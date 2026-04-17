public class BankBCA extends Bank {

    // Overriding method suku bunga
    @Override
    public void sukuBunga() {
        System.out.println("Suku bunga BCA adalah 4.5%");
    }

    // Overriding transfer uang untuk menentukan nama bank otomatis
    @Override
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        bankTujuan = "BCA";
        System.out.println("Transfer sebesar Rp" + jumlah + " ke rekening " + rekeningTujuan + " di bank " + bankTujuan);
    }
}
