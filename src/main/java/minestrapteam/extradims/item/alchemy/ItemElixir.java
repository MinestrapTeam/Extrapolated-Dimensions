package minestrapteam.extradims.item.alchemy;

import java.util.List;

import clashsoft.brewingapi.item.ItemPotion2;
import clashsoft.brewingapi.potion.base.PotionBase;
import clashsoft.brewingapi.potion.type.IPotionType;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import minestrapteam.extradims.lib.Alchemy;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;

public class ItemElixir extends ItemPotion2
{
	public static final int	BOTTLE_TYPES	= 3;
	
	public IIcon[]			bottles;
	public IIcon[]			splashBottles;
	public IIcon[]			liquids;
	
	public ItemElixir()
	{
		super();
	}
	
	@Override
	public CreativeTabs[] getCreativeTabs()
	{
		return new CreativeTabs[] { Alchemy.tabAlchemy, CreativeTabs.tabAllSearch };
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		this.bottles = new IIcon[BOTTLE_TYPES];
		this.splashBottles = new IIcon[BOTTLE_TYPES];
		this.liquids = new IIcon[BOTTLE_TYPES];
		for (int i = 0; i < BOTTLE_TYPES; i++)
		{
			this.bottles[i] = iconRegister.registerIcon("ed_alchemy:elixir/elixir_bottle_" + i);
			this.splashBottles[i] = iconRegister.registerIcon("ed_alchemy:elixir/elixir_splash_" + i);
			this.liquids[i] = iconRegister.registerIcon("ed_alchemy:elixir/elixir_liquid_" + i);
		}
	}
	
	@Override
	public boolean isSplashDamage(int metadata)
	{
		return (metadata & 2) != 0;
	}
	
	public int getBottleType(int metadata)
	{
		return metadata >> 2;
	}
	
	@Override
	public boolean isWater(ItemStack stack)
	{
		return (stack.getItemDamage() & 1) == 0;
	}
	
	/**
	 * Bit 0 = water, Bit 1 = splash, Bit 2... = bottleType
	 * 
	 * @param bottleType
	 * @param water
	 * @param splash
	 * @return
	 */
	public int getMetadata(int bottleType, boolean water, boolean splash)
	{
		return bottleType << 2 | (water ? 1 : 0) | (splash ? 2 : 0);
	}
	
	@Override
	public IIcon getIcon(ItemStack stack, int pass)
	{
		int type = this.getBottleType(stack.getItemDamage());
		return pass == 0 ? this.liquids[type] : (this.isSplashDamage(stack.getItemDamage()) ? this.splashBottles[type] : this.bottles[type]);
	}
	
	@Override
	public IIcon getSplashIcon(ItemStack stack)
	{
		return this.splashBottles[this.getBottleType(stack.getItemDamage())];
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack stack)
	{
		List<IPotionType> effects = this.getPotionTypes(stack);
		if (this.isWater(stack))
		{
			return StatCollector.translateToLocal("elixir.empty").trim();
		}
		else
		{
			String string1 = "";
			
			if (this.isSplashDamage(stack.getItemDamage()))
			{
				string1 = StatCollector.translateToLocal("elixir.prefix.grenade").trim() + " ";
			}
			
			String string2 = "";
			
			if (effects != null && !effects.isEmpty())
			{
				if (effects.size() == IPotionType.combinableTypes.size())
				{
					return "\u00a7b" + string1 + StatCollector.translateToLocal("elixir.alleffects.postfix");
				}
				else if (effects.size() > 3)
				{
					return string1 + StatCollector.translateToLocal("elixir.elixirof") + " " + effects.size() + " " + StatCollector.translateToLocal("potion.effects");
				}
				else if (effects.get(0).isBase())
				{
					return StatCollector.translateToLocal("potion.prefix." + ((PotionBase) effects.get(0)).getName()).trim() + " " + string1 + super.getItemStackDisplayName(stack);
				}
				for (int i = 0; i < effects.size(); i++)
				{
					if (i == 0)
					{
						string2 = StatCollector.translateToLocal("elixir.elixirof") + " " + StatCollector.translateToLocal(effects.get(i).getEffect() != null && effects.get(i).getEffect().getPotionID() > 0 ? (effects.get(i).getEffect().getEffectName()) : "");
						string1 += StatCollector.translateToLocal(string2).trim();
					}
					else if (i + 1 == effects.size())
					{
						string2 = effects.get(i).getEffect().getEffectName();
						string1 += " " + StatCollector.translateToLocal("potion.and") + " " + StatCollector.translateToLocal(string2).trim();
					}
					else
					{
						string2 = effects.get(i).getEffect().getEffectName();
						string1 += ", " + StatCollector.translateToLocal(string2).trim();
					}
				}
				return string1;
			}
		}
		return super.getItemStackDisplayName(stack);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean flag)
	{
		String s = EnumChatFormatting.ITALIC + StatCollector.translateToLocal("elixir.bottletype") + ": " + StatCollector.translateToLocal("elixir.bottletype." + this.getBottleType(stack.getItemDamage()));
		list.add(s);
		super.addInformation(stack, player, list, flag);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs creativeTab, List list)
	{
		if (creativeTab == Alchemy.tabAlchemy || creativeTab == CreativeTabs.tabAllSearch)
		{
			for (int i = 0; i < BOTTLE_TYPES; i++)
			{
				list.add(new ItemStack(this, 1, i * 4));
			}
			
			for (IPotionType potionType : IPotionType.potionTypeList)
			{
				for (int i = 1; i <= BOTTLE_TYPES * 4; i += 2)
				{
					for (IPotionType potionType2 : potionType.getSubTypes())
					{
						IPotionType potionType3 = potionType2.copy();
						list.add(potionType3.apply(new ItemStack(this, 1, i)));
						
						if (this.isSplashDamage(i))
						{
							list.add(potionType3.onGunpowderUsed().apply(new ItemStack(this, 1, i)));
						}
					}
				}
			}
		}
	}
}