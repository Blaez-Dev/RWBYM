package be.bluexin.rwbym.entity;

import net.minecraft.util.math.MathHelper;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class ModelApathy extends ModelBase {
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer rightArm;
	private final ModelRenderer leftArm;
	private final ModelRenderer rightLeg;
	private final ModelRenderer leftLeg;

	public ModelApathy() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 16, 16, -4.0F, 0.375F, -2.0F, 8, 7, 4, 0.0F, true));
		body.cubeList.add(new ModelBox(body, 36, 0, -3.002F, 10.378F, -2.261F, 6, 1, 1, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 44, 0, 2.572F, 9.751F, -2.261F, 1, 1, 1, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 44, 0, -3.242F, 9.751F, -2.261F, 1, 1, 1, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 44, 0, -3.964F, 8.751F, -2.261F, 1, 2, 1, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 44, 0, 3.294F, 8.751F, -2.261F, 1, 2, 1, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 44, 0, 4.65F, -0.8F, -2.1F, 1, 1, 4, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 44, 0, -4.875F, -0.8F, -2.1F, 1, 1, 4, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 44, 0, -5.125F, -0.8F, 0.0F, 1, 1, 4, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 44, 0, 4.925F, -0.8F, 0.0F, 1, 1, 4, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 44, 0, -4.9F, -0.525F, -2.975F, 1, 2, 1, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 44, 0, -3.95F, 0.475F, -2.975F, 1, 1, 1, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 36, 0, -3.95F, 1.3F, -2.975F, 8, 1, 1, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 44, 0, 3.7F, 0.475F, -2.975F, 1, 1, 1, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 44, 0, 4.65F, -0.525F, -2.975F, 1, 2, 1, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 0, 58, -2.75F, 10.075F, -2.0F, 5, 2, 4, 0.0F, true));
		body.cubeList.add(new ModelBox(body, 3, 46, -1.8F, -0.675F, -1.675F, 3, 11, 3, 0.0F, true));

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.cubeList.add(new ModelBox(head, 0, 0, -4.0F, -8.0F, -4.0F, 8, 6, 8, 0.0F, true));
		head.cubeList.add(new ModelBox(head, 33, 0, -4.5F, -6.825F, -3.725F, 8, 3, 7, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 33, 0, -3.3F, -8.825F, -3.725F, 6, 5, 7, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 40, 54, -3.075F, -3.0F, -3.25F, 6, 3, 6, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 0, -4.0F, -8.0F, -4.0F, 8, 6, 8, 0.0F, true));
		head.cubeList.add(new ModelBox(head, 49, 12, -3.05F, -3.35F, -4.025F, 6, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 44, 47, -3.1F, -3.3F, -4.05F, 1, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 40, 6, -2.525F, -1.15F, -3.3F, 5, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 44, 47, -1.525F, -3.3F, -4.05F, 1, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 44, 47, 2.075F, -3.3F, -4.05F, 1, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 44, 47, 0.55F, -3.3F, -4.05F, 1, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 44, 47, 0.825F, -1.175F, -3.325F, 1, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 44, 47, -1.775F, -1.175F, -3.325F, 1, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 45, 22, -0.55F, -5.175F, -4.15F, 1, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 14, 50, -3.275F, -6.95F, -4.025F, 2, 1, 0, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 56, 1, -3.975F, -7.075F, -4.05F, 1, 3, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 56, 1, 3.0F, -7.075F, -4.05F, 1, 3, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 56, 1, 0.275F, -7.525F, -4.05F, 3, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 56, 1, -3.6F, -7.525F, -4.05F, 3, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 14, 50, 1.025F, -6.95F, -4.025F, 2, 1, 0, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 45, 22, -0.55F, -5.075F, -4.15F, 1, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 44, 47, -1.775F, -1.075F, -3.325F, 1, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 44, 47, 0.825F, -1.075F, -3.325F, 1, 1, 1, 0.0F, false));

		rightArm = new ModelRenderer(this);
		rightArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		rightArm.cubeList.add(new ModelBox(rightArm, 5, 39, -1.0F, -1.25F, -1.0F, 2, 14, 2, 0.0F, true));
		rightArm.cubeList.add(new ModelBox(rightArm, 44, 8, -0.675F, 5.3F, 0.75F, 1, 1, 1, 0.0F, true));
		rightArm.cubeList.add(new ModelBox(rightArm, 44, 8, -0.625F, 5.0F, 1.65F, 1, 1, 1, 0.0F, true));

		leftArm = new ModelRenderer(this);
		leftArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		leftArm.cubeList.add(new ModelBox(leftArm, 1, 40, -1.0F, -1.25F, -1.0F, 2, 14, 2, 0.0F, false));
		leftArm.cubeList.add(new ModelBox(leftArm, 44, 8, -0.675F, 5.3F, 0.75F, 1, 1, 1, 0.0F, false));
		leftArm.cubeList.add(new ModelBox(leftArm, 44, 8, -0.625F, 5.0F, 1.65F, 1, 1, 1, 0.0F, false));

		rightLeg = new ModelRenderer(this);
		rightLeg.setRotationPoint(2.0F, 12.0F, 0.0F);
		rightLeg.cubeList.add(new ModelBox(rightLeg, 0, 39, -1.0F, 0.0F, -1.0F, 2, 12, 2, 0.0F, true));
		rightLeg.cubeList.add(new ModelBox(rightLeg, 53, 7, -1.45F, 6.15F, -1.425F, 3, 1, 1, 0.0F, false));
		rightLeg.cubeList.add(new ModelBox(rightLeg, 53, 7, -1.45F, 5.825F, -0.975F, 3, 1, 0, 0.0F, false));

		leftLeg = new ModelRenderer(this);
		leftLeg.setRotationPoint(-2.0F, 12.0F, 0.0F);
		leftLeg.cubeList.add(new ModelBox(leftLeg, 0, 37, -1.0F, 0.0F, -1.0F, 2, 12, 2, 0.0F, false));
		leftLeg.cubeList.add(new ModelBox(leftLeg, 36, 1, -1.575F, 6.15F, -1.35F, 3, 1, 1, 0.0F, false));
		leftLeg.cubeList.add(new ModelBox(leftLeg, 36, 1, -1.6F, 5.825F, -0.975F, 3, 1, 1, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		body.render(f5);
		head.render(f5);
		rightArm.render(f5);
		leftArm.render(f5);
		rightLeg.render(f5);
		leftLeg.render(f5);
	}
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
	{
		this.head.rotateAngleY = netHeadYaw * 0.017453292F;
		this.body.rotateAngleY = 0.0F;
		this.rightArm.rotationPointZ = 0.0F;
		this.rightArm.rotationPointX = -5.0F;
		this.leftArm.rotationPointZ = 0.0F;
		this.leftArm.rotationPointX = 5.0F;
		float f = 1.0F;
		this.rightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F / f;
		this.leftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / f;
		this.rightArm.rotateAngleZ = 0.0F;
		this.leftArm.rotateAngleZ = 0.0F;
		this.rightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f;
		this.leftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount / f;
		this.rightLeg.rotateAngleY = 0.0F;
		this.leftLeg.rotateAngleY = 0.0F;
		this.rightLeg.rotateAngleZ = 0.0F;
		this.leftLeg.rotateAngleZ = 0.0F;
		this.rightArm.rotateAngleY = 0.0F;
		this.rightArm.rotateAngleZ = 0.0F;
		this.rightArm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.leftArm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.rightArm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		this.leftArm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;

	}
}