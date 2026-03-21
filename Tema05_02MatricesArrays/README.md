# Tema 05b — Matrices y Algoritmos de Ordenacion

> Prerequisito: Tema 05a (arrays 1D)

Arrays bidimensionales (matrices) y algoritmos clasicos de ordenacion y busqueda.

---

## Teoria rapida

### Arrays bidimensionales

```java
// Declarar e inicializar
int[][] matriz = new int[3][4];   // 3 filas, 4 columnas

// Inicializacion directa
int[][] tablero = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

// Acceder a un elemento
tablero[1][2]   // 6 — fila 1, columna 2

// Dimensiones
tablero.length       // 3 — numero de filas
tablero[0].length    // 3 — numero de columnas

// Recorrer con bucles anidados
for (int i = 0; i < matriz.length; i++) {
    for (int j = 0; j < matriz[i].length; j++) {
        System.out.printf("%4d", matriz[i][j]);
    }
    System.out.println();
}
```

### Algoritmos de ordenacion

```java
// BURBUJA — O(n^2) — simple pero lento
for (int i = 0; i < n - 1; i++) {
    for (int j = 0; j < n - 1 - i; j++) {
        if (arr[j] > arr[j+1]) {
            int temp = arr[j];
            arr[j] = arr[j+1];
            arr[j+1] = temp;
        }
    }
}

// INSERCION — O(n^2) — eficiente para arrays casi ordenados
for (int i = 1; i < n; i++) {
    int clave = arr[i];
    int j = i - 1;
    while (j >= 0 && arr[j] > clave) {
        arr[j+1] = arr[j];
        j--;
    }
    arr[j+1] = clave;
}

// SELECCION — O(n^2) — minimo numero de intercambios
for (int i = 0; i < n - 1; i++) {
    int minIdx = i;
    for (int j = i + 1; j < n; j++) {
        if (arr[j] < arr[minIdx]) minIdx = j;
    }
    int temp = arr[minIdx];
    arr[minIdx] = arr[i];
    arr[i] = temp;
}
```

### Busqueda binaria — O(log n)

```java
// REQUIERE array ORDENADO
static int busquedaBinaria(int[] arr, int objetivo) {
    int izq = 0, der = arr.length - 1;
    while (izq <= der) {
        int medio = (izq + der) / 2;
        if (arr[medio] == objetivo) return medio;
        if (arr[medio] < objetivo) izq = medio + 1;
        else der = medio - 1;
    }
    return -1; // no encontrado
}
```

---

## Ejercicios

| Archivo | Descripción |
|---------|------------|
| `Ejercicio01MatrizUnidimensional.java` | Crear y mostrar una matriz |
| `Ejercicio02ForEach.java` | Recorrer con for-each |
| `Ejercicio03MatrizBidimensional.java` | Operaciones con matriz 2D |
| `Ejercicio04Burbuja.java` | Algoritmo de la burbuja |
| `Ejercicio05OrdenacionIsercion.java` | Algoritmo de insercion |
| `Ejercicio06OrdenacionSeleccion.java` | Algoritmo de seleccion |
| `Ejercicio07MetodosBusqueda.java` | Busqueda lineal y binaria |
| `Ejercicio08BusquedaBinaria.java` | Busqueda binaria detallada |
