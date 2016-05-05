package minestrapteam.extradims.item.armor;

import minestrapteam.extracore.ExtraCore;
import minestrapteam.extracore.cape.Capes;
import minestrapteam.extradims.api.ICape;
import minestrapteam.extradims.lib.Aerius;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;

import java.util.List;

public class ItemCape extends Item implements ICape
{
	public static final String[] CAPE_NAMES = { "pro", "invisibility", "white", "black", "blue", "green", "red", "yellow",
		"minecon_2011", "minecon_2012", "minecon_2013", "minecon_2015" };

	static
	{
		for (String capeName : CAPE_NAMES)
		{
			ResourceLocation location = new ResourceLocation("ed_aerius", "textures/capes/" + capeName + ".png");
			Capes.addCape(capeName, location);
		}
	}

	protected final IIcon[] icons = new IIcon[CAPE_NAMES.length];

	public ItemCape()
	{
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}

	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		for (int i = 0; i < CAPE_NAMES.length; i++)
		{
			this.icons[i] = iconRegister.registerIcon(Aerius.TEXTURE_PREFIX + "armor/cape/cape_" + CAPE_NAMES[i]);
		}
	}

	@Override
	public IIcon getIconFromDamage(int damage)
	{
		return this.icons[damage];
	}

	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return "item.cape." + CAPE_NAMES[stack.getItemDamage()];
	}

	@SuppressWarnings("unchecked")
	@Override
	public void getSubItems(Item item, CreativeTabs creativeTab, List list)
	{
		for (int i = 0; i < CAPE_NAMES.length; i++)
		{
			list.add(new ItemStack(this, 1, i));
		}
	}

	@Override
	public boolean isValidArmor(ItemStack stack, int armorType, Entity entity)
	{
		return armorType == ArmorTypes.CAPE;
	}

	@Override
	public void updateCape(EntityPlayer player, ItemStack stack)
	{
		if (player.worldObj.isRemote)
		{
			return;
		}

		final int metadata = stack.getItemDamage();
		if (metadata == 1) // Invisibility Cape
		{
			player.addPotionEffect(new PotionEffect(Potion.invisibility.id, 2, 0));
		}
		else
		{
			ExtraCore.getNetHandler().sendCapePacket(player, CAPE_NAMES[metadata]);
		}
	}
}
