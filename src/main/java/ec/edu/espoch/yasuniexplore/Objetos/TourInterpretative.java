package ec.edu.espoch.yasuniexplore.Objetos;

/**
 * Clase que representa un tour interpretativo.
 * La duracion total es tiempo de caminata ajustado + minutos educativos.
 * Los minutos educativos NO se multiplican por el factor de dificultad.
 */
public class TourInterpretative extends Tour {
    private double educationalMinutes;

    public TourInterpretative(String code, String name, int maxTrails, double educationalMinutes) {
        super(code, name, maxTrails);
        this.educationalMinutes = educationalMinutes;
    }

    @Override
    public double calculateTotalDuration() {
        return (calculateBaseWalkingTime() * getFactor()) + educationalMinutes;
    }

    public double getEducationalMinutes() {
        return educationalMinutes;
    }

    public void setEducationalMinutes(double educationalMinutes) {
        this.educationalMinutes = educationalMinutes;
    }
}
