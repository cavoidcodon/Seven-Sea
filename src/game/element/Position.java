package game.element;

import java.util.Random;

public class Position {
	private int xPoint;
	private int yPoint;
	
	public Position() {
		Random rand = new Random();
		xPoint = rand.nextInt(5);
		yPoint = rand.nextInt(5);
	}
	
	public Position(int xNewValue, int yNewValue) {
		xPoint = xNewValue;
		yPoint = yNewValue;
	}
	
	public int getXPoint() {
		return xPoint;
	}
	
	public int getYPoint() {
		return yPoint;
	}
	
	public void setPosition(int xNewValue, int yNewValue) throws IndexOutOfBoundsException {
		if (xNewValue >= 0 && xNewValue < 5 &&
			yNewValue >= 0 && yNewValue < 5) {			
				xPoint = xNewValue;
				yPoint = yNewValue;
		}
		else {
			throw new IndexOutOfBoundsException();
		}
	}
	
	public boolean isSamePosition(Position position) {
		if (xPoint == position.getXPoint() &&
			yPoint == position.getYPoint()) 
				return true;
		else 
			return false;
	} 
}
