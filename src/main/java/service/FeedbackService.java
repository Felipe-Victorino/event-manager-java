package service;

import dao.FeedbackDao;
import model.Feedback;
import model.Session;

public class FeedbackService {

	private FeedbackDao dao = new FeedbackDao();

	public Feedback createFeedback(Session session){
		Feedback feedback = new Feedback();
		feedback.setPredictedCapacity(session.getPredictedCapacity());
		feedback.setFinalCapacity(session.getParticipants().size());

		return feedback;
	}

	public double calculateScore(Feedback feedback){
		return (double) feedback.getFinalCapacity();
	}
}