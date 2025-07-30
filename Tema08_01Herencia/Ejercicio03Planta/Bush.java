package Tema08_01Herencia.Ejercicio03Planta;

public class Bush extends Plant {

    private double weight;
    private boolean savage;

    Bush() {
    }

    public Bush(String name, double higth, boolean sheets, String weather, double weight, boolean savage) {
        super(name, higth, sheets, weather);
        this.weight = weight;
        this.savage = savage;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isSavage() {
        return savage;
    }

    public void setSavage(boolean savage) {
        this.savage = savage;
    }

    @Override
    public void saidWhoIam() {
        System.out.println("I am a Bush");
    }
}
