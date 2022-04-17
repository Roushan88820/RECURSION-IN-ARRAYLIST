import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int row = scn.nextInt();
        int col = scn.nextInt();

        ArrayList<String> paths = getMazePaths(1, 1 , row , col);
        System.out.println(paths);


    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr > dr || sc > dc) { // agarr maine row yaa frr column koii v wall breach ki too ye base case

            ArrayList<String> bres= new ArrayList<>();

            return bres; // [] :-> 0 maii maze see bahar hoon isiliyee khaalii arrayList

        }
        else if(sr == dr && sc == dc) { // jabb iskee andarr aaungaa too iskaa matlbb mainee dono condition  satisfy karii haii aurr maii bottom right corner pee hoon
            
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");

            return bres; // [""] :-> yhaa arrayList kaa size 1 haii kukii maii apnee destination pee hoo too v ekk raasta haii khii matt jaoo khdee rahoo
        }

        ArrayList<String> hpaths = getMazePaths(sr , sc + 1 , dr , dc); // yee meraa faith haii kii yee mujhe saare horizontal paths laake dee degaa

        ArrayList<String> vpaths = getMazePaths(sr + 1 , sc , dr , dc); // ispee v bhrosa haii kii yee mujhee saare vertical paths laake dee dega

        ArrayList<String> all_paths = new ArrayList<>();


        for(String var : hpaths) {

            all_paths.add("h" + var);

        }

        for(String var : vpaths){

            all_paths.add("v" + var);
        }

        return all_paths;
    }

}
