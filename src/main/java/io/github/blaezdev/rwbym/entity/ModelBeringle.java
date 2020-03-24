package io.github.blaezdev.rwbym.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class ModelBeringle extends ModelBase {
	private final ModelRenderer root;
	private final ModelRenderer Torso;
	private final ModelRenderer bone;
	private final ModelRenderer bone3;
	private final ModelRenderer bone2;
	private final ModelRenderer Head;
	private final ModelRenderer Leftleg;
	private final ModelRenderer leftlowerleg;
	private final ModelRenderer LeftAnkle;
	private final ModelRenderer leftfoot;
	private final ModelRenderer Rightleg;
	private final ModelRenderer Rightlowerleg;
	private final ModelRenderer rightankle;
	private final ModelRenderer Rightfoot;
	private final ModelRenderer Leftsarm;
	private final ModelRenderer Leftforarm;
	private final ModelRenderer lefthand;
	private final ModelRenderer Rightarm;
	private final ModelRenderer rightforarm2;
	private final ModelRenderer righthand2;

	public ModelBeringle() {
		textureWidth = 512;
		textureHeight = 512;

		root = new ModelRenderer(this);
		root.setRotationPoint(0.0F, 24.0F, 0.0F);

		Torso = new ModelRenderer(this);
		Torso.setRotationPoint(-9.0F, -48.0F, 0.0F);
		setRotationAngle(Torso, 0.6981F, 0.0F, 0.0F);
		root.addChild(Torso);
		Torso.cubeList.add(new ModelBox(Torso, 0, 361, -11.0F, -15.0F, -11.0F, 39, 13, 23, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 0, 299, 8.0F, -19.9375F, 8.616F, 2, 1, 1, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 0, 299, 8.0F, -17.1199F, 8.8626F, 2, 1, 1, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 0, 299, 8.25F, -13.4389F, 11.284F, 1, 2, 1, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 0, 299, 7.0F, -11.4811F, 12.1733F, 3, 0, 1, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 0, 299, 5.0F, -8.3794F, 11.2024F, 7, 1, 1, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 0, 299, 2.0F, -4.1529F, 11.5722F, 12, 2, 1, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 0, 299, 0.0F, 0.3201F, 9.1243F, 16, 4, 1, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 0, 299, 3.0F, 7.7214F, 8.9746F, 11, 2, 1, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 0, 299, 7.0F, 12.714F, 8.7015F, 4, 2, 1, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 16, 299, 24.0F, -15.273F, 5.0075F, 3, 0, 2, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 16, 299, 23.0F, -15.1739F, 5.9034F, 3, 0, 2, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 6, 318, -8.0F, -12.7019F, -12.9284F, 14, 10, 1, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 6, 318, -9.0F, -16.9784F, -11.438F, 10, 9, 1, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 6, 318, 12.0F, -13.8409F, -13.5579F, 10, 8, 1, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 6, 318, 9.0F, -11.9358F, -13.5712F, 14, 10, 1, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 6, 318, 10.0F, 0.6869F, -9.6177F, 9, 2, 1, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 6, 318, -4.0F, 0.6869F, -9.6177F, 9, 2, 1, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 6, 318, 16.0F, 0.6869F, -9.6177F, 12, 2, 1, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 6, 318, -11.0F, 0.6869F, -9.6177F, 12, 2, 1, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 6, 318, 15.0F, 5.6487F, -9.5385F, 14, 1, 2, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 6, 318, -11.0F, 5.6487F, -9.5385F, 14, 1, 1, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 6, 318, 15.0F, 9.6595F, -6.7033F, 11, 2, 1, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 6, 318, -8.125F, 9.6595F, -6.7033F, 11, 2, 1, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 6, 318, 11.0F, 9.6595F, -6.7033F, 6, 2, 1, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 6, 318, -2.0F, 9.6595F, -6.7033F, 6, 2, 1, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 6, 318, 10.0F, 5.6487F, -9.5385F, 10, 1, 1, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 6, 318, -5.0F, 5.6487F, -9.5385F, 10, 1, 1, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 6, 318, 24.0F, 0.8917F, -9.1233F, 4, 2, 10, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 6, 318, -11.5F, 0.8917F, -9.1233F, 4, 2, 10, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 6, 318, 28.0F, 5.4552F, -9.06F, 1, 1, 7, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 6, 318, -12.0F, 5.4552F, -9.06F, 1, 1, 7, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 6, 318, 25.5F, 10.906F, -5.7709F, 1, 1, 3, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 6, 318, -8.5F, 10.906F, -5.7709F, 1, 1, 3, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 6, 318, 25.5F, 13.9702F, -7.3421F, 1, 1, 11, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 6, 318, 25.5F, 13.9702F, -7.3421F, 1, 1, 11, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 6, 318, -9.0F, 13.9702F, -7.3421F, 1, 1, 11, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 6, 318, 24.0F, 13.9967F, 0.4681F, 2, 1, 8, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 6, 318, -9.0F, 13.9967F, 0.4681F, 2, 1, 8, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 6, 318, 20.0F, 14.2697F, 5.4607F, 5, 1, 3, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 6, 318, -7.0F, 14.2697F, 5.4607F, 5, 1, 3, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 6, 318, 24.5F, 15.5023F, -8.6276F, 1, 8, 3, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 6, 318, -8.5F, 15.379F, -7.2188F, 1, 8, 3, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 0, 361, -10.0F, -17.6279F, -10.32F, 37, 5, 15, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 0, 361, -2.0F, -25.9776F, -9.2809F, 20, 9, 14, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 0, 361, -1.0F, -27.0418F, -6.7098F, 17, 7, 14, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 0, 361, -3.0F, -23.7637F, -5.4507F, 22, 10, 14, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 0, 361, -11.0F, -2.0F, -9.0F, 39, 8, 19, 0.0F, false));
		Torso.cubeList.add(new ModelBox(Torso, 0, 361, -8.0F, 6.0F, -6.0F, 34, 7, 15, 0.0F, false));

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 34.0F, 0.0F);
		setRotationAngle(bone, 0.0F, 0.0F, -0.7854F);
		Torso.addChild(bone);
		bone.cubeList.add(new ModelBox(bone, 0, 361, 29.0F, -42.0231F, -9.1061F, 13, 5, 15, 0.0F, false));

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(-32.2929F, -40.454F, -0.8973F);
		setRotationAngle(bone3, 0.0F, 0.0F, 0.7854F);
		Torso.addChild(bone3);
		bone3.cubeList.add(new ModelBox(bone3, 0, 361, 46.6777F, -24.3454F, -9.1061F, 13, 5, 15, 0.0F, false));

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(9.0F, 13.0F, 0.0F);
		setRotationAngle(bone2, -1.0472F, 0.0F, 0.0F);
		Torso.addChild(bone2);
		bone2.cubeList.add(new ModelBox(bone2, 0, 361, -15.0F, -6.0F, -5.0F, 30, 12, 11, 0.0F, false));
		bone2.cubeList.add(new ModelBox(bone2, 0, 361, -14.0F, -4.4348F, 3.3994F, 29, 12, 11, 0.0F, false));
		bone2.cubeList.add(new ModelBox(bone2, 0, 361, -11.0F, -1.9452F, 14.0582F, 24, 8, 1, 0.0F, false));

		Head = new ModelRenderer(this);
		Head.setRotationPoint(-5.0F, -80.0F, -16.0F);
		root.addChild(Head);
		Head.cubeList.add(new ModelBox(Head, 46, 396, -6.0F, -0.2758F, -8.3526F, 21, 13, 15, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 46, 396, -6.0F, -0.2758F, -8.3526F, 21, 13, 15, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 46, 396, -5.0F, -2.2758F, -8.3526F, 19, 2, 14, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 46, 396, -4.0F, -4.2758F, -7.3526F, 17, 2, 11, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 46, 396, -3.0F, -5.2758F, -6.3526F, 15, 1, 9, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 38, 200, -2.0F, 5.7242F, -13.6026F, 13, 2, 6, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 54, 366, -2.0F, 11.7242F, -15.3526F, 12, 2, 8, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 78, 257, -1.0F, 5.7242F, -14.8526F, 11, 2, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 91, 318, -4.0F, 0.7242F, -10.3526F, 2, 4, 3, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 67, 305, 13.0F, 1.7242F, -9.1026F, 2, 1, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 67, 305, 6.0F, -1.0258F, -10.3526F, 5, 1, 2, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 67, 305, -2.0F, -1.0258F, -10.3526F, 5, 1, 2, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 67, 305, 2.0F, 3.9742F, -11.3526F, 1, 1, 2, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 67, 305, 2.0F, 2.2242F, -11.3526F, 4, 1, 2, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 67, 305, 5.0F, 3.9742F, -11.3526F, 1, 1, 2, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 91, 374, 3.0F, 3.9742F, -10.8526F, 2, 1, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 67, 305, -6.0F, 4.9742F, -10.3526F, 2, 3, 2, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 67, 305, -4.0F, 4.7242F, -12.3526F, 2, 3, 4, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 67, 305, 2.0F, -0.0258F, -10.3526F, 5, 0, 2, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 67, 305, 15.0F, 3.7242F, -7.3526F, 0, 1, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 67, 305, 12.0F, 5.7242F, -8.8526F, 1, 1, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 67, 305, 13.0F, 7.7242F, -8.8526F, 2, 0, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 73, 316, 9.0F, 6.7242F, -14.3526F, 1, 2, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 73, 294, 8.75F, 9.7242F, -14.6026F, 1, 2, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 126, 312, -0.75F, 9.7242F, -14.6026F, 1, 2, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 65, 318, -1.0F, 6.7242F, -14.3526F, 1, 2, 1, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 75, 281, 2.0F, 0.7242F, -10.3526F, 2, 4, 3, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 51, 308, 4.0F, -0.2758F, -10.3526F, 2, 5, 3, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 80, 328, -4.0F, 0.7242F, -10.3526F, 17, 1, 3, 0.0F, false));

		Leftleg = new ModelRenderer(this);
		Leftleg.setRotationPoint(15.0F, -29.93F, 15.0609F);
		setRotationAngle(Leftleg, 0.3491F, 0.0F, 0.0F);
		root.addChild(Leftleg);
		Leftleg.cubeList.add(new ModelBox(Leftleg, 83, 382, 0.0F, -6.468F, -8.6293F, 11, 19, 12, 0.0F, false));
		Leftleg.cubeList.add(new ModelBox(Leftleg, 83, 382, 0.0F, 20.5128F, 4.0866F, 8, 8, 5, 0.0F, false));

		leftlowerleg = new ModelRenderer(this);
		leftlowerleg.setRotationPoint(5.0F, 10.0F, 3.0F);
		setRotationAngle(leftlowerleg, 0.7854F, 0.0F, 0.0F);
		Leftleg.addChild(leftlowerleg);
		leftlowerleg.cubeList.add(new ModelBox(leftlowerleg, 83, 382, -5.0F, -5.1355F, -10.3434F, 9, 17, 8, 0.0F, false));

		LeftAnkle = new ModelRenderer(this);
		LeftAnkle.setRotationPoint(6.0F, 29.0F, 6.0F);
		setRotationAngle(LeftAnkle, 0.5236F, 0.0F, 0.0F);
		Leftleg.addChild(LeftAnkle);
		LeftAnkle.cubeList.add(new ModelBox(LeftAnkle, 83, 382, -6.0F, -3.1505F, -6.5004F, 8, 4, 10, 0.0F, false));
		LeftAnkle.cubeList.add(new ModelBox(LeftAnkle, 83, 382, -6.0F, -1.9505F, -6.5004F, 8, 3, 10, 0.0F, false));

		leftfoot = new ModelRenderer(this);
		leftfoot.setRotationPoint(4.0F, 31.9362F, -6.0467F);
		setRotationAngle(leftfoot, -0.3491F, 0.0F, 0.0F);
		Leftleg.addChild(leftfoot);
		leftfoot.cubeList.add(new ModelBox(leftfoot, 83, 382, -4.0F, -4.4415F, -0.5787F, 8, 3, 7, 0.0F, false));
		leftfoot.cubeList.add(new ModelBox(leftfoot, 83, 382, -4.0F, -2.8016F, -1.9543F, 8, 1, 2, 0.0F, false));
		leftfoot.cubeList.add(new ModelBox(leftfoot, 83, 382, -6.0F, -2.702F, 3.6989F, 2, 1, 1, 0.0F, false));

		Rightleg = new ModelRenderer(this);
		Rightleg.setRotationPoint(-26.0F, -30.93F, 17.0609F);
		setRotationAngle(Rightleg, 0.2618F, 0.0F, 0.0F);
		root.addChild(Rightleg);
		Rightleg.cubeList.add(new ModelBox(Rightleg, 30, 376, 0.0F, -6.468F, -8.6293F, 11, 19, 12, 0.0F, false));
		Rightleg.cubeList.add(new ModelBox(Rightleg, 30, 376, 0.0F, 20.5128F, 4.0866F, 8, 8, 5, 0.0F, false));

		Rightlowerleg = new ModelRenderer(this);
		Rightlowerleg.setRotationPoint(5.0F, 10.0F, 3.0F);
		setRotationAngle(Rightlowerleg, 0.7854F, 0.0F, 0.0F);
		Rightleg.addChild(Rightlowerleg);
		Rightlowerleg.cubeList.add(new ModelBox(Rightlowerleg, 30, 376, -5.0F, -5.1355F, -10.3434F, 9, 17, 8, 0.0F, false));

		rightankle = new ModelRenderer(this);
		rightankle.setRotationPoint(6.0F, 29.0F, 6.0F);
		setRotationAngle(rightankle, 0.5236F, 0.0F, 0.0F);
		Rightleg.addChild(rightankle);
		rightankle.cubeList.add(new ModelBox(rightankle, 30, 376, -6.0F, -2.9505F, -6.5004F, 8, 4, 10, 0.0F, false));

		Rightfoot = new ModelRenderer(this);
		Rightfoot.setRotationPoint(4.0F, 31.6025F, -5.211F);
		setRotationAngle(Rightfoot, -0.2618F, 0.0F, 0.0F);
		Rightleg.addChild(Rightfoot);
		Rightfoot.cubeList.add(new ModelBox(Rightfoot, 30, 376, -4.0F, -3.0431F, -1.2284F, 8, 3, 7, 0.0F, false));
		Rightfoot.cubeList.add(new ModelBox(Rightfoot, 30, 376, -4.0F, -0.7758F, -3.0078F, 7, 1, 2, 0.0F, false));
		Rightfoot.cubeList.add(new ModelBox(Rightfoot, 30, 376, 4.0F, -1.202F, 2.9489F, 2, 1, 1, 0.0F, false));

		Leftsarm = new ModelRenderer(this);
		Leftsarm.setRotationPoint(19.0F, -63.0F, -8.0F);
		setRotationAngle(Leftsarm, -0.0873F, 0.0F, 0.0F);
		root.addChild(Leftsarm);
		Leftsarm.cubeList.add(new ModelBox(Leftsarm, 0, 366, 0.0F, -3.7902F, -6.1609F, 10, 23, 17, 0.0F, false));
		Leftsarm.cubeList.add(new ModelBox(Leftsarm, 12, 286, 1.0F, -2.7504F, -6.5719F, 3, 3, 2, 0.0F, false));
		Leftsarm.cubeList.add(new ModelBox(Leftsarm, 12, 286, 7.5F, 0.7986F, -1.2423F, 3, 3, 2, 0.0F, false));
		Leftsarm.cubeList.add(new ModelBox(Leftsarm, 12, 286, 1.75F, -3.0213F, -6.3446F, 3, 3, 2, 0.0F, false));
		Leftsarm.cubeList.add(new ModelBox(Leftsarm, 12, 286, 6.75F, -4.2665F, -6.4536F, 2, 2, 2, 0.0F, false));
		Leftsarm.cubeList.add(new ModelBox(Leftsarm, 12, 286, 7.75F, -1.2779F, -6.1921F, 2, 2, 2, 0.0F, false));
		Leftsarm.cubeList.add(new ModelBox(Leftsarm, 12, 286, 7.75F, 11.8687F, -7.3005F, 2, 2, 2, 0.0F, false));
		Leftsarm.cubeList.add(new ModelBox(Leftsarm, 12, 286, 3.75F, 7.6349F, -7.6709F, 2, 2, 2, 0.0F, false));
		Leftsarm.cubeList.add(new ModelBox(Leftsarm, 12, 286, 2.0F, -4.6151F, -2.4688F, 4, 2, 7, 0.0F, false));
		Leftsarm.cubeList.add(new ModelBox(Leftsarm, 12, 286, 5.0F, -3.7122F, 10.158F, 2, 1, 1, 0.0F, false));
		Leftsarm.cubeList.add(new ModelBox(Leftsarm, 0, 366, 0.0F, 19.2098F, -2.1609F, 10, 12, 8, 0.0F, false));

		Leftforarm = new ModelRenderer(this);
		Leftforarm.setRotationPoint(6.0F, 31.0F, 8.0F);
		setRotationAngle(Leftforarm, -0.2618F, 0.0F, 0.0F);
		Leftsarm.addChild(Leftforarm);
		Leftforarm.cubeList.add(new ModelBox(Leftforarm, 0, 366, -7.0F, 0.5062F, -10.0548F, 12, 6, 8, 0.0F, false));
		Leftforarm.cubeList.add(new ModelBox(Leftforarm, 0, 366, -8.0F, 5.8887F, -11.224F, 14, 24, 10, 0.0F, false));
		Leftforarm.cubeList.add(new ModelBox(Leftforarm, 27, 216, 4.0F, 9.1361F, -11.2988F, 2, 5, 6, 0.0F, false));
		Leftforarm.cubeList.add(new ModelBox(Leftforarm, 27, 216, -7.0F, 8.3657F, -6.2583F, 9, 5, 6, 0.0F, false));
		Leftforarm.cubeList.add(new ModelBox(Leftforarm, 27, 216, 5.0F, 15.8004F, -12.0657F, 1, 2, 1, 0.0F, false));
		Leftforarm.cubeList.add(new ModelBox(Leftforarm, 27, 216, 5.0F, 5.0353F, -11.7272F, 1, 2, 1, 0.0F, false));
		Leftforarm.cubeList.add(new ModelBox(Leftforarm, 27, 216, 5.5F, 16.9957F, -9.5023F, 1, 2, 2, 0.0F, false));
		Leftforarm.cubeList.add(new ModelBox(Leftforarm, 27, 216, 5.5F, 25.8813F, -10.5249F, 1, 1, 1, 0.0F, false));
		Leftforarm.cubeList.add(new ModelBox(Leftforarm, 27, 216, -0.5F, 16.7159F, -2.1549F, 1, 1, 1, 0.0F, false));
		Leftforarm.cubeList.add(new ModelBox(Leftforarm, 27, 216, 5.5F, 15.6276F, -5.7435F, 1, 3, 2, 0.0F, false));

		lefthand = new ModelRenderer(this);
		lefthand.setRotationPoint(-7.0F, 29.0F, -1.0F);
		setRotationAngle(lefthand, -0.6109F, 0.0F, 0.0F);
		Leftforarm.addChild(lefthand);
		lefthand.cubeList.add(new ModelBox(lefthand, 0, 366, -1.0F, 1.7266F, -7.0303F, 14, 11, 7, 0.0F, false));
		lefthand.cubeList.add(new ModelBox(lefthand, 0, 366, 10.0F, 8.6405F, -1.1021F, 2, 4, 3, 0.0F, false));
		lefthand.cubeList.add(new ModelBox(lefthand, 0, 366, 7.0F, 7.6405F, -1.1021F, 2, 5, 3, 0.0F, false));
		lefthand.cubeList.add(new ModelBox(lefthand, 0, 366, 4.0F, 7.6405F, -1.1021F, 2, 5, 3, 0.0F, false));
		lefthand.cubeList.add(new ModelBox(lefthand, 0, 366, 0.0F, 7.6405F, -1.1021F, 2, 5, 3, 0.0F, false));
		lefthand.cubeList.add(new ModelBox(lefthand, 0, 366, -4.0F, 5.7266F, -3.0303F, 3, 2, 3, 0.0F, false));

		Rightarm = new ModelRenderer(this);
		Rightarm.setRotationPoint(-20.0F, -61.0F, -5.0F);
		setRotationAngle(Rightarm, -0.0873F, 0.0F, 0.0F);
		root.addChild(Rightarm);
		Rightarm.cubeList.add(new ModelBox(Rightarm, 76, 372, -10.0F, -4.7902F, -9.1609F, 10, 22, 16, 0.0F, false));
		Rightarm.cubeList.add(new ModelBox(Rightarm, 76, 272, -10.25F, -3.0593F, -5.998F, 1, 7, 8, 0.0F, false));
		Rightarm.cubeList.add(new ModelBox(Rightarm, 76, 272, -8.0F, -4.7836F, -2.5863F, 4, 1, 4, 0.0F, false));
		Rightarm.cubeList.add(new ModelBox(Rightarm, 76, 272, -9.0F, -2.5115F, -9.9959F, 8, 7, 0, 0.0F, false));
		Rightarm.cubeList.add(new ModelBox(Rightarm, 76, 272, -10.0F, 9.3309F, -9.9331F, 5, 5, 1, 0.0F, false));
		Rightarm.cubeList.add(new ModelBox(Rightarm, 76, 272, -4.0F, 6.3423F, -10.1946F, 2, 2, 1, 0.0F, false));
		Rightarm.cubeList.add(new ModelBox(Rightarm, 76, 272, -11.0F, 5.9065F, -5.2136F, 2, 2, 3, 0.0F, false));
		Rightarm.cubeList.add(new ModelBox(Rightarm, 76, 272, -11.0F, 9.5426F, 0.1198F, 2, 2, 2, 0.0F, false));
		Rightarm.cubeList.add(new ModelBox(Rightarm, 76, 372, -10.0F, 17.2098F, -5.1609F, 10, 12, 8, 0.0F, false));

		rightforarm2 = new ModelRenderer(this);
		rightforarm2.setRotationPoint(-4.0F, 29.0F, 5.0F);
		setRotationAngle(rightforarm2, -0.2618F, 0.0F, 0.0F);
		Rightarm.addChild(rightforarm2);
		rightforarm2.cubeList.add(new ModelBox(rightforarm2, 76, 372, -7.0F, 0.5062F, -10.0548F, 12, 6, 8, 0.0F, false));
		rightforarm2.cubeList.add(new ModelBox(rightforarm2, 76, 372, -8.0F, 5.8887F, -11.224F, 14, 24, 10, 0.0F, false));
		rightforarm2.cubeList.add(new ModelBox(rightforarm2, 57, 251, -7.0F, 21.9507F, -11.497F, 5, 4, 1, 0.0F, false));
		rightforarm2.cubeList.add(new ModelBox(rightforarm2, 57, 251, -8.75F, 11.5593F, -8.4846F, 4, 5, 6, 0.0F, false));
		rightforarm2.cubeList.add(new ModelBox(rightforarm2, 57, 251, -8.75F, 19.0768F, -5.7484F, 4, 2, 2, 0.0F, false));
		rightforarm2.cubeList.add(new ModelBox(rightforarm2, 57, 251, -8.75F, 22.3243F, -8.8231F, 4, 2, 2, 0.0F, false));
		rightforarm2.cubeList.add(new ModelBox(rightforarm2, 57, 251, -7.0F, 15.714F, -11.9046F, 3, 2, 1, 0.0F, false));
		rightforarm2.cubeList.add(new ModelBox(rightforarm2, 57, 251, 1.0F, 19.2171F, -12.758F, 2, 2, 1, 0.0F, false));
		rightforarm2.cubeList.add(new ModelBox(rightforarm2, 57, 251, -3.0F, 11.5277F, -12.0981F, 3, 2, 1, 0.0F, false));

		righthand2 = new ModelRenderer(this);
		righthand2.setRotationPoint(-7.0F, 29.0F, -1.0F);
		setRotationAngle(righthand2, -0.6109F, 0.0F, 0.0F);
		rightforarm2.addChild(righthand2);
		righthand2.cubeList.add(new ModelBox(righthand2, 76, 372, -1.0F, 1.7266F, -7.0303F, 14, 13, 7, 0.0F, false));
		righthand2.cubeList.add(new ModelBox(righthand2, 76, 372, -0.75F, 8.6097F, -0.2929F, 1, 4, 1, 0.0F, false));
		righthand2.cubeList.add(new ModelBox(righthand2, 76, 372, 3.25F, 8.6097F, -0.2929F, 1, 4, 1, 0.0F, false));
		righthand2.cubeList.add(new ModelBox(righthand2, 76, 372, 7.0F, 8.6097F, -0.2929F, 1, 4, 1, 0.0F, false));
		righthand2.cubeList.add(new ModelBox(righthand2, 76, 372, 10.75F, 8.6097F, -0.2929F, 1, 4, 1, 0.0F, false));
		righthand2.cubeList.add(new ModelBox(righthand2, 76, 372, 13.0F, 5.7266F, -3.0303F, 3, 2, 3, 0.0F, false));
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
		this.Rightleg.rotateAngleX = MathHelper.cos(par2 * 0.6662f) * 1.4f * par3;
		this.Leftleg.rotateAngleX = MathHelper.cos(par2 * 0.6662f + 3.1415927f) * 1.4f * par3;
		this.Rightarm.rotateAngleX = MathHelper.cos(par2 * 0.6662f + 3.1415927f) * 1.4f * par3;
		this.Leftsarm.rotateAngleX = MathHelper.cos(par2 * 0.6662f) * 1.4f * par3;
	}

	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity) {
		super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
		this.Head.rotateAngleX = par5 / 57.295776f;
	}
}