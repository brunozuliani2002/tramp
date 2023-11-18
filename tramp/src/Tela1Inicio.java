import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Tela1Inicio {
    private JButton btnCadastrar;
    private JButton btnLogin;
    JPanel JPTelaInicio;
    public static void main(String[] args) {
        JFrame frame = new JFrame("TelaInicio");
        frame.setContentPane(new Tela1Inicio().JPTelaInicio);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }
    public Tela1Inicio() {


        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameTelaInicio = (JFrame) SwingUtilities.getWindowAncestor(JPTelaInicio);
                frameTelaInicio.setVisible(false);

                JFrame frameTelaCadastro = new JFrame("TelaCadastrar");
                frameTelaCadastro.setContentPane(new Tela2CadastroUser().JPTelaCadastroUser);
                frameTelaCadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frameTelaCadastro.pack();
                frameTelaCadastro.setVisible(true);
                frameTelaCadastro.setLocationRelativeTo(null);
            }
        });
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameTelaInicio = (JFrame) SwingUtilities.getWindowAncestor(JPTelaInicio);
                frameTelaInicio.setVisible(false);

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
            }
        });
    }




}
