package clashsoft.mods.moredimensions.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelScider extends ModelBase
{
	/** The scider's head box */
	public ModelRenderer	sciderHead;
	
	/** The scider's neck box */
	public ModelRenderer	sciderNeck;
	
	/** The scider's body box */
	public ModelRenderer	sciderBody;
	
	/** Scider's first leg */
	public ModelRenderer	sciderLeg1;
	
	/** Scider's second leg */
	public ModelRenderer	sciderLeg2;
	
	/** Scider's third leg */
	public ModelRenderer	sciderLeg3;
	
	/** Scider's fourth leg */
	public ModelRenderer	sciderLeg4;
	
	/** Scider's fifth leg */
	public ModelRenderer	sciderLeg5;
	
	/** Scider's sixth leg */
	public ModelRenderer	sciderLeg6;
	
	/** Scider's seventh leg */
	public ModelRenderer	sciderLeg7;
	
	/** Scider's eight leg */
	public ModelRenderer	sciderLeg8;
	
	public ModelScider()
	{
		float var1 = 0.0F;
		byte var2 = 15;
		this.sciderHead = new ModelRenderer(this, 32, 4);
		this.sciderHead.addBox(-4.0F, -4.0F, -8.0F, 8, 8, 8, var1);
		this.sciderHead.setRotationPoint(0.0F, var2, -3.0F);
		this.sciderNeck = new ModelRenderer(this, 0, 0);
		this.sciderNeck.addBox(-3.0F, -3.0F, -3.0F, 6, 6, 6, var1);
		this.sciderNeck.setRotationPoint(0.0F, var2, 0.0F);
		this.sciderBody = new ModelRenderer(this, 0, 12);
		this.sciderBody.addBox(-5.0F, -4.0F, -6.0F, 10, 8, 12, var1);
		this.sciderBody.setRotationPoint(0.0F, var2, 9.0F);
		this.sciderLeg1 = new ModelRenderer(this, 18, 0);
		this.sciderLeg1.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2, var1);
		this.sciderLeg1.setRotationPoint(-4.0F, var2, 2.0F);
		this.sciderLeg2 = new ModelRenderer(this, 18, 0);
		this.sciderLeg2.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2, var1);
		this.sciderLeg2.setRotationPoint(4.0F, var2, 2.0F);
		this.sciderLeg3 = new ModelRenderer(this, 18, 0);
		this.sciderLeg3.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2, var1);
		this.sciderLeg3.setRotationPoint(-4.0F, var2, 1.0F);
		this.sciderLeg4 = new ModelRenderer(this, 18, 0);
		this.sciderLeg4.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2, var1);
		this.sciderLeg4.setRotationPoint(4.0F, var2, 1.0F);
		this.sciderLeg5 = new ModelRenderer(this, 18, 0);
		this.sciderLeg5.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2, var1);
		this.sciderLeg5.setRotationPoint(-4.0F, var2, 0.0F);
		this.sciderLeg6 = new ModelRenderer(this, 18, 0);
		this.sciderLeg6.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2, var1);
		this.sciderLeg6.setRotationPoint(4.0F, var2, 0.0F);
		this.sciderLeg7 = new ModelRenderer(this, 18, 0);
		this.sciderLeg7.addBox(-15.0F, -1.0F, -1.0F, 16, 2, 2, var1);
		this.sciderLeg7.setRotationPoint(-4.0F, var2, -1.0F);
		this.sciderLeg8 = new ModelRenderer(this, 18, 0);
		this.sciderLeg8.addBox(-1.0F, -1.0F, -1.0F, 16, 2, 2, var1);
		this.sciderLeg8.setRotationPoint(4.0F, var2, -1.0F);
	}
	
	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	@Override
	public void render(Entity entity, float x, float y, float z, float i1, float i2, float i3)
	{
		this.setRotationAngles(x, y, z, i1, i2, i3);
		this.sciderHead.render(i3);
		this.sciderNeck.render(i3);
		this.sciderBody.render(i3);
		this.sciderLeg1.render(i3);
		this.sciderLeg2.render(i3);
		this.sciderLeg3.render(i3);
		this.sciderLeg4.render(i3);
		this.sciderLeg5.render(i3);
		this.sciderLeg6.render(i3);
		this.sciderLeg7.render(i3);
		this.sciderLeg8.render(i3);
	}
	
	/**
	 * Sets the models various rotation angles.
	 */
	public void setRotationAngles(float x, float y, float z, float x1, float y1, float z1)
	{
		this.sciderHead.rotateAngleY = x1 / (180F / (float) Math.PI);
		this.sciderHead.rotateAngleX = y1 / (180F / (float) Math.PI);
		float var7 = ((float) Math.PI / 4F);
		this.sciderLeg1.rotateAngleZ = -var7;
		this.sciderLeg2.rotateAngleZ = var7;
		this.sciderLeg3.rotateAngleZ = -var7 * 0.74F;
		this.sciderLeg4.rotateAngleZ = var7 * 0.74F;
		this.sciderLeg5.rotateAngleZ = -var7 * 0.74F;
		this.sciderLeg6.rotateAngleZ = var7 * 0.74F;
		this.sciderLeg7.rotateAngleZ = -var7;
		this.sciderLeg8.rotateAngleZ = var7;
		float var8 = -0.0F;
		float var9 = 0.3926991F;
		this.sciderLeg1.rotateAngleY = var9 * 2.0F + var8;
		this.sciderLeg2.rotateAngleY = -var9 * 2.0F - var8;
		this.sciderLeg3.rotateAngleY = var9 * 1.0F + var8;
		this.sciderLeg4.rotateAngleY = -var9 * 1.0F - var8;
		this.sciderLeg5.rotateAngleY = -var9 * 1.0F + var8;
		this.sciderLeg6.rotateAngleY = var9 * 1.0F - var8;
		this.sciderLeg7.rotateAngleY = -var9 * 2.0F + var8;
		this.sciderLeg8.rotateAngleY = var9 * 2.0F - var8;
		float var10 = -(MathHelper.cos(x * 0.6662F * 2.0F + 0.0F) * 0.4F) * y;
		float var11 = -(MathHelper.cos(x * 0.6662F * 2.0F + (float) Math.PI) * 0.4F) * y;
		float var12 = -(MathHelper.cos(x * 0.6662F * 2.0F + ((float) Math.PI / 2F)) * 0.4F) * y;
		float var13 = -(MathHelper.cos(x * 0.6662F * 2.0F + ((float) Math.PI * 3F / 2F)) * 0.4F) * y;
		float var14 = Math.abs(MathHelper.sin(x * 0.6662F + 0.0F) * 0.4F) * y;
		float var15 = Math.abs(MathHelper.sin(x * 0.6662F + (float) Math.PI) * 0.4F) * y;
		float var16 = Math.abs(MathHelper.sin(x * 0.6662F + ((float) Math.PI / 2F)) * 0.4F) * y;
		float var17 = Math.abs(MathHelper.sin(x * 0.6662F + ((float) Math.PI * 3F / 2F)) * 0.4F) * y;
		this.sciderLeg1.rotateAngleY += var10;
		this.sciderLeg2.rotateAngleY += -var10;
		this.sciderLeg3.rotateAngleY += var11;
		this.sciderLeg4.rotateAngleY += -var11;
		this.sciderLeg5.rotateAngleY += var12;
		this.sciderLeg6.rotateAngleY += -var12;
		this.sciderLeg7.rotateAngleY += var13;
		this.sciderLeg8.rotateAngleY += -var13;
		this.sciderLeg1.rotateAngleZ += var14;
		this.sciderLeg2.rotateAngleZ += -var14;
		this.sciderLeg3.rotateAngleZ += var15;
		this.sciderLeg4.rotateAngleZ += -var15;
		this.sciderLeg5.rotateAngleZ += var16;
		this.sciderLeg6.rotateAngleZ += -var16;
		this.sciderLeg7.rotateAngleZ += var17;
		this.sciderLeg8.rotateAngleZ += -var17;
	}
}
