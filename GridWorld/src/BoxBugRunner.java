/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 */

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;
import java.awt.Color;

/**
 * This class runs a world that contains box bugs. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class BoxBugRunner
{
	public static int[] array = {1,5,4,6,2};
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        JumperBug bob = new JumperBug();
        Rock a = new Rock();
        Flower b = new Flower();
        world.add(b);
        world.add(a);
        world.add(new Location(5, 5), bob);
        world.show();
    }
}