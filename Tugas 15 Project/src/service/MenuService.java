package service;

import java.util.InputMismatchException;
import java.util.Scanner;

import dao.PelangganDAO;
import dao.TransaksiDAO;
import model.Pelanggan;
import model.Transaksi;

public class MenuService {

    Scanner input = new Scanner(System.in);

    PelangganDAO pelangganDAO = new PelangganDAO();
    TransaksiDAO transaksiDAO = new TransaksiDAO();

    public void tampilMenu() {

        int pilih = -1;

        do {

            try {

                System.out.println("\n======================================");
                System.out.println("      APLIKASI MANAJEMEN LAUNDRY");
                System.out.println("======================================");
                System.out.println("1. Kelola Pelanggan");
                System.out.println("2. Transaksi Laundry");
                System.out.println("3. Laporan");
                System.out.println("0. Keluar");
                System.out.println("======================================");
                System.out.print("Pilih Menu : ");

                pilih = input.nextInt();

                switch (pilih) {

                    case 1:
                        menuPelanggan();
                        break;

                    case 2:
                        menuTransaksi();
                        break;

                    case 3:
                        menuLaporan();
                        break;

                    case 0:
                        System.out.println("\nTerima kasih telah menggunakan aplikasi.");
                        break;

                    default:
                        System.out.println("\nMenu tidak tersedia.");

                }

            } catch (InputMismatchException e) {

                System.out.println("\nInput harus berupa angka!");

                input.nextLine();

            }

        } while (pilih != 0);

    }

    private void menuPelanggan() {

        int pilih;

        do {

        System.out.println("1. Tambah Pelanggan");
        System.out.println("2. Lihat Pelanggan");
        System.out.println("3. Update Pelanggan");
        System.out.println("4. Hapus Pelanggan");
        System.out.println("0. Kembali");

            pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {

                case 1:

                    System.out.print("Nama    : ");
                    String nama = input.nextLine();

                    System.out.print("No HP   : ");
                    String hp = input.nextLine();

                    System.out.print("Alamat  : ");
                    String alamat = input.nextLine();

                    Pelanggan pelanggan = new Pelanggan(nama, hp, alamat);

                    pelangganDAO.tambahPelanggan(pelanggan);

                    break;

                case 2:

                    pelangganDAO.lihatPelanggan();

                    break;
                case 3:
                    System.out.print("ID : ");
                    int id=input.nextInt();
                    input.nextLine();

                    System.out.print("Nama Baru : ");
                    String Nama=input.nextLine();

                    System.out.print("No HP : ");
                    String noHp=input.nextLine();

                    System.out.print("Alamat : ");
                    String Alamat=input.nextLine();

                    Pelanggan p=new Pelanggan();

                    p.setId(id);
                    p.setNama(Nama);
                    p.setNoHp(noHp);
                    p.setAlamat(Alamat);

                    pelangganDAO.updatePelanggan(p);
                                        break;

                case 4:
                    System.out.print("Masukkan ID Pelanggan : ");
                    int idHapus = input.nextInt();

                    pelangganDAO.hapusPelanggan(idHapus);
                    break;
                    

                case 0:

                    break;

                default:

                    System.out.println("Menu tidak tersedia.");

            }

        } while (pilih != 0);

    }

    private void menuTransaksi() {

        int pilih;

        do {

            System.out.println("\n========== MENU TRANSAKSI ==========");
            System.out.println("1. Tambah Transaksi");
            System.out.println("2. Lihat Transaksi");
            System.out.println("0. Kembali");
            System.out.print("Pilih : ");

            pilih = input.nextInt();

            switch (pilih) {

                case 1:

                    System.out.print("ID Pelanggan : ");
                    int id = input.nextInt();

                    System.out.print("Berat (Kg) : ");
                    double berat = input.nextDouble();

                    input.nextLine();

                    System.out.print("Jenis Layanan : ");
                    String layanan = input.nextLine();

                    double total = berat * 7000;

                    Transaksi transaksi =
                            new Transaksi(id, berat, layanan, total);

                    transaksiDAO.tambahTransaksi(transaksi);

                    break;

                case 2:

                    transaksiDAO.lihatTransaksi();

                    break;

                case 0:

                    break;

                default:

                    System.out.println("Menu tidak tersedia.");

            }

        } while (pilih != 0);

    }

    private void menuLaporan() {

        int pilih;

        do {

            System.out.println("\n========== MENU LAPORAN ==========");
            System.out.println("1. Total Pendapatan");
            System.out.println("2. Laundry Belum Selesai");
            System.out.println("0. Kembali");
            System.out.print("Pilih : ");

            pilih = input.nextInt();

            switch (pilih) {

                case 1:

                    transaksiDAO.totalPendapatan();

                    break;

                case 2:

                    transaksiDAO.laundryBelumSelesai();

                    break;

                case 0:

                    break;

                default:

                    System.out.println("Menu tidak tersedia.");

            }

        } while (pilih != 0);

    }

}