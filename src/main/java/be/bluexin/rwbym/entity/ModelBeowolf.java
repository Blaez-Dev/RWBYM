package be.bluexin.rwbym.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;

public class ModelBeowolf extends ModelBase {

    //fields
    ModelRenderer Body1;
    ModelRenderer Body2;
    ModelRenderer Shape3;
    ModelRenderer Tail;
    ModelRenderer Head1;
    ModelRenderer Head3;
    ModelRenderer Head4;
    ModelRenderer Head2;
    ModelRenderer ArmR1;
    ModelRenderer ArmR2;
    ModelRenderer ArmL2;
    ModelRenderer ArmL1;
    ModelRenderer LegL3;
    ModelRenderer LegL1;
    ModelRenderer LegL2;
    ModelRenderer LegR3;
    ModelRenderer LegR2;
    ModelRenderer LegR1;

    public ModelBeowolf() {
        textureWidth = 64;
        textureHeight = 64;

        Body1 = new ModelRenderer(this, 0, 32);
        Body1.addBox(-4.5F, 0F, 0F, 9, 12, 7);
        Body1.setRotationPoint(-0.5F, 5F, -6F);
        Body1.setTextureSize(64, 64);
        Body1.mirror = true;
        setRotation(Body1, 0.8922867F, 0F, 0F);

        Body2 = new ModelRenderer(this, 0, 19);
        Body2.addBox(-2.5F, 0F, 0F, 5, 6, 7);
        Body2.setRotationPoint(-0.5F, 7F, 5F);
        Body2.setTextureSize(64, 64);
        Body2.mirror = true;
        setRotation(Body2, -0.2974289F, 0F, 0F);

        Shape3 = new ModelRenderer(this, 44, 22);
        Shape3.addBox(-1.5F, -1F, 0F, 3, 4, 7);
        Shape3.setRotationPoint(-0.5F, 9F, 10F);
        Shape3.setTextureSize(64, 64);
        Shape3.mirror = true;
        setRotation(Shape3, 0.3717861F, 0F, 0F);

        Tail = new ModelRenderer(this, 0, 51);
        Tail.addBox(-3.5F, 0F, 0F, 7, 8, 5);
        Tail.setRotationPoint(-0.5F, 0F, -6F);
        Tail.setTextureSize(64, 64);
        Tail.mirror = true;
        setRotation(Tail, 0F, 0F, 0F);

        Head1 = new ModelRenderer(this, 50, 46);
        Head1.addBox(-1.5F, 2F, -9F, 3, 3, 4);
        Head1.setRotationPoint(-0.5F, 0F, -7F);
        Head1.setTextureSize(64, 64);
        Head1.mirror = true;
        setRotation(Head1, 0.4089647F, 0F, 0F);

        Head3 = new ModelRenderer(this, 42, 53);
        Head3.addBox(-2.5F, 0F, -5F, 5, 5, 6);
        Head3.setRotationPoint(-0.5F, 0F, -7F);
        Head3.setTextureSize(64, 64);
        Head3.mirror = true;
        setRotation(Head3, 0.4089647F, 0F, 0F);

        Head4 = new ModelRenderer(this, 34, 53);
        Head4.addBox(-2.5F, -3F, 0F, 2, 3, 1);
        Head4.setRotationPoint(-0.5F, 0F, -7F);
        Head4.setTextureSize(64, 64);
        Head4.mirror = true;
        setRotation(Head4, 0F, 0F, -0.4089647F);

        Head2 = new ModelRenderer(this, 34, 53);
        Head2.addBox(0.5F, -3F, 0F, 2, 3, 1);
        Head2.setRotationPoint(-0.5F, 0F, -7F);
        Head2.setTextureSize(64, 64);
        Head2.mirror = true;
        setRotation(Head2, 0F, 0F, 0.4089656F);

        ArmR1 = new ModelRenderer(this, 46, 0);
        ArmR1.addBox(5F, 0.5F, -2.5F, 5, 12, 4);
        ArmR1.setRotationPoint(-4F, 4F, -3F);
        ArmR1.setTextureSize(64, 64);
        ArmR1.mirror = true;
        setRotation(ArmR1, 0.5576851F, 2.96706F, 0.260246F);


        ArmR2 = new ModelRenderer(this, 42, 16);
        ArmR2.addBox(0F, -1.5F, -1.5F, 8, 3, 3);
        ArmR2.setRotationPoint(-4F, 4F, -3F);
        ArmR2.setTextureSize(64, 64);
        ArmR2.mirror = true;
        setRotation(ArmR2, 0F, 2.845602F, 0.4461411F);


        ArmL2 = new ModelRenderer(this, 42, 16);
        ArmL2.addBox(0F, -1.5F, -1.5F, 8, 3, 3);
        ArmL2.setRotationPoint(3F, 4F, -3F);
        ArmL2.setTextureSize(64, 64);
        ArmL2.mirror = true;
        setRotation(ArmL2, 0F, 0.2974289F, 0.4461433F);

        ArmL1 = new ModelRenderer(this, 46, 0);
        ArmL1.addBox(5F, 0.5F, -1.5F, 5, 12, 4);
        ArmL1.setRotationPoint(3F, 4F, -3F);
        ArmL1.setTextureSize(64, 64);
        ArmL1.mirror = true;
        setRotation(ArmL1, -0.5576792F, 0.1858931F, 0.2602503F);


        LegL3 = new ModelRenderer(this, 0, 0);
        LegL3.addBox(0F, 7F, -8F, 3, 2, 3);
        LegL3.setRotationPoint(2F, 10F, 9F);
        LegL3.setTextureSize(64, 64);
        LegL3.mirror = true;
        setRotation(LegL3, 0F, -0.2230705F, 0F);
        LegL3.mirror = false;


        LegL1 = new ModelRenderer(this, 28, 0);
        LegL1.addBox(0F, -2F, -6F, 3, 4, 6);
        LegL1.setRotationPoint(2F, 10F, 9F);
        LegL1.setTextureSize(64, 64);
        LegL1.mirror = true;
        setRotation(LegL1, 0.4833166F, -0.2230705F, 0F);
        LegL1.mirror = false;

        LegL2 = new ModelRenderer(this, 16, 0);
        LegL2.addBox(0F, -2F, -9F, 3, 7, 3);
        LegL2.setRotationPoint(2F, 10F, 9F);
        LegL2.setTextureSize(64, 64);
        LegL2.mirror = true;
        setRotation(LegL2, 0.4833219F, -0.2230705F, 0F);
        LegL2.mirror = false;

        LegR3 = new ModelRenderer(this, 0, 0);
        LegR3.addBox(-3F, 7F, -8F, 3, 2, 3);
        LegR3.setRotationPoint(-3F, 10F, 9F);
        LegR3.setTextureSize(64, 64);
        LegR3.mirror = true;
        setRotation(LegR3, 0F, 0.2230717F, 0F);

        LegR2 = new ModelRenderer(this, 16, 0);
        LegR2.addBox(-3F, -2F, -9F, 3, 7, 3);
        LegR2.setRotationPoint(-3F, 10F, 9F);
        LegR2.setTextureSize(64, 64);
        LegR2.mirror = true;
        setRotation(LegR2, 0.4833219F, 0.2230717F, 0F);

        LegR1 = new ModelRenderer(this, 28, 0);
        LegR1.addBox(-3F, -2F, -6F, 3, 4, 6);
        LegR1.setRotationPoint(-3F, 10F, 9F);
        LegR1.setTextureSize(64, 64);
        LegR1.mirror = true;
        setRotation(LegR1, 0.4833219F, 0.2230717F, 0F);
    }


    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
        super.render(par1Entity, par2, par3, par4, par5, par6, par7);

        Body1.renderWithRotation(par7);
        Body2.renderWithRotation(par7);
        Shape3.renderWithRotation(par7);
        Tail.renderWithRotation(par7);
        Head1.renderWithRotation(par7);
        Head3.renderWithRotation(par7);
        Head4.renderWithRotation(par7);
        Head2.renderWithRotation(par7);
        ArmR1.renderWithRotation(par7);
        ArmR2.renderWithRotation(par7);
        ArmL2.renderWithRotation(par7);
        ArmL1.renderWithRotation(par7);
        LegL3.renderWithRotation(par7);
        LegL1.renderWithRotation(par7);
        LegL2.renderWithRotation(par7);
        LegR3.renderWithRotation(par7);
        LegR2.renderWithRotation(par7);
        LegR1.renderWithRotation(par7);


    }


    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    /**
     * Used for easily adding entity-dependent animations. The second and third float params here are the same second
     * and third as in the setRotationAngles method.
     */
    public void setLivingAnimations(EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4) {


        this.LegR1.rotateAngleX = MathHelper.cos(par2 * 0.6662F) * 1.4F * par3 + 0.4833166F;
        this.LegR2.rotateAngleX = MathHelper.cos(par2 * 0.6662F) * 1.4F * par3 + 0.4833219F;
        this.LegR3.rotateAngleX = MathHelper.cos(par2 * 0.6662F) * 1.4F * par3;

        this.LegL1.rotateAngleX = MathHelper.cos(par2 * 0.6662F + (float) Math.PI) * 1.4F * par3 + 0.4833166F;
        this.LegL2.rotateAngleX = MathHelper.cos(par2 * 0.6662F + (float) Math.PI) * 1.4F * par3 + 0.4833219F;
        this.LegL3.rotateAngleX = MathHelper.cos(par2 * 0.6662F + (float) Math.PI) * 1.4F * par3;


        this.ArmR1.rotateAngleX = MathHelper.cos(par2 * 0.6662F + (float) Math.PI) * 1.4F * par3;
        this.ArmR2.rotateAngleX = MathHelper.cos(par2 * 0.6662F + (float) Math.PI) * 1.4F * par3;


        this.ArmL1.rotateAngleX = MathHelper.cos(par2 * 0.6662F) * 1.4F * par3;
        this.ArmL2.rotateAngleX = MathHelper.cos(par2 * 0.6662F) * 1.4F * par3;


    }

    /**
     * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
     * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
     * "far" arms and legs can swing at most.
     */
    public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
        super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);

        this.Head1.rotateAngleX = par5 / (180F / (float) Math.PI);
        this.Head1.rotateAngleY = par4 / (180F / (float) Math.PI);
        this.Head2.rotateAngleX = par5 / (180F / (float) Math.PI);
        this.Head2.rotateAngleY = par4 / (180F / (float) Math.PI);
        this.Head3.rotateAngleX = par5 / (180F / (float) Math.PI);
        this.Head3.rotateAngleY = par4 / (180F / (float) Math.PI);
        this.Head4.rotateAngleX = par5 / (180F / (float) Math.PI);
        this.Head4.rotateAngleY = par4 / (180F / (float) Math.PI);
    }
}

