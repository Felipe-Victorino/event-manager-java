package service;

import dao.RegistryDao;
import exceptions.IntervalTreeOverlap;
import model.Participant;
import model.Registry;
import model.Session;
import util.interval.DateInterval;

import java.util.List;

public class RegistryService implements Service<Registry>{

	private final RegistryDao dao = new RegistryDao();

	@Override
	public void printAllEntries() {
		List<Registry> registryList = dao.searchAll();
		for (Registry r : registryList){
			System.out.println(r.toString());
		}
	}

	public Registry createRegistry(Participant part, Session sess){
		Registry newReg = new Registry();

		List<Session> sessionsWPart = new SessionService().getAllSessionsWPart(part);
		part = new ParticipantService().setPastEntries(part);

		DateInterval interval = new DateInterval(sess.getStartTime(), sess.getEndTime());

		try{
			part.getIntervalTree().add(interval);
		} catch (IntervalTreeOverlap e){
			System.out.println(e.getMessage());
		}

		newReg.setParticipant(part);
		newReg.setSession(sess);


		dao.insert(newReg);
		return newReg;
	}

	public Registry search(long id) {
		return this.dao.searchBy(id);
	}

	public Registry update(Registry registry, Participant part, Session sess){
		registry.setSession(sess);
		registry.setParticipant(part);
		this.dao.update(registry);
		return registry;
	}

	public Registry delete(Registry registry){
		return this.dao.delete(registry);
	}
}