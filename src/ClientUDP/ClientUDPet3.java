package ClientUDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClientUDPet3 {

    public static void main(String[] args) {

        try {

            Scanner scanner = new Scanner(System.in);

            DatagramSocket client = new DatagramSocket();

            InetAddress adresseServeur = InetAddress.getByName("localhost");

            System.out.print("Entrez votre nom d'utilisateur : ");
            String nom = scanner.nextLine();

            // Thread pour recevoir les messages
            Thread reception = new Thread(() -> {

                try {

                    while (!client.isClosed()) {

                        byte[] buffer = new byte[1024];

                        DatagramPacket paquet =
                                new DatagramPacket(
                                        buffer,
                                        buffer.length
                                );

                        client.receive(paquet);

                        String message = new String(
                                paquet.getData(),
                                0,
                                paquet.getLength()
                        );

                        System.out.println();
                        System.out.println(message);
                        System.out.print("Message : ");
                    }

                } catch (Exception e) {

                    if (!client.isClosed()) {
                        e.printStackTrace();
                    }
                }
            });

            // Démarrage du thread
            reception.start();

            System.out.println(
                    "Chat démarré. Tapez exit pour quitter."
            );

            while (true) {

                System.out.print("Message : ");

                String texte = scanner.nextLine();

                if (texte.equalsIgnoreCase("exit")) {
                    break;
                }

                String message =
                        "[" + nom + "] : " + texte;

                byte[] data = message.getBytes();

                DatagramPacket paquet =
                        new DatagramPacket(
                                data,
                                data.length,
                                adresseServeur,
                                1234
                        );

                client.send(paquet);
            }

            client.close();

            System.out.println("Vous avez quitté le chat.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}