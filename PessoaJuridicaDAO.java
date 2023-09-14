import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaJuridicaDAO {
    private Connection connection;
    private String url;
    private String usuario;
    private String senha;

    public PessoaJuridicaDAO(String url, String usuario, String senha) {
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

    public PessoaJuridica getPessoa(int id, String nome, String logradouro,String cidade, String estado, int telefone, String email, String cnpj,String RazaoSocial) throws SQLException {
        if (connection == null) {
            throw new IllegalStateException("A conexão com o banco de dados não foi estabelecida.");
        }

        String sql = "SELECT * FROM PessoaJuridica WHERE Id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    PessoaJuridica pessoa = new PessoaJuridica(id, nome, logradouro,cidade,estado,telefone,email, cnpj, RazaoSocial);
                    pessoa.setId(resultSet.getInt("Id"));
                    pessoa.setRazaoSocial(resultSet.getString("RazaoSocial"));
                    // Outros atributos...

                    return pessoa;
                } else {
                    return null; // Não encontrou a pessoa com o ID especificado.
                }
            }
        }
    }

    public List<PessoaJuridica> getPessoas(int id ,String nome, String logradouro,String cidade, String estado, int telefone, String email, String cnpj,String RazaoSocial) throws SQLException {
        if (connection == null) {
            throw new IllegalStateException("A conexão com o banco de dados não foi estabelecida.");
        }

        List<PessoaJuridica> pessoas = new ArrayList<>();
        String sql = "SELECT * FROM PessoaJuridica";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet resultSet = stmt.executeQuery()) {
            while (resultSet.next()) {
                PessoaJuridica pessoa = new PessoaJuridica(id, nome, logradouro,cidade,estado,telefone,email, cnpj, RazaoSocial);
                pessoa.setId(resultSet.getInt("Id"));
                pessoa.setRazaoSocial(resultSet.getString("RazaoSocial"));
                // Outros atributos...

                pessoas.add(pessoa);
            }
        }
        return pessoas;
    }

    public void incluir(PessoaJuridica pessoa) throws SQLException {
        if (connection == null) {
            throw new IllegalStateException("A conexão com o banco de dados não foi estabelecida.");
        }

        String sql = "INSERT INTO Pessoa (RazaoSocial, CNPJ) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, pessoa.getRazaoSocial());
            stmt.setString(2, pessoa.getCnpj());
            stmt.executeUpdate();
        }
    }

    public void alterar(PessoaJuridica pessoa) throws SQLException {
        if (connection == null) {
            throw new IllegalStateException("A conexão com o banco de dados não foi estabelecida.");
        }

        String sql = "UPDATE PessoaJuridica SET RazaoSocial = ?, CNPJ = ? WHERE Id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, pessoa.getRazaoSocial());
            stmt.setString(2, pessoa.getCnpj());
            stmt.setInt(3, pessoa.getId());
            stmt.executeUpdate();
        }
    }

    public void excluir(int id) throws SQLException {
        if (connection == null) {
            throw new IllegalStateException("A conexão com o banco de dados não foi estabelecida.");
        }

        String sql = "DELETE FROM PessoaJuridica WHERE Id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
