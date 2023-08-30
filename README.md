
# Gestion de Stock d'une Société avec Spring Boot

Ce projet Spring Boot vise à créer une application de gestion de stock pour une société. L'application permet de gérer les produits, les catégories, les fournisseurs, les commandes et les livraisons. Elle met en œuvre des opérations CRUD (Créer, Lire, Mettre à jour, Supprimer) pour chaque entité et fournit une API pour interagir avec les données.

## Table des Matières

- [Technologies Utilisées](#Spring boot)
- [Installation](#IntelliJ)
- [Configuration de la Base de Données](#Postgresl)
- [Tests avec Postman](#tests-avec-postman)
- [Auteur](#Lisa Rasoanirina)

## Technologies Utilisées

Ce projet a été développé en utilisant les technologies suivantes :

- Java : Langage de programmation orienté objet.
- Spring Boot : Framework pour créer des applications Java rapidement.
- PostgreSQL : Système de gestion de base de données relationnelle.
- Lombok : Bibliothèque pour la génération de code boilerplate.
- Postman : Outil pour tester les API.

## Installation

1. Clonez le dépôt GitHub dans un répertoire de votre choix :

2. Ouvrez le projet dans votre environnement de développement intégré (IDE) préféré.

3. Installez les dépendances Maven en exécutant la commande suivante à la racine du projet :

 
## Configuration de la Base de Données

1. Assurez-vous que PostgreSQL est installé et en cours d'exécution sur votre machine.

2. Créez une base de données nommée `gestion_stock` dans PostgreSQL.

3. Mettez à jour les informations de connexion à la base de données dans le fichier `src/main/resources/application.properties` :

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/gestion_stock
   spring.datasource.username=votre_utilisateur
   spring.datasource.password=votre_mot_de_passe
   ```

## Utilisation de l'API

L'application expose une API pour gérer les opérations CRUD sur les entités suivantes :

- Produits
- Catégories
- Fournisseurs
- Commandes
- Livraisons

Les endpoints et les schémas de données sont définis dans le fichier OpenAPI.

## Tests avec Postman

Pour tester les fonctionnalités de l'API, vous pouvez utiliser Postman. Importez la collection de requêtes Postman fournie dans le répertoire `postman_collection` à la racine du projet.

## Auteur

Ce projet a été développé par [STD22026].
