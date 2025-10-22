import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        Camarero c1 = new Camarero("c1");
        Camarero c2 = new Camarero("c2");
        //Camarero c3 = new Camarero("c3");
        //Camarero c4 = new Camarero("c4");
        int tiempoEspera;

        Cliente[] ClientesArray={
                new Cliente("Ramon",2500),
                new Cliente("Juanjo",1000),
                new Cliente("Pepe",40000),
                new Cliente("Manuel",2222),
                new Cliente("Ramona",4200),
                new Cliente("Larry",69696),
                new Cliente("Manuela",1191),
                new Cliente("Ana",1234)
        };


        System.out.println("Comienzo!");
        c1.start();
        c2.start();



    try{
        c1.join();
        c2.join();

    }catch(InterruptedException e) {
        System.out.println("Error!");

    }
}}