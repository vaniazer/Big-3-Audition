package Controller_Pack;
import View_Pack.*;
import Utama.*;

import javax.swing.*;
import java.awt.event.*;

public class cInputData {
    vInputData vInputData;
    Model model;
    int baris;
    String dataEdit;

    public cInputData(vInputData vInputData, Model model){
        this.vInputData = vInputData;
        this.model = model;

        if(model.getBanyakData()!=0){
            updateData();
        }
        else{
            JOptionPane.showMessageDialog(null, "Data Trainee Tidak Ada");
        }

        vInputData.tfUsia.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                try{
                    int umur = Integer.parseInt(vInputData.tfUsia.getText());
                    vInputData.lValidUsia.setText("");
                    vInputData.btnTambah.setEnabled(true);
                } catch (NumberFormatException numberFormatException){
                    vInputData.lValidUsia.setText("Invalid Number");
                    vInputData.btnTambah.setEnabled(false);
                }
            }
        });

        vInputData.btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    vInputData.dispose();
                } catch (Exception e1){
                    System.out.println("Gagal button kembali Input Data");
                }
            }
        });

        vInputData.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                baris = vInputData.tabel.getSelectedRow();
                dataEdit = vInputData.tabel.getValueAt(baris,1).toString();
                if(dataEdit!=null){
                    vInputData.lNamaJawaban.setText(vInputData.tabel.getValueAt(baris,2).toString());
                    vInputData.lUsiaJawaban.setText(vInputData.tabel.getValueAt(baris,3).toString());
                    vInputData.lVocalJawaban.setText(vInputData.tabel.getValueAt(baris,4).toString());
                    vInputData.lDanceJawaban.setText(vInputData.tabel.getValueAt(baris,5).toString());
                    vInputData.lRapJawaban.setText(vInputData.tabel.getValueAt(baris,6).toString());
                    vInputData.lVisualJawaban.setText(vInputData.tabel.getValueAt(baris,7).toString());
                    vInputData.lCompanyJawaban.setText(vInputData.tabel.getValueAt(baris,8).toString());
                    vInputData.lStatusJawaban.setText(vInputData.tabel.getValueAt(baris,9).toString());
                    vInputData.btnEdit.setEnabled(true);
                    vInputData.btnHapus.setEnabled(true);
                }
            }
        });

        vInputData.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(vInputData.getNama().equals("")|| vInputData.getUsia().equals("") ||
                            vInputData.getVocal().equals("") || vInputData.getRap().equals("") ||
                            vInputData.getDance().equals("") || vInputData.getVisual().equals("") ||
                            vInputData.getCompany().equals("") || vInputData.getStatus().equals("")){
                        JOptionPane.showMessageDialog(null, "Data masih ada yang kosong");
                    }
                    else {
                        String nama = vInputData.getNama();
                        int usia = Integer.parseInt(vInputData.getUsia());
                        int vokal = Integer.parseInt(vInputData.getVocal());
                        int dance = Integer.parseInt(vInputData.getDance());
                        int rap = Integer.parseInt(vInputData.getRap());
                        int visual = Integer.parseInt(vInputData.getVisual());
                        String company = vInputData.getCompany();
                        String status = vInputData.getStatus();
                        model.insertData(nama,usia,vokal,dance,rap,visual,company,status);
                        updateData();
                        vInputData.tfNama.setText("");
                        vInputData.tfUsia.setText("");
                        vInputData.jVocal.setValue(1);
                        vInputData.jDance.setValue(1);
                        vInputData.jRap.setValue(1);
                        vInputData.jVisual.setValue(1);
                        vInputData.tfCompany.setSelectedItem("SM");
                        vInputData.tfStatus.clearSelection();
                    }
                } catch (Exception e1){
                    System.out.println("Gagal button simpan Input Data!");
                }
            }
        });


        vInputData.btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(dataEdit!=null){
                        int id_data = Integer.parseInt(vInputData.tabel.getValueAt(baris,1).toString());
                        model.deleteData(id_data);
                        updateData();
                    }
                } catch (Exception e1){
                    System.out.println("Gagal button Hapus Input Data");
                }
            }
        });

        vInputData.tfSearch.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                vInputData.tfSearch.setText("");
            }
        });

        vInputData.btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String cari = vInputData.tfSearch.getText();
                    String pencarian[][] = model.searchData(cari);
                    vInputData.tabel.setModel((new JTable(pencarian,vInputData.namaKolom)).getModel());
                } catch (Exception e1){
                    System.out.println("Gagal button pencarian Data!");
                }
            }
        });

        vInputData.btnRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    updateData();
                } catch (Exception e1){
                    System.out.println("Gagal button refresh data!");
                }
            }
        });

        vInputData.btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(dataEdit!=null){
                        int id_data = Integer.parseInt(vInputData.tabel.getValueAt(baris,1).toString());
                        String namaA = vInputData.tabel.getValueAt(baris,2).toString();
                        String umurA = vInputData.tabel.getValueAt(baris,3).toString();
                        int vokalA = Integer.parseInt(vInputData.tabel.getValueAt(baris,4).toString());
                        int danceA = Integer.parseInt(vInputData.tabel.getValueAt(baris,5).toString());
                        int rapA = Integer.parseInt(vInputData.tabel.getValueAt(baris,6).toString());
                        int visualA = Integer.parseInt(vInputData.tabel.getValueAt(baris,7).toString());
                        String companyA = vInputData.tabel.getValueAt(baris,8).toString();
                        String statusA = vInputData.tabel.getValueAt(baris,9).toString();

                        vInputData.dispose();
                        vEditData vEditData = new vEditData();
                        vEditData.tfNama.setText(namaA);
                        vEditData.tfUsia.setText(umurA);
                        vEditData.jVocal.setValue(vokalA);
                        vEditData.jDance.setValue(danceA);
                        vEditData.jRap.setValue(rapA);
                        vEditData.jVisual.setValue(visualA);
                        if(companyA.equals("SM")){ vEditData.tfCompany.setSelectedItem("SM"); }
                        else if(companyA.equals("YG")){ vEditData.tfCompany.setSelectedItem("YG"); }
                        else{ vEditData.tfCompany.setSelectedItem("JYP"); }
                        if(statusA.equals("Lolos")){ vEditData.status1.setSelected(true); }
                        else{ vEditData.status2.setSelected(true); }

                        vEditData.btnSimpan.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try{
                                    if(vEditData.getNama().equals("")|| vEditData.getUsia().equals("") ||
                                            vEditData.getVocal().equals("") || vEditData.getRap().equals("") ||
                                            vEditData.getDance().equals("") || vEditData.getVisual().equals("") ||
                                            vEditData.getCompany().equals("") || vEditData.getStatus().equals("")){
                                        JOptionPane.showMessageDialog(null, "Data masih ada yang kosong");
                                    }
                                    else{
                                        String namaE = vEditData.getNama();
                                        int umurE = Integer.parseInt(vEditData.getUsia());
                                        int vokalE = Integer.parseInt(vEditData.getVocal());
                                        int danceE = Integer.parseInt(vEditData.getDance());
                                        int rapE = Integer.parseInt(vEditData.getRap());
                                        int visualE = Integer.parseInt(vEditData.getVisual());
                                        String companyE = vEditData.getCompany();
                                        String statusE = vEditData.getStatus();
                                        model.updateData(id_data,namaE,umurE,vokalE,danceE,rapE,visualE,companyE,statusE);

                                        vEditData.dispose();
                                        vInputData vInputData1 = new vInputData();
                                        cInputData cInputData = new cInputData(vInputData1,model);
                                    }
                                } catch (Exception e1){
                                    System.out.println("Gagal button simpan");
                                }
                            }
                        });

                        vEditData.tfUsia.addKeyListener(new KeyAdapter() {
                            @Override
                            public void keyTyped(KeyEvent e) {
                                try{
                                    int umur = Integer.parseInt(vEditData.tfUsia.getText());
                                    vEditData.lValidUsia.setText("");
                                    vEditData.btnSimpan.setEnabled(true);
                                } catch (NumberFormatException numberFormatException){
                                    vEditData.lValidUsia.setText("Invalid Number");
                                    vEditData.btnSimpan.setEnabled(false);
                                }
                            }
                        });

                        vEditData.btnKembali.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try{
                                    vEditData.dispose();
                                } catch (Exception e1){
                                    System.out.println("Gagal button kembali edit data!");
                                }
                            }
                        });
                    }
                } catch (Exception e1){
                    System.out.println("Gagal button edit data!");
                }
            }
        });


    }

    public void updateData(){
        String data[][] = model.getData();
        vInputData.tabel.setModel((new JTable(data,vInputData.namaKolom)).getModel());
    }
}
