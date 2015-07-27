package et.registry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;
import et.items.ModItems;

public class RegisterRecipes {
	
	public static void setup()
	{
		GameRegistry.addRecipe(new ItemStack(ModItems.advEnderTeleport), new Object[]{
			" o ",
			" | ",
			" OB",
			'o', Items.ender_pearl, '|', Items.stick, 'B', Blocks.stone_button, 'O', new ItemStack(ModItems.enderResource, 1, 0)
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.enderResource, 18, 1), new Object[]{
			new ItemStack(Blocks.obsidian),
			new ItemStack(Items.diamond)
		});
		
		GameRegistry.addRecipe(new ItemStack(ModItems.enderResource, 1, 0), new Object[]{
			"ooo",
			"o/o",
			"ooo",
			'o', new ItemStack(ModItems.enderResource, 1, 1), '/', Items.iron_ingot
		});
		
		OreDictionary.registerOre("nuggetObsidian", new ItemStack(ModItems.enderResource, 1, 1));
		
		GameRegistry.addRecipe(new ItemStack(ModItems.basicEnderTeleport), new Object[]{
			" o ",
			" | ",
			" OB",
			'o', Items.ender_pearl, '|', Items.stick, 'B', Blocks.wooden_button, 'O', Blocks.stone
		});
	}

}
