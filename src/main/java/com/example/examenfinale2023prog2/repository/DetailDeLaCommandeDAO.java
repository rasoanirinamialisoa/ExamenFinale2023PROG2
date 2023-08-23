package com.example.examenfinale2023prog2.repository;


import com.example.examenfinale2023prog2.entity.DetailDeLaCommandeEntity;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DetailDeLaCommandeDAO implements DetailDeLaCommandeRepository {

    private final Connection connection;

    public DetailDeLaCommandeDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<DetailDeLaCommandeEntity> getAllDetailsDeLaCommande() throws SQLException {
        List<DetailDeLaCommandeEntity> detailsDeLaCommande = new ArrayList<>();
        String query = "SELECT * FROM detailDeLaCommande";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                DetailDeLaCommandeEntity detailDeLaCommande = convertToDetailDeLaCommande(resultSet);
                detailsDeLaCommande.add(detailDeLaCommande);
            }
        }

        return detailsDeLaCommande;
    }

    @Override
    public DetailDeLaCommandeEntity getDetailDeLaCommandeById(Long id) throws SQLException {
        String query = "SELECT * FROM detailDeLaCommande WHERE idDetailDeLaCommande = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return convertToDetailDeLaCommande(resultSet);
                }
            }
        }
        return null;
    }

    @Override
    public DetailDeLaCommandeEntity createDetailDeLaCommande(DetailDeLaCommandeEntity detailDeLaCommande) throws SQLException {
        String query = "INSERT INTO detailDeLaCommande (quantiteCommande, idProduit, idCommande) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, detailDeLaCommande.getQuantiteCommande());
            preparedStatement.setLong(2, detailDeLaCommande.getIdProduit());
            preparedStatement.setLong(3, detailDeLaCommande.getIdCommande());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating detail de la commande failed, no rows affected.");
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    detailDeLaCommande.setIdDetailDeLaCommande(generatedKeys.getLong(1));
                } else {
                    throw new SQLException("Creating detail de la commande failed, no ID obtained.");
                }
            }
        }

        return detailDeLaCommande;
    }

    @Override
    public DetailDeLaCommandeEntity updateDetailDeLaCommande(Long id, DetailDeLaCommandeEntity detailDeLaCommande) throws SQLException {
        String query = "UPDATE detailDeLaCommande SET quantiteCommande=?, idProduit=?, idCommande=? WHERE idDetailDeLaCommande=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, detailDeLaCommande.getQuantiteCommande());
            preparedStatement.setLong(2, detailDeLaCommande.getIdProduit());
            preparedStatement.setLong(3, detailDeLaCommande.getIdCommande());
            preparedStatement.setLong(4, id);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Updating detail de la commande failed, no rows affected.");
            }
        }

        return detailDeLaCommande;
    }

    @Override
    public void deleteDetailDeLaCommande(Long id) throws SQLException {
        String query = "DELETE FROM detailDeLaCommande WHERE idDetailDeLaCommande = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Deleting detail de la commande failed, no rows affected.");
            }
        }
    }


    private DetailDeLaCommandeEntity convertToDetailDeLaCommande(ResultSet resultSet) throws SQLException {
        DetailDeLaCommandeEntity detailDeLaCommande = new DetailDeLaCommandeEntity();
        detailDeLaCommande.setIdDetailDeLaCommande(resultSet.getLong("idDetailDeLaCommande"));
        detailDeLaCommande.setQuantiteCommande(resultSet.getInt("quantiteCommande"));
        detailDeLaCommande.setIdProduit(resultSet.getLong("idProduit"));
        detailDeLaCommande.setIdCommande(resultSet.getLong("idCommande"));
        return detailDeLaCommande;
    }

    // Autres méthodes pour les conversions et opérations CRUD...
}
