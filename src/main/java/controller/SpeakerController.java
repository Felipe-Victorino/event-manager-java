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

		this.service.create(name, cpf);
	}

	public void readAll() {
		this.service.printAllEntries();
	}

	public Speaker searchByCpf(){
		System.out.println("Search speaker, insert their cpf");
		System.out.print("CPF: ");
		String cpf = sc.nextLine();
		return this.service.searchSpeaker(cpf);
	}

	public Speaker searchById(){
		long id = sc.nextLong();
		return this.service.search(id);
	}

	public void update() {
		Speaker speak = searchByCpf();
		String cpf = this.sc.nextLine();
		String name = this.sc.nextLine();
		this.service.update(speak, cpf, name);
	}

	public void delete() {
		Speaker speak = searchByCpf();
		this.service.delete(speak);
	}
}