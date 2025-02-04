package com.github.wilwe21.gsad;

import com.github.wilwe21.gsad.datagen.*;
import com.github.wilwe21.gsad.datagen.lang.ModEngLangProvider;
import com.github.wilwe21.gsad.datagen.lang.ModPlLangProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class GsadDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModEngLangProvider::new);
		pack.addProvider(ModPlLangProvider::new);
	}
}
