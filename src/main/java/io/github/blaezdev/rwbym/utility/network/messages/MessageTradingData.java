package io.github.blaezdev.rwbym.utility.network.messages;


import io.github.blaezdev.rwbym.inventory.ContainerVillager;
import io.github.blaezdev.rwbym.utility.IPrivateAccessor;
import io.github.blaezdev.rwbym.utility.network.MessageBase;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.network.PacketBuffer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MessageTradingData extends MessageBase<MessageTradingData> implements IPrivateAccessor {

    private static final Logger LOGGER = LogManager.getLogger();
    private int channel;
    private PacketBuffer data;

    public MessageTradingData() {
    }

    public MessageTradingData(int channelIn, PacketBuffer bufIn) {
        this.channel = channelIn;
        this.data = bufIn;

        if (bufIn.writerIndex() > 32767)
        {
            throw new IllegalArgumentException("Payload may not be larger than 32767 bytes");
        }
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.channel = buf.readUnsignedByte();
        int i = buf.readableBytes();

        if (i >= 0 && i <= 32767)
        {
            this.data = new PacketBuffer(buf.readBytes(i));
        }
        else
        {
            throw new IllegalArgumentException("Payload may not be larger than 32767 bytes");
        }
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeByte(this.channel);
        synchronized(this.data) {
            this.data.markReaderIndex();
            buf.writeBytes(this.data);
            this.data.resetReaderIndex();
        }
    }

    @Override
    public void handleClientSide(MessageTradingData message, EntityPlayer player) {

    }

    @Override
    public void handleServerSide(MessageTradingData message, EntityPlayer player) {

        switch (message.getChannelId()) {

            //Select trade
            case 0:

                try
                {
                    int k = message.getBufferData().readUnsignedByte();
                    boolean flag = message.getBufferData().readBoolean();
                    Container container = player.openContainer;

                    if (container instanceof ContainerVillager)
                    {
                        ((ContainerVillager)container).setCurrentRecipeIndex(k);
                        if (flag) {
                            ((ContainerVillager)container).clearTradingSlots();
                        }
                    }
                }
                catch (Exception exception5)
                {
                    LOGGER.error("Couldn't select trade", exception5);
                }
                break;

            //Set wealth for storing last trade
            case 1:

                try
                {
                    int k = message.getBufferData().readUnsignedByte();
                    int l = message.getBufferData().readInt();
                    Entity entity = player.world.getEntityByID(l);

                    if (entity instanceof EntityVillager) {
                        this.setWealth((EntityVillager) entity, k);
                    }
                }
                catch (Exception exception5)
                {
                    LOGGER.error("Couldn't set wealth", exception5);
                }
                break;

            //Populate trading slots
            case 2:

                try
                {
                    int k = message.getBufferData().readUnsignedByte();
                    boolean flag = message.getBufferData().readBoolean();
                    boolean flag1 = message.getBufferData().readBoolean();
                    boolean flag2 = message.getBufferData().readBoolean();
                    Container container = player.openContainer;

                    if (container instanceof ContainerVillager)
                    {
                        ((ContainerVillager) container).handleClickedButtonItems(k, flag, flag1, flag2);
                    }
                }
                catch (Exception exception5)
                {
                    LOGGER.error("Couldn't populate trading slots", exception5);
                }
                break;

        }

    }

    private int getChannelId()
    {
        return this.channel;
    }

    private PacketBuffer getBufferData()
    {
        return this.data;
    }
}
