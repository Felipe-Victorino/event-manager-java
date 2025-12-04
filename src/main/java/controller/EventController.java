package controller;

import model.Event;
import service.EventService;

import java.util.Date;

public class EventController extends Controller<EventService, Event>{

	public EventController(){
		super(new EventService());
	}

	public void create(){
		String name = sc.nextLine();
		Date start = parseDate();
		Date end = parseDate();

		this.service.create(name, start, end);
	}

	public void readAll(){
		this.service.printAllEntries();
	}

	public void search(){
		String name = sc.nextLine();
		this.service.printAllEventsWithName(name);
	}

	public Event searchById() {
		long id = sc.nextLong();
		return this.service.search(id);
	}

	public void update(){
		String name = sc.nextLine();
		long id = sc.nextLong();
		Event event = this.service.search(id);
		this.service.update(event, name);
	}

	public void delete(){
		long id = sc.nextLong();
		Event event = this.service.search(id);

		this.service.delete(event);
	}
}