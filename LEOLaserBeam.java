package leominer;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;

public class LEOLaserBeam extends Block

{    
	public int ticks = 0;
	public LEOLaserBeam(int par1)
	{
		super(par1, Material.cactus);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
	public boolean isBlockBurning(World par1world, int par2, int par3, int par4)
	{
		return true;
    }
    
	 /**
     * How many world ticks before ticking
     */
    public int tickRate(World par1World)
    {
        return 10;
    }
    
    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
    	ticks++;
		if (ticks > LEOMiner.laserTtl)
		{
			par1World.setBlock(par2, par3, par4, 0);
		}
    	
    }

    
    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate(par1World));
        /**
         * Check the block below and if its bedrock, cease to exist
         */
        if (par1World.getBlockId(par2, par3-1, par4) == 7)
        {
        	par1World.setBlock(par2, par3, par4, 0);
        }
        else
        /**
         * if its not bedrock replace the block below with copy of LEOLaserBeam.
         */
        par1World.setBlock(par2, par3-1, par4, LEOMiner.leolaserBeamID);
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
        par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate(par1World));
    }

    
}
