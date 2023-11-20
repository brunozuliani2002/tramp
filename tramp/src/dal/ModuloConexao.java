package dal;
import java.sql.*;
public class ModuloConexao {
    private String nomeServidor = "127.0.0.1";
    private static String usuario = "root";
    private static String senha = "memelo01";
    private String nomeBancoDados = "trampo";

    public static Connection obterConexao() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/trampo";

        Connection connection;

        connection = DriverManager.getConnection(url, usuario, senha);
        return connection;
    }
}

