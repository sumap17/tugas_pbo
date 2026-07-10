package dao;

import database.DatabaseConnection;
import model.Transaksi;
import java.sql.*;

public class TransaksiDAO {

    private Connection conn;

    public TransaksiDAO() {
        conn = DatabaseConnection.getConnection();
    }

    // Stored Procedure
    public void tambahTransaksi(Transaksi t) {

        try {

            CallableStatement cs = conn.prepareCall("{CALL tambah_transaksi(?,?,?,?)}");

            cs.setInt(1, t.getIdPelanggan());
            cs.setDouble(2, t.getBerat());
            cs.setString(3, t.getJenisLayanan());
            cs.setDouble(4, t.getTotalHarga());

            cs.execute();

            System.out.println("\nTransaksi berhasil ditambahkan.");

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

    }

    // Lihat Transaksi
    public void lihatTransaksi() {

        String sql = "SELECT * FROM transaksi";

        try {

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            System.out.println("\n===== DATA TRANSAKSI =====");

            while (rs.next()) {

                System.out.println("--------------------------------");
                System.out.println("ID Transaksi : " + rs.getInt("id_transaksi"));
                System.out.println("ID Pelanggan : " + rs.getInt("id_pelanggan"));
                System.out.println("Berat        : " + rs.getDouble("berat") + " Kg");
                System.out.println("Layanan      : " + rs.getString("jenis_layanan"));
                System.out.println("Total        : Rp " + rs.getDouble("total_harga"));
                System.out.println("Status       : " + rs.getString("status"));

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

    }

    // Function
    public void totalPendapatan() {

        String sql = "SELECT totalPendapatan() AS total";

        try {

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {

                System.out.println("\n===== TOTAL PENDAPATAN =====");
                System.out.println("Rp " + rs.getDouble("total"));

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

    }

    // View
    public void laundryBelumSelesai() {

        String sql = "SELECT * FROM laundry_belum_selesai";

        try {

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            System.out.println("\n===== LAUNDRY BELUM SELESAI =====");

            while (rs.next()) {

                System.out.println("--------------------------------");
                System.out.println("ID Transaksi : " + rs.getInt("id_transaksi"));
                System.out.println("ID Pelanggan : " + rs.getInt("id_pelanggan"));
                System.out.println("Berat        : " + rs.getDouble("berat") + " Kg");
                System.out.println("Layanan      : " + rs.getString("jenis_layanan"));
                System.out.println("Status       : " + rs.getString("status"));

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

    }

}