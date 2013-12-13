package clashsoft.mods.moredimensions.dreams.dreamtypes;

import java.util.*;

import clashsoft.mods.moredimensions.dreams.EnumDreamType;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public abstract class DreamType
{
	public static Map<String, DreamType>	dreamTypes	= new HashMap<String, DreamType>();
	
	public static DreamType					forest		= new DreamTypeBiome("forest", EnumDreamType.NIGHTMARE, BiomeGenBase.forest);
	public static DreamType					plains		= new DreamTypeBiome("plains", EnumDreamType.DREAM, BiomeGenBase.plains);
	
	public EnumDreamType					type;
	public String							name;
	
	public DreamType(String name, EnumDreamType type)
	{
		this.name = name;
		this.type = type;
		dreamTypes.put(name, this);
	}
	
	public abstract BiomeGenBase getDreamBiome();
	
	public Block getStoneBlock()
	{
		return Block.stone;
	}
	
	public Block getDirtBlock()
	{
		return Block.dirt;
	}
	
	public Block getTopBlock()
	{
		return Block.grass;
	}
	
	public Block getFilledBlock()
	{
		return Block.dirt;
	}
	
	public Block getSandBlock()
	{
		return Block.sand;
	}
	
	public Block getSandstoneBlock()
	{
		return Block.sandStone;
	}
	
	public Block getSnowBlock()
	{
		return Block.snow;
	}
	
	public Block getIceBlock()
	{
		return Block.ice;
	}
	
	public Block getWaterBlock()
	{
		return Block.waterStill;
	}
	
	public Block getLavaBlock()
	{
		return Block.lavaStill;
	}
	
	public Block getBedrockBlock()
	{
		return Block.bedrock;
	}
	
	public abstract void generateWorld(World world, int chunkX, int chunkY, Random random);
	
	public static DreamType getRandomDreamType(EnumDreamType type)
	{
		List<DreamType> temp = new ArrayList<DreamType>();
		for (DreamType dt : dreamTypes.values())
		{
			if (dt != null && dt.type != null && dt.type.equals(type))
				temp.add(dt);
		}
		
		DreamType random = null;
		if (temp.size() > 0)
			random = temp.get(new Random(192846209836394869L).nextInt(temp.size()));
		return random;
	}
}
