package io.github.blaez-dev.rwbym.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelNeverMore extends ModelBase {
    public ModelRenderer Head;
    public ModelRenderer Body;
    public ModelRenderer tail;
    public ModelRenderer footright;
    public ModelRenderer footright2;
    public ModelRenderer footleft2;
    public ModelRenderer footright3;
    public ModelRenderer footleft;
    public ModelRenderer footleft3;
    public ModelRenderer headspike;
    public ModelRenderer beak2;
    public ModelRenderer beak;
    public ModelRenderer beak3;
    public ModelRenderer leftwing1;
    public ModelRenderer rightwing1;
    public ModelRenderer neck;
    public ModelRenderer leftwing2;
    public ModelRenderer rightwing2;

    public ModelNeverMore() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.beak = new ModelRenderer(this, 0, 24);
        this.beak.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.beak.addBox(-1.0F, -4.5F, 0.6F, 2, 5, 1, 0.0F);
        this.setRotateAngle(beak, 2.0032889154390916F, 0.0F, 0.0F);
        this.tail = new ModelRenderer(this, 0, 34);
        this.tail.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tail.addBox(-5.0F, 16.0F, 2.2F, 10, 17, 1, 0.0F);
        this.setRotateAngle(tail, 3.141592653589793F, 0.0F, 0.0F);
        this.neck = new ModelRenderer(this, 0, 16);
        this.neck.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.neck.addBox(-3.0F, 2.0F, -3.0F, 6, 2, 6, 0.0F);
        this.footright = new ModelRenderer(this, 0, 22);
        this.footright.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.footright.addBox(0.5F, -15.4F, -9.0F, 3, 3, 5, 0.0F);
        this.setRotateAngle(footright, -0.6373942428283291F, 0.0F, 0.0F);
        this.rightwing1 = new ModelRenderer(this, 42, 0);
        this.rightwing1.mirror = true;
        this.rightwing1.setRotationPoint(3.0F, 0.0F, 3.0F);
        this.rightwing1.addBox(2.0F, 1.0F, 1.5F, 10, 16, 1, 0.0F);
        this.setRotateAngle(rightwing1, -0.15707963267948966F, 1.2566370614359172F, 0.0F);
        this.beak2 = new ModelRenderer(this, 0, 24);
        this.beak2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.beak2.addBox(-1.0F, -3.8F, -2.4F, 2, 4, 1, 0.0F);
        this.setRotateAngle(beak2, 1.2747884856566583F, 0.0F, 0.0F);
        this.beak3 = new ModelRenderer(this, 0, 24);
        this.beak3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.beak3.addBox(-1.0F, 2.2F, -4.3F, 2, 1, 1, 0.0F);
        this.setRotateAngle(beak3, -0.36425021489121656F, 0.0F, 0.0F);
        this.leftwing2 = new ModelRenderer(this, 24, 16);
        this.leftwing2.setRotationPoint(-12.0F, 1.0F, 1.5F);
        this.leftwing2.addBox(-9.8F, 0.9F, -0.1F, 10, 12, 1, 0.0F);
        this.setRotateAngle(leftwing2, 0.0F, -1.7278759594743864F, 0.0F);
        this.headspike = new ModelRenderer(this, 24, 0);
        this.headspike.mirror = true;
        this.headspike.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headspike.addBox(-0.6F, -5.2F, -2.1F, 1, 4, 2, 0.0F);
        this.setRotateAngle(headspike, -0.6373942428283291F, 0.0F, 0.0F);
        this.footleft2 = new ModelRenderer(this, 0, 22);
        this.footleft2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.footleft2.addBox(-3.9F, -4.6F, 15.5F, 3, 3, 3, 0.0F);
        this.setRotateAngle(footleft2, 1.0927506446736497F, 0.0F, 0.0F);
        this.rightwing2 = new ModelRenderer(this, 24, 16);
        this.rightwing2.mirror = true;
        this.rightwing2.setRotationPoint(12.0F, 1.0F, 1.5F);
        this.rightwing2.addBox(-0.3F, 1.0F, 0.0F, 10, 12, 1, 0.0F);
        this.setRotateAngle(rightwing2, 0.0F, 1.7278759594743864F, 0.0F);
        this.footright3 = new ModelRenderer(this, 0, 55);
        this.footright3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.footright3.addBox(0.6F, -18.3F, 5.1F, 3, 2, 4, 0.0F);
        this.footleft = new ModelRenderer(this, 0, 22);
        this.footleft.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.footleft.addBox(-3.8F, -15.9F, -9.0F, 3, 3, 5, 0.0F);
        this.setRotateAngle(footleft, -0.6373942428283291F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 0, 16);
        this.Body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Body.addBox(-3.0F, 4.0F, -3.0F, 6, 12, 6, 0.0F);
        this.setRotateAngle(Body, 3.141592653589793F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.Head.addBox(-3.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
        this.setRotateAngle(Head, 0.0F, 3.141592653589793F, 3.141592653589793F);
        this.leftwing1 = new ModelRenderer(this, 42, 0);
        this.leftwing1.setRotationPoint(-3.0F, 0.0F, 3.0F);
        this.leftwing1.addBox(-12.0F, 1.0F, 1.5F, 10, 16, 1, 0.0F);
        this.setRotateAngle(leftwing1, -0.15707963267948966F, -1.2566370614359172F, 0.0F);
        this.footright2 = new ModelRenderer(this, 0, 22);
        this.footright2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.footright2.addBox(0.5F, -4.6F, 15.5F, 3, 3, 3, 0.0F);
        this.setRotateAngle(footright2, 1.0927506446736497F, 0.0F, 0.0F);
        this.footleft3 = new ModelRenderer(this, 0, 55);
        this.footleft3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.footleft3.addBox(-3.9F, -18.3F, 5.1F, 3, 2, 4, 0.0F);
        this.Head.addChild(this.beak);
        this.Body.addChild(this.neck);
        this.Body.addChild(this.rightwing1);
        this.Head.addChild(this.beak2);
        this.Head.addChild(this.beak3);
        this.leftwing1.addChild(this.leftwing2);
        this.Head.addChild(this.headspike);
        this.rightwing1.addChild(this.rightwing2);
        this.Body.addChild(this.leftwing1);
    }
    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Head.render(f5);
        this.footleft.render(f5);
        this.footleft2.render(f5);
        this.tail.render(f5);
        this.footright.render(f5);
        this.Body.render(f5);
        this.footright2.render(f5);
        this.footright3.render(f5);
        this.footleft3.render(f5);
    }



    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
    {
            this.Head.rotateAngleX = headPitch * 0.017453292F;
            this.Head.rotateAngleY = netHeadYaw * 0.017453292F;
            this.Head.rotateAngleZ = 0.0F;
            this.Head.setRotationPoint(0.0F, 0.0F, 0.0F);
            this.rightwing1.setRotationPoint(0.0F, 0.0F, 0.0F);
            this.leftwing1.setRotationPoint(0.0F, 0.0F, 0.0F);
            this.Body.rotateAngleX = ((float)Math.PI / 4F) + MathHelper.cos(ageInTicks * 0.1F) * 0.15F;
            this.Body.rotateAngleY = 0.0F;
            this.tail.rotateAngleX = ((float)Math.PI / 4F) + MathHelper.cos(ageInTicks * 0.1F) * 0.15F;
            this.tail.rotateAngleY = 0.0F;
            this.footleft.rotateAngleX = ((float)Math.PI / 0.95F) + MathHelper.cos(ageInTicks * 0.1F) * 0.15F;
            this.footleft.rotateAngleY = 0.0F;
            this.footleft2.rotateAngleX = ((float)Math.PI / 0.623F) + MathHelper.cos(ageInTicks * 0.1F) * 0.15F;
            this.footleft2.rotateAngleY = 0.0F;
            this.footleft3.rotateAngleX = ((float)Math.PI / 0.80F) + MathHelper.cos(ageInTicks * 0.1F) * 0.15F;
            this.footleft3.rotateAngleY = 0.0F;
            this.footright.rotateAngleX = ((float)Math.PI / 0.95F) + MathHelper.cos(ageInTicks * 0.1F) * 0.15F;
            this.footright.rotateAngleY = 0.0F;
            this.footright2.rotateAngleX = ((float)Math.PI / 0.623F) + MathHelper.cos(ageInTicks * 0.1F) * 0.15F;
            this.footright2.rotateAngleY = 0.0F;
            this.footright3.rotateAngleX = ((float)Math.PI / 0.80F) + MathHelper.cos(ageInTicks * 0.1F) * 0.15F;
            this.footright3.rotateAngleY = 0.0F;
            this.rightwing1.rotateAngleY = MathHelper.cos(ageInTicks * 0.4F) * (float)Math.PI * 0.25F;
            this.leftwing1.rotateAngleY = -this.rightwing1.rotateAngleY;
            this.rightwing2.rotateAngleY = this.rightwing1.rotateAngleY * 0.5F;
            this.leftwing2.rotateAngleY = -this.rightwing1.rotateAngleY * 0.5F;
    }
    
}
