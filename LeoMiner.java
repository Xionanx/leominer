package leominer;

import net.minecraft.block.Block;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = LEOMiner.modid, name = "LEO Miner", version = "0.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class LEOMiner
{
    public static final String modid = "Xionanx_LeoMiner";


    public static Block leolaserBeam;
    public static Block leolaserController;
    
    public static int leolaserControllerID;
    public static int leolaserBeamID;
    public static int laserTtl;
    
    @PreInit
    public void preInit(FMLPreInitializationEvent event)
    {
    	Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();
        leolaserBeamID = config.getBlock("leolaserBeam", 500).getInt();
        
        leolaserControllerID = config.getBlock("leolaserController", 501).getInt();
        
        laserTtl = config.get(Configuration.CATEGORY_GENERAL, "LaserTimeToLive", 60).getInt();
        
        
        config.save();
    }
    @Init
    public void load(FMLInitializationEvent event)
    {
        leolaserBeam = new LEOLaserBeam(leolaserBeamID).setUnlocalizedName("leolaserBeam");
        GameRegistry.registerBlock(leolaserBeam, modid + leolaserBeam.getUnlocalizedName2());
        LanguageRegistry.addName(leolaserBeam, "LEO Laser Block");

        leolaserController = new LEOLaserController(leolaserControllerID, 0).setUnlocalizedName("leolaserController");
        GameRegistry.registerBlock(leolaserController, modid + leolaserController.getUnlocalizedName2());
        LanguageRegistry.addName(leolaserController, "LEO Laser Controller");
       
    }
}

