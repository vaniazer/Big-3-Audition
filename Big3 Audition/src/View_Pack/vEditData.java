package View_Pack;

import javax.swing.*;
import java.awt.*;

public class vEditData extends JFrame {
    JLabel lJudulEdit = new JLabel("Edit Data Mining");

    public JButton btnKembali = new JButton("Kembali");
    public JButton btnSimpan = new JButton("Simpan");

    public JLabel lValidUsia = new JLabel();

    JLabel lNama = new JLabel("Nama");
    JLabel lUsia = new JLabel("Usia");
    JLabel lVocal = new JLabel("Vocal");
    JLabel lDance= new JLabel("Dance");
    JLabel lRap = new JLabel("Rap");
    JLabel lVisual = new JLabel("Visual");
    JLabel lCompany = new JLabel("Company");
    JLabel lStatus = new JLabel("Status");
    String[] company = { "SM", "YG", "JYP" };

    public JTextField tfNama = new JTextField();
    public JTextField tfUsia = new JTextField();
    public JSpinner jVocal = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
    public JSpinner jDance = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
    public JSpinner jRap = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
    public JSpinner jVisual = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
    public JComboBox tfCompany = new JComboBox(company);
    public JRadioButton status1 = new JRadioButton("Lolos");
    public JRadioButton status2 = new JRadioButton("Tidak Lolos");
    public ButtonGroup tfStatus = new ButtonGroup();

    Font font = new Font("Serif",Font.BOLD, 20);


    public vEditData(){

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(400, 570);
        getContentPane().setBackground(Color.BLACK);

        add(lJudulEdit);
        lJudulEdit.setFont(font);
        lJudulEdit.setBounds(120, 40, 200, 30);
        lJudulEdit.setForeground(Color.WHITE);

        add(lNama);
        lNama.setBounds(80, 100, 130, 20);
        lNama.setForeground(Color.WHITE);
        add(tfNama);
        tfNama.setBounds(150, 100, 180, 30);

        add(lUsia);
        lUsia.setBounds(80, 145, 130, 20);
        lUsia.setForeground(Color.WHITE);
        add(tfUsia);
        tfUsia.setBounds(150, 145, 50, 30);
        add(lValidUsia);
        lValidUsia.setBounds(210, 145, 80, 30);
        lValidUsia.setForeground(Color.red);

        add(lVocal);
        lVocal.setBounds(80, 190, 130, 20);
        lVocal.setForeground(Color.WHITE);
        add(jVocal);
        jVocal.setBounds(150, 190, 50, 30);

        add(lDance);
        lDance.setBounds(80, 235, 130, 20);
        lDance.setForeground(Color.WHITE);
        add(jDance);
        jDance.setBounds(150, 235, 50, 30);

        add(lRap);
        lRap.setBounds(80, 280, 130, 20);
        lRap.setForeground(Color.WHITE);
        add(jRap);
        jRap.setBounds(150, 280, 50, 30);

        add(lVisual);
        lVisual.setBounds(80, 325, 130, 20);
        lVisual.setForeground(Color.WHITE);
        add(jVisual);
        jVisual.setBounds(150, 325, 50, 30);

        add(lCompany);
        lCompany.setBounds(80, 370, 130, 20);
        lCompany.setForeground(Color.WHITE);
        add(tfCompany);
        tfCompany.setBounds(150, 370, 180, 30);

        add(lStatus);
        lStatus.setBounds(80, 415, 130, 20);
        lStatus.setForeground(Color.WHITE);

        add(status1);
        status1.setBounds(150, 415, 80, 20);
        status1.setBackground(Color.BLACK);
        status1.setForeground(Color.WHITE);
        add(status2);
        status2.setBounds(240, 415, 100, 20);
        status1.setActionCommand("Lolos");
        status1.setBackground(Color.BLACK);
        status1.setForeground(Color.WHITE);
        status2.setActionCommand("Tidak Lolos");
        status2.setBackground(Color.BLACK);
        status2.setForeground(Color.WHITE);
        tfStatus.add(status1);
        tfStatus.add(status2);

        add(btnSimpan);
        btnSimpan.setBounds(100, 460, 90, 30);

        add(btnKembali);
        btnKembali.setBounds(200, 460, 90, 30);
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

    public String getCompany(){
        return (String) tfCompany.getSelectedItem();}
    public String getStatus(){
        return tfStatus.getSelection().getActionCommand();
    }
}

