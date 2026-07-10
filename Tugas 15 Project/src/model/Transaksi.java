package model;

public class Transaksi {

    private int idTransaksi;
    private int idPelanggan;
    private double berat;
    private String jenisLayanan;
    private double totalHarga;
    private String status;

    public Transaksi() {

    }

    public Transaksi(int idPelanggan, double berat, String jenisLayanan, double totalHarga) {
        this.idPelanggan = idPelanggan;
        this.berat = berat;
        this.jenisLayanan = jenisLayanan;
        this.totalHarga = totalHarga;
    }

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public int getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(int idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public double getBerat() {
        return berat;
    }

    public void setBerat(double berat) {
        this.berat = berat;
    }

    public String getJenisLayanan() {
        return jenisLayanan;
    }

    public void setJenisLayanan(String jenisLayanan) {
        this.jenisLayanan = jenisLayanan;
    }

    public double getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(double totalHarga) {
        this.totalHarga = totalHarga;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}