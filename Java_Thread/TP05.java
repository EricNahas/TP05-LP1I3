import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class TP05 extends JFrame implements  ActionListener, ItemListener {
    private JFrame f = new JFrame();

    private JPanel painel1 = new JPanel(); 
    private JPanel painel2 = new JPanel();
    private JPanel painel3 = new JPanel();
    private JPanel painel3_2 = new JPanel();
    private JPanel painel4 = new JPanel();

    private JPanel flowPanel1 = new JPanel();
    private JPanel flowPanel2 = new JPanel();
    private JPanel flowPanel3 = new JPanel();
    private JPanel flowPanel4 = new JPanel();
    private JPanel flowPanel5 = new JPanel();

    private JPanel buttonFlowPanel = new JPanel();

    private JButton b1 = new JButton("Iniciar");
    private JButton b2 = new JButton("Limpar");
    private JLabel l1 = new JLabel("Máximo: ");
    private JLabel l2 = new JLabel("Prioridade 1: ");
    private JLabel l3 = new JLabel("Prioridade 2: ");
    private JLabel l4 = new JLabel("");
    private JLabel l5 = new JLabel("");
    private Choice p1 = new Choice();
    private Choice p2 = new Choice();
    private JTextField t1 = new JTextField("1000            ");
    private List list1 = new List();
    private List list2 = new List();

    public int getT1() {
        return Integer.parseInt(t1.getText().trim());
    }

    public void setL1(String s) 
    {
        list1.add(s);
    }

    public void setL2(String s) 
    {
        list2.add(s);
    }

    public void setLabel1() 
    {
        l4.setText("Terminou!");
    }

    public void setLabel2() 
    {
        l5.setText("Terminou!");
    }


    public TP05 (String titulo, int largura, int altura, int colinic, int lininic) 
    {
        f.setTitle(titulo);
        f.setSize(largura,altura);
        f.setLocation(colinic,lininic);

        f.setLayout(new GridLayout(5, 1));
        painel1.setLayout(new FlowLayout((FlowLayout.LEFT)));
        painel2.setLayout(new FlowLayout((FlowLayout.CENTER)));
        painel3.setLayout(new GridLayout(1, 2));
        painel3_2.setLayout(new GridLayout(1, 2));
        painel4.setLayout(new FlowLayout((FlowLayout.CENTER)));

        flowPanel1.setLayout(new FlowLayout(FlowLayout.LEFT));
        flowPanel1.setPreferredSize(new Dimension(130, 100));
        flowPanel2.setLayout(new FlowLayout(FlowLayout.CENTER));
        flowPanel3.setLayout(new FlowLayout(FlowLayout.CENTER));
        flowPanel4.setLayout(new FlowLayout(FlowLayout.CENTER));
        flowPanel5.setLayout(new FlowLayout(FlowLayout.CENTER));

        buttonFlowPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        b1.addActionListener(this);
        b2.addActionListener(this);

        p1.addItemListener(this);
        p2.addItemListener(this);

        for (int i = 1; i <= 10; i++) {
            p1.add(Integer.toString(i));
            p2.add(Integer.toString(i));
        }

        flowPanel1.add(l1);
        flowPanel1.add(t1);
        flowPanel1.add(l2);
        flowPanel1.add(p1);
        flowPanel1.add(l3);
        flowPanel1.add(p2);

        painel1.add(flowPanel1);

        f.add(painel1);

        buttonFlowPanel.add(b1);
        painel2.add(buttonFlowPanel);

        f.add(painel2);

        flowPanel2.add(list1);
        flowPanel3.add(list2);
        flowPanel4.add(l4);
        flowPanel5.add(l5);

        painel3.add(flowPanel2);
        painel3.add(flowPanel3);
        painel3_2.add(flowPanel4);
        painel3_2.add(flowPanel5);

        f.add(painel3);

        f.add(painel3_2);

        painel4.add(b2);

        f.add(painel4);

        f.setVisible(true);
    }

    public void itemStateChanged(ItemEvent e) 
    {
        p1.getSelectedItem();
        p2.getSelectedItem();
    }

    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == b1) {
            Threads t1Threads = new Threads();
            t1Threads.getInfo(getT1());
            Thread thread1 = new Thread(t1Threads);
            thread1.setName("Thread-4");

            Threads t2Threads = new Threads();
            t2Threads.getInfo(getT1());
            Thread thread2 = new Thread(t2Threads);

            thread1.setPriority(Integer.parseInt(p1.getSelectedItem()));
            thread2.setPriority(Integer.parseInt(p2.getSelectedItem()));

            thread1.start();
            thread2.start();
        }
        if (e.getSource() == b2) 
        {
            list1.removeAll();
            list2.removeAll();

            l4.setText(" ");
            l5.setText(" ");
        }
    }


}