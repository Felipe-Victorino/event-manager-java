import com.github.javafaker.Faker;
import model.Participant;
import service.ParticipantService;
import service.RoomService;
import service.SpeakerService;

import java.util.Arrays;
import java.util.Locale;
import java.util.Random;

public class BasicData {

	public static void main() {



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
		try {
			for (int i = 0; i < 100; i++) {
				new SpeakerService().createSpeaker(nameGen(), cpfGen());
				Thread.sleep(500L);
			}
		} catch (InterruptedException e){
			System.out.println(e.getMessage());
			System.out.println(Arrays.toString(e.getStackTrace()));
		}
	}

	public static void genParticipant(){
		try {
			for (int i = 0; i < 100; i++) {
				new ParticipantService().createParticipant(nameGen(), cpfGen());
				Thread.sleep(500L);
			}
		} catch (InterruptedException e){
			System.out.println(e.getMessage());
			System.out.println(Arrays.toString(e.getStackTrace()));
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