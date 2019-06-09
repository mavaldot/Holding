package model;

public class Survey {

	public static final String[] QUESTIONS = {	"How satisfied are you with the service provived?",
												"How satisfied are you with the given response time?",
												"How satisfied are you with the service's cost-benefit relationship?"
												};
	private int[] answers;
	private boolean done;
	
	/**
	 * Class constructor
	 * <p>
	 * post: answers is now initalized and all its elements are equal to zero <br>
	 * post: <code> done = false </code> 
	 */
	public Survey() {
		answers = new int[3];
		answers[0] = 0;
		answers[1] = 0;
		answers[2] = 0;
		done = false;
	}
	
	/**
	 * Fills the elements of the answer array with the answers provided
	 * <p>
	 * post: <code> done = true </code>
	 * @param a The answer to the first question of the survey
	 * @param b The answer to the second question of the survey
	 * @param c The answer to the third question of the survey
	 */
	public void doSurvey(int a, int b, int c) {
		answers[0] = a;
		answers[1] = b;
		answers[2] = c;
		done = true;
	}
	
	/**
	 * Returns whether the survey is done
	 * 
	 * @return true if the survey is done, false if it has not been completed yet
	 */
	public boolean getDone() {
		return done;
	}
	
	/**
	 * Calculates the average based on the answers
	 * 
	 * @return A number between 1 and 5 representing the average
	 */
	public double calculateAverage() {
		double avg = 0;
		double total = 0;
		if(done) {
			for(int ans : answers) {
				total += ans;
			}
			avg = total/answers.length;
		}
		
		return avg;
	}
	
}
