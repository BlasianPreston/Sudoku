import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Sudoku s = new Sudoku();
    boolean play = true;
    int warnings = 0;
    boolean game = false;
    while (play) {
      if (!game) {
        s.fillValues(); 
        System.out.println();
        s.finalBoard();
        s.print();
      }
      game = true;
      while (game) {
        System.out.println("Enter the row: ");
        int x = sc.nextInt();
        System.out.println("Enter the column: ");
        int y = sc.nextInt();
        if (s.check(x, y)) {
          warnings += s.play(x, y);
        }
        else {
          System.out.println("Your coordinates do not work.");
          warnings++;
        }
        if (s.win() == true) {
          System.out.println("Congratulations! You won!");
          System.out.println("Enter 1 if you wish to play again. Enter 0 to end the game.");
          int playerEnter = sc.nextInt();
          if (playerEnter != 0 && playerEnter != 1) {
            System.out.println("You must enter 1 to play again or 0 to end the game.");
            playerEnter = sc.nextInt();
          }
          if (playerEnter == 0) {
            play = false;
          }
          if (playerEnter == 1) {
            play = true;
            game = false;
            System.out.println("We will play again! Good luck!");
          }
        }
        if (s.lose(warnings) == true) {
          System.out.println("You lost. :(");
          System.out.println("Enter 1 if you wish to play again. Enter 0 to end the game.");
          int playerEnter = sc.nextInt();
          if (playerEnter != 0 && playerEnter != 1) {
            System.out.println("You must enter 1 to play again or 0 to end the game.");
            playerEnter = sc.nextInt();
          }
          if (playerEnter == 0) {
            play = false;
          }
          if (playerEnter == 1) {
            play = true;
            game = false;
            System.out.println("We will play again! Good luck!");
          }
        }
      }
    }
  }
}