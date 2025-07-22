package Tema07Clases.ejercicio04Conversor;

public class ConversorDatos {
    private int bytes;

    // Constructor
    public ConversorDatos(int bytes) {
        this.bytes = bytes;
    }

    // Devuelve los bits (1 byte = 8 bits)
    public double getBits() {
        return bytes * 8.0;
    }

    // Megabytes (1 MB = 1.000.000 B)
    public double getMB() {
        return bytes / 1_000_000.0;
    }

    // Mebibytes (1 MiB = 1.048.576 B)
    public double getMiB() {
        return bytes / 1_048_576.0;
    }

    // Gigabytes (1 GB = 1.000.000.000 B)
    public double getGB() {
        return bytes / 1_000_000_000.0;
    }

    // Gibibytes (1 GiB = 1.073.741.824 B)
    public double getGiB() {
        return bytes / 1_073_741_824.0;
    }

    // Bytes
    public int getBytes() {
        return bytes;
    }
}
