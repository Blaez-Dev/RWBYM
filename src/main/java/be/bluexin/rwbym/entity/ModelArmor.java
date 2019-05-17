package be.bluexin.rwbym.entity;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;

public class ModelArmor extends ModelPlayer {
	
	private final EntityEquipmentSlot slot;
	
	public ModelArmor(float modelSize, boolean smallArmsIn, EntityEquipmentSlot slotIn) {
		super(modelSize, smallArmsIn);
		this.slot = slotIn;
	}
	
	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		
		this.setVisiblePart();
		
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
	}
	
	@SuppressWarnings("incomplete-switch")
	private void setVisiblePart() {
		
		this.setVisible(false);
		
		switch (this.slot) {
		case HEAD:
			this.bipedHead.showModel = true;
			this.bipedHeadwear.showModel = true;
			break;
		case CHEST:
			this.bipedLeftArm.showModel = true;
			this.bipedLeftArmwear.showModel = true;
			this.bipedRightArm.showModel = true;
			this.bipedRightArmwear.showModel = true;
			this.bipedBody.showModel = true;
			this.bipedBodyWear.showModel = true;
			break;
		case LEGS:
			this.bipedLeftLeg.showModel = true;
			this.bipedLeftLegwear.showModel = true;
			this.bipedRightLeg.showModel = true;
			this.bipedRightLegwear.showModel = true;
			//this.bipedBody.showModel = true;
			//this.bipedBodyWear.showModel = true;
			break;
		case FEET:
			//this.bipedLeftLeg.showModel = true;
			//this.bipedLeftLegwear.showModel = true;
			//this.bipedRightLeg.showModel = true;
			//this.bipedRightLegwear.showModel = true;
			break;
		default:
			this.setVisible(true);
		}
	}
}
