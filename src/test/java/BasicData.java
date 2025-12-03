import com.github.javafaker.Faker;
import model.Participant;
import service.EventService;
import service.ParticipantService;
import service.RoomService;
import service.SpeakerService;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class BasicData {

	//Perguntar como fazer a população da base de dados sem o limite de conexões

	public static void main() {
		System.out.println("Test class");



	}

	public static void genEvent(){
		Faker faker = new Faker(new Locale("pt-BR"));
		Date start = new Date(2025-1900, Calendar.JANUARY, 1);
		//para inserir o date dessa forma tem que se tirar 1900 do ano
		Calendar c= Calendar.getInstance();
		c.setTime(start);
		c.add(Calendar.DATE, 30);
		Date end = c.getTime();
		new EventService().createEvent(faker.job().field(), start, end);
	}

	public static Date randomDate(int min, int max){ //função quebrada
		int minday = (int) new Date(min -1900, Calendar.JANUARY, 1).getTime();
		int maxday = (int) new Date(max -1900, Calendar.DECEMBER, 1).getTime();
		long randomDay = minday + new Random().nextInt(maxday - minday);

		return new Date(randomDay);
	}

	public static Date randomDateBeforeNow(){
		return new Date(new Date().getTime() - new Random().nextInt());
	}

	public static Date randomDateAfterNow(){
		return new Date(new Date().getTime() + new Random().nextInt());
	}

	public static String cpfGen(){
		Random rd = new Random();
		return Long.toString(rd.nextLong(99999999999L));
	}

	public static String nameGen(){
		@SuppressWarnings("deprecation")
		Faker faker = new Faker(new Locale("pt-BR"));
		return faker.name().fullName();
	}

	public static void genSpeaker(){
		SpeakerService server = new SpeakerService();
		for (int i = 0; i < 100; i++) {
			server.createSpeaker(nameGen(), cpfGen());
		}


	}

	public static void genParticipant(){
		ParticipantService server = new ParticipantService();
		for (int i = 0; i < 1000; i++) {
			server.createParticipant(nameGen(), cpfGen());
		}
	}

	public static void genRooms(){
		new RoomService().addNewRoom(new RoomService().createRoom("Sala 1", "Zenith", 500));
		new RoomService().addNewRoom(new RoomService().createRoom("Sala 2", "Shakermaker", 400));
		new RoomService().addNewRoom(new RoomService().createRoom("Sala 3", "Iikon", 300));
		new RoomService().addNewRoom(new RoomService().createRoom("Sala 4", "Mosaik", 200));
		new RoomService().addNewRoom(new RoomService().createRoom("Sala 5", "Azimuth", 100));
	}
}