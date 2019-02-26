package be.bluexin.rwbym.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;

public class ModelBoarbatusk extends ModelBase {
    public ModelRenderer tail;
    public ModelRenderer body2;
    public ModelRenderer body3;
    public ModelRenderer body;
    public ModelRenderer head;
    public ModelRenderer Shape9;
    public ModelRenderer leg3_2;
    public ModelRenderer leg4_1;
    public ModelRenderer leg4_2;
    public ModelRenderer Shape2;
    public ModelRenderer Shape1;
    public ModelRenderer head2;
    public ModelRenderer Shape4;
    public ModelRenderer head3;
    public ModelRenderer Shape3;
    public ModelRenderer Shape6;
    public ModelRenderer leg1_2;
    public ModelRenderer leg2_1;
    public ModelRenderer Shape5;
    public ModelRenderer leg3_1;
    public ModelRenderer leg2_2;
    public ModelRenderer Shape8;
    public ModelRenderer Shape7;
    public ModelRenderer leg1_1;

    public ModelBoarbatusk() {
        this.textureWidth = 64;
        this.textureHeight = 128;
        this.Shape2 = new ModelRenderer(this, 0, 17);
        this.Shape2.setRotationPoint(0.0F, 14.0F, -8.0F);
        this.Shape2.addBox(-2.200000047683716F, 2.0F, -8.5F, 1, 3, 1, 0.0F);
        this.head2 = new ModelRenderer(this, 0, 7);
        this.head2.setRotationPoint(0.0F, 14.0F, -8.0F);
        this.head2.addBox(-2.0F, -1.5F, -9.0F, 4, 4, 5, 0.0F);
        this.Shape6 = new ModelRenderer(this, 37, 16);
        this.Shape6.setRotationPoint(0.0F, 14.0F, -8.0F);
        this.Shape6.addBox(3.0F, -2.0F, -11.800000190734863F, 1, 3, 1, 0.0F);
        this.setRotateAngle(Shape6, -0.5948578119277954F, 0.0F, 0.1745329052209854F);
        this.leg3_1 = new ModelRenderer(this, 3, 38);
        this.leg3_1.setRotationPoint(-4.0F, 18.0F, -5.0F);
        this.leg3_1.addBox(-1.5F, 0.0F, -1.5F, 3, 6, 3, 0.0F);
        this.head = new ModelRenderer(this, 19, 0);
        this.head.setRotationPoint(0.0F, 14.0F, -8.0F);
        this.head.addBox(-4.0F, -5.0F, -4.0F, 8, 9, 4, 0.0F);
        this.Shape3 = new ModelRenderer(this, 44, 0);
        this.Shape3.setRotationPoint(0.0F, 14.0F, -8.0F);
        this.Shape3.addBox(-3.5F, 1.0F, -6.5F, 7, 1, 1, 0.0F);
        this.setRotateAngle(Shape3, 0.1745329052209854F, 0.0F, 0.0F);
        this.Shape1 = new ModelRenderer(this, 22, 17);
        this.Shape1.setRotationPoint(0.0F, 14.0F, -8.0F);
        this.Shape1.addBox(1.2000000476837158F, 2.0F, -8.5F, 1, 3, 1, 0.0F);
        this.leg2_1 = new ModelRenderer(this, 3, 38);
        this.leg2_1.setRotationPoint(3.5F, 18.0F, 6.5F);
        this.leg2_1.addBox(-1.5F, 0.0F, -1.5F, 3, 6, 3, 0.0F);
        this.leg3_2 = new ModelRenderer(this, 5, 27);
        this.leg3_2.setRotationPoint(-4.0F, 18.0F, -5.0F);
        this.leg3_2.addBox(-2.0F, -6.0F, -2.0F, 1, 6, 4, 0.0F);
        this.leg4_2 = new ModelRenderer(this, 5, 27);
        this.leg4_2.mirror = true;
        this.leg4_2.setRotationPoint(4.0F, 18.0F, -5.0F);
        this.leg4_2.addBox(1.0F, -6.0F, -2.0F, 1, 6, 4, 0.0F);
        this.head3 = new ModelRenderer(this, 0, 0);
        this.head3.setRotationPoint(0.0F, 14.0F, -6.0F);
        this.head3.addBox(-1.5F, 2.5F, -10.5F, 3, 1, 5, 0.0F);
        this.body = new ModelRenderer(this, 29, 26);
        this.body.setRotationPoint(0.5F, 11.0F, 3.0F);
        this.body.addBox(-5.0F, 0.0F, -7.0F, 9, 7, 8, 0.0F);
        this.setRotateAngle(body, 1.570796012878418F, 0.0F, 0.0F);
        this.leg4_1 = new ModelRenderer(this, 3, 38);
        this.leg4_1.setRotationPoint(4.0F, 18.0F, -5.0F);
        this.leg4_1.addBox(-1.5F, 0.0F, -1.5F, 3, 6, 3, 0.0F);
        this.leg1_2 = new ModelRenderer(this, 16, 25);
        this.leg1_2.setRotationPoint(-3.5F, 18.0F, 6.5F);
        this.leg1_2.addBox(-2.0F, -7.0F, -3.0F, 1, 7, 5, 0.0F);
        this.leg1_1 = new ModelRenderer(this, 3, 38);
        this.leg1_1.setRotationPoint(-3.5F, 18.0F, 6.5F);
        this.leg1_1.addBox(-1.5F, 0.0F, -1.5F, 3, 6, 3, 0.0F);
        this.leg2_2 = new ModelRenderer(this, 16, 25);
        this.leg2_2.mirror = true;
        this.leg2_2.setRotationPoint(3.5F, 18.0F, 6.5F);
        this.leg2_2.addBox(1.0F, -7.0F, -3.0F, 1, 7, 5, 0.0F);
        this.Shape8 = new ModelRenderer(this, 10, 17);
        this.Shape8.setRotationPoint(0.0F, 14.0F, -8.0F);
        this.Shape8.addBox(-4.0F, -7.699999809265137F, -9.199999809265137F, 1, 5, 1, 0.0F);
        this.setRotateAngle(Shape8, 0.1745329052209854F, 0.0F, -0.1745329052209854F);
        this.tail = new ModelRenderer(this, 0, 55);
        this.tail.setRotationPoint(-0.5F, 10.0F, 10.0F);
        this.tail.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 8, 0.0F);
        this.setRotateAngle(tail, -0.8726645708084108F, 0.0F, 0.0F);
        this.body2 = new ModelRenderer(this, 19, 42);
        this.body2.setRotationPoint(0.0F, 11.5F, 2.0F);
        this.body2.addBox(-5.0F, -10.0F, -7.0F, 10, 11, 11, 0.0F);
        this.setRotateAngle(body2, 1.570796012878418F, 0.0F, 0.0F);
        this.Shape7 = new ModelRenderer(this, 5, 17);
        this.Shape7.setRotationPoint(0.0F, 14.0F, -8.0F);
        this.Shape7.addBox(-4.0F, -7.5F, -6.0F, 1, 5, 1, 0.0F);
        this.setRotateAngle(Shape7, 0.7853981852531433F, 0.0F, -0.1745329052209854F);
        this.Shape4 = new ModelRenderer(this, 27, 17);
        this.Shape4.setRotationPoint(0.0F, 14.0F, -8.0F);
        this.Shape4.addBox(3.0F, -7.5F, -6.0F, 1, 5, 1, 0.0F);
        this.setRotateAngle(Shape4, 0.7853981852531433F, 0.0F, 0.1745329052209854F);
        this.body3 = new ModelRenderer(this, 0, 47);
        this.body3.setRotationPoint(0.5F, 11.0F, 3.0F);
        this.body3.addBox(-5.0F, -2.799999952316284F, 0.0F, 9, 3, 2, 0.0F);
        this.setRotateAngle(body3, 0.6108651757240294F, 0.0F, 0.0F);
        this.Shape5 = new ModelRenderer(this, 32, 16);
        this.Shape5.setRotationPoint(0.0F, 14.0F, -8.0F);
        this.Shape5.addBox(3.0F, -7.699999809265137F, -9.199999809265137F, 1, 5, 1, 0.0F);
        this.setRotateAngle(Shape5, 0.1745329052209854F, 0.0F, 0.1745329052209854F);
        this.Shape9 = new ModelRenderer(this, 15, 17);
        this.Shape9.setRotationPoint(0.0F, 14.0F, -8.0F);
        this.Shape9.addBox(-4.0F, -2.0F, -11.800000190734863F, 1, 3, 1, 0.0F);
        this.setRotateAngle(Shape9, -0.5948578119277954F, 0.0F, -0.1745329052209854F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Shape2.render(f5);
        this.head2.render(f5);
        this.Shape6.render(f5);
        this.leg3_1.render(f5);
        this.head.render(f5);
        this.Shape3.render(f5);
        this.Shape1.render(f5);
        this.leg2_1.render(f5);
        this.leg3_2.render(f5);
        this.leg4_2.render(f5);
        this.head3.render(f5);
        this.body.render(f5);
        this.leg4_1.render(f5);
        this.leg1_2.render(f5);
        this.leg1_1.render(f5);
        this.leg2_2.render(f5);
        this.Shape8.render(f5);
        this.tail.render(f5);
        this.body2.render(f5);
        this.Shape7.render(f5);
        this.Shape4.render(f5);
        this.body3.render(f5);
        this.Shape5.render(f5);
        this.Shape9.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    public void setLivingAnimations(EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4) {
        this.leg1_1.rotateAngleX = MathHelper.cos(par2 * 0.6662f) * 1.4f * par3;
        this.leg2_1.rotateAngleX = MathHelper.cos(par2 * 0.6662f + 3.1415927f) * 1.4f * par3;
        this.leg4_1.rotateAngleX = MathHelper.cos(par2 * 0.6662f) * 1.4f * par3;
        this.leg3_1.rotateAngleX = MathHelper.cos(par2 * 0.6662f + 3.1415927f) * 1.4f * par3;
    }
}
