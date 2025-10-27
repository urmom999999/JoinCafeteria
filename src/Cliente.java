public class Cliente extends Thread{
private static String nombre;
private int tiempoEspera;
private long llegada;
private static boolean servido;
private Cola cola;
    //Servido?
//llegada?

public Cliente(String nombre, int tiempoEspera,Cola cola){
    this.nombre=nombre;
    this.tiempoEspera=tiempoEspera;
    this.servido=false;
    this.cola=cola;
}

    public static String getnombre() {
        return nombre;
    }

public int getTiempoEspera (){
    return tiempoEspera;
}



public boolean getServido(){
    return servido;
}
public static void siServido(){
        Cliente.servido=true;
    }

@Override
public void run(){
    //ENTRAR, ANUNCIAR ENTRADA -----HORA-----
    System.out.println(nombre+ " entró en la cafetería y pidió un café. Máximo de espera: "+ tiempoEspera/1000+" segundos");


    //ESPERAR DETERMINADO TIEMPO
    try {

        Thread.sleep(tiempoEspera);
        //IRSE SI SUPERA EL TIEPO Thread.sleep?
        if(!servido){System.out.println(nombre+ " esperó demasiado y se fue.");}
    } catch (InterruptedException e) {
        System.out.println(nombre+ " murió");
    }


    //CONFIRMAR CAFE RECIVIDO?
    //System.out.println(nombre+ " recivió su café!.");

}
}
