package ec.edu.espoch.yasuniexplore.Implementacion;

import ec.edu.espoch.yasuniexplore.Objetos.TourRegular;

/**
 * Gestiona un arreglo fijo de tours regulares.
 */
public class TourRegulars {
    private TourRegular[] tours;
    private int count;
    private static final int MAX = 10;

    public TourRegulars() {
        tours = new TourRegular[MAX];
        count = 0;
    }

    public boolean addTour(TourRegular tour) {
        if (count < MAX) {
            tours[count] = tour;
            count++;
            return true;
        }
        System.out.println("No se pueden agregar mas tours regulares. Arreglo lleno.");
        return false;
    }

    public TourRegular getTour(int index) {
        if (index >= 0 && index < count) {
            return tours[index];
        }
        return null;
    }

    public int getCount() {
        return count;
    }
}
