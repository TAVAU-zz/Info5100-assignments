/* good work
 * score 30 + extra credit 7
 */
package MidTermPartB;
import java.util.*;

class Cell {
    int x, y;
    Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "[" + this.x + ", " + this.y + "]";
    }
}

public class Solution5 {
    public static void main(String[] args) {
        ArrayList<Cell> result = new ArrayList<>();
        Solution5 rat = new Solution5();
        int maze[][] = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };
        result = rat.findPath(maze);
        for (Cell c: result) {
            System.out.println(c);
        }
    }
    public ArrayList<Cell> findPath(int[][] maze) { //you fixed the maze, but you should find path for any maze that is passed
        ArrayList<Cell> res = new ArrayList<Cell>();
        int n = maze.length;
        int sol[][] = {{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        if (solveMazeUtil(maze, 0, 0, sol, n, res) == false)
        {
            System.out.print("Solution doesn't exist");
            return res;
        }
        res.add(new Cell(n - 1, n - 1));
        return res;
    }
    boolean solveMazeUtil(int maze[][], int x, int y,
                          int sol[][], int n, ArrayList<Cell> res)
    {
        // if (x,y is goal) return true
        if (x == n - 1 && y == n - 1)
        {
            sol[x][y] = 1;
            return true;
        }

        // Check if maze[x][y] is valid
        if (isSafe(maze, x, y, n) == true)
        {
            // mark x,y as part of solution path
            sol[x][y] = 1;
            res.add(new Cell(x,y));
            /* Move forward in x direction */
            if (solveMazeUtil(maze, x + 1, y, sol, n, res))
                return true;

            /* If moving in x direction doesn't give
               solution then  Move down in y direction */
            if (solveMazeUtil(maze, x, y + 1, sol, n, res))
                return true;

            /* If none of the above movements work then
               BACKTRACK: unmark x,y as part of solution
               path */
            sol[x][y] = 0;
            return false;
        }

        return false;
    }

    boolean isSafe(int maze[][], int x, int y, int n)
    {
        // if (x,y outside maze) return false
        return (x >= 0 && x < n && y >= 0 &&
                y < n && maze[x][y] == 1);
    }
}
