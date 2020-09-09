package io.github.blaezdev.rwbym.utility.network;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import io.github.blaezdev.rwbym.weaponry.specialweapons.guns.ItemGun;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class MessageShoot extends MessageBase<MessageShoot> {
	
	NBTTagCompound nbt;
	double damage;
	float accuracy1;
	float accuracy2;
	int life;
	int bullets;

		
	public MessageShoot() {}
	
	public MessageShoot(NBTTagCompound nbt, double damage, float accuracy1, float accuracy2, int life, int bullets) {

		this.nbt = nbt;
		this.damage = damage;
		this.accuracy1 = accuracy1;
		this.accuracy2 = accuracy2;
		this.life = life;
		this.bullets = bullets;
		
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		
		nbt = ByteBufUtils.readTag(buf);
		damage = buf.readDouble();
		accuracy1 = buf.readFloat();
		accuracy2 = buf.readFloat();
		life = buf.readInt();
		bullets = buf.readInt();
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		
		ByteBufUtils.writeTag(buf, nbt);
		buf.writeDouble(damage);
		buf.writeFloat(accuracy1);
		buf.writeFloat(accuracy2);
		buf.writeInt(life);
		buf.writeInt(bullets);

	}

	@Override
	public void handleClientSide(MessageShoot message, EntityPlayer player) {

	}

	@Override
	public void handleServerSide(MessageShoot message, EntityPlayer player) {
		
		//System.out.println("MessageShoot Received" + message.nbt);
		((ItemGun) player.getHeldItemMainhand().getItem()).Shoot(message.nbt, player, message.damage, message.accuracy1, message.accuracy2, message.bullets, message.life);
	
	}

}
