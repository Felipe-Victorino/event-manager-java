package service;

import dao.RoomDao;
import model.Room;

public class RoomService {

	private RoomDao dao = new RoomDao();

	public void addNewRoom(Room room){
		dao.insert(room);
	}
	public Room createRoom(String name, String description, int capacity){
		Room room = new Room();
		room.setName(name);
		room.setDescription(description);
		room.setMaxCapacity(capacity);
		return room;
	}
}