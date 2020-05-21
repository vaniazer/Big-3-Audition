package Utama;

import javax.swing.*;
import java.sql.*;

public class Model {
    static final String driver = "com.mysql.cj.jdbc.Driver";
    static final String dbURL = "jdbc:mysql://localhost/dbaudition";
    static final String user = "root";
    static final String pass = "";
    Connection connection;
    Statement statement;

    public Model(){
        try{
            Class.forName(driver);
            connection = (Connection) DriverManager.getConnection(dbURL,user,pass);
            System.out.println("Koneksi Berhasil!!");
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Gagal Koneksi Database!", "Hasil",
                    JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null,"Driver Tidak Ditemukan!", "Hasil",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public String[] Login(String username, String password){
        try{
            String datap[] = new String[4];
            String query = "SELECT * FROM `user` WHERE username='"+username+"' AND password='"+password+"'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                datap[0] = String.valueOf(resultSet.getInt("id_user"));
                datap[1] = resultSet.getString("username");
                datap[2] = resultSet.getString("password");
                datap[3] = resultSet.getString("role");
                return datap;
            }
            else{
                JOptionPane.showMessageDialog(null,"Gagal Login! Username/Password salah!",
                        "Hasil", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Gagal Login Model!",
                    "Hasil", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public String[] dataUser(int id_user){
        try{
            String datap[] = new String[4];
            String query = "SELECT * FROM `user` WHERE id_user='"+id_user+"'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                datap[0] = String.valueOf(resultSet.getInt("id_user"));
                datap[1] = resultSet.getString("username");
                datap[2] = resultSet.getString("password");
                datap[3] = resultSet.getString("role");
                return datap;
            }
            else{
                JOptionPane.showMessageDialog(null,"Gagal mengambil data user!",
                        "Hasil", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Gagal Login Model!",
                    "Hasil", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public void insertUser(String Nama, String Password, String role){
        try{
            String query = "INSERT INTO `user` VALUES (NULL,'"+Nama+"','"+Password+"','"+role+"')";
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Data User Berhasil Disimpan!", "Hasil",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Data User Gagal Disimpan!",
                    "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateUser(int id_user,String username, String password){
        try{
            String query = "update `user` set `username` ='"+username+"',`password`='"+password+"' where id_user='"+id_user+"'";
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Update Data User Berhasil!", "Hasil",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Update Data User Gagal!",
                    "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteUser(int id_user){
        try {
            String query = "DELETE from `user` where id_user = '"+id_user+"'";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data User Berhasil Dihapus!");
        } catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null, "Data User Gagal Dihapus!");
        }
    }

    public String[][] getData(){
        try{
            int banyakData=0;
            String Data[][] = new String[getBanyakData()][10];
            String query = "select * from `data`";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Data[banyakData][0] = String.valueOf(banyakData+1);
                Data[banyakData][1] = String.valueOf(resultSet.getInt("id_data"));
                Data[banyakData][2] = resultSet.getString("nama");
                Data[banyakData][3] = String.valueOf(resultSet.getInt("usia"));
                Data[banyakData][4] = String.valueOf(resultSet.getInt("vokal"));
                Data[banyakData][5] = String.valueOf(resultSet.getInt("dance"));
                Data[banyakData][6] = String.valueOf(resultSet.getInt("rap"));
                Data[banyakData][7] = String.valueOf(resultSet.getInt("visual"));
                Data[banyakData][8] = resultSet.getString("company");
                Data[banyakData][9] = resultSet.getString("status");
                banyakData++;
            }
            return Data;
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Gagal Menampilkan Data Trainee!",
                    "Hasil", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public int getBanyakData(){
        int jumlahData=0;
        try{
            String query = "select * from `data`";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jumlahData++;
            }
            return jumlahData;
        } catch (SQLException e){
            System.out.println("Banyak Data gagal diambil!!");
            return 0;
        }
    }

    public void insertData(String Nama, int umur, int vokal, int dance, int rap, int visual, String company, String status){
        try{
            String query = "INSERT INTO `data` VALUES (NULL,'"+Nama+"','"+umur+"','"+vokal+"','"+dance+"','"+rap+"','"+visual+"','"+company+"','"+status+"')";
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Data Trainee Berhasil Disimpan!", "Hasil",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null,"Data Trainee Gagal Disimpan!",
                    "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateData(int id_data,String Nama, int umur, int vokal, int dance, int rap, int visual, String company, String status){
        try{
            String query = "Update `data` set nama='"+Nama+"',usia='"+umur+"',vokal='"+vokal+"',dance='"+dance+"'," +
                    "rap='"+rap+"',visual='"+visual+"',company='"+company+"',status='"+status+"' where id_data='"+id_data+"'";
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Data Trainee Berhasil Diupdate!", "Hasil",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null,"Data Trainee Gagal Diupdate!",
                    "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteData(int id_data){
        try {
            String query = "DELETE from `data` where id_data = '"+id_data+"'";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Trainee Berhasil Dihapus!");
        } catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null, "Data Trainee Gagal Dihapus!");
        }
    }

    public String[][] searchData(String cari){
        try{
            int banyakData=0;
            String Data[][] = new String[getBanyakData()][10];
            String query = "select * from `data` where nama like '%"+cari+"' or nama like '%"+cari+"%' or nama like '"+cari+"%'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Data[banyakData][0] = String.valueOf(banyakData+1);
                Data[banyakData][1] = String.valueOf(resultSet.getInt("id_data"));
                Data[banyakData][2] = resultSet.getString("nama");
                Data[banyakData][3] = String.valueOf(resultSet.getInt("usia"));
                Data[banyakData][4] = String.valueOf(resultSet.getInt("vokal"));
                Data[banyakData][5] = String.valueOf(resultSet.getInt("dance"));
                Data[banyakData][6] = String.valueOf(resultSet.getInt("rap"));
                Data[banyakData][7] = String.valueOf(resultSet.getInt("visual"));
                Data[banyakData][8] = resultSet.getString("company");
                Data[banyakData][9] = resultSet.getString("status");
                banyakData++;
            }
            return Data;
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Gagal Menampilkan Data Trainee yang dicari!",
                    "Hasil", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public String[] knn(String nama,int usia, int vocal, int dance, int rap, int visual,int neighbor){
        try{
            int usia1,vocal1, dance1,rap1,visual1,banyakData;
            int SM=0,YG=0,JYP=0,lolos=0,tidakLolos=0;
            banyakData = getBanyakData();
            String hasil[] = new String[2];
            String Data[][] = getData();
            double proses[] = new double[banyakData];
            String proses1[][] = new String[banyakData][2];
            String temp1[][] = new String[1][2];
            double temp;
            int maxCom, maxLolos;

            for(int i=0; i<banyakData; i++){
                usia1 = Integer.parseInt(Data[i][3])-usia;
                vocal1 = Integer.parseInt(Data[i][4])-vocal;
                dance1 = Integer.parseInt(Data[i][5])-dance;
                rap1 = Integer.parseInt(Data[i][6])-rap;
                visual1 = Integer.parseInt(Data[i][7])-visual;
                proses[i] = Math.sqrt(Math.pow(usia1,2)+Math.pow(vocal1,2)+Math.pow(dance1,2)+Math.pow(rap1,2)+Math.pow(visual1,2));
                proses1[i][0] = Data[i][8];
                proses1[i][1] = Data[i][9];
            }
            for(int i=0; i<banyakData-1; i++){
                for(int j=0; j<banyakData-1-i; j++){
                    if(proses[j]>proses[j+1]){
                        temp = proses[j];
                        proses[j] = proses[j+1];
                        proses[j+1] = temp;
                        temp1[0] = proses1[j];
                        proses1[j] = proses1[j+1];
                        proses1[j+1]= temp1[0];
                    }
                }
            }
            for(int i=0; i<neighbor; i++){
                if(proses1[i][0].equals("SM")){
                    SM++;
                }
                else if(proses1[i][0].equals("YG")){
                    YG++;
                }
                else if(proses1[i][0].equals("JYP")){
                    JYP++;
                }
                if(proses1[i][1].equals("Lolos")){
                    lolos++;
                }
                else if (proses1[i][1].equals("Tidak Lolos")){
                    tidakLolos++;
                }
            }
            maxCom = Math.max(SM,Math.max(YG,JYP));
            maxLolos = Math.max(lolos,tidakLolos);
            if((maxCom == SM && maxCom==JYP) || (maxCom == SM && maxCom==YG) || (maxCom == YG || maxCom==JYP)){
                hasil[0] = "Metode KNN tidak dapat menentukan company/perusahaan yang harus "+nama+" dituju";
            }
            else if(maxCom == SM){
                hasil[0] = "Berdasarkan data, "+nama+" dapat mencoba audisi di SM Entertainment";
            }
            else if(maxCom == YG){
                hasil[0] = "Berdasarkan data, "+nama+" dapat mencoba audisi di YG Entertainment";
            }
            else if(maxCom == JYP){
                hasil[0] = "Berdasarkan data, "+nama+" dapat mencoba audisi di JYP Entertainment";
            }

            if(maxLolos == lolos && maxLolos == tidakLolos){
                hasil[1] = "Metode KNN tidak dapat menentukan kemungkinan "+nama+" lolos audisi";
            }
            else if(maxLolos == lolos){
                hasil[1] = "Berdasarkan data, "+nama+" memiliki kemungkinan untuk lolos audisi";
            }
            else if(maxLolos == tidakLolos){
                hasil[1] = "Berdasarkan data, "+nama+" memiliki kemungkinan untuk tidak lolos audisi";
            }
            return hasil;
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Gagal Menampilkan Data KNN yang dicari!",
                    "Hasil", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public String[][] getDataCompany(String company){
        try{
            int banyakData=0;
            String Data[][] = new String[getBanyakData()][9];
            String query = "select * from `data` where company ='"+company+"' ";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Data[banyakData][0] = String.valueOf(banyakData+1);
                Data[banyakData][1] = resultSet.getString("nama");
                Data[banyakData][2] = String.valueOf(resultSet.getInt("usia"));
                Data[banyakData][3] = String.valueOf(resultSet.getInt("vokal"));
                Data[banyakData][4] = String.valueOf(resultSet.getInt("dance"));
                Data[banyakData][5] = String.valueOf(resultSet.getInt("rap"));
                Data[banyakData][6] = String.valueOf(resultSet.getInt("visual"));
                Data[banyakData][7] = resultSet.getString("company");
                Data[banyakData][8] = resultSet.getString("status");
                banyakData++;
            }
            return Data;
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Gagal Menampilkan Data Trainee!",
                    "Hasil", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public int getBanyakDataCompany(String company){
        int jumlahData=0;
        try{
            String query = "select * from `data` where company='"+company+"'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jumlahData++;
            }
            return jumlahData;
        } catch (SQLException e){
            System.out.println("Banyak Data gagal diambil!!");
            return 0;
        }
    }

}
