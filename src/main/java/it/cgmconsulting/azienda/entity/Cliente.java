package it.cgmconsulting.azienda.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Cliente {

    @Id
    @Column(columnDefinition="CHAR(11)")
    private String piva;

    private String ragioneSociale;

    private String indirizzo;

    private String citta;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(piva, cliente.piva);
    }

    @Override
    public int hashCode() {
        return Objects.hash(piva);
    }
}
