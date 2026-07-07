import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CSVWriter {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("students.csv"))) {

            bw.write("NIM,NAMA,UMUR,PRODI");
            bw.newLine();

            System.out.print("Jumlah data yang akan dimasukkan : ");
            int n = input.nextInt();
            input.nextLine();

            for (int i = 1; i <= n; i++) {

                System.out.println("\nData ke-" + i);

                System.out.print("NIM   : ");
                String nim = input.nextLine();

                System.out.print("Nama  : ");
                String nama = input.nextLine();

                System.out.print("Umur  : ");
                String umur = input.nextLine();

                System.out.print("Prodi : ");
                String prodi = input.nextLine();

                bw.write(nim + "," + nama + "," + umur + "," + prodi);
                bw.newLine();
            }

            System.out.println("\nData berhasil disimpan.");

        } catch (IOException e) {
            e.printStackTrace();
        }

        input.close();
    }
}