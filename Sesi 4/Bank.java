public class Bank {

    // Method Overloading: beberapa versi transfer uang
    public void transferUang(int jumlah, String rekeningTujuan) {
        System.out.println("Transfer sebesar Rp" + jumlah + " ke rekening " + rekeningTujuan);
    }

    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        System.out.println("Transfer sebesar Rp" + jumlah + " ke rekening " + rekeningTujuan + " di bank " + bankTujuan);
    }

    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan, String berita) {
        System.out.println("Transfer sebesar Rp" + jumlah + " ke rekening " + rekeningTujuan + " di bank " + bankTujuan + " dengan berita: " + berita);
    }

    // Method biasa
    public void sukuBunga() {
        System.out.println("Suku bunga standar adalah 3%");
    }

    // Bonus: biaya transfer antar bank
    public double hitungBiayaTransfer(String bankTujuan) {
        // Misalnya, biaya Rp 5.000 untuk transfer antar bank lain
        if (bankTujuan.equalsIgnoreCase("BNI") || bankTujuan.equalsIgnoreCase("BCA")) {
            return 0; // gratis antar bank internal
        } else {
            return 5000; // biaya tambahan jika ke bank lain
        }
    }
}
