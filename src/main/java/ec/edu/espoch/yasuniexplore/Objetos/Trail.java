package ec.edu.espoch.yasuniexplore.Objetos;

/**
 * Clase que representa un sendero de un tour.
 * Atributos privados con encapsulamiento.
 */
public class Trail {
    private String name;
    private double length;
    private double timeEstimated;
    private boolean enabled;

    public Trail(String name, double length, double timeEstimated) {
        this.name = name;
        this.length = length;
        this.timeEstimated = timeEstimated;
        this.enabled = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getTimeEstimated() {
        return timeEstimated;
    }

    public void setTimeEstimated(double timeEstimated) {
        this.timeEstimated = timeEstimated;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "Sendero: " + name + " | " + length + " km | " + timeEstimated + " min | Habilitado: " + enabled;
    }
}