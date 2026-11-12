package ec.edu.espoch.yasuniexplore.Implementacion;

import ec.edu.espoch.yasuniexplore.Objetos.Tour;
import ec.edu.espoch.yasuniexplore.Objetos.Trail;

/**
 * Gestiona un arreglo polimorfico de tours (regulares e interpretativos).
 * Incluye ordenamiento burbuja, simulacion de dificultad y cierre de senderos.
 */
public class Tours {
    private Tour[] tours;
    private int count;
    private static final int MAX = 10;

    public Tours() {
        tours = new Tour[MAX];
        count = 0;
    }

    public boolean addTour(Tour tour) {
        if (count < MAX) {
            tours[count] = tour;
            count++;
            return true;
        }
        System.out.println("No se pueden agregar mas tours. Arreglo lleno.");
        return false;
    }

    public void listAllTours() {
        if (count == 0) {
            System.out.println("No hay tours registrados.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + tours[i].toString());
            System.out.println("----------------------------------------");
        }
    }

    public Tour getTour(int index) {
        if (index >= 0 && index < count) {
            return tours[index];
        }
        return null;
    }

    public int getCount() {
        return count;
    }

    // Ordenamiento burbuja por distancia total (menor a mayor)
    public void sortByDistance() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (tours[j].calculateTotalDistance() > tours[j + 1].calculateTotalDistance()) {
                    Tour temp = tours[j];
                    tours[j] = tours[j + 1];
                    tours[j + 1] = temp;
                }
            }
        }
        System.out.println("Tours ordenados por distancia (menor a mayor).");
    }

    // Ordenamiento burbuja por duracion total estimada (menor a mayor)
    public void sortByDuration() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (tours[j].calculateTotalDuration() > tours[j + 1].calculateTotalDuration()) {
                    Tour temp = tours[j];
                    tours[j] = tours[j + 1];
                    tours[j + 1] = temp;
                }
            }
        }
        System.out.println("Tours ordenados por duracion estimada (menor a mayor).");
    }

    // Cierra un sendero de un tour (lo deshabilita)
    public void closeTrail(Tour tour, int trailIndex) {
        Trail[] trails = tour.getTrails();
        int trailCount = tour.getTrailCount();
        if (trailIndex >= 0 && trailIndex < trailCount && trails[trailIndex] != null) {
            trails[trailIndex].setEnabled(false);
            System.out.println("Sendero cerrado: " + trails[trailIndex].getName());
        } else {
            System.out.println("Indice de sendero no valido.");
        }
    }
}
