package View_Pack;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class vInputData extends JFrame {
    JLabel lJudul = new JLabel("Input Data Mining");
    public String[] company = {"SM","YG","JYP"};

    public JLabel lValidUsia = new JLabel();
    JLabel lJudulTerpilih = new JLabel("Data Terpilih");

    public JLabel lResult = new JLabel("Disini Untuk munculin Hasilnya Bagaimana");
    public JLabel lHasil = new JLabel("HASIL :");


    public JButton btnTambah = new JButton("Tambah");
    public JButton btnKembali = new JButton("Kembali");
    public JButton btnEdit = new JButton("Edit");
    public JButton btnHapus = new JButton("Hapus");
    public JButton btnSearch = new JButton("Cari");
    public JButton btnRefresh = new JButton("Refresh");

    JLabel lNama = new JLabel("Nama");
    JLabel lUsia = new JLabel("Usia (join)");
    JLabel lVocal = new JLabel("Vocal");
    JLabel lDance= new JLabel("Dance");
    JLabel lRap = new JLabel("Rap");
    JLabel lVisual = new JLabel("Visual");
    JLabel lCompany = new JLabel("Company");
    JLabel lStatus = new JLabel("Status");

    JLabel lNamaTepilih = new JLabel("NAMA");
    JLabel lUsiaTerpilih = new JLabel("USIA");
    JLabel lVocalTerpilih = new JLabel("VOCAL");
    JLabel lDanceTerpilih = new JLabel("DANCE");
    JLabel lRapTerpilih = new JLabel("RAP");
    JLabel lVisualTerpilih = new JLabel("VISUAL");
    JLabel lCompanyTerpilih = new JLabel("COMPANY");
    JLabel lStatusTerpilih = new JLabel("STATUS");

    public JLabel lNamaJawaban = new JLabel();
    public JLabel lUsiaJawaban = new JLabel();
    public JLabel lVocalJawaban = new JLabel();
    public JLabel lDanceJawaban = new JLabel();
    public JLabel lRapJawaban = new JLabel();
    public JLabel lVisualJawaban = new JLabel();
    public JLabel lCompanyJawaban = new JLabel();
    public JLabel lStatusJawaban = new JLabel();

    public JTextField tfNama = new JTextField();
    public JTextField tfUsia = new JTextField();
    public JSpinner jVocal = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
    public JSpinner jDance = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
    public JSpinner jRap = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
    public JSpinner jVisual = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
    public JComboBox tfCompany = new JComboBox(company);
    public JRadioButton status1 = new JRadioButton("Lolos");
    public JRadioButton status2 = new JRadioButton("Tidak Lolos");
    public ButtonGroup tfStatus = new ButtonGroup();
    public JTextField tfSearch = new JTextField("Pencarian (Nama)");


    JLabel lRange = new JLabel();
    String path = new String("src/Gambar/range.png");
    ImageIcon imageIcon = new ImageIcon(path);
    Image image = imageIcon.getImage();
    Image newImage = image.getScaledInstance(150,30,Image.SCALE_SMOOTH);
    ImageIcon logo = new ImageIcon(newImage);

    public JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"No","ID","Nama","Usia (join)","Vocal","Dance","Rap","Visual","Company","Status"};

    Font font = new Font("Serif",Font.BOLD, 30);

    public vInputData(){
        tableModel = new DefaultTableModel(namaKolom,0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(1200, 600);
        getContentPane().setBackground(Color.BLACK);

        add(lJudul);
        lJudul.setFont(font);
        lJudul.setBounds(280, 5, 800, 40);
        lJudul.setForeground(Color.WHITE);

        add(lRange);
        lRange.setBounds(595,90,200,30);
        lRange.setIcon(logo);

        add(lJudulTerpilih);
        lJudulTerpilih.setFont(font);
        lJudulTerpilih.setBounds(900, 5, 200, 40);
        lJudulTerpilih.setForeground(Color.WHITE);

        add(lNama);
        lNama.setBounds(30, 70, 70, 20);
        lNama.setForeground(Color.WHITE);
        add(tfNama);
        tfNama.setBounds(110, 70, 240, 30);

        add(lUsia);
        lUsia.setBounds(30, 115, 70, 20);
        lUsia.setForeground(Color.WHITE);
        add(tfUsia);
        tfUsia.setBounds(110, 115, 50, 30);
        add(lValidUsia);
        lValidUsia.setBounds(170,115,100,30);
        lValidUsia.setForeground(Color.red);

        add(lVocal);
        lVocal.setBounds(30, 160, 70, 20);
        lVocal.setForeground(Color.WHITE);
        add(jVocal);
        jVocal.setBounds(110, 160, 50, 30);

        add(lDance);
        lDance.setBounds(30, 205, 70, 20);
        lDance.setForeground(Color.WHITE);
        add(jDance);
        jDance.setBounds(110, 205, 50, 30);

        add(lRap);
        lRap.setBounds(430, 70, 70, 20);
        lRap.setForeground(Color.WHITE);
        add(jRap);
        jRap.setBounds(510, 70, 50, 30);


        add(lVisual);
        lVisual.setBounds(430, 115, 70, 20);
        lVisual.setForeground(Color.WHITE);
        add(jVisual);
        jVisual.setBounds(510,115,50,30);

        add(lCompany);
        lCompany.setBounds(430, 160, 70, 20);
        lCompany.setForeground(Color.WHITE);
        add(tfCompany);
        tfCompany.setBounds(510, 160, 240, 30);

        add(lStatus);
        lStatus.setBounds(430, 205, 70, 20);
        lStatus.setForeground(Color.WHITE);
        add(status1);
        status1.setBounds(510, 205, 80, 20);
        add(status2);
        status2.setBounds(600, 205, 100, 20);
        status1.setActionCommand("Lolos");
        status1.setBackground(Color.BLACK);
        status1.setForeground(Color.WHITE);
        status2.setActionCommand("Tidak Lolos");
        status2.setBackground(Color.BLACK);
        status2.setForeground(Color.WHITE);
        tfStatus.add(status1);
        tfStatus.add(status2);

        add(btnTambah);
        btnTambah.setBounds(360, 245, 90, 20);

        add(tfSearch);
        tfSearch.setBounds(430, 280, 120, 20);
        add(btnSearch);
        btnSearch.setBounds(560,280,90,20);
        add(btnRefresh);
        btnRefresh.setBounds(660,280,90,20);

        add(scrollPane);
        scrollPane.setBounds(30, 310, 720, 200);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);


        add(btnKembali);
        btnKembali.setBounds(30, 520, 90, 20);

        add(lNamaTepilih);
        lNamaTepilih.setBounds(830, 70, 70, 20);
        lNamaTepilih.setForeground(Color.WHITE);
        add(lNamaJawaban);
        lNamaJawaban.setBounds(910, 70, 240, 20);
        lNamaJawaban.setForeground(Color.WHITE);

        add(lUsiaTerpilih);
        lUsiaTerpilih.setBounds(830, 115, 70, 20);
        lUsiaTerpilih.setForeground(Color.WHITE);
        add(lUsiaJawaban);
        lUsiaJawaban.setBounds(910, 115, 50, 20);
        lUsiaJawaban.setForeground(Color.WHITE);

        add(lVocalTerpilih);
        lVocalTerpilih.setBounds(830, 160, 70, 20);
        lVocalTerpilih.setForeground(Color.WHITE);
        add(lVocalJawaban);
        lVocalJawaban.setBounds(910, 160, 50, 20);
        lVocalJawaban.setForeground(Color.WHITE);

        add(lDanceTerpilih);
        lDanceTerpilih.setBounds(830, 205, 70, 20);
        lDanceTerpilih.setForeground(Color.WHITE);
        add(lDanceJawaban);
        lDanceJawaban.setBounds(910, 205, 50, 20);
        lDanceJawaban.setForeground(Color.WHITE);

        add(lRapTerpilih);
        lRapTerpilih.setBounds(830, 250, 70, 20);
        lRapTerpilih.setForeground(Color.WHITE);
        add(lRapJawaban);
        lRapJawaban.setBounds(910, 250, 50, 20);
        lRapJawaban.setForeground(Color.WHITE);


        add(lVisualTerpilih);
        lVisualTerpilih.setBounds(830, 295, 70, 20);
        lVisualTerpilih.setForeground(Color.WHITE);
        add(lVisualJawaban);
        lVisualJawaban.setBounds(910,295,50,20);
        lVisualJawaban.setForeground(Color.WHITE);

        add(lCompanyTerpilih);
        lCompanyTerpilih.setBounds(830, 340, 70, 20);
        lCompanyTerpilih.setForeground(Color.WHITE);
        add(lCompanyJawaban);
        lCompanyJawaban.setBounds(910, 340, 240, 20);
        lCompanyJawaban.setForeground(Color.WHITE);

        add(lStatusTerpilih);
        lStatusTerpilih.setBounds(830, 395, 70, 20);
        lStatusTerpilih.setForeground(Color.WHITE);
        add(lStatusJawaban);
        lStatusJawaban.setBounds(910, 395, 240, 20);
        lStatusJawaban.setForeground(Color.WHITE);

        add(btnEdit);
        btnEdit.setBounds(900, 490, 90, 20);

        add(btnHapus);
        btnHapus.setBounds(1000, 490, 90, 20);
    }

    public String getNama(){
        return tfNama.getText();
    }

    public String getUsia(){
        return tfUsia.getText();
    }

    public String getVocal(){
        return String.valueOf(jVocal.getValue()); }

    public String getDance(){
        return String.valueOf(jDance.getValue()); }

    public String getRap(){
        return String.valueOf(jRap.getValue()); }

    public String getVisual(){
        return String.valueOf(jVisual.getValue()); }

    public String getCompany(){
        return (String) tfCompany.getSelectedItem();
    }

    public String getStatus(){
        return tfStatus.getSelection().getActionCommand();
    }
}

