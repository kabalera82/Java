# Java desde Cero — Guía de Aprendizaje Completa

![Java 24](https://img.shields.io/badge/Java-24-orange?logo=openjdk)
![IntelliJ IDEA](https://img.shields.io/badge/IDE-IntelliJ%20IDEA-blue?logo=intellijidea)
![Maven](https://img.shields.io/badge/build-Maven-red?logo=apachemaven)
![Licencia MIT](https://img.shields.io/badge/licencia-MIT-green)

Repositorio de teoría y ejercicios de Java para el primer curso de **Desarrollo de Aplicaciones Multiplataforma (1º DAM)**. Cubre desde los fundamentos del lenguaje hasta programación orientada a objetos, colecciones, ficheros, hilos y acceso a bases de datos con JDBC. Cada concepto se aprende con ejercicios prácticos, comentados paso a paso.

---

## ¿Para quién es este repositorio?

Este repositorio es para ti si:

- Estás empezando a programar en Java (o en cualquier lenguaje)
- Estudias un ciclo formativo de Informática o una carrera técnica
- Quieres consolidar los fundamentos antes de lanzarte a frameworks y librerías
- Aprendes mejor leyendo código real que memorizando teoría

No necesitas saber nada de programación para empezar. El Tema 01 parte desde cero.

---

## Cómo usar este repositorio

Este repositorio está pensado para seguirse **en orden**, de arriba a abajo. Cada tema construye sobre el anterior.

1. Lee la descripción del tema en este README para saber qué vas a aprender
2. Abre la carpeta del tema en IntelliJ IDEA
3. Lee los comentarios `[APRENDE]` dentro del código — están en el punto exacto donde ocurre el concepto
4. Ejecuta el ejercicio, cambia valores, rompe cosas, observa qué pasa
5. Cuando entiendas el ejercicio, pasa al siguiente

> No copies el código sin entenderlo. Si no sabes por qué funciona, no funciona para ti.

---

## Estructura del proyecto

```
JavaRepo/
├── Tema01ConceptosBasicos/        Tipos, operadores, entrada de datos
├── Tema02Condicionales/           if/else, switch, operador ternario
├── Tema03Bucles/                  for, while, do-while
├── Tema04_01Metodos/              Métodos, parámetros, retorno, recursión
├── Tema04_02VarArgs/              Argumentos variables, sobrecarga
├── Tema04_03Polimorfismo/         Polimorfismo, clases abstractas, casting
├── Tema05_01Tablas/               Arrays unidimensionales
├── Tema05_02MatricesArrays/       Arrays 2D, ordenación, búsqueda
├── Tema06CadenasDeCaracteres/     String, StringBuilder, formateo
├── Tema07Clases/                  Clases, constructores, encapsulamiento
├── Tema08_01Herencia/             Herencia, extends, super, @Override
├── Tema08_02InstanceOf/           instanceof, casting de objetos
├── Tema09Interfaces/              Interfaces, implementación múltiple
├── Tema10Excepciones/             try-catch-finally, excepciones personalizadas
├── Tema11_01FicherosDeTexto/      Lectura y escritura de ficheros de texto
├── Tema11_02FicherosBinarios/     Serialización, DataOutputStream, ObjectOutputStream
├── Tema11_03CSV/                  Crear, leer, modificar y CRUD sobre archivos CSV
├── Tema11_04PDF/                  Generar y leer PDFs con iText 7
├── Tema12Colecciones/             List, Set, Map, Queue, Stack
├── Tema13AccesoDatos/             Texto plano, Properties, JSON, CSV
├── Tema14Streams/                 Streams, lambdas, Optional
├── Tema15Hilos/                   Thread, Runnable, sincronización, ExecutorService
├── Tema16JDBC/                    JDBC + MySQL con patrón DAO
└── Tema99EjerciciosMultiples/     Ejercicios mixtos de repaso
```

---

## Temario completo

---

### TEMA 01 — Conceptos Básicos

**¿Qué aprenderás?**
- Tipos de datos primitivos: `int`, `double`, `boolean`, `char`
- Operadores aritméticos, relacionales y lógicos
- Entrada de datos con `Scanner` y `JOptionPane`
- Conversiones entre tipos (`casting`)

**Ejercicios incluidos:**

| Ejercicio | Descripción | Conceptos clave |
|-----------|-------------|-----------------|
| Ejercicio01HolaMundo | El primer programa en Java | `System.out.println`, clase, `main` |
| Ejercicio02SalidaConsola | Mostrar distintos tipos de datos | `print`, `println`, `printf` |
| Ejercicio03OperadoresAritmeticos | Suma, resta, multiplicación, división | Operadores `+`, `-`, `*`, `/`, `%` |
| Ejercicio04JOptionPanel | Ventanas de diálogo con Swing | `JOptionPane`, ventana emergente |
| Ejercicio05 / Ejercicio06 | Ejercicios de variables y tipos | Declaración y asignación |
| Ejercicio07Economista | Cálculo de porcentajes e intereses | `double`, operaciones matemáticas |
| Ejercicio08Multiplos | Múltiplos de un número | Operador módulo `%` |
| Ejercicio09Triangulo | Cálculo de área de triángulo | Fórmulas con variables |
| Ejercicio10Ec2Grado | Ecuación de segundo grado | `Math.sqrt`, raíz cuadrada |
| Ejercicio11Tiempo | Conversión de segundos a horas/min/seg | División entera y módulo |
| Ejercicio12Conversiones | Conversiones de unidades | Casting, operaciones encadenadas |
| Ejercicio13-16Calculos | Series de cálculos numéricos | Operadores, precedencia |
| Ejercicio99Repaso | Ejercicio integrador del tema | Todos los conceptos del tema |
| Primitivos | Referencia de tipos primitivos | Rango y tamaño de cada tipo |

**Concepto clave:** Una variable es como una caja con etiqueta. La etiqueta es el nombre (`edad`, `precio`), lo que hay dentro es el valor (`25`, `9.99`), y el tipo (`int`, `double`) define qué tipo de cosas puedes meter en esa caja. No puedes meter texto en una caja de enteros.

---

### TEMA 02 — Condicionales

**¿Qué aprenderás?**
- Estructuras `if`, `else if`, `else`
- `switch` para múltiples opciones
- Operador ternario `condicion ? valor1 : valor2`
- Combinar condiciones con `&&`, `||`, `!`

**Ejercicios incluidos:**

| Ejercicio | Descripción | Conceptos clave |
|-----------|-------------|-----------------|
| Ejercicio01ParImpar | Determinar si un número es par o impar | `if/else`, módulo `%` |
| Ejercicio02ComparaNum | Comparar dos números | Operadores relacionales |
| Ejercicio03OrdenarNum | Ordenar tres números | `if` anidados |
| Ejercicio04NumDec | Clasificar número positivo, negativo o cero | `if / else if / else` |
| Ejercicio08Coeficiente | Calcular coeficiente con condiciones | Condiciones compuestas |
| Ejercicio10Nota | Nota a letra (A, B, C...) | `switch` |
| Ejercicio11NumSemana | Nombre del día de la semana | `switch` con `String` |
| Ejercicio12-14Fechas | Validación y cálculos con fechas | Condiciones encadenadas |
| Ejercicio16GeneraDni | Generar la letra del DNI | Módulo y array de letras |
| Ejercicio17Animales | Clasificar animales por características | `switch` con múltiples casos |
| Ejercicio18NumLetra | Número en letra (uno, dos...) | `switch` exhaustivo |
| Ejercicio19JuegoSumas | Juego simple de sumas | `if`, `Scanner` |
| Ejercicio20Angulos | Clasificar ángulos (agudo, recto, obtuso) | Rangos con `if` |
| Ejercicio21-26 | Ejercicios variados de condicionales | Todos los patrones del tema |

**Concepto clave:** Un condicional es como una señal de tráfico: "si el semáforo está en verde, avanza; si está en rojo, para". El programa toma decisiones según el valor de las variables, igual que tú decides qué ropa ponerte según el tiempo que hace.

---

### TEMA 03 — Bucles

**¿Qué aprenderás?**
- Bucle `for` cuando sabes cuántas veces repetir
- Bucle `while` cuando repites hasta que se cumple una condición
- Bucle `do-while` para ejecutar al menos una vez
- `for-each` para recorrer colecciones
- Bucles anidados (un bucle dentro de otro)

**Ejercicios incluidos:**

| Ejercicio | Descripción | Conceptos clave |
|-----------|-------------|-----------------|
| Ejercicio01ComprobacionNum | Validar entrada hasta que sea correcta | `while` como guardián |
| Ejercicio02FuncAlumn | Calcular media de alumnos | `for`, acumuladores |
| Ejercicio03NumSecreto | Juego: adivina el número secreto | `while`, `Random` |
| Ejercicio04InvestigacionFlora | Contar plantas según condición | `for`, contadores |
| Ejercicio06AprenderContar | Contar en distintos rangos | `for` con paso |
| Ejercicio07multiplos | Mostrar múltiplos de un número | `for`, módulo |
| Ejercicio09TablaMult | Tabla de multiplicar | `for` anidado |
| Ejercicio11Factorial | Calcular el factorial de un número | `for` acumulativo |
| Ejercicio14Tablas | Tablas de múltiples números | Bucles anidados |
| Ejercicio15Triangulo | Dibujar triángulo con asteriscos | Bucles anidados, `print` |
| Ejercicio20ConversionBinario | Convertir decimal a binario | `while`, división entera |
| Ejercicio21HoraReloj | Simular un reloj con tres bucles | `for` anidados (horas, min, seg) |
| Ejercicio22Primos | Listar números primos hasta N | Bucle dentro de bucle |
| Ejercicio24ComprobacionTipo | Identificar el tipo de un carácter | `do-while` para repetir |

**Concepto clave:** Un bucle es como una lavadora: defines el programa (condición de parada) y la máquina repite el ciclo hasta terminarlo. El `for` es cuando sabes exactamente cuántas vueltas (`lavar 5 veces`). El `while` es cuando no sabes cuántas, pero sabes cuándo parar (`hasta que la ropa esté limpia`).

---

### TEMA 04a — Métodos

**¿Qué aprenderás?**
- Declarar y llamar métodos
- Parámetros y valores de retorno
- Ámbito de las variables
- Recursión: un método que se llama a sí mismo

**Ejercicios incluidos:**

| Ejercicio | Descripción | Conceptos clave |
|-----------|-------------|-----------------|
| Ejercicio01Suma | Método que suma dos números | Declaración, parámetros, `return` |
| Ejercicio02Saludar | Método que genera saludos | `String` como retorno |
| Ejercicio04ParImpar | Método booleano par o impar | `boolean` como retorno |
| Ejercicio07GeneradorId | Generar IDs únicos | Método con lógica interna |
| Ejercicio09FuncionRecursiva | Primeros pasos en recursión | Caso base, llamada recursiva |
| Ejercicio18Calculadora | Calculadora con métodos separados | Organización con métodos |
| Ejercicio20Iterativa / Ejercicio21Recursiva | Misma operación de dos formas | Comparar iterativo vs recursivo |
| Ejercicio23Fibonacci | Serie de Fibonacci recursiva | Recursión con dos llamadas |
| Ejercicio24_Geometria / Matematicas | Fórmulas organizadas en métodos | Reutilización de código |
| Ejercicio37Factorial / Ejercicio38Fibonacci | Factorial y Fibonacci avanzados | Recursión + validación |
| Ejercicio40ContarCifras | Contar cifras de un número | Recursión con enteros |
| Ejercicio41CuentaBilletes | Cambio óptimo en billetes | Algoritmo voraz |

**Concepto clave:** Un método es como una receta de cocina. La defines una vez (`cómo hacer una tortilla`) y la puedes usar todas las veces que quieras sin volver a escribir los pasos. Los parámetros son los ingredientes que le pasas, y el `return` es el plato que te devuelve.

---

### TEMA 04b — VarArgs y Sobrecarga

**¿Qué aprenderás?**
- Métodos con número variable de parámetros (`varargs`)
- Sobrecarga: mismo nombre de método, distintos parámetros
- Cuándo usar uno u otro

**Ejercicios incluidos:**

| Ejercicio | Descripción | Conceptos clave |
|-----------|-------------|-----------------|
| Ejercicio01ArgumentosVariables | Suma con número ilimitado de argumentos | `int... numeros` |
| Ejercicio02MetParamVariables | Métodos con parámetros opcionales | Varargs con lógica |
| Ejercicio03ArgumentosMetodosVariables | Combinar varargs con tipos distintos | Firmas de métodos |
| Ejercicio04SobrecargaMetodos | Mismo método, distintos tipos de datos | Sobrecarga de métodos |

**Concepto clave:** La sobrecarga es como tener una paleta multiusos: `calcularArea(radio)` para un círculo y `calcularArea(base, altura)` para un triángulo. Mismo nombre, distintos ingredientes. Java sabe cuál usar según lo que le pases.

---

### TEMA 04c — Polimorfismo y Clases Abstractas

**¿Qué aprenderás?**
- Qué es el polimorfismo y para qué sirve
- Clases abstractas: plantillas que no se pueden instanciar
- Lista polimórfica: tratar objetos distintos de forma uniforme
- Casting entre tipos de la jerarquía

**Ejercicios incluidos:**

| Ejercicio | Descripción | Conceptos clave |
|-----------|-------------|-----------------|
| Ejercicio01 | Polimorfismo básico con animales | `Animal`, `Perro`, `Gato`, `hablar()` |
| Ejercicio02ClasesAbstractas | Figuras geométricas con clase abstracta | `abstract class`, `@Override` |
| Ejercicio03ListaPolimorfica | Lista con vehículos distintos | `List<Vehiculo>`, polimorfismo real |
| Ejercicio04Casting | Downcasting y comprobación de tipo | `instanceof`, casting seguro |

**Concepto clave:** El polimorfismo es como un control remoto universal. No importa si tienes un Samsung o un LG — el botón "subir volumen" funciona en ambos porque todos los televisores `implementan` la misma acción. Tu código habla con la interfaz común, no con cada marca por separado.

---

### TEMA 05a — Arrays (Tablas Unidimensionales)

**¿Qué aprenderás?**
- Declarar, inicializar y recorrer arrays
- Buscar el máximo, mínimo y media
- Eliminar duplicados
- Copiar y transformar arrays con `Arrays`

**Ejercicios incluidos:**

| Ejercicio | Descripción | Conceptos clave |
|-----------|-------------|-----------------|
| Ejercicio01TablaReferencia | Crear y mostrar un array | Declaración e inicialización |
| Ejercicio02RangoValores | Rellenar con rango de valores | Bucle + índice |
| Ejercicio04MaximoTabla | Encontrar el máximo de un array | Recorrido lineal |
| Ejercicio06NumeroAciertos | Contar coincidencias entre arrays | Comparación elemento a elemento |
| Ejercicio07SinRepetidos | Eliminar duplicados de un array | Lógica de unicidad |
| Ejercicio09MediaNumeros | Calcular la media | Acumulador + tamaño |
| Ejercicio11SumaDiagonal | Suma de la diagonal de una matriz | Índices, arrays 2D básico |
| Ejercicio12CamaraSecreta | Cifrado de texto con array | Caracteres y arrays |
| Ejercicio13CreaOrdena | Crear y ordenar un array | `Arrays.sort()` |
| Ejercicio14ArrayFill | Rellenar con `Arrays.fill()` | Clase utilitaria `Arrays` |
| Ejercicio15CopyOf | Copiar arrays con `Arrays.copyOf()` | Copia parcial y total |

**Concepto clave:** Un array es como una fila de casilleros numerados del 0 al N. Cada casillero guarda un valor, y puedes acceder a cualquiera directamente si sabes su número (`casillero[3]`). El problema: el tamaño es fijo desde el momento en que lo creas. Para tamaño dinámico, usarás colecciones (Tema 12).

---

### TEMA 05b — Arrays Bidimensionales y Ordenación

**¿Qué aprenderás?**
- Matrices: arrays de arrays
- Algoritmos de ordenación: burbuja, inserción, selección
- Algoritmos de búsqueda: lineal y binaria

**Ejercicios incluidos:**

| Ejercicio | Descripción | Conceptos clave |
|-----------|-------------|-----------------|
| Ejercicio01MatrizUnidimensional | Recorrer una matriz con índices | `array[fila][columna]` |
| Ejercicio02ForEach | Iterar con `for-each` | Sintaxis compacta de recorrido |
| Ejercicio03MatrizBidimensional | Crear y operar sobre una matriz | Bucles anidados |
| Ejercicio04Burbuja | Ordenación por burbuja | Intercambio de elementos adyacentes |
| Ejercicio05OrdenacionInsercion | Ordenación por inserción | Comparar e insertar |
| Ejercicio06OrdenacionSeleccion | Ordenación por selección | Buscar mínimo y colocar |
| Ejercicio07MetodosBusqueda | Búsqueda lineal | Recorrer hasta encontrar |
| Ejercicio08BusquedaBinaria | Búsqueda binaria | Dividir y conquistar |

**Concepto clave:** Una matriz es como una hoja de Excel: tiene filas y columnas. Para acceder a la celda de la fila 2, columna 3 escribes `tabla[2][3]`. Los algoritmos de ordenación son como ordenar cartas: burbuja las va cambiando de dos en dos, inserción las va encajando en su lugar, selección busca la más pequeña cada vez.

---

### TEMA 06 — Cadenas de Caracteres

**¿Qué aprenderás?**
- Los métodos más útiles de `String`
- Comparar cadenas correctamente (no con `==`)
- Construir cadenas dinámicas con `StringBuilder`
- Formatear texto con `String.format()`
- Dividir y unir cadenas con `split()` y `join()`

**Ejercicios incluidos:**

| Ejercicio | Descripción | Conceptos clave |
|-----------|-------------|-----------------|
| Ejercicio01 | Explorar propiedades de una cadena | `length()`, `charAt()`, `indexOf()` |
| Ejercicio02LongitudStrings | Medir y comparar longitudes | `length()`, comparación |
| Ejercicio03MetodosBasicos | Transformar cadenas | `toUpperCase()`, `trim()`, `replace()` |
| Ejercicio04SplitJoin | Dividir y reunir cadenas | `split()`, `String.join()` |
| Ejercicio05Comparacion | Comparar cadenas correctamente | `equals()`, `equalsIgnoreCase()`, no usar `==` |
| Ejercicio06StringBuilder | Construir cadenas eficientemente | `StringBuilder`, `append()`, `reverse()` |
| Ejercicio07Formato | Dar formato a datos con plantilla | `String.format()`, `%s`, `%d`, `%.2f` |
| Ejercicio08Practico | Ejercicio integrador de cadenas | Varios métodos combinados |

**Concepto clave:** Un `String` es como una frase escrita en piedra: una vez creada, no se puede modificar (es inmutable). Cada vez que "cambias" un `String`, Java crea uno nuevo. Si necesitas construir texto dinámicamente (en un bucle, por ejemplo), usa `StringBuilder`, que es como un bloc de notas al que puedes añadir, borrar y modificar sin crear copias nuevas.

---

### TEMA 07 — Clases y Programación Orientada a Objetos

**¿Qué aprenderás?**
- Crear clases con atributos y métodos
- Constructores: cómo se crean los objetos
- Encapsulamiento: `private` + getters/setters
- Modificadores `static` y `final`
- Clases especiales de Java

**Ejercicios incluidos:**

| Ejercicio | Descripción | Conceptos clave |
|-----------|-------------|-----------------|
| ejercicio01persona | Clase `Persona` con nombre y edad | Clase, constructor, getters/setters |
| ejercicio02coche | Clase `Coche` con marca y velocidad | Encapsulamiento, métodos de comportamiento |
| ejercicio03CuentaCorriente | Cuenta bancaria con saldo | Validación en setters, lógica de negocio |
| ejercicio04Conversor | Conversor de unidades | Métodos estáticos `static` |
| ejercicio05restaurante | Sistema de pedidos de restaurante | Objetos que colaboran entre sí |
| ejercicio06Geometria | Figuras geométricas con clase | Múltiples constructores |
| ejercicio07personaSobrecarga | Persona con constructores sobrecargados | Sobrecarga de constructores |
| ejercicio08Clonando | Clonar objetos | Constructor copia |
| ClasesEspeciales | Clases de la API de Java | `Math`, `Random`, `LocalDate` |
| CasteoDeClases | Conversión entre tipos de clase | Casting con objetos |

**Concepto clave:** Una clase es como el plano de una casa: define cuántas habitaciones tiene, dónde está la cocina, qué puertas hay. Un objeto es la casa construida a partir de ese plano. Puedes construir mil casas (objetos) a partir del mismo plano (clase), y cada una tendrá sus propios muebles (valores de atributos).

---

### TEMA 08a — Herencia

**¿Qué aprenderás?**
- Herencia con `extends`: una clase hija que hereda de la madre
- Reutilizar y ampliar comportamiento
- `super`: acceder al constructor y métodos del padre
- Sobreescritura de métodos con `@Override`

**Ejercicios incluidos:**

| Ejercicio | Descripción | Conceptos clave |
|-----------|-------------|-----------------|
| Ejercicio01Vehiculos | Jerarquía Vehículo → Coche/Moto | `extends`, constructor con `super` |
| Ejercicio02Planta | Jerarquía de plantas | `@Override`, especialización de métodos |

**Concepto clave:** La herencia es como la herencia biológica. Un `Perro` es un `Animal` y hereda sus características (tiene patas, come, respira). Pero además tiene las suyas propias (ladra, mueve el rabo). Con `extends` le dices a Java: "esta clase es una versión especializada de aquella otra, con todo lo que tenía más estas cosas nuevas".

---

### TEMA 08b — instanceof y Casting

**¿Qué aprenderás?**
- Comprobar el tipo real de un objeto con `instanceof`
- Hacer downcasting de forma segura
- Diferencia entre tipo declarado y tipo real

**Ejercicios incluidos:**

| Ejercicio | Descripción | Conceptos clave |
|-----------|-------------|-----------------|
| ejercicio01 | Jerarquía de vehículos con `instanceof` | Verificar tipo antes de hacer casting |
| ejercicio02Interfaz | `instanceof` con interfaces | Casting desde interfaz |

**Concepto clave:** Imagina que tienes una caja marcada como `Animal`. Dentro puede haber un `Perro` o un `Gato`. Antes de pedirle que ladre, tienes que comprobar si realmente es un `Perro` — eso es `instanceof`. El casting es abrir la caja y sacar el objeto con su tipo real: `Perro perro = (Perro) miAnimal`.

---

### TEMA 09 — Interfaces

**¿Qué aprenderás?**
- Qué es una interfaz y para qué sirve
- Implementar múltiples interfaces en una clase
- Diferencia entre interfaz y clase abstracta
- Polimorfismo a través de interfaces

**Ejercicios incluidos:**

| Ejercicio | Descripción | Conceptos clave |
|-----------|-------------|-----------------|
| Ejercicio01 | Primera interfaz y su implementación | `interface`, `implements` |
| Ejercicio02Lista | Lista de objetos con interfaz común | Polimorfismo con interfaces |
| Ejercicio03Jerarquia | Jerarquía de interfaces | Una interfaz extiende otra |
| Ejercicio04Hibrida | Clase que implementa varias interfaces | Múltiple implementación |

**Concepto clave:** Una interfaz es un contrato. Si una clase firma el contrato `Volable`, se compromete a implementar el método `volar()`. No importa si es un `Pajaro`, un `Avion` o un `Superheroe` — todos saben volar porque firmaron ese contrato. Esto te permite escribir código que funciona con cualquier cosa que vuele, sin saber exactamente qué es.

---

### TEMA 10 — Excepciones

**¿Qué aprenderás?**
- Qué es una excepción y por qué existen
- Capturar errores con `try-catch-finally`
- Capturar múltiples tipos de excepción
- Crear tus propias excepciones personalizadas
- Lanzar excepciones con `throw` y declararlas con `throws`

**Ejercicios incluidos:**

| Ejercicio | Descripción | Conceptos clave |
|-----------|-------------|-----------------|
| Ejercicio01TryCatch | Capturar error de división entre cero | `try-catch`, `ArithmeticException` |
| Ejercicio02MultipleCatch | Capturar distintos tipos de error | Múltiples bloques `catch` |
| Ejercicio03Finally | Código que siempre se ejecuta | Bloque `finally`, cierre de recursos |
| Ejercicio04ExcepcionPersonalizada | Crear tu propia excepción | `extends Exception`, constructor |
| Ejercicio05ThrowThrows | Lanzar y declarar excepciones | `throw new`, `throws` en la firma |
| Ejercicio06Practica | Ejercicio integrador de excepciones | Aplicación real con manejo de errores |

**Concepto clave:** Una excepción es como una alarma de incendios. No evita el fuego, pero te avisa para que puedas reaccionar: apagar el fuego (`catch`), avisar a los bomberos (loguear el error), y abrir las ventanas pase lo que pase (`finally`). Sin gestión de excepciones, un error inesperado tumba todo el programa.

---

### TEMA 11 — Ficheros

#### 11a — Ficheros de Texto

**¿Qué aprenderás?**
- Leer ficheros de texto con `BufferedReader` y `Files`
- Escribir y modificar ficheros con `BufferedWriter`
- Trabajar con rutas y directorios

**Ejercicios incluidos:**

| Ejercicio | Descripción | Conceptos clave |
|-----------|-------------|-----------------|
| Ejercicio01Ejemplo | Crear, leer y editar un fichero de texto | `BufferedReader`, `BufferedWriter`, `Files` |
| Ejercicio02Bonana | Proyecto completo de gestión con ficheros | Capas model/persistence/servicio/ui |

**Concepto clave:** Un fichero de texto es como un cuaderno de notas que guardas en el disco duro. Puedes abrirlo, leer lo que hay escrito, añadir más contenido o borrarlo. Mientras el programa está cerrado, los datos siguen ahí — algo que no ocurre con las variables, que se pierden al terminar la ejecución.

---

#### 11b — Ficheros Binarios y Serialización

**¿Qué aprenderás?**
- Serializar objetos Java para guardarlos en disco
- Deserializar: recuperar objetos guardados
- `DataOutputStream` para tipos primitivos binarios
- `ObjectOutputStream` / `ObjectInputStream` para objetos completos
- La interfaz `Serializable` y `serialVersionUID`

**Ejercicios incluidos:**

| Ejercicio | Descripción | Conceptos clave |
|-----------|-------------|-----------------|
| Ejercicio01InsertaTabla | Guardar un array de enteros en fichero binario | `ObjectOutputStream`, escritura binaria |
| Ejercicio02InsertaVersos | Guardar un poema en fichero `.dat` | Escritura secuencial de `String` |
| Ejercicio03RecuperaVersos | Leer y mostrar el poema guardado | `ObjectInputStream`, deserialización |
| Ejercicio04 | Escribir enteros con centinela -1, releerlos | `DataOutputStream`, `DataInputStream`, centinela |
| Ejercicio05 | Serializar/deserializar objetos `Socio` | `Serializable`, `serialVersionUID`, `ArrayList` |

**Concepto clave:** La serialización es como hacer una fotocopia de un objeto y meterla en un cajón. Cuando necesites ese objeto de nuevo, sacas la fotocopia y la "rehidratas" para tener el objeto original. El fichero binario no es legible para humanos, pero Java lo entiende perfectamente y puede reconstruir el objeto exacto.

---

#### 11c — CSV (Comma-Separated Values)

**¿Qué aprenderás?**
- Crear y escribir archivos CSV desde cero
- Leer y parsear líneas CSV con `split()`
- Modificar registros en un CSV (patrón leer-modificar-reescribir)
- Implementar un DAO completo sobre CSV con menú interactivo

**Ejercicios incluidos:**

| Ejercicio | Descripción | Conceptos clave |
|-----------|-------------|-----------------|
| Ejercicio01EscribirCSV | Crear `productos.csv` con 5 productos | Cabecera, separador `;`, `PrintWriter` |
| Ejercicio02LeerCSV | Leer y mostrar CSV como tabla formateada | `split(";")`, `printf`, parseo de tipos |
| Ejercicio03ModificarCSV | Subir precios un 10% y reescribir el CSV | Patrón leer → modificar → reescribir |
| Ejercicio04AppCompleto | App con menú: listar, buscar, añadir, actualizar, eliminar | DAO pattern, `Scanner`, append mode |

**Concepto clave:** Un CSV es como una hoja de Excel guardada en formato texto: cada fila es un registro y cada columna está separada por un delimitador (`;` en nuestro caso, más seguro que `,` con textos en español). Es el formato más universal para intercambiar datos tabulares entre sistemas.

---

#### 11d — PDF con iText 7

**¿Qué aprenderás?**
- Crear documentos PDF desde Java
- Añadir texto con distintos estilos (negrita, color, tamaño)
- Extraer texto de un PDF existente
- Generar informes con tablas y pie de página

**Ejercicios incluidos:**

| Ejercicio | Descripción | Conceptos clave |
|-----------|-------------|-----------------|
| Ejercicio01CrearPDF | Crear `hola_mundo.pdf` con título y párrafos | `PdfWriter`, `Document`, `Paragraph` |
| Ejercicio02LeerPDF | Extraer texto de un PDF página a página | `PdfTextExtractor`, `PdfReader` |
| Ejercicio03InformePDF | Informe profesional con tabla de productos | `Table`, cabecera, filas alternadas, pie de página |

> **Requisito:** iText 7 ya está configurado en el `pom.xml` del proyecto (`com.itextpdf:kernel` y `com.itextpdf:layout`, versión 7.2.5).

**Concepto clave:** Un PDF es como imprimir un documento y sellarlo — el aspecto queda fijado independientemente del sistema operativo, fuente o impresora. iText te da un "lienzo" sobre el que colocas elementos (párrafos, tablas, imágenes) con coordenadas y estilos precisos.

---

### TEMA 12 — Colecciones

**¿Qué aprenderás?**
- `ArrayList`: lista dinámica, el reemplazo moderno del array
- `LinkedList`: lista enlazada, ideal como cola o pila
- `HashSet`, `LinkedHashSet`, `TreeSet`: conjuntos sin duplicados
- `HashMap`, `LinkedHashMap`, `TreeMap`: pares clave-valor
- `Stack` y `Queue`: pilas y colas
- Colecciones genéricas

**Ejercicios incluidos:**

| Ejercicio | Descripción | Conceptos clave |
|-----------|-------------|-----------------|
| Ejercicio01Arrays | Del array a la colección | Por qué `ArrayList` mejora al array |
| Ejercicio02ArrayList | Lista de elementos con operaciones | `add()`, `remove()`, `get()`, `size()` |
| Ejercicio03pila | Pila LIFO con `Stack` | `push()`, `pop()`, `peek()` |
| Ejercicio04LinkedList | Lista enlazada como cola | `offer()`, `poll()`, `peek()` |
| Ejercicio05Map | Diccionario clave-valor | `HashMap`, `put()`, `get()`, `containsKey()` |
| Ejercicio06ArrayList | ArrayList avanzado con objetos | Colección de objetos propios |
| Ejercicio07HashSet | Conjunto sin duplicados | `HashSet`, unicidad automática |
| Ejercicio08LinkedHashSet | Conjunto con orden de inserción | `LinkedHashSet` vs `HashSet` |
| Ejercicio09TreeSet | Conjunto ordenado automáticamente | `TreeSet`, orden natural |
| Ejercicio10LinkedHashMap | Mapa con orden de inserción | `LinkedHashMap` |
| Ejercicio11TreeMap | Mapa ordenado por clave | `TreeMap`, `NavigableMap` |
| Ejercicio12HashMap | HashMap avanzado | Colisiones, `equals()`, `hashCode()` |
| Ejercicio13Generico | Colección genérica propia | `<T>`, tipos genéricos básicos |
| Ejercicio14 | Ejercicio integrador | Escoger la colección correcta |

**Concepto clave:** Las colecciones son como distintos tipos de contenedores de cocina. Una `List` es como una bandeja numerada (puedes tener duplicados y el orden importa). Un `Set` es como un tarro de caramelos únicos (sin duplicados). Un `Map` es como una agenda telefónica (buscas por nombre y te da el teléfono). Usa cada una para lo que fue diseñada.

---

### TEMA 13 — Acceso a Datos

**¿Qué aprenderás?**
- Leer y escribir ficheros de texto estructurado
- Gestionar configuración con ficheros `.properties`
- Trabajar con JSON en Java
- Leer y generar ficheros CSV

**Ejercicios incluidos:**

| Ejercicio | Descripción | Conceptos clave |
|-----------|-------------|-----------------|
| ejercicio01 | Persistencia básica en texto plano | Lectura/escritura con `Files` |
| ejercicio02Texto | Gestión de datos en fichero de texto | Parsear líneas, separadores |
| ejercicio03 | Acceso a datos estructurado | Formato propio, lectura secuencial |
| ejercicio04Properties | Configuración con `.properties` | `Properties`, `load()`, `getProperty()` |
| ejercicio05json | Leer y escribir JSON | Librería JSON, objetos a JSON y viceversa |
| ejercicio06csv | Gestión de productos en CSV | Separador `,`, `split()`, escritura CSV |

**Concepto clave:**
- **Properties** es como un archivo de configuración de Windows (`.ini`): clave=valor, sencillo y rápido para settings.
- **JSON** es como un objeto JavaScript convertido en texto: ideal para APIs y configuraciones complejas.
- **CSV** es como una hoja de Excel guardada en formato texto: filas de datos separadas por comas, perfecta para importar/exportar datos tabulares.

---

### TEMA 14 — Streams y Lambdas

**¿Qué aprenderás?**
- Programación funcional en Java
- `Stream`: procesar colecciones de forma declarativa
- Operaciones intermedias: `filter()`, `map()`, `sorted()`
- Operaciones terminales: `collect()`, `reduce()`, `forEach()`
- Referencias a métodos con `::`
- `Optional`: evitar el `NullPointerException`

**Ejercicios incluidos:**

| Ejercicio | Descripción | Conceptos clave |
|-----------|-------------|-----------------|
| Ejercicio01Hola | Primera lambda y primer Stream | `() -> {}`, `stream()` |
| Ejercicio02SaludoMultiple | Stream sobre lista de nombres | `forEach()`, lambda con parámetro |
| Ejercicio03StreamBasico | Filtrar y transformar una lista | `filter()`, `map()`, `collect()` |
| Ejercicio04Reduccion | Reducir una lista a un valor | `reduce()`, `sum()`, `count()` |
| Ejercicio05MethodReference | Simplificar lambdas con `::` | `System.out::println`, `Clase::metodo` |
| Ejercicio06Optional | Manejar valores que pueden ser null | `Optional.of()`, `isPresent()`, `orElse()` |

**Concepto clave:** Un Stream es como una cadena de montaje. Tienes una lista de piezas (tu colección), la pones en la cinta transportadora (`stream()`), aplicas operaciones en cadena (`filter` quita las defectuosas, `map` las transforma), y al final recoges el resultado (`collect`). Nada se modifica en el original — todo ocurre en la cadena.

---

### TEMA 15 — Hilos (Concurrencia)

**¿Qué aprenderás?**
- Qué es un hilo y para qué sirve
- Crear hilos con `Thread` y con `Runnable`
- Ciclo de vida de un hilo
- Sincronización para evitar condiciones de carrera
- `ExecutorService`: gestión moderna de hilos
- Hilos daemon

**Ejercicios incluidos:**

| Ejercicio | Descripción | Conceptos clave |
|-----------|-------------|-----------------|
| Ejercicio01 | Primer hilo con `Thread` | `new Thread()`, `start()`, `run()` |
| Ejercicio02 | Hilo con `Runnable` | `Runnable`, lambda como hilo |
| Ejercicio03SincronizacionHilos | Acceso concurrente a recurso compartido | `synchronized`, condición de carrera |
| Ejercicio04SleepJoin | Esperar a que un hilo termine | `sleep()`, `join()` |
| Ejercicio05Daemon | Hilo en segundo plano | `setDaemon(true)`, hilo de servicio |
| Ejercicio06ExecutorService | Pool de hilos gestionado | `Executors.newFixedThreadPool()`, `submit()` |

**Concepto clave:** Un hilo es como un empleado en una fábrica. Por defecto, Java tiene un solo empleado que hace todo en orden (un hilo, el `main`). Con `Thread`, contratas empleados adicionales que trabajan en paralelo. El problema: si dos empleados intentan usar la misma herramienta a la vez sin coordinarse, el resultado es impredecible — eso es una condición de carrera, y `synchronized` es el turno de trabajo que evita los conflictos.

---

### TEMA 16 — JDBC y Patrón DAO

**¿Qué aprenderás?**
- Conectar Java con una base de datos MySQL
- Ejecutar sentencias SQL desde Java con `PreparedStatement`
- El patrón DAO (Data Access Object): separar la lógica de acceso a datos
- Gestionar conexiones de forma segura
- Operaciones CRUD completas

**Ejercicios incluidos:**

| Componente | Descripción | Conceptos clave |
|------------|-------------|-----------------|
| `conexión/Conexion.java` | Clase de conexión con MySQL | `DriverManager`, `Connection`, env vars |
| `model/Usuario.java` | Entidad de dominio | POJO, atributos mapeados a columnas |
| `dao/UsuarioDAO.java` | Capa de acceso a datos | `PreparedStatement`, CRUD completo |
| `gui/Main.java` | Interfaz gráfica de prueba | Swing, integración UI + DAO |

**Requisitos adicionales para este tema:**
- MySQL 8+ instalado y en ejecución
- Crear la base de datos y tabla según las instrucciones del `README.md` del tema
- Configurar la variable de entorno `DB_PASSWORD` con tu contraseña de MySQL

**Concepto clave:** El patrón DAO es como el mostrador de una farmacia. Tú (la interfaz, la lógica de negocio) pides "dame el usuario con ID 5" al `UsuarioDAO`. Éste va al almacén (la base de datos), busca lo que pediste y te lo trae en una caja ordenada (un objeto `Usuario`). Tú no sabes nada del almacén, ni hace falta — el DAO es quien sabe dónde está cada cosa.

---

## Cómo ejecutar los ejercicios

### Requisitos previos

- **Java 24** (o Java 17+): [descargar en adoptium.net](https://adoptium.net)
- **IntelliJ IDEA** (Community Edition es gratuita): [descargar en jetbrains.com](https://www.jetbrains.com/idea/download)
- **Maven 3.6+** (solo para Tema16JDBC): incluido en IntelliJ

### Pasos para ejecutar un ejercicio

1. **Clona el repositorio:**
   ```bash
   git clone https://github.com/tu-usuario/JavaRepo.git
   ```

2. **Abre el proyecto en IntelliJ IDEA:**
   - `File` → `Open` → selecciona la carpeta `JavaRepo`
   - IntelliJ detectará automáticamente el `pom.xml` raíz

3. **Navega hasta el ejercicio:**
   - En el panel de la izquierda (`Project`), busca la carpeta del tema
   - Abre la carpeta del ejercicio y haz clic en `Main.java`

4. **Ejecuta el ejercicio:**
   - Haz clic en el triángulo verde (`▶`) junto al método `main`
   - O pulsa `Shift + F10` para ejecutar el último programa activo
   - La salida aparecerá en el panel `Run` en la parte inferior

5. **Para Tema16JDBC** (requiere MySQL):
   ```bash
   cd Tema16JDBC
   export DB_PASSWORD=tu_contraseña_mysql
   mvn compile exec:java -Dexec.mainClass="tech.Kabadev.gui.Main"
   ```

---

## Convenciones del código

### Estructura de cada ejercicio

```
TemaXX_NombreTema/
├── EjercicioYY_NombreDescriptivo/
│   ├── Main.java            Punto de entrada — tiene el método main()
│   └── ClaseAuxiliar.java   Clases de apoyo si el ejercicio las necesita
└── README.md                Teoría del tema e índice de ejercicios
```

Cada ejercicio es independiente y autocontenido. No necesitas ejecutar otros ejercicios antes.

### Comentarios `[APRENDE]`

El código usa comentarios especiales para señalar exactamente dónde ocurre el concepto que se está enseñando:

```java
// [APRENDE] El método trim() elimina los espacios en blanco al inicio y al final
String nombre = "  Juan  ".trim(); // resultado: "Juan"
```

Lee estos comentarios antes de ejecutar el código — te ahorran mucho tiempo de entendimiento.

### Convención de nombres

| Elemento | Convención | Ejemplo |
|----------|------------|---------|
| Clase | PascalCase | `CuentaBancaria` |
| Método | camelCase | `calcularSaldo()` |
| Variable | camelCase | `nombreUsuario` |
| Constante | UPPER_SNAKE_CASE | `MAX_INTENTOS` |
| Paquete | todo en minúsculas | `tema01conceptosbasicos` |
| Archivo | igual que la clase pública | `CuentaBancaria.java` |

### Paquetes

Los ejercicios siguen la estructura de paquetes `TemaXX_nombre.EjercicioYY`. Por ejemplo:

```java
package Tema07Clases.ejercicio01persona;

public class Persona {
    // ...
}
```

---

## Recursos adicionales

Si quieres profundizar más allá de los ejercicios de este repositorio:

- **Documentación oficial de Java**: [docs.oracle.com/en/java](https://docs.oracle.com/en/java/)
- **Exercism Java Track** (práctica guiada): [exercism.org/tracks/java](https://exercism.org/tracks/java)
- **Baeldung** (tutoriales en profundidad): [baeldung.com](https://www.baeldung.com)
- **Refactoring Guru** (patrones de diseño): [refactoring.guru/es](https://refactoring.guru/es)
- **Visualgo** (visualización de algoritmos): [visualgo.net](https://visualgo.net)

---

## Licencia

Este repositorio está publicado bajo la licencia **MIT**. Puedes usarlo, copiarlo y modificarlo libremente, con o sin atribución. Si te ha sido útil, una estrella en GitHub siempre se agradece.

---

*Última actualización: marzo 2026*
