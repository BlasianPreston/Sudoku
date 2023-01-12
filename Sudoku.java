import java.util.Scanner;

public class Sudoku {
  int[] board[]; int[] fboard[]; 
  Sudoku() {   
    board = new int[9][9]; 
    fboard = new int[9][9];
  } 
  public void fillValues() { 
    for (int i = 0; i < 9; i = i + 3){
      int num; 
      for (int k = 0; k < 3; k++) { 
        for (int j = 0; j < 3; j++) {
          num = (int) Math.floor((Math.random() * 9 + 1));
          while(!notInArea(i, i, num)){
            num = (int) Math.floor((Math.random() * 9 + 1));
          }
           
          board[i + k][i + j] = num; 
        } 
      } 
    } 
    
    fillRest(0, 3); 
  
    }
  boolean fillRest(int i, int j) { 
    if (j >= 9 && i < 8) { 
      i += 1; j = 0;} 
    if (i >= 9 && j >= 9) 
      return true; 
    if (i < 3) { 
      if (j < 3) j = 3; } 
    else if (i < 6) { 
      if (j == (int) (i/3) * 3) j += 3;} 
    else{ 
      if (j == 6) { 
        i += 1;j = 0; 
        if (i >= 9) return true; } 
    } 

    for (int num = 1; num <= 9; num++) { 
      if ((!inRow(i, num) && !inCol(j, num) && notInArea(i-i % 3, j-j % 3, num))) { 
        board[i][j] = num; 
        if (fillRest(i, j + 1)) return true; 
        board[i][j] = 0; 
      } 
    } 
    return false; 
  } 

  boolean inRow(int i,int num) { 
    for (int j = 0; j < 9; j++) 
     if (board[i][j] == num) 
      return true; 
    return false; 
    }
  boolean inCol(int j,int num) { 
    for (int i = 0; i < 9; i++) 
      if (board[i][j] == num) 
        return true; 
    return false; 
    } 
  boolean notInArea(int rowStart, int colStart, int num) { 
    for (int i = 0; i < 3; i++) 
      for (int j = 0; j < 3; j++) 
        if (board[rowStart+i][colStart+j]==num) 
          return false; 
  
      return true; 
    } 
  public void finalBoard(){
    fboard = board;
    int num = 0;
    for (int i = 0; i < 9; i++) {
      while (num < 2){
      for (int j = 0; j < 9; j++){
      if (( (int) (Math.random() * 2 + 1) == 1) && fboard[i][j] != 0){fboard[i][j] = 0;num++;}
      if (num >= 6)break;
      }
      
    }num=0;
  }
  }

  public void print() { 
    System.out.println("  0 1 2  3 4 5  6 7 8");
    int c = 0;
    for (int i = 0; i < 9; i++) { 
      if(i % 3 == 0)System.out.println("  --------------------");
      System.out.print (c);
      for (int j = 0; j < 9; j++){ 
        if(j % 3 == 0)System.out.print("|");
        System.out.print(fboard[i][j] + " "); 
        
      }
      System.out.print("|");
      System.out.println(); 
      c++;
    } 
    System.out.println("  --------------------");
    System.out.println(); 
  }

  public boolean check (int x, int y) {
    if (board[x][y] != 0) {
      return false;
    }
    return true;
  }
  
  public int play(int x, int y) {
    Scanner sc = new Scanner(System.in);
    System.out.println ("Enter a number.");
    int num = sc.nextInt();
    if (inRow(x, num) || inCol(y,num)) {
      System.out.println ("Enter a different number."); 
      return 1;
    }
    board[x][y] = num;
    print();
    return 0;
  }

  public boolean win() {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] == 0) {
          return false;
        }
      }
    }
    return true;
  }

  public boolean lose(int warnings) {
    return (warnings == 3);
  }
}