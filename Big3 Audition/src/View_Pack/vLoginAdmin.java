package View_Pack;

import javax.swing.*;
import java.awt.*;

public class vLoginAdmin extends JFrame {
    JLabel lJudul = new JLabel("LOGIN");
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

    public JButton btnLogin = new JButton("Login");
    public JButton btnKembali = new JButton("Kembali");

    public vLoginAdmin(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Login Admin");
        setVisible(true);
        setLayout(null);
        setSize(400,400);
        setResizable(true);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);

        add(lLogo);
        lLogo.setBounds(130,10,130,160);
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
        tfAdmin.setToolTipText("Masukkan Username Anda");

        add(lPassword);
        lPassword.setBounds(105,230,80,23);
        lPassword.setForeground(Color.WHITE);
        add(tfPassword);
        tfPassword.setBounds(195,230,100,23);
        tfPassword.setEchoChar('*');
        tfPassword.setToolTipText("Masukkan Password Anda");

        add(showPassword);
        showPassword.setFont(font1);
        showPassword.setBounds(195,255,200,20);
        showPassword.setBackground(Color.BLACK);
        showPassword.setForeground(Color.WHITE);

        add(btnLogin);
        btnLogin.setBounds(110,290,80,20);
        btnLogin.getRootPane().setDefaultButton(btnLogin);

        add(btnKembali);
        btnKembali.setBounds(200,290,80,20);
    }
    public String getAdmin(){
        return tfAdmin.getText();
    }
    public String getPassword(){
        String password = String.valueOf(tfPassword.getPassword());
        return password;
    }
}


