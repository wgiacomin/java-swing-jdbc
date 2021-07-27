package app.delivery.model.dao;

import app.delivery.model.beans.formatos.FormatoAbstract;
import app.delivery.model.beans.formatos.Circulo;
import app.delivery.model.beans.formatos.Quadrado;
import app.delivery.model.beans.formatos.Triangulo;
import app.delivery.model.dao.utils.DAOInterface;
import app.delivery.model.dao.utils.TipoForma;
import app.exceptions.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import app.delivery.model.dao.utils.ConnectionFactory;

public class FormaDAO implements DAOInterface<FormatoAbstract> {

    private static final String QUERY_BUSCAR = "SELECT id, medida, tipo_forma FROM forma WHERE id = ?;";
    private static final String QUERY_BUSCAR_TODOS = "SELECT id, medida, tipo_forma FROM forma;";
    private static final String QUERY_INSERIR = "INSERT INTO forma(medida, tipo_forma) VALUES (?, ?, ?);";
    private static final String QUERY_REMOVER = "DELETE FROM forma WHERE id = ?;";
    private static final String QUERY_EDITAR = "UPDATE forma SET medida = ?, tipo_forma = ? WHERE id = ?;";

    private Connection con = null;

    public FormaDAO() throws DAOException {
        ConnectionFactory factory = new ConnectionFactory();
        con = factory.getConnection();
    }

    private FormatoAbstract extrairForma(ResultSet rs) throws SQLException, DAOException {
        FormatoAbstract forma;
        int tipoForma = rs.getInt("tipo_forma");

        switch(tipoForma){
            case TipoForma.CIRCULO:
                forma = new Circulo();
                ((Circulo) forma).setRaio(rs.getDouble("medida"));
                break;
            case TipoForma.QUADRADO:
                forma = new Quadrado();
                ((Quadrado) forma).setLado(rs.getDouble("medida"));
                break;
            case TipoForma.TRIANGULO:
                forma = new Triangulo();
                ((Triangulo) forma).setLado(rs.getDouble("medida"));
                break;
            default:
                throw new DAOException("Erro buscando categoria de forma");
        }
        forma.setId(rs.getInt("id"));
        return forma;
    }
    
    @Override
    public FormatoAbstract buscar(FormatoAbstract forma) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR)) {
            st.setInt(1, forma.getId());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                forma = extrairForma(rs);
                return forma;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new DAOException("Erro buscando categoria de forma: " + forma.getId(), e);
        }
    }

    public FormatoAbstract buscarPorId(int idForma) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR)) {
            st.setInt(1, idForma);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                FormatoAbstract forma = extrairForma(rs);
                return forma;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new DAOException("Erro buscando categoria de forma: " + idForma, e);
        }
    }

    @Override
    public List<FormatoAbstract> buscarTodos() throws DAOException {
        List<FormatoAbstract> lista = new ArrayList<>();
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_TODOS)) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                lista.add(extrairForma(rs));
            }
            return lista;
        } catch (SQLException e) {
            throw new DAOException("Erro buscando todas os formas: "
                    + QUERY_BUSCAR_TODOS, e);

        }
    }

    @Override
    public void inserir(FormatoAbstract forma) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_INSERIR)) {
            if(forma instanceof Circulo){
                st.setDouble(1,((Circulo) forma).getRaio());
                st.setInt(2, TipoForma.CIRCULO);
            } else if(forma instanceof Quadrado){
                st.setDouble(1,((Quadrado) forma).getLado());
                st.setInt(2, TipoForma.QUADRADO);
            } else if(forma instanceof Triangulo){
                st.setDouble(1,((Triangulo) forma).getLado());
                st.setInt(2, TipoForma.TRIANGULO);
            } else {
                throw new DAOException("Erro no tipo de forma ao inserir forma: "
                        + QUERY_BUSCAR_TODOS);
            }
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro ao criar forma: "
                    + QUERY_INSERIR, e);
        }
    }

    @Override
    public void remover(FormatoAbstract forma) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_REMOVER)) {
            st.setInt(1, forma.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro ao deletar forma: "
                    + QUERY_REMOVER, e);
        }
    }

    @Override
    public void editar(FormatoAbstract forma) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(QUERY_EDITAR)) {
            if(forma instanceof Circulo){
                st.setDouble(1,((Circulo) forma).getRaio());
                st.setInt(2, TipoForma.CIRCULO);
            } else if(forma instanceof Quadrado){
                st.setDouble(1,((Quadrado) forma).getLado());
                st.setInt(2, TipoForma.QUADRADO);
            } else if(forma instanceof Triangulo){
                st.setDouble(1,((Triangulo) forma).getLado());
                st.setInt(2, TipoForma.TRIANGULO);
            } else {
                throw new DAOException("Erro no tipo de forma ao inserir forma: "
                        + QUERY_BUSCAR_TODOS);
            }
            st.setInt(3, forma.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro ao editar forma: "
                    + QUERY_EDITAR, e);
        }
    }

}