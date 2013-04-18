LEO Miner
========
LEO Miner, or Low Earth Orbit Miner, is a project meant to simulate a "laser" from space being used to mine in 
minecraft.  The goal of the project as of right now is to make:

1.  A laser "beam" block. this block will be both the visual beam as well as the mining device.  The block should
be able to appear at the highest point in the minecraft world, replicate itself all the way down to bedrock, place
any minable items into the inventory of the collector, and then dissipate after a period of time.

2.  A "Controllor" block.  This block will be used to designate the area of effect, calculate the power required
to mine the area, collect the power needed, and then once enough power is collected via (MJ/UE/etc) "fire" the 
laser beam.  While the beam is active it will then eject the items collected by the beam into an adjacent chest,
pipre, or into the world if the chest is full.

Optional/Future Plans

3.  A "Satellite" block.  This block will be a token block that simply works as a flag, its only function is to
act as a "Recipe" that the player must make and then "Launch" into space applying a "Flag" to the player so
that they can then use the mining system.

4.  Determining the "Maximum" area of effect based on the number of "Satellite" the player has launched.  For
instance one Satellite has a max mining area of 9x9, adding an additional Satellite increases the area to 9x18,
allowing the player to designate via the controllor a larger area to mine, up to a maximum size of 63x63.

5.  Consider adding/using "Solar Panels" in the satellite recipe to eliminate the need for power usage on the 
ground, and instead place a time limit on the use of satellite so that they have to "recharge" between uses.  This
would be shown in the Controllor GUI showing how many satellites the player has up, how many are charged and ready
to use, and how many are still charging.  This would allow a player to continue to launch satellites to not only
increase the the area they can mine but also how often they can mine.

LEO Miner
