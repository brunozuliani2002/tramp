import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela4Principal {
    public JPanel JPTelaPrincipal;
    private JButton btnCarrosAlugados;
    private JButton btnCarrosVendidos;
    private JTextField txtCarro3;
    private JTextField txtCarro2;
    private JTextField txtCarro1;
    private JTextField txtCarro6;
    private JTextField txtCarro4;
    private JTextField txtCarro5;
    private JButton cadastarCarroButton;

    JTextField[] textFields = {txtCarro1, txtCarro2, txtCarro3,txtCarro4, txtCarro5};

    public static void main(String[] args) {
        JFrame frame = new JFrame("TelaPrincipal");
        frame.setContentPane(new Tela4Principal().JPTelaPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public Tela4Principal(){
        for (JTextField textField : textFields) {
            textField.setEnabled(false);
    }
        cadastarCarroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameTelaLogin = (JFrame) SwingUtilities.getWindowAncestor(JPTelaPrincipal);
                frameTelaLogin.setVisible(false);

                JFrame frameTelaPrincipal = new JFrame("TelaPrincipal");
                frameTelaPrincipal.setContentPane(new Tela4Principal().JPTelaPrincipal);
                frameTelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frameTelaPrincipal.pack();
                frameTelaPrincipal.setVisible(true);
                frameTelaPrincipal.setLocationRelativeTo(null);
            }
        });
    }
}

