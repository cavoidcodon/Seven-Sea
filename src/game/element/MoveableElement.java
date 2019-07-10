package game.element;

public class MoveableElement extends GeneralElement {
	protected boolean isSinked;
	
	public MoveableElement() {
		super();
		isSinked = false;
	}
	
	public void moveLeft() throws IndexOutOfBoundsException{
		if (!isSinked) {
			position.setPosition(position.getXPoint(), position.getYPoint() - 1);
		}
	}
	
	public void moveRight() throws IndexOutOfBoundsException {
		if (!isSinked) {
			position.setPosition(position.getXPoint(), position.getYPoint() + 1);
		}
	}
	
	public void moveUp() throws IndexOutOfBoundsException {
		if (!isSinked) {
			position.setPosition(position.getXPoint() - 1, position.getYPoint());
		}
	}
	
	public void moveDown() throws IndexOutOfBoundsException {
		if (!isSinked) {
			position.setPosition(position.getXPoint() + 1, position.getYPoint());
		}
	}
	
	public boolean isSinked() {
		return isSinked;
	}
	
	public void destroyed() {
		isSinked = true;
	}
}
