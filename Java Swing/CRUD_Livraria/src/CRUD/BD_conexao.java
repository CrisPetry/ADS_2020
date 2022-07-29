package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class BD_conexao {

    private Connection con;
    private PreparedStatement stmt;

    public void conectar() {
        String username = "postgres";
        String password = "masterkey";
        String url = "jdbc:postgresql://localhost/POO";
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Falha ao conectar " + e.getMessage());
        }
    }

    public void cadastraLivro(int codigo, String titulo, String autor, String genero, double preco) {
        try {
            Statement stmt = con.createStatement();
            stmt.execute("INSERT INTO livros(codigo, titulo, autor, genero, preco) VALUES('" + codigo + "',' " + titulo + "','" + autor + "','" + genero + "','" + preco + "')");
        } catch (SQLException e) {
            System.out.println("Falha na conexão na tentativa de inserção" + e.getMessage());
        }
    }

    public ResultSet buscaLivro(String sql) {
        ResultSet rs = null;
        try {
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("Erro SQL " + e.getMessage());
        }
        return rs;
    }

    public void alteraDados(int c, String t, String a, String g, double p) {
        try {
            Statement stmt = con.createStatement();
            stmt.execute("UPDATE livros SET codigo = '" + c + "', titulo = " + "'" + t + "', autor = '" + a + "',"
                    + " genero = '" + g + "', preco = " + "'" + p + "'");
        } catch (SQLException e) {
            System.out.println("Falha ao fazer update" + e.getMessage());
        }
    }

    public void delete(int c, String t, String a, String g, double p) {
        try {
            Statement stmt = con.createStatement();
        } catch (SQLException e) {
            System.out.println("[ERRO] " + e.getMessage());
        }
    }

    public void desconectar() {
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("Erro ao desconectar" + e.getMessage());
        }
    }
}
