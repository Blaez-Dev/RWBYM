package io.github.blaezdev.rwbym.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;

public class ModelSabyr  extends ModelBase {
    private final ModelRenderer Head;
    private final ModelRenderer bone6;
    private final ModelRenderer bone7;
    private final ModelRenderer bone2;
    private final ModelRenderer bone4;
    private final ModelRenderer bone5;
    private final ModelRenderer bone3;
    private final ModelRenderer Torso;
    private final ModelRenderer bone;
    private final ModelRenderer LeftFrontLeg;
    private final ModelRenderer LeftFrontThigh;
    private final ModelRenderer LeftfrontAnkle;
    private final ModelRenderer LeftFrontPaw;
    private final ModelRenderer LeftFrontClaws;
    private final ModelRenderer RightFrontLeg;
    private final ModelRenderer RightFrontThigh;
    private final ModelRenderer RightfrontAnkle;
    private final ModelRenderer RightFrontPaw;
    private final ModelRenderer RightFrontClaws;
    private final ModelRenderer HindleftLeg;
    private final ModelRenderer Lefthindankle;
    private final ModelRenderer DewClaw;
    private final ModelRenderer TopPaw;
    private final ModelRenderer LeftHindpaw;
    private final ModelRenderer LeftPaw;
    private final ModelRenderer HindRighLeg;
    private final ModelRenderer Righthindankle;
    private final ModelRenderer DewClaw2;
    private final ModelRenderer TopPaw2;
    private final ModelRenderer RightPaw;

    public ModelSabyr() {
        textureWidth = 216;
        textureHeight = 216;

        Head = new ModelRenderer(this);
        Head.setRotationPoint(-0.6F, -5.0F, -12.0F);
        Head.cubeList.add(new ModelBox(Head, 2, 207, -5.4F, -7.0F, 2.0F, 11, 12, 3, 0.0F, false));
        Head.cubeList.add(new ModelBox(Head, 2, 207, -4.4F, -6.0F, -1.0F, 9, 10, 3, 0.0F, false));
        Head.cubeList.add(new ModelBox(Head, 2, 207, -4.4F, -6.0F, -3.0F, 9, 10, 2, 0.0F, false));
        Head.cubeList.add(new ModelBox(Head, 2, 207, -3.4F, -5.0F, -5.0F, 7, 9, 2, 0.0F, false));

        bone6 = new ModelRenderer(this);
        bone6.setRotationPoint(-5.0F, -4.0F, -6.0F);
        setRotationAngle(bone6, -1.0472F, -0.0873F, -0.0873F);
        Head.addChild(bone6);
        bone6.cubeList.add(new ModelBox(bone6, 3, 89, -0.0245F, -3.8871F, -1.7314F, 1, 3, 1, 0.0F, false));

        bone7 = new ModelRenderer(this);
        bone7.setRotationPoint(4.0F, -4.0F, -6.0F);
        setRotationAngle(bone7, -1.0472F, 0.0873F, 0.0873F);
        Head.addChild(bone7);
        bone7.cubeList.add(new ModelBox(bone7, 3, 95, -0.0245F, -3.8871F, -1.7314F, 1, 3, 1, 0.0F, false));

        bone2 = new ModelRenderer(this);
        bone2.setRotationPoint(0.6F, -5.0F, -8.0F);
        setRotationAngle(bone2, 0.0873F, 0.0F, 0.0F);
        Head.addChild(bone2);
        bone2.cubeList.add(new ModelBox(bone2, 9, 91, -5.0F, -1.0F, 0.25F, 9, 5, 2, 0.0F, false));
        bone2.cubeList.add(new ModelBox(bone2, 8, 95, -4.0F, -1.9962F, 1.0872F, 0, 1, 2, 0.0F, false));
        bone2.cubeList.add(new ModelBox(bone2, 7, 95, -3.0F, -1.9962F, 1.0872F, 0, 1, 2, 0.0F, false));
        bone2.cubeList.add(new ModelBox(bone2, 3, 89, -2.0F, -1.9962F, 1.0872F, 0, 1, 2, 0.0F, false));
        bone2.cubeList.add(new ModelBox(bone2, 7, 94, -1.0F, -1.9962F, 1.0872F, 0, 1, 2, 0.0F, false));
        bone2.cubeList.add(new ModelBox(bone2, 6, 95, 0.0F, -1.9962F, 1.0872F, 0, 1, 2, 0.0F, false));
        bone2.cubeList.add(new ModelBox(bone2, 7, 91, 0.0F, -2.8181F, 3.1667F, 0, 1, 2, 0.0F, false));
        bone2.cubeList.add(new ModelBox(bone2, 13, 91, 1.0F, -2.8181F, 3.1667F, 0, 1, 2, 0.0F, false));
        bone2.cubeList.add(new ModelBox(bone2, 7, 95, 1.0F, -1.909F, 2.0834F, 0, 1, 2, 0.0F, false));
        bone2.cubeList.add(new ModelBox(bone2, 7, 93, 2.0F, -1.9962F, 1.0872F, 0, 1, 2, 0.0F, false));
        bone2.cubeList.add(new ModelBox(bone2, 7, 93, 3.0F, -1.9962F, 1.0872F, 0, 1, 2, 0.0F, false));
        bone2.cubeList.add(new ModelBox(bone2, 5, 91, 3.0F, -2.9052F, 2.1705F, 0, 1, 2, 0.0F, false));
        bone2.cubeList.add(new ModelBox(bone2, 8, 95, 2.0F, -2.8181F, 3.1667F, 0, 1, 2, 0.0F, false));
        bone2.cubeList.add(new ModelBox(bone2, 7, 96, -1.0F, -2.9052F, 2.1705F, 0, 1, 2, 0.0F, false));
        bone2.cubeList.add(new ModelBox(bone2, 4, 95, -2.0F, -2.8181F, 3.1667F, 0, 1, 2, 0.0F, false));
        bone2.cubeList.add(new ModelBox(bone2, 2, 207, -4.5F, -0.8257F, 2.9924F, 0, 1, 2, 0.0F, false));
        bone2.cubeList.add(new ModelBox(bone2, 2, 207, 3.5F, -0.8257F, 2.9924F, 0, 1, 2, 0.0F, false));
        bone2.cubeList.add(new ModelBox(bone2, 1, 96, -4.0F, -2.9052F, 2.1705F, 0, 1, 2, 0.0F, false));
        bone2.cubeList.add(new ModelBox(bone2, 5, 91, -3.0F, -2.8181F, 3.1667F, 0, 1, 2, 0.0F, false));
        bone2.cubeList.add(new ModelBox(bone2, 5, 91, -5.0F, -1.5728F, 4.0578F, 1, 3, 1, 0.0F, false));
        bone2.cubeList.add(new ModelBox(bone2, 3, 93, 3.0F, -1.5728F, 4.0578F, 1, 3, 1, 0.0F, false));

        bone4 = new ModelRenderer(this);
        bone4.setRotationPoint(0.6F, 1.0F, -7.0F);
        setRotationAngle(bone4, -0.1745F, 0.0F, 0.0F);
        Head.addChild(bone4);
        bone4.cubeList.add(new ModelBox(bone4, 6, 87, -6.5F, -3.2462F, -1.0434F, 1, 2, 4, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 3, 93, -6.0F, -4.1556F, -1.5792F, 1, 1, 4, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 4, 95, 4.0F, -4.1556F, -1.5792F, 1, 1, 4, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 4, 93, 4.25F, -3.2462F, -1.0434F, 1, 2, 4, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 2, 207, -6.0F, -3.7671F, 1.911F, 1, 1, 3, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 4, 92, -6.0F, -4.5783F, 0.7526F, 1, 1, 3, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 6, 92, 4.0F, -4.5783F, 0.7526F, 1, 1, 3, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 8, 97, 4.0F, -3.7671F, 1.911F, 1, 1, 3, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 7, 87, -5.5F, 1.0868F, -1.4924F, 1, 2, 4, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 4, 81, -5.5F, -0.8828F, -0.8397F, 1, 2, 3, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 6, 93, 3.5F, -0.8828F, -0.8397F, 1, 2, 3, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 5, 89, 3.75F, 1.0868F, -1.4924F, 1, 2, 4, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 0, 88, -4.5F, 2.4484F, -4.9826F, 1, 1, 4, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 6, 92, 2.25F, 2.4484F, -4.9826F, 1, 1, 4, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 2, 92, -2.75F, 2.5638F, -8.5163F, 0, 1, 4, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 7, 94, 1.0F, 2.5638F, -8.2663F, 1, 1, 3, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 28, 164, -5.0F, -3.0F, -0.5F, 9, 6, 3, 0.0F, false));

        bone5 = new ModelRenderer(this);
        bone5.setRotationPoint(0.6F, 1.0F, -7.0F);
        setRotationAngle(bone5, 0.0873F, 0.0F, 0.0F);
        Head.addChild(bone5);
        bone5.cubeList.add(new ModelBox(bone5, 11, 167, -4.0F, 1.5247F, -3.8673F, 7, 1, 4, 0.0F, false));
        bone5.cubeList.add(new ModelBox(bone5, 6, 208, -3.0F, 0.8523F, -5.3161F, 5, 1, 4, 0.0F, false));
        bone5.cubeList.add(new ModelBox(bone5, 2, 207, -2.0F, 0.3399F, -8.8265F, 3, 1, 4, 0.0F, false));
        bone5.cubeList.add(new ModelBox(bone5, 7, 93, -2.0F, 0.9913F, -9.3112F, 3, 1, 0, 0.0F, false));
        bone5.cubeList.add(new ModelBox(bone5, 4, 85, -2.0F, 1.0349F, -8.8131F, 3, 1, 0, 0.0F, false));
        bone5.cubeList.add(new ModelBox(bone5, 4, 93, -1.0F, 0.4477F, -9.8093F, 1, 1, 0, 0.0F, false));

        bone3 = new ModelRenderer(this);
        bone3.setRotationPoint(0.6F, -4.75F, -8.0F);
        setRotationAngle(bone3, 0.2618F, 0.0F, 0.0F);
        Head.addChild(bone3);
        bone3.cubeList.add(new ModelBox(bone3, 0, 88, -5.0F, -0.0898F, -4.0189F, 9, 4, 4, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 2, 207, -5.0F, -1.0898F, -4.0189F, 9, 5, 4, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 89, 54, -6.0F, -1.4488F, -4.3111F, 10, 1, 6, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 7, 97, -6.0F, 2.8761F, -4.2777F, 1, 1, 4, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 8, 89, 3.75F, 2.8761F, -4.2777F, 1, 1, 4, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 185, 68, -5.5F, 1.9102F, -5.0189F, 1, 1, 4, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 6, 93, 3.5F, 2.169F, -4.0529F, 1, 1, 5, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 4, 95, -5.5F, 1.009F, -0.5186F, 1, 1, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 2, 207, 3.5F, 1.009F, -0.5186F, 1, 1, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 6, 97, 3.75F, 1.009F, -0.5186F, 1, 1, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 119, 95, -5.5F, 1.4746F, -1.6786F, 1, 1, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 142, 88, 3.5F, 1.4746F, -1.6786F, 1, 1, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 205, 71, -5.5F, 1.2158F, -2.6445F, 1, 1, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 131, 88, 3.5F, 1.2158F, -2.6445F, 1, 1, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 206, 88, -5.5F, 1.1984F, -3.6751F, 1, 1, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 95, 91, 3.5F, 1.1984F, -3.6751F, 1, 1, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 171, 8, -5.5F, 0.8963F, -2.2733F, 1, 0, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 169, 12, 3.5F, 0.8963F, -2.7733F, 1, 0, 2, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 2, 94, 3.5F, -0.0217F, -4.5012F, 1, 1, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 5, 91, -5.5F, -0.0217F, -4.7512F, 1, 2, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 8, 84, -5.5F, -0.4699F, -0.3105F, 1, 3, 3, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 6, 89, 3.75F, -0.4699F, -0.3105F, 1, 3, 3, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 0, 92, -5.75F, -0.9876F, -4.4924F, 1, 1, 5, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 2, 94, 3.5F, -0.9876F, -4.2424F, 1, 1, 5, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 2, 207, -5.5F, -0.9876F, -4.2424F, 1, 1, 5, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 12, 93, -5.5F, 1.2551F, -0.7022F, 1, 2, 2, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 2, 94, 3.5F, 1.2551F, -0.7022F, 1, 2, 2, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 2, 93, 3.25F, 0.9443F, -4.76F, 1, 1, 5, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 0, 93, -4.75F, 2.3238F, -8.2708F, 1, 1, 4, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 0, 90, -4.5F, -0.1251F, -8.3826F, 1, 2, 4, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 0, 91, 2.5F, -0.1251F, -8.3826F, 1, 2, 4, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 2, 87, -4.0F, -0.1944F, -9.5051F, 0, 3, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 10, 83, 2.5F, -0.1944F, -9.5051F, 0, 3, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 8, 93, 2.5F, 2.3238F, -8.2708F, 1, 1, 4, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 2, 96, -3.0F, 2.2545F, -10.3933F, 1, 1, 2, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 8, 97, 1.0F, 2.2545F, -10.3933F, 1, 1, 2, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 6, 89, -3.0F, 0.2885F, -10.1345F, 1, 2, 2, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 9, 92, 1.0F, 0.2885F, -10.1345F, 1, 2, 2, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 6, 96, -5.5F, 6.4689F, 0.374F, 2, 3, 2, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 4, 96, 2.75F, 6.4689F, 0.374F, 2, 3, 2, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 4, 93, -4.0F, -0.6589F, -7.2402F, 7, 4, 4, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 2, 91, -4.25F, -1.1418F, -7.1107F, 7, 1, 4, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 10, 93, -3.75F, -0.7282F, -10.1127F, 6, 1, 3, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 2, 207, -3.0F, -0.5641F, -8.8185F, 5, 4, 2, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 6, 90, -4.75F, 0.9795F, -9.785F, 1, 2, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 0, 90, 2.75F, 0.9795F, -9.785F, 1, 2, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 5, 93, -4.75F, 2.7819F, -9.7856F, 1, 3, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 1, 94, 3.0F, 2.7819F, -9.7856F, 1, 3, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 8, 97, -4.5F, 4.9079F, -9.3288F, 0, 3, 0, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 6, 78, 3.25F, 4.9079F, -9.3288F, 0, 3, 0, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 2, 207, -2.0F, 0.4012F, -9.8797F, 3, 3, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 5, 90, -1.5F, 2.1083F, -11.1045F, 2, 1, 1, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 14, 96, -0.75F, 0.3618F, -10.8283F, 0, 0, 1, 0.0F, false));

        Torso = new ModelRenderer(this);
        Torso.setRotationPoint(0.0F, 22.0F, 0.0F);
        Torso.cubeList.add(new ModelBox(Torso, 1, 161, -6.6F, -35.0F, -7.0F, 13, 16, 12, 0.0F, false));
        Torso.cubeList.add(new ModelBox(Torso, 102, 12, -5.6F, -34.0F, 3.0F, 11, 14, 10, 0.0F, false));
        Torso.cubeList.add(new ModelBox(Torso, 145, 28, -5.6F, -33.0F, 13.0F, 11, 11, 8, 0.0F, false));
        Torso.cubeList.add(new ModelBox(Torso, 6, 130, -7.0F, -31.75F, 16.5F, 2, 10, 1, 0.0F, false));
        Torso.cubeList.add(new ModelBox(Torso, 5, 125, 4.0F, -31.75F, 16.25F, 2, 10, 1, 0.0F, false));
        Torso.cubeList.add(new ModelBox(Torso, 4, 130, -7.0F, -31.75F, 14.0F, 2, 10, 1, 0.0F, false));
        Torso.cubeList.add(new ModelBox(Torso, 1, 128, 4.0F, -31.75F, 14.0F, 2, 10, 1, 0.0F, false));
        Torso.cubeList.add(new ModelBox(Torso, 3, 132, -7.0F, -31.75F, 11.75F, 2, 10, 1, 0.0F, false));
        Torso.cubeList.add(new ModelBox(Torso, 3, 132, 4.0F, -31.75F, 11.5F, 2, 10, 1, 0.0F, false));
        Torso.cubeList.add(new ModelBox(Torso, 3, 134, -7.0F, -31.75F, 9.5F, 2, 11, 1, 0.0F, false));
        Torso.cubeList.add(new ModelBox(Torso, 10, 128, 4.0F, -31.75F, 9.0F, 2, 11, 1, 0.0F, false));
        Torso.cubeList.add(new ModelBox(Torso, 3, 134, -7.0F, -29.75F, 7.0F, 2, 6, 1, 0.0F, false));
        Torso.cubeList.add(new ModelBox(Torso, 6, 134, 4.0F, -29.75F, 6.75F, 2, 6, 1, 0.0F, false));
        Torso.cubeList.add(new ModelBox(Torso, 7, 138, -7.0F, -29.75F, 19.0F, 2, 6, 1, 0.0F, false));
        Torso.cubeList.add(new ModelBox(Torso, 3, 125, 4.5F, -29.75F, 18.75F, 2, 6, 1, 0.0F, false));
        Torso.cubeList.add(new ModelBox(Torso, 0, 188, -5.6F, -33.0F, 21.0F, 11, 11, 8, 0.0F, false));
        Torso.cubeList.add(new ModelBox(Torso, 8, 163, -5.6F, -34.0F, 26.0F, 12, 13, 12, 0.0F, false));
        Torso.cubeList.add(new ModelBox(Torso, 2, 84, -1.0F, -34.0F, 38.0F, 2, 3, 2, 0.0F, false));
        Torso.cubeList.add(new ModelBox(Torso, 4, 89, -1.0F, -34.0F, 40.0F, 2, 3, 2, 0.0F, false));
        Torso.cubeList.add(new ModelBox(Torso, 5, 88, -1.0F, -34.75F, 42.0F, 2, 3, 2, 0.0F, false));
        Torso.cubeList.add(new ModelBox(Torso, 7, 89, -1.0F, -34.75F, 44.0F, 2, 3, 2, 0.0F, false));
        Torso.cubeList.add(new ModelBox(Torso, 4, 92, -1.0F, -34.75F, 46.0F, 2, 3, 2, 0.0F, false));
        Torso.cubeList.add(new ModelBox(Torso, 8, 94, -1.0F, -34.25F, 48.0F, 2, 3, 2, 0.0F, false));
        Torso.cubeList.add(new ModelBox(Torso, 7, 90, -1.0F, -33.75F, 50.0F, 2, 3, 2, 0.0F, false));
        Torso.cubeList.add(new ModelBox(Torso, 7, 91, -1.0F, -33.25F, 52.0F, 2, 3, 2, 0.0F, false));
        Torso.cubeList.add(new ModelBox(Torso, 14, 89, -1.0F, -32.75F, 54.0F, 2, 3, 2, 0.0F, false));
        Torso.cubeList.add(new ModelBox(Torso, 3, 93, -1.0F, -31.75F, 56.0F, 2, 2, 2, 0.0F, false));
        Torso.cubeList.add(new ModelBox(Torso, 5, 93, -1.0F, -32.0F, 58.0F, 2, 2, 2, 0.0F, false));
        Torso.cubeList.add(new ModelBox(Torso, 3, 89, -1.0F, -32.25F, 60.0F, 2, 2, 2, 0.0F, false));
        Torso.cubeList.add(new ModelBox(Torso, 7, 88, -0.5F, -31.5F, 62.0F, 1, 1, 2, 0.0F, false));
        Torso.cubeList.add(new ModelBox(Torso, 2, 93, -0.5F, -31.75F, 64.0F, 1, 1, 2, 0.0F, false));

        bone = new ModelRenderer(this);
        bone.setRotationPoint(0.4F, -36.0F, 2.0F);
        setRotationAngle(bone, -0.5236F, 0.0F, 0.0F);
        Torso.addChild(bone);
        bone.cubeList.add(new ModelBox(bone, 4, 139, -2.4F, -0.4562F, 1.1667F, 3, 2, 3, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 11, 146, -2.4F, -4.5902F, 10.327F, 3, 2, 3, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 2, 143, -2.4F, -9.5902F, 18.9872F, 3, 2, 3, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 10, 132, -2.4F, -13.5902F, 25.9154F, 3, 2, 3, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 6, 134, -2.4F, 6.1508F, -8.9264F, 3, 2, 3, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 11, 131, -2.4F, 3.0438F, -4.8955F, 3, 2, 3, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 0, 143, -1.9F, 5.1191F, -8.2028F, 1, 1, 2, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 9, 136, -1.9F, 2.012F, -4.1719F, 1, 1, 2, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 3, 143, -1.9F, -1.488F, 1.8903F, 1, 1, 2, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 11, 138, -1.9F, -5.6219F, 11.0505F, 1, 1, 2, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 13, 140, -1.9F, -10.6219F, 19.7108F, 1, 1, 2, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 3, 144, -1.9F, -14.6219F, 26.639F, 1, 1, 2, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 7, 142, -1.4F, 3.7531F, -7.5868F, 0, 1, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 8, 146, -1.4F, 0.646F, -3.5559F, 0, 1, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 7, 148, -1.4F, -2.854F, 2.5063F, 0, 1, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 9, 145, -1.4F, -6.988F, 11.6665F, 0, 1, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 9, 142, -1.4F, -11.988F, 20.3268F, 0, 1, 1, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 5, 144, -1.4F, -15.988F, 27.255F, 0, 1, 1, 0.0F, false));

        LeftFrontLeg = new ModelRenderer(this);
        LeftFrontLeg.setRotationPoint(6.0F, -5.0F, -2.0F);
        LeftFrontLeg.cubeList.add(new ModelBox(LeftFrontLeg, 34, 6, 0.0F, -6.0F, -5.0F, 7, 11, 10, 0.0F, false));
        LeftFrontLeg.cubeList.add(new ModelBox(LeftFrontLeg, 6, 111, 6.0F, -4.0F, -3.0F, 2, 5, 5, 0.0F, false));
        LeftFrontLeg.cubeList.add(new ModelBox(LeftFrontLeg, 6, 134, 4.0F, -5.0F, -6.0F, 2, 2, 1, 0.0F, false));
        LeftFrontLeg.cubeList.add(new ModelBox(LeftFrontLeg, 5, 134, 6.0F, 2.5F, 2.0F, 2, 1, 2, 0.0F, false));
        LeftFrontLeg.cubeList.add(new ModelBox(LeftFrontLeg, 5, 136, 6.0F, 1.5F, -4.0F, 2, 3, 3, 0.0F, false));

        LeftFrontThigh = new ModelRenderer(this);
        LeftFrontThigh.setRotationPoint(2.0F, 5.0F, 3.0F);
        setRotationAngle(LeftFrontThigh, 0.4363F, 0.0F, 0.0F);
        LeftFrontLeg.addChild(LeftFrontThigh);
        LeftFrontThigh.cubeList.add(new ModelBox(LeftFrontThigh, 20, 5, -2.0F, -5.2352F, -5.0611F, 6, 8, 9, 0.0F, false));
        LeftFrontThigh.cubeList.add(new ModelBox(LeftFrontThigh, 37, 35, -2.0F, 1.9195F, -2.8737F, 5, 5, 6, 0.0F, false));
        LeftFrontThigh.cubeList.add(new ModelBox(LeftFrontThigh, 6, 175, -2.0F, 6.39F, -2.7515F, 5, 5, 6, 0.0F, false));

        LeftfrontAnkle = new ModelRenderer(this);
        LeftfrontAnkle.setRotationPoint(3.0F, 16.0F, 7.0F);
        setRotationAngle(LeftfrontAnkle, -0.1745F, 0.0F, 0.0F);
        LeftFrontLeg.addChild(LeftfrontAnkle);
        LeftfrontAnkle.cubeList.add(new ModelBox(LeftfrontAnkle, 6, 175, -2.5F, -1.4832F, -3.3433F, 4, 4, 4, 0.0F, false));
        LeftfrontAnkle.cubeList.add(new ModelBox(LeftfrontAnkle, 6, 175, -2.0F, 2.2241F, -3.2127F, 2, 4, 3, 0.0F, false));
        LeftfrontAnkle.cubeList.add(new ModelBox(LeftfrontAnkle, 6, 175, -2.0F, 5.5116F, -2.8908F, 2, 4, 2, 0.0F, false));

        LeftFrontPaw = new ModelRenderer(this);
        LeftFrontPaw.setRotationPoint(9.0F, 5.5058F, -4.7808F);
        setRotationAngle(LeftFrontPaw, 0.6981F, 0.0F, 0.0F);
        LeftfrontAnkle.addChild(LeftFrontPaw);
        LeftFrontPaw.cubeList.add(new ModelBox(LeftFrontPaw, 6, 175, -12.0F, 4.5107F, -4.4878F, 4, 2, 5, 0.0F, false));

        LeftFrontClaws = new ModelRenderer(this);
        LeftFrontClaws.setRotationPoint(-10.0F, 5.9397F, -3.342F);
        setRotationAngle(LeftFrontClaws, -0.5236F, 0.0F, 0.0F);
        LeftFrontPaw.addChild(LeftFrontClaws);
        LeftFrontClaws.cubeList.add(new ModelBox(LeftFrontClaws, 6, 175, 1.0F, -0.4893F, -3.4878F, 2, 2, 4, 0.0F, false));
        LeftFrontClaws.cubeList.add(new ModelBox(LeftFrontClaws, 6, 175, -3.0F, -0.4893F, -3.4878F, 2, 2, 4, 0.0F, false));
        LeftFrontClaws.cubeList.add(new ModelBox(LeftFrontClaws, 3, 94, -3.0F, 0.5107F, -4.9878F, 1, 1, 1, 0.0F, false));
        LeftFrontClaws.cubeList.add(new ModelBox(LeftFrontClaws, 1, 91, -1.0F, 0.5107F, -4.9878F, 1, 1, 1, 0.0F, false));
        LeftFrontClaws.cubeList.add(new ModelBox(LeftFrontClaws, 2, 100, 1.0F, 0.5107F, -4.9878F, 1, 1, 1, 0.0F, false));
        LeftFrontClaws.cubeList.add(new ModelBox(LeftFrontClaws, 0, 97, 3.0F, 0.5107F, -4.7378F, 1, 1, 1, 0.0F, false));
        LeftFrontClaws.cubeList.add(new ModelBox(LeftFrontClaws, 6, 175, -1.0F, -0.4893F, -3.4878F, 2, 2, 4, 0.0F, false));

        RightFrontLeg = new ModelRenderer(this);
        RightFrontLeg.setRotationPoint(-5.5F, -3.0F, -2.0F);
        RightFrontLeg.cubeList.add(new ModelBox(RightFrontLeg, 49, 7, -8.0F, -8.0F, -5.0F, 7, 11, 10, 0.0F, false));
        RightFrontLeg.cubeList.add(new ModelBox(RightFrontLeg, 4, 139, -9.0F, -6.0F, -4.0F, 2, 5, 4, 0.0F, false));
        RightFrontLeg.cubeList.add(new ModelBox(RightFrontLeg, 1, 137, -6.5F, -6.0F, -5.25F, 3, 3, 2, 0.0F, false));
        RightFrontLeg.cubeList.add(new ModelBox(RightFrontLeg, 3, 144, -8.75F, 0.0F, 2.0F, 2, 2, 2, 0.0F, false));
        RightFrontLeg.cubeList.add(new ModelBox(RightFrontLeg, 7, 121, -8.75F, -6.0F, 1.5F, 2, 3, 2, 0.0F, false));

        RightFrontThigh = new ModelRenderer(this);
        RightFrontThigh.setRotationPoint(-6.0F, 3.0F, 3.0F);
        setRotationAngle(RightFrontThigh, 0.4363F, 0.0F, 0.0F);
        RightFrontLeg.addChild(RightFrontThigh);
        RightFrontThigh.cubeList.add(new ModelBox(RightFrontThigh, 66, 28, -1.0F, -5.2352F, -5.0611F, 6, 8, 9, 0.0F, false));
        RightFrontThigh.cubeList.add(new ModelBox(RightFrontThigh, 0, 171, -0.5F, 1.9195F, -2.8737F, 5, 5, 6, 0.0F, false));
        RightFrontThigh.cubeList.add(new ModelBox(RightFrontThigh, 0, 171, -0.5F, 6.39F, -2.7515F, 5, 5, 6, 0.0F, false));

        RightfrontAnkle = new ModelRenderer(this);
        RightfrontAnkle.setRotationPoint(-5.0F, 14.0F, 7.0F);
        setRotationAngle(RightfrontAnkle, -0.1745F, 0.0F, 0.0F);
        RightFrontLeg.addChild(RightfrontAnkle);
        RightfrontAnkle.cubeList.add(new ModelBox(RightfrontAnkle, 0, 171, -1.0F, -1.4832F, -3.3433F, 4, 4, 4, 0.0F, false));
        RightfrontAnkle.cubeList.add(new ModelBox(RightfrontAnkle, 0, 171, -0.5F, 2.2241F, -3.2127F, 2, 4, 3, 0.0F, false));
        RightfrontAnkle.cubeList.add(new ModelBox(RightfrontAnkle, 0, 171, -0.5F, 5.5116F, -2.8908F, 2, 4, 2, 0.0F, false));

        RightFrontPaw = new ModelRenderer(this);
        RightFrontPaw.setRotationPoint(10.75F, 5.5058F, -4.7808F);
        setRotationAngle(RightFrontPaw, 0.6981F, 0.0F, 0.0F);
        RightfrontAnkle.addChild(RightFrontPaw);
        RightFrontPaw.cubeList.add(new ModelBox(RightFrontPaw, 0, 171, -12.0F, 4.5107F, -4.4878F, 4, 2, 5, 0.0F, false));

        RightFrontClaws = new ModelRenderer(this);
        RightFrontClaws.setRotationPoint(-10.0F, 5.9397F, -3.342F);
        setRotationAngle(RightFrontClaws, -0.5236F, 0.0F, 0.0F);
        RightFrontPaw.addChild(RightFrontClaws);
        RightFrontClaws.cubeList.add(new ModelBox(RightFrontClaws, 0, 171, 1.0F, -0.4893F, -3.4878F, 2, 2, 4, 0.0F, false));
        RightFrontClaws.cubeList.add(new ModelBox(RightFrontClaws, 0, 171, -3.0F, -0.4893F, -3.4878F, 2, 2, 4, 0.0F, false));
        RightFrontClaws.cubeList.add(new ModelBox(RightFrontClaws, 5, 97, -3.0F, 0.5107F, -4.7378F, 1, 1, 1, 0.0F, false));
        RightFrontClaws.cubeList.add(new ModelBox(RightFrontClaws, 5, 95, -1.0F, 0.5107F, -4.9878F, 1, 1, 1, 0.0F, false));
        RightFrontClaws.cubeList.add(new ModelBox(RightFrontClaws, 4, 97, 1.0F, 0.5107F, -4.9878F, 1, 1, 1, 0.0F, false));
        RightFrontClaws.cubeList.add(new ModelBox(RightFrontClaws, 5, 98, 3.0F, 0.5107F, -4.9878F, 1, 1, 1, 0.0F, false));
        RightFrontClaws.cubeList.add(new ModelBox(RightFrontClaws, 0, 171, -1.0F, -0.4893F, -3.4878F, 2, 2, 4, 0.0F, false));

        HindleftLeg = new ModelRenderer(this);
        HindleftLeg.setRotationPoint(14.4F, -5.0F, 35.0F);
        setRotationAngle(HindleftLeg, 0.2618F, 0.0F, 0.0F);
        HindleftLeg.cubeList.add(new ModelBox(HindleftLeg, 172, 167, -8.0F, -4.2929F, -7.2247F, 7, 15, 10, 0.0F, false));
        HindleftLeg.cubeList.add(new ModelBox(HindleftLeg, 10, 131, -2.75F, 2.9674F, -7.8914F, 2, 3, 3, 0.0F, false));
        HindleftLeg.cubeList.add(new ModelBox(HindleftLeg, 4, 141, -5.25F, -1.6816F, -8.2198F, 2, 3, 0, 0.0F, false));
        HindleftLeg.cubeList.add(new ModelBox(HindleftLeg, 12, 121, -2.5F, -3.2765F, -4.1478F, 2, 2, 1, 0.0F, false));
        HindleftLeg.cubeList.add(new ModelBox(HindleftLeg, 176, 196, -8.0F, 11.0968F, -5.5882F, 7, 7, 7, 0.0F, false));

        Lefthindankle = new ModelRenderer(this);
        Lefthindankle.setRotationPoint(-4.4F, 10.0341F, 2.2588F);
        setRotationAngle(Lefthindankle, -0.1745F, 0.0F, 0.0F);
        HindleftLeg.addChild(Lefthindankle);
        Lefthindankle.cubeList.add(new ModelBox(Lefthindankle, 14, 190, -3.0F, 4.1338F, -4.1586F, 5, 5, 7, 0.0F, false));
        Lefthindankle.cubeList.add(new ModelBox(Lefthindankle, 13, 184, -2.0F, 4.8587F, 2.1848F, 3, 4, 5, 0.0F, false));
        Lefthindankle.cubeList.add(new ModelBox(Lefthindankle, 5, 93, -0.8F, 3.1839F, 6.0326F, 1, 3, 1, 0.0F, false));

        DewClaw = new ModelRenderer(this);
        DewClaw.setRotationPoint(0.4F, 9.8181F, 6.8333F);
        Lefthindankle.addChild(DewClaw);
        DewClaw.cubeList.add(new ModelBox(DewClaw, 14, 190, -2.4F, -2.4192F, -2.8206F, 3, 5, 3, 0.0F, false));
        DewClaw.cubeList.add(new ModelBox(DewClaw, 14, 190, -2.4F, 2.3781F, -2.4875F, 3, 4, 2, 0.0F, false));

        TopPaw = new ModelRenderer(this);
        TopPaw.setRotationPoint(-8.0F, 6.0F, -2.0F);
        setRotationAngle(TopPaw, -0.7854F, 0.0F, 0.0F);
        DewClaw.addChild(TopPaw);
        TopPaw.cubeList.add(new ModelBox(TopPaw, 14, 190, 4.6F, -1.7167F, -1.658F, 5, 5, 2, 0.0F, false));

        LeftHindpaw = new ModelRenderer(this);
        LeftHindpaw.setRotationPoint(0.0F, -0.5712F, -40.9358F);
        setRotationAngle(LeftHindpaw, -0.8727F, -0.0873F, -0.0873F);
        TopPaw.addChild(LeftHindpaw);
        LeftHindpaw.cubeList.add(new ModelBox(LeftHindpaw, 8, 90, 7.359F, -30.9073F, 25.6714F, 1, 1, 1, 0.0F, false));

        LeftPaw = new ModelRenderer(this);
        LeftPaw.setRotationPoint(9.0076F, -12.5514F, 25.9249F);
        setRotationAngle(LeftPaw, 0.0F, 0.0F, 0.0873F);
        LeftHindpaw.addChild(LeftPaw);
        LeftPaw.cubeList.add(new ModelBox(LeftPaw, 14, 190, -3.5178F, -16.1408F, 2.7771F, 7, 6, 2, 0.0F, false));
        LeftPaw.cubeList.add(new ModelBox(LeftPaw, 8, 84, -3.2149F, -10.642F, 3.529F, 1, 2, 1, 0.0F, false));
        LeftPaw.cubeList.add(new ModelBox(LeftPaw, 4, 93, -1.2163F, -10.5708F, 3.5509F, 1, 2, 1, 0.0F, false));
        LeftPaw.cubeList.add(new ModelBox(LeftPaw, 3, 91, 0.7824F, -10.4997F, 3.5728F, 1, 2, 1, 0.0F, false));
        LeftPaw.cubeList.add(new ModelBox(LeftPaw, 7, 89, 2.781F, -10.4285F, 3.5948F, 1, 2, 1, 0.0F, false));

        HindRighLeg = new ModelRenderer(this);
        HindRighLeg.setRotationPoint(-4.6F, -5.0F, 35.0F);
        setRotationAngle(HindRighLeg, 0.2618F, 0.0F, 0.0F);
        HindRighLeg.cubeList.add(new ModelBox(HindRighLeg, 149, 160, -8.0F, -4.2929F, -7.2247F, 7, 15, 10, 0.0F, false));
        HindRighLeg.cubeList.add(new ModelBox(HindRighLeg, 6, 145, -8.9F, -2.3784F, -1.773F, 1, 3, 3, 0.0F, false));
        HindRighLeg.cubeList.add(new ModelBox(HindRighLeg, 5, 143, -8.9F, 2.1924F, -5.033F, 1, 4, 4, 0.0F, false));
        HindRighLeg.cubeList.add(new ModelBox(HindRighLeg, 0, 136, -8.9F, -2.9654F, -8.0774F, 3, 4, 3, 0.0F, false));
        HindRighLeg.cubeList.add(new ModelBox(HindRighLeg, 3, 144, -7.4F, 4.8302F, -7.6303F, 2, 2, 1, 0.0F, false));
        HindRighLeg.cubeList.add(new ModelBox(HindRighLeg, 120, 160, -8.0F, 11.3155F, -5.5882F, 7, 7, 7, 0.0F, false));

        Righthindankle = new ModelRenderer(this);
        Righthindankle.setRotationPoint(-4.4F, 10.0341F, 2.2588F);
        setRotationAngle(Righthindankle, -0.1745F, 0.0F, 0.0F);
        HindRighLeg.addChild(Righthindankle);
        Righthindankle.cubeList.add(new ModelBox(Righthindankle, 7, 167, -3.0F, 4.1338F, -4.1586F, 5, 5, 7, 0.0F, false));
        Righthindankle.cubeList.add(new ModelBox(Righthindankle, 7, 167, -2.0F, 4.8587F, 2.1848F, 3, 4, 5, 0.0F, false));
        Righthindankle.cubeList.add(new ModelBox(Righthindankle, 7, 94, -1.0F, 3.1354F, 6.322F, 1, 2, 1, 0.0F, false));

        DewClaw2 = new ModelRenderer(this);
        DewClaw2.setRotationPoint(0.4F, 9.8181F, 6.8333F);
        Righthindankle.addChild(DewClaw2);
        DewClaw2.cubeList.add(new ModelBox(DewClaw2, 7, 167, -2.4F, -2.4192F, -2.8206F, 3, 5, 3, 0.0F, false));
        DewClaw2.cubeList.add(new ModelBox(DewClaw2, 7, 167, -2.4F, 2.3781F, -2.4875F, 3, 4, 2, 0.0F, false));

        TopPaw2 = new ModelRenderer(this);
        TopPaw2.setRotationPoint(-8.0F, 6.0F, -2.0F);
        setRotationAngle(TopPaw2, -0.7854F, 0.0F, 0.0F);
        DewClaw2.addChild(TopPaw2);
        TopPaw2.cubeList.add(new ModelBox(TopPaw2, 7, 167, 4.6F, -1.7167F, -1.658F, 5, 6, 2, 0.0F, false));

        RightPaw = new ModelRenderer(this);
        RightPaw.setRotationPoint(0.0F, -29.4171F, -29.8944F);
        setRotationAngle(RightPaw, -0.8727F, 0.0F, 0.0F);
        TopPaw2.addChild(RightPaw);
        RightPaw.cubeList.add(new ModelBox(RightPaw, 3, 91, 3.8706F, 2.4205F, 44.3576F, 1, 2, 1, 0.0F, false));
        RightPaw.cubeList.add(new ModelBox(RightPaw, 6, 95, 5.8706F, 2.4205F, 44.3576F, 1, 2, 1, 0.0F, false));
        RightPaw.cubeList.add(new ModelBox(RightPaw, 5, 95, 7.6206F, 2.4205F, 44.3576F, 1, 2, 1, 0.0F, false));
        RightPaw.cubeList.add(new ModelBox(RightPaw, 8, 91, 9.6206F, 2.4205F, 44.3576F, 1, 2, 1, 0.0F, false));
        RightPaw.cubeList.add(new ModelBox(RightPaw, 7, 167, 3.6F, -3.1846F, 43.6276F, 7, 6, 2, 0.0F, false));
        RightPaw.cubeList.add(new ModelBox(RightPaw, 2, 97, 9.609F, -5.0263F, 40.3134F, 1, 1, 1, 0.0F, false));
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        Head.render(f5);
        Torso.render(f5);
        LeftFrontLeg.render(f5);
        RightFrontLeg.render(f5);
        HindleftLeg.render(f5);
        HindRighLeg.render(f5);
    }
    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    public void setLivingAnimations(EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4) {
        this.HindRighLeg.rotateAngleX = MathHelper.cos(par2 * 0.6662f) * 1.4f * par3;
        this.HindleftLeg.rotateAngleX = MathHelper.cos(par2 * 0.6662f + 3.1415927f) * 1.4f * par3;
        this.RightFrontLeg.rotateAngleX = MathHelper.cos(par2 * 0.6662f + 3.1415927f) * 1.4f * par3;
        this.LeftFrontLeg.rotateAngleX = MathHelper.cos(par2 * 0.6662f) * 1.4f * par3;
    }

    public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
        super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
        this.Head.rotateAngleX = par5 / 57.295776f;
    }
}
