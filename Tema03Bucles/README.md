# Tema 03 — Bucles

> Prerequisito: Tema 01, Tema 02

Estructuras de repeticion: `for`, `while`, `do-while` y bucles anidados.

---

## Teoria rapida

### for

```java
// Bucle clasico
for (int i = 0; i < 10; i++) {
    System.out.println(i);
}

// Contar hacia atras
for (int i = 10; i > 0; i--) {
    System.out.println(i);
}

// Saltar de dos en dos
for (int i = 0; i <= 20; i += 2) {
    System.out.println(i);
}
```

### while

```java
// Se ejecuta mientras la condicion sea true
// Puede no ejecutarse nunca si la condicion es false desde el inicio
int i = 0;
while (i < 10) {
    System.out.println(i);
    i++;
}
```

### do-while

```java
// Se ejecuta al menos una vez antes de comprobar la condicion
int opcion;
do {
    opcion = sc.nextInt();
} while (opcion < 1 || opcion > 5);  // valida que la opcion sea 1-5
```

### break y continue

```java
for (int i = 0; i < 10; i++) {
    if (i == 5) break;     // sale del bucle cuando i = 5
    if (i % 2 == 0) continue; // salta los pares, pasa a la siguiente iteracion
    System.out.println(i);
}
```

### Bucles anidados — tabla de multiplicar

```java
for (int tabla = 1; tabla <= 10; tabla++) {
    for (int num = 1; num <= 10; num++) {
        System.out.printf("%3d", tabla * num);
    }
    System.out.println();
}
```

---

## Ejercicios

| Archivo | Descripcion |
|---------|------------|
| `Ejercicio01ComprobacionNum.java` | Comprobar condicion en un rango |
| `Ejercicio02FuncAlumn.java` | Funcionalidad con alumnos |
| `Ejercicio03NumSecreto.java` | Adivinar numero secreto con `while` |
| `Ejercicio04InvestigacionFlora.java` | Acumulador con bucle |
| `Ejercicio05Calculos.java` | Calculos iterativos |
| `Ejercicio06AprenderContar.java` | Contar de distintas formas |
| `Ejercicio07multiplos.java` | Mostrar multiplos de un numero |
| `Ejercicio08Enteros.java` | Procesar lista de enteros |
| `Ejercicio09TablaMult.java` | Tabla de multiplicar con bucle anidado |
| `Ejercicio10Suma.java` | Suma acumulativa |
| `Ejercicio11Factorial.java` | Calculo de factorial con `for` |
| `Ejercicio12Calificaciones.java` | Media de calificaciones |
| `Ejercicio13Notas.java` | Estadisticas de notas |
| `Ejercicio14Tablas.java` | Varias tablas de multiplicar |
| `Ejercicio15Triangulo.java` | Dibujar triangulo con bucles anidados |
| `Ejercicio16Edades.java` | Clasificar edades con bucle |
| `Ejercicio17Eco.java` | Repetir entrada del usuario |
| `Ejercicio18NumPos.java` | Filtrar numeros positivos |
| `Ejercicio19Decimales.java` | Operar con decimales en bucle |
| `Ejercicio20ConversionBinario.java` | Convertir decimal a binario |
