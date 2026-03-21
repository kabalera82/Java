# Tema 05a — Arrays (Tablas)

> Prerequisito: Tema 01-04

Arrays unidimensionales: declaracion, inicializacion, recorrido y operaciones comunes.

---

## Teoria rapida

### Declaracion e inicializacion

```java
// Declarar y crear (valores por defecto: 0 para int, null para objetos)
int[] numeros = new int[5];         // [0, 0, 0, 0, 0]

// Inicializacion directa
int[] primos = {2, 3, 5, 7, 11};   // longitud inferida = 5

// Acceder a elementos
primos[0]   // 2  — primer elemento (indice 0)
primos[4]   // 11 — ultimo elemento
primos.length // 5 — numero de elementos

// CUIDADO: ArrayIndexOutOfBoundsException si el indice esta fuera de rango
primos[5]   // ERROR — el ultimo indice valido es 4
```

### Recorrer un array

```java
int[] nums = {10, 20, 30, 40, 50};

// for clasico — cuando necesitas el indice
for (int i = 0; i < nums.length; i++) {
    System.out.println("nums[" + i + "] = " + nums[i]);
}

// for-each — cuando solo necesitas los valores
for (int n : nums) {
    System.out.println(n);
}
```

### Clase `Arrays` — utilidades

```java
import java.util.Arrays;

int[] arr = {5, 3, 1, 4, 2};

Arrays.sort(arr);               // ordena in-place: [1, 2, 3, 4, 5]
Arrays.fill(arr, 0);            // rellena con 0: [0, 0, 0, 0, 0]
int idx = Arrays.binarySearch(arr, 3);  // busqueda binaria (requiere ordenado)
int[] copia = Arrays.copyOf(arr, arr.length);  // copia el array
System.out.println(Arrays.toString(arr));       // imprime bonito
```

### Pasar array a un metodo

```java
// Se pasa por referencia — los cambios dentro del metodo afectan al original
static int suma(int[] arr) {
    int total = 0;
    for (int n : arr) total += n;
    return total;
}

static void duplicar(int[] arr) {
    for (int i = 0; i < arr.length; i++) arr[i] *= 2;
}
```

---

## Ejercicios

| Archivo | Descripcion |
|---------|------------|
| `Ejercicio01TablaReferencia.java` | Crear y mostrar un array |
| `Ejercicio02RangoValores.java` | Rellenar array con rango de valores |
| `Ejercicio03PedirNumeros.java` | Leer N numeros y guardarlos |
| `Ejercicio04MaximoTabla.java` | Encontrar el maximo de un array |
| `Ejercicio05RellenarPares.java` | Rellenar array con numeros pares |
| `Ejercicio06NumeroAciertos.java` | Comparar dos arrays elemento a elemento |
| `Ejercicio07SinRepetidos.java` | Filtrar elementos duplicados |
| `Ejercicio08GestionResultados.java` | Estadisticas de un array |
| `Ejercicio09MediaNumeros.java` | Calcular la media |
| `Ejercicio10IntroducirValores.java` | Entrada de usuario en array |
| `Ejercicio11SumaDiagonal.java` | Suma de la diagonal (anticipo de matrices) |
| `Ejercicio12CamaraSecreta.java` | Algoritmo con arrays |
| `Ejercicio13CreaOrdena.java` | Crear y ordenar array |
| `Ejercicio14ArrayFill.java` | Uso de `Arrays.fill()` |
| `Ejercicio15CopyOf.java` | Uso de `Arrays.copyOf()` |
| `VueltaEfectivo/` | Calculo de cambio con array de billetes |
