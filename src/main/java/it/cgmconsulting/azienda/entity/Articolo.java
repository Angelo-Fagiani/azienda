package it.cgmconsulting.azienda.entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Articolo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50, unique = true)
    private String nomeArticolo;

    private double prezzo;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    public Articolo(String nomeArticolo, double prezzo, Categoria categoria) {
        this.nomeArticolo = nomeArticolo;
        this.prezzo = prezzo;
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Articolo articolo = (Articolo) o;
        return id == articolo.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}

