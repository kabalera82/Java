package Tema07Clases.ejercicio07personaSobrecarga;

/**
 * Define una clase deportista que contenga PErsona (ejercicio01)
 * atributos deporte practicado si tiene licencia o nó en caso positivo su numero de licencia
 * dos constructores uno con licencia y otro sin licencia
 * lo importante de este ejercicio es la sobrecarga de constructores y metodos
 */


import Tema07Clases.ejercicio01persona.Persona;

/** Entity representing a sports person. */
public class Deportista {

    // === Attributes ==========================================================
    private Persona persona;
    private String sport;
    private boolean federated;
    private String licFed; // meaningful only if federated

    // === Constructors ========================================================

    /** Non-federated athlete. */
    public Deportista(Persona persona, String sport, boolean federated) {
        this(persona, sport, federated, null);
    }

    /** Federated athlete (license kept only if federated is true). */
    public Deportista(Persona persona, String sport, boolean federated, String licFed) {
        this.persona   = persona;
        this.sport     = sport;
        this.federated = federated;
        this.licFed    = (federated && licFed != null && !licFed.isBlank()) ? licFed : null;
    }

    // === Invariants & Setters ===============================================

    /** Change federated status; clears license when set to false. */
    public void setFederated(boolean federated) {
        this.federated = federated;
        if (!federated) this.licFed = null;
    }

    /** Set license only if federated; otherwise store null. */
    public void setLicFed(String licFed) {
        this.licFed = (this.federated && licFed != null && !licFed.isBlank()) ? licFed : null;
    }

    // === Helpers =============================================================

    private boolean hasValidLicense() {
        return federated && licFed != null && !licFed.isBlank();
    }

    private String federatedTag() {
        return federated ? "[Federated]" : "[Not federated]";
    }

    // === Overloaded methods ==================================================

    /** Basic info: name, sport, and federated tag. */
    public void showInfo() {
        System.out.println(persona.getNombre() + " practices " + sport + " " + federatedTag());
    }

    /**
     * Adds federated tag conditionally.
     * @param showFederated whether to display federated information
     */
    public void showInfo(boolean showFederated) {
        StringBuilder sb = new StringBuilder();
        sb.append(persona.getNombre()).append(" practices ").append(sport);
        if (showFederated) sb.append(" ").append(federatedTag());
        System.out.println(sb);
    }

    /**
     * Adds federated tag and (only if valid) license.
     * @param showFederated whether to display federated information
     * @param showLicense   whether to display license number (shown only if valid)
     */
    public void showInfo(boolean showFederated, boolean showLicense) {
        StringBuilder sb = new StringBuilder();
        sb.append(persona.getNombre()).append(" practices ").append(sport);
        if (showFederated) sb.append(" ").append(federatedTag());
        if (showLicense && hasValidLicense()) sb.append(" | License: ").append(licFed);
        System.out.println(sb);
    }

    // (Opcional) útil para logs/debug
    @Override
    public String toString() {
        return persona.getNombre() + " - " + sport + " " + federatedTag() +
                (hasValidLicense() ? " | License: " + licFed : "");
    }
}
