package app;
import model.Makanan;
import model.Minuman;

public class KasirApp {
    public static void main(String[] args) {
        System.out.println("===== SISTEM KASIR =====");

        Makanan makanan = new Makanan();
        makanan.nama = "Nasi Goreng";
        makanan.harga = 25000;
        makanan.qty = 3;

        Minuman minuman = new Minuman();
        minuman.nama = "Teh Botol";
        minuman.harga = 6000;
        minuman.qty = 15;
        minuman.stok = 20;
        int totalMinuman = 0; 

        System.out.println("\n--- Item 1 ---");
        makanan.tampil();
        System.out.println("Diskon : " + makanan.hitungDiskon());
        System.out.println("Total  : " + makanan.hitungTotal());
        int totalMakanan = makanan.hitungTotal();

        System.out.println("\n--- Item 2 ---");
        minuman.tampil();
        if (minuman.cekStok()) {
            System.out.println("Diskon : " + minuman.hitungDiskon());
            System.out.println("Total  : " + minuman.hitungTotal());
            totalMinuman = minuman.hitungTotal();
            minuman.kurangiStok();
            System.out.println("Sisa Stok : " + minuman.stok);
        } else {
            System.out.println("Stok tidak cukup!");
        }

        int grandTotal = totalMakanan + totalMinuman;
        System.out.println("\n=======================");
        System.out.println("GRAND TOTAL : " + grandTotal);
    }
}