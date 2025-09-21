package net.chrupki.crownofthevoid.items;

import net.chrupki.crownofthevoid.CrownOfTheVoid;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;

import java.util.List;

public class ModItems {

    public class ModTiers {

        public static final Tier ENDERITE_TIER = new Tier() {
            private final Tier BASE = Tiers.NETHERITE;

            @Override
            public int getUses() {
                return Math.round(BASE.getUses() * 1.5f);
            }

            @Override
            public float getSpeed() {
                return BASE.getSpeed() * 1.5f;
            }

            @Override
            public float getAttackDamageBonus() {
                return BASE.getAttackDamageBonus() * 1.5f;
            }

            @Override
            public TagKey<Block> getIncorrectBlocksForDrops() {
                return Tiers.NETHERITE.getIncorrectBlocksForDrops();
            }

            @Override
            public int getEnchantmentValue() {
                return Math.max(1, Math.round(BASE.getEnchantmentValue() * 1.5f));
            }

            @Override
            public Ingredient getRepairIngredient() {
                return Ingredient.of(ModItems.ENDERITE_INGOT.get());
            }

            @Override
            public Tool createToolProperties(TagKey<Block> pBlock) {
                return Tier.super.createToolProperties(pBlock);
            }
        };
    }


    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CrownOfTheVoid.MOD_ID);

    public static final RegistryObject<Item> ENDERITE_SCRAP = ITEMS.register("enderite_scrap",
            () -> new Item(new Item.Properties().fireResistant()));



    public static final RegistryObject<Item> ENDERITE_INGOT = ITEMS.register("enderite_ingot",
            () -> new Item(new Item.Properties().fireResistant()));

    public static final RegistryObject<SwordItem> ENDERITE_SWORD = ITEMS.register("enderite_sword",
            () -> new SwordItem(
                    ModTiers.ENDERITE_TIER,
                    new Item.Properties()
                            .attributes(SwordItem.createAttributes(ModTiers.ENDERITE_TIER, 3, -2.4f))
                            .fireResistant()
            )
    );

    public static final RegistryObject<PickaxeItem> ENDERITE_PICKAXE = ITEMS.register("enderite_pickaxe",
            () -> new PickaxeItem(
                    ModTiers.ENDERITE_TIER,
                    new Item.Properties()
                            .attributes(PickaxeItem.createAttributes(ModTiers.ENDERITE_TIER, 1, -2.8f))
                            .fireResistant()
            )
    );

    public static final RegistryObject<AxeItem> ENDERITE_AXE = ITEMS.register("enderite_axe",
            () -> new AxeItem(
                    ModTiers.ENDERITE_TIER,
                    new Item.Properties()
                            .attributes(PickaxeItem.createAttributes(ModTiers.ENDERITE_TIER, 1, -2.8f))
                            .fireResistant()
            )
    );

    public static final RegistryObject<ShovelItem> ENDERITE_SHOVEL = ITEMS.register("enderite_shovel",
            () -> new ShovelItem(
                    ModTiers.ENDERITE_TIER,
                    new Item.Properties()
                            .attributes(PickaxeItem.createAttributes(ModTiers.ENDERITE_TIER, 1, -2.8f))
                            .fireResistant()
            )
    );

    public static final RegistryObject<HoeItem> ENDERITE_HOE = ITEMS.register("enderite_hoe",
            () -> new HoeItem(
                    ModTiers.ENDERITE_TIER,
                    new Item.Properties()
                            .attributes(PickaxeItem.createAttributes(ModTiers.ENDERITE_TIER, 1, -2.8f))
                            .fireResistant()
            )
    );

    public static final RegistryObject<Item> ENDERITE_HELMET = ITEMS.register("enderite_helmet",
            () -> new ArmorItem(ItemArmorMaterial.ENDERITE_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(46)).fireResistant()));
    public static final RegistryObject<Item> ENDERITE_CHESTPLATE = ITEMS.register("enderite_chestplate",
            () -> new ArmorItem(ItemArmorMaterial.ENDERITE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(46)).fireResistant()));
    public static final RegistryObject<Item> ENDERITE_LEGGINGS = ITEMS.register("enderite_leggings",
            () -> new ArmorItem(ItemArmorMaterial.ENDERITE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(46)).fireResistant()));
    public static final RegistryObject<Item> ENDERITE_BOOTS = ITEMS.register("enderite_boots",
            () -> new ArmorItem(ItemArmorMaterial.ENDERITE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(46)).fireResistant()));

    public static final RegistryObject<Item> ENDERITE_UPGRADE_SMITHING_TEMPLATE =
            ITEMS.register("enderite_upgrade_smithing_template",
                    () -> createEnderiteUpgradeTemplate());

    private static SmithingTemplateItem createEnderiteUpgradeTemplate() {
        Component appliesTo = Component.translatable("item.crownofthevoid.smithing_template.enderite_upgrade.applies_to").withStyle(ChatFormatting.BLUE);
        Component ingredients = Component.translatable("item.crownofthevoid.smithing_template.enderite_upgrade.ingredients").withStyle(ChatFormatting.BLUE);
        Component upgradeTitle = Component.translatable("upgrade.crownofthevoid.enderite_upgrade").withStyle(ChatFormatting.GRAY);
        Component baseDesc = Component.translatable("item.crownofthevoid.smithing_template.enderite_upgrade.base_slot_description");
        Component additionsDesc = Component.translatable("item.crownofthevoid.smithing_template.enderite_upgrade.additions_slot_description");

        List<ResourceLocation> baseItems = List.of(
                BuiltInRegistries.ITEM.getKey(Items.DIAMOND_HELMET),
                BuiltInRegistries.ITEM.getKey(Items.DIAMOND_CHESTPLATE),
                BuiltInRegistries.ITEM.getKey(Items.DIAMOND_LEGGINGS),
                BuiltInRegistries.ITEM.getKey(Items.DIAMOND_BOOTS),
                BuiltInRegistries.ITEM.getKey(Items.DIAMOND_SWORD),
                BuiltInRegistries.ITEM.getKey(Items.DIAMOND_AXE),
                BuiltInRegistries.ITEM.getKey(Items.DIAMOND_PICKAXE),
                BuiltInRegistries.ITEM.getKey(Items.DIAMOND_SHOVEL),
                BuiltInRegistries.ITEM.getKey(Items.DIAMOND_HOE)
        );

        List<ResourceLocation> additions = List.of(
                BuiltInRegistries.ITEM.getKey(ModItems.ENDERITE_INGOT.get())
        );

        return new SmithingTemplateItem(
                appliesTo,
                ingredients,
                upgradeTitle,
                baseDesc,
                additionsDesc,
                baseItems,
                additions
        );
    }




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
