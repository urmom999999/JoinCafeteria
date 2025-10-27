import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        Cola cola = new Cola();
        Camarero c1 = new Camarero("c1");
        Camarero c2 = new Camarero("c2");
        //Camarero c3 = new Camarero("c3");
        //Camarero c4 = new Camarero("c4");
        Random random = new Random();


        Cliente[] ClientesArray={
                new Cliente("Ramon",random.nextInt(5000)+5000,cola),
                new Cliente("Juanjo",random.nextInt(5000)+5000,cola),
                new Cliente("Pepe",random.nextInt(5000)+5000,cola),
                new Cliente("Manuel",random.nextInt(5000)+5000,cola),
                new Cliente("Ramona",random.nextInt(5000)+5000,cola),
                new Cliente("Larry",random.nextInt(5000)+5000,cola),
                new Cliente("Manuela",random.nextInt(5000)+5000,cola),
                new Cliente("Ana",random.nextInt(5000)+5000,cola)
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