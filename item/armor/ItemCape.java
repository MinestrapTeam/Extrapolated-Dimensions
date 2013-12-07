package clashsoft.mods.moredimensions.item.armor;

import clashsoft.cslib.minecraft.CustomItem;
import clashsoft.mods.moredimensions.addons.MDMItems;

import com.jadarstudios.developercapes.DevCapes;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class ItemCape extends CustomItem
{
	public static Icon		slotIcon;
	
	public static String[]	displayNames	= { "Pro Cape", "Blue Cape", "Green Cape", "Red Cape", "Yellow Cape", "Invisibility Cape", "Minecon Cape", "Minecon Cape" };
	public static String[]	iconNames		= { "cape_pro", "cape_blue", "cape_green", "cape_red", "cape_yellow", "cape_invisibility", "cape_minecon2011", "cape_minecon2012" };
	public static String[]	descriptions	= { "", "", "", "", "", "Makes you invisible", "Minecon 2011 Cape", "Minecon 2012 Cape" };
	
	public ItemCape(int itemID)
	{
		super(itemID, displayNames, iconNames, descriptions);
		this.setCreativeTab(MDMItems.tabHeavenArmor);
	}
	
	@Override
	public void registerIcons(IconRegister par1IconRegister)
	{
		super.registerIcons(par1IconRegister);
		if (slotIcon == null)
			slotIcon = par1IconRegister.registerIcon("armorslot_cape");
	}
	
	@Override
	public boolean isValidArmor(ItemStack stack, int armorType, Entity entity)
	{
		return armorType == ArmorTypes.CAPE;
	}
	
	@Override
	public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack itemStack)
	{
		int metadata = itemStack.getItemDamage();
		if (metadata == 5)
			player.addPotionEffect(new PotionEffect(Potion.invisibility.id, 2, 0));
		else
			DevCapes.getInstance().addUser(player.username, iconNames[metadata]);
	}
}
