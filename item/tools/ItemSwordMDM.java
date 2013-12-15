package clashsoft.mods.moredimensions.item.tools;

import clashsoft.mods.moredimensions.addons.MDMItems;

import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSwordMDM extends Item
{
	public float					weaponDamage;
	public final EnumToolMaterial	toolMaterial;
	public float					efficiencyOnProperMaterial	= 1F;
	
	public ItemSwordMDM(int itemID, float weaponDamage, EnumToolMaterial material)
	{
		this(itemID, weaponDamage, 1F, material);
	}
	
	public ItemSwordMDM(int itemID, float weaponDamage, float efficiencyMultiplier, EnumToolMaterial material)
	{
		super(itemID);
		this.maxStackSize = 1;
		this.toolMaterial = material;
		this.efficiencyOnProperMaterial = material.getEfficiencyOnProperMaterial() * efficiencyMultiplier;
		
		this.setMaxDamage(material.getMaxUses());
		this.setCreativeTab(MDMItems.tabTools);
		this.weaponDamage = weaponDamage + material.getDamageVsEntity();
	}
	
	/**
	 * Returns the strength of the stack against a given block. 1.0F base, (Quality+1)*2 if correct blocktype, 1.5F if sword
	 */
	@Override
	public float getStrVsBlock(ItemStack stack, Block block)
	{
		if (block.blockID == Block.web.blockID)
		{
			return 15.0F;
		}
		else
		{
			Material material = block.blockMaterial;
			return material != Material.plants && material != Material.vine && material != Material.coral && material != Material.leaves && material != Material.pumpkin ? this.efficiencyOnProperMaterial : (this.efficiencyOnProperMaterial * 1.5F);
		}
	}
	
	/**
	 * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise the damage on the stack.
	 */
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase attacker, EntityLivingBase living)
	{
		stack.damageItem(1, living);
		return true;
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World world, int blockID, int x, int y, int z, EntityLivingBase living)
	{
		if (Block.blocksList[blockID].getBlockHardness(world, x, y, z) != 0.0D)
		{
			stack.damageItem(2, living);
		}
		
		return true;
	}
	
	/**
	 * Returns True is the item is renderer in full 3D when hold.
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public boolean isFull3D()
	{
		return true;
	}
	
	/**
	 * How long it takes to use or consume an item
	 */
	@Override
	public int getMaxItemUseDuration(ItemStack stack)
	{
		return 72000;
	}
	
	/**
	 * Returns if the item (tool) can harvest results from the block type.
	 */
	@Override
	public boolean canHarvestBlock(Block block)
	{
		return block.blockID == Block.web.blockID;
	}
	
	/**
	 * Return the enchantability factor of the item, most of the time is based on material.
	 */
	@Override
	public int getItemEnchantability()
	{
		return this.toolMaterial.getEnchantability();
	}
	
	/**
	 * Return the name for this tool's material.
	 */
	public String getToolMaterialName()
	{
		return this.toolMaterial.toString();
	}
	
	/**
	 * Return whether this item is repairable in an anvil.
	 */
	@Override
	public boolean getIsRepairable(ItemStack item, ItemStack stack)
	{
		return this.toolMaterial.getToolCraftingMaterial() == stack.itemID ? true : super.getIsRepairable(item, stack);
	}
	
	/**
	 * Gets a map of item attribute modifiers, used by ItemSword to increase hit damage.
	 */
	@Override
	public Multimap getItemAttributeModifiers()
	{
		Multimap multimap = super.getItemAttributeModifiers();
		multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", this.weaponDamage, 0));
		return multimap;
	}
	
	// --------------------
	
	public static class ItemDagger extends ItemSwordMDM
	{
		public ItemDagger(int itemID, EnumToolMaterial material)
		{
			super(itemID, 4.5F, 0.75F, material);
		}
	}
	
	public static class ItemScimitar extends ItemSwordMDM
	{
		public ItemScimitar(int itemID, EnumToolMaterial material)
		{
			super(itemID, 5F, 0.5F, material);
		}
	}
	
	public static class ItemRapier extends ItemSwordMDM
	{
		public ItemRapier(int itemID, EnumToolMaterial material)
		{
			super(itemID, 4.75F, 0.75F, material);
		}
	}
	
	public static class ItemLongsword extends ItemSwordMDM
	{
		public ItemLongsword(int itemID, EnumToolMaterial material)
		{
			super(itemID, 4.5F, 1.2F, material);
		}
	}
	
	public static class ItemHalberd extends ItemSwordMDM
	{
		public ItemHalberd(int itemID, EnumToolMaterial material)
		{
			super(itemID, 4F, 1.3F, material);
		}
	}
	
	public static class ItemSpear extends ItemSwordMDM
	{
		public ItemSpear(int itemID, EnumToolMaterial material)
		{
			super(itemID, 3.75F, 1.3F, material);
		}
	}
	
	public static class ItemClaws extends ItemSwordMDM
	{
		public ItemClaws(int itemID, EnumToolMaterial material)
		{
			super(itemID, 5F, 1.25F, material);
		}
	}
	
	// Throwable
	
	public static class ItemThrowableKnife extends ItemSwordMDM
	{
		public ItemThrowableKnife(int itemID, EnumToolMaterial material)
		{
			super(itemID, 4F, 0.7F, material);
		}
	}
	
	public static class ItemNinjaStar extends ItemSwordMDM
	{
		public ItemNinjaStar(int itemID, EnumToolMaterial material)
		{
			super(itemID, 3.5F, 0.666F, material);
		}
	}
	
	public static class ItemJavelin extends ItemSwordMDM
	{
		public ItemJavelin(int itemID, EnumToolMaterial material)
		{
			super(itemID, 3.5F, 1.3F, material);
		}
	}
	
	public static class ItemDart extends ItemSwordMDM
	{
		public ItemDart(int itemID, EnumToolMaterial material)
		{
			super(itemID, 3F, 0.666F, material);
		}
	}
}
