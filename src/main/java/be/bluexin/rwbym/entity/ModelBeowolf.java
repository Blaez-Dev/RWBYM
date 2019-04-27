package be.bluexin.rwbym.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;

public class ModelBeowolf extends ModelBase {
    private final ModelRenderer beowolf;
    private final ModelRenderer head;
    private final ModelRenderer jaw;
    private final ModelRenderer bone15;
    private final ModelRenderer ears;
    private final ModelRenderer earLeft;
    private final ModelRenderer earRight;
    private final ModelRenderer bone27;
    private final ModelRenderer bone28;
    private final ModelRenderer neck;
    private final ModelRenderer spine6;
    private final ModelRenderer bone10;
    private final ModelRenderer bone11;
    private final ModelRenderer n;
    private final ModelRenderer bone;
    private final ModelRenderer bone12;
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
    private final ModelRenderer leftLeg;
    private final ModelRenderer legLeft;
    private final ModelRenderer bone16;
    private final ModelRenderer shin;
    private final ModelRenderer foot;
    private final ModelRenderer bone17;
    private final ModelRenderer bone18;
    private final ModelRenderer toeMiddle;
    private final ModelRenderer toeOuter;
    private final ModelRenderer toeInner;
    private final ModelRenderer bone19;
    private final ModelRenderer bone20;
    private final ModelRenderer rightLeg;
    private final ModelRenderer legRight;
    private final ModelRenderer bone21;
    private final ModelRenderer shin2;
    private final ModelRenderer foot2;
    private final ModelRenderer bone23;
    private final ModelRenderer bone24;
    private final ModelRenderer toeMiddle2;
    private final ModelRenderer toeOuter2;
    private final ModelRenderer toeInner2;
    private final ModelRenderer bone25;
    private final ModelRenderer bone26;
    private final ModelRenderer leftArm;
    private final ModelRenderer armLeft;
    private final ModelRenderer shoulders;
    private final ModelRenderer forearms;
    private final ModelRenderer hand;
    private final ModelRenderer handOuter;
    private final ModelRenderer handInner;
    private final ModelRenderer bone29;
    private final ModelRenderer fingers;
    private final ModelRenderer bone30;
    private final ModelRenderer bone31;
    private final ModelRenderer bone32;
    private final ModelRenderer rightArm;
    private final ModelRenderer armRight;
    private final ModelRenderer shoulders2;
    private final ModelRenderer forearms2;
    private final ModelRenderer hand2;
    private final ModelRenderer handOuter2;
    private final ModelRenderer handInner2;
    private final ModelRenderer bone33;
    private final ModelRenderer fingers2;
    private final ModelRenderer bone34;
    private final ModelRenderer bone35;
    private final ModelRenderer bone36;

    public ModelBeowolf() {
        textureWidth = 256;
        textureHeight = 256;

        beowolf = new ModelRenderer(this);
        beowolf.setRotationPoint(-1.25F, 24.0F, 0.0F);


        body = new ModelRenderer(this);
        body.setRotationPoint(-6.7107F, -13.5377F, 0.0F);
        setRotationAngle(body, 0.0F, 0.0F, 1.309F);
        beowolf.addChild(body);
        body.cubeList.add(new ModelBox(body, 0, 20, -4.7224F, -11.142F, -3.0F, 8, 16, 6, 0.0F, false));
        body.cubeList.add(new ModelBox(body, 92, 20, -4.1037F, -6.0386F, -5.0F, 6, 6, 10, 0.0F, false));
        body.cubeList.add(new ModelBox(body, 0, 57, -7.4724F, -11.142F, -4.5F, 5, 4, 9, 0.0F, false));
        body.cubeList.add(new ModelBox(body, 106, 85, -6.9724F, -12.142F, -3.5F, 2, 1, 7, 0.0F, false));

        spine5 = new ModelRenderer(this);
        spine5.setRotationPoint(-0.0393F, -3.4623F, 0.0F);
        setRotationAngle(spine5, 0.0F, 0.0F, 0.1745F);
        body.addChild(spine5);
        spine5.cubeList.add(new ModelBox(spine5, 48, 112, -9.8059F, -6.4744F, -1.0F, 5, 2, 2, 0.0F, false));

        head = new ModelRenderer(this);
        head.setRotationPoint(10.25F, -21.0F, 0.0F);
        beowolf.addChild(head);
        head.cubeList.add(new ModelBox(head, 22, 85, 0.0434F, -1.7538F, -2.0F, 9, 3, 4, 0.0F, false));
        head.cubeList.add(new ModelBox(head, 88, 85, 2.0434F, -1.7538F, -3.0F, 3, 3, 6, 0.0F, false));
        head.cubeList.add(new ModelBox(head, 84, 104, -0.2066F, -3.5038F, -2.0F, 3, 2, 4, 0.0F, false));

        jaw = new ModelRenderer(this);
        jaw.setRotationPoint(2.0F, 1.0F, 0.0F);
        head.addChild(jaw);
        jaw.cubeList.add(new ModelBox(jaw, 48, 85, -0.9566F, -0.7538F, -1.5F, 9, 3, 3, 0.0F, false));

        bone15 = new ModelRenderer(this);
        bone15.setRotationPoint(9.5F, -0.5F, 0.0F);
        setRotationAngle(bone15, 0.0F, 0.0F, -0.6109F);
        head.addChild(bone15);
        bone15.cubeList.add(new ModelBox(bone15, 24, 112, -1.6057F, -1.2734F, -2.0F, 2, 3, 4, 0.0F, false));

        ears = new ModelRenderer(this);
        ears.setRotationPoint(1.0F, -3.5F, 2.5F);
        setRotationAngle(ears, 0.0F, 0.0F, -0.9599F);
        head.addChild(ears);
        ears.cubeList.add(new ModelBox(ears, 44, 104, -0.9682F, 1.4669F, -4.5F, 2, 4, 4, 0.0F, false));

        earLeft = new ModelRenderer(this);
        earLeft.setRotationPoint(-0.5F, -2.0F, 0.0F);
        setRotationAngle(earLeft, -0.2618F, 0.0F, 0.0F);
        ears.addChild(earLeft);
        earLeft.cubeList.add(new ModelBox(earLeft, 34, 143, -0.6768F, -1.3292F, -0.7042F, 1, 5, 2, 0.0F, false));
        earLeft.cubeList.add(new ModelBox(earLeft, 12, 143, -0.6768F, -5.3292F, 1.2958F, 1, 9, 1, 0.0F, false));

        earRight = new ModelRenderer(this);
        earRight.setRotationPoint(-0.5F, -2.0F, -5.0F);
        setRotationAngle(earRight, 0.2618F, 0.0F, 0.0F);
        ears.addChild(earRight);
        earRight.cubeList.add(new ModelBox(earRight, 28, 143, -0.6768F, -1.3292F, -1.2958F, 1, 5, 2, 0.0F, false));
        earRight.cubeList.add(new ModelBox(earRight, 52, 133, -0.6768F, -5.3292F, -2.2958F, 1, 9, 1, 0.0F, false));

        bone27 = new ModelRenderer(this);
        bone27.setRotationPoint(3.5434F, -0.2538F, 0.0F);
        setRotationAngle(bone27, 0.0F, 0.4363F, 0.0F);
        head.addChild(bone27);
        bone27.cubeList.add(new ModelBox(bone27, 44, 146, 0.0F, -1.0F, 2.25F, 3, 2, 1, 0.0F, false));

        bone28 = new ModelRenderer(this);
        bone28.setRotationPoint(3.5434F, -0.2538F, 0.0F);
        setRotationAngle(bone28, 0.0F, -0.4363F, 0.0F);
        head.addChild(bone28);
        bone28.cubeList.add(new ModelBox(bone28, 44, 143, 0.0F, -1.0F, -3.25F, 3, 2, 1, 0.0F, false));

        neck = new ModelRenderer(this);
        neck.setRotationPoint(2.406F, -19.3854F, 0.0F);
        setRotationAngle(neck, 0.0F, 0.0F, 1.309F);
        beowolf.addChild(neck);
        neck.cubeList.add(new ModelBox(neck, 14, 112, -4.5606F, -4.5887F, -2.0F, 1, 5, 4, 0.0F, false));
        neck.cubeList.add(new ModelBox(neck, 34, 42, -1.0606F, -4.5887F, -5.0F, 5, 5, 10, 0.0F, false));
        neck.cubeList.add(new ModelBox(neck, 72, 85, 3.9394F, -4.5887F, -3.5F, 1, 5, 7, 0.0F, false));

        spine6 = new ModelRenderer(this);
        spine6.setRotationPoint(-8.656F, 0.6354F, 0.0F);
        setRotationAngle(spine6, 0.0F, 0.0F, 0.1745F);
        neck.addChild(spine6);
        spine6.cubeList.add(new ModelBox(spine6, 84, 121, 5.1744F, -4.9495F, -1.0F, 5, 1, 2, 0.0F, false));

        bone10 = new ModelRenderer(this);
        bone10.setRotationPoint(-1.0F, 0.0F, 0.0F);
        setRotationAngle(bone10, 0.0F, 0.0F, -0.3491F);
        spine5.addChild(bone10);
        bone10.cubeList.add(new ModelBox(bone10, 16, 145, -11.1459F, -8.8609F, -0.5F, 5, 1, 1, 0.0F, false));

        bone11 = new ModelRenderer(this);
        bone11.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone11, 0.0F, 0.0F, -0.1745F);
        bone10.addChild(bone11);
        bone11.cubeList.add(new ModelBox(bone11, 52, 143, -12.4379F, -10.6617F, -0.5F, 3, 1, 1, 0.0F, false));

        n = new ModelRenderer(this);
        n.setRotationPoint(0.844F, -3.8646F, 0.5F);
        setRotationAngle(n, 0.0F, 0.0F, 0.1745F);
        neck.addChild(n);
        n.cubeList.add(new ModelBox(n, 28, 57, -3.4602F, -2.4109F, -4.5F, 7, 3, 8, 0.0F, false));
        n.cubeList.add(new ModelBox(n, 26, 71, -4.4602F, -3.4109F, -3.5F, 8, 4, 6, 0.0F, false));
        n.cubeList.add(new ModelBox(n, 36, 97, -1.9602F, -4.4109F, -3.0F, 3, 2, 5, 0.0F, false));
        n.cubeList.add(new ModelBox(n, 18, 97, -3.4602F, -5.4109F, -2.0F, 6, 3, 3, 0.0F, false));

        bone = new ModelRenderer(this);
        bone.setRotationPoint(-2.1254F, -1.8472F, -3.0F);
        setRotationAngle(bone, 0.0F, 0.6981F, 0.0F);
        neck.addChild(bone);
        bone.cubeList.add(new ModelBox(bone, 82, 97, -2.5083F, -2.7415F, -0.7993F, 5, 5, 2, 0.0F, false));

        bone12 = new ModelRenderer(this);
        bone12.setRotationPoint(-2.1254F, -1.8472F, 3.0F);
        setRotationAngle(bone12, 0.0F, -0.6981F, 0.0F);
        neck.addChild(bone12);
        bone12.cubeList.add(new ModelBox(bone12, 110, 97, -2.5083F, -2.7415F, -1.2007F, 5, 5, 2, 0.0F, false));

        chest = new ModelRenderer(this);
        chest.setRotationPoint(-0.0393F, -1.4623F, 0.0F);
        setRotationAngle(chest, 0.0F, 0.0F, -0.2618F);
        body.addChild(chest);
        chest.cubeList.add(new ModelBox(chest, 0, 0, -3.7679F, -9.5745F, -6.0F, 9, 7, 12, 0.0F, false));

        back = new ModelRenderer(this);
        back.setRotationPoint(-0.0393F, -1.4623F, 0.0F);
        setRotationAngle(back, 0.0F, 0.0F, -0.1745F);
        body.addChild(back);
        back.cubeList.add(new ModelBox(back, 80, 71, -5.5698F, -7.6144F, -4.0F, 2, 6, 8, 0.0F, false));


        spine4 = new ModelRenderer(this);
        spine4.setRotationPoint(-0.0393F, -1.4623F, 0.0F);
        body.addChild(spine4);
        spine4.cubeList.add(new ModelBox(spine4, 86, 112, -9.683F, -6.9297F, -1.0F, 5, 2, 2, 0.0F, false));

        bone2 = new ModelRenderer(this);
        bone2.setRotationPoint(0.0F, -0.75F, 0.0F);
        setRotationAngle(bone2, 0.0F, 0.0F, -0.4363F);
        spine4.addChild(bone2);
        bone2.cubeList.add(new ModelBox(bone2, 16, 143, -11.2698F, -9.4664F, -0.5F, 5, 1, 1, 0.0F, false));

        bone3 = new ModelRenderer(this);
        bone3.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone3, 0.0F, 0.0F, -0.3491F);
        bone2.addChild(bone3);
        bone3.cubeList.add(new ModelBox(bone3, 0, 127, -13.3525F, -12.75F, -0.5F, 6, 1, 1, 0.0F, false));

        spine3 = new ModelRenderer(this);
        spine3.setRotationPoint(1.2107F, -0.4623F, 0.0F);
        setRotationAngle(spine3, 0.0F, 0.0F, -0.2618F);
        body.addChild(spine3);
        spine3.cubeList.add(new ModelBox(spine3, 0, 129, -8.5179F, -6.8245F, -1.0F, 4, 2, 2, 0.0F, false));

        bone4 = new ModelRenderer(this);
        bone4.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone4, 0.0F, 0.0F, -0.3491F);
        spine3.addChild(bone4);
        bone4.cubeList.add(new ModelBox(bone4, 8, 153, -8.7556F, -9.0913F, -0.5F, 3, 1, 1, 0.0F, false));

        bone5 = new ModelRenderer(this);
        bone5.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone5, 0.0F, 0.0F, -0.2618F);
        bone4.addChild(bone5);
        bone5.cubeList.add(new ModelBox(bone5, 0, 145, -11.1042F, -11.0477F, -0.5F, 5, 1, 1, 0.0F, false));

        spine2 = new ModelRenderer(this);
        spine2.setRotationPoint(2.9607F, 0.5377F, 0.0F);
        setRotationAngle(spine2, 0.0F, 0.0F, -0.4363F);
        body.addChild(spine2);
        spine2.cubeList.add(new ModelBox(spine2, 14, 127, -8.4255F, -6.7321F, -1.0F, 4, 2, 2, 0.0F, false));

        bone6 = new ModelRenderer(this);
        bone6.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone6, 0.0F, 0.0F, -0.3491F);
        spine2.addChild(bone6);
        bone6.cubeList.add(new ModelBox(bone6, 44, 151, -8.7003F, -8.9729F, -0.5F, 3, 1, 1, 0.0F, false));

        bone7 = new ModelRenderer(this);
        bone7.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone7, 0.0F, 0.0F, -0.1745F);
        bone6.addChild(bone7);
        bone7.cubeList.add(new ModelBox(bone7, 0, 153, -10.01F, -10.3473F, -0.5F, 3, 1, 1, 0.0F, false));

        spine1 = new ModelRenderer(this);
        spine1.setRotationPoint(5.2107F, 1.5377F, 0.0F);
        setRotationAngle(spine1, 0.0F, 0.0F, -0.5236F);
        body.addChild(spine1);

        bone8 = new ModelRenderer(this);
        bone8.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone8, 0.0F, 0.0F, -0.3491F);
        spine1.addChild(bone8);
        bone8.cubeList.add(new ModelBox(bone8, 34, 150, -8.5256F, -8.4441F, -0.5F, 4, 1, 1, 0.0F, false));

        bone9 = new ModelRenderer(this);
        bone9.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone9, 0.0F, 0.0F, -0.1745F);
        bone8.addChild(bone9);
        bone9.cubeList.add(new ModelBox(bone9, 8, 155, -9.9297F, -9.7963F, -0.5F, 3, 1, 1, 0.0F, false));

        pelvis0 = new ModelRenderer(this);
        pelvis0.setRotationPoint(-0.0393F, -1.4623F, 0.0F);
        setRotationAngle(pelvis0, 0.0F, 0.0F, -0.5236F);
        body.addChild(pelvis0);
        pelvis0.cubeList.add(new ModelBox(pelvis0, 0, 42, -6.3856F, 4.0698F, -4.5F, 8, 4, 9, 0.0F, false));
        pelvis0.cubeList.add(new ModelBox(pelvis0, 54, 71, -7.2158F, 3.132F, -4.0F, 5, 3, 8, 0.0F, false));

        tail = new ModelRenderer(this);
        tail.setRotationPoint(-6.0F, 5.75F, 0.0F);
        pelvis0.addChild(tail);
        tail.cubeList.add(new ModelBox(tail, 14, 104, -5.0F, -1.0F, -1.0F, 6, 2, 2, 0.0F, false));

        bone13 = new ModelRenderer(this);
        bone13.setRotationPoint(-7.5F, 0.0F, 0.0F);
        setRotationAngle(bone13, 0.0F, 0.0F, -0.2618F);
        tail.addChild(bone13);
        bone13.cubeList.add(new ModelBox(bone13, 0, 97, -2.5F, -0.5F, -1.5F, 6, 3, 3, 0.0F, false));

        bone14 = new ModelRenderer(this);
        bone14.setRotationPoint(-10.0F, 3.0F, 0.0F);
        setRotationAngle(bone14, 0.0F, 0.0F, -0.6981F);
        tail.addChild(bone14);
        bone14.cubeList.add(new ModelBox(bone14, 52, 97, -3.5F, -1.75F, -1.0F, 6, 4, 2, 0.0F, false));

        bone22 = new ModelRenderer(this);
        bone22.setRotationPoint(-1.9207F, 3.1412F, 0.0F);
        setRotationAngle(bone22, 0.0F, 0.0F, -0.1745F);
        body.addChild(bone22);
        bone22.cubeList.add(new ModelBox(bone22, 84, 57, -1.5977F, -3.5105F, -4.0F, 5, 6, 8, 0.0F, false));

        leftLeg = new ModelRenderer(this);
        leftLeg.setRotationPoint(-11.4566F, 10.7462F, 5.0F);

        legLeft = new ModelRenderer(this);
        legLeft.setRotationPoint(-0.7934F, 1.5038F, -0.5F);
        setRotationAngle(legLeft, -0.4363F, 0.9599F, 0.0F);
        leftLeg.addChild(legLeft);
        legLeft.cubeList.add(new ModelBox(legLeft, 78, 0, -3.0F, -3.0F, -2.0F, 4, 6, 14, 0.0F, false));

        bone16 = new ModelRenderer(this);
        bone16.setRotationPoint(-1.0F, 1.25F, 12.0F);
        setRotationAngle(bone16, 0.5236F, 0.0F, 0.0F);
        legLeft.addChild(bone16);
        bone16.cubeList.add(new ModelBox(bone16, 26, 127, -0.5F, -2.0F, 0.0F, 1, 2, 4, 0.0F, false));

        shin = new ModelRenderer(this);
        shin.setRotationPoint(-1.0F, 3.0F, 12.0F);
        setRotationAngle(shin, 0.5236F, 0.0F, 0.0F);
        legLeft.addChild(shin);
        shin.cubeList.add(new ModelBox(shin, 0, 71, -1.0F, -3.0F, -11.0F, 2, 3, 11, 0.0F, false));

        foot = new ModelRenderer(this);
        foot.setRotationPoint(0.0F, 0.0F, -11.0F);
        setRotationAngle(foot, -0.7854F, 0.0F, 0.0F);
        shin.addChild(foot);
        foot.cubeList.add(new ModelBox(foot, 96, 97, -1.0F, -2.0F, 0.0F, 2, 2, 5, 0.0F, false));

        bone17 = new ModelRenderer(this);
        bone17.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone17, 0.0F, -0.2618F, 0.0F);
        foot.addChild(bone17);
        bone17.cubeList.add(new ModelBox(bone17, 56, 104, -1.0F, -1.5F, 0.0F, 2, 1, 5, 0.0F, false));

        bone18 = new ModelRenderer(this);
        bone18.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone18, 0.0F, 0.2618F, 0.0F);
        foot.addChild(bone18);
        bone18.cubeList.add(new ModelBox(bone18, 70, 104, -1.0F, -1.5F, 0.0F, 2, 1, 5, 0.0F, false));

        toeMiddle = new ModelRenderer(this);
        toeMiddle.setRotationPoint(0.0F, 0.0F, 5.0F);
        setRotationAngle(toeMiddle, 0.6981F, 0.0F, 0.0F);
        foot.addChild(toeMiddle);
        toeMiddle.cubeList.add(new ModelBox(toeMiddle, 48, 121, -1.0F, -1.25F, 0.0F, 2, 1, 4, 0.0F, false));

        toeOuter = new ModelRenderer(this);
        toeOuter.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(toeOuter, 0.0F, 0.2618F, 0.0F);
        toeMiddle.addChild(toeOuter);
        toeOuter.cubeList.add(new ModelBox(toeOuter, 46, 127, 0.75F, -1.25F, 0.0F, 1, 1, 4, 0.0F, false));

        toeInner = new ModelRenderer(this);
        toeInner.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(toeInner, 0.0F, -0.2618F, 0.0F);
        toeMiddle.addChild(toeInner);
        toeInner.cubeList.add(new ModelBox(toeInner, 20, 138, -1.75F, -1.25F, 0.0F, 1, 1, 4, 0.0F, false));

        bone19 = new ModelRenderer(this);
        bone19.setRotationPoint(0.0F, -3.0F, -11.5F);
        setRotationAngle(bone19, 0.5236F, 0.0F, 0.0F);
        shin.addChild(bone19);
        bone19.cubeList.add(new ModelBox(bone19, 88, 153, -0.5F, -1.0F, 0.0F, 1, 2, 1, 0.0F, false));

        bone20 = new ModelRenderer(this);
        bone20.setRotationPoint(0.0F, -2.0F, -11.0F);
        setRotationAngle(bone20, 0.8727F, 0.0F, 0.0F);
        shin.addChild(bone20);
        bone20.cubeList.add(new ModelBox(bone20, 4, 157, -0.5F, -1.0F, -1.25F, 1, 2, 1, 0.0F, false));

        rightLeg = new ModelRenderer(this);
        rightLeg.setRotationPoint(-13.0F, 10.5F, -5.0F);

        legRight = new ModelRenderer(this);
        legRight.setRotationPoint(0.75F, 1.75F, 0.5F);
        setRotationAngle(legRight, 0.4363F, -0.9599F, 0.0F);
        rightLeg.addChild(legRight);
        legRight.cubeList.add(new ModelBox(legRight, 42, 0, -3.0F, -3.0F, -12.0F, 4, 6, 14, 0.0F, false));

        bone21 = new ModelRenderer(this);
        bone21.setRotationPoint(-1.0F, 1.25F, -12.0F);
        setRotationAngle(bone21, -0.5236F, 0.0F, 0.0F);
        legRight.addChild(bone21);
        bone21.cubeList.add(new ModelBox(bone21, 110, 121, -0.5F, -2.0F, -4.0F, 1, 2, 4, 0.0F, false));

        shin2 = new ModelRenderer(this);
        shin2.setRotationPoint(-1.0F, 3.0F, -12.0F);
        setRotationAngle(shin2, -0.5236F, 0.0F, 0.0F);
        legRight.addChild(shin2);
        shin2.cubeList.add(new ModelBox(shin2, 58, 57, -1.0F, -3.0F, 0.0F, 2, 3, 11, 0.0F, false));

        foot2 = new ModelRenderer(this);
        foot2.setRotationPoint(0.0F, 0.0F, 11.0F);
        setRotationAngle(foot2, 0.7854F, 0.0F, 0.0F);
        shin2.addChild(foot2);
        foot2.cubeList.add(new ModelBox(foot2, 68, 97, -1.0F, -2.0F, -5.0F, 2, 2, 5, 0.0F, false));

        bone23 = new ModelRenderer(this);
        bone23.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone23, 0.0F, 0.2618F, 0.0F);
        foot2.addChild(bone23);
        bone23.cubeList.add(new ModelBox(bone23, 30, 104, -1.0F, -1.5F, -5.0F, 2, 1, 5, 0.0F, false));

        bone24 = new ModelRenderer(this);
        bone24.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone24, 0.0F, -0.2618F, 0.0F);
        foot2.addChild(bone24);
        bone24.cubeList.add(new ModelBox(bone24, 98, 104, -1.0F, -1.5F, -5.0F, 2, 1, 5, 0.0F, false));

        toeMiddle2 = new ModelRenderer(this);
        toeMiddle2.setRotationPoint(0.0F, 0.0F, -5.0F);
        setRotationAngle(toeMiddle2, -0.6981F, 0.0F, 0.0F);
        foot2.addChild(toeMiddle2);
        toeMiddle2.cubeList.add(new ModelBox(toeMiddle2, 98, 121, -1.0F, -1.25F, -4.0F, 2, 1, 4, 0.0F, false));

        toeOuter2 = new ModelRenderer(this);
        toeOuter2.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(toeOuter2, 0.0F, -0.2618F, 0.0F);
        toeMiddle2.addChild(toeOuter2);
        toeOuter2.cubeList.add(new ModelBox(toeOuter2, 10, 133, 0.75F, -1.25F, -4.0F, 1, 1, 4, 0.0F, false));

        toeInner2 = new ModelRenderer(this);
        toeInner2.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(toeInner2, 0.0F, 0.2618F, 0.0F);
        toeMiddle2.addChild(toeInner2);
        toeInner2.cubeList.add(new ModelBox(toeInner2, 20, 133, -1.75F, -1.25F, -4.0F, 1, 1, 4, 0.0F, false));

        bone25 = new ModelRenderer(this);
        bone25.setRotationPoint(0.0F, -3.0F, 11.5F);
        setRotationAngle(bone25, -0.5236F, 0.0F, 0.0F);
        shin2.addChild(bone25);
        bone25.cubeList.add(new ModelBox(bone25, 84, 153, -0.5F, -1.0F, -1.0F, 1, 2, 1, 0.0F, false));

        bone26 = new ModelRenderer(this);
        bone26.setRotationPoint(0.0F, -2.0F, 11.0F);
        setRotationAngle(bone26, -0.8727F, 0.0F, 0.0F);
        shin2.addChild(bone26);
        bone26.cubeList.add(new ModelBox(bone26, 76, 153, -0.5F, -1.0F, 0.25F, 1, 2, 1, 0.0F, false));

        leftArm = new ModelRenderer(this);
        leftArm.setRotationPoint(-1.0F, 7.5F, 6.0F);

        armLeft = new ModelRenderer(this);
        armLeft.setRotationPoint(0.0F, 0.0F, 2.0F);
        setRotationAngle(armLeft, -0.5236F, 0.5236F, 0.5236F);
        leftArm.addChild(armLeft);
        armLeft.cubeList.add(new ModelBox(armLeft, 60, 20, -2.5F, -2.25F, 0.0F, 5, 5, 11, 0.0F, false));

        shoulders = new ModelRenderer(this);
        shoulders.setRotationPoint(0.0F, 0.25F, -0.5F);
        setRotationAngle(shoulders, 0.2618F, 0.0F, 0.0F);
        armLeft.addChild(shoulders);
        shoulders.cubeList.add(new ModelBox(shoulders, 100, 71, -3.0F, -3.5F, -2.5F, 6, 7, 5, 0.0F, false));
        shoulders.cubeList.add(new ModelBox(shoulders, 0, 157, 0.0F, -5.5F, -1.5F, 1, 2, 1, 0.0F, false));
        shoulders.cubeList.add(new ModelBox(shoulders, 68, 153, -2.0F, -6.5F, -0.5F, 1, 3, 1, 0.0F, false));
        shoulders.cubeList.add(new ModelBox(shoulders, 8, 157, -1.0F, -5.5F, 1.0F, 1, 2, 1, 0.0F, false));

        forearms = new ModelRenderer(this);
        forearms.setRotationPoint(-1.5F, 0.25F, 11.0F);
        setRotationAngle(forearms, 0.0F, 1.2217F, 0.0F);
        armLeft.addChild(forearms);
        forearms.cubeList.add(new ModelBox(forearms, 92, 42, -0.75F, -2.0F, 0.0F, 4, 4, 10, 0.0F, false));
        forearms.cubeList.add(new ModelBox(forearms, 76, 127, -0.25F, -1.25F, 10.0F, 3, 3, 2, 0.0F, false));
        forearms.cubeList.add(new ModelBox(forearms, 12, 121, -1.0F, -0.5F, -5.0F, 1, 1, 5, 0.0F, false));

        hand = new ModelRenderer(this);
        hand.setRotationPoint(1.25F, 0.0F, 12.0F);
        setRotationAngle(hand, 0.2618F, 0.0F, 0.6109F);
        forearms.addChild(hand);
        hand.cubeList.add(new ModelBox(hand, 0, 112, -1.5F, -0.75F, -0.25F, 3, 2, 4, 0.0F, false));

        handOuter = new ModelRenderer(this);
        handOuter.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(handOuter, 0.0F, -0.4363F, 0.0F);
        hand.addChild(handOuter);
        handOuter.cubeList.add(new ModelBox(handOuter, 74, 112, -1.5F, -0.75F, -0.25F, 2, 2, 4, 0.0F, false));

        handInner = new ModelRenderer(this);
        handInner.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(handInner, 0.0F, 0.4363F, 0.0F);
        hand.addChild(handInner);
        handInner.cubeList.add(new ModelBox(handInner, 62, 112, -0.5F, -0.75F, -0.25F, 2, 2, 4, 0.0F, false));

        bone29 = new ModelRenderer(this);
        bone29.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone29, 0.0F, 0.2618F, 0.0F);
        handInner.addChild(bone29);
        bone29.cubeList.add(new ModelBox(bone29, 36, 121, 0.5F, -0.25F, 1.5F, 1, 1, 5, 0.0F, false));

        fingers = new ModelRenderer(this);
        fingers.setRotationPoint(0.0F, 1.25F, 3.75F);
        setRotationAngle(fingers, 0.4363F, 0.0F, 0.0F);
        hand.addChild(fingers);
        fingers.cubeList.add(new ModelBox(fingers, 60, 121, -1.5F, -2.0F, 0.0F, 3, 2, 3, 0.0F, false));
        fingers.cubeList.add(new ModelBox(fingers, 16, 153, -1.5F, -1.0F, 3.0F, 1, 1, 2, 0.0F, false));
        fingers.cubeList.add(new ModelBox(fingers, 22, 153, 0.5F, -1.0F, 3.0F, 1, 1, 2, 0.0F, false));

        bone30 = new ModelRenderer(this);
        bone30.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone30, 0.0F, -0.3491F, 0.0F);
        fingers.addChild(bone30);
        bone30.cubeList.add(new ModelBox(bone30, 96, 127, -2.75F, -2.0F, 0.0F, 2, 2, 3, 0.0F, false));
        bone30.cubeList.add(new ModelBox(bone30, 58, 153, -2.0F, -1.0F, 3.0F, 1, 1, 2, 0.0F, false));

        bone31 = new ModelRenderer(this);
        bone31.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone31, 0.0F, 0.3491F, 0.0F);
        fingers.addChild(bone31);
        bone31.cubeList.add(new ModelBox(bone31, 0, 133, 0.75F, -2.0F, 0.0F, 2, 2, 3, 0.0F, false));
        bone31.cubeList.add(new ModelBox(bone31, 52, 153, 1.0F, -1.0F, 3.0F, 1, 1, 2, 0.0F, false));

        bone32 = new ModelRenderer(this);
        bone32.setRotationPoint(-3.25F, 0.0F, 0.5F);
        setRotationAngle(bone32, 0.0F, 0.8727F, 0.0F);
        forearms.addChild(bone32);
        bone32.cubeList.add(new ModelBox(bone32, 40, 133, 0.5F, -0.5F, -0.75F, 1, 1, 4, 0.0F, false));
        bone32.cubeList.add(new ModelBox(bone32, 30, 138, -1.5F, -0.5F, 0.5F, 1, 1, 4, 0.0F, false));
        bone32.cubeList.add(new ModelBox(bone32, 30, 133, -3.5F, -0.5F, 2.25F, 1, 1, 4, 0.0F, false));

        rightArm = new ModelRenderer(this);
        rightArm.setRotationPoint(-1.0F, 7.5F, -6.0F);

        armRight = new ModelRenderer(this);
        armRight.setRotationPoint(0.0F, 0.0F, -2.0F);
        setRotationAngle(armRight, 0.5236F, -0.5236F, 0.5236F);
        rightArm.addChild(armRight);
        armRight.cubeList.add(new ModelBox(armRight, 28, 20, -2.5F, -2.25F, -11.0F, 5, 5, 11, 0.0F, false));

        shoulders2 = new ModelRenderer(this);
        shoulders2.setRotationPoint(0.0F, 0.25F, 0.5F);
        setRotationAngle(shoulders2, -0.2618F, 0.0F, 0.0F);
        armRight.addChild(shoulders2);
        shoulders2.cubeList.add(new ModelBox(shoulders2, 0, 85, -3.0F, -3.5F, -2.5F, 6, 7, 5, 0.0F, false));
        shoulders2.cubeList.add(new ModelBox(shoulders2, 80, 153, 0.0F, -5.5F, 0.5F, 1, 2, 1, 0.0F, false));
        shoulders2.cubeList.add(new ModelBox(shoulders2, 64, 153, -2.0F, -6.5F, -0.5F, 1, 3, 1, 0.0F, false));
        shoulders2.cubeList.add(new ModelBox(shoulders2, 72, 153, -1.0F, -5.5F, -2.0F, 1, 2, 1, 0.0F, false));

        forearms2 = new ModelRenderer(this);
        forearms2.setRotationPoint(-1.5F, 0.25F, -11.0F);
        setRotationAngle(forearms2, 0.0F, -1.2217F, 0.0F);
        armRight.addChild(forearms2);
        forearms2.cubeList.add(new ModelBox(forearms2, 64, 42, -0.75F, -2.0F, -10.0F, 4, 4, 10, 0.0F, false));
        forearms2.cubeList.add(new ModelBox(forearms2, 10, 138, -0.25F, -1.25F, -12.0F, 3, 3, 2, 0.0F, false));
        forearms2.cubeList.add(new ModelBox(forearms2, 36, 112, -1.0F, -0.5F, 0.0F, 1, 1, 5, 0.0F, false));

        hand2 = new ModelRenderer(this);
        hand2.setRotationPoint(1.25F, 0.0F, -12.0F);
        setRotationAngle(hand2, -0.2618F, 0.0F, 0.6109F);
        forearms2.addChild(hand2);
        hand2.cubeList.add(new ModelBox(hand2, 0, 104, -1.5F, -0.75F, -3.75F, 3, 2, 4, 0.0F, false));

        handOuter2 = new ModelRenderer(this);
        handOuter2.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(handOuter2, 0.0F, 0.4363F, 0.0F);
        hand2.addChild(handOuter2);
        handOuter2.cubeList.add(new ModelBox(handOuter2, 24, 121, -1.5F, -0.75F, -3.75F, 2, 2, 4, 0.0F, false));

        handInner2 = new ModelRenderer(this);
        handInner2.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(handInner2, 0.0F, -0.4363F, 0.0F);
        hand2.addChild(handInner2);
        handInner2.cubeList.add(new ModelBox(handInner2, 0, 121, -0.5F, -0.75F, -3.75F, 2, 2, 4, 0.0F, false));

        bone33 = new ModelRenderer(this);
        bone33.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone33, 0.0F, -0.2618F, 0.0F);
        handInner2.addChild(bone33);
        bone33.cubeList.add(new ModelBox(bone33, 100, 112, 0.5F, -0.25F, -6.5F, 1, 1, 5, 0.0F, false));

        fingers2 = new ModelRenderer(this);
        fingers2.setRotationPoint(0.0F, 1.25F, -3.75F);
        setRotationAngle(fingers2, -0.4363F, 0.0F, 0.0F);
        hand2.addChild(fingers2);
        fingers2.cubeList.add(new ModelBox(fingers2, 72, 121, -1.5F, -2.0F, -3.0F, 3, 2, 3, 0.0F, false));
        fingers2.cubeList.add(new ModelBox(fingers2, 34, 153, -1.5F, -1.0F, -5.0F, 1, 1, 2, 0.0F, false));
        fingers2.cubeList.add(new ModelBox(fingers2, 46, 153, 0.5F, -1.0F, -5.0F, 1, 1, 2, 0.0F, false));

        bone34 = new ModelRenderer(this);
        bone34.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone34, 0.0F, 0.3491F, 0.0F);
        fingers2.addChild(bone34);
        bone34.cubeList.add(new ModelBox(bone34, 0, 138, -2.75F, -2.0F, -3.0F, 2, 2, 3, 0.0F, false));
        bone34.cubeList.add(new ModelBox(bone34, 28, 153, -2.0F, -1.0F, -5.0F, 1, 1, 2, 0.0F, false));

        bone35 = new ModelRenderer(this);
        bone35.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bone35, 0.0F, -0.3491F, 0.0F);
        fingers2.addChild(bone35);
        bone35.cubeList.add(new ModelBox(bone35, 66, 127, 0.75F, -2.0F, -3.0F, 2, 2, 3, 0.0F, false));
        bone35.cubeList.add(new ModelBox(bone35, 40, 153, 1.0F, -1.0F, -5.0F, 1, 1, 2, 0.0F, false));

        bone36 = new ModelRenderer(this);
        bone36.setRotationPoint(-3.25F, 0.0F, -0.5F);
        setRotationAngle(bone36, 0.0F, -0.8727F, 0.0F);
        forearms2.addChild(bone36);
        bone36.cubeList.add(new ModelBox(bone36, 56, 127, 0.5F, -0.5F, -3.25F, 1, 1, 4, 0.0F, false));
        bone36.cubeList.add(new ModelBox(bone36, 86, 127, -1.5F, -0.5F, -4.5F, 1, 1, 4, 0.0F, false));
        bone36.cubeList.add(new ModelBox(bone36, 36, 127, -3.5F, -0.5F, -6.25F, 1, 1, 4, 0.0F, false));
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        beowolf.render(f5);
        leftLeg.render(f5);
        rightLeg.render(f5);
        leftArm.render(f5);
        rightArm.render(f5);
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
        float f = 1.0F;
        this.rightArm.rotateAngleX = 0.0F;
        this.leftArm.rotateAngleX = 0.0F;
        this.rightArm.rotateAngleY = 0.0F;
        this.leftArm.rotateAngleY = 0.0F;
        this.rightArm.rotateAngleZ = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f;
        this.leftArm.rotateAngleZ = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount / f;
        this.rightLeg.rotateAngleX = 0.0F;
        this.leftLeg.rotateAngleX = 0.0F;
        this.rightLeg.rotateAngleY = 0.0F;
        this.leftLeg.rotateAngleY = 0.0F;
        this.rightLeg.rotateAngleZ = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f;
        this.leftLeg.rotateAngleZ = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount / f;

    }


}

