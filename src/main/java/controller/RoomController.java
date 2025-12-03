package controller;

import service.RoomService;

public class RoomController extends Controller<RoomService>{

	public RoomController(){
		super(new RoomService());
	}
}