package com.github.wilwe21.gsad.datagen;

import com.github.wilwe21.gsad.CreativeTab.ItemGroup;
import com.github.wilwe21.gsad.block.ModBlock;
//import com.github.wilwe21.gsad.entity.ModEntity;
import com.github.wilwe21.gsad.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLangProvider extends FabricLanguageProvider {
    public ModLangProvider(FabricDataOutput dataGenerator, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        // Specifying en_us is optional, by default it is en_us.
        super(dataGenerator, "en_us", registryLookup);
    }
    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        // Celeste
        translationBuilder.add(ItemGroup.CELESTE_GROUP_KEY, "Celeste");
        translationBuilder.add(ModBlock.DREAM_BLOCK, "Dream Block");
        translationBuilder.add(ModBlock.TV_BLOCK, "Tv");
        translationBuilder.add(ModBlock.SPIKES, "Spikes");
        translationBuilder.add(ModBlock.SPINNER, "Crystals");
        translationBuilder.add(ModBlock.DUST_BUNNY, "Dust Bunny");
        translationBuilder.add(ModBlock.SCAFFOLDING, "Scaffolding");
        translationBuilder.add(ModBlock.SPRING, "Spring");
        translationBuilder.add(ModBlock.STRAWBERRY, "Strawberry");
        translationBuilder.add(ModItems.STARDUST, "Stardust");
        // Sonic
        translationBuilder.add(ItemGroup.SONIC_GROUP_KEY, "Sonic");
        translationBuilder.add(ModBlock.RING, "Ring");
//        translationBuilder.add(ModEntity.MOTOBUG(), "MotoBug");
        // Mario
        translationBuilder.add(ItemGroup.MARIO_GROUP_KEY, "Mario");
        translationBuilder.add(ModBlock.LUCKY_BLOCK, "Lucky Block");
        translationBuilder.add(ModBlock.EMPTY_BLOCK, "Empty Block");
        translationBuilder.add(ModBlock.GROUND_BLOCK, "Ground Block");
        translationBuilder.add(ModBlock.BRICK, "Brick");
    }
}
