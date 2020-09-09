package io.github.blaezdev.rwbym.client.particle.renderer.model.bbgunmodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.UUID;
import java.util.function.Function;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.vecmath.Vector3f;

import io.github.blaezdev.rwbym.client.particle.renderer.model.BakedQuadBuilder;
import io.github.blaezdev.rwbym.client.particle.renderer.model.TransformationBuilder;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.EnumFaceDirection;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.FaceBakery;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

public class SimpleBakedBBModel implements IBakedModel {

    protected final List<BakedQuad> generalQuads;
    protected final Map<EnumFacing, List<BakedQuad>> faceQuads;
    protected final boolean ambientOcclusion;
    protected final boolean gui3d;
    protected final TextureAtlasSprite texture;
    protected final ItemCameraTransforms cameraTransforms;
    protected final ItemOverrideList itemOverrideList;

    public SimpleBakedBBModel(List<BakedQuad> generalQuadsIn, Map<EnumFacing, List<BakedQuad>> faceQuadsIn, boolean ambientOcclusionIn, boolean gui3dIn, TextureAtlasSprite textureIn, ItemCameraTransforms cameraTransformsIn, ItemOverrideList itemOverrideListIn) {
        this.generalQuads = generalQuadsIn;
        this.faceQuads = faceQuadsIn;
        this.ambientOcclusion = ambientOcclusionIn;
        this.gui3d = gui3dIn;
        this.texture = textureIn;
        this.cameraTransforms = cameraTransformsIn;
        this.itemOverrideList = itemOverrideListIn;
    }
    
    @Nonnull
    @Override
    public List<BakedQuad> getQuads(@Nullable IBlockState state, @Nullable EnumFacing side, @Nonnull long rand) {
        return side == null ? this.generalQuads : new ArrayList<>();
    }

    @Override
    public boolean isAmbientOcclusion() {
        return this.ambientOcclusion;
    }

    @Override
    public boolean isGui3d() {
        return this.gui3d;
    }

    @Override
    public boolean isBuiltInRenderer() {
        return false;
    }

    @Override
    public TextureAtlasSprite getParticleTexture() {
        return this.texture;
    }

    @Override
    public ItemCameraTransforms getItemCameraTransforms() {
        return this.cameraTransforms;
    }

    @Override
    public ItemOverrideList getOverrides() {
        return this.itemOverrideList;
    }
	
	public static class Builder {
		
		private final ModelBlock model;
		private final ItemOverrideList overrides;
		private final Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter;

		private static final FaceBakery bakery = new FaceBakery();
		
		public Builder(ModelBlock model, ItemOverrideList overrides, final Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter) {
			this.model = model;
			this.overrides = overrides;
			this.bakedTextureGetter = bakedTextureGetter;
		}
		
		public IBakedModel build() {
			
			List<BakedQuad> quads = new ArrayList<>();

			List<ModelGroup> groupStack = new ArrayList<>();

			Map<UUID, ModelElement> map = new HashMap<>(model.getElements());

			for (ModelGroup group : model.getGroups()) {
                groupStack.add(0, group);
                buildFromGroup(groupStack, map, quads);
                groupStack.remove(0);
            }

			for (Entry<UUID, ModelElement> entry : map.entrySet()) {
			    buildFromElement(groupStack, entry.getValue(), quads);
            }
			
			return new SimpleBakedBBModel(quads, null, model.ambientOcclusion, model.isGui3d(), bakedTextureGetter.apply(new ResourceLocation(model.textures.get("0"))), model.getAllTransforms(), overrides);
		}

        private void buildFromGroup(List<ModelGroup> groupStack, Map<UUID, ModelElement> elementMap, List<BakedQuad> quads) {
            ModelGroup group = groupStack.get(0);
            for (ModelGroup newGroup : group.subGroups) {
                groupStack.add(0, newGroup);
                buildFromGroup(groupStack, elementMap, quads);
                groupStack.remove(0);
            }
            for (UUID elementUUID : group.elements) {
                ModelElement element = elementMap.remove(elementUUID);
                buildFromElement(groupStack, element, quads);
            }
        }

        private void buildFromElement(List<ModelGroup> groupStack, ModelElement element, List<BakedQuad> quads) {

            Vector3f[] points = new Vector3f[8];

            float vertexinfo[] = new float[EnumFacing.values().length];

            vertexinfo[EnumFaceDirection.Constants.WEST_INDEX] = element.start.x;
            vertexinfo[EnumFaceDirection.Constants.DOWN_INDEX] = element.start.y;
            vertexinfo[EnumFaceDirection.Constants.NORTH_INDEX] = element.start.z;
            vertexinfo[EnumFaceDirection.Constants.EAST_INDEX] = element.end.x;
            vertexinfo[EnumFaceDirection.Constants.UP_INDEX] = element.end.y;
            vertexinfo[EnumFaceDirection.Constants.SOUTH_INDEX] = element.end.z;

            points[0] = new Vector3f(element.start.x, element.end.y, element.end.z);
            points[1] = new Vector3f(element.end.x, element.end.y, element.end.z);
            points[2] = new Vector3f(element.end.x, element.end.y, element.start.z);
            points[3] = new Vector3f(element.start.x, element.end.y, element.start.z);

            points[4] = new Vector3f(element.start.x, element.start.y, element.start.z);
            points[5] = new Vector3f(element.end.x, element.start.y, element.start.z);
            points[6] = new Vector3f(element.end.x, element.start.y, element.end.z);
            points[7] = new Vector3f(element.start.x, element.start.y, element.end.z);

            for (EnumFacing facing : EnumFacing.values()) {

                ElementFace face = element.faces.get(facing);

                if (face != null) {

                    TransformationBuilder transformationBuilder = new TransformationBuilder();

                    int[] ints = getPointIndexes(facing);

                    Vector3f[] aVector3f = new Vector3f[4];
                    for (int i = 0; i < 4; i++) {
                        aVector3f[i] = new Vector3f(vertexinfo[EnumFaceDirection.getFacing(facing).getVertexInformation(i).xIndex], vertexinfo[EnumFaceDirection.getFacing(facing).getVertexInformation(i).yIndex], vertexinfo[EnumFaceDirection.getFacing(facing).getVertexInformation(i).zIndex]);
                    }

                    BakedQuadBuilder builder = new BakedQuadBuilder().setPosition(aVector3f[0], 0).setPosition(aVector3f[1], 1).setPosition(aVector3f[2], 2).setPosition(aVector3f[3], 3).applyRotation(element.rotation, element.origin).setColor(0xffffffff).setTexture(bakedTextureGetter.apply(new ResourceLocation(model.resolveTextureName(face.texture)))).setUV(face.uv).setFace(facing);

                    int i = 0;

                    transformationBuilder.add(null, element.rotation, element.origin, null, i++);

                    for (ModelGroup group : groupStack) {
                        builder.applyRotation(group.rotation, group.origin);
                        transformationBuilder.add(null, group.rotation, group.origin, null, i++);
                    }

                    transformationBuilder.add(null, model.rotation, model.origin, null, i);

                    quads.add(builder.applyRotation(model.rotation, model.origin).build());
                    float[] uvs = new float[4];
                    face.uv.get(uvs);

                    //quads.add(bakery.makeBakedQuad(new net.minecraft.client.renderer.Vector3f(element.start.x * 16, element.start.y * 16, element.start.z * 16), new net.minecraft.client.renderer.Vector3f(element.end.x * 16, element.end.y * 16, element.end.z * 16), new BlockPartFace(null, -1, "0", new BlockFaceUV(uvs, 0)), bakedTextureGetter.apply(new ResourceLocation(model.resolveTextureName(face.texture))), facing, new BasicState(TRSRTransformation.identity(), false), new BlockPartRotation(new net.minecraft.client.renderer.Vector3f(0, 0, 0), Direction.Axis.X, 0.0f, false), true));
                }
            }
        }

        private int[] getPointIndexes(EnumFacing facing) {

		    switch (facing) {

                case DOWN:
                    return new int[]{4, 5, 6, 7};
                case UP:
                    return new int[]{0, 1, 2, 3};
                case NORTH:
                    return new int[]{5, 4, 3, 2};
                case SOUTH:
                    return new int[]{7, 6, 1, 0};
                case WEST:
                    return new int[]{4, 7, 0, 3};
                case EAST:
                    return new int[]{6, 5, 2, 1};
                default:
                    return new int[0];
            }

        }
		
	}

}
