package com.sumap.laptop.main;

import java.util.Scanner;

import com.sumap.laptop.impl.Toshiba;
import com.sumap.laptop.impl.MacBook;
import com.sumap.laptop.user.LaptopUser;
import com.sumap.laptop.interfaces.Laptop;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Pilih Laptop:");
        System.out.println("1. Toshiba");
        System.out.println("2. MacBook");
        System.out.print("Masukkan pilihan: ");
        int pilihan = input.nextInt();
        input.nextLine();

        Laptop laptop;

        if (pilihan == 1) {
            laptop = new Toshiba();
        } else {
            laptop = new MacBook();
        }

        LaptopUser user = new LaptopUser(laptop);

        while (true) {
            System.out.println("\nMasukkan perintah (ON / OFF / UP / DOWN / EXIT): ");
            String command = input.nextLine();

            switch (command.toUpperCase()) {
                case "ON":
                    user.turnOnLaptop();
                    break;
                case "OFF":
                    user.turnOffLaptop();
                    break;
                case "UP":
                    user.makeVolumeUp();
                    break;
                case "DOWN":
                    user.makeVolumeDown();
                    break;
                case "EXIT":
                    input.close();
                    System.out.println("Program selesai");
                    return;
                default:
                    System.out.println("Perintah tidak dikenali");
            }
        }
    }
}