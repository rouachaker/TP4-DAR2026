package ClientUDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClientUDP {

    public static void main(String[] args) {

        try {

            Scanner scanner = new Scanner(System.in);

            // Création du socket UDP du client
            DatagramSocket client = new DatagramSocket();

            // Adresse IP du serveur
            InetAddress adresseServeur = InetAddress.getByName("localhost");

            System.out.print("Entrez votre nom d'utilisateur : ");
            String nom = scanner.nextLine();

            System.out.println("Vous pouvez commencer à écrire.");
            System.out.println("Tapez exit pour quitter.");

            while (true) {

                System.out.print("Message : ");
                String texte = scanner.nextLine();

                if (texte.equalsIgnoreCase("exit")) {
                    break;
                }

                // Ajouter le nom d'utilisateur
                String message = "[" + nom + "] : " + texte;

                // Transformer String -> byte[]
                byte[] data = message.getBytes();

                // Création du paquet
                DatagramPacket paquet = new DatagramPacket(
                                data,
                                data.length,
                                adresseServeur,
                                1234
                        );

                // Envoyer le paquet
                client.send(paquet);
            }
            client.close();
            System.out.println("Client fermé.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}