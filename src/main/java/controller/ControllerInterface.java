package controller;

public interface ControllerInterface<E> {
	void create();
	void readAll();
	void update();
	void delete();
	E searchById();
}