package clashsoft.mods.moredimensions.dream.type;

import java.util.*;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public abstract class DreamType
{
	public static Map<String, DreamType>	dreamTypes	= new HashMap();
	public static List<DreamType>			dreamList	= new ArrayList();
	
	public static DreamType					forest		= new DreamTypeBiome("forest", true, BiomeGenBase.forest);
	public static DreamType					plains		= new DreamTypeBiome("plains", true, BiomeGenBase.plains);
	
	public boolean							nightmare;
	public String							name;
	
	public DreamType(String name, boolean nightmare)
	{
		this.name = name;
		this.nightmare = nightmare;
		
		dreamList.add(this);
		dreamTypes.put(name, this);
	}
	
	public abstract BiomeGenBase getDreamBiome();
	
	public void addBiomes(List<BiomeGenBase> biomes)
	{
		biomes.add(this.getDreamBiome());
	}
	
	public abstract void generateWorld(World world, int chunkX, int chunkY, Random random);
	
	public static DreamType getRandomDreamType(boolean nightmare, Random random)
	{
		List<DreamType> temp = new ArrayList<DreamType>();
		for (DreamType dt : dreamList)
		{
			if (dt != null && dt.nightmare == nightmare)
				temp.add(dt);
		}
		
		DreamType type = null;
		if (temp.size() > 0)
		{
			type = temp.get(random.nextInt(temp.size()));
		}
		return type;
	}
}
