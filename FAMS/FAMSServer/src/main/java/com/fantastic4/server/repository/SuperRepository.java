package com.fantastic4.server.repository;

import java.util.List;

public interface SuperRepository<T, ID> {

    boolean save(T t)throws Exception;

    boolean delete(ID id)throws Exception;

    boolean update(T t)throws Exception;

    T findById(ID id)throws Exception;

    List<T> findAll() throws Exception;

}
