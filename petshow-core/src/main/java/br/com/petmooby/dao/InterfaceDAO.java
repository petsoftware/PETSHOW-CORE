package br.com.petmooby.dao;

import br.com.petmooby.model.Entidade;


public interface InterfaceDAO<T> {
	public String insert(Entidade entidade) throws Exception;
	public String delete(long codigo) throws Exception;
	public String update(Entidade entidade) throws Exception;
	public T find(long codigo) throws Exception;
}
