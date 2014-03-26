import info.gridworld.actor.*;
import info.gridworld.grid.*;

import java.awt.Color;


public class TetrisBlockT extends TetrisBlock {


	protected int rotationPos;

	protected Grid<Actor> gr;


	public TetrisBlockT() {
		super();
		rotationPos = 0;
		gr = TetrisGame.world.getGrid();

		if (gr.get(new Location(0,6)) != null
						|| gr.get(new Location(0,4)) != null) {
			javax.swing.JOptionPane.showMessageDialog(null, "Score: "
					+ TetrisGame.score, "GAME OVER!", 0);
			System.exit(0);
		}

		TetrisBug d;
		TetrisBug f;
		
		d = new TetrisBug(Color.yellow);
		f = new TetrisBug(Color.yellow);
		
		d.putSelfInGrid(gr, new Location(0, 6));
		f.putSelfInGrid(gr, new Location(0, 4));
		
		blocks.add(d);
		blocks.add(f);
		

	}


	public void act() {
		setDirection(180);
		for (TetrisBug tb : blocks)
			tb.setDirection(180);
		if (canMoveDown())
			moveDown();
		else if (!TetrisGame.currentBlock.canMoveDown())
			TetrisGame.nextTetrisBlock();
	}


	public void moveDown() {
			move();
			blocks.get(2).move();
			blocks.get(1).move();
			blocks.get(0).move();
	}


	public boolean canMoveDown() {
		return canMove() && blocks.get(2).canMove();
	}


	public void moveRight() {
		setDirection(90);
		for (TetrisBug tb : blocks)
			tb.setDirection(90);
		if(rotationPos == 0)
		{
			if(blocks.get(1).canMove())
			{
				blocks.get(1).move();
				blocks.get(0).move();
				move();
				blocks.get(2).move();
			}
		}
	}

	public void moveLeft() {
		setDirection(-90);
		for (TetrisBug tb : blocks)
			tb.setDirection(-90);
		if(rotationPos == 0)
		{
			if(blocks.get(2).canMove())
			{
			move();
			blocks.get(2).move();
			blocks.get(0).move();
			blocks.get(1).move();
			}
		}
	}
	
	public void rotate() 
	{
		Location nextLoc;
		Location currLoc;
		if (rotationPos == 0) {
			// only one block must move
			nextLoc = new Location(getLocation().getRow() - 1,
					getLocation().getCol() + 1);
			if (gr.isValid(nextLoc) && gr.get(nextLoc) == null) {
				moveTo(nextLoc);
				rotationPos = (rotationPos + 1) % 4;// will be % 4 with 4 blocks
			}
		} else if (rotationPos == 1) {

			// Your code goes here ... see Question 1
			nextLoc = new Location(getLocation().getRow() - 2,
					getLocation().getCol() + 2);
			
			if(blocks.get(2).canMove())
			{
				blocks.get(2).moveTo(new Location(0,5));
			}
			currLoc = new Location(getLocation().getRow() + 2, getLocation().getCol() - 2);
			if(gr.isValid(currLoc)&& gr.get(currLoc) == null)
			{
				moveTo(currLoc);
				rotationPos = (rotationPos + 2) % 4;
			}
			
		} else if(rotationPos == 2){
			
		}
	}
	
	
}
	
