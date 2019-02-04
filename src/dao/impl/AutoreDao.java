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

    private final String NEXT_ID = "select max(id) from autore";

    @Override
    public Collection<Autore> list() {

        Collection<Autore> result = new ArrayList();
        try (
                Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(LIST);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {
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

        Autore result = null;
        ResultSet rs = null;
        try (
                Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(GET)
        ) {
            ps.setLong(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                Autore autore = new Autore();
                autore.setCognome(rs.getString("cognome"));
                autore.setId(rs.getLong("id"));
                autore.setNome(rs.getString("nome"));
                result = autore;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }

    @Override
    public void create(Autore author) {
        try (
                Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(INSERT)
        ) {
            ps.setLong(1,  nextId(c,NEXT_ID));
            ps.setString(2, author.getNome());
            ps.setString(3, author.getCognome());
            ps.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Autore author) {
        try (
                Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(UPDATE)
        ) {
            ps.setString(1, author.getNome());
            ps.setString(2, author.getCognome());
            ps.setLong(3, author.getId());
            ps.executeUpdate();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Long id) {
        try (
                Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(DELETE)
        ) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
