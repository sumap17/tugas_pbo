public class BankBNI extends Bank {

    // Overriding method suku bunga
    @Override
    public void sukuBunga() {
        System.out.println("Suku bunga BNI adalah 4%");
    }

    // Overriding transfer uang untuk menentukan nama bank otomatis
    @Override
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        bankTujuan = "BNI";
        System.out.println("Transfer sebesar Rp" + jumlah + " ke rekening " + rekeningTujuan + " di bank " + bankTujuan);
    }
}
