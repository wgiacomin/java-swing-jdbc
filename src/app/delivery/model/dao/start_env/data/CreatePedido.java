package app.delivery.model.dao.start_env.data;

import app.delivery.model.dao.utils.ConnectionFactory;
import java.sql.Connection;
import java.sql.Statement;

public class CreatePedido {

    private static Statement query = null;
    private static Connection con = null;

    public static void main(String[] args) {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            con = factory.getConnection();
            query = con.createStatement();

            query.executeUpdate("INSERT INTO pedido (id_cliente, valor_total) VALUES (1, 30);");

            query.executeUpdate("INSERT INTO pedido (id_cliente, valor_total) VALUES (2, 45);");

            query.executeUpdate("INSERT INTO pedido (id_cliente, valor_total) VALUES (3, 50);");

            query.executeUpdate("INSERT INTO pedido (id_cliente, valor_total) VALUES (4, 60);");

            query.executeUpdate("INSERT INTO pedido (id_cliente, valor_total) VALUES (5, 70);");

            System.out.println("Pedidos criados com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao criar ao criar Pedidos.");
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
