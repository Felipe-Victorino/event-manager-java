package controller;

import service.ParticipantService;

public class ParticipantController extends Controller<ParticipantService> {

	public ParticipantController(){
		super(new ParticipantService());
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

	public void searchParticipant(){
		System.out.println("Search Participant, insert their cpf");
		System.out.print("CPF: ");
		String cpf = sc.nextLine();
		this.service.search(cpf);
	}
}