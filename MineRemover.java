import java.util.Scanner;

public class MineRemover {

    public  static Scanner scanner = new Scanner(System.in);
    public  static String START_POSITION        = " S";
    public  static String FINAL_POSITION        = " F ";
    public  static String UNREACHABLE_POSITION  = " X";
    public  static String REACHED_POSITION      = " V";
    public  static String MINES                 = " M";
    public  static String CURRENT_POSITION      = " *";
    public  static boolean isFirstTurn          = true;
    public  static int countProbes              =  10;
    public  static int countDisposal            =  3;
    public static void main(String[] args) {

        String [][] mineBoard = {
                {START_POSITION,UNREACHABLE_POSITION,UNREACHABLE_POSITION,UNREACHABLE_POSITION,UNREACHABLE_POSITION,UNREACHABLE_POSITION},
                {UNREACHABLE_POSITION,MINES,UNREACHABLE_POSITION,UNREACHABLE_POSITION,UNREACHABLE_POSITION,MINES},
                {UNREACHABLE_POSITION,UNREACHABLE_POSITION,UNREACHABLE_POSITION,UNREACHABLE_POSITION,MINES,FINAL_POSITION},
                {MINES,UNREACHABLE_POSITION,UNREACHABLE_POSITION,UNREACHABLE_POSITION,MINES,UNREACHABLE_POSITION},
                {UNREACHABLE_POSITION,UNREACHABLE_POSITION,UNREACHABLE_POSITION,UNREACHABLE_POSITION,UNREACHABLE_POSITION,UNREACHABLE_POSITION},
                {UNREACHABLE_POSITION,UNREACHABLE_POSITION,UNREACHABLE_POSITION,UNREACHABLE_POSITION,UNREACHABLE_POSITION,UNREACHABLE_POSITION},

        };



        do {
            printOurBoard(mineBoard);

             int [] cordinates = readInput();
             int [] target = new int [2] ;
            System.out.printf("От позиция [ %d ,%d ] do [ %d , %d ] \n ",cordinates[0],cordinates[1],cordinates[2],cordinates[3]);
            System.out.println();
            if(mineBoard[cordinates[3]][cordinates[2]].equals(MINES)){
                System.out.println("Там има мина");
                System.out.println("Може да я обезвредите :)\n" +
                        "Или да посрещнете гибелта си " );

            }
            if(!isFirstTurn) {
                printMenu(mineBoard, cordinates);
            }
            System.out.println();
            move(mineBoard,cordinates);
        }while (true);



    }
    public  static  void printOurBoard(String[][] board) {
        int rolNumbers=0;
        for (int i = 0; i <board.length ; i++) {
            System.out.print(rolNumbers+i);
            for (int j = 0; j <board[i].length ; j++) {
                System.out.print(board[i][j]);

            }
            System.out.println();
        }
                rolNumbers(board);

    }
    public static  void  rolNumbers(String[] [] array  ){
        System.out.print("  ");
        //int num =0;
        for (int i = 0; i <array.length ; i++) {
            System.out.printf("%d ",i);

        }
        System.out.println();
    }
    public  static  int[] readInput (){
        System.out.print("Въведете  кординати :\n");
        int intCoordinates ;
        int [] cord = new int[4];
        int [] firstCord =  new int[2];
        int [] secondCord =   new int[2];
        for (int i = 0; i <firstCord.length ; i++) {
            if(isFirstTurn){
                System.out.println("Toва е първият ви ход.\n" +
                        " Понеже мините се виждат имате право да обезвредите само 2 мини . Успех !\n" +
                        "Въведете само кординатите където искате да се позиционирате\n");
                break;
            }
            intCoordinates = scanner.nextInt();
            if(intCoordinates>=6){
                System.out.println("Въведете кординати от 0 до 6..\n"+
                        "Въведете свойте нови кординати : ");
                readInput();
                break;
            }

            firstCord[i] +=intCoordinates ;
        }
        for (int i = 0; i < secondCord.length ; i++) {
            intCoordinates = scanner.nextInt();
            if(intCoordinates>=6){
                System.out.println("Въведете кординати от 0 до 6..\n"+
                        "Въведете свойте нови кординати : ");
                readInput();
                break;
            }

            secondCord[i] +=intCoordinates ;
        }
        int [] fromCord = new int[2];
        int [] toCord = new int[2];

         fromCord[0] = firstCord[0];
         fromCord[1] = (firstCord[1]);
         toCord[0] = (secondCord[0]);
         toCord[1] = (secondCord[1]);

         cord[0]= fromCord[0];
         cord[1]= fromCord[1];
         cord[2]= toCord[0];
         cord[3]= toCord[1];

         if(isFirstTurn&& cord[2]==5 && cord[3]==2 ){
             System.out.println("Опитваш се да мимищ");
             System.out.println("Вече губиш своя шанс за обезвреждане . Честито ;)");
             countProbes-=2;
             cord[2]=0 ;
             cord[3]=0 ;
         }
        return cord;
    }
    public static  void move (String [][] board ,int [] coord) {
        String target = board[coord[3]][coord[2]];

        board[coord[3]][coord[2]] = CURRENT_POSITION;
        if (!isFirstTurn) {
            board[coord[1]][coord[0]] = REACHED_POSITION;
        }
        isFirstTurn = false;


        if(target.equals(MINES)&&countDisposal==0){
            System.out.println("Там имаше мина ,a си вече без опции за обезвреждане");
            System.out.println("Играта за теб приключи :(");
            System.exit(0);
        }
            if (target.equals(FINAL_POSITION)) {
                System.out.println("Поздравления вие сте победител");
                System.exit(0);
            }



    }
    public  static  void printMenu (String [][] bord , int[] cord){
        System.out.println("1. Анализ\n" +
                "2. обезвреждане\n" +
                "3. придвижване, по бойното поле.");
        chooseOption(bord,cord);
    }
    public  static  void chooseOption  (String [][] bord , int[] cord){
        System.out.println("Изберете опция");
        int n =scanner.nextInt();
        switch (n){
            case 1:
                System.out.println("Недовършена опция"); break;
            case 2: disposal(bord,cord); break;
            case 3: break;
        }

    }
    public  static void disposal (String [][] bord , int[] cord ){
        String target = bord[cord[3]][cord[2]];
        System.out.printf("Твоят ход е към {%d %d} ако там има мина ,", cord[3],cord[2]);
        System.out.print("Мината ще бъде обезвредена ;)");
       countDisposal--;
    }
    public  static void probe (String [][] bord , int[] cord ){
        String currPosition =  bord[cord[1]][cord[0]];

    }

}
