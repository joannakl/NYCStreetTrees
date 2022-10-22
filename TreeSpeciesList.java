package project2;

import java.util.ArrayList;

/**
 * TreeSpeciesList class is used to store TreeSpecies objects.
 * The class extends ArrayList
 * @author Vishnu Matta
 *
 */

public class TreeSpeciesList extends ArrayList<TreeSpecies>{

    /**
     * Constructs a new TreeSpeciesList object with no parameters
     */
    public TreeSpeciesList (){

    }

    /**
     * Returns a TreeSpeciesList which is essentially an ArrayList containing TreeSpecies objects for common name.
     * @return a TreeSpeciesList which is essentially an ArrayList containing TreeSpecies objects for common name.
     * @param keyword checks if any TreeSpecies object in the list has a commonName containing the keyword
     */
    public TreeSpeciesList getByCommonName (String keyword){
        TreeSpeciesList testTreeSpeciesList = new TreeSpeciesList();
        if(keyword == null) {
            throw new IllegalArgumentException("String keyword cannot be null");

        }
        for (TreeSpecies treeSpecies: this){
            String commonNameLocal = treeSpecies.varCommonName;
            commonNameLocal = commonNameLocal.toLowerCase();
            keyword = keyword.toLowerCase();
            if(commonNameLocal.contains(keyword)){
                testTreeSpeciesList.add(treeSpecies);
            }
        }

        if(testTreeSpeciesList.size() ==0){
            return null;
        } else{
            return testTreeSpeciesList;
        }

    }

    /**
     * Returns a TreeSpeciesList which is essentially an ArrayList containing TreeSpecies objects for latin name.
     * @return a TreeSpeciesList which is essentially an ArrayList containing TreeSpecies objects for latin name. .
     * @param keyword checks if any TreeSpecies object in the list has a latinName containing the keyword
     */
    public TreeSpeciesList getByLatinName (String keyword){
        TreeSpeciesList testTreeSpeciesList = new TreeSpeciesList();
        if(keyword == null) {
            throw new IllegalArgumentException("String keyword cannot be null");

        }
        for (TreeSpecies treeSpecies: this){
            String latinNameLocal = treeSpecies.varLatinName;
            latinNameLocal = latinNameLocal.toLowerCase();
            keyword = keyword.toLowerCase();
            if(latinNameLocal.contains(keyword)){
                testTreeSpeciesList.add(treeSpecies);
            }
        }

        if(testTreeSpeciesList.size() ==0){
            return null;
        } else{
            return testTreeSpeciesList;
        }


    }

    /**
     * Returns null.
     * @return null.
     */
    public String toString(){

        return null;
    }


}
