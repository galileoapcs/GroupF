import info.gridworld.actor.*;
import info.gridworld.grid.*;

import java.awt.Color;


public class TetrisBlockI extends TetrisBlock {


	protected int rotationPos;

	protected Grid<Actor> gr;


	public TetrisBlockI() {
		super();
		rotationPos = 0;
		gr = TetrisGame.world.getGrid();

		if (gr.get(new Location(3,5)) != null
						|| gr.get(new Location(4,5)) != null) {
			javax.swing.JOptionPane.showMessageDialog(null, "Score: "
					+ TetrisGame.score, "GAME OVER!", 0);
			System.exit(0);
		}

		TetrisBug b;
		TetrisBug c;
		b = new TetrisBug(Color.cyan);
		c = new TetrisBug(Color.green);
		b.putSelfInGrid(gr, new Location(3,5));
		c.putSelfInGrid(gr, new Location(4,5));
		blocks.add(b);
		blocks.add(c);

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
		if(blocks.get(1).canMove() && blocks.get(2).canMove())
		{
			blocks.get(2).move();
			blocks.get(1).move();
			blocks.get(0).move();
			move();
		}
	}

	public void moveLeft() {
		setDirection(-90);
		for (TetrisBug tb : blocks)
			tb.setDirection(-90);
		if(canMove() && blocks.get(0).canMove())
		{
			move();
			blocks.get(0).move();
			blocks.get(2).move();
			blocks.get(1).move();
		}
	}
	
	public void rotate() 
	{
		
	}
	
	
}