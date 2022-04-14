 import java.util.*;
 import java.io.*;

 public class Main {
     public static void main(String [] args) throws Exception {
         Scanner scn = new Scanner(System.in);
         int n = scn.nextInt();

         ArrayList<String> output = getstairpaths (n);
         System.out.println(output);

     }

     // Expectation:-> [3 -> 0] = [111, 12, 21, 3] // mujhee 3 see 0 ladder pee jaana haii

     // faith      :-> [2 -> 0] and [1 -> 0] and [0 -> 0] jaane kee saaree raastee already ptaa haii

     // EWF        :-> [3->0] =>  (1)[paths from 2->0] + ("2")[paths from 1->0] + ("3")[paths from 0->0]

     public static ArrayList <String> getstairpaths(int n) {

        if(n==0){ // yee base case jab 0th position pee hongee

            ArrayList<String> bres = new ArrayList<>();

            bres.add(""); // yee haii blank string 

            return bres; //ismee ArrayList [] kaa size 1 haii parr uskee andarr kuch v nhii haii 

        }else if(n<0) { // yee base case jab negative position pee hongee

            ArrayList<String> bres = new ArrayList<>();

            return bres;  // ismee ArrayList [] kaa size hii 0 haii 

        }
         ArrayList<String> paths_from_nm1 = getstairpaths(n-1); // call 1 :-> yee bhrosaa haii ki pakkaa n-1 see n tak jitnee paths hongee yee dee dega

         ArrayList<String> paths_from_nm2 = getstairpaths(n-2); // call 2 :-> yee bhrosaa haii ki pakkaa n-2 see n tak jitnee paths hongee yee dee dega

         ArrayList<String> paths_from_nm3 = getstairpaths(n-3); // call 3 :-> yee bhrosaa haii ki pakkaa n-3 see n tak jitnee paths hongee yee dee dega

         ArrayList<String> paths_from_n = new ArrayList<>();

         for(String var : paths_from_nm1){

             paths_from_n.add("1" + var);

         }
         for(String var : paths_from_nm2){
             
            paths_from_n.add("2" + var);

        }
        for(String var : paths_from_nm3){
             
            paths_from_n.add("3" + var);

        }
        return paths_from_n;

     }
 }

 // note:-> "1" , "2" , "3" are strings infacts all the numbers which we are using here are strings not integers