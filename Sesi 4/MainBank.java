public class MainBank {
    public static void main(String[] args) {
        // Objek dari kelas Bank (dasar)
        Bank bankUmum = new Bank();
        System.out.println("=== TEST BANK UMUM (Method Overloading) ===");
        bankUmum.transferUang(500000, "1234567890");
        bankUmum.transferUang(1000000, "9876543210", "BRI");
        bankUmum.transferUang(250000, "1234509876", "Mandiri", "Pembayaran Tagihan");
        bankUmum.sukuBunga();

        System.out.println("\n=== TEST BANK BNI (Overriding) ===");
        BankBNI bni = new BankBNI();
        bni.transferUang(750000, "111122223333", "BANK LAIN");
        bni.sukuBunga();

        System.out.println("\n=== TEST BANK BCA (Overriding) ===");
        BankBCA bca = new BankBCA();
        bca.transferUang(900000, "444455556666", "BANK LAIN");
        bca.sukuBunga();

        System.out.println("\n=== BONUS: BIAYA TRANSFER ===");
        System.out.println("Biaya transfer ke BRI: Rp" + bankUmum.hitungBiayaTransfer("BRI"));
        System.out.println("Biaya transfer ke BCA: Rp" + bankUmum.hitungBiayaTransfer("BCA"));
    }
}
