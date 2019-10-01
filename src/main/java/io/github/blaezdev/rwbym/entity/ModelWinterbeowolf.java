
package io.github.blaezdev.rwbym.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelWinterbeowolf extends ModelBase {
    private final ModelRenderer beowolf;
    private final ModelRenderer beowolfRotation;
    private final ModelRenderer headMove;
    private final ModelRenderer head;
    private final ModelRenderer jaw;
    private final ModelRenderer bone15;
    private final ModelRenderer ears;
    private final ModelRenderer earLeft;
    private final ModelRenderer earRight;
    private final ModelRenderer bone27;
    private final ModelRenderer bone28;
    private final ModelRenderer bone37;
    private final ModelRenderer neckMove;
    private final ModelRenderer neck;
    private final ModelRenderer spine6;
    private final ModelRenderer bone10;
    private final ModelRenderer bone11;
    private final ModelRenderer n;
    private final ModelRenderer bone;
    private final ModelRenderer bone12;
    private final ModelRenderer bodyMove;
    private final ModelRenderer body;
    private final ModelRenderer chest;
    private final ModelRenderer back;
    private final ModelRenderer spine5;
    private final ModelRenderer spine4;
    private final ModelRenderer bone2;
    private final ModelRenderer bone3;
    private final ModelRenderer spine3;
    private final ModelRenderer bone4;
    private final ModelRenderer bone5;
    private final ModelRenderer spine2;
    private final ModelRenderer bone6;
    private final ModelRenderer bone7;
    private final ModelRenderer spine1;
    private final ModelRenderer bone8;
    private final ModelRenderer bone9;
    private final ModelRenderer pelvis0;
    private final ModelRenderer tail;
    private final ModelRenderer bone13;
    private final ModelRenderer bone14;
    private final ModelRenderer bone22;
    private final ModelRenderer legLeftMove;
    private final ModelRenderer legLeft;
    private final ModelRenderer bone16;
    private final ModelRenderer shinLeft;
    private final ModelRenderer footLeft;
    private final ModelRenderer bone17;
    private final ModelRenderer bone18;
    private final ModelRenderer toeMiddle;
    private final ModelRenderer toeOuter;
    private final ModelRenderer toeInner;
    private final ModelRenderer bone19;
    private final ModelRenderer bone20;
    private final ModelRenderer legRightMove;
    private final ModelRenderer legRight;
    private final ModelRenderer bone21;
    private final ModelRenderer shinRight;
    private final ModelRenderer footRight;
    private final ModelRenderer bone23;
    private final ModelRenderer bone24;
    private final ModelRenderer toeMiddle2;
    private final ModelRenderer toeOuter2;
    private final ModelRenderer toeInner2;
    private final ModelRenderer bone25;
    private final ModelRenderer bone26;
    private final ModelRenderer armLeftMove;
    private final ModelRenderer armLeft;
    private final ModelRenderer shoulderLeft;
    private final ModelRenderer forearmLeft;
    private final ModelRenderer handLeft;
    private final ModelRenderer handOuter;
    private final ModelRenderer handInner;
    private final ModelRenderer bone29;
    private final ModelRenderer fingers;
    private final ModelRenderer bone30;
    private final ModelRenderer bone31;
    private final ModelRenderer bone32;
    private final ModelRenderer armRightMove;
    private final ModelRenderer armRight;
    private final ModelRenderer shoulderRight;
    private final ModelRenderer forearmRight;
    private final ModelRenderer handRight;
    private final ModelRenderer handOuter2;
    private final ModelRenderer handInner2;
    private final ModelRenderer bone33;
    private final ModelRenderer fingers2;
    private final ModelRenderer bone34;
    private final ModelRenderer bone35;
    private final ModelRenderer bone36;

    public ModelWinterbeowolf() {
        textureWidth = 128;
        textureHeight = 128;

        beowolf = new ModelRenderer(this);
        beowolf.setRotationPoint(0.0F, 24.0F, 0.0F);

        beowolfRotation = new ModelRenderer(this);
        beowolfRotation.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(beowolfRotation, 0.0F, 1.5708F, 0.0F);
        beowolf.addChild(beowolfRotation);

        bodyMove = new ModelRenderer(this);
        bodyMove.setRotationPoint(0.0F, 0.0F, 0.0F);
        beowolfRotation.addChild(bodyMove);

        body = new ModelRenderer(this);
        body.setRotationPoint(-7.9607F, -13.5377F, 0.0F);
        setRotationAngle(body, 0.0F, 0.0F, 1.309F);
        bodyMove.addChild(body);
        body.cubeList.add(new ModelBox(body, 0, 40, -4.7223F, -11.142F, -3.0F, 8, 16, 6, 0.0F, false));
        body.cubeList.add(new ModelBox(body, 49, 36, -4.1037F, -6.0386F, -5.0F, 6, 6, 10, 0.0F, false));
        body.cubeList.add(new ModelBox(body, 28, 62, -7.4723F, -11.142F, -4.5F, 5, 4, 9, 0.0F, false));
        body.cubeList.add(new ModelBox(body, 77, 0, -6.9723F, -12.142F, -3.5F, 2, 1, 7, 0.0F, false));

        headMove = new ModelRenderer(this);
        headMove.setRotationPoint(9.0F, -21.0F, 0.0F);
        beowolfRotation.addChild(headMove);

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(head, 0.0F, 0.0F, 0.1745F);
        headMove.addChild(head);

        jaw = new ModelRenderer(this);
        jaw.setRotationPoint(2.0F, 1.0F, 0.0F);
        head.addChild(jaw);
        jaw.cubeList.add(new ModelBox(jaw, 44, 29, -0.9566F, -0.7538F, -1.5F, 9, 3, 3, 0.0F, false));

        bone15 = new ModelRenderer(this);
        bone15.setRotationPoint(9.5F, -0.5F, 0.0F);
        setRotationAngle(bone15, 0.0F, 0.0F, -0.6109F);
        head.addChild(bone15);
        bone15.cubeList.add(new ModelBox(bone15, 38, 75, -1.6057F, -1.2734F, -2.0F, 2, 3, 4, 0.0F, false));

        ears = new ModelRenderer(this);
        ears.setRotationPoint(1.0F, -3.5F, 2.5F);
        setRotationAngle(ears, 0.0F, 0.0F, -0.9599F);
        head.addChild(ears);
        ears.cubeList.add(new ModelBox(ears, 0, 1, -0.9682F, 1.4669F, -4.5F, 2, 4, 4, 0.0F, false));

        earLeft = new ModelRenderer(this);
        earLeft.setRotationPoint(-0.5F, -2.0F, 0.0F);
        setRotationAngle(earLeft, -0.2618F, 0.0F, 0.0F);
        ears.addChild(earLeft);
        earLeft.cubeList.add(new ModelBox(earLeft, 0, 76, -0.6768F, -1.3292F, -0.7042F, 1, 5, 2, 0.0F, false));
        earLeft.cubeList.add(new ModelBox(earLeft, 33, 98, -0.6768F, -5.3292F, 1.2958F, 1, 9, 1, 0.0F, false));

        earRight = new ModelRenderer(this);
        earRight.setRotationPoint(-0.5F, -2.0F, -5.0F);
        setRotationAngle(earRight, 0.2618F, 0.0F, 0.0F);
        ears.addChild(earRight);
        earRight.cubeList.add(new ModelBox(earRight, 70, 67, -0.6768F, -1.3292F, -1.2958F, 1, 5, 2, 0.0F, false));
        earRight.cubeList.add(new ModelBox(earRight, 29, 98, -0.6768F, -5.3292F, -2.2958F, 1, 9, 1, 0.0F, false));

        bone27 = new ModelRenderer(this);
        bone27.setRotationPoint(3.5434F, -0.2538F, 0.0F);
        setRotationAngle(bone27, 0.0F, 0.4363F, 0.0F);
        head.addChild(bone27);
        bone27.cubeList.add(new ModelBox(bone27, 44, 25, 0.0F, -1.0F, 2.25F, 3, 2, 1, 0.0F, false));

        bone28 = new ModelRenderer(this);
        bone28.setRotationPoint(3.5434F, -0.2538F, 0.0F);
        setRotationAngle(bone28, 0.0F, -0.4363F, 0.0F);
        head.addChild(bone28);
        bone28.cubeList.add(new ModelBox(bone28, 22, 20, 0.0F, -1.0F, -3.25F, 3, 2, 1, 0.0F, false));

        bone37 = new ModelRenderer(this);
        bone37.setRotationPoint(0.0F, 0.0F, 0.0F);
        head.addChild(bone37);
        bone37.cubeList.add(new ModelBox(bone37, 30, 0, 0.0434F, -1.7538F, -2.0F, 9, 3, 4, 0.0F, false));
        bone37.cubeList.add(new ModelBox(bone37, 18, 62, 2.0434F, -1.7538F, -3.0F, 3, 3, 6, 0.0F, false));
        bone37.cubeList.add(new ModelBox(bone37, 89, 29, -0.2066F, -3.5038F, -2.0F, 3, 2, 4, 0.0F, false));

        neckMove = new ModelRenderer(this);
        neckMove.setRotationPoint(1.156F, -19.3854F, 0.0F);
        beowolfRotation.addChild(neckMove);

        neck = new ModelRenderer(this);
        neck.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(neck, 0.0F, 0.0F, 1.309F);
        neckMove.addChild(neck);
        neck.cubeList.add(new ModelBox(neck, 28, 46, -4.5607F, -4.5887F, -2.0F, 1, 5, 4, 0.0F, false));
        neck.cubeList.add(new ModelBox(neck, 50, 52, -1.0607F, -4.5887F, -5.0F, 5, 5, 10, 0.0F, false));
        neck.cubeList.add(new ModelBox(neck, 82, 57, 3.9393F, -4.5887F, -3.5F, 1, 5, 7, 0.0F, false));

        spine6 = new ModelRenderer(this);
        spine6.setRotationPoint(-8.656F, 0.6354F, 0.0F);
        setRotationAngle(spine6, 0.0F, 0.0F, 0.1745F);
        neck.addChild(spine6);
        spine6.cubeList.add(new ModelBox(spine6, 16, 93, 5.1744F, -4.9495F, -1.0F, 5, 1, 2, 0.0F, false));

        spine5 = new ModelRenderer(this);
        spine5.setRotationPoint(-0.0393F, -3.4623F, 0.0F);
        setRotationAngle(spine5, 0.0F, 0.0F, 0.1745F);
        body.addChild(spine5);
        spine5.cubeList.add(new ModelBox(spine5, 44, 35, -9.8059F, -6.4744F, -1.0F, 5, 2, 2, 0.0F, false));

        bone10 = new ModelRenderer(this);
        bone10.setRotationPoint(-1.0F, 0.0F, 0.0F);
        setRotationAngle(bone10, 0.0F, 0.0F, -0.3491F);
        spine5.addChild(bone10);
        bone10.cubeList.add(new ModelBox(bone10, 82, 75, -11.1459F, -8.8609F, -0.5F, 5, 1, 1, 0.0F, false));

        bone11 = new ModelRenderer(this);
        bone11.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone11, 0.0F, 0.0F, -0.1745F);
        bone10.addChild(bone11);
        bone11.cubeList.add(new ModelBox(bone11, 52, 2, -12.4379F, -10.6617F, -0.5F, 3, 1, 1, 0.0F, false));

        n = new ModelRenderer(this);
        n.setRotationPoint(0.844F, -3.8646F, 0.5F);
        setRotationAngle(n, 0.0F, 0.0F, 0.1745F);
        neck.addChild(n);
        n.cubeList.add(new ModelBox(n, 48, 67, -3.4602F, -2.4109F, -4.5F, 7, 3, 8, 0.0F, false));
        n.cubeList.add(new ModelBox(n, 71, 13, -4.4602F, -3.4109F, -3.5F, 8, 4, 6, 0.0F, false));
        n.cubeList.add(new ModelBox(n, 12, 76, -1.9602F, -4.4109F, -3.0F, 3, 2, 5, 0.0F, false));
        n.cubeList.add(new ModelBox(n, 82, 69, -3.4602F, -5.4109F, -2.0F, 6, 3, 3, 0.0F, false));

        bone = new ModelRenderer(this);
        bone.setRotationPoint(-2.1254F, -1.8473F, -3.0F);
        setRotationAngle(bone, 0.0F, 0.6981F, 0.0F);
        neck.addChild(bone);
        bone.cubeList.add(new ModelBox(bone, 22, 25, -2.5083F, -2.7415F, -0.7993F, 5, 5, 2, 0.0F, false));

        bone12 = new ModelRenderer(this);
        bone12.setRotationPoint(-2.1254F, -1.8473F, 3.0F);
        setRotationAngle(bone12, 0.0F, -0.6981F, 0.0F);
        neck.addChild(bone12);
        bone12.cubeList.add(new ModelBox(bone12, 20, 86, -2.5083F, -2.7415F, -1.2007F, 5, 5, 2, 0.0F, false));

        chest = new ModelRenderer(this);
        chest.setRotationPoint(-0.0393F, -1.4623F, 0.0F);
        setRotationAngle(chest, 0.0F, 0.0F, -0.2618F);
        body.addChild(chest);
        chest.cubeList.add(new ModelBox(chest, 0, 1, -3.7679F, -9.5745F, -6.0F, 9, 7, 12, 0.0F, false));

        back = new ModelRenderer(this);
        back.setRotationPoint(-0.0393F, -1.4623F, 0.0F);
        setRotationAngle(back, 0.0F, 0.0F, -0.1745F);
        body.addChild(back);
        back.cubeList.add(new ModelBox(back, 0, 76, -5.5698F, -7.6144F, -4.0F, 2, 6, 8, 0.0F, false));

        spine4 = new ModelRenderer(this);
        spine4.setRotationPoint(-0.0393F, -1.4623F, 0.0F);
        body.addChild(spine4);
        spine4.cubeList.add(new ModelBox(spine4, 85, 49, -9.683F, -6.9297F, -1.0F, 5, 2, 2, 0.0F, false));

        bone2 = new ModelRenderer(this);
        bone2.setRotationPoint(0.0F, -0.75F, 0.0F);
        setRotationAngle(bone2, 0.0F, 0.0F, -0.4363F);
        spine4.addChild(bone2);
        bone2.cubeList.add(new ModelBox(bone2, 71, 23, -11.2698F, -9.4664F, -0.5F, 5, 1, 1, 0.0F, false));

        bone3 = new ModelRenderer(this);
        bone3.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone3, 0.0F, 0.0F, -0.3491F);
        bone2.addChild(bone3);
        bone3.cubeList.add(new ModelBox(bone3, 22, 32, -13.3525F, -12.75F, -0.5F, 6, 1, 1, 0.0F, false));

        spine3 = new ModelRenderer(this);
        spine3.setRotationPoint(1.2107F, -0.4623F, 0.0F);
        setRotationAngle(spine3, 0.0F, 0.0F, -0.2618F);
        body.addChild(spine3);
        spine3.cubeList.add(new ModelBox(spine3, 0, 9, -8.5179F, -6.8245F, -1.0F, 4, 2, 2, 0.0F, false));

        bone4 = new ModelRenderer(this);
        bone4.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone4, 0.0F, 0.0F, -0.3491F);
        spine3.addChild(bone4);
        bone4.cubeList.add(new ModelBox(bone4, 47, 69, -8.7556F, -9.0913F, -0.5F, 3, 1, 1, 0.0F, false));

        bone5 = new ModelRenderer(this);
        bone5.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone5, 0.0F, 0.0F, -0.2618F);
        bone4.addChild(bone5);
        bone5.cubeList.add(new ModelBox(bone5, 58, 13, -11.1042F, -11.0477F, -0.5F, 5, 1, 1, 0.0F, false));

        spine2 = new ModelRenderer(this);
        spine2.setRotationPoint(2.9607F, 0.5377F, 0.0F);
        setRotationAngle(spine2, 0.0F, 0.0F, -0.4363F);
        body.addChild(spine2);
        spine2.cubeList.add(new ModelBox(spine2, 94, 89, -8.4255F, -6.7321F, -1.0F, 4, 2, 2, 0.0F, false));

        bone6 = new ModelRenderer(this);
        bone6.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone6, 0.0F, 0.0F, -0.3491F);
        spine2.addChild(bone6);
        bone6.cubeList.add(new ModelBox(bone6, 52, 0, -8.7003F, -8.9729F, -0.5F, 3, 1, 1, 0.0F, false));

        bone7 = new ModelRenderer(this);
        bone7.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone7, 0.0F, 0.0F, -0.1745F);
        bone6.addChild(bone7);
        bone7.cubeList.add(new ModelBox(bone7, 47, 67, -10.01F, -10.3473F, -0.5F, 3, 1, 1, 0.0F, false));

        spine1 = new ModelRenderer(this);
        spine1.setRotationPoint(5.2107F, 1.5377F, 0.0F);
        setRotationAngle(spine1, 0.0F, 0.0F, -0.5236F);
        body.addChild(spine1);

        bone8 = new ModelRenderer(this);
        bone8.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone8, 0.0F, 0.0F, -0.3491F);
        spine1.addChild(bone8);
        bone8.cubeList.add(new ModelBox(bone8, 28, 55, -8.5256F, -8.4441F, -0.5F, 4, 1, 1, 0.0F, false));

        bone9 = new ModelRenderer(this);
        bone9.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone9, 0.0F, 0.0F, -0.1745F);
        bone8.addChild(bone9);
        bone9.cubeList.add(new ModelBox(bone9, 0, 70, -9.9297F, -9.7963F, -0.5F, 3, 1, 1, 0.0F, false));

        pelvis0 = new ModelRenderer(this);
        pelvis0.setRotationPoint(-0.0393F, -1.4623F, 0.0F);
        setRotationAngle(pelvis0, 0.0F, 0.0F, -0.5236F);
        body.addChild(pelvis0);
        pelvis0.cubeList.add(new ModelBox(pelvis0, 52, 0, -6.3856F, 4.0698F, -4.5F, 8, 4, 9, 0.0F, false));
        pelvis0.cubeList.add(new ModelBox(pelvis0, 20, 75, -7.2158F, 3.132F, -4.0F, 5, 3, 8, 0.0F, false));

        tail = new ModelRenderer(this);
        tail.setRotationPoint(-6.0F, 5.75F, 0.0F);
        pelvis0.addChild(tail);
        tail.cubeList.add(new ModelBox(tail, 70, 57, -5.0F, -1.0F, -1.0F, 6, 2, 2, 0.0F, false));

        bone13 = new ModelRenderer(this);
        bone13.setRotationPoint(-7.5F, 0.0F, 0.0F);
        setRotationAngle(bone13, 0.0F, 0.0F, -0.2618F);
        tail.addChild(bone13);
        bone13.cubeList.add(new ModelBox(bone13, 81, 23, -2.5F, -0.5F, -1.5F, 6, 3, 3, 0.0F, false));

        bone14 = new ModelRenderer(this);
        bone14.setRotationPoint(-10.0F, 3.0F, 0.0F);
        setRotationAngle(bone14, 0.0F, 0.0F, -0.6981F);
        tail.addChild(bone14);
        bone14.cubeList.add(new ModelBox(bone14, 85, 43, -3.5F, -1.75F, -1.0F, 6, 4, 2, 0.0F, false));

        bone22 = new ModelRenderer(this);
        bone22.setRotationPoint(-1.9206F, 3.1412F, 0.0F);
        setRotationAngle(bone22, 0.0F, 0.0F, -0.1745F);
        body.addChild(bone22);
        bone22.cubeList.add(new ModelBox(bone22, 71, 29, -1.5977F, -3.5105F, -4.0F, 5, 6, 8, 0.0F, false));

        legLeftMove = new ModelRenderer(this);
        legLeftMove.setRotationPoint(-12.25F, -11.75F, 4.5F);
        beowolfRotation.addChild(legLeftMove);

        legLeft = new ModelRenderer(this);
        legLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(legLeft, -0.4363F, 1.1345F, 0.0F);
        legLeftMove.addChild(legLeft);
        legLeft.cubeList.add(new ModelBox(legLeft, 22, 26, -3.0F, -3.0F, -2.0F, 4, 6, 14, 0.0F, false));

        bone16 = new ModelRenderer(this);
        bone16.setRotationPoint(-1.0F, 1.25F, 12.0F);
        setRotationAngle(bone16, 0.5236F, 0.0F, 0.0F);
        legLeft.addChild(bone16);
        bone16.cubeList.add(new ModelBox(bone16, 0, 62, -0.5F, -2.0F, 0.0F, 1, 2, 4, 0.0F, false));

        shinLeft = new ModelRenderer(this);
        shinLeft.setRotationPoint(-1.0F, 3.0F, 12.0F);
        setRotationAngle(shinLeft, 0.5236F, 0.0F, 0.0F);
        legLeft.addChild(shinLeft);
        shinLeft.cubeList.add(new ModelBox(shinLeft, 70, 43, -1.0F, -3.0F, -11.0F, 2, 3, 11, 0.0F, false));

        footLeft = new ModelRenderer(this);
        footLeft.setRotationPoint(0.0F, 0.0F, -11.0F);
        setRotationAngle(footLeft, -0.7854F, 0.0F, 0.0F);
        shinLeft.addChild(footLeft);
        footLeft.cubeList.add(new ModelBox(footLeft, 0, 27, -1.0F, -2.0F, 0.0F, 2, 2, 5, 0.0F, false));

        bone17 = new ModelRenderer(this);
        bone17.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone17, 0.0F, -0.2618F, 0.0F);
        footLeft.addChild(bone17);
        bone17.cubeList.add(new ModelBox(bone17, 88, 0, -1.0F, -1.5F, 0.0F, 2, 1, 5, 0.0F, false));

        bone18 = new ModelRenderer(this);
        bone18.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone18, 0.0F, 0.2618F, 0.0F);
        footLeft.addChild(bone18);
        bone18.cubeList.add(new ModelBox(bone18, 88, 77, -1.0F, -1.5F, 0.0F, 2, 1, 5, 0.0F, false));

        toeMiddle = new ModelRenderer(this);
        toeMiddle.setRotationPoint(0.0F, 0.0F, 5.0F);
        setRotationAngle(toeMiddle, 0.6981F, 0.0F, 0.0F);
        footLeft.addChild(toeMiddle);
        toeMiddle.cubeList.add(new ModelBox(toeMiddle, 36, 92, -1.0F, -1.25F, 0.0F, 2, 1, 4, 0.0F, false));

        toeOuter = new ModelRenderer(this);
        toeOuter.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(toeOuter, 0.0F, 0.2618F, 0.0F);
        toeMiddle.addChild(toeOuter);
        toeOuter.cubeList.add(new ModelBox(toeOuter, 85, 95, 0.75F, -1.25F, 0.0F, 1, 1, 4, 0.0F, false));

        toeInner = new ModelRenderer(this);
        toeInner.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(toeInner, 0.0F, -0.2618F, 0.0F);
        toeMiddle.addChild(toeInner);
        toeInner.cubeList.add(new ModelBox(toeInner, 37, 97, -1.75F, -1.25F, 0.0F, 1, 1, 4, 0.0F, false));

        bone19 = new ModelRenderer(this);
        bone19.setRotationPoint(0.0F, -3.0F, -11.5F);
        setRotationAngle(bone19, 0.5236F, 0.0F, 0.0F);
        shinLeft.addChild(bone19);
        bone19.cubeList.add(new ModelBox(bone19, 30, 0, -0.5F, -1.0F, 0.0F, 1, 2, 1, 0.0F, false));

        bone20 = new ModelRenderer(this);
        bone20.setRotationPoint(0.0F, -2.0F, -11.0F);
        setRotationAngle(bone20, 0.8727F, 0.0F, 0.0F);
        shinLeft.addChild(bone20);
        bone20.cubeList.add(new ModelBox(bone20, 37, 9, -0.5F, -1.0F, -1.25F, 1, 2, 1, 0.0F, false));

        legRightMove = new ModelRenderer(this);
        legRightMove.setRotationPoint(-12.25F, -11.75F, -4.5F);
        beowolfRotation.addChild(legRightMove);

        legRight = new ModelRenderer(this);
        legRight.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(legRight, 0.4363F, -0.9599F, 0.0F);
        legRightMove.addChild(legRight);
        legRight.cubeList.add(new ModelBox(legRight, 0, 20, -3.0F, -3.0F, -12.0F, 4, 6, 14, 0.0F, false));

        bone21 = new ModelRenderer(this);
        bone21.setRotationPoint(-1.0F, 1.25F, -12.0F);
        setRotationAngle(bone21, -0.5236F, 0.0F, 0.0F);
        legRight.addChild(bone21);
        bone21.cubeList.add(new ModelBox(bone21, 52, 13, -0.5F, -2.0F, -4.0F, 1, 2, 4, 0.0F, false));

        shinRight = new ModelRenderer(this);
        shinRight.setRotationPoint(-1.0F, 3.0F, -12.0F);
        setRotationAngle(shinRight, -0.5236F, 0.0F, 0.0F);
        legRight.addChild(shinRight);
        shinRight.cubeList.add(new ModelBox(shinRight, 67, 68, -1.0F, -3.0F, 0.0F, 2, 3, 11, 0.0F, false));

        footRight = new ModelRenderer(this);
        footRight.setRotationPoint(0.0F, 0.0F, 11.0F);
        setRotationAngle(footRight, 0.7854F, 0.0F, 0.0F);
        shinRight.addChild(footRight);
        footRight.cubeList.add(new ModelBox(footRight, 0, 20, -1.0F, -2.0F, -5.0F, 2, 2, 5, 0.0F, false));

        bone23 = new ModelRenderer(this);
        bone23.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone23, 0.0F, 0.2618F, 0.0F);
        footRight.addChild(bone23);
        bone23.cubeList.add(new ModelBox(bone23, 63, 30, -1.0F, -1.5F, -5.0F, 2, 1, 5, 0.0F, false));

        bone24 = new ModelRenderer(this);
        bone24.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone24, 0.0F, -0.2618F, 0.0F);
        footRight.addChild(bone24);
        bone24.cubeList.add(new ModelBox(bone24, 85, 89, -1.0F, -1.5F, -5.0F, 2, 1, 5, 0.0F, false));

        toeMiddle2 = new ModelRenderer(this);
        toeMiddle2.setRotationPoint(0.0F, 0.0F, -5.0F);
        setRotationAngle(toeMiddle2, -0.6981F, 0.0F, 0.0F);
        footRight.addChild(toeMiddle2);
        toeMiddle2.cubeList.add(new ModelBox(toeMiddle2, 77, 94, -1.0F, -1.25F, -4.0F, 2, 1, 4, 0.0F, false));

        toeOuter2 = new ModelRenderer(this);
        toeOuter2.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(toeOuter2, 0.0F, -0.2618F, 0.0F);
        toeMiddle2.addChild(toeOuter2);
        toeOuter2.cubeList.add(new ModelBox(toeOuter2, 96, 71, 0.75F, -1.25F, -4.0F, 1, 1, 4, 0.0F, false));

        toeInner2 = new ModelRenderer(this);
        toeInner2.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(toeInner2, 0.0F, 0.2618F, 0.0F);
        toeMiddle2.addChild(toeInner2);
        toeInner2.cubeList.add(new ModelBox(toeInner2, 6, 97, -1.75F, -1.25F, -4.0F, 1, 1, 4, 0.0F, false));

        bone25 = new ModelRenderer(this);
        bone25.setRotationPoint(0.0F, -3.0F, 11.5F);
        setRotationAngle(bone25, -0.5236F, 0.0F, 0.0F);
        shinRight.addChild(bone25);
        bone25.cubeList.add(new ModelBox(bone25, 9, 27, -0.5F, -1.0F, -1.0F, 1, 2, 1, 0.0F, false));

        bone26 = new ModelRenderer(this);
        bone26.setRotationPoint(0.0F, -2.0F, 11.0F);
        setRotationAngle(bone26, -0.8727F, 0.0F, 0.0F);
        shinRight.addChild(bone26);
        bone26.cubeList.add(new ModelBox(bone26, 9, 20, -0.5F, -1.0F, 0.25F, 1, 2, 1, 0.0F, false));

        armLeftMove = new ModelRenderer(this);
        armLeftMove.setRotationPoint(-1.0F, -16.5F, 8.0F);
        beowolfRotation.addChild(armLeftMove);

        armLeft = new ModelRenderer(this);
        armLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(armLeft, -0.5236F, 0.5236F, 0.5236F);
        armLeftMove.addChild(armLeft);
        armLeft.cubeList.add(new ModelBox(armLeft, 28, 46, -2.5F, -2.25F, 0.0F, 5, 5, 11, 0.0F, false));

        shoulderLeft = new ModelRenderer(this);
        shoulderLeft.setRotationPoint(0.0F, 0.25F, -0.5F);
        setRotationAngle(shoulderLeft, 0.2618F, 0.0F, 0.0F);
        armLeft.addChild(shoulderLeft);
        shoulderLeft.cubeList.add(new ModelBox(shoulderLeft, 46, 78, -3.0F, -3.5F, -2.5F, 6, 7, 5, 0.0F, false));
        shoulderLeft.cubeList.add(new ModelBox(shoulderLeft, 30, 7, 0.0F, -5.5F, -1.5F, 1, 2, 1, 0.0F, false));
        shoulderLeft.cubeList.add(new ModelBox(shoulderLeft, 8, 0, -2.0F, -6.5F, -0.5F, 1, 3, 1, 0.0F, false));
        shoulderLeft.cubeList.add(new ModelBox(shoulderLeft, 28, 46, -1.0F, -5.5F, 1.0F, 1, 2, 1, 0.0F, false));

        forearmLeft = new ModelRenderer(this);
        forearmLeft.setRotationPoint(-1.5F, 0.25F, 11.0F);
        setRotationAngle(forearmLeft, 0.0F, 1.2217F, 0.0F);
        armLeft.addChild(forearmLeft);
        forearmLeft.cubeList.add(new ModelBox(forearmLeft, 0, 62, -0.75F, -2.0F, 0.0F, 4, 4, 10, 0.0F, false));
        forearmLeft.cubeList.add(new ModelBox(forearmLeft, 19, 96, -0.25F, -1.25F, 10.0F, 3, 3, 2, 0.0F, false));
        forearmLeft.cubeList.add(new ModelBox(forearmLeft, 9, 91, -1.0F, -0.5F, -5.0F, 1, 1, 5, 0.0F, false));

        handLeft = new ModelRenderer(this);
        handLeft.setRotationPoint(1.25F, 0.0F, 12.0F);
        setRotationAngle(handLeft, 0.2618F, 0.0F, 0.6109F);
        forearmLeft.addChild(handLeft);
        handLeft.cubeList.add(new ModelBox(handLeft, 0, 90, -1.5F, -0.75F, -0.25F, 3, 2, 4, 0.0F, false));

        handOuter = new ModelRenderer(this);
        handOuter.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(handOuter, 0.0F, -0.4363F, 0.0F);
        handLeft.addChild(handOuter);
        handOuter.cubeList.add(new ModelBox(handOuter, 56, 90, -1.5F, -0.75F, -0.25F, 2, 2, 4, 0.0F, false));

        handInner = new ModelRenderer(this);
        handInner.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(handInner, 0.0F, 0.4363F, 0.0F);
        handLeft.addChild(handInner);
        handInner.cubeList.add(new ModelBox(handInner, 44, 90, -0.5F, -0.75F, -0.25F, 2, 2, 4, 0.0F, false));

        bone29 = new ModelRenderer(this);
        bone29.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone29, 0.0F, 0.2618F, 0.0F);
        handInner.addChild(bone29);
        bone29.cubeList.add(new ModelBox(bone29, 29, 92, 0.5F, -0.25F, 1.5F, 1, 1, 5, 0.0F, false));

        fingers = new ModelRenderer(this);
        fingers.setRotationPoint(0.0F, 1.25F, 3.75F);
        setRotationAngle(fingers, 0.4363F, 0.0F, 0.0F);
        handLeft.addChild(fingers);
        fingers.cubeList.add(new ModelBox(fingers, 93, 12, -1.5F, -2.0F, 0.0F, 3, 2, 3, 0.0F, false));
        fingers.cubeList.add(new ModelBox(fingers, 0, 40, -1.5F, -1.0F, 3.0F, 1, 1, 2, 0.0F, false));
        fingers.cubeList.add(new ModelBox(fingers, 0, 43, 0.5F, -1.0F, 3.0F, 1, 1, 2, 0.0F, false));

        bone30 = new ModelRenderer(this);
        bone30.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone30, 0.0F, -0.3491F, 0.0F);
        fingers.addChild(bone30);
        bone30.cubeList.add(new ModelBox(bone30, 45, 96, -2.75F, -2.0F, 0.0F, 2, 2, 3, 0.0F, false));
        bone30.cubeList.add(new ModelBox(bone30, 71, 16, -2.0F, -1.0F, 3.0F, 1, 1, 2, 0.0F, false));

        bone31 = new ModelRenderer(this);
        bone31.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone31, 0.0F, 0.3491F, 0.0F);
        fingers.addChild(bone31);
        bone31.cubeList.add(new ModelBox(bone31, 55, 96, 0.75F, -2.0F, 0.0F, 2, 2, 3, 0.0F, false));
        bone31.cubeList.add(new ModelBox(bone31, 71, 13, 1.0F, -1.0F, 3.0F, 1, 1, 2, 0.0F, false));

        bone32 = new ModelRenderer(this);
        bone32.setRotationPoint(-3.25F, 0.0F, 0.5F);
        setRotationAngle(bone32, 0.0F, 0.8727F, 0.0F);
        forearmLeft.addChild(bone32);
        bone32.cubeList.add(new ModelBox(bone32, 97, 65, 0.5F, -0.5F, -0.75F, 1, 1, 4, 0.0F, false));
        bone32.cubeList.add(new ModelBox(bone32, 97, 35, -1.5F, -0.5F, 0.5F, 1, 1, 4, 0.0F, false));
        bone32.cubeList.add(new ModelBox(bone32, 97, 6, -3.5F, -0.5F, 2.25F, 1, 1, 4, 0.0F, false));

        armRightMove = new ModelRenderer(this);
        armRightMove.setRotationPoint(-1.0F, -16.5F, -8.0F);
        beowolfRotation.addChild(armRightMove);

        armRight = new ModelRenderer(this);
        armRight.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(armRight, 0.5236F, -0.5236F, 0.5236F);
        armRightMove.addChild(armRight);
        armRight.cubeList.add(new ModelBox(armRight, 31, 9, -2.5F, -2.25F, -11.0F, 5, 5, 11, 0.0F, false));

        shoulderRight = new ModelRenderer(this);
        shoulderRight.setRotationPoint(0.0F, 0.25F, 0.5F);
        setRotationAngle(shoulderRight, -0.2618F, 0.0F, 0.0F);
        armRight.addChild(shoulderRight);
        shoulderRight.cubeList.add(new ModelBox(shoulderRight, 68, 82, -3.0F, -3.5F, -2.5F, 6, 7, 5, 0.0F, false));
        shoulderRight.cubeList.add(new ModelBox(shoulderRight, 0, 27, 0.0F, -5.5F, 0.5F, 1, 2, 1, 0.0F, false));
        shoulderRight.cubeList.add(new ModelBox(shoulderRight, 0, 1, -2.0F, -6.5F, -0.5F, 1, 3, 1, 0.0F, false));
        shoulderRight.cubeList.add(new ModelBox(shoulderRight, 0, 20, -1.0F, -5.5F, -2.0F, 1, 2, 1, 0.0F, false));

        forearmRight = new ModelRenderer(this);
        forearmRight.setRotationPoint(-1.5F, 0.25F, -11.0F);
        setRotationAngle(forearmRight, 0.0F, -1.2217F, 0.0F);
        armRight.addChild(forearmRight);
        forearmRight.cubeList.add(new ModelBox(forearmRight, 53, 15, -0.75F, -2.0F, -10.0F, 4, 4, 10, 0.0F, false));
        forearmRight.cubeList.add(new ModelBox(forearmRight, 97, 0, -0.25F, -1.25F, -12.0F, 3, 3, 2, 0.0F, false));
        forearmRight.cubeList.add(new ModelBox(forearmRight, 30, 7, -1.0F, -0.5F, 0.0F, 1, 1, 5, 0.0F, false));

        handRight = new ModelRenderer(this);
        handRight.setRotationPoint(1.25F, 0.0F, -12.0F);
        setRotationAngle(handRight, -0.2618F, 0.0F, 0.6109F);
        forearmRight.addChild(handRight);
        handRight.cubeList.add(new ModelBox(handRight, 34, 86, -1.5F, -0.75F, -3.75F, 3, 2, 4, 0.0F, false));

        handOuter2 = new ModelRenderer(this);
        handOuter2.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(handOuter2, 0.0F, 0.4363F, 0.0F);
        handRight.addChild(handOuter2);
        handOuter2.cubeList.add(new ModelBox(handOuter2, 91, 57, -1.5F, -0.75F, -3.75F, 2, 2, 4, 0.0F, false));

        handInner2 = new ModelRenderer(this);
        handInner2.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(handInner2, 0.0F, -0.4363F, 0.0F);
        handRight.addChild(handInner2);
        handInner2.cubeList.add(new ModelBox(handInner2, 90, 83, -0.5F, -0.75F, -3.75F, 2, 2, 4, 0.0F, false));

        bone33 = new ModelRenderer(this);
        bone33.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone33, 0.0F, -0.2618F, 0.0F);
        handInner2.addChild(bone33);
        bone33.cubeList.add(new ModelBox(bone33, 90, 6, 0.5F, -0.25F, -6.5F, 1, 1, 5, 0.0F, false));

        fingers2 = new ModelRenderer(this);
        fingers2.setRotationPoint(0.0F, 1.25F, -3.75F);
        setRotationAngle(fingers2, -0.4363F, 0.0F, 0.0F);
        handRight.addChild(fingers2);
        fingers2.cubeList.add(new ModelBox(fingers2, 65, 94, -1.5F, -2.0F, -3.0F, 3, 2, 3, 0.0F, false));
        fingers2.cubeList.add(new ModelBox(fingers2, 30, 62, -1.5F, -1.0F, -5.0F, 1, 1, 2, 0.0F, false));
        fingers2.cubeList.add(new ModelBox(fingers2, 30, 65, 0.5F, -1.0F, -5.0F, 1, 1, 2, 0.0F, false));

        bone34 = new ModelRenderer(this);
        bone34.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone34, 0.0F, 0.3491F, 0.0F);
        fingers2.addChild(bone34);
        bone34.cubeList.add(new ModelBox(bone34, 96, 20, -2.75F, -2.0F, -3.0F, 2, 2, 3, 0.0F, false));
        bone34.cubeList.add(new ModelBox(bone34, 18, 62, -2.0F, -1.0F, -5.0F, 1, 1, 2, 0.0F, false));

        bone35 = new ModelRenderer(this);
        bone35.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone35, 0.0F, -0.3491F, 0.0F);
        fingers2.addChild(bone35);
        bone35.cubeList.add(new ModelBox(bone35, 0, 96, 0.75F, -2.0F, -3.0F, 2, 2, 3, 0.0F, false));
        bone35.cubeList.add(new ModelBox(bone35, 18, 65, 1.0F, -1.0F, -5.0F, 1, 1, 2, 0.0F, false));

        bone36 = new ModelRenderer(this);
        bone36.setRotationPoint(-3.25F, 0.0F, -0.5F);
        setRotationAngle(bone36, 0.0F, -0.8727F, 0.0F);
        forearmRight.addChild(bone36);
        bone36.cubeList.add(new ModelBox(bone36, 95, 49, 0.5F, -0.5F, -3.25F, 1, 1, 4, 0.0F, false));
        bone36.cubeList.add(new ModelBox(bone36, 95, 93, -1.5F, -0.5F, -4.5F, 1, 1, 4, 0.0F, false));
        bone36.cubeList.add(new ModelBox(bone36, 49, 52, -3.5F, -0.5F, -6.25F, 1, 1, 4, 0.0F, false));
    }

    protected float degToRad(float degrees)
    {
        return degrees * (float)Math.PI / 180 ;
    }

    protected void setRotation(ModelRenderer model, float rotX, float rotY, float rotZ)
    {
        model.rotateAngleX = degToRad(rotX);
        model.rotateAngleY = degToRad(rotY);
        model.rotateAngleZ = degToRad(rotZ);
    }

    @Override
    public void render(Entity parEntity, float parTime, float parSwingSuppress, float par4, float parHeadAngleY, float parHeadAngleX, float par7) {
        renderBeowolf((EntityWinterBeowolf) parEntity, parTime, parSwingSuppress, par4, parHeadAngleY, parHeadAngleX, par7);
        parEntity.getEntityId();

    }

    public void renderBeowolf(EntityWinterBeowolf parEntity, float parTime, float parSwingSuppress, float par4, float parHeadAngleY, float parHeadAngleX, float par7) {
        setRotationAngles(parTime, parSwingSuppress, par4, parHeadAngleY, parHeadAngleX, par7, parEntity);
        beowolf.render(par7);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(float parTime, float parSwingSuppress, float par3, float parHeadAngleY, float parHeadAngleX, float par6, Entity parEntity) {

        //Left arm
        this.armLeftMove.rotateAngleY = MathHelper.cos(parTime * 0.2223F + (float)Math.PI) * parSwingSuppress - degToRad(15);
        this.armLeftMove.rotateAngleZ = MathHelper.cos(parTime * 0.3333F) * parSwingSuppress;

        this.forearmLeft.rotateAngleY = (-1) * (MathHelper.cos(parTime * 0.2333F) * parSwingSuppress) + degToRad(65);

        this.handLeft.rotateAngleX = degToRad(15);
        this.handLeft.rotateAngleZ = degToRad(25);

        //Right arm
        this.armRightMove.rotateAngleY = MathHelper.cos(parTime * 0.2223F) * parSwingSuppress + degToRad(15);
        this.armRightMove.rotateAngleZ = MathHelper.cos(parTime * 0.3333F + (float)Math.PI) * parSwingSuppress;

        this.forearmRight.rotateAngleY = (MathHelper.cos(parTime * 0.2333F + (float)Math.PI) * parSwingSuppress) + degToRad(-65);

        this.handRight.rotateAngleX = degToRad(-15);
        this.handRight.rotateAngleZ = degToRad(25);

        //Left leg
        this.legLeftMove.rotateAngleZ = MathHelper.cos(parTime * 0.3333F + (float)Math.PI) * parSwingSuppress;

        this.shinLeft.rotateAngleX = (-1) * (MathHelper.cos(parTime * 0.3333F + (float)Math.PI) * parSwingSuppress) + degToRad(30);

        this.footLeft.rotateAngleX = MathHelper.cos(parTime * 0.3333F + (float)Math.PI) * parSwingSuppress - degToRad(45);

        //Right leg
        this.legRightMove.rotateAngleZ = MathHelper.cos(parTime * 0.3333F) * parSwingSuppress;

        this.shinRight.rotateAngleX = (-1) * (MathHelper.cos(parTime * 0.3333F) * parSwingSuppress) - degToRad(30);

        this.footRight.rotateAngleX = MathHelper.cos(parTime * 0.3333F) * parSwingSuppress + degToRad(45);


    }
}
