package app.delivery.model.dao.start_env.data;

import app.delivery.model.dao.utils.ConnectionFactory;
import java.sql.Connection;
import java.sql.Statement;

public class CreateTipoSabor {

    private static Statement query = null;
    private static Connection con = null;

    public static void main(String[] args) {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            con = factory.getConnection();
            query = con.createStatement();

            query.executeUpdate("INSERT INTO tipo_sabor (nome, custo) VALUES ('Simples', 0.5);");

            query.executeUpdate("INSERT INTO tipo_sabor (nome, custo) VALUES ('Especial', 0.75);");
            
            query.executeUpdate("INSERT INTO tipo_sabor (nome, custo) VALUES ('Premium', 1);");

            System.out.println("Tipos de sabores criados com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao criar ao criar Tipos de sabores.");
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                    con = null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (query != null) {
                try {
                    query.close();
                    query = null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
