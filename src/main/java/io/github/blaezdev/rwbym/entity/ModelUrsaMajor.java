package io.github.blaezdev.rwbym.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class ModelUrsaMajor extends ModelBase {
	private final ModelRenderer root;
	private final ModelRenderer bone;
	private final ModelRenderer bs2;
	private final ModelRenderer bs1;
	private final ModelRenderer bs3;
	private final ModelRenderer bs6;
	private final ModelRenderer bs5;
	private final ModelRenderer bs8;
	private final ModelRenderer bs7;
	private final ModelRenderer bs9;
	private final ModelRenderer bs10;
	private final ModelRenderer b1;
	private final ModelRenderer b2;
	private final ModelRenderer b3;
	private final ModelRenderer bone2;
	private final ModelRenderer bs11;
	private final ModelRenderer bs4;
	private final ModelRenderer bs12;
	private final ModelRenderer bone3;
	private final ModelRenderer bs13;
	private final ModelRenderer bs14;
	private final ModelRenderer bs15;
	private final ModelRenderer bone4;
	private final ModelRenderer bs16;
	private final ModelRenderer bs17;
	private final ModelRenderer bs18;
	private final ModelRenderer bone5;
	private final ModelRenderer bs19;
	private final ModelRenderer bs20;
	private final ModelRenderer bs21;
	private final ModelRenderer bone6;
	private final ModelRenderer bs22;
	private final ModelRenderer bs23;
	private final ModelRenderer bs24;
	private final ModelRenderer llb4;
	private final ModelRenderer llb5;
	private final ModelRenderer llb2;
	private final ModelRenderer llb3;
	private final ModelRenderer rlb5;
	private final ModelRenderer leftfrontleg;
	private final ModelRenderer llf6;
	private final ModelRenderer llf7;
	private final ModelRenderer llf2;
	private final ModelRenderer llf5;
	private final ModelRenderer llf1;
	private final ModelRenderer bone7;
	private final ModelRenderer llf4;
	private final ModelRenderer llf3;
	private final ModelRenderer rightfrontleg;
	private final ModelRenderer rlf7;
	private final ModelRenderer rlf6;
	private final ModelRenderer rlf4;
	private final ModelRenderer rlf5;
	private final ModelRenderer rlf2;
	private final ModelRenderer rlf3;
	private final ModelRenderer rlf1;
	private final ModelRenderer rlb4;
	private final ModelRenderer llb1;
	private final ModelRenderer rlb1;
	private final ModelRenderer rlb3;
	private final ModelRenderer rlb2;
	private final ModelRenderer h4;
	private final ModelRenderer h3;
	private final ModelRenderer h2;
	private final ModelRenderer h1;

	public ModelUrsaMajor() {
		textureWidth = 128;
		textureHeight = 128;

		root = new ModelRenderer(this);
		root.setRotationPoint(0.0F, 0.0F, 0.0F);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.5F, -5.0313F, 1.8438F);
		setRotationAngle(bone, -0.8727F, 0.0F, 0.0F);
		root.addChild(bone);

		bs2 = new ModelRenderer(this);
		bs2.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(bs2, -0.1745F, 0.0F, 0.0F);
		bone.addChild(bs2);
		bs2.cubeList.add(new ModelBox(bs2, 57, 52, -1.0F, -5.0F, 0.0F, 1, 5, 1, 0.0F, true));
		bs2.cubeList.add(new ModelBox(bs2, 57, 52, -1.0F, -5.875F, 0.0F, 1, 5, 1, 0.0F, true));

		bs1 = new ModelRenderer(this);
		bs1.setRotationPoint(0.0F, -2.5F, -4.0F);
		setRotationAngle(bs1, 0.2231F, 0.0F, 0.0F);
		bone.addChild(bs1);
		bs1.cubeList.add(new ModelBox(bs1, 57, 46, -1.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F, true));
		bs1.cubeList.add(new ModelBox(bs1, 57, 46, -1.0F, -1.3438F, 0.0F, 1, 4, 1, 0.0F, true));

		bs3 = new ModelRenderer(this);
		bs3.setRotationPoint(0.0F, 0.0F, 3.5F);
		setRotationAngle(bs3, -0.1745F, 0.0F, 0.0F);
		bone.addChild(bs3);
		bs3.cubeList.add(new ModelBox(bs3, 57, 59, -1.0F, -5.0F, 0.0F, 1, 5, 1, 0.0F, true));
		bs3.cubeList.add(new ModelBox(bs3, 57, 59, -1.0F, -6.4688F, 0.0F, 1, 5, 1, 0.0F, true));

		bs6 = new ModelRenderer(this);
		bs6.setRotationPoint(-2.0F, -0.5F, -3.0F);
		setRotationAngle(bs6, 0.2231F, 0.0F, 0.0F);
		bone.addChild(bs6);
		bs6.cubeList.add(new ModelBox(bs6, 62, 47, -1.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F, true));

		bs5 = new ModelRenderer(this);
		bs5.setRotationPoint(2.0F, -0.5F, -3.0F);
		setRotationAngle(bs5, 0.2231F, 0.0F, 0.0F);
		bone.addChild(bs5);
		bs5.cubeList.add(new ModelBox(bs5, 62, 47, -1.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F, true));

		bs8 = new ModelRenderer(this);
		bs8.setRotationPoint(2.5F, 0.0F, 0.5F);
		setRotationAngle(bs8, -0.1745F, 0.0F, 0.0F);
		bone.addChild(bs8);
		bs8.cubeList.add(new ModelBox(bs8, 62, 53, -1.0F, -2.0F, 0.0F, 1, 2, 1, 0.0F, true));

		bs7 = new ModelRenderer(this);
		bs7.setRotationPoint(2.5F, 0.0F, 4.0F);
		setRotationAngle(bs7, -0.1745F, 0.0F, 0.0F);
		bone.addChild(bs7);
		bs7.cubeList.add(new ModelBox(bs7, 62, 59, -1.0F, -2.0F, 0.0F, 1, 2, 1, 0.0F, true));

		bs9 = new ModelRenderer(this);
		bs9.setRotationPoint(-2.5F, 0.0F, 0.5F);
		setRotationAngle(bs9, -0.1745F, 0.0F, 0.0F);
		bone.addChild(bs9);
		bs9.cubeList.add(new ModelBox(bs9, 62, 53, -1.0F, -2.0F, 0.0F, 1, 2, 1, 0.0F, true));

		bs10 = new ModelRenderer(this);
		bs10.setRotationPoint(-2.5F, 0.0F, 4.0F);
		setRotationAngle(bs10, -0.1745F, 0.0F, 0.0F);
		bone.addChild(bs10);
		bs10.cubeList.add(new ModelBox(bs10, 62, 59, -1.0F, -2.0F, 0.0F, 1, 2, 1, 0.0F, true));

		b1 = new ModelRenderer(this);
		b1.setRotationPoint(0.5F, 6.0F, -1.0F);
		bone.addChild(b1);
		b1.cubeList.add(new ModelBox(b1, 0, 36, -7.0F, -6.0F, 0.0F, 12, 13, 14, 0.0F, true));

		b2 = new ModelRenderer(this);
		b2.setRotationPoint(0.0F, 6.0F, 14.0F);
		setRotationAngle(b2, -0.1859F, 0.0F, 0.0F);
		bone.addChild(b2);
		b2.cubeList.add(new ModelBox(b2, 0, 64, -6.0F, -5.0F, -2.0F, 11, 11, 9, 0.0F, true));

		b3 = new ModelRenderer(this);
		b3.setRotationPoint(0.5F, 6.0F, -3.0F);
		setRotationAngle(b3, 0.2231F, 0.0F, 0.0F);
		bone.addChild(b3);
		b3.cubeList.add(new ModelBox(b3, 0, 19, -6.0F, -4.5F, -2.0F, 10, 10, 6, 0.0F, true));

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.addChild(bone2);

		bs11 = new ModelRenderer(this);
		bs11.setRotationPoint(-2.5F, 0.0F, 8.0F);
		setRotationAngle(bs11, -0.1745F, 0.0F, 0.0F);
		bone2.addChild(bs11);
		bs11.cubeList.add(new ModelBox(bs11, 62, 65, -1.0F, -2.0F, 0.0F, 1, 2, 1, 0.0F, true));

		bs4 = new ModelRenderer(this);
		bs4.setRotationPoint(0.0F, 0.0F, 7.5F);
		setRotationAngle(bs4, -0.1745F, 0.0F, 0.0F);
		bone2.addChild(bs4);
		bs4.cubeList.add(new ModelBox(bs4, 57, 66, -1.0F, -4.0F, 0.0F, 1, 4, 1, 0.0F, true));
		bs4.cubeList.add(new ModelBox(bs4, 57, 66, -1.0F, -5.625F, 0.0F, 1, 4, 1, 0.0F, true));

		bs12 = new ModelRenderer(this);
		bs12.setRotationPoint(2.5F, 0.0F, 8.0F);
		setRotationAngle(bs12, -0.1745F, 0.0F, 0.0F);
		bone2.addChild(bs12);
		bs12.cubeList.add(new ModelBox(bs12, 62, 65, -1.0F, -2.0F, 0.0F, 1, 2, 1, 0.0F, true));

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.addChild(bone3);

		bs13 = new ModelRenderer(this);
		bs13.setRotationPoint(-2.5F, 0.0F, 8.0F);
		setRotationAngle(bs13, -0.1745F, 0.0F, 0.0F);
		bone3.addChild(bs13);
		bs13.cubeList.add(new ModelBox(bs13, 62, 65, -1.0F, -2.0F, -1.9063F, 1, 2, 1, 0.0F, true));

		bs14 = new ModelRenderer(this);
		bs14.setRotationPoint(0.0F, 0.0F, 7.5F);
		setRotationAngle(bs14, -0.1745F, 0.0F, 0.0F);
		bone3.addChild(bs14);
		bs14.cubeList.add(new ModelBox(bs14, 57, 66, -1.0F, -4.0F, -1.9063F, 1, 4, 1, 0.0F, true));
		bs14.cubeList.add(new ModelBox(bs14, 57, 66, -1.0F, -6.5625F, -1.9063F, 1, 4, 1, 0.0F, true));

		bs15 = new ModelRenderer(this);
		bs15.setRotationPoint(2.5F, 0.0F, 8.0F);
		setRotationAngle(bs15, -0.1745F, 0.0F, 0.0F);
		bone3.addChild(bs15);
		bs15.cubeList.add(new ModelBox(bs15, 62, 65, -1.0F, -2.0F, -1.9063F, 1, 2, 1, 0.0F, true));

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.addChild(bone4);

		bs16 = new ModelRenderer(this);
		bs16.setRotationPoint(-2.5F, 0.0F, 8.0F);
		setRotationAngle(bs16, -0.1745F, 0.0F, 0.0F);
		bone4.addChild(bs16);
		bs16.cubeList.add(new ModelBox(bs16, 62, 65, -1.0F, -0.5938F, -5.6875F, 1, 2, 1, 0.0F, true));

		bs17 = new ModelRenderer(this);
		bs17.setRotationPoint(0.0F, 0.0F, 7.5F);
		setRotationAngle(bs17, -0.1745F, 0.0F, 0.0F);
		bone4.addChild(bs17);
		bs17.cubeList.add(new ModelBox(bs17, 57, 66, -1.0F, -2.5938F, -5.6875F, 1, 4, 1, 0.0F, true));
		bs17.cubeList.add(new ModelBox(bs17, 57, 66, -1.0F, -3.6563F, -5.6875F, 1, 4, 1, 0.0F, true));

		bs18 = new ModelRenderer(this);
		bs18.setRotationPoint(2.5F, 0.0F, 8.0F);
		setRotationAngle(bs18, -0.1745F, 0.0F, 0.0F);
		bone4.addChild(bs18);
		bs18.cubeList.add(new ModelBox(bs18, 62, 65, -1.0F, -0.5938F, -5.6875F, 1, 2, 1, 0.0F, true));

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.addChild(bone5);

		bs19 = new ModelRenderer(this);
		bs19.setRotationPoint(-2.5F, 0.0F, 8.0F);
		setRotationAngle(bs19, -0.1745F, 0.0F, 0.0F);
		bone5.addChild(bs19);
		bs19.cubeList.add(new ModelBox(bs19, 62, 65, -1.0F, 0.9375F, -9.0313F, 1, 2, 1, 0.0F, true));

		bs20 = new ModelRenderer(this);
		bs20.setRotationPoint(0.0F, 0.0F, 7.5F);
		setRotationAngle(bs20, -0.1745F, 0.0F, 0.0F);
		bone5.addChild(bs20);
		bs20.cubeList.add(new ModelBox(bs20, 57, 66, -1.0F, -1.0625F, -9.0313F, 1, 4, 1, 0.0F, true));

		bs21 = new ModelRenderer(this);
		bs21.setRotationPoint(2.5F, 0.0F, 8.0F);
		setRotationAngle(bs21, -0.1745F, 0.0F, 0.0F);
		bone5.addChild(bs21);
		bs21.cubeList.add(new ModelBox(bs21, 62, 65, -1.0F, 0.9375F, -9.0313F, 1, 2, 1, 0.0F, true));

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(bone6, 0.6109F, 0.0F, 0.0F);
		bone.addChild(bone6);

		bs22 = new ModelRenderer(this);
		bs22.setRotationPoint(-2.5F, 0.0F, 8.0F);
		setRotationAngle(bs22, -0.1745F, 0.0F, 0.0F);
		bone6.addChild(bs22);
		bs22.cubeList.add(new ModelBox(bs22, 62, 65, -1.0F, -0.5938F, -12.9375F, 1, 2, 1, 0.0F, true));

		bs23 = new ModelRenderer(this);
		bs23.setRotationPoint(0.0F, 0.0F, 7.5F);
		setRotationAngle(bs23, -0.1745F, 0.0F, 0.0F);
		bone6.addChild(bs23);
		bs23.cubeList.add(new ModelBox(bs23, 57, 66, -1.0F, -2.5938F, -12.9375F, 1, 4, 1, 0.0F, true));

		bs24 = new ModelRenderer(this);
		bs24.setRotationPoint(2.5F, 0.0F, 8.0F);
		setRotationAngle(bs24, -0.1745F, 0.0F, 0.0F);
		bone6.addChild(bs24);
		bs24.cubeList.add(new ModelBox(bs24, 62, 65, -1.0F, -0.5938F, -12.9375F, 1, 2, 1, 0.0F, true));

		llb4 = new ModelRenderer(this);
		llb4.setRotationPoint(-3.5F, 14.0F, 8.5F);
		root.addChild(llb4);
		llb4.cubeList.add(new ModelBox(llb4, 52, 30, -5.5938F, 8.7F, -7.0F, 3, 1, 3, 0.0F, true));

		llb5 = new ModelRenderer(this);
		llb5.setRotationPoint(-3.5F, 14.0F, 8.5F);
		root.addChild(llb5);
		llb5.cubeList.add(new ModelBox(llb5, 100, 15, -5.0938F, 5.0F, -5.0F, 1, 1, 2, 0.0F, true));

		llb2 = new ModelRenderer(this);
		llb2.setRotationPoint(-3.5F, 14.0F, 8.5F);
		root.addChild(llb2);
		llb2.cubeList.add(new ModelBox(llb2, 79, 13, -6.0938F, 4.0F, -3.0F, 4, 5, 4, 0.0F, true));

		llb3 = new ModelRenderer(this);
		llb3.setRotationPoint(-3.5F, 14.0F, 8.5F);
		root.addChild(llb3);
		llb3.cubeList.add(new ModelBox(llb3, 79, 23, -6.0938F, 9.0F, -4.0F, 4, 1, 5, 0.0F, true));

		rlb5 = new ModelRenderer(this);
		rlb5.setRotationPoint(3.5F, 14.0F, 8.5F);
		root.addChild(rlb5);
		rlb5.cubeList.add(new ModelBox(rlb5, 100, 15, 4.0F, 5.0F, -5.0F, 1, 1, 2, 0.0F, true));

		leftfrontleg = new ModelRenderer(this);
		leftfrontleg.setRotationPoint(-6.0F, 1.0F, -5.0F);
		root.addChild(leftfrontleg);

		llf6 = new ModelRenderer(this);
		llf6.setRotationPoint(2.5F, 13.0F, -2.0F);
		leftfrontleg.addChild(llf6);
		llf6.cubeList.add(new ModelBox(llf6, 43, 27, -7.25F, -10.375F, 1.2813F, 1, 1, 1, 0.0F, true));

		llf7 = new ModelRenderer(this);
		llf7.setRotationPoint(2.5F, 13.0F, -2.0F);
		leftfrontleg.addChild(llf7);
		llf7.cubeList.add(new ModelBox(llf7, 43, 17, -7.75F, -13.375F, 0.2813F, 2, 2, 2, 0.0F, true));

		llf2 = new ModelRenderer(this);
		llf2.setRotationPoint(2.5F, 13.0F, -2.0F);
		leftfrontleg.addChild(llf2);
		llf2.cubeList.add(new ModelBox(llf2, 52, 14, -5.75F, -7.375F, 0.7813F, 3, 4, 4, 0.0F, true));

		llf5 = new ModelRenderer(this);
		llf5.setRotationPoint(2.5F, 13.0F, -2.0F);
		leftfrontleg.addChild(llf5);
		llf5.cubeList.add(new ModelBox(llf5, 43, 22, -7.25F, -12.675F, 0.5812F, 1, 2, 2, 0.0F, true));

		llf1 = new ModelRenderer(this);
		llf1.setRotationPoint(2.5F, 13.0F, -2.0F);
		leftfrontleg.addChild(llf1);
		llf1.cubeList.add(new ModelBox(llf1, 52, 0, -6.25F, -14.375F, -0.7188F, 4, 8, 5, 0.0F, true));

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(bone7, 0.0F, -0.0873F, 0.0F);
		leftfrontleg.addChild(bone7);

		llf4 = new ModelRenderer(this);
		llf4.setRotationPoint(2.5F, 13.0F, -2.0F);
		bone7.addChild(llf4);
		llf4.cubeList.add(new ModelBox(llf4, 52, 30, -5.75F, -3.675F, -3.2188F, 3, 1, 3, 0.0F, true));

		llf3 = new ModelRenderer(this);
		llf3.setRotationPoint(2.5F, 13.0F, -2.0F);
		bone7.addChild(llf3);
		llf3.cubeList.add(new ModelBox(llf3, 52, 23, -5.75F, -3.375F, -0.2188F, 3, 1, 5, 0.0F, true));

		rightfrontleg = new ModelRenderer(this);
		rightfrontleg.setRotationPoint(7.0F, 0.0F, -5.0F);
		root.addChild(rightfrontleg);

		rlf7 = new ModelRenderer(this);
		rlf7.setRotationPoint(-3.5F, 14.0F, -2.0F);
		rightfrontleg.addChild(rlf7);
		rlf7.cubeList.add(new ModelBox(rlf7, 43, 27, 6.375F, -10.375F, 1.2813F, 1, 1, 1, 0.0F, true));

		rlf6 = new ModelRenderer(this);
		rlf6.setRotationPoint(-3.5F, 14.0F, -2.0F);
		rightfrontleg.addChild(rlf6);
		rlf6.cubeList.add(new ModelBox(rlf6, 43, 22, 6.375F, -12.675F, 0.5812F, 1, 2, 2, 0.0F, true));

		rlf4 = new ModelRenderer(this);
		rlf4.setRotationPoint(-3.5F, 14.0F, -2.0F);
		rightfrontleg.addChild(rlf4);
		rlf4.cubeList.add(new ModelBox(rlf4, 52, 30, 2.875F, -3.675F, -3.2188F, 3, 1, 3, 0.0F, true));

		rlf5 = new ModelRenderer(this);
		rlf5.setRotationPoint(-3.5F, 14.0F, -2.0F);
		rightfrontleg.addChild(rlf5);
		rlf5.cubeList.add(new ModelBox(rlf5, 43, 17, 5.875F, -13.375F, 0.2813F, 2, 2, 2, 0.0F, true));

		rlf2 = new ModelRenderer(this);
		rlf2.setRotationPoint(-3.5F, 14.0F, -2.0F);
		rightfrontleg.addChild(rlf2);
		rlf2.cubeList.add(new ModelBox(rlf2, 52, 14, 2.875F, -7.375F, 0.7813F, 3, 4, 4, 0.0F, true));

		rlf3 = new ModelRenderer(this);
		rlf3.setRotationPoint(-3.5F, 14.0F, -2.0F);
		rightfrontleg.addChild(rlf3);
		rlf3.cubeList.add(new ModelBox(rlf3, 52, 23, 2.875F, -3.375F, -0.2188F, 3, 1, 5, 0.0F, true));

		rlf1 = new ModelRenderer(this);
		rlf1.setRotationPoint(-3.5F, 14.0F, -2.0F);
		rightfrontleg.addChild(rlf1);
		rlf1.cubeList.add(new ModelBox(rlf1, 52, 0, 2.375F, -14.375F, -0.7188F, 4, 8, 5, 0.0F, true));

		rlb4 = new ModelRenderer(this);
		rlb4.setRotationPoint(3.5F, 14.0F, 8.5F);
		root.addChild(rlb4);
		rlb4.cubeList.add(new ModelBox(rlb4, 52, 30, 2.5F, 8.7F, -7.0F, 3, 1, 3, 0.0F, true));

		llb1 = new ModelRenderer(this);
		llb1.setRotationPoint(-7.0F, 0.0F, 0.0F);
		setRotationAngle(llb1, -0.1833F, 0.0F, 0.0F);
		rlb4.addChild(llb1);
		llb1.cubeList.add(new ModelBox(llb1, 79, 0, -6.5938F, -2.0F, -2.5F, 5, 7, 5, 0.0F, true));

		rlb1 = new ModelRenderer(this);
		rlb1.setRotationPoint(3.5F, 14.0F, 8.5F);
		setRotationAngle(rlb1, -0.1833F, 0.0F, 0.0F);
		root.addChild(rlb1);
		rlb1.cubeList.add(new ModelBox(rlb1, 79, 0, 1.5F, -2.0F, -2.5F, 5, 7, 5, 0.0F, true));

		rlb3 = new ModelRenderer(this);
		rlb3.setRotationPoint(3.5F, 14.0F, 8.5F);
		root.addChild(rlb3);
		rlb3.cubeList.add(new ModelBox(rlb3, 79, 23, 2.0F, 9.0F, -4.0F, 4, 1, 5, 0.0F, true));

		rlb2 = new ModelRenderer(this);
		rlb2.setRotationPoint(3.5F, 14.0F, 8.5F);
		root.addChild(rlb2);
		rlb2.cubeList.add(new ModelBox(rlb2, 79, 13, 2.0F, 4.0F, -3.0F, 4, 5, 4, 0.0F, true));

		h4 = new ModelRenderer(this);
		h4.setRotationPoint(0.0F, -2.5F, -7.0F);
		h4.cubeList.add(new ModelBox(h4, 25, 15, -2.5F, 1.5F, -4.6563F, 5, 1, 2, 0.0F, true));
		root.addChild(h4);

		h3 = new ModelRenderer(this);
		h3.setRotationPoint(0.0F, -2.5F, -7.0F);
		h3.cubeList.add(new ModelBox(h3, 0, 0, -3.0F, -1.0F, -6.1563F, 6, 2, 1, 0.0F, true));
		root.addChild(h3);

		h2 = new ModelRenderer(this);
		h2.setRotationPoint(0.0F, -2.5F, -7.0F);
		h2.cubeList.add(new ModelBox(h2, 0, 4, -3.5F, -3.0F, -5.1563F, 7, 4, 2, 0.0F, true));
		root.addChild(h2);

		h1 = new ModelRenderer(this);
		h1.setRotationPoint(0.0F, -2.5F, -7.0F);
		h1.cubeList.add(new ModelBox(h1, 19, 0, -3.5F, -4.0F, -3.1563F, 7, 7, 6, 0.0F, true));
		root.addChild(h1);
	}


	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		root.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setLivingAnimations(EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4) {
		this.rlb1.rotateAngleX = MathHelper.cos(par2 * 0.6662f) * 1.4f * par3 - 0.1832596f;
		this.rlb2.rotateAngleX = MathHelper.cos(par2 * 0.6662f) * 1.4f * par3;
		this.rlb3.rotateAngleX = MathHelper.cos(par2 * 0.6662f) * 1.4f * par3;
		this.rlb4.rotateAngleX = MathHelper.cos(par2 * 0.6662f) * 1.4f * par3;
		this.rlb5.rotateAngleX = MathHelper.cos(par2 * 0.6662f) * 1.4f * par3;
		this.llb1.rotateAngleX = MathHelper.cos(par2 * 0.6662f + 3.1415927f) * 1.4f * par3 - 0.1832596f;
		this.llb2.rotateAngleX = MathHelper.cos(par2 * 0.6662f + 3.1415927f) * 1.4f * par3;
		this.llb3.rotateAngleX = MathHelper.cos(par2 * 0.6662f + 3.1415927f) * 1.4f * par3;
		this.llb4.rotateAngleX = MathHelper.cos(par2 * 0.6662f + 3.1415927f) * 1.4f * par3;
		this.llb5.rotateAngleX = MathHelper.cos(par2 * 0.6662f + 3.1415927f) * 1.4f * par3;
		this.rightfrontleg.rotateAngleX = MathHelper.cos(par2 * 0.6662f + 3.1415927f) * 1.4f * par3;
		this.leftfrontleg.rotateAngleX = MathHelper.cos(par2 * 0.6662f) * 1.4f * par3;
	}

	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
		super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
		this.h1.rotateAngleX = par5 / 57.295776f;
		this.h1.rotateAngleY = par4 / 57.295776f;
		this.h2.rotateAngleX = par5 / 57.295776f;
		this.h2.rotateAngleY = par4 / 57.295776f;
		this.h3.rotateAngleX = par5 / 57.295776f;
		this.h3.rotateAngleY = par4 / 57.295776f;
		this.h4.rotateAngleX = par5 / 57.295776f;
		this.h4.rotateAngleY = par4 / 57.295776f;
	}
}