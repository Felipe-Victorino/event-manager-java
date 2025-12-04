package controller;

import model.Participant;
import service.ParticipantService;

public class ParticipantController extends Controller<ParticipantService, Participant> {

	public ParticipantController(){
		super(new ParticipantService());
	}

	public void create(){
		System.out.println("New Participant, insert the data in the following inputs: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("CPF: ");
		String cpf = sc.nextLine();
		sc.nextLine();
		this.service.createParticipant(name, cpf);
	}

	public void readAll(){
		this.service.printAllEntries();
	}

	public void update(){
		Participant part = searchById();
		String cpf = this.sc.nextLine();
		String name = this.sc.nextLine();
		this.service.updateParticipant(part, cpf, name);
	}

	public void delete(){
		String cpf = this.sc.nextLine();
		this.service.removeParticipant(cpf);
	}

	public Participant search(){
		System.out.println("Search Participant, insert their cpf");
		System.out.print("CPF: ");
		String cpf = sc.nextLine();
		return this.service.search(cpf);
	}

	public Participant searchById(){
		long id = sc.nextLong();
		return this.service.search(id);
	}
}