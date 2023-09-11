import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaFisicaDAO  {
    private Connection connection;
    private String url;
    private String usuario;
    private String senha;

    public PessoaFisicaDAO(String url, String usuario, String senha) {
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

    public PessoaFisica getPessoa(int id) throws SQLException {
        if (connection == null) {
            throw new IllegalStateException("A conexão com o banco de dados não foi estabelecida.");
        }

        String sql = "SELECT * FROM PessoaFisica WHERE Id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    PessoaFisica pessoa = new PessoaFisica();
                    pessoa.setId(resultSet.getInt("Id"));
                    pessoa.setNome(resultSet.getString("Nome"));
                    // Outros atributos...

                    return pessoa;
                } else {
                    return null; // Não encontrou a pessoa com o ID especificado.
                }
            }
        }
    }

    public List<PessoaFisica> getPessoas() throws SQLException {
        if (connection == null) {
            throw new IllegalStateException("A conexão com o banco de dados não foi estabelecida.");
        }

        List<PessoaFisica> pessoas = new ArrayList<>();
        String sql = "SELECT * FROM PessoaFisica";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet resultSet = stmt.executeQuery()) {
            while (resultSet.next()) {
                PessoaFisica pessoa = new PessoaFisica();
                pessoa.setId(resultSet.getInt("Id"));
                pessoa.setNome(resultSet.getString("Nome"));
                // Outros atributos...

                pessoas.add(pessoa);
            }
        }
        return pessoas;
    }

    public void incluir(PessoaFisica pessoa) throws SQLException {
        if (connection == null) {
            throw new IllegalStateException("A conexão com o banco de dados não foi estabelecida.");
        }

        String sql = "INSERT INTO Pessoa (Nome, Sobrenome, CPF, DataNascimento) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getSobrenome());
            stmt.setString(3, pessoa.getCPF());
            stmt.setDate(4, pessoa.getDataNascimento());
            stmt.executeUpdate();
        }
    }

    public void alterar(PessoaFisica pessoa) throws SQLException {
        if (connection == null) {
            throw new IllegalStateException("A conexão com o banco de dados não foi estabelecida.");
        }

        String sql = "UPDATE PessoaFisica SET Nome = ?, Sobrenome = ?, CPF = ?, DataNascimento = ? WHERE Id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getSobrenome());
            stmt.setString(3, pessoa.getCPF());
            stmt.setDate(4, pessoa.getDataNascimento());
            stmt.setInt(5, pessoa.getId());
            stmt.executeUpdate();
        }
    }

    public void excluir(int id) throws SQLException {
        if (connection == null) {
            throw new IllegalStateException("A conexão com o banco de dados não foi estabelecida.");
        }

        String sql = "DELETE FROM PessoaFisica WHERE Id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
