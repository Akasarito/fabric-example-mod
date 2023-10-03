package net.kaya.tutorialmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.kaya.tutorialmod.block.ExampleBlock;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final Block EXAMPLE_BLOCK  = new ExampleBlock(FabricBlockSettings.create().strength(4.0f).requiresTool());

	public static final Item EXAMPLE_BLOCK_ITEM = new BlockItem(EXAMPLE_BLOCK, new FabricItemSettings());


	@Override
	public void onInitialize() {
		Registry.register(Registries.BLOCK, new Identifier("tutorial", "example_block"), EXAMPLE_BLOCK);
		Registry.register(Registries.ITEM, new Identifier("tutorial", "example_block"), EXAMPLE_BLOCK_ITEM);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> entries.add(EXAMPLE_BLOCK_ITEM));
	}
}