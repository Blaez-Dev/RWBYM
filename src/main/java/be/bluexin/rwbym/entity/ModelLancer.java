package be.bluexin.rwbym.entity;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.monster.EntityVex;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class ModelLancer extends ModelBiped {
	private final ModelRenderer body;
	private final ModelRenderer leftwing;
	private final ModelRenderer rightwing;
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer bone3;
	private final ModelRenderer bone4;
	private final ModelRenderer bone5;
	private final ModelRenderer bone6;
	private final ModelRenderer bone7;
	private final ModelRenderer bone8;
	private final ModelRenderer bone9;
	private final ModelRenderer bone10;
	private final ModelRenderer bone11;
	private final ModelRenderer bone12;
	private final ModelRenderer body2;
	private final ModelRenderer bone13;
	private final ModelRenderer bone14;
	private final ModelRenderer bone15;
	private final ModelRenderer bone16;
	private final ModelRenderer bone17;
	private final ModelRenderer legset;
	private final ModelRenderer bone18;
	private final ModelRenderer bone19;
	private final ModelRenderer bone20;
	private final ModelRenderer bone21;
	private final ModelRenderer bone22;

	public ModelLancer() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(body, 0.4363F, 0.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 16, 16, -2.3833F, 0.0F, -1.0F, 4, 4, 3, 0.0F, true));

		leftwing = new ModelRenderer(this);
		leftwing.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(leftwing, 0.0F, 3.1416F, 0.0F);
		leftwing.cubeList.add(new ModelBox(leftwing, 0, 0, -19.45F, -0.55F, 0.05F, 20, 6, 1, 0.0F, false));

		rightwing = new ModelRenderer(this);
		rightwing.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(rightwing, 0.0F, 3.1416F, 0.0F);
		rightwing.cubeList.add(new ModelBox(rightwing, 0, 0, 0.5667F, -0.55F, 0.125F, 20, 6, 1, 0.0F, true));

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(bone, 0.1745F, 0.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 16, 23, -1.3833F, 2.425F, -0.35F, 2, 3, 3, 0.0F, true));

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone2.cubeList.add(new ModelBox(bone2, 17, 29, -0.8833F, 4.4F, 0.85F, 1, 3, 2, 0.0F, true));

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(bone3, 0.7854F, 0.0F, 0.0F);
		bone3.cubeList.add(new ModelBox(bone3, 17, 29, -0.8833F, 5.575F, -4.425F, 1, 3, 2, 0.0F, true));

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(bone4, 0.7854F, 0.0F, 0.0F);
		bone4.cubeList.add(new ModelBox(bone4, 17, 34, -2.3583F, 7.775F, -5.425F, 4, 2, 4, 0.0F, true));

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(bone5, 1.5708F, 0.0F, 0.0F);
		bone5.cubeList.add(new ModelBox(bone5, 17, 41, -2.3083F, 4.475F, -11.525F, 4, 2, 2, 0.0F, true));

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(bone6, 1.6581F, 0.0F, 0.0F);
		bone6.cubeList.add(new ModelBox(bone6, 17, 50, -2.8833F, 3.7F, -10.875F, 5, 2, 4, 0.0F, true));
		bone6.cubeList.add(new ModelBox(bone6, 17, 41, -1.4583F, 4.55F, -10.875F, 2, 1, 5, 0.0F, true));

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(bone7, 1.3963F, 0.0F, 0.0F);
		bone7.cubeList.add(new ModelBox(bone7, 0, 59, -1.8833F, 6.175F, -11.0F, 3, 2, 2, 0.0F, true));

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(bone8, 0.4363F, 0.0F, 0.0F);
		bone8.cubeList.add(new ModelBox(bone8, 17, 34, -1.9833F, 9.475F, -2.075F, 3, 2, 3, 0.0F, true));

		bone9 = new ModelRenderer(this);
		bone9.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(bone9, 0.1745F, 0.0F, 0.0F);
		bone9.cubeList.add(new ModelBox(bone9, 17, 34, -1.4333F, 10.45F, 0.775F, 2, 2, 3, 0.0F, true));

		bone10 = new ModelRenderer(this);
		bone10.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone10.cubeList.add(new ModelBox(bone10, 21, 36, -1.0083F, 11.325F, 3.05F, 1, 1, 2, 0.0F, true));

		bone11 = new ModelRenderer(this);
		bone11.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(bone11, 0.8727F, 0.0F, 0.0F);
		bone11.cubeList.add(new ModelBox(bone11, 0, 52, -1.4583F, 12.0F, -9.85F, 2, 1, 1, 0.0F, true));
		bone11.cubeList.add(new ModelBox(bone11, 0, 52, -1.0083F, 12.0F, -11.6F, 1, 1, 2, 0.0F, true));

		bone12 = new ModelRenderer(this);
		bone12.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(bone12, 1.309F, 0.0F, 0.0F);
		bone12.cubeList.add(new ModelBox(bone12, 0, 55, -1.4333F, 7.05F, -10.85F, 2, 2, 1, 0.0F, true));
		bone12.cubeList.add(new ModelBox(bone12, 17, 36, -1.0083F, 7.075F, -14.175F, 1, 1, 4, 0.0F, true));

		body2 = new ModelRenderer(this);
		body2.setRotationPoint(0.0F, 0.0F, 0.0F);
		body2.cubeList.add(new ModelBox(body2, 19, 35, -1.7833F, -2.075F, -3.35F, 3, 3, 2, 0.0F, true));
		body2.cubeList.add(new ModelBox(body2, 54, 58, -1.2333F, -2.2F, -4.35F, 2, 3, 1, 0.0F, true));
		body2.cubeList.add(new ModelBox(body2, 54, 58, -1.2333F, -1.675F, -5.275F, 2, 3, 1, 0.0F, true));
		body2.cubeList.add(new ModelBox(body2, 54, 58, -1.2333F, -0.95F, -5.775F, 2, 2, 1, 0.0F, true));
		body2.cubeList.add(new ModelBox(body2, 59, 24, -0.7583F, -0.675F, -6.075F, 1, 3, 1, 0.0F, true));
		body2.cubeList.add(new ModelBox(body2, 59, 24, -1.9333F, 1.55F, -6.075F, 1, 2, 1, 0.0F, true));
		body2.cubeList.add(new ModelBox(body2, 59, 24, 0.4917F, 1.425F, -6.075F, 1, 2, 1, 0.0F, true));

		bone13 = new ModelRenderer(this);
		bone13.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(bone13, 1.0472F, 0.0F, 0.0F);
		bone13.cubeList.add(new ModelBox(bone13, 17, 29, -0.8833F, -2.675F, -1.575F, 1, 3, 2, 0.0F, true));

		bone14 = new ModelRenderer(this);
		bone14.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(bone14, -0.4363F, 0.0F, 0.0F);
		bone14.cubeList.add(new ModelBox(bone14, 59, 0, -1.4083F, -21.25F, -15.05F, 2, 2, 1, 0.0F, true));
		bone14.cubeList.add(new ModelBox(bone14, 59, 0, -1.0083F, -21.25F, -15.05F, 2, 2, 1, 0.0F, true));

		bone15 = new ModelRenderer(this);
		bone15.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(bone15, -0.6981F, 0.0F, 0.0F);
		bone15.cubeList.add(new ModelBox(bone15, 59, 0, -1.4083F, -16.675F, -19.475F, 2, 2, 1, 0.0F, true));
		bone15.cubeList.add(new ModelBox(bone15, 59, 0, -1.0083F, -16.675F, -19.475F, 2, 2, 1, 0.0F, true));

		bone16 = new ModelRenderer(this);
		bone16.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(bone16, -1.5708F, 0.0F, 0.0F);
		bone16.cubeList.add(new ModelBox(bone16, 59, 0, -1.4083F, 2.7F, -25.6F, 2, 2, 1, 0.0F, true));
		bone16.cubeList.add(new ModelBox(bone16, 59, 0, -1.0083F, 2.7F, -25.6F, 2, 2, 1, 0.0F, true));

		bone17 = new ModelRenderer(this);
		bone17.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(bone17, -0.9599F, 0.0F, 0.0F);
		bone17.cubeList.add(new ModelBox(bone17, 22, 37, -1.3583F, -9.95F, -21.85F, 1, 2, 1, 0.0F, true));
		bone17.cubeList.add(new ModelBox(bone17, 22, 37, -0.1833F, -9.95F, -21.85F, 1, 2, 1, 0.0F, true));

		legset = new ModelRenderer(this);
		legset.setRotationPoint(0.0F, 2.0F, 0.0F);
		setRotationAngle(legset, 0.0873F, 0.0F, 0.0F);
		legset.cubeList.add(new ModelBox(legset, 22, 37, -3.25F, -2.375F, 0.2F, 1, 2, 1, 0.0F, true));
		legset.cubeList.add(new ModelBox(legset, 22, 37, 1.45F, -2.375F, 0.2F, 1, 2, 1, 0.0F, true));
		legset.cubeList.add(new ModelBox(legset, 22, 37, 1.45F, 1.5631F, 1.6121F, 1, 2, 1, 0.0F, true));
		legset.cubeList.add(new ModelBox(legset, 22, 37, -3.25F, 1.5631F, 1.6121F, 1, 2, 1, 0.0F, true));

		bone18 = new ModelRenderer(this);
		bone18.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(bone18, -2.2689F, 0.0F, 0.0F);
		legset.addChild(bone18);
		bone18.cubeList.add(new ModelBox(bone18, 21, 34, -4.3F, 0.2F, -1.5F, 1, 3, 1, 0.0F, true));
		bone18.cubeList.add(new ModelBox(bone18, 21, 34, 2.475F, 0.2F, -1.5F, 1, 3, 1, 0.0F, true));
		bone18.cubeList.add(new ModelBox(bone18, 21, 34, -4.3F, -3.4131F, 0.609F, 1, 3, 1, 0.0F, true));
		bone18.cubeList.add(new ModelBox(bone18, 21, 34, 2.475F, -3.4131F, 0.609F, 1, 3, 1, 0.0F, true));
		bone18.cubeList.add(new ModelBox(bone18, 21, 34, -1.85F, -4.3146F, 3.3349F, 1, 3, 1, 0.0F, true));
		bone18.cubeList.add(new ModelBox(bone18, 21, 34, 0.125F, -4.3556F, 3.3062F, 1, 3, 1, 0.0F, true));
		bone18.cubeList.add(new ModelBox(bone18, 21, 34, 0.225F, 4.4826F, -1.95F, 1, 3, 1, 0.0F, true));
		bone18.cubeList.add(new ModelBox(bone18, 21, 34, -1.75F, 4.5973F, -2.1138F, 1, 3, 1, 0.0F, true));

		bone19 = new ModelRenderer(this);
		bone19.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(bone19, -0.6981F, 0.0F, 0.0F);
		legset.addChild(bone19);
		bone19.cubeList.add(new ModelBox(bone19, 21, 34, -4.3F, -1.3F, -3.3F, 1, 3, 1, 0.0F, true));
		bone19.cubeList.add(new ModelBox(bone19, 21, 34, 2.475F, -1.3F, -3.3F, 1, 3, 1, 0.0F, true));
		bone19.cubeList.add(new ModelBox(bone19, 21, 34, -4.3F, 0.809F, 0.3131F, 1, 3, 1, 0.0F, true));
		bone19.cubeList.add(new ModelBox(bone19, 21, 34, 2.475F, 0.809F, 0.3131F, 1, 3, 1, 0.0F, true));
		bone19.cubeList.add(new ModelBox(bone19, 21, 34, -1.85F, 3.5349F, 1.2146F, 1, 3, 1, 0.0F, true));
		bone19.cubeList.add(new ModelBox(bone19, 21, 34, 0.125F, 3.5062F, 1.2556F, 1, 3, 1, 0.0F, true));
		bone19.cubeList.add(new ModelBox(bone19, 21, 34, -1.75F, -1.9138F, -7.6973F, 1, 3, 1, 0.0F, true));
		bone19.cubeList.add(new ModelBox(bone19, 21, 34, 0.225F, -1.75F, -7.5826F, 1, 3, 1, 0.0F, true));

		bone20 = new ModelRenderer(this);
		bone20.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(bone20, -0.6981F, 0.0F, 0.0F);
		legset.addChild(bone20);
		bone20.cubeList.add(new ModelBox(bone20, 21, 34, -4.3F, 1.55F, -3.3F, 1, 3, 1, 0.0F, true));
		bone20.cubeList.add(new ModelBox(bone20, 21, 34, 2.475F, 1.55F, -3.3F, 1, 3, 1, 0.0F, true));

		bone21 = new ModelRenderer(this);
		bone21.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(bone21, 0.2618F, 0.0F, 0.0F);
		legset.addChild(bone21);
		bone21.cubeList.add(new ModelBox(bone21, 59, 30, -4.3F, -0.075F, -5.4F, 1, 3, 1, 0.0F, true));
		bone21.cubeList.add(new ModelBox(bone21, 59, 30, 2.475F, -0.075F, -5.4F, 1, 3, 1, 0.0F, true));
		bone21.cubeList.add(new ModelBox(bone21, 59, 30, 2.475F, 2.2F, -2.775F, 1, 3, 1, 0.0F, true));
		bone21.cubeList.add(new ModelBox(bone21, 59, 30, -4.3F, 2.2F, -2.775F, 1, 3, 1, 0.0F, true));
		bone21.cubeList.add(new ModelBox(bone21, 21, 34, 0.125F, 4.5191F, -4.4438F, 1, 3, 1, 0.0F, true));
		bone21.cubeList.add(new ModelBox(bone21, 21, 34, -1.85F, 4.502F, -4.4908F, 1, 3, 1, 0.0F, true));

		bone22 = new ModelRenderer(this);
		bone22.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(bone22, 0.2618F, 0.0F, 0.0F);
		legset.addChild(bone22);
		bone22.cubeList.add(new ModelBox(bone22, 59, 30, -4.3F, 2.725F, -5.4F, 1, 3, 1, 0.0F, true));
		bone22.cubeList.add(new ModelBox(bone22, 59, 30, 2.475F, 2.725F, -5.4F, 1, 3, 1, 0.0F, true));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		body.render(f5);
		leftwing.render(f5);
		rightwing.render(f5);
		bone.render(f5);
		bone2.render(f5);
		bone3.render(f5);
		bone4.render(f5);
		bone5.render(f5);
		bone6.render(f5);
		bone7.render(f5);
		bone8.render(f5);
		bone9.render(f5);
		bone10.render(f5);
		bone11.render(f5);
		bone12.render(f5);
		body2.render(f5);
		bone13.render(f5);
		bone14.render(f5);
		bone15.render(f5);
		bone16.render(f5);
		bone17.render(f5);
		legset.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
		this.rightwing.rotationPointZ = 0.0F;
		this.leftwing.rotationPointZ = 0.0F;
		this.rightwing.rotationPointY = 0.0F;
		this.leftwing.rotationPointY = 0.0F;
		this.rightwing.rotateAngleY = -0.47123894F + MathHelper.cos(ageInTicks*2) * 3.1415927F * 0.05F;
		this.leftwing.rotateAngleY = -this.rightwing.rotateAngleY;
		this.leftwing.rotateAngleZ = 0.0F;
		this.leftwing.rotateAngleX = 0.32F;
		this.rightwing.rotateAngleX = 0.32F;
		this.rightwing.rotateAngleZ = 0.0F;
	}
}