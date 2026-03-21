# Tema 04a — Métodos

> Prerequisito: Tema 01-03

Declaracion, llamada y composicion de metodos. Paso de parametros, retorno de valores y recursion.

---

## Teoria rapida

### Anatomia de un metodo

```java
// modificador  tipoRetorno  nombre  (parametros)
public static   int          sumar   (int a, int b) {
    return a + b;  // valor de retorno del mismo tipo declarado
}

// void: no devuelve nada
public static void saludar(String nombre) {
    System.out.println("Hola, " + nombre);
}
```

### Llamada a un metodo

```java
// Desde main (metodo estatico llamando a metodo estatico)
int resultado = sumar(3, 5);     // 8
saludar("Marcos");               // Hola, Marcos

// Si el metodo no es estatico, necesitas un objeto:
MiClase obj = new MiClase();
obj.miMetodo();
```

### Paso por valor vs referencia

```java
// Los tipos primitivos se pasan por VALOR — el original no cambia
static void doblar(int n) { n = n * 2; }  // no afecta al original
int x = 5;
doblar(x);
System.out.println(x); // sigue siendo 5

// Los objetos/arrays se pasan por referencia — el original puede cambiar
static void rellenar(int[] arr) { arr[0] = 99; }
int[] nums = {1, 2, 3};
rellenar(nums);
System.out.println(nums[0]); // 99
```

### Recursion

```java
// Un metodo que se llama a si mismo
// SIEMPRE necesita un caso base para no ser infinito
static int factorial(int n) {
    if (n <= 1) return 1;          // caso base
    return n * factorial(n - 1);  // llamada recursiva
}

// factorial(4) = 4 * factorial(3)
//              = 4 * 3 * factorial(2)
//              = 4 * 3 * 2 * factorial(1)
//              = 4 * 3 * 2 * 1 = 24
```

---

## Ejercicios

| Archivo | Descripción |
|---------|------------|
| `Ejercicio01Suma.java` | Metodo que suma dos enteros |
| `Ejercicio02Saludar.java` | Metodo con `String` como retorno |
| `Ejercicio03Redondeo.java` | Metodo de redondeo personalizado |
| `Ejercicio04ParImpar.java` | Metodo que retorna boolean |
| `Ejercicio05numerosAleatorios.java` | Generador de numeros aleatorios |
| `Ejercicio06LongitudCadena.java` | Metodo que recibe y retorna String |
| `Ejercicio07GeneradorId.java` | Generar identificadores unicos |
| `Ejercicio08GeneradorEmails.java` | Construir emails a partir de datos |
| `Ejercicio09FuncionRecursiva.java` | Recursion básica |
| `Ejercicio10AreasYVolumenes.java` | Metodos geometricos con `Math` |
| `Ejercicio11CambiaHoras.java` | Conversion de unidades de tiempo |
| `Ejercicio12MostrarRango.java` | Metodo que imprime un rango |
| `Ejercicio13VolumenCilindro.java` | Calculo geometrico |
| `Ejercicio14RetornaMaximo.java` | Metodo que retorna el maximo de N valores |
| `Ejercicio15esVocal.java` | Metodo que verifica si es vocal |
| `Ejercicio16EsPRimo.java` | Verificar si un numero es primo |
| `Ejercicio17DivisoresPrimos.java` | Descomposicion en factores primos |
| `Ejercicio18Calculadora.java` | Calculadora con metodos por operación |
| `Ejercicio19MaximoParametros.java` | Maximo con multiple parametros |
| `Ejercicio20Iterativa.java` | Comparacion iterativo vs recursivo |
