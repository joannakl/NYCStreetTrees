package project2;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.text.NumberFormat;

/**
 * This class is the program performing reading part of the program creating Tree, TreeList, TreeSpecies, and TreeSpeciesList classes.
 * The program is interactive.
 * When the program is executed the name of the input file containing the list of all the
 * trees with all their attributes is provided as the program's single command line argument. The data in this file
 * serves as a database of all the trees in all the boroughs in NYC.
 * In the interactive part, the user enters a common or latin name of a tree. The program responds by printing all matching species,
 * and their distribution throughout the five boroughs and NYC itself
 *
 * @author Vishnu Matta
 *
 */

public class NYCStreetTrees {

    public static void main(String[] args) throws IOException {

        /**
         * The main() method of this program.
         * @param args array of Strings provided on the command line when the program is started;
         * the first string should be the name of the input file containing the list of census trees.
         */

        //verify that the command line argument exists
        if (args.length == 0) {
            System.err.println("Usage Error: the program expects file name as an argument.\n");
            System.exit(1);
        }

        //verify that the command line argument contains a name of an existing file
        File treeFile = new File(args[0]);
        if (!treeFile.exists()) {
            System.err.println("Error: the file " + treeFile.getAbsolutePath() + " cannot be opened.\n");
            System.exit(1);
        }
        if (!treeFile.canRead()) {
            System.err.println("Error: the file " + treeFile.getAbsolutePath() +
                    " cannot be opened.\n");
            System.exit(1);
        }

        //open the file for reading
        Scanner inTrees = null;


        try {
            inTrees = new Scanner(treeFile);
        } catch (FileNotFoundException e) {
            System.err.println("Error: the file " + treeFile.getAbsolutePath() +
                    " cannot be opened.\n");
            System.exit(1);
        }


        //read the content of the file and save the data in a list of trees
        TreeList finalTreeList = new TreeList();
        String line = null;
        Scanner parseLine = null;
        String treeIDString = null;
        int treeId = 0;
        String status = null;
        String health = null;
        String spc_latin = null;
        String spc_common = null;
        String zipcodeString = null;
        int zipcode = 0;
        String boroname = null;
        double x_sp = 0;
        double y_sp = 0;

        Tree current = null;
        TreeSpeciesList treeSpeciesList = new TreeSpeciesList();

        //Opens CSV file using CSV class and creates an array list that stores common names
        CSV one = new CSV(inTrees);
        ArrayList<String> rowCount = new ArrayList<>();


        //Iterates through CSV rows extracting information and using setter methods to create Tree and TreeSpecies classes
        //Then taking these Tree and TreeSpecies classes and putting them in TreeList and TreeSpeciesList classes
        for (int i = 0; i < one.getNumOfRows(); i++) {

            try {
                rowCount = one.getNextRow();
                TreeSpecies test = new TreeSpecies(rowCount.get(9), rowCount.get(8));
                treeSpeciesList.add(test);

                Tree t = new Tree(Integer.parseInt(rowCount.get(0)), test);
                t.setStatus(rowCount.get(6));
                t.setHealth(rowCount.get(7));
                t.setTree_id(Integer.parseInt(rowCount.get(0)));
                t.setBoroname(rowCount.get(29));
                finalTreeList.add(t);


            } catch (NumberFormatException e) {

                //In case of in correct format

                System.err.println("Number Format Exception");
            }

        }

        //Create scanner for user input
        Scanner userInput = new Scanner(System.in);
        String userValue = "";


        do {
            System.out.println("Enter the tree species to learn more about it (\"quit\" to stop):\n");
            //get value of from the user
            userValue = userInput.nextLine();
            userValue = userValue.toLowerCase();


            //Takes all unique species names and assigns them to a list
            ArrayList<String> testValues = new ArrayList<String>();
            int totalCommonName = 0;
            int totalLatinName = 0;

            //Iterates through each item in the list to accumulate total values
            if (!userValue.equalsIgnoreCase("quit")) {
                System.out.println("All matching species:");
                for (TreeSpecies type : treeSpeciesList) {
                    String compareCommonLowercase = type.varCommonName.toLowerCase();

                    if (compareCommonLowercase.contains(userValue) || compareCommonLowercase.startsWith(userValue)) {

                        if (!testValues.contains(compareCommonLowercase)) {
                            testValues.add(compareCommonLowercase);

                        }
                        totalCommonName++;

                    }


                    String compareLatinLowercase = type.varLatinName.toLowerCase();
                    if (compareLatinLowercase.contains(userValue.toLowerCase()) || compareLatinLowercase.startsWith(userValue)) {


                        if (!testValues.contains(compareLatinLowercase)) {
                            testValues.add(compareLatinLowercase);

                        }

                        totalLatinName++;

                    }


                }

            }


            //Number and Decimal Formatting
            NumberFormat myFormat = NumberFormat.getInstance();
            myFormat.setGroupingUsed(true);
            DecimalFormat df = new DecimalFormat("0.00");
            DecimalFormat df1 = new DecimalFormat("0");
            df1.setGroupingUsed(true);
            df1.setGroupingSize(3);

            //Alphabetize the ArrayList
            Collections.sort(testValues);
            int h = totalLatinName + finalTreeList.getCountByCommonName(userValue);

            //All values columns
            int NYCColumn1 = 0;
            String NYCColumn2 = df1.format(finalTreeList.getTotalNumberOfTrees());

            int manhattanColumn1 = 0;
            String manhattanColumn2 = df1.format(finalTreeList.getCountByBorough("Manhattan"));

            int bronxColumn1 = 0;
            String bronxColumn2 = df1.format(finalTreeList.getCountByBorough("Bronx"));

            int brooklynColumn1 = 0;
            String brooklynColumn2 = df1.format(finalTreeList.getCountByBorough("Brooklyn"));

            int queensColumn1 = 0;
            String queensColumn2 = df1.format(finalTreeList.getCountByBorough("Queens"));

            int statenIslandColumn1 = 0;
            String statenIslandColumn2 = df1.format(finalTreeList.getCountByBorough("Staten Island"));


            //Set column values to totals and print Matching Species
            for (String i : testValues) {
                System.out.println("\t" + i);
                NYCColumn1 += finalTreeList.getCountByLatinName(i) + finalTreeList.getCountByCommonName(i);
                manhattanColumn1 += finalTreeList.getCountByLatinNameBorough(i, "Manhattan") + finalTreeList.getCountByCommonNameBorough(i, "Manhattan");
                bronxColumn1 += finalTreeList.getCountByLatinNameBorough(i, "Bronx") + finalTreeList.getCountByCommonNameBorough(i, "Bronx");
                brooklynColumn1 += finalTreeList.getCountByLatinNameBorough(i, "Brooklyn") + finalTreeList.getCountByCommonNameBorough(i, "Brooklyn");
                queensColumn1 += finalTreeList.getCountByLatinNameBorough(i, "Queens") + finalTreeList.getCountByCommonNameBorough(i, "Queens");
                statenIslandColumn1 += finalTreeList.getCountByLatinNameBorough(i, "Staten Island") + finalTreeList.getCountByCommonNameBorough(i, "Staten Island");


            }

            //Set column values for percentage by dividing both previous column values
            String NYCColumn3 = df.format((double) (NYCColumn1) / (double) finalTreeList.getTotalNumberOfTrees() * 100);
            String manhattanColumn3 = df.format(100 * (double) (manhattanColumn1) / (double) finalTreeList.getCountByBorough("Manhattan"));
            String bronxColumn3 = df.format(100 * (double) (bronxColumn1) / (double) finalTreeList.getCountByBorough("Bronx"));
            String brooklynColumn3 = df.format(100 * (double) (brooklynColumn1) / (double) finalTreeList.getCountByBorough("Brooklyn"));
            String queensColumn3 = df.format(100 * (double) (queensColumn1) / (double) finalTreeList.getCountByBorough("Queens"));
            String statenIslandColumn3 = df.format(100 * (double) (statenIslandColumn1) / (double) finalTreeList.getCountByBorough("Staten Island"));

        if(userValue.equals("quit")){

            System.exit(1);


        }

        if(manhattanColumn1==0 && bronxColumn1==0  && brooklynColumn1==0  && queensColumn1==0  && statenIslandColumn1==0 ) {

                System.out.println("There are no records of " + userValue + " on NYC streets");

            }else {
                //Print values in print format method
                System.out.println();
                System.out.printf("  " + "%-30s %-20s %-10s\n", "NYC", df1.format(NYCColumn1) + "(" + NYCColumn2 + ")", NYCColumn3 + "%");
                System.out.printf("  " + "%-30s %-20s %-10s\n", "Manhattan", df1.format(manhattanColumn1) + "(" + manhattanColumn2 + ")", manhattanColumn3 + "%");
                System.out.printf("  " + "%-30s %-20s %-10s\n", "Bronx", df1.format(bronxColumn1) + "(" + bronxColumn2 + ")", bronxColumn3 + "%");
                System.out.printf("  " + "%-30s %-20s %-10s\n", "Brooklyn", df1.format(brooklynColumn1) + "(" + brooklynColumn2 + ")", brooklynColumn3 + "%");
                System.out.printf("  " + "%-30s %-20s %-10s\n", "Queens", df1.format(queensColumn1) + "(" + queensColumn2 + ")", queensColumn3 + "%");
                System.out.printf("  " + "%-30s %-20s %-10s\n", "Staten Island", df1.format(statenIslandColumn1) + "(" + statenIslandColumn2 + ")", statenIslandColumn3 + "%");

                }
            }


        while (!userValue.equalsIgnoreCase("quit"));

        userInput.close();
    }
}
