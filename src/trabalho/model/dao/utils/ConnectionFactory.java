package trabalho.model.dao.utils;

import trabalho.model.exceptions.DAOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/java";
    private static final String LOGIN = "postgres";
    private static final String SENHA = "postgres";

    private Connection con = null;

    public Connection getConnection() throws DAOException {
        if (con == null) {
            try {
                Class.forName(DRIVER);
                con = DriverManager.getConnection(URL, LOGIN, SENHA);
            } catch (ClassNotFoundException e) {
                throw new DAOException("Driver do banco não encontrado: "
                        + DRIVER, e);

            } catch (SQLException e) {
                throw new DAOException("Erro conectando ao BD: " + URL + "/"
                        + LOGIN + "/" + SENHA, e);
            }
        }
        return con;
    }
}
