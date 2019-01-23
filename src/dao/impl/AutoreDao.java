package dao.impl;

import dao.IAutoreDao;
import models.Autore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

public class AutoreDao extends AbstractDao implements IAutoreDao {

    private final String LIST = "select id, nome, cognome from autore";
    private final String GET = "select id, nome, cognome from autore where id=?";
    private final String INSERT = "insert into autore (id, nome, cognome) values (?,?,?)";
    private final String UPDATE = "update autore set nome = ?, cognome = ? where id=?";
    private final String DELETE = "delete from autore where id=?";


    @Override
    public Collection<Autore> list() {

        Collection<Autore> result = new ArrayList();
        try (
                Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(LIST);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()){
                Autore autore = new Autore();
                autore.setCognome(rs.getString("cognome"));
                autore.setId(rs.getLong("id"));
                autore.setNome(rs.getString("nome"));
                result.add(autore);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public Autore get(Long id) {
        return null;
    }

    @Override
    public void create(Autore author) {

    }

    @Override
    public void update(Autore author) {

    }

    @Override
    public void delete(Long id) {

    }
}
