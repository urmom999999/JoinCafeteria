public class Cliente extends Thread{
private String nombre;
private int tiempoEspera;
private long llegada;
private boolean servido;
private Cola cola;
    //Servido?
//llegada?

public Cliente(String nombre, int tiempoEspera,Cola cola){
    this.nombre=nombre;
    this.tiempoEspera=tiempoEspera;
    this.servido=false;
    this.cola=cola;
}
public String getNombre(){
    return nombre;
}
public int getTiempoEspera (){
    return tiempoEspera;
}



public boolean getServido(){
    return servido;
}


@Override
public void run(){
    //ENTRAR, ANUNCIAR ENTRADA -----HORA-----
    System.out.println(nombre+ " entró en la cafetería y pidió un café. A la hora "+ llegada+ "maximo de espera:"+ tiempoEspera);


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
