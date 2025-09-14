// FloatingItemsHandler.java
package net.chrupki.crownofthevoid;

import com.mojang.logging.LogUtils;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

@Mod.EventBusSubscriber(modid = CrownOfTheVoid.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class FloatingItemsHandler {
    private static final Logger LOG = LogUtils.getLogger();

    @SubscribeEvent
    public static void onItemSpawn(EntityJoinLevelEvent event) {
        if (!(event.getEntity() instanceof ItemEntity item)) return;
        if (event.getLevel().isClientSide()) return; // agir côté serveur

        LOG.info("[COTV] ItemEntity spawned: {}", item.getItem());

        if (item.getItem().is(ModTags.Items.FLOATING)) {
            item.setNoGravity(true);
            item.setDeltaMovement(item.getDeltaMovement().x, 0.0, item.getDeltaMovement().z);
            LOG.info("[COTV] Floating on spawn: {}", item.getItem());
        }
    }
}
