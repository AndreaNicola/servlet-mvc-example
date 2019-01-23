package models;

public class Libro {

    private Long id;
    private Long autoreId;
    private String titolo;
    private String descrizione;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAutoreId() {
        return autoreId;
    }

    public void setAutoreId(Long autoreId) {
        this.autoreId = autoreId;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
