package be.bluexin.rwbym.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class ModelNuckleeve extends ModelBase {
	private final ModelRenderer Body;
	private final ModelRenderer TailA;
	private final ModelRenderer Leg1A;
	private final ModelRenderer Leg1B;
	private final ModelRenderer Leg1C;
	private final ModelRenderer Leg2A;
	private final ModelRenderer Leg2B;
	private final ModelRenderer Leg2C;
	private final ModelRenderer Leg3A;
	private final ModelRenderer Leg3B;
	private final ModelRenderer Leg3C;
	private final ModelRenderer Leg4A;
	private final ModelRenderer Leg4B;
	private final ModelRenderer Leg4C;
	private final ModelRenderer head;
	private final ModelRenderer bone;
	private final ModelRenderer UMouth;
	private final ModelRenderer LMouth;
	private final ModelRenderer Ear1;
	private final ModelRenderer Ear2;
	private final ModelRenderer Neck;
	private final ModelRenderer Mane;
	private final ModelRenderer bodyknuck;
	private final ModelRenderer rightarm;
	private final ModelRenderer leftarm;
	private final ModelRenderer humanhead;

	public ModelNuckleeve() {
		textureWidth = 128;
		textureHeight = 128;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 11.0F, 9.0F);
		Body.cubeList.add(new ModelBox(Body, 0, 34, -5.0F, -8.0F, -19.0F, 10, 10, 24, 0.0F, true));
		Body.cubeList.add(new ModelBox(Body, 0, 100, -4.575F, -7.875F, -19.0F, 9, 5, 23, 0.0F, true));
		Body.cubeList.add(new ModelBox(Body, 0, 100, -4.575F, -5.875F, -18.0F, 9, 5, 22, 0.0F, true));
		Body.cubeList.add(new ModelBox(Body, 0, 100, -2.575F, -3.875F, -18.0F, 5, 5, 22, 0.0F, true));
		Body.cubeList.add(new ModelBox(Body, 114, 121, -2.575F, -8.2F, 2.125F, 5, 5, 1, 0.0F, true));
		Body.cubeList.add(new ModelBox(Body, 114, 121, -1.575F, -8.2F, 1.125F, 3, 5, 2, 0.0F, true));
		Body.cubeList.add(new ModelBox(Body, 114, 121, -1.575F, -8.2F, -1.675F, 3, 5, 2, 0.0F, true));
		Body.cubeList.add(new ModelBox(Body, 114, 121, -2.575F, -8.2F, -0.675F, 5, 5, 1, 0.0F, true));

		TailA = new ModelRenderer(this);
		TailA.setRotationPoint(0.0F, 3.0F, 14.0F);
		setRotationAngle(TailA, -1.1345F, 0.0F, 0.0F);
		TailA.cubeList.add(new ModelBox(TailA, 116, 90, -1.0F, -1.0F, 0.0F, 2, 2, 3, 0.0F, true));

		Leg1A = new ModelRenderer(this);
		Leg1A.setRotationPoint(-4.0F, 9.0F, 11.0F);
		Leg1A.cubeList.add(new ModelBox(Leg1A, 15, 102, -1.5F, -2.0F, -2.5F, 4, 9, 5, 0.0F, true));

		Leg1B = new ModelRenderer(this);
		Leg1B.setRotationPoint(-4.0F, 16.0F, 11.0F);
		Leg1B.cubeList.add(new ModelBox(Leg1B, 27, 119, -1.0F, 0.0F, -1.5F, 3, 5, 3, 0.0F, true));

		Leg1C = new ModelRenderer(this);
		Leg1C.setRotationPoint(-4.0F, 16.0F, 11.0F);
		Leg1C.cubeList.add(new ModelBox(Leg1C, 98, 95, -1.5F, 4.1F, -2.0F, 4, 4, 4, 0.0F, true));
		Leg1C.cubeList.add(new ModelBox(Leg1C, 98, 95, -1.5F, 5.1F, -3.0F, 4, 3, 5, 0.0F, true));

		Leg2A = new ModelRenderer(this);
		Leg2A.setRotationPoint(4.0F, 9.0F, 11.0F);
		Leg2A.cubeList.add(new ModelBox(Leg2A, 15, 102, -2.5F, -2.0F, -2.5F, 4, 9, 5, 0.0F, true));

		Leg2B = new ModelRenderer(this);
		Leg2B.setRotationPoint(4.0F, 16.0F, 11.0F);
		Leg2B.cubeList.add(new ModelBox(Leg2B, 27, 119, -2.0F, 0.0F, -1.5F, 3, 5, 3, 0.0F, true));

		Leg2C = new ModelRenderer(this);
		Leg2C.setRotationPoint(4.0F, 16.0F, 11.0F);
		Leg2C.cubeList.add(new ModelBox(Leg2C, 98, 95, -2.5F, 4.1F, -2.0F, 4, 4, 4, 0.0F, true));
		Leg2C.cubeList.add(new ModelBox(Leg2C, 98, 95, -2.5F, 5.1F, -3.0F, 4, 3, 5, 0.0F, true));

		Leg3A = new ModelRenderer(this);
		Leg3A.setRotationPoint(-4.0F, 9.0F, -8.0F);
		Leg3A.cubeList.add(new ModelBox(Leg3A, 32, 99, -1.1F, -1.0F, -2.1F, 3, 8, 4, 0.0F, true));

		Leg3B = new ModelRenderer(this);
		Leg3B.setRotationPoint(-4.0F, 16.0F, -8.0F);
		Leg3B.cubeList.add(new ModelBox(Leg3B, 17, 108, -1.1F, 0.0F, -1.6F, 3, 7, 3, 0.0F, true));

		Leg3C = new ModelRenderer(this);
		Leg3C.setRotationPoint(-4.0F, 16.0F, -8.0F);
		Leg3C.cubeList.add(new ModelBox(Leg3C, 5, 105, -1.6F, 7.1F, -2.1F, 4, 1, 4, 0.0F, true));
		Leg3C.cubeList.add(new ModelBox(Leg3C, 5, 105, -2.075F, 7.1F, -2.975F, 2, 1, 3, 0.0F, true));
		Leg3C.cubeList.add(new ModelBox(Leg3C, 5, 105, 0.95F, 7.1F, -2.975F, 2, 1, 3, 0.0F, true));
		Leg3C.cubeList.add(new ModelBox(Leg3C, 30, 19, -1.55F, 7.1F, -3.975F, 1, 1, 1, 0.0F, true));
		Leg3C.cubeList.add(new ModelBox(Leg3C, 30, 19, 1.45F, 7.1F, -3.975F, 1, 1, 1, 0.0F, true));

		Leg4A = new ModelRenderer(this);
		Leg4A.setRotationPoint(4.0F, 9.0F, -8.0F);
		Leg4A.cubeList.add(new ModelBox(Leg4A, 17, 108, -1.9F, -1.0F, -2.1F, 3, 8, 4, 0.0F, true));

		Leg4B = new ModelRenderer(this);
		Leg4B.setRotationPoint(4.0F, 16.0F, -8.0F);
		Leg4B.cubeList.add(new ModelBox(Leg4B, 17, 108, -1.9F, 0.0F, -1.6F, 3, 7, 3, 0.0F, true));

		Leg4C = new ModelRenderer(this);
		Leg4C.setRotationPoint(4.0F, 16.0F, -8.0F);
		Leg4C.cubeList.add(new ModelBox(Leg4C, 20, 118, -2.4F, 7.1F, -2.1F, 4, 1, 4, 0.0F, true));
		Leg4C.cubeList.add(new ModelBox(Leg4C, 20, 118, -0.1F, 7.1F, -2.95F, 2, 1, 4, 0.0F, true));
		Leg4C.cubeList.add(new ModelBox(Leg4C, 20, 118, -3.05F, 7.1F, -2.95F, 2, 1, 4, 0.0F, true));
		Leg4C.cubeList.add(new ModelBox(Leg4C, 30, 19, 0.375F, 7.1F, -3.95F, 1, 1, 1, 0.0F, true));
		Leg4C.cubeList.add(new ModelBox(Leg4C, 30, 19, -2.625F, 7.1F, -3.95F, 1, 1, 1, 0.0F, true));

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 4.0F, -10.0F);
		setRotationAngle(head, 0.5236F, 0.0F, 0.0F);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(bone);
		bone.cubeList.add(new ModelBox(bone, 0, 0, -2.5F, -10.0F, -1.5F, 5, 5, 7, 0.0F, true));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -1.0F, -1.0F, 0.0F, 1, 1, 1, 0.0F, false));
		

		this.UMouth = new ModelRenderer(this, 24, 18);
		this.UMouth.addBox(-2.0F, -10.0F, -7.0F, 4, 3, 6);
		this.UMouth.setRotationPoint(0.0F, 3.95F, -10.0F);
		this.UMouth.rotateAngleX = 0.5235988F;
		this.LMouth = new ModelRenderer(this, 24, 27);
		this.LMouth.addBox(-2.0F, -7.0F, -6.5F, 4, 2, 5);
		this.LMouth.setRotationPoint(0.0F, 4.0F, -10.0F);
		this.LMouth.rotateAngleX = 0.5235988F;

		Ear1 = new ModelRenderer(this);
		Ear1.setRotationPoint(0.0F, 4.0F, -10.0F);
		setRotationAngle(Ear1, 0.5236F, 0.0F, 0.0F);
		Ear1.cubeList.add(new ModelBox(Ear1, 0, 0, -2.45F, -12.0F, 4.0F, 2, 3, 1, 0.0F, true));

		Ear2 = new ModelRenderer(this);
		Ear2.setRotationPoint(0.0F, 4.0F, -10.0F);
		setRotationAngle(Ear2, 0.5236F, 0.0F, 0.0F);
		Ear2.cubeList.add(new ModelBox(Ear2, 0, 0, 0.45F, -12.0F, 4.0F, 2, 3, 1, 0.0F, true));

		Neck = new ModelRenderer(this);
		Neck.setRotationPoint(0.0F, 4.0F, -10.0F);
		setRotationAngle(Neck, 0.5236F, 0.0F, 0.0F);
		Neck.cubeList.add(new ModelBox(Neck, 0, 12, -1.95F, -9.8F, -2.0F, 4, 14, 8, 0.0F, true));

		Mane = new ModelRenderer(this);
		Mane.setRotationPoint(0.0F, 4.0F, -10.0F);
		setRotationAngle(Mane, 0.5236F, 0.0F, 0.0F);
		Mane.cubeList.add(new ModelBox(Mane, 58, 0, -1.0F, -11.5F, 5.0F, 2, 16, 4, 0.0F, true));

		bodyknuck = new ModelRenderer(this);
		bodyknuck.setRotationPoint(0.0F, 11.0F, 9.0F);
		setRotationAngle(bodyknuck, 0.1745F, 0.0F, 0.0F);
		bodyknuck.cubeList.add(new ModelBox(bodyknuck, 0, 100, -1.925F, -25.575F, -4.825F, 4, 23, 4, 0.0F, true));
		bodyknuck.cubeList.add(new ModelBox(bodyknuck, 0, 100, -2.925F, -20.575F, -4.825F, 6, 8, 5, 0.0F, true));
		bodyknuck.cubeList.add(new ModelBox(bodyknuck, 0, 115, -3.925F, -20.575F, -4.825F, 8, 4, 6, 0.0F, true));
		bodyknuck.cubeList.add(new ModelBox(bodyknuck, 86, 117, -3.475F, -14.85F, -5.275F, 2, 1, 2, 0.0F, true));
		bodyknuck.cubeList.add(new ModelBox(bodyknuck, 86, 117, 1.525F, -14.85F, -5.275F, 2, 1, 2, 0.0F, true));
		bodyknuck.cubeList.add(new ModelBox(bodyknuck, 86, 117, 0.525F, -16.5F, -5.275F, 3, 1, 2, 0.0F, true));
		bodyknuck.cubeList.add(new ModelBox(bodyknuck, 86, 117, -3.475F, -16.5F, -5.275F, 3, 1, 2, 0.0F, true));
		bodyknuck.cubeList.add(new ModelBox(bodyknuck, 86, 117, 1.525F, -10.775F, -5.275F, 1, 1, 1, 0.0F, true));
		bodyknuck.cubeList.add(new ModelBox(bodyknuck, 86, 117, -2.475F, -10.925F, -5.275F, 1, 1, 1, 0.0F, true));
		bodyknuck.cubeList.add(new ModelBox(bodyknuck, 86, 117, -2.475F, -12.925F, -5.275F, 1, 1, 1, 0.0F, true));
		bodyknuck.cubeList.add(new ModelBox(bodyknuck, 86, 117, 1.525F, -12.775F, -5.275F, 1, 1, 1, 0.0F, true));
		bodyknuck.cubeList.add(new ModelBox(bodyknuck, 86, 117, 0.525F, -20.025F, -5.275F, 4, 3, 2, 0.0F, true));
		bodyknuck.cubeList.add(new ModelBox(bodyknuck, 86, 117, -4.475F, -20.025F, -5.275F, 4, 3, 2, 0.0F, true));
		bodyknuck.cubeList.add(new ModelBox(bodyknuck, 86, 117, -0.85F, -10.85F, -1.975F, 1, 1, 2, 0.0F, true));
		bodyknuck.cubeList.add(new ModelBox(bodyknuck, 86, 117, -0.85F, -10.85F, -1.975F, 1, 1, 2, 0.0F, true));
		bodyknuck.cubeList.add(new ModelBox(bodyknuck, 86, 117, -0.85F, -15.65F, -0.975F, 1, 1, 4, 0.0F, true));
		bodyknuck.cubeList.add(new ModelBox(bodyknuck, 86, 117, -0.85F, -18.65F, 0.025F, 1, 1, 4, 0.0F, true));
		bodyknuck.cubeList.add(new ModelBox(bodyknuck, 88, 59, -2.875F, -19.85F, -5.375F, 2, 1, 2, 0.0F, true));
		bodyknuck.cubeList.add(new ModelBox(bodyknuck, 88, 59, 0.95F, -19.85F, -5.375F, 2, 1, 2, 0.0F, true));
		bodyknuck.cubeList.add(new ModelBox(bodyknuck, 88, 59, 0.95F, -18.425F, -5.375F, 3, 1, 2, 0.0F, true));
		bodyknuck.cubeList.add(new ModelBox(bodyknuck, 88, 59, -3.875F, -18.425F, -5.375F, 3, 1, 2, 0.0F, true));
		bodyknuck.cubeList.add(new ModelBox(bodyknuck, 86, 117, -4.475F, -20.225F, -5.425F, 4, 1, 2, 0.0F, true));
		bodyknuck.cubeList.add(new ModelBox(bodyknuck, 86, 117, 0.525F, -20.225F, -5.425F, 4, 1, 2, 0.0F, true));
		bodyknuck.cubeList.add(new ModelBox(bodyknuck, 86, 117, 0.525F, -18.05F, -5.425F, 4, 1, 2, 0.0F, true));
		bodyknuck.cubeList.add(new ModelBox(bodyknuck, 86, 117, -4.475F, -18.05F, -5.425F, 4, 1, 2, 0.0F, true));

		rightarm = new ModelRenderer(this);
		rightarm.setRotationPoint(-4.0F, -8.0F, 4.0F);
		rightarm.cubeList.add(new ModelBox(rightarm, 0, 105, -2.075F, -1.025F, -0.875F, 4, 3, 3, 0.0F, false));
		rightarm.cubeList.add(new ModelBox(rightarm, 0, 105, -3.075F, -1.025F, 0.125F, 2, 25, 1, 0.0F, false));
		rightarm.cubeList.add(new ModelBox(rightarm, 124, 115, -2.525F, 23.95F, 0.125F, 1, 1, 1, 0.0F, false));
		rightarm.cubeList.add(new ModelBox(rightarm, 124, 115, -3.85F, 23.95F, 0.125F, 1, 1, 1, 0.0F, false));
		rightarm.cubeList.add(new ModelBox(rightarm, 124, 115, -1.2F, 23.95F, 0.125F, 1, 1, 1, 0.0F, false));

		leftarm = new ModelRenderer(this);
		leftarm.setRotationPoint(5.0F, -8.0F, 4.0F);
		leftarm.cubeList.add(new ModelBox(leftarm, 124, 115, 2.65F, 23.95F, 0.125F, 1, 1, 1, 0.0F, false));
		leftarm.cubeList.add(new ModelBox(leftarm, 124, 115, 1.325F, 23.95F, 0.125F, 1, 1, 1, 0.0F, false));
		leftarm.cubeList.add(new ModelBox(leftarm, 124, 115, 0.0F, 23.95F, 0.125F, 1, 1, 1, 0.0F, false));
		leftarm.cubeList.add(new ModelBox(leftarm, 0, 105, 0.775F, -1.025F, 0.125F, 2, 25, 1, 0.0F, false));
		leftarm.cubeList.add(new ModelBox(leftarm, 0, 105, -3.175F, -1.025F, -0.875F, 4, 3, 3, 0.0F, false));

		humanhead = new ModelRenderer(this);
		humanhead.setRotationPoint(0.0F, -14.0F, 0.0F);
		setRotationAngle(humanhead, 0.1745F, 0.0F, 0.0F);
		humanhead.cubeList.add(new ModelBox(humanhead, 4, 115, -3.6F, -0.5F, -0.95F, 7, 2, 5, 0.0F, true));
		humanhead.cubeList.add(new ModelBox(humanhead, 94, 53, 1.4F, -0.875F, -1.175F, 1, 1, 1, 0.0F, true));
		humanhead.cubeList.add(new ModelBox(humanhead, 94, 53, -2.6F, -0.875F, -1.175F, 1, 1, 1, 0.0F, true));
		humanhead.cubeList.add(new ModelBox(humanhead, 4, 115, -2.225F, -0.65F, -1.35F, 1, 2, 5, 0.0F, true));
		humanhead.cubeList.add(new ModelBox(humanhead, 94, 53, -1.6F, -0.875F, -1.175F, 3, 2, 1, 0.0F, true));
		humanhead.cubeList.add(new ModelBox(humanhead, 4, 115, -0.625F, -0.65F, -1.35F, 1, 2, 5, 0.0F, true));
		humanhead.cubeList.add(new ModelBox(humanhead, 4, 115, 0.925F, -0.65F, -1.35F, 1, 2, 5, 0.0F, true));
		humanhead.cubeList.add(new ModelBox(humanhead, 98, 0, -3.6F, -6.55F, -1.475F, 7, 6, 7, 0.0F, true));
		humanhead.cubeList.add(new ModelBox(humanhead, 123, 124, 2.475F, -7.5F, -1.5F, 1, 2, 1, 0.0F, true));
		humanhead.cubeList.add(new ModelBox(humanhead, 123, 124, -3.625F, -7.5F, -1.5F, 1, 2, 1, 0.0F, true));
		humanhead.cubeList.add(new ModelBox(humanhead, 123, 124, -3.625F, -9.325F, -0.55F, 1, 2, 1, 0.0F, true));
		humanhead.cubeList.add(new ModelBox(humanhead, 123, 124, 2.475F, -9.325F, -0.55F, 1, 2, 1, 0.0F, true));
		humanhead.cubeList.add(new ModelBox(humanhead, 123, 124, -3.625F, -10.675F, 0.325F, 1, 2, 1, 0.0F, true));
		humanhead.cubeList.add(new ModelBox(humanhead, 123, 124, 2.475F, -10.675F, 0.325F, 1, 2, 1, 0.0F, true));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		Body.render(f5);
		TailA.render(f5);
		Leg1A.render(f5);
		Leg1B.render(f5);
		Leg1C.render(f5);
		Leg2A.render(f5);
		Leg2B.render(f5);
		Leg2C.render(f5);
		Leg3A.render(f5);
		Leg3B.render(f5);
		Leg3C.render(f5);
		Leg4A.render(f5);
		Leg4B.render(f5);
		Leg4C.render(f5);
		head.render(f5);
		UMouth.render(f5);
		LMouth.render(f5);
		Ear1.render(f5);
		Ear2.render(f5);
		Neck.render(f5);
		Mane.render(f5);
		bodyknuck.render(f5);
		rightarm.render(f5);
		leftarm.render(f5);
		humanhead.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	/**
	 * Fixes and offsets a rotation in the ModelHorse class.
	 */
	private float updateHorseRotation(float p_110683_1_, float p_110683_2_, float p_110683_3_)
	{
		float f;

		for (f = p_110683_2_ - p_110683_1_; f < -180.0F; f += 360.0F)
		{
			;
		}

		while (f >= 180.0F)
		{
			f -= 360.0F;
		}

		return p_110683_1_ + p_110683_3_ * f;
	}

	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
	{
		float f6 = 0;
		float f7 = 1.0F - f6;
		float f9 = (float)entityIn.ticksExisted + 0;
		float f10 = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI);
		float f11 = f10 * 0.8F * limbSwingAmount;
		this.Body.rotateAngleX = 0.0F;
		float f12 = 0.2617994F * f6;
		float f13 = MathHelper.cos(f9 * 0.6F + (float)Math.PI);
		this.Leg4A.rotationPointY = -2.0F * f6 + 9.0F * f7;
		this.Leg4A.rotationPointZ = -2.0F * f6 + -8.0F * f7;
		this.Leg3A.rotationPointY = this.Leg4A.rotationPointY;
		this.Leg3A.rotationPointZ = this.Leg4A.rotationPointZ;
		this.Leg2B.rotationPointY = this.Leg2A.rotationPointY + MathHelper.sin(((float)Math.PI / 2F) + f12 + f7 * -f10 * 0.5F * limbSwingAmount) * 7.0F;
		this.Leg2B.rotationPointZ = this.Leg2A.rotationPointZ + MathHelper.cos(-((float)Math.PI / 2F) + f12 + f7 * -f10 * 0.5F * limbSwingAmount) * 7.0F;
		this.Leg1B.rotationPointY = this.Leg1A.rotationPointY + MathHelper.sin(((float)Math.PI / 2F) + f12 + f7 * f10 * 0.5F * limbSwingAmount) * 7.0F;
		this.Leg1B.rotationPointZ = this.Leg1A.rotationPointZ + MathHelper.cos(-((float)Math.PI / 2F) + f12 + f7 * f10 * 0.5F * limbSwingAmount) * 7.0F;
		float f14 = (-1.0471976F + f13) * f6 + f11 * f7;
		float f15 = (-1.0471976F - f13) * f6 + -f11 * f7;
		this.Leg4B.rotationPointY = this.Leg4A.rotationPointY + MathHelper.sin(((float)Math.PI / 2F) + f14) * 7.0F;
		this.Leg4B.rotationPointZ = this.Leg4A.rotationPointZ + MathHelper.cos(-((float)Math.PI / 2F) + f14) * 7.0F;
		this.Leg3B.rotationPointY = this.Leg3A.rotationPointY + MathHelper.sin(((float)Math.PI / 2F) + f15) * 7.0F;
		this.Leg3B.rotationPointZ = this.Leg3A.rotationPointZ + MathHelper.cos(-((float)Math.PI / 2F) + f15) * 7.0F;
		this.Leg2A.rotateAngleX = f12 + -f10 * 0.5F * limbSwingAmount * f7;
		this.Leg2B.rotateAngleX = -0.08726646F * f6 + (-f10 * 0.5F * limbSwingAmount - Math.max(0.0F, f10 * 0.5F * limbSwingAmount)) * f7;
		this.Leg2C.rotateAngleX = this.Leg2B.rotateAngleX;
		this.Leg1A.rotateAngleX = f12 + f10 * 0.5F * limbSwingAmount * f7;
		this.Leg1B.rotateAngleX = -0.08726646F * f6 + (f10 * 0.5F * limbSwingAmount - Math.max(0.0F, -f10 * 0.5F * limbSwingAmount)) * f7;
		this.Leg1C.rotateAngleX = this.Leg1B.rotateAngleX;
		this.Leg4A.rotateAngleX = f14;
		this.Leg4B.rotateAngleX = (this.Leg4A.rotateAngleX + (float)Math.PI * Math.max(0.0F, 0.2F + f13 * 0.2F)) * f6 + (f11 + Math.max(0.0F, f10 * 0.5F * limbSwingAmount)) * f7;
		this.Leg4C.rotateAngleX = this.Leg4B.rotateAngleX;
		this.Leg3A.rotateAngleX = f15;
		this.Leg3B.rotateAngleX = (this.Leg3A.rotateAngleX + (float)Math.PI * Math.max(0.0F, 0.2F - f13 * 0.2F)) * f6 + (-f11 + Math.max(0.0F, -f10 * 0.5F * limbSwingAmount)) * f7;
		this.Leg3A.rotateAngleX = this.Leg3B.rotateAngleX;
		this.Leg2C.rotationPointY = this.Leg2B.rotationPointY;
		this.Leg2C.rotationPointZ = this.Leg2B.rotationPointZ;
		this.Leg1C.rotationPointY = this.Leg1B.rotationPointY;
		this.Leg1C.rotationPointZ = this.Leg1B.rotationPointZ;
		this.Leg4C.rotationPointY = this.Leg4B.rotationPointY;
		this.Leg4C.rotationPointZ = this.Leg4B.rotationPointZ;
		this.Leg3C.rotationPointY = this.Leg3B.rotationPointY;
		this.Leg3C.rotationPointZ = this.Leg3B.rotationPointZ;
		this.humanhead.rotateAngleY = netHeadYaw * 0.017453292F;
		this.rightarm.rotationPointZ = 0.0F;
		this.rightarm.rotationPointX = -5.0F;
		this.leftarm.rotationPointZ = 0.0F;
		this.leftarm.rotationPointX = 5.0F;
		float f = 1.0F;
		this.rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F / f;
		this.leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / f;
		this.rightarm.rotateAngleZ = 0.0F;
		this.leftarm.rotateAngleZ = 0.0F;
		this.rightarm.rotateAngleY = 0.0F;
		this.rightarm.rotateAngleZ = 0.0F;
		this.rightarm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.leftarm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		this.leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;

	}
	
}