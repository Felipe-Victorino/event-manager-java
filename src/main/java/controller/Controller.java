package controller;

import service.ParticipantService;

import java.util.Scanner;

public abstract class Controller<T> {

	protected T service;
	protected Scanner sc = new Scanner(System.in);

	public Controller(T service) {
		this.service = service;
	}

}