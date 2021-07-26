package app.delivery.model.dao.start_env.data;

import app.delivery.model.dao.utils.ConnectionFactory;
import java.sql.Connection;
import java.sql.Statement;

public class CreatePizza {

    private static Statement query = null;
    private static Connection con = null;

    public static void main(String[] args) {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            con = factory.getConnection();
            query = con.createStatement();

            query.executeUpdate("INSERT INTO pizza (id_pedido, id_forma) VALUES (1, 1);");

            query.executeUpdate("INSERT INTO pizza (id_pedido, id_forma) VALUES (1, 2);");

            query.executeUpdate("INSERT INTO pizza (id_pedido, id_forma) VALUES (2, 3);");

            query.executeUpdate("INSERT INTO pizza (id_pedido, id_forma) VALUES (2, 4);");

            query.executeUpdate("INSERT INTO pizza (id_pedido, id_forma) VALUES (3, 5);");

            System.out.println("Pizzas criadas com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao criar ao criar Pizzas.");
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
