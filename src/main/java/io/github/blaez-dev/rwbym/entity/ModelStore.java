package io.github.blaez-dev.rwbym.entity;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class ModelStore extends ModelBiped {
	private final ModelRenderer body;
	private final ModelRenderer bipedBodyWear;
	private final ModelRenderer head;
	private final ModelRenderer hat;
	private final ModelRenderer rightArm;
	private final ModelRenderer leftArm;
	private final ModelRenderer bipedRightArmwear;
	private final ModelRenderer bipedLeftArmwear;
	private final ModelRenderer rightLeg;
	private final ModelRenderer bipedLeftLeg;
	private final ModelRenderer bipedRightLegwear;
	private final ModelRenderer bipedLeftLegwear;

	public ModelStore() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 16, 16, -4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F, true));

		bipedBodyWear = new ModelRenderer(this);
		bipedBodyWear.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedBodyWear.cubeList.add(new ModelBox(bipedBodyWear, 16, 32, -4.0F, 0.0F, -2.0F, 8, 12, 4, 0.5F, true));

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.cubeList.add(new ModelBox(head, 0, 0, -4.0F, -8.0F, -4.0F, 8, 8, 8, 0.5F, true));

		hat = new ModelRenderer(this);
		hat.setRotationPoint(0.0F, 0.0F, 0.0F);
		hat.cubeList.add(new ModelBox(hat, 32, 0, -4.0F, -8.0F, -4.0F, 8, 8, 8, 1.0F, true));

		rightArm = new ModelRenderer(this);
		rightArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		rightArm.cubeList.add(new ModelBox(rightArm, 40, 16, -2.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, true));

		leftArm = new ModelRenderer(this);
		leftArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		leftArm.cubeList.add(new ModelBox(leftArm, 40, 16, -3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, false));

		bipedRightArmwear = new ModelRenderer(this);
		bipedRightArmwear.setRotationPoint(5.0F, 2.0F, 0.0F);
		bipedRightArmwear.cubeList.add(new ModelBox(bipedRightArmwear, 40, 32, -2.0F, -2.0F, -2.0F, 4, 12, 4, 0.5F, true));

		bipedLeftArmwear = new ModelRenderer(this);
		bipedLeftArmwear.setRotationPoint(-5.0F, 2.0F, 0.0F);
		bipedLeftArmwear.cubeList.add(new ModelBox(bipedLeftArmwear, 40, 32, -3.0F, -2.0F, -2.0F, 4, 12, 4, 0.5F, false));

		rightLeg = new ModelRenderer(this);
		rightLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
		rightLeg.cubeList.add(new ModelBox(rightLeg, 16, 48, -1.85F, 0.0F, -2.0F, 4, 12, 4, 0.0F, true));

		bipedLeftLeg = new ModelRenderer(this);
		bipedLeftLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
		bipedLeftLeg.cubeList.add(new ModelBox(bipedLeftLeg, 16, 48, -2.15F, 0.0F, -2.0F, 4, 12, 4, 0.0F, false));

		bipedRightLegwear = new ModelRenderer(this);
		bipedRightLegwear.setRotationPoint(1.9F, 12.0F, 0.0F);
		bipedRightLegwear.cubeList.add(new ModelBox(bipedRightLegwear, 0, 48, -1.65F, 0.0F, -2.0F, 4, 12, 4, 0.25F, true));

		bipedLeftLegwear = new ModelRenderer(this);
		bipedLeftLegwear.setRotationPoint(-1.9F, 12.0F, 0.0F);
		bipedLeftLegwear.cubeList.add(new ModelBox(bipedLeftLegwear, 0, 32, -2.35F, 0.0F, -2.0F, 4, 12, 4, 0.25F, false));
	}


	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		GlStateManager.pushMatrix();
		if (this.isChild) {
			float f = 2.0F;
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			GlStateManager.translate(0.0F, 24.0F * scale, 0.0F);
			this.bipedLeftLegwear.render(scale);
			this.bipedRightLegwear.render(scale);
			this.bipedLeftArmwear.render(scale);
			this.bipedRightArmwear.render(scale);
			this.bipedBodyWear.render(scale);
		} else {
			if (entityIn.isSneaking()) {
				GlStateManager.translate(0.0F, 0.2F, 0.0F);
			}

			this.bipedLeftLegwear.render(scale);
			this.bipedRightLegwear.render(scale);
			this.bipedLeftArmwear.render(scale);
			this.bipedRightArmwear.render(scale);
			this.bipedBodyWear.render(scale);
		}

		GlStateManager.popMatrix();
	}


	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
		copyModelAngles(this.bipedLeftLeg, this.bipedLeftLegwear);
		copyModelAngles(this.bipedRightLeg, this.bipedRightLegwear);
		copyModelAngles(this.bipedLeftArm, this.bipedLeftArmwear);
		copyModelAngles(this.bipedRightArm, this.bipedRightArmwear);
		copyModelAngles(this.bipedBody, this.bipedBodyWear);
	}




}