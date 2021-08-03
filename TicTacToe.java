import java.util.Scanner;

public class TicTacToe {
  public static Scanner input = new Scanner(System.in);
  
  // Main method calls the methods and controls the flow of the game
  public static void main(String[] args) {
	  
	// Create 3x3 array that represents the game  
	char[][] board = new char[3][3];
    drawBoard(board);

    boolean over = false;
    
    // While loop keeps the game going
    while (!over) {
      
      // Prompt the first player
      getMove(board, 'X');
      
      drawBoard(board);
      
      over = checkState('X', board);
      
      if (over)
    	  break;
     
      // Prompt the second player
      getMove(board, 'O');
      
      drawBoard(board);

      over = checkState('O', board);
    }
  }

  // drawBoard draws the game board after every move
  public static void drawBoard(char[][] board) {
    System.out.println("\n-------------");

    for (int i = 0; i < 3; i++) {
      System.out.print("| ");
      for (int j = 0; j < 3; j++)
        System.out.print(board[i][j] != '\u0000' ?  board[i][j] + " | ": "  | ");
      System.out.println("\n-------------");
    }
  }
  
  // getMove gets the players input
  public static void getMove(char[][] board, char player) { 
    boolean done = false;
    
    // While loop keeps going until a legal play has been made
    while (!done) {
      
      System.out.print("Enter a row (1, 2, or 3) for player " + player + ": ");
      int row = input.nextInt() - 1;
      System.out.print("Enter a column (1, 2, or 3) for player " + player + ": ");
      int column = input.nextInt() - 1;
    
      // Checks for valid move
      if (row < 0 || row > 2 || column < 0 || column > 2) {
    	  System.out.println("Invalid input. Try again");
    	  continue;
      }
      
      // Checks if the cell is occupied
      if (board[row][column] == '\u0000') { // an empty cell
        board[row][column] = player;
        done = true;
      }
      else 
        System.out.println("This cell is already occupied. Try a different cell");
    }
  }
  

  // checkState checks the game state to see if there is a winner
  public static boolean checkState(char ch, char[][] board) {  
	// Check rows
    for (int i = 0; i < 3; i++) {
      if (ch == board[i][0] && ch == board[i][1] && ch == board[i][2]) {
    	  System.out.println(ch + " player won");
    	  return true;
      }
    }    
    // Check columns
    for (int j = 0; j < 3; j++) {
      if (ch == board[0][j] && ch == board[1][j] && ch == board[2][j]) {
    	  System.out.println(ch + " player won");
    	  return true;
      }
    }   
    // Check major diagonal
    if (ch == board[0][0] && ch == board[1][1] && ch == board[2][2]) {
    	System.out.println(ch + " player won");
    	return true;
    }
    // Check sub diagonal
    if (ch == board[0][2] && ch == board[1][1] && ch == board[2][0]) {
    	System.out.println(ch + " player won");
    	return true;
    }
 
    // Check for a draw
    boolean draw = true;
    for (int i = 0; i < 3; i++) {
       for (int j = 0; j < 3; j++) {
          if (board[i][j] == '\u0000') {
        	  draw = false;
        	  break;
          }
       }
    }
    if (draw) {
    	System.out.println("No winner");
    	return true;
    }
    
    return false;
  }
}
