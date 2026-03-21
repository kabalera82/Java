package Tema08_01Herencia.Ejercicio03Planta;

public class Flower extends Plant {
    private String colorPetals;
    private int quantityPetal;
    private String variety;
    private String station;

    Flower() {
    }

    public Flower(String name, double higth, boolean sheets, String weather, String colorPetals, int quantityPetal, String variety, String station) {
        super(name, higth, sheets, weather);
        this.colorPetals = colorPetals;
        this.quantityPetal = quantityPetal;
        this.variety = variety;
        this.station = station;
    }

    public String getColorPetals() {
        return colorPetals;
    }

    public void setColorPetals(String colorPetals) {
        this.colorPetals = colorPetals;
    }

    public int getQuantityPetal() {
        return quantityPetal;
    }

    public void setQuantityPetal(int quantityPetal) {
        this.quantityPetal = quantityPetal;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    @Override
    public void saidWhoIam() {
        System.out.println("I am a Flower");
    }


}
