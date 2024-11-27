


class Position {
    private final int x;
    private final int y;
     private final String value;
   

    public String getValue() {
        return value;
    }

    public Position(int x, int y, String value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
public class App {
  
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    //   TypeCell redMoveSquare = TypeCell.createMoveSquare("r");

      
      //  TypeCell redTargetSquare = TypeCell.createTargetSquare("R");
        GameBoard gameBoard = new GameBoard(5);
        // GameBoard currentBoard = gameBoard.deepCopy();
        // Set specific tiles
        gameBoard.setTile(0, 0, TypeCell.Fixed);
        gameBoard.setTile(0, 1, TypeCell.Fixed);
        gameBoard.setTile(0, 2, TypeCell.Fixed);
        gameBoard.setTile(0, 3, TypeCell.Fixed);
        gameBoard.setTile(0, 4, TypeCell.Fixed);
        // gameBoard.setTile(0, 5, TypeCell.Fixed);
        // gameBoard.setTile(0, 6, TypeCell.Fixed);
        // gameBoard.setTile(0, 7, TypeCell.Fixed);
        gameBoard.setTile(1, 0, TypeCell.Fixed);
        gameBoard.setTile(2, 0, TypeCell.Fixed);
        gameBoard.setTile(3, 0, TypeCell.Fixed);
        gameBoard.setTile(4, 0, TypeCell.Fixed);
        // gameBoard.setTile(5, 0, TypeCell.Fixed);
        // gameBoard.setTile(6, 0, TypeCell.Fixed);
        // gameBoard.setTile(7,0, TypeCell.Fixed);
        gameBoard.setTile(4, 0, TypeCell.Fixed);
        gameBoard.setTile(4, 1, TypeCell.Fixed);
        gameBoard.setTile(4, 2, TypeCell.Fixed);
        gameBoard.setTile(4, 3, TypeCell.Fixed);
        gameBoard.setTile(4, 4, TypeCell.Fixed);
        // gameBoard.setTile(7, 5, TypeCell.Fixed);
        // gameBoard.setTile(7, 6, TypeCell.Fixed);
        // gameBoard.setTile(7, 7, TypeCell.Fixed);
        // gameBoard.setTile(0, 0, TypeCell.Fixed);
        gameBoard.setTile(1, 4, TypeCell.Fixed);
        gameBoard.setTile(2, 4, TypeCell.Fixed);
        gameBoard.setTile(3, 4, TypeCell.Fixed);
        gameBoard.setTile(4, 4, TypeCell.Fixed);
        // gameBoard.setTile(5, 7, TypeCell.Fixed);
        // gameBoard.setTile(6, 7, TypeCell.Fixed);
        //
    //    gameBoard.setTile(6, 3, TypeCell.Fixed);
    //     gameBoard.setTile(5, 3, TypeCell.Fixed);
    //     gameBoard.setTile(4, 6, TypeCell.Fixed);
    //    gameBoard.setTile(4, 7, TypeCell.Fixed);
         gameBoard.setTile(2, 2, TypeCell.Fixed);
        // gameBoard.setTile(3, 3, TypeCell.TargetSquare);
        // gameBoard.setTile(3, 1, TypeCell.MoveSquare);
        // gameBoard.setTile(4, 2, TypeCell.MoveSquare);
        // gameBoard.setTile(4, 1, TypeCell.MoveSquare);
        // gameBoard.setTile(5, 1, TypeCell.MoveSquare);
       // gameBoard.setTile(4, 4, TypeCell.TargetSquare);
       gameBoard.setMoveSquare(1, 1, "b");
     //  gameBoard.setMoveSquare(3, 1, "y");
       gameBoard.setTargetSquare(3, 2, "B");
        gameBoard.setMoveSquare(3, 3, "r");
      // gameBoard.setTargetSquare(4, 5, "R");
       gameBoard.setTargetSquare(1, 2, "R");
    // gameBoard.setMoveSquare(6, 1, "r");
    // // gameBoard.setTargetSquare(4, 5, "R");
    //  gameBoard.setTargetSquare(1, 6, "R");
    //   gameBoard.setMoveSquare(1, 1, "a");
    //   // gameBoard.setTargetSquare(4, 5, "R");
    //    gameBoard.setTargetSquare(6, 1, "A");
        gameBoard.printBoard();
       
       // gameBoard.generatePossibleMoves();
       // gameBoard.generatePossibleMoves();
      // play move=new play(gameBoard);
     //move.Move();
    Algorithms bf =new Algorithms();
//    bf.dfs(gameBoard);
//   bf.bfs(gameBoard);
    bf.recursiveDFS(gameBoard);
  //  bf.ucs(gameBoard);
    }
}



 class TypeCell {
    private final String type;
    private String color;

  
    public static final TypeCell Empty = new TypeCell("Empty", "_");
    public static final TypeCell Fixed = new TypeCell("Fixed", "#");


    private TypeCell(String type, String color) {
        this.type = type;
        this.color = color;
    }


    public static TypeCell createMoveSquare(String color) {
        return new TypeCell("MoveSquare", color);
    }


    public static TypeCell createTargetSquare(String color) {
        return new TypeCell("TargetSquare", color);
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public boolean matchesColor(TypeCell other) {
        // System.out.println(this.color);
        // System.out.println(other.color);
        return this.color.equals(other.color.toLowerCase());
    }

    @Override
    public String toString() {
        return type + "(" + color + ")";
    }
    @Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TypeCell typeCell = (TypeCell) o;
    return type.equals(typeCell.type) && color.equals(typeCell.color);
}

// @Override
// public int hashCode() {
//     return Objects.hash(type, color);
// }

}
