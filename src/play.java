import java.util.Scanner;

public class play {
    GameBoard board;

    public play(GameBoard board) {
        this.board = board;
    }
  public GameBoard Move(){
        Scanner scanner = new Scanner(System.in);
       
      
        
        while (true) {  
System.out.println("How do you want to move ? \n Right enter : {r} \n Left enter : {l} \n Iop enter : {t} \n Down enter : {d} \n Cancel enter : {c}");
        String move = scanner.next();
       
            
            if (move.equals("r")) {
                GameBoard newBoard = this.board.moveRight();
                newBoard.printBoard();
                if(newBoard.isGoal())
                  break;
                board=newBoard;
            } else if (move.equals("l")) {
                GameBoard newBoard = this.board.moveLeft();
                newBoard.printBoard();
                if(newBoard.isGoal())
                 break;
                board=newBoard;
            } else if (move.equals("t")) {
                GameBoard newBoard = this.board.moveUp();
                newBoard.printBoard();
                if(newBoard.isGoal())
                 break;
                board=newBoard;
            } else if (move.equals("d")) {
                GameBoard newBoard = this.board.moveDown();
                newBoard.printBoard();
                if(newBoard.isGoal())
                 break;
                board=newBoard;
            } else if (move.equals("c")) {
                break;  
            } else {
                System.out.println("يرجى إدخال اختيار صالح.");
            }
        
    
    }
    scanner.close();
        return this.board;
        }
}
