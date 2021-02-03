package view;


import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TaskView extends JFrame {

    public TaskView() {

        initComponents();
    }

    public void initComponents() {

        setTitle("Tareas");
        setBounds(100, 100,  500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        String[] labels = { "Titulo:", "Descripción:", "Hora:", "Estado" };

        int posX = 100;
        int posY = 100;

        var listJLabels = new ArrayList<JLabel>();

        for (var label : labels) {

            JLabel jlabel = new JLabel(label);
            jlabel.setLocation(posX, posY);
            posX += 20;
            posY += 20;
            System.out.println(posX + " " + posY);
            listJLabels.add(jlabel);
        }

        for (JLabel jLabel : listJLabels) {
            getContentPane().add(jLabel);
        }

        JButton btn = new JButton("hola");
        btn.setBounds(200, 200, 50, 50);
        getContentPane().add(btn);

    }
}