package BUS;

import java.util.List;

public interface BaseInterfaceBUS<T> {
	public boolean insert(T obj);
	public List<T> getList(String sql);
	public boolean delete(T obj);
	public boolean update(T obj);
}
