package ec.edu.espoch.yasuniexplore.Interfaz;

/**
 * Interfaz que declara el contrato de un dispositivo de comunicacion.
 */
public interface InterfaceCommunicationDevice {
    String getCode();
    String getDescription();
    boolean isAvailable();
    void setAvailable(boolean available);
}
