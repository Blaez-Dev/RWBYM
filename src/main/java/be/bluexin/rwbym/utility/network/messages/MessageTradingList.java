package be.bluexin.rwbym.utility.network.messages;


import be.bluexin.rwbym.gui.GuiVillager;
import be.bluexin.rwbym.utility.network.MessageBase;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.village.MerchantRecipeList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class MessageTradingList extends MessageBase<MessageTradingList> {

    private static final Logger LOGGER = LogManager.getLogger();
    private PacketBuffer data;

    public MessageTradingList()
    {
    }

    public MessageTradingList(PacketBuffer bufIn)
    {
        this.data = bufIn;

        if (bufIn.writerIndex() > 1048576)
        {
            throw new IllegalArgumentException("Payload may not be larger than 1048576 bytes");
        }
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        int i = buf.readableBytes();

        if (i >= 0 && i <= 1048576)
        {
            this.data = new PacketBuffer(buf.readBytes(i));
        }
        else
        {
            throw new IllegalArgumentException("Payload may not be larger than 1048576 bytes");
        }
    }

    @Override
    public void toBytes(ByteBuf buf) {
        synchronized(this.data) {
            this.data.markReaderIndex();
            buf.writeBytes(this.data);
            this.data.resetReaderIndex();
        }
    }

    @Override
    public void handleClientSide(MessageTradingList message, EntityPlayer player) {

        Minecraft gameController = Minecraft.getMinecraft();
        PacketBuffer packetbuffer = message.getBufferData();

        gameController.addScheduledTask(() -> {
            try {
                int k = packetbuffer.readInt();
                GuiScreen guiscreen = gameController.currentScreen;

                if (guiscreen instanceof GuiVillager && k == gameController.player.openContainer.windowId) {
                    IMerchant imerchant = ((GuiVillager) guiscreen).getMerchant();
                    MerchantRecipeList merchantrecipelist = MerchantRecipeList.readFromBuf(packetbuffer);
                    imerchant.setRecipes(merchantrecipelist);
                }
            } catch (IOException ioexception) {
                LOGGER.error("Couldn't load trade info", ioexception);
            }
        });

    }

    @Override
    public void handleServerSide(MessageTradingList message, EntityPlayer player) {
    }

    @SideOnly(Side.CLIENT)
    private PacketBuffer getBufferData()
    {
        return this.data;
    }
}
