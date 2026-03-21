# Tema 04b — VarArgs y Sobrecarga

> Prerequisito: Tema 04a (metodos)

Argumentos variables (`varargs`), sobrecarga de metodos y primeros `Stream` basicos.

---

## Teoria rapida

### Varargs — argumentos variables

```java
// La elipsis (...) indica que acepta 0 o mas argumentos del tipo indicado
public static int sumar(int... numeros) {
    int total = 0;
    for (int n : numeros) total += n;
    return total;
}

// Llamadas validas:
sumar()              // 0 argumentos — numeros es un array vacio
sumar(1)             // 1 argumento
sumar(1, 2, 3)       // 3 argumentos
sumar(1, 2, 3, 4, 5) // 5 argumentos

// REGLA: varargs debe ser el ultimo parametro
public static void log(String nivel, String... mensajes) { ... }
```

### Sobrecarga de metodos

```java
// Mismo nombre, diferente firma (numero o tipo de parametros)
public static int area(int lado) {                  // cuadrado
    return lado * lado;
}
public static double area(double radio) {           // circulo
    return Math.PI * radio * radio;
}
public static int area(int base, int altura) {      // rectangulo
    return base * altura;
}

// Java elige el metodo correcto segun los argumentos en tiempo de compilacion
area(5)          // llama al primero (int)
area(3.0)        // llama al segundo (double)
area(4, 6)       // llama al tercero (dos int)
```

---

## Ejercicios

| Archivo | Descripcion |
|---------|------------|
| `Ejercicio01ArgumentosVariables.java` | Metodo basico con varargs |
| `Ejercicio02MetParamVariables.java` | Metodo con parametros variables y calculo |
| `Ejercicio03ArgumentosMetodosVariables.java` | Combinar varargs con otros parametros |
| `Ejercicio04SobrecargaMetodos.java` | Sobrecarga — mismo nombre, diferente firma |
| `utils/Utilidades.java` | Clase de utilidades estaticas |
| `utils/Utilidades2.java` | Segunda clase de utilidades |
