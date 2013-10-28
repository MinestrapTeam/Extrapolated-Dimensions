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
    public float weaponDamage;
    public final EnumToolMaterial toolMaterial;
    public float efficiencyOnProperMaterial = 1F;

    public ItemSwordMDM(int par1, float weaponDamage, EnumToolMaterial material)
    {
    	this(par1, weaponDamage, 1F, material);
    }
    
    public ItemSwordMDM(int par1, float weaponDamage, float efficiencyMultiplier, EnumToolMaterial par2EnumToolMaterial)
    {
        super(par1);
        this.maxStackSize = 1;
        this.toolMaterial = par2EnumToolMaterial;
        this.efficiencyOnProperMaterial = par2EnumToolMaterial.getEfficiencyOnProperMaterial() * efficiencyMultiplier;
        
        this.setMaxDamage(par2EnumToolMaterial.getMaxUses());
        this.setCreativeTab(MDMItems.tabTools);
        this.weaponDamage = weaponDamage + par2EnumToolMaterial.getDamageVsEntity();
    }

    /**
     * Returns the strength of the stack against a given block. 1.0F base, (Quality+1)*2 if correct blocktype, 1.5F if
     * sword
     */
    public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
    {
        if (par2Block.blockID == Block.web.blockID)
        {
            return 15.0F;
        }
        else
        {
            Material material = par2Block.blockMaterial;
            return material != Material.plants && material != Material.vine && material != Material.coral && material != Material.leaves && material != Material.pumpkin ? efficiencyOnProperMaterial : (efficiencyOnProperMaterial * 1.5F);
        }
    }

    /**
     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
     * the damage on the stack.
     */
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
        par1ItemStack.damageItem(1, par3EntityLivingBase);
        return true;
    }

    public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, int par3, int par4, int par5, int par6, EntityLivingBase par7EntityLivingBase)
    {
        if ((double)Block.blocksList[par3].getBlockHardness(par2World, par4, par5, par6) != 0.0D)
        {
            par1ItemStack.damageItem(2, par7EntityLivingBase);
        }

        return true;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    public boolean isFull3D()
    {
        return true;
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 72000;
    }

    /**
     * Returns if the item (tool) can harvest results from the block type.
     */
    public boolean canHarvestBlock(Block par1Block)
    {
        return par1Block.blockID == Block.web.blockID;
    }

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
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
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
        return this.toolMaterial.getToolCraftingMaterial() == par2ItemStack.itemID ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
    }

    /**
     * Gets a map of item attribute modifiers, used by ItemSword to increase hit damage.
     */
    public Multimap getItemAttributeModifiers()
    {
        Multimap multimap = super.getItemAttributeModifiers();
        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", (double)this.weaponDamage, 0));
        return multimap;
    }
    
    // --------------------
    
    public static class ItemDagger extends ItemSwordMDM
    {
    	public ItemDagger(int par1, EnumToolMaterial par2EnumToolMaterial)
    	{
    		super(par1, 4.5F, 0.75F, par2EnumToolMaterial);
    	}	
    }
    
    public static class ItemScimitar extends ItemSwordMDM
    {
    	public ItemScimitar(int par1, EnumToolMaterial par2EnumToolMaterial)
    	{
    		super(par1, 5F, 0.5F, par2EnumToolMaterial);
    	}
    }
    
    public static class ItemRapier extends ItemSwordMDM
    {
    	public ItemRapier(int par1, EnumToolMaterial par2EnumToolMaterial)
    	{
    		super(par1, 4.75F, 0.75F, par2EnumToolMaterial);
    	}
    }
    
    public static class ItemLongsword extends ItemSwordMDM
    {
    	public ItemLongsword(int par1, EnumToolMaterial par2EnumToolMaterial)
    	{
    		super(par1, 4.5F, 1.2F, par2EnumToolMaterial);
    	}
    }
    
    public static class ItemHalberd extends ItemSwordMDM
    {
    	public ItemHalberd(int par1, EnumToolMaterial par2EnumToolMaterial)
    	{
    		super(par1, 4F, 1.3F, par2EnumToolMaterial);
    	}
    }
    
    public static class ItemSpear extends ItemSwordMDM
    {
    	public ItemSpear(int par1, EnumToolMaterial par2EnumToolMaterial)
    	{
    		super(par1, 3.75F, 1.3F, par2EnumToolMaterial);
    	}
    }
    
    public static class ItemClaws extends ItemSwordMDM
    {
    	public ItemClaws(int par1, EnumToolMaterial par2EnumToolMaterial)
    	{
    		super(par1, 5F, 1.25F, par2EnumToolMaterial);
    	}
    }
}
