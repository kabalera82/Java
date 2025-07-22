package Tema07Clases.ejercicio04Conversor;

public class ConversorTemperatura {

    private double tempF, tempC, tempK;

    // Setters
    public void setFahrenheit(double f) {
        tempF = f;
    }

    public void setCelsius(double c) {
        tempC = c;
    }

    public void setKelvin(double k) {
        tempK = k;
    }

    // Celsius ↔ Fahrenheit
    public double celsiusToFahrenheit() {
        return (1.8 * tempC) + 32;
    }

    public double fahrenheitToCelsius() {
        return (tempF - 32) / 1.8;
    }

    // Celsius ↔ Kelvin
    public double celsiusToKelvin() {
        return tempC + 273.15;
    }

    public double kelvinToCelsius() {
        return tempK - 273.15;
    }

    // Fahrenheit ↔ Kelvin (opcional, combinando anteriores)
    public double fahrenheitToKelvin() {
        return celsiusToKelvin(fahrenheitToCelsius());
    }

    public double kelvinToFahrenheit() {
        return celsiusToFahrenheit(kelvinToCelsius());
    }

    // Métodos auxiliares para combinaciones
    private double fahrenheitToCelsius(double f) {
        return (f - 32) / 1.8;
    }

    private double celsiusToKelvin(double c) {
        return c + 273.15;
    }

    private double kelvinToCelsius(double k) {
        return k - 273.15;
    }

    private double celsiusToFahrenheit(double c) {
        return (c * 1.8) + 32;
    }

    private double kelvinToFahrenheit(double k) {
        return celsiusToFahrenheit(kelvinToCelsius(k));
    }

    private double fahrenheitToKelvin(double f) {
        return celsiusToKelvin(fahrenheitToCelsius(f));
    }
}
