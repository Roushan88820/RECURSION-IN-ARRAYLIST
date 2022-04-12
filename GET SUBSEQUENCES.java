import java.util.*;
import java.io.*;

public class Main {
    public static void main (String [] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        ArrayList <String> output = gss(str);

        System.out.println(output);

    }

    //Expectation :-> gss(abc) :-> [ ... , ..c , .b. , .bc , a.. , a.c , ab. , abc ] // iseyy mujhee umeed haii 

    //Faith       :-> gss(bc) :-> [ .. , .c , b. , bc]         // parr ispee bhrosaa hai kii yee pakka laake dee degaaa

    //EWF         :-> gss(abc) :-> (.)-[.. , .c , b. , bc] + (a)-[.. , .c , b. , bc]  // yee donoo list combined hii haii bass smjhne kee liyee likhaa hai separately



    public static ArrayList<String> gss(String str) {

        if( str.length() == 0) {
            ArrayList <String> bres = new ArrayList<>();
            bres.add("");
            return bres ; // [] bres.size = 0 , [""] bres.size = 1 parr bres.get(0).length == 0
        }

        char ch = str.charAt(0); // abc :-> a ;

        String ros = str.substring(1); // abc :-> bc ;

        ArrayList <String> rres = gss(ros); // [.. , .c , b. , bc] faith hai mil jaega

        ArrayList <String> mres = new ArrayList<> ();

        for(String var : rres) {

            mres.add("." + var); // mres :-> [... , ..c , .b. , .bc] // yhaa takk bnn jaega ye list for loop complete hone ke baad 
        }
        for (String var : rres) {

            mres.add( ch + var ); // mres :-> [... , ..c , .b. , .bc , a.. , a.c , ab. , abc] // abb iss for loop kee baad list puri complete hoo jaegii

        }

        return mres;



    }
}