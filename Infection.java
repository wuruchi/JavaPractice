import java.lang.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

// Compile Infection.java
// Run java Infection N
// Where N is the size of the NxN board.
// The virus that infects its neighborhood and new infected members infect their neighborhoods recursively
public class Infection {
  public static void main(String[] args){
    // Side of square
    int m = Integer.parseInt(args[0]); 
    Solver sol = new Solver(m); 
    //sol.print_board();  
    sol.solve();
  }
}

class Solver {
  int side_length;
  int[][] board;
  boolean totally_infected;
  int[] current_position;
  Set<String> path;

  Solver(int m){
    this.side_length = m;
    this.board = new int[m][m];
    this.current_position = new int[2];
    this.totally_infected = false;
    this.path = new HashSet<String>();
    this.initialize_board();
    //this.solve();
  }

  public void solve() {
    this.start_solving(this.current_position);
    this.print_board(); 
    if (this.totally_infected == false) {
      System.out.println("Not Totally Infected.");
    } else {
      System.out.println("Totally Infected.");
    }
  } 

  private void start_solving(int[] position) {
    try {
      TimeUnit.SECONDS.sleep(1);
      int i_coordinate = position[0];
      int j_coordinate = position[1];
      this.path.add(i_coordinate + "-" + j_coordinate);
      this.print_board();    
     
      this.board[i_coordinate][j_coordinate] = 1;
      for (int i = i_coordinate - 1; i <= i_coordinate + 1; i++){
        for (int j = j_coordinate - 1; j <= j_coordinate + 1; j++){
          if ((i >= 0 && i < this.side_length) && (j >= 0 && j < this.side_length) && !(i_coordinate == i && j_coordinate == j) && (this.board[i][j] == 0)) {
            this.start_solving(new int[]{i,j});
          }
        }
      }

    } catch (Exception e) {
      System.out.println(e);
      //TODO: handle exception
    }
    
  }

  private void initialize_board(){
    this.totally_infected = true;
    for(int i = 0; i < this.side_length; i++){
      for(int j = 0; j < this.side_length; j++){
        this.board[i][j] = new Random().nextInt(2); 
        // There's a small probability that all cells are infected conditioned on the side_length
        // So we make sure to update totally_infect to keep track of this status
        if (this.board[i][j] == 0){
          this.totally_infected = false;
        }
      }
    }
    int i_coordinate = 0;
    int j_coordinate = 0;
    // Find the starting position
    while (true && this.totally_infected == false){
      i_coordinate = new Random().nextInt(this.side_length);
      j_coordinate = new Random().nextInt(this.side_length);
      if (this.board[i_coordinate][j_coordinate] == 0){
        this.current_position[0] = i_coordinate;
        this.current_position[1] = j_coordinate;
        break;
      }
    }
  }

  public void print_board() {
    this.totally_infected = true;
    System.out.println("\033[H\033[2J");
    System.out.println("Board Status: ");
    for(int i = 0; i < this.side_length; i++){
      for(int j = 0; j < this.side_length; j++){
        if (this.path.contains(i + "-" + j) == true){
          System.out.print("[" + this.board[i][j] + "]\t");
        } else {
          if (this.board[i][j] == 0) this.totally_infected = false;
          System.out.print(this.board[i][j] + "\t");
        }
        
      }
      System.out.println("\n");
    }
  }

}