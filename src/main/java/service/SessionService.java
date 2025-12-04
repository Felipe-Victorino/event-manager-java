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

public class SessionService implements Service<Session>{

	private final SessionDao dao = new SessionDao();

	public Session create(Room room, Date startDate, Date startTime, Date endTime){
		Session session = new Session();
		session.setDate(startDate);
		session.setStartTime(startTime);
		session.setEndTime(endTime);
		session.setRoom(room);
		session.setParticipants(new ArrayList<>());
		dao.insert(session);
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

	public Session search(long id){
		return this.dao.searchBy(id);
	}

	public List<Session> searchAllSessionsByDate(Date date){
		List<Session> sessionList = this.dao.searchAll();
		List<Session> sessionsOnDate = new ArrayList<>();
		for (Session s : sessionList){
			if (date.equals(s.getDate())){
				sessionsOnDate.add(s);
			}
		}
		return sessionsOnDate;
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
		return this.dao.searchAll();
	}
}