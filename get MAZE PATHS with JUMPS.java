import java.util.*;
import java.io.*;

public class Main {
    public static void main (String [] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int r = scn.nextInt();
        int c = scn.nextInt();
        
        ArrayList<String> paths = get_maze_paths_jumps( 1 , 1, r , c);
        System.out.println(paths);

    }

    public static ArrayList<String> get_maze_paths_jumps(int sr , int sc, int dr , int dc ){

        if(sr==dr && sc == dc) {
            ArrayList<String>bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        else if(sr > dr || sc > dc) {

            ArrayList<String>bres = new ArrayList<>();
            
            return bres;
        }

        ArrayList<String> all_paths = new ArrayList<>();

        // for horizontal paths

        for( int ms = 1 ; ms <= dc - sc ; ms++ ) { // ms = move size

            ArrayList<String> hpaths = get_maze_paths_jumps(sr, sc + ms, dr, dc);

            for(String var : hpaths) {

                all_paths.add("h" + ms + var);

            }

        }

        // for all vertical paths 
        for(int ms = 1 ; ms <= dr - sr ; ms++ ) {

            ArrayList<String> vpaths = get_maze_paths_jumps(sr + ms, sc, dr, dc);

            for(String var : vpaths) {

                all_paths.add("v" + ms + var);

            }
        }
        
        // for all diagonal paths

        for(int ms = 1 ; ms <= dr - sr &&  ms <= dc - sc ; ms++) {

            ArrayList<String> dpaths = get_maze_paths_jumps(sr + ms , sc + ms , dr, dc) ;

            for(String var : dpaths) {

                all_paths.add("d" + ms + var);
            }
        }

        return all_paths;
    }
}