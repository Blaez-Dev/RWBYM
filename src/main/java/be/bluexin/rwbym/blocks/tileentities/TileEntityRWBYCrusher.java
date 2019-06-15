package be.bluexin.rwbym.blocks.tileentities;
import javax.annotation.Nonnull;

import be.bluexin.rwbym.Init.CrusherRecipe;
import be.bluexin.rwbym.Init.RWBYItems;
import be.bluexin.rwbym.blocks.RWBYCrusher;
import be.bluexin.rwbym.weaponry.RWBYItem;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityRWBYCrusher extends TileEntity implements ITickable
{
    private ItemStackHandler input = new CrusherItemStackHandler(2) {
    	@Override
    	public boolean isItemValid(int slot, ItemStack stack) {
            if (slot == 0) {
                return true;
            } else if (stack.getItem() == RWBYItems.chisel) {
                return stack.getItem() == RWBYItems.chisel;
            } else return stack.getItem() == RWBYItems.crush;
        }
    };
    private ItemStackHandler fuel = new CrusherItemStackHandler(1) {
    	@Override
    	public boolean isItemValid(int slot, ItemStack stack) {
    		return TileEntityRWBYCrusher.isItemFuel(stack);
    	}
    };
    private ItemStackHandler output = new CrusherItemStackHandler(1) {
    	@Override
    	public boolean isItemValid(int slot, ItemStack stack) {
    		return false;
        }
    };
    private String customName;
    private ItemStack smelting = ItemStack.EMPTY;

    private int burnTime;
    private int currentBurnTime;
    private int cookTime;
    private int totalCookTime = 200;

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing)
    {
        if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return true;
        else return false;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing)
    {
        if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
        	switch(facing) {
			case DOWN:
				return (T) this.output;
			case EAST:
				return (T) this.fuel;
			case NORTH:
				return (T) this.fuel;
			case SOUTH:
				return (T) this.fuel;
			case WEST:
				return (T) this.fuel;
			case UP:
				return (T) this.input;
			default:
				break;
        	}
        }
        return super.getCapability(capability, facing);
    }

    public boolean hasCustomName()
    {
        return this.customName != null && !this.customName.isEmpty();
    }

    public void setCustomName(String customName)
    {
        this.customName = customName;
    }

    @Override
    public ITextComponent getDisplayName()
    {
        return this.hasCustomName() ? new TextComponentString(this.customName) : new TextComponentTranslation("container.crusher");
    }

    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        this.input.deserializeNBT(compound.getCompoundTag("Input"));
        this.fuel.deserializeNBT(compound.getCompoundTag("Fuel"));
        this.output.deserializeNBT(compound.getCompoundTag("Output"));
        this.burnTime = compound.getInteger("BurnTime");
        this.cookTime = compound.getInteger("CookTime");
        this.totalCookTime = compound.getInteger("CookTimeTotal");
        this.currentBurnTime = getItemBurnTime((ItemStack)this.fuel.getStackInSlot(0));

        if(compound.hasKey("CustomName", 8)) this.setCustomName(compound.getString("CustomName"));
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        compound.setInteger("BurnTime", (short)this.burnTime);
        compound.setInteger("CookTime", (short)this.cookTime);
        compound.setInteger("CookTimeTotal", (short)this.totalCookTime);
        compound.setTag("Input", this.input.serializeNBT());
        compound.setTag("Fuel", this.fuel.serializeNBT());
        compound.setTag("Output", this.output.serializeNBT());

        if(this.hasCustomName()) compound.setString("CustomName", this.customName);
        return compound;
    }

    public boolean isBurning()
    {
        return this.burnTime > 0;
    }

    @SideOnly(Side.CLIENT)
    public static boolean isBurning(TileEntityRWBYCrusher te)
    {
        return te.getField(0) > 0;
    }

    public void update()
    {
        if(this.isBurning())
        {
            --this.burnTime;
            RWBYCrusher.setState(true, world, pos);
        }

        ItemStack[] inputs = new ItemStack[] {input.getStackInSlot(0).copy(), input.getStackInSlot(1).copy()};
        ItemStack fuel = this.fuel.getStackInSlot(0);

        if(this.isBurning() || !fuel.isEmpty() && !this.input.getStackInSlot(0).isEmpty() || this.input.getStackInSlot(1).isEmpty())
        {
            if(!this.isBurning() && this.canSmelt())
            {
                this.burnTime = getItemBurnTime(fuel);
                this.currentBurnTime = burnTime;

                if(this.isBurning() && !fuel.isEmpty())
                {
                    Item item = fuel.getItem();
                    fuel.shrink(1);

                    if(fuel.isEmpty())
                    {
                        ItemStack item1 = item.getContainerItem(fuel);
                        this.fuel.setStackInSlot(0, item1);
                    }
                }
            }
        }

        if(this.isBurning() && this.canSmelt() && cookTime > 0)
        {
            cookTime++;
            if(cookTime == totalCookTime)
            {
                if(output.getStackInSlot(0).getCount() > 0)
                {
                    output.getStackInSlot(0).grow(smelting.getCount());
                }
                else
                {
                    output.setStackInSlot(0, smelting);
                }
                
                if (inputs[0].getItem().hasContainerItem(inputs[0])) {
                	input.setStackInSlot(0, inputs[0].getItem().getContainerItem(inputs[0]));
                }
                else {
                	inputs[0].shrink(1);
                	input.setStackInSlot(0, inputs[0]);
                }
                
                if (inputs[1].getItem().hasContainerItem(inputs[1])) {
                	input.setStackInSlot(1, inputs[1].getItem().getContainerItem(inputs[1]));
                }
                else {
                	inputs[0].shrink(1);
                	input.setStackInSlot(1, inputs[1]);
                }

                smelting = ItemStack.EMPTY;
                cookTime = 0;
                return;
            }
        }
        else
        {
            if(this.canSmelt() && this.isBurning())
            {
                ItemStack output = CrusherRecipe.getInstance().getCrusherResult(inputs[0], inputs[1]);
                if(!output.isEmpty())
                {
                    smelting = output.copy();
                    cookTime++;
                }
            }
        }
    }

    private boolean canSmelt()
    {
        if(((ItemStack)this.input.getStackInSlot(0)).isEmpty() || ((ItemStack)this.input.getStackInSlot(1)).isEmpty()) return false;
        else
        {
            ItemStack result = CrusherRecipe.getInstance().getCrusherResult((ItemStack)this.input.getStackInSlot(0), (ItemStack)this.input.getStackInSlot(1));
            if(result.isEmpty()) return false;
            else
            {
                ItemStack output = (ItemStack)this.output.getStackInSlot(0);
                if(output.isEmpty()) return true;
                if(!output.isItemEqual(result)) return false;
                int res = output.getCount() + result.getCount();
                return res <= 64 && res <= output.getMaxStackSize();
            }
        }
    }

    public static int getItemBurnTime(ItemStack fuel)
    {
        if(fuel.isEmpty()) return 0;
        else
        {
            Item item = fuel.getItem();

            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.AIR)
            {
                Block block = Block.getBlockFromItem(item);

                if (block == Blocks.WOODEN_SLAB) return 150;
                if (block.getDefaultState().getMaterial() == Material.WOOD) return 300;
                if (block == Blocks.COAL_BLOCK) return 16000;
            }

            if (item instanceof ItemTool && "WOOD".equals(((ItemTool)item).getToolMaterialName())) return 200;
            if (item instanceof ItemSword && "WOOD".equals(((ItemSword)item).getToolMaterialName())) return 200;
            if (item instanceof ItemHoe && "WOOD".equals(((ItemHoe)item).getMaterialName())) return 200;
            if (item == Items.STICK) return 100;
            if (item == Items.COAL) return 1600;
            if (item == Items.LAVA_BUCKET) return 20000;
            if (item == Item.getItemFromBlock(Blocks.SAPLING)) return 100;
            if (item == Items.BLAZE_ROD) return 2400;

            return GameRegistry.getFuelValue(fuel);
        }
    }

    public static boolean isItemFuel(ItemStack fuel)
    {
        return getItemBurnTime(fuel) > 0;
    }

    public boolean isUsableByPlayer(EntityPlayer player)
    {
        return this.world.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
    }

    public int getField(int id)
    {
        switch(id)
        {
            case 0:
                return this.burnTime;
            case 1:
                return this.currentBurnTime;
            case 2:
                return this.cookTime;
            case 3:
                return this.totalCookTime;
            default:
                return 0;
        }
    }

    public void setField(int id, int value)
    {
        switch(id)
        {
            case 0:
                this.burnTime = value;
                break;
            case 1:
                this.currentBurnTime = value;
                break;
            case 2:
                this.cookTime = value;
                break;
            case 3:
                this.totalCookTime = value;
        }
    }
    
    private class CrusherItemStackHandler extends ItemStackHandler {
        public CrusherItemStackHandler()
        {
            super();
        }

        public CrusherItemStackHandler(int size)
        {
            super(size);
        }

        public CrusherItemStackHandler(NonNullList<ItemStack> stacks)
        {
            super(stacks);
        }
        
        //because forge is stupid
    	@Override
        public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate)
        {
            if (stack.isEmpty())
                return ItemStack.EMPTY;

            validateSlotIndex(slot);
            
            if (!this.isItemValid(slot, stack)) {
            	return stack;
            }

            ItemStack existing = this.stacks.get(slot);

            int limit = getStackLimit(slot, stack);

            if (!existing.isEmpty())
            {
                if (!ItemHandlerHelper.canItemStacksStack(stack, existing))
                    return stack;

                limit -= existing.getCount();
            }

            if (limit <= 0)
                return stack;

            boolean reachedLimit = stack.getCount() > limit;

            if (!simulate)
            {
                if (existing.isEmpty())
                {
                    this.stacks.set(slot, reachedLimit ? ItemHandlerHelper.copyStackWithSize(stack, limit) : stack);
                }
                else
                {
                    existing.grow(reachedLimit ? limit : stack.getCount());
                }
                onContentsChanged(slot);
            }

            return reachedLimit ? ItemHandlerHelper.copyStackWithSize(stack, stack.getCount()- limit) : ItemStack.EMPTY;
        }
    }
}