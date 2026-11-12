package ec.edu.espoch.yasuniexplore.Implementacion;

import ec.edu.espoch.yasuniexplore.Objetos.CommunicationDevice;

/**
 * Gestiona un arreglo fijo de dispositivos de comunicacion.
 */
public class CommunicationDevices {
    private CommunicationDevice[] devices;
    private int count;
    private static final int MAX = 10;

    public CommunicationDevices() {
        devices = new CommunicationDevice[MAX];
        count = 0;
    }

    public boolean addDevice(CommunicationDevice device) {
        if (count < MAX) {
            devices[count] = device;
            count++;
            return true;
        }
        System.out.println("No se pueden agregar mas dispositivos. Arreglo lleno.");
        return false;
    }

    public void listDevices() {
        if (count == 0) {
            System.out.println("No hay dispositivos registrados.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + devices[i].getCode() + " - " + devices[i].getDescription()
                    + " | Disponible: " + devices[i].isAvailable());
        }
    }

    public CommunicationDevice getDevice(int index) {
        if (index >= 0 && index < count) {
            return devices[index];
        }
        return null;
    }

    public int getCount() {
        return count;
    }

    public int findAvailableDevice() {
        for (int i = 0; i < count; i++) {
            if (devices[i].isAvailable()) {
                return i;
            }
        }
        return -1;
    }
}
