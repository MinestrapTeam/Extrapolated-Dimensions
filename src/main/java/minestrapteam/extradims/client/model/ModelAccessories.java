package minestrapteam.extradims.client.model;

import net.minecraft.client.model.ModelBiped;

public class ModelAccessories extends ModelBiped
{
	public ModelAccessories()
	{
		super(0.25F);
	}

	public void renderArms(float partialTickTime)
	{
		this.bipedLeftArm.render(partialTickTime);
		this.bipedRightArm.render(partialTickTime);
	}

	public void renderBody(float partialTickTime)
	{
		this.bipedBody.render(partialTickTime);
	}
}
