package ec.edu.espoch.yasuniexplore.Interfaz;

import ec.edu.espoch.yasuniexplore.Objetos.CommunicationDevice;
import ec.edu.espoch.yasuniexplore.Objetos.Guide;
import ec.edu.espoch.yasuniexplore.Objetos.Tour;

/**
 * Interfaz que declara el contrato de asignacion de dispositivo y guia a un tour.
 */
public interface InterfaceAssigment {
    String assign(Tour tour, CommunicationDevice device, Guide guide);
}
