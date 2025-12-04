package service;

public interface Service<T> {

	public T search(long id);
	public void printAllEntries();
}