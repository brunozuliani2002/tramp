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
    private JTextField txtLogin;
    private JButton btnLogar;
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
            String sql = "select * from tbusuarios where login = ? and senha = ?";
            // consulta ao banco o q foi digitado nos txt
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtUsuario.getText());
            pst.setString(2, txtSenha.getText());
            //executa a query
            rs = pst.executeQuery();
            //se existir usuario e senha correspondente
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
                JOptionPane.showMessageDialog(null, "usuario ou senha incorreto");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }


    public Tela3Login() throws SQLException, ClassNotFoundException {

        conexao = ModuloConexao.obterConexao();
        if (conexao != null) {
            LStatus.setText("conectado");
        } else {
            LStatus.setText("nao conectado");
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

    }
}







