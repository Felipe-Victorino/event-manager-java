package service;

public interface Service<T> {


	public void printAllEntries();
	public T delete(T t);
	public T search(long id);
}