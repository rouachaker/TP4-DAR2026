package ServeurUDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.HashSet;
import java.util.Set;

public class ServeurUDPet3 {

    public static void main(String[] args) {

        // Liste des clients
        Set<SocketAddress> clients = new HashSet<>();

        try {

            DatagramSocket serveur = new DatagramSocket(null);

            InetSocketAddress adresseServeur =
                    new InetSocketAddress("0.0.0.0", 1234);

            serveur.bind(adresseServeur);

            System.out.println(
                    "Serveur de chat UDP démarré sur le port 1234..."
            );

            while (true) {

                byte[] buffer = new byte[1024];

                DatagramPacket paquetRecu = new DatagramPacket(buffer, buffer.length);

                // Recevoir un message
                serveur.receive(paquetRecu);

                // Adresse complète IP + port du client
                SocketAddress adresseClient =
                        paquetRecu.getSocketAddress();

                // Ajouter le client s'il n'existe pas déjà
                clients.add(adresseClient);

                // Transformer les données en texte
                String message = new String(
                        paquetRecu.getData(),
                        0,
                        paquetRecu.getLength()
                );

                System.out.println(adresseClient + " -> " + message);
                // Diffusion vers les autres clients
                for (SocketAddress client : clients) {

                    // Ne pas renvoyer à l'expéditeur
                    if (!client.equals(adresseClient)) {

                        byte[] data = message.getBytes();

                        DatagramPacket paquetEnvoi =
                                new DatagramPacket(
                                        data,
                                        data.length,
                                        client
                                );
                        serveur.send(paquetEnvoi);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}