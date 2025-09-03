package creacionales.singleton;

public class MainSingletonDemo {

    /*
    Singleton con Double-Checked Locking
    En SingletonDCL, los hilos intentan crear la instancia casi al mismo tiempo.
    Solo el primer hilo que entra realmente crea la instancia, los demás reutilizan la misma.

    Bill Pugh Singleton
    En Singleton con Holder, la instancia se crea al momento de la primera llamada a getInstance(),
    y la carga de clases de Java garantiza que solo se inicialice una vez, de forma thread-safe
    sin necesidad de synchronized
    */

    public static void main(String[] args) {
        System.out.println("=== Ejemplo con Singleton DCL (Double-Checked Locking) ===");

        Runnable task1 = () -> {
            SingletonDCL singleton = SingletonDCL.getInstance("Uno");
            System.out.println(Thread.currentThread().getName() + " obtuvo valor: " + singleton.getValue());
        };

        Runnable task2 = () -> {
            SingletonDCL singleton = SingletonDCL.getInstance("Dos");
            System.out.println(Thread.currentThread().getName() + " obtuvo valor: " + singleton.getValue());
        };

        Thread t1 = new Thread(task1, "Hilo-1");
        Thread t2 = new Thread(task2, "Hilo-2");
        t1.start();
        t2.start();

        // Esperamos a que terminen
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n=== Ejemplo con Singleton Holder ===");

        Runnable task3 = () -> {
            SingletonHolder singleton = SingletonHolder.getInstance();
            System.out.println(Thread.currentThread().getName() + " obtuvo valor: " + singleton.getValue());
        };

        Thread t3 = new Thread(task3, "Hilo-3");
        Thread t4 = new Thread(task3, "Hilo-4");
        t3.start();
        t4.start();

        try {
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}