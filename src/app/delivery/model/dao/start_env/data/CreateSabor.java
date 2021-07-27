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

            query.executeUpdate("INSERT INTO sabor (nome, id_tipo) VALUES ('Calabresa', 1);");

            query.executeUpdate("INSERT INTO sabor (nome, id_tipo) VALUES ('Portuguesa', 1);");
            
            query.executeUpdate("INSERT INTO sabor (nome, id_tipo) VALUES ('Atum', 2);");
            
            query.executeUpdate("INSERT INTO sabor (nome, id_tipo) VALUES ('Baiana', 2);");
            
            query.executeUpdate("INSERT INTO sabor (nome, id_tipo) VALUES ('Brócolis', 2);");
            
            query.executeUpdate("INSERT INTO sabor (nome, id_tipo) VALUES ('Caipira', 3);");
            
            query.executeUpdate("INSERT INTO sabor (nome, id_tipo) VALUES ('Frango Catupiry', 1);");
            
            query.executeUpdate("INSERT INTO sabor (nome, id_tipo) VALUES ('Camarão', 3);");
            
            query.executeUpdate("INSERT INTO sabor (nome, id_tipo) VALUES ('Lombo com Abacaxi', 3);");
            
            query.executeUpdate("INSERT INTO sabor (nome, id_tipo) VALUES ('Pão', 3);");

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
