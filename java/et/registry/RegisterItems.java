package et.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import et.items.ModItems;

public class RegisterItems {
	
	public static void setup()
	{
		GameRegistry.registerItem(ModItems.basicEnderTeleport, "basicEnderTeleport");
		GameRegistry.registerItem(ModItems.advEnderTeleport, "advEnderTeleport");
		GameRegistry.registerItem(ModItems.enderResource, "enderResource");
	}

}
