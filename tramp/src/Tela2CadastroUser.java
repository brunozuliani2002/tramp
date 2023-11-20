import dal.ModuloConexao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Tela2CadastroUser {
    private JTextField txtNome;
    private JLabel JLNome;
    private JLabel JLSenha;
    private JTextField txtSenha;
    private JButton btnCadastrar;
    private JLabel JLTituloTchefood;
    public JPanel JPTelaCadastroUser;
    private JTextField txtFone;
    private JTextField txtLogin;
    private JButton btnVoltar;
    JPanel JPTelaCadastro;
    private JLabel lNome;
    private JLabel lSenha;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        JFrame frame = new JFrame("TelaCadastroUser");
        frame.setContentPane(new Tela2CadastroUser().JPTelaCadastro);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }

    public Tela2CadastroUser() {

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = txtLogin.getText();
                String senha = txtSenha.getText();


                if (cadastrarUsuario(login,senha)) {

                    JOptionPane.showMessageDialog(JPTelaCadastro, "Cadastro realizado com sucesso!");

                    JFrame frameTelaCadastro = (JFrame) SwingUtilities.getWindowAncestor(JPTelaCadastro);
                    frameTelaCadastro.setVisible(false);

                    JFrame frameTelaLogin = new JFrame("TelaLogin");
                    try {
                        frameTelaLogin.setContentPane(new Tela3Login().JPTelaLogin);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                    frameTelaLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frameTelaLogin.pack();
                    frameTelaLogin.setVisible(true);
                    frameTelaLogin.setLocationRelativeTo(null);
                } else {

                    JOptionPane.showMessageDialog(JPTelaCadastro, "Erro ao cadastrar usuário", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameTelaCadastroUser = (JFrame) SwingUtilities.getWindowAncestor(JPTelaCadastro);
                frameTelaCadastroUser.setVisible(false);

                JFrame frameTelaInicio = new JFrame("TelaInicio");
                frameTelaInicio.setContentPane(new Tela1Inicio().JPTelaInicio);
                frameTelaInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frameTelaInicio.pack();
                frameTelaInicio.setVisible(true);
                frameTelaInicio.setLocationRelativeTo(null);
            }
        });

    }


    private boolean cadastrarUsuario( String login, String senha) {
        // Lógica para cadastrar o usuário no banco de dados
        // Substitua pelo código de inserção no banco de dados

        try {
            Connection conexao = ModuloConexao.obterConexao();
            String insercaoSQL = "INSERT INTO tbusuarios (login, senha) VALUES (?, ?)";
            PreparedStatement statement = conexao.prepareStatement(insercaoSQL);

            statement.setString(1, login);
            statement.setString(2, senha);
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
