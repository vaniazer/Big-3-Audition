package Controller_Pack;

import Utama.*;
import View_Pack.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class cHomeAdmin {
    vHomeAdmin vHomeAdmin;
    Model model;
    int Admin;

    public cHomeAdmin(vHomeAdmin vHomeAdmin, Model model, int id_user) {
        this.vHomeAdmin = vHomeAdmin;
        this.model = model;
        this.Admin = id_user;

        String Admin[] = model.dataUser(id_user);
        vHomeAdmin.lWelcome.setText(Admin[1] + ", Selamat Datang");

        vHomeAdmin.btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    vHomeAdmin.dispose();
                    MVC mvc = new MVC();
                } catch (Exception e1) {
                    System.out.println("Gagal button Logout!!");
                }
            }
        });

        vHomeAdmin.btnData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    vInputData vInputData = new vInputData();
                    cInputData cInputData = new cInputData(vInputData,model);
                } catch (Exception e1){
                    System.out.println("Gagal button input data Admin!");
                }
            }
        });

        vHomeAdmin.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    vTambahAkun vTambahAkun = new vTambahAkun();
                    vTambahAkun.btnDaftar.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                if(vTambahAkun.getAdmin().equals("") || vTambahAkun.getPassword().equals("")){
                                    JOptionPane.showMessageDialog(null, "Data masih ada yang kosong");
                                }
                                else{
                                    String username = vTambahAkun.getAdmin();
                                    String password = vTambahAkun.getPassword();
                                    String role = "admin";
                                    model.insertUser(username,password,role);
                                    vTambahAkun.dispose();
                                }
                            } catch (Exception e1){
                                System.out.println("Gagal Button Daftar Admin!");
                            }
                        }
                    });

                    vTambahAkun.btnKembali.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            vTambahAkun.dispose();
                        }
                    });

                    vTambahAkun.showPassword.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(vTambahAkun.showPassword.isSelected()){
                                vTambahAkun.tfPassword.setEchoChar((char)0);
                            }
                            else{
                                vTambahAkun.tfPassword.setEchoChar('*');
                            }
                        }
                    });
                } catch (Exception e1){
                    System.out.println("Gagal button tambah Home Admin!");
                }
            }
        });

        vHomeAdmin.lWelcome.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    vProfile vProfile = new vProfile();
                    String Admin1[] = model.dataUser(id_user);
                    vProfile.tfAdmin.setText(Admin1[1]);
                    vProfile.tfPassword.setText(Admin1[2]);
                    vProfile.btnSimpan.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                if(vProfile.getAdmin().equals("") || vProfile.getPassword().equals("")){
                                    JOptionPane.showMessageDialog(null, "Data masih ada yang kosong");
                                }
                                else{
                                    String username = vProfile.getAdmin();
                                    String password = vProfile.getPassword();
                                    int id_user = Integer.parseInt(Admin1[0]);
                                    model.updateUser(id_user,username,password);
                                    vProfile.dispose();
                                }
                            } catch (Exception e1){
                                System.out.println("Gagal button simpan edit profil!");
                            }
                        }
                    });

                    vProfile.showPassword.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(vProfile.showPassword.isSelected()){
                                vProfile.tfPassword.setEchoChar((char)0);
                            }
                            else{
                                vProfile.tfPassword.setEchoChar('*');
                            }
                        }
                    });

                    vProfile.btnHapus.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                int id_user = Integer.parseInt(Admin1[0]);
                                model.deleteUser(id_user);
                                vProfile.dispose();
                                vHomeAdmin.dispose();
                                MVC mvc = new MVC();
                            } catch (Exception e1){
                                System.out.println("Gagal button hapus admin!");
                            }
                        }
                    });

                    vProfile.btnKembali.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            vProfile.dispose();
                        }
                    });
                }catch (Exception e1){
                    System.out.println("Gagal profile!");
                }
            }
        });


    }
}
