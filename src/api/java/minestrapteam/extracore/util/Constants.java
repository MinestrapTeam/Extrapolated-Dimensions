package minestrapteam.extracore.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import minestrapteam.extracore.util.ReflectionUtils;
import cpw.mods.fml.common.registry.FMLControlledNamespacedRegistry;
import cpw.mods.fml.common.registry.RegistryDelegate.Delegate;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBlock;
import net.minecraft.stats.StatCrafting;

public class Constants
{
	public static final int		COLOR_RED											= 0xFF0000;
	public static final int		COLOR_YELLOW										= 0xFFDF00;
	public static final int		COLOR_GREEN											= 0x00DF00;
	public static final int		COLOR_BLUE											= 0x007FFF;
	public static final int		COLOR_LIGHT_BLUE									= 0x00DFFF;
	
	public static final Field	FIELD_ItemBlock_block								= ReflectionUtils
											                                                .getField(ItemBlock.class, 0);
	public static final Field	FIELD_StatCrafting_item								= ReflectionUtils
											                                                  .getField(StatCrafting.class, 0);
	public static final Field	FIELD_ItemArmor_armorType							= ReflectionUtils
										                                                    .getField(ItemArmor.class, 4);
	public static final Field	FIELD_ItemArmor_damageReduction						= ReflectionUtils
									                                                          .getField(ItemArmor.class, 5);
	public static final Field	FIELD_EntityList_classToIDMapping					= ReflectionUtils
								                                                            .getField(EntityList.class, 4);
	public static final Field	FIELD_EntityList_stringToIDMapping					= ReflectionUtils
								                                                             .getField(EntityList.class, 5);
	public static final Field	FIELD_CreativeTabs_tabIndex							= ReflectionUtils
										                                                      .getField(CreativeTabs.class, 13);
	public static final Field	FIELD_Delegate_referant								= ReflectionUtils
											                                                  .getField(Delegate.class, 0);
	
	public static final Method	METHOD_FMLControlledNamespacedRegistry_addObjectRaw	= ReflectionUtils
				                                                                               .getMethod(FMLControlledNamespacedRegistry.class, "addObjectRaw", new Class[] { int.class, String.class, Object.class });
}
