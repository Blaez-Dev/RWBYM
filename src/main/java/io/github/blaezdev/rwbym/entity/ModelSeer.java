package io.github.blaezdev.rwbym.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSeer extends ModelBase {
	private final ModelRenderer Head;
	private final ModelRenderer bone26;
	private final ModelRenderer bone27;
	private final ModelRenderer bone28;
	private final ModelRenderer bone29;
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
	private final ModelRenderer bone57;
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
	private final ModelRenderer bone2;
	private final ModelRenderer bone3;
	private final ModelRenderer bone4;
	private final ModelRenderer bone14;
	private final ModelRenderer bone15;
	private final ModelRenderer bone16;
	private final ModelRenderer bone17;
	private final ModelRenderer bone18;
	private final ModelRenderer bone19;
	private final ModelRenderer bone23;
	private final ModelRenderer bone24;
	private final ModelRenderer bone25;
	private final ModelRenderer bone20;
	private final ModelRenderer bone21;
	private final ModelRenderer bone22;
	private final ModelRenderer bone8;
	private final ModelRenderer bone9;
	private final ModelRenderer bone10;
	private final ModelRenderer bone11;
	private final ModelRenderer bone12;
	private final ModelRenderer bone13;
	private final ModelRenderer bone5;
	private final ModelRenderer bone6;
	private final ModelRenderer bone7;
	private final ModelRenderer body;
	private final ModelRenderer bone59;
	private final ModelRenderer bone60;
	private final ModelRenderer bone61;
	private final ModelRenderer bone62;
	private final ModelRenderer bone63;
	private final ModelRenderer bone64;
	private final ModelRenderer bone65;
	private final ModelRenderer bone66;
	private final ModelRenderer bone67;
	private final ModelRenderer bone58;
	private final ModelRenderer bone68;
	private final ModelRenderer bone69;
	private final ModelRenderer bone70;
	private final ModelRenderer bone71;
	private final ModelRenderer bone72;
	private final ModelRenderer bone73;
	private final ModelRenderer bone74;
	private final ModelRenderer bone75;
	private final ModelRenderer bone76;
	private final ModelRenderer bone77;
	private final ModelRenderer bone78;
	private final ModelRenderer bone79;
	private final ModelRenderer bone80;
	private final ModelRenderer bone81;
	private final ModelRenderer bone82;
	private final ModelRenderer bone83;
	private final ModelRenderer bone84;
	private final ModelRenderer bone85;
	private final ModelRenderer Leg1;
	private final ModelRenderer bone86;
	private final ModelRenderer bone87;
	private final ModelRenderer LEg2;
	private final ModelRenderer bone89;
	private final ModelRenderer bone90;
	private final ModelRenderer Leg3;
	private final ModelRenderer bone92;
	private final ModelRenderer bone93;
	private final ModelRenderer Leg4;
	private final ModelRenderer bone95;
	private final ModelRenderer bone96;
	private final ModelRenderer Leg5;
	private final ModelRenderer bone98;
	private final ModelRenderer bone99;
	private final ModelRenderer Leg6;
	private final ModelRenderer bone101;
	private final ModelRenderer bone102;

	public ModelSeer() {
		textureWidth = 512;
		textureHeight = 512;

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, -253.0F, 0.0F);
		Head.cubeList.add(new ModelBox(Head, 231, 85, -6.0F, -12.0F, -6.0F, 12, 12, 12, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 433, 203, -6.0F, 0.0F, -6.0F, 12, 12, 12, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 229, 193, -4.0F, 12.0F, -6.0F, 8, 12, 12, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 98, 400, -6.0F, -12.0F, -18.0F, 12, 12, 12, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 81, 379, -6.0F, -12.0F, -30.0F, 12, 12, 12, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 103, 350, -6.0F, -12.0F, 6.0F, 12, 12, 12, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 100, 378, -6.0F, -12.0F, 18.0F, 12, 12, 12, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 71, 398, -22.0F, -24.0F, -19.0F, 42, 12, 39, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 206, 433, -30.0F, -43.0F, -31.0F, 60, 19, 61, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 49, 64, -28.25F, -34.0F, -33.0F, 8, 10, 4, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 129, 69, -15.25F, -34.0F, -33.0F, 6, 5, 4, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 71, 75, -10.25F, -42.0F, -32.0F, 6, 5, 4, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 2, 11, -32.25F, -38.0F, -20.75F, 8, 10, 8, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 72, 78, -32.25F, -40.0F, 7.25F, 8, 10, 8, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 93, 56, -32.25F, -34.0F, 20.25F, 8, 8, 7, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 74, 61, -17.25F, -41.0F, 25.25F, 8, 8, 7, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 87, 62, 9.75F, -36.0F, 25.75F, 5, 7, 7, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 98, 66, 2.75F, -46.0F, 22.75F, 2, 2, 6, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 104, 81, 17.75F, -33.0F, 24.75F, 8, 8, 7, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 123, 84, 23.75F, -38.0F, 18.75F, 8, 4, 5, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 103, 62, 23.75F, -31.0F, 20.75F, 8, 6, 7, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 98, 42, 23.75F, -39.0F, -14.25F, 8, 6, 7, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 132, 61, 23.75F, -46.0F, 0.75F, 5, 3, 4, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 112, 55, 23.75F, -49.0F, -4.25F, 5, 2, 2, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 101, 48, 23.75F, -31.0F, -25.25F, 8, 6, 9, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 23, 8, 5.75F, -41.0F, -32.25F, 8, 6, 9, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 84, 66, 17.75F, -36.0F, -32.25F, 8, 6, 9, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 46, 50, 11.75F, -23.0F, -26.25F, 6, 5, 9, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 103, 50, 17.75F, -22.0F, -23.25F, 8, 6, 7, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 119, 56, 18.75F, -23.0F, 17.75F, 8, 4, 5, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 117, 64, 12.75F, -23.0F, 20.75F, 8, 4, 5, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 96, 78, -27.25F, -32.0F, 25.0F, 7, 7, 7, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 94, 65, -20.25F, -24.0F, 18.25F, 8, 6, 7, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 109, 82, -25.25F, -24.0F, 12.5F, 8, 6, 7, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 59, 29, -26.25F, -28.0F, -29.75F, 3, 10, 10, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 104, 33, -17.25F, -28.0F, -27.25F, 8, 10, 3, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 81, 43, -28.25F, -29.0F, -14.25F, 8, 10, 4, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 208, 391, -24.0F, -36.0F, -25.0F, 49, 19, 49, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 219, 424, -28.0F, -54.0F, -29.0F, 55, 11, 56, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 241, 400, -20.75F, -62.0F, -23.0F, 43, 17, 45, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 229, 413, -18.0F, -67.0F, -20.25F, 37, 17, 40, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 119, 413, -18.0F, -12.0F, -6.0F, 12, 12, 12, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 85, 375, -30.0F, -12.0F, -6.0F, 12, 12, 12, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 75, 489, 6.0F, -12.0F, -6.0F, 12, 12, 12, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 64, 411, 17.0F, -12.0F, -6.0F, 12, 12, 12, 0.0F, false));

		bone26 = new ModelRenderer(this);
		bone26.setRotationPoint(1.5F, 9.0F, -23.0F);
		Head.addChild(bone26);
		setRotationAngle(bone26, -0.4363F, 0.0F, 0.0F);
		bone26.cubeList.add(new ModelBox(bone26, 107, 53, -6.0F, -9.0F, -11.0F, 9, 9, 9, 0.0F, false));

		bone27 = new ModelRenderer(this);
		bone27.setRotationPoint(0.0F, -0.9848F, -0.1736F);
		bone26.addChild(bone27);
		setRotationAngle(bone27, 0.1745F, 0.0F, 0.0F);
		bone27.cubeList.add(new ModelBox(bone27, 62, 45, -5.0F, -1.1215F, -10.6108F, 7, 9, 8, 0.0F, false));

		bone28 = new ModelRenderer(this);
		bone28.setRotationPoint(0.0F, 5.9088F, 1.0419F);
		bone26.addChild(bone28);
		setRotationAngle(bone28, 0.3491F, 0.0F, 0.0F);
		bone28.cubeList.add(new ModelBox(bone28, 80, 39, -4.0F, -1.1215F, -9.6108F, 5, 5, 6, 0.0F, false));

		bone29 = new ModelRenderer(this);
		bone29.setRotationPoint(0.0F, 9.6744F, 2.7213F);
		bone26.addChild(bone29);
		setRotationAngle(bone29, 0.3491F, 0.0F, 0.0F);
		bone29.cubeList.add(new ModelBox(bone29, 103, 46, -3.0F, -1.1215F, -8.6108F, 3, 5, 4, 0.0F, false));

		bone46 = new ModelRenderer(this);
		bone46.setRotationPoint(-17.0F, 9.0F, -17.75F);
		Head.addChild(bone46);
		setRotationAngle(bone46, -0.4363F, 0.6981F, 0.0F);
		bone46.cubeList.add(new ModelBox(bone46, 125, 62, -6.0F, -9.0F, -11.0F, 9, 9, 9, 0.0F, false));

		bone47 = new ModelRenderer(this);
		bone47.setRotationPoint(0.0F, -0.9848F, -0.1736F);
		bone46.addChild(bone47);
		setRotationAngle(bone47, 0.1745F, 0.0F, 0.0F);
		bone47.cubeList.add(new ModelBox(bone47, 149, 71, -5.0F, -1.1215F, -10.6108F, 7, 9, 8, 0.0F, false));

		bone48 = new ModelRenderer(this);
		bone48.setRotationPoint(0.0F, 5.9088F, 1.0419F);
		bone46.addChild(bone48);
		setRotationAngle(bone48, 0.3491F, 0.0F, 0.0F);
		bone48.cubeList.add(new ModelBox(bone48, 125, 74, -4.0F, -1.1215F, -9.6108F, 5, 5, 6, 0.0F, false));

		bone49 = new ModelRenderer(this);
		bone49.setRotationPoint(0.0F, 9.6744F, 2.7213F);
		bone46.addChild(bone49);
		setRotationAngle(bone49, 0.3491F, 0.0F, 0.0F);
		bone49.cubeList.add(new ModelBox(bone49, 152, 87, -3.0F, -1.1215F, -8.6108F, 3, 5, 4, 0.0F, false));

		bone50 = new ModelRenderer(this);
		bone50.setRotationPoint(-25.0F, 9.0F, -1.25F);
		Head.addChild(bone50);
		setRotationAngle(bone50, -0.5236F, 1.5708F, 0.0F);
		bone50.cubeList.add(new ModelBox(bone50, 75, 104, -6.0F, -9.0F, -11.0F, 9, 9, 9, 0.0F, false));

		bone51 = new ModelRenderer(this);
		bone51.setRotationPoint(0.0F, -0.9848F, -0.1736F);
		bone50.addChild(bone51);
		setRotationAngle(bone51, 0.1745F, 0.0F, 0.0F);
		bone51.cubeList.add(new ModelBox(bone51, 84, 77, -5.0F, -1.1215F, -10.6108F, 7, 9, 8, 0.0F, false));

		bone52 = new ModelRenderer(this);
		bone52.setRotationPoint(0.0F, 5.9088F, 1.0419F);
		bone50.addChild(bone52);
		setRotationAngle(bone52, 0.3491F, 0.0F, 0.0F);
		bone52.cubeList.add(new ModelBox(bone52, 62, 71, -4.0F, -1.1215F, -9.6108F, 5, 5, 6, 0.0F, false));

		bone53 = new ModelRenderer(this);
		bone53.setRotationPoint(0.0F, 9.6744F, 2.7213F);
		bone50.addChild(bone53);
		setRotationAngle(bone53, 0.3491F, 0.0F, 0.0F);
		bone53.cubeList.add(new ModelBox(bone53, 128, 75, -3.0F, -1.1215F, -8.6108F, 3, 5, 4, 0.0F, false));

		bone54 = new ModelRenderer(this);
		bone54.setRotationPoint(-18.75F, 9.0F, 17.75F);
		Head.addChild(bone54);
		setRotationAngle(bone54, -0.5236F, 2.2689F, 0.0F);
		bone54.cubeList.add(new ModelBox(bone54, 74, 69, -6.0F, -9.0F, -11.0F, 9, 9, 9, 0.0F, false));

		bone55 = new ModelRenderer(this);
		bone55.setRotationPoint(0.0F, -0.9848F, -0.1736F);
		bone54.addChild(bone55);
		setRotationAngle(bone55, 0.1745F, 0.0F, 0.0F);
		bone55.cubeList.add(new ModelBox(bone55, 75, 55, -5.0F, -1.1215F, -10.6108F, 7, 9, 8, 0.0F, false));

		bone56 = new ModelRenderer(this);
		bone56.setRotationPoint(0.0F, 5.9088F, 1.0419F);
		bone54.addChild(bone56);
		setRotationAngle(bone56, 0.3491F, 0.0F, 0.0F);
		bone56.cubeList.add(new ModelBox(bone56, 136, 53, -4.0F, -1.1215F, -9.6108F, 5, 5, 6, 0.0F, false));

		bone57 = new ModelRenderer(this);
		bone57.setRotationPoint(0.0F, 9.6744F, 2.7213F);
		bone54.addChild(bone57);
		setRotationAngle(bone57, 0.3491F, 0.0F, 0.0F);
		bone57.cubeList.add(new ModelBox(bone57, 139, 65, -3.0F, -1.1215F, -8.6108F, 3, 5, 4, 0.0F, false));

		bone30 = new ModelRenderer(this);
		bone30.setRotationPoint(16.25F, 9.0F, -15.5F);
		Head.addChild(bone30);
		setRotationAngle(bone30, -0.4363F, -0.8727F, 0.0F);
		bone30.cubeList.add(new ModelBox(bone30, 136, 74, -6.0F, -9.0F, -11.0F, 9, 9, 9, 0.0F, false));

		bone31 = new ModelRenderer(this);
		bone31.setRotationPoint(0.0F, -0.9848F, -0.1736F);
		bone30.addChild(bone31);
		setRotationAngle(bone31, 0.1745F, 0.0F, 0.0F);
		bone31.cubeList.add(new ModelBox(bone31, 93, 81, -5.0F, -1.1215F, -10.6108F, 7, 9, 8, 0.0F, false));

		bone32 = new ModelRenderer(this);
		bone32.setRotationPoint(0.0F, 5.9088F, 1.0419F);
		bone30.addChild(bone32);
		setRotationAngle(bone32, 0.3491F, 0.0F, 0.0F);
		bone32.cubeList.add(new ModelBox(bone32, 136, 85, -4.0F, -1.1215F, -9.6108F, 5, 5, 6, 0.0F, false));

		bone33 = new ModelRenderer(this);
		bone33.setRotationPoint(0.0F, 9.6744F, 2.7213F);
		bone30.addChild(bone33);
		setRotationAngle(bone33, 0.3491F, 0.0F, 0.0F);
		bone33.cubeList.add(new ModelBox(bone33, 101, 91, -3.0F, -1.1215F, -8.6108F, 3, 5, 4, 0.0F, false));

		bone34 = new ModelRenderer(this);
		bone34.setRotationPoint(22.0F, 9.0F, 1.5F);
		Head.addChild(bone34);
		setRotationAngle(bone34, -0.4363F, -1.5708F, 0.0F);
		bone34.cubeList.add(new ModelBox(bone34, 107, 81, -6.0F, -9.0F, -11.0F, 9, 9, 9, 0.0F, false));

		bone35 = new ModelRenderer(this);
		bone35.setRotationPoint(0.0F, -0.9848F, -0.1736F);
		bone34.addChild(bone35);
		setRotationAngle(bone35, 0.1745F, 0.0F, 0.0F);
		bone35.cubeList.add(new ModelBox(bone35, 139, 61, -5.0F, -1.1215F, -10.6108F, 7, 9, 8, 0.0F, false));

		bone36 = new ModelRenderer(this);
		bone36.setRotationPoint(0.0F, 5.9088F, 1.0419F);
		bone34.addChild(bone36);
		setRotationAngle(bone36, 0.3491F, 0.0F, 0.0F);
		bone36.cubeList.add(new ModelBox(bone36, 94, 52, -4.0F, -1.1215F, -9.6108F, 5, 5, 6, 0.0F, false));

		bone37 = new ModelRenderer(this);
		bone37.setRotationPoint(0.0F, 9.6744F, 2.7213F);
		bone34.addChild(bone37);
		setRotationAngle(bone37, 0.3491F, 0.0F, 0.0F);
		bone37.cubeList.add(new ModelBox(bone37, 117, 82, -3.0F, -1.1215F, -8.6108F, 3, 5, 4, 0.0F, false));

		bone38 = new ModelRenderer(this);
		bone38.setRotationPoint(15.25F, 9.0F, 17.75F);
		Head.addChild(bone38);
		setRotationAngle(bone38, -0.4363F, -2.3562F, 0.0F);
		bone38.cubeList.add(new ModelBox(bone38, 103, 65, -6.0F, -9.0F, -11.0F, 9, 9, 9, 0.0F, false));

		bone39 = new ModelRenderer(this);
		bone39.setRotationPoint(0.0F, -0.9848F, -0.1736F);
		bone38.addChild(bone39);
		setRotationAngle(bone39, 0.1745F, 0.0F, 0.0F);
		bone39.cubeList.add(new ModelBox(bone39, 128, 52, -5.0F, -1.1215F, -10.6108F, 7, 9, 8, 0.0F, false));

		bone40 = new ModelRenderer(this);
		bone40.setRotationPoint(0.0F, 5.9088F, 1.0419F);
		bone38.addChild(bone40);
		setRotationAngle(bone40, 0.3491F, 0.0F, 0.0F);
		bone40.cubeList.add(new ModelBox(bone40, 141, 75, -4.0F, -1.1215F, -9.6108F, 5, 5, 6, 0.0F, false));

		bone41 = new ModelRenderer(this);
		bone41.setRotationPoint(0.0F, 9.6744F, 2.7213F);
		bone38.addChild(bone41);
		setRotationAngle(bone41, 0.3491F, 0.0F, 0.0F);
		bone41.cubeList.add(new ModelBox(bone41, 135, 71, -3.0F, -1.1215F, -8.6108F, 3, 5, 4, 0.0F, false));

		bone42 = new ModelRenderer(this);
		bone42.setRotationPoint(-2.5F, 9.0F, 23.0F);
		Head.addChild(bone42);
		setRotationAngle(bone42, -0.4363F, 3.1416F, 0.0F);
		bone42.cubeList.add(new ModelBox(bone42, 107, 84, -6.0F, -9.0F, -11.0F, 9, 9, 9, 0.0F, false));

		bone43 = new ModelRenderer(this);
		bone43.setRotationPoint(0.0F, -0.9848F, -0.1736F);
		bone42.addChild(bone43);
		setRotationAngle(bone43, 0.1745F, 0.0F, 0.0F);
		bone43.cubeList.add(new ModelBox(bone43, 122, 85, -5.0F, -1.1215F, -10.6108F, 7, 9, 8, 0.0F, false));

		bone44 = new ModelRenderer(this);
		bone44.setRotationPoint(0.0F, 5.9088F, 1.0419F);
		bone42.addChild(bone44);
		setRotationAngle(bone44, 0.3491F, 0.0F, 0.0F);
		bone44.cubeList.add(new ModelBox(bone44, 109, 80, -4.0F, -1.1215F, -9.6108F, 5, 5, 6, 0.0F, false));

		bone45 = new ModelRenderer(this);
		bone45.setRotationPoint(0.0F, 9.6744F, 2.7213F);
		bone42.addChild(bone45);
		setRotationAngle(bone45, 0.3491F, 0.0F, 0.0F);
		bone45.cubeList.add(new ModelBox(bone45, 128, 71, -3.0F, -1.1215F, -8.6108F, 3, 5, 4, 0.0F, false));

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(23.25F, -12.0F, -4.25F);
		Head.addChild(bone2);
		setRotationAngle(bone2, 0.0F, 0.3491F, 0.0F);
		bone2.cubeList.add(new ModelBox(bone2, 110, 388, -6.25F, 0.0F, -11.5F, 12, 12, 12, 0.0F, false));

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(-1.2006F, 0.0F, -10.1809F);
		bone2.addChild(bone3);
		setRotationAngle(bone3, 0.0F, 0.3491F, 0.0F);
		bone3.cubeList.add(new ModelBox(bone3, 84, 368, -5.0676F, 0.0F, -10.4658F, 12, 12, 12, 0.0F, false));

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(-3.2484F, 0.0F, -19.1736F);
		bone2.addChild(bone4);
		setRotationAngle(bone4, 0.0F, 0.8727F, 0.0F);
		bone4.cubeList.add(new ModelBox(bone4, 126, 386, -6.4818F, 0.0F, -10.4658F, 12, 12, 12, 0.0F, false));

		bone14 = new ModelRenderer(this);
		bone14.setRotationPoint(24.75F, -12.0F, 7.25F);
		Head.addChild(bone14);
		setRotationAngle(bone14, -1.5708F, 0.0F, 0.6981F);
		bone14.cubeList.add(new ModelBox(bone14, 82, 45, -6.25F, 0.0F, -11.5F, 12, 12, 19, 0.0F, false));

		bone15 = new ModelRenderer(this);
		bone15.setRotationPoint(-1.2006F, 0.0F, -10.1809F);
		bone14.addChild(bone15);
		setRotationAngle(bone15, 0.0F, 0.3491F, 0.0F);
		bone15.cubeList.add(new ModelBox(bone15, 74, 66, -4.0676F, 1.0F, -10.4658F, 10, 10, 14, 0.0F, false));

		bone16 = new ModelRenderer(this);
		bone16.setRotationPoint(-3.2484F, 0.0F, -19.1736F);
		bone14.addChild(bone16);
		setRotationAngle(bone16, 0.0F, 0.8727F, 0.0F);
		bone16.cubeList.add(new ModelBox(bone16, 96, 85, -3.4818F, 2.0F, -10.4658F, 7, 8, 12, 0.0F, false));

		bone17 = new ModelRenderer(this);
		bone17.setRotationPoint(5.75F, -12.25F, -25.0F);
		Head.addChild(bone17);
		setRotationAngle(bone17, 0.0F, 0.7854F, 1.5708F);
		bone17.cubeList.add(new ModelBox(bone17, 52, 55, -6.25F, 0.0F, -11.5F, 12, 12, 19, 0.0F, false));

		bone18 = new ModelRenderer(this);
		bone18.setRotationPoint(-1.2006F, 0.0F, -10.1809F);
		bone17.addChild(bone18);
		setRotationAngle(bone18, 0.0F, 0.3491F, 0.0F);
		bone18.cubeList.add(new ModelBox(bone18, 8, 93, -4.0676F, 1.0F, -10.4658F, 10, 10, 14, 0.0F, false));

		bone19 = new ModelRenderer(this);
		bone19.setRotationPoint(-3.2484F, 0.0F, -19.1736F);
		bone17.addChild(bone19);
		setRotationAngle(bone19, 0.0F, 0.8727F, 0.0F);
		bone19.cubeList.add(new ModelBox(bone19, 66, 80, -3.4818F, 2.0F, -10.4658F, 7, 8, 12, 0.0F, false));

		bone23 = new ModelRenderer(this);
		bone23.setRotationPoint(-6.25F, -12.25F, 25.0F);
		Head.addChild(bone23);
		setRotationAngle(bone23, 3.1416F, -0.8727F, 1.5708F);
		bone23.cubeList.add(new ModelBox(bone23, 52, 72, -6.25F, 0.0F, -11.5F, 12, 12, 19, 0.0F, false));

		bone24 = new ModelRenderer(this);
		bone24.setRotationPoint(-1.2006F, 0.0F, -10.1809F);
		bone23.addChild(bone24);
		setRotationAngle(bone24, 0.0F, 0.3491F, 0.0F);
		bone24.cubeList.add(new ModelBox(bone24, 68, 43, -4.0676F, 1.0F, -10.4658F, 10, 10, 14, 0.0F, false));

		bone25 = new ModelRenderer(this);
		bone25.setRotationPoint(-3.2484F, 0.0F, -19.1736F);
		bone23.addChild(bone25);
		setRotationAngle(bone25, 0.0F, 0.8727F, 0.0F);
		bone25.cubeList.add(new ModelBox(bone25, 91, 58, -3.4818F, 2.0F, -10.4658F, 7, 8, 12, 0.0F, false));

		bone20 = new ModelRenderer(this);
		bone20.setRotationPoint(-24.25F, -12.25F, -5.75F);
		Head.addChild(bone20);
		setRotationAngle(bone20, 1.5708F, 0.0F, 2.4435F);
		bone20.cubeList.add(new ModelBox(bone20, 96, 78, -6.25F, 0.0F, -11.5F, 12, 12, 19, 0.0F, false));

		bone21 = new ModelRenderer(this);
		bone21.setRotationPoint(-1.2006F, 0.0F, -10.1809F);
		bone20.addChild(bone21);
		setRotationAngle(bone21, 0.0F, 0.3491F, 0.0F);
		bone21.cubeList.add(new ModelBox(bone21, 77, 62, -4.0676F, 1.0F, -10.4658F, 10, 10, 14, 0.0F, false));

		bone22 = new ModelRenderer(this);
		bone22.setRotationPoint(-3.2484F, 0.0F, -19.1736F);
		bone20.addChild(bone22);
		setRotationAngle(bone22, 0.0F, 0.8727F, 0.0F);
		bone22.cubeList.add(new ModelBox(bone22, 104, 82, -3.4818F, 2.0F, -10.4658F, 7, 8, 12, 0.0F, false));

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(43.25F, -12.0F, -4.25F);
		Head.addChild(bone8);
		setRotationAngle(bone8, 0.0F, 0.3491F, 0.0F);
		bone8.cubeList.add(new ModelBox(bone8, 177, 337, -72.0647F, 0.0F, -15.061F, 12, 12, 12, 0.0F, true));

		bone9 = new ModelRenderer(this);
		bone9.setRotationPoint(-1.2006F, 0.0F, -10.1809F);
		bone8.addChild(bone9);
		setRotationAngle(bone9, 0.0F, 0.3491F, 0.0F);
		bone9.cubeList.add(new ModelBox(bone9, 177, 337, -69.1129F, 0.0F, -17.5295F, 12, 12, 12, 0.0F, true));

		bone10 = new ModelRenderer(this);
		bone10.setRotationPoint(-6.1089F, 0.0F, -24.4715F);
		bone8.addChild(bone10);
		setRotationAngle(bone10, 0.0F, 0.9599F, 0.0F);
		bone10.cubeList.add(new ModelBox(bone10, 177, 337, -62.3746F, 0.0F, -31.6607F, 12, 12, 12, 0.0F, true));

		bone11 = new ModelRenderer(this);
		bone11.setRotationPoint(-10.75F, -11.75F, -4.0F);
		Head.addChild(bone11);
		setRotationAngle(bone11, 0.0F, -1.2217F, 0.0F);
		bone11.cubeList.add(new ModelBox(bone11, 91, 410, -22.8147F, 0.0F, -13.061F, 12, 12, 12, 0.0F, true));

		bone12 = new ModelRenderer(this);
		bone12.setRotationPoint(48.0494F, 0.0F, -8.1809F);
		bone11.addChild(bone12);
		setRotationAngle(bone12, 0.0F, 0.3491F, 0.0F);
		bone12.cubeList.add(new ModelBox(bone12, 91, 410, -69.1129F, 0.0F, -17.5295F, 12, 12, 12, 0.0F, true));

		bone13 = new ModelRenderer(this);
		bone13.setRotationPoint(43.1411F, 0.0F, -22.4715F);
		bone11.addChild(bone13);
		setRotationAngle(bone13, 0.0F, 0.9599F, 0.0F);
		bone13.cubeList.add(new ModelBox(bone13, 91, 410, -62.3746F, 0.0F, -31.6607F, 12, 12, 12, 0.0F, true));

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(3.5F, -12.0F, 24.5F);
		Head.addChild(bone5);
		setRotationAngle(bone5, 0.0F, -1.2217F, 0.0F);
		bone5.cubeList.add(new ModelBox(bone5, 27, 414, -6.1429F, 0.0F, -12.5252F, 12, 12, 12, 0.0F, false));

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(-0.6452F, 0.0F, -10.2448F);
		bone5.addChild(bone6);
		setRotationAngle(bone6, 0.0F, 0.4363F, 0.0F);
		bone6.cubeList.add(new ModelBox(bone6, 27, 414, -5.16F, 0.0F, -11.5224F, 12, 12, 12, 0.0F, false));

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(-2.9919F, 0.0F, -19.8784F);
		bone5.addChild(bone7);
		setRotationAngle(bone7, 0.0F, 0.9599F, 0.0F);
		bone7.cubeList.add(new ModelBox(bone7, 27, 414, -7.0295F, 0.0F, -10.5779F, 12, 12, 12, 0.0F, false));

		body = new ModelRenderer(this);
		body.setRotationPoint(-1.0F, -218.0F, 1.75F);
		setRotationAngle(body, 0.0873F, 0.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 45, 231, -4.0F, -12.0F, -6.0F, 9, 12, 12, 0.0F, false));

		bone59 = new ModelRenderer(this);
		bone59.setRotationPoint(3.0F, -4.7849F, 2.6772F);
		body.addChild(bone59);
		setRotationAngle(bone59, 0.1745F, 0.0F, 0.0F);
		bone59.cubeList.add(new ModelBox(bone59, 45, 231, -4.0F, 2.9429F, -7.3073F, 9, 12, 12, 0.0F, false));

		bone60 = new ModelRenderer(this);
		bone60.setRotationPoint(6.0F, 4.8533F, 3.8416F);
		body.addChild(bone60);
		setRotationAngle(bone60, 0.5236F, 0.0F, 0.0F);
		bone60.cubeList.add(new ModelBox(bone60, 45, 231, -4.0F, 2.9429F, -7.3073F, 8, 12, 12, 0.0F, false));

		bone61 = new ModelRenderer(this);
		bone61.setRotationPoint(3.75F, 13.5513F, 8.6017F);
		body.addChild(bone61);
		setRotationAngle(bone61, 0.2618F, 0.0F, 0.0F);
		bone61.cubeList.add(new ModelBox(bone61, 45, 231, -2.0F, 2.9429F, -7.3073F, 8, 12, 12, 0.0F, false));

		bone62 = new ModelRenderer(this);
		bone62.setRotationPoint(0.25F, 23.233F, 10.2642F);
		body.addChild(bone62);
		bone62.cubeList.add(new ModelBox(bone62, 45, 231, -6.0F, 2.9429F, -7.3073F, 12, 12, 12, 0.0F, false));

		bone63 = new ModelRenderer(this);
		bone63.setRotationPoint(-1.75F, 30.9411F, 6.5783F);
		body.addChild(bone63);
		bone63.cubeList.add(new ModelBox(bone63, 45, 231, -6.0F, 2.9429F, -7.3073F, 12, 12, 12, 0.0F, false));

		bone64 = new ModelRenderer(this);
		bone64.setRotationPoint(-5.75F, 36.1338F, -2.9103F);
		body.addChild(bone64);
		setRotationAngle(bone64, 0.0873F, 0.0F, 0.0F);
		bone64.cubeList.add(new ModelBox(bone64, 45, 231, -6.0F, -1.0571F, -7.3073F, 12, 12, 12, 0.0F, false));

		bone65 = new ModelRenderer(this);
		bone65.setRotationPoint(-10.75F, 38.1637F, -14.13F);
		body.addChild(bone65);
		setRotationAngle(bone65, 0.1745F, 0.0F, 0.0F);
		bone65.cubeList.add(new ModelBox(bone65, 45, 231, -6.0F, -0.8227F, -3.6279F, 10, 12, 10, 0.0F, false));

		bone66 = new ModelRenderer(this);
		bone66.setRotationPoint(-20.75F, 44.1409F, -14.6529F);
		body.addChild(bone66);
		setRotationAngle(bone66, -0.1745F, 0.0F, 0.0F);
		bone66.cubeList.add(new ModelBox(bone66, 45, 231, -6.0F, -5.0266F, -2.0046F, 12, 12, 6, 0.0F, false));

		bone67 = new ModelRenderer(this);
		bone67.setRotationPoint(-24.75F, 51.7243F, -8.2896F);
		body.addChild(bone67);
		setRotationAngle(bone67, -0.4363F, 0.0F, 0.0F);
		bone67.cubeList.add(new ModelBox(bone67, 45, 231, -6.0F, -6.8894F, -9.2201F, 12, 12, 12, 0.0F, false));

		bone58 = new ModelRenderer(this);
		bone58.setRotationPoint(-26.75F, 56.4811F, -2.6829F);
		body.addChild(bone58);
		setRotationAngle(bone58, -0.6109F, 0.0F, 0.0F);
		bone58.cubeList.add(new ModelBox(bone58, 45, 231, -6.0F, -7.1104F, -8.7461F, 12, 12, 12, 0.0F, false));

		bone68 = new ModelRenderer(this);
		bone68.setRotationPoint(-24.5F, 63.4357F, 2.2297F);
		body.addChild(bone68);
		setRotationAngle(bone68, -0.8727F, 0.0F, 0.0F);
		bone68.cubeList.add(new ModelBox(bone68, 45, 231, -7.0F, -7.5872F, -8.1248F, 12, 12, 11, 0.0F, false));

		bone69 = new ModelRenderer(this);
		bone69.setRotationPoint(-24.5F, 71.0068F, 5.5826F);
		body.addChild(bone69);
		setRotationAngle(bone69, -1.2217F, 0.0F, 0.0F);
		bone69.cubeList.add(new ModelBox(bone69, 45, 231, -7.0F, -7.5872F, -8.1248F, 12, 12, 11, 0.0F, false));

		bone70 = new ModelRenderer(this);
		bone70.setRotationPoint(-21.75F, 79.0229F, 11.1551F);
		body.addChild(bone70);
		bone70.cubeList.add(new ModelBox(bone70, 45, 231, -7.0F, -7.5872F, -8.1248F, 12, 12, 11, 0.0F, false));

		bone71 = new ModelRenderer(this);
		bone71.setRotationPoint(-18.0F, 85.0001F, 10.6322F);
		body.addChild(bone71);
		bone71.cubeList.add(new ModelBox(bone71, 45, 231, -7.0F, -7.5872F, -8.1248F, 12, 12, 11, 0.0F, false));

		bone72 = new ModelRenderer(this);
		bone72.setRotationPoint(-14.0F, 93.4647F, 4.1197F);
		body.addChild(bone72);
		bone72.cubeList.add(new ModelBox(bone72, 45, 231, -7.0F, -7.5872F, -8.1248F, 12, 12, 11, 0.0F, false));

		bone73 = new ModelRenderer(this);
		bone73.setRotationPoint(-9.0F, 100.9113F, -2.5547F);
		body.addChild(bone73);
		setRotationAngle(bone73, 0.1745F, 0.0F, 0.0F);
		bone73.cubeList.add(new ModelBox(bone73, 45, 231, -7.0F, -7.5872F, -8.1248F, 12, 12, 11, 0.0F, false));

		bone74 = new ModelRenderer(this);
		bone74.setRotationPoint(-6.0F, 104.286F, -9.8767F);
		body.addChild(bone74);
		bone74.cubeList.add(new ModelBox(bone74, 45, 231, -7.0F, -7.5872F, -8.1248F, 12, 12, 11, 0.0F, false));

		bone75 = new ModelRenderer(this);
		bone75.setRotationPoint(-15.0F, 113.8122F, -15.7292F);
		body.addChild(bone75);
		bone75.cubeList.add(new ModelBox(bone75, 45, 231, -7.0F, -7.5872F, -8.1248F, 12, 12, 11, 0.0F, false));

		bone76 = new ModelRenderer(this);
		bone76.setRotationPoint(-24.0F, 120.7856F, -16.3393F);
		body.addChild(bone76);
		bone76.cubeList.add(new ModelBox(bone76, 45, 231, -7.0F, -7.5872F, -8.1248F, 12, 12, 11, 0.0F, false));

		bone77 = new ModelRenderer(this);
		bone77.setRotationPoint(-27.0F, 130.1871F, -12.1428F);
		body.addChild(bone77);
		bone77.cubeList.add(new ModelBox(bone77, 45, 231, -7.0F, -7.5872F, -8.1248F, 12, 12, 11, 0.0F, false));

		bone78 = new ModelRenderer(this);
		bone78.setRotationPoint(-25.0F, 137.8577F, -4.7833F);
		body.addChild(bone78);
		bone78.cubeList.add(new ModelBox(bone78, 45, 231, -7.0F, -7.5872F, -8.1248F, 12, 12, 11, 0.0F, false));

		bone79 = new ModelRenderer(this);
		bone79.setRotationPoint(-19.0F, 144.2706F, -0.3253F);
		body.addChild(bone79);
		bone79.cubeList.add(new ModelBox(bone79, 45, 231, -7.0F, -7.5872F, -8.1248F, 12, 12, 11, 0.0F, false));

		bone80 = new ModelRenderer(this);
		bone80.setRotationPoint(-12.0F, 144.0963F, -2.3176F);
		body.addChild(bone80);
		bone80.cubeList.add(new ModelBox(bone80, 45, 231, -7.0F, -0.9128F, -0.6782F, 12, 11, 11, 0.0F, false));

		bone81 = new ModelRenderer(this);
		bone81.setRotationPoint(-4.0F, 150.6339F, -7.9087F);
		body.addChild(bone81);
		bone81.cubeList.add(new ModelBox(bone81, 45, 231, -7.0F, -0.9128F, -0.6782F, 12, 12, 11, 0.0F, false));

		bone82 = new ModelRenderer(this);
		bone82.setRotationPoint(-3.0F, 159.9858F, -15.7536F);
		body.addChild(bone82);
		bone82.cubeList.add(new ModelBox(bone82, 45, 231, -7.0F, -0.9128F, -0.6782F, 12, 12, 11, 0.0F, false));

		bone83 = new ModelRenderer(this);
		bone83.setRotationPoint(0.0F, 165.7886F, -18.269F);
		body.addChild(bone83);
		bone83.cubeList.add(new ModelBox(bone83, 45, 231, -7.0F, -0.9128F, -0.6782F, 12, 12, 11, 0.0F, false));

		bone84 = new ModelRenderer(this);
		bone84.setRotationPoint(9.0F, 173.1481F, -25.9396F);
		body.addChild(bone84);
		bone84.cubeList.add(new ModelBox(bone84, 45, 231, -7.0F, -0.9128F, -0.6782F, 12, 12, 11, 0.0F, false));

		bone85 = new ModelRenderer(this);
		bone85.setRotationPoint(25.0F, 109.0F, -36.4435F);
		body.addChild(bone85);
		setRotationAngle(bone85, 0.0873F, 0.0F, 0.0F);
		bone85.cubeList.add(new ModelBox(bone85, 45, 231, -16.0F, 68.7767F, 4.3218F, 12, 12, 11, 0.0F, false));

		Leg1 = new ModelRenderer(this);
		Leg1.setRotationPoint(-38.0F, 24.0F, 33.75F);
		setRotationAngle(Leg1, 0.0873F, 0.0F, 0.0873F);
		Leg1.cubeList.add(new ModelBox(Leg1, 16, 199, -3.0F, -285.0F, 0.0F, 5, 78, 5, 0.0F, false));

		bone86 = new ModelRenderer(this);
		bone86.setRotationPoint(38.0F, 1.0F, -33.0F);
		Leg1.addChild(bone86);
		bone86.cubeList.add(new ModelBox(bone86, 16, 199, -40.9386F, -210.4388F, 32.9141F, 5, 78, 5, 0.0F, false));

		bone87 = new ModelRenderer(this);
		bone87.setRotationPoint(-0.2624F, -132.0F, 1.9857F);
		Leg1.addChild(bone87);
		setRotationAngle(bone87, 0.1745F, 0.0F, 0.0F);
		bone87.cubeList.add(new ModelBox(bone87, 16, 199, -4.2884F, 73.4753F, -2.9152F, 8, 5, 7, 0.0F, false));
		bone87.cubeList.add(new ModelBox(bone87, 16, 199, -5.6869F, 76.5168F, -3.4805F, 10, 6, 8, 0.0F, false));
		bone87.cubeList.add(new ModelBox(bone87, 16, 199, -5.6745F, 81.6187F, -3.5352F, 10, 4, 8, 0.0F, false));
		bone87.cubeList.add(new ModelBox(bone87, 16, 77, -2.8458F, 85.2693F, -3.5134F, 5, 4, 8, 0.0F, false));
		bone87.cubeList.add(new ModelBox(bone87, 32, 107, -1.8334F, 88.3712F, -2.5681F, 3, 4, 6, 0.0F, false));
		bone87.cubeList.add(new ModelBox(bone87, 16, 122, -1.8209F, 91.4731F, -1.6228F, 3, 4, 4, 0.0F, false));
		bone87.cubeList.add(new ModelBox(bone87, 23, 154, -1.8085F, 94.575F, -0.6775F, 3, 3, 2, 0.0F, false));
		bone87.cubeList.add(new ModelBox(bone87, 16, 199, -2.9386F, 0.1723F, -2.0859F, 5, 78, 5, 0.0F, false));

		LEg2 = new ModelRenderer(this);
		LEg2.setRotationPoint(-65.0F, 24.0F, 0.5F);
		setRotationAngle(LEg2, 0.0F, 0.0F, 0.1745F);
		LEg2.cubeList.add(new ModelBox(LEg2, 27, 205, -3.0F, -285.0F, 0.0F, 5, 78, 5, 0.0F, false));

		bone89 = new ModelRenderer(this);
		bone89.setRotationPoint(38.0F, 1.0F, -33.0F);
		LEg2.addChild(bone89);
		bone89.cubeList.add(new ModelBox(bone89, 27, 205, -40.9386F, -210.4388F, 32.9141F, 5, 78, 5, 0.0F, false));

		bone90 = new ModelRenderer(this);
		bone90.setRotationPoint(-0.2624F, -131.0F, 1.9857F);
		LEg2.addChild(bone90);
		setRotationAngle(bone90, 0.0873F, 0.0F, 0.0F);
		bone90.cubeList.add(new ModelBox(bone90, 27, 205, -2.9386F, -0.8277F, -2.0859F, 5, 78, 5, 0.0F, false));
		bone90.cubeList.add(new ModelBox(bone90, 27, 205, -4.1663F, 73.4337F, -4.4334F, 8, 3, 8, 0.0F, false));
		bone90.cubeList.add(new ModelBox(bone90, 27, 205, -4.3846F, 80.8712F, -4.3312F, 8, 3, 8, 0.0F, false));
		bone90.cubeList.add(new ModelBox(bone90, 27, 205, -5.3114F, 75.5041F, -5.3635F, 10, 6, 10, 0.0F, false));

		Leg3 = new ModelRenderer(this);
		Leg3.setRotationPoint(-34.5F, 24.0F, -37.0F);
		setRotationAngle(Leg3, -0.0873F, 0.0F, 0.0873F);
		Leg3.cubeList.add(new ModelBox(Leg3, 50, 222, -3.0F, -285.0F, 0.0F, 5, 78, 5, 0.0F, false));

		bone92 = new ModelRenderer(this);
		bone92.setRotationPoint(38.0F, 1.0F, -33.0F);
		Leg3.addChild(bone92);
		bone92.cubeList.add(new ModelBox(bone92, 50, 222, -40.9386F, -210.4388F, 32.9141F, 5, 78, 5, 0.0F, false));

		bone93 = new ModelRenderer(this);
		bone93.setRotationPoint(-1.2624F, -132.0F, 0.9857F);
		Leg3.addChild(bone93);
		setRotationAngle(bone93, 0.1745F, 0.0F, 0.0F);
		bone93.cubeList.add(new ModelBox(bone93, 50, 222, -1.9386F, 0.1723F, -1.0859F, 5, 78, 5, 0.0F, false));
		bone93.cubeList.add(new ModelBox(bone93, 50, 222, -2.8423F, 75.8153F, -2.1666F, 7, 4, 7, 0.0F, false));
		bone93.cubeList.add(new ModelBox(bone93, 50, 222, -2.8174F, 81.8349F, -2.4423F, 7, 4, 7, 0.0F, false));
		bone93.cubeList.add(new ModelBox(bone93, 50, 222, -3.8952F, 78.0699F, -3.3639F, 9, 6, 9, 0.0F, false));

		Leg4 = new ModelRenderer(this);
		Leg4.setRotationPoint(35.5F, 24.0F, -39.0F);
		setRotationAngle(Leg4, -0.0873F, 0.0F, -0.0873F);
		Leg4.cubeList.add(new ModelBox(Leg4, 37, 194, -3.0F, -285.0F, 0.0F, 5, 78, 5, 0.0F, false));

		bone95 = new ModelRenderer(this);
		bone95.setRotationPoint(38.0F, 1.0F, -33.0F);
		Leg4.addChild(bone95);
		bone95.cubeList.add(new ModelBox(bone95, 37, 194, -40.9386F, -210.4388F, 32.9141F, 5, 78, 5, 0.0F, false));

		bone96 = new ModelRenderer(this);
		bone96.setRotationPoint(-1.2624F, -129.0F, 0.9857F);
		Leg4.addChild(bone96);
		setRotationAngle(bone96, 0.1745F, 0.0F, 0.0F);
		bone96.cubeList.add(new ModelBox(bone96, 37, 194, -1.9386F, -2.8277F, -1.0859F, 5, 78, 5, 0.0F, false));
		bone96.cubeList.add(new ModelBox(bone96, 37, 194, -2.4279F, 71.6836F, -2.3148F, 7, 6, 7, 0.0F, false));
		bone96.cubeList.add(new ModelBox(bone96, 37, 194, -2.0418F, 78.7172F, -2.9301F, 7, 3, 7, 0.0F, false));
		bone96.cubeList.add(new ModelBox(bone96, 37, 194, -3.6022F, 73.6684F, -3.4884F, 9, 7, 9, 0.0F, false));

		Leg5 = new ModelRenderer(this);
		Leg5.setRotationPoint(65.5F, 24.0F, -3.0F);
		setRotationAngle(Leg5, 0.0F, 0.0F, -0.1745F);
		Leg5.cubeList.add(new ModelBox(Leg5, 33, 209, -3.0F, -285.0F, 0.0F, 5, 78, 5, 0.0F, false));

		bone98 = new ModelRenderer(this);
		bone98.setRotationPoint(38.0F, 1.0F, -33.0F);
		Leg5.addChild(bone98);
		bone98.cubeList.add(new ModelBox(bone98, 33, 209, -40.9386F, -210.4388F, 32.9141F, 5, 78, 5, 0.0F, false));

		bone99 = new ModelRenderer(this);
		bone99.setRotationPoint(-0.2624F, -132.0F, 0.9857F);
		Leg5.addChild(bone99);
		setRotationAngle(bone99, 0.1745F, 0.0F, 0.0F);
		bone99.cubeList.add(new ModelBox(bone99, 33, 209, -2.9386F, 0.1723F, -1.0859F, 5, 78, 5, 0.0F, false));
		bone99.cubeList.add(new ModelBox(bone99, 33, 209, -4.4556F, 76.7353F, -2.8147F, 8, 5, 8, 0.0F, false));
		bone99.cubeList.add(new ModelBox(bone99, 33, 209, -5.1653F, 80.9159F, -3.7903F, 10, 6, 10, 0.0F, false));
		bone99.cubeList.add(new ModelBox(bone99, 33, 209, -4.0488F, 86.1098F, -2.6907F, 8, 4, 8, 0.0F, false));

		Leg6 = new ModelRenderer(this);
		Leg6.setRotationPoint(58.5F, 14.0F, 56.0F);
		setRotationAngle(Leg6, 0.1745F, 0.0F, -0.1745F);
		Leg6.cubeList.add(new ModelBox(Leg6, 33, 210, -3.0F, -285.0F, 0.0F, 5, 78, 5, 0.0F, false));

		bone101 = new ModelRenderer(this);
		bone101.setRotationPoint(38.0F, 1.0F, -33.0F);
		Leg6.addChild(bone101);
		bone101.cubeList.add(new ModelBox(bone101, 33, 210, -40.9386F, -210.4388F, 32.9141F, 5, 78, 5, 0.0F, false));

		bone102 = new ModelRenderer(this);
		bone102.setRotationPoint(-1.2624F, -131.0F, 0.9857F);
		Leg6.addChild(bone102);
		setRotationAngle(bone102, 0.1745F, 0.0F, 0.0F);
		bone102.cubeList.add(new ModelBox(bone102, 33, 210, -1.9386F, -0.8277F, -1.0859F, 5, 78, 5, 0.0F, false));
		bone102.cubeList.add(new ModelBox(bone102, 33, 210, -4.9104F, 68.1844F, -2.3151F, 10, 4, 7, 0.0F, false));
		bone102.cubeList.add(new ModelBox(bone102, 33, 210, -5.4313F, 70.9606F, -4.3256F, 11, 4, 11, 0.0F, false));
		bone102.cubeList.add(new ModelBox(bone102, 33, 210, -5.5467F, 74.7087F, -4.3595F, 11, 6, 11, 0.0F, false));
		bone102.cubeList.add(new ModelBox(bone102, 32, 133, -2.5321F, 80.7234F, -3.6864F, 6, 4, 10, 0.0F, false));
		bone102.cubeList.add(new ModelBox(bone102, 11, 110, -1.5607F, 83.9232F, -2.7869F, 4, 4, 8, 0.0F, false));
		bone102.cubeList.add(new ModelBox(bone102, 29, 104, -1.5458F, 86.8917F, -1.8031F, 4, 4, 6, 0.0F, false));
		bone102.cubeList.add(new ModelBox(bone102, 24, 119, -1.5743F, 90.1771F, -0.6687F, 4, 5, 4, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		Head.render(f5);
		body.render(f5);
		Leg1.render(f5);
		LEg2.render(f5);
		Leg3.render(f5);
		Leg4.render(f5);
		Leg5.render(f5);
		Leg6.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}