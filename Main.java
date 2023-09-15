import java.util.Scanner;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String url = "jdbc:mysql://localhost:3306/seu_banco_de_dados";
            String usuario = "seu_usuario";
            String senha = "sua_senha";
            PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO(url, usuario, senha);

            try {
                pessoaFisicaDAO.conectar();

                while (true) {
                    System.out.println("Selecione uma opção:");
                    System.out.println("1 - Incluir Pessoa Física");
                    System.out.println("2 - Alterar Pessoa Física");
                    System.out.println("3 - Excluir Pessoa Física");
                    System.out.println("4 - Obter Pessoa Física por ID");
                    System.out.println("5 - Obter Todas as Pessoas Físicas");
                    System.out.println("0 - Sair");

                    int opcao = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer de entrada

                    switch (opcao) {
                        case 1:
                            // Implemente a lógica para incluir Pessoa Física aqui
                            break;
                        case 2:
                            // Implemente a lógica para alterar Pessoa Física aqui
                            break;
                        case 3:
                            // Implemente a lógica para excluir Pessoa Física aqui
                            break;
                        case 4:
                            // Implemente a lógica para obter Pessoa Física por ID aqui
                            break;
                        case 5:
                            // Implemente a lógica para obter todas as Pessoas Físicas aqui
                            break;
                        case 0:
                            pessoaFisicaDAO.desconectar();
                            System.out.println("Programa encerrado.");
                            return;
                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                    }
                }
            } catch (SQLException e) {
                System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            } finally {
                scanner.close();
            }
        }
    }


