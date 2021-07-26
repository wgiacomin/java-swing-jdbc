package app.delivery.model.dao.start_env.data;

import app.delivery.model.dao.utils.ConnectionFactory;
import java.sql.Connection;
import java.sql.Statement;

public class CreatePizzaSabor {

    private static Statement query = null;
    private static Connection con = null;

    public static void main(String[] args) {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            con = factory.getConnection();
            query = con.createStatement();

            query.executeUpdate("INSERT INTO pizza_sabor (id_pizza, id_sabor) VALUES (1, 8);");

            query.executeUpdate("INSERT INTO pizza_sabor (id_pizza, id_sabor) VALUES (1, 1);");

            query.executeUpdate("INSERT INTO pizza_sabor (id_pizza, id_sabor) VALUES (2, 10);");

            query.executeUpdate("INSERT INTO pizza_sabor (id_pizza, id_sabor) VALUES (2, 9);");

            query.executeUpdate("INSERT INTO pizza_sabor (id_pizza, id_sabor) VALUES (3, 4);");

            query.executeUpdate("INSERT INTO pizza_sabor (id_pizza, id_sabor) VALUES (4, 3);");
            
            query.executeUpdate("INSERT INTO pizza_sabor (id_pizza, id_sabor) VALUES (4, 7);");
            
            query.executeUpdate("INSERT INTO pizza_sabor (id_pizza, id_sabor) VALUES (5, 3);");

            System.out.println("Relações entre pizza e sabor criadas com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao criar ao criar Relações entre pizza e sabor.");
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
