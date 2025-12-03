package controller;

import model.Event;
import service.EventService;

import java.util.Date;

public class EventController extends Controller<EventService>{

	public EventController(){
		super(new EventService());
	}

	public void create(){
		createEvent();
	}

	public void update() {
		updateEvent();
	}

	public void readAll() {
		showAllEvents();
	}

	public void delete() {
		deleteEvent();
	}

	public void createEvent(){
		String name = sc.nextLine();
		Date start = parseDate();
		Date end = parseDate();

		this.service.createEvent(name, start, end);
	}

	public void showAllEvents(){
		this.service.printAllEntries();
	}

	public void searchEvent(){
		String name = sc.nextLine();
		this.service.printAllEventsWithName(name);
	}
	public void updateEvent(){
		String name = sc.nextLine();
		long id = sc.nextLong();
		Event event = this.service.searchEventByID(id);
		this.service.updateEventName(event, name);
	}

	public void deleteEvent(){
		long id = sc.nextLong();
		Event event = this.service.searchEventByID(id);

		this.service.deleteEvent(event);
	}
}