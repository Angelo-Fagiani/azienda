
package it.cgmconsulting.azienda.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {

    @Id
    private String categoria;

    private byte iva;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria1 = (Categoria) o;
        return Objects.equals(categoria, categoria1.categoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoria);
    }
}

