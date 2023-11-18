package dal;
import java.sql.*;
public class ModuloConexao {
    private String nomeServidor = "127.0.0.1";
    private static String usuario = "root";
    private static String senha = "memelo01";
    private String nomeBancoDados = "infox";

    public static Connection obterConexao() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/dbinfox";

        Connection connection;

        connection = DriverManager.getConnection(url, usuario, senha);
        return connection;
    }
}

