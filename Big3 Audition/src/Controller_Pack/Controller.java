package Controller_Pack;

import Utama.*;
import View_Pack.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    vLogin vlogin;
    Model model;

    public Controller(vLogin vlogin,Model model){
        this.vlogin = vlogin;
        this.model = model;

        vlogin.btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(vlogin.getUsername().equals("") || vlogin.getPassword().equals("")){
                        JOptionPane.showMessageDialog(null, "Data masih ada yang kosong");
                    }
                    else{
                        String username = vlogin.getUsername();
                        String password = vlogin.getPassword();
                        String user[] = model.Login(username,password);
                        int id_user = Integer.parseInt(user[0]);
                        if(user[1].equals(username) && user[2].equals(password)){
                            if(user[3].equals("admin")){
                                vlogin.dispose();
                                vHomeAdmin vHomeAdmin = new vHomeAdmin();
                                cHomeAdmin cHomeAdmin = new cHomeAdmin(vHomeAdmin,model,id_user);
                            }
                            if(user[3].equals("user")){
                                vlogin.dispose();
                                vHomePeserta vHomePeserta = new vHomePeserta();
                                cHomePeserta cHomePeserta = new cHomePeserta(vHomePeserta,model,id_user);
                            }
                        }
                    }
                } catch (Exception e1){
                    vlogin.tfPassword.setText("");
                    System.out.println("Gagal button login");
                }
            }
        });

        vlogin.showPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(vlogin.showPassword.isSelected()){
                    vlogin.tfPassword.setEchoChar((char)0);
                }
                else{
                    vlogin.tfPassword.setEchoChar('*');
                }
            }
        });

        vlogin.btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    vlogin.dispose();
                    vRegister vRegister = new vRegister();
                    vRegister.btnDaftar.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(vRegister.getUsername().equals("") || vRegister.getUsername().equals("")){
                                JOptionPane.showMessageDialog(null, "Data masih ada yang kosong");
                            }
                            else{
                                String usernameR = vRegister.getUsername();
                                String passwordR = vRegister.getPassword();
                                String role = "user";
                                model.insertUser(usernameR,passwordR,role);
                                vRegister.dispose();
                                MVC mvc = new MVC();
                            }
                        }
                    });
                    vRegister.btnKembali.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            vRegister.dispose();
                            MVC mvc = new MVC();
                        }
                    });

                    vRegister.showPassword.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(vRegister.showPassword.isSelected()){
                                vRegister.tfPassword.setEchoChar((char)0);
                            }
                            else{
                                vRegister.tfPassword.setEchoChar('*');
                            }
                        }
                    });
                } catch (Exception e1){
                    System.out.println("Gagal button Register!");
                }
            }
        });
    }

}
