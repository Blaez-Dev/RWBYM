package io.github.blaez-dev.rwbym.utility.network.messages;



import io.github.blaez-dev.rwbym.RWBYModels;
import io.github.blaez-dev.rwbym.gui.GuiVillager;
import io.github.blaez-dev.rwbym.utility.IPrivateAccessor;
import io.github.blaez-dev.rwbym.utility.network.MessageBase;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.NpcMerchant;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MessageOpenWindow extends MessageBase<MessageOpenWindow> implements IPrivateAccessor
{
    private int windowId;
    private ITextComponent windowTitle;
    private int slotCount;
    private int entityId;
    private int wealth;

    public MessageOpenWindow() {
    }

    public MessageOpenWindow(int windowIdIn, ITextComponent windowTitleIn, int slotCountIn, int entityIdIn, int wealth)
    {
        this.windowId = windowIdIn;
        this.windowTitle = windowTitleIn;
        this.slotCount = slotCountIn;
        this.entityId = entityIdIn;
        this.wealth = wealth;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.windowId = buf.readUnsignedByte();
        this.windowTitle = ITextComponent.Serializer.jsonToComponent(ByteBufUtils.readUTF8String(buf));
        this.slotCount = buf.readUnsignedByte();
        this.wealth = buf.readUnsignedByte();
        this.entityId = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeByte(this.windowId);
        ByteBufUtils.writeUTF8String(buf, ITextComponent.Serializer.componentToJson(this.windowTitle));
        buf.writeByte(this.slotCount);
        buf.writeByte(this.wealth);
        buf.writeInt(this.entityId);
    }

    @Override
    public void handleClientSide(MessageOpenWindow message, EntityPlayer player) {
        Minecraft gameController = Minecraft.getMinecraft();
        World worldIn = player.world;
        Entity entity = worldIn.getEntityByID(message.entityId);
        if (entity instanceof EntityVillager) {
            EntityVillager entityVillager = (EntityVillager) entity;
            this.setWealth(entityVillager, message.getWealth());
            gameController.addScheduledTask(() -> {
                //crashes on server startup when calling Minecraft#displayGuiScreen directly, @SideOnly and FMLCommonHandler#showGuiScreen seem to solve this as well
                Object guiContainer = new GuiVillager(player.inventory, new NpcMerchant(player, message.getWindowTitle()), entityVillager, worldIn);
                RWBYModels.proxy.showGuiScreen(guiContainer);
            player.openContainer.windowId = message.getWindowId();
            });
        }
    }

    @Override
    public void handleServerSide(MessageOpenWindow message, EntityPlayer player) {
    }

    @SideOnly(Side.CLIENT)
    private int getWindowId()
    {
        return this.windowId;
    }

    @SideOnly(Side.CLIENT)
    private ITextComponent getWindowTitle()
    {
        return this.windowTitle;
    }

    @SideOnly(Side.CLIENT)
    private int getWealth()
    {
        return this.wealth;
    }
}