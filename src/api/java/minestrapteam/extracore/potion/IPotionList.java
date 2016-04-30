package minestrapteam.extracore.potion;

public interface IPotionList
{
	/**
	 * Constructs and initializes the {@link PotionType PotionTypes}.
	 */
	void initPotionTypes();
	
	/**
	 * Registers the {@link PotionType PotionTypes}.
	 */
	void loadPotionTypes();
}
