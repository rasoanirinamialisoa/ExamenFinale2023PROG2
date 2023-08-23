package com.example.examenfinale2023prog2.repository;


import com.example.examenfinale2023prog2.entity.FournisseurEntity;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FournisseurDAO implements FournisseurRepository {

    private final Connection connection;

    public FournisseurDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<FournisseurEntity> getAllFournisseurs() throws SQLException {
        List<FournisseurEntity> fournisseurs = new ArrayList<>();
        String query = "SELECT * FROM fournisseur";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                FournisseurEntity fournisseur = convertToFournisseur(resultSet);
                fournisseurs.add(fournisseur);
            }
        }

        return fournisseurs;
    }

    @Override
    public FournisseurEntity getFournisseurById(Long id) throws SQLException {
        String query = "SELECT * FROM fournisseur WHERE idFournisseur = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return convertToFournisseur(resultSet);
                }
            }
        }
        return null;
    }

    @Override
    public FournisseurEntity createFournisseur(FournisseurEntity fournisseur) throws SQLException {
        String query = "INSERT INTO fournisseur (nomFournisseur, adreseFournisseur, telephone, email) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, fournisseur.getNomFournisseur());
            preparedStatement.setString(2, fournisseur.getAdreseFournisseur());
            preparedStatement.setString(3, fournisseur.getTelephone());
            preparedStatement.setString(4, fournisseur.getEmail());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating fournisseur failed, no rows affected.");
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    fournisseur.setIdFournisseur(generatedKeys.getLong(1));
                } else {
                    throw new SQLException("Creating fournisseur failed, no ID obtained.");
                }
            }
        }

        return fournisseur;
    }

    @Override
    public FournisseurEntity updateFournisseur(Long id, FournisseurEntity fournisseur) throws SQLException {
        String query = "UPDATE fournisseur SET nomFournisseur=?, adreseFournisseur=?, telephone=?, email=? WHERE idFournisseur=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, fournisseur.getNomFournisseur());
            preparedStatement.setString(2, fournisseur.getAdreseFournisseur());
            preparedStatement.setString(3, fournisseur.getTelephone());
            preparedStatement.setString(4, fournisseur.getEmail());
            preparedStatement.setLong(5, id);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Updating fournisseur failed, no rows affected.");
            }
        }

        return fournisseur;
    }

    @Override
    public void deleteFournisseur(Long id) throws SQLException {
        String query = "DELETE FROM fournisseur WHERE idFournisseur = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Deleting fournisseur failed, no rows affected.");
            }
        }
    }


    private FournisseurEntity convertToFournisseur(ResultSet resultSet) throws SQLException {
        FournisseurEntity fournisseur = new FournisseurEntity();
        fournisseur.setIdFournisseur(resultSet.getLong("idFournisseur"));
        fournisseur.setNomFournisseur(resultSet.getString("nomFournisseur"));
        fournisseur.setAdreseFournisseur(resultSet.getString("adreseFournisseur"));
        fournisseur.setTelephone(resultSet.getString("telephone"));
        fournisseur.setEmail(resultSet.getString("email"));
        return fournisseur;
    }

    // Autres méthodes pour les conversions et opérations CRUD...
}

