package service;

import dao.SessionDao;
import model.Participant;
import model.Room;
import model.Session;
import util.interval.DateInterval;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SessionService {

	private SessionDao dao = new SessionDao();

	public Session createSession(Room room, Date startDate, Date startTime, Date endTime){
		Session session = new Session();
		session.setDate(startDate);
		session.setStartTime(startTime);
		session.setEndTime(endTime);
		session.setRoom(room);
		session.setParticipants(new ArrayList<Participant>());
		return session;
	}

	public void confirmPresence(Session session, Participant participant){
		session.getParticipants().add(participant);
	}

	public DateInterval getSessionTimeInterval(Session session){
		return new DateInterval(session.getStartTime(), session.getEndTime());
	}

	public List<Session> getAllSessionsWPart(Participant participant){
		List<Session> thisPartList = new ArrayList<>();
		for(Session s : getAllSessions()){
			for(Participant p : s.getParticipants()){
				if (p.equals(participant)){
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