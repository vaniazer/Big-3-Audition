package View_Pack;

import javax.swing.*;
import java.awt.*;

public class vTambahAkun extends JFrame {
    JLabel lJudul = new JLabel("Register");
    JLabel lAdmin = new JLabel("Username");
    JLabel lPassword = new JLabel("Password");

    public JTextField tfAdmin = new JTextField();
    public JPasswordField tfPassword = new JPasswordField();
    public JCheckBox showPassword = new JCheckBox("Show Password");

    JLabel lLogo = new JLabel();
    String path = new String("src/Gambar/iconpeople.png");
    ImageIcon imageIcon = new ImageIcon(path);
    Image image = imageIcon.getImage();
    Image newImage = image.getScaledInstance(120,100,Image.SCALE_SMOOTH);
    ImageIcon logo = new ImageIcon(newImage);
    Font font = new Font("Serif",Font.BOLD, 30);
    Font font1 = new Font("Monospaced", Font.CENTER_BASELINE,12);

    public JButton btnDaftar = new JButton("Daftar");
    public JButton btnKembali = new JButton("Kembali");

    public vTambahAkun(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Tambah Akun");
        setVisible(true);
        setLayout(null);
        setSize(400,400);
        setResizable(true);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);

        add(lLogo);
        lLogo.setBounds(135,10,130,160);
        lLogo.setIcon(logo);

        add(lJudul);
        lJudul.setFont(font);
        lJudul.setBounds(135,150,300,40);
        lJudul.setForeground(Color.WHITE);

        add(lAdmin);
        lAdmin.setBounds(105,200,80,23);
        lAdmin.setForeground(Color.WHITE);
        add(tfAdmin);
        tfAdmin.setBounds(195,200,100,23);

        add(lPassword);
        lPassword.setBounds(105,230,80,23);
        lPassword.setForeground(Color.WHITE);
        add(tfPassword);
        tfPassword.setBounds(195,230,100,23);
        tfPassword.setEchoChar('*');

        add(showPassword);
        showPassword.setFont(font1);
        showPassword.setBounds(195,265,200,20);
        showPassword.setBackground(Color.BLACK);
        showPassword.setForeground(Color.WHITE);

        add(btnDaftar);
        btnDaftar.setBounds(90,300,100,20);
        btnDaftar.getRootPane().setDefaultButton(btnDaftar);

        add(btnKembali);
        btnKembali.setBounds(210,300,100,20);
    }
    public String getAdmin(){
        return tfAdmin.getText();
    }
    public String getPassword(){
        return String.valueOf(tfPassword.getPassword());
    }

}




