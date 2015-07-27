package et.items;

import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import et.core.Main;

public class AdvEnderTeleport extends Item 
{
	public AdvEnderTeleport()
	{
		super();
		setCreativeTab(CreativeTabs.tabTools);
		setMaxStackSize(1);
		setUnlocalizedName("advEnderTeleport");
		setTextureName(Main.modid + ":" + getUnlocalizedName());
	}
	
	public ItemStack onItemRightClick(ItemStack stack, World w, EntityPlayer p)
	{
		if(p.isSneaking())
		{
			stack.stackTagCompound = new NBTTagCompound();
		    stack.stackTagCompound.setDouble("PosX", p.posX);
		    stack.stackTagCompound.setDouble("PosY", p.posY);
		    stack.stackTagCompound.setDouble("PosZ", p.posZ);
		    stack.stackTagCompound.setInteger("Dim", p.dimension);
		    stack.addEnchantment(Enchantment.knockback, 1);
		}
		else
		{
			if (stack.stackTagCompound != null)
			{
				if (p.dimension != stack.stackTagCompound.getInteger("Dim"))
				{
					p.travelToDimension(stack.stackTagCompound.getInteger("Dim"));
				}
				p.setPositionAndUpdate(stack.stackTagCompound.getDouble("PosX"), stack.stackTagCompound.getDouble("PosY"), stack.stackTagCompound.getDouble("PosZ"));
				w.playSoundAtEntity(p, Main.modid + ":" + "useTeleport", 1, 1);
			}
		}
	    
		return stack;
	}
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer p, List l, boolean bool)
	{
		l.add(I18n.format("text.advEnderTeleport.lore.1"));
		l.add(I18n.format("text.advEnderTeleport.lore.2"));
		if (stack.stackTagCompound != null)
		{
			if (stack.stackTagCompound.hasKey("PosX") && stack.stackTagCompound.hasKey("PosY") && stack.stackTagCompound.hasKey("PosZ"))
			{
				l.add("X: " + stack.stackTagCompound.getInteger("PosX") + "  Y: " + stack.stackTagCompound.getInteger("PosY") + "  Z: " + stack.stackTagCompound.getInteger("PosZ") + "  Dimension: " + stack.stackTagCompound.getInteger("Dim"));
			}
		}
	}

}
