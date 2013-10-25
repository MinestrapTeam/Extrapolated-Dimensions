package clashsoft.mods.moredimensions.addons;

import clashsoft.clashsoftapi.util.addons.Addon;
import clashsoft.mods.moredimensions.MoreDimensionsMod;
import clashsoft.mods.moredimensions.entity.boss.EntityLich;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.entity.EnumCreatureType;

@Addon(modName = "MoreDimensionsMod", addonName = "Entitys")
public class MDMEntitys
{
	public void load()
	{
		// Lich Entity
		EntityRegistry.registerGlobalEntityID(EntityLich.class, "POCBossLich", EntityRegistry.findGlobalUniqueEntityId(), 0xFFFFFF, 0xEEEEEE);
		LanguageRegistry.instance().addStringLocalization("entity.POCBossLich.name", "Lich");
		
		MoreDimensionsMod.proxy.registerEntityRenderers();
		
		EntityRegistry.addSpawn(EntityLich.class, 100, 1, 10, EnumCreatureType.creature);
	}
}
