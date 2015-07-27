package et.items;

import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import et.core.Main;

public class BasicEnderTeleport extends Item
{
	public BasicEnderTeleport()
	{
		super();
		setCreativeTab(CreativeTabs.tabTools);
		setMaxStackSize(1);
		setUnlocalizedName("basicEnderTeleport");
		setTextureName(Main.modid + ":" + getUnlocalizedName());
	}
	
	public ItemStack onItemRightClick(ItemStack item, World w, EntityPlayer p)
	{
		ChunkCoordinates c = new ChunkCoordinates();
		c = w.getSpawnPoint();
		p.setPositionAndUpdate(c.posX, c.posY, c.posZ);
		w.playSoundAtEntity(p, Main.modid + ":" + "useTeleport", 1, 1);
		return item;
	}
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer p, List l, boolean bool)
	{
		l.add(I18n.format("text.basicEnderTeleport.lore.1"));
		l.add(I18n.format("text.basicEnderTeleport.lore.2"));
		l.add(I18n.format("text.basicEnderTeleport.lore.3"));
		l.add(I18n.format("text.basicEnderTeleport.lore.4"));
	}
}
