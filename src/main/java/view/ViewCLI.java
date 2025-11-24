package view;

import service.ParticipantService;

import java.util.Scanner;

public class ViewCLI {

	private DisplayText text = new DisplayText();
	private Scanner sc = new Scanner(System.in);

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
				case 1:
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
					new ParticipantService().search();
					break;
				case 2:
				default:
					System.out.println("Invalid Option, please select a possible value.");
					break;
			}
		}
	}

}