package ec.edu.espoch.yasuniexplore.Interfaz;

/**
 * Interfaz que declara los metodos de negocio para tours interpretativos.
 */
public interface InterfaceTourInterpretativo {
    double calculateTotalDistance();
    double calculateTotalDuration();
    double calculateAdjustedWalkingTime();
    double simulateNewFactor(double currentFactor);
    void closeTrail(int index);
    double getEducationalMinutes();
    void setEducationalMinutes(double minutes);
}
