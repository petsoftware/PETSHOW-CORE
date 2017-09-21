package br.com.petshow.role;

public interface EntityInterfaceRole<T> {
	public String insert(T entidade) throws Exception;
	public String delete(long codigo) throws Exception;
	public String update(T entidade) throws Exception;
	public T find(long codigo) throws Exception;
}
