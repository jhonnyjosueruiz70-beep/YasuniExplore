package ec.edu.espoch.yasuniexplore.Implementacion;

import ec.edu.espoch.yasuniexplore.Interfaz.InterfaceAssigment;
import ec.edu.espoch.yasuniexplore.Objetos.CommunicationDevice;
import ec.edu.espoch.yasuniexplore.Objetos.Guide;
import ec.edu.espoch.yasuniexplore.Objetos.Tour;

/**
 * Implementa la logica de asignacion de dispositivo y guia a un tour.
 */
public class Assignments implements InterfaceAssigment {

    @Override
    public String assign(Tour tour, CommunicationDevice device, Guide guide) {
        if (device != null && guide != null && device.isAvailable() && guide.isAvailable()) {
            tour.setAssignedDevice(device);
            tour.setAssignedGuide(guide);
            device.setAvailable(false);
            guide.setAvailable(false);
            return "Asignación ACEPTADA";
        } else {
            return "Asignación RECHAZADA";
        }
    }
}
