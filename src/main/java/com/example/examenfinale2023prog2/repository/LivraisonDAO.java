package com.example.examenfinale2023prog2.repository;



import com.example.examenfinale2023prog2.entity.LivraisonEntity;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LivraisonDAO implements LivraisonRepository {

    private final Connection connection;

    public LivraisonDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<LivraisonEntity> getAllLivraisons() throws SQLException {
        List<LivraisonEntity> livraisons = new ArrayList<>();
        String query = "SELECT * FROM livraison";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                LivraisonEntity livraison = convertToLivraison(resultSet);
                livraisons.add(livraison);
            }
        }

        return livraisons;
    }

    @Override
    public LivraisonEntity getLivraisonById(Long id) throws SQLException {
        String query = "SELECT * FROM livraison WHERE idLivraison = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return convertToLivraison(resultSet);
                }
            }
        }
        return null;
    }

    @Override
    public LivraisonEntity createLivraison(LivraisonEntity livraison) throws SQLException {
        String query = "INSERT INTO livraison (dateLivraison, statutLivraison, idCommande) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setDate(1, java.sql.Date.valueOf(livraison.getDateLivraison()));
            preparedStatement.setBoolean(2, livraison.isStatutLivraison());
            preparedStatement.setLong(3, livraison.getIdCommande());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating livraison failed, no rows affected.");
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    livraison.setIdLivraison(generatedKeys.getLong(1));
                } else {
                    throw new SQLException("Creating livraison failed, no ID obtained.");
                }
            }
        }

        return livraison;
    }

    @Override
    public LivraisonEntity updateLivraison(Long id, LivraisonEntity livraison) throws SQLException {
        String query = "UPDATE livraison SET dateLivraison=?, statutLivraison=?, idCommande=? WHERE idLivraison=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDate(1, java.sql.Date.valueOf(livraison.getDateLivraison()));
            preparedStatement.setBoolean(2, livraison.isStatutLivraison());
            preparedStatement.setLong(3, livraison.getIdCommande());
            preparedStatement.setLong(4, id);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Updating livraison failed, no rows affected.");
            }
        }

        return livraison;
    }

    @Override
    public void deleteLivraison(Long id) throws SQLException {
        String query = "DELETE FROM livraison WHERE idLivraison = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Deleting livraison failed, no rows affected.");
            }
        }
    }


    private LivraisonEntity convertToLivraison(ResultSet resultSet) throws SQLException {
        LivraisonEntity livraison = new LivraisonEntity();
        livraison.setIdLivraison(resultSet.getLong("idLivraison"));
        livraison.setDateLivraison(resultSet.getDate("dateLivraison").toLocalDate());
        livraison.setStatutLivraison(resultSet.getBoolean("statutLivraison"));
        livraison.setIdCommande(resultSet.getLong("idCommande"));
        return livraison;
    }

    // Autres méthodes pour les conversions et opérations CRUD...
}

