package clashsoft.mods.moredimensions.item;

import com.jadarstudios.developercapes.DevCapes;

import clashsoft.clashsoftapi.CustomItem;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemCape extends CustomItem
{
	public static final String[] displayNames = { "Blue Cape", "Green Cape", "Red Cape", "Yellow Cape", "Invisibility Cape", "Pro Cape", "Minecon Cape", "Minecon Cape" };
	public static final String[] iconNames = { "cape_blue", "cape_green", "cape_red", "cape_yellow", "cape_invisibility", "cape_pro", "cape_minecon2011", "cape_minecon2012"};
	public static final String[] descriptions = { "", "", "", "", "Makes you invisible", "", "Minecon 2011 Cape", "Minecon 2012 Cape"};
	
	public ItemCape(int itemID)
	{
		super(itemID, displayNames, iconNames, descriptions);
		this.setCreativeTab(CreativeTabs.tabMisc);
	}
	
	@Override
	public boolean isValidArmor(ItemStack stack, int armorType, Entity entity)
	{
		return armorType == 1;
	}
	
	@Override
	public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack itemStack)
	{
		int metadata = itemStack.getItemDamage();
		if (metadata == 4)
			player.addPotionEffect(new PotionEffect(Potion.invisibility.id, 2, 0));
		else
			DevCapes.getInstance().addUser(player.username, iconNames[metadata]);
	}
}
