package io.github.blaezdev.rwbym.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelGeist extends ModelBase {
    private final ModelRenderer bone12;
    private final ModelRenderer head;
    private final ModelRenderer bone50;
    private final ModelRenderer bone52;
    private final ModelRenderer bone51;
    private final ModelRenderer bone53;
    private final ModelRenderer rightarm;
    private final ModelRenderer bone17;
    private final ModelRenderer bone18;
    private final ModelRenderer bone19;
    private final ModelRenderer bone16;
    private final ModelRenderer bone5;
    private final ModelRenderer bone7;
    private final ModelRenderer bone8;
    private final ModelRenderer bone9;
    private final ModelRenderer bone10;
    private final ModelRenderer bone11;
    private final ModelRenderer bone13;
    private final ModelRenderer bone14;
    private final ModelRenderer bone15;
    private final ModelRenderer bone20;
    private final ModelRenderer bone23;
    private final ModelRenderer bone25;
    private final ModelRenderer bone26;
    private final ModelRenderer bone21;
    private final ModelRenderer bone22;
    private final ModelRenderer bone24;
    private final ModelRenderer Spike1;
    private final ModelRenderer Spike14;
    private final ModelRenderer Spike2;
    private final ModelRenderer Spike21;
    private final ModelRenderer Spike22;
    private final ModelRenderer Spike23;
    private final ModelRenderer Spike24;
    private final ModelRenderer Spike25;
    private final ModelRenderer Spike3;
    private final ModelRenderer Spike31;
    private final ModelRenderer Spike32;
    private final ModelRenderer Spike15;
    private final ModelRenderer Spike34;
    private final ModelRenderer Spike35;
    private final ModelRenderer Spike4;
    private final ModelRenderer Spike41;
    private final ModelRenderer Spike5;
    private final ModelRenderer Spike6;
    private final ModelRenderer leftarm;
    private final ModelRenderer bone27;
    private final ModelRenderer bone28;
    private final ModelRenderer bone29;
    private final ModelRenderer bone30;
    private final ModelRenderer bone31;
    private final ModelRenderer bone32;
    private final ModelRenderer bone33;
    private final ModelRenderer bone34;
    private final ModelRenderer bone35;
    private final ModelRenderer bone36;
    private final ModelRenderer bone39;
    private final ModelRenderer bone40;
    private final ModelRenderer bone41;
    private final ModelRenderer bone42;
    private final ModelRenderer bone43;
    private final ModelRenderer bone44;
    private final ModelRenderer bone45;
    private final ModelRenderer bone46;
    private final ModelRenderer bone47;
    private final ModelRenderer Spike7;
    private final ModelRenderer Spike13;
    private final ModelRenderer Spike8;
    private final ModelRenderer Spike26;
    private final ModelRenderer Spike27;
    private final ModelRenderer Spike28;
    private final ModelRenderer Spike29;
    private final ModelRenderer Spike210;
    private final ModelRenderer Spike9;
    private final ModelRenderer Spike36;
    private final ModelRenderer Spike37;
    private final ModelRenderer Spike38;
    private final ModelRenderer Spike39;
    private final ModelRenderer Spike310;
    private final ModelRenderer Spike10;
    private final ModelRenderer Spike42;
    private final ModelRenderer Spike11;
    private final ModelRenderer Spike12;
    private final ModelRenderer bone38;
    private final ModelRenderer body;
    private final ModelRenderer Neck;
    private final ModelRenderer bone4;
    private final ModelRenderer bone49;
    private final ModelRenderer bone;
    private final ModelRenderer bone3;
    private final ModelRenderer bone2;
    private final ModelRenderer bone48;
    private final ModelRenderer bone6;
    private final ModelRenderer bone37;

    public ModelGeist() {
        textureWidth = 176;
        textureHeight = 176;

        bone12 = new ModelRenderer(this);
        bone12.setRotationPoint(0.0F, 24.0F, 0.0F);
        setRotationAngle(bone12, 0.1745F, 0.0F, 0.0F);

        head = new ModelRenderer(this);
        head.setRotationPoint(0.5F, -51.5F, 2.5F);
        bone12.addChild(head);
        head.cubeList.add(new ModelBox(head, 0, 42, -2.5F, -8.0F, -2.5F, 5, 8, 5, 0.0F, false));
        head.cubeList.add(new ModelBox(head, 8, 129, -2.0F, -9.1F, -4.9F, 4, 1, 2, 0.0F, false));
        head.cubeList.add(new ModelBox(head, 50, 55, -3.5F, -8.0F, -3.2F, 1, 10, 5, 0.0F, false));
        head.cubeList.add(new ModelBox(head, 18, 55, 2.5F, -8.0F, -3.2F, 1, 10, 5, 0.0F, false));
        head.cubeList.add(new ModelBox(head, 48, 102, 2.0F, -8.8F, -4.2F, 1, 1, 5, 0.0F, false));
        head.cubeList.add(new ModelBox(head, 32, 102, -3.0F, -8.8F, -4.2F, 1, 1, 5, 0.0F, false));
        head.cubeList.add(new ModelBox(head, 10, 116, -2.0F, -7.2F, -4.5F, 4, 6, 1, 0.0F, false));
        head.cubeList.add(new ModelBox(head, 14, 146, -2.9F, -7.0F, -3.5F, 1, 5, 1, 0.0F, false));
        head.cubeList.add(new ModelBox(head, 62, 82, -2.5F, -8.5F, -4.0F, 5, 8, 2, 0.0F, false));
        head.cubeList.add(new ModelBox(head, 18, 146, 1.9F, -7.0F, -3.5F, 1, 5, 1, 0.0F, false));
        head.cubeList.add(new ModelBox(head, 8, 157, -1.0F, -1.0F, -3.5F, 2, 1, 1, 0.0F, false));
        head.cubeList.add(new ModelBox(head, 32, 82, -1.5F, -8.2F, -0.5F, 3, 4, 5, 0.0F, false));
        head.cubeList.add(new ModelBox(head, 44, 42, -2.0F, -8.8F, -1.5F, 4, 7, 5, 0.0F, false));
        head.cubeList.add(new ModelBox(head, 0, 109, -0.5F, -7.5F, 0.06F, 1, 2, 5, 0.0F, false));
        head.cubeList.add(new ModelBox(head, 20, 42, -2.5F, -8.9F, -5.0F, 5, 1, 7, 0.0F, false));
        head.cubeList.add(new ModelBox(head, 30, 55, -2.0F, -9.5F, -3.9F, 4, 1, 6, 0.0F, false));

        bone50 = new ModelRenderer(this);
        bone50.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone50, 0.6981F, 0.0F, 0.0F);
        head.addChild(bone50);
        bone50.cubeList.add(new ModelBox(bone50, 50, 116, -3.5F, -0.5248F, -3.7369F, 1, 2, 4, 0.0F, false));

        bone52 = new ModelRenderer(this);
        bone52.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone52, 0.6981F, 0.0F, 0.0F);
        head.addChild(bone52);
        bone52.cubeList.add(new ModelBox(bone52, 40, 116, 2.5F, -0.5248F, -3.7369F, 1, 2, 4, 0.0F, false));

        bone51 = new ModelRenderer(this);
        bone51.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone51, 1.1345F, 0.0F, 0.0F);
        head.addChild(bone51);
        bone51.cubeList.add(new ModelBox(bone51, 30, 116, -3.5F, -0.2423F, -4.0102F, 1, 2, 4, 0.0F, false));

        bone53 = new ModelRenderer(this);
        bone53.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone53, 1.1345F, 0.0F, 0.0F);
        head.addChild(bone53);
        bone53.cubeList.add(new ModelBox(bone53, 60, 116, 2.5F, -0.2423F, -4.0102F, 1, 2, 4, 0.0F, false));

        rightarm = new ModelRenderer(this);
        rightarm.setRotationPoint(-5.5F, -45.0F, 2.0F);
        setRotationAngle(rightarm, -0.3491F, 0.0F, 0.0873F);
        bone12.addChild(rightarm);
        rightarm.cubeList.add(new ModelBox(rightarm, 0, 55, -3.9392F, -0.8054F, -2.0F, 4, 5, 5, 0.0F, false));
        rightarm.cubeList.add(new ModelBox(rightarm, 18, 70, -3.0F, 4.0F, -1.5F, 3, 8, 4, 0.0F, false));
        rightarm.cubeList.add(new ModelBox(rightarm, 20, 128, -2.5F, 12.0F, 0.0F, 2, 3, 2, 0.0F, false));
        rightarm.cubeList.add(new ModelBox(rightarm, 68, 135, -2.0F, 27.7F, -0.5F, 2, 2, 2, 0.0F, false));

        bone17 = new ModelRenderer(this);
        bone17.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone17, -0.2618F, 0.0F, 0.0F);
        rightarm.addChild(bone17);
        bone17.cubeList.add(new ModelBox(bone17, 8, 146, -2.5F, 10.9441F, 4.5206F, 2, 3, 1, 0.0F, false));

        bone18 = new ModelRenderer(this);
        bone18.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone18, 0.0F, 0.0F, 0.4363F);
        rightarm.addChild(bone18);
        bone18.cubeList.add(new ModelBox(bone18, 18, 140, 4.0714F, 10.8757F, 0.0F, 1, 3, 2, 0.0F, false));

        bone19 = new ModelRenderer(this);
        bone19.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone19, 0.0F, 0.0F, -0.2618F);
        rightarm.addChild(bone19);
        bone19.cubeList.add(new ModelBox(bone19, 12, 140, -6.0036F, 10.8147F, 0.0F, 1, 3, 2, 0.0F, false));

        bone16 = new ModelRenderer(this);
        bone16.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone16, 0.4014F, 0.0F, 0.0F);
        rightarm.addChild(bone16);
        bone16.cubeList.add(new ModelBox(bone16, 28, 128, -2.5F, 10.5572F, -5.75F, 2, 3, 2, 0.0F, false));

        bone5 = new ModelRenderer(this);
        bone5.setRotationPoint(5.5F, 45.0F, -2.0F);
        setRotationAngle(bone5, 0.0F, 0.0F, -0.1745F);
        rightarm.addChild(bone5);
        bone5.cubeList.add(new ModelBox(bone5, 0, 94, -1.3418F, -46.7486F, 0.5F, 4, 2, 4, 0.0F, false));

        bone7 = new ModelRenderer(this);
        bone7.setRotationPoint(5.5F, 45.0F, -2.0F);
        setRotationAngle(bone7, 0.0F, 0.0F, -0.6109F);
        rightarm.addChild(bone7);
        bone7.cubeList.add(new ModelBox(bone7, 70, 116, 15.6729F, -38.84F, 0.5F, 1, 2, 4, 0.0F, false));

        bone8 = new ModelRenderer(this);
        bone8.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone8, 0.0524F, 0.0F, 0.0F);
        rightarm.addChild(bone8);
        bone8.cubeList.add(new ModelBox(bone8, 50, 135, -3.0F, 4.3F, 1.623F, 3, 3, 1, 0.0F, false));

        bone9 = new ModelRenderer(this);
        bone9.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone9, -0.1222F, 0.0F, 0.0F);
        rightarm.addChild(bone9);
        bone9.cubeList.add(new ModelBox(bone9, 30, 140, -2.5F, 6.7336F, 2.8508F, 2, 4, 1, 0.0F, false));

        bone10 = new ModelRenderer(this);
        bone10.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone10, -0.1222F, 0.0F, -0.1047F);
        rightarm.addChild(bone10);
        bone10.cubeList.add(new ModelBox(bone10, 44, 152, -3.65F, 6.3835F, 2.8078F, 1, 4, 1, 0.0F, false));

        bone11 = new ModelRenderer(this);
        bone11.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone11, -0.1222F, 0.0F, 0.1047F);
        rightarm.addChild(bone11);
        bone11.cubeList.add(new ModelBox(bone11, 40, 152, -0.34F, 6.7F, 2.84F, 1, 4, 1, 0.0F, false));

        bone13 = new ModelRenderer(this);
        bone13.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone13, 0.0F, 0.0F, -0.1745F);
        rightarm.addChild(bone13);
        bone13.cubeList.add(new ModelBox(bone13, 0, 123, -6.55F, 16.35F, 0.0F, 1, 11, 1, 0.0F, false));

        bone14 = new ModelRenderer(this);
        bone14.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone14, 0.4363F, 0.0F, -0.3491F);
        rightarm.addChild(bone14);
        bone14.cubeList.add(new ModelBox(bone14, 50, 157, -6.7F, 12.0F, -5.0F, 1, 2, 1, 0.0F, false));

        bone15 = new ModelRenderer(this);
        bone15.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone15, -0.0873F, 0.0F, 0.0F);
        rightarm.addChild(bone15);
        bone15.cubeList.add(new ModelBox(bone15, 44, 102, -1.4F, 15.22F, 2.66F, 1, 13, 1, 0.0F, false));

        bone20 = new ModelRenderer(this);
        bone20.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone20, 0.0F, 0.0F, -0.2618F);
        rightarm.addChild(bone20);
        bone20.cubeList.add(new ModelBox(bone20, 20, 123, -9.7F, 30.1704F, -1.0F, 1, 2, 3, 0.0F, false));
        bone20.cubeList.add(new ModelBox(bone20, 6, 140, -9.7F, 27.1704F, -0.5F, 1, 3, 2, 0.0F, false));

        bone23 = new ModelRenderer(this);
        bone23.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone23, 0.2618F, 0.0F, 0.0F);
        rightarm.addChild(bone23);
        bone23.cubeList.add(new ModelBox(bone23, 34, 157, -1.0432F, 32.0F, -6.95F, 1, 2, 1, 0.0F, false));

        bone25 = new ModelRenderer(this);
        bone25.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightarm.addChild(bone25);
        bone25.cubeList.add(new ModelBox(bone25, 0, 135, -1.0432F, 33.5847F, -1.25F, 1, 2, 3, 0.0F, false));

        bone26 = new ModelRenderer(this);
        bone26.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone26, 0.0F, 0.0F, -1.309F);
        rightarm.addChild(bone26);
        bone26.cubeList.add(new ModelBox(bone26, 32, 135, -17.5F, 1.0F, 0.0F, 4, 1, 1, 0.0F, false));

        bone21 = new ModelRenderer(this);
        bone21.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone21, 0.1658F, 0.0F, -0.2618F);
        rightarm.addChild(bone21);
        bone21.cubeList.add(new ModelBox(bone21, 22, 157, -9.7F, 27.0867F, -4.007F, 1, 3, 1, 0.0F, false));

        bone22 = new ModelRenderer(this);
        bone22.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone22, -0.1658F, 0.0F, -0.2618F);
        rightarm.addChild(bone22);
        bone22.cubeList.add(new ModelBox(bone22, 18, 157, -9.7F, 26.9216F, 3.9933F, 1, 3, 1, 0.0F, false));

        bone24 = new ModelRenderer(this);
        bone24.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone24, -0.6109F, -0.8727F, -0.3491F);
        rightarm.addChild(bone24);
        bone24.cubeList.add(new ModelBox(bone24, 38, 157, -8.7F, 20.0F, 24.5F, 1, 2, 1, 0.0F, false));

        Spike1 = new ModelRenderer(this);
        Spike1.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(Spike1, 0.0F, 0.0F, -0.3491F);
        rightarm.addChild(Spike1);
        Spike1.cubeList.add(new ModelBox(Spike1, 42, 157, -1.0F, -3.5F, 0.0F, 1, 2, 1, 0.0F, false));

        Spike14 = new ModelRenderer(this);
        Spike14.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(Spike14, 0.0F, 0.0F, -0.1745F);
        rightarm.addChild(Spike14);
        Spike14.cubeList.add(new ModelBox(Spike14, 32, 161, -1.5926F, -4.2732F, 0.0F, 1, 1, 1, 0.0F, false));

        Spike2 = new ModelRenderer(this);
        Spike2.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(Spike2, 0.0F, 0.0F, -0.7854F);
        rightarm.addChild(Spike2);
        Spike2.cubeList.add(new ModelBox(Spike2, 4, 146, -2.2F, -7.0F, 0.0F, 1, 5, 1, 0.0F, false));

        Spike21 = new ModelRenderer(this);
        Spike21.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(Spike21, 0.0F, 0.0F, -0.6981F);
        rightarm.addChild(Spike21);
        Spike21.cubeList.add(new ModelBox(Spike21, 50, 140, -3.0F, -6.8029F, 0.0F, 1, 5, 1, 0.0F, false));

        Spike22 = new ModelRenderer(this);
        Spike22.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(Spike22, 0.0F, 0.0F, -0.2618F);
        rightarm.addChild(Spike22);
        Spike22.cubeList.add(new ModelBox(Spike22, 48, 152, -5.366F, -7.5622F, 0.0F, 1, 3, 1, 0.0F, false));

        Spike23 = new ModelRenderer(this);
        Spike23.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(Spike23, 0.0F, 0.0F, -0.1833F);
        rightarm.addChild(Spike23);
        Spike23.cubeList.add(new ModelBox(Spike23, 48, 146, -5.961F, -8.4436F, 0.0F, 1, 4, 1, 0.0F, false));

        Spike24 = new ModelRenderer(this);
        Spike24.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(Spike24, -0.1745F, 0.0F, -0.7854F);
        rightarm.addChild(Spike24);
        Spike24.cubeList.add(new ModelBox(Spike24, 54, 140, -2.2F, -6.9315F, -1.2222F, 1, 5, 1, 0.0F, false));

        Spike25 = new ModelRenderer(this);
        Spike25.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(Spike25, 0.1745F, 0.0F, -0.7854F);
        rightarm.addChild(Spike25);
        Spike25.cubeList.add(new ModelBox(Spike25, 32, 146, -2.2F, -6.7579F, 1.207F, 1, 5, 1, 0.0F, false));

        Spike3 = new ModelRenderer(this);
        Spike3.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(Spike3, 0.0F, 0.0F, -1.0472F);
        rightarm.addChild(Spike3);
        Spike3.cubeList.add(new ModelBox(Spike3, 36, 152, -4.7456F, -3.9F, 0.0F, 1, 4, 1, 0.0F, false));

        Spike31 = new ModelRenderer(this);
        Spike31.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(Spike31, 0.0F, 0.0F, -0.6109F);
        rightarm.addChild(Spike31);
        Spike31.cubeList.add(new ModelBox(Spike31, 58, 157, -5.9492F, -3.529F, -0.0F, 1, 2, 1, 0.0F, false));

        Spike32 = new ModelRenderer(this);
        Spike32.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(Spike32, -0.1222F, 0.0F, -1.0472F);
        rightarm.addChild(Spike32);
        Spike32.cubeList.add(new ModelBox(Spike32, 28, 152, -4.7456F, -3.722F, -0.457F, 1, 4, 1, 0.0F, false));

        Spike15 = new ModelRenderer(this);
        Spike15.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(Spike15, 0.1222F, 0.0F, -1.0472F);
        rightarm.addChild(Spike15);
        Spike15.cubeList.add(new ModelBox(Spike15, 24, 152, -4.7456F, -3.6002F, 0.4496F, 1, 4, 1, 0.0F, false));

        Spike34 = new ModelRenderer(this);
        Spike34.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(Spike34, 0.0F, 0.0F, -1.1694F);
        rightarm.addChild(Spike34);
        Spike34.cubeList.add(new ModelBox(Spike34, 20, 152, -4.2606F, -4.1785F, 0.0F, 1, 4, 1, 0.0F, false));

        Spike35 = new ModelRenderer(this);
        Spike35.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(Spike35, 0.0F, 0.0F, -0.925F);
        rightarm.addChild(Spike35);
        Spike35.cubeList.add(new ModelBox(Spike35, 16, 152, -5.1672F, -3.1437F, 0.0F, 1, 4, 1, 0.0F, false));

        Spike4 = new ModelRenderer(this);
        Spike4.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(Spike4, -0.1745F, 0.0F, -1.3614F);
        rightarm.addChild(Spike4);
        Spike4.cubeList.add(new ModelBox(Spike4, 62, 157, -6.5F, -2.5F, -0.5F, 1, 2, 1, 0.0F, false));

        Spike41 = new ModelRenderer(this);
        Spike41.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(Spike41, 0.0F, 0.0F, -1.3614F);
        rightarm.addChild(Spike41);
        Spike41.cubeList.add(new ModelBox(Spike41, 28, 161, -6.5F, -3.3752F, -0.0735F, 1, 1, 1, 0.0F, false));

        Spike5 = new ModelRenderer(this);
        Spike5.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(Spike5, 0.2618F, 0.0F, -1.5359F);
        rightarm.addChild(Spike5);
        Spike5.cubeList.add(new ModelBox(Spike5, 30, 157, -8.0F, -3.6F, 0.7F, 1, 2, 1, 0.0F, false));

        Spike6 = new ModelRenderer(this);
        Spike6.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(Spike6, 0.6109F, 0.0F, -0.3491F);
        rightarm.addChild(Spike6);
        Spike6.cubeList.add(new ModelBox(Spike6, 12, 161, -2.0F, -3.35F, -0.9F, 1, 2, 1, 0.0F, false));

        leftarm = new ModelRenderer(this);
        leftarm.setRotationPoint(6.5F, -45.0F, 2.0F);
        setRotationAngle(leftarm, -0.2618F, 0.0F, -0.0873F);
        bone12.addChild(leftarm);
        leftarm.cubeList.add(new ModelBox(leftarm, 62, 42, -0.0608F, -0.8054F, -2.0F, 4, 5, 5, 0.0F, false));
        leftarm.cubeList.add(new ModelBox(leftarm, 18, 82, 0.0F, 4.0F, -1.5F, 3, 8, 4, 0.0F, false));
        leftarm.cubeList.add(new ModelBox(leftarm, 16, 135, 0.5F, 12.0F, 0.0F, 2, 3, 2, 0.0F, false));
        leftarm.cubeList.add(new ModelBox(leftarm, 24, 135, 0.0F, 27.7F, -0.5F, 2, 2, 2, 0.0F, false));

        bone27 = new ModelRenderer(this);
        bone27.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone27, -0.2618F, 0.0F, 0.0F);
        leftarm.addChild(bone27);
        bone27.cubeList.add(new ModelBox(bone27, 26, 146, 0.5F, 10.9441F, 4.5206F, 2, 3, 1, 0.0F, false));

        bone28 = new ModelRenderer(this);
        bone28.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone28, 0.0F, 0.0F, -0.4363F);
        leftarm.addChild(bone28);
        bone28.cubeList.add(new ModelBox(bone28, 36, 140, -5.0714F, 10.8757F, 0.0F, 1, 3, 2, 0.0F, false));

        bone29 = new ModelRenderer(this);
        bone29.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone29, 0.0F, 0.0F, 0.2618F);
        leftarm.addChild(bone29);
        bone29.cubeList.add(new ModelBox(bone29, 0, 140, 5.0036F, 10.8147F, 0.0F, 1, 3, 2, 0.0F, false));

        bone30 = new ModelRenderer(this);
        bone30.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone30, 0.4014F, 0.0F, 0.0F);
        leftarm.addChild(bone30);
        bone30.cubeList.add(new ModelBox(bone30, 36, 123, 0.5F, 10.5572F, -5.75F, 2, 3, 2, 0.0F, false));

        bone31 = new ModelRenderer(this);
        bone31.setRotationPoint(-5.5F, 45.0F, -2.0F);
        setRotationAngle(bone31, 0.0F, 0.0F, 0.1745F);
        leftarm.addChild(bone31);
        bone31.cubeList.add(new ModelBox(bone31, 16, 94, -2.6582F, -46.7486F, 0.5F, 4, 2, 4, 0.0F, false));

        bone32 = new ModelRenderer(this);
        bone32.setRotationPoint(-5.5F, 45.0F, -2.0F);
        setRotationAngle(bone32, 0.0F, 0.0F, 0.6109F);
        leftarm.addChild(bone32);
        bone32.cubeList.add(new ModelBox(bone32, 8, 123, -16.6729F, -38.84F, 0.5F, 1, 2, 4, 0.0F, false));

        bone33 = new ModelRenderer(this);
        bone33.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone33, 0.0524F, 0.0F, 0.0F);
        leftarm.addChild(bone33);
        bone33.cubeList.add(new ModelBox(bone33, 42, 135, 0.0F, 4.3F, 1.623F, 3, 3, 1, 0.0F, false));

        bone34 = new ModelRenderer(this);
        bone34.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone34, -0.1222F, 0.0F, 0.0F);
        leftarm.addChild(bone34);
        bone34.cubeList.add(new ModelBox(bone34, 76, 135, 0.5F, 6.7336F, 2.8508F, 2, 4, 1, 0.0F, false));

        bone35 = new ModelRenderer(this);
        bone35.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone35, -0.1222F, 0.0F, 0.1047F);
        leftarm.addChild(bone35);
        bone35.cubeList.add(new ModelBox(bone35, 0, 152, 2.65F, 6.3835F, 2.8078F, 1, 4, 1, 0.0F, false));

        bone36 = new ModelRenderer(this);
        bone36.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone36, -0.1222F, 0.0F, -0.1047F);
        leftarm.addChild(bone36);
        bone36.cubeList.add(new ModelBox(bone36, 40, 146, -0.66F, 6.7F, 2.84F, 1, 4, 1, 0.0F, false));

        bone39 = new ModelRenderer(this);
        bone39.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone39, 0.0F, 0.0F, 0.1745F);
        leftarm.addChild(bone39);
        bone39.cubeList.add(new ModelBox(bone39, 4, 123, 5.55F, 16.35F, 0.0F, 1, 11, 1, 0.0F, false));

        bone40 = new ModelRenderer(this);
        bone40.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone40, 0.4363F, 0.0F, 0.3491F);
        leftarm.addChild(bone40);
        bone40.cubeList.add(new ModelBox(bone40, 20, 161, 5.7F, 12.0F, -5.0F, 1, 2, 1, 0.0F, false));

        bone41 = new ModelRenderer(this);
        bone41.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone41, -0.0873F, 0.0F, 0.0F);
        leftarm.addChild(bone41);
        bone41.cubeList.add(new ModelBox(bone41, 28, 102, 0.4F, 15.22F, 2.66F, 1, 13, 1, 0.0F, false));

        bone42 = new ModelRenderer(this);
        bone42.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone42, 0.0F, 0.0F, 0.2618F);
        leftarm.addChild(bone42);
        bone42.cubeList.add(new ModelBox(bone42, 8, 135, 8.7F, 30.1704F, -1.0F, 1, 2, 3, 0.0F, false));
        bone42.cubeList.add(new ModelBox(bone42, 24, 140, 8.7F, 27.1704F, -0.5F, 1, 3, 2, 0.0F, false));

        bone43 = new ModelRenderer(this);
        bone43.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone43, 0.2618F, 0.0F, 0.0F);
        leftarm.addChild(bone43);
        bone43.cubeList.add(new ModelBox(bone43, 26, 157, 0.0432F, 32.0F, -6.95F, 1, 2, 1, 0.0F, false));

        bone44 = new ModelRenderer(this);
        bone44.setRotationPoint(0.0F, 0.0F, 0.0F);
        leftarm.addChild(bone44);
        bone44.cubeList.add(new ModelBox(bone44, 28, 123, 0.0432F, 33.5847F, -1.25F, 1, 2, 3, 0.0F, false));

        bone45 = new ModelRenderer(this);
        bone45.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone45, 0.1658F, 0.0F, 0.2618F);
        leftarm.addChild(bone45);
        bone45.cubeList.add(new ModelBox(bone45, 0, 157, 8.7F, 27.0867F, -4.007F, 1, 3, 1, 0.0F, false));

        bone46 = new ModelRenderer(this);
        bone46.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone46, -0.1658F, 0.0F, 0.2618F);
        leftarm.addChild(bone46);
        bone46.cubeList.add(new ModelBox(bone46, 4, 157, 8.7F, 26.9216F, 3.9933F, 1, 3, 1, 0.0F, false));

        bone47 = new ModelRenderer(this);
        bone47.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone47, -0.6109F, 0.8727F, 0.3491F);
        leftarm.addChild(bone47);
        bone47.cubeList.add(new ModelBox(bone47, 4, 161, 7.7F, 20.0F, 24.5F, 1, 2, 1, 0.0F, false));

        Spike7 = new ModelRenderer(this);
        Spike7.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(Spike7, 0.0F, 0.0F, 0.3491F);
        leftarm.addChild(Spike7);
        Spike7.cubeList.add(new ModelBox(Spike7, 0, 161, 0.0F, -3.5F, 0.0F, 1, 2, 1, 0.0F, false));

        Spike13 = new ModelRenderer(this);
        Spike13.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(Spike13, 0.0F, 0.0F, 0.1745F);
        leftarm.addChild(Spike13);
        Spike13.cubeList.add(new ModelBox(Spike13, 36, 161, 0.5926F, -4.2732F, 0.0F, 1, 1, 1, 0.0F, false));

        Spike8 = new ModelRenderer(this);
        Spike8.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(Spike8, 0.0F, 0.0F, 0.7854F);
        leftarm.addChild(Spike8);
        Spike8.cubeList.add(new ModelBox(Spike8, 42, 140, 1.2F, -7.0F, 0.0F, 1, 5, 1, 0.0F, false));

        Spike26 = new ModelRenderer(this);
        Spike26.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(Spike26, 0.0F, 0.0F, 0.6981F);
        leftarm.addChild(Spike26);
        Spike26.cubeList.add(new ModelBox(Spike26, 46, 140, 2.0F, -6.8029F, 0.0F, 1, 5, 1, 0.0F, false));

        Spike27 = new ModelRenderer(this);
        Spike27.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(Spike27, 0.0F, 0.0F, 0.2618F);
        leftarm.addChild(Spike27);
        Spike27.cubeList.add(new ModelBox(Spike27, 14, 157, 4.366F, -7.5622F, 0.0F, 1, 3, 1, 0.0F, false));

        Spike28 = new ModelRenderer(this);
        Spike28.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(Spike28, 0.0F, 0.0F, 0.1833F);
        leftarm.addChild(Spike28);
        Spike28.cubeList.add(new ModelBox(Spike28, 36, 146, 4.961F, -9.4436F, 0.0F, 1, 5, 1, 0.0F, false));

        Spike29 = new ModelRenderer(this);
        Spike29.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(Spike29, -0.1745F, 0.0F, 0.7854F);
        leftarm.addChild(Spike29);
        Spike29.cubeList.add(new ModelBox(Spike29, 22, 146, 1.2F, -6.9315F, -1.2222F, 1, 5, 1, 0.0F, false));

        Spike210 = new ModelRenderer(this);
        Spike210.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(Spike210, 0.1745F, 0.0F, 0.7854F);
        leftarm.addChild(Spike210);
        Spike210.cubeList.add(new ModelBox(Spike210, 0, 146, 1.2F, -6.7579F, 1.207F, 1, 5, 1, 0.0F, false));

        Spike9 = new ModelRenderer(this);
        Spike9.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(Spike9, 0.0F, 0.0F, 1.0472F);
        leftarm.addChild(Spike9);
        Spike9.cubeList.add(new ModelBox(Spike9, 8, 152, 3.7456F, -3.9F, 0.0F, 1, 4, 1, 0.0F, false));

        Spike36 = new ModelRenderer(this);
        Spike36.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(Spike36, 0.0F, 0.0F, 0.6109F);
        leftarm.addChild(Spike36);
        Spike36.cubeList.add(new ModelBox(Spike36, 54, 157, 4.9492F, -3.529F, -0.0F, 1, 2, 1, 0.0F, false));

        Spike37 = new ModelRenderer(this);
        Spike37.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(Spike37, -0.1222F, 0.0F, 1.0472F);
        leftarm.addChild(Spike37);
        Spike37.cubeList.add(new ModelBox(Spike37, 32, 152, 3.7456F, -3.722F, -0.457F, 1, 4, 1, 0.0F, false));

        Spike38 = new ModelRenderer(this);
        Spike38.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(Spike38, 0.1222F, 0.0F, 1.0472F);
        leftarm.addChild(Spike38);
        Spike38.cubeList.add(new ModelBox(Spike38, 12, 152, 3.7456F, -3.6002F, 0.4496F, 1, 4, 1, 0.0F, false));

        Spike39 = new ModelRenderer(this);
        Spike39.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(Spike39, 0.0F, 0.0F, 1.1694F);
        leftarm.addChild(Spike39);
        Spike39.cubeList.add(new ModelBox(Spike39, 4, 152, 3.2606F, -4.1785F, 0.0F, 1, 4, 1, 0.0F, false));

        Spike310 = new ModelRenderer(this);
        Spike310.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(Spike310, 0.0F, 0.0F, 0.925F);
        leftarm.addChild(Spike310);
        Spike310.cubeList.add(new ModelBox(Spike310, 44, 146, 4.1672F, -3.1437F, 0.0F, 1, 4, 1, 0.0F, false));

        Spike10 = new ModelRenderer(this);
        Spike10.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(Spike10, -0.1745F, 0.0F, 1.3614F);
        leftarm.addChild(Spike10);
        Spike10.cubeList.add(new ModelBox(Spike10, 16, 161, 5.5F, -2.5F, -0.5F, 1, 2, 1, 0.0F, false));

        Spike42 = new ModelRenderer(this);
        Spike42.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(Spike42, 0.0F, 0.0F, 1.3614F);
        leftarm.addChild(Spike42);
        Spike42.cubeList.add(new ModelBox(Spike42, 24, 161, 5.5F, -3.3752F, -0.0735F, 1, 1, 1, 0.0F, false));

        Spike11 = new ModelRenderer(this);
        Spike11.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(Spike11, 0.2618F, 0.0F, 1.5359F);
        leftarm.addChild(Spike11);
        Spike11.cubeList.add(new ModelBox(Spike11, 8, 161, 7.0F, -3.6F, 0.7F, 1, 2, 1, 0.0F, false));

        Spike12 = new ModelRenderer(this);
        Spike12.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(Spike12, 0.6109F, 0.0F, 0.3491F);
        leftarm.addChild(Spike12);
        Spike12.cubeList.add(new ModelBox(Spike12, 46, 157, 1.0F, -3.35F, -0.9F, 1, 2, 1, 0.0F, false));

        bone38 = new ModelRenderer(this);
        bone38.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone38, 0.0F, 0.0F, 1.309F);
        leftarm.addChild(bone38);
        bone38.cubeList.add(new ModelBox(bone38, 58, 135, 13.5F, 1.0F, 0.0F, 4, 1, 1, 0.0F, false));

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 0.0F, 0.0F);
        bone12.addChild(body);

        Neck = new ModelRenderer(this);
        Neck.setRotationPoint(0.5F, -46.5F, 0.0F);
        body.addChild(Neck);

        bone4 = new ModelRenderer(this);
        bone4.setRotationPoint(-0.5F, 46.5F, 0.0F);
        setRotationAngle(bone4, -0.0873F, 0.0F, 0.0F);
        Neck.addChild(bone4);
        bone4.cubeList.add(new ModelBox(bone4, 32, 94, -2.0F, -52.2315F, -4.5688F, 5, 6, 2, 0.0F, false));

        bone49 = new ModelRenderer(this);
        bone49.setRotationPoint(-0.5F, 46.5F, 0.0F);
        setRotationAngle(bone49, -0.7854F, 0.0F, 0.0F);
        Neck.addChild(bone49);
        bone49.cubeList.add(new ModelBox(bone49, 14, 102, -2.0F, -40.0749F, -37.0737F, 5, 3, 2, 0.0F, false));

        bone = new ModelRenderer(this);
        bone.setRotationPoint(-0.5F, 46.5F, 0.0F);
        setRotationAngle(bone, 0.2618F, 0.0F, 0.0F);
        Neck.addChild(bone);
        bone.cubeList.add(new ModelBox(bone, 48, 82, -2.0F, -50.8867F, 15.6587F, 5, 8, 2, 0.0F, false));

        bone3 = new ModelRenderer(this);
        bone3.setRotationPoint(-0.5F, 46.5F, 0.0F);
        setRotationAngle(bone3, 0.0F, -0.1396F, 0.3491F);
        Neck.addChild(bone3);
        bone3.cubeList.add(new ModelBox(bone3, 62, 55, -19.6189F, -48.5849F, 3.6F, 5, 7, 3, 0.0F, false));

        bone2 = new ModelRenderer(this);
        bone2.setRotationPoint(-0.5F, 46.5F, 0.0F);
        setRotationAngle(bone2, 0.0F, 0.1396F, -0.3491F);
        Neck.addChild(bone2);
        bone2.cubeList.add(new ModelBox(bone2, 68, 70, 15.5494F, -48.2429F, 3.6F, 5, 7, 3, 0.0F, false));

        bone48 = new ModelRenderer(this);
        bone48.setRotationPoint(-0.5F, 46.5F, 0.0F);
        setRotationAngle(bone48, 0.0F, 0.1396F, -0.9599F);
        Neck.addChild(bone48);
        bone48.cubeList.add(new ModelBox(bone48, 0, 116, 39.18F, -23.3244F, 6.5F, 2, 4, 3, 0.0F, false));

        bone6 = new ModelRenderer(this);
        bone6.setRotationPoint(-0.5F, 46.5F, 0.0F);
        setRotationAngle(bone6, 0.0F, -0.1396F, 0.9599F);
        Neck.addChild(bone6);
        bone6.cubeList.add(new ModelBox(bone6, 20, 116, -40.6012F, -24.3244F, 6.55F, 2, 4, 3, 0.0F, false));

        bone37 = new ModelRenderer(this);
        bone37.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.addChild(bone37);
        bone37.cubeList.add(new ModelBox(bone37, 60, 94, 5.5F, -33.0F, -1.0F, 1, 1, 6, 0.0F, false));
        bone37.cubeList.add(new ModelBox(bone37, 34, 0, -5.5F, -46.5F, -1.0F, 12, 10, 7, 0.0F, false));
        bone37.cubeList.add(new ModelBox(bone37, 74, 94, -6.0F, -40.5F, -0.5F, 1, 1, 6, 0.0F, false));
        bone37.cubeList.add(new ModelBox(bone37, 0, 0, -5.0F, -36.5F, -0.5F, 11, 36, 6, 0.0F, false));
        bone37.cubeList.add(new ModelBox(bone37, 0, 82, -6.0F, -38.0F, -1.5F, 2, 1, 7, 0.0F, false));
        bone37.cubeList.add(new ModelBox(bone37, 0, 70, 4.5F, -35.5F, -1.4F, 2, 1, 7, 0.0F, false));
        bone37.cubeList.add(new ModelBox(bone37, 32, 70, 5.0F, -38.0F, -1.5F, 2, 1, 7, 0.0F, false));
        bone37.cubeList.add(new ModelBox(bone37, 46, 94, 6.0F, -40.5F, -0.5F, 1, 1, 6, 0.0F, false));
        bone37.cubeList.add(new ModelBox(bone37, 50, 70, -5.5F, -35.5F, -1.4F, 2, 1, 7, 0.0F, false));
        bone37.cubeList.add(new ModelBox(bone37, 0, 102, -5.5F, -33.0F, -1.0F, 1, 1, 6, 0.0F, false));
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        bone12.render(f5);
    }
    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netheadYaw, float headPitch, float scaleFactor, Entity entityIn)
    {
        float f6 = 0;
        float f7 = 1.0F - f6;
        float f9 = (float)entityIn.ticksExisted + 0;
        float f10 = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI);
        float f11 = f10 * 0.8F * limbSwingAmount;
        this.body.rotateAngleX = 0.0F;
        float f12 = 0.2617994F * f6;
        float f13 = MathHelper.cos(f9 * 0.6F + (float)Math.PI);
        this.head.rotateAngleY = netheadYaw * 0.017453292F;
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