package clashsoft.mods.moredimensions.client.renderer.tileentity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelAlchemyTube extends ModelBase
{
	ModelRenderer	TubeCore;
	ModelRenderer	TubeYNegative;
	ModelRenderer	TubeYPositive;
	ModelRenderer	TubeXNegative;
	ModelRenderer	TubeXPositive;
	ModelRenderer	TubeZNegative;
	ModelRenderer	TubeZPositive;
	
	public ModelAlchemyTube()
	{
		textureWidth = 32;
		textureHeight = 32;
		
		TubeCore = new ModelRenderer(this, 0, 0);
		TubeCore.addBox(-2F, -2F, -2F, 4, 4, 4);
		TubeCore.setRotationPoint(0F, 16F, 0F);
		TubeCore.setTextureSize(32, 32);
		TubeCore.mirror = true;
		setRotation(TubeCore, 0F, 0F, 0F);
		TubeYNegative = new ModelRenderer(this, 16, 0);
		TubeYNegative.addBox(-2F, 2F, -2F, 4, 6, 4);
		TubeYNegative.setRotationPoint(0F, 16F, 0F);
		TubeYNegative.setTextureSize(32, 32);
		TubeYNegative.mirror = true;
		setRotation(TubeYNegative, 3.141593F, 0F, 0F);
		TubeYPositive = new ModelRenderer(this, 16, 0);
		TubeYPositive.addBox(-2F, 2F, -2F, 4, 6, 4);
		TubeYPositive.setRotationPoint(0F, 16F, 0F);
		TubeYPositive.setTextureSize(32, 32);
		TubeYPositive.mirror = true;
		setRotation(TubeYPositive, 0F, 0F, 0F);
		TubeXNegative = new ModelRenderer(this, 16, 0);
		TubeXNegative.addBox(-2F, 2F, -2F, 4, 6, 4);
		TubeXNegative.setRotationPoint(0F, 16F, 0F);
		TubeXNegative.setTextureSize(32, 32);
		TubeXNegative.mirror = true;
		setRotation(TubeXNegative, 0F, 0F, 1.570796F);
		TubeXPositive = new ModelRenderer(this, 16, 0);
		TubeXPositive.addBox(-2F, 2F, -2F, 4, 6, 4);
		TubeXPositive.setRotationPoint(0F, 16F, 0F);
		TubeXPositive.setTextureSize(32, 32);
		TubeXPositive.mirror = true;
		setRotation(TubeXPositive, 0F, 0F, -1.570796F);
		TubeZNegative = new ModelRenderer(this, 16, 0);
		TubeZNegative.addBox(-2F, 2F, -2F, 4, 6, 4);
		TubeZNegative.setRotationPoint(0F, 16F, 0F);
		TubeZNegative.setTextureSize(32, 32);
		TubeZNegative.mirror = true;
		setRotation(TubeZNegative, -1.570796F, 0F, 0F);
		TubeZPositive = new ModelRenderer(this, 16, 0);
		TubeZPositive.addBox(-2F, 2F, -2F, 4, 6, 4);
		TubeZPositive.setRotationPoint(0F, 16F, 0F);
		TubeZPositive.setTextureSize(32, 32);
		TubeZPositive.mirror = true;
		setRotation(TubeZPositive, 1.570796F, 0F, 0F);
		
	}
	
	public void renderAll(boolean xPos, boolean xNeg, boolean yPos, boolean yNeg, boolean zPos, boolean zNeg)
	{
		TubeCore.render(0.0625F);
		if (xPos)
			TubeXPositive.render(0.0625F);
		if (xNeg)
			TubeXNegative.render(0.0625F);
		if (yPos)
			TubeYPositive.render(0.0625F);
		if (yNeg)
			TubeYNegative.render(0.0625F);
		if (zPos)
			TubeZPositive.render(0.0625F);
		if (zNeg)
			TubeZNegative.render(0.0625F);
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}
