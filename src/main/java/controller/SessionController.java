package controller;

import model.Room;
import model.Session;
import service.SessionService;

import java.util.Date;
import java.util.List;

public class SessionController extends Controller<SessionService, Session> {

	public SessionController(){
		super(new SessionService());
	}

	public void create(){
		Room room = new RoomController().searchRoomByName();
		Date day = this.parseDate();
		Date start = this.parseTime(day);
		Date end = this.parseTime(day);
		this.service.createSession(room, day, start, end);
	}

	public void readAll(){
		this.service.printAllEntries();
	}

	public Session searchById(){
		long id = sc.nextLong();
		return this.service.search(id);
	}

	public List<Session> searchByDate(){
		Date date = this.parseDate();
		return this.service.searchAllSessionsByDate(date);
	}

	public void update() {

	}

	public void delete() {

	}
}