import java.util.ArrayList;
import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<NilaiMahasiswa> daftar = new ArrayList<>();

        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumlah = input.nextInt();
        input.nextLine(); // hapus newline

        for (int i = 0; i < jumlah; i++) {
            System.out.println("\nData mahasiswa ke-" + (i+1));
            System.out.print("Masukkan NIM   : ");
            String nim = input.nextLine();
            System.out.print("Masukkan Nama  : ");
            String nama = input.nextLine();
            System.out.print("Masukkan Nilai : ");
            double nilai = input.nextDouble();
            input.nextLine();

            NilaiMahasiswa mhs = new NilaiMahasiswa(nim, nama, nilai);
            daftar.add(mhs);
        }

        System.out.println("\n=========== HASIL DATA ===========");
        int lulus = 0, tidakLulus = 0;
        double totalNilai = 0;

        StringBuilder namaLulus = new StringBuilder();
        StringBuilder namaTidakLulus = new StringBuilder();
        ArrayList<String> namaA = new ArrayList<>();
        ArrayList<String> namaB = new ArrayList<>();
        ArrayList<String> namaC = new ArrayList<>();
        ArrayList<String> namaD = new ArrayList<>();
        ArrayList<String> namaE = new ArrayList<>();

        for (NilaiMahasiswa m : daftar) {
            m.tampilData();
            if (m.getGrade().equals("Error")) continue;

            totalNilai += m.getNilai();
            if (m.isLulus()) {
                lulus++;
                namaLulus.append(m.getNama()).append(", ");
            } else {
                tidakLulus++;
                namaTidakLulus.append(m.getNama()).append(", ");
            }

            switch (m.getGrade()) {
                case "A": namaA.add(m.getNama()); break;
                case "B": namaB.add(m.getNama()); break;
                case "C": namaC.add(m.getNama()); break;
                case "D": namaD.add(m.getNama()); break;
                case "E": namaE.add(m.getNama()); break;
            }
        }

        double rataRata = totalNilai / daftar.size();
        System.out.println("|  Jumlah Mahasiswa : " + daftar.size() + "  |");
        System.out.println("|  Jumlah Mahasiswa yg Lulus : " + lulus + " yaitu " + hapusKoma(namaLulus.toString()));
        System.out.println("|  Jumlah Mahasiswa yg Tidak Lulus : " + tidakLulus + " yaitu " + hapusKoma(namaTidakLulus.toString()));
        System.out.println("|  Jumlah Mahasiswa dengan Nilai A = " + namaA.size() + " yaitu " + hapusKoma(listToString(namaA)));
        System.out.println("|  Jumlah Mahasiswa dengan Nilai B = " + namaB.size() + " yaitu " + hapusKoma(listToString(namaB)));
        System.out.println("|  Jumlah Mahasiswa dengan Nilai C = " + namaC.size() + " yaitu " + hapusKoma(listToString(namaC)));
        System.out.println("|  Jumlah Mahasiswa dengan Nilai D = " + namaD.size() + " yaitu " + hapusKoma(listToString(namaD)));
        System.out.println("|  Jumlah Mahasiswa dengan Nilai E = " + namaE.size() + " yaitu " + hapusKoma(listToString(namaE)));
        System.out.println("|  Rata-rata nilai mahasiswa adalah : " + rataRata + "  |");
    }

    private static String listToString(ArrayList<String> list) {
        return String.join(", ", list);
    }

    private static String hapusKoma(String teks) {
        if (teks.endsWith(", ")) {
            return teks.substring(0, teks.length() - 2);
        }
        return teks;
    }
}
