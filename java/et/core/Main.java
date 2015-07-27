package et.core;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import et.registry.RegisterItems;
import et.registry.RegisterRecipes;

@Mod(modid = Main.modid)
public class Main {
	public static final String modid = "enderteleports";
	
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent ev)
	{
		RegisterItems.setup();
		RegisterRecipes.setup();
	}

}
