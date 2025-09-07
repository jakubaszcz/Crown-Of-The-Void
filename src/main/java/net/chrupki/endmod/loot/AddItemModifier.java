package net.chrupki.endmod.loot;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;

import java.util.List;

public class AddItemModifier extends LootModifier {

    public static final MapCodec<AddItemModifier> CODEC = RecordCodecBuilder.mapCodec(inst ->
            codecStart(inst)
                    .and(Codec.list(Entry.CODEC).fieldOf("items").forGetter(m -> m.items))
                    .apply(inst, AddItemModifier::new)
    );

    private final List<Entry> items;

    // **Seul constructeur requis par le codec**
    public AddItemModifier(LootItemCondition[] conditions, List<Entry> items) {
        super(conditions);
        this.items = items;
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }

    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext ctx) {
        int total = 0;
        for (Entry e : items) total += Math.max(0, e.weight);
        if (total <= 0) return generatedLoot;

        int r = ctx.getRandom().nextInt(total);
        for (Entry e : items) {
            r -= Math.max(0, e.weight);
            if (r < 0) {
                Item item = ctx.getLevel().registryAccess()
                        .registryOrThrow(Registries.ITEM)
                        .get(e.itemId);
                if (item != null) {
                    generatedLoot.add(new ItemStack(item, Math.max(1, e.count)));
                }
                break;
            }
        }
        return generatedLoot;
    }

    public static class Entry {
        public static final Codec<Entry> CODEC = RecordCodecBuilder.create(inst ->
                inst.group(
                        ResourceLocation.CODEC.fieldOf("item").forGetter(e -> e.itemId),
                        Codec.INT.optionalFieldOf("count", 1).forGetter(e -> e.count),
                        Codec.INT.optionalFieldOf("weight", 1).forGetter(e -> e.weight)
                ).apply(inst, Entry::new)
        );

        public final ResourceLocation itemId;
        public final int count;
        public final int weight;

        public Entry(ResourceLocation itemId, int count, int weight) {
            this.itemId = itemId;
            this.count = count;
            this.weight = weight;
        }
    }
}
