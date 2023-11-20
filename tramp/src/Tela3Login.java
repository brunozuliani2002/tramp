import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import dal.ModuloConexao;
import javax.swing.*;

public class Tela3Login {

    private JButton btnLogin;
    private JTextField txtUsuario;
    private JTextField txtSenha;
    private JLabel LUsuario;
    public JPanel JPTelaLogin;
    private JLabel LStatus;
    private JButton btnVoltar;

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        JFrame frame = new JFrame("TelaLogin");
        frame.setContentPane(new Tela3Login().JPTelaLogin);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void logar() {
        try {
            if (conexao == null) {
                JOptionPane.showMessageDialog(null, "Não foi possível estabelecer a conexão com o banco de dados.");
                return;
            }
            if (txtUsuario.getText().isEmpty() || txtSenha.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
                return;
            }

            String sql = "SELECT * FROM tbusuarios WHERE login = ? AND senha = ?";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtUsuario.getText());
            pst.setString(2, txtSenha.getText());

            rs = pst.executeQuery();

            if (rs.next()) {
                JFrame frameTelaLogin = (JFrame) SwingUtilities.getWindowAncestor(JPTelaLogin);
                frameTelaLogin.setVisible(false);

                JFrame frameTelaPrincipal = new JFrame("TelaPrincipal");
                frameTelaPrincipal.setContentPane(new Tela4Principal().JPTelaPrincipal);
                frameTelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frameTelaPrincipal.pack();
                frameTelaPrincipal.setVisible(true);
                frameTelaPrincipal.setLocationRelativeTo(null);
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar fazer login:\n" + e.getMessage());
        } finally {
            fecharRecursos();
        }
    }

    private void fecharRecursos() {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            // Não feche a conexão aqui, pois ela pode ser reutilizada por outras operações.
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar recursos:\n" + e.getMessage());
        }
    }

    public Tela3Login() throws SQLException, ClassNotFoundException {
        try {
            conexao = ModuloConexao.obterConexao();
            if (conexao != null) {
                LStatus.setText("Conectado");
            } else {
                LStatus.setText("Não conectado");
            }

            btnLogin.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    logar();
                }
            });

            btnVoltar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame frameTelaLogin = (JFrame) SwingUtilities.getWindowAncestor(JPTelaLogin);
                    frameTelaLogin.setVisible(false);

                    JFrame frameTelaInicio = new JFrame("TelaInicio");
                    frameTelaInicio.setContentPane(new Tela1Inicio().JPTelaInicio);
                    frameTelaInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frameTelaInicio.pack();
                    frameTelaInicio.setVisible(true);
                    frameTelaInicio.setLocationRelativeTo(null);
                }
            });
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao iniciar a tela:\n" + e.getMessage());
        }
    }
}