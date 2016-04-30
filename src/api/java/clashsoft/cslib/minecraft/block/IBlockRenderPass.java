package clashsoft.cslib.minecraft.block;

public interface IBlockRenderPass
{
	int getRenderPasses(int metadata);
	
	int getRenderID(int metadata, int pass);
}
