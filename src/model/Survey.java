package model;

public class Survey {

	public static final String[] QUESTIONS = {	"How satisfied are you with the service provived?",
												"How satisfied are you with the given response time?",
												"How satisfied are you with the service's cost-benefit relationship?"
												};
	private int[] answers;
	private boolean done;
	
	public Survey() {
		answers = new int[3];
		done = false;
	}
	
	public void doSurvey(int a, int b, int c) {
		answers[0] = a;
		answers[1] = b;
		answers[2] = c;
		done = true;
	}
	
	public boolean getDone() {
		return done;
	}
	
}
