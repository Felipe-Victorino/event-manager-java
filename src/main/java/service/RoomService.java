package service;

import dao.RoomDao;
import model.Room;

import java.util.List;

public class RoomService implements Service<Room>{

	private final RoomDao dao = new RoomDao();

	public Room create(Room room){
		return createRoom(room.getName(), room.getDescription(), room.getMaxCapacity());
	}

	public Room createRoom(String name, String description, int capacity){
		Room room = new Room();
		room.setName(name);
		room.setDescription(description);
		room.setMaxCapacity(capacity);
		dao.insert(room);
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

	public Room update(Room room, String name, String desc, int capacity){
		room.setName(name);
		room.setDescription(desc);
		room.setMaxCapacity(capacity);
		return this.dao.update(room);
	}

	public Room delete(Room room) {
		return this.dao.delete(room);
	}
}