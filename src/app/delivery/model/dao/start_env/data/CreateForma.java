package app.delivery.model.dao.start_env.data;

import app.delivery.model.dao.utils.ConnectionFactory;
import java.sql.Connection;
import java.sql.Statement;

public class CreateForma {

    private static Statement query = null;
    private static Connection con = null;

    public static void main(String[] args) {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            con = factory.getConnection();
            query = con.createStatement();

            query.executeUpdate("INSERT INTO forma (medida, tipo_forma) VALUES (300, 2);");

            query.executeUpdate("INSERT INTO forma (medida, tipo_forma) VALUES (350, 3);");

            query.executeUpdate("INSERT INTO forma (medida, tipo_forma) VALUES (400, 1);");

            query.executeUpdate("INSERT INTO forma (medida, tipo_forma) VALUES (200, 3);");
            
            query.executeUpdate("INSERT INTO forma (medida, tipo_forma) VALUES (250, 2);");

            System.out.println("Formas criadas com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao criar ao criar Formas.");
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
