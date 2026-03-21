# Tema 14 — Hilos (Threads)

> Prerequisito: Tema 07 (clases), Tema 09 (interfaces)

Programacion concurrente en Java: crear y gestionar hilos, coordinacion basica y sincronizacion.

> ⚠️ **Tema escaso — solo 3 ejercicios.** Necesita ampliacion.

---

## Teoria rapida

### Dos formas de crear un hilo

```java
// OPCION 1: extender Thread
public class MiHilo extends Thread {
    @Override
    public void run() {
        System.out.println("Hilo " + getName() + " ejecutandose");
    }
}
// Uso:
Thread t = new MiHilo();
t.start();  // NO llamar a run() directamente — llama a start()

// OPCION 2: implementar Runnable (preferida — mas flexible)
public class MiTarea implements Runnable {
    @Override
    public void run() {
        System.out.println("Tarea en " + Thread.currentThread().getName());
    }
}
// Uso:
Thread t = new Thread(new MiTarea());
t.start();

// Con lambda (Java 8+)
Thread t = new Thread(() -> System.out.println("Hilo con lambda"));
t.start();
```

### Metodos fundamentales

| Metodo | Descripcion |
|--------|------------|
| `start()` | Inicia el hilo — llama a `run()` en un hilo separado |
| `run()` | El codigo que ejecuta el hilo — NO llamar directamente |
| `sleep(ms)` | Pausa el hilo N milisegundos. Lanza `InterruptedException` |
| `join()` | El hilo que llama espera a que ESTE termine |
| `join(ms)` | Espera como maximo N milisegundos |
| `isAlive()` | `true` si el hilo esta en ejecucion |
| `getName()` | Nombre del hilo |
| `setPriority(n)` | Prioridad 1-10 (MIN=1, NORM=5, MAX=10) |
| `interrupt()` | Interrumpe el hilo (lanza `InterruptedException` si esta en `sleep`) |

### Ciclo de vida

```
NEW          → start()  → RUNNABLE → (CPU disponible) → RUNNING
RUNNING      → sleep()  → TIMED_WAITING → (tiempo expira) → RUNNABLE
RUNNING      → join()   → WAITING   → (otro hilo termina) → RUNNABLE
RUNNING      → wait()   → WAITING   → (notify) → RUNNABLE
RUNNING      → fin de run() → TERMINATED
```

### Sincronizacion basica — `synchronized`

```java
// Problema: dos hilos incrementan un contador — el resultado es impredecible (race condition)
public class Contador {
    private int valor = 0;

    // synchronized garantiza que solo un hilo ejecuta este metodo a la vez
    public synchronized void incrementar() {
        valor++;
    }

    public synchronized int getValor() { return valor; }
}
```

---

## Ejercicios

| Carpeta | Descripcion |
|---------|------------|
| `Ejercicio01/` | Crear hilos con `extends Thread` e `implements Runnable` |
| `Ejercicio02/` | Uso de `sleep()` y `join()` para coordinar hilos |
| `Ejercicio03SincronizacionHilos/` | `synchronized` para evitar race conditions |

> **Pendiente:** ampliar con `ExecutorService`, `Callable`, `Future` y patrones de concurrencia. Ver [README raiz](../README.md).
