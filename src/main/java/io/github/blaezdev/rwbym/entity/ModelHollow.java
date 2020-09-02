// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

/*
public class ModelHollow extends EntityModel<Entity> {
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
		bone151.setTextureOffset(4, 123).addBox(25.3028F, -3.6741F, 0.371F, 27.0F, 4.0F, 1.0F, 0.0F, false);

		bone132 = new ModelRenderer(this);
		bone132.setRotationPoint(0.5F, -10.0F, 11.5F);
		upperbody.addChild(bone132);
		setRotationAngle(bone132, 0.0F, 0.0F, -1.2217F);
		bone132.setTextureOffset(1, 108).addBox(1.3028F, -3.6741F, 0.371F, 48.0F, 4.0F, 1.0F, 0.0F, false);

		bone141 = new ModelRenderer(this);
		bone141.setRotationPoint(3.5F, 11.5F, 11.5F);
		upperbody.addChild(bone141);
		bone141.setTextureOffset(13, 109).addBox(-7.2766F, -31.7405F, 0.6016F, 7.0F, 4.0F, 1.0F, 0.0F, false);

		bone140 = new ModelRenderer(this);
		bone140.setRotationPoint(3.5F, 7.5F, 11.5F);
		upperbody.addChild(bone140);
		bone140.setTextureOffset(26, 95).addBox(-9.2766F, -31.7405F, 0.6016F, 10.0F, 4.0F, 1.0F, 0.0F, false);

		bone139 = new ModelRenderer(this);
		bone139.setRotationPoint(3.5F, 3.5F, 11.5F);
		upperbody.addChild(bone139);
		bone139.setTextureOffset(10, 116).addBox(-8.2766F, -31.7405F, 0.6016F, 10.0F, 4.0F, 1.0F, 0.0F, false);

		bone138 = new ModelRenderer(this);
		bone138.setRotationPoint(3.5F, -0.5F, 11.5F);
		upperbody.addChild(bone138);
		bone138.setTextureOffset(17, 95).addBox(-10.2766F, -31.7405F, 0.6016F, 13.0F, 4.0F, 1.0F, 0.0F, false);

		bone137 = new ModelRenderer(this);
		bone137.setRotationPoint(3.5F, -4.5F, 11.5F);
		upperbody.addChild(bone137);
		bone137.setTextureOffset(17, 107).addBox(-11.2766F, -31.7405F, 0.6016F, 16.0F, 4.0F, 1.0F, 0.0F, false);

		bone136 = new ModelRenderer(this);
		bone136.setRotationPoint(3.5F, -8.5F, 11.5F);
		upperbody.addChild(bone136);
		bone136.setTextureOffset(10, 109).addBox(-14.2766F, -31.7405F, 0.6016F, 20.0F, 4.0F, 1.0F, 0.0F, false);

		bone135 = new ModelRenderer(this);
		bone135.setRotationPoint(3.5F, -12.5F, 11.5F);
		upperbody.addChild(bone135);
		bone135.setTextureOffset(2, 108).addBox(-15.2766F, -31.7405F, 0.6016F, 22.0F, 4.0F, 1.0F, 0.0F, false);

		bone134 = new ModelRenderer(this);
		bone134.setRotationPoint(3.5F, -16.5F, 11.5F);
		upperbody.addChild(bone134);
		bone134.setTextureOffset(4, 120).addBox(-17.2766F, -31.7405F, 0.6016F, 26.0F, 4.0F, 1.0F, 0.0F, false);

		bone145 = new ModelRenderer(this);
		bone145.setRotationPoint(-20.0F, -27.5F, -3.25F);
		upperbody.addChild(bone145);
		bone145.setTextureOffset(7, 112).addBox(0.7234F, -31.9905F, 12.8516F, 4.0F, 4.0F, 3.0F, 0.0F, false);
		bone145.setTextureOffset(5, 116).addBox(33.9734F, -31.9905F, 12.8516F, 4.0F, 4.0F, 3.0F, 0.0F, false);
		bone145.setTextureOffset(10, 121).addBox(33.9734F, -31.9905F, -2.1484F, 4.0F, 4.0F, 3.0F, 0.0F, false);
		bone145.setTextureOffset(9, 120).addBox(0.9734F, -31.9905F, -2.1484F, 4.0F, 4.0F, 3.0F, 0.0F, false);

		bone146 = new ModelRenderer(this);
		bone146.setRotationPoint(15.0F, -27.5F, -6.25F);
		upperbody.addChild(bone146);
		bone146.setTextureOffset(9, 109).addBox(-1.2766F, -32.7405F, 3.8516F, 6.0F, 4.0F, 12.0F, 0.0F, false);

		bone144 = new ModelRenderer(this);
		bone144.setRotationPoint(-20.0F, -27.5F, -6.25F);
		upperbody.addChild(bone144);
		bone144.setTextureOffset(3, 106).addBox(-1.2766F, -32.7405F, 3.8516F, 6.0F, 4.0F, 12.0F, 0.0F, false);

		bone148 = new ModelRenderer(this);
		bone148.setRotationPoint(13.25F, -28.5F, -6.25F);
		upperbody.addChild(bone148);
		setRotationAngle(bone148, 0.0F, 0.0F, 0.1745F);
		bone148.setTextureOffset(12, 94).addBox(-19.2766F, -31.7405F, 2.6016F, 15.0F, 4.0F, 15.0F, 0.0F, false);

		bone147 = new ModelRenderer(this);
		bone147.setRotationPoint(9.0F, -32.5F, -6.25F);
		upperbody.addChild(bone147);
		setRotationAngle(bone147, 0.0F, 0.0F, -0.1745F);
		bone147.setTextureOffset(2, 101).addBox(-19.2766F, -31.7405F, 2.6016F, 15.0F, 4.0F, 15.0F, 0.0F, false);

		bone149 = new ModelRenderer(this);
		bone149.setRotationPoint(3.5F, -27.5F, -6.25F);
		upperbody.addChild(bone149);
		bone149.setTextureOffset(5, 109).addBox(-19.2766F, -31.7405F, 1.6016F, 30.0F, 4.0F, 17.0F, 0.0F, false);

		bone142 = new ModelRenderer(this);
		bone142.setRotationPoint(3.5F, -27.5F, -6.25F);
		upperbody.addChild(bone142);
		bone142.setTextureOffset(4, 100).addBox(-19.2766F, -31.7405F, 1.6016F, 30.0F, 4.0F, 17.0F, 0.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(0.0F, -24.75F, 6.0F);
		upperbody.addChild(bone6);
		setRotationAngle(bone6, -0.6109F, 0.0F, 0.0F);
		bone6.setTextureOffset(4, 140).addBox(-2.0F, -3.0F, 0.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		bone29 = new ModelRenderer(this);
		bone29.setRotationPoint(2.0F, -24.25F, 7.0F);
		upperbody.addChild(bone29);
		setRotationAngle(bone29, 0.0F, 0.2618F, 0.0873F);
		bone29.setTextureOffset(4, 140).addBox(-2.0F, -3.0F, 0.0F, 7.0F, 3.0F, 2.0F, 0.0F, false);

		bone53 = new ModelRenderer(this);
		bone53.setRotationPoint(2.0F, -30.5F, 9.0F);
		upperbody.addChild(bone53);
		setRotationAngle(bone53, 0.0F, 0.2618F, 0.0873F);
		bone53.setTextureOffset(4, 140).addBox(-2.0F, -3.0F, 0.0F, 7.0F, 3.0F, 2.0F, 0.0F, false);

		bone71 = new ModelRenderer(this);
		bone71.setRotationPoint(2.0F, -35.75F, 10.0F);
		upperbody.addChild(bone71);
		setRotationAngle(bone71, 0.0F, 0.2618F, 0.0F);
		bone71.setTextureOffset(4, 140).addBox(-2.0F, -3.0F, 0.0F, 8.0F, 3.0F, 2.0F, 0.0F, false);

		bone87 = new ModelRenderer(this);
		bone87.setRotationPoint(2.0F, -42.75F, 10.0F);
		upperbody.addChild(bone87);
		setRotationAngle(bone87, 0.0F, 0.2618F, 0.0F);
		bone87.setTextureOffset(4, 140).addBox(-1.8706F, -3.0F, -0.483F, 9.0F, 3.0F, 2.0F, 0.0F, false);

		bone94 = new ModelRenderer(this);
		bone94.setRotationPoint(-8.0F, -42.75F, 8.75F);
		upperbody.addChild(bone94);
		setRotationAngle(bone94, 0.0F, -0.2618F, 0.0F);
		bone94.setTextureOffset(4, 140).addBox(-1.8706F, -3.0F, -0.483F, 9.0F, 3.0F, 2.0F, 0.0F, false);

		bone79 = new ModelRenderer(this);
		bone79.setRotationPoint(-7.0F, -35.75F, 8.75F);
		upperbody.addChild(bone79);
		setRotationAngle(bone79, 0.0F, -0.2618F, 0.0F);
		bone79.setTextureOffset(4, 140).addBox(-2.0F, -3.0F, 0.0F, 8.0F, 3.0F, 2.0F, 0.0F, false);

		bone102 = new ModelRenderer(this);
		bone102.setRotationPoint(-7.0F, -47.75F, 6.25F);
		upperbody.addChild(bone102);
		setRotationAngle(bone102, 0.0F, -0.2618F, 0.0F);
		bone102.setTextureOffset(4, 140).addBox(-1.9353F, -3.0F, 0.2415F, 8.0F, 3.0F, 2.0F, 0.0F, false);

		bone117 = new ModelRenderer(this);
		bone117.setRotationPoint(-7.0F, -52.75F, 4.0F);
		upperbody.addChild(bone117);
		setRotationAngle(bone117, 0.0F, -0.2618F, 0.0F);
		bone117.setTextureOffset(4, 140).addBox(-1.9353F, -3.0F, 0.2415F, 9.0F, 3.0F, 2.0F, 0.0F, false);

		bone123 = new ModelRenderer(this);
		bone123.setRotationPoint(2.25F, -52.75F, 5.25F);
		upperbody.addChild(bone123);
		setRotationAngle(bone123, 0.0F, 0.2618F, 0.0F);
		bone123.setTextureOffset(4, 140).addBox(-2.9353F, -3.0F, 0.2415F, 9.0F, 3.0F, 2.0F, 0.0F, false);

		bone109 = new ModelRenderer(this);
		bone109.setRotationPoint(2.0F, -47.75F, 7.5F);
		upperbody.addChild(bone109);
		setRotationAngle(bone109, 0.0F, 0.2618F, 0.0F);
		bone109.setTextureOffset(4, 140).addBox(-1.9353F, -3.0F, 0.2415F, 8.0F, 3.0F, 2.0F, 0.0F, false);

		bone62 = new ModelRenderer(this);
		bone62.setRotationPoint(-6.0F, -30.25F, 8.5F);
		upperbody.addChild(bone62);
		setRotationAngle(bone62, 0.0F, -0.2618F, -0.0873F);
		bone62.setTextureOffset(4, 140).addBox(-1.8232F, -3.0F, -0.3062F, 7.0F, 3.0F, 2.0F, 0.0F, false);

		bone41 = new ModelRenderer(this);
		bone41.setRotationPoint(-6.0F, -24.0F, 7.0F);
		upperbody.addChild(bone41);
		setRotationAngle(bone41, 0.0F, -0.2618F, -0.0873F);
		bone41.setTextureOffset(4, 140).addBox(-2.0F, -3.0F, 0.0F, 7.0F, 3.0F, 2.0F, 0.0F, false);

		bone30 = new ModelRenderer(this);
		bone30.setRotationPoint(7.5F, -23.75F, 5.0F);
		upperbody.addChild(bone30);
		setRotationAngle(bone30, 0.0F, 0.6109F, 0.0F);
		bone30.setTextureOffset(4, 140).addBox(-2.0F, -3.0F, 0.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		bone54 = new ModelRenderer(this);
		bone54.setRotationPoint(7.5F, -28.75F, 7.0F);
		upperbody.addChild(bone54);
		setRotationAngle(bone54, 0.0F, 0.6109F, 0.0F);
		bone54.setTextureOffset(4, 140).addBox(-2.0F, -4.0F, 0.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		bone72 = new ModelRenderer(this);
		bone72.setRotationPoint(9.5F, -34.75F, 7.0F);
		upperbody.addChild(bone72);
		setRotationAngle(bone72, 0.0F, 0.6109F, 0.0F);
		bone72.setTextureOffset(4, 140).addBox(-2.9012F, -4.0F, -0.0206F, 4.0F, 3.0F, 2.0F, 0.0F, false);

		bone88 = new ModelRenderer(this);
		bone88.setRotationPoint(10.5F, -41.75F, 7.0F);
		upperbody.addChild(bone88);
		setRotationAngle(bone88, 0.0F, 0.6109F, 0.0F);
		bone88.setTextureOffset(4, 140).addBox(-2.6144F, -4.0F, -0.4302F, 4.0F, 3.0F, 2.0F, 0.0F, false);

		bone95 = new ModelRenderer(this);
		bone95.setRotationPoint(-10.0F, -41.75F, 7.75F);
		upperbody.addChild(bone95);
		setRotationAngle(bone95, 0.0F, -0.6109F, 0.0F);
		bone95.setTextureOffset(4, 140).addBox(-2.6144F, -4.0F, -0.4302F, 4.0F, 3.0F, 2.0F, 0.0F, false);

		bone80 = new ModelRenderer(this);
		bone80.setRotationPoint(-8.75F, -34.75F, 8.0F);
		upperbody.addChild(bone80);
		setRotationAngle(bone80, 0.0F, -0.6109F, 0.0F);
		bone80.setTextureOffset(4, 140).addBox(-2.9012F, -4.0F, -0.0206F, 4.0F, 3.0F, 2.0F, 0.0F, false);

		bone63 = new ModelRenderer(this);
		bone63.setRotationPoint(-7.5F, -28.75F, 7.5F);
		upperbody.addChild(bone63);
		setRotationAngle(bone63, 0.0F, -0.6109F, 0.0F);
		bone63.setTextureOffset(4, 140).addBox(-2.0F, -4.0F, 0.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		bone103 = new ModelRenderer(this);
		bone103.setRotationPoint(-8.75F, -46.75F, 5.75F);
		upperbody.addChild(bone103);
		setRotationAngle(bone103, 0.0F, -0.6109F, 0.0F);
		bone103.setTextureOffset(4, 140).addBox(-2.0F, -4.0F, 0.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		bone118 = new ModelRenderer(this);
		bone118.setRotationPoint(-9.0F, -51.75F, 3.5F);
		upperbody.addChild(bone118);
		setRotationAngle(bone118, 0.0F, -0.6109F, 0.0F);
		bone118.setTextureOffset(4, 140).addBox(-2.0F, -4.0F, 0.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		bone124 = new ModelRenderer(this);
		bone124.setRotationPoint(9.0F, -51.5F, 3.0F);
		upperbody.addChild(bone124);
		setRotationAngle(bone124, 0.0F, 0.6109F, 0.0F);
		bone124.setTextureOffset(4, 140).addBox(-2.0F, -4.0F, 0.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		bone110 = new ModelRenderer(this);
		bone110.setRotationPoint(8.75F, -46.75F, 5.25F);
		upperbody.addChild(bone110);
		setRotationAngle(bone110, 0.0F, 0.6109F, 0.0F);
		bone110.setTextureOffset(4, 140).addBox(-2.0F, -4.0F, 0.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		bone42 = new ModelRenderer(this);
		bone42.setRotationPoint(-7.75F, -23.75F, 6.25F);
		upperbody.addChild(bone42);
		setRotationAngle(bone42, 0.0F, -0.6109F, 0.0F);
		bone42.setTextureOffset(4, 140).addBox(-2.0F, -3.0F, 0.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		bone31 = new ModelRenderer(this);
		bone31.setRotationPoint(12.0F, -23.75F, 1.25F);
		upperbody.addChild(bone31);
		setRotationAngle(bone31, 0.0F, 0.9599F, 0.0F);
		bone31.setTextureOffset(4, 140).addBox(-5.7072F, -3.0F, -1.3717F, 4.0F, 3.0F, 2.0F, 0.0F, false);

		bone55 = new ModelRenderer(this);
		bone55.setRotationPoint(12.0F, -28.75F, 3.25F);
		upperbody.addChild(bone55);
		setRotationAngle(bone55, 0.0F, 0.9599F, 0.0F);
		bone55.setTextureOffset(4, 140).addBox(-5.7072F, -4.0F, -1.3717F, 5.0F, 3.0F, 2.0F, 0.0F, false);

		bone73 = new ModelRenderer(this);
		bone73.setRotationPoint(14.75F, -34.75F, 3.25F);
		upperbody.addChild(bone73);
		setRotationAngle(bone73, 0.0F, 0.9599F, 0.0F);
		bone73.setTextureOffset(4, 140).addBox(-5.994F, -4.0F, -1.7813F, 5.0F, 3.0F, 2.0F, 0.0F, false);

		bone89 = new ModelRenderer(this);
		bone89.setRotationPoint(16.0F, -41.75F, 2.5F);
		upperbody.addChild(bone89);
		setRotationAngle(bone89, 0.0F, 0.9599F, 0.0F);
		bone89.setTextureOffset(4, 140).addBox(-5.994F, -4.0F, -1.7813F, 5.0F, 3.0F, 2.0F, 0.0F, false);

		bone96 = new ModelRenderer(this);
		bone96.setRotationPoint(-12.0F, -41.75F, 8.5F);
		upperbody.addChild(bone96);
		setRotationAngle(bone96, 0.0F, -0.9599F, 0.0F);
		bone96.setTextureOffset(4, 140).addBox(-6.3422F, -4.0F, -1.7199F, 5.0F, 3.0F, 2.0F, 0.0F, false);

		bone81 = new ModelRenderer(this);
		bone81.setRotationPoint(-11.25F, -34.75F, 9.0F);
		upperbody.addChild(bone81);
		setRotationAngle(bone81, 0.0F, -0.9599F, 0.0F);
		bone81.setTextureOffset(4, 140).addBox(-5.994F, -4.0F, -1.7813F, 5.0F, 3.0F, 2.0F, 0.0F, false);

		bone64 = new ModelRenderer(this);
		bone64.setRotationPoint(-9.0F, -28.75F, 8.5F);
		upperbody.addChild(bone64);
		setRotationAngle(bone64, 0.0F, -0.9599F, 0.0F);
		bone64.setTextureOffset(4, 140).addBox(-5.7072F, -4.0F, -1.3717F, 5.0F, 3.0F, 2.0F, 0.0F, false);

		bone104 = new ModelRenderer(this);
		bone104.setRotationPoint(-10.5F, -46.75F, 6.5F);
		upperbody.addChild(bone104);
		setRotationAngle(bone104, 0.0F, -0.9599F, 0.0F);
		bone104.setTextureOffset(4, 140).addBox(-5.7072F, -4.0F, -1.3717F, 5.0F, 3.0F, 2.0F, 0.0F, false);

		bone119 = new ModelRenderer(this);
		bone119.setRotationPoint(-10.5F, -51.25F, 4.0F);
		upperbody.addChild(bone119);
		setRotationAngle(bone119, 0.0F, -1.1345F, 0.0F);
		bone119.setTextureOffset(4, 140).addBox(-5.5863F, -4.25F, -1.0395F, 5.0F, 3.0F, 2.0F, 0.0F, false);

		bone125 = new ModelRenderer(this);
		bone125.setRotationPoint(12.25F, -51.25F, -1.5F);
		upperbody.addChild(bone125);
		setRotationAngle(bone125, 0.0F, 1.1345F, 0.0F);
		bone125.setTextureOffset(4, 140).addBox(-5.5863F, -4.25F, -1.0395F, 5.0F, 3.0F, 2.0F, 0.0F, false);

		bone111 = new ModelRenderer(this);
		bone111.setRotationPoint(13.25F, -46.75F, 1.25F);
		upperbody.addChild(bone111);
		setRotationAngle(bone111, 0.0F, 0.9599F, 0.0F);
		bone111.setTextureOffset(4, 140).addBox(-5.7072F, -4.0F, -1.3717F, 5.0F, 3.0F, 2.0F, 0.0F, false);

		bone43 = new ModelRenderer(this);
		bone43.setRotationPoint(-9.0F, -23.75F, 7.75F);
		upperbody.addChild(bone43);
		setRotationAngle(bone43, 0.0F, -0.9599F, 0.0F);
		bone43.setTextureOffset(4, 140).addBox(-5.7072F, -3.0F, -1.3717F, 4.0F, 3.0F, 2.0F, 0.0F, false);

		bone32 = new ModelRenderer(this);
		bone32.setRotationPoint(10.75F, -23.75F, -2.25F);
		upperbody.addChild(bone32);
		setRotationAngle(bone32, 0.0F, 1.5708F, 0.0F);
		bone32.setTextureOffset(4, 140).addBox(-5.7072F, -3.0F, -1.3717F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		bone56 = new ModelRenderer(this);
		bone56.setRotationPoint(13.0F, -28.5F, -7.5F);
		upperbody.addChild(bone56);
		setRotationAngle(bone56, 0.0F, 1.3963F, 0.0F);
		bone56.setTextureOffset(4, 140).addBox(-11.7468F, -4.25F, -0.8245F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		bone74 = new ModelRenderer(this);
		bone74.setRotationPoint(15.75F, -34.25F, -7.75F);
		upperbody.addChild(bone74);
		setRotationAngle(bone74, 0.0F, 1.3963F, 0.0F);
		bone74.setTextureOffset(4, 140).addBox(-11.8337F, -4.5F, -1.3169F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		bone90 = new ModelRenderer(this);
		bone90.setRotationPoint(17.0F, -41.0F, -8.25F);
		upperbody.addChild(bone90);
		setRotationAngle(bone90, 0.0F, 1.3963F, 0.0F);
		bone90.setTextureOffset(4, 140).addBox(-11.8337F, -4.5F, -1.3169F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		bone97 = new ModelRenderer(this);
		bone97.setRotationPoint(-13.25F, -41.0F, 12.75F);
		upperbody.addChild(bone97);
		setRotationAngle(bone97, 0.0F, -1.3963F, 0.0F);
		bone97.setTextureOffset(4, 140).addBox(-12.6157F, -4.5F, -1.2009F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		bone82 = new ModelRenderer(this);
		bone82.setRotationPoint(-12.5F, -34.25F, 12.75F);
		upperbody.addChild(bone82);
		setRotationAngle(bone82, 0.0F, -1.3963F, 0.0F);
		bone82.setTextureOffset(4, 140).addBox(-11.8337F, -4.5F, -1.3169F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		bone65 = new ModelRenderer(this);
		bone65.setRotationPoint(-10.0F, -28.5F, 12.75F);
		upperbody.addChild(bone65);
		setRotationAngle(bone65, 0.0F, -1.3963F, 0.0F);
		bone65.setTextureOffset(4, 140).addBox(-11.7468F, -4.25F, -0.8245F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		bone105 = new ModelRenderer(this);
		bone105.setRotationPoint(-11.5F, -46.5F, 10.5F);
		upperbody.addChild(bone105);
		setRotationAngle(bone105, 0.0F, -1.3963F, 0.0F);
		bone105.setTextureOffset(4, 140).addBox(-11.7468F, -4.25F, -0.8245F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		bone112 = new ModelRenderer(this);
		bone112.setRotationPoint(14.0F, -46.5F, -9.5F);
		upperbody.addChild(bone112);
		setRotationAngle(bone112, 0.0F, 1.3963F, 0.0F);
		bone112.setTextureOffset(4, 140).addBox(-11.7468F, -4.25F, -0.8245F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		bone44 = new ModelRenderer(this);
		bone44.setRotationPoint(-12.0F, -23.75F, 6.25F);
		upperbody.addChild(bone44);
		setRotationAngle(bone44, 0.0F, -1.5708F, 0.0F);
		bone44.setTextureOffset(4, 140).addBox(-5.7072F, -3.0F, -1.3717F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		bone33 = new ModelRenderer(this);
		bone33.setRotationPoint(8.75F, -23.75F, -4.5F);
		upperbody.addChild(bone33);
		setRotationAngle(bone33, 0.0F, 1.9199F, 0.0F);
		bone33.setTextureOffset(4, 140).addBox(-5.7072F, -3.0F, -1.3717F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		bone57 = new ModelRenderer(this);
		bone57.setRotationPoint(9.5F, -28.5F, -4.0F);
		upperbody.addChild(bone57);
		setRotationAngle(bone57, 0.0F, 1.9199F, 0.0F);
		bone57.setTextureOffset(4, 140).addBox(-6.1131F, -4.0F, -0.9874F, 4.0F, 3.0F, 2.0F, 0.0F, false);

		bone75 = new ModelRenderer(this);
		bone75.setRotationPoint(12.25F, -34.25F, -4.0F);
		upperbody.addChild(bone75);
		setRotationAngle(bone75, 0.0F, 1.9199F, 0.0F);
		bone75.setTextureOffset(4, 140).addBox(-6.0276F, -4.5F, -1.2223F, 4.0F, 3.0F, 2.0F, 0.0F, false);

		bone91 = new ModelRenderer(this);
		bone91.setRotationPoint(13.25F, -40.75F, -4.75F);
		upperbody.addChild(bone91);
		setRotationAngle(bone91, 0.0F, 1.9199F, 0.0F);
		bone91.setTextureOffset(4, 140).addBox(-6.0276F, -4.5F, -1.2223F, 4.0F, 3.0F, 2.0F, 0.0F, false);

		bone98 = new ModelRenderer(this);
		bone98.setRotationPoint(-15.75F, -40.75F, 3.5F);
		upperbody.addChild(bone98);
		setRotationAngle(bone98, 0.0F, -1.9199F, 0.0F);
		bone98.setTextureOffset(4, 140).addBox(-6.6469F, -4.5F, -0.7308F, 4.0F, 3.0F, 2.0F, 0.0F, false);

		bone83 = new ModelRenderer(this);
		bone83.setRotationPoint(-15.0F, -34.25F, 3.5F);
		upperbody.addChild(bone83);
		setRotationAngle(bone83, 0.0F, -1.9199F, 0.0F);
		bone83.setTextureOffset(4, 140).addBox(-6.0276F, -4.5F, -1.2223F, 4.0F, 3.0F, 2.0F, 0.0F, false);

		bone66 = new ModelRenderer(this);
		bone66.setRotationPoint(-14.25F, -46.75F, 2.0F);
		upperbody.addChild(bone66);
		setRotationAngle(bone66, 0.0F, -1.9199F, 0.0F);
		bone66.setTextureOffset(4, 140).addBox(-6.3481F, -4.0F, -0.9019F, 4.0F, 3.0F, 2.0F, 0.0F, false);

		bone120 = new ModelRenderer(this);
		bone120.setRotationPoint(-12.75F, -51.0F, 1.5F);
		upperbody.addChild(bone120);
		setRotationAngle(bone120, 0.0F, -1.9199F, 0.0F);
		bone120.setTextureOffset(4, 140).addBox(-5.6217F, -4.25F, -0.3681F, 4.0F, 3.0F, 2.0F, 0.0F, false);

		bone126 = new ModelRenderer(this);
		bone126.setRotationPoint(9.25F, -51.0F, -5.0F);
		upperbody.addChild(bone126);
		setRotationAngle(bone126, 0.0F, 1.9199F, 0.0F);
		bone126.setTextureOffset(4, 140).addBox(-5.6217F, -4.25F, -0.3681F, 4.0F, 3.0F, 2.0F, 0.0F, false);

		bone113 = new ModelRenderer(this);
		bone113.setRotationPoint(10.25F, -46.75F, -6.25F);
		upperbody.addChild(bone113);
		setRotationAngle(bone113, 0.0F, 1.9199F, 0.0F);
		bone113.setTextureOffset(4, 140).addBox(-6.3481F, -4.0F, -0.9019F, 4.0F, 3.0F, 2.0F, 0.0F, false);

		bone106 = new ModelRenderer(this);
		bone106.setRotationPoint(-12.75F, -28.75F, 3.75F);
		upperbody.addChild(bone106);
		setRotationAngle(bone106, 0.0F, -1.9199F, 0.0F);
		bone106.setTextureOffset(4, 140).addBox(-6.3481F, -4.0F, -0.9019F, 4.0F, 3.0F, 2.0F, 0.0F, false);

		bone45 = new ModelRenderer(this);
		bone45.setRotationPoint(-12.75F, -23.75F, 3.5F);
		upperbody.addChild(bone45);
		setRotationAngle(bone45, 0.0F, -1.9199F, 0.0F);
		bone45.setTextureOffset(4, 140).addBox(-5.7072F, -3.0F, -1.3717F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		bone34 = new ModelRenderer(this);
		bone34.setRotationPoint(5.25F, -23.75F, -4.75F);
		upperbody.addChild(bone34);
		setRotationAngle(bone34, 0.0F, 2.5307F, 0.0F);
		bone34.setTextureOffset(4, 140).addBox(-5.7072F, -2.75F, -1.3717F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		bone58 = new ModelRenderer(this);
		bone58.setRotationPoint(6.0F, -28.5F, -4.5F);
		upperbody.addChild(bone58);
		setRotationAngle(bone58, 0.0F, 2.5307F, 0.0F);
		bone58.setTextureOffset(4, 140).addBox(-5.4818F, -3.5F, -0.6139F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		bone76 = new ModelRenderer(this);
		bone76.setRotationPoint(8.25F, -35.0F, -4.5F);
		upperbody.addChild(bone76);
		setRotationAngle(bone76, 0.0F, 2.5307F, 0.0F);
		bone76.setTextureOffset(4, 140).addBox(-5.4818F, -3.5F, -0.6139F, 4.0F, 2.0F, 2.0F, 0.0F, false);

		bone92 = new ModelRenderer(this);
		bone92.setRotationPoint(9.25F, -41.5F, -5.25F);
		upperbody.addChild(bone92);
		setRotationAngle(bone92, 0.0F, 2.5307F, 0.0F);
		bone92.setTextureOffset(4, 140).addBox(-5.4818F, -3.25F, -0.6139F, 4.0F, 2.0F, 2.0F, 0.0F, false);

		bone99 = new ModelRenderer(this);
		bone99.setRotationPoint(-14.75F, -41.5F, -0.25F);
		upperbody.addChild(bone99);
		setRotationAngle(bone99, 0.0F, -2.5307F, 0.0F);
		bone99.setTextureOffset(4, 140).addBox(-5.7072F, -3.25F, 0.1438F, 4.0F, 2.0F, 2.0F, 0.0F, false);

		bone84 = new ModelRenderer(this);
		bone84.setRotationPoint(-14.25F, -35.0F, -0.25F);
		upperbody.addChild(bone84);
		setRotationAngle(bone84, 0.0F, -2.5307F, 0.0F);
		bone84.setTextureOffset(4, 140).addBox(-5.4818F, -3.5F, -0.6139F, 4.0F, 2.0F, 2.0F, 0.0F, false);

		bone67 = new ModelRenderer(this);
		bone67.setRotationPoint(-13.0F, -28.5F, 0.75F);
		upperbody.addChild(bone67);
		setRotationAngle(bone67, 0.0F, -2.5307F, 0.0F);
		bone67.setTextureOffset(4, 140).addBox(-5.7686F, -3.5F, -0.2044F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		bone107 = new ModelRenderer(this);
		bone107.setRotationPoint(-14.25F, -46.75F, -1.25F);
		upperbody.addChild(bone107);
		setRotationAngle(bone107, 0.0F, -2.5307F, 0.0F);
		bone107.setTextureOffset(4, 140).addBox(-5.7686F, -3.5F, -0.2044F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		bone121 = new ModelRenderer(this);
		bone121.setRotationPoint(-13.5F, -51.5F, -1.0F);
		upperbody.addChild(bone121);
		setRotationAngle(bone121, 0.0F, -2.5307F, 0.0F);
		bone121.setTextureOffset(4, 140).addBox(-5.7686F, -3.5F, -0.2044F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		bone127 = new ModelRenderer(this);
		bone127.setRotationPoint(5.5F, -51.5F, -5.75F);
		upperbody.addChild(bone127);
		setRotationAngle(bone127, 0.0F, 2.5307F, 0.0F);
		bone127.setTextureOffset(4, 140).addBox(-5.912F, -3.5F, 0.0004F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		bone114 = new ModelRenderer(this);
		bone114.setRotationPoint(6.5F, -46.75F, -6.25F);
		upperbody.addChild(bone114);
		setRotationAngle(bone114, 0.0F, 2.5307F, 0.0F);
		bone114.setTextureOffset(4, 140).addBox(-5.5638F, -3.5F, -0.3478F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		bone46 = new ModelRenderer(this);
		bone46.setRotationPoint(-13.25F, -23.75F, 0.25F);
		upperbody.addChild(bone46);
		setRotationAngle(bone46, 0.0F, -2.5307F, 0.0F);
		bone46.setTextureOffset(4, 140).addBox(-5.7072F, -3.0F, -1.3717F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		bone35 = new ModelRenderer(this);
		bone35.setRotationPoint(2.25F, -24.25F, -3.0F);
		upperbody.addChild(bone35);
		setRotationAngle(bone35, 0.0F, 3.1416F, 0.0873F);
		bone35.setTextureOffset(4, 140).addBox(-5.729F, -2.751F, -1.3717F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		bone100 = new ModelRenderer(this);
		bone100.setRotationPoint(-10.0F, -41.75F, -3.0F);
		upperbody.addChild(bone100);
		setRotationAngle(bone100, 0.0F, 3.1416F, -0.0873F);
		bone100.setTextureOffset(4, 140).addBox(-8.7072F, -3.0872F, 0.3783F, 10.0F, 2.0F, 2.0F, 0.0F, false);

		bone69 = new ModelRenderer(this);
		bone69.setRotationPoint(-8.75F, -28.5F, -2.25F);
		upperbody.addChild(bone69);
		setRotationAngle(bone69, 0.0F, 3.1416F, -0.2618F);
		bone69.setTextureOffset(4, 140).addBox(-6.6605F, -3.0796F, -0.3717F, 5.0F, 2.0F, 2.0F, 0.0F, false);

		bone36 = new ModelRenderer(this);
		bone36.setRotationPoint(-0.5F, -25.5F, -3.0F);
		upperbody.addChild(bone36);
		setRotationAngle(bone36, 0.0F, 3.1416F, 0.2618F);
		bone36.setTextureOffset(4, 140).addBox(-6.7252F, -2.8381F, -1.3717F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		bone59 = new ModelRenderer(this);
		bone59.setRotationPoint(2.75F, -29.5F, -2.75F);
		upperbody.addChild(bone59);
		setRotationAngle(bone59, 0.0F, 3.1416F, 0.0873F);
		bone59.setTextureOffset(4, 140).addBox(-6.2053F, -3.0436F, -0.6217F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		bone77 = new ModelRenderer(this);
		bone77.setRotationPoint(3.75F, -36.0F, -3.5F);
		upperbody.addChild(bone77);
		setRotationAngle(bone77, 0.0F, 3.1416F, 0.0873F);
		bone77.setTextureOffset(4, 140).addBox(-6.2053F, -3.0436F, -0.6217F, 7.0F, 2.0F, 2.0F, 0.0F, false);
		bone77.setTextureOffset(4, 140).addBox(-6.9058F, -9.3787F, -0.1217F, 10.0F, 2.0F, 2.0F, 0.0F, false);

		bone85 = new ModelRenderer(this);
		bone85.setRotationPoint(-9.5F, -35.5F, -3.0F);
		upperbody.addChild(bone85);
		setRotationAngle(bone85, 0.0F, 3.1416F, -0.0873F);
		bone85.setTextureOffset(4, 140).addBox(-6.2053F, -3.0436F, -0.1217F, 7.0F, 2.0F, 2.0F, 0.0F, false);

		bone108 = new ModelRenderer(this);
		bone108.setRotationPoint(-9.25F, -47.25F, -3.5F);
		upperbody.addChild(bone108);
		setRotationAngle(bone108, 0.0F, 3.1416F, -0.0873F);
		bone108.setTextureOffset(4, 140).addBox(-7.7072F, -3.0872F, 0.6283F, 9.0F, 2.0F, 2.0F, 0.0F, false);

		bone122 = new ModelRenderer(this);
		bone122.setRotationPoint(-8.25F, -51.75F, -3.25F);
		upperbody.addChild(bone122);
		setRotationAngle(bone122, 0.0F, 3.1416F, -0.0873F);
		bone122.setTextureOffset(4, 140).addBox(-6.7072F, -3.0872F, 0.6283F, 8.0F, 2.0F, 2.0F, 0.0F, false);

		bone128 = new ModelRenderer(this);
		bone128.setRotationPoint(2.0F, -52.25F, -3.25F);
		upperbody.addChild(bone128);
		setRotationAngle(bone128, 0.0F, 3.1416F, 0.0873F);
		bone128.setTextureOffset(4, 140).addBox(-6.7072F, -3.0872F, 0.6283F, 8.0F, 2.0F, 2.0F, 0.0F, false);

		bone115 = new ModelRenderer(this);
		bone115.setRotationPoint(2.0F, -47.75F, -3.5F);
		upperbody.addChild(bone115);
		setRotationAngle(bone115, 0.0F, 3.1416F, 0.0873F);
		bone115.setTextureOffset(4, 140).addBox(-7.4582F, -3.0654F, 0.6283F, 9.0F, 2.0F, 2.0F, 0.0F, false);

		bone47 = new ModelRenderer(this);
		bone47.setRotationPoint(-12.0F, -23.75F, -3.0F);
		upperbody.addChild(bone47);
		setRotationAngle(bone47, 0.0F, 3.1416F, -0.0873F);
		bone47.setTextureOffset(4, 140).addBox(-5.2091F, -2.5455F, -1.3717F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		bone68 = new ModelRenderer(this);
		bone68.setRotationPoint(-13.5F, -28.5F, -2.0F);
		upperbody.addChild(bone68);
		setRotationAngle(bone68, 0.0F, 3.1416F, -0.0873F);
		bone68.setTextureOffset(4, 140).addBox(-6.2053F, -3.0436F, -0.1217F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		bone60 = new ModelRenderer(this);
		bone60.setRotationPoint(0.75F, -30.75F, -3.0F);
		upperbody.addChild(bone60);
		setRotationAngle(bone60, 0.0F, 3.1416F, 0.2618F);
		bone60.setTextureOffset(4, 140).addBox(-6.6605F, -3.0796F, -0.8717F, 5.0F, 2.0F, 2.0F, 0.0F, false);

		bone48 = new ModelRenderer(this);
		bone48.setRotationPoint(-11.0F, -23.25F, -2.75F);
		upperbody.addChild(bone48);
		setRotationAngle(bone48, 0.0F, 3.1416F, -0.2618F);
		bone48.setTextureOffset(4, 140).addBox(-6.3543F, -2.4198F, -1.1217F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		bone37 = new ModelRenderer(this);
		bone37.setRotationPoint(-2.0F, -27.25F, -3.0F);
		upperbody.addChild(bone37);
		setRotationAngle(bone37, 0.0F, 3.1416F, 0.4363F);
		bone37.setTextureOffset(4, 140).addBox(-6.7252F, -2.8381F, -1.3717F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		bone38 = new ModelRenderer(this);
		bone38.setRotationPoint(-1.75F, -26.25F, -3.0F);
		upperbody.addChild(bone38);
		setRotationAngle(bone38, 0.0F, 3.1416F, 0.6981F);
		bone38.setTextureOffset(4, 140).addBox(-3.6447F, -4.7118F, -1.3717F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		bone49 = new ModelRenderer(this);
		bone49.setRotationPoint(-9.0F, -22.5F, -3.0F);
		upperbody.addChild(bone49);
		setRotationAngle(bone49, 0.0F, 3.1416F, -0.4363F);
		bone49.setTextureOffset(4, 140).addBox(-6.7252F, -2.8381F, -1.3717F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		bone50 = new ModelRenderer(this);
		bone50.setRotationPoint(-3.0F, -22.75F, -3.0F);
		upperbody.addChild(bone50);
		setRotationAngle(bone50, 0.0F, 3.1416F, -0.6981F);
		bone50.setTextureOffset(4, 140).addBox(-3.6447F, -4.7118F, -1.3717F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		bone39 = new ModelRenderer(this);
		bone39.setRotationPoint(-2.5F, -28.25F, -3.0F);
		upperbody.addChild(bone39);
		setRotationAngle(bone39, 0.0F, 3.1416F, 0.9599F);
		bone39.setTextureOffset(4, 140).addBox(-2.9484F, -4.589F, -1.3717F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		bone51 = new ModelRenderer(this);
		bone51.setRotationPoint(-0.5F, -24.75F, -3.0F);
		upperbody.addChild(bone51);
		setRotationAngle(bone51, 0.0F, 3.1416F, -0.9599F);
		bone51.setTextureOffset(4, 140).addBox(-2.9484F, -4.589F, -1.3717F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		bone61 = new ModelRenderer(this);
		bone61.setRotationPoint(-1.5F, -30.5F, -3.0F);
		upperbody.addChild(bone61);
		setRotationAngle(bone61, 0.0F, 3.1416F, 0.3491F);
		bone61.setTextureOffset(4, 140).addBox(-3.6894F, -3.8725F, -0.8717F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		bone40 = new ModelRenderer(this);
		bone40.setRotationPoint(-3.5F, -30.25F, -3.0F);
		upperbody.addChild(bone40);
		setRotationAngle(bone40, 0.0F, 3.1416F, 1.0472F);
		bone40.setTextureOffset(4, 140).addBox(-3.6894F, -3.8725F, -1.3717F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		bone78 = new ModelRenderer(this);
		bone78.setRotationPoint(0.0F, -30.5F, -3.0F);
		upperbody.addChild(bone78);
		setRotationAngle(bone78, 0.0F, 3.1416F, 0.1745F);
		bone78.setTextureOffset(4, 140).addBox(-1.9793F, -8.571F, -0.1217F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		bone93 = new ModelRenderer(this);
		bone93.setRotationPoint(0.0F, -30.5F, -3.0F);
		upperbody.addChild(bone93);
		setRotationAngle(bone93, 0.0F, 3.1416F, 0.1745F);
		bone93.setTextureOffset(4, 140).addBox(0.1342F, -14.7986F, 0.3783F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		bone116 = new ModelRenderer(this);
		bone116.setRotationPoint(-0.25F, -35.75F, -3.5F);
		upperbody.addChild(bone116);
		setRotationAngle(bone116, 0.0F, 3.1416F, 0.1745F);
		bone116.setTextureOffset(4, 140).addBox(0.3804F, -14.7552F, 0.6283F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		bone86 = new ModelRenderer(this);
		bone86.setRotationPoint(-2.25F, -30.25F, -3.0F);
		upperbody.addChild(bone86);
		setRotationAngle(bone86, 0.0F, 3.1416F, -0.1745F);
		bone86.setTextureOffset(4, 140).addBox(-1.9793F, -8.571F, -0.1217F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		bone129 = new ModelRenderer(this);
		bone129.setRotationPoint(-0.25F, -18.25F, -8.25F);
		Body.addChild(bone129);
		setRotationAngle(bone129, 0.0F, 3.1416F, 0.1745F);
		bone129.setTextureOffset(4, 140).addBox(0.3804F, -14.7552F, 0.6283F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		bone101 = new ModelRenderer(this);
		bone101.setRotationPoint(-2.25F, -8.25F, -8.0F);
		Body.addChild(bone101);
		setRotationAngle(bone101, 0.0F, 3.1416F, -0.1745F);
		bone101.setTextureOffset(4, 140).addBox(-4.0928F, -14.7986F, 0.3783F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone101.setTextureOffset(4, 140).addBox(-4.9611F, -19.7226F, 1.1283F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone101.setTextureOffset(4, 140).addBox(-5.7425F, -24.1542F, 0.8783F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		bone70 = new ModelRenderer(this);
		bone70.setRotationPoint(-3.75F, -6.5F, -7.25F);
		Body.addChild(bone70);
		setRotationAngle(bone70, 0.0F, 3.1416F, -0.3491F);
		bone70.setTextureOffset(4, 140).addBox(-3.6894F, -3.8725F, -0.3717F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		bone52 = new ModelRenderer(this);
		bone52.setRotationPoint(0.0F, -3.5F, -8.0F);
		Body.addChild(bone52);
		setRotationAngle(bone52, 0.0F, 3.1416F, -1.0472F);
		bone52.setTextureOffset(4, 140).addBox(-3.6894F, -3.8725F, -1.3717F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(0.0F, -4.5F, 2.5F);
		Body.addChild(bone7);
		setRotationAngle(bone7, -0.4363F, 0.0F, 0.0F);
		bone7.setTextureOffset(4, 140).addBox(-2.0F, -3.0F, 0.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(0.0F, -6.75F, 3.5F);
		Body.addChild(bone8);
		setRotationAngle(bone8, -0.2618F, 0.0F, 0.0F);
		bone8.setTextureOffset(4, 140).addBox(-2.0F, -3.0F, 0.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		bone9 = new ModelRenderer(this);
		bone9.setRotationPoint(0.0F, -9.25F, 4.25F);
		Body.addChild(bone9);
		setRotationAngle(bone9, -0.2618F, 0.0F, 0.0F);
		bone9.setTextureOffset(4, 140).addBox(-2.0F, -3.0F, 0.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		bone10 = new ModelRenderer(this);
		bone10.setRotationPoint(0.0F, -11.75F, 5.0F);
		Body.addChild(bone10);
		setRotationAngle(bone10, -0.1745F, 0.0F, 0.0F);
		bone10.setTextureOffset(4, 140).addBox(-2.0F, -3.0F, 0.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		bone11 = new ModelRenderer(this);
		bone11.setRotationPoint(0.0F, -14.25F, 5.5F);
		Body.addChild(bone11);
		bone11.setTextureOffset(4, 140).addBox(-2.0F, -3.0F, 0.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		bone12 = new ModelRenderer(this);
		bone12.setRotationPoint(0.0F, -17.0F, 5.5F);
		Body.addChild(bone12);
		setRotationAngle(bone12, 0.0873F, 0.0F, 0.0F);
		bone12.setTextureOffset(4, 140).addBox(-2.0F, -3.0F, 0.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		bone13 = new ModelRenderer(this);
		bone13.setRotationPoint(0.0F, -19.25F, 5.25F);
		Body.addChild(bone13);
		setRotationAngle(bone13, 0.2618F, 0.0F, 0.0F);
		bone13.setTextureOffset(4, 140).addBox(-2.0F, -3.0F, 0.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		bone14 = new ModelRenderer(this);
		bone14.setRotationPoint(0.0F, -21.75F, 4.5F);
		Body.addChild(bone14);
		setRotationAngle(bone14, 0.3491F, 0.0F, 0.0F);
		bone14.setTextureOffset(4, 140).addBox(-2.0F, -3.0F, 0.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		bone15 = new ModelRenderer(this);
		bone15.setRotationPoint(0.0F, -24.25F, 3.5F);
		Body.addChild(bone15);
		setRotationAngle(bone15, 0.5236F, 0.0F, 0.0F);
		bone15.setTextureOffset(4, 140).addBox(-2.0F, -3.0F, 0.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		bone16 = new ModelRenderer(this);
		bone16.setRotationPoint(0.0F, -26.5F, 2.25F);
		Body.addChild(bone16);
		setRotationAngle(bone16, 0.6109F, 0.0F, 0.0F);
		bone16.setTextureOffset(4, 140).addBox(-2.0F, -3.0F, 0.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		bone24 = new ModelRenderer(this);
		bone24.setRotationPoint(0.0F, -28.75F, 0.5F);
		Body.addChild(bone24);
		setRotationAngle(bone24, 0.6109F, 0.0F, 0.0F);
		bone24.setTextureOffset(4, 140).addBox(-2.0F, -3.0F, 0.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		bone25 = new ModelRenderer(this);
		bone25.setRotationPoint(0.0F, -30.75F, -1.25F);
		Body.addChild(bone25);
		setRotationAngle(bone25, 0.6981F, 0.0F, 0.0F);
		bone25.setTextureOffset(4, 140).addBox(-2.0F, -3.0F, 0.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		bone26 = new ModelRenderer(this);
		bone26.setRotationPoint(0.0F, -32.75F, -3.25F);
		Body.addChild(bone26);
		setRotationAngle(bone26, 0.4363F, 0.0F, 0.0F);
		bone26.setTextureOffset(4, 140).addBox(-2.0F, -3.0F, 0.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		bone27 = new ModelRenderer(this);
		bone27.setRotationPoint(0.0F, -35.5F, -4.5F);
		Body.addChild(bone27);
		setRotationAngle(bone27, 0.2618F, 0.0F, 0.0F);
		bone27.setTextureOffset(4, 140).addBox(-2.0F, -3.0F, 0.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		bone28 = new ModelRenderer(this);
		bone28.setRotationPoint(0.0F, -38.0F, -5.25F);
		Body.addChild(bone28);
		setRotationAngle(bone28, 0.1745F, 0.0F, 0.0F);
		bone28.setTextureOffset(4, 140).addBox(-2.0F, -3.0F, 0.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		bone156 = new ModelRenderer(this);
		bone156.setRotationPoint(0.0F, -43.0F, -5.25F);
		Body.addChild(bone156);
		setRotationAngle(bone156, 0.1745F, 0.0F, 0.0F);
		bone156.setTextureOffset(3, 91).addBox(-8.0F, -3.8146F, -3.738F, 16.0F, 10.0F, 13.0F, 0.0F, false);

		bone157 = new ModelRenderer(this);
		bone157.setRotationPoint(0.0F, -43.0F, -5.25F);
		Body.addChild(bone157);
		setRotationAngle(bone157, 0.1745F, 0.0F, 0.0F);
		bone157.setTextureOffset(12, 102).addBox(-5.5F, -9.7082F, -3.5225F, 10.0F, 7.0F, 10.0F, 0.0F, false);
		bone157.setTextureOffset(13, 100).addBox(-4.0F, -12.6626F, -3.0015F, 7.0F, 7.0F, 8.0F, 0.0F, false);

		bone130 = new ModelRenderer(this);
		bone130.setRotationPoint(2.5F, 13.0F, 6.5F);
		Body.addChild(bone130);
		setRotationAngle(bone130, 0.0F, 0.0F, 0.7854F);
		bone130.setTextureOffset(11, 114).addBox(-5.2766F, -0.7405F, 0.6016F, 3.0F, 3.0F, 1.0F, 0.0F, false);

		bone153 = new ModelRenderer(this);
		bone153.setRotationPoint(2.5F, -10.0F, -11.75F);
		Body.addChild(bone153);
		setRotationAngle(bone153, 0.0F, 0.0F, 0.7854F);
		bone153.setTextureOffset(6, 109).addBox(-5.2766F, -0.7405F, 0.6016F, 4.0F, 4.0F, 1.0F, 0.0F, false);

		bone131 = new ModelRenderer(this);
		bone131.setRotationPoint(0.5F, 12.25F, 6.5F);
		Body.addChild(bone131);
		setRotationAngle(bone131, 0.0F, 0.0F, 1.2217F);
		bone131.setTextureOffset(7, 107).addBox(-50.2766F, -1.7405F, 0.6016F, 48.0F, 4.0F, 1.0F, 0.0F, false);

		bone152 = new ModelRenderer(this);
		bone152.setRotationPoint(11.75F, 10.25F, -11.75F);
		Body.addChild(bone152);
		setRotationAngle(bone152, 0.0F, 0.0F, 1.0472F);
		bone152.setTextureOffset(4, 102).addBox(-53.2766F, -1.7405F, 0.6016F, 27.0F, 4.0F, 1.0F, 0.0F, false);

		bone133 = new ModelRenderer(this);
		bone133.setRotationPoint(3.5F, 1.5F, 6.5F);
		Body.addChild(bone133);
		bone133.setTextureOffset(3, 89).addBox(-19.2766F, -31.7405F, 0.6016F, 30.0F, 4.0F, 1.0F, 0.0F, false);

		bone143 = new ModelRenderer(this);
		bone143.setRotationPoint(3.5F, -2.5F, 6.5F);
		Body.addChild(bone143);
		bone143.setTextureOffset(3, 113).addBox(-19.2766F, -31.7405F, 0.6016F, 30.0F, 4.0F, 1.0F, 0.0F, false);

		bone150 = new ModelRenderer(this);
		bone150.setRotationPoint(3.5F, -2.5F, -11.5F);
		Body.addChild(bone150);
		bone150.setTextureOffset(0, 122).addBox(-17.2766F, -31.7405F, 0.6016F, 27.0F, 4.0F, 1.0F, 0.0F, false);

		bone154 = new ModelRenderer(this);
		bone154.setRotationPoint(3.5F, 0.5F, -11.5F);
		Body.addChild(bone154);
		bone154.setTextureOffset(5, 119).addBox(-15.2766F, -31.7405F, 0.3516F, 21.0F, 4.0F, 1.0F, 0.0F, false);

		bone155 = new ModelRenderer(this);
		bone155.setRotationPoint(3.5F, 4.5F, -11.5F);
		Body.addChild(bone155);
		bone155.setTextureOffset(3, 118).addBox(-13.2766F, -31.7405F, 0.3516F, 18.0F, 4.0F, 1.0F, 0.0F, false);
		bone155.setTextureOffset(0, 123).addBox(-11.2766F, -27.7405F, 0.3516F, 13.0F, 4.0F, 1.0F, 0.0F, false);
		bone155.setTextureOffset(4, 117).addBox(-7.2766F, -24.7405F, 0.3516F, 7.0F, 6.0F, 1.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-17.25F, -35.75F, -1.25F);
		Body.addChild(RightArm);
		

		RightArm3 = new ModelRenderer(this);
		RightArm3.setRotationPoint(0.0F, 0.0F, 0.0F);
		RightArm.addChild(RightArm3);
		setRotationAngle(RightArm3, -2.1817F, 0.0F, -0.4363F);
		RightArm3.setTextureOffset(10, 57).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 40.0F, 5.0F, 0.0F, false);

		bone193 = new ModelRenderer(this);
		bone193.setRotationPoint(-3.5253F, 37.3075F, 0.0F);
		RightArm3.addChild(bone193);
		setRotationAngle(bone193, -0.1745F, 0.0F, -0.2618F);
		bone193.setTextureOffset(10, 57).addBox(-0.1261F, -0.85F, -2.0F, 4.0F, 72.0F, 5.0F, 0.0F, false);

		bone194 = new ModelRenderer(this);
		bone194.setRotationPoint(1.7548F, 67.2209F, 0.0896F);
		bone193.addChild(bone194);
		setRotationAngle(bone194, -0.8727F, 0.0F, 0.0F);
		bone194.setTextureOffset(10, 57).addBox(-3.9134F, 0.6599F, -2.1556F, 8.0F, 3.0F, 5.0F, 0.0F, false);
		bone194.setTextureOffset(10, 57).addBox(-4.391F, 3.4572F, -2.4239F, 9.0F, 3.0F, 5.0F, 0.0F, false);
		bone194.setTextureOffset(10, 57).addBox(-6.3609F, 6.169F, -2.7073F, 13.0F, 10.0F, 5.0F, 0.0F, false);
		bone194.setTextureOffset(10, 57).addBox(8.3021F, 8.979F, -4.2698F, 3.0F, 4.0F, 5.0F, 0.0F, false);
		bone194.setTextureOffset(10, 57).addBox(6.3176F, 6.8531F, -4.6447F, 3.0F, 4.0F, 5.0F, 0.0F, false);
		bone194.setTextureOffset(10, 57).addBox(9.649F, 11.789F, -2.7744F, 3.0F, 4.0F, 4.0F, 0.0F, false);
		bone194.setTextureOffset(10, 57).addBox(10.6053F, 14.613F, -2.2764F, 2.0F, 5.0F, 4.0F, 0.0F, false);
		bone194.setTextureOffset(10, 57).addBox(11.6341F, 18.2786F, -1.6301F, 2.0F, 5.0F, 4.0F, 0.0F, false);
		bone194.setTextureOffset(10, 57).addBox(-7.1274F, 13.2859F, -1.4524F, 13.0F, 5.0F, 4.0F, 0.0F, false);

		bone195 = new ModelRenderer(this);
		bone195.setRotationPoint(-12.0F, -11.0419F, 15.9088F);
		bone194.addChild(bone195);
		bone195.setTextureOffset(10, 57).addBox(5.858F, 28.8791F, -17.3203F, 2.0F, 8.0F, 3.0F, 0.0F, false);
		bone195.setTextureOffset(10, 150).addBox(6.0316F, 28.0395F, -18.23F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		bone195.setTextureOffset(6, 148).addBox(10.3473F, 28.0389F, -18.2301F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		bone195.setTextureOffset(14, 156).addBox(15.4016F, 28.1666F, -18.2075F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		bone195.setTextureOffset(10, 57).addBox(5.8734F, 35.8818F, -16.0856F, 2.0F, 4.0F, 4.0F, 0.0F, false);
		bone195.setTextureOffset(10, 57).addBox(6.3373F, 38.6151F, -13.5728F, 2.0F, 4.0F, 3.0F, 0.0F, false);
		bone195.setTextureOffset(10, 57).addBox(6.4824F, 40.4666F, -12.2309F, 2.0F, 4.0F, 3.0F, 0.0F, false);
		bone195.setTextureOffset(10, 57).addBox(6.6715F, 43.3258F, -10.1823F, 2.0F, 4.0F, 3.0F, 0.0F, false);

		bone196 = new ModelRenderer(this);
		bone196.setRotationPoint(-8.0316F, -9.1028F, 16.2508F);
		bone194.addChild(bone196);
		bone196.setTextureOffset(10, 57).addBox(5.858F, 25.8791F, -17.3203F, 2.0F, 11.0F, 3.0F, 0.0F, false);
		bone196.setTextureOffset(10, 57).addBox(5.8734F, 35.8818F, -16.0856F, 2.0F, 4.0F, 4.0F, 0.0F, false);
		bone196.setTextureOffset(10, 57).addBox(6.3373F, 38.6151F, -13.5728F, 2.0F, 4.0F, 3.0F, 0.0F, false);
		bone196.setTextureOffset(10, 57).addBox(6.4824F, 40.4666F, -12.2309F, 2.0F, 4.0F, 3.0F, 0.0F, false);
		bone196.setTextureOffset(10, 57).addBox(6.6715F, 43.3258F, -10.1823F, 2.0F, 4.0F, 3.0F, 0.0F, false);

		bone197 = new ModelRenderer(this);
		bone197.setRotationPoint(-2.8328F, -11.2F, 15.881F);
		bone194.addChild(bone197);
		bone197.setTextureOffset(10, 57).addBox(5.858F, 25.8791F, -17.3203F, 2.0F, 11.0F, 3.0F, 0.0F, false);
		bone197.setTextureOffset(10, 57).addBox(5.8734F, 35.8818F, -16.0856F, 2.0F, 4.0F, 4.0F, 0.0F, false);
		bone197.setTextureOffset(10, 57).addBox(6.3373F, 38.6151F, -13.5728F, 2.0F, 4.0F, 3.0F, 0.0F, false);
		bone197.setTextureOffset(10, 57).addBox(6.4824F, 40.4666F, -12.2309F, 2.0F, 4.0F, 3.0F, 0.0F, false);
		bone197.setTextureOffset(10, 57).addBox(6.6715F, 43.3258F, -10.1823F, 2.0F, 4.0F, 3.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(17.0F, -35.75F, -1.25F);
		Body.addChild(LeftArm);
		

		LeftArm3 = new ModelRenderer(this);
		LeftArm3.setRotationPoint(0.0F, 0.0F, 0.0F);
		LeftArm.addChild(LeftArm3);
		setRotationAngle(LeftArm3, -2.1817F, 0.0F, 0.6109F);
		LeftArm3.setTextureOffset(29, 67).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 40.0F, 5.0F, 0.0F, false);

		bone188 = new ModelRenderer(this);
		bone188.setRotationPoint(-0.5798F, 35.934F, 0.0F);
		LeftArm3.addChild(bone188);
		setRotationAngle(bone188, -0.1745F, 0.0F, 0.2618F);
		bone188.setTextureOffset(12, 55).addBox(-0.1261F, -0.85F, -2.0F, 4.0F, 72.0F, 5.0F, 0.0F, false);

		bone189 = new ModelRenderer(this);
		bone189.setRotationPoint(1.7548F, 67.2209F, 0.0896F);
		bone188.addChild(bone189);
		setRotationAngle(bone189, -0.8727F, 0.0F, 0.0F);
		bone189.setTextureOffset(29, 67).addBox(-3.9134F, 0.6599F, -2.1556F, 8.0F, 3.0F, 5.0F, 0.0F, false);
		bone189.setTextureOffset(29, 67).addBox(-4.391F, 3.4572F, -2.4239F, 9.0F, 3.0F, 5.0F, 0.0F, false);
		bone189.setTextureOffset(29, 67).addBox(-6.3609F, 6.169F, -2.7073F, 13.0F, 10.0F, 5.0F, 0.0F, false);
		bone189.setTextureOffset(29, 67).addBox(-11.133F, 9.6039F, -4.1597F, 3.0F, 4.0F, 5.0F, 0.0F, false);
		bone189.setTextureOffset(29, 67).addBox(-8.8887F, 6.9936F, -4.6199F, 3.0F, 4.0F, 5.0F, 0.0F, false);
		bone189.setTextureOffset(29, 67).addBox(-11.7265F, 11.5008F, -2.8252F, 3.0F, 4.0F, 4.0F, 0.0F, false);
		bone189.setTextureOffset(29, 67).addBox(-11.7551F, 14.4959F, -2.2971F, 2.0F, 5.0F, 4.0F, 0.0F, false);
		bone189.setTextureOffset(29, 67).addBox(-12.2035F, 18.418F, -1.6055F, 2.0F, 5.0F, 4.0F, 0.0F, false);
		bone189.setTextureOffset(29, 67).addBox(-7.1275F, 13.2859F, -1.4524F, 13.0F, 5.0F, 4.0F, 0.0F, false);

		bone190 = new ModelRenderer(this);
		bone190.setRotationPoint(-12.0F, -11.0419F, 15.9088F);
		bone189.addChild(bone190);
		bone190.setTextureOffset(29, 67).addBox(5.858F, 28.8791F, -17.3203F, 2.0F, 8.0F, 3.0F, 0.0F, false);
		bone190.setTextureOffset(20, 150).addBox(6.0316F, 28.0395F, -18.23F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		bone190.setTextureOffset(14, 145).addBox(10.3473F, 28.0389F, -18.2301F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		bone190.setTextureOffset(17, 158).addBox(15.4016F, 28.1666F, -18.2075F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		bone190.setTextureOffset(29, 67).addBox(5.8734F, 35.8818F, -16.0856F, 2.0F, 4.0F, 4.0F, 0.0F, false);
		bone190.setTextureOffset(29, 67).addBox(6.3373F, 38.6151F, -13.5728F, 2.0F, 4.0F, 3.0F, 0.0F, false);
		bone190.setTextureOffset(29, 67).addBox(6.4824F, 40.4666F, -12.2309F, 2.0F, 4.0F, 3.0F, 0.0F, false);
		bone190.setTextureOffset(29, 67).addBox(6.6715F, 43.3258F, -10.1823F, 2.0F, 4.0F, 3.0F, 0.0F, false);

		bone191 = new ModelRenderer(this);
		bone191.setRotationPoint(-8.0317F, -9.1028F, 16.2508F);
		bone189.addChild(bone191);
		bone191.setTextureOffset(29, 67).addBox(5.858F, 25.8791F, -17.3203F, 2.0F, 11.0F, 3.0F, 0.0F, false);
		bone191.setTextureOffset(29, 67).addBox(5.8734F, 35.8818F, -16.0856F, 2.0F, 4.0F, 4.0F, 0.0F, false);
		bone191.setTextureOffset(29, 67).addBox(6.3373F, 38.6151F, -13.5728F, 2.0F, 4.0F, 3.0F, 0.0F, false);
		bone191.setTextureOffset(29, 67).addBox(6.4824F, 40.4666F, -12.2309F, 2.0F, 4.0F, 3.0F, 0.0F, false);
		bone191.setTextureOffset(29, 67).addBox(6.6715F, 43.3258F, -10.1823F, 2.0F, 4.0F, 3.0F, 0.0F, false);

		bone192 = new ModelRenderer(this);
		bone192.setRotationPoint(-2.8329F, -11.2F, 15.881F);
		bone189.addChild(bone192);
		bone192.setTextureOffset(29, 67).addBox(5.858F, 25.8791F, -17.3203F, 2.0F, 11.0F, 3.0F, 0.0F, false);
		bone192.setTextureOffset(29, 67).addBox(5.8734F, 35.8818F, -16.0856F, 2.0F, 4.0F, 4.0F, 0.0F, false);
		bone192.setTextureOffset(29, 67).addBox(6.3373F, 38.6151F, -13.5728F, 2.0F, 4.0F, 3.0F, 0.0F, false);
		bone192.setTextureOffset(29, 67).addBox(6.4824F, 40.4666F, -12.2309F, 2.0F, 4.0F, 3.0F, 0.0F, false);
		bone192.setTextureOffset(29, 67).addBox(6.6715F, 43.3258F, -10.1823F, 2.0F, 4.0F, 3.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, -55.5F, -10.0F);
		Body.addChild(Head);
		setRotationAngle(Head, 0.1745F, 0.0F, 0.2618F);
		

		Head3 = new ModelRenderer(this);
		Head3.setRotationPoint(0.0F, 0.0F, 0.0F);
		Head.addChild(Head3);
		setRotationAngle(Head3, -1.1345F, 0.0F, 0.0F);
		Head3.setTextureOffset(65, 34).addBox(-5.0F, -3.4322F, -4.2661F, 9.0F, 7.0F, 10.0F, 0.0F, false);
		Head3.setTextureOffset(0, 0).addBox(-4.0F, -2.8441F, -1.2302F, 7.0F, 5.0F, 9.0F, 0.0F, false);
		Head3.setTextureOffset(74, 40).addBox(-4.0F, -1.6172F, -8.3878F, 7.0F, 4.0F, 5.0F, 0.0F, false);
		Head3.setTextureOffset(0, 0).addBox(2.25F, 2.2346F, -6.1839F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		Head3.setTextureOffset(0, 0).addBox(2.25F, 2.1595F, -7.5281F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		Head3.setTextureOffset(0, 0).addBox(1.0F, 2.0844F, -8.8723F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		Head3.setTextureOffset(0, 0).addBox(-2.0F, 2.0844F, -8.8723F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		Head3.setTextureOffset(0, 0).addBox(1.0F, 1.6771F, -10.3374F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		Head3.setTextureOffset(0, 0).addBox(-2.0F, 1.6771F, -10.3374F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		Head3.setTextureOffset(0, 0).addBox(1.0F, 1.4963F, -11.9082F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		Head3.setTextureOffset(0, 0).addBox(-2.0F, 1.4963F, -11.9082F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		Head3.setTextureOffset(0, 0).addBox(1.0F, 1.4212F, -13.2524F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		Head3.setTextureOffset(0, 0).addBox(-2.0F, 1.4212F, -13.2524F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		Head3.setTextureOffset(0, 0).addBox(1.0F, 1.346F, -14.5966F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		Head3.setTextureOffset(0, 0).addBox(-2.0F, 1.346F, -14.5966F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		Head3.setTextureOffset(0, 0).addBox(1.0F, 1.0596F, -16.3939F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		Head3.setTextureOffset(0, 0).addBox(-2.25F, 1.0596F, -16.3939F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		Head3.setTextureOffset(0, 0).addBox(0.75F, 0.8788F, -17.9647F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		Head3.setTextureOffset(0, 0).addBox(-2.0F, 0.8788F, -17.9647F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		Head3.setTextureOffset(0, 0).addBox(-3.75F, 2.2346F, -6.1839F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		Head3.setTextureOffset(0, 0).addBox(-3.75F, 2.1595F, -7.5281F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		Head3.setTextureOffset(9, 17).addBox(-6.0F, -1.3699F, -5.6395F, 11.0F, 1.0F, 4.0F, 0.0F, false);
		Head3.setTextureOffset(62, 9).addBox(-2.5F, -0.9808F, -15.3048F, 4.0F, 3.0F, 8.0F, 0.0F, false);
		Head3.setTextureOffset(0, 0).addBox(-1.5F, -1.6605F, -14.9878F, 2.0F, 3.0F, 8.0F, 0.0F, false);
		Head3.setTextureOffset(0, 0).addBox(-1.5F, -2.7794F, -10.8801F, 2.0F, 3.0F, 8.0F, 0.0F, false);

		bone162 = new ModelRenderer(this);
		bone162.setRotationPoint(4.75F, -3.6079F, 3.7739F);
		Head3.addChild(bone162);
		setRotationAngle(bone162, -0.2618F, 0.0F, 0.2618F);
		bone162.setTextureOffset(0, 0).addBox(-1.25F, -2.2469F, -0.9463F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		bone162.setTextureOffset(0, 0).addBox(0.5757F, -8.1929F, 0.0538F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		bone163 = new ModelRenderer(this);
		bone163.setRotationPoint(-0.6823F, -0.4723F, -0.6115F);
		bone162.addChild(bone163);
		setRotationAngle(bone163, 0.0F, 0.0F, 0.4363F);
		bone163.setTextureOffset(0, 0).addBox(-1.2224F, -3.3168F, -0.2867F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		bone164 = new ModelRenderer(this);
		bone164.setRotationPoint(-0.8513F, -2.206F, -0.3104F);
		bone162.addChild(bone164);
		setRotationAngle(bone164, 0.0F, 0.0F, 1.1345F);
		bone164.setTextureOffset(0, 0).addBox(-1.2224F, -5.3168F, -0.2867F, 1.0F, 4.0F, 2.0F, 0.0F, false);

		bone165 = new ModelRenderer(this);
		bone165.setRotationPoint(3.9783F, -3.456F, -0.6453F);
		bone162.addChild(bone165);
		setRotationAngle(bone165, 0.2618F, 0.0F, 1.309F);
		bone165.setTextureOffset(0, 0).addBox(-2.1748F, -4.5249F, -0.2035F, 1.0F, 5.0F, 2.0F, 0.0F, false);

		bone166 = new ModelRenderer(this);
		bone166.setRotationPoint(7.5772F, -4.2746F, -1.6777F);
		bone162.addChild(bone166);
		setRotationAngle(bone166, 0.7854F, -0.0873F, 1.3963F);
		bone166.setTextureOffset(0, 0).addBox(-2.1748F, -4.5249F, -0.2035F, 1.0F, 5.0F, 2.0F, 0.0F, false);

		bone182 = new ModelRenderer(this);
		bone182.setRotationPoint(-5.0F, 23.0F, -5.0F);
		bone166.addChild(bone182);
		setRotationAngle(bone182, 0.0F, -0.1745F, 0.0F);
		bone182.setTextureOffset(0, 0).addBox(0.5585F, -28.0713F, 3.9962F, 4.0F, 2.0F, 2.0F, 0.0F, false);
		bone182.setTextureOffset(0, 0).addBox(-5.2278F, -27.6291F, 4.6149F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		bone167 = new ModelRenderer(this);
		bone167.setRotationPoint(10.6775F, -4.5314F, -4.5298F);
		bone162.addChild(bone167);
		setRotationAngle(bone167, 1.2217F, -0.2618F, 1.3963F);
		bone167.setTextureOffset(0, 0).addBox(-2.1748F, -4.5249F, -0.2035F, 1.0F, 5.0F, 2.0F, 0.0F, false);

		bone168 = new ModelRenderer(this);
		bone168.setRotationPoint(11.9399F, -3.6919F, -8.1199F);
		bone162.addChild(bone168);
		setRotationAngle(bone168, 1.6581F, -0.2618F, 1.3963F);
		bone168.setTextureOffset(0, 0).addBox(-2.1748F, -4.5249F, -0.2035F, 1.0F, 5.0F, 2.0F, 0.0F, false);

		bone184 = new ModelRenderer(this);
		bone184.setRotationPoint(-2.1813F, 21.6806F, -5.9364F);
		bone168.addChild(bone184);
		setRotationAngle(bone184, 0.0F, -0.4363F, 0.0F);
		bone184.setTextureOffset(0, 0).addBox(-2.2774F, -27.0079F, 4.4198F, 5.0F, 2.0F, 2.0F, 0.0F, false);
		bone184.setTextureOffset(0, 0).addBox(-6.1855F, -26.557F, 5.0347F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		bone169 = new ModelRenderer(this);
		bone169.setRotationPoint(11.6988F, -2.5572F, -12.1001F);
		bone162.addChild(bone169);
		setRotationAngle(bone169, 2.1817F, -0.2618F, 1.3963F);
		bone169.setTextureOffset(0, 0).addBox(-2.1748F, -4.5249F, -0.2035F, 1.0F, 5.0F, 2.0F, 0.0F, false);

		bone170 = new ModelRenderer(this);
		bone170.setRotationPoint(9.732F, -1.3427F, -15.1364F);
		bone162.addChild(bone170);
		setRotationAngle(bone170, 2.7925F, -0.2618F, 1.3963F);
		bone170.setTextureOffset(0, 0).addBox(-2.1748F, -4.5249F, -0.2035F, 1.0F, 5.0F, 2.0F, 0.0F, false);

		bone186 = new ModelRenderer(this);
		bone186.setRotationPoint(-9.5837F, 22.9057F, -5.8908F);
		bone170.addChild(bone186);
		setRotationAngle(bone186, 0.0F, -0.1745F, 0.1745F);
		bone186.setTextureOffset(0, 0).addBox(-0.599F, -27.9086F, 5.6167F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		bone171 = new ModelRenderer(this);
		bone171.setRotationPoint(5.8215F, -0.1048F, -16.4309F);
		bone162.addChild(bone171);
		setRotationAngle(bone171, 3.0543F, -0.2618F, 1.3963F);
		bone171.setTextureOffset(0, 0).addBox(-2.1748F, -4.5249F, -0.2035F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		bone171.setTextureOffset(0, 0).addBox(-1.6666F, -6.8195F, 0.3608F, 0.0F, 3.0F, 1.0F, 0.0F, false);

		bone172 = new ModelRenderer(this);
		bone172.setRotationPoint(-4.75F, -4.0458F, 3.4264F);
		Head3.addChild(bone172);
		setRotationAngle(bone172, -0.2618F, 0.0F, -0.2618F);
		bone172.setTextureOffset(0, 0).addBox(-1.25F, -2.2469F, -0.9463F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		bone172.setTextureOffset(0, 0).addBox(-2.8254F, -8.0105F, -0.1003F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		bone173 = new ModelRenderer(this);
		bone173.setRotationPoint(0.7011F, -0.876F, -0.3915F);
		bone172.addChild(bone173);
		setRotationAngle(bone173, 0.0F, 0.0F, -0.4363F);
		bone173.setTextureOffset(0, 0).addBox(-1.4148F, -3.4755F, -0.3035F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		bone174 = new ModelRenderer(this);
		bone174.setRotationPoint(0.221F, -3.2921F, -0.5236F);
		bone172.addChild(bone174);
		setRotationAngle(bone174, 0.0F, 0.0F, -1.1345F);
		bone174.setTextureOffset(0, 0).addBox(-1.1769F, -5.0716F, -0.27F, 1.0F, 4.0F, 2.0F, 0.0F, false);

		bone175 = new ModelRenderer(this);
		bone175.setRotationPoint(-4.0835F, -6.2573F, -0.8332F);
		bone172.addChild(bone175);
		setRotationAngle(bone175, 0.2618F, 0.0F, -1.309F);
		bone175.setTextureOffset(0, 0).addBox(-2.1748F, -4.5249F, -0.2035F, 1.0F, 5.0F, 2.0F, 0.0F, false);

		bone176 = new ModelRenderer(this);
		bone176.setRotationPoint(-7.9215F, -7.3361F, -1.8879F);
		bone172.addChild(bone176);
		setRotationAngle(bone176, 0.7854F, 0.0873F, -1.3963F);
		bone176.setTextureOffset(0, 0).addBox(-2.1748F, -4.5249F, -0.2035F, 1.0F, 5.0F, 2.0F, 0.0F, false);

		bone183 = new ModelRenderer(this);
		bone183.setRotationPoint(1.0477F, -0.6037F, -0.8142F);
		bone176.addChild(bone183);
		setRotationAngle(bone183, 0.0F, 0.1745F, 0.0F);
		bone183.setTextureOffset(0, 0).addBox(-2.2435F, -4.7238F, -0.5221F, 4.0F, 2.0F, 2.0F, 0.0F, false);
		bone183.setTextureOffset(0, 0).addBox(1.1468F, -4.3962F, 0.0226F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		bone177 = new ModelRenderer(this);
		bone177.setRotationPoint(14.6842F, -2.4506F, -2.8929F);
		bone172.addChild(bone177);
		setRotationAngle(bone177, 1.2217F, 0.2618F, -1.3963F);
		bone177.setTextureOffset(0, 0).addBox(-1.3173F, -15.2498F, 23.4911F, 1.0F, 5.0F, 2.0F, 0.0F, false);

		bone178 = new ModelRenderer(this);
		bone178.setRotationPoint(-11.9381F, -7.1447F, -9.2006F);
		bone172.addChild(bone178);
		setRotationAngle(bone178, 1.6581F, 0.2618F, -1.3963F);
		bone178.setTextureOffset(0, 0).addBox(-3.0392F, -4.3781F, 0.1224F, 1.0F, 5.0F, 2.0F, 0.0F, false);

		bone185 = new ModelRenderer(this);
		bone185.setRotationPoint(-0.5435F, -0.2535F, -0.9436F);
		bone178.addChild(bone185);
		setRotationAngle(bone185, 0.0F, 0.4363F, 0.0F);
		bone185.setTextureOffset(0, 0).addBox(1.3381F, -3.4884F, 0.6185F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		bone185.setTextureOffset(0, 0).addBox(-2.1764F, -4.1035F, -0.0484F, 5.0F, 2.0F, 2.0F, 0.0F, false);

		bone179 = new ModelRenderer(this);
		bone179.setRotationPoint(-12.4138F, -5.055F, -13.3624F);
		bone172.addChild(bone179);
		setRotationAngle(bone179, 2.1817F, 0.2618F, -1.3963F);
		bone179.setTextureOffset(0, 0).addBox(-2.1617F, -4.0539F, -0.5044F, 1.0F, 5.0F, 2.0F, 0.0F, false);

		bone180 = new ModelRenderer(this);
		bone180.setRotationPoint(-10.2237F, -4.0342F, -15.9038F);
		bone172.addChild(bone180);
		setRotationAngle(bone180, 2.7925F, 0.2618F, -1.3963F);
		bone180.setTextureOffset(0, 0).addBox(-2.1748F, -4.5249F, -0.2035F, 1.0F, 5.0F, 2.0F, 0.0F, false);

		bone187 = new ModelRenderer(this);
		bone187.setRotationPoint(-1.2165F, 24.7883F, -3.6821F);
		bone180.addChild(bone187);
		setRotationAngle(bone187, 0.0F, 0.1745F, -0.1745F);
		bone187.setTextureOffset(0, 0).addBox(3.9716F, -28.2161F, 5.2425F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		bone181 = new ModelRenderer(this);
		bone181.setRotationPoint(-6.1284F, -2.6898F, -17.3423F);
		bone172.addChild(bone181);
		setRotationAngle(bone181, 3.0543F, 0.2618F, -1.3963F);
		bone181.setTextureOffset(0, 0).addBox(-2.1748F, -4.5249F, -0.2035F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		bone181.setTextureOffset(0, 0).addBox(-1.6666F, -6.8195F, 0.3608F, 0.0F, 3.0F, 1.0F, 0.0F, false);

		bone161 = new ModelRenderer(this);
		bone161.setRotationPoint(7.0F, -1.0F, -3.25F);
		Head3.addChild(bone161);
		bone161.setTextureOffset(0, 0).addBox(-4.0F, -1.1487F, -3.0247F, 2.0F, 0.0F, 6.0F, 0.0F, false);
		bone161.setTextureOffset(0, 0).addBox(-13.25F, -1.1487F, -3.0247F, 2.0F, 0.0F, 6.0F, 0.0F, false);
		bone161.setTextureOffset(0, 0).addBox(-4.0F, -0.8491F, -3.5616F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		bone161.setTextureOffset(0, 0).addBox(-13.25F, -0.8491F, -3.5616F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		bone161.setTextureOffset(0, 0).addBox(-4.0F, -0.8961F, 2.253F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		bone161.setTextureOffset(0, 0).addBox(-13.25F, -0.8961F, 2.253F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		bone161.setTextureOffset(0, 0).addBox(-4.25F, -0.3807F, -4.3317F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		bone161.setTextureOffset(0, 0).addBox(-12.75F, -0.3807F, -4.3317F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		bone161.setTextureOffset(0, 0).addBox(-4.25F, -0.5792F, 2.9328F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		bone161.setTextureOffset(0, 0).addBox(-13.25F, -0.5792F, 2.9328F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		bone161.setTextureOffset(0, 0).addBox(-4.75F, -0.3654F, -4.8905F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		bone161.setTextureOffset(0, 0).addBox(-12.25F, -0.3654F, -4.8905F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		bone161.setTextureOffset(0, 0).addBox(-4.5F, -0.4888F, 3.7182F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		bone161.setTextureOffset(0, 0).addBox(-13.0F, -0.4888F, 3.7182F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		bone161.setTextureOffset(0, 0).addBox(-4.0F, 1.6301F, -3.3895F, 2.0F, 0.0F, 6.0F, 0.0F, false);
		bone161.setTextureOffset(0, 0).addBox(-13.25F, 1.6301F, -3.3895F, 2.0F, 0.0F, 6.0F, 0.0F, false);

		bone158 = new ModelRenderer(this);
		bone158.setRotationPoint(0.0F, 15.6191F, -10.5005F);
		Head3.addChild(bone158);
		setRotationAngle(bone158, 0.1745F, 0.0F, 0.0F);
		bone158.setTextureOffset(0, 0).addBox(-0.75F, -16.6251F, -5.1264F, 1.0F, 2.0F, 3.0F, 0.0F, false);
		bone158.setTextureOffset(0, 0).addBox(-2.0313F, -16.2159F, -6.4648F, 3.0F, 1.0F, 2.0F, 0.0F, false);
		bone158.setTextureOffset(114, 11).addBox(-1.75F, -16.9287F, -3.0036F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		bone159 = new ModelRenderer(this);
		bone159.setRotationPoint(2.25F, 15.6191F, -10.5005F);
		Head3.addChild(bone159);
		setRotationAngle(bone159, 0.1745F, 0.1745F, 0.0F);
		bone159.setTextureOffset(142, 40).addBox(0.156F, -16.6132F, -6.0591F, 0.0F, 2.0F, 4.0F, 0.0F, false);

		bone160 = new ModelRenderer(this);
		bone160.setRotationPoint(0.0F, 15.5885F, -9.3828F);
		Head3.addChild(bone160);
		setRotationAngle(bone160, 0.1745F, -0.1745F, 0.0F);
		bone160.setTextureOffset(123, 24).addBox(-3.4873F, -16.7075F, -6.5935F, 0.0F, 2.0F, 4.0F, 0.0F, false);

		middlebody = new ModelRenderer(this);
		middlebody.setRotationPoint(0.0F, 0.0F, 0.0F);
		UpperBody2.addChild(middlebody);
		middlebody.setTextureOffset(4, 140).addBox(-3.5F, -9.0F, 0.0F, 6.0F, 3.0F, 2.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, -9.0F, 0.0F);
		middlebody.addChild(bone);
		setRotationAngle(bone, -0.0873F, 0.0F, 0.0F);
		bone.setTextureOffset(4, 140).addBox(-2.5F, -3.0F, 0.0F, 4.0F, 3.0F, 2.0F, 0.0F, false);

		bone17 = new ModelRenderer(this);
		bone17.setRotationPoint(0.0F, -3.5F, 0.25F);
		middlebody.addChild(bone17);
		setRotationAngle(bone17, 0.0873F, 0.0F, 0.0F);
		bone17.setTextureOffset(4, 140).addBox(-2.5F, -3.0F, 0.0F, 4.0F, 3.0F, 2.0F, 0.0F, false);

		bone18 = new ModelRenderer(this);
		bone18.setRotationPoint(0.0F, -0.75F, 1.0F);
		middlebody.addChild(bone18);
		setRotationAngle(bone18, 0.2618F, 0.0F, 0.0F);
		bone18.setTextureOffset(4, 140).addBox(-2.0F, -3.0F, 0.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		bone19 = new ModelRenderer(this);
		bone19.setRotationPoint(0.0F, 2.25F, 1.75F);
		middlebody.addChild(bone19);
		setRotationAngle(bone19, 0.2618F, 0.0F, 0.0F);
		bone19.setTextureOffset(4, 140).addBox(-2.0F, -3.0F, 0.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		bone23 = new ModelRenderer(this);
		bone23.setRotationPoint(0.0F, -1.75F, -3.25F);
		middlebody.addChild(bone23);
		bone23.setTextureOffset(12, 105).addBox(-8.75F, -3.0F, 1.5F, 16.0F, 7.0F, 2.0F, 0.0F, false);
		bone23.setTextureOffset(7, 106).addBox(-8.75F, -1.0F, -1.5F, 16.0F, 9.0F, 3.0F, 0.0F, false);
		bone23.setTextureOffset(12, 116).addBox(6.25F, -4.25F, 2.75F, 4.0F, 5.0F, 2.0F, 0.0F, false);
		bone23.setTextureOffset(7, 118).addBox(-11.75F, -4.25F, 2.75F, 4.0F, 5.0F, 2.0F, 0.0F, false);
		bone23.setTextureOffset(11, 112).addBox(8.5F, -1.0F, 2.75F, 4.0F, 5.0F, 2.0F, 0.0F, false);
		bone23.setTextureOffset(6, 111).addBox(-13.75F, -1.0F, 2.75F, 4.0F, 5.0F, 2.0F, 0.0F, false);
		bone23.setTextureOffset(10, 103).addBox(-10.0F, -3.0F, 2.75F, 19.0F, 7.0F, 2.0F, 0.0F, false);

		bone20 = new ModelRenderer(this);
		bone20.setRotationPoint(0.0F, 5.25F, 2.75F);
		middlebody.addChild(bone20);
		setRotationAngle(bone20, 0.3491F, 0.0F, 0.0F);
		bone20.setTextureOffset(4, 140).addBox(-2.0F, -3.0F, 0.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		bone21 = new ModelRenderer(this);
		bone21.setRotationPoint(0.0F, 7.75F, 4.25F);
		middlebody.addChild(bone21);
		setRotationAngle(bone21, 0.4363F, 0.0F, 0.0F);
		bone21.setTextureOffset(4, 140).addBox(-1.5F, -3.0855F, -0.2349F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		bone22 = new ModelRenderer(this);
		bone22.setRotationPoint(0.0F, 9.75F, 4.75F);
		middlebody.addChild(bone22);
		setRotationAngle(bone22, 0.4363F, 0.0F, 0.0F);
		bone22.setTextureOffset(4, 140).addBox(-1.5F, -3.0855F, 0.7651F, 2.0F, 3.0F, 1.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, -12.0F, 0.25F);
		middlebody.addChild(bone2);
		setRotationAngle(bone2, -0.2618F, 0.0F, 0.0F);
		bone2.setTextureOffset(4, 140).addBox(-2.0F, -3.0F, 0.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, -14.5F, 1.0F);
		middlebody.addChild(bone3);
		setRotationAngle(bone3, -0.3491F, 0.0F, 0.0F);
		bone3.setTextureOffset(4, 140).addBox(-2.5F, -3.0F, 0.0F, 4.0F, 3.0F, 2.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(0.0F, -17.25F, 2.0F);
		middlebody.addChild(bone4);
		setRotationAngle(bone4, -0.4363F, 0.0F, 0.0F);
		bone4.setTextureOffset(4, 140).addBox(-2.0F, -3.0F, 0.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
		bone4.setTextureOffset(4, 140).addBox(-2.0F, -5.794F, 0.0763F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(0.0F, -22.25F, 4.5F);
		middlebody.addChild(bone5);
		setRotationAngle(bone5, -0.5236F, 0.0F, 0.0F);
		bone5.setTextureOffset(4, 140).addBox(-2.0F, -3.0F, 0.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

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
		LeftLeg3.setTextureOffset(4, 58).addBox(-4.25F, -3.703F, -1.3814F, 5.0F, 50.0F, 10.0F, 0.0F, false);
		LeftLeg3.setTextureOffset(4, 58).addBox(-4.25F, -0.4453F, -2.3925F, 3.0F, 5.0F, 2.0F, 0.0F, false);
		LeftLeg3.setTextureOffset(4, 58).addBox(-8.5F, -3.703F, -1.3814F, 11.0F, 23.0F, 10.0F, 0.0F, false);
		LeftLeg3.setTextureOffset(4, 58).addBox(-6.75F, 12.3129F, -1.1539F, 9.0F, 25.0F, 10.0F, 0.0F, false);
		LeftLeg3.setTextureOffset(4, 58).addBox(-5.5F, 34.9592F, 0.4827F, 8.0F, 14.0F, 12.0F, 0.0F, false);
		LeftLeg3.setTextureOffset(3, 142).addBox(-6.0F, 46.3863F, 10.7568F, 9.0F, 3.0F, 2.0F, 0.0F, false);
		LeftLeg3.setTextureOffset(13, 149).addBox(-4.75F, 46.9401F, 4.7356F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		LeftLeg3.setTextureOffset(24, 139).addBox(-1.5F, 46.8993F, 3.4862F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		bone198 = new ModelRenderer(this);
		bone198.setRotationPoint(-1.75F, 42.75F, -1.4142F);
		LeftLeg3.addChild(bone198);
		setRotationAngle(bone198, -0.7854F, 0.0F, 0.0F);
		bone198.setTextureOffset(4, 58).addBox(-2.5F, -53.703F, -1.3814F, 5.0F, 50.0F, 11.0F, 0.0F, false);
		bone198.setTextureOffset(4, 58).addBox(-3.5F, -57.0048F, -2.8301F, 8.0F, 11.0F, 11.0F, 0.0F, false);

		bone199 = new ModelRenderer(this);
		bone199.setRotationPoint(-1.75F, 64.6787F, 43.5442F);
		LeftLeg3.addChild(bone199);
		setRotationAngle(bone199, 0.1745F, 0.0F, 0.0F);
		bone199.setTextureOffset(182, 49).addBox(-2.5F, -53.703F, -1.3814F, 5.0F, 74.0F, 10.0F, 0.0F, false);

		bone200 = new ModelRenderer(this);
		bone200.setRotationPoint(-3.4734F, 86.7992F, 11.423F);
		LeftLeg3.addChild(bone200);
		setRotationAngle(bone200, 0.6981F, 0.0F, 0.1745F);
		bone200.setTextureOffset(7, 150).addBox(-4.0F, 18.9276F, 25.6435F, 10.0F, 8.0F, 10.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-6.25F, 3.75F, -4.75F);
		LowerBody.addChild(RightLeg);
		

		RightLeg3 = new ModelRenderer(this);
		RightLeg3.setRotationPoint(0.0F, 0.0F, 0.0F);
		RightLeg.addChild(RightLeg3);
		setRotationAngle(RightLeg3, -0.6109F, 0.0F, 0.1745F);
		RightLeg3.setTextureOffset(92, 64).addBox(-4.25F, -3.703F, -1.3814F, 5.0F, 50.0F, 10.0F, 0.0F, false);
		RightLeg3.setTextureOffset(92, 64).addBox(-2.7728F, -0.6587F, -2.5419F, 3.0F, 5.0F, 2.0F, 0.0F, false);
		RightLeg3.setTextureOffset(92, 64).addBox(-6.5304F, -3.9875F, -1.5806F, 11.0F, 23.0F, 10.0F, 0.0F, false);
		RightLeg3.setTextureOffset(92, 64).addBox(-6.0114F, 12.2062F, -1.2286F, 9.0F, 25.0F, 10.0F, 0.0F, false);
		RightLeg3.setTextureOffset(92, 64).addBox(-5.9924F, 35.0303F, 0.5325F, 8.0F, 14.0F, 12.0F, 0.0F, false);
		RightLeg3.setTextureOffset(7, 145).addBox(-6.2462F, 46.4219F, 10.7817F, 9.0F, 3.0F, 2.0F, 0.0F, false);
		RightLeg3.setTextureOffset(40, 159).addBox(-4.9236F, 47.1372F, 2.7372F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		RightLeg3.setTextureOffset(56, 155).addBox(-1.1961F, 47.0205F, 6.3178F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		bone201 = new ModelRenderer(this);
		bone201.setRotationPoint(-1.75F, 42.75F, -1.4142F);
		RightLeg3.addChild(bone201);
		setRotationAngle(bone201, -0.7854F, 0.0F, 0.0F);
		bone201.setTextureOffset(92, 64).addBox(-2.5F, -53.703F, -1.3814F, 5.0F, 50.0F, 11.0F, 0.0F, false);
		bone201.setTextureOffset(92, 64).addBox(-3.9924F, -56.9897F, -2.7446F, 8.0F, 11.0F, 11.0F, 0.0F, false);

		bone202 = new ModelRenderer(this);
		bone202.setRotationPoint(-1.75F, 64.6787F, 43.5442F);
		RightLeg3.addChild(bone202);
		setRotationAngle(bone202, 0.1745F, 0.0F, 0.0F);
		bone202.setTextureOffset(185, 49).addBox(-2.5F, -53.703F, -1.3814F, 5.0F, 74.0F, 10.0F, 0.0F, false);

		bone203 = new ModelRenderer(this);
		bone203.setRotationPoint(-1.75F, 87.0481F, 11.5973F);
		RightLeg3.addChild(bone203);
		setRotationAngle(bone203, 0.6981F, 0.0F, -0.1745F);
		bone203.setTextureOffset(10, 142).addBox(-4.0F, 18.9276F, 25.6435F, 10.0F, 8.0F, 10.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Hollow.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}*/