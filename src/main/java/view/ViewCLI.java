package view;

import controller.EventController;
import controller.ParticipantController;
import controller.SpeakerController;
import service.EventService;


import java.util.Scanner;

public class ViewCLI {

	private final DisplayText text = new DisplayText();
	private final Scanner sc = new Scanner(System.in);

	public void start(){
		this.text.printTitle();
		mainMenuSwitch();
	}

	private int prompt(){
		sc.next();
		System.out.print("> ");
		return sc.nextInt();
	}

	private void mainMenuSwitch(){
		boolean loop = true;
		this.text.printMenu();
		while(loop){
			int choice = prompt();

			switch (choice){
				case 0:
					System.out.println("Closing ISOLA...");
					loop = false;
					break;
				case 1:
					subMenuUsersSwitch();
					break;
				case 2:
					subMenuEventsSwitch();
					break;
				case 3:
					subMenuRegisterSwitch();
					break;
				case 4:
					break;
				default:
					System.out.println("Invalid Option, please select a possible value.");
					break;
			}
		}

	}

	private void subMenuEventsSwitch(){
		boolean loop = true;
		this.text.subMenuEvents();

		while(loop){
			int choice = prompt();

			switch (choice){
				case 0:
					loop = false;
					text.printMenu();
					break;
				case 1: //Show events
					new EventController().readAll();
					break;
				case 2:
				default:
					System.out.println("Invalid Option, please select a possible value.");
					break;
			}
		}
	}

	private void subMenuRegisterSwitch(){
		boolean loop = true;
		this.text.subMenuRegistros();
		while(loop){
			int choice = prompt();

			switch (choice){
				case 0:
					loop = false;
					text.printMenu();
					break;
				case 1: //events
					this.text.printCRUD("events");
					eventsCRUD();
				case 2: //sessions
					this.text.printCRUD("sessions");
				case 3: //rooms
					this.text.printCRUD("rooms");
				case 4: //users
					usersChoice();
				default:
					System.out.println("Invalid Option, please select a possible value.");
					break;
			}
		}
	}

	private void usersChoice(){
		boolean loop = true;
		System.out.println("==============================");
		System.out.println("1 - Participants");
		System.out.println("2 - Speakers");
		System.out.println("0 - Back");
		System.out.println("==============================");
		while(loop){
			int choice = prompt();

			switch (choice){
				case 0:
					loop = false;
					break;
				case 1: // C
					this.text.printCRUD("participants");
				case 2: // R
					this.text.printCRUD("speakers");
				default:
					System.out.println("Invalid Option, please select a possible value.");
					break;
			}
		}
	}

	private void participantCRUD(){
		boolean loop = true;
		while(loop){
			int choice = prompt();

			switch (choice){
				case 0:
					loop = false;
					break;
				case 1: // C
					new ParticipantController().create();
					break;
				case 2: // R
					new ParticipantController().readAll();
					break;
				case 3: // U
					new ParticipantController().update();
					break;
				case 4: // D
					new ParticipantController().delete();
					break;
				default:
					System.out.println("Invalid Option, please select a possible value.");
					break;
			}
		}
	}

	private void eventsCRUD(){
		boolean loop = true;
		while(loop){
			int choice = prompt();

			switch (choice){
				case 0:
					loop = false;
					break;
				case 1: // C
					break;
				case 2: // R
					break;
				case 3: // U
					break;
				case 4: // D
					break;
				default:
					System.out.println("Invalid Option, please select a possible value.");
					break;
			}
		}
	}

	private void baseChoice(){
		boolean loop = true;
		while(loop){
			int choice = prompt();

			switch (choice){
				case 0:
					loop = false;
					break;
				case 1: // C
					break;
				case 2: // R
					break;
				case 3: // U
					break;
				case 4: // D
					break;
				default:
					System.out.println("Invalid Option, please select a possible value.");
					break;
			}
		}
	}

	private void subMenuUsersSwitch(){
		boolean loop = true;
		this.text.subMenuUsuarios();
		while(loop){
			int choice = prompt();

			switch (choice){
				case 0:
					loop = false;
					text.printMenu();
					break;
				case 1:
					new ParticipantController().search();
					sc.next();
					break;
				case 2: //search speakers
					new SpeakerController().searchByCpf();
				default:
					System.out.println("Invalid Option, please select a possible value.");
					break;
			}
		}
	}

}