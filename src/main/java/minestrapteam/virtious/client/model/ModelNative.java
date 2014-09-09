package minestrapteam.virtious.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelNative extends ModelBase
{
	ModelRenderer	LegRightBottom;
	ModelRenderer	LegLeftBottom;
	ModelRenderer	LegRightTop;
	ModelRenderer	LegLeftTop;
	ModelRenderer	Body;
	ModelRenderer	ArmRight;
	ModelRenderer	ArmLeft;
	ModelRenderer	ArmLeftClawLeft;
	ModelRenderer	ArmLeftClawRight;
	ModelRenderer	ArmRightClawLeft;
	ModelRenderer	ArmRightClawRight;
	ModelRenderer	Neck;
	ModelRenderer	Jaw;
	ModelRenderer	Head;
	ModelRenderer	TailBase;
	ModelRenderer	TailCenter;
	ModelRenderer	TailEnd;
	
	public ModelNative()
	{
		this.textureWidth = 64;
		this.textureHeight = 32;
		
		this.LegRightBottom = new ModelRenderer(this, 28, 0);
		this.LegRightBottom.addBox(0F, 0F, 0F, 1, 12, 1);
		this.LegRightBottom.setRotationPoint(-4F, 13F, -3F);
		this.LegRightBottom.setTextureSize(64, 32);
		this.LegRightBottom.mirror = true;
		setRotation(this.LegRightBottom, 0.2792527F, 0F, 0F);
		this.LegLeftBottom = new ModelRenderer(this, 28, 0);
		this.LegLeftBottom.addBox(0F, 0F, 0F, 1, 12, 1);
		this.LegLeftBottom.setRotationPoint(3F, 13F, -3F);
		this.LegLeftBottom.setTextureSize(64, 32);
		this.LegLeftBottom.mirror = true;
		setRotation(this.LegLeftBottom, 0.2792527F, 0F, 0F);
		this.LegRightTop = new ModelRenderer(this, 20, 0);
		this.LegRightTop.addBox(0F, 0F, 0F, 2, 10, 2);
		this.LegRightTop.setRotationPoint(-4.5F, 4F, -1F);
		this.LegRightTop.setTextureSize(64, 32);
		this.LegRightTop.mirror = true;
		setRotation(this.LegRightTop, -0.2792527F, 0F, 0F);
		this.LegLeftTop = new ModelRenderer(this, 20, 0);
		this.LegLeftTop.addBox(0F, 0F, 0F, 2, 10, 2);
		this.LegLeftTop.setRotationPoint(2.5F, 4F, -1F);
		this.LegLeftTop.setTextureSize(64, 32);
		this.LegLeftTop.mirror = true;
		setRotation(this.LegLeftTop, -0.2792527F, 0F, 0F);
		this.Body = new ModelRenderer(this, 0, 0);
		this.Body.addBox(0F, 0F, 0F, 6, 8, 4);
		this.Body.setRotationPoint(-3F, -2F, -3F);
		this.Body.setTextureSize(64, 32);
		this.Body.mirror = true;
		setRotation(this.Body, 0.1745329F, 0F, 0F);
		this.ArmRight = new ModelRenderer(this, 32, 0);
		this.ArmRight.addBox(0F, 0F, 0F, 2, 6, 2);
		this.ArmRight.setRotationPoint(-4F, 0F, 0F);
		this.ArmRight.setTextureSize(64, 32);
		this.ArmRight.mirror = true;
		setRotation(this.ArmRight, -1.658063F, 0F, 0F);
		this.ArmLeft = new ModelRenderer(this, 32, 0);
		this.ArmLeft.addBox(0F, 0F, 0F, 2, 6, 2);
		this.ArmLeft.setRotationPoint(2F, 0F, 0F);
		this.ArmLeft.setTextureSize(64, 32);
		this.ArmLeft.mirror = true;
		setRotation(this.ArmLeft, -1.658063F, 0F, 0F);
		this.ArmLeftClawLeft = new ModelRenderer(this, 40, 0);
		this.ArmLeftClawLeft.addBox(0F, 0F, 0F, 1, 2, 1);
		this.ArmLeftClawLeft.setRotationPoint(-4.5F, 0F, -6F);
		this.ArmLeftClawLeft.setTextureSize(64, 32);
		this.ArmLeftClawLeft.mirror = true;
		setRotation(this.ArmLeftClawLeft, -0.5410521F, 0F, 0F);
		this.ArmLeftClawRight = new ModelRenderer(this, 40, 0);
		this.ArmLeftClawRight.addBox(0F, 0F, 0F, 1, 2, 1);
		this.ArmLeftClawRight.setRotationPoint(-3F, 0F, -6F);
		this.ArmLeftClawRight.setTextureSize(64, 32);
		this.ArmLeftClawRight.mirror = true;
		setRotation(this.ArmLeftClawRight, -0.5410521F, 0F, 0F);
		this.ArmRightClawLeft = new ModelRenderer(this, 40, 0);
		this.ArmRightClawLeft.addBox(0F, 0F, 0F, 1, 2, 1);
		this.ArmRightClawLeft.setRotationPoint(2F, 0F, -6F);
		this.ArmRightClawLeft.setTextureSize(64, 32);
		this.ArmRightClawLeft.mirror = true;
		setRotation(this.ArmRightClawLeft, -0.5410521F, 0F, 0F);
		this.ArmRightClawRight = new ModelRenderer(this, 40, 0);
		this.ArmRightClawRight.addBox(0F, 0F, 0F, 1, 2, 1);
		this.ArmRightClawRight.setRotationPoint(3.5F, 0F, -6F);
		this.ArmRightClawRight.setTextureSize(64, 32);
		this.ArmRightClawRight.mirror = true;
		setRotation(this.ArmRightClawRight, -0.5410521F, 0F, 0F);
		this.Neck = new ModelRenderer(this, 44, 0);
		this.Neck.addBox(0F, 0F, 0F, 2, 3, 2);
		this.Neck.setRotationPoint(-1F, -3F, -4F);
		this.Neck.setTextureSize(64, 32);
		this.Neck.mirror = true;
		setRotation(this.Neck, 0.4712389F, 0F, 0F);
		this.Jaw = new ModelRenderer(this, 16, 13);
		this.Jaw.addBox(0F, 0F, 0F, 6, 1, 6);
		this.Jaw.setRotationPoint(-3F, -3F, -7F);
		this.Jaw.setTextureSize(64, 32);
		this.Jaw.mirror = true;
		setRotation(this.Jaw, 0.1745329F, 0F, 0F);
		this.Head = new ModelRenderer(this, 16, 20);
		this.Head.addBox(0F, 0F, 0F, 5, 3, 5);
		this.Head.setRotationPoint(-2.5F, -6F, -6.5F);
		this.Head.setTextureSize(64, 32);
		this.Head.mirror = true;
		setRotation(this.Head, 0.1745329F, 0F, 0F);
		this.TailBase = new ModelRenderer(this, 0, 12);
		this.TailBase.addBox(0F, 0F, 0F, 3, 3, 5);
		this.TailBase.setRotationPoint(-1.5F, 3F, 1F);
		this.TailBase.setTextureSize(64, 32);
		this.TailBase.mirror = true;
		setRotation(this.TailBase, -0.4886922F, 0F, 0F);
		this.TailCenter = new ModelRenderer(this, 0, 20);
		this.TailCenter.addBox(0F, 0F, 0F, 2, 2, 5);
		this.TailCenter.setRotationPoint(-1F, 5.5F, 4F);
		this.TailCenter.setTextureSize(64, 32);
		this.TailCenter.mirror = true;
		setRotation(this.TailCenter, -0.2792527F, 0F, 0F);
		this.TailEnd = new ModelRenderer(this, 0, 27);
		this.TailEnd.addBox(0F, 0F, 0F, 1, 1, 4);
		this.TailEnd.setRotationPoint(-0.5F, 7F, 8F);
		this.TailEnd.setTextureSize(64, 32);
		this.TailEnd.mirror = true;
		setRotation(this.TailEnd, 0F, 0F, 0F);
	}
	
	@Override
	public void render(Entity entity, float x, float y, float z, float yaw, float pitch, float partialTickTime)
	{
		super.render(entity, x, y, z, yaw, pitch, partialTickTime);
		setRotationAngles(x, y, z, yaw, pitch, partialTickTime, entity);
		this.LegRightBottom.render(partialTickTime);
		this.LegLeftBottom.render(partialTickTime);
		this.LegRightTop.render(partialTickTime);
		this.LegLeftTop.render(partialTickTime);
		this.Body.render(partialTickTime);
		this.ArmRight.render(partialTickTime);
		this.ArmLeft.render(partialTickTime);
		this.ArmLeftClawLeft.render(partialTickTime);
		this.ArmLeftClawRight.render(partialTickTime);
		this.ArmRightClawLeft.render(partialTickTime);
		this.ArmRightClawRight.render(partialTickTime);
		this.Neck.render(partialTickTime);
		this.Jaw.render(partialTickTime);
		this.Head.render(partialTickTime);
		this.TailBase.render(partialTickTime);
		this.TailCenter.render(partialTickTime);
		this.TailEnd.render(partialTickTime);
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
	
	@Override
	public void setRotationAngles(float x, float y, float z, float yaw, float pitch, float partialTickTime, Entity entity)
	{
		super.setRotationAngles(x, y, z, yaw, pitch, partialTickTime, entity);
		
		// LegLeftTop.rotateAngleX = -0.2792527F + MathHelper.cos(f * 0.3332F) *
		// 1.2F * f1;
		// LegRightTop.rotateAngleX = -0.2792527F + MathHelper.cos(f * 0.3332F +
		// 3.141593F) * f1;
		// LegLeftBottom.rotateAngleX = 0.2792527F + LegLeftTop.rotateAngleX;
		// LegRightBottom.rotateAngleX = 0.2792527F + LegRightTop.rotateAngleX;
		
		// TailBase.rotateAngleY = MathHelper.cos(f * 0.6662F) * 1.2F * f1;
		// TailCenter.rotateAngleY = MathHelper.cos(f * 0.6662F) * 1.2F * f1 +
		// TailBase.rotateAngleY;
		// TailEnd.rotateAngleY = MathHelper.cos(f * 0.6662F) * 1.2F * f1 +
		// TailCenter.rotateAngleY;
	}
}
