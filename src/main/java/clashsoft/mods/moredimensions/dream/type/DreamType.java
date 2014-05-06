package clashsoft.mods.moredimensions.dream.type;

import java.util.*;

import clashsoft.mods.moredimensions.dream.EnumDreamType;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
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
	
	public void addBiomes(List<BiomeGenBase> biomes)
	{
		biomes.add(this.getDreamBiome());
	}
	
	public Block getStoneBlock()
	{
		return Blocks.stone;
	}
	
	public Block getDirtBlock()
	{
		return Blocks.dirt;
	}
	
	public Block getTopBlock()
	{
		return Blocks.grass;
	}
	
	public Block getFillerBlock()
	{
		return Blocks.dirt;
	}
	
	public Block getSandBlock()
	{
		return Blocks.sand;
	}
	
	public Block getSandstoneBlock()
	{
		return Blocks.sandstone;
	}
	
	public Block getSnowBlock()
	{
		return Blocks.snow;
	}
	
	public Block getIceBlock()
	{
		return Blocks.ice;
	}
	
	public Block getWaterBlock()
	{
		return Blocks.water;
	}
	
	public Block getLavaBlock()
	{
		return Blocks.lava;
	}
	
	public Block getBedrockBlock()
	{
		return Blocks.bedrock;
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
