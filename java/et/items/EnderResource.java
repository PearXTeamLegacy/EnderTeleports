package et.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import et.core.Main;

public class EnderResource extends Item
{
	public EnderResource()
	{
		super();
		setCreativeTab(CreativeTabs.tabMaterials);
		setHasSubtypes(true);
		setUnlocalizedName("enderResource");
	}
	
	public IIcon[] icns = new IIcon[2];
	
	@Override
	public void registerIcons(IIconRegister r)
	{
		for(int i = 0; i < 2; i++)
		{
			this.icns[i] = r.registerIcon(Main.modid + ":resource_" + i);
		}
	}
	
	@Override
	public IIcon getIconFromDamage(int m)
	{
		if (m > 1)
			m = 0;
		return this.icns[m];
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs ct, List l)
	{
		for (int i = 0; i < 2; i++)
		{
			l.add(new ItemStack(item, 1, i));
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return this.getUnlocalizedName() + "_" + stack.getItemDamage();
	}
	
}
