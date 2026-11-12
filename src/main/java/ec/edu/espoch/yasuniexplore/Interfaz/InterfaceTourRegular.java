package ec.edu.espoch.yasuniexplore.Interfaz;

/**
 * Interfaz que declara los metodos de negocio para tours regulares.
 */
public interface InterfaceTourRegular {
    double calculateTotalDistance();
    double calculateTotalDuration();
    double calculateAdjustedWalkingTime();
    double simulateNewFactor(double currentFactor);
    void closeTrail(int index);
}
