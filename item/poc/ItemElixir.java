package clashsoft.mods.moredimensions.item.poc;

import java.util.List;

import clashsoft.brewingapi.brewing.PotionType;
import clashsoft.brewingapi.brewing.PotionBase;
import clashsoft.brewingapi.item.ItemPotion2;
import clashsoft.mods.moredimensions.addons.MDMItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;

public class ItemElixir extends ItemPotion2
{
	public static final int	BOTTLE_TYPES	= 3;
	
	public Icon[]			bottles;
	public Icon[]			splashBottles;
	public Icon[]			liquids;
	
	public ItemElixir(int par1)
	{
		super(par1);
	}
	
	@Override
	public CreativeTabs[] getCreativeTabs()
	{
		return new CreativeTabs[] { MDMItems.tabAlchemy, CreativeTabs.tabAllSearch };
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.bottles = new Icon[BOTTLE_TYPES];
		this.splashBottles = new Icon[BOTTLE_TYPES];
		this.liquids = new Icon[BOTTLE_TYPES];
		for (int i = 0; i < BOTTLE_TYPES; i++)
		{
			this.bottles[i] = par1IconRegister.registerIcon("elixir_bottle_" + i);
			this.splashBottles[i] = par1IconRegister.registerIcon("elixir_splash_" + i);
			this.liquids[i] = par1IconRegister.registerIcon("elixir_liquid_" + i);
		}
	}
	
	/**
	 * returns wether or not a potion is a throwable splash potion based on
	 * damage value
	 */
	@Override
	public boolean isSplash(int par1)
	{
		return (par1 & 2) != 0;
	}
	
	public int getBottleType(int par1)
	{
		return par1 >> 2;
	}
	
	@Override
	public boolean isWater(int par1)
	{
		return (par1 & 1) == 0;
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
	public Icon getIcon(ItemStack par1ItemStack, int par2)
	{
		int type = this.getBottleType(par1ItemStack.getItemDamage());
		return par2 == 0 ? this.liquids[type] : (this.isSplash(par1ItemStack.getItemDamage()) ? this.splashBottles[type] : this.bottles[type]);
	}
	
	@Override
	public Icon getSplashIcon(ItemStack stack)
	{
		return this.splashBottles[this.getBottleType(stack.getItemDamage())];
	}
	
	@Override
	public String getItemDisplayName(ItemStack par1ItemStack)
	{
		List effects = this.getEffects(par1ItemStack);
		if (this.isWater(par1ItemStack.getItemDamage()))
		{
			return StatCollector.translateToLocal("elixir.empty").trim();
		}
		else
		{
			String var2 = "";
			
			if (this.isSplash(par1ItemStack.getItemDamage()))
			{
				var2 = StatCollector.translateToLocal("elixir.prefix.grenade").trim() + " ";
			}
			
			List<PotionType> var3 = this.getEffects(par1ItemStack);
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
					return StatCollector.translateToLocal("potion.prefix." + ((PotionBase) var3.get(0)).basename).trim() + " " + var2 + super.getItemDisplayName(par1ItemStack);
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
				return super.getItemDisplayName(par1ItemStack);
			}
		}
	}
	
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		String s = EnumChatFormatting.ITALIC + StatCollector.translateToLocal("elixir.bottletype") + ": " + StatCollector.translateToLocal("elixir.bottletype." + this.getBottleType(par1ItemStack.getItemDamage()));
		par3List.add(s);
		super.addInformation(par1ItemStack, par2EntityPlayer, par3List, par4);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
	 */
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		if (par2CreativeTabs == MDMItems.tabAlchemy || par2CreativeTabs == CreativeTabs.tabAllSearch)
		{
			for (int i = 0; i < BOTTLE_TYPES; i++)
			{
				par3List.add(new ItemStack(this, 1, i * 4));
			}
			
			for (PotionType potionType : PotionType.potionTypeList)
			{
				for (int i = 1; i <= BOTTLE_TYPES * 4; i += 2)
				{
					for (PotionType brewing2 : potionType.getSubTypes())
					{
						PotionType var1 = new PotionType(brewing2.getEffect(), brewing2.getMaxAmplifier(), brewing2.getMaxDuration(), brewing2.getInverted(), brewing2.getIngredient(), brewing2.getBase());
						if (this.isSplash(i) && var1 != null && var1.getEffect() != null && var1.getEffect().getPotionID() > 0)
						{
							var1.setEffect(new PotionEffect(var1.getEffect().getPotionID(), MathHelper.ceiling_double_int(var1.getEffect().getDuration() * 0.75D), var1.getEffect().getAmplifier()));
						}
						par3List.add(var1.addBrewingToItemStack(new ItemStack(this, 1, i)));
					}
				}
			}
		}
	}
}