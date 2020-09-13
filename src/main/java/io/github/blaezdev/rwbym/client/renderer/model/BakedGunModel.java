package io.github.blaezdev.rwbym.client.renderer.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Nonnull;
import javax.vecmath.Matrix4f;

import org.apache.commons.lang3.tuple.Pair;

import com.google.common.collect.ImmutableMap;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.PerspectiveMapWrapper;
import net.minecraftforge.common.model.TRSRTransformation;

public class BakedGunModel implements IBakedModel {
    private final IModel parent;
    private final List<IBakedModel> models;
    private List<BakedQuad> quads = new ArrayList<>();
    private Map<ItemCameraTransforms.TransformType, TRSRTransformation> transforms;
    private List<TRSRTransformation> subTransforms = new ArrayList<>();
    private final TextureAtlasSprite particle;
    private final ItemOverrideList overrides;
    private final List<IBakedModel> accessoryModels = new ArrayList<IBakedModel>();
    private final Map<String, IBakedModel> cache = new HashMap<>();

    public BakedGunModel(IModel parent,
                         List<IBakedModel> models,
                         Map<ItemCameraTransforms.TransformType, TRSRTransformation> transforms,
                         TextureAtlasSprite particle,
                         VertexFormat format,
                         ItemOverrideList overrides,
                         Map<String, IBakedModel> cache) {
        this.parent = parent;
        this.models = models;
        this.transforms = transforms;
        this.particle = particle;
        this.overrides = overrides;
    }

    public void setSubTransforms(List<TRSRTransformation> subTransformations) {
        this.subTransforms = new ArrayList<TRSRTransformation>();
        this.subTransforms.add(TRSRTransformation.identity());
        this.subTransforms.addAll(subTransformations);
    }

//    public void addAccessories(List<ItemStack> list) {
//        for (ItemStack stack : list) {
//            IBakedModel model;
//            TRSRTransformation subtransform;
//
//            int[] ints = stack.getTagCompound()().getIntArray("transform");
//            float[] floats = new float[16];
//            for (int i = 0; i < 16; i++) {
//                floats[i] = Float.intBitsToFloat(ints[i]);
//            }
//            subtransform = new TRSRTransformation(new Matrix4f(floats));
//
//            if (cache.containsKey(stack.toString())) {
//                model = cache.get(stack.toString());
//            }
//            else {
//                model = Minecraft.getMinecraft().getItemRenderer().getItemModelWithOverrides(stack, null, null);
//                cache.put(stack.toString(), model);
//            }
//            subTransforms.add(subtransform);
////            if (stack.getItem() instanceof ItemScope) {
////                for (Map.Entry<ItemCameraTransforms.TransformType, TRSRTransformation> entry : transforms.entrySet()) {
////                    if (entry.getKey() == ItemCameraTransforms.TransformType.FIRST_PERSON_LEFT_HAND || entry.getKey() == ItemCameraTransforms.TransformType.FIRST_PERSON_RIGHT_HAND) {
////                        Minecraft.getInstance().world.getCapability(ItemDataProvider.ITEMDATA_CAP, null).ifPresent(itemData -> {
////                            CompoundNBT datatag = itemData.getItemData();
////                            CompoundNBT itemtag = datatag.getCompound(stack.getOrCreateTag().getString("UUID"));
////                            if (itemtag.getBoolean("ads")) {
////                                //entry.setValue(entry.getValue().compose(TRSRTransformation.blockCenterToCorner(new TRSRTransformation(model.handlePerspective(TransformType.FIRST_PERSON_LEFT_HAND).getRight()))));
////                                entry.setValue(TRSRTransformation.blockCenterToCorner(new TRSRTransformation(model.handlePerspective(ItemCameraTransforms.TransformType.FIRST_PERSON_LEFT_HAND).getRight())).compose(subtransform.inverse()));
////                            }
////                        });
////                    }
////                }
////            }
//            if (!models.contains(model)) {
//                this.models.add(model);
//            }
//        }
//    }

    @Nonnull
    @Override
    public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, @Nonnull long rand) {

        quads.clear();
        if (this.subTransforms == null) {
            return quads;
        }
        //System.out.println(this.subTransforms.size() + ", " + models.size());
        //if (this.subTransforms.size() <= models.size()) {
        int count = Math.min(subTransforms.size(), models.size());
        int i;
        for (i = 0; i < count; i++) {

            for (BakedQuad quad : models.get(i).getQuads(state, side, rand)) {

                //System.out.println(quad.getFormat());

                Matrix4f transformation = this.subTransforms.get(i).getMatrix();

                if (transformation.equals(TRSRTransformation.identity().getMatrix())) {
                    quads.add(quad);
                    continue;
                }

                int[] data = quad.getVertexData().clone();

                //System.out.println(data);

                Matrix4f points = new Matrix4f();

                points.m00 = Float.intBitsToFloat(data[0]);
                points.m10 = Float.intBitsToFloat(data[1]);
                points.m20 = Float.intBitsToFloat(data[2]);
                points.m30 = 1;

                points.m01 = Float.intBitsToFloat(data[7]);
                points.m11 = Float.intBitsToFloat(data[8]);
                points.m21 = Float.intBitsToFloat(data[9]);
                points.m31 = 1;

                points.m02 = Float.intBitsToFloat(data[14]);
                points.m12 = Float.intBitsToFloat(data[15]);
                points.m22 = Float.intBitsToFloat(data[16]);
                points.m32 = 1;

                points.m03 = Float.intBitsToFloat(data[21]);
                points.m13 = Float.intBitsToFloat(data[22]);
                points.m23 = Float.intBitsToFloat(data[23]);
                points.m33 = 1;

                points.mul(transformation, points);

                data[0] = Float.floatToRawIntBits(points.m00);
                data[1] = Float.floatToRawIntBits(points.m10);
                data[2] = Float.floatToRawIntBits(points.m20);

                data[7] = Float.floatToRawIntBits(points.m01);
                data[8] = Float.floatToRawIntBits(points.m11);
                data[9] = Float.floatToRawIntBits(points.m21);

                data[14] = Float.floatToRawIntBits(points.m02);
                data[15] = Float.floatToRawIntBits(points.m12);
                data[16] = Float.floatToRawIntBits(points.m22);

                data[21] = Float.floatToRawIntBits(points.m03);
                data[22] = Float.floatToRawIntBits(points.m13);
                data[23] = Float.floatToRawIntBits(points.m23);

                ForgeHooksClient.fillNormal(data, null);

                BakedQuad newQuad = new BakedQuad(data, quad.getTintIndex(), quad.getFace(), quad.getSprite(), quad.shouldApplyDiffuseLighting(), quad.getFormat());

                quads.add(newQuad);
            }
        }
        //}
        //System.out.println(quads.size());

        if (quads.size() > 0) {
            //System.out.println("took " + (double)(System.nanoTime() - start)/50000000D + " frames to get " + quads.size() + " quads for model " + this.parent.baseLocation);
        }

        return quads;
    }

    private int calculateNormal(Matrix4f points) {

        float xp = points.m03 - points.m01;
        float yp = points.m13 - points.m11;
        float zp = points.m23 - points.m21;

        float xq = points.m02 - points.m00;
        float yq = points.m12 - points.m10;
        float zq = points.m22 - points.m20;

        //Cross Product
        float xn = yq * zp - zq * yp;
        float yn = zq * xp - xq * zp;
        float zn = xq * yp - yq * xp;

        //Normalize
        float norm = (float) Math.sqrt(xn * xn + yn * yn + zn * zn);
        final float SMALL_LENGTH = 1.0E-4F;  //Vec3d.normalise() uses this
        if (norm < SMALL_LENGTH) norm = 1.0F;  // protect against degenerate quad

        norm = 1.0F / norm;
        xn *= norm;
        yn *= norm;
        zn *= norm;

        int x = ((byte) (xn * 127)) & 0xFF;
        int y = ((byte) (yn * 127)) & 0xFF;
        int z = ((byte) (zn * 127)) & 0xFF;
        return x | (y << 0x08) | (z << 0x10);
    }

    public IModel getParent() {
        return parent;
    }

    @Override
    public boolean isAmbientOcclusion() {
        return false;
    }

    @Override
    public boolean isGui3d() {
        return true;
    }

    @Override
    public boolean isBuiltInRenderer() {
        return false;
    }

    @Nonnull
    @Override
    public TextureAtlasSprite getParticleTexture() {
        return this.particle;
    }

    @Nonnull
    @Override
    public ItemOverrideList getOverrides() {
        return this.overrides;
    }

    @Override
    public ItemCameraTransforms getItemCameraTransforms() {
        return models.get(0).getItemCameraTransforms();
    }

    public Pair<? extends IBakedModel, Matrix4f> handlePerspective(ItemCameraTransforms.TransformType type) {
        return PerspectiveMapWrapper.handlePerspective(this, ImmutableMap.copyOf(transforms), type);
    }

    public void setCameraTransforms(ImmutableMap<ItemCameraTransforms.TransformType, TRSRTransformation> transforms) {
        this.transforms = new HashMap<>(transforms);
    }

}
