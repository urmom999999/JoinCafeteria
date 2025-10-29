import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        Cola cola = new Cola();
        Camarero c1 = new Camarero("c1",cola);
        Camarero c2 = new Camarero("c2",cola);
        Camarero[] camareros = {c1, c2};
        //Camarero c3 = new Camarero("c3");
        //Camarero c4 = new Camarero("c4");
        Random random = new Random();

//Ana y Ramona son unas impacientes
        Cliente[] clientes={
                new Cliente("Ramon",random.nextInt(3000)+7000,cola,camareros),
                new Cliente("Juanjo",random.nextInt(3000)+7000,cola,camareros),
                new Cliente("Pepe",random.nextInt(3000)+5000,cola,camareros),
                new Cliente("Manuel",random.nextInt(3000)+5000,cola,camareros),
                new Cliente("Ramona",random.nextInt(1000)+1000,cola,camareros),
                new Cliente("Larry",random.nextInt(5000)+10000,cola,camareros),
                new Cliente("Manuela",random.nextInt(2000)+3000,cola,camareros),
                new Cliente("Ana",random.nextInt(1000)+500,cola,camareros)
        };

        System.out.println("Comienzo!");

        for (int i = 0; i < clientes.length; i++) {
            clientes[i].start();
            try {
                Thread.sleep(random.nextInt(4000) + 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        for (Cliente cliente : clientes) {
            try {
                cliente.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//Esperar a que camareros terminen
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ambos camareros terminaron de trabajar!");
}}