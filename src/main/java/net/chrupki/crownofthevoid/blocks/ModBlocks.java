package net.chrupki.crownofthevoid.blocks;

import net.chrupki.crownofthevoid.CrownOfTheVoid;
import net.chrupki.crownofthevoid.items.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, CrownOfTheVoid.MOD_ID);

    public static final RegistryObject<Block> MODERN_DEBRIS = registerBlock("modern_debris",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(65f, 1500f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.ANCIENT_DEBRIS)));

    public static final RegistryObject<Block> METEOR_STONE = registerBlock("meteor_stone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(20f, 1000f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
