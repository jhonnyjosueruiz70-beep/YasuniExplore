package ec.edu.espoch.yasuniexplore.Objetos;

/**
 * Clase que representa un tour regular.
 * La duracion total es solo el tiempo de caminata ajustado por el factor.
 */
public class TourRegular extends Tour {

    public TourRegular(String code, String name, int maxTrails) {
        super(code, name, maxTrails);
    }

    @Override
    public double calculateTotalDuration() {
        return calculateBaseWalkingTime() * getFactor();
    }
}
