import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class trabalhofisica2bi extends JFrame {

    private JTextField res_total;
    private JLabel res_silicio;
    private JLabel res_ferro;
    private final double alphaFerro = 6.5e-3; 
    private final double alphaSilicio = -70e-3; 

    public trabalhofisica2bi() {
        setTitle("Cálculo de Resistores - Silício e Ferro");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1)); 

        JPanel painelResistenciaTotal = new JPanel(new FlowLayout());
        JLabel resistenciatotal = new JLabel("RTD:");
        res_total = new JTextField(10);
        painelResistenciaTotal.add(resistenciatotal);
        painelResistenciaTotal.add(res_total);
        add(painelResistenciaTotal);

        JPanel painelResistencias = new JPanel(new GridLayout(1, 2)); 
        res_silicio = new JLabel("RS = ");
        res_ferro = new JLabel("RF = ");
        painelResistencias.add(res_silicio);
        painelResistencias.add(res_ferro);
        add(painelResistencias);

        JPanel painelBotao = new JPanel(new FlowLayout());
        JButton btnCalcular = new JButton("Calcular");
        painelBotao.add(btnCalcular);
        add(painelBotao);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularResistencias();
            }
        });

        setVisible(true);
    }

    private void calcularResistencias() {
        try {
            double resistenciaTotal = Double.parseDouble(res_total.getText());

            double resistorSilicio = (resistenciaTotal * alphaFerro) / (alphaFerro - alphaSilicio);

            double resistorFerro = resistenciaTotal - resistorSilicio;

            // Exibindo os resultados na interface
            res_silicio.setText(String.format("RS = %.2f Ω", resistorSilicio));
            res_ferro.setText(String.format("RF = %.2f Ω", resistorFerro));
        } catch (NumberFormatException ex) {
            res_silicio.setText("Entrada inválida.");
            res_ferro.setText("");
        }
    }

    public static void main(String[] args) {
        new trabalhofisica2bi();
    }
}
