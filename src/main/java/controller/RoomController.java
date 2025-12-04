package controller;

import model.Room;
import service.RoomService;

public class RoomController extends Controller<RoomService, Room>{

	public RoomController(){
		super(new RoomService());
	}

	public void create() {
		System.out.print("Nome: ");
		String name = sc.nextLine();
		System.out.print("Descrição: ");
		String description = sc.nextLine();
		System.out.print("Capacidade máxima: ");
		int capacity = sc.nextInt();
		this.service.createRoom(name, description, capacity);
	}

	public void update() {
		Room room = searchRoomByName();
		System.out.print("Nome: ");
		String name = sc.nextLine();
		System.out.print("Descrição: ");
		String description = sc.nextLine();
		System.out.print("Capacidade máxima: ");
		int capacity = sc.nextInt();
		this.service.update(room, name, description, capacity);
	}

	public void readAll() {
		this.service.printAllEntries();
	}

	public Room searchRoomByName(){
		String name = this.sc.nextLine();
		return this.service.search(name);
	}

	public Room searchById(){
		long id = this.sc.nextLong();
		return this.service.search(id);
	}

	public void delete() {

	}
}