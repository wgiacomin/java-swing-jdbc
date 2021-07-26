package app.delivery.model.dao.start_env.data;

import app.delivery.model.dao.utils.ConnectionFactory;
import java.sql.Connection;
import java.sql.Statement;

public class CreateSabor {

    private static Statement query = null;
    private static Connection con = null;

    public static void main(String[] args) {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            con = factory.getConnection();
            query = con.createStatement();

            query.executeUpdate("INSERT INTO sabor (nome) VALUES ('Calabresa');");

            query.executeUpdate("INSERT INTO sabor (nome) VALUES ('Portuguesa');");
            
            query.executeUpdate("INSERT INTO sabor (nome) VALUES ('Atum');");
            
            query.executeUpdate("INSERT INTO sabor (nome) VALUES ('Baiana');");
            
            query.executeUpdate("INSERT INTO sabor (nome) VALUES ('Brócolis');");
            
            query.executeUpdate("INSERT INTO sabor (nome) VALUES ('Caipira');");
            
            query.executeUpdate("INSERT INTO sabor (nome) VALUES ('Frango Catupiry');");
            
            query.executeUpdate("INSERT INTO sabor (nome) VALUES ('Camarão');");
            
            query.executeUpdate("INSERT INTO sabor (nome) VALUES ('Lombo com Abacaxi');");
            
            query.executeUpdate("INSERT INTO sabor (nome) VALUES ('Pão');");

            System.out.println("Sabores criados com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao criar ao criar Sabores.");
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
