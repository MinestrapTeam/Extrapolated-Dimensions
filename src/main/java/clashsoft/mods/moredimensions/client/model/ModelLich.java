package clashsoft.mods.moredimensions.client.model;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelLich extends ModelBiped
{
	// fields
	ModelRenderer	head;
	ModelRenderer	body;
	ModelRenderer	leg1;
	ModelRenderer	leg2;
	ModelRenderer	leg3;
	ModelRenderer	leg4;
	
	public ModelLich()
	{
		this.textureWidth = 64;
		this.textureHeight = 32;
		
		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-4F, -4F, -8F, 8, 8, 8);
		this.head.setRotationPoint(0F, 12F, -6F);
		this.head.setTextureSize(64, 32);
		this.head.mirror = true;
		this.setRotation(this.head, 0F, 0F, 0F);
		this.body = new ModelRenderer(this, 28, 8);
		this.body.addBox(-5F, -10F, -7F, 10, 16, 8);
		this.body.setRotationPoint(0F, 11F, 3F);
		this.body.setTextureSize(64, 32);
		this.body.mirror = true;
		this.setRotation(this.body, 1.570796F, 0F, 0F);
		this.leg1 = new ModelRenderer(this, 0, 16);
		this.leg1.addBox(-2F, 0F, -2F, 4, 6, 4);
		this.leg1.setRotationPoint(-3F, 18F, 7F);
		this.leg1.setTextureSize(64, 32);
		this.leg1.mirror = true;
		this.setRotation(this.leg1, 0F, 0F, 0F);
		this.leg2 = new ModelRenderer(this, 0, 16);
		this.leg2.addBox(-2F, 0F, -2F, 4, 6, 4);
		this.leg2.setRotationPoint(3F, 18F, 7F);
		this.leg2.setTextureSize(64, 32);
		this.leg2.mirror = true;
		this.setRotation(this.leg2, 0F, 0F, 0F);
		this.leg3 = new ModelRenderer(this, 0, 16);
		this.leg3.addBox(-2F, 18F, -2F, 4, 6, 4);
		this.leg3.setRotationPoint(-3F, 0F, -5F);
		this.leg3.setTextureSize(64, 32);
		this.leg3.mirror = true;
		this.setRotation(this.leg3, 0F, 0F, 0F);
		this.leg4 = new ModelRenderer(this, 0, 16);
		this.leg4.addBox(-2F, 0F, -2F, 4, 6, 4);
		this.leg4.setRotationPoint(3F, 18F, -5F);
		this.leg4.setTextureSize(64, 32);
		this.leg4.mirror = true;
		this.setRotation(this.leg4, 0F, 0F, 0F);
	}
	
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.head.render(f5);
		this.body.render(f5);
		this.leg1.render(f5);
		this.leg2.render(f5);
		this.leg3.render(f5);
		this.leg4.render(f5);
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
	
	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}
	
}
