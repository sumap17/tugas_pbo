package model;

public class User {

    protected String nama;

    public User(String nama) {
        this.nama = nama;
    }

    public void tampilInfo() {
        System.out.println("User : " + nama);
    }

}