public class KnightTour{
  static int N = 8;

  static void printSolution(int sol[][]) {
    for (int x = 0; x < N; x++) {
      for (int y = 0; y < N; y++)
        System.out.print(sol[x][y] + " ");
      System.out.println();
    }
  }

  static boolean isBoundaryValid(int x, int y, int sol[][]){
    return (x>=0 && x<N && y>=0 && y<N && sol[x][y] == -1);
  }

  static void solveKT(){
  int sol[][] = new int[8][8];

// Moves are important
    int xmove[] = {2, 1, -1, -2, -2, -1, 1, 2};
    int ymove[] = {1, 2, 2, 1, -1, -2, -2, -1};

    //  initialization
  for(int i=0; i<N; i++){
    for(int j=0; j<N; j++)
      sol[i][j] = -1;
  }
    sol[0][0] = 0;

      if (!solveKTUtil(0, 0, xmove, ymove, 1, sol)) {
      System.out.println("Solution does not exist");
    } else
      {
        printSolution(sol);
      }

  }

  static boolean solveKTUtil(int x, int y, int xmove[], int ymove[], int knight, int sol[][] ){
     int next_x, next_y;
    if(knight == N*N)
      return true;

    for(int k=0; k<8; k++)
   {
     next_x = x + xmove[k];
     next_y = y + ymove[k];

     if (isBoundaryValid(next_x, next_y, sol))
     {
       sol[next_x][next_y] = knight;
       if(solveKTUtil(next_x, next_y, xmove, ymove, knight+1, sol))
       {
         return true;
       }else{
         sol[next_x][next_y] = -1;
       }
     }

   }
    return false;
  }
  public static void main(String args[]) {
    solveKT();
  }
}