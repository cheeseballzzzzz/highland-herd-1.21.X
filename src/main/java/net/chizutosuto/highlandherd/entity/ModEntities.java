package net.chizutosuto.highlandherd.entity;

import net.chizutosuto.highlandherd.HighlandHerd;
import net.chizutosuto.highlandherd.entity.custom.HighlandCowEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class ModEntities {

    // Define the registry key without generics for your entity type
    public static final RegistryKey<EntityType<?>> HIGHLAND_COW_KEY =
            RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of("highlandherd", "highland_cow"));

    // Register your entity type
    public static final EntityType<HighlandCowEntity> HIGHLAND_COW = Registry.register(
            Registries.ENTITY_TYPE,
            HIGHLAND_COW_KEY.getValue(),
            EntityType.Builder.create(
                            (EntityType<HighlandCowEntity> type, World world) -> new HighlandCowEntity(type, world),
                            SpawnGroup.CREATURE
                    )
                    .dimensions(1.0f, 2.5f)
                    .build(HIGHLAND_COW_KEY) // Pass the key with raw type here
    );

    public static void registerModEntities() {
        HighlandHerd.LOGGER.info("Registering Mod Entities for " + HighlandHerd.MOD_ID);
    }
}
