import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;
import info.gridworld.actor.Bug;

public class JumperBug extends Bug
{
    
    public JumperBug()
    {
        setColor(Color.cyan);
    }

    public void act()
    {
        if(canJump() == true)
        {
        	jump();
        }
        else if(canMove() == true)
        {
        	move();
        }
        else
        {
        	turn();
        }
    	
    }
    
    public void turn()
    {
    	setDirection(getDirection() + Location.HALF_RIGHT);
    }
    
    public boolean canJump()
    {
    	Grid<Actor> gr = getGrid();
    	if(gr == null)
    	{
    		return false;
    	}
    	Location loc = getLocation();
    	Location loc2 = loc.getAdjacentLocation(getDirection());
    	Location next2 = loc2.getAdjacentLocation(getDirection());
    	if(!gr.isValid(next2))
    	{
    		return false;
    	}
    	Actor neighbor2 = gr.get(next2);
    	return (neighbor2 == null);
    }
    
    public void jump()
    {
    	Grid<Actor> gr = getGrid();
    	if(gr == null)
    	{
    		return;
    	}
    	Location loc = getLocation();
    	Location loc2 = loc.getAdjacentLocation(getDirection());
    	Location next2 = loc2.getAdjacentLocation(getDirection());
    	if(gr.isValid(next2))
    	{
    		moveTo(next2);
    	}
    	else
    	{
    		removeSelfFromGrid();
    	}
    }
    
}
