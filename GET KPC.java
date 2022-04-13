import java.util.*;
import java.io.*;

public class Main {
    public static void main (String [] args) {

        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        ArrayList<String>words = get_KPC(str);
        System.out.println(words);

    }

    // expectation :-> getKPC(67) = [pt, pu, qt, qu, rt, ru, st, su] // yee mujhe chaiyee
    // Faith       :-> getKPC(7) = [ t , u ]; // yee mujhe mil jaegaa kaisee iseyy koii frkk nahii padta
    // ewf         :-> getKPC(67) = [p * getKPC(7) + q * getKPC(7) + r * getKPC(7) + s * getKPC(7)] => [pt, pu, qt, qu, rt, ru, st, su]

    public static String[]codes = {".;" , "abc" , "def" , "ghi", "jkl", "mno" , "pqrs" , "tu", "vwx" , "yz"}; // yee ekk static array haii iseyy maii apnee puree code meii kahii v kisii v function meii use kar sktaa hoon

    public static ArrayList<String> get_KPC(String str) {
        if(str.length() == 0){ 

            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;

        }
        char ch = str.charAt(0); // 6 
        String ros = str.substring(1); // 7

        ArrayList<String>rres = get_KPC(ros);
        ArrayList<String>mres = new ArrayList<>();

        String code = codes[ ch - 48] ; // this is way to convert a character into integer by subtracting 48. ASCII value of character'0' is 48

        for(int i = 0; i<code.length() ; i++) {
            char chi = code.charAt(i);
            for(String var : rres) {
                mres.add(chi + var);
            }
        }

        return mres;


    }

}
