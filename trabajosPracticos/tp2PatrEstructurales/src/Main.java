import adapter.*;
import bridge.*;
import composite.ElementoMenu;
import composite.Menu;
import composite.Plato;
import decorator.*;
import facade.*;
import flyweight.*;
import proxy.Archivo;
import proxy.ArchivoProxy;
import proxy.ArchivoReal;
import proxy.Usuario;

public class Main {
    public static void main(String[] args) {

        // PATRON ADAPTER
        // Se usa la clase ImpresoraAdapter para imprimir otros tipos de archivo permitidos
        System.out.println("--- ADAPTER ---");
        ImpresoraPDF impresora = new ImpresoraPDF();

        impresora.imprimir("pdf","my_file.pdf");
        impresora.imprimir("txt","mi_archivo.txt");
        impresora.imprimir("docx","mi_tp2.docx");
        impresora.imprimir("mp4","mi_tp2.mp4");

        // PATRON BRIDGE
        // Se usa la clase abstracta TipoNotificacion para los distintos tipos
        // que implementan la interfaz CanalEnvio con sus metodos
        System.out.println("\n--- BRIDGE ---");
        CanalEnvio email = new Email();
        CanalEnvio sms = new SMS();
        TipoNotificacion alertaMail = new Alerta(email, "Detectamos un inicio de sesion");
        TipoNotificacion recordatorioSMS = new Recordatorio(sms, "Turno medico 18hs");
        TipoNotificacion promocionMail = new Promocion(email, "Cashback del 2% en tus compras");

        alertaMail.enviarNotificacion();
        recordatorioSMS.enviarNotificacion();
        promocionMail.enviarNotificacion();

        //PATRON DECORATOR
        // Añade responsabilidades al planBasico sin crear muchas subclases con todas las combinaciones
        System.out.println("\n--- DECORATOR ---");
        System.out.println("Suscripcion 1");
        Plan plan1 = new PlanBasico();
        System.out.println(plan1.descripcion() +" - "+ plan1.costo());
        plan1 = new HD(plan1);
        System.out.println(plan1.descripcion() +" - "+ plan1.costo());
        plan1 = new DescargasOffline(plan1);
        System.out.println(plan1.descripcion() +" - "+ plan1.costo());

        System.out.println("\nSuscripcion 2");
        Plan plan2 = new PlanBasico();
        plan2 = new UltraHD(plan2);
        plan2 = new DescargasOffline(plan2);
        System.out.println(plan2.descripcion() +" - "+ plan2.costo());

        // PATRON FACADE
        // Se usa la tiendaFacade para ocultar el procedimiento que involucra la compra,
        // y solo usar la funcion comprar()
        System.out.println("\n--- FACADE ---");
        TiendaFacade tienda = new TiendaFacade(new Carrito(), new Pago(), new Envio());
        Producto ps5 = new Producto("PS5", 500000);
        tienda.comprar(ps5,"Coronel Rodriguez 912");

        // PATRON FLYWEIGHT
        // Se crea solo un objeto del tipo de arbol que necesitamos y luego se usa el mismo objeto
        System.out.println("\n--- FLYWEIGHT ---");
        FabricaDeArboles fabrica = new FabricaDeArboles();

        String[] tipos = {"Roble","Pino","Abedul","Cerezo"};
        String textura = "pinchoso";
        String color = "marron";
        int x = 1;

        for (int i = 0; i < 25; i++){ // cambiar a 1.000.000 como dice el TP, pero la consola no muestra todos
            for (String tipo : tipos) {
                Arbol arbol = fabrica.obtenerArbol(tipo, textura, color);
                arbol.mostrar(x++,50);
            }
        }

        // PATRON PROXY
        // Se usa ArchivoProxy para evaluar si es accesible dependiendo del tipo de acceso que tiene el usuario
        System.out.println("--- PROXY ---");
        Usuario user1 = new Usuario("Ignaw",true);
        Usuario user2 = new Usuario("Luli", false);

        Archivo secretFile = new ArchivoProxy(new ArchivoReal("formula_secreta.pdf","Mayonesa y Ketchup nomas"));
        secretFile.abrir(user1);
        secretFile.abrir(user2);

        // PATRON COMPOSITE
        // Se crean los ElementoMenu para que sean tratados de la misma manera los platos y los menu
        System.out.println("--- COMPOSITE ---");
        ElementoMenu plato1 = new Plato("Milanesa napolitana", 10900);
        ElementoMenu plato2 = new Plato("Cheeseburguer doble", 9700);
        ElementoMenu postre1 = new Plato("Flan con dulce de leche", 4500);
        ElementoMenu postre2 = new Plato("Brownie con crema", 6200);

        Menu menuPpal1 = new Menu("Menu Principal");
        menuPpal1.agregarElemento(plato1);
        menuPpal1.agregarElemento(plato2);

        Menu menuPostres1 = new Menu("Postres");
        menuPostres1.agregarElemento(postre1);
        menuPostres1.agregarElemento(postre2);

        menuPpal1.agregarElemento(menuPostres1);

        menuPpal1.mostrar();



    }
}