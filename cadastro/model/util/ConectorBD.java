package cadastro.model.util;

import java.sql.*;

public class ConectorBD {
    static String url = "jdbc:sqlserver://172.17.0.2:1433;databaseName=bd";
   static String usuario = "SA";
    static String senha = "962133246";

    // Método para obter uma conexão com o banco de dados
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, usuario, senha);
    }

    // Método para criar um PreparedStatement a partir de uma consulta SQL
    public static PreparedStatement getPrepared(String sql) throws SQLException {
        Connection conexao = getConnection();
        return conexao.prepareStatement(sql);
    }

    // Método para executar uma consulta e retornar um ResultSet
    public static ResultSet getSelect(String sql) throws SQLException {
        PreparedStatement preparedStatement = getPrepared(sql);
        return preparedStatement.executeQuery();
    }


    public static void main(String[] args) {
        try {
            // Exemplo de uso:
            // Obtendo uma conexão
            Connection conexao = getConnection();

            // Criando uma consulta SQL
            String consultaSQL = "SELECT * FROM tabela";

            // Obtendo um ResultSet com os resultados da consulta
            ResultSet resultSet = getSelect(consultaSQL);

            // Iterando através dos resultados
            while (resultSet.next()) {
                // Processar os dados do ResultSet
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");

                // Faça algo com os dados...
                System.out.println("ID: " + id + ", Nome: " + nome);
            }

            resultSet.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }







