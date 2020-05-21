package View_Pack;

import javax.swing.*;
import java.awt.*;

public class vProfile extends JFrame {
    JLabel lJudul = new JLabel("Profile");
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

    public JButton btnHapus = new JButton("Hapus Akun");
    public JButton btnSimpan = new JButton("Simpan");
    public JButton btnKembali = new JButton("Kembali");

    public vProfile(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Profile");
        setVisible(true);
        setLayout(null);
        setSize(400,400);
        setResizable(true);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);

        add(lLogo);
        lLogo.setBounds(135,30,130,160);
        lLogo.setIcon(logo);

        add(lJudul);
        lJudul.setFont(font);
        lJudul.setBounds(150,170,300,40);
        lJudul.setForeground(Color.WHITE);

        add(lAdmin);
        lAdmin.setBounds(105,220,80,23);
        lAdmin.setForeground(Color.WHITE);
        add(tfAdmin);
        tfAdmin.setBounds(195,220,100,23);

        add(lPassword);
        lPassword.setBounds(105,250,80,23);
        lPassword.setForeground(Color.WHITE);
        add(tfPassword);
        tfPassword.setBounds(195,250,100,23);
        tfPassword.setEchoChar('*');

        add(showPassword);
        showPassword.setFont(font1);
        showPassword.setBounds(195,280,200,20);
        showPassword.setBackground(Color.BLACK);
        showPassword.setForeground(Color.WHITE);

        add(btnHapus);
        btnHapus.setBounds(260,10,110,20);

        add(btnSimpan);
        btnSimpan.setBounds(100,310,90,20);

        add(btnKembali);
        btnKembali.setBounds(210,310,90,20);
    }
    public String getAdmin(){
        return tfAdmin.getText();
    }
    public String getPassword(){
        return String.valueOf(tfPassword.getPassword());
    }

}




