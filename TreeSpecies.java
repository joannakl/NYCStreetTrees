package project2;

import java.util.Objects;

/**
 * TreeSpecies class is used to store a Tree's two main species names: common and latin.
 * The class is typically created to be put inside a Tree class constructor. Also is used
 * to populate TreeSpeciesList
 * @author Vishnu Matta
 *
 */
public class TreeSpecies {

    String varCommonName;
    String varLatinName;


    /**
     * Constructs a new TreeSpecies object with specified common name and latin name.
     * @param commonName represents the common name of a tree. Example: american elm
     * @param latinName represents the latin name of a tree. Example: carpinus betulus
     * @throws IllegalArgumentException  if either parameter is null
     */
    public TreeSpecies(String commonName, String latinName) throws IllegalArgumentException {

        if (commonName == null) {
            throw new IllegalArgumentException("project2.TreeSpecies Name cannot be null.");
        }

        if (latinName == null) {

            throw new IllegalArgumentException("LatinName Name cannot be null.");

        }

        varCommonName = commonName;
        varLatinName = latinName;

    }
    /**
     * Returns the boolean value representing if the two compared objects are equal.
     * @return the boolean value of the comparison of the two objects.
     */
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null){
            return false;

        }

        if (!(obj instanceof  TreeSpecies)){
            return false;

        }

        TreeSpecies other = (TreeSpecies) obj;
        if(varCommonName == null){
            if(other.varCommonName != null){
                return false;
            }
        } else if(!varCommonName.equalsIgnoreCase(other.varCommonName)){

            return false;
        } else if(varLatinName==null){
            if(other.varLatinName != null){
                return false;
            }
        } else if(!(varLatinName.equalsIgnoreCase(other.varLatinName))){
            return false;
        }
        return true;


    }
}




