package controller;

import service.ParticipantService;

public class ParticipantController extends Controller<ParticipantService> {

	public ParticipantController(){
		super(new ParticipantService());
	}

	public void create(){
		createParticipant();
	}

	public void readAll(){
		showAllParticipants();
	}

	public void update(){
		updateParticipant();
	}

	public void delete(){
		deleteParticipant();
	}

	public void createParticipant(){
		System.out.println("New Participant, insert the data in the following inputs: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("CPF: ");
		String cpf = sc.nextLine();
		sc.nextLine();
		this.service.createParticipant(name, cpf);
	}

	public void showAllParticipants(){
		this.service.printAllEntries();
	}

	public void updateParticipant(){
		String cpf = this.sc.nextLine();
		String name = this.sc.nextLine();
		this.service.updateParticipant(cpf, name);
	}

	public void deleteParticipant(){
		String cpf = this.sc.nextLine();
		this.service.removeParticipant(cpf);
	}

	public void searchParticipant(){
		System.out.println("Search Participant, insert their cpf");
		System.out.print("CPF: ");
		String cpf = sc.nextLine();
		this.service.search(cpf);
	}
}