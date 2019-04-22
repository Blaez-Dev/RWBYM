package be.bluexin.rwbym.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class ModelCreep extends ModelBase {
  private final ModelRenderer Body;
  private final ModelRenderer BonyPlate1;
  private final ModelRenderer BonyPlate2;
  private final ModelRenderer BonyPlate3;
  private final ModelRenderer BonyPlate4;
  private final ModelRenderer BonyPlate5;
  private final ModelRenderer BonyPlate6;
  private final ModelRenderer BonyPlate7;
  private final ModelRenderer BonyPlate8;
  private final ModelRenderer BonyPlate9;
  private final ModelRenderer Tail;
  private final ModelRenderer Tail2;
  private final ModelRenderer Tail4;
  private final ModelRenderer Tail5;
  private final ModelRenderer Head;
  private final ModelRenderer Head1;
  private final ModelRenderer Head2;
  private final ModelRenderer Head3;
  private final ModelRenderer Head4;
  private final ModelRenderer Head5;
  private final ModelRenderer Head6;
  private final ModelRenderer Head7;
  private final ModelRenderer Head8;
  private final ModelRenderer Head9;
  private final ModelRenderer Head10;
  private final ModelRenderer Head11;
  private final ModelRenderer Head12;
  private final ModelRenderer Head13;
  private final ModelRenderer Teeth1;
  private final ModelRenderer Teeth2;
  private final ModelRenderer Teeth3;
  private final ModelRenderer Teeth4;
  private final ModelRenderer Teeth5;
  private final ModelRenderer Teeth6;
  private final ModelRenderer LeftLeg;
  private final ModelRenderer LLeg1;
  private final ModelRenderer LLeg2;
  private final ModelRenderer LLeg3;
  private final ModelRenderer LLeg4;
  private final ModelRenderer LLeg5;
  private final ModelRenderer LLeg6;
  private final ModelRenderer LLeg7;
  private final ModelRenderer LLeg8;
  private final ModelRenderer LFoot1;
  private final ModelRenderer RightLeg;
  private final ModelRenderer RLeg1;
  private final ModelRenderer RLeg2;
  private final ModelRenderer RLeg3;
  private final ModelRenderer RLeg4;
  private final ModelRenderer RLeg5;
  private final ModelRenderer RLeg6;
  private final ModelRenderer RLeg7;
  private final ModelRenderer RLeg8;
  private final ModelRenderer RFoot1;

  public ModelCreep() {
    textureWidth = 90;
    textureHeight = 90;

    Body = new ModelRenderer(this);
    Body.setRotationPoint(0.0F, 24.0F, 0.0F);
    Body.cubeList.add(new ModelBox(Body, 0, 41, -4.0F, -18.0F, -4.0F, 8, 9, 10, 0.0F, true));
    Body.cubeList.add(new ModelBox(Body, 0, 30, -2.5F, -18.5F, -3.5F, 5, 1, 9, 0.0F, true));
    Body.cubeList.add(new ModelBox(Body, 46, 75, -3.0F, -17.5F, -8.0F, 6, 7, 4, 0.0F, true));
    Body.cubeList.add(new ModelBox(Body, 46, 70, -2.5F, -18.0F, -7.0F, 5, 1, 3, 0.0F, true));
    Body.cubeList.add(new ModelBox(Body, 29, 66, -2.5F, -17.5F, -11.0F, 5, 6, 3, 0.0F, true));

    BonyPlate1 = new ModelRenderer(this);
    BonyPlate1.setRotationPoint(0.5F, -18.0F, -7.5F);
    setRotationAngle(BonyPlate1, 1.041F, 0.0F, 0.0F);
    Body.addChild(BonyPlate1);
    BonyPlate1.cubeList.add(new ModelBox(BonyPlate1, 46, 64, -1.0F, 0.0F, -1.0F, 1, 2, 3, 0.0F, true));

    BonyPlate2 = new ModelRenderer(this);
    BonyPlate2.setRotationPoint(0.5F, -20.0F, -2.3F);
    setRotationAngle(BonyPlate2, -0.6313F, 0.0F, 0.0F);
    Body.addChild(BonyPlate2);
    BonyPlate2.cubeList.add(new ModelBox(BonyPlate2, 0, 34, -1.0F, 0.0F, 0.0F, 1, 2, 2, 0.0F, true));

    BonyPlate3 = new ModelRenderer(this);
    BonyPlate3.setRotationPoint(0.5F, -20.3F, 2.7F);
    setRotationAngle(BonyPlate3, -0.9287F, 0.0F, 0.0F);
    Body.addChild(BonyPlate3);
    BonyPlate3.cubeList.add(new ModelBox(BonyPlate3, 0, 27, -1.0F, -1.0F, 0.0F, 1, 4, 2, 0.0F, true));

    BonyPlate4 = new ModelRenderer(this);
    BonyPlate4.setRotationPoint(0.5F, -19.1F, 6.9F);
    setRotationAngle(BonyPlate4, -0.78F, 0.0F, 0.0F);
    Body.addChild(BonyPlate4);
    BonyPlate4.cubeList.add(new ModelBox(BonyPlate4, 47, 38, -1.0F, -1.0F, 0.0F, 1, 3, 2, 0.0F, true));

    BonyPlate5 = new ModelRenderer(this);
    BonyPlate5.setRotationPoint(0.5F, -17.5F, 10.9F);
    setRotationAngle(BonyPlate5, -0.7428F, 0.0F, 0.0F);
    Body.addChild(BonyPlate5);
    BonyPlate5.cubeList.add(new ModelBox(BonyPlate5, 44, 27, -1.0F, -1.0F, 0.0F, 1, 2, 2, 0.0F, true));

    BonyPlate6 = new ModelRenderer(this);
    BonyPlate6.setRotationPoint(0.5F, -16.5F, 14.9F);
    setRotationAngle(BonyPlate6, -0.8544F, 0.0F, 0.0F);
    Body.addChild(BonyPlate6);
    BonyPlate6.cubeList.add(new ModelBox(BonyPlate6, 0, 18, -1.0F, -1.0F, 0.0F, 1, 2, 1, 0.0F, true));

    BonyPlate7 = new ModelRenderer(this);
    BonyPlate7.setRotationPoint(0.5F, -15.7F, 17.9F);
    setRotationAngle(BonyPlate7, -0.6859F, 0.0F, 0.0F);
    Body.addChild(BonyPlate7);
    BonyPlate7.cubeList.add(new ModelBox(BonyPlate7, 14, 18, -1.0F, -1.0F, 0.0F, 1, 2, 1, 0.0F, true));

    BonyPlate8 = new ModelRenderer(this);
    BonyPlate8.setRotationPoint(0.5F, -15.2F, 20.9F);
    setRotationAngle(BonyPlate8, -0.6859F, 0.0F, 0.0F);
    Body.addChild(BonyPlate8);
    BonyPlate8.cubeList.add(new ModelBox(BonyPlate8, 0, 5, -1.0F, -1.0F, 0.0F, 1, 1, 2, 0.0F, true));

    BonyPlate9 = new ModelRenderer(this);
    BonyPlate9.setRotationPoint(0.5F, -15.8F, 24.5F);
    setRotationAngle(BonyPlate9, -1.1321F, 0.0F, 0.0F);
    Body.addChild(BonyPlate9);
    BonyPlate9.cubeList.add(new ModelBox(BonyPlate9, 18, 0, -1.0F, -1.0F, 0.0F, 1, 2, 1, 0.0F, true));

    Tail = new ModelRenderer(this);
    Tail.setRotationPoint(0.0F, 0.0F, 0.0F);
    Body.addChild(Tail);
    Tail.cubeList.add(new ModelBox(Tail, 29, 40, -3.0F, -17.5F, 6.0F, 6, 6, 4, 0.0F, true));
    Tail.cubeList.add(new ModelBox(Tail, 0, 17, -2.0F, -15.5F, 14.0F, 4, 4, 5, 0.0F, true));
    Tail.cubeList.add(new ModelBox(Tail, 36, 51, -2.5F, -12.5F, 6.0F, 5, 2, 3, 0.0F, true));

    Tail2 = new ModelRenderer(this);
    Tail2.setRotationPoint(2.5F, -17.0F, 10.0F);
    setRotationAngle(Tail2, -0.1487F, 0.0F, 0.0F);
    Tail.addChild(Tail2);
    Tail2.cubeList.add(new ModelBox(Tail2, 28, 27, -5.0F, 0.0F, 0.0F, 5, 5, 5, 0.0F, true));

    Tail4 = new ModelRenderer(this);
    Tail4.setRotationPoint(1.5F, -15.0F, 18.0F);
    setRotationAngle(Tail4, 0.1396F, 0.0F, 0.0F);
    Tail.addChild(Tail4);
    Tail4.cubeList.add(new ModelBox(Tail4, 0, 9, -3.0F, 0.0F, 0.0F, 3, 3, 4, 0.0F, true));

    Tail5 = new ModelRenderer(this);
    Tail5.setRotationPoint(1.0F, -15.0F, 22.0F);
    setRotationAngle(Tail5, 0.1396F, 0.0F, 0.0F);
    Tail.addChild(Tail5);
    Tail5.cubeList.add(new ModelBox(Tail5, 7, 0, -2.0F, 0.0F, 0.0F, 2, 2, 4, 0.0F, true));

    Head = new ModelRenderer(this);
    Head.setRotationPoint(0.0F, 9.0F, -11.0F);

    Head1 = new ModelRenderer(this);
    Head1.setRotationPoint(2.0F, -2.0F, -5.0F);
    Head.addChild(Head1);
    Head1.cubeList.add(new ModelBox(Head1, 7, 73, -4.0F, 0.0F, 0.0F, 4, 4, 5, 0.0F, true));

    Head2 = new ModelRenderer(this);
    Head2.setRotationPoint(1.5F, 1.9F, -4.0F);
    Head.addChild(Head2);
    Head2.cubeList.add(new ModelBox(Head2, 26, 76, -3.0F, 0.0F, 0.0F, 3, 1, 5, 0.0F, true));

    Head3 = new ModelRenderer(this);
    Head3.setRotationPoint(0.5F, -2.5F, -5.0F);
    setRotationAngle(Head3, 0.4461F, 0.0F, 0.0F);
    Head.addChild(Head3);
    Head3.cubeList.add(new ModelBox(Head3, 0, 70, -1.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, true));

    Head4 = new ModelRenderer(this);
    Head4.setRotationPoint(1.5F, -2.1F, -5.2F);
    Head.addChild(Head4);
    Head4.cubeList.add(new ModelBox(Head4, 7, 83, -3.0F, 0.0F, 0.0F, 3, 4, 2, 0.0F, true));

    Head5 = new ModelRenderer(this);
    Head5.setRotationPoint(1.0F, 1.8F, -4.5F);
    Head.addChild(Head5);
    Head5.cubeList.add(new ModelBox(Head5, 35, 83, -2.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F, true));

    Head6 = new ModelRenderer(this);
    Head6.setRotationPoint(1.5F, -2.0F, -2.5F);
    setRotationAngle(Head6, 0.2094F, 0.0F, 0.0F);
    Head.addChild(Head6);
    Head6.cubeList.add(new ModelBox(Head6, 7, 62, -3.0F, 0.0F, 0.0F, 3, 3, 2, 0.0F, true));

    Head7 = new ModelRenderer(this);
    Head7.setRotationPoint(1.0F, -1.9F, -5.5F);
    setRotationAngle(Head7, 0.7854F, 0.0F, 0.0F);
    Head.addChild(Head7);
    Head7.cubeList.add(new ModelBox(Head7, 0, 73, -2.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F, true));

    Head8 = new ModelRenderer(this);
    Head8.setRotationPoint(1.0F, 2.3F, -1.8F);
    Head.addChild(Head8);
    Head8.cubeList.add(new ModelBox(Head8, 26, 83, -2.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F, true));

    Head9 = new ModelRenderer(this);
    Head9.setRotationPoint(0.5F, -2.2F, -0.5F);
    setRotationAngle(Head9, 0.5934F, 0.0F, 0.0F);
    Head.addChild(Head9);
    Head9.cubeList.add(new ModelBox(Head9, 20, 68, -1.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F, true));

    Head10 = new ModelRenderer(this);
    Head10.setRotationPoint(1.0F, -2.0F, -2.5F);
    setRotationAngle(Head10, 0.2094F, 0.0F, 0.0F);
    Head.addChild(Head10);
    Head10.cubeList.add(new ModelBox(Head10, 29, 61, -2.0F, 0.0F, 2.0F, 2, 3, 1, 0.0F, true));

    Head11 = new ModelRenderer(this);
    Head11.setRotationPoint(1.5F, -2.2F, -3.8F);
    Head.addChild(Head11);
    Head11.cubeList.add(new ModelBox(Head11, 7, 68, -3.0F, 0.0F, 0.0F, 3, 1, 3, 0.0F, true));

    Head12 = new ModelRenderer(this);
    Head12.setRotationPoint(1.0F, -2.2F, -5.5F);
    Head.addChild(Head12);
    Head12.cubeList.add(new ModelBox(Head12, 0, 76, -2.0F, 0.0F, 0.0F, 2, 2, 1, 0.0F, true));

    Head13 = new ModelRenderer(this);
    Head13.setRotationPoint(1.0F, -0.2F, -5.5F);
    setRotationAngle(Head13, 0.1571F, 0.0F, 0.0F);
    Head.addChild(Head13);
    Head13.cubeList.add(new ModelBox(Head13, 0, 80, -2.0F, 0.0F, 0.0F, 2, 2, 1, 0.0F, true));

    Teeth1 = new ModelRenderer(this);
    Teeth1.setRotationPoint(-0.7F, 0.9F, -0.5F);
    setRotationAngle(Teeth1, -1.041F, 0.0F, 0.0F);
    Head.addChild(Teeth1);
    Teeth1.cubeList.add(new ModelBox(Teeth1, 31, 87, -1.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, true));

    Teeth2 = new ModelRenderer(this);
    Teeth2.setRotationPoint(-0.9F, 1.5F, -2.5F);
    setRotationAngle(Teeth2, 0.5577F, 0.0F, 0.0F);
    Head.addChild(Teeth2);
    Teeth2.cubeList.add(new ModelBox(Teeth2, 26, 87, -1.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, true));

    Teeth3 = new ModelRenderer(this);
    Teeth3.setRotationPoint(-0.7F, 1.8F, -3.8F);
    setRotationAngle(Teeth3, 1.0782F, 0.0F, 0.0F);
    Head.addChild(Teeth3);
    Teeth3.cubeList.add(new ModelBox(Teeth3, 21, 87, -1.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, true));

    Teeth4 = new ModelRenderer(this);
    Teeth4.setRotationPoint(1.7F, 0.9F, -0.5F);
    setRotationAngle(Teeth4, -1.041F, 0.0F, 0.0F);
    Head.addChild(Teeth4);
    Teeth4.cubeList.add(new ModelBox(Teeth4, 37, 87, -1.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, true));

    Teeth5 = new ModelRenderer(this);
    Teeth5.setRotationPoint(1.9F, 1.5F, -2.5F);
    setRotationAngle(Teeth5, 0.5577F, 0.0F, 0.0F);
    Head.addChild(Teeth5);
    Teeth5.cubeList.add(new ModelBox(Teeth5, 42, 87, -1.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, true));

    Teeth6 = new ModelRenderer(this);
    Teeth6.setRotationPoint(1.7F, 1.8F, -3.8F);
    setRotationAngle(Teeth6, 1.0782F, 0.0F, 0.0F);
    Head.addChild(Teeth6);
    Teeth6.cubeList.add(new ModelBox(Teeth6, 47, 87, -1.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, true));

    LeftLeg = new ModelRenderer(this);
    LeftLeg.setRotationPoint(-4.0F, 8.0F, -1.0F);

    LLeg1 = new ModelRenderer(this);
    LLeg1.setRotationPoint(0.0F, 0.0F, 0.0F);
    setRotationAngle(LLeg1, 0.6109F, 0.0F, 0.0F);
    LeftLeg.addChild(LLeg1);
    LLeg1.cubeList.add(new ModelBox(LLeg1, 74, 0, -3.5F, -0.5F, -2.5F, 3, 1, 5, 0.0F, true));

    LLeg2 = new ModelRenderer(this);
    LLeg2.setRotationPoint(0.0F, 0.0F, 0.0F);
    setRotationAngle(LLeg2, 0.6109F, 0.0F, 0.0F);
    LeftLeg.addChild(LLeg2);
    LLeg2.cubeList.add(new ModelBox(LLeg2, 70, 7, -4.0F, 0.0F, -3.0F, 4, 5, 6, 0.0F, true));

    LLeg3 = new ModelRenderer(this);
    LLeg3.setRotationPoint(0.0F, 0.0F, 0.0F);
    setRotationAngle(LLeg3, 0.6109F, 0.0F, 0.0F);
    LeftLeg.addChild(LLeg3);
    LLeg3.cubeList.add(new ModelBox(LLeg3, 72, 19, -3.7F, 5.0F, -2.5F, 4, 4, 5, 0.0F, true));

    LLeg4 = new ModelRenderer(this);
    LLeg4.setRotationPoint(0.0F, 0.0F, 0.0F);
    setRotationAngle(LLeg4, -0.0873F, 0.0F, 0.0F);
    LeftLeg.addChild(LLeg4);
    LLeg4.cubeList.add(new ModelBox(LLeg4, 76, 29, -3.2F, 5.5F, 3.5F, 3, 9, 4, 0.0F, true));

    LLeg5 = new ModelRenderer(this);
    LLeg5.setRotationPoint(0.0F, 0.0F, 0.0F);
    LeftLeg.addChild(LLeg5);
    LLeg5.cubeList.add(new ModelBox(LLeg5, 76, 43, -3.2F, 14.0F, 1.5F, 3, 2, 4, 0.0F, true));

    LLeg6 = new ModelRenderer(this);
    LLeg6.setRotationPoint(0.0F, 0.0F, 0.0F);
    LeftLeg.addChild(LLeg6);
    LLeg6.cubeList.add(new ModelBox(LLeg6, 72, 50, -3.7F, 15.0F, -0.5F, 4, 1, 5, 0.0F, true));

    LLeg7 = new ModelRenderer(this);
    LLeg7.setRotationPoint(0.0F, 0.0F, 0.0F);
    setRotationAngle(LLeg7, 0.0F, 1.5708F, 0.0F);
    LeftLeg.addChild(LLeg7);
    LLeg7.cubeList.add(new ModelBox(LLeg7, 76, 57, -11.575F, 1.8F, -3.175F, 6, 9, 1, 0.0F, true));

    LLeg8 = new ModelRenderer(this);
    LLeg8.setRotationPoint(0.0F, 0.0F, 0.0F);
    setRotationAngle(LLeg8, 1.0038F, 0.0F, 0.0F);
    LeftLeg.addChild(LLeg8);
    LLeg8.cubeList.add(new ModelBox(LLeg8, 24, 9, -3.0F, 0.5F, 1.8F, 2, 2, 1, 0.0F, true));

    LFoot1 = new ModelRenderer(this);
    LFoot1.setRotationPoint(0.0F, 0.0F, 0.0F);
    LeftLeg.addChild(LFoot1);
    LFoot1.cubeList.add(new ModelBox(LFoot1, 24, 0, -5.2F, 15.9F, -6.0F, 7, 1, 7, 0.0F, true));

    RightLeg = new ModelRenderer(this);
    RightLeg.setRotationPoint(4.0F, 8.0F, -1.0F);

    RLeg1 = new ModelRenderer(this);
    RLeg1.setRotationPoint(0.0F, 0.0F, 0.0F);
    setRotationAngle(RLeg1, 0.6109F, 0.0F, 0.0F);
    RightLeg.addChild(RLeg1);
    RLeg1.cubeList.add(new ModelBox(RLeg1, 53, 0, 0.5F, -0.5F, -2.5F, 3, 1, 5, 0.0F, true));

    RLeg2 = new ModelRenderer(this);
    RLeg2.setRotationPoint(0.0F, 0.0F, 0.0F);
    setRotationAngle(RLeg2, 0.6109F, 0.0F, 0.0F);
    RightLeg.addChild(RLeg2);
    RLeg2.cubeList.add(new ModelBox(RLeg2, 49, 7, 0.0F, 0.0F, -3.0F, 4, 5, 6, 0.0F, true));

    RLeg3 = new ModelRenderer(this);
    RLeg3.setRotationPoint(0.0F, 0.0F, 0.0F);
    setRotationAngle(RLeg3, 0.6109F, 0.0F, 0.0F);
    RightLeg.addChild(RLeg3);
    RLeg3.cubeList.add(new ModelBox(RLeg3, 51, 19, -0.4F, 5.0F, -2.5F, 4, 4, 5, 0.0F, true));

    RLeg4 = new ModelRenderer(this);
    RLeg4.setRotationPoint(0.0F, 0.0F, 0.0F);
    setRotationAngle(RLeg4, -0.0873F, 0.0F, 0.0F);
    RightLeg.addChild(RLeg4);
    RLeg4.cubeList.add(new ModelBox(RLeg4, 55, 29, 0.1F, 5.5F, 3.5F, 3, 9, 4, 0.0F, true));

    RLeg5 = new ModelRenderer(this);
    RLeg5.setRotationPoint(0.0F, 0.0F, 0.0F);
    RightLeg.addChild(RLeg5);
    RLeg5.cubeList.add(new ModelBox(RLeg5, 55, 43, 0.1F, 14.0F, 1.5F, 3, 2, 4, 0.0F, true));

    RLeg6 = new ModelRenderer(this);
    RLeg6.setRotationPoint(0.0F, 0.0F, 0.0F);
    RightLeg.addChild(RLeg6);
    RLeg6.cubeList.add(new ModelBox(RLeg6, 53, 50, -0.4F, 15.0F, -0.5F, 4, 1, 5, 0.0F, true));

    RLeg7 = new ModelRenderer(this);
    RLeg7.setRotationPoint(0.0F, 0.0F, 0.0F);
    setRotationAngle(RLeg7, 0.0F, -1.5708F, 0.0F);
    RightLeg.addChild(RLeg7);
    RLeg7.cubeList.add(new ModelBox(RLeg7, 58, 57, 6.25F, 1.8F, -2.425F, 6, 9, 1, 0.0F, true));

    RLeg8 = new ModelRenderer(this);
    RLeg8.setRotationPoint(0.0F, 0.0F, 0.0F);
    setRotationAngle(RLeg8, 1.0038F, 0.0F, 0.0F);
    RightLeg.addChild(RLeg8);
    RLeg8.cubeList.add(new ModelBox(RLeg8, 31, 9, 1.0F, 0.5F, 1.8F, 2, 2, 1, 0.0F, true));

    RFoot1 = new ModelRenderer(this);
    RFoot1.setRotationPoint(0.0F, 0.0F, 0.0F);
    RightLeg.addChild(RFoot1);
    RFoot1.cubeList.add(new ModelBox(RFoot1, 24, 0, -1.9F, 15.9F, -6.0F, 7, 1, 7, 0.0F, true));
  }

  @Override
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    Body.render(f5);
    Head.render(f5);
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
