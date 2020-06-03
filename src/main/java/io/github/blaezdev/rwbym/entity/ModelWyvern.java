package io.github.blaezdev.rwbym.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelWyvern extends ModelBase {
	private final ModelRenderer Body;
	private final ModelRenderer bone173;
	private final ModelRenderer bone175;
	private final ModelRenderer bone176;
	private final ModelRenderer bone177;
	private final ModelRenderer bone178;
	private final ModelRenderer bone179;
	private final ModelRenderer bone180;
	private final ModelRenderer bone181;
	private final ModelRenderer bone182;
	private final ModelRenderer bone183;
	private final ModelRenderer bone184;
	private final ModelRenderer bone185;
	private final ModelRenderer bone174;
	private final ModelRenderer bone2;
	private final ModelRenderer bone3;
	private final ModelRenderer Rightleg;
	private final ModelRenderer bone;
	private final ModelRenderer bone4;
	private final ModelRenderer bone5;
	private final ModelRenderer bone6;
	private final ModelRenderer bone7;
	private final ModelRenderer bone8;
	private final ModelRenderer bone9;
	private final ModelRenderer bone10;
	private final ModelRenderer bone11;
	private final ModelRenderer bone12;
	private final ModelRenderer bone13;
	private final ModelRenderer bone14;
	private final ModelRenderer bone15;
	private final ModelRenderer bone16;
	private final ModelRenderer bone21;
	private final ModelRenderer bone22;
	private final ModelRenderer bone23;
	private final ModelRenderer bone24;
	private final ModelRenderer bone25;
	private final ModelRenderer bone26;
	private final ModelRenderer bone27;
	private final ModelRenderer bone28;
	private final ModelRenderer bone29;
	private final ModelRenderer bone17;
	private final ModelRenderer bone18;
	private final ModelRenderer bone19;
	private final ModelRenderer bone20;
	private final ModelRenderer Leftleg;
	private final ModelRenderer bone30;
	private final ModelRenderer bone31;
	private final ModelRenderer bone32;
	private final ModelRenderer bone33;
	private final ModelRenderer bone34;
	private final ModelRenderer bone35;
	private final ModelRenderer bone36;
	private final ModelRenderer bone37;
	private final ModelRenderer bone38;
	private final ModelRenderer bone39;
	private final ModelRenderer bone40;
	private final ModelRenderer bone41;
	private final ModelRenderer bone42;
	private final ModelRenderer bone43;
	private final ModelRenderer bone44;
	private final ModelRenderer bone45;
	private final ModelRenderer bone46;
	private final ModelRenderer bone47;
	private final ModelRenderer bone48;
	private final ModelRenderer bone49;
	private final ModelRenderer bone50;
	private final ModelRenderer bone51;
	private final ModelRenderer bone52;
	private final ModelRenderer bone53;
	private final ModelRenderer bone54;
	private final ModelRenderer bone55;
	private final ModelRenderer bone56;
	private final ModelRenderer Tail;
	private final ModelRenderer bone57;
	private final ModelRenderer bone58;
	private final ModelRenderer bone59;
	private final ModelRenderer bone60;
	private final ModelRenderer bone61;
	private final ModelRenderer Rightwing;
	private final ModelRenderer bone188;
	private final ModelRenderer bone189;
	private final ModelRenderer bone81;
	private final ModelRenderer bone87;
	private final ModelRenderer bone88;
	private final ModelRenderer bone89;
	private final ModelRenderer bone90;
	private final ModelRenderer bone94;
	private final ModelRenderer bone98;
	private final ModelRenderer bone102;
	private final ModelRenderer bone103;
	private final ModelRenderer bone104;
	private final ModelRenderer bone105;
	private final ModelRenderer bone106;
	private final ModelRenderer bone111;
	private final ModelRenderer bone112;
	private final ModelRenderer bone113;
	private final ModelRenderer bone107;
	private final ModelRenderer bone108;
	private final ModelRenderer bone109;
	private final ModelRenderer bone110;
	private final ModelRenderer bone114;
	private final ModelRenderer bone95;
	private final ModelRenderer bone96;
	private final ModelRenderer bone99;
	private final ModelRenderer bone100;
	private final ModelRenderer bone101;
	private final ModelRenderer bone97;
	private final ModelRenderer bone91;
	private final ModelRenderer bone92;
	private final ModelRenderer bone93;
	private final ModelRenderer bone82;
	private final ModelRenderer bone84;
	private final ModelRenderer bone83;
	private final ModelRenderer bone85;
	private final ModelRenderer bone86;
	private final ModelRenderer bone62;
	private final ModelRenderer bone68;
	private final ModelRenderer bone69;
	private final ModelRenderer bone70;
	private final ModelRenderer bone71;
	private final ModelRenderer bone76;
	private final ModelRenderer bone72;
	private final ModelRenderer bone73;
	private final ModelRenderer bone74;
	private final ModelRenderer bone75;
	private final ModelRenderer bone77;
	private final ModelRenderer bone78;
	private final ModelRenderer bone79;
	private final ModelRenderer bone80;
	private final ModelRenderer bone63;
	private final ModelRenderer bone64;
	private final ModelRenderer bone65;
	private final ModelRenderer bone66;
	private final ModelRenderer bone67;
	private final ModelRenderer LeftWing;
	private final ModelRenderer Bone190;
	private final ModelRenderer bone186;
	private final ModelRenderer bone187;
	private final ModelRenderer bone115;
	private final ModelRenderer bone116;
	private final ModelRenderer bone117;
	private final ModelRenderer bone118;
	private final ModelRenderer bone119;
	private final ModelRenderer bone120;
	private final ModelRenderer bone121;
	private final ModelRenderer bone122;
	private final ModelRenderer bone123;
	private final ModelRenderer bone124;
	private final ModelRenderer bone125;
	private final ModelRenderer bone126;
	private final ModelRenderer bone127;
	private final ModelRenderer bone128;
	private final ModelRenderer bone129;
	private final ModelRenderer bone130;
	private final ModelRenderer bone131;
	private final ModelRenderer bone132;
	private final ModelRenderer bone133;
	private final ModelRenderer bone134;
	private final ModelRenderer bone135;
	private final ModelRenderer bone136;
	private final ModelRenderer bone137;
	private final ModelRenderer bone138;
	private final ModelRenderer bone139;
	private final ModelRenderer bone140;
	private final ModelRenderer bone141;
	private final ModelRenderer bone142;
	private final ModelRenderer bone143;
	private final ModelRenderer bone144;
	private final ModelRenderer bone145;
	private final ModelRenderer bone146;
	private final ModelRenderer bone147;
	private final ModelRenderer bone148;
	private final ModelRenderer bone149;
	private final ModelRenderer bone150;
	private final ModelRenderer bone151;
	private final ModelRenderer bone152;
	private final ModelRenderer bone153;
	private final ModelRenderer bone154;
	private final ModelRenderer bone155;
	private final ModelRenderer bone156;
	private final ModelRenderer bone157;
	private final ModelRenderer bone158;
	private final ModelRenderer bone159;
	private final ModelRenderer bone160;
	private final ModelRenderer bone161;
	private final ModelRenderer bone162;
	private final ModelRenderer bone163;
	private final ModelRenderer bone164;
	private final ModelRenderer bone165;
	private final ModelRenderer bone166;
	private final ModelRenderer bone167;
	private final ModelRenderer Head;
	private final ModelRenderer bone170;
	private final ModelRenderer bone171;
	private final ModelRenderer bone172;
	private final ModelRenderer bone168;
	private final ModelRenderer bone169;

	public ModelWyvern() {
		textureWidth = 115;
		textureHeight = 115;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 7.0F, 0.0F);
		Body.cubeList.add(new ModelBox(Body, 7, 82, -8.0F, -33.0F, -8.0F, 16, 14, 14, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 9, 62, -8.5F, -21.25F, -7.25F, 8, 3, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 2, 61, 0.5F, -21.25F, -7.25F, 8, 3, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 6, 56, 0.5F, -22.25F, -4.25F, 8, 4, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 3, 64, -8.5F, -22.25F, -4.25F, 8, 4, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 6, 56, 0.5F, -21.25F, -1.25F, 8, 3, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 3, 58, 0.5F, -20.25F, 1.5F, 8, 2, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 6, 61, -8.5F, -20.25F, 1.5F, 8, 2, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 3, 70, -8.5F, -21.25F, -1.25F, 8, 3, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 9, 59, -7.25F, -21.5F, -9.5F, 6, 2, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 7, 62, 1.25F, -21.5F, -9.5F, 6, 2, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 7, 82, 0.25F, -22.5F, -12.0F, 6, 2, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 7, 82, -6.25F, -22.5F, -12.0F, 6, 2, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 7, 82, -7.0F, -32.25F, -11.0F, 14, 12, 3, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 7, 82, -5.75F, -31.75F, -14.0F, 12, 11, 3, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 7, 82, -5.25F, -31.25F, -17.0F, 11, 10, 3, 0.0F, false));

		bone173 = new ModelRenderer(this);
		bone173.setRotationPoint(0.25F, -36.25F, -19.0F);
		Body.addChild(bone173);
		setRotationAngle(bone173, 0.6109F, 0.0F, 0.0F);
		bone173.cubeList.add(new ModelBox(bone173, 3, 56, -2.0F, 5.4752F, -1.3905F, 3, 3, 3, 0.0F, false));
		bone173.cubeList.add(new ModelBox(bone173, 3, 58, -1.5F, 5.9021F, 0.842F, 2, 2, 3, 0.0F, false));
		bone173.cubeList.add(new ModelBox(bone173, 3, 53, -1.0F, 6.336F, 2.8898F, 1, 1, 3, 0.0F, false));

		bone175 = new ModelRenderer(this);
		bone175.setRotationPoint(0.25F, -36.25F, -11.75F);
		Body.addChild(bone175);
		setRotationAngle(bone175, 0.8727F, 0.0F, 0.0F);
		bone175.cubeList.add(new ModelBox(bone175, 7, 82, -2.0F, 5.4752F, -1.3905F, 3, 3, 3, 0.0F, false));
		bone175.cubeList.add(new ModelBox(bone175, 8, 52, -1.5F, 5.9021F, 0.842F, 2, 2, 3, 0.0F, false));
		bone175.cubeList.add(new ModelBox(bone175, 11, 65, -1.0F, 6.336F, 2.8898F, 1, 1, 3, 0.0F, false));

		bone176 = new ModelRenderer(this);
		bone176.setRotationPoint(0.25F, -38.25F, -3.75F);
		Body.addChild(bone176);
		setRotationAngle(bone176, 0.8727F, 0.0F, 0.0F);
		bone176.cubeList.add(new ModelBox(bone176, 4, 56, -2.0F, 5.4752F, -1.3905F, 3, 3, 3, 0.0F, false));
		bone176.cubeList.add(new ModelBox(bone176, 3, 59, -1.5F, 5.9021F, 0.842F, 2, 2, 3, 0.0F, false));
		bone176.cubeList.add(new ModelBox(bone176, 0, 64, -1.0F, 6.336F, 2.8898F, 1, 1, 3, 0.0F, false));

		bone177 = new ModelRenderer(this);
		bone177.setRotationPoint(0.25F, -38.25F, 4.25F);
		Body.addChild(bone177);
		setRotationAngle(bone177, 0.9599F, 0.0F, 0.0F);
		bone177.cubeList.add(new ModelBox(bone177, 7, 57, -2.0F, 5.4752F, -1.3905F, 3, 3, 3, 0.0F, false));
		bone177.cubeList.add(new ModelBox(bone177, 5, 57, -1.5F, 5.9021F, 0.842F, 2, 2, 3, 0.0F, false));
		bone177.cubeList.add(new ModelBox(bone177, 1, 67, -1.0F, 6.336F, 2.8898F, 1, 1, 3, 0.0F, false));

		bone178 = new ModelRenderer(this);
		bone178.setRotationPoint(0.25F, -38.25F, 14.25F);
		Body.addChild(bone178);
		setRotationAngle(bone178, 0.9599F, 0.0F, 0.0F);
		bone178.cubeList.add(new ModelBox(bone178, 7, 82, -2.0F, 5.4752F, -1.3905F, 3, 3, 3, 0.0F, false));
		bone178.cubeList.add(new ModelBox(bone178, 0, 59, -1.5F, 5.9021F, 0.842F, 2, 2, 3, 0.0F, false));
		bone178.cubeList.add(new ModelBox(bone178, 4, 62, -1.0F, 6.336F, 2.8898F, 1, 1, 3, 0.0F, false));

		bone179 = new ModelRenderer(this);
		bone179.setRotationPoint(0.25F, -38.25F, 27.25F);
		Body.addChild(bone179);
		setRotationAngle(bone179, 0.6981F, 0.0F, 0.0F);
		bone179.cubeList.add(new ModelBox(bone179, 3, 61, -2.0F, 5.4752F, -1.3905F, 3, 3, 3, 0.0F, false));
		bone179.cubeList.add(new ModelBox(bone179, 3, 67, -1.5F, 5.9021F, 0.842F, 2, 2, 3, 0.0F, false));
		bone179.cubeList.add(new ModelBox(bone179, 6, 62, -1.0F, 6.336F, 2.8898F, 1, 1, 3, 0.0F, false));

		bone180 = new ModelRenderer(this);
		bone180.setRotationPoint(0.25F, -36.0F, 36.25F);
		Body.addChild(bone180);
		setRotationAngle(bone180, 0.6109F, 0.0F, 0.0F);
		bone180.cubeList.add(new ModelBox(bone180, 7, 82, -2.0F, 5.4752F, -1.3905F, 3, 3, 3, 0.0F, false));
		bone180.cubeList.add(new ModelBox(bone180, 1, 61, -1.5F, 5.9021F, 0.842F, 2, 2, 3, 0.0F, false));
		bone180.cubeList.add(new ModelBox(bone180, 2, 59, -1.0F, 6.336F, 2.8898F, 1, 1, 3, 0.0F, false));

		bone181 = new ModelRenderer(this);
		bone181.setRotationPoint(0.25F, -33.75F, 45.5F);
		Body.addChild(bone181);
		setRotationAngle(bone181, 0.5236F, 0.0F, 0.0F);
		bone181.cubeList.add(new ModelBox(bone181, 7, 82, -2.0F, 5.4752F, -1.3905F, 3, 3, 3, 0.0F, false));
		bone181.cubeList.add(new ModelBox(bone181, 4, 65, -1.5F, 5.9021F, 0.842F, 2, 2, 3, 0.0F, false));
		bone181.cubeList.add(new ModelBox(bone181, 0, 65, -1.0F, 6.336F, 2.8898F, 1, 1, 3, 0.0F, false));

		bone182 = new ModelRenderer(this);
		bone182.setRotationPoint(0.25F, -32.25F, 57.0F);
		Body.addChild(bone182);
		setRotationAngle(bone182, 0.5236F, 0.0F, 0.0F);
		bone182.cubeList.add(new ModelBox(bone182, 7, 82, -2.0F, 5.4752F, -1.3905F, 3, 3, 3, 0.0F, false));
		bone182.cubeList.add(new ModelBox(bone182, 2, 64, -1.5F, 5.9021F, 0.842F, 2, 2, 3, 0.0F, false));
		bone182.cubeList.add(new ModelBox(bone182, 3, 65, -1.0F, 6.336F, 2.8898F, 1, 1, 3, 0.0F, false));

		bone183 = new ModelRenderer(this);
		bone183.setRotationPoint(0.25F, -31.25F, 67.75F);
		Body.addChild(bone183);
		setRotationAngle(bone183, 0.5236F, 0.0F, 0.0F);
		bone183.cubeList.add(new ModelBox(bone183, 7, 82, -2.0F, 5.4752F, -1.3905F, 3, 3, 3, 0.0F, false));
		bone183.cubeList.add(new ModelBox(bone183, 7, 82, -1.5F, 5.9021F, 0.842F, 2, 2, 3, 0.0F, false));
		bone183.cubeList.add(new ModelBox(bone183, 1, 65, -1.0F, 6.336F, 2.8898F, 1, 1, 3, 0.0F, false));

		bone184 = new ModelRenderer(this);
		bone184.setRotationPoint(0.25F, -30.25F, 78.0F);
		Body.addChild(bone184);
		setRotationAngle(bone184, 0.5236F, 0.0F, 0.0F);
		bone184.cubeList.add(new ModelBox(bone184, 7, 82, -2.0F, 5.4752F, -1.3905F, 3, 3, 3, 0.0F, false));
		bone184.cubeList.add(new ModelBox(bone184, 7, 82, -1.5F, 5.9021F, 0.842F, 2, 2, 3, 0.0F, false));
		bone184.cubeList.add(new ModelBox(bone184, 7, 82, -1.0F, 6.336F, 2.8898F, 1, 1, 3, 0.0F, false));

		bone185 = new ModelRenderer(this);
		bone185.setRotationPoint(0.25F, -27.75F, 88.5F);
		Body.addChild(bone185);
		setRotationAngle(bone185, 0.5236F, 0.0F, 0.0F);
		bone185.cubeList.add(new ModelBox(bone185, 7, 82, -2.0F, 5.4752F, -1.3905F, 3, 3, 3, 0.0F, false));
		bone185.cubeList.add(new ModelBox(bone185, 7, 82, -1.5F, 5.9021F, 0.842F, 2, 2, 3, 0.0F, false));
		bone185.cubeList.add(new ModelBox(bone185, 7, 82, -1.0F, 6.336F, 2.8898F, 1, 1, 3, 0.0F, false));

		bone174 = new ModelRenderer(this);
		bone174.setRotationPoint(0.25F, -36.25F, -19.0F);
		Body.addChild(bone174);
		setRotationAngle(bone174, 0.6109F, 0.0F, 0.0F);
		bone174.cubeList.add(new ModelBox(bone174, 7, 82, -2.0F, 5.4752F, -1.3905F, 3, 3, 3, 0.0F, false));

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, -21.0F, 2.0F);
		Body.addChild(bone2);
		setRotationAngle(bone2, 0.0349F, 0.0F, 0.0F);
		bone2.cubeList.add(new ModelBox(bone2, 7, 82, -6.0F, -13.0F, -3.0F, 12, 13, 11, 0.0F, false));
		bone2.cubeList.add(new ModelBox(bone2, 7, 82, -6.0F, -13.0F, 8.0F, 12, 12, 6, 0.0F, false));

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, -21.5F, 14.5F);
		Body.addChild(bone3);
		setRotationAngle(bone3, -0.0524F, 0.0F, 0.0F);
		bone3.cubeList.add(new ModelBox(bone3, 7, 82, -6.0F, -13.4993F, -0.0262F, 12, 11, 8, 0.0F, false));
		bone3.cubeList.add(new ModelBox(bone3, 7, 82, -6.0F, -11.447F, 6.9752F, 12, 9, 13, 0.0F, false));

		Rightleg = new ModelRenderer(this);
		Rightleg.setRotationPoint(-4.5F, -18.0F, 23.0F);
		setRotationAngle(Rightleg, -0.7854F, 0.0F, 0.0F);
		Rightleg.cubeList.add(new ModelBox(Rightleg, 5, 89, -6.5F, -8.9477F, 0.0014F, 7, 9, 11, 0.0F, false));

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 0.1768F, 9.9445F);
		Rightleg.addChild(bone);
		setRotationAngle(bone, 0.2618F, 0.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 5, 89, -6.0F, -8.1397F, 0.4407F, 6, 8, 9, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 9, 59, -6.25F, -0.9949F, 4.5657F, 1, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 3, 61, -5.75F, -0.8544F, 7.8223F, 1, 1, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 7, 65, -2.25F, -0.861F, 1.3336F, 2, 1, 2, 0.0F, false));

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(0.0F, -6.364F, 14.0104F);
		Rightleg.addChild(bone4);
		setRotationAngle(bone4, -0.6981F, 0.0F, 0.0F);
		bone4.cubeList.add(new ModelBox(bone4, 5, 89, -5.5F, -8.1614F, 0.1916F, 5, 8, 6, 0.0F, false));
		bone4.cubeList.add(new ModelBox(bone4, 5, 89, -5.0F, -12.222F, 0.8055F, 4, 5, 5, 0.0F, false));
		bone4.cubeList.add(new ModelBox(bone4, 5, 89, -4.25F, -16.2029F, 1.2413F, 3, 4, 4, 0.0F, false));

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(-1.25F, -15.4905F, 0.2179F);
		bone4.addChild(bone5);
		setRotationAngle(bone5, 0.1745F, 0.0F, 0.0F);
		bone5.cubeList.add(new ModelBox(bone5, 5, 89, -2.5F, -1.4138F, 1.2887F, 2, 2, 8, 0.0F, false));
		bone5.cubeList.add(new ModelBox(bone5, 5, 89, -3.5F, -2.1162F, 8.3945F, 4, 3, 4, 0.0F, false));
		bone5.cubeList.add(new ModelBox(bone5, 5, 89, -3.0F, -2.1683F, 6.3026F, 3, 3, 3, 0.0F, false));

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(7.5F, 15.0F, 0.0F);
		bone5.addChild(bone6);
		bone6.cubeList.add(new ModelBox(bone6, 5, 89, -8.0F, -16.3872F, 12.0814F, 1, 2, 3, 0.0F, false));

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(0.0F, -13.6464F, 14.3876F);
		bone6.addChild(bone7);
		setRotationAngle(bone7, -0.3491F, 0.0F, 0.0F);
		bone7.cubeList.add(new ModelBox(bone7, 5, 89, -8.0F, -5.0479F, -2.9272F, 1, 1, 3, 0.0F, false));
		bone7.cubeList.add(new ModelBox(bone7, 5, 89, -8.0F, -4.8354F, -0.7279F, 0, 4, 1, 0.0F, false));

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(0.0F, 14.7347F, -11.9243F);
		bone7.addChild(bone8);
		setRotationAngle(bone8, 0.1745F, 0.0F, 0.0F);
		bone8.cubeList.add(new ModelBox(bone8, 8, 68, -8.0F, -17.7864F, 11.5842F, 1, 1, 1, 0.0F, false));

		bone9 = new ModelRenderer(this);
		bone9.setRotationPoint(6.0F, 15.0F, 0.0F);
		bone5.addChild(bone9);
		bone9.cubeList.add(new ModelBox(bone9, 5, 89, -8.0F, -16.3872F, 12.0814F, 1, 2, 3, 0.0F, false));

		bone10 = new ModelRenderer(this);
		bone10.setRotationPoint(0.0F, -13.6464F, 14.3876F);
		bone9.addChild(bone10);
		setRotationAngle(bone10, -0.3491F, 0.0F, 0.0F);
		bone10.cubeList.add(new ModelBox(bone10, 5, 89, -8.0F, -5.0479F, -2.9272F, 1, 1, 3, 0.0F, false));
		bone10.cubeList.add(new ModelBox(bone10, 5, 89, -8.0F, -4.8354F, -0.7279F, 1, 4, 1, 0.0F, false));

		bone11 = new ModelRenderer(this);
		bone11.setRotationPoint(0.0F, 14.7347F, -11.9243F);
		bone10.addChild(bone11);
		setRotationAngle(bone11, 0.1745F, 0.0F, 0.0F);
		bone11.cubeList.add(new ModelBox(bone11, 5, 68, -8.0F, -17.7864F, 11.5842F, 1, 1, 1, 0.0F, false));

		bone12 = new ModelRenderer(this);
		bone12.setRotationPoint(4.5F, 15.0F, 0.0F);
		bone5.addChild(bone12);
		bone12.cubeList.add(new ModelBox(bone12, 5, 89, -8.0F, -16.3872F, 12.0814F, 1, 2, 3, 0.0F, false));
		bone12.cubeList.add(new ModelBox(bone12, 5, 57, -8.0F, -14.8915F, 10.1016F, 1, 1, 2, 0.0F, false));
		bone12.cubeList.add(new ModelBox(bone12, 4, 68, -6.5F, -14.8915F, 10.1016F, 1, 1, 2, 0.0F, false));
		bone12.cubeList.add(new ModelBox(bone12, 3, 71, -5.0F, -14.8915F, 10.1016F, 1, 1, 2, 0.0F, false));

		bone13 = new ModelRenderer(this);
		bone13.setRotationPoint(0.0F, -13.6464F, 14.3876F);
		bone12.addChild(bone13);
		setRotationAngle(bone13, -0.3491F, 0.0F, 0.0F);
		bone13.cubeList.add(new ModelBox(bone13, 5, 89, -8.0F, -5.0479F, -2.9272F, 1, 1, 3, 0.0F, false));
		bone13.cubeList.add(new ModelBox(bone13, 5, 89, -8.0F, -4.8354F, -0.7279F, 1, 4, 1, 0.0F, false));

		bone14 = new ModelRenderer(this);
		bone14.setRotationPoint(0.0F, 14.7347F, -11.9243F);
		bone13.addChild(bone14);
		setRotationAngle(bone14, 0.1745F, 0.0F, 0.0F);
		bone14.cubeList.add(new ModelBox(bone14, 3, 68, -8.0F, -17.7864F, 11.5842F, 1, 1, 1, 0.0F, false));

		bone15 = new ModelRenderer(this);
		bone15.setRotationPoint(-7.0F, -13.9346F, 0.7471F);
		bone14.addChild(bone15);
		setRotationAngle(bone15, -0.0873F, 0.0F, 0.0F);
		bone15.cubeList.add(new ModelBox(bone15, 4, 66, 0.5F, 0.3448F, -0.5644F, 1, 1, 3, 0.0F, false));

		bone16 = new ModelRenderer(this);
		bone16.setRotationPoint(0.0F, 0.25F, -2.0F);
		bone15.addChild(bone16);
		setRotationAngle(bone16, 0.1745F, 0.0F, 0.0F);
		bone16.cubeList.add(new ModelBox(bone16, 10, 58, 0.5F, 0.3448F, -0.5644F, 1, 1, 2, 0.0F, false));

		bone21 = new ModelRenderer(this);
		bone21.setRotationPoint(-7.0F, 6.1013F, 6.021F);
		bone14.addChild(bone21);
		setRotationAngle(bone21, 2.2689F, 0.0F, 0.0F);
		bone21.cubeList.add(new ModelBox(bone21, 2, 59, -0.5F, -0.6552F, -0.5644F, 3, 2, 3, 0.0F, false));

		bone22 = new ModelRenderer(this);
		bone22.setRotationPoint(0.0F, -0.2803F, -1.4697F);
		bone21.addChild(bone22);
		setRotationAngle(bone22, -0.1745F, 0.0F, 0.0F);
		bone22.cubeList.add(new ModelBox(bone22, 7, 65, 0.0F, -0.0648F, -0.2776F, 2, 1, 2, 0.0F, false));

		bone23 = new ModelRenderer(this);
		bone23.setRotationPoint(1.0F, 1.0F, 0.0F);
		bone22.addChild(bone23);
		setRotationAngle(bone23, -0.2618F, 0.0F, 0.0F);
		bone23.cubeList.add(new ModelBox(bone23, 3, 66, -0.5F, -1.0808F, -1.9608F, 1, 1, 2, 0.0F, false));

		bone24 = new ModelRenderer(this);
		bone24.setRotationPoint(-7.0F, 6.8578F, 3.1943F);
		bone14.addChild(bone24);
		setRotationAngle(bone24, 2.0071F, 0.0F, 0.0F);
		bone24.cubeList.add(new ModelBox(bone24, 5, 89, -0.5F, -0.6552F, -0.5644F, 3, 2, 3, 0.0F, false));

		bone25 = new ModelRenderer(this);
		bone25.setRotationPoint(0.0F, -0.2803F, -1.4697F);
		bone24.addChild(bone25);
		setRotationAngle(bone25, -0.1745F, 0.0F, 0.0F);
		bone25.cubeList.add(new ModelBox(bone25, 7, 64, 0.0F, -0.0648F, -0.2776F, 2, 1, 2, 0.0F, false));

		bone26 = new ModelRenderer(this);
		bone26.setRotationPoint(1.0F, 1.0F, 0.0F);
		bone25.addChild(bone26);
		setRotationAngle(bone26, -0.2618F, 0.0F, 0.0F);
		bone26.cubeList.add(new ModelBox(bone26, 1, 64, -0.5F, -1.0808F, -1.9608F, 1, 1, 2, 0.0F, false));

		bone27 = new ModelRenderer(this);
		bone27.setRotationPoint(-7.0F, 2.3002F, 5.6007F);
		bone14.addChild(bone27);
		setRotationAngle(bone27, 2.9671F, 0.0F, 0.0F);
		bone27.cubeList.add(new ModelBox(bone27, 6, 65, -0.5F, -0.6552F, -0.5644F, 3, 2, 3, 0.0F, false));

		bone28 = new ModelRenderer(this);
		bone28.setRotationPoint(0.0F, -0.2803F, -1.4697F);
		bone27.addChild(bone28);
		setRotationAngle(bone28, -0.1745F, 0.0F, 0.0F);
		bone28.cubeList.add(new ModelBox(bone28, 11, 56, 0.0F, -0.0648F, -0.2776F, 2, 1, 2, 0.0F, false));

		bone29 = new ModelRenderer(this);
		bone29.setRotationPoint(1.0F, 1.0F, 0.0F);
		bone28.addChild(bone29);
		setRotationAngle(bone29, -0.2618F, 0.0F, 0.0F);
		bone29.cubeList.add(new ModelBox(bone29, 5, 63, -0.5F, -1.0808F, -1.9608F, 1, 1, 2, 0.0F, false));

		bone17 = new ModelRenderer(this);
		bone17.setRotationPoint(-7.0F, -14.7347F, 3.0757F);
		bone14.addChild(bone17);
		setRotationAngle(bone17, -0.4363F, 0.0F, 0.0F);
		bone17.cubeList.add(new ModelBox(bone17, 2, 63, 0.5F, 0.3448F, -0.5644F, 1, 1, 3, 0.0F, false));

		bone18 = new ModelRenderer(this);
		bone18.setRotationPoint(0.0F, 0.25F, -2.0F);
		bone17.addChild(bone18);
		setRotationAngle(bone18, 0.1745F, 0.0F, 0.0F);
		bone18.cubeList.add(new ModelBox(bone18, 4, 61, 0.5F, 0.3448F, -0.5644F, 1, 1, 2, 0.0F, false));

		bone19 = new ModelRenderer(this);
		bone19.setRotationPoint(-7.0F, -12.4186F, 0.8655F);
		bone14.addChild(bone19);
		setRotationAngle(bone19, 0.0873F, 0.0F, 0.0F);
		bone19.cubeList.add(new ModelBox(bone19, 5, 89, 0.5F, 0.3448F, -0.5644F, 1, 1, 3, 0.0F, false));

		bone20 = new ModelRenderer(this);
		bone20.setRotationPoint(0.0F, 0.25F, -2.0F);
		bone19.addChild(bone20);
		setRotationAngle(bone20, 0.1745F, 0.0F, 0.0F);
		bone20.cubeList.add(new ModelBox(bone20, 4, 62, 0.5F, 0.3448F, -0.5644F, 1, 1, 2, 0.0F, false));

		Leftleg = new ModelRenderer(this);
		Leftleg.setRotationPoint(10.5F, -17.75F, 23.0F);
		setRotationAngle(Leftleg, -0.7854F, 0.0F, 0.0F);
		Leftleg.cubeList.add(new ModelBox(Leftleg, 4, 95, -6.5F, -8.9477F, 0.0014F, 7, 9, 11, 0.0F, false));

		bone30 = new ModelRenderer(this);
		bone30.setRotationPoint(0.0F, 0.1768F, 9.9445F);
		Leftleg.addChild(bone30);
		setRotationAngle(bone30, 0.2618F, 0.0F, 0.0F);
		bone30.cubeList.add(new ModelBox(bone30, 4, 95, -6.0F, -8.1397F, 0.4407F, 6, 8, 9, 0.0F, false));
		bone30.cubeList.add(new ModelBox(bone30, 7, 64, -1.25F, -0.7066F, 0.6907F, 2, 1, 2, 0.0F, false));
		bone30.cubeList.add(new ModelBox(bone30, 8, 59, -4.25F, -0.7156F, 2.7062F, 1, 1, 1, 0.0F, false));
		bone30.cubeList.add(new ModelBox(bone30, 4, 95, -0.75F, -1.3741F, 4.3468F, 1, 1, 1, 0.0F, false));
		bone30.cubeList.add(new ModelBox(bone30, 8, 54, -5.75F, -1.0081F, 5.7128F, 1, 1, 1, 0.0F, false));
		bone30.cubeList.add(new ModelBox(bone30, 4, 95, -6.0F, -8.1397F, 0.4407F, 6, 8, 9, 0.0F, false));

		bone31 = new ModelRenderer(this);
		bone31.setRotationPoint(0.0F, -6.364F, 14.0104F);
		Leftleg.addChild(bone31);
		setRotationAngle(bone31, -0.6981F, 0.0F, 0.0F);
		bone31.cubeList.add(new ModelBox(bone31, 4, 95, -5.5F, -8.1614F, 0.1916F, 5, 8, 6, 0.0F, false));
		bone31.cubeList.add(new ModelBox(bone31, 4, 95, -5.0F, -12.222F, 0.8055F, 4, 5, 5, 0.0F, false));
		bone31.cubeList.add(new ModelBox(bone31, 4, 95, -4.25F, -16.2029F, 1.2413F, 3, 4, 4, 0.0F, false));

		bone32 = new ModelRenderer(this);
		bone32.setRotationPoint(-1.25F, -15.4905F, 0.2179F);
		bone31.addChild(bone32);
		setRotationAngle(bone32, 0.1745F, 0.0F, 0.0F);
		bone32.cubeList.add(new ModelBox(bone32, 4, 95, -2.5F, -1.4138F, 1.2887F, 2, 2, 8, 0.0F, false));
		bone32.cubeList.add(new ModelBox(bone32, 4, 95, -3.5F, -2.1162F, 8.3945F, 4, 3, 4, 0.0F, false));
		bone32.cubeList.add(new ModelBox(bone32, 4, 95, -3.0F, -2.1683F, 6.3026F, 3, 3, 3, 0.0F, false));

		bone33 = new ModelRenderer(this);
		bone33.setRotationPoint(7.5F, 15.0F, 0.0F);
		bone32.addChild(bone33);
		bone33.cubeList.add(new ModelBox(bone33, 4, 95, -8.0F, -16.3872F, 12.0814F, 1, 2, 3, 0.0F, false));

		bone34 = new ModelRenderer(this);
		bone34.setRotationPoint(0.0F, -13.6464F, 14.3876F);
		bone33.addChild(bone34);
		setRotationAngle(bone34, -0.3491F, 0.0F, 0.0F);
		bone34.cubeList.add(new ModelBox(bone34, 4, 95, -8.0F, -5.0479F, -2.9272F, 1, 1, 3, 0.0F, false));
		bone34.cubeList.add(new ModelBox(bone34, 4, 95, -8.0F, -4.8354F, -0.7279F, 1, 4, 1, 0.0F, false));

		bone35 = new ModelRenderer(this);
		bone35.setRotationPoint(0.0F, 14.7347F, -11.9243F);
		bone34.addChild(bone35);
		setRotationAngle(bone35, 0.1745F, 0.0F, 0.0F);
		bone35.cubeList.add(new ModelBox(bone35, 4, 61, -8.0F, -17.7864F, 11.5842F, 1, 1, 1, 0.0F, false));

		bone36 = new ModelRenderer(this);
		bone36.setRotationPoint(6.0F, 15.0F, 0.0F);
		bone32.addChild(bone36);
		bone36.cubeList.add(new ModelBox(bone36, 4, 95, -8.0F, -16.3872F, 12.0814F, 1, 2, 3, 0.0F, false));

		bone37 = new ModelRenderer(this);
		bone37.setRotationPoint(0.0F, -13.6464F, 14.3876F);
		bone36.addChild(bone37);
		setRotationAngle(bone37, -0.3491F, 0.0F, 0.0F);
		bone37.cubeList.add(new ModelBox(bone37, 4, 95, -8.0F, -5.0479F, -2.9272F, 1, 1, 3, 0.0F, false));
		bone37.cubeList.add(new ModelBox(bone37, 4, 95, -8.0F, -4.8354F, -0.7279F, 1, 4, 1, 0.0F, false));

		bone38 = new ModelRenderer(this);
		bone38.setRotationPoint(0.0F, 14.7347F, -11.9243F);
		bone37.addChild(bone38);
		setRotationAngle(bone38, 0.1745F, 0.0F, 0.0F);
		bone38.cubeList.add(new ModelBox(bone38, 0, 65, -8.0F, -17.7864F, 11.5842F, 1, 1, 1, 0.0F, false));

		bone39 = new ModelRenderer(this);
		bone39.setRotationPoint(4.5F, 15.0F, 0.0F);
		bone32.addChild(bone39);
		bone39.cubeList.add(new ModelBox(bone39, 4, 95, -8.0F, -16.3872F, 12.0814F, 1, 2, 3, 0.0F, false));
		bone39.cubeList.add(new ModelBox(bone39, 3, 60, -8.0F, -14.8915F, 10.1016F, 1, 1, 2, 0.0F, false));
		bone39.cubeList.add(new ModelBox(bone39, 6, 58, -6.5F, -14.8915F, 10.1016F, 1, 1, 2, 0.0F, false));
		bone39.cubeList.add(new ModelBox(bone39, 0, 64, -5.0F, -14.8915F, 10.1016F, 1, 1, 2, 0.0F, false));

		bone40 = new ModelRenderer(this);
		bone40.setRotationPoint(0.0F, -13.6464F, 14.3876F);
		bone39.addChild(bone40);
		setRotationAngle(bone40, -0.3491F, 0.0F, 0.0F);
		bone40.cubeList.add(new ModelBox(bone40, 4, 95, -8.0F, -5.0479F, -2.9272F, 1, 1, 3, 0.0F, false));
		bone40.cubeList.add(new ModelBox(bone40, 4, 95, -8.0F, -4.8354F, -0.7279F, 1, 4, 1, 0.0F, false));

		bone41 = new ModelRenderer(this);
		bone41.setRotationPoint(0.0F, 14.7347F, -11.9243F);
		bone40.addChild(bone41);
		setRotationAngle(bone41, 0.1745F, 0.0F, 0.0F);
		bone41.cubeList.add(new ModelBox(bone41, 5, 67, -8.0F, -17.7864F, 11.5842F, 1, 1, 1, 0.0F, false));

		bone42 = new ModelRenderer(this);
		bone42.setRotationPoint(-7.0F, -13.9346F, 0.7471F);
		bone41.addChild(bone42);
		setRotationAngle(bone42, -0.0873F, 0.0F, 0.0F);
		bone42.cubeList.add(new ModelBox(bone42, 4, 55, 0.5F, 0.3448F, -0.5644F, 1, 1, 3, 0.0F, false));

		bone43 = new ModelRenderer(this);
		bone43.setRotationPoint(0.0F, 0.25F, -2.0F);
		bone42.addChild(bone43);
		setRotationAngle(bone43, 0.1745F, 0.0F, 0.0F);
		bone43.cubeList.add(new ModelBox(bone43, 2, 62, 0.5F, 0.3448F, -0.5644F, 1, 1, 2, 0.0F, false));

		bone44 = new ModelRenderer(this);
		bone44.setRotationPoint(-7.0F, 6.1013F, 6.021F);
		bone41.addChild(bone44);
		setRotationAngle(bone44, 2.2689F, 0.0F, 0.0F);
		bone44.cubeList.add(new ModelBox(bone44, 1, 62, -0.5F, -0.6552F, -0.5644F, 3, 2, 3, 0.0F, false));

		bone45 = new ModelRenderer(this);
		bone45.setRotationPoint(0.0F, -0.2803F, -1.4697F);
		bone44.addChild(bone45);
		setRotationAngle(bone45, -0.1745F, 0.0F, 0.0F);
		bone45.cubeList.add(new ModelBox(bone45, 2, 65, 0.0F, -0.0648F, -0.2776F, 2, 1, 2, 0.0F, false));

		bone46 = new ModelRenderer(this);
		bone46.setRotationPoint(1.0F, 1.0F, 0.0F);
		bone45.addChild(bone46);
		setRotationAngle(bone46, -0.2618F, 0.0F, 0.0F);
		bone46.cubeList.add(new ModelBox(bone46, 3, 62, -0.5F, -1.0808F, -1.9608F, 1, 1, 2, 0.0F, false));

		bone47 = new ModelRenderer(this);
		bone47.setRotationPoint(-7.0F, 6.8578F, 3.1943F);
		bone41.addChild(bone47);
		setRotationAngle(bone47, 2.0071F, 0.0F, 0.0F);
		bone47.cubeList.add(new ModelBox(bone47, 4, 95, -0.5F, -0.6552F, -0.5644F, 3, 2, 3, 0.0F, false));

		bone48 = new ModelRenderer(this);
		bone48.setRotationPoint(0.0F, -0.2803F, -1.4697F);
		bone47.addChild(bone48);
		setRotationAngle(bone48, -0.1745F, 0.0F, 0.0F);
		bone48.cubeList.add(new ModelBox(bone48, 7, 65, 0.0F, -0.0648F, -0.2776F, 2, 1, 2, 0.0F, false));

		bone49 = new ModelRenderer(this);
		bone49.setRotationPoint(1.0F, 1.0F, 0.0F);
		bone48.addChild(bone49);
		setRotationAngle(bone49, -0.2618F, 0.0F, 0.0F);
		bone49.cubeList.add(new ModelBox(bone49, 7, 62, -0.5F, -1.0808F, -1.9608F, 1, 1, 2, 0.0F, false));

		bone50 = new ModelRenderer(this);
		bone50.setRotationPoint(-7.0F, 2.3002F, 5.6007F);
		bone41.addChild(bone50);
		setRotationAngle(bone50, 2.9671F, 0.0F, 0.0F);
		bone50.cubeList.add(new ModelBox(bone50, 4, 95, -0.5F, -0.6552F, -0.5644F, 3, 2, 3, 0.0F, false));

		bone51 = new ModelRenderer(this);
		bone51.setRotationPoint(0.0F, -0.2803F, -1.4697F);
		bone50.addChild(bone51);
		setRotationAngle(bone51, -0.1745F, 0.0F, 0.0F);
		bone51.cubeList.add(new ModelBox(bone51, 0, 63, -1.0F, -0.0648F, -0.2776F, 3, 1, 2, 0.0F, false));

		bone52 = new ModelRenderer(this);
		bone52.setRotationPoint(1.0F, 1.0F, 0.0F);
		bone51.addChild(bone52);
		setRotationAngle(bone52, -0.2618F, 0.0F, 0.0F);
		bone52.cubeList.add(new ModelBox(bone52, 3, 69, -0.5F, -1.0808F, -1.9608F, 1, 1, 2, 0.0F, false));

		bone53 = new ModelRenderer(this);
		bone53.setRotationPoint(-7.0F, -14.7347F, 3.0757F);
		bone41.addChild(bone53);
		setRotationAngle(bone53, -0.4363F, 0.0F, 0.0F);
		bone53.cubeList.add(new ModelBox(bone53, 4, 68, 0.5F, 0.3448F, -0.5644F, 1, 1, 3, 0.0F, false));

		bone54 = new ModelRenderer(this);
		bone54.setRotationPoint(0.0F, 0.25F, -2.0F);
		bone53.addChild(bone54);
		setRotationAngle(bone54, 0.1745F, 0.0F, 0.0F);
		bone54.cubeList.add(new ModelBox(bone54, 5, 60, 0.5F, 0.3448F, -0.5644F, 1, 1, 2, 0.0F, false));

		bone55 = new ModelRenderer(this);
		bone55.setRotationPoint(-7.0F, -12.4186F, 0.8655F);
		bone41.addChild(bone55);
		setRotationAngle(bone55, 0.0873F, 0.0F, 0.0F);
		bone55.cubeList.add(new ModelBox(bone55, 4, 95, 0.5F, 0.3448F, -0.5644F, 1, 1, 3, 0.0F, false));

		bone56 = new ModelRenderer(this);
		bone56.setRotationPoint(0.0F, 0.25F, -2.0F);
		bone55.addChild(bone56);
		setRotationAngle(bone56, 0.1745F, 0.0F, 0.0F);
		bone56.cubeList.add(new ModelBox(bone56, 6, 49, 0.5F, 0.3448F, -0.5644F, 1, 1, 2, 0.0F, false));

		Tail = new ModelRenderer(this);
		Tail.setRotationPoint(0.0F, -15.75F, 33.25F);
		setRotationAngle(Tail, -0.1745F, 0.0F, 0.0F);
		Tail.cubeList.add(new ModelBox(Tail, 0, 85, -5.0F, -8.5984F, -0.0549F, 10, 8, 13, 0.0F, false));
		Tail.cubeList.add(new ModelBox(Tail, 0, 85, -5.0F, -9.9174F, -12.4109F, 10, 8, 17, 0.0F, false));

		bone57 = new ModelRenderer(this);
		bone57.setRotationPoint(0.0F, 3.0F, 13.0F);
		Tail.addChild(bone57);
		setRotationAngle(bone57, 0.0873F, 0.0F, 0.0F);
		bone57.cubeList.add(new ModelBox(bone57, 0, 85, -4.5F, -11.4749F, -0.7817F, 9, 8, 12, 0.0F, false));

		bone58 = new ModelRenderer(this);
		bone58.setRotationPoint(0.0F, -2.0121F, 23.4989F);
		Tail.addChild(bone58);
		setRotationAngle(bone58, 0.1745F, 0.0F, 0.0F);
		bone58.cubeList.add(new ModelBox(bone58, 0, 85, -4.0F, -6.973F, 0.1747F, 8, 7, 10, 0.0F, false));

		bone59 = new ModelRenderer(this);
		bone59.setRotationPoint(0.0F, -3.575F, 32.3622F);
		Tail.addChild(bone59);
		setRotationAngle(bone59, 0.0873F, 0.0F, 0.0F);
		bone59.cubeList.add(new ModelBox(bone59, 0, 85, -4.0F, -6.973F, 0.1747F, 8, 7, 10, 0.0F, false));

		bone60 = new ModelRenderer(this);
		bone60.setRotationPoint(0.0F, -4.3267F, 42.3839F);
		Tail.addChild(bone60);
		setRotationAngle(bone60, 0.0873F, 0.0F, 0.0F);
		bone60.cubeList.add(new ModelBox(bone60, 0, 85, -3.5F, -6.7239F, 0.1965F, 7, 6, 10, 0.0F, false));
		bone60.cubeList.add(new ModelBox(bone60, 0, 85, -2.5F, -5.7057F, 20.1111F, 5, 4, 10, 0.0F, false));
		bone60.cubeList.add(new ModelBox(bone60, 0, 85, -2.0F, -5.1539F, 28.1024F, 4, 3, 5, 0.0F, false));
		bone60.cubeList.add(new ModelBox(bone60, 0, 85, -1.5F, -4.7516F, 32.0654F, 3, 2, 5, 0.0F, false));
		bone60.cubeList.add(new ModelBox(bone60, 0, 85, -3.0F, -6.3284F, 10.0184F, 6, 5, 10, 0.0F, false));

		bone61 = new ModelRenderer(this);
		bone61.setRotationPoint(0.0F, 5.0F, -26.0F);
		bone60.addChild(bone61);
		bone61.cubeList.add(new ModelBox(bone61, 0, 85, -2.0F, -9.6239F, 62.3428F, 4, 1, 4, 0.0F, false));
		bone61.cubeList.add(new ModelBox(bone61, 0, 85, -1.75F, -9.82F, 64.5842F, 1, 1, 1, 0.0F, false));
		bone61.cubeList.add(new ModelBox(bone61, 0, 85, 0.25F, -9.7328F, 63.588F, 1, 1, 1, 0.0F, false));
		bone61.cubeList.add(new ModelBox(bone61, 0, 85, -1.0F, -10.0348F, 61.303F, 1, 1, 1, 0.0F, false));
		bone61.cubeList.add(new ModelBox(bone61, 0, 85, 0.25F, -9.9041F, 59.8087F, 1, 1, 1, 0.0F, false));
		bone61.cubeList.add(new ModelBox(bone61, 0, 85, -0.5F, -9.6837F, 65.9384F, 1, 1, 4, 0.0F, false));
		bone61.cubeList.add(new ModelBox(bone61, 0, 67, -0.5F, -10.0417F, 69.1619F, 1, 1, 2, 0.0F, false));
		bone61.cubeList.add(new ModelBox(bone61, 0, 85, -0.5F, -9.0549F, 64.4877F, 1, 1, 4, 0.0F, false));
		bone61.cubeList.add(new ModelBox(bone61, 0, 68, -2.0F, -8.9677F, 63.4915F, 1, 1, 4, 0.0F, false));
		bone61.cubeList.add(new ModelBox(bone61, 0, 61, 1.0F, -8.9677F, 63.4915F, 1, 1, 4, 0.0F, false));

		Rightwing = new ModelRenderer(this);
		Rightwing.setRotationPoint(-7.25F, -17.5767F, -2.3661F);
		setRotationAngle(Rightwing, 0.0F, 0.0F, 0.2618F);
		Rightwing.cubeList.add(new ModelBox(Rightwing, 1, 88, -29.0F, -4.0F, -3.0F, 29, 4, 5, 0.0F, false));
		Rightwing.cubeList.add(new ModelBox(Rightwing, 7, 97, -14.0F, -4.5F, -5.25F, 14, 5, 9, 0.0F, false));
		Rightwing.cubeList.add(new ModelBox(Rightwing, 4, 46, -3.0F, -3.5F, -5.75F, 2, 2, 1, 0.0F, false));
		Rightwing.cubeList.add(new ModelBox(Rightwing, 5, 46, -9.0F, -3.5F, -5.75F, 1, 1, 1, 0.0F, false));
		Rightwing.cubeList.add(new ModelBox(Rightwing, 17, 50, -4.5F, -2.25F, -5.75F, 1, 2, 1, 0.0F, false));
		Rightwing.cubeList.add(new ModelBox(Rightwing, 7, 48, -7.5F, -2.25F, -5.75F, 2, 1, 1, 0.0F, false));

		bone188 = new ModelRenderer(this);
		bone188.setRotationPoint(-2.25F, -1.25F, -6.25F);
		Rightwing.addChild(bone188);
		setRotationAngle(bone188, -2.618F, 0.0F, 0.0F);
		bone188.cubeList.add(new ModelBox(bone188, 17, 56, -4.75F, -0.75F, -5.5F, 3, 4, 4, 0.0F, false));
		bone188.cubeList.add(new ModelBox(bone188, 9, 53, -4.25F, 2.25F, -4.75F, 2, 4, 2, 0.0F, false));
		bone188.cubeList.add(new ModelBox(bone188, 14, 68, -3.75F, 4.75F, -4.0F, 1, 4, 1, 0.0F, false));

		bone189 = new ModelRenderer(this);
		bone189.setRotationPoint(-7.25F, 0.75F, -4.25F);
		Rightwing.addChild(bone189);
		setRotationAngle(bone189, -2.8798F, 0.1745F, 0.0F);
		bone189.cubeList.add(new ModelBox(bone189, 0, 0, -4.75F, -0.75F, -5.5F, 3, 4, 1, 0.0F, false));
		bone189.cubeList.add(new ModelBox(bone189, 13, 57, -4.25F, 2.25F, -4.75F, 2, 4, 2, 0.0F, false));
		bone189.cubeList.add(new ModelBox(bone189, 12, 58, -3.75F, 4.75F, -4.0F, 1, 4, 1, 0.0F, false));

		bone81 = new ModelRenderer(this);
		bone81.setRotationPoint(-1.0F, -2.0F, 9.0F);
		Rightwing.addChild(bone81);
		bone81.cubeList.add(new ModelBox(bone81, 0, 0, -27.0F, -0.5F, -7.0F, 32, 1, 16, 0.0F, false));

		bone87 = new ModelRenderer(this);
		bone87.setRotationPoint(-30.0F, -2.0F, 9.0F);
		Rightwing.addChild(bone87);
		setRotationAngle(bone87, 0.0F, -0.4363F, 0.0F);
		bone87.cubeList.add(new ModelBox(bone87, 0, 0, -27.0F, -0.5F, -7.0F, 33, 1, 14, 0.0F, false));

		bone88 = new ModelRenderer(this);
		bone88.setRotationPoint(-34.0F, -1.5F, 21.0F);
		Rightwing.addChild(bone88);
		setRotationAngle(bone88, 0.0F, -0.3491F, 0.0F);
		bone88.cubeList.add(new ModelBox(bone88, 0, 0, -27.4275F, -1.0F, -8.1746F, 39, 1, 12, 0.0F, false));

		bone89 = new ModelRenderer(this);
		bone89.setRotationPoint(-33.5F, -1.5F, 31.25F);
		Rightwing.addChild(bone89);
		setRotationAngle(bone89, 0.0F, -0.2618F, 0.0F);
		bone89.cubeList.add(new ModelBox(bone89, 0, 0, -27.4275F, -1.0F, -8.1746F, 27, 1, 12, 0.0F, false));

		bone90 = new ModelRenderer(this);
		bone90.setRotationPoint(-33.5F, -1.5F, 42.25F);
		Rightwing.addChild(bone90);
		setRotationAngle(bone90, 0.0F, -0.2618F, 0.0F);
		bone90.cubeList.add(new ModelBox(bone90, 0, 0, -21.4275F, -1.0F, -8.1746F, 8, 1, 12, 0.0F, false));

		bone94 = new ModelRenderer(this);
		bone94.setRotationPoint(-51.75F, -1.5F, -5.75F);
		Rightwing.addChild(bone94);
		setRotationAngle(bone94, 0.0F, -0.2618F, 0.0F);
		bone94.cubeList.add(new ModelBox(bone94, 0, 0, -14.4275F, -1.0F, -6.1746F, 12, 1, 12, 0.0F, false));

		bone98 = new ModelRenderer(this);
		bone98.setRotationPoint(-61.75F, -1.5F, -9.0F);
		Rightwing.addChild(bone98);
		bone98.cubeList.add(new ModelBox(bone98, 0, 0, -18.4275F, -1.0F, -6.1746F, 16, 1, 20, 0.0F, false));

		bone102 = new ModelRenderer(this);
		bone102.setRotationPoint(-74.75F, -1.5F, -9.0F);
		Rightwing.addChild(bone102);
		setRotationAngle(bone102, 0.0F, 0.4363F, 0.0F);
		bone102.cubeList.add(new ModelBox(bone102, 0, 0, -26.4275F, -1.0F, -6.1746F, 24, 1, 30, 0.0F, false));

		bone103 = new ModelRenderer(this);
		bone103.setRotationPoint(-94.75F, -1.5F, 0.0F);
		Rightwing.addChild(bone103);
		setRotationAngle(bone103, 0.0F, 0.6981F, 0.0F);
		bone103.cubeList.add(new ModelBox(bone103, 0, 0, -35.4275F, -1.0F, -6.1746F, 33, 1, 22, 0.0F, false));

		bone104 = new ModelRenderer(this);
		bone104.setRotationPoint(-116.75F, -1.5F, 16.0F);
		Rightwing.addChild(bone104);
		setRotationAngle(bone104, 0.0F, 0.9599F, 0.0F);
		bone104.cubeList.add(new ModelBox(bone104, 0, 0, -30.4275F, -1.0F, -6.1746F, 28, 1, 5, 0.0F, false));

		bone105 = new ModelRenderer(this);
		bone105.setRotationPoint(-111.75F, -1.5F, 16.0F);
		Rightwing.addChild(bone105);
		setRotationAngle(bone105, 0.0F, 0.9599F, 0.0F);
		bone105.cubeList.add(new ModelBox(bone105, 0, 0, -30.4275F, -1.0F, -6.1746F, 28, 1, 5, 0.0F, false));

		bone106 = new ModelRenderer(this);
		bone106.setRotationPoint(-105.75F, -1.5F, 15.0F);
		Rightwing.addChild(bone106);
		setRotationAngle(bone106, 0.0F, 0.9599F, 0.0F);
		bone106.cubeList.add(new ModelBox(bone106, 0, 0, -30.4275F, -1.0F, -6.1746F, 28, 1, 5, 0.0F, false));

		bone111 = new ModelRenderer(this);
		bone111.setRotationPoint(-100.75F, -1.5F, 15.0F);
		Rightwing.addChild(bone111);
		setRotationAngle(bone111, 0.0F, 0.9599F, 0.0F);
		bone111.cubeList.add(new ModelBox(bone111, 0, 0, -30.4275F, -1.0F, -6.1746F, 28, 1, 5, 0.0F, false));

		bone112 = new ModelRenderer(this);
		bone112.setRotationPoint(-95.75F, -1.5F, 15.0F);
		Rightwing.addChild(bone112);
		setRotationAngle(bone112, 0.0F, 0.9599F, 0.0F);
		bone112.cubeList.add(new ModelBox(bone112, 0, 0, -30.4275F, -1.0F, -6.1746F, 28, 1, 5, 0.0F, false));

		bone113 = new ModelRenderer(this);
		bone113.setRotationPoint(-90.75F, -1.5F, 15.0F);
		Rightwing.addChild(bone113);
		setRotationAngle(bone113, 0.0F, 0.9599F, 0.0F);
		bone113.cubeList.add(new ModelBox(bone113, 0, 0, -30.4275F, -1.0F, -6.1746F, 28, 1, 6, 0.0F, false));

		bone107 = new ModelRenderer(this);
		bone107.setRotationPoint(-82.75F, -1.5F, 23.0F);
		Rightwing.addChild(bone107);
		setRotationAngle(bone107, 0.0F, 1.3963F, 0.0F);
		bone107.cubeList.add(new ModelBox(bone107, 0, 0, -30.4275F, -1.0F, -6.1746F, 33, 1, 5, 0.0F, false));

		bone108 = new ModelRenderer(this);
		bone108.setRotationPoint(-85.75F, -1.5F, 20.0F);
		Rightwing.addChild(bone108);
		setRotationAngle(bone108, 0.0F, 1.3963F, 0.0F);
		bone108.cubeList.add(new ModelBox(bone108, 0, 0, -30.4275F, -1.0F, -6.1746F, 33, 1, 5, 0.0F, false));

		bone109 = new ModelRenderer(this);
		bone109.setRotationPoint(-88.75F, -1.5F, 16.0F);
		Rightwing.addChild(bone109);
		setRotationAngle(bone109, 0.0F, 1.3963F, 0.0F);
		bone109.cubeList.add(new ModelBox(bone109, 0, 0, -30.4275F, -1.0F, -6.1746F, 33, 1, 5, 0.0F, false));

		bone110 = new ModelRenderer(this);
		bone110.setRotationPoint(-92.75F, -1.5F, 13.0F);
		Rightwing.addChild(bone110);
		setRotationAngle(bone110, 0.0F, 1.3963F, 0.0F);
		bone110.cubeList.add(new ModelBox(bone110, 0, 0, -30.4275F, -1.0F, -6.1746F, 33, 1, 5, 0.0F, false));

		bone114 = new ModelRenderer(this);
		bone114.setRotationPoint(-96.75F, -1.5F, 11.0F);
		Rightwing.addChild(bone114);
		setRotationAngle(bone114, 0.0F, 1.3963F, 0.0F);
		bone114.cubeList.add(new ModelBox(bone114, 0, 0, -30.4275F, -1.0F, -6.1746F, 33, 1, 5, 0.0F, false));

		bone95 = new ModelRenderer(this);
		bone95.setRotationPoint(-45.5F, -1.5F, 10.25F);
		Rightwing.addChild(bone95);
		setRotationAngle(bone95, 0.0F, -0.2618F, 0.0F);
		bone95.cubeList.add(new ModelBox(bone95, 0, 0, -25.4275F, -1.0F, -8.1746F, 12, 1, 12, 0.0F, false));

		bone96 = new ModelRenderer(this);
		bone96.setRotationPoint(-45.5F, -1.5F, 22.25F);
		Rightwing.addChild(bone96);
		setRotationAngle(bone96, 0.0F, -0.2618F, 0.0F);
		bone96.cubeList.add(new ModelBox(bone96, 0, 0, -25.4275F, -1.0F, -8.1746F, 12, 1, 12, 0.0F, false));

		bone99 = new ModelRenderer(this);
		bone99.setRotationPoint(-59.5F, -1.5F, 54.25F);
		Rightwing.addChild(bone99);
		setRotationAngle(bone99, 0.0F, -0.2618F, 0.0F);
		bone99.cubeList.add(new ModelBox(bone99, 0, 0, -32.1568F, -1.0F, -33.2887F, 12, 1, 29, 0.0F, false));

		bone100 = new ModelRenderer(this);
		bone100.setRotationPoint(-61.5F, -1.5F, 65.25F);
		Rightwing.addChild(bone100);
		setRotationAngle(bone100, 0.0F, -0.2618F, 0.0F);
		bone100.cubeList.add(new ModelBox(bone100, 0, 0, -32.1568F, -1.0F, -33.2887F, 4, 1, 29, 0.0F, false));

		bone101 = new ModelRenderer(this);
		bone101.setRotationPoint(-57.5F, -1.5F, 65.25F);
		Rightwing.addChild(bone101);
		setRotationAngle(bone101, 0.0F, -0.2618F, 0.0F);
		bone101.cubeList.add(new ModelBox(bone101, 0, 0, -32.6745F, -1.0F, -20.2205F, 4, 1, 13, 0.0F, false));
		bone101.cubeList.add(new ModelBox(bone101, 0, 0, -29.3284F, -1.0F, -23.1877F, 4, 1, 12, 0.0F, false));
		bone101.cubeList.add(new ModelBox(bone101, 0, 0, -25.9823F, -1.0F, -45.1548F, 4, 1, 30, 0.0F, false));
		bone101.cubeList.add(new ModelBox(bone101, 0, 0, -22.1186F, -1.0F, -46.1901F, 4, 1, 28, 0.0F, false));
		bone101.cubeList.add(new ModelBox(bone101, 0, 0, -18.2549F, -1.0F, -47.2253F, 4, 1, 24, 0.0F, false));
		bone101.cubeList.add(new ModelBox(bone101, 0, 0, -14.3912F, -1.0F, -48.2606F, 4, 1, 20, 0.0F, false));
		bone101.cubeList.add(new ModelBox(bone101, 0, 0, -10.717F, -1.0F, -46.1393F, 4, 1, 19, 0.0F, false));
		bone101.cubeList.add(new ModelBox(bone101, 0, 0, -6.5945F, -1.0F, -46.2087F, 4, 1, 21, 0.0F, false));

		bone97 = new ModelRenderer(this);
		bone97.setRotationPoint(-52.5F, -1.5F, 17.25F);
		Rightwing.addChild(bone97);
		setRotationAngle(bone97, 0.0F, -0.2618F, 0.0F);
		bone97.cubeList.add(new ModelBox(bone97, 0, 0, -25.4275F, -1.0F, -8.1746F, 12, 1, 13, 0.0F, false));

		bone91 = new ModelRenderer(this);
		bone91.setRotationPoint(-23.5F, -1.5F, 41.0F);
		Rightwing.addChild(bone91);
		setRotationAngle(bone91, 0.0F, -0.0873F, 0.0F);
		bone91.cubeList.add(new ModelBox(bone91, 0, 0, -25.4275F, -1.0F, -8.1746F, 5, 1, 9, 0.0F, false));
		bone91.cubeList.add(new ModelBox(bone91, 0, 0, -20.6209F, -1.0F, -10.6028F, 3, 1, 9, 0.0F, false));

		bone92 = new ModelRenderer(this);
		bone92.setRotationPoint(-12.5F, -1.5F, 36.0F);
		Rightwing.addChild(bone92);
		setRotationAngle(bone92, 0.0F, -0.0873F, 0.0F);
		bone92.cubeList.add(new ModelBox(bone92, 0, 0, -25.4275F, -1.0F, -8.1746F, 10, 1, 11, 0.0F, false));

		bone93 = new ModelRenderer(this);
		bone93.setRotationPoint(-4.5F, -0.75F, 36.5F);
		Rightwing.addChild(bone93);
		setRotationAngle(bone93, -0.1745F, -0.0873F, 0.0F);
		bone93.cubeList.add(new ModelBox(bone93, 0, 0, -25.4275F, -0.2529F, -8.1092F, 10, 1, 9, 0.0F, false));

		bone82 = new ModelRenderer(this);
		bone82.setRotationPoint(-1.0F, -0.75F, 23.75F);
		Rightwing.addChild(bone82);
		setRotationAngle(bone82, -0.1745F, 0.0F, 0.0F);
		bone82.cubeList.add(new ModelBox(bone82, 0, 0, -19.0F, -0.5076F, -6.9132F, 24, 1, 16, 0.0F, false));

		bone84 = new ModelRenderer(this);
		bone84.setRotationPoint(-21.0F, -1.25F, 23.75F);
		Rightwing.addChild(bone84);
		setRotationAngle(bone84, -0.0873F, 0.0F, 0.0F);
		bone84.cubeList.add(new ModelBox(bone84, 0, 0, -3.0F, -0.5076F, -6.9132F, 8, 1, 11, 0.0F, false));

		bone83 = new ModelRenderer(this);
		bone83.setRotationPoint(-1.0F, 2.5F, 39.0F);
		Rightwing.addChild(bone83);
		setRotationAngle(bone83, -0.2618F, 0.0F, 0.0F);
		bone83.cubeList.add(new ModelBox(bone83, 0, 0, -10.0F, -0.517F, -6.8706F, 15, 1, 5, 0.0F, false));

		bone85 = new ModelRenderer(this);
		bone85.setRotationPoint(-1.0F, 5.75F, 42.0F);
		Rightwing.addChild(bone85);
		setRotationAngle(bone85, -0.6109F, 0.0F, 0.0F);
		bone85.cubeList.add(new ModelBox(bone85, 0, 0, -8.0F, -0.5904F, -6.7132F, 11, 1, 5, 0.0F, false));

		bone86 = new ModelRenderer(this);
		bone86.setRotationPoint(-1.0F, 10.0F, 45.75F);
		Rightwing.addChild(bone86);
		setRotationAngle(bone86, -0.6109F, 0.0F, 0.0F);
		bone86.cubeList.add(new ModelBox(bone86, 0, 0, -6.0F, -1.8192F, -7.5736F, 8, 1, 5, 0.0F, false));

		bone62 = new ModelRenderer(this);
		bone62.setRotationPoint(-28.75F, -1.4233F, 2.1161F);
		Rightwing.addChild(bone62);
		setRotationAngle(bone62, 0.0F, -0.3491F, 0.0F);
		bone62.cubeList.add(new ModelBox(bone62, 6, 96, -22.25F, -2.5767F, -5.3661F, 22, 4, 2, 0.0F, false));

		bone68 = new ModelRenderer(this);
		bone68.setRotationPoint(-53.0F, -0.4233F, -7.3839F);
		Rightwing.addChild(bone68);
		setRotationAngle(bone68, 0.0F, -0.3491F, 0.0F);
		bone68.cubeList.add(new ModelBox(bone68, 8, 100, -14.25F, -2.5767F, -5.3661F, 14, 2, 2, 0.0F, false));

		bone69 = new ModelRenderer(this);
		bone69.setRotationPoint(-11.6408F, 0.0F, -0.5519F);
		bone68.addChild(bone69);
		setRotationAngle(bone69, 0.0F, 0.4363F, 0.0F);
		bone69.cubeList.add(new ModelBox(bone69, 1, 79, -14.25F, -2.5767F, -5.3661F, 14, 2, 2, 0.0F, false));

		bone70 = new ModelRenderer(this);
		bone70.setRotationPoint(-22.6606F, 0.0F, 4.2571F);
		bone68.addChild(bone70);
		setRotationAngle(bone70, 0.0F, 0.7854F, 0.0F);
		bone70.cubeList.add(new ModelBox(bone70, 0, 85, -24.25F, -2.5767F, -5.3661F, 24, 2, 2, 0.0F, false));

		bone71 = new ModelRenderer(this);
		bone71.setRotationPoint(-38.6112F, 0.0F, 19.6403F);
		bone68.addChild(bone71);
		setRotationAngle(bone71, 0.0F, 1.0472F, 0.0F);
		bone71.cubeList.add(new ModelBox(bone71, 0, 82, -36.25F, -2.5767F, -5.3661F, 36, 2, 2, 0.0F, false));

		bone76 = new ModelRenderer(this);
		bone76.setRotationPoint(-55.9247F, 0.0F, 48.8217F);
		bone68.addChild(bone76);
		setRotationAngle(bone76, 0.0F, 1.309F, 0.0F);
		bone76.cubeList.add(new ModelBox(bone76, 1, 85, -27.25F, -2.5767F, -5.3661F, 27, 2, 2, 0.0F, false));
		bone76.cubeList.add(new ModelBox(bone76, 7, 48, -31.0558F, -3.5767F, -5.6082F, 5, 3, 2, 0.0F, false));
		bone76.cubeList.add(new ModelBox(bone76, 2, 46, -32.592F, -2.5767F, -5.0586F, 5, 1, 1, 0.0F, false));

		bone72 = new ModelRenderer(this);
		bone72.setRotationPoint(-49.75F, -1.4233F, -6.6339F);
		Rightwing.addChild(bone72);
		setRotationAngle(bone72, 0.0F, 0.4363F, 0.0F);
		bone72.cubeList.add(new ModelBox(bone72, 10, 95, -14.25F, -1.5767F, -5.3661F, 14, 2, 2, 0.0F, false));

		bone73 = new ModelRenderer(this);
		bone73.setRotationPoint(-11.6408F, 1.0F, -0.5519F);
		bone72.addChild(bone73);
		setRotationAngle(bone73, 0.0F, 0.4363F, 0.0F);
		bone73.cubeList.add(new ModelBox(bone73, 3, 96, -14.25F, -2.5767F, -5.3661F, 14, 2, 2, 0.0F, false));

		bone74 = new ModelRenderer(this);
		bone74.setRotationPoint(-22.6606F, 1.0F, 4.2571F);
		bone72.addChild(bone74);
		setRotationAngle(bone74, 0.0F, 0.6109F, 0.0F);
		bone74.cubeList.add(new ModelBox(bone74, 0, 96, -24.25F, -2.5767F, -5.3661F, 24, 2, 2, 0.0F, false));

		bone75 = new ModelRenderer(this);
		bone75.setRotationPoint(-40.8171F, 1.0F, 16.6807F);
		bone72.addChild(bone75);
		setRotationAngle(bone75, 0.0F, 0.8727F, 0.0F);
		bone75.cubeList.add(new ModelBox(bone75, 0, 90, -30.25F, -2.5767F, -5.3661F, 30, 2, 2, 0.0F, false));
		bone75.cubeList.add(new ModelBox(bone75, 5, 42, -32.5906F, -3.0767F, -4.7512F, 3, 2, 2, 0.0F, false));
		bone75.cubeList.add(new ModelBox(bone75, 4, 48, -34.0701F, -2.5767F, -4.3456F, 2, 1, 1, 0.0F, false));

		bone77 = new ModelRenderer(this);
		bone77.setRotationPoint(-49.75F, -1.4233F, -4.6339F);
		Rightwing.addChild(bone77);
		setRotationAngle(bone77, 0.0F, 1.2217F, 0.0F);
		bone77.cubeList.add(new ModelBox(bone77, 7, 94, -14.25F, -1.5767F, -5.3661F, 17, 2, 2, 0.0F, false));

		bone78 = new ModelRenderer(this);
		bone78.setRotationPoint(-11.6408F, 1.0F, -0.5519F);
		bone77.addChild(bone78);
		setRotationAngle(bone78, 0.0F, 0.4363F, 0.0F);
		bone78.cubeList.add(new ModelBox(bone78, 9, 90, -14.25F, -2.5767F, -5.3661F, 14, 2, 2, 0.0F, false));

		bone79 = new ModelRenderer(this);
		bone79.setRotationPoint(-22.4896F, 1.0F, 4.727F);
		bone77.addChild(bone79);
		setRotationAngle(bone79, 0.0F, 0.5236F, 0.0F);
		bone79.cubeList.add(new ModelBox(bone79, 12, 98, -16.25F, -2.5767F, -5.3661F, 16, 2, 2, 0.0F, false));

		bone80 = new ModelRenderer(this);
		bone80.setRotationPoint(-41.2446F, 1.0F, 15.5061F);
		bone77.addChild(bone80);
		setRotationAngle(bone80, 0.0F, 0.6981F, 0.0F);
		bone80.cubeList.add(new ModelBox(bone80, 9, 95, -4.0958F, -2.5767F, -4.1048F, 11, 2, 2, 0.0F, false));
		bone80.cubeList.add(new ModelBox(bone80, 4, 46, -6.5791F, -2.5767F, -4.3639F, 4, 2, 2, 0.0F, false));
		bone80.cubeList.add(new ModelBox(bone80, 8, 48, -8.4585F, -2.0767F, -4.0479F, 4, 1, 1, 0.0F, false));

		bone63 = new ModelRenderer(this);
		bone63.setRotationPoint(-30.75F, -1.4233F, 3.8661F);
		Rightwing.addChild(bone63);
		setRotationAngle(bone63, 0.0F, -0.3491F, 0.0F);
		bone63.cubeList.add(new ModelBox(bone63, 4, 96, -21.25F, -2.5767F, -4.3661F, 23, 4, 2, 0.0F, false));

		bone64 = new ModelRenderer(this);
		bone64.setRotationPoint(-48.75F, -2.4233F, -9.1339F);
		Rightwing.addChild(bone64);
		setRotationAngle(bone64, 0.0F, -0.3491F, 0.0F);
		bone64.cubeList.add(new ModelBox(bone64, 9, 97, -4.25F, -0.5767F, -2.3661F, 6, 2, 7, 0.0F, false));

		bone65 = new ModelRenderer(this);
		bone65.setRotationPoint(-46.75F, -2.4233F, -15.1339F);
		Rightwing.addChild(bone65);
		setRotationAngle(bone65, 0.0F, -0.3491F, 0.0F);
		bone65.cubeList.add(new ModelBox(bone65, 6, 89, -0.25F, -0.5767F, -0.3661F, 2, 2, 5, 0.0F, false));

		bone66 = new ModelRenderer(this);
		bone66.setRotationPoint(-43.25F, -2.4233F, -20.8839F);
		Rightwing.addChild(bone66);
		setRotationAngle(bone66, 0.0F, -0.6109F, 0.0F);
		bone66.cubeList.add(new ModelBox(bone66, 3, 45, 0.1394F, -0.5767F, 2.4976F, 2, 2, 4, 0.0F, false));

		bone67 = new ModelRenderer(this);
		bone67.setRotationPoint(-41.0F, -1.9233F, -23.6339F);
		Rightwing.addChild(bone67);
		setRotationAngle(bone67, 0.0F, -0.7854F, 0.0F);
		bone67.cubeList.add(new ModelBox(bone67, 4, 56, 1.4571F, -0.5767F, 2.0481F, 1, 1, 4, 0.0F, false));

		LeftWing = new ModelRenderer(this);
		LeftWing.setRotationPoint(9.5F, -21.5767F, -2.3661F);
		setRotationAngle(LeftWing, 0.0F, 0.0F, -0.2618F);
		

		Bone190 = new ModelRenderer(this);
		Bone190.setRotationPoint(0.0F, 0.0F, 0.0F);
		LeftWing.addChild(Bone190);
		setRotationAngle(Bone190, 0.0F, 0.0F, -3.1416F);
		Bone190.cubeList.add(new ModelBox(Bone190, 5, 91, -29.0F, -4.0F, -3.0F, 29, 4, 5, 0.0F, false));
		Bone190.cubeList.add(new ModelBox(Bone190, 1, 85, -12.5F, -5.5F, -5.0F, 16, 6, 9, 0.0F, false));
		Bone190.cubeList.add(new ModelBox(Bone190, 9, 49, -1.5F, -2.5F, -5.75F, 2, 2, 2, 0.0F, false));
		Bone190.cubeList.add(new ModelBox(Bone190, 10, 56, -5.5F, -2.5F, -5.75F, 2, 1, 2, 0.0F, false));
		Bone190.cubeList.add(new ModelBox(Bone190, 15, 57, -2.5F, -4.5F, -5.5F, 1, 2, 2, 0.0F, false));

		bone186 = new ModelRenderer(this);
		bone186.setRotationPoint(0.0F, -0.25F, 0.75F);
		Bone190.addChild(bone186);
		setRotationAngle(bone186, -0.3491F, 0.0F, 0.0F);
		bone186.cubeList.add(new ModelBox(bone186, 8, 49, -4.75F, -0.75F, -5.5F, 3, 4, 4, 0.0F, false));
		bone186.cubeList.add(new ModelBox(bone186, 0, 47, -4.25F, 2.25F, -4.75F, 2, 4, 2, 0.0F, false));
		bone186.cubeList.add(new ModelBox(bone186, 5, 49, -3.75F, 4.75F, -4.0F, 1, 4, 1, 0.0F, false));

		bone187 = new ModelRenderer(this);
		bone187.setRotationPoint(-4.0F, -2.25F, 2.75F);
		Bone190.addChild(bone187);
		setRotationAngle(bone187, -0.4363F, 0.1745F, 0.0F);
		bone187.cubeList.add(new ModelBox(bone187, 0, 0, -4.75F, -0.75F, -5.5F, 3, 4, 4, 0.0F, false));
		bone187.cubeList.add(new ModelBox(bone187, 10, 51, -4.25F, 2.25F, -4.75F, 2, 4, 2, 0.0F, false));
		bone187.cubeList.add(new ModelBox(bone187, 7, 49, -3.75F, 4.75F, -4.0F, 1, 4, 1, 0.0F, false));

		bone115 = new ModelRenderer(this);
		bone115.setRotationPoint(-1.0F, -2.0F, 9.0F);
		Bone190.addChild(bone115);
		bone115.cubeList.add(new ModelBox(bone115, 0, 0, -27.0F, -0.5F, -7.0F, 32, 1, 16, 0.0F, false));

		bone116 = new ModelRenderer(this);
		bone116.setRotationPoint(-30.0F, -2.0F, 9.0F);
		Bone190.addChild(bone116);
		setRotationAngle(bone116, 0.0F, -0.4363F, 0.0F);
		bone116.cubeList.add(new ModelBox(bone116, 0, 0, -27.0F, -0.5F, -7.0F, 33, 1, 14, 0.0F, false));

		bone117 = new ModelRenderer(this);
		bone117.setRotationPoint(-34.0F, -1.5F, 21.0F);
		Bone190.addChild(bone117);
		setRotationAngle(bone117, 0.0F, -0.3491F, 0.0F);
		bone117.cubeList.add(new ModelBox(bone117, 0, 0, -27.4275F, -1.0F, -8.1746F, 39, 1, 12, 0.0F, false));

		bone118 = new ModelRenderer(this);
		bone118.setRotationPoint(-33.5F, -1.5F, 31.25F);
		Bone190.addChild(bone118);
		setRotationAngle(bone118, 0.0F, -0.2618F, 0.0F);
		bone118.cubeList.add(new ModelBox(bone118, 0, 0, -27.4275F, -1.0F, -8.1746F, 27, 1, 12, 0.0F, false));

		bone119 = new ModelRenderer(this);
		bone119.setRotationPoint(-33.5F, -1.5F, 42.25F);
		Bone190.addChild(bone119);
		setRotationAngle(bone119, 0.0F, -0.2618F, 0.0F);
		bone119.cubeList.add(new ModelBox(bone119, 0, 0, -21.4275F, -1.0F, -8.1746F, 8, 1, 12, 0.0F, false));

		bone120 = new ModelRenderer(this);
		bone120.setRotationPoint(-51.75F, -1.5F, -5.75F);
		Bone190.addChild(bone120);
		setRotationAngle(bone120, 0.0F, -0.2618F, 0.0F);
		bone120.cubeList.add(new ModelBox(bone120, 0, 0, -14.4275F, -1.0F, -6.1746F, 12, 1, 12, 0.0F, false));

		bone121 = new ModelRenderer(this);
		bone121.setRotationPoint(-61.75F, -1.5F, -9.0F);
		Bone190.addChild(bone121);
		bone121.cubeList.add(new ModelBox(bone121, 0, 0, -18.4275F, -1.0F, -6.1746F, 16, 1, 20, 0.0F, false));

		bone122 = new ModelRenderer(this);
		bone122.setRotationPoint(-74.75F, -1.5F, -9.0F);
		Bone190.addChild(bone122);
		setRotationAngle(bone122, 0.0F, 0.4363F, 0.0F);
		bone122.cubeList.add(new ModelBox(bone122, 0, 0, -26.4275F, -1.0F, -6.1746F, 24, 1, 30, 0.0F, false));

		bone123 = new ModelRenderer(this);
		bone123.setRotationPoint(-94.75F, -1.5F, 0.0F);
		Bone190.addChild(bone123);
		setRotationAngle(bone123, 0.0F, 0.6981F, 0.0F);
		bone123.cubeList.add(new ModelBox(bone123, 0, 0, -35.4275F, -1.0F, -6.1746F, 33, 1, 22, 0.0F, false));

		bone124 = new ModelRenderer(this);
		bone124.setRotationPoint(-116.75F, -1.5F, 16.0F);
		Bone190.addChild(bone124);
		setRotationAngle(bone124, 0.0F, 0.9599F, 0.0F);
		bone124.cubeList.add(new ModelBox(bone124, 0, 0, -30.4275F, -1.0F, -6.1746F, 28, 1, 5, 0.0F, false));

		bone125 = new ModelRenderer(this);
		bone125.setRotationPoint(-111.75F, -1.5F, 16.0F);
		Bone190.addChild(bone125);
		setRotationAngle(bone125, 0.0F, 0.9599F, 0.0F);
		bone125.cubeList.add(new ModelBox(bone125, 0, 0, -30.4275F, -1.0F, -6.1746F, 28, 1, 5, 0.0F, false));

		bone126 = new ModelRenderer(this);
		bone126.setRotationPoint(-105.75F, -1.5F, 15.0F);
		Bone190.addChild(bone126);
		setRotationAngle(bone126, 0.0F, 0.9599F, 0.0F);
		bone126.cubeList.add(new ModelBox(bone126, 0, 0, -30.4275F, -1.0F, -6.1746F, 28, 1, 5, 0.0F, false));

		bone127 = new ModelRenderer(this);
		bone127.setRotationPoint(-100.75F, -1.5F, 15.0F);
		Bone190.addChild(bone127);
		setRotationAngle(bone127, 0.0F, 0.9599F, 0.0F);
		bone127.cubeList.add(new ModelBox(bone127, 0, 0, -30.4275F, -1.0F, -6.1746F, 28, 1, 5, 0.0F, false));

		bone128 = new ModelRenderer(this);
		bone128.setRotationPoint(-95.75F, -1.5F, 15.0F);
		Bone190.addChild(bone128);
		setRotationAngle(bone128, 0.0F, 0.9599F, 0.0F);
		bone128.cubeList.add(new ModelBox(bone128, 0, 0, -30.4275F, -1.0F, -6.1746F, 28, 1, 5, 0.0F, false));

		bone129 = new ModelRenderer(this);
		bone129.setRotationPoint(-90.75F, -1.5F, 15.0F);
		Bone190.addChild(bone129);
		setRotationAngle(bone129, 0.0F, 0.9599F, 0.0F);
		bone129.cubeList.add(new ModelBox(bone129, 0, 0, -30.4275F, -1.0F, -6.1746F, 28, 1, 6, 0.0F, false));

		bone130 = new ModelRenderer(this);
		bone130.setRotationPoint(-82.75F, -1.5F, 23.0F);
		Bone190.addChild(bone130);
		setRotationAngle(bone130, 0.0F, 1.3963F, 0.0F);
		bone130.cubeList.add(new ModelBox(bone130, 0, 0, -30.4275F, -1.0F, -6.1746F, 33, 1, 5, 0.0F, false));

		bone131 = new ModelRenderer(this);
		bone131.setRotationPoint(-85.75F, -1.5F, 20.0F);
		Bone190.addChild(bone131);
		setRotationAngle(bone131, 0.0F, 1.3963F, 0.0F);
		bone131.cubeList.add(new ModelBox(bone131, 0, 0, -30.4275F, -1.0F, -6.1746F, 33, 1, 5, 0.0F, false));

		bone132 = new ModelRenderer(this);
		bone132.setRotationPoint(-88.75F, -1.5F, 16.0F);
		Bone190.addChild(bone132);
		setRotationAngle(bone132, 0.0F, 1.3963F, 0.0F);
		bone132.cubeList.add(new ModelBox(bone132, 0, 0, -30.4275F, -1.0F, -6.1746F, 33, 1, 5, 0.0F, false));

		bone133 = new ModelRenderer(this);
		bone133.setRotationPoint(-92.75F, -1.5F, 13.0F);
		Bone190.addChild(bone133);
		setRotationAngle(bone133, 0.0F, 1.3963F, 0.0F);
		bone133.cubeList.add(new ModelBox(bone133, 0, 0, -30.4275F, -1.0F, -6.1746F, 33, 1, 5, 0.0F, false));

		bone134 = new ModelRenderer(this);
		bone134.setRotationPoint(-96.75F, -1.5F, 11.0F);
		Bone190.addChild(bone134);
		setRotationAngle(bone134, 0.0F, 1.3963F, 0.0F);
		bone134.cubeList.add(new ModelBox(bone134, 0, 0, -30.4275F, -1.0F, -6.1746F, 33, 1, 5, 0.0F, false));

		bone135 = new ModelRenderer(this);
		bone135.setRotationPoint(-45.5F, -1.5F, 10.25F);
		Bone190.addChild(bone135);
		setRotationAngle(bone135, 0.0F, -0.2618F, 0.0F);
		bone135.cubeList.add(new ModelBox(bone135, 0, 0, -25.4275F, -1.0F, -8.1746F, 12, 1, 12, 0.0F, false));

		bone136 = new ModelRenderer(this);
		bone136.setRotationPoint(-45.5F, -1.5F, 22.25F);
		Bone190.addChild(bone136);
		setRotationAngle(bone136, 0.0F, -0.2618F, 0.0F);
		bone136.cubeList.add(new ModelBox(bone136, 0, 0, -25.4275F, -1.0F, -8.1746F, 12, 1, 12, 0.0F, false));

		bone137 = new ModelRenderer(this);
		bone137.setRotationPoint(-59.5F, -1.5F, 54.25F);
		Bone190.addChild(bone137);
		setRotationAngle(bone137, 0.0F, -0.2618F, 0.0F);
		bone137.cubeList.add(new ModelBox(bone137, 0, 0, -32.1568F, -1.0F, -33.2887F, 12, 1, 29, 0.0F, false));

		bone138 = new ModelRenderer(this);
		bone138.setRotationPoint(-61.5F, -1.5F, 65.25F);
		Bone190.addChild(bone138);
		setRotationAngle(bone138, 0.0F, -0.2618F, 0.0F);
		bone138.cubeList.add(new ModelBox(bone138, 0, 0, -32.1568F, -1.0F, -33.2887F, 4, 1, 29, 0.0F, false));

		bone139 = new ModelRenderer(this);
		bone139.setRotationPoint(-57.5F, -1.5F, 65.25F);
		Bone190.addChild(bone139);
		setRotationAngle(bone139, 0.0F, -0.2618F, 0.0F);
		bone139.cubeList.add(new ModelBox(bone139, 0, 0, -32.6745F, -1.0F, -20.2205F, 4, 1, 13, 0.0F, false));
		bone139.cubeList.add(new ModelBox(bone139, 0, 0, -29.3284F, -1.0F, -23.1877F, 4, 1, 12, 0.0F, false));
		bone139.cubeList.add(new ModelBox(bone139, 0, 0, -25.9823F, -1.0F, -45.1548F, 4, 1, 30, 0.0F, false));
		bone139.cubeList.add(new ModelBox(bone139, 0, 0, -22.1186F, -1.0F, -46.1901F, 4, 1, 28, 0.0F, false));
		bone139.cubeList.add(new ModelBox(bone139, 0, 0, -18.2549F, -1.0F, -47.2253F, 4, 1, 24, 0.0F, false));
		bone139.cubeList.add(new ModelBox(bone139, 0, 0, -14.3912F, -1.0F, -48.2606F, 4, 1, 20, 0.0F, false));
		bone139.cubeList.add(new ModelBox(bone139, 0, 0, -10.717F, -1.0F, -46.1393F, 4, 1, 19, 0.0F, false));
		bone139.cubeList.add(new ModelBox(bone139, 0, 0, -6.5945F, -1.0F, -46.2087F, 4, 1, 21, 0.0F, false));

		bone140 = new ModelRenderer(this);
		bone140.setRotationPoint(-52.5F, -1.5F, 17.25F);
		Bone190.addChild(bone140);
		setRotationAngle(bone140, 0.0F, -0.2618F, 0.0F);
		bone140.cubeList.add(new ModelBox(bone140, 0, 0, -25.4275F, -1.0F, -8.1746F, 12, 1, 13, 0.0F, false));

		bone141 = new ModelRenderer(this);
		bone141.setRotationPoint(-23.5F, -1.5F, 41.0F);
		Bone190.addChild(bone141);
		setRotationAngle(bone141, 0.0F, -0.0873F, 0.0F);
		bone141.cubeList.add(new ModelBox(bone141, 0, 0, -25.4275F, -1.0F, -8.1746F, 5, 1, 9, 0.0F, false));
		bone141.cubeList.add(new ModelBox(bone141, 0, 0, -20.6209F, -1.0F, -10.6028F, 3, 1, 9, 0.0F, false));

		bone142 = new ModelRenderer(this);
		bone142.setRotationPoint(-12.5F, -1.5F, 36.0F);
		Bone190.addChild(bone142);
		setRotationAngle(bone142, 0.0F, -0.0873F, 0.0F);
		bone142.cubeList.add(new ModelBox(bone142, 0, 0, -25.4275F, -1.0F, -8.1746F, 10, 1, 11, 0.0F, false));

		bone143 = new ModelRenderer(this);
		bone143.setRotationPoint(-4.5F, -4.0F, 36.5F);
		Bone190.addChild(bone143);
		setRotationAngle(bone143, 0.1745F, -0.0873F, 0.0F);
		bone143.cubeList.add(new ModelBox(bone143, 0, 0, -25.4275F, -0.2529F, -8.1092F, 10, 1, 9, 0.0F, false));

		bone144 = new ModelRenderer(this);
		bone144.setRotationPoint(-1.0F, -3.25F, 23.75F);
		Bone190.addChild(bone144);
		setRotationAngle(bone144, 0.1745F, 0.0F, 0.0F);
		bone144.cubeList.add(new ModelBox(bone144, 0, 0, -19.0F, -0.5076F, -6.9132F, 24, 1, 16, 0.0F, false));

		bone145 = new ModelRenderer(this);
		bone145.setRotationPoint(-21.0F, -2.5F, 23.75F);
		Bone190.addChild(bone145);
		setRotationAngle(bone145, 0.0873F, 0.0F, 0.0F);
		bone145.cubeList.add(new ModelBox(bone145, 0, 0, -3.0F, -0.5076F, -6.9132F, 8, 1, 11, 0.0F, false));

		bone146 = new ModelRenderer(this);
		bone146.setRotationPoint(-1.0F, -6.5F, 39.0F);
		Bone190.addChild(bone146);
		setRotationAngle(bone146, 0.2618F, 0.0F, 0.0F);
		bone146.cubeList.add(new ModelBox(bone146, 0, 0, -10.0F, -0.517F, -6.8706F, 15, 1, 5, 0.0F, false));

		bone147 = new ModelRenderer(this);
		bone147.setRotationPoint(-1.0F, -9.5F, 42.0F);
		Bone190.addChild(bone147);
		setRotationAngle(bone147, 0.6109F, 0.0F, 0.0F);
		bone147.cubeList.add(new ModelBox(bone147, 0, 0, -8.0F, -0.5904F, -6.7132F, 11, 1, 5, 0.0F, false));

		bone148 = new ModelRenderer(this);
		bone148.setRotationPoint(-1.0F, -10.75F, 45.75F);
		Bone190.addChild(bone148);
		setRotationAngle(bone148, 0.6109F, 0.0F, 0.0F);
		bone148.cubeList.add(new ModelBox(bone148, 0, 0, -6.0F, -1.8192F, -7.5736F, 8, 1, 5, 0.0F, false));

		bone149 = new ModelRenderer(this);
		bone149.setRotationPoint(-28.75F, -1.4233F, 2.1161F);
		Bone190.addChild(bone149);
		setRotationAngle(bone149, 0.0F, -0.3491F, 0.0F);
		bone149.cubeList.add(new ModelBox(bone149, 10, 96, -22.25F, -2.5767F, -5.3661F, 22, 4, 2, 0.0F, false));

		bone150 = new ModelRenderer(this);
		bone150.setRotationPoint(-53.0F, -0.4233F, -7.3839F);
		Bone190.addChild(bone150);
		setRotationAngle(bone150, 0.0F, -0.3491F, 0.0F);
		bone150.cubeList.add(new ModelBox(bone150, 12, 92, -14.25F, -2.5767F, -5.3661F, 14, 2, 2, 0.0F, false));

		bone151 = new ModelRenderer(this);
		bone151.setRotationPoint(-11.6408F, 0.0F, -0.5519F);
		bone150.addChild(bone151);
		setRotationAngle(bone151, 0.0F, 0.4363F, 0.0F);
		bone151.cubeList.add(new ModelBox(bone151, 5, 89, -14.25F, -2.5767F, -5.3661F, 14, 2, 2, 0.0F, false));

		bone152 = new ModelRenderer(this);
		bone152.setRotationPoint(-22.6606F, 0.0F, 4.2571F);
		bone150.addChild(bone152);
		setRotationAngle(bone152, 0.0F, 0.7854F, 0.0F);
		bone152.cubeList.add(new ModelBox(bone152, 8, 91, -24.25F, -2.5767F, -5.3661F, 24, 2, 2, 0.0F, false));

		bone153 = new ModelRenderer(this);
		bone153.setRotationPoint(-38.6112F, 0.0F, 19.6403F);
		bone150.addChild(bone153);
		setRotationAngle(bone153, 0.0F, 1.0472F, 0.0F);
		bone153.cubeList.add(new ModelBox(bone153, 5, 86, -36.25F, -2.5767F, -5.3661F, 36, 2, 2, 0.0F, false));

		bone154 = new ModelRenderer(this);
		bone154.setRotationPoint(-55.9247F, 0.0F, 48.8217F);
		bone150.addChild(bone154);
		setRotationAngle(bone154, 0.0F, 1.309F, 0.0F);
		bone154.cubeList.add(new ModelBox(bone154, 0, 95, -27.25F, -2.5767F, -5.3661F, 27, 2, 2, 0.0F, false));
		bone154.cubeList.add(new ModelBox(bone154, 1, 50, -30.8956F, -2.5767F, -5.9358F, 4, 2, 2, 0.0F, false));
		bone154.cubeList.add(new ModelBox(bone154, 8, 53, -33.1281F, -2.0767F, -5.509F, 4, 1, 1, 0.0F, false));

		bone155 = new ModelRenderer(this);
		bone155.setRotationPoint(-49.75F, -1.4233F, -6.6339F);
		Bone190.addChild(bone155);
		setRotationAngle(bone155, 0.0F, 0.4363F, 0.0F);
		bone155.cubeList.add(new ModelBox(bone155, 0, 83, -14.25F, -1.5767F, -5.3661F, 14, 2, 2, 0.0F, false));

		bone156 = new ModelRenderer(this);
		bone156.setRotationPoint(-11.6408F, 1.0F, -0.5519F);
		bone155.addChild(bone156);
		setRotationAngle(bone156, 0.0F, 0.4363F, 0.0F);
		bone156.cubeList.add(new ModelBox(bone156, 2, 85, -14.25F, -2.5767F, -5.3661F, 14, 2, 2, 0.0F, false));

		bone157 = new ModelRenderer(this);
		bone157.setRotationPoint(-22.6606F, 1.0F, 4.2571F);
		bone155.addChild(bone157);
		setRotationAngle(bone157, 0.0F, 0.6109F, 0.0F);
		bone157.cubeList.add(new ModelBox(bone157, 3, 86, -24.25F, -2.5767F, -5.3661F, 24, 2, 2, 0.0F, false));

		bone158 = new ModelRenderer(this);
		bone158.setRotationPoint(-40.8171F, 1.0F, 16.6807F);
		bone155.addChild(bone158);
		setRotationAngle(bone158, 0.0F, 0.8727F, 0.0F);
		bone158.cubeList.add(new ModelBox(bone158, 10, 96, -30.25F, -2.5767F, -5.3661F, 30, 2, 2, 0.0F, false));
		bone158.cubeList.add(new ModelBox(bone158, 9, 47, -34.4785F, -2.5767F, -4.2989F, 5, 2, 2, 0.0F, false));
		bone158.cubeList.add(new ModelBox(bone158, 10, 63, -36.6345F, -1.8267F, -3.6859F, 5, 1, 1, 0.0F, false));

		bone159 = new ModelRenderer(this);
		bone159.setRotationPoint(-49.75F, -1.4233F, -4.6339F);
		Bone190.addChild(bone159);
		setRotationAngle(bone159, 0.0F, 1.2217F, 0.0F);
		bone159.cubeList.add(new ModelBox(bone159, 5, 84, -14.25F, -1.5767F, -5.3661F, 17, 2, 2, 0.0F, false));

		bone160 = new ModelRenderer(this);
		bone160.setRotationPoint(-11.6408F, 1.0F, -0.5519F);
		bone159.addChild(bone160);
		setRotationAngle(bone160, 0.0F, 0.4363F, 0.0F);
		bone160.cubeList.add(new ModelBox(bone160, 0, 84, -14.25F, -2.5767F, -5.3661F, 14, 2, 2, 0.0F, false));

		bone161 = new ModelRenderer(this);
		bone161.setRotationPoint(-22.4896F, 1.0F, 4.727F);
		bone159.addChild(bone161);
		setRotationAngle(bone161, 0.0F, 0.5236F, 0.0F);
		bone161.cubeList.add(new ModelBox(bone161, 12, 92, -16.25F, -2.5767F, -5.3661F, 16, 2, 2, 0.0F, false));

		bone162 = new ModelRenderer(this);
		bone162.setRotationPoint(-41.2446F, 1.0F, 15.5061F);
		bone159.addChild(bone162);
		setRotationAngle(bone162, 0.0F, 0.6981F, 0.0F);
		bone162.cubeList.add(new ModelBox(bone162, 15, 88, -4.0958F, -2.5767F, -4.1048F, 11, 2, 2, 0.0F, false));
		bone162.cubeList.add(new ModelBox(bone162, 3, 46, -7.3478F, -2.8267F, -5.1758F, 4, 3, 2, 0.0F, false));
		bone162.cubeList.add(new ModelBox(bone162, 8, 53, -9.4405F, -1.8267F, -4.7356F, 4, 1, 1, 0.0F, false));

		bone163 = new ModelRenderer(this);
		bone163.setRotationPoint(-30.75F, -1.4233F, 3.8661F);
		Bone190.addChild(bone163);
		setRotationAngle(bone163, 0.0F, -0.3491F, 0.0F);
		bone163.cubeList.add(new ModelBox(bone163, 11, 87, -21.25F, -2.5767F, -4.3661F, 23, 4, 2, 0.0F, false));

		bone164 = new ModelRenderer(this);
		bone164.setRotationPoint(-48.75F, -2.4233F, -9.1339F);
		Bone190.addChild(bone164);
		setRotationAngle(bone164, 0.0F, -0.3491F, 0.0F);
		bone164.cubeList.add(new ModelBox(bone164, 10, 92, -4.25F, -0.5767F, -2.3661F, 6, 2, 7, 0.0F, false));

		bone165 = new ModelRenderer(this);
		bone165.setRotationPoint(-46.75F, -2.4233F, -15.1339F);
		Bone190.addChild(bone165);
		setRotationAngle(bone165, 0.0F, -0.3491F, 0.0F);
		bone165.cubeList.add(new ModelBox(bone165, 15, 99, -0.25F, -0.5767F, -0.3661F, 2, 2, 5, 0.0F, false));

		bone166 = new ModelRenderer(this);
		bone166.setRotationPoint(-43.25F, -2.4233F, -20.8839F);
		Bone190.addChild(bone166);
		setRotationAngle(bone166, 0.0F, -0.6109F, 0.0F);
		bone166.cubeList.add(new ModelBox(bone166, 8, 53, 0.1394F, -0.5767F, 2.4976F, 2, 2, 4, 0.0F, false));

		bone167 = new ModelRenderer(this);
		bone167.setRotationPoint(-41.0F, -1.9233F, -23.6339F);
		Bone190.addChild(bone167);
		setRotationAngle(bone167, 0.0F, -0.7854F, 0.0F);
		bone167.cubeList.add(new ModelBox(bone167, 6, 57, 1.4571F, -0.5767F, 2.0481F, 1, 1, 4, 0.0F, false));

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, -20.0F, -16.0F);
		Head.cubeList.add(new ModelBox(Head, 2, 89, -4.75F, -4.0F, -11.0F, 10, 9, 12, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 0, 87, -4.75F, -2.0F, -12.5F, 10, 3, 3, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 1, 55, -4.75F, -6.0F, -18.8F, 10, 5, 8, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 5, 59, -5.25F, -6.0F, -16.55F, 11, 4, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 3, 60, -5.25F, -6.0F, -13.55F, 11, 4, 3, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 4, 65, -5.25F, -6.0F, -19.55F, 11, 4, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 4, 68, -4.75F, -5.25F, -23.3F, 10, 3, 2, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 6, 59, -5.25F, -5.75F, -19.3F, 11, 1, 8, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 5, 63, -4.75F, -5.5F, -23.3F, 10, 1, 4, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 5, 57, -5.25F, -3.25F, -19.3F, 11, 2, 8, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 2, 60, -4.75F, -3.25F, -23.3F, 10, 2, 4, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 5, 28, -5.25F, -4.5F, -15.05F, 11, 1, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 2, 31, -5.25F, -4.5F, -18.05F, 11, 1, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 2, 32, -4.75F, -4.5F, -21.05F, 10, 1, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 4, 58, -4.25F, -5.25F, -23.5F, 9, 4, 5, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 3, 66, -3.25F, -4.5F, -26.25F, 7, 3, 3, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 7, 48, -2.5F, -3.75F, -27.85F, 5, 2, 3, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 5, 51, -0.5F, -5.25F, -27.6F, 1, 2, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 4, 61, 1.5F, -2.25F, -27.85F, 1, 2, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 6, 65, 1.0F, 3.75F, -26.1F, 1, 2, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 8, 67, 2.0F, 3.5F, -23.35F, 1, 2, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 0, 63, -2.5F, 3.5F, -23.35F, 1, 2, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 6, 62, -1.5F, 3.75F, -26.1F, 1, 2, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 3, 65, 2.25F, -2.5F, -26.1F, 1, 2, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 3, 67, 2.25F, -2.5F, -24.6F, 1, 2, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 4, 66, 4.25F, -2.5F, -23.1F, 1, 2, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 6, 64, 4.25F, -2.5F, -21.1F, 1, 2, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 2, 89, -5.25F, 0.5F, -10.6F, 11, 2, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 2, 89, -5.25F, -0.75F, -9.35F, 11, 2, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 2, 89, -5.25F, 0.25F, -8.1F, 11, 2, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 2, 89, -5.25F, -1.0F, -6.85F, 11, 2, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 2, 89, -5.25F, 0.25F, -5.6F, 11, 2, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 2, 89, -5.25F, -1.0F, -4.35F, 11, 2, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 2, 89, -5.25F, -0.75F, -3.1F, 11, 2, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 6, 60, -4.75F, -2.5F, -23.1F, 1, 2, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 2, 60, -4.75F, -2.5F, -21.1F, 1, 2, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 9, 62, -3.0F, -2.5F, -26.1F, 1, 2, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 4, 62, -3.0F, -2.5F, -24.6F, 1, 2, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 4, 66, 0.25F, -3.0F, -27.85F, 1, 2, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 4, 61, -2.5F, -2.25F, -27.6F, 1, 2, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 4, 67, -1.25F, -3.0F, -27.85F, 1, 2, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 8, 63, -0.5F, -5.75F, -28.6F, 1, 1, 2, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 4, 62, -1.0F, -5.75F, -26.85F, 2, 1, 2, 0.0F, false));

		bone170 = new ModelRenderer(this);
		bone170.setRotationPoint(3.75F, -6.0F, -11.3F);
		Head.addChild(bone170);
		setRotationAngle(bone170, 0.1745F, 0.0F, 0.0F);
		bone170.cubeList.add(new ModelBox(bone170, 3, 56, -1.75F, -0.0152F, -0.1736F, 3, 2, 8, 0.0F, false));
		bone170.cubeList.add(new ModelBox(bone170, 3, 56, -8.75F, -0.0152F, -0.1736F, 3, 2, 8, 0.0F, false));
		bone170.cubeList.add(new ModelBox(bone170, 8, 56, -8.25F, -0.0015F, 7.6626F, 2, 2, 2, 0.0F, false));
		bone170.cubeList.add(new ModelBox(bone170, 11, 61, -1.25F, -0.0015F, 7.6626F, 2, 2, 2, 0.0F, false));
		bone170.cubeList.add(new ModelBox(bone170, 2, 89, -5.0F, 2.2583F, 3.2025F, 2, 2, 2, 0.0F, false));
		bone170.cubeList.add(new ModelBox(bone170, 2, 61, -0.75F, 0.2741F, 9.3135F, 1, 1, 2, 0.0F, false));
		bone170.cubeList.add(new ModelBox(bone170, 2, 89, -4.5F, 2.4906F, 4.6071F, 1, 1, 2, 0.0F, false));
		bone170.cubeList.add(new ModelBox(bone170, 5, 63, -7.5F, 0.2741F, 9.3135F, 1, 1, 2, 0.0F, false));

		bone171 = new ModelRenderer(this);
		bone171.setRotationPoint(6.0F, 2.6527F, -2.9696F);
		bone170.addChild(bone171);
		setRotationAngle(bone171, 0.0F, 0.6109F, 0.0F);
		bone171.cubeList.add(new ModelBox(bone171, 7, 55, -6.1116F, -0.2344F, -2.3301F, 2, 2, 5, 0.0F, false));
		bone171.cubeList.add(new ModelBox(bone171, 9, 62, -5.7273F, 0.2006F, 2.3003F, 1, 1, 2, 0.0F, false));

		bone172 = new ModelRenderer(this);
		bone172.setRotationPoint(-5.25F, 3.7814F, 3.4316F);
		bone170.addChild(bone172);
		setRotationAngle(bone172, 0.0F, -0.6109F, 0.0F);
		bone172.cubeList.add(new ModelBox(bone172, 8, 53, -6.1116F, -0.2344F, -2.3301F, 2, 2, 5, 0.0F, false));
		bone172.cubeList.add(new ModelBox(bone172, 6, 61, -5.7273F, 0.2006F, 2.3003F, 1, 1, 2, 0.0F, false));

		bone168 = new ModelRenderer(this);
		bone168.setRotationPoint(0.25F, 3.0F, -11.0F);
		Head.addChild(bone168);
		setRotationAngle(bone168, 0.1745F, 0.0F, 0.0F);
		bone168.cubeList.add(new ModelBox(bone168, 2, 89, -5.0F, -1.0F, -5.0F, 10, 3, 5, 0.0F, false));
		bone168.cubeList.add(new ModelBox(bone168, 95, 17, -4.75F, -4.8536F, -1.4347F, 1, 5, 1, 0.0F, false));
		bone168.cubeList.add(new ModelBox(bone168, 78, 26, 3.75F, -4.8536F, -1.4347F, 1, 5, 1, 0.0F, false));
		bone168.cubeList.add(new ModelBox(bone168, 77, 23, -4.75F, -5.1141F, -2.9119F, 1, 5, 1, 0.0F, false));
		bone168.cubeList.add(new ModelBox(bone168, 84, 23, 3.75F, -5.1141F, -2.9119F, 1, 5, 1, 0.0F, false));
		bone168.cubeList.add(new ModelBox(bone168, 84, 21, -4.75F, -5.418F, -4.6353F, 1, 5, 1, 0.0F, false));
		bone168.cubeList.add(new ModelBox(bone168, 99, 24, 3.75F, -5.418F, -4.6353F, 1, 5, 1, 0.0F, false));
		bone168.cubeList.add(new ModelBox(bone168, 74, 20, -3.75F, -5.6785F, -6.1126F, 1, 5, 1, 0.0F, false));
		bone168.cubeList.add(new ModelBox(bone168, 85, 21, 2.75F, -5.6785F, -6.1126F, 1, 5, 1, 0.0F, false));
		bone168.cubeList.add(new ModelBox(bone168, 84, 23, -3.75F, -5.939F, -7.5898F, 1, 5, 1, 0.0F, false));
		bone168.cubeList.add(new ModelBox(bone168, 102, 19, 2.75F, -5.939F, -7.5898F, 1, 5, 1, 0.0F, false));
		bone168.cubeList.add(new ModelBox(bone168, 2, 89, -4.0F, -1.0428F, -7.5619F, 8, 3, 3, 0.0F, false));
		bone168.cubeList.add(new ModelBox(bone168, 2, 89, -3.5F, -0.9845F, -10.1107F, 7, 3, 3, 0.0F, false));
		bone168.cubeList.add(new ModelBox(bone168, 2, 89, -3.0F, -0.9262F, -12.6596F, 6, 3, 3, 0.0F, false));
		bone168.cubeList.add(new ModelBox(bone168, 2, 89, -2.0F, -0.6652F, -15.498F, 4, 3, 3, 0.0F, false));
		bone168.cubeList.add(new ModelBox(bone168, 2, 89, -1.5F, 2.2893F, -16.019F, 3, 1, 2, 0.0F, false));
		bone168.cubeList.add(new ModelBox(bone168, 2, 89, -1.0F, 2.9553F, -15.121F, 2, 1, 2, 0.0F, false));
		bone168.cubeList.add(new ModelBox(bone168, 2, 89, -0.5F, 3.6648F, -13.9768F, 1, 1, 1, 0.0F, false));

		bone169 = new ModelRenderer(this);
		bone169.setRotationPoint(-1.25F, 4.0F, -16.25F);
		Head.addChild(bone169);
		setRotationAngle(bone169, -0.0873F, 0.0F, 0.0F);
		bone169.cubeList.add(new ModelBox(bone169, 84, 23, -1.5F, -1.0F, -4.0F, 6, 1, 4, 0.0F, false));
		bone169.cubeList.add(new ModelBox(bone169, 89, 22, -1.0F, -1.13F, -5.5657F, 5, 1, 2, 0.0F, false));
		bone169.cubeList.add(new ModelBox(bone169, 80, 27, -0.5F, -0.9098F, -7.0965F, 4, 1, 2, 0.0F, false));
		bone169.cubeList.add(new ModelBox(bone169, 81, 23, 0.0F, -0.6896F, -8.6274F, 3, 1, 2, 0.0F, false));
		bone169.cubeList.add(new ModelBox(bone169, 101, 23, 0.5F, -0.5157F, -9.4697F, 2, 1, 1, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		Body.render(f5);
		Rightleg.render(f5);
		Leftleg.render(f5);
		Tail.render(f5);
		Rightwing.render(f5);
		LeftWing.render(f5);
		Head.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
	{
		this.Head.rotateAngleX = headPitch * 0.017453292F;
		this.Head.rotateAngleY = netHeadYaw * 0.017453292F;
		this.Rightwing.rotateAngleZ = MathHelper.cos(ageInTicks * 0.4F) * (float)Math.PI * 0.25F;
		this.LeftWing.rotateAngleZ = -this.Rightwing.rotateAngleZ;
	}
}