package model;

/**
 * An interface for the classes who must pay the procultura tax
 * 
 * @author Mateo Valdes
 *
 */
public interface ProculturaTax {

	/**
	 * The classes that implement this interface must calculate the procultura tax
	 * 
	 * @return A double with the procultura tax
	 */
	double calculateProculturaTax();
	
}
