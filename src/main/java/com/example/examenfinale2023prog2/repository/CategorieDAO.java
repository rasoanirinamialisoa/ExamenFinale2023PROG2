package com.example.examenfinale2023prog2.repository;


import com.example.examenfinale2023prog2.entity.CategorieEntity;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategorieDAO implements CategorieRepository {

    private final Connection connection;

    public CategorieDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<CategorieEntity> getAllCategories() throws SQLException {
        List<CategorieEntity> categories = new ArrayList<>();
        String query = "SELECT * FROM categorie";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                CategorieEntity categorie = convertToCategorie(resultSet);
                categories.add(categorie);
            }
        }

        return categories;
    }

    @Override
    public CategorieEntity getCategorieById(Long id) throws SQLException {
        String query = "SELECT * FROM categorie WHERE idCategorie = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return convertToCategorie(resultSet);
                }
            }
        }
        return null;
    }

    @Override
    public CategorieEntity createCategorie(CategorieEntity categorie) throws SQLException {
        String query = "INSERT INTO categorie (nomCategorie, descriptionCategorie) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, categorie.getNomCategorie());
            preparedStatement.setString(2, categorie.getDescriptionCategorie());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating category failed, no rows affected.");
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    categorie.setIdCategorie(generatedKeys.getLong(1));
                } else {
                    throw new SQLException("Creating category failed, no ID obtained.");
                }
            }
        }

        return categorie;
    }

    @Override
    public CategorieEntity updateCategorie(Long id, CategorieEntity categorie) throws SQLException {
        String query = "UPDATE categorie SET nomCategorie=?, descriptionCategorie=? WHERE idCategorie=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, categorie.getNomCategorie());
            preparedStatement.setString(2, categorie.getDescriptionCategorie());
            preparedStatement.setLong(3, id);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Updating category failed, no rows affected.");
            }
        }

        return categorie;
    }

    @Override
    public void deleteCategorie(Long id) throws SQLException {
        String query = "DELETE FROM categorie WHERE idCategorie = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Deleting category failed, no rows affected.");
            }
        }
    }


    private CategorieEntity convertToCategorie(ResultSet resultSet) throws SQLException {
        CategorieEntity categorie = new CategorieEntity();
        categorie.setIdCategorie(resultSet.getLong("idCategorie"));
        categorie.setNomCategorie(resultSet.getString("nomCategorie"));
        categorie.setDescriptionCategorie(resultSet.getString("descriptionCategorie"));
        return categorie;
    }

}

