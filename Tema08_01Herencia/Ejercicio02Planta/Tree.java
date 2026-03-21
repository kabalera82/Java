package Tema08_01Herencia.Ejercicio03Planta;

public class Tree extends Plant {

    private String variety;
    private String typeTrunk;
    private String color;
    private String tipeSheet;

    public Tree() {
    }

    public Tree(String name, double higth, boolean sheets, String weather, String variety, String typeTrunk, String color, String tipeSheet) {
        super(name, higth, sheets, weather);
        this.variety = variety;
        this.typeTrunk = typeTrunk;
        this.color = color;
        this.tipeSheet = tipeSheet;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getTypeTrunk() {
        return typeTrunk;
    }

    public void setTypeTrunk(String typeTrunk) {
        this.typeTrunk = typeTrunk;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipeSheet() {
        return tipeSheet;
    }

    public void setTipeSheet(String tipeSheet) {
        this.tipeSheet = tipeSheet;
    }

    @Override
    public void saidWhoIam() {
        System.out.println("I am a Tree");
    }
}
