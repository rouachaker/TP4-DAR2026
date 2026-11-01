# TP4 – Sockets en mode non-connecté UDP

## Objectif du TP

L'objectif de ce TP est de développer une application de chat client/serveur en Java utilisant le protocole UDP.

Cette application permet d'envoyer et de recevoir des messages entre plusieurs clients à travers un serveur.

## Étape 1 : Préparation de l'espace de travail

Création d'un projet Java contenant deux classes :

- `ServeurUDP.java` : gestion de la réception et de la diffusion des messages.
- `ClientUDP.java` : gestion de l'envoi et de la réception des messages.

## Étape 2 : Chat unidirectionnel avec un seul client

Dans cette étape, nous avons créé un serveur UDP qui écoute sur le port `1234` et un client permettant de saisir un nom d'utilisateur et d'envoyer des messages.

Le serveur reçoit les messages et affiche l'adresse IP, le port et le contenu du message.

**Capture d'écran 1 !(0.png)

**Capture d'écran 2 !(1.png)

## Étape 3 : Chat bidirectionnel avec plusieurs clients

Nous avons modifié l'application pour permettre la communication entre plusieurs clients.

Le serveur conserve les adresses des clients dans une liste et diffuse chaque message reçu à tous les autres clients, sauf à l'expéditeur.

Du côté client, nous avons utilisé un thread pour permettre l'envoi et la réception des messages simultanément.
!(2.png)
!(3.png)
!(4.png)
!(5.png)


## Étape 4 : Dépôt du projet sur GitHub

## Conclusion

Ce TP nous a permis de comprendre le fonctionnement des sockets UDP en Java à travers les classes `DatagramSocket` et `DatagramPacket`.

Nous avons réalisé un chat unidirectionnel, puis un chat bidirectionnel permettant à plusieurs clients de communiquer en utilisant des threads.