package service;

import dao.RoomDao;
import model.Room;

import java.util.List;

public class RoomService implements Service{

	private final RoomDao dao = new RoomDao();

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

	@Override
	public void printAllEntries() {
		List<Room> roomList = dao.searchAll();
		for(Room r : roomList){
			System.out.println(r.toString());
		}
	}

	public Room search(long id){
		return dao.searchBy(id);
	}

	public Room search(String name){
		List<Room> roomList = dao.searchAll();
		for (Room r : roomList){
			if(name.equals(r.getName())){
				return r;
			}
		}
		return null;
	}
}