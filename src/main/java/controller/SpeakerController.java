package controller;

import model.Speaker;
import service.SpeakerService;

public class SpeakerController extends Controller<SpeakerService, Speaker> {
	public SpeakerController() {
		super(new SpeakerService());
	}

	public void create() {
		System.out.println("New Speaker, insert the data in the following inputs: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("CPF: ");
		String cpf = sc.nextLine();
		sc.nextLine();

		this.service.createSpeaker(name, cpf);
	}

	public void readAll() {
		this.service.printAllEntries();
	}

	public void searchByCpf(){
		System.out.println("Search speaker, insert their cpf");
		System.out.print("CPF: ");
		String cpf = sc.nextLine();
		this.service.searchSpeaker(cpf);
	}

	public Speaker searchById(){
		long id = sc.nextLong();
		return this.service.search(id);
	}

	public void update() {
		Speaker speak = searchById();
		String cpf = this.sc.nextLine();
		String name = this.sc.nextLine();
		this.service.updateSpeaker(speak, cpf, name);
	}

	public void delete() {

	}
}