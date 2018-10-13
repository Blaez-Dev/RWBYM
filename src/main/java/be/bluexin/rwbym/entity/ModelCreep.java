package be.bluexin.rwbym.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;

public class ModelCreep extends ModelBase {
    public ModelRenderer torso;
    public ModelRenderer torso_1;
    public ModelRenderer head;
    public ModelRenderer torso_2;
    public ModelRenderer torso_3;
    public ModelRenderer torso_4;
    public ModelRenderer torso_5;
    public ModelRenderer torso_6;
    public ModelRenderer torso_7;
    public ModelRenderer torso_8;
    public ModelRenderer torso_9;
    public ModelRenderer legleft1;
    public ModelRenderer legright1;
    public ModelRenderer legleft4;
    public ModelRenderer legright4;
    public ModelRenderer legright2;
    public ModelRenderer legleft2;
    public ModelRenderer torso_10;
    public ModelRenderer legright5;
    public ModelRenderer legleft5;
    public ModelRenderer torso_11;
    public ModelRenderer torso_12;
    public ModelRenderer torso_13;
    public ModelRenderer torso_14;
    public ModelRenderer torso_15;
    public ModelRenderer torso_16;
    public ModelRenderer torso_17;
    public ModelRenderer torso_18;
    public ModelRenderer legright3;
    public ModelRenderer legleft3;

    public ModelCreep() {
        this.textureWidth = 64;
        this.textureHeight = 128;
        this.torso_1 = new ModelRenderer(this, 16, 16);
        this.torso_1.setRotationPoint(-0.5F, 1.5F, 7.0F);
        this.torso_1.addBox(-0.4F, 17.6F, 8.2F, 1, 3, 5, 0.0F);
        this.setRotateAngle(torso_1, 0.31869712141416456F, 0.0F, 0.0F);
        this.torso_2 = new ModelRenderer(this, 16, 16);
        this.torso_2.setRotationPoint(-0.5F, 1.4F, 6.9F);
        this.torso_2.addBox(-3.1F, 0.0F, 4.1F, 6, 8, 5, 0.0F);
        this.setRotateAngle(torso_2, -0.7285004297824331F, 0.0F, 0.0F);
        this.legright1 = new ModelRenderer(this, 0, 16);
        this.legright1.setRotationPoint(-1.9F, 6.0F, 0.1F);
        this.legright1.addBox(-2.5F, -0.1F, -1.0F, 5, 7, 9, 0.1F);
        this.setRotateAngle(legright1, 0.0F, 0.0F, 1.2292353921796064F);
        this.torso_5 = new ModelRenderer(this, 16, 16);
        this.torso_5.setRotationPoint(-0.5F, 1.5F, 7.0F);
        this.torso_5.addBox(-1.4F, 1.9F, 9.1F, 3, 4, 5, 0.0F);
        this.setRotateAngle(torso_5, -0.8651597102135892F, 0.0F, 0.0F);
        this.torso_7 = new ModelRenderer(this, 16, 16);
        this.torso_7.setRotationPoint(-0.5F, 1.5F, 7.0F);
        this.torso_7.addBox(-1.4F, 12.0F, 10.8F, 3, 4, 5, 0.0F);
        this.setRotateAngle(torso_7, -0.091106186954104F, 0.0F, 0.0F);
        this.torso_10 = new ModelRenderer(this, 10, 88);
        this.torso_10.setRotationPoint(0.1F, 1.7F, -13.3F);
        this.torso_10.addBox(-1.5F, -4.1F, 31.7F, 2, 5, 2, 0.0F);
        this.setRotateAngle(torso_10, -0.4553564018453205F, 0.0F, 0.0F);
        this.legright5 = new ModelRenderer(this, 0, 16);
        this.legright5.setRotationPoint(-1.9F, 6.0F, 0.3F);
        this.legright5.addBox(-2.4F, 1.1F, 14.4F, 10, 5, 2, 0.0F);
        this.setRotateAngle(legright5, -0.9557422983920949F, 0.0F, 1.2292353921796064F);
        this.legleft5 = new ModelRenderer(this, 0, 16);
        this.legleft5.mirror = true;
        this.legleft5.setRotationPoint(2.0F, 6.0F, 0.3F);
        this.legleft5.addBox(-8.0F, 1.1F, 14.8F, 10, 5, 2, 0.0F);
        this.setRotateAngle(legleft5, -0.9560913642424937F, 0.0F, -1.2274900629276118F);
        this.torso_15 = new ModelRenderer(this, 10, 88);
        this.torso_15.setRotationPoint(0.1F, 1.7F, -13.3F);
        this.torso_15.addBox(-1.3F, -3.7F, 13.7F, 2, 5, 2, 0.0F);
        this.torso_13 = new ModelRenderer(this, 10, 88);
        this.torso_13.setRotationPoint(0.1F, 1.7F, -13.3F);
        this.torso_13.addBox(-1.3F, -3.7F, 4.3F, 2, 5, 2, 0.0F);
        this.torso_17 = new ModelRenderer(this, 10, 88);
        this.torso_17.setRotationPoint(0.1F, 1.7F, -13.3F);
        this.torso_17.addBox(-1.6F, -16.1F, 20.6F, 2, 5, 2, 0.0F);
        this.setRotateAngle(torso_17, -0.7285004297824331F, 0.0F, 0.0F);
        this.legright2 = new ModelRenderer(this, 0, 16);
        this.legright2.setRotationPoint(-1.9F, 6.0F, 0.3F);
        this.legright2.addBox(-1.5F, -2.6F, 5.7F, 4, 7, 8, 0.0F);
        this.setRotateAngle(legright2, -0.9557422983920949F, 0.0F, 1.2292353921796064F);
        this.torso = new ModelRenderer(this, 16, 16);
        this.torso.setRotationPoint(-0.5F, 0.2F, -7.0F);
        this.torso.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 14, 0.0F);
        this.legleft1 = new ModelRenderer(this, 0, 16);
        this.legleft1.mirror = true;
        this.legleft1.setRotationPoint(2.0F, 6.0F, 0.1F);
        this.legleft1.addBox(-2.5F, 0.0F, -1.0F, 5, 7, 9, 0.0F);
        this.setRotateAngle(legleft1, -0.0F, 0.0F, -1.2292353921796064F);
        this.torso_4 = new ModelRenderer(this, 16, 16);
        this.torso_4.setRotationPoint(-0.5F, 1.5F, 7.0F);
        this.torso_4.addBox(-1.5F, -7.7F, 8.0F, 3, 6, 3, 0.0F);
        this.setRotateAngle(torso_4, -1.6390387005478748F, 0.0F, 0.0F);
        this.torso_18 = new ModelRenderer(this, 10, 88);
        this.torso_18.setRotationPoint(0.1F, 1.7F, -13.3F);
        this.torso_18.addBox(-1.5F, -13.7F, 25.5F, 2, 5, 2, 0.0F);
        this.setRotateAngle(torso_18, -0.7285004297824331F, 0.0F, 0.0F);
        this.legright3 = new ModelRenderer(this, 0, 16);
        this.legright3.setRotationPoint(-1.9F, 6.0F, 0.3F);
        this.legright3.addBox(1.4F, 1.0F, 11.5F, 10, 5, 5, 0.0F);
        this.setRotateAngle(legright3, -0.9557422983920949F, 0.0F, 1.2292353921796064F);
        this.head = new ModelRenderer(this, 33, 88);
        this.head.setRotationPoint(0.1F, 2.7F, -13.3F);
        this.head.addBox(-4.0F, 0.0F, -8.9F, 7, 6, 7, 0.0F);
        this.setRotateAngle(head, 0.5462880558742251F, 0.0F, 0.0F);
        this.torso_3 = new ModelRenderer(this, 16, 16);
        this.torso_3.setRotationPoint(-0.5F, 1.7F, 7.0F);
        this.torso_3.addBox(-1.5F, -1.3F, 8.4F, 3, 6, 3, 0.0F);
        this.setRotateAngle(torso_3, -1.0016444577195458F, 0.0F, 0.0F);
        this.legleft2 = new ModelRenderer(this, 0, 16);
        this.legleft2.mirror = true;
        this.legleft2.setRotationPoint(2.0F, 6.0F, 0.3F);
        this.legleft2.addBox(-2.5F, -2.6F, 5.6F, 4, 7, 8, 0.0F);
        this.setRotateAngle(legleft2, -0.9560913642424937F, 0.0F, -1.2274900629276118F);
        this.torso_11 = new ModelRenderer(this, 44, 44);
        this.torso_11.setRotationPoint(0.1F, 2.7F, -13.3F);
        this.torso_11.addBox(-4.0F, 0.0F, -2.0F, 7, 11, 7, 0.0F);
        this.setRotateAngle(torso_11, 0.5462880558742251F, 0.0F, 0.0F);
        this.torso_16 = new ModelRenderer(this, 10, 88);
        this.torso_16.setRotationPoint(0.1F, 1.7F, -13.3F);
        this.torso_16.addBox(-1.3F, -10.4F, 18.0F, 2, 5, 2, 0.0F);
        this.setRotateAngle(torso_16, -0.40980330836826856F, 0.0F, 0.0F);
        this.torso_12 = new ModelRenderer(this, 10, 88);
        this.torso_12.setRotationPoint(0.1F, 2.7F, -13.3F);
        this.torso_12.addBox(-1.3F, -2.8F, -0.3F, 2, 5, 2, 0.0F);
        this.setRotateAngle(torso_12, 0.5462880558742251F, 0.0F, 0.0F);
        this.torso_14 = new ModelRenderer(this, 10, 88);
        this.torso_14.setRotationPoint(0.1F, 1.7F, -13.3F);
        this.torso_14.addBox(-1.3F, -2.9F, 9.0F, 2, 5, 2, 0.0F);
        this.legleft3 = new ModelRenderer(this, 0, 16);
        this.legleft3.mirror = true;
        this.legleft3.setRotationPoint(2.0F, 6.0F, 0.3F);
        this.legleft3.addBox(-11.4F, 1.1F, 11.9F, 10, 5, 5, 0.0F);
        this.setRotateAngle(legleft3, -0.9560913642424937F, 0.0F, -1.2274900629276118F);
        this.torso_6 = new ModelRenderer(this, 16, 16);
        this.torso_6.setRotationPoint(-0.5F, 1.5F, 7.0F);
        this.torso_6.addBox(-1.4F, 6.4F, 11.2F, 3, 4, 5, 0.0F);
        this.setRotateAngle(torso_6, -0.5009094953223726F, 0.0F, 0.0F);
        this.legleft4 = new ModelRenderer(this, 0, 16);
        this.legleft4.mirror = true;
        this.legleft4.setRotationPoint(2.0F, 6.0F, 0.3F);
        this.legleft4.addBox(-11.4F, 3.1F, 12.0F, 2, 5, 5, 0.0F);
        this.setRotateAngle(legleft4, -0.9560913642424937F, 0.0F, -1.2274900629276118F);
        this.torso_8 = new ModelRenderer(this, 16, 16);
        this.torso_8.setRotationPoint(-0.5F, 1.4F, 6.9F);
        this.torso_8.addBox(-4.0F, 0.0F, -2.0F, 8, 10, 7, 0.0F);
        this.setRotateAngle(torso_8, -0.5462880558742251F, 0.0F, 0.0F);
        this.torso_9 = new ModelRenderer(this, 44, 44);
        this.torso_9.setRotationPoint(0.1F, 2.7F, -13.3F);
        this.torso_9.addBox(-4.0F, 6.0F, -7.9F, 7, 2, 7, 0.0F);
        this.setRotateAngle(torso_9, 0.5462880558742251F, 0.0F, 0.0F);
        this.legright4 = new ModelRenderer(this, 0, 16);
        this.legright4.setRotationPoint(-1.9F, 6.0F, 0.3F);
        this.legright4.addBox(9.3F, 3.4F, 11.5F, 2, 5, 5, 0.0F);
        this.setRotateAngle(legright4, -0.9557422983920949F, 0.0F, 1.2292353921796064F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.torso_1.render(f5);
        this.torso_2.render(f5);
        this.legright1.render(f5);
        this.torso_5.render(f5);
        this.torso_7.render(f5);
        this.torso_10.render(f5);
        this.legright5.render(f5);
        this.legleft5.render(f5);
        this.torso_15.render(f5);
        this.torso_13.render(f5);
        this.torso_17.render(f5);
        this.legright2.render(f5);
        this.torso.render(f5);
        this.legleft1.render(f5);
        this.torso_4.render(f5);
        this.torso_18.render(f5);
        this.legright3.render(f5);
        this.head.render(f5);
        this.torso_3.render(f5);
        this.legleft2.render(f5);
        this.torso_11.render(f5);
        this.torso_16.render(f5);
        this.torso_12.render(f5);
        this.torso_14.render(f5);
        this.legleft3.render(f5);
        this.torso_6.render(f5);
        this.legleft4.render(f5);
        this.torso_8.render(f5);
        this.torso_9.render(f5);
        this.legright4.render(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }


    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
    {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        float f = -14.0F;
        this.legright1.rotateAngleX -= 0.0F;
        this.legleft1.rotateAngleX -= 0.0F;
        this.legright2.rotateAngleX -= 0.0F;
        this.legleft2.rotateAngleX -= 0.0F;
        this.legright3.rotateAngleX -= 0.0F;
        this.legleft3.rotateAngleX -= 0.0F;
        this.legright4.rotateAngleX -= 0.0F;
        this.legleft4.rotateAngleX -= 0.0F;
        this.legright5.rotateAngleX -= 0.0F;
        this.legleft5.rotateAngleX -= 0.0F;
        this.legright1.rotateAngleX = (float)((double)this.legright1.rotateAngleX * 0.5D);
        this.legleft1.rotateAngleX = (float)((double)this.legleft1.rotateAngleX * 0.5D);
        this.legright2.rotateAngleX = (float)((double)this.legright2.rotateAngleX * 0.5D);
        this.legleft2.rotateAngleX = (float)((double)this.legleft2.rotateAngleX * 0.5D);
        this.legright3.rotateAngleX = (float)((double)this.legright3.rotateAngleX * 0.5D);
        this.legleft3.rotateAngleX = (float)((double)this.legleft3.rotateAngleX * 0.5D);
        this.legright4.rotateAngleX = (float)((double)this.legright4.rotateAngleX * 0.5D);
        this.legleft4.rotateAngleX = (float)((double)this.legleft4.rotateAngleX * 0.5D);
        this.legright5.rotateAngleX = (float)((double)this.legright5.rotateAngleX * 0.5D);
        this.legleft5.rotateAngleX = (float)((double)this.legleft5.rotateAngleX * 0.5D);
        float f1 = 0.4F;

        if (this.legright1.rotateAngleX > 0.4F)
        {
            this.legright1.rotateAngleX = 0.4F;
        }
        if (this.legright2.rotateAngleX > 0.4F)
        {
            this.legright2.rotateAngleX = 0.4F;
        }
        if (this.legright3.rotateAngleX > 0.4F)
        {
            this.legright3.rotateAngleX = 0.4F;
        }
        if (this.legright4.rotateAngleX > 0.4F)
        {
            this.legright4.rotateAngleX = 0.4F;
        }
        if (this.legright5.rotateAngleX > 0.4F)
        {
            this.legright5.rotateAngleX = 0.4F;
        }

        if (this.legleft1.rotateAngleX > 0.4F)
        {
            this.legleft1.rotateAngleX = 0.4F;
        }
        if (this.legleft2.rotateAngleX > 0.4F)
        {
            this.legleft2.rotateAngleX = 0.4F;
        }if (this.legleft3.rotateAngleX > 0.4F)
    {
        this.legleft3.rotateAngleX = 0.4F;
    }if (this.legleft4.rotateAngleX > 0.4F)
    {
        this.legleft4.rotateAngleX = 0.4F;
    }if (this.legleft5.rotateAngleX > 0.4F)
    {
        this.legleft5.rotateAngleX = 0.4F;
    }
        if (this.legright1.rotateAngleX < -0.4F)
        {
            this.legright1.rotateAngleX = -0.4F;
        }if (this.legright2.rotateAngleX < -0.4F)
    {
        this.legright2.rotateAngleX = -0.4F;
    }if (this.legright3.rotateAngleX < -0.4F)
    {
        this.legright3.rotateAngleX = -0.4F;
    }if (this.legright4.rotateAngleX < -0.4F)
    {
        this.legright4.rotateAngleX = -0.4F;
    }if (this.legright5.rotateAngleX < -0.4F)
    {
        this.legright5.rotateAngleX = -0.4F;
    }

        if (this.legleft1.rotateAngleX < -0.4F)
        {
            this.legleft1.rotateAngleX = -0.4F;
        }if (this.legleft2.rotateAngleX < -0.4F)
    {
        this.legleft2.rotateAngleX = -0.4F;
    }if (this.legleft3.rotateAngleX < -0.4F)
    {
        this.legleft3.rotateAngleX = -0.4F;
    }if (this.legleft4.rotateAngleX < -0.4F)
    {
        this.legleft4.rotateAngleX = -0.4F;
    }if (this.legleft5.rotateAngleX < -0.4F)
    {
        this.legleft5.rotateAngleX = -0.4F;
    }


        this.legright1.rotationPointZ = 0.0F;
        this.legright2.rotationPointZ = 0.0F;
        this.legright3.rotationPointZ = 0.0F;
        this.legright4.rotationPointZ = 0.0F;
        this.legright5.rotationPointZ = 0.0F;
        this.legleft1.rotationPointZ = 0.0F;
        this.legleft2.rotationPointZ = 0.0F;
        this.legleft3.rotationPointZ = 0.0F;
        this.legleft4.rotationPointZ = 0.0F;
        this.legleft5.rotationPointZ = 0.0F;
        this.legright1.rotationPointY = -5.0F;
        this.legright2.rotationPointY = -5.0F;
        this.legright3.rotationPointY = -5.0F;
        this.legright4.rotationPointY = -5.0F;
        this.legright5.rotationPointY = -5.0F;
        this.legleft1.rotationPointY = -5.0F;
        this.legleft2.rotationPointY = -5.0F;
        this.legleft3.rotationPointY = -5.0F;
        this.legleft4.rotationPointY = -5.0F;
        this.legleft5.rotationPointY = -5.0F;}
}