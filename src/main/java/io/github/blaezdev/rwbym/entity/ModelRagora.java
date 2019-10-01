package io.github.blaezdev.rwbym.entity;


import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class ModelRagora extends ModelBase {
	private final ModelRenderer Ragora;
	private final ModelRenderer upperJaw;
	private final ModelRenderer sideFront1;
	private final ModelRenderer riseLeft;
	private final ModelRenderer riseRight;
	private final ModelRenderer horn;
	private final ModelRenderer hornBend;
	private final ModelRenderer sideLeft1;
	private final ModelRenderer sideRight1;
	private final ModelRenderer hornsCurve;
	private final ModelRenderer hornLeft1;
	private final ModelRenderer hornLeft2;
	private final ModelRenderer hornLeft3;
	private final ModelRenderer hornLeft4;
	private final ModelRenderer hornLeft5;
	private final ModelRenderer hornLeft6;
	private final ModelRenderer hornLeft7;
	private final ModelRenderer hornLeft8;
	private final ModelRenderer hornLeft9;
	private final ModelRenderer hornRight1;
	private final ModelRenderer hornRight2;
	private final ModelRenderer hornRight3;
	private final ModelRenderer hornRight4;
	private final ModelRenderer hornRight5;
	private final ModelRenderer hornRight6;
	private final ModelRenderer hornRight7;
	private final ModelRenderer hornRight8;
	private final ModelRenderer hornRight9;
	private final ModelRenderer lowerJaw;
	private final ModelRenderer sideFront2;
	private final ModelRenderer sideLeft2;
	private final ModelRenderer sideRight2;

	public ModelRagora() {
		textureWidth = 128;
		textureHeight = 128;

		Ragora = new ModelRenderer(this);
		Ragora.setRotationPoint(0.0F, 23.0F, 0.0F);

		upperJaw = new ModelRenderer(this);
		upperJaw.setRotationPoint(0.0F, -6.0F, 9.225F);
		Ragora.addChild(upperJaw);
		upperJaw.cubeList.add(new ModelBox(upperJaw, 0, 1, -6.5F, -6.0F, -7.475F, 13, 4, 6, 0.0F, false));
		upperJaw.cubeList.add(new ModelBox(upperJaw, 0, 21, -6.5F, -5.0F, -1.475F, 13, 5, 2, 0.0F, false));
		upperJaw.cubeList.add(new ModelBox(upperJaw, 31, 59, -2.5F, -6.0F, -12.475F, 5, 4, 5, 0.0F, false));
		upperJaw.cubeList.add(new ModelBox(upperJaw, 20, 77, 5.5F, -2.0F, -7.475F, 1, 2, 6, 0.0F, false));
		upperJaw.cubeList.add(new ModelBox(upperJaw, 12, 71, -6.5F, -2.0F, -7.475F, 1, 2, 6, 0.0F, false));

		sideFront1 = new ModelRenderer(this);
		sideFront1.setRotationPoint(0.0F, -4.0F, -12.225F);
		setRotationAngle(sideFront1, 0.0F, -0.7854F, 0.0F);
		upperJaw.addChild(sideFront1);
		sideFront1.cubeList.add(new ModelBox(sideFront1, 41, 73, -5.0F, -5.0F, -5.0F, 6, 12, 1, 0.0F, false));
		sideFront1.cubeList.add(new ModelBox(sideFront1, 34, 38, -5.0F, -2.0F, -5.0F, 6, 4, 6, 0.0F, false));
		sideFront1.cubeList.add(new ModelBox(sideFront1, 22, 44, -5.0F, -5.0F, -5.0F, 1, 12, 6, 0.0F, false));

		riseLeft = new ModelRenderer(this);
		riseLeft.setRotationPoint(1.0F, -2.0F, -4.5F);
		setRotationAngle(riseLeft, 0.0F, 0.0F, 0.5236F);
		sideFront1.addChild(riseLeft);
		riseLeft.cubeList.add(new ModelBox(riseLeft, 60, 0, -6.0F, 0.0F, -0.5F, 6, 1, 1, 0.0F, false));

		riseRight = new ModelRenderer(this);
		riseRight.setRotationPoint(-4.5F, -2.0F, 1.0F);
		setRotationAngle(riseRight, -0.5236F, 0.0F, 0.0F);
		sideFront1.addChild(riseRight);
		riseRight.cubeList.add(new ModelBox(riseRight, 79, 75, -0.5F, 0.0F, -6.0F, 1, 1, 6, 0.0F, false));

		horn = new ModelRenderer(this);
		horn.setRotationPoint(0.0F, -9.5F, -16.475F);
		setRotationAngle(horn, 0.5236F, 0.0F, 0.0F);
		upperJaw.addChild(horn);
		horn.cubeList.add(new ModelBox(horn, 0, 28, -1.0F, -0.5F, -1.75F, 2, 2, 2, 0.0F, false));

		hornBend = new ModelRenderer(this);
		hornBend.setRotationPoint(0.0F, -0.75F, 0.25F);
		setRotationAngle(hornBend, -0.2618F, 0.0F, 0.0F);
		horn.addChild(hornBend);
		hornBend.cubeList.add(new ModelBox(hornBend, 16, 30, -0.5F, 0.25F, 0.0F, 1, 1, 3, 0.0F, false));

		sideLeft1 = new ModelRenderer(this);
		sideLeft1.setRotationPoint(2.5F, -4.0F, -11.475F);
		setRotationAngle(sideLeft1, 0.0F, 0.2618F, 0.0F);
		upperJaw.addChild(sideLeft1);
		sideLeft1.cubeList.add(new ModelBox(sideLeft1, 0, 28, -1.25F, -2.0F, -3.0F, 4, 4, 8, 0.0F, false));
		sideLeft1.cubeList.add(new ModelBox(sideLeft1, 56, 18, 1.75F, 2.0F, -3.0F, 1, 3, 8, 0.0F, false));

		sideRight1 = new ModelRenderer(this);
		sideRight1.setRotationPoint(-2.5F, -4.0F, -11.475F);
		setRotationAngle(sideRight1, 0.0F, -0.2618F, 0.0F);
		upperJaw.addChild(sideRight1);
		sideRight1.cubeList.add(new ModelBox(sideRight1, 22, 21, -2.75F, -2.0F, -3.0F, 4, 4, 8, 0.0F, false));
		sideRight1.cubeList.add(new ModelBox(sideRight1, 61, 43, -2.75F, 2.0F, -3.0F, 1, 3, 8, 0.0F, false));

		hornsCurve = new ModelRenderer(this);
		hornsCurve.setRotationPoint(0.0F, -6.0F, -7.225F);
		setRotationAngle(hornsCurve, -0.9599F, 0.0F, 0.0F);
		upperJaw.addChild(hornsCurve);

		hornLeft1 = new ModelRenderer(this);
		hornLeft1.setRotationPoint(4.0F, -4.0F, 2.5F);
		setRotationAngle(hornLeft1, 0.0F, 0.1745F, 0.1745F);
		hornsCurve.addChild(hornLeft1);
		hornLeft1.cubeList.add(new ModelBox(hornLeft1, 51, 54, -1.5F, -2.0F, -2.5F, 5, 6, 5, 0.0F, false));

		hornLeft2 = new ModelRenderer(this);
		hornLeft2.setRotationPoint(0.0F, -1.0F, 0.0F);
		setRotationAngle(hornLeft2, 0.0F, 0.0F, 0.7854F);
		hornLeft1.addChild(hornLeft2);
		hornLeft2.cubeList.add(new ModelBox(hornLeft2, 0, 51, -1.75F, -6.0F, -2.5F, 5, 6, 5, 0.0F, false));

		hornLeft3 = new ModelRenderer(this);
		hornLeft3.setRotationPoint(0.5F, -6.0F, -2.5F);
		setRotationAngle(hornLeft3, 0.5236F, 0.0F, 0.0F);
		hornLeft2.addChild(hornLeft3);
		hornLeft3.cubeList.add(new ModelBox(hornLeft3, 0, 40, -2.25F, 0.0F, 0.0F, 5, 5, 6, 0.0F, false));

		hornLeft4 = new ModelRenderer(this);
		hornLeft4.setRotationPoint(-2.25F, 0.0F, 6.0F);
		setRotationAngle(hornLeft4, 0.7854F, 0.0F, 0.0F);
		hornLeft3.addChild(hornLeft4);
		hornLeft4.cubeList.add(new ModelBox(hornLeft4, 0, 67, 0.0F, 0.0F, -4.0F, 5, 5, 4, 0.0F, false));

		hornLeft5 = new ModelRenderer(this);
		hornLeft5.setRotationPoint(0.0F, 5.0F, 0.0F);
		setRotationAngle(hornLeft5, 0.0F, 0.0F, 0.6981F);
		hornLeft4.addChild(hornLeft5);
		hornLeft5.cubeList.add(new ModelBox(hornLeft5, 66, 65, 0.0F, -5.0F, -3.9F, 5, 5, 4, 0.0F, false));

		hornLeft6 = new ModelRenderer(this);
		hornLeft6.setRotationPoint(5.0F, 0.0F, 0.0F);
		setRotationAngle(hornLeft6, 0.0F, 0.0F, 0.9599F);
		hornLeft5.addChild(hornLeft6);
		hornLeft6.cubeList.add(new ModelBox(hornLeft6, 71, 41, -4.0F, -5.0F, -4.0F, 4, 5, 4, 0.0F, false));

		hornLeft7 = new ModelRenderer(this);
		hornLeft7.setRotationPoint(0.0F, -5.0F, 0.0F);
		setRotationAngle(hornLeft7, -0.7854F, 0.0F, 0.0F);
		hornLeft6.addChild(hornLeft7);
		hornLeft7.cubeList.add(new ModelBox(hornLeft7, 71, 0, -4.0F, 0.0F, -5.0F, 4, 4, 5, 0.0F, false));

		hornLeft8 = new ModelRenderer(this);
		hornLeft8.setRotationPoint(0.0F, 0.0F, -5.0F);
		setRotationAngle(hornLeft8, 0.0F, -1.0472F, 0.0F);
		hornLeft7.addChild(hornLeft8);
		hornLeft8.cubeList.add(new ModelBox(hornLeft8, 0, 76, -4.0F, 1.0F, 0.0F, 4, 3, 4, 0.0F, false));

		hornLeft9 = new ModelRenderer(this);
		hornLeft9.setRotationPoint(-4.0F, 0.0F, 0.0F);
		setRotationAngle(hornLeft9, 0.0F, 0.0F, 1.0472F);
		hornLeft8.addChild(hornLeft9);
		hornLeft9.cubeList.add(new ModelBox(hornLeft9, 78, 82, 1.0F, 0.5F, 0.5F, 3, 4, 3, 0.0F, false));

		hornRight1 = new ModelRenderer(this);
		hornRight1.setRotationPoint(-4.0F, -4.0F, 2.5F);
		setRotationAngle(hornRight1, 0.0F, -0.1745F, -0.1745F);
		hornsCurve.addChild(hornRight1);
		hornRight1.cubeList.add(new ModelBox(hornRight1, 36, 48, -3.5F, -2.0F, -2.5F, 5, 6, 5, 0.0F, false));

		hornRight2 = new ModelRenderer(this);
		hornRight2.setRotationPoint(0.0F, -1.0F, 0.0F);
		setRotationAngle(hornRight2, 0.0F, 0.0F, -0.7854F);
		hornRight1.addChild(hornRight2);
		hornRight2.cubeList.add(new ModelBox(hornRight2, 56, 6, -3.25F, -6.0F, -2.5F, 5, 6, 5, 0.0F, false));

		hornRight3 = new ModelRenderer(this);
		hornRight3.setRotationPoint(-0.5F, -6.0F, -2.5F);
		setRotationAngle(hornRight3, 0.5236F, 0.0F, 0.0F);
		hornRight2.addChild(hornRight3);
		hornRight3.cubeList.add(new ModelBox(hornRight3, 40, 27, -2.75F, 0.0F, 0.0F, 5, 5, 6, 0.0F, false));

		hornRight4 = new ModelRenderer(this);
		hornRight4.setRotationPoint(2.25F, 0.0F, 6.0F);
		setRotationAngle(hornRight4, 0.7854F, 0.0F, 0.0F);
		hornRight3.addChild(hornRight4);
		hornRight4.cubeList.add(new ModelBox(hornRight4, 66, 17, -5.0F, 0.0F, -4.0F, 5, 5, 4, 0.0F, false));

		hornRight5 = new ModelRenderer(this);
		hornRight5.setRotationPoint(0.0F, 5.0F, 0.0F);
		setRotationAngle(hornRight5, 0.0F, 0.0F, -0.6981F);
		hornRight4.addChild(hornRight5);
		hornRight5.cubeList.add(new ModelBox(hornRight5, 71, 26, -5.0F, -5.0F, -3.9F, 5, 5, 4, 0.0F, false));

		hornRight6 = new ModelRenderer(this);
		hornRight6.setRotationPoint(-5.0F, 0.0F, 0.0F);
		setRotationAngle(hornRight6, 0.0F, 0.0F, -0.9599F);
		hornRight5.addChild(hornRight6);
		hornRight6.cubeList.add(new ModelBox(hornRight6, 71, 54, 0.0F, -5.0F, -4.0F, 4, 5, 4, 0.0F, false));

		hornRight7 = new ModelRenderer(this);
		hornRight7.setRotationPoint(0.0F, -5.0F, 0.0F);
		setRotationAngle(hornRight7, -0.7854F, 0.0F, 0.0F);
		hornRight6.addChild(hornRight7);
		hornRight7.cubeList.add(new ModelBox(hornRight7, 23, 68, 0.0F, 0.0F, -5.0F, 4, 4, 5, 0.0F, false));

		hornRight8 = new ModelRenderer(this);
		hornRight8.setRotationPoint(0.0F, 0.0F, -5.0F);
		setRotationAngle(hornRight8, 0.0F, 1.0472F, 0.0F);
		hornRight7.addChild(hornRight8);
		hornRight8.cubeList.add(new ModelBox(hornRight8, 69, 74, 0.0F, 1.0F, 0.0F, 4, 3, 4, 0.0F, false));

		hornRight9 = new ModelRenderer(this);
		hornRight9.setRotationPoint(4.0F, 0.0F, 0.0F);
		setRotationAngle(hornRight9, 0.0F, 0.0F, -1.0472F);
		hornRight8.addChild(hornRight9);
		hornRight9.cubeList.add(new ModelBox(hornRight9, 66, 81, -4.0F, 0.5F, 0.5F, 3, 4, 3, 0.0F, false));

		lowerJaw = new ModelRenderer(this);
		lowerJaw.setRotationPoint(0.0F, -6.0F, 9.5F);
		Ragora.addChild(lowerJaw);
		lowerJaw.cubeList.add(new ModelBox(lowerJaw, 0, 11, -6.5F, 1.0F, -7.75F, 13, 4, 6, 0.0F, false));
		lowerJaw.cubeList.add(new ModelBox(lowerJaw, 32, 0, -6.5F, 0.0F, -1.75F, 13, 4, 2, 0.0F, false));
		lowerJaw.cubeList.add(new ModelBox(lowerJaw, 76, 9, 5.5F, -1.0F, -7.75F, 1, 2, 6, 0.0F, false));
		lowerJaw.cubeList.add(new ModelBox(lowerJaw, 10, 79, -6.5F, -1.0F, -7.75F, 1, 2, 6, 0.0F, false));
		lowerJaw.cubeList.add(new ModelBox(lowerJaw, 46, 65, -2.5F, 2.0F, -12.75F, 5, 3, 5, 0.0F, false));

		sideFront2 = new ModelRenderer(this);
		sideFront2.setRotationPoint(0.0F, -4.0F, -12.5F);
		setRotationAngle(sideFront2, 0.0F, -0.7854F, 0.0F);
		lowerJaw.addChild(sideFront2);
		sideFront2.cubeList.add(new ModelBox(sideFront2, 14, 56, -5.0F, 1.0F, -5.0F, 1, 9, 6, 0.0F, false));
		sideFront2.cubeList.add(new ModelBox(sideFront2, 38, 17, -5.0F, 6.0F, -5.0F, 6, 3, 6, 0.0F, false));
		sideFront2.cubeList.add(new ModelBox(sideFront2, 55, 74, -5.0F, 1.0F, -5.0F, 6, 9, 1, 0.0F, false));

		sideLeft2 = new ModelRenderer(this);
		sideLeft2.setRotationPoint(2.5F, -4.0F, -11.75F);
		setRotationAngle(sideLeft2, 0.0F, 0.2618F, 0.0F);
		lowerJaw.addChild(sideLeft2);
		sideLeft2.cubeList.add(new ModelBox(sideLeft2, 16, 33, -1.25F, 6.0F, -3.0F, 4, 3, 8, 0.0F, false));
		sideLeft2.cubeList.add(new ModelBox(sideLeft2, 61, 30, 1.75F, 3.0F, -3.0F, 1, 3, 8, 0.0F, false));

		sideRight2 = new ModelRenderer(this);
		sideRight2.setRotationPoint(-2.5F, -4.0F, -11.75F);
		setRotationAngle(sideRight2, 0.0F, -0.2618F, 0.0F);
		lowerJaw.addChild(sideRight2);
		sideRight2.cubeList.add(new ModelBox(sideRight2, 32, 6, -2.75F, 6.0F, -3.0F, 4, 3, 8, 0.0F, false));
		sideRight2.cubeList.add(new ModelBox(sideRight2, 51, 40, -2.75F, 3.0F, -3.0F, 1, 3, 8, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		EntityRagora entityragora = (EntityRagora) entity;
		float scale = entityragora.getRenderSizeModifier();
		GlStateManager.pushMatrix();
		GlStateManager.scale(scale, scale, scale);
		GlStateManager.translate(0, 1F * (1/scale - 1), 0);
		lowerJaw.rotateAngleX = (float) ((Math.cos(f) + 1) * Math.PI / 10) * f1;
		Ragora.rotateAngleX = (float) (f4 * Math.PI / 180);
		Ragora.rotationPointX = 0;
		Ragora.rotationPointY = 23F;
		Ragora.rotationPointZ = 0;
		Ragora.offsetX = 0;
		Ragora.offsetY = 0F;
		Ragora.offsetZ = 0;
		float pt = Minecraft.getMinecraft().getRenderPartialTicks();
		float yaw = (float) ((entityragora.prevRotationYaw + 180) * Math.PI / 180 * (1 - pt) + (entityragora.rotationYaw + 180) * Math.PI / 180 * pt);
		Ragora.rotateAngleY = yaw;
		Ragora.render(f5);
		GlStateManager.popMatrix();
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}