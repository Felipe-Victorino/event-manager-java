package controller;

import service.SpeakerService;

public class SpeakerController extends Controller<SpeakerService> {
	public SpeakerController() {
		super(new SpeakerService());
	}

	public void searchSpeaker(){
		System.out.println("Search speaker, insert their cpf");
		System.out.print("CPF: ");
		String cpf = sc.nextLine();
		this.service.searchSpeaker(cpf);
	}
}