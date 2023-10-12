/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packageHotel;

/**
 *
 * @author + Muhamad Reza Muktasib (312250024) + Shofira + Zahro
 */
public class Tamu {

    private String nama;
    private String alamat;
    private String noTelepon;
    private String email;

    /**
     * konstruktor untuk membuat objek tamu
     */
    public Tamu() {
        this.nama = "user" + Math.random();
        this.alamat = "";
        this.noTelepon = "+62" + Math.random();
        this.email = this.nama + "@hotel.com";
    }

    public Tamu(int x) {
        this.nama = "Select Name";
    }

    public Tamu(String nama) {
        this.nama = nama;
        this.alamat = "";
        this.noTelepon = "+62" + Math.random();
        this.email = this.nama + "@hotel.com";
    }

    public Tamu(String nama, String alamat, String noTelepon, String email) {
        this.nama = nama;
        this.alamat = alamat;
        this.noTelepon = noTelepon;
        this.email = email;
    }

    /**
     * untuk mendapatkan nama Tamu
     * @return mengembalikan nama tamu
     */
    public String getNama() {
        return nama;
    }

    /**
     * untuk memberikan atau mengatur nama 
     * @param nama 
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * untuk mengisi informasi alamat
     * @return 
     */
    public String getAlamat() {
        return alamat;
    }

    /**
     * fungsi untuk mengatur alamat
     * @param alamat untuk memberikan alamat
     */
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Tamu{" + "nama=" + nama + ", email=" + email + '}';
    }

}
