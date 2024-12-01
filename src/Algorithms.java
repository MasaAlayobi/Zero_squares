import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Algorithms {
    public void bfs(GameBoard board) {
        Queue<GameBoard> queue = new LinkedList<>();
        List<GameBoard> visited = new ArrayList<>();
        queue.add(board);

        while (!queue.isEmpty()) {
            GameBoard currentBoard = queue.poll();
            boolean isAlreadyVisited = false;
        for (GameBoard visitedBoard : visited) {
            if (visitedBoard.equals(currentBoard)) {
                isAlreadyVisited = true;
                break;
            }
        }

    
        if (isAlreadyVisited) {
            continue;
        }

  
        visited.add(currentBoard);
            if (currentBoard.isGoal()) {
                List<GameBoard> path = new ArrayList<>();
                path.add(currentBoard);
                while (currentBoard.parent != null) {
                    path.add(currentBoard.parent);
                    currentBoard = currentBoard.parent;
                }
                System.out.println("BFS____________________________________");
                for (GameBoard gameBoard : path) {
                    gameBoard.printBoard();
                }
                System.out.println(visited.size());
                System.out.println(path.size());
                System.out.println("BFS____________________________________");
                break;
            }

            List<GameBoard> nextState = currentBoard.generatePossibleMoves();
            for (GameBoard gameBoard : nextState) {
                boolean isVisited = false;

                for (GameBoard newB : visited) {
                    if (newB.equals(gameBoard)) {
                        isVisited = true;
                        break;
                    }
                }

                if (!isVisited) {
                    queue.add(gameBoard);

                }
            }

        }
    }

    public void dfs(GameBoard board) {
        Stack<GameBoard> stack = new Stack<>();
        List<GameBoard> visited = new ArrayList<>();
        stack.add(board);

        while (!stack.isEmpty()) {
            GameBoard currentBoard = stack.pop();
            currentBoard.printBoard();
            boolean isAlreadyVisited = false;
            for (GameBoard visitedBoard : visited) {
                if (visitedBoard.equals(currentBoard)) {
                    isAlreadyVisited = true;
                    break;
                }
            }
    
        
            if (isAlreadyVisited) {
                continue;
            }
    
      
            visited.add(currentBoard);

            if (currentBoard.isGoal()) {
                List<GameBoard> path = new ArrayList<>();
                path.add(currentBoard);
                while (currentBoard.parent != null) {
                    path.add(currentBoard.parent);
                    currentBoard = currentBoard.parent;
                }
                System.out.println("DFS____________________________________");
                
                for (GameBoard gameBoard : path) {
                    gameBoard.printBoard();
                }
                System.out.println(visited.size());
                System.out.println(path.size());
                System.out.println("DFS____________________________________");
                break;
            }

            List<GameBoard> nextState = currentBoard.generatePossibleMoves();
            for (GameBoard gameBoard : nextState) {
                boolean isVisited = false;

                for (GameBoard newB : visited) {
                    if (newB.equals(gameBoard)) {
                        isVisited = true;
                        break;
                    }
                }

                if (!isVisited) {
                    stack.add(gameBoard);

                }
            }

        }
    }
    public void ucs(GameBoard board) {
        PriorityQueue<GameBoard> pqueue = new PriorityQueue<>(new Comparator<GameBoard>() {
            @Override
            public int compare(GameBoard board1, GameBoard board2) {
             
                return Integer.compare(board1.cost, board2.cost);
            }
        });
        List<GameBoard> visited = new ArrayList<>();
        pqueue.add(board);
    // pqueue.comparator();
        while (!pqueue.isEmpty()) {
            // GameBoard currentBoard = pqueue.comparator();
            GameBoard currentBoard = pqueue.poll();
            boolean isAlreadyVisited = false;
        for (GameBoard visitedBoard : visited) {
            if (visitedBoard.equals(currentBoard)) {
                isAlreadyVisited = true;
                break;
            }
        }

    
        if (isAlreadyVisited) {
            continue;
        }

  
        visited.add(currentBoard);
            if (currentBoard.isGoal()) {
                List<GameBoard> path = new ArrayList<>();
                path.add(currentBoard);
                while (currentBoard.parent != null) {
                    path.add(currentBoard.parent);
                    currentBoard = currentBoard.parent;
                }
                System.out.println("UCS____________________________________");
                for (GameBoard gameBoard : path) {
                    gameBoard.printBoard();
                }
                System.out.println(visited.size());
                System.out.println(path.size());
                System.out.println("UCS____________________________________");
                break;
            }
            
            List<GameBoard> nextState = currentBoard.generatePossibleMoves();
            for (GameBoard gameBoard : nextState) {
                boolean isVisited = false;

                for (GameBoard newB : visited) {
                    if (newB.equals(gameBoard)) {
                        isVisited = true;
                        break;
                    }
                }
                
                if (!isVisited) {
                    gameBoard.cost += currentBoard.cost;
                    
                    pqueue.add(gameBoard);
                    
                }
            }

        }
    }
    List<GameBoard> visited = new ArrayList<>();
    public void recursiveDFS(GameBoard board) {
        for (GameBoard visitedBoard : visited) {
            if (visitedBoard.equals(board)) {
                return;
            }
        }
        visited.add(board);
        if (board.isGoal()) {
            List<GameBoard> path = new ArrayList<>();
            path.add(board);
            while (board.parent != null) {
                path.add(board.parent);
                board = board.parent;
            }
            System.out.println("RDFS____________________________________");
            
            for (GameBoard gameBoard : path) {
                gameBoard.printBoard();
            }
            System.out.println(visited.size());
            System.out.println(path.size());
            System.out.println("RDFS____________________________________");
            
        }
        List<GameBoard> nextState = board.generatePossibleMoves();
        for (GameBoard gameBoard : nextState) {
            boolean isVisited = false;

            for (GameBoard newB : visited) {
                if (newB.equals(gameBoard)) {
                    isVisited = true;
                    break;
                }
            }

            if (!isVisited) {
                recursiveDFS(gameBoard);

            }
        }  
    }
    public int heuristic (GameBoard board){
        int Heuristic = 0;
        for (Position posT : board.targetSquares) {
            for (Position posM : board.moveSquares) {
                if(board.board[posT.getX()][posT.getY()].matchesColor(board.board[posM.getX()][posM.getY()])){
                   int  manhatten =  Math.abs(posM.getX()-posT.getX())+Math.abs(posM.getY()-posT.getY());
                   System.out.println(manhatten);
                   Heuristic += manhatten;
                }
            }
        }
        System.out.println(Heuristic);
        return Heuristic;
    }

}
// boolean  visit =false;
          
// for (GameBoard gameBoard : visited) {
//     if (gameBoard.equals(currentBoard)) {
//         visit=true;
//         break;
//     }
// }
// if(!visit) {
// visited.add(currentBoard);
// }  else{
// continue;
// }