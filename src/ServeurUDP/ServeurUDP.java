package ServeurUDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class ServeurUDP {

    public static void main(String[] args) {

        try {

            // Création du socket UDP
            DatagramSocket serveur = new DatagramSocket(null);

            // Adresse + port du serveur
            InetSocketAddress adresseServeur = new InetSocketAddress("0.0.0.0", 1234);

            // Liaison du socket avec le port 1234
            serveur.bind(adresseServeur);

            System.out.println("Serveur UDP démarré sur le port 1234...");
            System.out.println("En attente de messages...");

            while (true) {

                // Tableau qui va recevoir les données
                byte[] buffer = new byte[1024];

                // Création du paquet de réception
                DatagramPacket paquet = new DatagramPacket(buffer, buffer.length);
                // Attendre un message
                serveur.receive(paquet);
                // Transformer les octets reçus en String
                String message = new String(
                        paquet.getData(),
                        0,
                        paquet.getLength()
                );

                System.out.println("-----------------------------");

                System.out.println("IP client : " + paquet.getAddress().getHostAddress());

                System.out.println("Port client : " + paquet.getPort());

                System.out.println("Message : " + message);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}