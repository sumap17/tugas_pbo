public class Mahasiswa {
    protected String nim;
    protected String nama;
    protected double nilai;

    public Mahasiswa(String nim, String nama, double nilai) {
        this.nim = nim;
        this.nama = nama;
        this.nilai = nilai;
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public double getNilai() {
        return nilai;
    }

    public void tampilData() {
        System.out.println("|  NIM   : " + nim + "  |");
        System.out.println("|  Nama  : " + nama + "  |");
        System.out.println("|  Nilai : " + nilai + "  |");
    }
}
