package View_Pack;

import javax.swing.*;
import java.awt.*;

public class vCheckYourResult extends JFrame {
    JLabel lJudul = new JLabel("Check Your Result");

    public JLabel lResult = new JLabel();
    public JLabel lResult1 = new JLabel();

    public JLabel lValidUsia = new JLabel();

    public JButton btnGo = new JButton("Go");
    public JButton btnKembali = new JButton("Kembali");

    JLabel lNama = new JLabel("Nama");
    JLabel lUsia = new JLabel("Usia");
    JLabel lVocal = new JLabel("Vocal");
    JLabel lDance= new JLabel("Dance");
    JLabel lRap = new JLabel("Rap");
    JLabel lVisual = new JLabel("Visual");
    JLabel lNeighbor = new JLabel("Neighbor");

    public JTextField tfNama = new JTextField();
    public JTextField tfUsia = new JTextField();
    public JSpinner jVocal = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
    public JSpinner jDance = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
    public JSpinner jRap = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
    public JSpinner jVisual = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
    public JSpinner tfNeighbor = new JSpinner(new SpinnerNumberModel(1,1,100,1));

    public JRadioButton neighbor1 = new JRadioButton("Semua");
    public JRadioButton neighbor2 = new JRadioButton();
    public ButtonGroup bgNeighbor = new ButtonGroup();

    JLabel lRange = new JLabel();
    String path = new String("src/Gambar/range.png");
    ImageIcon imageIcon = new ImageIcon(path);
    Image image = imageIcon.getImage();
    Image newImage = image.getScaledInstance(150,30,Image.SCALE_SMOOTH);
    ImageIcon logo = new ImageIcon(newImage);

    Font font = new Font("Serif",Font.BOLD, 30);

    public vCheckYourResult(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(800, 420);
        getContentPane().setBackground(Color.BLACK);

        add(lJudul);
        lJudul.setFont(font);
        lJudul.setBounds(280, 5, 800, 40);
        lJudul.setForeground(Color.WHITE);

        add(lRange);
        lRange.setBounds(595,90,200,40);
        lRange.setIcon(logo);
        lRange.setBackground(Color.WHITE);

        add(lNama);
        lNama.setBounds(30, 70, 70, 20);
        lNama.setForeground(Color.WHITE);
        add(tfNama);
        tfNama.setBounds(110, 70, 240, 30);

        add(lUsia);
        lUsia.setBounds(30, 115, 70, 20);
        lUsia.setForeground(Color.WHITE);
        add(tfUsia);
        tfUsia.setBounds(110, 115, 50, 30);
        add(lValidUsia);
        lValidUsia.setBounds(170,115,100,30);
        lValidUsia.setForeground(Color.red);

        add(lVocal);
        lVocal.setBounds(30, 160, 70, 20);
        lVocal.setForeground(Color.WHITE);
        add(jVocal);
        jVocal.setBounds(110, 160, 50, 30);

        add(lDance);
        lDance.setBounds(30, 205, 70, 20);
        lDance.setForeground(Color.WHITE);
        add(jDance);
        jDance.setBounds(110, 205, 50, 30);

        add(lRap);
        lRap.setBounds(430, 70, 70, 20);
        lRap.setForeground(Color.WHITE);
        add(jRap);
        jRap.setBounds(510, 70, 50, 30);


        add(lVisual);
        lVisual.setBounds(430, 115, 70, 20);
        lVisual.setForeground(Color.WHITE);
        add(jVisual);
        jVisual.setBounds(510,115,50,30);

        add(lNeighbor);
        lNeighbor.setBounds(430, 160, 70, 30);
        lNeighbor.setForeground(Color.WHITE);
        add(neighbor1);
        neighbor1.setBounds(510,160,100,30);
        neighbor1.setBackground(Color.BLACK);
        neighbor1.setForeground(Color.WHITE);
        add(neighbor2);
        neighbor2.setBounds(620,160,20,30);
        neighbor2.setForeground(Color.WHITE);
        add(tfNeighbor);
        tfNeighbor.setBounds(640,160,100,30);
        tfNeighbor.setForeground(Color.WHITE);
        neighbor1.setActionCommand("Semua");
        neighbor2.setActionCommand("custom");
        bgNeighbor.add(neighbor1);
        bgNeighbor.add(neighbor2);

        add(btnGo);
        btnGo.setBounds(360, 245, 90, 20);

        add(lResult);
        lResult.setBounds(50, 270, 800, 20);
        lResult.setForeground(Color.WHITE);
        add(lResult1);
        lResult1.setBounds(50, 300, 800, 20);
        lResult1.setForeground(Color.WHITE);

        add(btnKembali);
        btnKembali.setBounds(655, 335, 90, 20);
    }
    public String getNama(){
        return tfNama.getText();
    }

    public String getUsia(){
        return tfUsia.getText();
    }

    public String getVocal(){
        return String.valueOf(jVocal.getValue()); }

    public String getDance(){
        return String.valueOf(jDance.getValue()); }

    public String getRap(){
        return String.valueOf(jRap.getValue()); }

    public String getVisual(){
        return String.valueOf(jVisual.getValue()); }

    public String getTfNeighbor(){
        return String.valueOf(tfNeighbor.getValue());
    }

    public String getNeighbor(){
        return bgNeighbor.getSelection().getActionCommand();
    }

}

