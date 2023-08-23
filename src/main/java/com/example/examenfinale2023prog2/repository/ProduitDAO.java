package com.example.examenfinale2023prog2.repository;



import com.example.examenfinale2023prog2.entity.ProduitEntity;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProduitDAO implements ProduitRepository {

    private final Connection connection;

    public ProduitDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<ProduitEntity> getAllProduits() throws SQLException {
        List<ProduitEntity> produits = new ArrayList<>();
        String query = "SELECT * FROM produit";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                ProduitEntity produit = convertToProduit(resultSet);
                produits.add(produit);
            }
        }

        return produits;
    }

    @Override
    public ProduitEntity getProduitById(Long id) throws SQLException {
        String query = "SELECT * FROM produit WHERE idProduit = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return convertToProduit(resultSet);
                }
            }
        }
        return null;
    }

    // ...

    @Override
    public ProduitEntity createProduit(ProduitEntity produit) throws SQLException {
        String query = "INSERT INTO produit (nomProduit, description, prixUnitaire, quantiteEnStock, dateAjout, dateMiseAJour, idCategorie, idFournisseur) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, produit.getNomProduit());
            preparedStatement.setString(2, produit.getDescription());
            preparedStatement.setDouble(3, produit.getPrixUnitaire());
            preparedStatement.setInt(4, produit.getQuantiteEnStock());
            preparedStatement.setDate(5, java.sql.Date.valueOf(produit.getDateAjout()));
            preparedStatement.setDate(6, java.sql.Date.valueOf(produit.getDateMiseAJour()));
            preparedStatement.setLong(7, produit.getIdCategorie());
            preparedStatement.setLong(8, produit.getIdFournisseur());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating product failed, no rows affected.");
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    produit.setIdProduit(generatedKeys.getLong(1));
                } else {
                    throw new SQLException("Creating product failed, no ID obtained.");
                }
            }
        }

        return produit;
    }

    @Override
    public ProduitEntity updateProduit(Long id, ProduitEntity produit) throws SQLException {
        String query = "UPDATE produit SET nomProduit=?, description=?, prixUnitaire=?, quantiteEnStock=?, dateAjout=?, dateMiseAJour=?, idCategorie=?, idFournisseur=? WHERE idProduit=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, produit.getNomProduit());
            preparedStatement.setString(2, produit.getDescription());
            preparedStatement.setDouble(3, produit.getPrixUnitaire());
            preparedStatement.setInt(4, produit.getQuantiteEnStock());
            preparedStatement.setDate(5, java.sql.Date.valueOf(produit.getDateAjout()));
            preparedStatement.setDate(6, java.sql.Date.valueOf(produit.getDateMiseAJour()));
            preparedStatement.setLong(7, produit.getIdCategorie());
            preparedStatement.setLong(8, produit.getIdFournisseur());
            preparedStatement.setLong(9, id);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Updating product failed, no rows affected.");
            }
        }

        return produit;
    }

    @Override
    public void deleteProduit(Long id) throws SQLException {
        String query = "DELETE FROM produit WHERE idProduit = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Deleting product failed, no rows affected.");
            }
        }
    }




    private ProduitEntity convertToProduit(ResultSet resultSet) throws SQLException {
        ProduitEntity produit = new ProduitEntity();
        produit.setIdProduit(resultSet.getLong("idProduit"));
        produit.setNomProduit(resultSet.getString("nomProduit"));
        produit.setDescription(resultSet.getString("description"));
        produit.setPrixUnitaire(resultSet.getDouble("prixUnitaire"));
        produit.setQuantiteEnStock(resultSet.getInt("quantiteEnStock"));
        produit.setDateAjout(resultSet.getDate("dateAjout").toLocalDate());
        produit.setDateMiseAJour(resultSet.getDate("dateMiseAJour").toLocalDate());
        produit.setIdCategorie(resultSet.getLong("idCategorie"));
        produit.setIdFournisseur(resultSet.getLong("idFournisseur"));
        return produit;
    }

    // Autres méthodes pour les conversions et opérations CRUD...
}
