package game.element;

public class PlayerShip extends MoveableElement {
	private int shipDirection; // 0 -> horizontal direction
							   // 1 true -> vertical direction
	
	public PlayerShip() {
		super();
		shipDirection = 0;
	}
	
	public int getDirection() {
		return shipDirection;
	}
	
	public void setHorizontalDirection() {
		shipDirection = 0;
	}
	
	public void setVerticalDirection() {
		shipDirection = 1;
	}
	
	public void fire(EnemyShip enemyShip) {
		if ( (enemyShip.getPosition().getXPoint() == position.getXPoint() && 
			 !enemyShip.isSinked() && shipDirection == 1 )                
				||
			 (enemyShip.getPosition().getYPoint() == position.getYPoint() &&
			 !enemyShip.isSinked() && shipDirection == 0 )     )
		{
			enemyShip.destroyed();	
		}
	}
}
