import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EmptyStackException;
import java.util.Stack;

public class Buscador extends JFrame{
    private JPanel panel1;
    private JTextField jTextBuscar;
    private JButton jButtonBuscar;
    private JTextArea jTextHistorial;
    private JButton jButtonAtras;
    private JButton jButtonSiguiente;
    Stack<String>pila1 = new Stack<>();
    Stack<String>pila2 = new Stack<>();


    public Buscador(){
        setContentPane(panel1);
        jButtonAtras.setEnabled(false);
        jButtonSiguiente.setEnabled(false);

        jButtonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                pila1.push(jTextBuscar.getText());
                jTextHistorial.setText(pila1.toString());
                jButtonAtras.setEnabled(true);
                jButtonSiguiente.setEnabled(true);
                jTextBuscar.setText("");
            }
        });
        jButtonAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pila1.isEmpty()){
                    try{
                        pila1.pop();
                    } catch (EmptyStackException es){

                    }
                } else {
                    pila2.push(pila1.pop());
                    jTextHistorial.setText(pila1.toString());
                }
            }
        });
        jButtonSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pila2.isEmpty()){
                    try{
                        pila2.pop();
                    } catch (EmptyStackException es){

                    }
                } else {
                    pila1.push(pila2.pop());
                    jTextHistorial.setText(pila1.toString());
                }
            }
        });
    }
}
