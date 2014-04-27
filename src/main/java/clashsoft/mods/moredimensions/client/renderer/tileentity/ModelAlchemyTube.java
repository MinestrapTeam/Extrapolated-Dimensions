package clashsoft.mods.moredimensions.client.renderer.tileentity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelAlchemyTube extends ModelBase
{
	public ModelRenderer	tubeCore;
	public ModelRenderer	tubeYNegative;
	public ModelRenderer	tubeYPositive;
	public ModelRenderer	tubeXNegative;
	public ModelRenderer	tubeXPositive;
	public ModelRenderer	tubeZNegative;
	public ModelRenderer	tubeZPositive;
	
	public ModelAlchemyTube()
	{
		this.textureWidth = 32;
		this.textureHeight = 32;
		
		this.tubeCore = new ModelRenderer(this, 0, 0);
		this.tubeCore.addBox(-2F, -2F, -2F, 4, 4, 4);
		this.tubeCore.setRotationPoint(0F, 16F, 0F);
		this.tubeCore.setTextureSize(32, 32);
		this.tubeCore.mirror = true;
		this.setRotation(this.tubeCore, 0F, 0F, 0F);
		this.tubeYNegative = new ModelRenderer(this, 16, 0);
		this.tubeYNegative.addBox(-2F, 2F, -2F, 4, 6, 4);
		this.tubeYNegative.setRotationPoint(0F, 16F, 0F);
		this.tubeYNegative.setTextureSize(32, 32);
		this.tubeYNegative.mirror = true;
		this.setRotation(this.tubeYNegative, 3.141593F, 0F, 0F);
		this.tubeYPositive = new ModelRenderer(this, 16, 0);
		this.tubeYPositive.addBox(-2F, 2F, -2F, 4, 6, 4);
		this.tubeYPositive.setRotationPoint(0F, 16F, 0F);
		this.tubeYPositive.setTextureSize(32, 32);
		this.tubeYPositive.mirror = true;
		this.setRotation(this.tubeYPositive, 0F, 0F, 0F);
		this.tubeXNegative = new ModelRenderer(this, 16, 0);
		this.tubeXNegative.addBox(-2F, 2F, -2F, 4, 6, 4);
		this.tubeXNegative.setRotationPoint(0F, 16F, 0F);
		this.tubeXNegative.setTextureSize(32, 32);
		this.tubeXNegative.mirror = true;
		this.setRotation(this.tubeXNegative, 0F, 0F, 1.570796F);
		this.tubeXPositive = new ModelRenderer(this, 16, 0);
		this.tubeXPositive.addBox(-2F, 2F, -2F, 4, 6, 4);
		this.tubeXPositive.setRotationPoint(0F, 16F, 0F);
		this.tubeXPositive.setTextureSize(32, 32);
		this.tubeXPositive.mirror = true;
		this.setRotation(this.tubeXPositive, 0F, 0F, -1.570796F);
		this.tubeZNegative = new ModelRenderer(this, 16, 0);
		this.tubeZNegative.addBox(-2F, 2F, -2F, 4, 6, 4);
		this.tubeZNegative.setRotationPoint(0F, 16F, 0F);
		this.tubeZNegative.setTextureSize(32, 32);
		this.tubeZNegative.mirror = true;
		this.setRotation(this.tubeZNegative, -1.570796F, 0F, 0F);
		this.tubeZPositive = new ModelRenderer(this, 16, 0);
		this.tubeZPositive.addBox(-2F, 2F, -2F, 4, 6, 4);
		this.tubeZPositive.setRotationPoint(0F, 16F, 0F);
		this.tubeZPositive.setTextureSize(32, 32);
		this.tubeZPositive.mirror = true;
		this.setRotation(this.tubeZPositive, 1.570796F, 0F, 0F);
		
	}
	
	public void renderAll(boolean xPos, boolean xNeg, boolean yPos, boolean yNeg, boolean zPos, boolean zNeg)
	{
		this.tubeCore.render(0.0625F);
		if (xPos)
			this.tubeXPositive.render(0.0625F);
		if (xNeg)
			this.tubeXNegative.render(0.0625F);
		if (yPos)
			this.tubeYPositive.render(0.0625F);
		if (yNeg)
			this.tubeYNegative.render(0.0625F);
		if (zPos)
			this.tubeZPositive.render(0.0625F);
		if (zNeg)
			this.tubeZNegative.render(0.0625F);
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}
