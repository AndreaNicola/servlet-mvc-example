package dao.impl;

import dao.ILibroDao;
import models.Libro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

public class LibroDao extends AbstractDao implements ILibroDao {

    private static final String LIST = "select id, titolo, descrizione, autore_id from libro";
    private static final String GET = LIST + " where id=?";
    private static final String INSERT = "insert into libro (id, titolo, descrizione, autore_id) values (?,?,?,?)";
    private static final String UPDATE = "update libro set titolo=?, descrizione=?, autore_id=? where id=?";
    private static final String DELETE = "delete from libro where id=?";

    private static final String ADD_LIBRO_GENERE = "insert into libro_genere (id, libro_id, genere_id) values (?,?,?)";
    private static final String DEL_LIBRO_GENERE = "delete from libro_genere where libro_id=?";

    private final String NEXT_ID_LIBRO = "select max(id) from libro";
    private final String NEXT_ID_LIBRO_GENERE = "select max(id) from libro_genere";

    @Override
    public Collection<Libro> list() {

        Collection<Libro> result = new ArrayList<>();
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
    public Libro get(Long id) {

        Libro result = null;
        ResultSet rs = null;
        try (
                Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(GET)
        ) {
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Libro libro = new Libro();
                libro.setAutoreId(rs.getLong("autore_id"));
                libro.setDescrizione(rs.getString("descrizione"));
                libro.setId(rs.getLong("id"));
                libro.setTitolo(rs.getString("titolo"));
                result = libro;
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
    public void create(Libro book) {
        try (
                Connection c = getConnection();
                PreparedStatement ps1 = c.prepareStatement(INSERT)
        ) {
            ps1.setLong(1, nextId(c, NEXT_ID_LIBRO) + 1);
            ps1.setString(2, book.getTitolo());
            ps1.setString(3, book.getDescrizione());
            ps1.setLong(4, book.getAutoreId());
            ps1.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Libro book) {
        try (
                Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(UPDATE)
        ) {
            ps.setString(1, book.getTitolo());
            ps.setString(2, book.getDescrizione());
            ps.setLong(3, book.getAutoreId());
            ps.setLong(4, book.getId());
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
    public void create(Libro libro, Collection<Long> generi) {

        Connection c = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;

        try {

            c = getConnection();
            c.setAutoCommit(false);
            ps1 = c.prepareStatement(INSERT);
            ps2 = c.prepareStatement(ADD_LIBRO_GENERE);

            long nextId = nextId(c, NEXT_ID_LIBRO);

            ps1.setLong(1, nextId);
            ps1.setString(2, libro.getTitolo());
            ps1.setString(3, libro.getDescrizione());
            ps1.setLong(4, libro.getAutoreId());
            ps1.executeUpdate();

            for (Long g : generi) {

                long nextLibroGenereId = nextId(c, NEXT_ID_LIBRO_GENERE);

                ps2.setLong(1, nextLibroGenereId);
                ps2.setLong(2, nextId);
                ps2.setLong(3, g);
                ps2.executeUpdate();

            }

            c.commit();

        } catch (Exception e) {

            if (c != null) {

                try {
                    c.rollback();
                } catch (Exception e1) {
                    e.printStackTrace();
                }

            }

            throw new RuntimeException(e);
        } finally {
            if (ps2 != null) {
                try {
                    ps2.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (ps1 != null) {
                try {
                    ps1.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (c != null) {
                try {
                    c.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void update(Libro libro, Collection<Long> generi) {
        Connection c = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        PreparedStatement ps3 = null;

        try {

            c = getConnection();
            c.setAutoCommit(false);
            ps1 = c.prepareStatement(UPDATE);
            ps2 = c.prepareStatement(DEL_LIBRO_GENERE);
            ps3 = c.prepareStatement(ADD_LIBRO_GENERE);


            ps1.setLong(1, libro.getId());
            ps1.setString(2, libro.getTitolo());
            ps1.setString(3, libro.getDescrizione());
            ps1.setLong(4, libro.getAutoreId());
            ps1.executeUpdate();

            ps2.setLong(1, libro.getId());
            ps2.executeUpdate();

            for (Long g : generi) {

                long nextLibroGenereId = nextId(c, NEXT_ID_LIBRO_GENERE);

                ps3.setLong(1, nextLibroGenereId);
                ps3.setLong(2, libro.getId());
                ps3.setLong(3, g);
                ps3.executeUpdate();

            }

            c.commit();

        } catch (Exception e) {

            if (c != null) {

                try {
                    c.rollback();
                } catch (Exception e1) {
                    e.printStackTrace();
                }

            }

            throw new RuntimeException(e);
        } finally {
            if (ps3 != null) {
                try {
                    ps3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (ps2 != null) {
                try {
                    ps2.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (ps1 != null) {
                try {
                    ps1.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (c != null) {
                try {
                    c.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Collection<Libro> listByFk(String sql, Long fk) {
        Collection<Libro> result = new ArrayList<>();
        ResultSet rs;
        try (
                Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(sql)
        ) {

            ps.setLong(1, fk);
            rs = ps.executeQuery();
            getElements(rs, result);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public Collection<Libro> listByAutore(Long autoreId) {
        String LIST_BY_AUTORE = LIST + " where autore_id=?";
        return listByFk(LIST_BY_AUTORE, autoreId);
    }

    @Override
    public Collection<Libro> listByGenere(Long genereId) {
        String LIST_BY_GENERE = "select id, titolo, descrizione, autore_id from libro where id in (select libro_id " +
                "from " +
                "libro_genere where genere_id = ?)";
        return listByFk(LIST_BY_GENERE, genereId);
    }

    private void getElements(ResultSet rs, Collection<Libro> result) throws Exception {
        while (rs.next()) {
            Libro libro = new Libro();
            libro.setAutoreId(rs.getLong("autore_id"));
            libro.setDescrizione(rs.getString("descrizione"));
            libro.setId(rs.getLong("id"));
            libro.setTitolo(rs.getString("titolo"));
            result.add(libro);
        }
    }

}
