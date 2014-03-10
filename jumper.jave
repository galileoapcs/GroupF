import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;

import info.gridworld.actor.Bug;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;


public class Jumper extends Bug {

	/**
	 * @param args
	 */
	private int steps;
    private int sideLength;

    /**
     * Constructs a box bug that traces a square of a given side length
     * @param length the side length
     */
    public Jumper()
    {
    }

    public void move()
    {
    	Grid<Actor> gr = getGrid(); 
    	if (gr == null) 
    		return; 
    	Location loc = getLocation(); 
    	Location next = loc.getAdjacentLocation(getDirection()); 
    	if (gr.isValid(next)) 
    		moveTo(next); 
    	else 
    		removeSelfFromGrid();
    }
 
    public boolean canMove() 
    { 
    	Grid<Actor> gr = getGrid(); 
    	if (gr == null) 
    		return false; 
    	Location loc = getLocation(); 
    	Location next = loc.getAdjacentLocation(getDirection()); 
    	Location p=next.getAdjacentLocation(getDirection());
    	if (!gr.isValid(p)) 
    		return false; 
    	Actor neighbor = gr.get(next); 
    	Actor neighborneighbor = gr.get(p);
    	if (neighborneighbor instanceof Rock){
    		return false;	
    	}
    	return (neighbor == null); 
    }
   
    /**
     * Moves to the next location of the square.
     */
    public void act()
    {
    	Grid<Actor> gr = getGrid(); 
    	Location loc = getLocation(); 
    	Location next = loc.getAdjacentLocation(getDirection()); 
    	Location p=next.getAdjacentLocation(getDirection());
    	Actor neighbor = gr.get(next); 
        if (canMove())
        {
            move();
            move();
        }
        else if (neighbor instanceof Rock || neighbor instanceof Flower){
        	this.moveTo(p);
        }

        else
        {
            turn();
            turn();
        }
    }

}
