package project2;

import java.util.Objects;

/**
 * This class represents a Tree.
 * It takes to parameters in the constructor which is tree_id and Class TreeSpecies
 * This holds all the tree information that can be accessed through a series of getters and setters
 * It can retrieve information about a tree's id, status, TreeSpecies species, health,spc_latin, spc_latin,
 * spc_common, zipcode, and boroname.
 *
 * @author Vishnu Matta
 *
 */

public class Tree implements Comparable<Tree>{


    //Need to initiate private fields
    private int tree_id;
    private String status;
    public final TreeSpecies species;
    private String health;
    private String spc_latin;
    private String spc_common;
    private int zipcode;
    private String boroname;
    private double x_sp;
    private double y_sp;

    /**
     * Constructs a new Tree object with specified tree_id value and TreeSpecies object.
     * @param tree_id_perm is gathered and placed by the while loop in the main functinon of NYCStreetTrees.java representing the trees ID
     * @param species is gathered and placed by the while loop in the main functinon of NYCStreetTrees.java representing the trees TreeSpecies class
     * @throws IllegalArgumentException  if tree_id_perm or species is null
     */
    public Tree (int tree_id_perm, TreeSpecies species ) throws IllegalArgumentException{

        if(species == null){

            throw new IllegalArgumentException("Species cannot be null.");
        }

        if(tree_id_perm < 0){
            throw new IllegalArgumentException("TreeID cannot be a non-negative number.");

        }


        this.tree_id = tree_id_perm;
        this.species = species;
        this.setSpc_common(species.varCommonName);
        this.setSpc_latin(species.varLatinName);
        this.setTree_id(tree_id);

    }


    //Two objects should be considered equal if their id's and both, Latin and common, species names are the same.
    /**
     * Returns the boolean value of if two Tree objects are equal.
     * @return the boolean value of if two Tree objects are equal.
     */
    public boolean equals(Object obj){

        if(this == obj){
            return true;
        }else if(obj == null){
            return false;
        }else if(!(obj instanceof Tree)){
            return false;
        }else if(spc_common == null){
            return false;
        }else if(this.tree_id == ((Tree) obj).tree_id && this.getSpc_common().equals(((Tree) obj).getSpc_common()) && this.getSpc_common().equals(((Tree) obj).getSpc_common())){

            return true;
        } else {

        return false;
        }


    }

    /**
     * Returns the treeId of this Tree object.
     * @return the treeId of this Tree object.
     */
    public int getTree_id () {
        return tree_id;
    }

    /**
     * Returns the status of this Tree object.
     * @return the status of this Tree object.
     */
    public String getStatus () {
        return this.status;
    }

    /**
     * Returns the health of this Tree object.
     * @return the health of this Tree object.
     */
    public String getHealth () {
        return this.health;
    }

    /**
     * Returns the latin name of this Tree object.
     * @return the latin name of this Tree object.
     */
    public String getSpc_latin () {
        return spc_latin;
    }

    /**
     * Returns the common name of this Tree object.
     * @return the common name of this Tree object.
     */
    public String getSpc_common () {
        return spc_common;
    }

    /**
     * Returns the borough name of this Tree object.
     * @return the borough name of this Tree object.
     */
    public String getBoroname () {
        return this.boroname;
    }

    /**
     * Returns the zipcode of this Tree object.
     * @return the zipcode of this Tree object.
     */
    public int getZipcode  () {
        return zipcode;
    }

    /**
     * Returns the x coordinate of this Tree object.
     * @return the x coordinate of this Tree object.
     */
    public double getX_sp () {
        return x_sp;
    }

    /**
     * Returns the y coordinate of this Tree object.
     * @return the y coordinate of this Tree object.
     */
    public double getY_sp () {
        return y_sp;
    }

    /**
     * Validates and sets the tree_id value for this Tree object.
     * @param tree_id_var user inputted tree_id
     */
    public void setTree_id(int tree_id_var) {
        if(tree_id_var >=0){
            tree_id = tree_id_var;
        } else {
            throw new IllegalArgumentException("tree id must be non-negative number");
        }
    }

    /**
     * Validates and sets the status value for this Tree object.
     * @param status user inputted status
     */
    public void setStatus(String status) {
        if(status.equalsIgnoreCase("Alive")){
            this.status = status;
        } else if(status.equalsIgnoreCase("Dead")){
            this.status = status;
        } else if(status.equalsIgnoreCase("Stump")){
            this.status = status;
        } else if(status.equals("")){
            this.status = status;

        } else if (status.equals(" ")){
            this.status = status;

        } else {
            throw new IllegalArgumentException("Status can only be Alive, Dead, Stump or empty");
        }
    }


    /**
     * Validates and sets the health value for this Tree object.
     * @param health user inputted health
     */
    public void setHealth(String health) {
        if(health.equalsIgnoreCase("Fair")){
            this.health = health;
        } else if(health.equalsIgnoreCase("Good")){
            this.health = health;
        } else if(health.equalsIgnoreCase("Poor")){
            this.health = health;
        } else if(health.equals("")){
            this.health = health;

        } else if (health.equals(" ")){
            this.health = health;

        } else {
            throw new IllegalArgumentException("Health can only be Alive, Dead, Stump or empty");
        }
    }

    /**
     * Validates and sets the latin name value for this Tree object.
     * @param spc_latin user inputted spc_latin
     */
    public void setSpc_latin(String spc_latin) {
        this.spc_latin = spc_latin;
    }

    /**
     * Validates and sets the common name value for this Tree object.
     * @param spc_common user inputted spc_latin
     */
    public void setSpc_common(String spc_common) {
        this.spc_common = spc_common;
    }

    /**
     * Validates and sets the zipcode value for this Tree object.
     * @param zipcode user inputted spc_latin
     * @throws IllegalArgumentException if the Zipcode is negative
     */
    public void setZipcode(int zipcode) {


        if(zipcode>0) {
            this.zipcode = zipcode;
        } else {
            throw new IllegalArgumentException("Zipcode must be positive");
        }
    }

    /**
     * Validates and sets the boroname value for this Tree object.
     * @param boroname user inputted boroname
     * @throws IllegalArgumentException if the boroname is not one of the 5 boroughs.
     */
    public void setBoroname(String boroname) {

        if (boroname.equalsIgnoreCase("Manhattan")) {
            this.boroname = boroname;
        } else if (boroname.equalsIgnoreCase("Bronx")) {
            this.boroname = boroname;
        } else if (boroname.equalsIgnoreCase("Brooklyn")) {
            this.boroname = boroname;
        } else if (boroname.equalsIgnoreCase("Queens")) {
            this.boroname = boroname;
        } else if (boroname.equalsIgnoreCase("Staten Island")) {
            this.boroname = boroname;
        } else {
            throw new IllegalArgumentException("boroname must be manhattan, bronx, brooklyn, queens, or staten island");
        }
    }

    /**
     * Validates and sets the x coordinate value for this Tree object.
     * @param x_sp user inputted x_sp
     */
    public void setX_sp(double x_sp) {
        this.x_sp = x_sp;
    }

    /**
     * Validates and sets the y coordinate value for this Tree object.
     * @param y_sp user inputted y_sp
     */
    public void setY_sp(double y_sp) {
        this.y_sp = y_sp;
    }


    /**
     * Converts Tree Object into a String sentence
     */
    public String toString(){

        return("This tree's ID is " + this.getTree_id() + "and it is located in the borough of " + this.getBoroname());

    }


    /**
     * compareTo function to compare two tree objects
     */
    public int compareTo(Tree tree) {
        if (this.spc_common.equalsIgnoreCase(tree.spc_common)){
            if(this.tree_id<tree.tree_id){
                return -1;
            } else if(this.tree_id == tree.tree_id){
                return 0;
            } else {
                return 1;
            }
        } else if(this.spc_common.compareTo(tree.spc_common)<0){
            return -1;
        } else if(this.spc_common.compareTo(tree.spc_common)>0){
            return 1;
        }
        return 0;
    }

}