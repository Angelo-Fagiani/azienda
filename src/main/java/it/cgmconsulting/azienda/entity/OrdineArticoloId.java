package it.cgmconsulting.azienda.entity;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrdineArticoloId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "ordine_id", nullable = false)
    private Ordine ordine;

    @ManyToOne
    @JoinColumn(name = "articolo_id", nullable = false)
    private Articolo articolo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdineArticoloId that = (OrdineArticoloId) o;
        return Objects.equals(ordine, that.ordine) && Objects.equals(articolo, that.articolo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ordine, articolo);
    }
}

