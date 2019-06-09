package model;

/**
 * An interface for the classes who must plant trees
 *  
 * @author Mateo Valdes
 *
 */
public interface TreePlanter {
	
	/**
	 * The classes that implement this interface must calculate the number of trees they must plant
	 * 
	 * @return A number representing the trees that must be planted
	 */
	int calculateTrees();
	
}
