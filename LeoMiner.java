package leominer;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = LeoMiner.modid, name = "LEO Miner", version = "0.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class LeoMiner 
{
	public static final String modid = "Xionanx_LeoMiner";
	
	public static Block leolaserBlock;
	
	@Init
	public void load(FMLInitializationEvent event)
	{
		leolaserBlock = new BlockLEOLaserBlock(500, Material.rock).setUnlocalizedName("leolaserBlock");
	
		GameRegistry.registerBlock(leolaserBlock, modid + leolaserBlock.getUnlocalizedName2());
		
		LanguageRegistry.addName(leolaserBlock, "LEO Laser Block");
	}
}
