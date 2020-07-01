package io.github.blaezdev.rwbym.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;

public class ModelArachne extends ModelBase {
	private final ModelRenderer Body;
	private final ModelRenderer Head;
	private final ModelRenderer Leg1;
	private final ModelRenderer bone4;
	private final ModelRenderer bone5;
	private final ModelRenderer Leg2;
	private final ModelRenderer bone7;
	private final ModelRenderer bone8;
	private final ModelRenderer Leg3;
	private final ModelRenderer bone10;
	private final ModelRenderer bone11;
	private final ModelRenderer Leg4;
	private final ModelRenderer bone13;
	private final ModelRenderer bone14;
	private final ModelRenderer Leg5;
	private final ModelRenderer bone16;
	private final ModelRenderer Leg6;
	private final ModelRenderer bone18;
	private final ModelRenderer Leg7;
	private final ModelRenderer bone20;
	private final ModelRenderer bone21;
	private final ModelRenderer Leg8;
	private final ModelRenderer bone23;
	private final ModelRenderer bone24;

	public ModelArachne() {
		textureWidth = 115;
		textureHeight = 115;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 11.75F, -11.0F);
		setRotationAngle(Body, 1.5708F, 0.0F, 0.0F);
		Body.cubeList.add(new ModelBox(Body, 6, 7, -8.0F, -16.0F, -2.0F, 16, 16, 6, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 3, 77, -8.0F, -16.0F, -8.0F, 16, 15, 6, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 10, 49, -2.0F, -12.0F, 3.75F, 4, 5, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 9, 52, -2.0F, -6.0F, 3.75F, 4, 1, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 14, 56, -2.75F, -6.25F, 3.75F, 1, 1, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 11, 47, -3.5F, -6.75F, 3.75F, 1, 1, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 6, 43, 2.5F, -6.75F, 3.75F, 1, 1, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 16, 53, -4.25F, -7.5F, 3.75F, 1, 1, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 10, 50, 3.25F, -7.5F, 3.75F, 1, 1, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 8, 41, 3.25F, -8.25F, 3.75F, 1, 1, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 8, 43, -4.25F, -8.25F, 3.75F, 1, 1, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 10, 54, -4.25F, -9.0F, 3.75F, 1, 1, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 5, 39, 3.25F, -9.0F, 3.75F, 1, 1, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 9, 53, 3.25F, -9.75F, 3.75F, 1, 1, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 11, 41, -4.25F, -9.75F, 3.75F, 1, 1, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 11, 44, -4.25F, -12.75F, 3.75F, 1, 3, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 7, 41, 3.25F, -12.75F, 3.75F, 1, 3, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 6, 41, 1.75F, -6.25F, 3.75F, 1, 1, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 1, 44, -0.5F, -5.25F, 3.75F, 1, 4, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 4, 44, -1.5F, -5.25F, 3.75F, 1, 1, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 3, 49, 0.5F, -5.25F, 3.75F, 1, 1, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 8, 38, -3.75F, -3.25F, 3.75F, 1, 1, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 5, 45, 2.5F, -3.25F, 3.75F, 1, 1, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 7, 37, -4.5F, -4.0F, 3.75F, 1, 1, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 6, 44, 3.0F, -4.0F, 3.75F, 1, 1, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 5, 42, -5.25F, -4.75F, 3.75F, 1, 1, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 4, 50, 3.75F, -4.75F, 3.75F, 1, 1, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 7, 41, -6.0F, -5.5F, 3.75F, 1, 1, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 1, 45, 4.5F, -5.5F, 3.75F, 1, 1, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 6, 43, -6.5F, -6.25F, 3.75F, 1, 1, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 6, 41, 5.0F, -6.25F, 3.75F, 1, 1, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 7, 42, -7.0F, -7.0F, 3.75F, 1, 1, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 5, 50, 5.75F, -7.0F, 3.75F, 1, 1, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 6, 44, -7.5F, -7.75F, 3.75F, 1, 1, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 10, 49, 6.25F, -7.75F, 3.75F, 1, 1, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 9, 5, 6.0F, -15.5F, -4.5F, 3, 15, 8, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 4, 6, -9.0F, -15.5F, -4.5F, 3, 15, 8, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 6, 6, -10.0F, -14.5F, -4.0F, 3, 13, 7, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 4, 7, 7.0F, -14.25F, -4.75F, 3, 13, 8, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 4, 8, -8.75F, -17.25F, -4.5F, 17, 5, 8, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 6, 12, -7.5F, -4.0F, -5.5F, 15, 5, 9, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 3, 17, -6.5F, -18.25F, -4.25F, 13, 5, 7, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 9, 75, -6.5F, -18.25F, -7.25F, 13, 5, 3, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 7, 16, -5.75F, -2.75F, -5.0F, 12, 5, 8, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 5, 14, -6.0F, -19.25F, -4.5F, 12, 5, 7, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 13, 83, -6.0F, -19.25F, -6.25F, 12, 5, 2, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 7, 17, -5.0F, -20.0F, -4.0F, 10, 5, 6, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 7, 78, -5.0F, -20.0F, -6.25F, 10, 5, 2, 0.0F, false));

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 14.75F, -2.0F);
		Head.cubeList.add(new ModelBox(Head, 3, 99, -5.0F, -5.0F, -10.0F, 10, 8, 6, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 3, 99, -5.5F, -5.5F, -4.0F, 11, 9, 7, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 3, 99, -5.0F, -5.0F, -1.0F, 10, 8, 7, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 5, 55, -1.0F, -5.5F, 3.25F, 2, 4, 2, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 7, 56, -3.5F, -6.0F, -0.25F, 2, 4, 2, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 4, 60, 1.25F, -6.0F, -0.25F, 2, 4, 2, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 3, 99, 0.75F, -3.0F, 4.0F, 4, 4, 4, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 3, 99, 1.25F, -2.5F, 5.5F, 3, 3, 4, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 4, 24, 1.75F, -2.0F, 7.25F, 2, 2, 4, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 5, 31, 1.0F, -1.5F, 11.0F, 2, 1, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 7, 31, -2.5F, -1.5F, 11.0F, 2, 1, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 4, 23, -3.5F, -2.0F, 7.25F, 2, 2, 4, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 3, 99, -4.25F, -2.5F, 5.5F, 3, 3, 4, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 3, 99, -4.75F, -3.0F, 4.0F, 4, 4, 4, 0.0F, false));

		Leg1 = new ModelRenderer(this);
		Leg1.setRotationPoint(-6.0F, 13.25F, -6.0F);
		setRotationAngle(Leg1, 0.0F, 1.2217F, -0.3491F);
		Leg1.cubeList.add(new ModelBox(Leg1, 2, 98, -21.0F, 0.0F, 0.0F, 19, 1, 1, 0.0F, false));
		Leg1.cubeList.add(new ModelBox(Leg1, 2, 98, -4.4181F, -1.25F, -0.9793F, 6, 3, 2, 0.0F, false));

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(-20.2213F, 1.0F, -0.431F);
		Leg1.addChild(bone4);
		setRotationAngle(bone4, 0.0F, 0.0F, -0.3491F);
		bone4.cubeList.add(new ModelBox(bone4, 2, 98, -4.2083F, -1.1523F, 0.23F, 4, 1, 1, 0.0F, false));

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(-23.8609F, 2.25F, -0.491F);
		Leg1.addChild(bone5);
		setRotationAngle(bone5, 0.0F, 0.0F, -0.0873F);
		bone5.cubeList.add(new ModelBox(bone5, 2, 98, -14.2083F, -1.1523F, 0.23F, 14, 1, 1, 0.0F, false));

		Leg2 = new ModelRenderer(this);
		Leg2.setRotationPoint(6.0F, 13.25F, -6.0F);
		setRotationAngle(Leg2, 0.0F, 1.9199F, 0.3491F);
		Leg2.cubeList.add(new ModelBox(Leg2, 9, 88, -21.0F, 0.0F, 0.0F, 19, 1, 1, 0.0F, false));
		Leg2.cubeList.add(new ModelBox(Leg2, 9, 88, -4.4181F, -1.25F, -0.9793F, 6, 3, 2, 0.0F, false));

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(-20.2213F, 1.0F, -0.431F);
		Leg2.addChild(bone7);
		setRotationAngle(bone7, 0.0F, 0.0F, -0.3491F);
		bone7.cubeList.add(new ModelBox(bone7, 9, 88, -4.2083F, -1.1523F, 0.23F, 4, 1, 1, 0.0F, false));

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(-23.8609F, 2.25F, -0.491F);
		Leg2.addChild(bone8);
		setRotationAngle(bone8, 0.0F, 0.0F, -0.0873F);
		bone8.cubeList.add(new ModelBox(bone8, 9, 88, -14.2083F, -1.1523F, 0.23F, 14, 1, 1, 0.0F, false));

		Leg3 = new ModelRenderer(this);
		Leg3.setRotationPoint(5.75F, 13.25F, -8.25F);
		setRotationAngle(Leg3, 0.0F, 2.3562F, 0.2618F);
		Leg3.cubeList.add(new ModelBox(Leg3, 5, 88, -21.0F, 0.0F, 0.0F, 19, 1, 1, 0.0F, false));
		Leg3.cubeList.add(new ModelBox(Leg3, 5, 88, -4.4181F, -1.25F, -0.9793F, 6, 3, 2, 0.0F, false));

		bone10 = new ModelRenderer(this);
		bone10.setRotationPoint(-20.2213F, 1.0F, -0.431F);
		Leg3.addChild(bone10);
		setRotationAngle(bone10, 0.0F, -0.5236F, -0.3491F);
		bone10.cubeList.add(new ModelBox(bone10, 5, 88, -4.2083F, -1.1523F, 0.23F, 4, 1, 1, 0.0F, false));

		bone11 = new ModelRenderer(this);
		bone11.setRotationPoint(-22.6234F, 2.25F, -1.7284F);
		Leg3.addChild(bone11);
		setRotationAngle(bone11, 0.0F, -0.6109F, -0.0873F);
		bone11.cubeList.add(new ModelBox(bone11, 5, 88, -14.2083F, -1.1523F, 0.23F, 14, 1, 1, 0.0F, false));

		Leg4 = new ModelRenderer(this);
		Leg4.setRotationPoint(-6.25F, 13.25F, -8.25F);
		setRotationAngle(Leg4, 0.0F, 0.7854F, -0.3491F);
		Leg4.cubeList.add(new ModelBox(Leg4, 6, 84, -21.0F, 0.0F, 0.0F, 19, 1, 1, 0.0F, false));
		Leg4.cubeList.add(new ModelBox(Leg4, 6, 84, -4.4181F, -1.25F, -0.9793F, 6, 3, 2, 0.0F, false));

		bone13 = new ModelRenderer(this);
		bone13.setRotationPoint(-20.2213F, 1.0F, -0.431F);
		Leg4.addChild(bone13);
		setRotationAngle(bone13, 0.0F, 0.2618F, -0.3491F);
		bone13.cubeList.add(new ModelBox(bone13, 6, 84, -4.2083F, -1.1523F, 0.23F, 4, 1, 1, 0.0F, false));

		bone14 = new ModelRenderer(this);
		bone14.setRotationPoint(-23.6841F, 2.25F, 0.3929F);
		Leg4.addChild(bone14);
		setRotationAngle(bone14, 0.0F, 0.6109F, -0.0873F);
		bone14.cubeList.add(new ModelBox(bone14, 6, 84, -14.2083F, -1.1523F, 0.23F, 14, 1, 1, 0.0F, false));

		Leg5 = new ModelRenderer(this);
		Leg5.setRotationPoint(-5.0F, 13.25F, -10.0F);
		setRotationAngle(Leg5, 0.0F, 0.0F, -0.2618F);
		Leg5.cubeList.add(new ModelBox(Leg5, 15, 101, -16.0F, 0.0F, 0.0F, 14, 1, 1, 0.0F, false));
		Leg5.cubeList.add(new ModelBox(Leg5, 15, 101, -4.4181F, -1.25F, -0.9793F, 6, 3, 2, 0.0F, false));

		bone16 = new ModelRenderer(this);
		bone16.setRotationPoint(-20.2213F, 1.0F, -0.431F);
		Leg5.addChild(bone16);
		setRotationAngle(bone16, 0.0F, 0.0F, -0.3491F);
		bone16.cubeList.add(new ModelBox(bone16, 15, 101, -4.5277F, 0.5578F, 0.6395F, 9, 1, 1, 0.0F, false));

		Leg6 = new ModelRenderer(this);
		Leg6.setRotationPoint(6.25F, 13.25F, -10.0F);
		setRotationAngle(Leg6, 0.0F, 3.1416F, 0.2618F);
		Leg6.cubeList.add(new ModelBox(Leg6, 7, 91, -16.0F, 0.0F, 0.0F, 14, 1, 1, 0.0F, false));
		Leg6.cubeList.add(new ModelBox(Leg6, 7, 91, -4.4181F, -1.25F, -0.9793F, 6, 3, 2, 0.0F, false));

		bone18 = new ModelRenderer(this);
		bone18.setRotationPoint(-20.2213F, 1.0F, -0.431F);
		Leg6.addChild(bone18);
		setRotationAngle(bone18, 0.0F, 0.0F, -0.3491F);
		bone18.cubeList.add(new ModelBox(bone18, 7, 91, -4.5277F, 0.5578F, 0.6395F, 9, 1, 1, 0.0F, false));

		Leg7 = new ModelRenderer(this);
		Leg7.setRotationPoint(6.25F, 17.75F, -12.0F);
		setRotationAngle(Leg7, 0.0F, -2.2689F, 0.0873F);
		Leg7.cubeList.add(new ModelBox(Leg7, 3, 89, -21.0F, 0.0F, 0.0F, 19, 1, 1, 0.0F, false));
		Leg7.cubeList.add(new ModelBox(Leg7, 3, 89, -4.4181F, -1.25F, -0.9793F, 6, 3, 5, 0.0F, false));

		bone20 = new ModelRenderer(this);
		bone20.setRotationPoint(-20.2213F, 1.0F, -0.431F);
		Leg7.addChild(bone20);
		setRotationAngle(bone20, 0.0F, 0.2618F, -0.3491F);
		bone20.cubeList.add(new ModelBox(bone20, 3, 89, -4.2083F, -1.1523F, 0.23F, 4, 1, 1, 0.0F, false));

		bone21 = new ModelRenderer(this);
		bone21.setRotationPoint(-23.6841F, 2.25F, 0.3929F);
		Leg7.addChild(bone21);
		setRotationAngle(bone21, 0.0F, 0.6109F, -0.0873F);
		bone21.cubeList.add(new ModelBox(bone21, 3, 89, -23.2083F, -1.1523F, 0.23F, 23, 1, 1, 0.0F, false));

		Leg8 = new ModelRenderer(this);
		Leg8.setRotationPoint(-6.75F, 18.5F, -11.25F);
		setRotationAngle(Leg8, 0.0F, -0.9599F, -0.0873F);
		Leg8.cubeList.add(new ModelBox(Leg8, 5, 88, -21.0F, 0.0F, 0.0F, 19, 1, 1, 0.0F, false));
		Leg8.cubeList.add(new ModelBox(Leg8, 5, 88, -4.4181F, -1.25F, -3.9793F, 6, 3, 5, 0.0F, false));

		bone23 = new ModelRenderer(this);
		bone23.setRotationPoint(-20.2213F, 1.0F, -0.431F);
		Leg8.addChild(bone23);
		setRotationAngle(bone23, 0.0F, -0.5236F, -0.3491F);
		bone23.cubeList.add(new ModelBox(bone23, 5, 88, -3.9842F, -1.1313F, 0.5027F, 4, 1, 1, 0.0F, false));

		bone24 = new ModelRenderer(this);
		bone24.setRotationPoint(-22.6234F, 2.25F, -1.7284F);
		Leg8.addChild(bone24);
		setRotationAngle(bone24, 0.0F, -0.5236F, -0.0873F);
		bone24.cubeList.add(new ModelBox(bone24, 5, 88, -22.2083F, -1.1523F, 0.23F, 22, 1, 1, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		Body.render(f5);
		Head.render(f5);
		Leg1.render(f5);
		Leg2.render(f5);
		Leg3.render(f5);
		Leg4.render(f5);
		Leg5.render(f5);
		Leg6.render(f5);
		Leg7.render(f5);
		Leg8.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}


	public void setLivingAnimations(EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4) {
		this.Leg1.rotateAngleZ = MathHelper.cos(par2 * 0.6662f) * 1.4f * par3 - 0.1832596f;
		this.Leg2.rotateAngleZ = MathHelper.cos(par2 * 0.6662f + 3.1415927f) * 1.4f * par3;
		this.Leg3.rotateAngleZ = MathHelper.cos(par2 * 0.6662f) * 1.4f * par3 - 0.1832596f;
		this.Leg4.rotateAngleZ = MathHelper.cos(par2 * 0.6662f + 3.1415927f) * 1.4f * par3;
		this.Leg5.rotateAngleZ = MathHelper.cos(par2 * 0.6662f) * 1.4f * par3 - 0.1832596f;
		this.Leg6.rotateAngleZ = MathHelper.cos(par2 * 0.6662f + 3.1415927f) * 1.4f * par3;
		this.Leg7.rotateAngleZ = MathHelper.cos(par2 * 0.6662f) * 1.4f * par3 - 0.1832596f;
		this.Leg8.rotateAngleZ = MathHelper.cos(par2 * 0.6662f + 3.1415927f) * 1.4f * par3;
	}

}