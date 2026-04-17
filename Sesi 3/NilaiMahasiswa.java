public class NilaiMahasiswa extends Mahasiswa {
    private String grade;
    private boolean lulus;

    public NilaiMahasiswa(String nim, String nama, double nilai) {
        super(nim, nama, nilai);
        tentukanGrade();
    }

    private void tentukanGrade() {
        if (nilai >= 80 && nilai <= 100) {
            grade = "A";
            lulus = true;
        } else if (nilai >= 70 && nilai <= 79) {
            grade = "B";
            lulus = true;
        } else if (nilai >= 60 && nilai <= 69) {
            grade = "C";
            lulus = true;
        } else if (nilai >= 50 && nilai <= 59) {
            grade = "D";
            lulus = false;
        } else if (nilai >= 0 && nilai < 50) {
            grade = "E";
            lulus = false;
        } else {
            grade = "Error";
            lulus = false;
        }
    }

    public String getGrade() {
        return grade;
    }

    public boolean isLulus() {
        return lulus;
    }

    @Override
    public void tampilData() {
        super.tampilData();
        if (grade.equals("Error")) {
            System.out.println("|  Grade : Input nilai anda salah  |");
        } else {
            System.out.println("|  Grade : " + grade + "  |");
        }
        System.out.println("|  ================================  |");
    }
}
