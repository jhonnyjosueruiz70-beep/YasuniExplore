package ec.edu.espoch.yasuniexplore.Objetos;

/**
 * Clase que representa un guia de turismo.
 * Atributos privados con encapsulamiento.
 */
public class Guide {
    private String id;
    private String name;
    private boolean available;

    public Guide(String id, String name) {
        this.id = id;
        this.name = name;
        this.available = true;
    }

    public Guide(String id, String name, boolean available) {
        this.id = id;
        this.name = name;
        this.available = available;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Guia: " + id + " - " + name + " | Disponible: " + available;
    }
}
