package ec.edu.espoch.yasuniexplore;

import ec.edu.espoch.yasuniexplore.Implementacion.Assignments;
import ec.edu.espoch.yasuniexplore.Implementacion.CommunicationDevices;
import ec.edu.espoch.yasuniexplore.Implementacion.Guides;
import ec.edu.espoch.yasuniexplore.Implementacion.Tours;
import ec.edu.espoch.yasuniexplore.Objetos.CommunicationDevice;
import ec.edu.espoch.yasuniexplore.Objetos.Guide;
import ec.edu.espoch.yasuniexplore.Objetos.Tour;
import ec.edu.espoch.yasuniexplore.Objetos.TourInterpretative;
import ec.edu.espoch.yasuniexplore.Objetos.TourRegular;
import ec.edu.espoch.yasuniexplore.Objetos.Trail;
import java.util.Scanner;

/**
 * Clase principal con el menu de consola para Yasuní Explora.
 */
public class YasuniExplore {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CommunicationDevices gestorDispositivos = new CommunicationDevices();
        Guides gestorGuias = new Guides();
        Tours gestorTours = new Tours();
        Assignments asignacion = new Assignments();

        int opcion;
        do {
            System.out.println("\n===== YASUNI EXPLORE - GESTION DE TOURS =====");
            System.out.println("1. Registrar dispositivo de comunicacion");
            System.out.println("2. Registrar guia");
            System.out.println("3. Registrar tour regular con senderos");
            System.out.println("4. Registrar tour interpretativo con senderos");
            System.out.println("5. Asignar dispositivo y guia a un tour");
            System.out.println("6. Listar todos los tours");
            System.out.println("7. Ordenar tours por distancia");
            System.out.println("8. Ordenar tours por duracion");
            System.out.println("9. Simular aumento de dificultad");
            System.out.println("10. Cerrar un sendero de un tour");
            System.out.println("11. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    registrarDispositivo(scanner, gestorDispositivos);
                    break;
                case 2:
                    registrarGuia(scanner, gestorGuias);
                    break;
                case 3:
                    registrarTourRegular(scanner, gestorTours);
                    break;
                case 4:
                    registrarTourInterpretativo(scanner, gestorTours);
                    break;
                case 5:
                    asignarDispositivoYGuia(scanner, gestorTours, gestorDispositivos, gestorGuias, asignacion);
                    break;
                case 6:
                    gestorTours.listAllTours();
                    break;
                case 7:
                    gestorTours.sortByDistance();
                    break;
                case 8:
                    gestorTours.sortByDuration();
                    break;
                case 9:
                    simularDificultad(scanner, gestorTours);
                    break;
                case 10:
                    cerrarSendero(scanner, gestorTours);
                    break;
                case 11:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 11);

        scanner.close();
    }

    private static void registrarDispositivo(Scanner scanner, CommunicationDevices gestor) {
        System.out.print("Codigo del dispositivo: ");
        String code = scanner.nextLine();
        System.out.print("Descripcion: ");
        String desc = scanner.nextLine();
        CommunicationDevice d = new CommunicationDevice(code, desc);
        if (gestor.addDevice(d)) {
            System.out.println("Dispositivo registrado exitosamente.");
        }
    }

    private static void registrarGuia(Scanner scanner, Guides gestor) {
        System.out.print("Cedula del guia: ");
        String id = scanner.nextLine();
        System.out.print("Nombre del guia: ");
        String name = scanner.nextLine();
        Guide g = new Guide(id, name);
        if (gestor.addGuide(g)) {
            System.out.println("Guia registrado exitosamente.");
        }
    }

    private static void registrarTourRegular(Scanner scanner, Tours gestor) {
        System.out.print("Codigo del tour: ");
        String code = scanner.nextLine();
        System.out.print("Nombre del tour: ");
        String name = scanner.nextLine();
        System.out.print("Numero maximo de senderos: ");
        int maxTrails = scanner.nextInt();
        scanner.nextLine();

        TourRegular tour = new TourRegular(code, name, maxTrails);

        for (int i = 0; i < maxTrails; i++) {
            System.out.println("\nSendero " + (i + 1) + ":");
            System.out.print("Nombre del sendero: ");
            String tName = scanner.nextLine();
            System.out.print("Longitud (km): ");
            double length = scanner.nextDouble();
            System.out.print("Tiempo estimado (min): ");
            double time = scanner.nextDouble();
            scanner.nextLine();
            tour.addTrail(new Trail(tName, length, time));
        }

        if (gestor.addTour(tour)) {
            System.out.println("Tour regular registrado exitosamente.");
        }
    }

    private static void registrarTourInterpretativo(Scanner scanner, Tours gestor) {
        System.out.print("Codigo del tour: ");
        String code = scanner.nextLine();
        System.out.print("Nombre del tour: ");
        String name = scanner.nextLine();
        System.out.print("Numero maximo de senderos: ");
        int maxTrails = scanner.nextInt();
        System.out.print("Minutos de actividades educativas: ");
        double eduMinutes = scanner.nextDouble();
        scanner.nextLine();

        TourInterpretative tour = new TourInterpretative(code, name, maxTrails, eduMinutes);

        for (int i = 0; i < maxTrails; i++) {
            System.out.println("\nSendero " + (i + 1) + ":");
            System.out.print("Nombre del sendero: ");
            String tName = scanner.nextLine();
            System.out.print("Longitud (km): ");
            double length = scanner.nextDouble();
            System.out.print("Tiempo estimado (min): ");
            double time = scanner.nextDouble();
            scanner.nextLine();
            tour.addTrail(new Trail(tName, length, time));
        }

        if (gestor.addTour(tour)) {
            System.out.println("Tour interpretativo registrado exitosamente.");
        }
    }

    private static void asignarDispositivoYGuia(Scanner scanner, Tours gestorTours,
            CommunicationDevices gestorDev, Guides gestorGuia, Assignments asignacion) {
        if (gestorTours.getCount() == 0) {
            System.out.println("No hay tours registrados.");
            return;
        }
        if (gestorDev.getCount() == 0) {
            System.out.println("No hay dispositivos registrados.");
            return;
        }
        if (gestorGuia.getCount() == 0) {
            System.out.println("No hay guias registrados.");
            return;
        }

        System.out.println("\nTours disponibles:");
        for (int i = 0; i < gestorTours.getCount(); i++) {
            System.out.println((i + 1) + ". " + gestorTours.getTour(i).getCode() + " - "
                    + gestorTours.getTour(i).getName());
        }
        System.out.print("Seleccione el tour (numero): ");
        int tourIdx = scanner.nextInt() - 1;
        scanner.nextLine();

        if (tourIdx < 0 || tourIdx >= gestorTours.getCount()) {
            System.out.println("Indice de tour no valido.");
            return;
        }

        System.out.println("\nDispositivos disponibles:");
        for (int i = 0; i < gestorDev.getCount(); i++) {
            System.out.println((i + 1) + ". " + gestorDev.getDevice(i).getCode() + " - "
                    + gestorDev.getDevice(i).getDescription() + " | Disponible: "
                    + gestorDev.getDevice(i).isAvailable());
        }
        System.out.print("Seleccione el dispositivo (numero): ");
        int devIdx = scanner.nextInt() - 1;
        scanner.nextLine();

        if (devIdx < 0 || devIdx >= gestorDev.getCount()) {
            System.out.println("Indice de dispositivo no valido.");
            return;
        }

        System.out.println("\nGuias disponibles:");
        for (int i = 0; i < gestorGuia.getCount(); i++) {
            System.out.println((i + 1) + ". " + gestorGuia.getGuide(i).getId() + " - "
                    + gestorGuia.getGuide(i).getName() + " | Disponible: "
                    + gestorGuia.getGuide(i).isAvailable());
        }
        System.out.print("Seleccione el guia (numero): ");
        int guiaIdx = scanner.nextInt() - 1;
        scanner.nextLine();

        if (guiaIdx < 0 || guiaIdx >= gestorGuia.getCount()) {
            System.out.println("Indice de guia no valido.");
            return;
        }

        Tour tour = gestorTours.getTour(tourIdx);
        CommunicationDevice device = gestorDev.getDevice(devIdx);
        Guide guide = gestorGuia.getGuide(guiaIdx);

        String resultado = asignacion.assign(tour, device, guide);
        System.out.println("\n" + resultado);
    }

    private static void simularDificultad(Scanner scanner, Tours gestorTours) {
        if (gestorTours.getCount() == 0) {
            System.out.println("No hay tours registrados.");
            return;
        }

        System.out.println("\nTours disponibles:");
        for (int i = 0; i < gestorTours.getCount(); i++) {
            System.out.println((i + 1) + ". " + gestorTours.getTour(i).getCode() + " - "
                    + gestorTours.getTour(i).getName() + " | Factor actual: "
                    + gestorTours.getTour(i).getFactor());
        }
        System.out.print("Seleccione el tour (numero): ");
        int idx = scanner.nextInt() - 1;
        scanner.nextLine();

        if (idx < 0 || idx >= gestorTours.getCount()) {
            System.out.println("Indice de tour no valido.");
            return;
        }

        Tour tour = gestorTours.getTour(idx);
        double currentFactor = tour.getFactor();
        System.out.println("Factor actual: " + currentFactor);
        System.out.print("Ingrese el porcentaje de aumento: ");
        double porcentaje = scanner.nextDouble();
        scanner.nextLine();

        double newFactor = currentFactor * (1 + porcentaje / 100);
        System.out.println("Nuevo factor simulado: " + newFactor);
        System.out.print("¿Daniella acepta este nuevo factor? (s/n): ");
        String respuesta = scanner.nextLine();

        if (respuesta.equalsIgnoreCase("s")) {
            tour.setFactor(newFactor);
            System.out.println("Factor actualizado correctamente.");
        } else {
            System.out.println("El factor no se modifico.");
        }
    }

    private static void cerrarSendero(Scanner scanner, Tours gestorTours) {
        if (gestorTours.getCount() == 0) {
            System.out.println("No hay tours registrados.");
            return;
        }

        System.out.println("\nTours disponibles:");
        for (int i = 0; i < gestorTours.getCount(); i++) {
            System.out.println((i + 1) + ". " + gestorTours.getTour(i).getCode() + " - "
                    + gestorTours.getTour(i).getName());
        }
        System.out.print("Seleccione el tour (numero): ");
        int idx = scanner.nextInt() - 1;
        scanner.nextLine();

        if (idx < 0 || idx >= gestorTours.getCount()) {
            System.out.println("Indice de tour no valido.");
            return;
        }

        Tour tour = gestorTours.getTour(idx);
        int trailCount = tour.getTrailCount();
        if (trailCount == 0) {
            System.out.println("El tour no tiene senderos.");
            return;
        }

        System.out.println("\nSenderos del tour:");
        for (int i = 0; i < trailCount; i++) {
            Trail t = tour.getTrails()[i];
            System.out.println((i + 1) + ". " + t.getName() + " | Habilitado: " + t.isEnabled());
        }
        System.out.print("Seleccione el sendero a cerrar (numero): ");
        int trailIdx = scanner.nextInt() - 1;
        scanner.nextLine();

        gestorTours.closeTrail(tour, trailIdx);
    }
}
