public class Camarero extends Thread{
public String nombre;

private boolean trabajo;
public Camarero(String nombre){
    this.nombre=nombre;

    this.trabajo=true;
}

public String getNombre() {
        return nombre;
    }
public void prepararCafe(){
//ANUNCIAR COMIEZO PREPARANDO EL CAFE, THREAD.SLEEP
System.out.println(nombre+ " empezó a preparar el café.");

        //SI EL CLIENTE SE MARCHA DETENER EL PROCESO
        System.out.println(nombre+ " paró de preparar el café, el cliente se marchó");

        //ENTREGAR SI ESTA A TIEMPO
        System.out.println(nombre+ " terminó de preparar el café!");
    }
    //thread.sleep

    @Override
public void run(){
        System.out.println(nombre + " comenzó a trabajar.");
while (trabajo){

}


        System.out.println(nombre + " terminó de trabajar.");}
}
