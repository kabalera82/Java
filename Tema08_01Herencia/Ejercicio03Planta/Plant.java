package Tema08_01Herencia.Ejercicio03Planta;

public abstract class Plant {
    double high;
    private String name;
    private boolean sheets;
    private String Weather;

    public Plant() {
    }

    ;

    public Plant(String name, double higth, boolean sheets, String weather) {
        this.name = name;
        this.high = higth;
        this.sheets = sheets;
        Weather = weather;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public boolean isSheets() {
        return sheets;
    }

    public void setSheets(boolean sheets) {
        this.sheets = sheets;
    }

    public String getWeather() {
        return Weather;
    }

    public void setWeather(String weather) {
        Weather = weather;
    }

    //metodo abstracto
    public abstract void saidWhoIam();
}
