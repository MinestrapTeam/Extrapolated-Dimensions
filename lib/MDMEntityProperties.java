package clashsoft.mods.moredimensions.lib;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class MDMEntityProperties implements IExtendedEntityProperties
{
	public static final String		IDENTIFIER			= "POCEntityProperties";
	public static final String		CHANNEL				= "POCEPC";
	
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
		if (entity instanceof EntityPlayer)
			sync((EntityPlayer) entity);
	}
	
	/*
	 * Setters
	 */
	
	public MDMEntityProperties setMana(float mana)
	{
		this.mana = mana;
		onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties setAdditionalHearts(float additionalHearts)
	{
		this.additionalHearts = additionalHearts;
		onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties setMeleeLevel(float meleeLevel)
	{
		this.meleeLevel = meleeLevel;
		onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties setDefenceLevel(float defenceLevel)
	{
		this.defenceLevel = defenceLevel;
		
		onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties setMagicLevel(float magicLevel)
	{
		this.magicLevel = magicLevel;
		onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties setRangedLevel(float rangedLevel)
	{
		this.rangedLevel = rangedLevel;
		onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties setDiggingLevel(float level)
	{
		this.diggingLevel = level;
		onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties setMiningLevel(float miningLevel)
	{
		this.miningLevel = miningLevel;
		onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties setSmithingLevel(float smithingLevel)
	{
		this.smithingLevel = smithingLevel;
		onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties setFishingLevel(float fishingLevel)
	{
		this.fishingLevel = fishingLevel;
		onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties setCookingLevel(float cookingLevel)
	{
		this.cookingLevel = cookingLevel;
		onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties setWoodCuttingLevel(float woodCuttingLevel)
	{
		this.woodCuttingLevel = woodCuttingLevel;
		onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties setHerbloreLevel(float herbloreLevel)
	{
		this.herbloreLevel = herbloreLevel;
		onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties setThievingLevel(float thievingLevel)
	{
		this.thievingLevel = thievingLevel;
		onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties setSlayerLevel(float level)
	{
		this.slayerLevel = level;
		onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties setFarmingLevel(float farmingLevel)
	{
		this.farmingLevel = farmingLevel;
		onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties setSharingLevel(float sharingLevel)
	{
		this.sharingLevel = sharingLevel;
		onPropertyChanged();
		return this;
	}
	
	/*
	 * Getters
	 */
	
	public float getMana()
	{
		return mana;
	}
	
	public float getAdditionalHearts()
	{
		return additionalHearts;
	}
	
	public float getMeleeLevel()
	{
		return meleeLevel;
	}
	
	public float getDefenceLevel()
	{
		return defenceLevel;
	}
	
	public float getMagicLevel()
	{
		return magicLevel;
	}
	
	public float getRangedLevel()
	{
		return rangedLevel;
	}
	
	public float getDiggingLevel()
	{
		return diggingLevel;
	}
	
	public float getMiningLevel()
	{
		return miningLevel;
	}
	
	public float getSmithingLevel()
	{
		return smithingLevel;
	}
	
	public float getFishingLevel()
	{
		return fishingLevel;
	}
	
	public float getCookingLevel()
	{
		return cookingLevel;
	}
	
	public float getWoodCuttingLevel()
	{
		return woodCuttingLevel;
	}
	
	public float getHerbloreLevel()
	{
		return herbloreLevel;
	}
	
	public float getThievingLevel()
	{
		return thievingLevel;
	}
	
	public float getSlayerLevel()
	{
		return slayerLevel;
	}
	
	public float getFarmingLevel()
	{
		return farmingLevel;
	}
	
	public float getSharingLevel()
	{
		return sharingLevel;
	}
	
	/*
	 * Increasing methods
	 */
	
	public MDMEntityProperties addMana(float mana)
	{
		this.mana += mana;
		onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties addMeleeLevel(float level)
	{
		this.meleeLevel += level;
		onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties addDefenceLevel(float level)
	{
		this.defenceLevel += level;
		onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties addMagicLevel(float level)
	{
		this.magicLevel += level;
		onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties addRangedLevel(float level)
	{
		this.rangedLevel += level;
		onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties addDiggingLevel(float level)
	{
		this.diggingLevel += level;
		onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties addMiningLevel(float level)
	{
		this.miningLevel += level;
		onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties addSmithingLevel(float level)
	{
		this.smithingLevel += level;
		onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties addFishingLevel(float level)
	{
		this.fishingLevel += level;
		onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties addCookingLevel(float level)
	{
		this.cookingLevel += level;
		onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties addWoodCuttingLevel(float level)
	{
		this.woodCuttingLevel += level;
		onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties addHerbloreLevel(float level)
	{
		this.herbloreLevel += level;
		onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties addThievingLevel(float level)
	{
		this.thievingLevel += level;
		onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties addSlayerLevel(float level)
	{
		this.slayerLevel += level;
		onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties addFarmingLevel(float level)
	{
		this.farmingLevel += level;
		onPropertyChanged();
		return this;
	}
	
	public MDMEntityProperties addSharingLevel(float level)
	{
		this.sharingLevel += level;
		onPropertyChanged();
		return this;
	}
	
	/*
	 * GENERIC PROPERTIES
	 */
	
	@Override
	public void init(final Entity entity, World world)
	{
		
	}
	
	public static MDMEntityProperties getEntityProperties(EntityLivingBase living)
	{
		MDMEntityProperties props = getEntityProperties_(living);
		return props == null ? setEntityProperties(living, create(living)) : props;
	}
	
	protected static MDMEntityProperties getEntityProperties_(EntityLivingBase living)
	{
		return (MDMEntityProperties) living.getExtendedProperties(IDENTIFIER);
	}
	
	public static MDMEntityProperties setByPacket(EntityLivingBase living, Packet250CustomPayload packet)
	{
		return setEntityProperties(living, create(living).readFromPacket(packet));
	}
	
	public static MDMEntityProperties setEntityProperties(EntityLivingBase living, MDMEntityProperties properties)
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
	
	public void sync(EntityPlayer playerEntity)
	{
		Packet250CustomPayload packet = createPacket();
		
		Side side = FMLCommonHandler.instance().getEffectiveSide();
		if (side == Side.SERVER)
			PacketDispatcher.sendPacketToPlayer(packet, (Player) playerEntity);
		else if (side == Side.CLIENT)
			PacketDispatcher.sendPacketToServer(packet);
	}
	
	protected Packet250CustomPayload createPacket()
	{
		ByteArrayOutputStream bos = new ByteArrayOutputStream(128);
		DataOutputStream dos = new DataOutputStream(bos);
		
		try
		{
			dos.writeFloat(this.mana);
			dos.writeFloat(this.additionalHearts);
			dos.writeFloat(this.meleeLevel);
			dos.writeFloat(this.defenceLevel);
			dos.writeFloat(this.magicLevel);
			dos.writeFloat(this.rangedLevel);
			dos.writeFloat(this.diggingLevel);
			dos.writeFloat(this.miningLevel);
			dos.writeFloat(this.smithingLevel);
			dos.writeFloat(this.fishingLevel);
			dos.writeFloat(this.cookingLevel);
			dos.writeFloat(this.woodCuttingLevel);
			dos.writeFloat(this.herbloreLevel);
			dos.writeFloat(this.thievingLevel);
			dos.writeFloat(this.slayerLevel);
			dos.writeFloat(this.farmingLevel);
			dos.writeFloat(this.sharingLevel);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
		
		Packet250CustomPayload packet = new Packet250CustomPayload(CHANNEL, bos.toByteArray());
		
		return packet;
	}
	
	public MDMEntityProperties readFromPacket(Packet250CustomPayload packet)
	{
		DataInputStream dis = new DataInputStream(new ByteArrayInputStream(packet.data));
		try
		{
			this.mana = dis.readFloat();
			this.additionalHearts = dis.readFloat();
			this.meleeLevel = dis.readFloat();
			this.defenceLevel = dis.readFloat();
			this.magicLevel = dis.readFloat();
			this.rangedLevel = dis.readFloat();
			this.diggingLevel = dis.readFloat();
			this.miningLevel = dis.readFloat();
			this.smithingLevel = dis.readFloat();
			this.fishingLevel = dis.readFloat();
			this.cookingLevel = dis.readFloat();
			this.woodCuttingLevel = dis.readFloat();
			this.herbloreLevel = dis.readFloat();
			this.thievingLevel = dis.readFloat();
			this.slayerLevel = dis.readFloat();
			this.farmingLevel = dis.readFloat();
			this.sharingLevel = dis.readFloat();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return this;
	}
	
	/*
	 * NBT
	 */
	
	@Override
	public void saveNBTData(NBTTagCompound compound)
	{
		NBTTagCompound compound1 = new NBTTagCompound();
		
		compound1.setFloat("Mana", this.mana);
		compound1.setFloat("MeleeLevel", this.meleeLevel);
		compound1.setFloat("DefenceLevel", this.defenceLevel);
		compound1.setFloat("MagicLevel", this.magicLevel);
		compound1.setFloat("RangedLevel", this.rangedLevel);
		compound1.setFloat("DiggingLevel", this.diggingLevel);
		compound1.setFloat("MiningLevel", this.miningLevel);
		compound1.setFloat("SmithingLevel", this.smithingLevel);
		compound1.setFloat("FishingLevel", this.fishingLevel);
		compound1.setFloat("CookingLevel", this.cookingLevel);
		compound1.setFloat("WoodCuttingLevel", this.woodCuttingLevel);
		compound1.setFloat("HerbloreLevel", this.herbloreLevel);
		compound1.setFloat("SlayerLevel", this.slayerLevel);
		compound1.setFloat("ThievingLevel", this.thievingLevel);
		compound1.setFloat("SharingLevel", this.sharingLevel);
		
		compound.setCompoundTag(IDENTIFIER, compound1);
	}
	
	@Override
	public void loadNBTData(NBTTagCompound compound)
	{
		NBTTagCompound compound1 = compound.getCompoundTag(IDENTIFIER);
		
		this.mana = compound1.getFloat("Mana");
		this.meleeLevel = compound1.getFloat("MeleeLevel");
		this.defenceLevel = compound1.getFloat("DefenceLevel");
		this.magicLevel = compound1.getFloat("MagicLevel");
		this.rangedLevel = compound1.getFloat("RangedLevel");
		this.diggingLevel = compound1.getFloat("DiggingLevel");
		this.miningLevel = compound1.getFloat("MiningLevel");
		this.smithingLevel = compound1.getFloat("SmithingLevel");
		this.fishingLevel = compound1.getFloat("FishingLevel");
		this.cookingLevel = compound1.getFloat("CookingLevel");
		this.woodCuttingLevel = compound1.getFloat("WoodCuttingLevel");
		this.herbloreLevel = compound1.getFloat("HerbloreLevel");
		this.slayerLevel = compound1.getFloat("SlayerLevel");
		this.thievingLevel = compound1.getFloat("ThievingLevel");
		this.sharingLevel = compound1.getFloat("SharingLevel");
	}
}
