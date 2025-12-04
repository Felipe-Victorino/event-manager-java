package service;

import dao.EventDao;
import model.Event;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventService implements Service<Event>{

	private final EventDao dao = new EventDao();

	public Event update(Event event, String name){
		event.setName(name);
		this.dao.update(event);
		return event;
	}

	public Event create(String name, Date start, Date end){
		Event event = new Event();
		event.setName(name);
		event.setStartDate(start);
		event.setEndDate(end);

		this.dao.insert(event);
		return event;
	}

	public void printAllEntries() {
		List<Event> eventList = this.dao.searchAll();
		for(Event e : eventList){
			System.out.println(e.toString());
		}
	}

	public void printAllEventsWithName(String name){
		List<Event> eventList = searchEventByName(name);
		for(Event e : eventList){
			System.out.println(e.toString());
		}
	}

	public Event delete(Event event){
		return this.dao.delete(event);
	}

	public List<Event> searchEventByName(String name){
		List<Event> eventList = this.dao.searchAll();
		List<Event> finalList = new ArrayList<>();
		for(Event e : eventList){
			if(e.getName().contains(name)){
				finalList.add(e);
			}
		}
		return finalList;
	}

	public Event search(long id){
		return this.dao.searchBy(id);
	}
}