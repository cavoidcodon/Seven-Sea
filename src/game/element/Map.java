package game.element;

public class Map {
	private char map[][];
	
	public Map() {
		map = new char[5][5];
	}
	
	public void setMap(PlayerShip playerShip, EnemyShip enemy1, EnemyShip enemy2, Island island) {
		for (int row = 0; row < 5; row ++) {
			for (int column = 0; column < 5; column ++) {
				map[row][column] = 'x';
			}
		}
		
		// set position for island in map, display by 'S'
		map[island.getPosition().getXPoint()][island.getPosition().getYPoint()] = 'S';
		
		// set position for player ship in map, display by '-' or '|'
		if (!playerShip.isSinked() && playerShip.getDirection() == 0) {
			map[playerShip.getPosition().getXPoint()][playerShip.getPosition().getYPoint()] = '-';
		}
		else if (!playerShip.isSinked() && playerShip.getDirection() == 1) {
			map[playerShip.getPosition().getXPoint()][playerShip.getPosition().getYPoint()] = '|';
		}
		
		// set position for enemy ship in map, display by 'E'
		if (!enemy1.isSinked()) {
			map[enemy1.getPosition().getXPoint()][enemy1.getPosition().getYPoint()] = 'E';
		}
		
		if (!enemy2.isSinked()) {
			map[enemy2.getPosition().getXPoint()][enemy2.getPosition().getYPoint()] = 'E';
		}
	}

	
	public void display() {
		for (char[] row : map) {
			for (char cell : row) {
				System.out.print(cell);
			}
			System.out.println();
		}
	}
}
