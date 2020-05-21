package View_Pack;

import Controller_Pack.CircleButton;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class vHomePeserta extends JFrame {
    public JLabel lWelcome = new JLabel();
    public JLabel lJudul = new JLabel("Get Your Information");

    public JButton btnLogout = new JButton("Logout");
    public CircleButton circleButton = new CircleButton("Check Your Result");
    public JButton btnSM = new JButton("SM");
    public JButton btnYG = new JButton("YG");
    public JButton btnJYP = new JButton("JYP");

    public JPanel p1=new JPanel();
    public JPanel p2=new JPanel();
    public JPanel p3=new JPanel();
    public JTabbedPane tp = new JTabbedPane();

    public JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"No","Nama","Usia","Vocal","Dance","Rap","Visual","Company","Status"};

    public JTable tabel2;
    DefaultTableModel tableModel2;
    JScrollPane scrollPane2;
    public Object namaKolom2[] = {"No","Nama","Usia","Vocal","Dance","Rap","Visual","Company","Status"};

    public JTable tabel3;
    DefaultTableModel tableModel3;
    JScrollPane scrollPane3;
    public Object namaKolom3[] = {"No","Nama","Usia","Vocal","Dance","Rap","Visual","Company","Status"};

    JLabel lAtas = new JLabel();
    JLabel lBawah = new JLabel();
    String path = new String("src/Gambar/matcha.png");
    ImageIcon imageIcon = new ImageIcon(path);
    Image image = imageIcon.getImage();
    Image newImage = image.getScaledInstance(950,30,Image.SCALE_SMOOTH);
    ImageIcon logo = new ImageIcon(newImage);

    Font font = new Font("Serif",Font.BOLD, 30);
    Font font1 = new Font("Monospaced", Font.CENTER_BASELINE,12);


    public vHomePeserta(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("BIG 3 AUDITION");
        setVisible(true);
        setLayout(null);
        setSize(950,400);
        setResizable(true);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);

        tableModel = new DefaultTableModel(namaKolom,0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);

        tableModel2 = new DefaultTableModel(namaKolom2,0);
        tabel2 = new JTable(tableModel2);
        scrollPane2 = new JScrollPane(tabel2);

        tableModel3 = new DefaultTableModel(namaKolom3,0);
        tabel3 = new JTable(tableModel3);
        scrollPane3 = new JScrollPane(tabel3);

        add(lWelcome);
        lWelcome.setBounds(640,10,200,20);
        lWelcome.setForeground(Color.WHITE);
        lWelcome.setToolTipText("Click username untuk mengganti profil");

        add(btnLogout);
        btnLogout.setBounds(850,10,80,20);

        add(lAtas);
        lAtas.setBounds(0,40,950,30);
        lAtas.setIcon(logo);

        add(lJudul);
        lJudul.setBounds(350,80,300,30);
        lJudul.setFont(font);
        lJudul.setForeground(Color.WHITE);

        add(circleButton);
        circleButton.setBounds(20,120,200,200);

        add(p1);
        p1.add(scrollPane);
        scrollPane.setBounds(260, 120, 650, 200);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        add(p2);
        p2.add(scrollPane2);
        scrollPane2.setBounds(260, 120, 650, 200);
        scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        add(p3);
        p3.add(scrollPane3);
        scrollPane3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        add(tp);
        tp.setBounds(260,120,650,200);
        tp.add("SM",p1);
        tp.add("YG",p2);
        tp.add("JYP",p3);


    }
}

