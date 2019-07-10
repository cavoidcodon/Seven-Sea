package game.main;

public class Main {

	public static void main(String[] args) {
		Game sevenSeaGame = new Game();
		try {
			sevenSeaGame.start();
		}
		catch (IndexOutOfBoundsException err) {
			System.out.println("You can not go out of map !");
			System.out.println("Game Over !");
		}
	}

}
