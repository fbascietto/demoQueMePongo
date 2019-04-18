package quemepongo.Guardarropa;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Guardarropa {

    private @Id @GeneratedValue Long id;
    private String nombre;
    private String duenio;

    Guardarropa() {}

    Guardarropa(String nombre, String duenio) {
        this.nombre = nombre;
        this.duenio = duenio;
    }
}