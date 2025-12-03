package service;

import dao.RegistryDao;
import exceptions.IntervalTreeOverlap;
import model.Participant;
import model.Registry;
import model.Session;
import util.interval.DateInterval;

import java.util.List;

public class RegistryService implements Service{

	private final RegistryDao dao = new RegistryDao();

	public Registry createRegistry(Session session, Participant participant){

		Registry reg = new Registry();
		reg.setSession(session);
		reg.setParticipant(participant);
		dao.insert(reg);
		return reg;
	}

	@Override
	public void printAllEntries() {
		List<Registry> registryList = dao.searchAll();
		for (Registry r : registryList){
			System.out.println(r.toString());
		}
	}

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


		dao.insert(newReg);
	}
}