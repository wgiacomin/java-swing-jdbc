package app.delivery.model.dao.start_env.data;

import app.delivery.model.dao.utils.ConnectionFactory;
import java.sql.Connection;
import java.sql.Statement;

public class CreateTables {

    private static Statement query = null;
    private static Connection con = null;

    public static void main(String[] args) {
        try (ConnectionFactory factory = new ConnectionFactory()) {
            con = factory.getConnection();
            query = con.createStatement();

            //Drop and recreate schema
            query.executeUpdate("DROP SCHEMA IF EXISTS public CASCADE;");
            query.executeUpdate("CREATE SCHEMA public;");

            //Giving permissions
            query.executeUpdate("GRANT ALL ON SCHEMA public TO postgres;");
            query.executeUpdate("GRANT ALL ON SCHEMA public TO public;");

            //Creating New Tables
            query.executeUpdate("CREATE TABLE cliente (" +
                    "    id serial PRIMARY KEY," +
                    "    nome text," +
                    "    sobrenome text," +
                    "    telefone text)");
            query.executeUpdate("CREATE TABLE pedido (" +
                    "    id serial PRIMARY KEY," +
                    "    id_cliente integer," +
                    "    CONSTRAINT pedido_id_cliente_fkey FOREIGN KEY (id_cliente)\n" +
                    "        REFERENCES cliente (id) ON DELETE CASCADE)");
            query.executeUpdate("CREATE TABLE forma (" +
                    "    id serial PRIMARY KEY," +
                    "    medida double precision," +
                    "    tipo_forma integer)");
            query.executeUpdate("CREATE TABLE pizza (" +
                    "    id serial PRIMARY KEY," +
                    "    id_pedido integer," +
                    "    id_forma integer," +
                    "    CONSTRAINT pizza_id_pedido_fkey FOREIGN KEY (id_pedido)" +
                    "        REFERENCES pedido (id) ON DELETE CASCADE, " +
                    "    CONSTRAINT pizza_id_forma_fkey FOREIGN KEY (id_forma)" +
                    "        REFERENCES forma (id) ON DELETE CASCADE)");
            query.executeUpdate("CREATE TABLE tipo_sabor (" +
                    "    id serial PRIMARY KEY," +
                    "    nome text," +
                    "    custo double precision)");
            query.executeUpdate("CREATE TABLE sabor (" +
                    "    id serial PRIMARY KEY," +
                    "    nome text," +
                    "    id_tipo integer," +
                    "    CONSTRAINT sabor_id_tipo_fkey FOREIGN KEY (id_tipo)" +
                    "        REFERENCES tipo_sabor (id) )");
            query.executeUpdate("CREATE TABLE pizza_sabor (" +
                    "    id serial PRIMARY KEY," +
                    "    id_pizza integer," +
                    "    id_sabor integer," +
                    "    CONSTRAINT pizza_sabor_id_pizza_fkey FOREIGN KEY (id_pizza)" +
                    "        REFERENCES pizza (id) ON DELETE CASCADE," +
                    "    CONSTRAINT pizza_sabor_id_sabor_fkey FOREIGN KEY (id_sabor)" +
                    "        REFERENCES sabor (id) )");

            System.out.println("Tabelas criadas com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro ao criar ao criar tabelas.");
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
