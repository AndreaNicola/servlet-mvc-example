package dao.impl;

import dao.IGenereDao;
import models.Genere;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

public class GenereDao extends AbstractDao implements IGenereDao {

    private static final String LIST = "select id, nome from genere";
    private static final String GET = "select id, nome from genere where id=?";
    private static final String INSERT = "insert into genere (id, nome) values (?,?)";
    private static final String UPDATE = "update genere set nome=? where id=?";
    private static final String DELETE = "delete from genere where id=?";

    private static final String LIST_BY_BOOK = "select id, nome from genere where id in (select genere_id from " +
            "libro_genere where libro_id = ?)";

    private final String NEXT_ID = "select max(id) from genere";

    @Override
    public Collection<Genere> list() {
        Collection<Genere> result = new ArrayList<>();
        try (
                Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(LIST);
                ResultSet rs = ps.executeQuery()
        ) {

            getElements(rs, result);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public Genere get(Long id) {

        Genere result = null;
        ResultSet rs = null;
        try (
                Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(GET)
        ) {
            ps.setLong(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                Genere genere = new Genere();
                genere.setId(rs.getLong("id"));
                genere.setNome(rs.getString("nome"));
                result = genere;
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
    public void create(Genere genre) {
        try (
                Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(INSERT)
        ) {
            ps.setLong(1, nextId(c,NEXT_ID) );
            ps.setString(2, genre.getNome());
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Genere genre) {
        try (
                Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(UPDATE)
        ) {
            ps.setString(1, genre.getNome());
            ps.setLong(2, genre.getId());
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

    @Override
    public Collection<Genere> listByLibro(Long bookId) {
        Collection<Genere> result = new ArrayList<>();
        ResultSet rs = null;
        try (
                Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(LIST_BY_BOOK)
        ) {
            ps.setLong(1, bookId);
            rs = ps.executeQuery();
            getElements(rs, result);

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

    private void getElements(ResultSet rs, Collection<Genere> result) throws Exception {
        while (rs.next()) {
            Genere genere = new Genere();
            genere.setId(rs.getLong("id"));
            genere.setNome(rs.getString("nome"));
            result.add(genere);
        }
    }

}

