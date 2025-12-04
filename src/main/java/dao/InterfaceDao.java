package dao;

import java.util.List;

public interface InterfaceDao<T> {

    public T insert(T t);
    public T delete(T t);
    public T update(T t);
    public T searchBy(long id);
    public List<T> searchAll();

}