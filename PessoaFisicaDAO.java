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

    public PessoaFIsica getPessoa(int id, String  nome,
                                  String logradouro,
                                  String cidade,
                                  String estado,
                                  int telefone,
                                  String email) throws SQLException {
        if (connection == null) {
            throw new IllegalStateException("A conexão com o banco de dados não foi estabelecida.");
        }

        String sql = "SELECT * FROM PessoaFisica WHERE Id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
           stmt.setString(1,nome);
            stmt.setInt(2, id );
            stmt.setString(3, cidade);
            stmt.setString(4, estado);
            stmt.setInt(5, telefone);
            stmt.setString(6, email);


            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    PessoaFIsica pessoa = new PessoaFIsica(id, nome, logradouro, cidade, estado, telefone, email);
                    pessoa.setId(resultSet.getInt("Id"));


                    return pessoa;
                } else {
                    return null; // Não encontrou a pessoa com o ID especificado.
                }
            }
        }
    }

    public List<PessoaFIsica> getPessoas(int id, String  nome,
                                         String logradouro,
                                         String cidade,
                                         String estado,
                                         int telefone,
                                         String email) throws SQLException {
        if (connection == null) {
            throw new IllegalStateException("A conexão com o banco de dados não foi estabelecida.");
        }

        List<PessoaFIsica > pessoas = new ArrayList<>();
        String sql = "SELECT * FROM PessoaFisica";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet resultSet = stmt.executeQuery()) {
            while (resultSet.next()) {
                PessoaFIsica pessoa = new PessoaFIsica(id,
                        nome,
                        logradouro,
                        cidade,
                        estado,
                        telefone,
                        email);
                pessoa.setId(resultSet.getInt("Id"));

                pessoas.add(pessoa);
            }
        }
        return pessoas;
    }

    public void incluir(PessoaFIsica pessoa) throws SQLException {
        if (connection == null) {
            throw new IllegalStateException("A conexão com o banco de dados não foi estabelecida.");
        }

        String sql = "INSERT INTO Pessoa (Nome, Sobrenome, CPF, DataNascimento) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, pessoa.getNome());
            stmt.executeUpdate();
        }
    }

    public void alterar(PessoaFIsica pessoa) throws SQLException {
        if (connection == null) {
            throw new IllegalStateException("A conexão com o banco de dados não foi estabelecida.");
        }

        String sql = "UPDATE PessoaFisica SET Nome = ?, Sobrenome = ?, CPF = ?, DataNascimento = ? WHERE Id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, pessoa.getNome());
            stmt.setInt(2, pessoa.getId());
            stmt.executeUpdate();
        }
    }

    public void excluir(int id, String  nome,
                        String logradouro,
                        String cidade,
                        String estado,
                        int telefone,
                        String email) throws SQLException {
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
