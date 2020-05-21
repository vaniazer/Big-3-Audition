package View_Pack;

import javax.swing.*;
import java.awt.*;

public class vLogin extends JFrame {
    JLabel lJudul = new JLabel("LOGIN");
    JLabel lPeserta = new JLabel("Username");
    JLabel lPassword = new JLabel("Password");

    public JTextField tfUsername = new JTextField();
    public JPasswordField tfPassword = new JPasswordField();
    public JCheckBox showPassword = new JCheckBox("Show Password");

    public JButton btnRegister = new JButton("Register");
    public JButton btnLogin = new JButton("Login");

    JLabel lLogo = new JLabel();
    String path = new String("src/Gambar/logoBig3.png");
    ImageIcon imageIcon = new ImageIcon(path);
    Image image = imageIcon.getImage();
    Image newImage = image.getScaledInstance(600,250,Image.SCALE_SMOOTH);
    ImageIcon logo = new ImageIcon(newImage);

    JLabel lTemplate = new JLabel();
    String path2 = new String("template.png");
    ImageIcon IconImage = new ImageIcon(path2);
    Image tmpt = IconImage.getImage();
    Image newTemplate = tmpt.getScaledInstance(300,250,Image.SCALE_SMOOTH);
    ImageIcon template = new ImageIcon(newTemplate);

    Font font = new Font("Serif",Font.BOLD, 30);
    Font font1 = new Font("Monospaced", Font.CENTER_BASELINE,12);


    public vLogin(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("BIG 3 AUDITION");
        setVisible(true);
        setLayout(null);
        setSize(950,320);
        setResizable(true);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);


        add(lLogo);
        lLogo.setBounds(10,15,600,250);
        lLogo.setIcon(logo);

        add(lJudul);
        lJudul.setBounds(720,50,150,30);
        lJudul.setFont(font);
        lJudul.setForeground(Color.WHITE);

        add(lPeserta);
        lPeserta.setBounds(660,100,80,23);
        lPeserta.setForeground(Color.WHITE);
        add(tfUsername);
        tfUsername.setBounds(750,100,100,23);
        tfUsername.setToolTipText("Masukkan Username Anda");

        add(lPassword);
        lPassword.setBounds(660,145,80,23);
        lPassword.setForeground(Color.WHITE);
        add(tfPassword);
        tfPassword.setBounds(750, 145, 100,23);
        tfPassword.setEchoChar('*');
        tfPassword.setToolTipText("Masukkan Password Anda");

        add(showPassword);
        showPassword.setFont(font1);
        showPassword.setBounds(750,175,200,20);
        showPassword.setBackground(Color.BLACK);
        showPassword.setForeground(Color.WHITE);

        add(btnRegister);
        btnRegister.setBounds(790,220,90,20);

        add(btnLogin);
        btnLogin.setBounds(690,220,80,20);
        btnLogin.getRootPane().setDefaultButton(btnLogin);
    }
    public String getUsername(){
        return tfUsername.getText();
    }
    public String getPassword(){
        return String.valueOf(tfPassword.getPassword());
    }
}

