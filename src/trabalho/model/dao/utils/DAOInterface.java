package trabalho.model.dao.utils;

import trabalho.model.exceptions.DAOException;

import java.util.List;


public interface DAOInterface<T> {
    T buscar(T t) throws DAOException;
    List<T> buscarTodos() throws DAOException;
    void inserir(T t) throws DAOException;
    void remover(T t) throws DAOException;
    void editar(T t) throws DAOException;
}