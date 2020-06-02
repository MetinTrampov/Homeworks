package Demo;

import java.util.Scanner;

public class OldMan {
 // public static   Scanner scanner = new Scanner(System.in);

        //getInput();
        String name ;
        String sName ;
        String age;
        String adres ;
        int phone;
        char sex;
        int pension;


        public void  getPension(int pension){
                this.pension=pension;

        }
        public int setPens(){
                return pension;
        }



        /*public OldMan(String n, String sn, String age, String a, int p, char s,int pen){
                name = n;
                sName=sn;
                this.age =age;
                adres=a;
                phone=p;
                sex = s;
                pension= pen;


        }*/
    }

  /*  public static  void getInput (){
        String name ;
        String sName ;
        int age;
        String adres ;
        int phone;
        char sex;
        System.out.println("Въведете имена");

        name    = scanner.nextLine();
        sName   = scanner.nextLine();

        System.out.println("Въведете години");

        age     = scanner.nextInt();

        System.out.println("Въведете адрес");

        adres   = scanner.nextLine();

        System.out.println("Въведете телефонен номер");

        phone   = scanner.nextInt();

        System.out.println("Въведете пол");

        sex     = scanner.next().charAt(0);


    }
    public static void chooseType(){
        char type = scanner.next().charAt(0);
        switch (type){
            case 'R': break;
            case 'W': break;
            case 'M': break;

        }

    }
    public static void priorityOfCharacter (char type ){
        switch (type){
            case 'R':
                int pension= scanner.nextInt();
                break;
            case 'W':
                int salary= scanner.nextInt();
                break;
            case 'M': break;

        }

    }*/

