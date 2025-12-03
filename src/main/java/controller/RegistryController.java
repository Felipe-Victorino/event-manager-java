package controller;

import service.RegistryService;

public class RegistryController extends Controller<RegistryService> {

	public RegistryController(){
		super(new RegistryService());
	}
}