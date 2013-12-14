package clashsoft.mods.moredimensions.item.tools;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

public class ItemBowMDM extends ItemTool
{
	public static Block[]	blocksEffectiveAgainst	= {};
	
	public static ItemStack	defaultArrow			= new ItemStack(Item.arrow);
	
	public ItemStack		arrow;
	public Icon[]			iconArray;
	
	public ItemBowMDM(int par1, EnumToolMaterial toolMaterial)
	{
		this(par1, toolMaterial, defaultArrow);
	}
	
	public ItemBowMDM(int par1, EnumToolMaterial toolMaterial, ItemStack arrow)
	{
		super(par1, 0F, toolMaterial, blocksEffectiveAgainst);
		
		this.arrow = arrow;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(this.getIconString());
		this.iconArray = new Icon[3];
		
		for (int i = 0; i < this.iconArray.length; ++i)
		{
			this.iconArray[i] = par1IconRegister.registerIcon(this.getIconString() + "_" + i);
		}
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		ArrowNockEvent event = new ArrowNockEvent(par3EntityPlayer, par1ItemStack);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.isCanceled())
		{
			return event.result;
		}
		
		if (par3EntityPlayer.capabilities.isCreativeMode || par3EntityPlayer.inventory.hasItemStack(this.arrow))
		{
			par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
		}
		
		return par1ItemStack;
	}
	
	@Override
	public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4)
	{
		int j = this.getMaxItemUseDuration(par1ItemStack) - par4;
		
		ArrowLooseEvent event = new ArrowLooseEvent(par3EntityPlayer, par1ItemStack, j);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.isCanceled())
		{
			return;
		}
		j = event.charge;
		
		int slot = -1;
		for (int i = 0; i < par3EntityPlayer.inventory.mainInventory.length; i++)
		{
			ItemStack stack = par3EntityPlayer.inventory.mainInventory[i];
			if (stack != null && stack.isItemEqual(this.arrow))
				slot = i;
		}
		
		boolean flag = par3EntityPlayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, par1ItemStack) > 0;
		
		if (flag || slot != -1)
		{
			float f = j / 20.0F;
			f = (f * f + f * 2.0F) / 3.0F;
			
			if (f < 0.1D)
			{
				return;
			}
			
			if (f > 1.0F)
			{
				f = 1.0F;
			}
			
			EntityArrow entityarrow = new EntityArrow(par2World, par3EntityPlayer, f * 2.0F);
			
			if (f == 1.0F)
			{
				entityarrow.setIsCritical(true);
			}
			
			int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, par1ItemStack);
			
			if (k > 0)
			{
				entityarrow.setDamage(entityarrow.getDamage() + k * 0.5D + 0.5D);
			}
			
			int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, par1ItemStack);
			
			if (l > 0)
			{
				entityarrow.setKnockbackStrength(l);
			}
			
			if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, par1ItemStack) > 0)
			{
				entityarrow.setFire(100);
			}
			
			par1ItemStack.damageItem(1, par3EntityPlayer);
			par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
			
			if (flag)
			{
				entityarrow.canBePickedUp = 2;
			}
			else
			{
				par3EntityPlayer.inventory.decrStackSize(slot, 1);
			}
			
			if (!par2World.isRemote)
			{
				par2World.spawnEntityInWorld(entityarrow);
			}
		}
	}
	
	@Override
	public Icon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
	{
		if (usingItem != null)
		{
			int k = usingItem.getMaxItemUseDuration() - useRemaining;
			if (k >= 18)
				return this.iconArray[2];
			else if (k > 13)
				return this.iconArray[1];
			else if (k > 0)
				return this.iconArray[0];
		}
		return this.itemIcon;
	}
	
	public static class ItemCrossBow extends ItemBowMDM
	{
		public ItemCrossBow(int itemID, EnumToolMaterial toolMaterial)
		{
			super(itemID, toolMaterial, defaultArrow);
		}
	}
	
	public static class ItemShortBow extends ItemBowMDM
	{
		public ItemShortBow(int itemID, EnumToolMaterial toolMaterial)
		{
			super(itemID, toolMaterial, defaultArrow);
		}
	}
}
