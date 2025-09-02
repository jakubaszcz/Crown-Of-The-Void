package net.chrupki.end.items;

import net.chrupki.end.EndMod;
import net.chrupki.end.blocks.Blocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EndMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ENDERITE_TAB = CREATIVE_MODE_TABS.register("enderite_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(Items.ENDERITE_INGOT.get()))
                    .title(Component.translatable("creativetab.end.enderite_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(Items.ENDERITE_INGOT.get());
                        output.accept(Items.ENDERITE_SCRAP.get());
                        output.accept(Blocks.MODERN_DEBRIS.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
