package controller;

import service.SessionService;

public class SessionController extends Controller<SessionService> {

	public SessionController(){
		super(new SessionService());
	}
}