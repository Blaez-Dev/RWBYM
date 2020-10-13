package io.github.blaezdev.rwbym.utility.network;

import io.github.blaezdev.rwbym.RWBYModels;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MoveMessage extends MessageBase<MoveMessage>
{
    private int distance;

    public MoveMessage(){}

    public MoveMessage(int distance)
    {
        this.distance = distance;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        distance = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(distance);
    }

    /*
    public static class Handler implements IMessageHandler<MoveMessage, IMessage>
    {
        @Override
        public IMessage onMessage(MoveMessage message, MessageContext ctx)
        {
            EntityPlayer player = RWBYModels.proxy.getPlayerFromMessage(ctx);
            player.move(MoverType.SELF, message.distance*Math.cos(-player.rotationPitch * (Math.PI / 180F))*Math.sin(-player.rotationYaw * (Math.PI / 180F)), message.distance*Math.sin(-player.rotationPitch * (Math.PI / 180F)), message.distance*Math.cos(-player.rotationPitch * (Math.PI / 180F))*Math.cos(-player.rotationYaw * (Math.PI / 180F)));
            return null;
        }
    }*/

    public void handleClientSide(MoveMessage message, EntityPlayer player) {
        player.move(MoverType.SELF, message.distance*Math.cos(-player.rotationPitch * (Math.PI / 180F))*Math.sin(-player.rotationYaw * (Math.PI / 180F)), message.distance*Math.sin(-player.rotationPitch * (Math.PI / 180F)), message.distance*Math.cos(-player.rotationPitch * (Math.PI / 180F))*Math.cos(-player.rotationYaw * (Math.PI / 180F)));

    }

    public void handleServerSide(MoveMessage message, EntityPlayer player) {
        player.move(MoverType.SELF, message.distance*Math.cos(-player.rotationPitch * (Math.PI / 180F))*Math.sin(-player.rotationYaw * (Math.PI / 180F)), message.distance*Math.sin(-player.rotationPitch * (Math.PI / 180F)), message.distance*Math.cos(-player.rotationPitch * (Math.PI / 180F))*Math.cos(-player.rotationYaw * (Math.PI / 180F)));
    }

}