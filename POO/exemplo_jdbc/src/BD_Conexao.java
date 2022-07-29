
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BD_Conexao {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        String username = "postgres";
        String password = "masterkey";
        String url = "jdbc:postgresql://localhost/POO";

        try {
            //responsável por carregar o driver JDBC
            Class.forName("org.postgresql.Driver");

            //faz a conexão com o servidor do postgres;
            Connection con = DriverManager.getConnection(url, username, password);

            //cria e inicializa o objeto para manipular o BD
            Statement stmt = con.createStatement();

            //leitura dos valores 
            System.out.print("Informe a cidade: ");
            String nomeCidade = teclado.nextLine();
            System.out.print("Informe UF: ");
            String uf = teclado.next();
            //inserção
            stmt.execute("INSERT INTO cidades (cidade,uf) VALUES ('" + nomeCidade + "', '" + uf + "')");

            //seleção
            String sql = "SELECT * FROM cidades";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.print(rs.getString("codigo") + " ");
                System.out.print(rs.getString("cidade") + " ");
                System.out.println(rs.getString("uf") + " ");
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Driver JDBC não foi encontrado!");
        } catch (SQLException e) {
            System.out.println("e.getMessage()");
            System.out.println("Erro SQL");
        }

    }

}
