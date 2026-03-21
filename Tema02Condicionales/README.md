# Tema 02 — Condicionales

> Prerequisito: Tema 01 (tipos primitivos, operadores booleanos)

Estructuras de control de flujo que permiten tomar decisiones: `if/else`, `switch` y el operador ternario.

---

## Teoria rapida

### if / else if / else

```java
int nota = 75;

if (nota >= 90) {
    System.out.println("Sobresaliente");
} else if (nota >= 70) {
    System.out.println("Notable");
} else if (nota >= 50) {
    System.out.println("Aprobado");
} else {
    System.out.println("Suspenso");
}
```

### switch

```java
// switch clasico (Java < 14)
int dia = 3;
switch (dia) {
    case 1: System.out.println("Lunes"); break;
    case 2: System.out.println("Martes"); break;
    case 3: System.out.println("Miercoles"); break;
    default: System.out.println("Otro dia");
}

// switch expression (Java 14+) — sin break, con ->
String nombre = switch (dia) {
    case 1 -> "Lunes";
    case 2 -> "Martes";
    case 3 -> "Miercoles";
    default -> "Otro";
};
```

### Operador ternario

```java
// condicion ? valor_si_true : valor_si_false
int max = (a > b) ? a : b;
String mensaje = (edad >= 18) ? "Mayor de edad" : "Menor de edad";
```

### Operadores logicos

```java
// AND: las dos condiciones deben ser true
if (edad >= 18 && tieneDNI) { ... }

// OR: al menos una condicion debe ser true
if (esSocio || tieneInvitacion) { ... }

// NOT: niega la condicion
if (!estaVacio) { ... }
```

---

## Ejercicios

| Archivo | Descripcion |
|---------|------------|
| `Ejercicio01ParImpar.java` | Determinar si un numero es par o impar |
| `Ejercicio02ComparaNum.java` | Comparar dos numeros |
| `Ejercicio03OrdenarNum.java` | Ordenar 3 numeros de menor a mayor |
| `Ejercicio04NumDec.java` | Clasificar numero segun rango |
| `Ejercicio05NumDecre.java` | Orden decreciente de numeros |
| `Ejercicio06OrdenNum.java` | Ordenacion de numeros |
| `Ejercicio07OrdenNum.java` | Variante de ordenacion |
| `Ejercicio08Coeficiente.java` | Calculo con condicion |
| `Ejercicio09OrdenNum.java` | Ordenar N numeros |
| `Ejercicio10Nota.java` | Calificacion a partir de nota numerica |
| `Ejercicio11NumSemana.java` | Nombre del dia de la semana con `switch` |
| `Ejercicio12Fechas.java` | Validacion de fechas |
| `Ejercicio13Horas.java` | Conversion y validacion de horas |
| `Ejercicio14Fechas.java` | Calculo con fechas |
| `Ejercicio15Numeros.java` | Clasificacion numerica |
| `Ejercicio16GeneraDni.java` | Generar letra del DNI |
| `Ejercicio17Animales.java` | Clasificacion con `switch` |
| `Ejercicio18NumLetra.java` | Numero a letra |
| `Ejercicio19JuegoSumas.java` | Juego con condiciones |
| `Ejercicio20Angulos.java` | Clasificacion de angulos |
