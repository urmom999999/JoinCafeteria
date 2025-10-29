public class Camarero extends Thread {
    public String nombre;
    private Cola cola;
    private boolean trabajando;
    private boolean activo;


    public Camarero(String nombre,Cola cola){
        this.nombre=nombre;
        this.cola=cola;
        this.activo=false;
        this.trabajando=false;
    }

    public String getNombre() {
        return nombre;
    }
    public boolean estaTrabajando() {
        return trabajando;
    }
public void activar(){
        this.activo=true;
        //Error si no esta iniciado correctamente por primera vez
    if (!this.isAlive()) {
        this.start();
    }
}
    public void prepararCafe(Cliente cliente) throws InterruptedException {
//ANUNCIAR COMIEZO PREPARANDO EL CAFE, THREAD.SLEEP
        //Si servido es true el cliente fue servido o se fue
        if(cliente.getServido()){
            return;
        }
        System.out.println(nombre + " empezó a preparar el café para " + cliente.getnombre());
        int preparacion = (int) (Math.random() * 2000) + 1000;
        //SI EL CLIENTE SE MARCHA DETENER EL PROCESO
        Thread.sleep(preparacion);
        //ENTREGAR SI ESTA A TIEMPO

if(cliente.isAlive() && !cliente.getServido()){
    cliente.servir();
    System.out.println(nombre + " terminó de preparar el café para "+ cliente.getnombre()+ " y tardó " + preparacion/1000 + "segundos!");
}
else{
        System.out.println(nombre + " terminó de preparar el café, pero el cliente se marchó ya");}
    }
    //thread.sleep

    @Override
    public void run() {
        System.out.println(nombre + " comenzó a trabajar.");
while (activo|| cola.hayMasClientes()){
    trabajando=true;
    while (cola.hayMasClientes()) {
        try {
            Cliente cliente = cola.siguienteCliente();
            if (cliente != null) {
                prepararCafe(cliente);
            }
        } catch (InterruptedException e) {
            System.out.println(nombre + " ERROR");
            activo = false;
            break;
        }
    }
    try {
        Thread.sleep(100);
    } catch (InterruptedException e) {
        break;
    }
    //DEJAR DE TRABAJAR
}
        trabajando = false;
        System.out.println(nombre + " terminó de trabajar.");
    }
}
