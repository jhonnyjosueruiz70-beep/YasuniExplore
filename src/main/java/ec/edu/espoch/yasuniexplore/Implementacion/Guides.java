package ec.edu.espoch.yasuniexplore.Implementacion;

import ec.edu.espoch.yasuniexplore.Objetos.Guide;

/**
 * Gestiona un arreglo fijo de guias de turismo.
 */
public class Guides {
    private Guide[] guides;
    private int count;
    private static final int MAX = 10;

    public Guides() {
        guides = new Guide[MAX];
        count = 0;
    }

    public boolean addGuide(Guide guide) {
        if (count < MAX) {
            guides[count] = guide;
            count++;
            return true;
        }
        System.out.println("No se pueden agregar mas guias. Arreglo lleno.");
        return false;
    }

    public void listGuides() {
        if (count == 0) {
            System.out.println("No hay guias registrados.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + guides[i].getId() + " - " + guides[i].getName()
                    + " | Disponible: " + guides[i].isAvailable());
        }
    }

    public Guide getGuide(int index) {
        if (index >= 0 && index < count) {
            return guides[index];
        }
        return null;
    }

    public int getCount() {
        return count;
    }

    public int findAvailableGuide() {
        for (int i = 0; i < count; i++) {
            if (guides[i].isAvailable()) {
                return i;
            }
        }
        return -1;
    }
}
