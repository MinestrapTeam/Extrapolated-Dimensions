package minestrapteam.extracore.crafting.loader;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.Arrays;

public abstract class CustomRecipeLoader
{
	public static File customPluginsDir = new File("custom-plugins");

	static
	{
		customPluginsDir.mkdirs();

		File readme = new File(customPluginsDir, "readme.txt");
		try
		{
			readme.createNewFile();
			FileUtils.writeLines(readme, Arrays.asList("Custom-Plugins Directory Readme File"));
		}
		catch (IOException ex)
		{
		}
	}

	public String type;

	public CustomRecipeLoader(String type)
	{
		this.type = type;
	}

	public void load()
	{
		try
		{
			File[] files = customPluginsDir.listFiles();

			if (files != null)
			{
				for (File file : files)
				{
					if (!file.getName().startsWith(this.type))
					{
						continue;
					}

					FileInputStream stream = new FileInputStream(file);
					DataInputStream in = new DataInputStream(stream);
					BufferedReader br = new BufferedReader(new InputStreamReader(in));
					System.out.println("Loading " + this.type + " recipes from: " + file);

					String line;
					while ((line = br.readLine()) != null)
					{
						this.processLine(line);
					}
					br.close();
				}
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void processLine(String line)
	{
		line = line.toLowerCase().replaceAll(" ", "");

		if (!line.isEmpty())
		{
			String[] split = line.split("\\s*;\\s*");

			String input = null;
			int inputMeta = 0;
			String output = null;
			int outputMeta = 0;
			int amount = 1;
			float exp = 1F;

			for (String s : split)
			{
				if (s.startsWith("input="))
				{
					input = s.substring(6);
				}
				else if (s.startsWith("input_meta="))
				{
					inputMeta = Integer.parseInt(s.substring(11));
				}
				else if (s.startsWith("output="))
				{
					output = s.substring(7);
				}
				else if (s.startsWith("output_meta="))
				{
					outputMeta = Integer.parseInt(s.substring(12));
				}
				else if (s.startsWith("amount="))
				{
					amount = Integer.parseInt(s.substring(7));
				}
				else if (s.startsWith("exp="))
				{
					exp = Float.parseFloat(s.substring(4));
				}
			}

			if (input != null && output != null)
			{
				this.addRecipe(GameRegistry.makeItemStack(input, inputMeta, 1, null),
				               GameRegistry.makeItemStack(output, outputMeta, amount, null), exp);
			}
		}
	}

	public abstract void addRecipe(ItemStack input, ItemStack output, float exp);
}
