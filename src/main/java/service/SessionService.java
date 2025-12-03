package service;

import dao.SessionDao;
import model.Participant;
import model.Registry;
import model.Room;
import model.Session;
import util.interval.DateInterval;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SessionService implements Service{

	private final SessionDao dao = new SessionDao();

	public Session createSession(Room room, Date startDate, Date startTime, Date endTime){
		Session session = new Session();
		session.setDate(startDate);
		session.setStartTime(startTime);
		session.setEndTime(endTime);
		session.setRoom(room);
		session.setParticipants(new ArrayList<Registry>());
		return session;
	}

	public void confirmPresence(Registry registry, Session session){
		session.getParticipants().add(registry);
	}

	@Override
	public void printAllEntries() {
		List<Session> sessionList = dao.searchAll();
		for(Session s : sessionList){
			System.out.println(s.toString());
		}
	}

	public DateInterval getSessionTimeInterval(Session session){
		return new DateInterval(session.getStartTime(), session.getEndTime());
	}

	public List<Session> getAllSessionsWPart(Participant participant){
		List<Session> thisPartList = new ArrayList<>();
		for(Session s : getAllSessions()){
			for(Registry p : s.getParticipants()){
				if (p.getParticipant().equals(participant)){
					thisPartList.add(s);
				}
			}
		}
		return thisPartList;
	}

	public List<Session> getAllSessions(){
		return dao.searchAll();
	}
}