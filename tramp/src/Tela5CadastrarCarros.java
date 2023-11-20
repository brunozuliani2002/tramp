import dal.ModuloConexao;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Tela5CadastrarCarros {
    private JPanel JPCadastrarCarros;
    private JTextField textField1;
    private JTextField textField2;
    private JButton btnCadastrar;
    private JButton btnVoltar;

    public static void main(String[] args) {
        JFrame frame = new JFrame("TelaCadastrarCarros");
        frame.setContentPane(new Tela5CadastrarCarros().JPCadastrarCarros);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


public  Tela5CadastrarCarros() {


}
    private boolean CadastrarCarros( String carros, int preco) {
        // Lógica para cadastrar o usuário no banco de dados
        // Substitua pelo código de inserção no banco de dados

        try {
            Connection conexao = ModuloConexao.obterConexao();
            String insercaoSQL = "INSERT INTO tbpedidos (carros,preco) VALUES (?, ?)";
            PreparedStatement statement = conexao.prepareStatement(insercaoSQL);

            statement.setString(1, carros);
            statement.setInt(2, preco);

            int linhasAfetadas = statement.executeUpdate();

            conexao.close();
            return linhasAfetadas > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();

            return false;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}