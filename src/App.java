
public class App {
  
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    //   TypeCell redMoveSquare = TypeCell.createMoveSquare("r");

      
      //  TypeCell redTargetSquare = TypeCell.createTargetSquare("R");
      String[] boardInput = {
        "# # # # # # # # # # #",
        "# # r _ _ # # # # # # ",
        "# _ _ _ _ # # B _ # # ",
        "# _ _ _ _ _ _ _ _ # #",
        "# _ _ _ # # # _ _ R #",
        "# _ _ _ _ _ _ _ _ # #",
        "# # b _ # # # # # # #",
        "# # # # # # # # # # #",
        "# # # # # # # # # # #",
        "# # # # # # # # # # #",
        "# # # # # # # # # # #",
    };

    // إنشاء اللوحة وتحليل الإدخال
    int boardSize = boardInput.length; // طول اللوحة
    GameBoard gameBoard = new GameBoard(boardSize);

    // تحليل الإدخال النصي وتعيين أنواع البلاطات
    for (int row = 0; row < boardInput.length; row++) {
        String[] tiles = boardInput[row].split(" "); // تقسيم السطر إلى خلايا
        for (int col = 0; col < tiles.length; col++) {
            String tile = tiles[col];
            switch (tile) {
                case "#":
                    gameBoard.setTile(row, col, TypeCell.Fixed);
                    break;
                case "_":
                    gameBoard.setTile(row, col, TypeCell.Empty);
                    break;
                case "b":
                    gameBoard.setMoveSquare(row, col, "b");
                    break;
                case "r":
                    gameBoard.setMoveSquare(row, col, "r");
                    break;
                case "R":
                    gameBoard.setTargetSquare(row, col, "R");
                    break;
                case "B":
                    gameBoard.setTargetSquare(row, col, "B");
                    break;
                default:
                    throw new IllegalArgumentException("رمز غير معروف: " + tile);
            }
        }
    }
        gameBoard.printBoard();
       
       // gameBoard.generatePossibleMoves();
       // gameBoard.generatePossibleMoves();
       play move=new play(gameBoard);
     move.Move();
    Algorithms bf =new Algorithms();
//    bf.dfs(gameBoard);
//   bf.bfs(gameBoard);
    // bf.recursiveDFS(gameBoard);
    // bf.ucs(gameBoard);
   // bf.heuristic();
     bf.hillClimbing(gameBoard);
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



