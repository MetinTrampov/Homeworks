package Demo;

import java.io.*;
import java.util.Scanner;



public class Register {
    public static Scanner scanner = new Scanner(System.in);
    
    /**
    *@author Metin Trampov
    *Този метод принтира текстовия файл и нищо повече не успях да измисля съжалявам за което ....
    *  
    */
    public static void main(String[] args) {



        String in = scanner.nextLine();

        switch (in){
            case "SELECT" : print ();               break;
            case "SELECT{TYPE}=[R]":                break;
            case "SELECT{TYPE}=[R]@{SEX}=[F]":      break;



        }
     



      //  printOldPersonInput();
   // printWorkingPersonInput();

    }

    /**
    *Метода който принтира подадения файл
    */
    public static void print (){
        File fileReference = new File("persons/personProperty");

        try {
            FileReader file             = new FileReader(fileReference);
            BufferedReader  buffreader  = new BufferedReader(file);

            String fullText;
            while ((fullText            = buffreader.readLine())!=null){
                System.out.println(fullText);

                String  [] ourLine      = fullText.split("@");
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
/*\
    public  static void printWorkingPersonInput(){
        WorkingMan workingHuman = new WorkingMan();
        System.out.println("Въведете имена");
        workingHuman.name=scanner.nextLine();
        workingHuman.sName=scanner.nextLine();
        System.out.println("Въведете години");
        workingHuman.age=scanner.nextLine();
        System.out.println("Въведете адрес");
        workingHuman.adres=scanner.nextLine();
        System.out.println("Въведете телефонен номер");
        workingHuman.phone=scanner.nextInt();
        System.out.println("Въведете пол");
        workingHuman.sex=scanner.next().charAt(0);
        System.out.println("Въведете заплата");
        workingHuman.salary=scanner.nextInt();
        setInputForOlderPerson(
                workingHuman.name,workingHuman.sName,workingHuman.age
                ,workingHuman.adres,workingHuman.phone,workingHuman.sex,workingHuman.salary);
    } public static void setInputForWorkingPerson(String n, String sn, String age, String a, int p, char s,int sal){
        System.out.println(n);
        System.out.println(sn);
        System.out.println(age);
        System.out.println(a);
        System.out.println(p);
        System.out.println(s);
        System.out.println(sal);

    }

    public  static void printOldPersonInput(){
        OldMan firstOldHuman = new OldMan();
        System.out.println("Въведете имена");
        firstOldHuman.name=scanner.nextLine();
        firstOldHuman.sName=scanner.nextLine();
        System.out.println("Въведете години");
        firstOldHuman.age=scanner.nextLine();
        System.out.println("Въведете адрес");
        firstOldHuman.adres=scanner.nextLine();
        System.out.println("Въведете телефонен номер");
        firstOldHuman.phone=scanner.nextInt();
        System.out.println("Въведете пол");
        firstOldHuman.sex=scanner.next().charAt(0);
        System.out.println("Въведете пинсия");
        firstOldHuman.pension=scanner.nextInt();
        setInputForOlderPerson(
                firstOldHuman.name,firstOldHuman.sName,firstOldHuman.age
                ,firstOldHuman.adres,firstOldHuman.phone,firstOldHuman.sex,firstOldHuman.pension);
    }
    public static void setInputForOlderPerson(String n, String sn, String age, String a, int p, char s,int pen){
        System.out.println(n);
        System.out.println(sn);
        System.out.println(age);
        System.out.println(a);
        System.out.println(p);
        System.out.println(s);
        System.out.println(pen);

    }*/
}
