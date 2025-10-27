public class Camarero extends Thread {
    public String nombre;

    private boolean trabajo;
private static Cliente[] ClientesArray;

    public Camarero(String nombre) {
        this.nombre = nombre;

        this.trabajo = true;
    }
    public static void setClientes(Cliente [] clientes){
        ClientesArray=clientes;
    }
    public String getNombre() {
        return nombre;
    }

    public void prepararCafe() throws InterruptedException {
//ANUNCIAR COMIEZO PREPARANDO EL CAFE, THREAD.SLEEP


        System.out.println(nombre + " empezó a preparar el café para " + Cliente.getnombre());
        int preparacion = (int) (Math.random() * 2000) + 1000;
        //SI EL CLIENTE SE MARCHA DETENER EL PROCESO
        Thread.sleep(preparacion);
        System.out.println(nombre + " paró de preparar el café, el cliente se marchó");

        Cliente.siServido();
        //ENTREGAR SI ESTA A TIEMPO
        System.out.println(nombre + " terminó de preparar el café, tardó " + preparacion + "!");
    }
    //thread.sleep

    @Override
    public void run() {
        System.out.println(nombre + " comenzó a trabajar.");

        for (Cliente cliente : ClientesArray) {
            try {
                Thread.sleep((long) (Math.random()*10));
                cliente.start();
                cliente.join();
                System.out.println("Terminado!");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
        while (trabajo) {

        }


        System.out.println(nombre + " terminó de trabajar.");
    }
}
