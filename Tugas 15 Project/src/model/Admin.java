package model;

public class Admin extends User {

    public Admin(String nama) {
        super(nama);
    }

    @Override
    public void tampilInfo() {
        System.out.println("Admin : " + nama);
    }

}