package net.chrupki.crownofthevoid.items;

import net.chrupki.crownofthevoid.CrownOfTheVoid;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraftforge.event.entity.living.EnderManAngerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CrownOfTheVoid.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EndermanHelmetHandler {
    @SubscribeEvent
    public static void onEndermanAnger(EnderManAngerEvent event) {
        var player = event.getPlayer();
        if (player != null && player.getItemBySlot(EquipmentSlot.HEAD).is(ModItems.ENDERITE_HELMET.get())) {
            event.setCanceled(true);
        }
    }
}
