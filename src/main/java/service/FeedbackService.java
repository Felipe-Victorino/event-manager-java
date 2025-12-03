package service;

import dao.FeedbackDao;
import model.Feedback;
import model.Session;

import java.util.List;

public class FeedbackService implements Service{

	private final FeedbackDao dao = new FeedbackDao();

	public Feedback createFeedback(Session session){
		Feedback feedback = new Feedback();
		feedback.setSession(session);
		feedback.setPredictedCapacity(session.getPredictedCapacity());
		feedback.setFinalCapacity(session.getParticipants().size());

		return feedback;
	}

	@Override
	public void printAllEntries() {
		List<Feedback> feedbackList = dao.searchAll();
		for (Feedback f : feedbackList){
			System.out.println(f.toString());
		}
	}

	public double calculateScore(Feedback feedback){
		return (double) feedback.getFinalCapacity();
	}
}