package ec.edu.espoch.yasuniexplore.Objetos;

/**
 * Clase abstracta que representa un tour guiado.
 * Contiene un arreglo de senderos y el factor de dificultad.
 */
public abstract class Tour {
    private String code;
    private String name;
    private Trail[] trails;
    private int trailCount;
    private double factor;
    private Guide assignedGuide;
    private CommunicationDevice assignedDevice;

    public Tour(String code, String name, int maxTrails) {
        this.code = code;
        this.name = name;
        this.trails = new Trail[maxTrails];
        this.trailCount = 0;
        this.factor = 1.0;
    }

    public void addTrail(Trail trail) {
        if (trailCount < trails.length) {
            trails[trailCount] = trail;
            trailCount++;
        } else {
            System.out.println("No se pueden agregar mas senderos. Arreglo lleno.");
        }
    }

    public double calculateBaseWalkingTime() {
        double total = 0;
        for (int i = 0; i < trailCount; i++) {
            if (trails[i] != null && trails[i].isEnabled()) {
                total += trails[i].getTimeEstimated();
            }
        }
        return total;
    }

    public double calculateTotalDistance() {
        double total = 0;
        for (int i = 0; i < trailCount; i++) {
            if (trails[i] != null && trails[i].isEnabled()) {
                total += trails[i].getLength();
            }
        }
        return total;
    }

    public abstract double calculateTotalDuration();

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Trail[] getTrails() {
        return trails;
    }

    public int getTrailCount() {
        return trailCount;
    }

    public double getFactor() {
        return factor;
    }

    public void setFactor(double factor) {
        this.factor = factor;
    }

    public Guide getAssignedGuide() {
        return assignedGuide;
    }

    public void setAssignedGuide(Guide assignedGuide) {
        this.assignedGuide = assignedGuide;
    }

    public CommunicationDevice getAssignedDevice() {
        return assignedDevice;
    }

    public void setAssignedDevice(CommunicationDevice assignedDevice) {
        this.assignedDevice = assignedDevice;
    }

    @Override
    public String toString() {
        String guia = (assignedGuide != null) ? assignedGuide.getName() : "Ninguno";
        String dispositivo = (assignedDevice != null) ? assignedDevice.getCode() : "Ninguno";
        return "Tour: " + code + " - " + name +
               "\n  Distancia total: " + calculateTotalDistance() + " km" +
               "\n  Duracion total: " + calculateTotalDuration() + " min" +
               "\n  Factor dificultad: " + factor +
               "\n  Guia asignado: " + guia +
               "\n  Dispositivo asignado: " + dispositivo;
    }
}
