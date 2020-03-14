package io.github.blaezdev.rwbym.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.util.math.MathHelper;

public class ModelZwei extends ModelBase {
    ModelRenderer WolfHead;
    ModelRenderer Mane;
    ModelRenderer Leg1;
    ModelRenderer Leg2;
    ModelRenderer Leg3;
    ModelRenderer Leg4;
    ModelRenderer Tail;
    ModelRenderer Ear1;
    ModelRenderer Ear2;
    ModelRenderer Nose;

    public ModelZwei() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.WolfHead = new ModelRenderer(this, 0, 0);
        this.WolfHead.addBox(-3.0F, -3.0F, -2.0F, 6, 6, 4);
        this.WolfHead.setRotationPoint(-1.0F, 12.5F, -7.0F);
        this.WolfHead.setTextureSize(64, 32);
        this.WolfHead.mirror = true;
        this.setRotation(this.WolfHead, 0.0F, 0.0F, 0.0F);
        this.Mane = new ModelRenderer(this, 23, 0);
        this.Mane.addBox(-4.0F, -3.0F, -3.0F, 8, 15, 7);
        this.Mane.setRotationPoint(-1.0F, 14.0F, -3.0F);
        this.Mane.setTextureSize(64, 32);
        this.Mane.mirror = true;
        this.setRotation(this.Mane, 1.570796F, 0.0F, 0.0F);
        this.Leg1 = new ModelRenderer(this, 0, 18);
        this.Leg1.addBox(-2.0F, 0.0F, -2.0F, 3, 5, 3);
        this.Leg1.setRotationPoint(-2.5F, 16.0F, 7.0F);
        this.Leg1.setTextureSize(64, 32);
        this.Leg1.mirror = true;
        this.setRotation(this.Leg1, 0.0F, 0.0F, 0.0F);
        this.Leg2 = new ModelRenderer(this, 0, 18);
        this.Leg2.addBox(-1.0F, 0.0F, -2.0F, 3, 5, 3);
        this.Leg2.setRotationPoint(0.5F, 16.0F, 7.0F);
        this.Leg2.setTextureSize(64, 32);
        this.Leg2.mirror = true;
        this.setRotation(this.Leg2, 0.0F, 0.0F, 0.0F);
        this.Leg3 = new ModelRenderer(this, 0, 18);
        this.Leg3.addBox(-2.0F, 0.0F, -1.0F, 3, 5, 3);
        this.Leg3.setRotationPoint(-2.5F, 16.0F, -4.0F);
        this.Leg3.setTextureSize(64, 32);
        this.Leg3.mirror = true;
        this.setRotation(this.Leg3, 0.0F, 0.0F, 0.0F);
        this.Leg4 = new ModelRenderer(this, 0, 18);
        this.Leg4.addBox(-1.0F, 0.0F, -1.0F, 3, 5, 3);
        this.Leg4.setRotationPoint(0.5F, 16.0F, -4.0F);
        this.Leg4.setTextureSize(64, 32);
        this.Leg4.mirror = true;
        this.setRotation(this.Leg4, 0.0F, 0.0F, 0.0F);
        this.Tail = new ModelRenderer(this, 13, 18);
        this.Tail.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2);
        this.Tail.setRotationPoint(-1.0F, 12.0F, 8.0F);
        this.Tail.setTextureSize(64, 32);
        this.Tail.mirror = true;
        this.setRotation(this.Tail, 1.130069F, 0.0F, 0.0F);
        this.Ear1 = new ModelRenderer(this, 16, 14);
        this.Ear1.addBox(-3.0F, -5.0F, 0.0F, 2, 2, 1);
        this.Ear1.setRotationPoint(-1.0F, 12.5F, -7.0F);
        this.Ear1.setTextureSize(64, 32);
        this.Ear1.mirror = true;
        this.setRotation(this.Ear1, 0.0F, 0.0F, 0.0F);
        this.Ear2 = new ModelRenderer(this, 16, 14);
        this.Ear2.addBox(1.0F, -5.0F, 0.0F, 2, 2, 1);
        this.Ear2.setRotationPoint(-1.0F, 12.5F, -7.0F);
        this.Ear2.setTextureSize(64, 32);
        this.Ear2.mirror = true;
        this.setRotation(this.Ear2, 0.0F, 0.0F, 0.0F);
        this.Nose = new ModelRenderer(this, 0, 10);
        this.Nose.addBox(-2.0F, -1.0F, -5.0F, 3, 3, 4);
        this.Nose.setRotationPoint(-0.5F, 12.5F, -7.0F);
        this.Nose.setTextureSize(64, 32);
        this.Nose.mirror = true;
        this.setRotation(this.Nose, 0.1858931F, 0.0F, 0.0F);
    }

    public void render(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
        super.render(p_78088_1_, p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_);
        this.setRotationAngles(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);
        this.WolfHead.renderWithRotation(p_78088_7_);
        this.Nose.renderWithRotation(p_78088_7_);
        this.Ear1.renderWithRotation(p_78088_7_);
        this.Ear2.renderWithRotation(p_78088_7_);
        this.Leg1.render(p_78088_7_);
        this.Leg2.render(p_78088_7_);
        this.Leg3.render(p_78088_7_);
        this.Leg4.render(p_78088_7_);
        this.Tail.renderWithRotation(p_78088_7_);
        this.Mane.render(p_78088_7_);
    }

    public void setLivingAnimations(EntityLivingBase p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_) {
        EntityZwei entitywolf = (EntityZwei)p_78086_1_;
        if (entitywolf.isAngry()) {
            this.Tail.rotateAngleY = 0.0F;
        } else {
            this.Tail.rotateAngleY = MathHelper.cos(p_78086_2_ * 0.6662F) * 1.4F * p_78086_3_;
        }

        if (entitywolf.isSitting()) {
            this.Mane.setRotationPoint(-1.0F, 14.0F, -3.0F);
            this.Mane.rotateAngleX = 1.3962635F;
            this.Mane.rotateAngleY = 0.0F;
            this.Tail.setRotationPoint(-1.0F, 20.0F, 6.0F);
            this.Tail.rotateAngleX = 2.0F;
            this.Leg1.setRotationPoint(-2.5F, 21.0F, 2.0F);
            this.Leg1.rotateAngleX = 4.712389F;
            this.Leg2.setRotationPoint(0.5F, 22.0F, 2.0F);
            this.Leg2.rotateAngleX = 4.712389F;
            this.Leg3.rotateAngleX = 5.811947F;
            this.Leg3.setRotationPoint(-2.49F, 17.0F, -4.0F);
            this.Leg4.rotateAngleX = 5.811947F;
            this.Leg4.setRotationPoint(0.51F, 17.0F, -4.0F);
        } else {
            this.Mane.setRotationPoint(-1.0F, 14.0F, -3.0F);
            this.setRotation(this.Mane, 1.570796F, 0.0F, 0.0F);
            this.Leg1.setRotationPoint(-2.5F, 16.0F, 7.0F);
            this.setRotation(this.Leg1, 0.0F, 0.0F, 0.0F);
            this.Leg2.setRotationPoint(0.5F, 16.0F, 7.0F);
            this.setRotation(this.Leg2, 0.0F, 0.0F, 0.0F);
            this.Leg3.setRotationPoint(-2.5F, 16.0F, -4.0F);
            this.setRotation(this.Leg3, 0.0F, 0.0F, 0.0F);
            this.Leg4.setRotationPoint(0.5F, 16.0F, -4.0F);
            this.setRotation(this.Leg4, 0.0F, 0.0F, 0.0F);
            this.Tail.setRotationPoint(-1.0F, 12.0F, 8.0F);
            this.setRotation(this.Tail, 1.130069F, 0.0F, 0.0F);
        }

        this.Tail.setRotationPoint(-1.0F, 12.0F, 8.0F);
        this.Leg1.setRotationPoint(-2.5F, 16.0F, 7.0F);
        this.Leg2.setRotationPoint(0.5F, 16.0F, 7.0F);
        this.Leg3.setRotationPoint(-2.5F, 16.0F, -4.0F);
        this.Leg4.setRotationPoint(0.5F, 16.0F, -4.0F);
        this.Leg1.rotateAngleX = MathHelper.cos(p_78086_2_ * 0.6662F) * 1.4F * p_78086_3_;
        this.Leg2.rotateAngleX = MathHelper.cos(p_78086_2_ * 0.6662F + 3.1415927F) * 1.4F * p_78086_3_;
        this.Leg3.rotateAngleX = MathHelper.cos(p_78086_2_ * 0.6662F + 3.1415927F) * 1.4F * p_78086_3_;
        this.Leg4.rotateAngleX = MathHelper.cos(p_78086_2_ * 0.6662F) * 1.4F * p_78086_3_;
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
        super.setRotationAngles(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_, p_78087_7_);
        this.WolfHead.rotateAngleX = p_78087_5_ / 57.295776F;
        this.WolfHead.rotateAngleY = p_78087_4_ / 57.295776F;
        this.Nose.rotateAngleX = p_78087_5_ / 57.295776F;
        this.Nose.rotateAngleY = p_78087_4_ / 57.295776F;
        this.Ear1.rotateAngleX = p_78087_5_ / 57.295776F;
        this.Ear1.rotateAngleY = p_78087_4_ / 57.295776F;
        this.Ear2.rotateAngleX = p_78087_5_ / 57.295776F;
        this.Ear2.rotateAngleY = p_78087_4_ / 57.295776F;
    }
}
