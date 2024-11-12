
import java.util.Scanner;

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
    public static GameBoard Move(GameBoard newBoard){
        Scanner scanner = new Scanner(System.in);
       
      
        
        while (true) {  
System.out.println("How do you want to move ? \n Right enter : {r} \n Left enter : {l} \n Iop enter : {t} \n Down enter : {d} \n Cancel enter : {c}");
        String move = scanner.next();
       
            
            if (move.equals("r")) {
                newBoard = newBoard.moveRight();
                newBoard.printBoard();
            } else if (move.equals("l")) {
                newBoard = newBoard.moveLeft();
                newBoard.printBoard();
            } else if (move.equals("t")) {
                newBoard = newBoard.moveUp();
                newBoard.printBoard();
            } else if (move.equals("d")) {
                newBoard = newBoard.moveDown();
                newBoard.printBoard();
            } else if (move.equals("c")) {
                break;  
            } else {
                System.out.println("يرجى إدخال اختيار صالح.");
            }
        
    
    }
    scanner.close();
        return newBoard;
        };
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    //   TypeCell redMoveSquare = TypeCell.createMoveSquare("r");

      
      //  TypeCell redTargetSquare = TypeCell.createTargetSquare("R");
        GameBoard gameBoard = new GameBoard(8);
        // GameBoard currentBoard = gameBoard.deepCopy();
        // Set specific tiles
        gameBoard.setTile(0, 0, TypeCell.Fixed);
        gameBoard.setTile(0, 1, TypeCell.Fixed);
        gameBoard.setTile(0, 2, TypeCell.Fixed);
        gameBoard.setTile(0, 3, TypeCell.Fixed);
        gameBoard.setTile(0, 4, TypeCell.Fixed);
        gameBoard.setTile(0, 5, TypeCell.Fixed);
        gameBoard.setTile(0, 6, TypeCell.Fixed);
        gameBoard.setTile(0, 7, TypeCell.Fixed);
        gameBoard.setTile(1, 0, TypeCell.Fixed);
        gameBoard.setTile(2, 0, TypeCell.Fixed);
        gameBoard.setTile(3, 0, TypeCell.Fixed);
        gameBoard.setTile(4, 0, TypeCell.Fixed);
        gameBoard.setTile(5, 0, TypeCell.Fixed);
        gameBoard.setTile(6, 0, TypeCell.Fixed);
        // gameBoard.setTile(7,0, TypeCell.Fixed);
        gameBoard.setTile(7, 0, TypeCell.Fixed);
        gameBoard.setTile(7, 1, TypeCell.Fixed);
        gameBoard.setTile(7, 2, TypeCell.Fixed);
        gameBoard.setTile(7, 3, TypeCell.Fixed);
        gameBoard.setTile(7, 4, TypeCell.Fixed);
        gameBoard.setTile(7, 5, TypeCell.Fixed);
        gameBoard.setTile(7, 6, TypeCell.Fixed);
        gameBoard.setTile(7, 7, TypeCell.Fixed);
        // gameBoard.setTile(0, 0, TypeCell.Fixed);
        gameBoard.setTile(1, 7, TypeCell.Fixed);
        gameBoard.setTile(2, 7, TypeCell.Fixed);
        gameBoard.setTile(3, 7, TypeCell.Fixed);
        //gameBoard.setTile(4, 7, TypeCell.Fixed);
        gameBoard.setTile(5, 7, TypeCell.Fixed);
        gameBoard.setTile(6, 7, TypeCell.Fixed);
        //
        gameBoard.setTile(6, 3, TypeCell.Fixed);
        gameBoard.setTile(5, 3, TypeCell.Fixed);
        gameBoard.setTile(4, 6, TypeCell.Fixed);

        gameBoard.setTile(3, 0, TypeCell.Fixed);
        // gameBoard.setTile(3, 3, TypeCell.TargetSquare);
        // gameBoard.setTile(3, 1, TypeCell.MoveSquare);
        // gameBoard.setTile(4, 2, TypeCell.MoveSquare);
        // gameBoard.setTile(4, 1, TypeCell.MoveSquare);
        // gameBoard.setTile(5, 1, TypeCell.MoveSquare);
       // gameBoard.setTile(4, 4, TypeCell.TargetSquare);
        gameBoard.setMoveSquare(4, 4, "b");
       // gameBoard.setMoveSquare(3, 1, "y");
        gameBoard.setTargetSquare(6, 1, "B");
        gameBoard.setMoveSquare(3, 4, "r");
       gameBoard.setTargetSquare(4, 5, "R");
       gameBoard.setTargetSquare(3, 6, "R");
        gameBoard.printBoard();
       
        gameBoard.generatePossibleMoves();
       // gameBoard.generatePossibleMoves();
       gameBoard = Move(gameBoard);
     


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
        System.out.println(this.color);
        System.out.println(other.color);
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
