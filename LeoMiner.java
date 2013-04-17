package leominer;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = LeoMiner.modid, name = "LEO Miner", version = "0.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class LeoMiner
{
    public static final String modid = "Xionanx_LeoMiner";

    public static Block leolaserBlock;
    public static int leolaserBlockID;
    
    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
            Configuration config = new Configuration(event.getSuggestedConfigurationFile());

            config.load();

            int leolaserBlockID = config.getBlock("leolaserBlock", 500).getInt();       

            config.save();
    }

    
    @Init
    public void load(FMLInitializationEvent event)
    {
        leolaserBlock = new LEOLaserBlock(leolaserBlockID, Material.cactus).setUnlocalizedName("leolaserBlock");
        GameRegistry.registerBlock(leolaserBlock, modid + leolaserBlock.getUnlocalizedName2());
        LanguageRegistry.addName(leolaserBlock, "LEO Laser Block");
    }
    
    
   
}
