package all;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ListaFilmow {

    public void konstruujFilmy(){
        File file = new File("filmy.txt");
        String zbior [][]= new String[10][10];
       // ArrayList<String[]> ar = new ArrayList<String[]>();

        try {
            Scanner in = new Scanner(file);

            while (in.hasNext()){
                String line = in.nextLine();
                System.out.println(Arrays.toString(line.split(",")));



            }
            System.out.println();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


//    Object[][] data = {
//            {"Kathy", "Smith",
//                    "Snowboarding", 5, Boolean.FALSE},
//            {"John", "Doe",
//                    "Rowing", 3, Boolean.TRUE},
//            {"Sue", "Black",
//                    "Knitting", 2, Boolean.FALSE},
//            {"Jane", "White",
//                    "Speed reading", 20, Boolean.TRUE},
//            {"Joe", "Brown",
//                    "Pool", 10, Boolean.FALSE}
//    };
//    String[] columnNames = {"First Name",
//            "Last Name",
//            "Sport",
//            "# of Years",
//            "Vegetarian"};


    public static void main(String[] args) {
        ListaFilmow lista1 = new ListaFilmow();
        lista1.konstruujFilmy();

    }
}
