package clashsoft.mods.moredimensions.item.alchemy;

import java.util.List;

import clashsoft.brewingapi.brewing.PotionBase;
import clashsoft.brewingapi.brewing.PotionType;
import clashsoft.brewingapi.item.ItemPotion2;
import clashsoft.mods.moredimensions.addons.MDMItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Icon;
import net.minecraft.util.StatCollector;

public class ItemElixir extends ItemPotion2
{
	public static final int	BOTTLE_TYPES	= 3;
	
	public Icon[]			bottles;
	public Icon[]			splashBottles;
	public Icon[]			liquids;
	
	public ItemElixir(int itemID)
	{
		super(itemID);
	}
	
	@Override
	public CreativeTabs[] getCreativeTabs()
	{
		return new CreativeTabs[] { MDMItems.tabAlchemy, CreativeTabs.tabAllSearch };
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
		this.bottles = new Icon[BOTTLE_TYPES];
		this.splashBottles = new Icon[BOTTLE_TYPES];
		this.liquids = new Icon[BOTTLE_TYPES];
		for (int i = 0; i < BOTTLE_TYPES; i++)
		{
			this.bottles[i] = iconRegister.registerIcon("moredimensions:elixir_bottle_" + i);
			this.splashBottles[i] = iconRegister.registerIcon("moredimensions:elixir_splash_" + i);
			this.liquids[i] = iconRegister.registerIcon("moredimensions:elixir_liquid_" + i);
		}
	}
	
	/**
	 * returns wether or not a potion is a throwable splash potion based on damage value
	 */
	@Override
	public boolean isSplash(int metadata)
	{
		return (metadata & 2) != 0;
	}
	
	public int getBottleType(int metadata)
	{
		return metadata >> 2;
	}
	
	@Override
	public boolean isWater(int metadata)
	{
		return (metadata & 1) == 0;
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
	
	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(ItemStack stack, int pass)
	{
		int type = this.getBottleType(stack.getItemDamage());
		return pass == 0 ? this.liquids[type] : (this.isSplash(stack.getItemDamage()) ? this.splashBottles[type] : this.bottles[type]);
	}
	
	@Override
	public Icon getSplashIcon(ItemStack stack)
	{
		return this.splashBottles[this.getBottleType(stack.getItemDamage())];
	}
	
	@Override
	public String getItemDisplayName(ItemStack stack)
	{
		List effects = this.getEffects(stack);
		if (this.isWater(stack.getItemDamage()))
		{
			return StatCollector.translateToLocal("elixir.empty").trim();
		}
		else
		{
			String var2 = "";
			
			if (this.isSplash(stack.getItemDamage()))
			{
				var2 = StatCollector.translateToLocal("elixir.prefix.grenade").trim() + " ";
			}
			
			List<PotionType> var3 = this.getEffects(stack);
			String var4 = "";
			
			if (var3 != null && !var3.isEmpty())
			{
				if (var3.size() == PotionType.combinableEffects.size())
				{
					return "\u00a7b" + var2 + StatCollector.translateToLocal("elixir.alleffects.postfix");
				}
				else if (var3.size() > 3)
				{
					return var2 + StatCollector.translateToLocal("elixir.elixirof") + " " + var3.size() + " " + StatCollector.translateToLocal("potion.effects");
				}
				else if (var3.get(0).isBase())
				{
					return StatCollector.translateToLocal("potion.prefix." + ((PotionBase) var3.get(0)).basename).trim() + " " + var2 + super.getItemDisplayName(stack);
				}
				for (int i = 0; i < var3.size(); i++)
				{
					if (i == 0)
					{
						var4 = StatCollector.translateToLocal("elixir.elixirof") + " " + StatCollector.translateToLocal(var3.get(i).getEffect() != null && var3.get(i).getEffect().getPotionID() > 0 ? (var3.get(i).getEffect().getEffectName()) : "");
						var2 += StatCollector.translateToLocal(var4).trim();
					}
					else if (i + 1 == var3.size())
					{
						var4 = var3.get(i).getEffect().getEffectName();
						var2 += " " + StatCollector.translateToLocal("potion.and") + " " + StatCollector.translateToLocal(var4).trim();
					}
					else
					{
						var4 = var3.get(i).getEffect().getEffectName();
						var2 += ", " + StatCollector.translateToLocal(var4).trim();
					}
				}
				return var2;
			}
			else
			{
				return super.getItemDisplayName(stack);
			}
		}
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
	/**
	 * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
	 */
	public void getSubItems(int itemID, CreativeTabs creativeTab, List list)
	{
		if (creativeTab == MDMItems.tabAlchemy || creativeTab == CreativeTabs.tabAllSearch)
		{
			for (int i = 0; i < BOTTLE_TYPES; i++)
			{
				list.add(new ItemStack(this, 1, i * 4));
			}
			
			for (PotionType potionType : PotionType.potionTypeList)
			{
				for (int i = 1; i <= BOTTLE_TYPES * 4; i += 2)
				{
					for (PotionType potionType2 : potionType.getSubTypes())
					{
						PotionType potionType3 = potionType2.copy();
						list.add(potionType3.addPotionTypeToItemStack(new ItemStack(this, 1, i)));
						
						if (this.isSplash(i))
						{
							list.add(potionType3.onGunpowderUsed().addPotionTypeToItemStack(new ItemStack(this, 1, i)));
						}
					}
				}
			}
		}
	}
}