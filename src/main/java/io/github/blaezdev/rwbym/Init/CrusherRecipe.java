package io.github.blaezdev.rwbym.Init;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import java.util.Map;
import java.util.Map.Entry;

public class CrusherRecipe
{
    private static final CrusherRecipe INSTANCE = new CrusherRecipe();
    private final Table<ItemStack, ItemStack, ItemStack> smeltingList = HashBasedTable.<ItemStack, ItemStack, ItemStack>create();
    private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();

    public static CrusherRecipe getInstance()
    {
        return INSTANCE;
    }

    private CrusherRecipe()
    {
        //addSinteringRecipe(new ItemStack(Blocks.ACACIA_FENCE), new ItemStack(Blocks.ACACIA_FENCE_GATE), new ItemStack(BlockInit.COPPER_CHEST), 5.3F);
        addCrusherRecipe(new ItemStack(RWBYItems.dustrock), new ItemStack(RWBYItems.chisel, 1, Short.MAX_VALUE), new ItemStack(RWBYItems.dustcrystal, 2), 3);
        addCrusherRecipe(new ItemStack(RWBYItems.dustrock), new ItemStack(RWBYItems.crush, 1, Short.MAX_VALUE), new ItemStack(RWBYItems.dust, 2), 3);
        addCrusherRecipe(new ItemStack(RWBYItems.firedustrock), new ItemStack(RWBYItems.chisel, 1, Short.MAX_VALUE), new ItemStack(RWBYItems.firedustcrystal, 2), 3);
        addCrusherRecipe(new ItemStack(RWBYItems.firedustrock), new ItemStack(RWBYItems.crush, 1, Short.MAX_VALUE), new ItemStack(RWBYItems.firedust, 2), 3);
        addCrusherRecipe(new ItemStack(RWBYItems.gravitydustrock), new ItemStack(RWBYItems.chisel, 1, Short.MAX_VALUE), new ItemStack(RWBYItems.gravitydustcrystal, 2), 3);
        addCrusherRecipe(new ItemStack(RWBYItems.gravitydustrock), new ItemStack(RWBYItems.crush, 1, Short.MAX_VALUE), new ItemStack(RWBYItems.gravitydust, 2), 3);
        addCrusherRecipe(new ItemStack(RWBYItems.winddustrock), new ItemStack(RWBYItems.chisel, 1, Short.MAX_VALUE), new ItemStack(RWBYItems.winddustcrystal, 2), 3);
        addCrusherRecipe(new ItemStack(RWBYItems.winddustrock), new ItemStack(RWBYItems.crush, 1, Short.MAX_VALUE), new ItemStack(RWBYItems.winddust, 2), 3);
        addCrusherRecipe(new ItemStack(RWBYItems.waterdustrock), new ItemStack(RWBYItems.chisel, 1, Short.MAX_VALUE), new ItemStack(RWBYItems.waterdustcrystal, 2), 3);
        addCrusherRecipe(new ItemStack(RWBYItems.waterdustrock), new ItemStack(RWBYItems.crush, 1, Short.MAX_VALUE), new ItemStack(RWBYItems.waterdust, 2), 3);
        addCrusherRecipe(new ItemStack(RWBYItems.lightdustrock), new ItemStack(RWBYItems.chisel, 1, Short.MAX_VALUE), new ItemStack(RWBYItems.lightdustcrystal, 2), 3);
        addCrusherRecipe(new ItemStack(RWBYItems.lightdustrock), new ItemStack(RWBYItems.crush, 1, Short.MAX_VALUE), new ItemStack(RWBYItems.lightdust, 2), 3);
        addCrusherRecipe(new ItemStack(RWBYItems.icedustrock), new ItemStack(RWBYItems.chisel, 1, Short.MAX_VALUE), new ItemStack(RWBYItems.icedustcrystal, 2), 3);
        addCrusherRecipe(new ItemStack(RWBYItems.icedustrock), new ItemStack(RWBYItems.crush, 1, Short.MAX_VALUE), new ItemStack(RWBYItems.icedust, 2), 3);
        addCrusherRecipe(new ItemStack(RWBYItems.gravitydustcrystal), new ItemStack(RWBYItems.chisel, 1, Short.MAX_VALUE), new ItemStack(RWBYItems.gravitydustcrystalcut, 1), 3);
        addCrusherRecipe(new ItemStack(RWBYItems.winddustcrystal), new ItemStack(RWBYItems.chisel, 1, Short.MAX_VALUE), new ItemStack(RWBYItems.winddustcrystalcut, 1), 3);
        addCrusherRecipe(new ItemStack(RWBYItems.waterdustcrystal), new ItemStack(RWBYItems.chisel, 1, Short.MAX_VALUE), new ItemStack(RWBYItems.waterdustcrystalcut, 1), 3);
        addCrusherRecipe(new ItemStack(RWBYItems.firedustcrystal), new ItemStack(RWBYItems.chisel, 1, Short.MAX_VALUE), new ItemStack(RWBYItems.firedustcrystalcut, 1), 3);
        addCrusherRecipe(new ItemStack(RWBYItems.dustcrystal), new ItemStack(RWBYItems.chisel, 1, Short.MAX_VALUE), new ItemStack(RWBYItems.dustcrystalcut, 1), 3);
        addCrusherRecipe(new ItemStack(RWBYItems.lightdustcrystal), new ItemStack(RWBYItems.chisel, 1, Short.MAX_VALUE), new ItemStack(RWBYItems.lightdustcrystalcut, 1), 3);
        addCrusherRecipe(new ItemStack(RWBYItems.icedustcrystal), new ItemStack(RWBYItems.chisel, 1, Short.MAX_VALUE), new ItemStack(RWBYItems.icedustcrystalcut, 1), 3);
        addCrusherRecipe(new ItemStack(RWBYItems.scrap), new ItemStack(RWBYItems.chisel, 1, Short.MAX_VALUE), new ItemStack(Items.IRON_NUGGET, 9), 3);
        addCrusherRecipe(new ItemStack(RWBYItems.dustrockhardlight), new ItemStack(RWBYItems.chisel, 1, Short.MAX_VALUE), new ItemStack(RWBYItems.dustcrystalhardlight, 2), 3);
    }


    public void addCrusherRecipe(ItemStack input1, ItemStack input2, ItemStack result, float experience)
    {
        if(getCrusherResult(input1, input2) != ItemStack.EMPTY) return;
        this.smeltingList.put(input1, input2, result);
        this.experienceList.put(result, Float.valueOf(experience));
    }

    public ItemStack getCrusherResult(ItemStack input1, ItemStack input2)
    {
        for(Entry<ItemStack, Map<ItemStack, ItemStack>> entry : this.smeltingList.rowMap().entrySet())
        {
            if(this.compareItemStacks(input1, (ItemStack)entry.getKey()))
            {
                for(Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet())
                {
                    if(this.compareItemStacks(input2, (ItemStack)ent.getKey()))
                    {
                        return (ItemStack)ent.getValue();
                    }
                }
            }
        }
        return ItemStack.EMPTY;
    }

    private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
    {
        return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == Short.MAX_VALUE || stack2.getMetadata() == stack1.getMetadata());
    }

    public Table<ItemStack, ItemStack, ItemStack> getDualSmeltingList()
    {
        return this.smeltingList;
    }

    public float getCrusherExperience(ItemStack stack)
    {
        for (Entry<ItemStack, Float> entry : this.experienceList.entrySet())
        {
            if(this.compareItemStacks(stack, (ItemStack)entry.getKey()))
            {
                return ((Float)entry.getValue()).floatValue();
            }
        }
        return 0.0F;
    }
}