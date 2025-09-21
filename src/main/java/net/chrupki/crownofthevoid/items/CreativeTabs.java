package net.chrupki.crownofthevoid.items;

import net.chrupki.crownofthevoid.CrownOfTheVoid;
import net.chrupki.crownofthevoid.blocks.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CrownOfTheVoid.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ENDERITE_TAB = CREATIVE_MODE_TABS.register("enderite_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.ENDERITE_INGOT.get()))
                    .title(Component.translatable("creativetab.crownofthevoid.enderite_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.ENDERITE_INGOT.get());
                        output.accept(ModItems.ENDERITE_SCRAP.get());
                        output.accept(ModItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE.get());
                        output.accept(ModBlocks.MODERN_DEBRIS.get());
                        output.accept(ModBlocks.METEOR_STONE.get());


                        output.accept(ModItems.ENDERITE_SWORD.get());
                        output.accept(ModItems.ENDERITE_AXE.get());
                        output.accept(ModItems.ENDERITE_SHOVEL.get());
                        output.accept(ModItems.ENDERITE_HOE.get());
                        output.accept(ModItems.ENDERITE_PICKAXE.get());


                        output.accept(ModItems.ENDERITE_HELMET.get());
                        output.accept(ModItems.ENDERITE_CHESTPLATE.get());
                        output.accept(ModItems.ENDERITE_LEGGINGS.get());
                        output.accept(ModItems.ENDERITE_BOOTS.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
