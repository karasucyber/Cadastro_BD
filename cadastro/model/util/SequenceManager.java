package cadastro.model.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SequenceManager {
    private Connection connection;
    private String url;
    private String usuario;
    private String senha;

    public SequenceManager(String url, String usuario, String senha) {
        this.url = url;
        this.usuario = usuario;
        this.senha = senha;
    }

    public void conectar() throws SQLException {
        connection = DriverManager.getConnection(url, usuario, senha);
    }

    public void desconectar() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public int getValue(String nomeSequencia) throws SQLException {
        if (connection == null) {
            throw new IllegalStateException("A conexão com o banco de dados não foi estabelecida.");
        }

        String sql = "SELECT NEXT VALUE FOR " + nomeSequencia + " AS NextValue";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet resultSet = stmt.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getInt("NextValue");
            } else {
                throw new SQLException("Não foi possível obter o próximo valor da sequência.");
            }
        }
    }

    public static void main(String[] args) {
        String url = "jdbc:sqlserver://seu_servidor:1433;databaseName=bd";
        String usuario = "SA";
        String senha = "962133246";

        SequenceManager sequenceManager = new SequenceManager(url, usuario, senha);

        try {
            sequenceManager.conectar();
            int proximoValor = sequenceManager.getValue("sua_sequencia");
            System.out.println("Próximo valor da sequência: " + proximoValor);
        } catch (SQLException e) {
            System.out.println("Erro ao obter o próximo valor da sequência: " + e.getMessage());
        } finally {
            try {
                sequenceManager.desconectar();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
