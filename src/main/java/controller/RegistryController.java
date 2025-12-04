package controller;

import model.Participant;
import model.Registry;
import model.Session;
import service.RegistryService;

public class RegistryController extends Controller<RegistryService, Registry> {

	public RegistryController(){
		super(new RegistryService());
	}

	public void create(){
		Participant part = new ParticipantController().search();
		Session sess = new SessionController().searchById();
	}

	public void readAll() {
		this.service.printAllEntries();
	}

	public Registry searchById() {
		long id = sc.nextLong();
		return this.service.search(id);
	}

	public void update() {
		Registry reg = searchById();
		Participant part = new ParticipantController().search();
		Session sess = new SessionController().searchById();
		this.service.update(reg, part, sess);
	}

	public void delete() {
		Registry reg = searchById();
		this.service.delete(reg);
	}
}