package io.github.blaezdev.rwbym.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;

public class ModelHollow extends ModelBase {
	private final ModelRenderer Hollow;
	private final ModelRenderer UpperBody2;
	private final ModelRenderer Body;
	private final ModelRenderer upperbody;
	private final ModelRenderer bone151;
	private final ModelRenderer bone132;
	private final ModelRenderer bone141;
	private final ModelRenderer bone140;
	private final ModelRenderer bone139;
	private final ModelRenderer bone138;
	private final ModelRenderer bone137;
	private final ModelRenderer bone136;
	private final ModelRenderer bone135;
	private final ModelRenderer bone134;
	private final ModelRenderer bone145;
	private final ModelRenderer bone146;
	private final ModelRenderer bone144;
	private final ModelRenderer bone148;
	private final ModelRenderer bone147;
	private final ModelRenderer bone149;
	private final ModelRenderer bone142;
	private final ModelRenderer bone6;
	private final ModelRenderer bone29;
	private final ModelRenderer bone53;
	private final ModelRenderer bone71;
	private final ModelRenderer bone87;
	private final ModelRenderer bone94;
	private final ModelRenderer bone79;
	private final ModelRenderer bone102;
	private final ModelRenderer bone117;
	private final ModelRenderer bone123;
	private final ModelRenderer bone109;
	private final ModelRenderer bone62;
	private final ModelRenderer bone41;
	private final ModelRenderer bone30;
	private final ModelRenderer bone54;
	private final ModelRenderer bone72;
	private final ModelRenderer bone88;
	private final ModelRenderer bone95;
	private final ModelRenderer bone80;
	private final ModelRenderer bone63;
	private final ModelRenderer bone103;
	private final ModelRenderer bone118;
	private final ModelRenderer bone124;
	private final ModelRenderer bone110;
	private final ModelRenderer bone42;
	private final ModelRenderer bone31;
	private final ModelRenderer bone55;
	private final ModelRenderer bone73;
	private final ModelRenderer bone89;
	private final ModelRenderer bone96;
	private final ModelRenderer bone81;
	private final ModelRenderer bone64;
	private final ModelRenderer bone104;
	private final ModelRenderer bone119;
	private final ModelRenderer bone125;
	private final ModelRenderer bone111;
	private final ModelRenderer bone43;
	private final ModelRenderer bone32;
	private final ModelRenderer bone56;
	private final ModelRenderer bone74;
	private final ModelRenderer bone90;
	private final ModelRenderer bone97;
	private final ModelRenderer bone82;
	private final ModelRenderer bone65;
	private final ModelRenderer bone105;
	private final ModelRenderer bone112;
	private final ModelRenderer bone44;
	private final ModelRenderer bone33;
	private final ModelRenderer bone57;
	private final ModelRenderer bone75;
	private final ModelRenderer bone91;
	private final ModelRenderer bone98;
	private final ModelRenderer bone83;
	private final ModelRenderer bone66;
	private final ModelRenderer bone120;
	private final ModelRenderer bone126;
	private final ModelRenderer bone113;
	private final ModelRenderer bone106;
	private final ModelRenderer bone45;
	private final ModelRenderer bone34;
	private final ModelRenderer bone58;
	private final ModelRenderer bone76;
	private final ModelRenderer bone92;
	private final ModelRenderer bone99;
	private final ModelRenderer bone84;
	private final ModelRenderer bone67;
	private final ModelRenderer bone107;
	private final ModelRenderer bone121;
	private final ModelRenderer bone127;
	private final ModelRenderer bone114;
	private final ModelRenderer bone46;
	private final ModelRenderer bone35;
	private final ModelRenderer bone100;
	private final ModelRenderer bone69;
	private final ModelRenderer bone36;
	private final ModelRenderer bone59;
	private final ModelRenderer bone77;
	private final ModelRenderer bone85;
	private final ModelRenderer bone108;
	private final ModelRenderer bone122;
	private final ModelRenderer bone128;
	private final ModelRenderer bone115;
	private final ModelRenderer bone47;
	private final ModelRenderer bone68;
	private final ModelRenderer bone60;
	private final ModelRenderer bone48;
	private final ModelRenderer bone37;
	private final ModelRenderer bone38;
	private final ModelRenderer bone49;
	private final ModelRenderer bone50;
	private final ModelRenderer bone39;
	private final ModelRenderer bone51;
	private final ModelRenderer bone61;
	private final ModelRenderer bone40;
	private final ModelRenderer bone78;
	private final ModelRenderer bone93;
	private final ModelRenderer bone116;
	private final ModelRenderer bone86;
	private final ModelRenderer bone129;
	private final ModelRenderer bone101;
	private final ModelRenderer bone70;
	private final ModelRenderer bone52;
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
	private final ModelRenderer bone24;
	private final ModelRenderer bone25;
	private final ModelRenderer bone26;
	private final ModelRenderer bone27;
	private final ModelRenderer bone28;
	private final ModelRenderer bone156;
	private final ModelRenderer bone157;
	private final ModelRenderer bone130;
	private final ModelRenderer bone153;
	private final ModelRenderer bone131;
	private final ModelRenderer bone152;
	private final ModelRenderer bone133;
	private final ModelRenderer bone143;
	private final ModelRenderer bone150;
	private final ModelRenderer bone154;
	private final ModelRenderer bone155;
	private final ModelRenderer RightArm;
	private final ModelRenderer RightArm3;
	private final ModelRenderer bone193;
	private final ModelRenderer bone194;
	private final ModelRenderer bone195;
	private final ModelRenderer bone196;
	private final ModelRenderer bone197;
	private final ModelRenderer LeftArm;
	private final ModelRenderer LeftArm3;
	private final ModelRenderer bone188;
	private final ModelRenderer bone189;
	private final ModelRenderer bone190;
	private final ModelRenderer bone191;
	private final ModelRenderer bone192;
	private final ModelRenderer Head;
	private final ModelRenderer Head3;
	private final ModelRenderer bone162;
	private final ModelRenderer bone163;
	private final ModelRenderer bone164;
	private final ModelRenderer bone165;
	private final ModelRenderer bone166;
	private final ModelRenderer bone182;
	private final ModelRenderer bone167;
	private final ModelRenderer bone168;
	private final ModelRenderer bone184;
	private final ModelRenderer bone169;
	private final ModelRenderer bone170;
	private final ModelRenderer bone186;
	private final ModelRenderer bone171;
	private final ModelRenderer bone172;
	private final ModelRenderer bone173;
	private final ModelRenderer bone174;
	private final ModelRenderer bone175;
	private final ModelRenderer bone176;
	private final ModelRenderer bone183;
	private final ModelRenderer bone177;
	private final ModelRenderer bone178;
	private final ModelRenderer bone185;
	private final ModelRenderer bone179;
	private final ModelRenderer bone180;
	private final ModelRenderer bone187;
	private final ModelRenderer bone181;
	private final ModelRenderer bone161;
	private final ModelRenderer bone158;
	private final ModelRenderer bone159;
	private final ModelRenderer bone160;
	private final ModelRenderer middlebody;
	private final ModelRenderer bone;
	private final ModelRenderer bone17;
	private final ModelRenderer bone18;
	private final ModelRenderer bone19;
	private final ModelRenderer bone23;
	private final ModelRenderer bone20;
	private final ModelRenderer bone21;
	private final ModelRenderer bone22;
	private final ModelRenderer bone2;
	private final ModelRenderer bone3;
	private final ModelRenderer bone4;
	private final ModelRenderer bone5;
	private final ModelRenderer LowerBody;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer LeftLeg3;
	private final ModelRenderer bone198;
	private final ModelRenderer bone199;
	private final ModelRenderer bone200;
	private final ModelRenderer RightLeg;
	private final ModelRenderer RightLeg3;
	private final ModelRenderer bone201;
	private final ModelRenderer bone202;
	private final ModelRenderer bone203;

	public ModelHollow() {
		textureWidth = 215;
		textureHeight = 215;

		Hollow = new ModelRenderer(this);
		Hollow.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		UpperBody2 = new ModelRenderer(this);
		UpperBody2.setRotationPoint(0.0F, -124.0F, 18.0F);
		Hollow.addChild(UpperBody2);
		setRotationAngle(UpperBody2, 1.309F, 0.0F, 0.0F);
		

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, -22.0F, 5.0F);
		UpperBody2.addChild(Body);
		setRotationAngle(Body, 0.5236F, 0.0F, 0.0F);
		

		upperbody = new ModelRenderer(this);
		upperbody.setRotationPoint(0.0F, 22.0F, -5.0F);
		Body.addChild(upperbody);
		

		bone151 = new ModelRenderer(this);
		bone151.setRotationPoint(-10.75F, -11.75F, -6.75F);
		upperbody.addChild(bone151);
		setRotationAngle(bone151, 0.0F, 0.0F, -1.0472F);
		bone151.cubeList.add(new ModelBox(bone151, 4, 123, 29.5545F, -6.1288F, -17.9514F, 27, 4, 1, 0.0F, false));

		bone132 = new ModelRenderer(this);
		bone132.setRotationPoint(0.5F, -10.0F, 11.5F);
		upperbody.addChild(bone132);
		setRotationAngle(bone132, 0.0F, 0.0F, -1.2217F);
		bone132.cubeList.add(new ModelBox(bone132, 1, 108, 5.9161F, -5.3534F, -17.9514F, 48, 4, 1, 0.0F, false));

		bone141 = new ModelRenderer(this);
		bone141.setRotationPoint(3.5F, 11.5F, 11.5F);
		upperbody.addChild(bone141);
		bone141.cubeList.add(new ModelBox(bone141, 13, 109, -7.2766F, -36.65F, -17.7208F, 7, 4, 1, 0.0F, false));

		bone140 = new ModelRenderer(this);
		bone140.setRotationPoint(3.5F, 7.5F, 11.5F);
		upperbody.addChild(bone140);
		bone140.cubeList.add(new ModelBox(bone140, 26, 95, -9.2766F, -36.65F, -17.7208F, 10, 4, 1, 0.0F, false));

		bone139 = new ModelRenderer(this);
		bone139.setRotationPoint(3.5F, 3.5F, 11.5F);
		upperbody.addChild(bone139);
		bone139.cubeList.add(new ModelBox(bone139, 10, 116, -8.2766F, -36.65F, -17.7208F, 10, 4, 1, 0.0F, false));

		bone138 = new ModelRenderer(this);
		bone138.setRotationPoint(3.5F, -0.5F, 11.5F);
		upperbody.addChild(bone138);
		bone138.cubeList.add(new ModelBox(bone138, 17, 95, -10.2766F, -36.65F, -17.7208F, 13, 4, 1, 0.0F, false));

		bone137 = new ModelRenderer(this);
		bone137.setRotationPoint(3.5F, -4.5F, 11.5F);
		upperbody.addChild(bone137);
		bone137.cubeList.add(new ModelBox(bone137, 17, 107, -11.2766F, -36.65F, -17.7208F, 16, 4, 1, 0.0F, false));

		bone136 = new ModelRenderer(this);
		bone136.setRotationPoint(3.5F, -8.5F, 11.5F);
		upperbody.addChild(bone136);
		bone136.cubeList.add(new ModelBox(bone136, 10, 109, -14.2766F, -36.65F, -17.7208F, 20, 4, 1, 0.0F, false));

		bone135 = new ModelRenderer(this);
		bone135.setRotationPoint(3.5F, -12.5F, 11.5F);
		upperbody.addChild(bone135);
		bone135.cubeList.add(new ModelBox(bone135, 2, 108, -15.2766F, -36.65F, -17.7208F, 22, 4, 1, 0.0F, false));

		bone134 = new ModelRenderer(this);
		bone134.setRotationPoint(3.5F, -16.5F, 11.5F);
		upperbody.addChild(bone134);
		bone134.cubeList.add(new ModelBox(bone134, 4, 120, -17.2766F, -36.65F, -17.7208F, 26, 4, 1, 0.0F, false));

		bone145 = new ModelRenderer(this);
		bone145.setRotationPoint(-20.0F, -27.5F, -3.25F);
		upperbody.addChild(bone145);
		bone145.cubeList.add(new ModelBox(bone145, 7, 112, 0.7234F, -36.9F, -5.4708F, 4, 4, 3, 0.0F, false));
		bone145.cubeList.add(new ModelBox(bone145, 5, 116, 33.9734F, -36.9F, -5.4708F, 4, 4, 3, 0.0F, false));
		bone145.cubeList.add(new ModelBox(bone145, 10, 121, 33.9734F, -36.9F, -20.4708F, 4, 4, 3, 0.0F, false));
		bone145.cubeList.add(new ModelBox(bone145, 9, 120, 0.9734F, -36.9F, -20.4708F, 4, 4, 3, 0.0F, false));

		bone146 = new ModelRenderer(this);
		bone146.setRotationPoint(15.0F, -27.5F, -6.25F);
		upperbody.addChild(bone146);
		bone146.cubeList.add(new ModelBox(bone146, 9, 109, -1.2766F, -37.65F, -14.4708F, 6, 4, 12, 0.0F, false));

		bone144 = new ModelRenderer(this);
		bone144.setRotationPoint(-20.0F, -27.5F, -6.25F);
		upperbody.addChild(bone144);
		bone144.cubeList.add(new ModelBox(bone144, 3, 106, -1.2766F, -37.65F, -14.4708F, 6, 4, 12, 0.0F, false));

		bone148 = new ModelRenderer(this);
		bone148.setRotationPoint(13.25F, -28.5F, -6.25F);
		upperbody.addChild(bone148);
		setRotationAngle(bone148, 0.0F, 0.0F, 0.1745F);
		bone148.cubeList.add(new ModelBox(bone148, 12, 94, -20.129F, -36.5754F, -15.7208F, 15, 4, 15, 0.0F, false));

		bone147 = new ModelRenderer(this);
		bone147.setRotationPoint(9.0F, -32.5F, -6.25F);
		upperbody.addChild(bone147);
		setRotationAngle(bone147, 0.0F, 0.0F, -0.1745F);
		bone147.cubeList.add(new ModelBox(bone147, 2, 101, -18.4242F, -36.5754F, -15.7208F, 15, 4, 15, 0.0F, false));

		bone149 = new ModelRenderer(this);
		bone149.setRotationPoint(3.5F, -27.5F, -6.25F);
		upperbody.addChild(bone149);
		bone149.cubeList.add(new ModelBox(bone149, 5, 109, -19.2766F, -36.65F, -16.7208F, 30, 4, 17, 0.0F, false));

		bone142 = new ModelRenderer(this);
		bone142.setRotationPoint(3.5F, -27.5F, -6.25F);
		upperbody.addChild(bone142);
		bone142.cubeList.add(new ModelBox(bone142, 4, 100, -19.2766F, -36.65F, -16.7208F, 30, 4, 17, 0.0F, false));

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(0.0F, -24.75F, 6.0F);
		upperbody.addChild(bone6);
		setRotationAngle(bone6, -0.6109F, 0.0F, 0.0F);
		bone6.cubeList.add(new ModelBox(bone6, 4, 140, -2.0F, 3.4883F, -17.8246F, 3, 3, 2, 0.0F, false));

		bone29 = new ModelRenderer(this);
		bone29.setRotationPoint(2.0F, -24.25F, 7.0F);
		upperbody.addChild(bone29);
		setRotationAngle(bone29, 0.0F, 0.2618F, 0.0873F);
		bone29.cubeList.add(new ModelBox(bone29, 4, 140, 2.3287F, -7.8908F, -17.8089F, 7, 3, 2, 0.0F, false));

		bone53 = new ModelRenderer(this);
		bone53.setRotationPoint(2.0F, -30.5F, 9.0F);
		upperbody.addChild(bone53);
		setRotationAngle(bone53, 0.0F, 0.2618F, 0.0873F);
		bone53.cubeList.add(new ModelBox(bone53, 4, 140, 2.3287F, -7.8908F, -17.8089F, 7, 3, 2, 0.0F, false));

		bone71 = new ModelRenderer(this);
		bone71.setRotationPoint(2.0F, -35.75F, 10.0F);
		upperbody.addChild(bone71);
		setRotationAngle(bone71, 0.0F, 0.2618F, 0.0F);
		bone71.cubeList.add(new ModelBox(bone71, 4, 140, 2.7422F, -7.9095F, -17.6981F, 8, 3, 2, 0.0F, false));

		bone87 = new ModelRenderer(this);
		bone87.setRotationPoint(2.0F, -42.75F, 10.0F);
		upperbody.addChild(bone87);
		setRotationAngle(bone87, 0.0F, 0.2618F, 0.0F);
		bone87.cubeList.add(new ModelBox(bone87, 4, 140, 2.8716F, -7.9095F, -18.1811F, 9, 3, 2, 0.0F, false));

		bone94 = new ModelRenderer(this);
		bone94.setRotationPoint(-8.0F, -42.75F, 8.75F);
		upperbody.addChild(bone94);
		setRotationAngle(bone94, 0.0F, -0.2618F, 0.0F);
		bone94.cubeList.add(new ModelBox(bone94, 4, 140, -6.6128F, -7.9095F, -18.1811F, 9, 3, 2, 0.0F, false));

		bone79 = new ModelRenderer(this);
		bone79.setRotationPoint(-7.0F, -35.75F, 8.75F);
		upperbody.addChild(bone79);
		setRotationAngle(bone79, 0.0F, -0.2618F, 0.0F);
		bone79.cubeList.add(new ModelBox(bone79, 4, 140, -6.7422F, -7.9095F, -17.6981F, 8, 3, 2, 0.0F, false));

		bone102 = new ModelRenderer(this);
		bone102.setRotationPoint(-7.0F, -47.75F, 6.25F);
		upperbody.addChild(bone102);
		setRotationAngle(bone102, 0.0F, -0.2618F, 0.0F);
		bone102.cubeList.add(new ModelBox(bone102, 4, 140, -6.6775F, -7.9095F, -17.4566F, 8, 3, 2, 0.0F, false));

		bone117 = new ModelRenderer(this);
		bone117.setRotationPoint(-7.0F, -52.75F, 4.0F);
		upperbody.addChild(bone117);
		setRotationAngle(bone117, 0.0F, -0.2618F, 0.0F);
		bone117.cubeList.add(new ModelBox(bone117, 4, 140, -6.6775F, -7.9095F, -17.4566F, 9, 3, 2, 0.0F, false));

		bone123 = new ModelRenderer(this);
		bone123.setRotationPoint(2.25F, -52.75F, 5.25F);
		upperbody.addChild(bone123);
		setRotationAngle(bone123, 0.0F, 0.2618F, 0.0F);
		bone123.cubeList.add(new ModelBox(bone123, 4, 140, 1.8069F, -7.9095F, -17.4566F, 9, 3, 2, 0.0F, false));

		bone109 = new ModelRenderer(this);
		bone109.setRotationPoint(2.0F, -47.75F, 7.5F);
		upperbody.addChild(bone109);
		setRotationAngle(bone109, 0.0F, 0.2618F, 0.0F);
		bone109.cubeList.add(new ModelBox(bone109, 4, 140, 2.8069F, -7.9095F, -17.4566F, 8, 3, 2, 0.0F, false));

		bone62 = new ModelRenderer(this);
		bone62.setRotationPoint(-6.0F, -30.25F, 8.5F);
		upperbody.addChild(bone62);
		setRotationAngle(bone62, 0.0F, -0.2618F, -0.0873F);
		bone62.cubeList.add(new ModelBox(bone62, 4, 140, -6.1519F, -7.8908F, -18.1151F, 7, 3, 2, 0.0F, false));

		bone41 = new ModelRenderer(this);
		bone41.setRotationPoint(-6.0F, -24.0F, 7.0F);
		upperbody.addChild(bone41);
		setRotationAngle(bone41, 0.0F, -0.2618F, -0.0873F);
		bone41.cubeList.add(new ModelBox(bone41, 4, 140, -6.3287F, -7.8908F, -17.8089F, 7, 3, 2, 0.0F, false));

		bone30 = new ModelRenderer(this);
		bone30.setRotationPoint(7.5F, -23.75F, 5.0F);
		upperbody.addChild(bone30);
		setRotationAngle(bone30, 0.0F, 0.6109F, 0.0F);
		bone30.cubeList.add(new ModelBox(bone30, 4, 140, 8.5098F, -7.9095F, -15.0085F, 3, 3, 2, 0.0F, false));

		bone54 = new ModelRenderer(this);
		bone54.setRotationPoint(7.5F, -28.75F, 7.0F);
		upperbody.addChild(bone54);
		setRotationAngle(bone54, 0.0F, 0.6109F, 0.0F);
		bone54.cubeList.add(new ModelBox(bone54, 4, 140, 8.5098F, -8.9095F, -15.0085F, 3, 3, 2, 0.0F, false));

		bone72 = new ModelRenderer(this);
		bone72.setRotationPoint(9.5F, -34.75F, 7.0F);
		upperbody.addChild(bone72);
		setRotationAngle(bone72, 0.0F, 0.6109F, 0.0F);
		bone72.cubeList.add(new ModelBox(bone72, 4, 140, 7.6086F, -8.9095F, -15.0291F, 4, 3, 2, 0.0F, false));

		bone88 = new ModelRenderer(this);
		bone88.setRotationPoint(10.5F, -41.75F, 7.0F);
		upperbody.addChild(bone88);
		setRotationAngle(bone88, 0.0F, 0.6109F, 0.0F);
		bone88.cubeList.add(new ModelBox(bone88, 4, 140, 7.8954F, -8.9095F, -15.4387F, 4, 3, 2, 0.0F, false));

		bone95 = new ModelRenderer(this);
		bone95.setRotationPoint(-10.0F, -41.75F, 7.75F);
		upperbody.addChild(bone95);
		setRotationAngle(bone95, 0.0F, -0.6109F, 0.0F);
		bone95.cubeList.add(new ModelBox(bone95, 4, 140, -13.1242F, -8.9095F, -15.4387F, 4, 3, 2, 0.0F, false));

		bone80 = new ModelRenderer(this);
		bone80.setRotationPoint(-8.75F, -34.75F, 8.0F);
		upperbody.addChild(bone80);
		setRotationAngle(bone80, 0.0F, -0.6109F, 0.0F);
		bone80.cubeList.add(new ModelBox(bone80, 4, 140, -13.411F, -8.9095F, -15.0291F, 4, 3, 2, 0.0F, false));

		bone63 = new ModelRenderer(this);
		bone63.setRotationPoint(-7.5F, -28.75F, 7.5F);
		upperbody.addChild(bone63);
		setRotationAngle(bone63, 0.0F, -0.6109F, 0.0F);
		bone63.cubeList.add(new ModelBox(bone63, 4, 140, -12.5098F, -8.9095F, -15.0085F, 3, 3, 2, 0.0F, false));

		bone103 = new ModelRenderer(this);
		bone103.setRotationPoint(-8.75F, -46.75F, 5.75F);
		upperbody.addChild(bone103);
		setRotationAngle(bone103, 0.0F, -0.6109F, 0.0F);
		bone103.cubeList.add(new ModelBox(bone103, 4, 140, -12.5098F, -8.9095F, -15.0085F, 3, 3, 2, 0.0F, false));

		bone118 = new ModelRenderer(this);
		bone118.setRotationPoint(-9.0F, -51.75F, 3.5F);
		upperbody.addChild(bone118);
		setRotationAngle(bone118, 0.0F, -0.6109F, 0.0F);
		bone118.cubeList.add(new ModelBox(bone118, 4, 140, -12.5098F, -8.9095F, -15.0085F, 3, 3, 2, 0.0F, false));

		bone124 = new ModelRenderer(this);
		bone124.setRotationPoint(9.0F, -51.5F, 3.0F);
		upperbody.addChild(bone124);
		setRotationAngle(bone124, 0.0F, 0.6109F, 0.0F);
		bone124.cubeList.add(new ModelBox(bone124, 4, 140, 8.5098F, -8.9095F, -15.0085F, 3, 3, 2, 0.0F, false));

		bone110 = new ModelRenderer(this);
		bone110.setRotationPoint(8.75F, -46.75F, 5.25F);
		upperbody.addChild(bone110);
		setRotationAngle(bone110, 0.0F, 0.6109F, 0.0F);
		bone110.cubeList.add(new ModelBox(bone110, 4, 140, 8.5098F, -8.9095F, -15.0085F, 3, 3, 2, 0.0F, false));

		bone42 = new ModelRenderer(this);
		bone42.setRotationPoint(-7.75F, -23.75F, 6.25F);
		upperbody.addChild(bone42);
		setRotationAngle(bone42, 0.0F, -0.6109F, 0.0F);
		bone42.cubeList.add(new ModelBox(bone42, 4, 140, -12.5098F, -7.9095F, -15.0085F, 3, 3, 2, 0.0F, false));

		bone31 = new ModelRenderer(this);
		bone31.setRotationPoint(12.0F, -23.75F, 1.25F);
		upperbody.addChild(bone31);
		setRotationAngle(bone31, 0.0F, 0.9599F, 0.0F);
		bone31.cubeList.add(new ModelBox(bone31, 4, 140, 9.3013F, -7.9095F, -11.8815F, 4, 3, 2, 0.0F, false));

		bone55 = new ModelRenderer(this);
		bone55.setRotationPoint(12.0F, -28.75F, 3.25F);
		upperbody.addChild(bone55);
		setRotationAngle(bone55, 0.0F, 0.9599F, 0.0F);
		bone55.cubeList.add(new ModelBox(bone55, 4, 140, 9.3013F, -8.9095F, -11.8815F, 5, 3, 2, 0.0F, false));

		bone73 = new ModelRenderer(this);
		bone73.setRotationPoint(14.75F, -34.75F, 3.25F);
		upperbody.addChild(bone73);
		setRotationAngle(bone73, 0.0F, 0.9599F, 0.0F);
		bone73.cubeList.add(new ModelBox(bone73, 4, 140, 9.0145F, -8.9095F, -12.2911F, 5, 3, 2, 0.0F, false));

		bone89 = new ModelRenderer(this);
		bone89.setRotationPoint(16.0F, -41.75F, 2.5F);
		upperbody.addChild(bone89);
		setRotationAngle(bone89, 0.0F, 0.9599F, 0.0F);
		bone89.cubeList.add(new ModelBox(bone89, 4, 140, 9.0145F, -8.9095F, -12.2911F, 5, 3, 2, 0.0F, false));

		bone96 = new ModelRenderer(this);
		bone96.setRotationPoint(-12.0F, -41.75F, 8.5F);
		upperbody.addChild(bone96);
		setRotationAngle(bone96, 0.0F, -0.9599F, 0.0F);
		bone96.cubeList.add(new ModelBox(bone96, 4, 140, -21.3507F, -8.9095F, -12.2297F, 5, 3, 2, 0.0F, false));

		bone81 = new ModelRenderer(this);
		bone81.setRotationPoint(-11.25F, -34.75F, 9.0F);
		upperbody.addChild(bone81);
		setRotationAngle(bone81, 0.0F, -0.9599F, 0.0F);
		bone81.cubeList.add(new ModelBox(bone81, 4, 140, -21.0025F, -8.9095F, -12.2911F, 5, 3, 2, 0.0F, false));

		bone64 = new ModelRenderer(this);
		bone64.setRotationPoint(-9.0F, -28.75F, 8.5F);
		upperbody.addChild(bone64);
		setRotationAngle(bone64, 0.0F, -0.9599F, 0.0F);
		bone64.cubeList.add(new ModelBox(bone64, 4, 140, -20.7157F, -8.9095F, -11.8815F, 5, 3, 2, 0.0F, false));

		bone104 = new ModelRenderer(this);
		bone104.setRotationPoint(-10.5F, -46.75F, 6.5F);
		upperbody.addChild(bone104);
		setRotationAngle(bone104, 0.0F, -0.9599F, 0.0F);
		bone104.cubeList.add(new ModelBox(bone104, 4, 140, -20.7157F, -8.9095F, -11.8815F, 5, 3, 2, 0.0F, false));

		bone119 = new ModelRenderer(this);
		bone119.setRotationPoint(-10.5F, -51.25F, 4.0F);
		upperbody.addChild(bone119);
		setRotationAngle(bone119, 0.0F, -1.1345F, 0.0F);
		bone119.cubeList.add(new ModelBox(bone119, 4, 140, -22.1923F, -9.1595F, -8.7823F, 5, 3, 2, 0.0F, false));

		bone125 = new ModelRenderer(this);
		bone125.setRotationPoint(12.25F, -51.25F, -1.5F);
		upperbody.addChild(bone125);
		setRotationAngle(bone125, 0.0F, 1.1345F, 0.0F);
		bone125.cubeList.add(new ModelBox(bone125, 4, 140, 11.0197F, -9.1595F, -8.7823F, 5, 3, 2, 0.0F, false));

		bone111 = new ModelRenderer(this);
		bone111.setRotationPoint(13.25F, -46.75F, 1.25F);
		upperbody.addChild(bone111);
		setRotationAngle(bone111, 0.0F, 0.9599F, 0.0F);
		bone111.cubeList.add(new ModelBox(bone111, 4, 140, 9.3013F, -8.9095F, -11.8815F, 5, 3, 2, 0.0F, false));

		bone43 = new ModelRenderer(this);
		bone43.setRotationPoint(-9.0F, -23.75F, 7.75F);
		upperbody.addChild(bone43);
		setRotationAngle(bone43, 0.0F, -0.9599F, 0.0F);
		bone43.cubeList.add(new ModelBox(bone43, 4, 140, -20.7157F, -7.9095F, -11.8815F, 4, 3, 2, 0.0F, false));

		bone32 = new ModelRenderer(this);
		bone32.setRotationPoint(10.75F, -23.75F, -2.25F);
		upperbody.addChild(bone32);
		setRotationAngle(bone32, 0.0F, 1.5708F, 0.0F);
		bone32.cubeList.add(new ModelBox(bone32, 4, 140, 12.6152F, -7.9095F, -1.3716F, 3, 3, 2, 0.0F, false));

		bone56 = new ModelRenderer(this);
		bone56.setRotationPoint(13.0F, -28.5F, -7.5F);
		upperbody.addChild(bone56);
		setRotationAngle(bone56, 0.0F, 1.3963F, 0.0F);
		bone56.cubeList.add(new ModelBox(bone56, 4, 140, 6.2974F, -9.1595F, -4.0055F, 3, 3, 2, 0.0F, false));

		bone74 = new ModelRenderer(this);
		bone74.setRotationPoint(15.75F, -34.25F, -7.75F);
		upperbody.addChild(bone74);
		setRotationAngle(bone74, 0.0F, 1.3963F, 0.0F);
		bone74.cubeList.add(new ModelBox(bone74, 4, 140, 6.2105F, -9.4095F, -4.4979F, 3, 3, 2, 0.0F, false));

		bone90 = new ModelRenderer(this);
		bone90.setRotationPoint(17.0F, -41.0F, -8.25F);
		upperbody.addChild(bone90);
		setRotationAngle(bone90, 0.0F, 1.3963F, 0.0F);
		bone90.cubeList.add(new ModelBox(bone90, 4, 140, 6.2105F, -9.4095F, -4.4979F, 3, 3, 2, 0.0F, false));

		bone97 = new ModelRenderer(this);
		bone97.setRotationPoint(-13.25F, -41.0F, 12.75F);
		upperbody.addChild(bone97);
		setRotationAngle(bone97, 0.0F, -1.3963F, 0.0F);
		bone97.cubeList.add(new ModelBox(bone97, 4, 140, -30.6599F, -9.4095F, -4.3819F, 3, 3, 2, 0.0F, false));

		bone82 = new ModelRenderer(this);
		bone82.setRotationPoint(-12.5F, -34.25F, 12.75F);
		upperbody.addChild(bone82);
		setRotationAngle(bone82, 0.0F, -1.3963F, 0.0F);
		bone82.cubeList.add(new ModelBox(bone82, 4, 140, -29.8779F, -9.4095F, -4.4979F, 3, 3, 2, 0.0F, false));

		bone65 = new ModelRenderer(this);
		bone65.setRotationPoint(-10.0F, -28.5F, 12.75F);
		upperbody.addChild(bone65);
		setRotationAngle(bone65, 0.0F, -1.3963F, 0.0F);
		bone65.cubeList.add(new ModelBox(bone65, 4, 140, -29.791F, -9.1595F, -4.0055F, 3, 3, 2, 0.0F, false));

		bone105 = new ModelRenderer(this);
		bone105.setRotationPoint(-11.5F, -46.5F, 10.5F);
		upperbody.addChild(bone105);
		setRotationAngle(bone105, 0.0F, -1.3963F, 0.0F);
		bone105.cubeList.add(new ModelBox(bone105, 4, 140, -29.791F, -9.1595F, -4.0055F, 3, 3, 2, 0.0F, false));

		bone112 = new ModelRenderer(this);
		bone112.setRotationPoint(14.0F, -46.5F, -9.5F);
		upperbody.addChild(bone112);
		setRotationAngle(bone112, 0.0F, 1.3963F, 0.0F);
		bone112.cubeList.add(new ModelBox(bone112, 4, 140, 6.2974F, -9.1595F, -4.0055F, 3, 3, 2, 0.0F, false));

		bone44 = new ModelRenderer(this);
		bone44.setRotationPoint(-12.0F, -23.75F, 6.25F);
		upperbody.addChild(bone44);
		setRotationAngle(bone44, 0.0F, -1.5708F, 0.0F);
		bone44.cubeList.add(new ModelBox(bone44, 4, 140, -24.0296F, -7.9095F, -1.3716F, 3, 3, 2, 0.0F, false));

		bone33 = new ModelRenderer(this);
		bone33.setRotationPoint(8.75F, -23.75F, -4.5F);
		upperbody.addChild(bone33);
		setRotationAngle(bone33, 0.0F, 1.9199F, 0.0F);
		bone33.cubeList.add(new ModelBox(bone33, 4, 140, 11.51F, -7.9095F, 4.8956F, 3, 3, 2, 0.0F, false));

		bone57 = new ModelRenderer(this);
		bone57.setRotationPoint(9.5F, -28.5F, -4.0F);
		upperbody.addChild(bone57);
		setRotationAngle(bone57, 0.0F, 1.9199F, 0.0F);
		bone57.cubeList.add(new ModelBox(bone57, 4, 140, 11.1041F, -8.9095F, 5.2799F, 4, 3, 2, 0.0F, false));

		bone75 = new ModelRenderer(this);
		bone75.setRotationPoint(12.25F, -34.25F, -4.0F);
		upperbody.addChild(bone75);
		setRotationAngle(bone75, 0.0F, 1.9199F, 0.0F);
		bone75.cubeList.add(new ModelBox(bone75, 4, 140, 11.1896F, -9.4095F, 5.045F, 4, 3, 2, 0.0F, false));

		bone91 = new ModelRenderer(this);
		bone91.setRotationPoint(13.25F, -40.75F, -4.75F);
		upperbody.addChild(bone91);
		setRotationAngle(bone91, 0.0F, 1.9199F, 0.0F);
		bone91.cubeList.add(new ModelBox(bone91, 4, 140, 11.1896F, -9.4095F, 5.045F, 4, 3, 2, 0.0F, false));

		bone98 = new ModelRenderer(this);
		bone98.setRotationPoint(-15.75F, -40.75F, 3.5F);
		upperbody.addChild(bone98);
		setRotationAngle(bone98, 0.0F, -1.9199F, 0.0F);
		bone98.cubeList.add(new ModelBox(bone98, 4, 140, -23.8641F, -9.4095F, 5.5365F, 4, 3, 2, 0.0F, false));

		bone83 = new ModelRenderer(this);
		bone83.setRotationPoint(-15.0F, -34.25F, 3.5F);
		upperbody.addChild(bone83);
		setRotationAngle(bone83, 0.0F, -1.9199F, 0.0F);
		bone83.cubeList.add(new ModelBox(bone83, 4, 140, -23.2448F, -9.4095F, 5.045F, 4, 3, 2, 0.0F, false));

		bone66 = new ModelRenderer(this);
		bone66.setRotationPoint(-14.25F, -46.75F, 2.0F);
		upperbody.addChild(bone66);
		setRotationAngle(bone66, 0.0F, -1.9199F, 0.0F);
		bone66.cubeList.add(new ModelBox(bone66, 4, 140, -23.5653F, -8.9095F, 5.3654F, 4, 3, 2, 0.0F, false));

		bone120 = new ModelRenderer(this);
		bone120.setRotationPoint(-12.75F, -51.0F, 1.5F);
		upperbody.addChild(bone120);
		setRotationAngle(bone120, 0.0F, -1.9199F, 0.0F);
		bone120.cubeList.add(new ModelBox(bone120, 4, 140, -22.8389F, -9.1595F, 5.8992F, 4, 3, 2, 0.0F, false));

		bone126 = new ModelRenderer(this);
		bone126.setRotationPoint(9.25F, -51.0F, -5.0F);
		upperbody.addChild(bone126);
		setRotationAngle(bone126, 0.0F, 1.9199F, 0.0F);
		bone126.cubeList.add(new ModelBox(bone126, 4, 140, 11.5955F, -9.1595F, 5.8992F, 4, 3, 2, 0.0F, false));

		bone113 = new ModelRenderer(this);
		bone113.setRotationPoint(10.25F, -46.75F, -6.25F);
		upperbody.addChild(bone113);
		setRotationAngle(bone113, 0.0F, 1.9199F, 0.0F);
		bone113.cubeList.add(new ModelBox(bone113, 4, 140, 10.8691F, -8.9095F, 5.3654F, 4, 3, 2, 0.0F, false));

		bone106 = new ModelRenderer(this);
		bone106.setRotationPoint(-12.75F, -28.75F, 3.75F);
		upperbody.addChild(bone106);
		setRotationAngle(bone106, 0.0F, -1.9199F, 0.0F);
		bone106.cubeList.add(new ModelBox(bone106, 4, 140, -23.5653F, -8.9095F, 5.3654F, 4, 3, 2, 0.0F, false));

		bone45 = new ModelRenderer(this);
		bone45.setRotationPoint(-12.75F, -23.75F, 3.5F);
		upperbody.addChild(bone45);
		setRotationAngle(bone45, 0.0F, -1.9199F, 0.0F);
		bone45.cubeList.add(new ModelBox(bone45, 4, 140, -22.9244F, -7.9095F, 4.8956F, 3, 3, 2, 0.0F, false));

		bone34 = new ModelRenderer(this);
		bone34.setRotationPoint(5.25F, -23.75F, -4.75F);
		upperbody.addChild(bone34);
		setRotationAngle(bone34, 0.0F, 2.5307F, 0.0F);
		bone34.cubeList.add(new ModelBox(bone34, 4, 140, 4.8025F, -7.6595F, 13.6368F, 3, 2, 2, 0.0F, false));

		bone58 = new ModelRenderer(this);
		bone58.setRotationPoint(6.0F, -28.5F, -4.5F);
		upperbody.addChild(bone58);
		setRotationAngle(bone58, 0.0F, 2.5307F, 0.0F);
		bone58.cubeList.add(new ModelBox(bone58, 4, 140, 5.0279F, -8.4095F, 14.3946F, 3, 2, 2, 0.0F, false));

		bone76 = new ModelRenderer(this);
		bone76.setRotationPoint(8.25F, -35.0F, -4.5F);
		upperbody.addChild(bone76);
		setRotationAngle(bone76, 0.0F, 2.5307F, 0.0F);
		bone76.cubeList.add(new ModelBox(bone76, 4, 140, 5.0279F, -8.4095F, 14.3946F, 4, 2, 2, 0.0F, false));

		bone92 = new ModelRenderer(this);
		bone92.setRotationPoint(9.25F, -41.5F, -5.25F);
		upperbody.addChild(bone92);
		setRotationAngle(bone92, 0.0F, 2.5307F, 0.0F);
		bone92.cubeList.add(new ModelBox(bone92, 4, 140, 5.0279F, -8.1595F, 14.3946F, 4, 2, 2, 0.0F, false));

		bone99 = new ModelRenderer(this);
		bone99.setRotationPoint(-14.75F, -41.5F, -0.25F);
		upperbody.addChild(bone99);
		setRotationAngle(bone99, 0.0F, -2.5307F, 0.0F);
		bone99.cubeList.add(new ModelBox(bone99, 4, 140, -16.2169F, -8.1595F, 15.1523F, 4, 2, 2, 0.0F, false));

		bone84 = new ModelRenderer(this);
		bone84.setRotationPoint(-14.25F, -35.0F, -0.25F);
		upperbody.addChild(bone84);
		setRotationAngle(bone84, 0.0F, -2.5307F, 0.0F);
		bone84.cubeList.add(new ModelBox(bone84, 4, 140, -15.9915F, -8.4095F, 14.3946F, 4, 2, 2, 0.0F, false));

		bone67 = new ModelRenderer(this);
		bone67.setRotationPoint(-13.0F, -28.5F, 0.75F);
		upperbody.addChild(bone67);
		setRotationAngle(bone67, 0.0F, -2.5307F, 0.0F);
		bone67.cubeList.add(new ModelBox(bone67, 4, 140, -16.2783F, -8.4095F, 14.8041F, 3, 2, 2, 0.0F, false));

		bone107 = new ModelRenderer(this);
		bone107.setRotationPoint(-14.25F, -46.75F, -1.25F);
		upperbody.addChild(bone107);
		setRotationAngle(bone107, 0.0F, -2.5307F, 0.0F);
		bone107.cubeList.add(new ModelBox(bone107, 4, 140, -16.2783F, -8.4095F, 14.8041F, 3, 2, 2, 0.0F, false));

		bone121 = new ModelRenderer(this);
		bone121.setRotationPoint(-13.5F, -51.5F, -1.0F);
		upperbody.addChild(bone121);
		setRotationAngle(bone121, 0.0F, -2.5307F, 0.0F);
		bone121.cubeList.add(new ModelBox(bone121, 4, 140, -16.2783F, -8.4095F, 14.8041F, 3, 2, 2, 0.0F, false));

		bone127 = new ModelRenderer(this);
		bone127.setRotationPoint(5.5F, -51.5F, -5.75F);
		upperbody.addChild(bone127);
		setRotationAngle(bone127, 0.0F, 2.5307F, 0.0F);
		bone127.cubeList.add(new ModelBox(bone127, 4, 140, 4.5977F, -8.4095F, 15.0089F, 3, 2, 2, 0.0F, false));

		bone114 = new ModelRenderer(this);
		bone114.setRotationPoint(6.5F, -46.75F, -6.25F);
		upperbody.addChild(bone114);
		setRotationAngle(bone114, 0.0F, 2.5307F, 0.0F);
		bone114.cubeList.add(new ModelBox(bone114, 4, 140, 4.9459F, -8.4095F, 14.6607F, 3, 2, 2, 0.0F, false));

		bone46 = new ModelRenderer(this);
		bone46.setRotationPoint(-13.25F, -23.75F, 0.25F);
		upperbody.addChild(bone46);
		setRotationAngle(bone46, 0.0F, -2.5307F, 0.0F);
		bone46.cubeList.add(new ModelBox(bone46, 4, 140, -16.2169F, -7.9095F, 13.6368F, 3, 3, 2, 0.0F, false));

		bone35 = new ModelRenderer(this);
		bone35.setRotationPoint(2.25F, -24.25F, -3.0F);
		upperbody.addChild(bone35);
		setRotationAngle(bone35, 0.0F, 3.1416F, 0.0873F);
		bone35.cubeList.add(new ModelBox(bone35, 4, 140, -5.3011F, -7.6418F, 16.9507F, 2, 2, 2, 0.0F, false));

		bone100 = new ModelRenderer(this);
		bone100.setRotationPoint(-10.0F, -41.75F, -3.0F);
		upperbody.addChild(bone100);
		setRotationAngle(bone100, 0.0F, 3.1416F, -0.0873F);
		bone100.cubeList.add(new ModelBox(bone100, 4, 140, -9.1354F, -7.978F, 18.7007F, 10, 2, 2, 0.0F, false));

		bone69 = new ModelRenderer(this);
		bone69.setRotationPoint(-8.75F, -28.5F, -2.25F);
		upperbody.addChild(bone69);
		setRotationAngle(bone69, 0.0F, 3.1416F, -0.2618F);
		bone69.cubeList.add(new ModelBox(bone69, 4, 140, -7.9313F, -7.8218F, 17.9507F, 5, 2, 2, 0.0F, false));

		bone36 = new ModelRenderer(this);
		bone36.setRotationPoint(-0.5F, -25.5F, -3.0F);
		upperbody.addChild(bone36);
		setRotationAngle(bone36, 0.0F, 3.1416F, 0.2618F);
		bone36.cubeList.add(new ModelBox(bone36, 4, 140, -5.4547F, -7.5803F, 16.9507F, 2, 2, 2, 0.0F, false));

		bone59 = new ModelRenderer(this);
		bone59.setRotationPoint(2.75F, -29.5F, -2.75F);
		upperbody.addChild(bone59);
		setRotationAngle(bone59, 0.0F, 3.1416F, 0.0873F);
		bone59.cubeList.add(new ModelBox(bone59, 4, 140, -5.7774F, -7.9344F, 17.7007F, 2, 2, 2, 0.0F, false));

		bone77 = new ModelRenderer(this);
		bone77.setRotationPoint(3.75F, -36.0F, -3.5F);
		upperbody.addChild(bone77);
		setRotationAngle(bone77, 0.0F, 3.1416F, 0.0873F);
		bone77.cubeList.add(new ModelBox(bone77, 4, 140, -5.7774F, -7.9344F, 17.7007F, 7, 2, 2, 0.0F, false));
		bone77.cubeList.add(new ModelBox(bone77, 4, 140, -6.4779F, -14.2695F, 18.2007F, 10, 2, 2, 0.0F, false));

		bone85 = new ModelRenderer(this);
		bone85.setRotationPoint(-9.5F, -35.5F, -3.0F);
		upperbody.addChild(bone85);
		setRotationAngle(bone85, 0.0F, 3.1416F, -0.0873F);
		bone85.cubeList.add(new ModelBox(bone85, 4, 140, -6.6335F, -7.9344F, 18.2007F, 7, 2, 2, 0.0F, false));

		bone108 = new ModelRenderer(this);
		bone108.setRotationPoint(-9.25F, -47.25F, -3.5F);
		upperbody.addChild(bone108);
		setRotationAngle(bone108, 0.0F, 3.1416F, -0.0873F);
		bone108.cubeList.add(new ModelBox(bone108, 4, 140, -8.1354F, -7.978F, 18.9507F, 9, 2, 2, 0.0F, false));

		bone122 = new ModelRenderer(this);
		bone122.setRotationPoint(-8.25F, -51.75F, -3.25F);
		upperbody.addChild(bone122);
		setRotationAngle(bone122, 0.0F, 3.1416F, -0.0873F);
		bone122.cubeList.add(new ModelBox(bone122, 4, 140, -7.1354F, -7.978F, 18.9507F, 8, 2, 2, 0.0F, false));

		bone128 = new ModelRenderer(this);
		bone128.setRotationPoint(2.0F, -52.25F, -3.25F);
		upperbody.addChild(bone128);
		setRotationAngle(bone128, 0.0F, 3.1416F, 0.0873F);
		bone128.cubeList.add(new ModelBox(bone128, 4, 140, -6.2793F, -7.978F, 18.9507F, 8, 2, 2, 0.0F, false));

		bone115 = new ModelRenderer(this);
		bone115.setRotationPoint(2.0F, -47.75F, -3.5F);
		upperbody.addChild(bone115);
		setRotationAngle(bone115, 0.0F, 3.1416F, 0.0873F);
		bone115.cubeList.add(new ModelBox(bone115, 4, 140, -7.0303F, -7.9562F, 18.9507F, 9, 2, 2, 0.0F, false));

		bone47 = new ModelRenderer(this);
		bone47.setRotationPoint(-12.0F, -23.75F, -3.0F);
		upperbody.addChild(bone47);
		setRotationAngle(bone47, 0.0F, 3.1416F, -0.0873F);
		bone47.cubeList.add(new ModelBox(bone47, 4, 140, -5.6373F, -7.4363F, 16.9507F, 2, 2, 2, 0.0F, false));

		bone68 = new ModelRenderer(this);
		bone68.setRotationPoint(-13.5F, -28.5F, -2.0F);
		upperbody.addChild(bone68);
		setRotationAngle(bone68, 0.0F, 3.1416F, -0.0873F);
		bone68.cubeList.add(new ModelBox(bone68, 4, 140, -6.6335F, -7.9344F, 18.2007F, 2, 2, 2, 0.0F, false));

		bone60 = new ModelRenderer(this);
		bone60.setRotationPoint(0.75F, -30.75F, -3.0F);
		upperbody.addChild(bone60);
		setRotationAngle(bone60, 0.0F, 3.1416F, 0.2618F);
		bone60.cubeList.add(new ModelBox(bone60, 4, 140, -5.39F, -7.8218F, 17.4507F, 5, 2, 2, 0.0F, false));

		bone48 = new ModelRenderer(this);
		bone48.setRotationPoint(-11.0F, -23.25F, -2.75F);
		upperbody.addChild(bone48);
		setRotationAngle(bone48, 0.0F, 3.1416F, -0.2618F);
		bone48.cubeList.add(new ModelBox(bone48, 4, 140, -7.6251F, -7.162F, 17.2007F, 2, 2, 2, 0.0F, false));

		bone37 = new ModelRenderer(this);
		bone37.setRotationPoint(-2.0F, -27.25F, -3.0F);
		upperbody.addChild(bone37);
		setRotationAngle(bone37, 0.0F, 3.1416F, 0.4363F);
		bone37.cubeList.add(new ModelBox(bone37, 4, 140, -4.6506F, -7.2877F, 16.9507F, 2, 2, 2, 0.0F, false));

		bone38 = new ModelRenderer(this);
		bone38.setRotationPoint(-1.75F, -26.25F, -3.0F);
		upperbody.addChild(bone38);
		setRotationAngle(bone38, 0.0F, 3.1416F, 0.6981F);
		bone38.cubeList.add(new ModelBox(bone38, 4, 140, -0.4892F, -8.4728F, 16.9507F, 2, 2, 2, 0.0F, false));

		bone49 = new ModelRenderer(this);
		bone49.setRotationPoint(-9.0F, -22.5F, -3.0F);
		upperbody.addChild(bone49);
		setRotationAngle(bone49, 0.0F, 3.1416F, -0.4363F);
		bone49.cubeList.add(new ModelBox(bone49, 4, 140, -8.8F, -7.2877F, 16.9507F, 2, 2, 2, 0.0F, false));

		bone50 = new ModelRenderer(this);
		bone50.setRotationPoint(-3.0F, -22.75F, -3.0F);
		upperbody.addChild(bone50);
		setRotationAngle(bone50, 0.0F, 3.1416F, -0.6981F);
		bone50.cubeList.add(new ModelBox(bone50, 4, 140, -6.8005F, -8.4728F, 16.9507F, 2, 2, 2, 0.0F, false));

		bone39 = new ModelRenderer(this);
		bone39.setRotationPoint(-2.5F, -28.25F, -3.0F);
		upperbody.addChild(bone39);
		setRotationAngle(bone39, 0.0F, 3.1416F, 0.9599F);
		bone39.cubeList.add(new ModelBox(bone39, 4, 140, 1.073F, -7.4051F, 16.9507F, 2, 2, 2, 0.0F, false));

		bone51 = new ModelRenderer(this);
		bone51.setRotationPoint(-0.5F, -24.75F, -3.0F);
		upperbody.addChild(bone51);
		setRotationAngle(bone51, 0.0F, 3.1416F, -0.9599F);
		bone51.cubeList.add(new ModelBox(bone51, 4, 140, -6.9701F, -7.4051F, 16.9507F, 2, 2, 2, 0.0F, false));

		bone61 = new ModelRenderer(this);
		bone61.setRotationPoint(-1.5F, -30.5F, -3.0F);
		upperbody.addChild(bone61);
		setRotationAngle(bone61, 0.0F, 3.1416F, 0.3491F);
		bone61.cubeList.add(new ModelBox(bone61, 4, 140, -2.0102F, -8.4858F, 17.4507F, 2, 1, 2, 0.0F, false));

		bone40 = new ModelRenderer(this);
		bone40.setRotationPoint(-3.5F, -30.25F, -3.0F);
		upperbody.addChild(bone40);
		setRotationAngle(bone40, 0.0F, 3.1416F, 1.0472F);
		bone40.cubeList.add(new ModelBox(bone40, 4, 140, 0.5622F, -6.3272F, 16.9507F, 2, 1, 2, 0.0F, false));

		bone78 = new ModelRenderer(this);
		bone78.setRotationPoint(0.0F, -30.5F, -3.0F);
		upperbody.addChild(bone78);
		setRotationAngle(bone78, 0.0F, 3.1416F, 0.1745F);
		bone78.cubeList.add(new ModelBox(bone78, 4, 140, -1.1271F, -13.4059F, 18.2007F, 2, 1, 2, 0.0F, false));

		bone93 = new ModelRenderer(this);
		bone93.setRotationPoint(0.0F, -30.5F, -3.0F);
		upperbody.addChild(bone93);
		setRotationAngle(bone93, 0.0F, 3.1416F, 0.1745F);
		bone93.cubeList.add(new ModelBox(bone93, 4, 140, 0.9864F, -19.6335F, 18.7007F, 2, 1, 2, 0.0F, false));

		bone116 = new ModelRenderer(this);
		bone116.setRotationPoint(-0.25F, -35.75F, -3.5F);
		upperbody.addChild(bone116);
		setRotationAngle(bone116, 0.0F, 3.1416F, 0.1745F);
		bone116.cubeList.add(new ModelBox(bone116, 4, 140, 1.2326F, -19.5901F, 18.9507F, 2, 1, 2, 0.0F, false));

		bone86 = new ModelRenderer(this);
		bone86.setRotationPoint(-2.25F, -30.25F, -3.0F);
		upperbody.addChild(bone86);
		setRotationAngle(bone86, 0.0F, 3.1416F, -0.1745F);
		bone86.cubeList.add(new ModelBox(bone86, 4, 140, -2.8318F, -13.4059F, 18.2007F, 2, 1, 2, 0.0F, false));

		bone129 = new ModelRenderer(this);
		bone129.setRotationPoint(-0.25F, -18.25F, -8.25F);
		Body.addChild(bone129);
		setRotationAngle(bone129, 0.0F, 3.1416F, 0.1745F);
		bone129.cubeList.add(new ModelBox(bone129, 4, 140, 1.2326F, -19.5901F, 18.9507F, 2, 1, 2, 0.0F, false));

		bone101 = new ModelRenderer(this);
		bone101.setRotationPoint(-2.25F, -8.25F, -8.0F);
		Body.addChild(bone101);
		setRotationAngle(bone101, 0.0F, 3.1416F, -0.1745F);
		bone101.cubeList.add(new ModelBox(bone101, 4, 140, -4.9453F, -19.6335F, 18.7007F, 2, 1, 2, 0.0F, false));
		bone101.cubeList.add(new ModelBox(bone101, 4, 140, -5.8136F, -24.5575F, 19.4507F, 2, 1, 2, 0.0F, false));
		bone101.cubeList.add(new ModelBox(bone101, 4, 140, -6.595F, -28.9891F, 19.2007F, 2, 1, 2, 0.0F, false));

		bone70 = new ModelRenderer(this);
		bone70.setRotationPoint(-3.75F, -6.5F, -7.25F);
		Body.addChild(bone70);
		setRotationAngle(bone70, 0.0F, 3.1416F, -0.3491F);
		bone70.cubeList.add(new ModelBox(bone70, 4, 140, -5.3688F, -8.4858F, 17.9507F, 2, 1, 2, 0.0F, false));

		bone52 = new ModelRenderer(this);
		bone52.setRotationPoint(0.0F, -3.5F, -8.0F);
		Body.addChild(bone52);
		setRotationAngle(bone52, 0.0F, 3.1416F, -1.0472F);
		bone52.cubeList.add(new ModelBox(bone52, 4, 140, -7.9413F, -6.3272F, 16.9507F, 2, 1, 2, 0.0F, false));

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(0.0F, -4.5F, 2.5F);
		Body.addChild(bone7);
		setRotationAngle(bone7, -0.4363F, 0.0F, 0.0F);
		bone7.cubeList.add(new ModelBox(bone7, 4, 140, -2.0F, 0.2933F, -18.6807F, 3, 3, 2, 0.0F, false));

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(0.0F, -6.75F, 3.5F);
		Body.addChild(bone8);
		setRotationAngle(bone8, -0.2618F, 0.0F, 0.0F);
		bone8.cubeList.add(new ModelBox(bone8, 4, 140, -2.0F, -3.0F, -18.9687F, 3, 3, 2, 0.0F, false));

		bone9 = new ModelRenderer(this);
		bone9.setRotationPoint(0.0F, -9.25F, 4.25F);
		Body.addChild(bone9);
		setRotationAngle(bone9, -0.2618F, 0.0F, 0.0F);
		bone9.cubeList.add(new ModelBox(bone9, 4, 140, -2.0F, -3.0F, -18.9687F, 3, 3, 2, 0.0F, false));

		bone10 = new ModelRenderer(this);
		bone10.setRotationPoint(0.0F, -11.75F, 5.0F);
		Body.addChild(bone10);
		setRotationAngle(bone10, -0.1745F, 0.0F, 0.0F);
		bone10.cubeList.add(new ModelBox(bone10, 4, 140, -2.0F, -4.6539F, -18.8965F, 3, 3, 2, 0.0F, false));

		bone11 = new ModelRenderer(this);
		bone11.setRotationPoint(0.0F, -14.25F, 5.5F);
		Body.addChild(bone11);
		bone11.cubeList.add(new ModelBox(bone11, 4, 140, -2.0F, -7.9095F, -18.3224F, 3, 3, 2, 0.0F, false));

		bone12 = new ModelRenderer(this);
		bone12.setRotationPoint(0.0F, -17.0F, 5.5F);
		Body.addChild(bone12);
		setRotationAngle(bone12, 0.0873F, 0.0F, 0.0F);
		bone12.cubeList.add(new ModelBox(bone12, 4, 140, -2.0F, -9.4883F, -17.8246F, 3, 3, 2, 0.0F, false));

		bone13 = new ModelRenderer(this);
		bone13.setRotationPoint(0.0F, -19.25F, 5.25F);
		Body.addChild(bone13);
		setRotationAngle(bone13, 0.2618F, 0.0F, 0.0F);
		bone13.cubeList.add(new ModelBox(bone13, 4, 140, -2.0F, -12.4844F, -16.4274F, 3, 3, 2, 0.0F, false));

		bone14 = new ModelRenderer(this);
		bone14.setRotationPoint(0.0F, -21.75F, 4.5F);
		Body.addChild(bone14);
		setRotationAngle(bone14, 0.3491F, 0.0F, 0.0F);
		bone14.cubeList.add(new ModelBox(bone14, 4, 140, -2.0F, -13.8806F, -15.5379F, 3, 3, 2, 0.0F, false));

		bone15 = new ModelRenderer(this);
		bone15.setRotationPoint(0.0F, -24.25F, 3.5F);
		Body.addChild(bone15);
		setRotationAngle(bone15, 0.5236F, 0.0F, 0.0F);
		bone15.cubeList.add(new ModelBox(bone15, 4, 140, -2.0F, -16.4129F, -13.4129F, 3, 3, 2, 0.0F, false));

		bone16 = new ModelRenderer(this);
		bone16.setRotationPoint(0.0F, -26.5F, 2.25F);
		Body.addChild(bone16);
		setRotationAngle(bone16, 0.6109F, 0.0F, 0.0F);
		bone16.cubeList.add(new ModelBox(bone16, 4, 140, -2.0F, -17.5313F, -12.1924F, 3, 3, 2, 0.0F, false));

		bone24 = new ModelRenderer(this);
		bone24.setRotationPoint(0.0F, -28.75F, 0.5F);
		Body.addChild(bone24);
		setRotationAngle(bone24, 0.6109F, 0.0F, 0.0F);
		bone24.cubeList.add(new ModelBox(bone24, 4, 140, -2.0F, -17.5313F, -12.1924F, 3, 3, 2, 0.0F, false));

		bone25 = new ModelRenderer(this);
		bone25.setRotationPoint(0.0F, -30.75F, -1.25F);
		Body.addChild(bone25);
		setRotationAngle(bone25, 0.6981F, 0.0F, 0.0F);
		bone25.cubeList.add(new ModelBox(bone25, 4, 140, -2.0F, -18.5379F, -10.8805F, 3, 3, 2, 0.0F, false));

		bone26 = new ModelRenderer(this);
		bone26.setRotationPoint(0.0F, -32.75F, -3.25F);
		Body.addChild(bone26);
		setRotationAngle(bone26, 0.4363F, 0.0F, 0.0F);
		bone26.cubeList.add(new ModelBox(bone26, 4, 140, -2.0F, -15.1924F, -14.5313F, 3, 3, 2, 0.0F, false));

		bone27 = new ModelRenderer(this);
		bone27.setRotationPoint(0.0F, -35.5F, -4.5F);
		Body.addChild(bone27);
		setRotationAngle(bone27, 0.2618F, 0.0F, 0.0F);
		bone27.cubeList.add(new ModelBox(bone27, 4, 140, -2.0F, -12.4844F, -16.4274F, 3, 3, 2, 0.0F, false));

		bone28 = new ModelRenderer(this);
		bone28.setRotationPoint(0.0F, -38.0F, -5.25F);
		Body.addChild(bone28);
		setRotationAngle(bone28, 0.1745F, 0.0F, 0.0F);
		bone28.cubeList.add(new ModelBox(bone28, 4, 140, -2.0F, -11.016F, -17.1918F, 3, 3, 2, 0.0F, false));

		bone156 = new ModelRenderer(this);
		bone156.setRotationPoint(0.0F, -43.0F, -5.25F);
		Body.addChild(bone156);
		setRotationAngle(bone156, 0.1745F, 0.0F, 0.0F);
		bone156.cubeList.add(new ModelBox(bone156, 3, 91, -8.0F, -11.8306F, -20.9298F, 16, 10, 13, 0.0F, false));

		bone157 = new ModelRenderer(this);
		bone157.setRotationPoint(0.0F, -43.0F, -5.25F);
		Body.addChild(bone157);
		setRotationAngle(bone157, 0.1745F, 0.0F, 0.0F);
		bone157.cubeList.add(new ModelBox(bone157, 12, 102, -5.5F, -17.7242F, -20.7143F, 10, 7, 10, 0.0F, false));
		bone157.cubeList.add(new ModelBox(bone157, 13, 100, -4.0F, -20.6786F, -20.1933F, 7, 7, 8, 0.0F, false));

		bone130 = new ModelRenderer(this);
		bone130.setRotationPoint(2.5F, 13.0F, 6.5F);
		Body.addChild(bone130);
		setRotationAngle(bone130, 0.0F, 0.0F, 0.7854F);
		bone130.cubeList.add(new ModelBox(bone130, 11, 114, -8.7481F, -4.212F, -17.7208F, 3, 3, 1, 0.0F, false));

		bone153 = new ModelRenderer(this);
		bone153.setRotationPoint(2.5F, -10.0F, -11.75F);
		Body.addChild(bone153);
		setRotationAngle(bone153, 0.0F, 0.0F, 0.7854F);
		bone153.cubeList.add(new ModelBox(bone153, 6, 109, -8.7481F, -4.212F, -17.7208F, 4, 4, 1, 0.0F, false));

		bone131 = new ModelRenderer(this);
		bone131.setRotationPoint(0.5F, 12.25F, 6.5F);
		Body.addChild(bone131);
		setRotationAngle(bone131, 0.0F, 0.0F, 1.2217F);
		bone131.cubeList.add(new ModelBox(bone131, 7, 107, -54.8899F, -3.4198F, -17.7208F, 48, 4, 1, 0.0F, false));

		bone152 = new ModelRenderer(this);
		bone152.setRotationPoint(11.75F, 10.25F, -11.75F);
		Body.addChild(bone152);
		setRotationAngle(bone152, 0.0F, 0.0F, 1.0472F);
		bone152.cubeList.add(new ModelBox(bone152, 4, 102, -57.5283F, -4.1952F, -17.7208F, 27, 4, 1, 0.0F, false));

		bone133 = new ModelRenderer(this);
		bone133.setRotationPoint(3.5F, 1.5F, 6.5F);
		Body.addChild(bone133);
		bone133.cubeList.add(new ModelBox(bone133, 3, 89, -19.2766F, -36.65F, -17.7208F, 30, 4, 1, 0.0F, false));

		bone143 = new ModelRenderer(this);
		bone143.setRotationPoint(3.5F, -2.5F, 6.5F);
		Body.addChild(bone143);
		bone143.cubeList.add(new ModelBox(bone143, 3, 113, -19.2766F, -36.65F, -17.7208F, 30, 4, 1, 0.0F, false));

		bone150 = new ModelRenderer(this);
		bone150.setRotationPoint(3.5F, -2.5F, -11.5F);
		Body.addChild(bone150);
		bone150.cubeList.add(new ModelBox(bone150, 0, 122, -17.2766F, -36.65F, -17.7208F, 27, 4, 1, 0.0F, false));

		bone154 = new ModelRenderer(this);
		bone154.setRotationPoint(3.5F, 0.5F, -11.5F);
		Body.addChild(bone154);
		bone154.cubeList.add(new ModelBox(bone154, 5, 119, -15.2766F, -36.65F, -17.9708F, 21, 4, 1, 0.0F, false));

		bone155 = new ModelRenderer(this);
		bone155.setRotationPoint(3.5F, 4.5F, -11.5F);
		Body.addChild(bone155);
		bone155.cubeList.add(new ModelBox(bone155, 3, 118, -13.2766F, -36.65F, -17.9708F, 18, 4, 1, 0.0F, false));
		bone155.cubeList.add(new ModelBox(bone155, 0, 123, -11.2766F, -32.65F, -17.9708F, 13, 4, 1, 0.0F, false));
		bone155.cubeList.add(new ModelBox(bone155, 4, 117, -7.2766F, -29.65F, -17.9708F, 7, 6, 1, 0.0F, false));

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-17.25F, -35.75F, -1.25F);
		Body.addChild(RightArm);
		

		RightArm3 = new ModelRenderer(this);
		RightArm3.setRotationPoint(0.0F, 0.0F, 0.0F);
		RightArm.addChild(RightArm3);
		setRotationAngle(RightArm3, -2.1817F, 0.0F, -0.4363F);
		RightArm3.cubeList.add(new ModelBox(RightArm3, 10, 57, 0.0748F, 17.561F, 4.8645F, 4, 40, 5, 0.0F, false));

		bone193 = new ModelRenderer(this);
		bone193.setRotationPoint(-3.5253F, 37.3075F, 0.0F);
		RightArm3.addChild(bone193);
		setRotationAngle(bone193, -0.1745F, 0.0F, -0.2618F);
		bone193.cubeList.add(new ModelBox(bone193, 10, 57, -2.6671F, 15.192F, 7.7984F, 4, 72, 5, 0.0F, false));

		bone194 = new ModelRenderer(this);
		bone194.setRotationPoint(1.7548F, 67.2209F, 0.0896F);
		bone193.addChild(bone194);
		setRotationAngle(bone194, -0.8727F, 0.0F, 0.0F);
		bone194.cubeList.add(new ModelBox(bone194, 10, 57, -6.4544F, 3.4655F, 16.4316F, 8, 3, 5, 0.0F, false));
		bone194.cubeList.add(new ModelBox(bone194, 10, 57, -6.932F, 6.2628F, 16.1633F, 9, 3, 5, 0.0F, false));
		bone194.cubeList.add(new ModelBox(bone194, 10, 57, -8.9019F, 8.9746F, 15.8799F, 13, 10, 5, 0.0F, false));
		bone194.cubeList.add(new ModelBox(bone194, 10, 57, 5.7611F, 11.7846F, 14.3174F, 3, 4, 5, 0.0F, false));
		bone194.cubeList.add(new ModelBox(bone194, 10, 57, 3.7766F, 9.6587F, 13.9425F, 3, 4, 5, 0.0F, false));
		bone194.cubeList.add(new ModelBox(bone194, 10, 57, 7.108F, 14.5946F, 15.8128F, 3, 4, 4, 0.0F, false));
		bone194.cubeList.add(new ModelBox(bone194, 10, 57, 8.0643F, 17.4186F, 16.3108F, 2, 5, 4, 0.0F, false));
		bone194.cubeList.add(new ModelBox(bone194, 10, 57, 9.0931F, 21.0842F, 16.9571F, 2, 5, 4, 0.0F, false));
		bone194.cubeList.add(new ModelBox(bone194, 10, 57, -9.6684F, 16.0915F, 17.1348F, 13, 5, 4, 0.0F, false));

		bone195 = new ModelRenderer(this);
		bone195.setRotationPoint(-12.0F, -11.0419F, 15.9088F);
		bone194.addChild(bone195);
		bone195.cubeList.add(new ModelBox(bone195, 10, 57, 3.317F, 31.6847F, 1.2669F, 2, 8, 3, 0.0F, false));
		bone195.cubeList.add(new ModelBox(bone195, 10, 150, 3.4906F, 30.8451F, 0.3572F, 1, 2, 2, 0.0F, false));
		bone195.cubeList.add(new ModelBox(bone195, 6, 148, 7.8063F, 30.8445F, 0.3571F, 1, 2, 2, 0.0F, false));
		bone195.cubeList.add(new ModelBox(bone195, 14, 156, 12.8606F, 30.9722F, 0.3797F, 1, 2, 2, 0.0F, false));
		bone195.cubeList.add(new ModelBox(bone195, 10, 57, 3.3324F, 38.6874F, 2.5016F, 2, 4, 4, 0.0F, false));
		bone195.cubeList.add(new ModelBox(bone195, 10, 57, 3.7963F, 41.4207F, 5.0144F, 2, 4, 3, 0.0F, false));
		bone195.cubeList.add(new ModelBox(bone195, 10, 57, 3.9414F, 43.2722F, 6.3563F, 2, 4, 3, 0.0F, false));
		bone195.cubeList.add(new ModelBox(bone195, 10, 57, 4.1305F, 46.1314F, 8.4049F, 2, 4, 3, 0.0F, false));

		bone196 = new ModelRenderer(this);
		bone196.setRotationPoint(-8.0316F, -9.1028F, 16.2508F);
		bone194.addChild(bone196);
		bone196.cubeList.add(new ModelBox(bone196, 10, 57, 3.317F, 28.6847F, 1.2669F, 2, 11, 3, 0.0F, false));
		bone196.cubeList.add(new ModelBox(bone196, 10, 57, 3.3324F, 38.6874F, 2.5016F, 2, 4, 4, 0.0F, false));
		bone196.cubeList.add(new ModelBox(bone196, 10, 57, 3.7963F, 41.4207F, 5.0144F, 2, 4, 3, 0.0F, false));
		bone196.cubeList.add(new ModelBox(bone196, 10, 57, 3.9414F, 43.2722F, 6.3563F, 2, 4, 3, 0.0F, false));
		bone196.cubeList.add(new ModelBox(bone196, 10, 57, 4.1305F, 46.1314F, 8.4049F, 2, 4, 3, 0.0F, false));

		bone197 = new ModelRenderer(this);
		bone197.setRotationPoint(-2.8328F, -11.2F, 15.881F);
		bone194.addChild(bone197);
		bone197.cubeList.add(new ModelBox(bone197, 10, 57, 3.317F, 28.6847F, 1.2669F, 2, 11, 3, 0.0F, false));
		bone197.cubeList.add(new ModelBox(bone197, 10, 57, 3.3324F, 38.6874F, 2.5016F, 2, 4, 4, 0.0F, false));
		bone197.cubeList.add(new ModelBox(bone197, 10, 57, 3.7963F, 41.4207F, 5.0144F, 2, 4, 3, 0.0F, false));
		bone197.cubeList.add(new ModelBox(bone197, 10, 57, 3.9414F, 43.2722F, 6.3563F, 2, 4, 3, 0.0F, false));
		bone197.cubeList.add(new ModelBox(bone197, 10, 57, 4.1305F, 46.1314F, 8.4049F, 2, 4, 3, 0.0F, false));

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(17.0F, -35.75F, -1.25F);
		Body.addChild(LeftArm);
		

		LeftArm3 = new ModelRenderer(this);
		LeftArm3.setRotationPoint(0.0F, 0.0F, 0.0F);
		LeftArm.addChild(LeftArm3);
		setRotationAngle(LeftArm3, -2.1817F, 0.0F, 0.6109F);
		LeftArm3.cubeList.add(new ModelBox(LeftArm3, 29, 67, -4.816F, 17.3155F, 5.215F, 4, 40, 5, 0.0F, false));

		bone188 = new ModelRenderer(this);
		bone188.setRotationPoint(-0.5798F, 35.934F, 0.0F);
		LeftArm3.addChild(bone188);
		setRotationAngle(bone188, -0.1745F, 0.0F, 0.2618F);
		bone188.cubeList.add(new ModelBox(bone188, 12, 55, 1.6355F, 15.0866F, 8.1358F, 4, 72, 5, 0.0F, false));

		bone189 = new ModelRenderer(this);
		bone189.setRotationPoint(1.7548F, 67.2209F, 0.0896F);
		bone188.addChild(bone189);
		setRotationAngle(bone189, -0.8727F, 0.0F, 0.0F);
		bone189.cubeList.add(new ModelBox(bone189, 29, 67, -2.1518F, 3.1393F, 16.5677F, 8, 3, 5, 0.0F, false));
		bone189.cubeList.add(new ModelBox(bone189, 29, 67, -2.6294F, 5.9366F, 16.2994F, 9, 3, 5, 0.0F, false));
		bone189.cubeList.add(new ModelBox(bone189, 29, 67, -4.5993F, 8.6484F, 16.016F, 13, 10, 5, 0.0F, false));
		bone189.cubeList.add(new ModelBox(bone189, 29, 67, -9.3714F, 12.0833F, 14.5636F, 3, 4, 5, 0.0F, false));
		bone189.cubeList.add(new ModelBox(bone189, 29, 67, -7.1271F, 9.473F, 14.1034F, 3, 4, 5, 0.0F, false));
		bone189.cubeList.add(new ModelBox(bone189, 29, 67, -9.9649F, 13.9802F, 15.8981F, 3, 4, 4, 0.0F, false));
		bone189.cubeList.add(new ModelBox(bone189, 29, 67, -9.9935F, 16.9753F, 16.4262F, 2, 5, 4, 0.0F, false));
		bone189.cubeList.add(new ModelBox(bone189, 29, 67, -10.4419F, 20.8974F, 17.1178F, 2, 5, 4, 0.0F, false));
		bone189.cubeList.add(new ModelBox(bone189, 29, 67, -5.3659F, 15.7653F, 17.2709F, 13, 5, 4, 0.0F, false));

		bone190 = new ModelRenderer(this);
		bone190.setRotationPoint(-12.0F, -11.0419F, 15.9088F);
		bone189.addChild(bone190);
		bone190.cubeList.add(new ModelBox(bone190, 29, 67, 7.6196F, 31.3585F, 1.403F, 2, 8, 3, 0.0F, false));
		bone190.cubeList.add(new ModelBox(bone190, 20, 150, 7.7932F, 30.5189F, 0.4933F, 1, 2, 2, 0.0F, false));
		bone190.cubeList.add(new ModelBox(bone190, 14, 145, 12.1089F, 30.5183F, 0.4932F, 1, 2, 2, 0.0F, false));
		bone190.cubeList.add(new ModelBox(bone190, 17, 158, 17.1632F, 30.646F, 0.5158F, 1, 2, 2, 0.0F, false));
		bone190.cubeList.add(new ModelBox(bone190, 29, 67, 7.635F, 38.3612F, 2.6377F, 2, 4, 4, 0.0F, false));
		bone190.cubeList.add(new ModelBox(bone190, 29, 67, 8.0989F, 41.0945F, 5.1505F, 2, 4, 3, 0.0F, false));
		bone190.cubeList.add(new ModelBox(bone190, 29, 67, 8.244F, 42.946F, 6.4924F, 2, 4, 3, 0.0F, false));
		bone190.cubeList.add(new ModelBox(bone190, 29, 67, 8.4331F, 45.8052F, 8.541F, 2, 4, 3, 0.0F, false));

		bone191 = new ModelRenderer(this);
		bone191.setRotationPoint(-8.0317F, -9.1028F, 16.2508F);
		bone189.addChild(bone191);
		bone191.cubeList.add(new ModelBox(bone191, 29, 67, 7.6196F, 28.3585F, 1.403F, 2, 11, 3, 0.0F, false));
		bone191.cubeList.add(new ModelBox(bone191, 29, 67, 7.635F, 38.3612F, 2.6377F, 2, 4, 4, 0.0F, false));
		bone191.cubeList.add(new ModelBox(bone191, 29, 67, 8.0989F, 41.0945F, 5.1505F, 2, 4, 3, 0.0F, false));
		bone191.cubeList.add(new ModelBox(bone191, 29, 67, 8.244F, 42.946F, 6.4924F, 2, 4, 3, 0.0F, false));
		bone191.cubeList.add(new ModelBox(bone191, 29, 67, 8.4331F, 45.8052F, 8.541F, 2, 4, 3, 0.0F, false));

		bone192 = new ModelRenderer(this);
		bone192.setRotationPoint(-2.8329F, -11.2F, 15.881F);
		bone189.addChild(bone192);
		bone192.cubeList.add(new ModelBox(bone192, 29, 67, 7.6196F, 28.3585F, 1.403F, 2, 11, 3, 0.0F, false));
		bone192.cubeList.add(new ModelBox(bone192, 29, 67, 7.635F, 38.3612F, 2.6377F, 2, 4, 4, 0.0F, false));
		bone192.cubeList.add(new ModelBox(bone192, 29, 67, 8.0989F, 41.0945F, 5.1505F, 2, 4, 3, 0.0F, false));
		bone192.cubeList.add(new ModelBox(bone192, 29, 67, 8.244F, 42.946F, 6.4924F, 2, 4, 3, 0.0F, false));
		bone192.cubeList.add(new ModelBox(bone192, 29, 67, 8.4331F, 45.8052F, 8.541F, 2, 4, 3, 0.0F, false));

		Head = new ModelRenderer(this);
		Head.setRotationPoint(1.375F, -55.5F, -10.0F);
		Body.addChild(Head);
		

		Head3 = new ModelRenderer(this);
		Head3.setRotationPoint(0.0F, 0.0F, 0.0F);
		Head.addChild(Head3);
		setRotationAngle(Head3, -1.1345F, 0.0F, 0.0F);
		Head3.cubeList.add(new ModelBox(Head3, 65, 34, -6.2707F, 8.8571F, -18.6596F, 9, 7, 10, 0.0F, false));
		Head3.cubeList.add(new ModelBox(Head3, 0, 0, -5.2707F, 9.4452F, -15.6237F, 7, 5, 9, 0.0F, false));
		Head3.cubeList.add(new ModelBox(Head3, 74, 40, -5.2707F, 10.6721F, -22.7813F, 7, 4, 5, 0.0F, false));
		Head3.cubeList.add(new ModelBox(Head3, 0, 0, 0.9793F, 14.5239F, -20.5774F, 0, 1, 1, 0.0F, false));
		Head3.cubeList.add(new ModelBox(Head3, 0, 0, 0.9793F, 14.4488F, -21.9216F, 0, 1, 1, 0.0F, false));
		Head3.cubeList.add(new ModelBox(Head3, 0, 0, -0.2707F, 14.3737F, -23.2658F, 0, 1, 1, 0.0F, false));
		Head3.cubeList.add(new ModelBox(Head3, 0, 0, -3.2707F, 14.3737F, -23.2658F, 0, 1, 1, 0.0F, false));
		Head3.cubeList.add(new ModelBox(Head3, 0, 0, -0.2707F, 13.9664F, -24.7309F, 0, 1, 1, 0.0F, false));
		Head3.cubeList.add(new ModelBox(Head3, 0, 0, -3.2707F, 13.9664F, -24.7309F, 0, 1, 1, 0.0F, false));
		Head3.cubeList.add(new ModelBox(Head3, 0, 0, -0.2707F, 13.7856F, -26.3017F, 0, 1, 1, 0.0F, false));
		Head3.cubeList.add(new ModelBox(Head3, 0, 0, -3.2707F, 13.7856F, -26.3017F, 0, 1, 1, 0.0F, false));
		Head3.cubeList.add(new ModelBox(Head3, 0, 0, -0.2707F, 13.7105F, -27.6459F, 0, 1, 1, 0.0F, false));
		Head3.cubeList.add(new ModelBox(Head3, 0, 0, -3.2707F, 13.7105F, -27.6459F, 0, 1, 1, 0.0F, false));
		Head3.cubeList.add(new ModelBox(Head3, 0, 0, -0.2707F, 13.6353F, -28.9901F, 0, 1, 1, 0.0F, false));
		Head3.cubeList.add(new ModelBox(Head3, 0, 0, -3.2707F, 13.6353F, -28.9901F, 0, 1, 1, 0.0F, false));
		Head3.cubeList.add(new ModelBox(Head3, 0, 0, -0.2707F, 13.3489F, -30.7874F, 0, 1, 1, 0.0F, false));
		Head3.cubeList.add(new ModelBox(Head3, 0, 0, -3.5207F, 13.3489F, -30.7874F, 0, 1, 1, 0.0F, false));
		Head3.cubeList.add(new ModelBox(Head3, 0, 0, -0.5207F, 13.1681F, -32.3582F, 0, 1, 1, 0.0F, false));
		Head3.cubeList.add(new ModelBox(Head3, 0, 0, -3.2707F, 13.1681F, -32.3582F, 0, 1, 1, 0.0F, false));
		Head3.cubeList.add(new ModelBox(Head3, 0, 0, -5.0207F, 14.5239F, -20.5774F, 0, 1, 1, 0.0F, false));
		Head3.cubeList.add(new ModelBox(Head3, 0, 0, -5.0207F, 14.4488F, -21.9216F, 0, 1, 1, 0.0F, false));
		Head3.cubeList.add(new ModelBox(Head3, 9, 17, -7.2707F, 10.9194F, -20.033F, 11, 1, 4, 0.0F, false));
		Head3.cubeList.add(new ModelBox(Head3, 62, 9, -3.7707F, 11.3085F, -29.6983F, 4, 3, 8, 0.0F, false));
		Head3.cubeList.add(new ModelBox(Head3, 0, 0, -2.7707F, 10.6288F, -29.3813F, 2, 3, 8, 0.0F, false));
		Head3.cubeList.add(new ModelBox(Head3, 0, 0, -2.7707F, 9.5099F, -25.2736F, 2, 3, 8, 0.0F, false));

		bone162 = new ModelRenderer(this);
		bone162.setRotationPoint(4.75F, -3.6079F, 3.7739F);
		Head3.addChild(bone162);
		setRotationAngle(bone162, -0.2618F, 0.0F, 0.2618F);
		bone162.cubeList.add(new ModelBox(bone162, 0, 0, 0.7033F, 13.2621F, -11.6919F, 1, 5, 2, 0.0F, false));
		bone162.cubeList.add(new ModelBox(bone162, 0, 0, 2.529F, 7.3161F, -10.6918F, 1, 5, 1, 0.0F, false));

		bone163 = new ModelRenderer(this);
		bone163.setRotationPoint(-0.6823F, -0.4723F, -0.6115F);
		bone162.addChild(bone163);
		setRotationAngle(bone163, 0.0F, 0.0F, 0.4363F);
		bone163.cubeList.add(new ModelBox(bone163, 0, 0, 7.1019F, 9.9139F, -11.0323F, 1, 2, 2, 0.0F, false));

		bone164 = new ModelRenderer(this);
		bone164.setRotationPoint(-0.8513F, -2.206F, -0.3104F);
		bone162.addChild(bone164);
		setRotationAngle(bone164, 0.0F, 0.0F, 1.1345F);
		bone164.cubeList.add(new ModelBox(bone164, 0, 0, 13.6593F, -0.5333F, -11.0323F, 1, 4, 2, 0.0F, false));

		bone165 = new ModelRenderer(this);
		bone165.setRotationPoint(3.9783F, -3.456F, -0.6453F);
		bone162.addChild(bone165);
		setRotationAngle(bone165, 0.2618F, 0.0F, 1.309F);
		bone165.cubeList.add(new ModelBox(bone165, 0, 0, 13.3114F, -5.2513F, -11.1335F, 1, 5, 2, 0.0F, false));

		bone166 = new ModelRenderer(this);
		bone166.setRotationPoint(7.5772F, -4.2746F, -1.6777F);
		bone162.addChild(bone166);
		setRotationAngle(bone166, 0.7854F, -0.0873F, 1.3963F);
		bone166.cubeList.add(new ModelBox(bone166, 0, 0, 12.4415F, -12.5131F, -9.2791F, 1, 5, 2, 0.0F, false));

		bone182 = new ModelRenderer(this);
		bone182.setRotationPoint(-5.0F, 23.0F, -5.0F);
		bone166.addChild(bone182);
		setRotationAngle(bone182, 0.0F, -0.1745F, 0.0F);
		bone182.cubeList.add(new ModelBox(bone182, 0, 0, 13.3772F, -36.0595F, -7.4791F, 4, 2, 2, 0.0F, false));
		bone182.cubeList.add(new ModelBox(bone182, 0, 0, 7.5909F, -35.6173F, -6.8604F, 6, 1, 1, 0.0F, false));

		bone167 = new ModelRenderer(this);
		bone167.setRotationPoint(10.6775F, -4.5314F, -4.5298F);
		bone162.addChild(bone167);
		setRotationAngle(bone167, 1.2217F, -0.2618F, 1.3963F);
		bone167.cubeList.add(new ModelBox(bone167, 0, 0, 10.1247F, -17.8124F, -5.8584F, 1, 5, 2, 0.0F, false));

		bone168 = new ModelRenderer(this);
		bone168.setRotationPoint(11.9399F, -3.6919F, -8.1199F);
		bone162.addChild(bone168);
		setRotationAngle(bone168, 1.6581F, -0.2618F, 1.3963F);
		bone168.cubeList.add(new ModelBox(bone168, 0, 0, 10.1247F, -18.9573F, 0.2879F, 1, 5, 2, 0.0F, false));

		bone184 = new ModelRenderer(this);
		bone184.setRotationPoint(-2.1813F, 21.6806F, -5.9364F);
		bone168.addChild(bone184);
		setRotationAngle(bone184, 0.0F, -0.4363F, 0.0F);
		bone184.cubeList.add(new ModelBox(bone184, 0, 0, 9.0776F, -41.4403F, -0.3325F, 5, 2, 2, 0.0F, false));
		bone184.cubeList.add(new ModelBox(bone184, 0, 0, 5.1695F, -40.9894F, 0.2824F, 5, 1, 1, 0.0F, false));

		bone169 = new ModelRenderer(this);
		bone169.setRotationPoint(11.6988F, -2.5572F, -12.1001F);
		bone162.addChild(bone169);
		setRotationAngle(bone169, 2.1817F, -0.2618F, 1.3963F);
		bone169.cubeList.add(new ModelBox(bone169, 0, 0, 10.1247F, -16.778F, 7.4383F, 1, 5, 2, 0.0F, false));

		bone170 = new ModelRenderer(this);
		bone170.setRotationPoint(9.732F, -1.3427F, -15.1364F);
		bone162.addChild(bone170);
		setRotationAngle(bone170, 2.7925F, -0.2618F, 1.3963F);
		bone170.cubeList.add(new ModelBox(bone170, 0, 0, 10.1247F, -10.1798F, 13.084F, 1, 5, 2, 0.0F, false));

		bone186 = new ModelRenderer(this);
		bone186.setRotationPoint(-9.5837F, 22.9057F, -5.8908F);
		bone170.addChild(bone186);
		setRotationAngle(bone186, 0.0F, -0.1745F, 0.1745F);
		bone186.cubeList.add(new ModelBox(bone186, 0, 0, 12.6698F, -35.613F, 16.7699F, 4, 1, 1, 0.0F, false));

		bone171 = new ModelRenderer(this);
		bone171.setRotationPoint(5.8215F, -0.1048F, -16.4309F);
		bone162.addChild(bone171);
		setRotationAngle(bone171, 3.0543F, -0.2618F, 1.3963F);
		bone171.cubeList.add(new ModelBox(bone171, 0, 0, 10.1247F, -6.548F, 14.0949F, 1, 5, 2, 0.0F, false));
		bone171.cubeList.add(new ModelBox(bone171, 0, 0, 10.6329F, -8.8426F, 14.6592F, 0, 3, 1, 0.0F, false));

		bone172 = new ModelRenderer(this);
		bone172.setRotationPoint(-4.75F, -4.0458F, 3.4264F);
		Head3.addChild(bone172);
		setRotationAngle(bone172, -0.2618F, 0.0F, -0.2618F);
		bone172.cubeList.add(new ModelBox(bone172, 0, 0, -5.6581F, 12.6268F, -11.8621F, 1, 5, 2, 0.0F, false));
		bone172.cubeList.add(new ModelBox(bone172, 0, 0, -7.2335F, 6.8632F, -11.0161F, 1, 5, 1, 0.0F, false));

		bone173 = new ModelRenderer(this);
		bone173.setRotationPoint(0.7011F, -0.876F, -0.3915F);
		bone172.addChild(bone173);
		setRotationAngle(bone173, 0.0F, 0.0F, -0.4363F);
		bone173.cubeList.add(new ModelBox(bone173, 0, 0, -11.6954F, 8.1421F, -11.2193F, 1, 2, 2, 0.0F, false));

		bone174 = new ModelRenderer(this);
		bone174.setRotationPoint(0.221F, -3.2921F, -0.5236F);
		bone172.addChild(bone174);
		setRotationAngle(bone174, 0.0F, 0.0F, -1.1345F);
		bone174.cubeList.add(new ModelBox(bone174, 0, 0, -16.5201F, -2.7813F, -11.1858F, 1, 4, 2, 0.0F, false));

		bone175 = new ModelRenderer(this);
		bone175.setRotationPoint(-4.0835F, -6.2573F, -0.8332F);
		bone172.addChild(bone175);
		setRotationAngle(bone175, 0.2618F, 0.0F, -1.309F);
		bone175.cubeList.add(new ModelBox(bone175, 0, 0, -17.6826F, -7.7445F, -10.6417F, 1, 5, 2, 0.0F, false));

		bone176 = new ModelRenderer(this);
		bone176.setRotationPoint(-7.9215F, -7.3361F, -1.8879F);
		bone172.addChild(bone176);
		setRotationAngle(bone176, 0.7854F, 0.0873F, -1.3963F);
		bone176.cubeList.add(new ModelBox(bone176, 0, 0, -16.5775F, -14.4081F, -7.5993F, 1, 5, 2, 0.0F, false));

		bone183 = new ModelRenderer(this);
		bone183.setRotationPoint(1.0477F, -0.6037F, -0.8142F);
		bone176.addChild(bone183);
		setRotationAngle(bone183, 0.0F, 0.1745F, 0.0F);
		bone183.cubeList.add(new ModelBox(bone183, 0, 0, -15.1434F, -14.607F, -10.3061F, 4, 2, 2, 0.0F, false));
		bone183.cubeList.add(new ModelBox(bone183, 0, 0, -11.7531F, -14.2794F, -9.7614F, 6, 1, 1, 0.0F, false));

		bone177 = new ModelRenderer(this);
		bone177.setRotationPoint(14.6842F, -2.4506F, -2.8929F);
		bone172.addChild(bone177);
		setRotationAngle(bone177, 1.2217F, 0.2618F, -1.3963F);
		bone177.cubeList.add(new ModelBox(bone177, 0, 0, -13.38F, -29.5079F, 20.1729F, 1, 5, 2, 0.0F, false));

		bone178 = new ModelRenderer(this);
		bone178.setRotationPoint(-11.9381F, -7.1447F, -9.2006F);
		bone172.addChild(bone178);
		setRotationAngle(bone178, 1.6581F, 0.2618F, -1.3963F);
		bone178.cubeList.add(new ModelBox(bone178, 0, 0, -15.1019F, -18.7025F, 3.1418F, 1, 5, 2, 0.0F, false));

		bone185 = new ModelRenderer(this);
		bone185.setRotationPoint(-0.5435F, -0.2535F, -0.9436F);
		bone178.addChild(bone185);
		setRotationAngle(bone185, 0.0F, 0.4363F, 0.0F);
		bone185.cubeList.add(new ModelBox(bone185, 0, 0, -10.8705F, -17.8128F, -1.7426F, 5, 1, 1, 0.0F, false));
		bone185.cubeList.add(new ModelBox(bone185, 0, 0, -14.385F, -18.4279F, -2.4095F, 5, 2, 2, 0.0F, false));

		bone179 = new ModelRenderer(this);
		bone179.setRotationPoint(-12.4138F, -5.055F, -13.3624F);
		bone172.addChild(bone179);
		setRotationAngle(bone179, 2.1817F, 0.2618F, -1.3963F);
		bone179.cubeList.add(new ModelBox(bone179, 0, 0, -14.2244F, -14.9495F, 9.2726F, 1, 5, 2, 0.0F, false));

		bone180 = new ModelRenderer(this);
		bone180.setRotationPoint(-10.2237F, -4.0342F, -15.9038F);
		bone172.addChild(bone180);
		setRotationAngle(bone180, 2.7925F, 0.2618F, -1.3963F);
		bone180.cubeList.add(new ModelBox(bone180, 0, 0, -14.2375F, -7.8431F, 14.0546F, 1, 5, 2, 0.0F, false));

		bone187 = new ModelRenderer(this);
		bone187.setRotationPoint(-1.2165F, 24.7883F, -3.6821F);
		bone180.addChild(bone187);
		setRotationAngle(bone187, 0.0F, 0.1745F, -0.1745F);
		bone187.cubeList.add(new ModelBox(bone187, 0, 0, -9.6356F, -33.5782F, 17.3216F, 4, 1, 1, 0.0F, false));

		bone181 = new ModelRenderer(this);
		bone181.setRotationPoint(-6.1284F, -2.6898F, -17.3423F);
		bone172.addChild(bone181);
		setRotationAngle(bone181, 3.0543F, 0.2618F, -1.3963F);
		bone181.cubeList.add(new ModelBox(bone181, 0, 0, -14.2375F, -4.0397F, 14.4276F, 1, 5, 2, 0.0F, false));
		bone181.cubeList.add(new ModelBox(bone181, 0, 0, -13.7293F, -6.3343F, 14.9919F, 0, 3, 1, 0.0F, false));

		bone161 = new ModelRenderer(this);
		bone161.setRotationPoint(7.0F, -1.0F, -3.25F);
		Head3.addChild(bone161);
		bone161.cubeList.add(new ModelBox(bone161, 0, 0, -5.2707F, 11.1406F, -17.4182F, 2, 0, 6, 0.0F, false));
		bone161.cubeList.add(new ModelBox(bone161, 0, 0, -14.5207F, 11.1406F, -17.4182F, 2, 0, 6, 0.0F, false));
		bone161.cubeList.add(new ModelBox(bone161, 0, 0, -5.2707F, 11.4402F, -17.9551F, 2, 2, 1, 0.0F, false));
		bone161.cubeList.add(new ModelBox(bone161, 0, 0, -14.5207F, 11.4402F, -17.9551F, 2, 2, 1, 0.0F, false));
		bone161.cubeList.add(new ModelBox(bone161, 0, 0, -5.2707F, 11.3932F, -12.1405F, 2, 2, 1, 0.0F, false));
		bone161.cubeList.add(new ModelBox(bone161, 0, 0, -14.5207F, 11.3932F, -12.1405F, 2, 2, 1, 0.0F, false));
		bone161.cubeList.add(new ModelBox(bone161, 0, 0, -5.5207F, 11.9086F, -18.7252F, 2, 1, 1, 0.0F, false));
		bone161.cubeList.add(new ModelBox(bone161, 0, 0, -14.0207F, 11.9086F, -18.7252F, 2, 1, 1, 0.0F, false));
		bone161.cubeList.add(new ModelBox(bone161, 0, 0, -5.5207F, 11.7101F, -11.4607F, 2, 1, 1, 0.0F, false));
		bone161.cubeList.add(new ModelBox(bone161, 0, 0, -14.5207F, 11.7101F, -11.4607F, 2, 1, 1, 0.0F, false));
		bone161.cubeList.add(new ModelBox(bone161, 0, 0, -6.0207F, 11.9239F, -19.284F, 2, 1, 1, 0.0F, false));
		bone161.cubeList.add(new ModelBox(bone161, 0, 0, -13.5207F, 11.9239F, -19.284F, 2, 1, 1, 0.0F, false));
		bone161.cubeList.add(new ModelBox(bone161, 0, 0, -5.7707F, 11.8005F, -10.6753F, 2, 1, 1, 0.0F, false));
		bone161.cubeList.add(new ModelBox(bone161, 0, 0, -14.2707F, 11.8005F, -10.6753F, 2, 1, 1, 0.0F, false));
		bone161.cubeList.add(new ModelBox(bone161, 0, 0, -5.2707F, 13.9194F, -17.783F, 2, 0, 6, 0.0F, false));
		bone161.cubeList.add(new ModelBox(bone161, 0, 0, -14.5207F, 13.9194F, -17.783F, 2, 0, 6, 0.0F, false));

		bone158 = new ModelRenderer(this);
		bone158.setRotationPoint(0.0F, 15.6191F, -10.5005F);
		Head3.addChild(bone158);
		setRotationAngle(bone158, 0.1745F, 0.0F, 0.0F);
		bone158.cubeList.add(new ModelBox(bone158, 0, 0, -2.0207F, -7.0214F, -21.4349F, 1, 2, 3, 0.0F, false));
		bone158.cubeList.add(new ModelBox(bone158, 0, 0, -3.3019F, -6.6122F, -22.7733F, 3, 1, 2, 0.0F, false));
		bone158.cubeList.add(new ModelBox(bone158, 114, 11, -3.0207F, -7.325F, -19.3121F, 3, 2, 2, 0.0F, false));

		bone159 = new ModelRenderer(this);
		bone159.setRotationPoint(2.25F, 15.6191F, -10.5005F);
		Head3.addChild(bone159);
		setRotationAngle(bone159, 0.1745F, 0.1745F, 0.0F);
		bone159.cubeList.add(new ModelBox(bone159, 142, 40, 1.4036F, -7.0098F, -22.3696F, 0, 2, 4, 0.0F, false));

		bone160 = new ModelRenderer(this);
		bone160.setRotationPoint(0.0F, 15.5885F, -9.3828F);
		Head3.addChild(bone160);
		setRotationAngle(bone160, 0.1745F, -0.1745F, 0.0F);
		bone160.cubeList.add(new ModelBox(bone160, 123, 24, -7.2376F, -7.0275F, -22.4695F, 0, 2, 4, 0.0F, false));

		middlebody = new ModelRenderer(this);
		middlebody.setRotationPoint(0.0F, 0.0F, 0.0F);
		UpperBody2.addChild(middlebody);
		middlebody.cubeList.add(new ModelBox(middlebody, 4, 140, -3.5F, -4.0905F, -18.3224F, 6, 3, 2, 0.0F, false));

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, -9.0F, 0.0F);
		middlebody.addChild(bone);
		setRotationAngle(bone, -0.0873F, 0.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 4, 140, -2.5F, 3.4883F, -17.8246F, 4, 3, 2, 0.0F, false));

		bone17 = new ModelRenderer(this);
		bone17.setRotationPoint(0.0F, -3.5F, 0.25F);
		middlebody.addChild(bone17);
		setRotationAngle(bone17, 0.0873F, 0.0F, 0.0F);
		bone17.cubeList.add(new ModelBox(bone17, 4, 140, -2.5F, 0.2933F, -18.6807F, 4, 3, 2, 0.0F, false));

		bone18 = new ModelRenderer(this);
		bone18.setRotationPoint(0.0F, -0.75F, 1.0F);
		middlebody.addChild(bone18);
		setRotationAngle(bone18, 0.2618F, 0.0F, 0.0F);
		bone18.cubeList.add(new ModelBox(bone18, 4, 140, -2.0F, -3.0F, -18.9687F, 3, 3, 2, 0.0F, false));

		bone19 = new ModelRenderer(this);
		bone19.setRotationPoint(0.0F, 2.25F, 1.75F);
		middlebody.addChild(bone19);
		setRotationAngle(bone19, 0.2618F, 0.0F, 0.0F);
		bone19.cubeList.add(new ModelBox(bone19, 4, 140, -2.0F, -3.0F, -18.9687F, 3, 3, 2, 0.0F, false));

		bone23 = new ModelRenderer(this);
		bone23.setRotationPoint(0.0F, -1.75F, -3.25F);
		middlebody.addChild(bone23);
		bone23.cubeList.add(new ModelBox(bone23, 12, 105, -8.75F, 1.9095F, -16.8224F, 16, 7, 2, 0.0F, false));
		bone23.cubeList.add(new ModelBox(bone23, 7, 106, -8.75F, 3.9095F, -19.8224F, 16, 9, 3, 0.0F, false));
		bone23.cubeList.add(new ModelBox(bone23, 12, 116, 6.25F, 0.6595F, -15.5724F, 4, 5, 2, 0.0F, false));
		bone23.cubeList.add(new ModelBox(bone23, 7, 118, -11.75F, 0.6595F, -15.5724F, 4, 5, 2, 0.0F, false));
		bone23.cubeList.add(new ModelBox(bone23, 11, 112, 8.5F, 3.9095F, -15.5724F, 4, 5, 2, 0.0F, false));
		bone23.cubeList.add(new ModelBox(bone23, 6, 111, -13.75F, 3.9095F, -15.5724F, 4, 5, 2, 0.0F, false));
		bone23.cubeList.add(new ModelBox(bone23, 10, 103, -10.0F, 1.9095F, -15.5724F, 19, 7, 2, 0.0F, false));

		bone20 = new ModelRenderer(this);
		bone20.setRotationPoint(0.0F, 5.25F, 2.75F);
		middlebody.addChild(bone20);
		setRotationAngle(bone20, 0.3491F, 0.0F, 0.0F);
		bone20.cubeList.add(new ModelBox(bone20, 4, 140, -2.0F, -4.6539F, -18.8965F, 3, 3, 2, 0.0F, false));

		bone21 = new ModelRenderer(this);
		bone21.setRotationPoint(0.0F, 7.75F, 4.25F);
		middlebody.addChild(bone21);
		setRotationAngle(bone21, 0.4363F, 0.0F, 0.0F);
		bone21.cubeList.add(new ModelBox(bone21, 4, 140, -1.5F, -6.3788F, -18.9156F, 2, 3, 2, 0.0F, false));

		bone22 = new ModelRenderer(this);
		bone22.setRotationPoint(0.0F, 9.75F, 4.75F);
		middlebody.addChild(bone22);
		setRotationAngle(bone22, 0.4363F, 0.0F, 0.0F);
		bone22.cubeList.add(new ModelBox(bone22, 4, 140, -1.5F, -6.3788F, -17.9156F, 2, 3, 1, 0.0F, false));

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, -12.0F, 0.25F);
		middlebody.addChild(bone2);
		setRotationAngle(bone2, -0.2618F, 0.0F, 0.0F);
		bone2.cubeList.add(new ModelBox(bone2, 4, 140, -2.0F, 6.4844F, -16.4274F, 3, 3, 2, 0.0F, false));

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, -14.5F, 1.0F);
		middlebody.addChild(bone3);
		setRotationAngle(bone3, -0.3491F, 0.0F, 0.0F);
		bone3.cubeList.add(new ModelBox(bone3, 4, 140, -2.5F, 7.8806F, -15.5379F, 4, 3, 2, 0.0F, false));

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(0.0F, -17.25F, 2.0F);
		middlebody.addChild(bone4);
		setRotationAngle(bone4, -0.4363F, 0.0F, 0.0F);
		bone4.cubeList.add(new ModelBox(bone4, 4, 140, -2.0F, 9.1924F, -14.5313F, 3, 3, 2, 0.0F, false));
		bone4.cubeList.add(new ModelBox(bone4, 4, 140, -2.0F, 6.3984F, -14.455F, 3, 3, 2, 0.0F, false));

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(0.0F, -22.25F, 4.5F);
		middlebody.addChild(bone5);
		setRotationAngle(bone5, -0.5236F, 0.0F, 0.0F);
		bone5.cubeList.add(new ModelBox(bone5, 4, 140, -2.0F, 10.4129F, -13.4129F, 3, 3, 2, 0.0F, false));

		LowerBody = new ModelRenderer(this);
		LowerBody.setRotationPoint(0.0F, -127.0F, 18.0F);
		Hollow.addChild(LowerBody);
		setRotationAngle(LowerBody, 0.4363F, 0.0F, 0.0F);
		

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(9.0F, 2.5F, -4.75F);
		LowerBody.addChild(LeftLeg);
		

		LeftLeg3 = new ModelRenderer(this);
		LeftLeg3.setRotationPoint(0.0F, 0.0F, 0.0F);
		LeftLeg.addChild(LeftLeg3);
		setRotationAngle(LeftLeg3, -0.6109F, 0.0F, -0.1745F);
		LeftLeg3.cubeList.add(new ModelBox(LeftLeg3, 4, 58, -7.2347F, 14.7636F, 1.7634F, 5, 50, 10, 0.0F, false));
		LeftLeg3.cubeList.add(new ModelBox(LeftLeg3, 4, 58, -7.2347F, 18.0213F, 0.7523F, 3, 5, 2, 0.0F, false));
		LeftLeg3.cubeList.add(new ModelBox(LeftLeg3, 4, 58, -11.4847F, 14.7636F, 1.7634F, 11, 23, 10, 0.0F, false));
		LeftLeg3.cubeList.add(new ModelBox(LeftLeg3, 4, 58, -9.7347F, 30.7795F, 1.9909F, 9, 25, 10, 0.0F, false));
		LeftLeg3.cubeList.add(new ModelBox(LeftLeg3, 4, 58, -8.4847F, 53.4258F, 3.6275F, 8, 14, 12, 0.0F, false));
		LeftLeg3.cubeList.add(new ModelBox(LeftLeg3, 3, 142, -8.9847F, 64.8529F, 13.9016F, 9, 3, 2, 0.0F, false));
		LeftLeg3.cubeList.add(new ModelBox(LeftLeg3, 13, 149, -7.7347F, 65.4067F, 7.8804F, 2, 3, 2, 0.0F, false));
		LeftLeg3.cubeList.add(new ModelBox(LeftLeg3, 24, 139, -4.4847F, 65.3659F, 6.631F, 2, 3, 2, 0.0F, false));

		bone198 = new ModelRenderer(this);
		bone198.setRotationPoint(-1.75F, 42.75F, -1.4142F);
		LeftLeg3.addChild(bone198);
		setRotationAngle(bone198, -0.7854F, 0.0F, 0.0F);
		bone198.cubeList.add(new ModelBox(bone198, 4, 58, -5.4847F, -42.8689F, 13.9002F, 5, 50, 11, 0.0F, false));
		bone198.cubeList.add(new ModelBox(bone198, 4, 58, -6.4847F, -46.1707F, 12.4515F, 8, 11, 11, 0.0F, false));

		bone199 = new ModelRenderer(this);
		bone199.setRotationPoint(-1.75F, 64.6787F, 43.5442F);
		LeftLeg3.addChild(bone199);
		setRotationAngle(bone199, 0.1745F, 0.0F, 0.0F);
		bone199.cubeList.add(new ModelBox(bone199, 182, 49, -5.4847F, -34.9709F, -1.4905F, 5, 74, 10, 0.0F, false));

		bone200 = new ModelRenderer(this);
		bone200.setRotationPoint(-3.4734F, 86.7992F, 11.423F);
		LeftLeg3.addChild(bone200);
		setRotationAngle(bone200, 0.6981F, 0.0F, 0.1745F);
		bone200.cubeList.add(new ModelBox(bone200, 7, 150, -3.7333F, 35.2777F, 16.0301F, 10, 8, 10, 0.0F, false));

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-6.25F, 3.75F, -4.75F);
		LowerBody.addChild(RightLeg);
		

		RightLeg3 = new ModelRenderer(this);
		RightLeg3.setRotationPoint(0.0F, 0.0F, 0.0F);
		RightLeg.addChild(RightLeg3);
		setRotationAngle(RightLeg3, -0.6109F, 0.0F, 0.1745F);
		RightLeg3.cubeList.add(new ModelBox(RightLeg3, 92, 64, -1.2653F, 14.7636F, 1.7634F, 5, 50, 10, 0.0F, false));
		RightLeg3.cubeList.add(new ModelBox(RightLeg3, 92, 64, 0.2119F, 17.8079F, 0.6029F, 3, 5, 2, 0.0F, false));
		RightLeg3.cubeList.add(new ModelBox(RightLeg3, 92, 64, -3.5457F, 14.4791F, 1.5642F, 11, 23, 10, 0.0F, false));
		RightLeg3.cubeList.add(new ModelBox(RightLeg3, 92, 64, -3.0267F, 30.6728F, 1.9162F, 9, 25, 10, 0.0F, false));
		RightLeg3.cubeList.add(new ModelBox(RightLeg3, 92, 64, -3.0077F, 53.4969F, 3.6773F, 8, 14, 12, 0.0F, false));
		RightLeg3.cubeList.add(new ModelBox(RightLeg3, 7, 145, -3.2615F, 64.8885F, 13.9265F, 9, 3, 2, 0.0F, false));
		RightLeg3.cubeList.add(new ModelBox(RightLeg3, 40, 159, -1.9389F, 65.6038F, 5.882F, 2, 3, 2, 0.0F, false));
		RightLeg3.cubeList.add(new ModelBox(RightLeg3, 56, 155, 1.7886F, 65.4871F, 9.4626F, 2, 3, 2, 0.0F, false));

		bone201 = new ModelRenderer(this);
		bone201.setRotationPoint(-1.75F, 42.75F, -1.4142F);
		RightLeg3.addChild(bone201);
		setRotationAngle(bone201, -0.7854F, 0.0F, 0.0F);
		bone201.cubeList.add(new ModelBox(bone201, 92, 64, 0.4847F, -42.8689F, 13.9002F, 5, 50, 11, 0.0F, false));
		bone201.cubeList.add(new ModelBox(bone201, 92, 64, -1.0077F, -46.1556F, 12.537F, 8, 11, 11, 0.0F, false));

		bone202 = new ModelRenderer(this);
		bone202.setRotationPoint(-1.75F, 64.6787F, 43.5442F);
		RightLeg3.addChild(bone202);
		setRotationAngle(bone202, 0.1745F, 0.0F, 0.0F);
		bone202.cubeList.add(new ModelBox(bone202, 185, 49, 0.4847F, -34.9709F, -1.4905F, 5, 74, 10, 0.0F, false));

		bone203 = new ModelRenderer(this);
		bone203.setRotationPoint(-1.75F, 87.0481F, 11.5973F);
		RightLeg3.addChild(bone203);
		setRotationAngle(bone203, 0.6981F, 0.0F, -0.1745F);
		bone203.cubeList.add(new ModelBox(bone203, 10, 142, -4.2667F, 35.2777F, 16.0301F, 10, 8, 10, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		Hollow.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setLivingAnimations(EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4) {
		this.RightArm.rotateAngleX = MathHelper.cos(par2 * 0.6662f) * 0.5f * par3;
		this.LeftArm.rotateAngleX = MathHelper.cos(par2 * 0.6662f + 3.1415927f) * 0.5f * par3;
		this.RightLeg.rotateAngleX = MathHelper.cos(par2 * 0.6662f) * 0.5f * par3;
		this.LeftLeg.rotateAngleX = MathHelper.cos(par2 * 0.6662f + 3.1415927f) * 0.5f * par3;
	}

	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
		super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
		this.Head.rotateAngleX = par5 / 57.295776f;
	}
}