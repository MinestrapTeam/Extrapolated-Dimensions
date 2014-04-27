package clashsoft.mods.moredimensions.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class MDMEntityProperties implements IExtendedEntityProperties
{
	public static final String		IDENTIFIER			= "MDMEntityProperties";
	public static final String		CHANNEL				= "MDMEntProp";
	
	public static float				maxManaValue		= 10F;
	
	public final EntityLivingBase	entity;
	
	protected float					mana				= maxManaValue;
	protected float					additionalHearts	= 0F;
	protected float					meleeLevel			= 0F;
	protected float					defenceLevel		= 0F;
	protected float					magicLevel			= 0F;						//
	protected float					rangedLevel			= 0F;
	protected float					diggingLevel		= 0F;
	protected float					miningLevel			= 0F;
	protected float					smithingLevel		= 0F;						//
	protected float					fishingLevel		= 0F;						//
	protected float					cookingLevel		= 0F;						//
	protected float					woodCuttingLevel	= 0F;
	protected float					herbloreLevel		= 0F;						//
	protected float					thievingLevel		= 0F;						//
	protected float					slayerLevel			= 0F;
	protected float					farmingLevel		= 0F;
	
	protected float					sharingLevel		= 0F;
	
	private MDMEntityProperties(final EntityLivingBase entity)
	{
		this.entity = entity;
	}
	
	public static MDMEntityProperties create(EntityLivingBase entity)
	{
		return new MDMEntityProperties(entity);
	}
	
	public void onPropertyChanged()
	{
		if (this.entity instanceof EntityPlayer)
		{
			this.sync((EntityPlayer) this.entity);
		}
	}
	
	/*
	 * Setters
	 */
	
	public MDMEntityProperties setMana(float mana)
	{
		this.mana = mana;
		this.onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties setAdditionalHearts(float additionalHearts)
	{
		this.additionalHearts = additionalHearts;
		this.onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties setMeleeLevel(float meleeLevel)
	{
		this.meleeLevel = meleeLevel;
		this.onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties setDefenceLevel(float defenceLevel)
	{
		this.defenceLevel = defenceLevel;
		
		this.onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties setMagicLevel(float magicLevel)
	{
		this.magicLevel = magicLevel;
		this.onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties setRangedLevel(float rangedLevel)
	{
		this.rangedLevel = rangedLevel;
		this.onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties setDiggingLevel(float level)
	{
		this.diggingLevel = level;
		this.onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties setMiningLevel(float miningLevel)
	{
		this.miningLevel = miningLevel;
		this.onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties setSmithingLevel(float smithingLevel)
	{
		this.smithingLevel = smithingLevel;
		this.onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties setFishingLevel(float fishingLevel)
	{
		this.fishingLevel = fishingLevel;
		this.onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties setCookingLevel(float cookingLevel)
	{
		this.cookingLevel = cookingLevel;
		this.onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties setWoodCuttingLevel(float woodCuttingLevel)
	{
		this.woodCuttingLevel = woodCuttingLevel;
		this.onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties setHerbloreLevel(float herbloreLevel)
	{
		this.herbloreLevel = herbloreLevel;
		this.onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties setThievingLevel(float thievingLevel)
	{
		this.thievingLevel = thievingLevel;
		this.onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties setSlayerLevel(float level)
	{
		this.slayerLevel = level;
		this.onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties setFarmingLevel(float farmingLevel)
	{
		this.farmingLevel = farmingLevel;
		this.onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties setSharingLevel(float sharingLevel)
	{
		this.sharingLevel = sharingLevel;
		this.onPropertyChanged();
		return this;
	}
	
	/*
	 * Getters
	 */
	
	public float getMana()
	{
		return this.mana;
	}
	
	public float getAdditionalHearts()
	{
		return this.additionalHearts;
	}
	
	public float getMeleeLevel()
	{
		return this.meleeLevel;
	}
	
	public float getDefenceLevel()
	{
		return this.defenceLevel;
	}
	
	public float getMagicLevel()
	{
		return this.magicLevel;
	}
	
	public float getRangedLevel()
	{
		return this.rangedLevel;
	}
	
	public float getDiggingLevel()
	{
		return this.diggingLevel;
	}
	
	public float getMiningLevel()
	{
		return this.miningLevel;
	}
	
	public float getSmithingLevel()
	{
		return this.smithingLevel;
	}
	
	public float getFishingLevel()
	{
		return this.fishingLevel;
	}
	
	public float getCookingLevel()
	{
		return this.cookingLevel;
	}
	
	public float getWoodCuttingLevel()
	{
		return this.woodCuttingLevel;
	}
	
	public float getHerbloreLevel()
	{
		return this.herbloreLevel;
	}
	
	public float getThievingLevel()
	{
		return this.thievingLevel;
	}
	
	public float getSlayerLevel()
	{
		return this.slayerLevel;
	}
	
	public float getFarmingLevel()
	{
		return this.farmingLevel;
	}
	
	public float getSharingLevel()
	{
		return this.sharingLevel;
	}
	
	/*
	 * Increasing methods
	 */
	
	public MDMEntityProperties addMana(float mana)
	{
		this.mana += mana;
		this.onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties addAdditionalHearts(float additionalHearts)
	{
		this.additionalHearts += additionalHearts;
		this.onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties addMeleeLevel(float level)
	{
		this.meleeLevel += level;
		this.onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties addDefenceLevel(float level)
	{
		this.defenceLevel += level;
		this.onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties addMagicLevel(float level)
	{
		this.magicLevel += level;
		this.onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties addRangedLevel(float level)
	{
		this.rangedLevel += level;
		this.onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties addDiggingLevel(float level)
	{
		this.diggingLevel += level;
		this.onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties addMiningLevel(float level)
	{
		this.miningLevel += level;
		this.onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties addSmithingLevel(float level)
	{
		this.smithingLevel += level;
		this.onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties addFishingLevel(float level)
	{
		this.fishingLevel += level;
		this.onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties addCookingLevel(float level)
	{
		this.cookingLevel += level;
		this.onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties addWoodCuttingLevel(float level)
	{
		this.woodCuttingLevel += level;
		this.onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties addHerbloreLevel(float level)
	{
		this.herbloreLevel += level;
		this.onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties addThievingLevel(float level)
	{
		this.thievingLevel += level;
		this.onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties addSlayerLevel(float level)
	{
		this.slayerLevel += level;
		this.onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties addFarmingLevel(float level)
	{
		this.farmingLevel += level;
		this.onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties addSharingLevel(float level)
	{
		this.sharingLevel += level;
		this.onPropertyChanged();
		return this;
	}
	
	/*
	 * GENERIC PROPERTIES
	 */
	
	@Override
	public void init(Entity entity, World world)
	{
		
	}
	
	public static MDMEntityProperties get(EntityLivingBase living)
	{
		MDMEntityProperties props = get_(living);
		return props == null ? set(living, create(living)) : props;
	}
	
	protected static MDMEntityProperties get_(EntityLivingBase living)
	{
		return (MDMEntityProperties) living.getExtendedProperties(IDENTIFIER);
	}
	
	public static MDMEntityProperties set(EntityLivingBase living, MDMEntityProperties properties)
	{
		MDMEntityProperties props = (MDMEntityProperties) living.getExtendedProperties(IDENTIFIER);
		if (props == null)
		{
			props = create(living);
			living.registerExtendedProperties(IDENTIFIER, props);
		}
		else
			copy(properties, props);
		return props;
	}
	
	public static void copy(MDMEntityProperties source, MDMEntityProperties dest)
	{
		dest.mana = source.mana;
		dest.additionalHearts = source.additionalHearts;
		dest.meleeLevel = source.meleeLevel;
		dest.defenceLevel = source.defenceLevel;
		dest.magicLevel = source.magicLevel;
		dest.rangedLevel = source.rangedLevel;
		dest.diggingLevel = source.diggingLevel;
		dest.miningLevel = source.miningLevel;
		dest.smithingLevel = source.smithingLevel;
		dest.fishingLevel = source.fishingLevel;
		dest.cookingLevel = source.cookingLevel;
		dest.woodCuttingLevel = source.woodCuttingLevel;
		dest.herbloreLevel = source.herbloreLevel;
		dest.thievingLevel = source.thievingLevel;
		dest.slayerLevel = source.slayerLevel;
		dest.farmingLevel = source.farmingLevel;
		dest.sharingLevel = source.sharingLevel;
	}
	
	public void sync(EntityPlayer player)
	{
		
	}
	
	/*
	 * NBT
	 */
	
	@Override
	public void saveNBTData(NBTTagCompound nbt)
	{
		NBTTagCompound compound = new NBTTagCompound();
		
		compound.setFloat("Mana", this.mana);
		compound.setFloat("MeleeLevel", this.meleeLevel);
		compound.setFloat("DefenceLevel", this.defenceLevel);
		compound.setFloat("MagicLevel", this.magicLevel);
		compound.setFloat("RangedLevel", this.rangedLevel);
		compound.setFloat("DiggingLevel", this.diggingLevel);
		compound.setFloat("MiningLevel", this.miningLevel);
		compound.setFloat("SmithingLevel", this.smithingLevel);
		compound.setFloat("FishingLevel", this.fishingLevel);
		compound.setFloat("CookingLevel", this.cookingLevel);
		compound.setFloat("WoodCuttingLevel", this.woodCuttingLevel);
		compound.setFloat("HerbloreLevel", this.herbloreLevel);
		compound.setFloat("SlayerLevel", this.slayerLevel);
		compound.setFloat("ThievingLevel", this.thievingLevel);
		compound.setFloat("SharingLevel", this.sharingLevel);
		
		nbt.setTag(IDENTIFIER, compound);
	}
	
	@Override
	public void loadNBTData(NBTTagCompound nbt)
	{
		NBTTagCompound compound = nbt.getCompoundTag(IDENTIFIER);
		
		this.mana = compound.getFloat("Mana");
		this.meleeLevel = compound.getFloat("MeleeLevel");
		this.defenceLevel = compound.getFloat("DefenceLevel");
		this.magicLevel = compound.getFloat("MagicLevel");
		this.rangedLevel = compound.getFloat("RangedLevel");
		this.diggingLevel = compound.getFloat("DiggingLevel");
		this.miningLevel = compound.getFloat("MiningLevel");
		this.smithingLevel = compound.getFloat("SmithingLevel");
		this.fishingLevel = compound.getFloat("FishingLevel");
		this.cookingLevel = compound.getFloat("CookingLevel");
		this.woodCuttingLevel = compound.getFloat("WoodCuttingLevel");
		this.herbloreLevel = compound.getFloat("HerbloreLevel");
		this.slayerLevel = compound.getFloat("SlayerLevel");
		this.thievingLevel = compound.getFloat("ThievingLevel");
		this.sharingLevel = compound.getFloat("SharingLevel");
	}
}
