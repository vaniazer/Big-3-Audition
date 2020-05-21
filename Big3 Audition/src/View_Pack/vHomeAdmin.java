package View_Pack;

import javax.swing.*;
import java.awt.*;

public class vHomeAdmin extends JFrame {
    public JLabel lWelcome = new JLabel();

    public JButton btnLogout = new JButton("Logout");
    public JButton btnData = new JButton("Input Data");
    public JButton btnTambah = new JButton("Tambah Akun");

    JLabel lLogo = new JLabel();
    String path = new String("src/Gambar/white.png");
    ImageIcon imageIcon = new ImageIcon(path);
    Image image = imageIcon.getImage();
    Image newImage = image.getScaledInstance(400,30,Image.SCALE_SMOOTH);
    ImageIcon logo = new ImageIcon(newImage);

    Font font = new Font("Serif",Font.BOLD, 20);
    Font font1 = new Font("Monospaced", Font.CENTER_BASELINE,12);

    public vHomeAdmin(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Home Admin");
        setVisible(true);
        setLayout(null);
        setSize(400,400);
        setResizable(true);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);

        add(lWelcome);
        lWelcome.setBounds(10,10,200,20);
        lWelcome.setForeground(Color.white);
        lWelcome.setToolTipText("Click username untuk mengganti profil");

        add(btnLogout);
        btnLogout.setBounds(280,10,80,20);

        add(lLogo);
        lLogo.setBounds(0,70,400,30);
        lLogo.setIcon(logo);

        add(btnData);
        btnData.setBounds(115,150,150,40);

        add(btnTambah);
        btnTambah.setBounds(115,200,150,40);

    }
}

