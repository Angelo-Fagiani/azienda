package it.cgmconsulting.azienda.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class OrdineArticolo {

    @EmbeddedId
    private OrdineArticoloId ordineArticoloId;

    @Column(nullable = false)
    private int qta;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdineArticolo that = (OrdineArticolo) o;
        return Objects.equals(ordineArticoloId, that.ordineArticoloId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ordineArticoloId);
    }
}

