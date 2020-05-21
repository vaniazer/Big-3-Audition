package Controller_Pack;

import Utama.*;
import View_Pack.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class cHomePeserta {
    vHomePeserta vHomePeserta;
    Model model;
    int id_user;

    public cHomePeserta(vHomePeserta vHomePeserta, Model model, int id_user) {
        this.vHomePeserta = vHomePeserta;
        this.model = model;
        this.id_user = id_user;

        String user[] = model.dataUser(id_user);
        vHomePeserta.lWelcome.setText(user[1] + ", Selamat Datang");

        String dataCompany[][] = model.getDataCompany("SM");
        vHomePeserta.tabel.setModel((new JTable(dataCompany,vHomePeserta.namaKolom)).getModel());

        String dataCompany1[][] = model.getDataCompany("YG");
        vHomePeserta.tabel2.setModel((new JTable(dataCompany1,vHomePeserta.namaKolom2)).getModel());

        String dataCompany2[][] = model.getDataCompany("JYP");
        vHomePeserta.tabel3.setModel((new JTable(dataCompany2,vHomePeserta.namaKolom3)).getModel());

        vHomePeserta.btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    vHomePeserta.dispose();
                    MVC mvc = new MVC();
                } catch (Exception e1) {
                    System.out.println("Gagal button Logout!!");
                }
            }
        });

        vHomePeserta.circleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    vCheckYourResult vCheckYourResult = new vCheckYourResult();
                    vCheckYourResult.btnGo.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try{
                                String nama = vCheckYourResult.getNama();
                                int usia = Integer.parseInt(vCheckYourResult.getUsia());
                                int vokal = Integer.parseInt(vCheckYourResult.getVocal());
                                int dance = Integer.parseInt(vCheckYourResult.getDance());
                                int rap = Integer.parseInt(vCheckYourResult.getRap());
                                int visual = Integer.parseInt(vCheckYourResult.getVisual());
                                String neighbor = vCheckYourResult.getNeighbor();
                                int tetangganya = 0;
                                if(neighbor.equals("Semua")){
                                    tetangganya = model.getBanyakData();
                                }
                                else if(neighbor.equals("custom")){
                                    tetangganya = Integer.parseInt(vCheckYourResult.getTfNeighbor());
                                }
                                String hasil[] = model.knn(nama,usia,vokal,dance,rap,visual,tetangganya);
                                vCheckYourResult.lResult.setText(hasil[0]);
                                vCheckYourResult.lResult1.setText(hasil[1]);
                            } catch (Exception e1){
                                System.out.println("Gagal button Go User");
                            }
                        }
                    });
                    vCheckYourResult.btnKembali.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            vCheckYourResult.dispose();
                        }
                    });
                } catch (Exception e1){
                    System.out.println("Gagal button CYR Home User");
                }
            }
        });

        vHomePeserta.lWelcome.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    vProfile vProfile = new vProfile();
                    String user1[] = model.dataUser(id_user);
                    vProfile.tfAdmin.setText(user1[1]);
                    vProfile.tfPassword.setText(user1[2]);
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
                                    int id_user = Integer.parseInt(user1[0]);
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
                                int id_user = Integer.parseInt(user1[0]);
                                model.deleteUser(id_user);
                                vProfile.dispose();
                                vHomePeserta.dispose();
                                MVC mvc = new MVC();
                            } catch (Exception e1){
                                System.out.println("Gagal button hapus User!");
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