import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameBoard {
    int sizeBorade;
    TypeCell[][] board;
    List<Position> targetSquares;
    GameBoard parent;
    int cost;
    public GameBoard(GameBoard parent) {
        this.parent = parent;
    }

    public GameBoard(int sizeBorade) {
        this.sizeBorade = sizeBorade;
        this.board = new TypeCell[sizeBorade][sizeBorade];
        this.targetSquares = new ArrayList<>(); 
        this.parent = parent;
        this.cost= 0;
        initState();
    }

    private void initState() {
        for (int i = 0; i < sizeBorade; i++) {
            for (int j = 0; j < sizeBorade; j++) {
                board[i][j] = TypeCell.Empty;
            }
        }
    }

    public GameBoard deepCopy() {
        GameBoard copy = new GameBoard(this.sizeBorade);
        copy.targetSquares = new ArrayList<>(this.targetSquares);
        copy.parent = this.parent;
      //  copy.cost=this.cost;
        for (int i = 0; i < this.sizeBorade; i++) {
            copy.board[i] = Arrays.copyOf(this.board[i], this.sizeBorade); 
        }
        return copy;
    }
    public void setMoveSquare(int row, int col, String color) {
        board[row][col] = TypeCell.createMoveSquare(color);
    }

  
    public void setTargetSquare(int row, int col, String color) {
        board[row][col] = TypeCell.createTargetSquare(color);
        this.targetSquares.add(new Position(row,col,color));
    //     boolean exists = targetSquares.stream().anyMatch(pos -> 
    //     pos.getX() == row && pos.getY() == col && pos.getValue().equals(color)
    // );

    // 
    // if (!exists) {
    //     board[row][col] = TypeCell.createTargetSquare(color);
    //     targetSquares.add(new Position(row, col, color));
    // }
    }
    public void setTile(int row, int col, TypeCell type) {
        board[row][col] = type;
    }

    public boolean canMoveR(int row, int col, GameBoard boardGame) {
        TypeCell currentCell = boardGame.board[row][col];
        TypeCell targetCell = boardGame.board[row][col + 1];
        if (currentCell.getType().equals("MoveSquare") 
        && !targetCell.getType().equals("Fixed") 
        && !targetCell.getType().equals("MoveSquare")) {
            return true;
        } else {
            return false;
        }
    }

    public GameBoard moveRight() {
            // System.out.println(targetSquares);
        GameBoard newBoard = this.deepCopy();
        int k=0;
        while (k<2) {
            
            
            for (int row = 0; row < newBoard.sizeBorade - 1; row++) {
    
                for (int col = 0; col < newBoard.sizeBorade - 1; col++) { 
                    if (canMoveR(row, col, newBoard)) {
                       if(newBoard.goal(row, col,row,col+1)){
                       
                        continue;
                       }
                        newBoard.board[row][col + 1] = newBoard.board[row][col];
                        newBoard.board[row][col] = TypeCell.Empty;   
                     }
                }
             };
           k++;
        }
       // System.out.println(this.targetSquares.size()+" "+newBoard.targetSquares.size());
        for(int i=0;i<newBoard.targetSquares.size();i++){
            
            Position pos= newBoard.targetSquares.get(i);
            if(newBoard.board[pos.getX()][pos.getY()].getType().equals("MoveSquare")){
                continue;
            }
            newBoard.board[pos.getX()][pos.getY()]=TypeCell.createTargetSquare(pos.getValue());
        }
        // for (Position pos : newBoard.targetSquares) {
        //     System.out.println("x: " + pos.getX() + ", y: " + pos.getY() + ", value: " + pos.getValue());
        // }
        //   for (Position typeCells : this.targetSquares) {
            
        //        if (!newBoard.board[typeCells.getX()][typeCells.getY()].getType().equals("MoveSquare")){
        //         //  System.out.println(!newBoard.board[typeCells.getX()][typeCells.getY()].getType().equals("MoveSquare"));
        //         newBoard.setTargetSquare(typeCells.getX(), typeCells.getY(), typeCells.getValue());
             
        //     }
        //  }
    //    newBoard.printBoard();
        
        return newBoard;
    }

    public boolean canMoveL(int row, int col, GameBoard boardGame) {
        TypeCell currentCell = boardGame.board[row][col];
        TypeCell targetCell = boardGame.board[row][col - 1];
        if (currentCell.getType().equals("MoveSquare") 
        && !targetCell.getType().equals("Fixed") 
        && !targetCell.getType().equals("MoveSquare")) {
            return true;
        } else {
            return false;
        }
    }

    public GameBoard moveLeft() {
        GameBoard newBoard = this.deepCopy();
        int k=0;
        while (k<2) {
            
            
            for (int row = 0; row < newBoard.sizeBorade - 1; row++) {
    
                for (int col = newBoard.sizeBorade - 1; col > 0; col--) { 
                    if (canMoveL(row, col, newBoard)) {
                        if(newBoard.goal(row, col,row,col-1)){
                            continue;
                           }
                        newBoard.board[row][col - 1] = newBoard.board[row][col];
                        newBoard.board[row][col] = TypeCell.Empty;
                    }
                }
            }
            k++;
        }
        for(int i=0;i<newBoard.targetSquares.size();i++){
            
            Position pos= newBoard.targetSquares.get(i);
            if(newBoard.board[pos.getX()][pos.getY()].getType().equals("MoveSquare")){
                continue;
            }
            newBoard.board[pos.getX()][pos.getY()]=TypeCell.createTargetSquare(pos.getValue());
        }

//newBoard.printBoard();
        ;
        return newBoard;
    }

    public boolean canMoveUp(int row, int col, GameBoard boardGame) {
        TypeCell currentCell = boardGame.board[row][col];
        TypeCell targetCell = boardGame.board[row - 1][col];
        if (currentCell.getType().equals("MoveSquare") 
        && !targetCell.getType().equals("Fixed") 
        && !targetCell.getType().equals("MoveSquare")) {
            return true;
        } else {
            return false;
        }
    }

    public GameBoard moveUp() {
        GameBoard newBoard = this.deepCopy();
        int k=0;
        while (k<2) {
            
            
            for (int row = newBoard.sizeBorade - 1; row > 0; row--) {
                for (int col = 0; col < newBoard.sizeBorade - 1; col++) {
                    // System.out.println(i);
                    if (canMoveUp(row, col, newBoard)) {
                        if(newBoard.goal(row, col,row-1,col)){
                            continue;
                           }
                        newBoard.board[row - 1][col] = newBoard.board[row][col];
                        newBoard.board[row][col] = TypeCell.Empty;
                    }
                    ;
                }
            }
            k++;
        }
        for(int i=0;i<newBoard.targetSquares.size();i++){
            
            Position pos= newBoard.targetSquares.get(i);
            if(newBoard.board[pos.getX()][pos.getY()].getType().equals("MoveSquare")){
                continue;
            }
            newBoard.board[pos.getX()][pos.getY()]=TypeCell.createTargetSquare(pos.getValue());
        }

     //   newBoard.printBoard();
        return newBoard;
    }

    public boolean canMoveD(int row, int col, GameBoard boardGame) {
        TypeCell currentCell = boardGame.board[row][col];
        TypeCell targetCell = boardGame.board[row + 1][col];
        if (currentCell.getType().equals("MoveSquare") 
        && !targetCell.getType().equals("Fixed") 
        && !targetCell.getType().equals("MoveSquare")) {
            return true;
        } else {
            return false;
        }
    }

    public GameBoard moveDown() {
        GameBoard newBoard = this.deepCopy();
        int k=0;
        while (k<2) {
            
            
            for (int row = 0; row < newBoard.sizeBorade - 1; row++) {
                for (int col = 0; col < newBoard.sizeBorade - 1; col++) {
                    if (canMoveD(row, col, newBoard)) {
                        if(newBoard.goal(row, col,row+1,col)){
                            continue;
                           }
                        newBoard.board[row + 1][col] = newBoard.board[row][col];
    
                        newBoard.board[row][col] = TypeCell.Empty;
    
                    }
                    ;
                }
            }
            k++;
        }
        for(int i=0;i<newBoard.targetSquares.size();i++){
            
            Position pos= newBoard.targetSquares.get(i);
            if(newBoard.board[pos.getX()][pos.getY()].getType().equals("MoveSquare")){
                continue;
            }
            newBoard.board[pos.getX()][pos.getY()]=TypeCell.createTargetSquare(pos.getValue());
        }
      //  newBoard.printBoard();
       
        return newBoard;
    }

    public void printBoard() {
        for (int i = 0; i <sizeBorade; i++) {
            for (int j = 0; j < sizeBorade; j++) {
                System.out.print(this.board[i][j].getColor() + " ");
            }
            System.out.println();
        }
        System.out.println("__________________________________________________________");
    }
    public boolean goal(int row ,int col,int nextRow ,int nextCol){
        //  printBoard();
        if(board[nextRow][nextCol].getType().equals("TargetSquare")){
            
            if(board[row][col].matchesColor(board[nextRow][nextCol])){
                board[row][col] = TypeCell.Empty;
                board[nextRow ][nextCol] = TypeCell.Empty;
                // for (Position pos : targetSquares) {
                //     System.out.println("x: " + pos.getX() + ", y: " + pos.getY() + ", value: " + pos.getValue());
                // }
                int rowwww=nextRow;
                int collll=nextCol;
                this.targetSquares.removeIf(targetSquare ->  
                targetSquare.getX()==rowwww && 
                targetSquare.getY() == collll);
              //  System.out.println(")))))))))))))))))))))))");

            //     for (Position pos : targetSquares) {
            //         System.out.println("x: " + pos.getX() + ", y: " + pos.getY() + ", value: " + pos.getValue());
            //     }
            // System.out.println("is goal");
            return true;
        }
       }
      
       return false;
    }
    public boolean isGoal(){
        if(targetSquares.isEmpty()){
            return true;
        }
        return false;

    } 
     public List<GameBoard> generatePossibleMoves() {
        List<GameBoard> possibleMoves = new ArrayList<>();
        this.parent=this.deepCopy();
       // this.cost= 1;
        GameBoard newBoard=this.deepCopy();
      if(!this.equals(newBoard.moveRight())){
        GameBoard boardd =newBoard.moveRight();
        boardd.cost = this.cost + 1;
        possibleMoves.add(boardd);
      }
      if(!this.equals(newBoard.moveLeft())){
        GameBoard boardd =newBoard.moveLeft();
        boardd.cost = this.cost + 1;
        possibleMoves.add(boardd);
     }
     if(!this.equals(newBoard.moveUp())){
        GameBoard boardd =newBoard.moveUp();
        boardd.cost = this.cost + 1;
        possibleMoves.add(boardd);
     }
     if(!this.equals(newBoard.moveDown())){
        GameBoard boardd =newBoard.moveDown();
        boardd.cost = this.cost + 1;
        possibleMoves.add(boardd);
     }
    //  for (GameBoard gameBoard : possibleMoves) {
    //     System.out.println("9999999999999999999999999999999999");
    //     gameBoard.printBoard();
    //  }
    //  System.out.println();
        return possibleMoves;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        GameBoard newBoard = (GameBoard) o;
     
        return Arrays.deepEquals(this.board, newBoard.board);
    }
    @Override
    public int hashCode() {
        return Arrays.deepHashCode(board);
    }
}
