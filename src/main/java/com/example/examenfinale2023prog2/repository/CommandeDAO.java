package com.example.examenfinale2023prog2.repository;


import com.example.examenfinale2023prog2.entity.CommandeEntity;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CommandeDAO implements CommandeRepository {

    private final Connection connection;

    public CommandeDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<CommandeEntity> getAllCommandes() throws SQLException {
        List<CommandeEntity> commandes = new ArrayList<>();
        String query = "SELECT * FROM commande";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                CommandeEntity commande = convertToCommande(resultSet);
                commandes.add(commande);
            }
        }

        return commandes;
    }

    @Override
    public CommandeEntity getCommandeById(Long id) throws SQLException {
        String query = "SELECT * FROM commande WHERE idCommande = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return convertToCommande(resultSet);
                }
            }
        }
        return null;
    }

    @Override
    public CommandeEntity createCommande(CommandeEntity commande) throws SQLException {
        String query = "INSERT INTO commande (dateDeCommande, statusDeLaCommande, montantDeLaCommande) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setDate(1, java.sql.Date.valueOf(commande.getDateDeCommande()));
            preparedStatement.setBoolean(2, commande.getStatusDeLaCommande());
            preparedStatement.setDouble(3, commande.getMontantDeLaCommande());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating command failed, no rows affected.");
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    commande.setIdCommande(generatedKeys.getLong(1));
                } else {
                    throw new SQLException("Creating command failed, no ID obtained.");
                }
            }
        }

        return commande;
    }

    @Override
    public CommandeEntity updateCommande(Long id, CommandeEntity commande) throws SQLException {
        String query = "UPDATE commande SET dateDeCommande=?, statusDeLaCommande=?, montantDeLaCommande=? WHERE idCommande=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDate(1, java.sql.Date.valueOf(commande.getDateDeCommande()));
            preparedStatement.setBoolean(2, commande.getStatusDeLaCommande());
            preparedStatement.setDouble(3, commande.getMontantDeLaCommande());
            preparedStatement.setLong(4, id);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Updating command failed, no rows affected.");
            }
        }

        return commande;
    }

    @Override
    public void deleteCommande(Long id) throws SQLException {
        String query = "DELETE FROM commande WHERE idCommande = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Deleting command failed, no rows affected.");
            }
        }
    }


    private CommandeEntity convertToCommande(ResultSet resultSet) throws SQLException {
        CommandeEntity commande = new CommandeEntity();
        commande.setIdCommande(resultSet.getLong("idCommande"));
        commande.setDateDeCommande(resultSet.getDate("dateDeCommande").toLocalDate());
        commande.setStatusDeLaCommande(resultSet.getBoolean("statusDeLaCommande"));
        commande.setMontantDeLaCommande(resultSet.getDouble("montantDeLaCommande"));
        return commande;
    }

    // Autres méthodes pour les conversions et opérations CRUD...
}

