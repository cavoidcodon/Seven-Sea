package game.element;

public class GeneralElement {
	protected Position position;
	
	public GeneralElement() {
		position = new Position();
	}
	
	public Position getPosition() {
		return position;
	}
	
	public void setPosition(int xNewValue, int yNewValue) throws IndexOutOfBoundsException{
		position.setPosition(xNewValue, yNewValue);
	}
}
