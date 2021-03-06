package app.delivery.model.dao.utils;

import app.exceptions.DAOException;

import java.util.List;


public interface DAOInterface<T> {
    T buscar(T t) throws DAOException;
    List<T> buscarTodos() throws DAOException;
    int inserir(T t) throws DAOException;
    void remover(T t) throws DAOException;
    void editar(T t) throws DAOException;
}