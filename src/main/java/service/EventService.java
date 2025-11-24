package service;

import com.sun.xml.fastinfoset.stax.events.EventBase;
import dao.EventDao;
import model.Event;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class EventService {

	EventDao dao = new EventDao();
	Scanner sc = new Scanner(System.in);

	public void createEvent() throws ParseException {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		System.out.print("Insert Event Name: ");
		String name = sc.nextLine();
		sc.next();

		System.out.println("Format: yyyy-MM-dd");
		System.out.print("Insert Event Start Date: ");
		String dateStart = sc.nextLine();
		sc.next();

		Date start = formatter.parse(dateStart);

		System.out.print("Insert Event End Date: ");
		String dateEnd = sc.nextLine();
		sc.next();

		Date end = formatter.parse(dateEnd);

		createEvent(name, start, end);
	}

	public Event createEvent(String name, Date start, Date end){
		Event event = new Event();
		event.setName(name);
		event.setStartDate(start);
		event.setEndDate(end);

		dao.insert(event);
		return event;
	}
}