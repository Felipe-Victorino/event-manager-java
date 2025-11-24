package service;

import dao.RegistryDao;
import exceptions.IntervalTreeOverlap;
import model.Participant;
import model.Registry;
import model.Session;
import util.interval.DateInterval;

import java.util.List;

public class RegistryService {

	private RegistryDao dao = new RegistryDao();

	public void createRegistry(Participant part, Session sess){
		Registry newReg = new Registry();

		List<Session> sessionsWPart = new SessionService().getAllSessionsWPart(part);

		DateInterval interval = new DateInterval(sess.getStartTime(), sess.getEndTime());

		try{
			part.getIntervalTree().add(interval);
		} catch (IntervalTreeOverlap e){
			System.out.println(e.getMessage());
		}

		newReg.setParticipant(part);
		newReg.setSession(sess);
		newReg.setFeedback();

		dao.insert(newReg);
	}
}