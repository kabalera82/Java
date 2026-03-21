# Tema 01 — Conceptos Básicos de Java

> Prerequisito: ninguno | Primer contacto con el lenguaje

Fundamentos del lenguaje Java: tipos de datos, operadores, entrada/salida por consola y por ventana (`JOptionPane`).

---

## Teoria rapida

### Tipos primitivos

| Tipo | Tamanio | Rango | Ejemplo |
|------|---------|-------|---------|
| `byte` | 8 bits | -128 a 127 | `byte b = 10;` |
| `short` | 16 bits | -32768 a 32767 | `short s = 1000;` |
| `int` | 32 bits | -2^31 a 2^31-1 | `int n = 42;` |
| `long` | 64 bits | muy grande | `long l = 123L;` |
| `float` | 32 bits | ~7 decimales | `float f = 3.14f;` |
| `double` | 64 bits | ~15 decimales | `double d = 3.14;` |
| `char` | 16 bits | Unicode | `char c = 'A';` |
| `boolean` | 1 bit | true/false | `boolean ok = true;` |

### Operadores

```java
// Aritmeticos
+  -  *  /  %  (modulo)

// Asignacion compuesta
+=  -=  *=  /=  %=

// Incremento/Decremento
int a = 5;
a++;  // a = 6 (post-incremento)
++a;  // a = 7 (pre-incremento)

// Relacionales — devuelven boolean
==  !=  <  >  <=  >=

// Logicos
&&  (AND)   ||  (OR)   !  (NOT)
```

### Entrada/Salida por consola

```java
import java.util.Scanner;

Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
double d = sc.nextDouble();
String s = sc.nextLine();

System.out.println("con salto de linea");
System.out.print("sin salto de linea");
System.out.printf("formateado: %d y %.2f%n", n, d);
```

### Entrada/Salida por ventana (JOptionPane)

```java
import javax.swing.JOptionPane;

// Leer del usuario
String entrada = JOptionPane.showInputDialog("Introduce un numero:");
int n = Integer.parseInt(entrada);

// Mostrar resultado
JOptionPane.showMessageDialog(null, "El resultado es: " + n);
```

### Conversion de tipos (casting)

```java
double d = 3.99;
int i = (int) d;      // casting explicito → 3 (trunca, no redondea)

int a = 5, b = 2;
double resultado = (double) a / b;  // 2.5 — sin el cast seria 2 (division entera)
```

---

## Ejercicios

| Archivo | Descripcion |
|---------|------------|
| `Ejercicio01HolaMundo.java` | `System.out.print` vs `System.out.println` |
| `Ejercicio02SalidaConsola.java` | Formatear salida con `printf` y tipos |
| `Ejercicio03OperadoresAritmeticos.java` | Operaciones con tipos primitivos |
| `Ejercicio04JOptionPanel.java` | Entrada/salida con `JOptionPane` |
| `Ejercicio05.java` | Calculos basicos con variables |
| `Ejercicio06.java` | Operaciones con enteros y doubles |
| `Ejercicio07Economista.java` | Calculo economico con casting |
| `Ejercicio08Multiplos.java` | Uso del operador modulo `%` |
| `Ejercicio09Triangulo.java` | Area y perimetro de un triangulo |
| `Ejercicio10Ec2Grado.java` | Ecuacion de 2º grado con `Math.sqrt` |
| `Ejercicio11Tiempo.java` | Conversion de segundos a h/m/s |
| `Ejercicio12Conversiones.java` | Conversion de unidades |
| `Ejercicio13-16Calculos.java` | Calculos matematicos variados |
| `Ejercicio99Repaso.java` | Repaso general del tema |
| `Primitivos.java` | Referencia de todos los tipos primitivos |

---

## Referencia rapida — `Math`

```java
Math.abs(-5)        // 5 — valor absoluto
Math.pow(2, 10)     // 1024.0 — potencia
Math.sqrt(16)       // 4.0 — raiz cuadrada
Math.max(3, 7)      // 7 — maximo
Math.min(3, 7)      // 3 — minimo
Math.round(3.7)     // 4 — redondeo
Math.random()       // 0.0 a 1.0 — numero aleatorio
(int)(Math.random() * 10) + 1  // entero entre 1 y 10
```
