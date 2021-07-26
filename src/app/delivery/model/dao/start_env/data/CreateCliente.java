package app.delivery.model.dao.start_env.data;

import app.delivery.model.dao.utils.ConnectionFactory;
import java.sql.Connection;
import java.sql.Statement;

public class CreateCliente {

    private static Statement query = null;
    private static Connection con = null;

    public static void main(String[] args) {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            con = factory.getConnection();
            query = con.createStatement();

            query.executeUpdate("INSERT INTO cliente (nome,sobrenome,telefone) VALUES ('Gabriel','Schmidt', '111111111');");

            query.executeUpdate("INSERT INTO cliente (nome,sobrenome,telefone) VALUES ('Wanderson','Giacomin', '222222222');");
            
            query.executeUpdate("INSERT INTO cliente (nome,sobrenome,telefone) VALUES ('Cliente 3','Teste', '333333333');");
            
            query.executeUpdate("INSERT INTO cliente (nome,sobrenome,telefone) VALUES ('Cliente 4','Teste', '444444444');");
            
            query.executeUpdate("INSERT INTO cliente (nome,sobrenome,telefone) VALUES ('Cliente 5','Teste', '555555555');");

            System.out.println("Clientes criados com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao criar ao criar Clientes.");
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
