
INSERT INTO categorie (nomCategorie, descriptionCategorie) VALUES
    ('Electronique', 'Produits electroniques et gadgets'),
    ('Vetements', 'Vetements pour hommes, femmes et enfants'),
    ('Alimentation', 'Produits alimentaires et boissons'),
    ('Mobilier', 'Meubles pour la maison'),
    ('Sport', 'Equipements sportifs'),
    ('Beaute', 'Produits de beaute et de soins personnels'),
    ('Livres', 'Livres et publications'),
    ('Jouets', 'Jouets et jeux pour enfants'),
    ('Maison', 'Articles menagers et de decoration'),
    ('Informatique', 'Materiel informatique et accessoires');

INSERT INTO fournisseur (nomFournisseur, adreseFournisseur, telephone, email) VALUES
    ('ElectroTech', '123 Rue Techno, VilleTech', '+1234567890', 'contact@electrotech.com'),
    ('ModeStyle', '456 Avenue de la Mode, VilleMode', '+9876543210', 'info@modestyle.com'),
    ('AlimentsDelice', '789 Place des Saveurs, VilleGourmande', '+5432167890', 'contact@alimentsdelice.com'),
    ('MeublesChic', '555 Rue du Mobilier, VilleDesign', '+2345678901', 'info@meubleschic.com'),
    ('SportExtreme', '777 Avenue de l''Aventure, VilleSportive', '+6789012345', 'contact@sportextreme.com'),
    ('BeauteNaturelle', '222 Rue de la Beaute, VilleEclat', '+8901234567', 'info@beautenaturelle.com'),
    ('LecturesPassion', '444 Boulevard des Livres, VilleLecture', '+3456789012', 'contact@lecturespassion.com'),
    ('JouetsAmusants', '666 Rue des Jouets, VilleAmusement', '+4567890123', 'info@jouetsamusants.com'),
    ('MaisonChaleureuse', '111 Place de la Maison, VilleConfort', '+5678901234', 'contact@maisonchaleureuse.com'),
    ('TechInnov', '888 Avenue de l''Innovation, VilleTech', '+3210987654', 'info@techinnov.com');

INSERT INTO produit (nomProduit, description, prixUnitaire, quantiteEnStock, dateAjout, dateMiseAJour, idCategorie, idFournisseur) VALUES
    ('Smartphone X', 'Un smartphone haut de gamme avec de nombreuses fonctionnalites.', 799.99, 150, '2023-08-20', '2023-08-21', 1, 1),
    ('Chemise elegante', 'Chemise pour hommes, style elegant et moderne.', 49.99, 200, '2023-08-19', '2023-08-20', 2, 2),
    ('Chocolat au lait', 'Chocolat au lait suisse, 100g.', 4.99, 500, '2023-08-18', '2023-08-19', 3, 3),
    ('Canape en cuir', 'Canape en cuir veritable, confortable et durable.', 899.99, 30, '2023-08-17', '2023-08-18', 4, 4),
    ('Planche de surf', 'Planche de surf pour les amateurs de sports nautiques.', 299.99, 15, '2023-08-16', '2023-08-17', 5, 5),
    ('Lotion hydratante', 'Lotion hydratante pour une peau douce et nourrie.', 19.99, 1000, '2023-08-15', '2023-08-16', 6, 6),
    ('Roman best-seller', 'Un roman captivant qui est un best-seller international.', 14.99, 300, '2023-08-14', '2023-08-15', 7, 7),
    ('Ensemble de LEGO', 'Ensemble de LEGO pour des heures de jeu creatif.', 39.99, 50, '2023-08-13', '2023-08-14', 8, 8),
    ('Vase decoratif', 'Vase en ceramique pour ajouter une touche d''elegance a votre maison.', 29.99, 100, '2023-08-12', '2023-08-13', 9, 9),
    ('Laptop puissant', 'Ordinateur portable puissant avec des specifications de pointe.', 1299.99, 50, '2023-08-11', '2023-08-12', 10, 10);


INSERT INTO commande (dateDeCommande, statusDeLaCommande, montantDeLaCommande) VALUES
    ('2023-08-20', true, 799.99),
    ('2023-08-19', true, 49.99),
    ('2023-08-18', true, 4.99),
    ('2023-08-17', false, 899.99),
    ('2023-08-16', false, 299.99),
    ('2023-08-15', true, 19.99),
    ('2023-08-14', true, 14.99),
    ('2023-08-13', false, 39.99),
    ('2023-08-12', true, 29.99),
    ('2023-08-11', true, 1299.99);


INSERT INTO livraison (dateLivraison, statutLivraison, idCommande) VALUES
    ('2023-08-22', true, 1),
    ('2023-08-21', true, 2),
    ('2023-08-20', true, 3),
    ('2023-08-19', false, 4),
    ('2023-08-18', false, 5),
    ('2023-08-17', true, 6),
    ('2023-08-16', true, 7),
    ('2023-08-15', false, 8),
    ('2023-08-14', true, 9),
    ('2023-08-13', true, 10);

INSERT INTO detailDeLaCommande (quantiteCommande, idProduit, idCommande) VALUES
    (1, 1, 1),
    (2, 2, 2),
    (5, 3, 3),
    (1, 4, 4),
    (1, 5, 5),
    (3, 6, 6),
    (2, 7, 7),
    (1, 8, 8),
    (4, 9, 9),
    (1, 10, 10);
