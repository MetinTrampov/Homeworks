package HeatMeneger;

import Machines.*;

import java.util.Arrays;

public class HeatManager {
     public static Machine mech = new Machine("MrBob",15.7,100);
     public static Engine engine = new Engine(150);
     public static Person human = new Person("Бат Бойко" );
     public static HeatEngine heat = new HeatEngine(38.5);
     public static ProductionEngine product = new ProductionEngine(50);

     public static void main(String[] args) {
          Object[] array ;
          //new Object[10];

          array = new Object[]{
                  engine,mech,human,heat,product

          };
         //; toString(array);
         // new HeatManager(array);
         // array.add();

         print(array);



     }


     public HeatManager(Object []array) {
          array = new Object[]{
                  engine,mech,human,heat,product

          };

     } public  static  String toString (Object [] nn){
          return Arrays.toString(nn);
     }


     public  static  void print (Object [] test){
          for (int i = 0; i < test.length ; i++) {

               System.out.println(test[i]);
               }

          }
     }

