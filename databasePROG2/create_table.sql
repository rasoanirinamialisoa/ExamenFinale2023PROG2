create database gestion_de_stock;

create table produit(
    idProduit serial primary key,
    nomProduit varchar(30),
    description text,
    prixUnitaire float,
    quantiteEnStock int,
    dateAjout date,
    dateMiseAJour date,
    idCategorie INT,
    idFournisseur INT,
    FOREIGN KEY (idCategorie) REFERENCES categorie (idCategorie),
    FOREIGN KEY (idFournisseur) REFERENCES fournisseur (idFournisseur)
);

create table categorie(
    idCategorie serial primary key,
    nomCategorie varchar(50),
    descriptionCategorie text
);

create table fournisseur(
    idFournisseur serial primary key,
    nomFournisseur varchar(50),
    adreseFournisseur varchar(50),
    telephone varchar(50),
    email varchar(30)
);

create table commande (
    idCommande serial primary key,
    dateDeCommande date,
    statusDeLaCommande boolean,
    montantDeLaCommande float
    
);

create table livraison(
    idLivraison serial primary key,
    dateLivraison date,
    statutLivraison boolean,
    idCommande INT,
    FOREIGN KEY (idCommande) REFERENCES commande (idCommande)
);

create table detailDeLaCommande (
    idDetailDeLaCommande serial primary key,
    quantiteCommande int,
    idProduit INT,
    idCommande INT,
    FOREIGN KEY (idProduit) REFERENCES produit (idProduit),
    FOREIGN KEY (idCommande) REFERENCES commande (idCommande)    
);
