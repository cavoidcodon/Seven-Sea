package game.element;

import java.util.Random;

public class EnemyShip extends MoveableElement {
	public void moveTowardsToPlayerShip(PlayerShip playerShip) {
		Random rand = new Random();
		
		int wayToMove = rand.nextInt(1); // 0 -> move horizontal
										// 1 -> move vertical
		
		// There are 8 case of enemy ship position compared to player ship
		if (position.getXPoint() < playerShip.getPosition().getXPoint() &&
			position.getYPoint() > playerShip.getPosition().getYPoint()) {
			if (wayToMove == 0) this.moveLeft();
			else this.moveDown();
		}
		else if (position.getXPoint() > playerShip.getPosition().getXPoint() &&
				 position.getYPoint() > playerShip.getPosition().getYPoint()) {
			if (wayToMove == 0) this.moveLeft();
			else this.moveUp();
		}
		else if (position.getXPoint() < playerShip.getPosition().getXPoint() &&
				 position.getYPoint() < playerShip.getPosition().getYPoint()) {
			if (wayToMove == 0) this.moveRight();
			else this.moveDown();
		}
		else if (position.getXPoint() > playerShip.getPosition().getXPoint() &&
				 position.getYPoint() < playerShip.getPosition().getYPoint()) {
			if (wayToMove == 0) this.moveRight();
			else this.moveUp();
		}
		else if (position.getXPoint() == playerShip.getPosition().getXPoint() &&
				position.getYPoint() > playerShip.getPosition().getYPoint()) {
			this.moveLeft();
		}
		else if (position.getXPoint() == playerShip.getPosition().getXPoint() &&
				 position.getYPoint() < playerShip.getPosition().getYPoint()) {
			this.moveRight();
		}
		else if (position.getXPoint() < playerShip.getPosition().getXPoint() &&
				 position.getYPoint() == playerShip.getPosition().getYPoint()) {
			this.moveDown();
		}
		else if (position.getXPoint() > playerShip.getPosition().getXPoint() &&
				 position.getYPoint() == playerShip.getPosition().getYPoint()) {
			this.moveUp();
		}
	}
}
