package be.bluexin.rwbym.entity;


import net.minecraft.util.math.MathHelper;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class ModelApathy extends ModelBase {
	private final ModelRenderer Body;
	private final ModelRenderer HipBone1;
	private final ModelRenderer HipBone7;
	private final ModelRenderer HipBone5;
	private final ModelRenderer HipBone6;
	private final ModelRenderer HipBone4;
	private final ModelRenderer HipBone3;
	private final ModelRenderer HipBone2;
	private final ModelRenderer Spine6;
	private final ModelRenderer Spine5;
	private final ModelRenderer Spine4;
	private final ModelRenderer Spine3;
	private final ModelRenderer Spine2;
	private final ModelRenderer Spine1;
	private final ModelRenderer RightAss;
	private final ModelRenderer LeftAss;
	private final ModelRenderer Hip2;
	private final ModelRenderer Hip;
	private final ModelRenderer Abs3;
	private final ModelRenderer Abs2;
	private final ModelRenderer Abs1;
	private final ModelRenderer TorsoBone6;
	private final ModelRenderer TorsoBone5;
	private final ModelRenderer TorsoBone4;
	private final ModelRenderer TorsoBone3;
	private final ModelRenderer TorsoBone2;
	private final ModelRenderer TorsoBone1;
	private final ModelRenderer Torso;
	private final ModelRenderer Neck4;
	private final ModelRenderer Neck3;
	private final ModelRenderer Neck1;
	private final ModelRenderer Head;
	private final ModelRenderer HeadMouth5;
	private final ModelRenderer HeadMouth4;
	private final ModelRenderer HeadMouth3;
	private final ModelRenderer HeadMouth1;
	private final ModelRenderer HeadJaw9;
	private final ModelRenderer HeadJaw8;
	private final ModelRenderer HeadJaw7;
	private final ModelRenderer HeadJaw6;
	private final ModelRenderer HeadJaw5;
	private final ModelRenderer HeadJaw4;
	private final ModelRenderer HeadJaw3;
	private final ModelRenderer HeadJaw2;
	private final ModelRenderer HeadJaw1;
	private final ModelRenderer HeadLowerTeeth;
	private final ModelRenderer HeadUpperTeeth;
	private final ModelRenderer HeadNose1;
	private final ModelRenderer HeadLeft;
	private final ModelRenderer HeadRight;
	private final ModelRenderer HeadJaw10;
	private final ModelRenderer HeadJaw11;
	private final ModelRenderer Neck2;
	private final ModelRenderer RightArm;
	private final ModelRenderer RightArm23;
	private final ModelRenderer RightArm22;
	private final ModelRenderer RightArm21;
	private final ModelRenderer RightArm20;
	private final ModelRenderer RightArm19;
	private final ModelRenderer RightArm18;
	private final ModelRenderer RightArm17;
	private final ModelRenderer RightArm16;
	private final ModelRenderer RightArm15;
	private final ModelRenderer RightArm14;
	private final ModelRenderer RightArm13;
	private final ModelRenderer RightArm12;
	private final ModelRenderer RightArm11;
	private final ModelRenderer RightArm10;
	private final ModelRenderer RightArm9;
	private final ModelRenderer RightArm8;
	private final ModelRenderer RightArm7;
	private final ModelRenderer RightArm6;
	private final ModelRenderer RightArm5;
	private final ModelRenderer RightArm4;
	private final ModelRenderer RightArm3;
	private final ModelRenderer RightArm2;
	private final ModelRenderer RightArm1;
	private final ModelRenderer LeftArm;
	private final ModelRenderer LeftArm1;
	private final ModelRenderer LeftArm2;
	private final ModelRenderer LeftArm3;
	private final ModelRenderer LeftArm4;
	private final ModelRenderer LeftArm5;
	private final ModelRenderer LeftArm6;
	private final ModelRenderer LeftArm7;
	private final ModelRenderer LeftArm8;
	private final ModelRenderer LeftArm9;
	private final ModelRenderer LeftArm10;
	private final ModelRenderer LeftArm11;
	private final ModelRenderer LeftArm12;
	private final ModelRenderer LeftArm13;
	private final ModelRenderer LeftArm14;
	private final ModelRenderer LeftArm15;
	private final ModelRenderer LeftArm16;
	private final ModelRenderer LeftArm17;
	private final ModelRenderer LeftArm18;
	private final ModelRenderer LeftArm19;
	private final ModelRenderer LeftArm20;
	private final ModelRenderer LeftArm21;
	private final ModelRenderer LeftArm22;
	private final ModelRenderer LeftArm23;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer LeftLeg1;
	private final ModelRenderer LeftLeg2;
	private final ModelRenderer LeftLeg3;
	private final ModelRenderer LeftLeg4;
	private final ModelRenderer LeftLeg5;
	private final ModelRenderer LeftLeg6;
	private final ModelRenderer LeftLeg7;
	private final ModelRenderer LeftLeg8;
	private final ModelRenderer LeftLeg9;
	private final ModelRenderer LeftLeg10;
	private final ModelRenderer RightLeg;
	private final ModelRenderer RightLeg1;
	private final ModelRenderer RightLeg2;
	private final ModelRenderer RightLeg3;
	private final ModelRenderer RightLeg4;
	private final ModelRenderer RightLeg5;
	private final ModelRenderer RightLeg6;
	private final ModelRenderer RightLeg7;
	private final ModelRenderer RightLeg8;
	private final ModelRenderer RightLeg9;
	private final ModelRenderer RightLeg10;

	public ModelApathy() {
		textureWidth = 128;
		textureHeight = 128;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, 0.0F);

		HipBone1 = new ModelRenderer(this);
		HipBone1.setRotationPoint(1.7F, -48.0F, -1.5F);
		setRotationAngle(HipBone1, 0.0F, 0.0F, 0.7785F);
		Body.addChild(HipBone1);
		HipBone1.cubeList.add(new ModelBox(HipBone1, 0, 53, -1.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, true));

		HipBone7 = new ModelRenderer(this);
		HipBone7.setRotationPoint(-4.0F, -56.5F, 0.5F);
		setRotationAngle(HipBone7, -0.9841F, 0.0F, -0.7436F);
		Body.addChild(HipBone7);
		HipBone7.cubeList.add(new ModelBox(HipBone7, 5, 50, -2.0882F, -5.8908F, -1.2107F, 1, 6, 1, 0.0F, true));

		HipBone5 = new ModelRenderer(this);
		HipBone5.setRotationPoint(-2.5F, -54.0F, -1.5F);
		setRotationAngle(HipBone5, -0.3149F, 0.0F, -0.7436F);
		Body.addChild(HipBone5);
		HipBone5.cubeList.add(new ModelBox(HipBone5, 10, 50, -2.0F, -4.0F, 0.0F, 2, 4, 1, 0.0F, true));

		HipBone6 = new ModelRenderer(this);
		HipBone6.setRotationPoint(6.0F, -56.5F, 0.5F);
		setRotationAngle(HipBone6, -0.9841F, 0.0F, 0.7436F);
		Body.addChild(HipBone6);
		HipBone6.cubeList.add(new ModelBox(HipBone6, 5, 50, 1.0882F, -5.8908F, -1.2107F, 1, 6, 1, 0.0F, true));

		HipBone4 = new ModelRenderer(this);
		HipBone4.setRotationPoint(4.5F, -54.0F, -1.5F);
		setRotationAngle(HipBone4, -0.3149F, 0.0F, 0.7436F);
		Body.addChild(HipBone4);
		HipBone4.cubeList.add(new ModelBox(HipBone4, 10, 50, 0.0F, -4.0F, 0.0F, 2, 4, 1, 0.0F, true));

		HipBone3 = new ModelRenderer(this);
		HipBone3.setRotationPoint(-2.5F, -54.0F, -1.5F);
		setRotationAngle(HipBone3, 0.0F, 0.0F, -0.7436F);
		Body.addChild(HipBone3);
		HipBone3.cubeList.add(new ModelBox(HipBone3, 17, 50, -2.0F, 0.0F, 0.0F, 2, 7, 1, 0.0F, true));

		HipBone2 = new ModelRenderer(this);
		HipBone2.setRotationPoint(4.5F, -54.0F, -1.5F);
		setRotationAngle(HipBone2, 0.0F, 0.0F, 0.7436F);
		Body.addChild(HipBone2);
		HipBone2.cubeList.add(new ModelBox(HipBone2, 17, 50, 0.0F, 0.0F, 0.0F, 2, 7, 1, 0.0F, true));

		Spine6 = new ModelRenderer(this);
		Spine6.setRotationPoint(1.0F, -60.0F, 3.0F);
		Body.addChild(Spine6);
		Spine6.cubeList.add(new ModelBox(Spine6, 75, 96, -0.5F, -2.0F, -0.5F, 1, 1, 1, 0.0F, true));

		Spine5 = new ModelRenderer(this);
		Spine5.setRotationPoint(1.0F, -60.0F, 3.0F);
		Body.addChild(Spine5);
		Spine5.cubeList.add(new ModelBox(Spine5, 75, 96, -0.5F, -6.0F, 0.3F, 1, 1, 1, 0.0F, true));

		Spine4 = new ModelRenderer(this);
		Spine4.setRotationPoint(1.0F, -60.0F, 3.0F);
		Body.addChild(Spine4);
		Spine4.cubeList.add(new ModelBox(Spine4, 75, 96, -0.5F, -10.0F, 0.8F, 1, 1, 1, 0.0F, true));

		Spine3 = new ModelRenderer(this);
		Spine3.setRotationPoint(1.0F, -60.0F, 3.0F);
		Body.addChild(Spine3);
		Spine3.cubeList.add(new ModelBox(Spine3, 75, 96, -0.5F, -13.5F, 1.3F, 1, 1, 1, 0.0F, true));

		Spine2 = new ModelRenderer(this);
		Spine2.setRotationPoint(1.0F, -60.0F, 3.0F);
		Body.addChild(Spine2);
		Spine2.cubeList.add(new ModelBox(Spine2, 70, 96, -0.5F, -17.0F, 1.7F, 1, 1, 1, 0.0F, true));

		Spine1 = new ModelRenderer(this);
		Spine1.setRotationPoint(1.0F, -60.0F, 3.0F);
		Body.addChild(Spine1);
		Spine1.cubeList.add(new ModelBox(Spine1, 65, 96, -0.5F, -21.0F, 2.0F, 1, 2, 1, 0.0F, true));

		RightAss = new ModelRenderer(this);
		RightAss.setRotationPoint(7.5F, -51.0F, -0.5F);
		setRotationAngle(RightAss, -0.0372F, 0.0372F, 1.1351F);
		Body.addChild(RightAss);
		RightAss.cubeList.add(new ModelBox(RightAss, 107, 15, -4.3F, 0.0F, 0.0F, 4, 4, 5, 0.0F, true));

		LeftAss = new ModelRenderer(this);
		LeftAss.setRotationPoint(-5.5F, -51.0F, -0.5F);
		setRotationAngle(LeftAss, -0.0372F, -0.0372F, -1.1351F);
		Body.addChild(LeftAss);
		LeftAss.cubeList.add(new ModelBox(LeftAss, 107, 15, 0.3F, 0.0F, 0.0F, 4, 4, 5, 0.0F, true));

		Hip2 = new ModelRenderer(this);
		Hip2.setRotationPoint(2.5F, -51.0F, 0.5F);
		Body.addChild(Hip2);
		Hip2.cubeList.add(new ModelBox(Hip2, 117, 9, -3.0F, 0.0F, 0.0F, 3, 1, 2, 0.0F, true));

		Hip = new ModelRenderer(this);
		Hip.setRotationPoint(6.5F, -55.0F, 0.0F);
		Body.addChild(Hip);
		Hip.cubeList.add(new ModelBox(Hip, 92, 0, -11.0F, 0.0F, 0.0F, 11, 4, 3, 0.0F, true));

		Abs3 = new ModelRenderer(this);
		Abs3.setRotationPoint(0.0F, -59.5F, 0.0F);
		setRotationAngle(Abs3, 0.0F, 0.0F, 0.2056F);
		Body.addChild(Abs3);
		Abs3.cubeList.add(new ModelBox(Abs3, 107, 7, -1.0F, 0.0F, 0.0F, 1, 5, 3, 0.0F, true));

		Abs2 = new ModelRenderer(this);
		Abs2.setRotationPoint(2.0F, -59.5F, 0.0F);
		setRotationAngle(Abs2, 0.0F, 0.0F, -0.2056F);
		Body.addChild(Abs2);
		Abs2.cubeList.add(new ModelBox(Abs2, 107, 7, 0.0F, 0.0F, 0.0F, 1, 5, 3, 0.0F, true));

		Abs1 = new ModelRenderer(this);
		Abs1.setRotationPoint(3.0F, -68.0F, 0.0F);
		Body.addChild(Abs1);
		Abs1.cubeList.add(new ModelBox(Abs1, 92, 74, -4.0F, -10.0F, 0.0F, 4, 23, 3, 0.0F, true));

		TorsoBone6 = new ModelRenderer(this);
		TorsoBone6.setRotationPoint(1.0F, -60.0F, 3.0F);
		setRotationAngle(TorsoBone6, -1.0123F, -0.4887F, -0.6283F);
		Body.addChild(TorsoBone6);
		TorsoBone6.cubeList.add(new ModelBox(TorsoBone6, 59, 81, 3.0F, -12.9F, -23.4F, 1, 8, 1, 0.0F, true));

		TorsoBone5 = new ModelRenderer(this);
		TorsoBone5.setRotationPoint(1.0F, -60.0F, 3.0F);
		setRotationAngle(TorsoBone5, -1.0123F, 0.4887F, 0.6283F);
		Body.addChild(TorsoBone5);
		TorsoBone5.cubeList.add(new ModelBox(TorsoBone5, 59, 91, -4.0F, -12.9F, -23.4F, 1, 8, 1, 0.0F, true));

		TorsoBone4 = new ModelRenderer(this);
		TorsoBone4.setRotationPoint(1.0F, -60.0F, 3.0F);
		setRotationAngle(TorsoBone4, -0.0873F, 0.0F, -1.4137F);
		Body.addChild(TorsoBone4);
		TorsoBone4.cubeList.add(new ModelBox(TorsoBone4, 70, 88, 19.8597F, -10.4472F, -6.7002F, 1, 5, 1, 0.0F, true));

		TorsoBone3 = new ModelRenderer(this);
		TorsoBone3.setRotationPoint(1.0F, -60.0F, 3.0F);
		setRotationAngle(TorsoBone3, -0.0873F, 0.0F, 1.4137F);
		Body.addChild(TorsoBone3);
		TorsoBone3.cubeList.add(new ModelBox(TorsoBone3, 65, 88, -20.8597F, -10.4472F, -6.7002F, 1, 5, 1, 0.0F, true));

		TorsoBone2 = new ModelRenderer(this);
		TorsoBone2.setRotationPoint(1.0F, -60.0F, 3.0F);
		setRotationAngle(TorsoBone2, 0.0F, 0.0F, -0.6283F);
		Body.addChild(TorsoBone2);
		TorsoBone2.cubeList.add(new ModelBox(TorsoBone2, 70, 81, 9.5F, -19.0F, -6.2F, 1, 5, 1, 0.0F, true));

		TorsoBone1 = new ModelRenderer(this);
		TorsoBone1.setRotationPoint(1.0F, -60.0F, 3.0F);
		setRotationAngle(TorsoBone1, 0.0F, 0.0F, 0.6283F);
		Body.addChild(TorsoBone1);
		TorsoBone1.cubeList.add(new ModelBox(TorsoBone1, 65, 81, -10.5F, -19.0F, -6.2F, 1, 5, 1, 0.0F, true));

		Torso = new ModelRenderer(this);
		Torso.setRotationPoint(1.0F, -60.0F, 3.0F);
		setRotationAngle(Torso, -0.1115F, 0.0F, 0.0F);
		Body.addChild(Torso);
		Torso.cubeList.add(new ModelBox(Torso, 44, 0, -7.5F, -21.0F, -8.0F, 15, 21, 8, 0.0F, true));

		Neck4 = new ModelRenderer(this);
		Neck4.setRotationPoint(4.7F, -86.0F, 0.7F);
		setRotationAngle(Neck4, 0.1859F, -0.0546F, -0.717F);
		Body.addChild(Neck4);
		Neck4.cubeList.add(new ModelBox(Neck4, 77, 30, -3.0F, 0.0F, -2.0F, 3, 8, 4, 0.0F, true));

		Neck3 = new ModelRenderer(this);
		Neck3.setRotationPoint(-2.7F, -86.0F, 0.7F);
		setRotationAngle(Neck3, 0.1904F, 0.0546F, 0.717F);
		Body.addChild(Neck3);
		Neck3.cubeList.add(new ModelBox(Neck3, 77, 30, 0.0F, 0.0F, -2.0F, 3, 8, 4, 0.0F, true));

		Neck1 = new ModelRenderer(this);
		Neck1.setRotationPoint(1.0F, -81.0F, 5.7F);
		setRotationAngle(Neck1, 0.4833F, 0.0F, 0.0F);
		Body.addChild(Neck1);
		Neck1.cubeList.add(new ModelBox(Neck1, 101, 25, -4.0F, -13.0F, -5.4F, 8, 13, 5, 0.0F, true));

		Head = new ModelRenderer(this);
		Head.setRotationPoint(1.0F, -68.0F, -2.0F);
		Head.cubeList.add(new ModelBox(Head, 44, 35, -3.5F, -7.0F, -6.5F, 7, 1, 8, 0.0F, true));
		Head.cubeList.add(new ModelBox(Head, 43, 45, -4.0F, -6.0F, -7.0F, 8, 8, 9, 0.0F, true));
		Head.cubeList.add(new ModelBox(Head, 101, 58, -2.0F, 0.0F, -8.1F, 4, 2, 2, 0.0F, true));
		Head.cubeList.add(new ModelBox(Head, 89, 66, -3.0F, 1.0F, -4.3F, 6, 3, 1, 0.0F, true));

		HeadMouth5 = new ModelRenderer(this);
		HeadMouth5.setRotationPoint(0.0F, 1.0F, 0.0F);
		setRotationAngle(HeadMouth5, 0.1396F, 0.0F, 0.1745F);
		Head.addChild(HeadMouth5);
		HeadMouth5.cubeList.add(new ModelBox(HeadMouth5, 111, 65, 1.3F, -1.0F, -5.9F, 1, 5, 1, 0.0F, true));

		HeadMouth4 = new ModelRenderer(this);
		HeadMouth4.setRotationPoint(0.0F, 1.0F, 0.0F);
		setRotationAngle(HeadMouth4, 0.1396F, 0.0F, -0.1745F);
		Head.addChild(HeadMouth4);
		HeadMouth4.cubeList.add(new ModelBox(HeadMouth4, 116, 65, -2.3333F, -1.0F, -5.9F, 1, 5, 1, 0.0F, true));

		HeadMouth3 = new ModelRenderer(this);
		HeadMouth3.setRotationPoint(0.0F, 1.0F, 0.0F);
		setRotationAngle(HeadMouth3, -0.5236F, 0.0F, 0.0F);
		Head.addChild(HeadMouth3);
		HeadMouth3.cubeList.add(new ModelBox(HeadMouth3, 78, 66, -2.0F, 4.0F, -2.2F, 4, 3, 1, 0.0F, true));

		HeadMouth1 = new ModelRenderer(this);
		HeadMouth1.setRotationPoint(0.0F, 1.0F, 0.0F);
		setRotationAngle(HeadMouth1, -0.5236F, 0.0F, 0.0F);
		Head.addChild(HeadMouth1);
		HeadMouth1.cubeList.add(new ModelBox(HeadMouth1, 104, 64, -1.0F, 1.3F, -2.2F, 2, 7, 1, 0.0F, true));

		HeadJaw9 = new ModelRenderer(this);
		HeadJaw9.setRotationPoint(0.0F, 1.0F, 0.0F);
		setRotationAngle(HeadJaw9, -0.5236F, 0.0F, -0.2793F);
		Head.addChild(HeadJaw9);
		HeadJaw9.cubeList.add(new ModelBox(HeadJaw9, 53, 63, -3.4F, 4.5F, -2.7F, 1, 3, 1, 0.0F, true));

		HeadJaw8 = new ModelRenderer(this);
		HeadJaw8.setRotationPoint(0.0F, 1.0F, 0.0F);
		setRotationAngle(HeadJaw8, -0.5236F, 0.0F, 0.2793F);
		Head.addChild(HeadJaw8);
		HeadJaw8.cubeList.add(new ModelBox(HeadJaw8, 53, 63, 2.4F, 4.5F, -2.7F, 1, 3, 1, 0.0F, true));

		HeadJaw7 = new ModelRenderer(this);
		HeadJaw7.setRotationPoint(0.0F, 2.0F, 0.0F);
		setRotationAngle(HeadJaw7, 0.0F, 0.0F, -0.2793F);
		Head.addChild(HeadJaw7);
		HeadJaw7.cubeList.add(new ModelBox(HeadJaw7, 43, 63, -3.1F, -1.7F, -5.0F, 1, 4, 1, 0.0F, true));

		HeadJaw6 = new ModelRenderer(this);
		HeadJaw6.setRotationPoint(0.0F, 2.0F, 0.0F);
		setRotationAngle(HeadJaw6, 0.0F, 0.0F, 0.2793F);
		Head.addChild(HeadJaw6);
		HeadJaw6.cubeList.add(new ModelBox(HeadJaw6, 43, 63, 2.1F, -1.7F, -5.0F, 1, 4, 1, 0.0F, true));

		HeadJaw5 = new ModelRenderer(this);
		HeadJaw5.setRotationPoint(0.0F, 1.0F, 0.0F);
		setRotationAngle(HeadJaw5, 0.0F, 0.0F, -0.4014F);
		Head.addChild(HeadJaw5);
		HeadJaw5.cubeList.add(new ModelBox(HeadJaw5, 48, 72, -4.0F, -0.6F, -4.0F, 1, 2, 1, 0.0F, true));

		HeadJaw4 = new ModelRenderer(this);
		HeadJaw4.setRotationPoint(0.0F, 1.0F, 0.0F);
		setRotationAngle(HeadJaw4, 0.0F, 0.0F, 0.4014F);
		Head.addChild(HeadJaw4);
		HeadJaw4.cubeList.add(new ModelBox(HeadJaw4, 48, 72, 3.0F, -0.6F, -4.0F, 1, 2, 1, 0.0F, true));

		HeadJaw3 = new ModelRenderer(this);
		HeadJaw3.setRotationPoint(0.0F, 1.0F, 0.0F);
		setRotationAngle(HeadJaw3, -0.5236F, 0.0F, -0.4014F);
		Head.addChild(HeadJaw3);
		HeadJaw3.cubeList.add(new ModelBox(HeadJaw3, 48, 63, -4.0F, 2.7F, -2.9F, 1, 5, 1, 0.0F, true));

		HeadJaw2 = new ModelRenderer(this);
		HeadJaw2.setRotationPoint(0.0F, 1.0F, 0.0F);
		setRotationAngle(HeadJaw2, -0.5236F, 0.0F, 0.4014F);
		Head.addChild(HeadJaw2);
		HeadJaw2.cubeList.add(new ModelBox(HeadJaw2, 48, 63, 3.0F, 2.7F, -2.9F, 1, 5, 1, 0.0F, true));

		HeadJaw1 = new ModelRenderer(this);
		HeadJaw1.setRotationPoint(0.0F, 1.0F, 0.0F);
		setRotationAngle(HeadJaw1, 0.3142F, 0.0F, 0.0F);
		Head.addChild(HeadJaw1);
		HeadJaw1.cubeList.add(new ModelBox(HeadJaw1, 52, 70, -1.5F, 3.7F, -8.0F, 3, 1, 1, 0.0F, true));

		HeadLowerTeeth = new ModelRenderer(this);
		HeadLowerTeeth.setRotationPoint(0.0F, 1.0F, 0.0F);
		setRotationAngle(HeadLowerTeeth, 0.3142F, 0.0F, 0.0F);
		Head.addChild(HeadLowerTeeth);
		HeadLowerTeeth.cubeList.add(new ModelBox(HeadLowerTeeth, 78, 58, -1.5F, 1.9F, -7.8F, 3, 2, 1, 0.0F, true));

		HeadUpperTeeth = new ModelRenderer(this);
		HeadUpperTeeth.setRotationPoint(0.0F, 1.0F, 0.0F);
		setRotationAngle(HeadUpperTeeth, 0.0698F, 0.0F, 0.0F);
		Head.addChild(HeadUpperTeeth);
		HeadUpperTeeth.cubeList.add(new ModelBox(HeadUpperTeeth, 87, 58, -2.0F, -0.1F, -7.9F, 4, 2, 2, 0.0F, true));

		HeadNose1 = new ModelRenderer(this);
		HeadNose1.setRotationPoint(0.0F, 1.0F, 0.0F);
		setRotationAngle(HeadNose1, -0.5411F, 0.0F, 0.0F);
		Head.addChild(HeadNose1);
		HeadNose1.cubeList.add(new ModelBox(HeadNose1, 115, 58, -1.0F, 1.3146F, -7.4581F, 2, 2, 2, 0.0F, true));

		HeadLeft = new ModelRenderer(this);
		HeadLeft.setRotationPoint(0.0F, 1.0F, 0.0F);
		setRotationAngle(HeadLeft, 0.0F, 0.0F, -0.0524F);
		Head.addChild(HeadLeft);
		HeadLeft.cubeList.add(new ModelBox(HeadLeft, 105, 43, -4.5F, -6.5F, -6.5F, 1, 6, 8, 0.0F, true));

		HeadRight = new ModelRenderer(this);
		HeadRight.setRotationPoint(0.0F, 1.0F, 0.0F);
		setRotationAngle(HeadRight, 0.0F, 0.0F, 0.0524F);
		Head.addChild(HeadRight);
		HeadRight.cubeList.add(new ModelBox(HeadRight, 82, 43, 3.5F, -6.5F, -6.5F, 1, 6, 8, 0.0F, true));

		HeadJaw10 = new ModelRenderer(this);
		HeadJaw10.setRotationPoint(0.0F, 1.0F, 0.0F);
		setRotationAngle(HeadJaw10, 0.0F, 0.0F, -0.4014F);
		Head.addChild(HeadJaw10);
		HeadJaw10.cubeList.add(new ModelBox(HeadJaw10, 43, 69, -4.0F, -0.8F, -5.0F, 1, 4, 1, 0.0F, true));

		HeadJaw11 = new ModelRenderer(this);
		HeadJaw11.setRotationPoint(0.0F, 1.0F, 0.0F);
		setRotationAngle(HeadJaw11, 0.0F, 0.0F, 0.4014F);
		Head.addChild(HeadJaw11);
		HeadJaw11.cubeList.add(new ModelBox(HeadJaw11, 43, 69, 3.0F, -0.8F, -5.0F, 1, 4, 1, 0.0F, true));

		Neck2 = new ModelRenderer(this);
		Neck2.setRotationPoint(0.0F, 2.0F, 0.0F);
		setRotationAngle(Neck2, -0.2094F, 0.0F, 0.0F);
		Head.addChild(Neck2);
		Neck2.cubeList.add(new ModelBox(Neck2, 59, 70, -2.5F, -1.0F, -3.3F, 5, 4, 5, 0.0F, true));

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(9.0F, -56.0F, 2.0F);

		RightArm23 = new ModelRenderer(this);
		RightArm23.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(RightArm23, -0.6458F, 0.0F, 0.2618F);
		RightArm.addChild(RightArm23);
		RightArm23.cubeList.add(new ModelBox(RightArm23, 0, 40, 9.5F, 13.5F, 14.5F, 1, 6, 1, 0.0F, true));

		RightArm22 = new ModelRenderer(this);
		RightArm22.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(RightArm22, -0.3491F, 0.0F, 0.2967F);
		RightArm.addChild(RightArm22);
		RightArm22.cubeList.add(new ModelBox(RightArm22, 64, 101, 27.3F, 56.0F, 22.9F, 1, 4, 1, 0.0F, true));

		RightArm21 = new ModelRenderer(this);
		RightArm21.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(RightArm21, -0.1745F, 0.0F, 0.3491F);
		RightArm.addChild(RightArm21);
		RightArm21.cubeList.add(new ModelBox(RightArm21, 58, 101, 30.9F, 55.9F, 10.6F, 1, 5, 1, 0.0F, true));

		RightArm20 = new ModelRenderer(this);
		RightArm20.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(RightArm20, -0.0873F, 0.0F, 0.2443F);
		RightArm.addChild(RightArm20);
		RightArm20.cubeList.add(new ModelBox(RightArm20, 52, 101, 23.0F, 60.6F, 4.7F, 1, 4, 1, 0.0F, true));

		RightArm19 = new ModelRenderer(this);
		RightArm19.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(RightArm19, 0.192F, 0.0F, -0.2269F);
		RightArm.addChild(RightArm19);
		RightArm19.cubeList.add(new ModelBox(RightArm19, 64, 107, -6.5F, 65.5F, -10.1F, 1, 7, 1, 0.0F, true));

		RightArm18 = new ModelRenderer(this);
		RightArm18.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(RightArm18, 0.0873F, 0.0F, 0.0349F);
		RightArm.addChild(RightArm18);
		RightArm18.cubeList.add(new ModelBox(RightArm18, 58, 108, 12.4F, 63.8F, -4.8F, 1, 8, 1, 0.0F, true));

		RightArm17 = new ModelRenderer(this);
		RightArm17.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(RightArm17, 0.1047F, 0.0F, -0.1396F);
		RightArm.addChild(RightArm17);
		RightArm17.cubeList.add(new ModelBox(RightArm17, 52, 108, -0.9F, 65.0F, -7.4F, 1, 7, 1, 0.0F, true));

		RightArm16 = new ModelRenderer(this);
		RightArm16.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(RightArm16, -0.4189F, 0.0F, 0.8029F);
		RightArm.addChild(RightArm16);
		RightArm16.cubeList.add(new ModelBox(RightArm16, 64, 116, 58.7F, 37.3F, 20.8F, 1, 8, 1, 0.0F, true));

		RightArm15 = new ModelRenderer(this);
		RightArm15.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(RightArm15, -0.2618F, 0.0F, 0.7505F);
		RightArm.addChild(RightArm15);
		RightArm15.cubeList.add(new ModelBox(RightArm15, 58, 118, 56.0F, 43.7F, 13.1F, 1, 8, 1, 0.0F, true));

		RightArm14 = new ModelRenderer(this);
		RightArm14.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(RightArm14, -0.2618F, 0.0F, 0.6283F);
		RightArm.addChild(RightArm14);
		RightArm14.cubeList.add(new ModelBox(RightArm14, 52, 117, 48.9F, 50.1333F, 13.5F, 1, 8, 1, 0.0F, true));

		RightArm13 = new ModelRenderer(this);
		RightArm13.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(RightArm13, 0.0F, 0.0F, -0.1222F);
		RightArm.addChild(RightArm13);
		RightArm13.cubeList.add(new ModelBox(RightArm13, 41, 118, -5.8F, 72.8F, -1.5F, 2, 5, 3, 0.0F, true));

		RightArm12 = new ModelRenderer(this);
		RightArm12.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(RightArm12, 0.0F, 0.0F, -0.1222F);
		RightArm.addChild(RightArm12);
		RightArm12.cubeList.add(new ModelBox(RightArm12, 42, 109, -5.8F, 66.8F, -1.0F, 2, 6, 2, 0.0F, true));

		RightArm11 = new ModelRenderer(this);
		RightArm11.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(RightArm11, 0.0F, 0.0F, -0.0524F);
		RightArm.addChild(RightArm11);
		RightArm11.cubeList.add(new ModelBox(RightArm11, 16, 111, -1.2F, 52.0F, -1.0F, 2, 15, 2, 0.0F, true));

		RightArm10 = new ModelRenderer(this);
		RightArm10.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(RightArm10, -0.0349F, 0.0F, 0.0524F);
		RightArm.addChild(RightArm10);
		RightArm10.cubeList.add(new ModelBox(RightArm10, 25, 107, 5.1F, 31.9F, 1.8F, 1, 20, 1, 0.0F, true));

		RightArm9 = new ModelRenderer(this);
		RightArm9.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(RightArm9, 0.2094F, 0.0F, -0.2443F);
		RightArm.addChild(RightArm9);
		RightArm9.cubeList.add(new ModelBox(RightArm9, 9, 121, -4.5161F, 28.0075F, -6.0808F, 1, 4, 1, 0.0F, true));

		RightArm8 = new ModelRenderer(this);
		RightArm8.setRotationPoint(0.0F, 0.0F, 0.0F);
		RightArm.addChild(RightArm8);
		RightArm8.cubeList.add(new ModelBox(RightArm8, 30, 104, 1.5F, 29.0F, -1.0F, 1, 23, 1, 0.0F, true));

		RightArm7 = new ModelRenderer(this);
		RightArm7.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(RightArm7, -0.1745F, 0.0F, 0.0262F);
		RightArm.addChild(RightArm7);
		RightArm7.cubeList.add(new ModelBox(RightArm7, 35, 100, 0.9F, 5.5F, 1.8F, 3, 5, 1, 0.0F, true));

		RightArm6 = new ModelRenderer(this);
		RightArm6.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(RightArm6, 0.0F, 0.0F, -0.0471F);
		RightArm.addChild(RightArm6);
		RightArm6.cubeList.add(new ModelBox(RightArm6, 28, 89, 0.3F, 13.0F, -1.0F, 1, 12, 2, 0.0F, true));

		RightArm5 = new ModelRenderer(this);
		RightArm5.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(RightArm5, 0.0F, 0.0F, -0.1471F);
		RightArm.addChild(RightArm5);
		RightArm5.cubeList.add(new ModelBox(RightArm5, 16, 99, -1.0F, 4.0F, -1.0F, 2, 9, 2, 0.0F, true));

		RightArm4 = new ModelRenderer(this);
		RightArm4.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(RightArm4, 0.0F, 0.0F, 0.0418F);
		RightArm.addChild(RightArm4);
		RightArm4.cubeList.add(new ModelBox(RightArm4, 9, 103, 3.2F, 5.0F, -1.0F, 1, 15, 2, 0.0F, true));

		RightArm3 = new ModelRenderer(this);
		RightArm3.setRotationPoint(0.0F, 0.0F, 0.0F);
		RightArm.addChild(RightArm3);
		RightArm3.cubeList.add(new ModelBox(RightArm3, 0, 103, 1.5F, 6.0F, -1.0F, 2, 23, 2, 0.0F, true));

		RightArm2 = new ModelRenderer(this);
		RightArm2.setRotationPoint(0.0F, 0.0F, 0.0F);
		RightArm.addChild(RightArm2);
		RightArm2.cubeList.add(new ModelBox(RightArm2, 35, 89, -1.0F, 1.0F, -2.0F, 5, 5, 4, 0.0F, true));

		RightArm1 = new ModelRenderer(this);
		RightArm1.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(RightArm1, 0.0F, 0.0F, -1.0585F);
		RightArm.addChild(RightArm1);
		RightArm1.cubeList.add(new ModelBox(RightArm1, 28, 78, -1.9F, -2.0F, -2.0F, 3, 6, 4, 0.0F, true));

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(-7.0F, -56.0F, 2.0F);

		LeftArm1 = new ModelRenderer(this);
		LeftArm1.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(LeftArm1, 0.0F, 0.0F, 1.0585F);
		LeftArm.addChild(LeftArm1);
		LeftArm1.cubeList.add(new ModelBox(LeftArm1, 28, 78, -1.1F, -2.0F, -2.0F, 3, 6, 4, 0.0F, false));

		LeftArm2 = new ModelRenderer(this);
		LeftArm2.setRotationPoint(0.0F, 0.0F, 0.0F);
		LeftArm.addChild(LeftArm2);
		LeftArm2.cubeList.add(new ModelBox(LeftArm2, 35, 89, -4.0F, 1.0F, -2.0F, 5, 5, 4, 0.0F, false));

		LeftArm3 = new ModelRenderer(this);
		LeftArm3.setRotationPoint(0.0F, 0.0F, 0.0F);
		LeftArm.addChild(LeftArm3);
		LeftArm3.cubeList.add(new ModelBox(LeftArm3, 0, 103, -3.5F, 6.0F, -1.0F, 2, 23, 2, 0.0F, false));

		LeftArm4 = new ModelRenderer(this);
		LeftArm4.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(LeftArm4, 0.0F, 0.0F, -0.0418F);
		LeftArm.addChild(LeftArm4);
		LeftArm4.cubeList.add(new ModelBox(LeftArm4, 9, 103, -4.2F, 5.0F, -1.0F, 1, 15, 2, 0.0F, true));

		LeftArm5 = new ModelRenderer(this);
		LeftArm5.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(LeftArm5, 0.0F, 0.0F, 0.1471F);
		LeftArm.addChild(LeftArm5);
		LeftArm5.cubeList.add(new ModelBox(LeftArm5, 16, 99, -1.0F, 4.0F, -1.0F, 2, 9, 2, 0.0F, true));

		LeftArm6 = new ModelRenderer(this);
		LeftArm6.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(LeftArm6, 0.0F, 0.0F, 0.0471F);
		LeftArm.addChild(LeftArm6);
		LeftArm6.cubeList.add(new ModelBox(LeftArm6, 28, 89, -1.3F, 13.0F, -1.0F, 1, 12, 2, 0.0F, true));

		LeftArm7 = new ModelRenderer(this);
		LeftArm7.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(LeftArm7, -0.1745F, 0.0F, -0.0262F);
		LeftArm.addChild(LeftArm7);
		LeftArm7.cubeList.add(new ModelBox(LeftArm7, 35, 100, -3.9F, 5.5F, 1.8F, 3, 5, 1, 0.0F, false));

		LeftArm8 = new ModelRenderer(this);
		LeftArm8.setRotationPoint(0.0F, 0.0F, 0.0F);
		LeftArm.addChild(LeftArm8);
		LeftArm8.cubeList.add(new ModelBox(LeftArm8, 30, 104, -2.5F, 29.0F, -1.0F, 1, 23, 1, 0.0F, true));

		LeftArm9 = new ModelRenderer(this);
		LeftArm9.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(LeftArm9, 0.2094F, 0.0F, 0.2443F);
		LeftArm.addChild(LeftArm9);
		LeftArm9.cubeList.add(new ModelBox(LeftArm9, 9, 121, 3.5161F, 28.0075F, -6.0808F, 1, 4, 1, 0.0F, true));

		LeftArm10 = new ModelRenderer(this);
		LeftArm10.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(LeftArm10, -0.0349F, 0.0F, -0.0524F);
		LeftArm.addChild(LeftArm10);
		LeftArm10.cubeList.add(new ModelBox(LeftArm10, 25, 107, -6.1F, 31.9F, 1.8F, 1, 20, 1, 0.0F, true));

		LeftArm11 = new ModelRenderer(this);
		LeftArm11.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(LeftArm11, 0.0F, 0.0F, 0.0524F);
		LeftArm.addChild(LeftArm11);
		LeftArm11.cubeList.add(new ModelBox(LeftArm11, 16, 111, -0.8F, 52.0F, -1.0F, 2, 15, 2, 0.0F, true));

		LeftArm12 = new ModelRenderer(this);
		LeftArm12.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(LeftArm12, 0.0F, 0.0F, 0.1222F);
		LeftArm.addChild(LeftArm12);
		LeftArm12.cubeList.add(new ModelBox(LeftArm12, 42, 109, 3.8F, 66.8F, -1.0F, 2, 6, 2, 0.0F, true));

		LeftArm13 = new ModelRenderer(this);
		LeftArm13.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(LeftArm13, 0.0F, 0.0F, 0.1222F);
		LeftArm.addChild(LeftArm13);
		LeftArm13.cubeList.add(new ModelBox(LeftArm13, 41, 118, 3.8F, 72.8F, -1.5F, 2, 5, 3, 0.0F, false));

		LeftArm14 = new ModelRenderer(this);
		LeftArm14.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(LeftArm14, -0.2618F, 0.0F, -0.6283F);
		LeftArm.addChild(LeftArm14);
		LeftArm14.cubeList.add(new ModelBox(LeftArm14, 52, 117, -49.9F, 50.2F, 13.5F, 1, 8, 1, 0.0F, true));

		LeftArm15 = new ModelRenderer(this);
		LeftArm15.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(LeftArm15, -0.2618F, 0.0F, -0.7505F);
		LeftArm.addChild(LeftArm15);
		LeftArm15.cubeList.add(new ModelBox(LeftArm15, 58, 118, -57.0F, 43.7F, 13.1F, 1, 8, 1, 0.0F, true));

		LeftArm16 = new ModelRenderer(this);
		LeftArm16.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(LeftArm16, -0.4189F, 0.0F, -0.8029F);
		LeftArm.addChild(LeftArm16);
		LeftArm16.cubeList.add(new ModelBox(LeftArm16, 64, 116, -59.7F, 37.3F, 20.8F, 1, 8, 1, 0.0F, true));

		LeftArm17 = new ModelRenderer(this);
		LeftArm17.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(LeftArm17, 0.1047F, 0.0F, 0.1396F);
		LeftArm.addChild(LeftArm17);
		LeftArm17.cubeList.add(new ModelBox(LeftArm17, 52, 108, 0.1F, 65.0F, -7.4F, 1, 7, 1, 0.0F, true));

		LeftArm18 = new ModelRenderer(this);
		LeftArm18.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(LeftArm18, 0.0873F, 0.0F, -0.0349F);
		LeftArm.addChild(LeftArm18);
		LeftArm18.cubeList.add(new ModelBox(LeftArm18, 58, 108, -13.4F, 63.8F, -4.8F, 1, 8, 1, 0.0F, true));

		LeftArm19 = new ModelRenderer(this);
		LeftArm19.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(LeftArm19, 0.192F, 0.0F, 0.2269F);
		LeftArm.addChild(LeftArm19);
		LeftArm19.cubeList.add(new ModelBox(LeftArm19, 64, 107, 5.5F, 65.5F, -10.1F, 1, 7, 1, 0.0F, true));

		LeftArm20 = new ModelRenderer(this);
		LeftArm20.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(LeftArm20, -0.0873F, 0.0F, -0.2443F);
		LeftArm.addChild(LeftArm20);
		LeftArm20.cubeList.add(new ModelBox(LeftArm20, 52, 101, -24.0F, 60.6F, 4.7F, 1, 4, 1, 0.0F, true));

		LeftArm21 = new ModelRenderer(this);
		LeftArm21.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(LeftArm21, -0.1745F, 0.0F, -0.3491F);
		LeftArm.addChild(LeftArm21);
		LeftArm21.cubeList.add(new ModelBox(LeftArm21, 58, 101, -32.1F, 55.9F, 10.6F, 1, 5, 1, 0.0F, true));

		LeftArm22 = new ModelRenderer(this);
		LeftArm22.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(LeftArm22, -0.3491F, 0.0F, -0.2967F);
		LeftArm.addChild(LeftArm22);
		LeftArm22.cubeList.add(new ModelBox(LeftArm22, 64, 101, -28.3F, 56.0F, 22.9F, 1, 4, 1, 0.0F, true));

		LeftArm23 = new ModelRenderer(this);
		LeftArm23.setRotationPoint(-1.0F, 0.0F, 0.0F);
		setRotationAngle(LeftArm23, -0.6458F, 0.0F, -0.2618F);
		LeftArm.addChild(LeftArm23);
		LeftArm23.cubeList.add(new ModelBox(LeftArm23, 5, 40, -9.5F, 13.5F, 14.5F, 1, 6, 1, 0.0F, true));

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(-3.0F, -27.0F, 1.5F);

		LeftLeg1 = new ModelRenderer(this);
		LeftLeg1.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(LeftLeg1, -0.0372F, 0.0F, 0.0F);
		LeftLeg.addChild(LeftLeg1);
		LeftLeg1.cubeList.add(new ModelBox(LeftLeg1, 0, 58, -1.5F, 0.0F, -2.0F, 3, 18, 4, 0.0F, false));

		LeftLeg2 = new ModelRenderer(this);
		LeftLeg2.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(LeftLeg2, -0.0372F, 0.0F, -0.0785F);
		LeftLeg.addChild(LeftLeg2);
		LeftLeg2.cubeList.add(new ModelBox(LeftLeg2, 15, 59, -2.4F, -0.5F, -2.0F, 1, 12, 4, 0.0F, true));

		LeftLeg3 = new ModelRenderer(this);
		LeftLeg3.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(LeftLeg3, -0.0372F, 0.0F, 0.0948F);
		LeftLeg.addChild(LeftLeg3);
		LeftLeg3.cubeList.add(new ModelBox(LeftLeg3, 26, 58, 0.5F, -1.0F, -2.0F, 2, 14, 4, 0.0F, false));

		LeftLeg4 = new ModelRenderer(this);
		LeftLeg4.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(LeftLeg4, 0.0175F, 0.0F, 0.0F);
		LeftLeg.addChild(LeftLeg4);
		LeftLeg4.cubeList.add(new ModelBox(LeftLeg4, 7, 81, -1.0F, 17.9F, -2.0F, 2, 17, 2, 0.0F, true));

		LeftLeg5 = new ModelRenderer(this);
		LeftLeg5.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(LeftLeg5, 0.075F, 0.0F, 0.0F);
		LeftLeg.addChild(LeftLeg5);
		LeftLeg5.cubeList.add(new ModelBox(LeftLeg5, 0, 81, -1.0F, 17.0F, -3.6F, 2, 11, 1, 0.0F, true));

		LeftLeg6 = new ModelRenderer(this);
		LeftLeg6.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(LeftLeg6, -0.0634F, 0.0F, 0.0F);
		LeftLeg.addChild(LeftLeg6);
		LeftLeg6.cubeList.add(new ModelBox(LeftLeg6, 16, 81, -1.0F, 17.0F, 1.0F, 2, 8, 1, 0.0F, true));

		LeftLeg7 = new ModelRenderer(this);
		LeftLeg7.setRotationPoint(0.0F, 0.0F, 0.0F);
		LeftLeg.addChild(LeftLeg7);
		LeftLeg7.cubeList.add(new ModelBox(LeftLeg7, 23, 81, -0.5F, 34.0F, -1.0F, 1, 17, 1, 0.0F, true));

		LeftLeg8 = new ModelRenderer(this);
		LeftLeg8.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(LeftLeg8, 0.0F, -0.8727F, 0.0F);
		LeftLeg.addChild(LeftLeg8);
		LeftLeg8.cubeList.add(new ModelBox(LeftLeg8, 11, 42, -2.1F, 24.0F, -2.0F, 2, 3, 2, 0.0F, true));

		LeftLeg9 = new ModelRenderer(this);
		LeftLeg9.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(LeftLeg9, -0.5263F, -0.6078F, -0.1487F);
		LeftLeg.addChild(LeftLeg9);
		LeftLeg9.cubeList.add(new ModelBox(LeftLeg9, 16, 36, -5.0F, 17.0F, 13.0F, 0, 4, 1, 0.0F, true));

		LeftLeg10 = new ModelRenderer(this);
		LeftLeg10.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(LeftLeg10, -0.5263F, 0.6078F, 0.1487F);
		LeftLeg.addChild(LeftLeg10);
		LeftLeg10.cubeList.add(new ModelBox(LeftLeg10, 13, 36, 5.0F, 17.0F, 13.0F, 0, 4, 1, 0.0F, true));

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(5.0F, -27.0F, 1.5F);

		RightLeg1 = new ModelRenderer(this);
		RightLeg1.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(RightLeg1, -0.0372F, 0.0F, 0.0F);
		RightLeg.addChild(RightLeg1);
		RightLeg1.cubeList.add(new ModelBox(RightLeg1, 0, 58, -1.5F, 0.0F, -2.0F, 3, 18, 4, 0.0F, true));

		RightLeg2 = new ModelRenderer(this);
		RightLeg2.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(RightLeg2, -0.0372F, 0.0F, 0.0785F);
		RightLeg.addChild(RightLeg2);
		RightLeg2.cubeList.add(new ModelBox(RightLeg2, 15, 59, 1.4F, -0.5F, -2.0F, 1, 12, 4, 0.0F, true));

		RightLeg3 = new ModelRenderer(this);
		RightLeg3.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(RightLeg3, -0.0372F, 0.0F, -0.0947F);
		RightLeg.addChild(RightLeg3);
		RightLeg3.cubeList.add(new ModelBox(RightLeg3, 26, 58, -2.5F, -1.0F, -2.0F, 2, 14, 4, 0.0F, true));

		RightLeg4 = new ModelRenderer(this);
		RightLeg4.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(RightLeg4, 0.0175F, 0.0F, 0.0F);
		RightLeg.addChild(RightLeg4);
		RightLeg4.cubeList.add(new ModelBox(RightLeg4, 7, 81, -1.0F, 17.9F, -2.0F, 2, 17, 2, 0.0F, true));

		RightLeg5 = new ModelRenderer(this);
		RightLeg5.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(RightLeg5, 0.075F, 0.0F, 0.0F);
		RightLeg.addChild(RightLeg5);
		RightLeg5.cubeList.add(new ModelBox(RightLeg5, 0, 81, -1.0F, 17.0F, -3.6F, 2, 11, 1, 0.0F, true));

		RightLeg6 = new ModelRenderer(this);
		RightLeg6.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(RightLeg6, -0.0634F, 0.0F, 0.0F);
		RightLeg.addChild(RightLeg6);
		RightLeg6.cubeList.add(new ModelBox(RightLeg6, 16, 81, -1.0F, 17.0F, 1.0F, 2, 8, 1, 0.0F, true));

		RightLeg7 = new ModelRenderer(this);
		RightLeg7.setRotationPoint(0.0F, 0.0F, 0.0F);
		RightLeg.addChild(RightLeg7);
		RightLeg7.cubeList.add(new ModelBox(RightLeg7, 23, 81, -0.5F, 34.0F, -1.0F, 1, 17, 1, 0.0F, true));

		RightLeg8 = new ModelRenderer(this);
		RightLeg8.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(RightLeg8, 0.0F, -0.8727F, 0.0F);
		RightLeg.addChild(RightLeg8);
		RightLeg8.cubeList.add(new ModelBox(RightLeg8, 21, 42, -2.1F, 24.0F, -2.0F, 2, 3, 2, 0.0F, true));

		RightLeg9 = new ModelRenderer(this);
		RightLeg9.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(RightLeg9, -0.5263F, 0.6078F, 0.1487F);
		RightLeg.addChild(RightLeg9);
		RightLeg9.cubeList.add(new ModelBox(RightLeg9, 23, 36, 5.0F, 17.0F, 13.0F, 0, 4, 1, 0.0F, true));

		RightLeg10 = new ModelRenderer(this);
		RightLeg10.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(RightLeg10, -0.5263F, -0.6078F, -0.1487F);
		RightLeg.addChild(RightLeg10);
		RightLeg10.cubeList.add(new ModelBox(RightLeg10, 26, 36, -5.0F, 17.0F, 13.0F, 0, 4, 1, 0.0F, true));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		Body.render(f5);
		Head.render(f5);
		RightArm.render(f5);
		LeftArm.render(f5);
		LeftLeg.render(f5);
		RightLeg.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
	{
		this.Head.rotateAngleY = netHeadYaw * 0.017453292F;
		this.Body.rotateAngleY = 0.0F;
		float f = 1.0F;
		this.RightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f;
		this.LeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount / f;
		this.RightLeg.rotateAngleY = 0.0F;
		this.LeftLeg.rotateAngleY = 0.0F;
		this.RightLeg.rotateAngleZ = 0.0F;
		this.LeftLeg.rotateAngleZ = 0.0F;

	}
}