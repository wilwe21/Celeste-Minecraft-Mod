package com.github.wilwe21.gsad;

import com.github.wilwe21.gsad.CreativeTab.ItemGroup;
import com.github.wilwe21.gsad.block.ModBlock;
import com.github.wilwe21.gsad.block.BlockTypes;
import com.github.wilwe21.gsad.entity.ModEntity;
import com.github.wilwe21.gsad.item.ItemTags;
import com.github.wilwe21.gsad.render.CustomRenderLayers;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.wilwe21.gsad.item.ModItems;

public class Gsad implements ModInitializer {
	public static final String MOD_ID = "gsad";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public void onInitialize() {
		ModItems.init();
		BlockTypes.init();
		ModBlock.init();
		ItemGroup.init();
		Keybinds.init();
		GsadAttributes.init();
		CustomRenderLayers.init();
		ItemTags.init();
		ModEntity.init();
	}
}
