package net.chrupki.end;


import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;


public class FloatingItems extends Item {
    public FloatingItems(Properties props) {
        super(props);
    }

    @Override
    public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity) {
        entity.setNoGravity(true);
        return false;
    }

}
