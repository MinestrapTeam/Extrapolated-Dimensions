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
		textureWidth = 32;
		textureHeight = 32;
		
		tubeCore = new ModelRenderer(this, 0, 0);
		tubeCore.addBox(-2F, -2F, -2F, 4, 4, 4);
		tubeCore.setRotationPoint(0F, 16F, 0F);
		tubeCore.setTextureSize(32, 32);
		tubeCore.mirror = true;
		setRotation(tubeCore, 0F, 0F, 0F);
		tubeYNegative = new ModelRenderer(this, 16, 0);
		tubeYNegative.addBox(-2F, 2F, -2F, 4, 6, 4);
		tubeYNegative.setRotationPoint(0F, 16F, 0F);
		tubeYNegative.setTextureSize(32, 32);
		tubeYNegative.mirror = true;
		setRotation(tubeYNegative, 3.141593F, 0F, 0F);
		tubeYPositive = new ModelRenderer(this, 16, 0);
		tubeYPositive.addBox(-2F, 2F, -2F, 4, 6, 4);
		tubeYPositive.setRotationPoint(0F, 16F, 0F);
		tubeYPositive.setTextureSize(32, 32);
		tubeYPositive.mirror = true;
		setRotation(tubeYPositive, 0F, 0F, 0F);
		tubeXNegative = new ModelRenderer(this, 16, 0);
		tubeXNegative.addBox(-2F, 2F, -2F, 4, 6, 4);
		tubeXNegative.setRotationPoint(0F, 16F, 0F);
		tubeXNegative.setTextureSize(32, 32);
		tubeXNegative.mirror = true;
		setRotation(tubeXNegative, 0F, 0F, 1.570796F);
		tubeXPositive = new ModelRenderer(this, 16, 0);
		tubeXPositive.addBox(-2F, 2F, -2F, 4, 6, 4);
		tubeXPositive.setRotationPoint(0F, 16F, 0F);
		tubeXPositive.setTextureSize(32, 32);
		tubeXPositive.mirror = true;
		setRotation(tubeXPositive, 0F, 0F, -1.570796F);
		tubeZNegative = new ModelRenderer(this, 16, 0);
		tubeZNegative.addBox(-2F, 2F, -2F, 4, 6, 4);
		tubeZNegative.setRotationPoint(0F, 16F, 0F);
		tubeZNegative.setTextureSize(32, 32);
		tubeZNegative.mirror = true;
		setRotation(tubeZNegative, -1.570796F, 0F, 0F);
		tubeZPositive = new ModelRenderer(this, 16, 0);
		tubeZPositive.addBox(-2F, 2F, -2F, 4, 6, 4);
		tubeZPositive.setRotationPoint(0F, 16F, 0F);
		tubeZPositive.setTextureSize(32, 32);
		tubeZPositive.mirror = true;
		setRotation(tubeZPositive, 1.570796F, 0F, 0F);
		
	}
	
	public void renderAll(boolean xPos, boolean xNeg, boolean yPos, boolean yNeg, boolean zPos, boolean zNeg)
	{
		tubeCore.render(0.0625F);
		if (xPos)
			tubeXPositive.render(0.0625F);
		if (xNeg)
			tubeXNegative.render(0.0625F);
		if (yPos)
			tubeYPositive.render(0.0625F);
		if (yNeg)
			tubeYNegative.render(0.0625F);
		if (zPos)
			tubeZPositive.render(0.0625F);
		if (zNeg)
			tubeZNegative.render(0.0625F);
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}
