package net.chrupki.endmod.items;

import net.chrupki.endmod.EndMod;
import net.chrupki.endmod.blocks.Blocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
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
                    .title(Component.translatable("creativetab.endmod.enderite_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(Items.ENDERITE_INGOT.get());
                        output.accept(Items.ENDERITE_SCRAP.get());
                        output.accept(Items.ENDERITE_UPGRADE_SMITHING_TEMPLATE.get());

                        output.accept(Items.ENDERITE_SWORD.get());
                        output.accept(Items.ENDERITE_AXE.get());
                        output.accept(Items.ENDERITE_SHOVEL.get());
                        output.accept(Items.ENDERITE_HOE.get());
                        output.accept(Items.ENDERITE_PICKAXE.get());

                        output.accept(Blocks.MODERN_DEBRIS.get());

                        output.accept(Items.ENDERITE_HELMET.get());
                        output.accept(Items.ENDERITE_CHESTPLATE.get());
                        output.accept(Items.ENDERITE_LEGGINGS.get());
                        output.accept(Items.ENDERITE_BOOTS.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
