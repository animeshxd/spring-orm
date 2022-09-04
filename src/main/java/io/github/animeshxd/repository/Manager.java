package io.github.animeshxd.repository;

public interface Manager<T> {
    public T create(T o);
    public T read(int id);
    public T update(T t);
    public T delete(T o);

}
