package dao;

import database.DatabaseConnection;
import model.Pelanggan;
import java.sql.*;

public class PelangganDAO {

    private Connection conn;

    public PelangganDAO() {
        conn = DatabaseConnection.getConnection();
    }

    // Tambah Pelanggan
    public void tambahPelanggan(Pelanggan p) {

        String sql = "INSERT INTO pelanggan(nama, no_hp, alamat) VALUES (?, ?, ?)";

        try {

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, p.getNama());
            ps.setString(2, p.getNoHp());
            ps.setString(3, p.getAlamat());

            ps.executeUpdate();

            System.out.println("\nData pelanggan berhasil ditambahkan.");

        } catch (SQLException e) {

            System.out.println("Gagal menambah pelanggan!");
            System.out.println(e.getMessage());

        }

    }

    // Lihat Pelanggan
    public void lihatPelanggan() {

        String sql = "SELECT * FROM pelanggan";

        try {

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            System.out.println("\n===== DATA PELANGGAN =====");

            while (rs.next()) {

                System.out.println("--------------------------------");
                System.out.println("ID      : " + rs.getInt("id_pelanggan"));
                System.out.println("Nama    : " + rs.getString("nama"));
                System.out.println("No HP   : " + rs.getString("no_hp"));
                System.out.println("Alamat  : " + rs.getString("alamat"));

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

    }

    public void updatePelanggan(Pelanggan p){

    String sql = "UPDATE pelanggan SET nama=?, no_hp=?, alamat=? WHERE id_pelanggan=?";

    try{

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, p.getNama());
        ps.setString(2, p.getNoHp());
        ps.setString(3, p.getAlamat());
        ps.setInt(4, p.getId());

        int hasil = ps.executeUpdate();

        if(hasil>0){
            System.out.println("Data berhasil diupdate.");
        }else{
            System.out.println("ID tidak ditemukan.");
        }

    }catch(SQLException e){

        System.out.println(e.getMessage());

    }

}


   public void hapusPelanggan(int id){

    String sql="DELETE FROM pelanggan WHERE id_pelanggan=?";

    try{

        PreparedStatement ps=conn.prepareStatement(sql);

        ps.setInt(1,id);

        int hasil=ps.executeUpdate();

        if(hasil>0){
            System.out.println("Data berhasil dihapus.");
        }else{
            System.out.println("ID tidak ditemukan.");
        }

    }catch(SQLException e){

        System.out.println(e.getMessage());

    }

}

}