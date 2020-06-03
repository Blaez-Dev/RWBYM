package io.github.blaezdev.rwbym.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelRavager extends ModelBase {
	private final ModelRenderer Body;
	private final ModelRenderer bone46;
	private final ModelRenderer bone47;
	private final ModelRenderer bone48;
	private final ModelRenderer bone49;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer bone3;
	private final ModelRenderer bone4;
	private final ModelRenderer RightLeg;
	private final ModelRenderer bone5;
	private final ModelRenderer bone6;
	private final ModelRenderer bone7;
	private final ModelRenderer bone8;
	private final ModelRenderer Leftwing;
	private final ModelRenderer bone9;
	private final ModelRenderer bone10;
	private final ModelRenderer bone11;
	private final ModelRenderer bone14;
	private final ModelRenderer bone17;
	private final ModelRenderer bone12;
	private final ModelRenderer bone15;
	private final ModelRenderer bone18;
	private final ModelRenderer bone13;
	private final ModelRenderer bone16;
	private final ModelRenderer bone19;
	private final ModelRenderer bone20;
	private final ModelRenderer bone21;
	private final ModelRenderer bone22;
	private final ModelRenderer bone23;
	private final ModelRenderer bone24;
	private final ModelRenderer Head;
	private final ModelRenderer bone41;
	private final ModelRenderer bone42;
	private final ModelRenderer bone43;
	private final ModelRenderer bone44;
	private final ModelRenderer bone45;
	private final ModelRenderer RightWing;
	private final ModelRenderer bone25;
	private final ModelRenderer bone26;
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
	private final ModelRenderer bone37;
	private final ModelRenderer bone38;
	private final ModelRenderer bone39;
	private final ModelRenderer bone40;

	public ModelRavager() {
		textureWidth = 115;
		textureHeight = 115;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 5.0F, 0.0F);
		Body.cubeList.add(new ModelBox(Body, 0, 81, -7.5F, -16.0F, -8.0F, 15, 15, 16, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 6, 59, 1.75F, -5.5F, -1.0F, 6, 5, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 6, 59, -7.75F, -5.5F, -1.0F, 6, 5, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 6, 59, 1.75F, -4.5F, 1.25F, 6, 4, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 6, 59, -7.75F, -4.5F, 1.25F, 6, 4, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 6, 59, 2.75F, -3.5F, 3.25F, 5, 3, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 6, 59, -7.75F, -3.5F, 3.25F, 5, 3, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 6, 59, 3.75F, -2.5F, 5.25F, 4, 2, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 6, 59, -7.75F, -2.5F, 5.25F, 4, 2, 1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 0, 81, -6.0F, -13.0F, 7.0F, 12, 10, 12, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 0, 81, -2.5F, -9.75F, 18.25F, 5, 2, 5, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 0, 81, -1.75F, -11.75F, 18.25F, 4, 3, 5, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 0, 81, -1.25F, -9.75F, 23.25F, 3, 2, 5, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 0, 81, 1.5F, -9.0F, 18.75F, 3, 1, 5, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 0, 81, 0.5F, -9.0F, 22.75F, 3, 1, 5, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 0, 81, -2.75F, -9.0F, 22.75F, 3, 1, 5, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 0, 81, -4.5F, -9.0F, 18.75F, 3, 1, 5, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 0, 81, -0.75F, -10.75F, 23.25F, 2, 2, 5, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 0, 81, -0.75F, -9.75F, 27.25F, 2, 2, 5, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 0, 81, -5.5F, -14.25F, 7.0F, 11, 3, 9, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 0, 81, -4.5F, -15.25F, 6.5F, 9, 2, 7, 0.0F, false));

		bone46 = new ModelRenderer(this);
		bone46.setRotationPoint(0.25F, -15.0F, -2.75F);
		Body.addChild(bone46);
		setRotationAngle(bone46, -0.2618F, 0.0F, 0.0F);
		bone46.cubeList.add(new ModelBox(bone46, 1, 51, -2.0F, -3.25F, -2.75F, 3, 5, 3, 0.0F, false));
		bone46.cubeList.add(new ModelBox(bone46, 1, 51, -1.5F, -6.0F, -2.0F, 2, 5, 2, 0.0F, false));
		bone46.cubeList.add(new ModelBox(bone46, 1, 51, -1.0F, -7.9492F, -1.487F, 1, 5, 1, 0.0F, false));

		bone47 = new ModelRenderer(this);
		bone47.setRotationPoint(0.25F, -14.25F, 3.5F);
		Body.addChild(bone47);
		setRotationAngle(bone47, -0.4363F, 0.0F, 0.0F);
		bone47.cubeList.add(new ModelBox(bone47, 1, 51, -2.0F, -3.25F, -2.75F, 3, 5, 3, 0.0F, false));
		bone47.cubeList.add(new ModelBox(bone47, 1, 51, -1.5F, -6.0F, -2.0F, 2, 5, 2, 0.0F, false));
		bone47.cubeList.add(new ModelBox(bone47, 1, 51, -1.0F, -7.9492F, -1.487F, 1, 5, 1, 0.0F, false));

		bone48 = new ModelRenderer(this);
		bone48.setRotationPoint(0.25F, -12.5F, 7.5F);
		Body.addChild(bone48);
		setRotationAngle(bone48, -0.6109F, 0.0F, 0.0F);
		bone48.cubeList.add(new ModelBox(bone48, 1, 51, -2.0F, -3.25F, -2.75F, 3, 5, 3, 0.0F, false));
		bone48.cubeList.add(new ModelBox(bone48, 1, 51, -1.5F, -6.0F, -2.0F, 2, 5, 2, 0.0F, false));
		bone48.cubeList.add(new ModelBox(bone48, 1, 51, -1.0F, -7.9492F, -1.487F, 1, 5, 1, 0.0F, false));

		bone49 = new ModelRenderer(this);
		bone49.setRotationPoint(0.25F, -10.25F, 10.5F);
		Body.addChild(bone49);
		setRotationAngle(bone49, -0.7854F, 0.0F, 0.0F);
		bone49.cubeList.add(new ModelBox(bone49, 1, 51, -2.0F, -3.25F, -2.75F, 3, 5, 3, 0.0F, false));
		bone49.cubeList.add(new ModelBox(bone49, 1, 51, -1.5F, -6.0F, -2.0F, 2, 5, 2, 0.0F, false));
		bone49.cubeList.add(new ModelBox(bone49, 1, 51, -1.0F, -7.9492F, -1.487F, 1, 5, 1, 0.0F, false));

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(6.0F, -2.0F, 17.0F);
		setRotationAngle(LeftLeg, -0.3491F, 0.0F, 0.0F);
		LeftLeg.cubeList.add(new ModelBox(LeftLeg, 6, 89, -2.0F, -3.0F, -1.0F, 4, 6, 7, 0.0F, false));

		bone = new ModelRenderer(this);
		bone.setRotationPoint(2.0F, 0.1746F, 6.4275F);
		LeftLeg.addChild(bone);
		setRotationAngle(bone, 0.4363F, 0.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 6, 89, -3.5F, -2.1441F, -2.4221F, 3, 4, 7, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 6, 89, -3.5F, -2.6384F, -2.2914F, 3, 3, 5, 0.0F, false));

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(2.0F, -1.8775F, 12.0657F);
		LeftLeg.addChild(bone2);
		setRotationAngle(bone2, -0.3491F, 0.0F, 0.0F);
		bone2.cubeList.add(new ModelBox(bone2, 6, 89, -3.0F, -0.1441F, -2.4221F, 2, 2, 6, 0.0F, false));

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(2.0F, -3.5876F, 16.7641F);
		LeftLeg.addChild(bone3);
		setRotationAngle(bone3, 0.6981F, 0.0F, 0.0F);
		bone3.cubeList.add(new ModelBox(bone3, 6, 89, -2.5F, 0.1115F, -4.6436F, 1, 2, 3, 0.0F, false));

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(2.0F, -4.6137F, 19.5832F);
		LeftLeg.addChild(bone4);
		setRotationAngle(bone4, 1.309F, 0.0F, 0.0F);
		bone4.cubeList.add(new ModelBox(bone4, 7, 58, -2.5F, -3.7799F, -4.3164F, 1, 2, 2, 0.0F, false));
		bone4.cubeList.add(new ModelBox(bone4, 4, 66, -2.5F, -3.2681F, -2.4321F, 1, 1, 1, 0.0F, false));

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-6.0F, -2.0F, 17.0F);
		setRotationAngle(RightLeg, -0.3491F, 0.0F, 0.0F);
		RightLeg.cubeList.add(new ModelBox(RightLeg, 10, 78, -2.0F, -3.0F, -1.0F, 4, 6, 7, 0.0F, false));

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(2.0F, 0.1746F, 6.4275F);
		RightLeg.addChild(bone5);
		setRotationAngle(bone5, 0.4363F, 0.0F, 0.0F);
		bone5.cubeList.add(new ModelBox(bone5, 10, 78, -3.5F, -2.1441F, -2.4221F, 3, 4, 7, 0.0F, false));
		bone5.cubeList.add(new ModelBox(bone5, 10, 78, -3.5F, -2.6384F, -2.2914F, 3, 3, 5, 0.0F, false));

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(2.0F, -1.8775F, 12.0657F);
		RightLeg.addChild(bone6);
		setRotationAngle(bone6, -0.3491F, 0.0F, 0.0F);
		bone6.cubeList.add(new ModelBox(bone6, 10, 78, -3.0F, -0.1441F, -2.4221F, 2, 2, 6, 0.0F, false));

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(2.0F, -3.5876F, 16.7641F);
		RightLeg.addChild(bone7);
		setRotationAngle(bone7, 0.6981F, 0.0F, 0.0F);
		bone7.cubeList.add(new ModelBox(bone7, 10, 78, -2.5F, 0.1115F, -4.6436F, 1, 2, 3, 0.0F, false));

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(2.0F, -4.6137F, 19.5832F);
		RightLeg.addChild(bone8);
		setRotationAngle(bone8, 1.309F, 0.0F, 0.0F);
		bone8.cubeList.add(new ModelBox(bone8, 1, 59, -2.5F, -3.7799F, -4.3164F, 1, 2, 2, 0.0F, false));
		bone8.cubeList.add(new ModelBox(bone8, 5, 66, -2.5F, -3.2681F, -2.4321F, 1, 1, 1, 0.0F, false));

		Leftwing = new ModelRenderer(this);
		Leftwing.setRotationPoint(7.6574F, -9.6296F, 1.2593F);
		Leftwing.cubeList.add(new ModelBox(Leftwing, 0, 88, -1.4074F, 1.6296F, -4.0093F, 17, 3, 4, 0.0F, false));
		Leftwing.cubeList.add(new ModelBox(Leftwing, 0, 11, 13.5926F, 2.3796F, -0.7593F, 3, 1, 11, 0.0F, false));
		Leftwing.cubeList.add(new ModelBox(Leftwing, 0, 11, 10.5926F, 2.3796F, -0.7593F, 3, 1, 13, 0.0F, false));
		Leftwing.cubeList.add(new ModelBox(Leftwing, 0, 11, 7.5926F, 2.3796F, -0.7593F, 3, 1, 12, 0.0F, false));
		Leftwing.cubeList.add(new ModelBox(Leftwing, 0, 11, -3.4074F, 2.3796F, -0.7593F, 11, 1, 13, 0.0F, false));
		Leftwing.cubeList.add(new ModelBox(Leftwing, 0, 11, 18.5926F, 2.3796F, -4.7593F, 3, 1, 11, 0.0F, false));
		Leftwing.cubeList.add(new ModelBox(Leftwing, 0, 11, 15.5926F, 2.3796F, -2.7593F, 3, 1, 11, 0.0F, false));
		Leftwing.cubeList.add(new ModelBox(Leftwing, 0, 11, 30.5926F, 2.3796F, -10.7593F, 3, 1, 21, 0.0F, false));
		Leftwing.cubeList.add(new ModelBox(Leftwing, 0, 11, 33.5926F, 2.3796F, -13.7593F, 4, 1, 26, 0.0F, false));
		Leftwing.cubeList.add(new ModelBox(Leftwing, 0, 11, 37.5926F, 2.3796F, -15.7593F, 7, 1, 18, 0.0F, false));
		Leftwing.cubeList.add(new ModelBox(Leftwing, 0, 11, 37.5926F, 2.3796F, 2.2407F, 3, 1, 11, 0.0F, false));
		Leftwing.cubeList.add(new ModelBox(Leftwing, 0, 11, 40.5926F, 2.3796F, 1.2407F, 4, 1, 11, 0.0F, false));
		Leftwing.cubeList.add(new ModelBox(Leftwing, 0, 11, 43.5926F, 2.3796F, -14.7593F, 4, 1, 25, 0.0F, false));
		Leftwing.cubeList.add(new ModelBox(Leftwing, 0, 11, 46.5926F, 2.3796F, -12.7593F, 3, 1, 23, 0.0F, false));
		Leftwing.cubeList.add(new ModelBox(Leftwing, 0, 11, 49.5926F, 2.3796F, -9.7593F, 3, 1, 19, 0.0F, false));
		Leftwing.cubeList.add(new ModelBox(Leftwing, 0, 11, 49.5926F, 2.3796F, -11.7593F, 1, 1, 2, 0.0F, false));
		Leftwing.cubeList.add(new ModelBox(Leftwing, 0, 11, 50.5926F, 2.3796F, -10.7593F, 1, 1, 1, 0.0F, false));
		Leftwing.cubeList.add(new ModelBox(Leftwing, 0, 11, 52.5926F, 2.3796F, -8.7593F, 1, 1, 2, 0.0F, false));
		Leftwing.cubeList.add(new ModelBox(Leftwing, 0, 11, 54.3426F, 2.3796F, -6.0093F, 1, 1, 2, 0.0F, false));
		Leftwing.cubeList.add(new ModelBox(Leftwing, 0, 11, 56.3426F, 2.3796F, -4.0093F, 1, 1, 4, 0.0F, false));
		Leftwing.cubeList.add(new ModelBox(Leftwing, 0, 11, 58.3426F, 2.3796F, -0.0093F, 1, 1, 4, 0.0F, false));
		Leftwing.cubeList.add(new ModelBox(Leftwing, 0, 11, 59.3426F, 2.3796F, 1.9907F, 1, 1, 3, 0.0F, false));
		Leftwing.cubeList.add(new ModelBox(Leftwing, 0, 11, 62.3426F, 2.3796F, 6.9907F, 1, 1, 2, 0.0F, false));
		Leftwing.cubeList.add(new ModelBox(Leftwing, 0, 11, 60.3426F, 2.3796F, 3.9907F, 1, 1, 3, 0.0F, false));
		Leftwing.cubeList.add(new ModelBox(Leftwing, 0, 11, 57.3426F, 2.3796F, -2.0093F, 1, 1, 2, 0.0F, false));
		Leftwing.cubeList.add(new ModelBox(Leftwing, 0, 11, 55.3426F, 2.3796F, -5.0093F, 1, 1, 1, 0.0F, false));
		Leftwing.cubeList.add(new ModelBox(Leftwing, 0, 11, 53.3426F, 2.3796F, -7.7593F, 1, 1, 1, 0.0F, false));
		Leftwing.cubeList.add(new ModelBox(Leftwing, 0, 11, 52.5926F, 2.3796F, -6.7593F, 2, 1, 14, 0.0F, false));
		Leftwing.cubeList.add(new ModelBox(Leftwing, 0, 11, 54.5926F, 2.3796F, -4.7593F, 2, 1, 11, 0.0F, false));
		Leftwing.cubeList.add(new ModelBox(Leftwing, 0, 11, 54.5926F, 2.3796F, -4.7593F, 2, 1, 11, 0.0F, false));
		Leftwing.cubeList.add(new ModelBox(Leftwing, 0, 11, 56.5926F, 2.3796F, -0.7593F, 2, 1, 9, 0.0F, false));
		Leftwing.cubeList.add(new ModelBox(Leftwing, 0, 11, 58.5926F, 2.3796F, 3.2407F, 2, 1, 6, 0.0F, false));
		Leftwing.cubeList.add(new ModelBox(Leftwing, 0, 11, 60.5926F, 2.3796F, 5.2407F, 2, 1, 5, 0.0F, false));
		Leftwing.cubeList.add(new ModelBox(Leftwing, 0, 11, 62.5926F, 2.3796F, 8.2407F, 2, 1, 3, 0.0F, false));
		Leftwing.cubeList.add(new ModelBox(Leftwing, 0, 11, 27.5926F, 2.3796F, -9.7593F, 3, 1, 18, 0.0F, false));
		Leftwing.cubeList.add(new ModelBox(Leftwing, 0, 11, 24.5926F, 2.3796F, -7.7593F, 3, 1, 14, 0.0F, false));
		Leftwing.cubeList.add(new ModelBox(Leftwing, 0, 11, 21.5926F, 2.3796F, -6.7593F, 3, 1, 11, 0.0F, false));
		Leftwing.cubeList.add(new ModelBox(Leftwing, 13, 81, -2.1574F, 0.6296F, -5.0093F, 7, 5, 5, 0.0F, false));

		bone9 = new ModelRenderer(this);
		bone9.setRotationPoint(15.0926F, 6.1296F, -1.2593F);
		Leftwing.addChild(bone9);
		setRotationAngle(bone9, 0.0F, 0.5236F, 0.0F);
		bone9.cubeList.add(new ModelBox(bone9, 0, 93, 0.0F, -4.0F, -2.0F, 29, 2, 3, 0.0F, false));

		bone10 = new ModelRenderer(this);
		bone10.setRotationPoint(25.0926F, 6.1296F, -1.2593F);
		Leftwing.addChild(bone10);
		bone10.cubeList.add(new ModelBox(bone10, 6, 88, 13.75F, -4.0F, -17.25F, 4, 2, 4, 0.0F, false));
		bone10.cubeList.add(new ModelBox(bone10, 6, 40, 14.75F, -4.0F, -20.0F, 1, 2, 4, 0.0F, false));
		bone10.cubeList.add(new ModelBox(bone10, 8, 54, 14.75F, -2.75F, -21.25F, 1, 1, 2, 0.0F, false));
		bone10.cubeList.add(new ModelBox(bone10, 14, 91, 14.75F, -1.75F, -21.25F, 1, 1, 1, 0.0F, false));

		bone11 = new ModelRenderer(this);
		bone11.setRotationPoint(49.5926F, 6.1296F, -11.0093F);
		Leftwing.addChild(bone11);
		setRotationAngle(bone11, 0.0F, -0.5236F, 0.0F);
		bone11.cubeList.add(new ModelBox(bone11, 6, 85, -10.9801F, -4.0F, -2.2508F, 11, 2, 2, 0.0F, false));

		bone14 = new ModelRenderer(this);
		bone14.setRotationPoint(42.5926F, 6.1296F, -6.0093F);
		Leftwing.addChild(bone14);
		setRotationAngle(bone14, 0.0F, -1.309F, 0.0F);
		bone14.cubeList.add(new ModelBox(bone14, 4, 88, -10.9801F, -4.0F, -2.2508F, 11, 2, 2, 0.0F, false));

		bone17 = new ModelRenderer(this);
		bone17.setRotationPoint(37.5926F, 6.1296F, -6.0093F);
		Leftwing.addChild(bone17);
		setRotationAngle(bone17, 0.0F, -1.6581F, 0.0F);
		bone17.cubeList.add(new ModelBox(bone17, 2, 85, -10.9801F, -4.0F, -2.2508F, 11, 2, 2, 0.0F, false));

		bone12 = new ModelRenderer(this);
		bone12.setRotationPoint(49.8426F, 6.1296F, -3.7593F);
		Leftwing.addChild(bone12);
		setRotationAngle(bone12, 0.0F, -0.8727F, 0.0F);
		bone12.cubeList.add(new ModelBox(bone12, 4, 85, -7.0617F, -4.0F, -6.1427F, 11, 2, 1, 0.0F, false));

		bone15 = new ModelRenderer(this);
		bone15.setRotationPoint(40.0926F, 6.1296F, 1.2407F);
		Leftwing.addChild(bone15);
		setRotationAngle(bone15, 0.0F, -1.309F, 0.0F);
		bone15.cubeList.add(new ModelBox(bone15, 4, 89, -6.8697F, -4.0F, -6.0427F, 11, 2, 1, 0.0F, false));

		bone18 = new ModelRenderer(this);
		bone18.setRotationPoint(31.8426F, 6.1296F, -1.7593F);
		Leftwing.addChild(bone18);
		setRotationAngle(bone18, 0.0F, -1.8326F, 0.0F);
		bone18.cubeList.add(new ModelBox(bone18, 2, 90, -6.6756F, -4.0F, -6.2842F, 11, 2, 1, 0.0F, false));

		bone13 = new ModelRenderer(this);
		bone13.setRotationPoint(55.8426F, 6.1296F, 5.2407F);
		Leftwing.addChild(bone13);
		setRotationAngle(bone13, 0.0F, -1.0472F, 0.0F);
		bone13.cubeList.add(new ModelBox(bone13, 0, 91, -8.2313F, -4.0F, -5.9432F, 21, 2, 1, 0.0F, false));
		bone13.cubeList.add(new ModelBox(bone13, 2, 45, 12.5677F, -4.25F, -6.0592F, 2, 2, 1, 0.0F, false));
		bone13.cubeList.add(new ModelBox(bone13, 6, 53, 14.2417F, -3.75F, -5.9587F, 2, 1, 1, 0.0F, false));

		bone16 = new ModelRenderer(this);
		bone16.setRotationPoint(42.5926F, 6.1296F, 10.4907F);
		Leftwing.addChild(bone16);
		setRotationAngle(bone16, 0.0F, -1.309F, 0.0F);
		bone16.cubeList.add(new ModelBox(bone16, 7, 89, -8.2313F, -4.0F, -5.9432F, 11, 2, 1, 0.0F, false));
		bone16.cubeList.add(new ModelBox(bone16, 4, 46, 2.5884F, -4.25F, -5.9732F, 2, 2, 1, 0.0F, false));
		bone16.cubeList.add(new ModelBox(bone16, 4, 50, 4.1667F, -3.75F, -6.0679F, 2, 1, 1, 0.0F, false));

		bone19 = new ModelRenderer(this);
		bone19.setRotationPoint(28.3426F, 6.1296F, 8.7407F);
		Leftwing.addChild(bone19);
		setRotationAngle(bone19, 0.0F, -1.9199F, 0.0F);
		bone19.cubeList.add(new ModelBox(bone19, 7, 86, -8.2313F, -4.0F, -5.9432F, 11, 2, 1, 0.0F, false));
		bone19.cubeList.add(new ModelBox(bone19, 1, 46, 2.5884F, -4.25F, -5.9732F, 2, 2, 1, 0.0F, false));
		bone19.cubeList.add(new ModelBox(bone19, 6, 44, 4.1667F, -3.75F, -6.0679F, 2, 1, 1, 0.0F, false));

		bone20 = new ModelRenderer(this);
		bone20.setRotationPoint(1.8426F, 6.8796F, 10.4907F);
		Leftwing.addChild(bone20);
		setRotationAngle(bone20, -0.2618F, 0.0F, 0.0F);
		bone20.cubeList.add(new ModelBox(bone20, 0, 11, 6.25F, -4.6481F, -0.3752F, 3, 1, 4, 0.0F, false));

		bone21 = new ModelRenderer(this);
		bone21.setRotationPoint(-1.1574F, 6.8796F, 10.4907F);
		Leftwing.addChild(bone21);
		setRotationAngle(bone21, -0.2618F, 0.0F, 0.0F);
		bone21.cubeList.add(new ModelBox(bone21, 0, 11, 6.25F, -4.6481F, -0.3752F, 3, 1, 6, 0.0F, false));

		bone22 = new ModelRenderer(this);
		bone22.setRotationPoint(-4.1574F, 6.8796F, 9.9907F);
		Leftwing.addChild(bone22);
		setRotationAngle(bone22, -0.4363F, 0.0F, 0.0F);
		bone22.cubeList.add(new ModelBox(bone22, 0, 11, 1.25F, -4.6481F, -0.3752F, 8, 1, 6, 0.0F, false));

		bone23 = new ModelRenderer(this);
		bone23.setRotationPoint(-4.1574F, 8.8796F, 14.2407F);
		Leftwing.addChild(bone23);
		setRotationAngle(bone23, -0.6109F, 0.0F, 0.0F);
		bone23.cubeList.add(new ModelBox(bone23, 0, 11, 3.25F, -4.6481F, -0.3752F, 6, 1, 6, 0.0F, false));

		bone24 = new ModelRenderer(this);
		bone24.setRotationPoint(-6.9074F, 9.8796F, 15.7407F);
		Leftwing.addChild(bone24);
		setRotationAngle(bone24, -0.6109F, 0.0F, 0.0F);
		bone24.cubeList.add(new ModelBox(bone24, 0, 11, 6.25F, -4.6481F, -0.3752F, 3, 1, 6, 0.0F, false));

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.25F, -2.0F, -7.25F);
		Head.cubeList.add(new ModelBox(Head, 0, 79, -6.25F, -8.0F, -9.0F, 12, 6, 10, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 0, 79, -5.25F, -7.0F, -12.25F, 10, 5, 5, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 11, 23, -5.75F, -5.5F, -10.5F, 11, 1, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 0, 79, -4.25F, -6.0F, -15.25F, 8, 4, 4, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 6, 56, -3.75F, -6.25F, -17.0F, 7, 4, 2, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 6, 63, -4.75F, -6.25F, -15.5F, 9, 4, 3, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 9, 55, -5.75F, -7.0625F, -12.5F, 11, 5, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 5, 61, -5.75F, -7.25F, -11.75F, 11, 5, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 2, 59, -5.75F, -7.25F, -11.75F, 11, 1, 3, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 2, 61, -5.75F, -4.25F, -11.75F, 11, 2, 3, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 3, 59, 4.25F, -3.25F, -11.75F, 1, 2, 3, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 1, 57, 5.0F, -3.25F, -9.75F, 1, 2, 3, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 2, 51, -6.25F, -3.25F, -9.75F, 1, 2, 3, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 0, 53, -6.75F, -8.25F, -9.3125F, 13, 7, 3, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 2, 68, -2.5F, -8.25F, -7.0F, 4, 2, 3, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 5, 57, -1.5F, -8.75F, -4.75F, 2, 2, 2, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 5, 56, -5.75F, -3.25F, -11.75F, 1, 2, 3, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 0, 79, -5.75F, -7.25F, -9.25F, 11, 5, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 2, 82, -2.4375F, -5.25F, -17.25F, 5, 3, 3, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 10, 50, -0.75F, -5.5F, -17.5F, 1, 4, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 7, 42, -3.25F, -5.5F, -17.5F, 1, 4, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 5, 64, 1.75F, -5.5F, -17.5F, 1, 4, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 3, 61, -3.25F, -3.5F, -17.5F, 6, 2, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 4, 62, -3.25F, -5.5F, -17.5F, 6, 1, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 5, 54, -3.0F, -2.25F, -17.0F, 1, 4, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 1, 54, 1.5F, -2.25F, -17.0F, 1, 4, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 8, 63, 0.25F, -4.25F, -17.0F, 1, 4, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 4, 65, 1.5F, -4.25F, -15.5F, 1, 4, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 5, 58, 2.25F, -4.25F, -14.0F, 1, 4, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 2, 59, -4.0F, -4.25F, -14.0F, 1, 4, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 5, 59, 2.5F, -4.25F, -12.5F, 1, 4, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 3, 64, -4.0F, -4.25F, -12.5F, 1, 4, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 4, 66, -3.0F, -4.25F, -15.5F, 1, 4, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 6, 62, -1.5F, -4.25F, -17.0F, 1, 4, 1, 0.0F, false));

		bone41 = new ModelRenderer(this);
		bone41.setRotationPoint(6.25F, -8.0F, -4.5F);
		Head.addChild(bone41);
		setRotationAngle(bone41, -0.1745F, -0.2618F, 0.0F);
		bone41.cubeList.add(new ModelBox(bone41, 0, 79, -3.483F, -1.7763F, -0.8291F, 3, 2, 2, 0.0F, false));

		bone42 = new ModelRenderer(this);
		bone42.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone41.addChild(bone42);
		bone42.cubeList.add(new ModelBox(bone42, 0, 79, -3.4656F, -3.1863F, -0.0312F, 4, 2, 2, 0.0F, false));
		bone42.cubeList.add(new ModelBox(bone42, 0, 79, -3.3362F, -5.2397F, 0.0971F, 3, 2, 2, 0.0F, false));
		bone42.cubeList.add(new ModelBox(bone42, 0, 79, -3.1421F, -6.8427F, 0.5501F, 2, 2, 1, 0.0F, false));
		bone42.cubeList.add(new ModelBox(bone42, 0, 79, -3.0774F, -8.3619F, 0.5274F, 1, 2, 1, 0.0F, false));

		bone43 = new ModelRenderer(this);
		bone43.setRotationPoint(-2.75F, -8.0F, -4.5F);
		Head.addChild(bone43);
		setRotationAngle(bone43, -0.1745F, 0.2618F, 0.0F);
		bone43.cubeList.add(new ModelBox(bone43, 0, 79, -3.2889F, -1.4043F, -1.4992F, 3, 2, 2, 0.0F, false));

		bone44 = new ModelRenderer(this);
		bone44.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone43.addChild(bone44);
		bone44.cubeList.add(new ModelBox(bone44, 0, 79, -4.4789F, -2.7581F, -1.0199F, 4, 2, 2, 0.0F, false));
		bone44.cubeList.add(new ModelBox(bone44, 0, 79, -3.6251F, -4.599F, -0.657F, 3, 2, 2, 0.0F, false));
		bone44.cubeList.add(new ModelBox(bone44, 0, 79, -2.7065F, -6.482F, -0.0562F, 2, 2, 1, 0.0F, false));
		bone44.cubeList.add(new ModelBox(bone44, 0, 79, -1.9174F, -8.281F, 0.0688F, 1, 2, 1, 0.0F, false));

		bone45 = new ModelRenderer(this);
		bone45.setRotationPoint(0.75F, 2.0F, -1.0F);
		Head.addChild(bone45);
		setRotationAngle(bone45, 0.2618F, 0.0F, 0.0F);
		bone45.cubeList.add(new ModelBox(bone45, 0, 79, -6.0F, -5.0F, -3.0F, 10, 7, 5, 0.0F, false));
		bone45.cubeList.add(new ModelBox(bone45, 0, 79, -5.0F, -1.0F, -7.0F, 8, 3, 4, 0.0F, false));
		bone45.cubeList.add(new ModelBox(bone45, 0, 79, -4.0F, -1.0F, -10.0F, 6, 3, 3, 0.0F, false));
		bone45.cubeList.add(new ModelBox(bone45, 0, 79, -3.5F, -0.5517F, -12.1907F, 5, 2, 3, 0.0F, false));
		bone45.cubeList.add(new ModelBox(bone45, 0, 79, -3.0F, -0.1681F, -14.6228F, 4, 2, 3, 0.0F, false));
		bone45.cubeList.add(new ModelBox(bone45, 7, 52, -0.25F, -2.6817F, -14.4761F, 1, 3, 1, 0.0F, false));
		bone45.cubeList.add(new ModelBox(bone45, 79, 21, 1.5F, -6.543F, -6.231F, 1, 7, 1, 0.0F, false));
		bone45.cubeList.add(new ModelBox(bone45, 88, 19, -4.5F, -6.543F, -6.231F, 1, 7, 1, 0.0F, false));
		bone45.cubeList.add(new ModelBox(bone45, 82, 18, 1.5F, -6.1548F, -4.7821F, 1, 7, 1, 0.0F, false));
		bone45.cubeList.add(new ModelBox(bone45, 73, 13, -4.5F, -6.1548F, -4.7821F, 1, 7, 1, 0.0F, false));
		bone45.cubeList.add(new ModelBox(bone45, 4, 54, -0.25F, -1.4396F, -12.7383F, 1, 3, 1, 0.0F, false));
		bone45.cubeList.add(new ModelBox(bone45, 3, 65, -2.75F, -1.4396F, -12.7383F, 1, 3, 1, 0.0F, false));
		bone45.cubeList.add(new ModelBox(bone45, 0, 52, 0.25F, -1.4697F, -10.9186F, 1, 2, 1, 0.0F, false));
		bone45.cubeList.add(new ModelBox(bone45, 5, 63, -3.25F, -1.4697F, -10.9186F, 1, 2, 1, 0.0F, false));
		bone45.cubeList.add(new ModelBox(bone45, 10, 49, -2.75F, -2.6817F, -14.4761F, 1, 3, 1, 0.0F, false));

		RightWing = new ModelRenderer(this);
		RightWing.setRotationPoint(-7.6574F, -9.6296F, 1.2593F);
		RightWing.cubeList.add(new ModelBox(RightWing, 0, 88, -15.5926F, 1.6296F, -4.0093F, 17, 3, 4, 0.0F, true));
		RightWing.cubeList.add(new ModelBox(RightWing, 0, 11, -16.5926F, 2.3796F, -0.7593F, 3, 1, 11, 0.0F, true));
		RightWing.cubeList.add(new ModelBox(RightWing, 0, 11, -13.5926F, 2.3796F, -0.7593F, 3, 1, 13, 0.0F, true));
		RightWing.cubeList.add(new ModelBox(RightWing, 0, 11, -10.5926F, 2.3796F, -0.7593F, 3, 1, 12, 0.0F, true));
		RightWing.cubeList.add(new ModelBox(RightWing, 0, 11, -7.5926F, 2.3796F, -0.7593F, 11, 1, 13, 0.0F, true));
		RightWing.cubeList.add(new ModelBox(RightWing, 0, 11, -21.5926F, 2.3796F, -4.7593F, 3, 1, 11, 0.0F, true));
		RightWing.cubeList.add(new ModelBox(RightWing, 0, 11, -18.5926F, 2.3796F, -2.7593F, 3, 1, 11, 0.0F, true));
		RightWing.cubeList.add(new ModelBox(RightWing, 0, 11, -33.5926F, 2.3796F, -10.7593F, 3, 1, 21, 0.0F, true));
		RightWing.cubeList.add(new ModelBox(RightWing, 0, 11, -37.5926F, 2.3796F, -13.7593F, 4, 1, 26, 0.0F, true));
		RightWing.cubeList.add(new ModelBox(RightWing, 0, 11, -44.5926F, 2.3796F, -15.7593F, 7, 1, 18, 0.0F, true));
		RightWing.cubeList.add(new ModelBox(RightWing, 0, 11, -40.5926F, 2.3796F, 2.2407F, 3, 1, 11, 0.0F, true));
		RightWing.cubeList.add(new ModelBox(RightWing, 0, 11, -44.5926F, 2.3796F, 1.2407F, 4, 1, 11, 0.0F, true));
		RightWing.cubeList.add(new ModelBox(RightWing, 0, 11, -47.5926F, 2.3796F, -14.7593F, 4, 1, 25, 0.0F, true));
		RightWing.cubeList.add(new ModelBox(RightWing, 0, 11, -49.5926F, 2.3796F, -12.7593F, 3, 1, 23, 0.0F, true));
		RightWing.cubeList.add(new ModelBox(RightWing, 0, 11, -52.5926F, 2.3796F, -9.7593F, 3, 1, 19, 0.0F, true));
		RightWing.cubeList.add(new ModelBox(RightWing, 0, 11, -50.5926F, 2.3796F, -11.7593F, 1, 1, 2, 0.0F, true));
		RightWing.cubeList.add(new ModelBox(RightWing, 0, 11, -51.5926F, 2.3796F, -10.7593F, 1, 1, 1, 0.0F, true));
		RightWing.cubeList.add(new ModelBox(RightWing, 0, 11, -53.5926F, 2.3796F, -8.7593F, 1, 1, 2, 0.0F, true));
		RightWing.cubeList.add(new ModelBox(RightWing, 0, 11, -55.3426F, 2.3796F, -6.0093F, 1, 1, 2, 0.0F, true));
		RightWing.cubeList.add(new ModelBox(RightWing, 0, 11, -57.3426F, 2.3796F, -4.0093F, 1, 1, 4, 0.0F, true));
		RightWing.cubeList.add(new ModelBox(RightWing, 0, 11, -59.3426F, 2.3796F, -0.0093F, 1, 1, 4, 0.0F, true));
		RightWing.cubeList.add(new ModelBox(RightWing, 0, 11, -60.3426F, 2.3796F, 1.9907F, 1, 1, 3, 0.0F, true));
		RightWing.cubeList.add(new ModelBox(RightWing, 0, 11, -63.3426F, 2.3796F, 6.9907F, 1, 1, 2, 0.0F, true));
		RightWing.cubeList.add(new ModelBox(RightWing, 0, 11, -61.3426F, 2.3796F, 3.9907F, 1, 1, 3, 0.0F, true));
		RightWing.cubeList.add(new ModelBox(RightWing, 0, 11, -58.3426F, 2.3796F, -2.0093F, 1, 1, 2, 0.0F, true));
		RightWing.cubeList.add(new ModelBox(RightWing, 0, 11, -56.3426F, 2.3796F, -5.0093F, 1, 1, 1, 0.0F, true));
		RightWing.cubeList.add(new ModelBox(RightWing, 0, 11, -54.3426F, 2.3796F, -7.7593F, 1, 1, 1, 0.0F, true));
		RightWing.cubeList.add(new ModelBox(RightWing, 0, 11, -54.5926F, 2.3796F, -6.7593F, 2, 1, 14, 0.0F, true));
		RightWing.cubeList.add(new ModelBox(RightWing, 0, 11, -56.5926F, 2.3796F, -4.7593F, 2, 1, 11, 0.0F, true));
		RightWing.cubeList.add(new ModelBox(RightWing, 0, 11, -56.5926F, 2.3796F, -4.7593F, 2, 1, 11, 0.0F, true));
		RightWing.cubeList.add(new ModelBox(RightWing, 0, 11, -58.5926F, 2.3796F, -0.7593F, 2, 1, 9, 0.0F, true));
		RightWing.cubeList.add(new ModelBox(RightWing, 0, 11, -60.5926F, 2.3796F, 3.2407F, 2, 1, 6, 0.0F, true));
		RightWing.cubeList.add(new ModelBox(RightWing, 0, 11, -62.5926F, 2.3796F, 5.2407F, 2, 1, 5, 0.0F, true));
		RightWing.cubeList.add(new ModelBox(RightWing, 0, 11, -64.5926F, 2.3796F, 8.2407F, 2, 1, 3, 0.0F, true));
		RightWing.cubeList.add(new ModelBox(RightWing, 0, 11, -30.5926F, 2.3796F, -9.7593F, 3, 1, 18, 0.0F, true));
		RightWing.cubeList.add(new ModelBox(RightWing, 0, 11, -27.5926F, 2.3796F, -7.7593F, 3, 1, 14, 0.0F, true));
		RightWing.cubeList.add(new ModelBox(RightWing, 0, 11, -24.5926F, 2.3796F, -6.7593F, 3, 1, 11, 0.0F, true));
		RightWing.cubeList.add(new ModelBox(RightWing, 13, 81, -4.8426F, 0.6296F, -5.0093F, 7, 5, 5, 0.0F, true));

		bone25 = new ModelRenderer(this);
		bone25.setRotationPoint(-15.0926F, 6.1296F, -1.2593F);
		RightWing.addChild(bone25);
		setRotationAngle(bone25, 0.0F, -0.5236F, 0.0F);
		bone25.cubeList.add(new ModelBox(bone25, 0, 93, -29.0F, -4.0F, -2.0F, 29, 2, 3, 0.0F, true));

		bone26 = new ModelRenderer(this);
		bone26.setRotationPoint(-25.0926F, 6.1296F, -1.2593F);
		RightWing.addChild(bone26);
		bone26.cubeList.add(new ModelBox(bone26, 6, 88, -17.75F, -4.0F, -17.25F, 4, 2, 4, 0.0F, true));
		bone26.cubeList.add(new ModelBox(bone26, 6, 40, -15.75F, -4.0F, -20.0F, 1, 2, 4, 0.0F, true));
		bone26.cubeList.add(new ModelBox(bone26, 8, 54, -15.75F, -2.75F, -21.25F, 1, 1, 2, 0.0F, true));
		bone26.cubeList.add(new ModelBox(bone26, 14, 91, -15.75F, -1.75F, -21.25F, 1, 1, 1, 0.0F, true));

		bone27 = new ModelRenderer(this);
		bone27.setRotationPoint(-49.5926F, 6.1296F, -11.0093F);
		RightWing.addChild(bone27);
		setRotationAngle(bone27, 0.0F, 0.5236F, 0.0F);
		bone27.cubeList.add(new ModelBox(bone27, 6, 85, -0.0199F, -4.0F, -2.2508F, 11, 2, 2, 0.0F, true));

		bone28 = new ModelRenderer(this);
		bone28.setRotationPoint(-42.5926F, 6.1296F, -6.0093F);
		RightWing.addChild(bone28);
		setRotationAngle(bone28, 0.0F, 1.309F, 0.0F);
		bone28.cubeList.add(new ModelBox(bone28, 4, 88, -0.0199F, -4.0F, -2.2508F, 11, 2, 2, 0.0F, true));

		bone29 = new ModelRenderer(this);
		bone29.setRotationPoint(-37.5926F, 6.1296F, -6.0093F);
		RightWing.addChild(bone29);
		setRotationAngle(bone29, 0.0F, 1.6581F, 0.0F);
		bone29.cubeList.add(new ModelBox(bone29, 2, 85, -0.0199F, -4.0F, -2.2508F, 11, 2, 2, 0.0F, true));

		bone30 = new ModelRenderer(this);
		bone30.setRotationPoint(-49.8426F, 6.1296F, -3.7593F);
		RightWing.addChild(bone30);
		setRotationAngle(bone30, 0.0F, 0.8727F, 0.0F);
		bone30.cubeList.add(new ModelBox(bone30, 4, 85, -3.9383F, -4.0F, -6.1427F, 11, 2, 1, 0.0F, true));

		bone31 = new ModelRenderer(this);
		bone31.setRotationPoint(-40.0926F, 6.1296F, 1.2407F);
		RightWing.addChild(bone31);
		setRotationAngle(bone31, 0.0F, 1.309F, 0.0F);
		bone31.cubeList.add(new ModelBox(bone31, 4, 89, -4.1303F, -4.0F, -6.0427F, 11, 2, 1, 0.0F, true));

		bone32 = new ModelRenderer(this);
		bone32.setRotationPoint(-31.8426F, 6.1296F, -1.7593F);
		RightWing.addChild(bone32);
		setRotationAngle(bone32, 0.0F, 1.8326F, 0.0F);
		bone32.cubeList.add(new ModelBox(bone32, 2, 90, -4.3244F, -4.0F, -6.2842F, 11, 2, 1, 0.0F, true));

		bone33 = new ModelRenderer(this);
		bone33.setRotationPoint(-55.8426F, 6.1296F, 5.2407F);
		RightWing.addChild(bone33);
		setRotationAngle(bone33, 0.0F, 1.0472F, 0.0F);
		bone33.cubeList.add(new ModelBox(bone33, 0, 91, -12.7686F, -4.0F, -5.9432F, 21, 2, 1, 0.0F, true));
		bone33.cubeList.add(new ModelBox(bone33, 2, 45, -14.5677F, -4.25F, -6.0592F, 2, 2, 1, 0.0F, true));
		bone33.cubeList.add(new ModelBox(bone33, 6, 53, -16.2417F, -3.75F, -5.9587F, 2, 1, 1, 0.0F, true));

		bone34 = new ModelRenderer(this);
		bone34.setRotationPoint(-42.5926F, 6.1296F, 10.4907F);
		RightWing.addChild(bone34);
		setRotationAngle(bone34, 0.0F, 1.309F, 0.0F);
		bone34.cubeList.add(new ModelBox(bone34, 7, 89, -2.7687F, -4.0F, -5.9432F, 11, 2, 1, 0.0F, true));
		bone34.cubeList.add(new ModelBox(bone34, 4, 46, -4.5884F, -4.25F, -5.9732F, 2, 2, 1, 0.0F, true));
		bone34.cubeList.add(new ModelBox(bone34, 4, 50, -6.1667F, -3.75F, -6.0679F, 2, 1, 1, 0.0F, true));

		bone35 = new ModelRenderer(this);
		bone35.setRotationPoint(-28.3426F, 6.1296F, 8.7407F);
		RightWing.addChild(bone35);
		setRotationAngle(bone35, 0.0F, 1.9199F, 0.0F);
		bone35.cubeList.add(new ModelBox(bone35, 7, 86, -2.7687F, -4.0F, -5.9432F, 11, 2, 1, 0.0F, true));
		bone35.cubeList.add(new ModelBox(bone35, 1, 46, -4.5884F, -4.25F, -5.9732F, 2, 2, 1, 0.0F, true));
		bone35.cubeList.add(new ModelBox(bone35, 6, 44, -6.1667F, -3.75F, -6.0679F, 2, 1, 1, 0.0F, true));

		bone36 = new ModelRenderer(this);
		bone36.setRotationPoint(-1.8426F, 6.8796F, 10.4907F);
		RightWing.addChild(bone36);
		setRotationAngle(bone36, -0.2618F, 0.0F, 0.0F);
		bone36.cubeList.add(new ModelBox(bone36, 0, 11, -9.25F, -4.6481F, -0.3752F, 3, 1, 4, 0.0F, true));

		bone37 = new ModelRenderer(this);
		bone37.setRotationPoint(1.1574F, 6.8796F, 10.4907F);
		RightWing.addChild(bone37);
		setRotationAngle(bone37, -0.2618F, 0.0F, 0.0F);
		bone37.cubeList.add(new ModelBox(bone37, 0, 11, -9.25F, -4.6481F, -0.3752F, 3, 1, 6, 0.0F, true));

		bone38 = new ModelRenderer(this);
		bone38.setRotationPoint(4.1574F, 6.8796F, 9.9907F);
		RightWing.addChild(bone38);
		setRotationAngle(bone38, -0.4363F, 0.0F, 0.0F);
		bone38.cubeList.add(new ModelBox(bone38, 0, 11, -9.25F, -4.6481F, -0.3752F, 8, 1, 6, 0.0F, true));

		bone39 = new ModelRenderer(this);
		bone39.setRotationPoint(4.1574F, 8.8796F, 14.2407F);
		RightWing.addChild(bone39);
		setRotationAngle(bone39, -0.6109F, 0.0F, 0.0F);
		bone39.cubeList.add(new ModelBox(bone39, 0, 11, -9.25F, -4.6481F, -0.3752F, 6, 1, 6, 0.0F, true));

		bone40 = new ModelRenderer(this);
		bone40.setRotationPoint(6.9074F, 9.8796F, 15.7407F);
		RightWing.addChild(bone40);
		setRotationAngle(bone40, -0.6109F, 0.0F, 0.0F);
		bone40.cubeList.add(new ModelBox(bone40, 0, 11, -9.25F, -4.6481F, -0.3752F, 3, 1, 6, 0.0F, true));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		Body.render(f5);
		LeftLeg.render(f5);
		RightLeg.render(f5);
		Leftwing.render(f5);
		Head.render(f5);
		RightWing.render(f5);
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
		this.RightWing.rotateAngleZ = MathHelper.cos(ageInTicks * 0.4F) * (float)Math.PI * 0.25F;
		this.Leftwing.rotateAngleZ = -this.RightWing.rotateAngleZ;
	}
}