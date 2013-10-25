package com.chaosdev.paradiseofchaos.client.renderer.entity;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;

import com.chaosdev.paradiseofchaos.client.model.ModelLich;
import com.chaosdev.paradiseofchaos.entity.boss.EntityLich;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderLich extends RenderBiped
{
	private final ModelBiped	field_82434_o;
	protected ModelBiped		field_82437_k;
	protected ModelBiped		field_82435_l;
	protected ModelBiped		field_82436_m;
	protected ModelBiped		field_82433_n;
	
	public RenderLich()
	{
		super(new ModelLich(), 0.5F, 1.0F);
		this.field_82434_o = this.modelBipedMain;
	}
	
	@Override
	protected void func_82421_b()
	{
		this.field_82423_g = new ModelLich();
		this.field_82425_h = new ModelLich();
		this.field_82437_k = this.field_82423_g;
		this.field_82435_l = this.field_82425_h;
	}
	
	protected int func_82429_a(EntityLich par1EntityLich, int par2, float par3)
	{
		this.func_82427_a(par1EntityLich);
		return super.shouldRenderPass(par1EntityLich, par2, par3);
	}
	
	public void func_82426_a(EntityLich par1EntityLich, double par2, double par4, double par6, float par8, float par9)
	{
		this.func_82427_a(par1EntityLich);
		super.doRenderLiving(par1EntityLich, par2, par4, par6, par8, par9);
	}
	
	protected void func_82428_a(EntityLich par1EntityLich, float par2)
	{
		this.func_82427_a(par1EntityLich);
		super.renderEquippedItems(par1EntityLich, par2);
	}
	
	private void func_82427_a(EntityLich par1EntityLich)
	{
		this.mainModel = this.field_82434_o;
		this.field_82423_g = this.field_82437_k;
		this.field_82425_h = this.field_82435_l;
		
		this.modelBipedMain = (ModelBiped) this.mainModel;
	}
	
	protected void func_82430_a(EntityLich par1EntityLich, float par2, float par3, float par4)
	{
		if (par1EntityLich.isStartingFight())
		{
			par3 += (float) (Math.cos(par1EntityLich.ticksExisted * 3.25D) * Math.PI * 0.25D);
		}
		
		super.rotateCorpse(par1EntityLich, par2, par3, par4);
	}
	
	protected void renderEquippedItems(EntityLiving par1EntityLiving, float par2)
	{
		this.func_82428_a((EntityLich) par1EntityLiving, par2);
	}
	
	@Override
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
	{
		this.func_82426_a((EntityLich) par1EntityLiving, par2, par4, par6, par8, par9);
	}
	
	/**
	 * Queries whether should render the specified pass or not.
	 */
	protected int shouldRenderPass(EntityLiving par1EntityLiving, int par2, float par3)
	{
		return this.func_82429_a((EntityLich) par1EntityLiving, par2, par3);
	}
	
	protected void rotateCorpse(EntityLiving par1EntityLiving, float par2, float par3, float par4)
	{
		this.func_82430_a((EntityLich) par1EntityLiving, par2, par3, par4);
	}
	
	@Override
	/**
	 * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
	 * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
	 * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
	 * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
	 */
	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
	{
		this.func_82426_a((EntityLich) par1Entity, par2, par4, par6, par8, par9);
	}
}
