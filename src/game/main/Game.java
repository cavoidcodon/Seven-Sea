package game.main;

import game.element.*;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Game {
	private Map gameMap;
	private PlayerShip playerShip;
	private EnemyShip enemyShip1, enemyShip2;
	private Island island;
	private boolean isFinish;
	private boolean isOver;
	
	public Game() throws IndexOutOfBoundsException{
		gameMap = new Map();
		playerShip = new PlayerShip();
		enemyShip1 = new EnemyShip();
		enemyShip2 = new EnemyShip();
		island = new Island();
		isFinish = false;
		isOver = false;
		
		
		// random distinct element position
		Random rand = new Random();
		Vector<Integer> positionCollection = new Vector<Integer>();
		int iNew = 0;
		for (int i = 0; i < 4; ) {
			iNew = rand.nextInt(25);
			if (!positionCollection.contains(iNew)) {
				i ++;
				positionCollection.add(iNew);
			}
		}	
		playerShip.setPosition(positionCollection.get(0)/5, positionCollection.get(0)%5);
		enemyShip1.setPosition(positionCollection.get(1)/5, positionCollection.get(1)%5);
		enemyShip2.setPosition(positionCollection.get(2)/5, positionCollection.get(2)%5);
		island.setPosition(positionCollection.get(3)/5, positionCollection.get(3)%5);
		
		
		gameMap.setMap(playerShip, enemyShip1, enemyShip2, island);
	}
	
	public void start() throws IndexOutOfBoundsException{
		gameMap.display();
		
		Scanner input = new Scanner(System.in);
		while (!isOver && !isFinish) {
			
			// input control key 'A', 'W', 'D', 'S'
			System.out.println("Next Step: ");
			String inputString = input.nextLine();
			inputString.toUpperCase();
			char controlKey = inputString.charAt(0);
			
			switch(controlKey) 
			{
				case 'A':
					playerShip.moveLeft();
					playerShip.setHorizontalDirection();
					break;
				case 'W':
					playerShip.moveUp();
					playerShip.setVerticalDirection();
					break;
				case 'D':
					playerShip.moveRight();
					playerShip.setHorizontalDirection();
					break;
				case 'S':
					playerShip.moveDown();
					playerShip.setVerticalDirection();
					break;
				case 'F':
					playerShip.fire(enemyShip1);
					playerShip.fire(enemyShip2);
					break;
				default:
					System.out.println("Invalid Control Key !");				
			}
			
			// behaves of enemy ship after player ship move
			if (controlKey == 'A' || controlKey == 'D' ||
				controlKey == 'W' || controlKey == 'S') {
				
				enemyShip1.moveTowardsToPlayerShip(playerShip);
				enemyShip2.moveTowardsToPlayerShip(playerShip);
				
				
				if (enemyShip1.getPosition().isSamePosition(island.getPosition()))
					enemyShip1.destroyed();
				if (enemyShip2.getPosition().isSamePosition(island.getPosition()))
					enemyShip2.destroyed();
				
				if (enemyShip1.getPosition().isSamePosition(playerShip.getPosition()) ||
					enemyShip2.getPosition().isSamePosition(playerShip.getPosition())) {
					isOver = true;
				}
				
				if (playerShip.getPosition().isSamePosition(island.getPosition())) {
					playerShip.destroyed();
					isOver = true;
				}
			}
			
			// win
			if (enemyShip1.isSinked() && enemyShip2.isSinked())
				isFinish = true;
			
			// reset map and display
			gameMap.setMap(playerShip, enemyShip1, enemyShip2, island);
			gameMap.display();
		}
		
		if (isFinish) {
			System.out.println("You Won !!!!");
		}
		else {
			System.out.println("Game Over !");
		}
		
		input.close();
	}
}
