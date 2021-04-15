package br.com.fabio.igreja.services;

import br.com.fabio.igreja.exceptions.ServiceException;
import java.util.HashMap;
import java.util.List;

public abstract class GenericService<T, ID> {

    public abstract void save(T entity) throws ServiceException;
    public abstract void edit(T entity) throws ServiceException;
    public abstract void remove(T entity) throws ServiceException;  
    public abstract T findById(ID id)throws ServiceException;     
    public abstract List<T> findAll()throws ServiceException;  
    public abstract List<T> findAll(int first, int pageSize, String sortField, boolean ascending, HashMap<String, Object> search) throws ServiceException;  
    public abstract int count(int first, int pageSize, String sortField, boolean ascending, HashMap<String, Object> search) throws ServiceException;  
    public abstract void bootstrap() throws ServiceException;  
}