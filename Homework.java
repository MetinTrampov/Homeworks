import java.util.Scanner;

public class Homework {

    static final int PLAYER_BLACK_ID   = 1;
    static final int PLAYER_WHITE_ID   = 2;


    static final int FIRST_ACTIVE_CHAR  = 1;
    static final int LAST_ACTIVE_CHAR   = 6;

   static Scanner scanner = new Scanner( System.in);
    
    public static void main(String[] args) {

        boolean isGameRunin = true;
        int activePlayer= FIRST_ACTIVE_CHAR;
        int [][] gameBoard = new int[LAST_ACTIVE_CHAR][LAST_ACTIVE_CHAR];
      //  Scanner scanner = new Scanner( System.in);

        viewOfGameBoard(gameBoard);

        while (isGameRunin) {
            System.out.print("Input figure  ");
            String element = scanner.nextLine();
            System.out.print("Input row : ");
            int rowInput = Integer.parseInt(scanner.nextLine());
            if (isPositionInvalid(rowInput)) {
                System.out.println("Invalid input . Try again with data between 1 to 6");
                continue;
            }
            System.out.print("Input col : ");
            int colInput = Integer.parseInt(scanner.nextLine());
            if (isPositionInvalid(colInput)) {
                System.out.println("Invalid input . Try again with data between 1 to 6");
                continue;
            }
           // System.out.println(boardElement(gameBoard,rowInput,colInput,element));

            int friendlyRow= rowInput-1;
            int friendlyCol= colInput-1;



            gameBoard[friendlyRow][friendlyCol]=  activePlayer;

            activePlayer = getActivePlayerId(activePlayer);
            viewOfGameBoard(gameBoard);
        }
    }





    public  static  boolean isPositionInvalid(int input){

        switch (input){
            case 1:
                System.out.println("A"); break;
            case 2:
                System.out.println("B"); break;
            case 3:
                System.out.println("C"); break;
            case 4:
                System.out.println("D"); break;
            case 5:
                System.out.println("E"); break;
            case 6:
                System.out.println("F"); break;

        }
        if(input<FIRST_ACTIVE_CHAR || input>LAST_ACTIVE_CHAR){
            return  true;
        }
            return false;
    }


    /**
     * @author Metin Trampov
     * @param gameBoard
     * @param row
     * @param col
     * @param mark
     * @return
     */

    public  static  String boardElement(int[][] gameBoard, int row, int col,String mark){
        int playerId = getGameBoardPlayerId(gameBoard, row, col);
        //String[] elements = new String[]{"Dw", "D ", "Q ", "K ", "M ", "Dw"};
        char prefixW = 'w';
        char prefixB = 'b';
        switch (mark){
            case "джудже":
                if(playerId ==PLAYER_BLACK_ID) {

                    return prefixB +"Dw";
                }
                return  prefixW+"Dw";
            case "картечница":
                if(playerId ==PLAYER_BLACK_ID) {

                    return prefixB +"M";
                }return prefixW +"М";
            case "магаре":  if(playerId ==PLAYER_BLACK_ID) {
                return prefixB +"D";
            }return prefixW+"D";
            case "цар":  if(playerId ==PLAYER_BLACK_ID) {
                return prefixB +"K";
            }return prefixW+"K";
            case "царица": if(playerId ==PLAYER_BLACK_ID) {
                return prefixB +"Q";
            } return prefixW+ "Q";
       default: return "try again with джудже/картечница/магаре/цар/царица";

        }
    }

    /**
     * @author Metin Trampov
     * use this method to visualised the Game Board Vision
     * @param gameBoard
     */
    public static void viewOfGameBoard(int [][] gameBoard){
        System.out.println("Dw  M  Q  K  D  Dw");
        for (int row = 0; row < 4; row++) {

            System.out.println("==================");
            for (int col = 0; col < 6 ; col++) {
                        ///if(row==0||row==6){
                        //    System.out.println(boardElements());
                       // }
                System.out.print(getGameBoardMark(gameBoard,row,col));

            }
            PrintSideLetters(row);
            System.out.println();
        }
        System.out.println("==================");
       PrintBottomNLetters();
    }

    public static int getGameBoardPlayerId(int[][] gameBoard, int row, int col) {
        //return gameBoard[getPiecePositionIndex(row, col)];
        return gameBoard[row][col];
    }
    public   static  void PrintBottomNLetters() {
        for (char i = 'A'; i <= 'F'; i++)
            System.out.print(" "+ i + " ");
        System.out.println();
    }

    /**
     *
     * @param gameBoard
     * @param row
     * @param col
     * @return
     */
    public static String getGameBoardMark(int[][] gameBoard, int row, int col) {

       int playerId = getGameBoardPlayerId(gameBoard, row, col);
        String prefixW = "w ";
        String prefixB = "b ";
        if(playerId == PLAYER_BLACK_ID  ) return prefixB ;
        if(playerId == PLAYER_WHITE_ID  ) return prefixW ;
        return "|X|";

    }

    /**
     *
     * @param currentId
     * @return
     */

    public static int getActivePlayerId(int currentId) {

        if (currentId == PLAYER_BLACK_ID) return PLAYER_WHITE_ID ;
        return  PLAYER_BLACK_ID;
    }


    public   static void PrintSideLetters(int row) {
        System.out.print(" " + (char) (row + 'B'));
    }


}



