package net.chrupki.crownofthevoid;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public final class ModTags {
    public static class Items {
        public static final TagKey<Item> FLOATING = createTag("floating");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(CrownOfTheVoid.MOD_ID, name));
        }
    }
}
