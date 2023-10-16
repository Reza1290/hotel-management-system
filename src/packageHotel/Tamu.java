/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packageHotel;

/**
 *
 * Kelas yang merepresentasikan seorang tamu dalam melakukan reservasi hotel.
 *
 * @author 
 * + Muhamad Reza Muktasib  (3122500204) 
 * + Shofira Izza Nurrohmah (3122500026) 
 * + Zahrotul Hidayah       (3122500004)
 */
public class Tamu {

    private String nama;
    private String alamat;
    private String noTelepon;
    private String email;

    /**
     * Konstruktor default untuk objek Tamu. Membuat objek Tamu dengan nilai
     * default untuk nama, alamat, nomor telepon, dan email. Nama akan
     * diinisialisasi dengan "user" dan nomor acak. Alamat akan diinisialisasi
     * sebagai string kosong. Nomor telepon akan diinisialisasi dengan format
     * "+62" dan nomor acak. Email akan diinisialisasi dengan gabungan nama acak
     * dan domain "hotel.com".
     */
    public Tamu() {
        this.nama = "user" + Math.random();
        this.alamat = "";
        this.noTelepon = "+62" + Math.random();
        this.email = this.nama + "@hotel.com";
    }

    /**
     * Konstruktor untuk objek Tamu dengan parameter nama. Membuat objek Tamu
     * dengan nama tertentu, sementara alamat, nomor telepon, dan email
     * diinisialisasi dengan nilai default.
     *
     * @param nama Nama tamu yang akan diatur.
     */
    public Tamu(String nama) {
        this.nama = nama;
        this.alamat = "";
        this.noTelepon = "+62" + Math.random();
        this.email = this.nama + "@hotel.com";
    }

    /**
     * Konstruktor untuk objek Tamu dengan parameter nama, alamat, nomor
     * telepon, dan email. Membuat objek Tamu dengan informasi tamu yang
     * diberikan.
     *
     * @param nama Nama tamu.
     * @param alamat Alamat tamu.
     * @param noTelepon Nomor telepon tamu.
     * @param email Alamat email tamu.
     */
    public Tamu(String nama, String alamat, String noTelepon, String email) {
        this.nama = nama;
        this.alamat = alamat;
        this.noTelepon = noTelepon;
        this.email = email;
    }

    /**
     * Mengambil Nama tamu.
     *
     * @return Nama dari tamu.
     */
    public String getNama() {
        return nama;
    }

    /**
     * Mengatur nama tamu.
     *
     * @param nama Nama yang akan diatur untuk tamu
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * Mengambil alamat tamu.
     *
     * @return Alamat dari tamu.
     */
    public String getAlamat() {
        return alamat;
    }

    /**
     * Mengatur alamat tamu.
     *
     * @param alamat Alamat yang akan diatur untuk tamu.
     */
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    /**
     * Mengambil nomor telepon tamu.
     *
     * @return Nomor telepon dari tamu.
     */
    public String getNoTelepon() {
        return noTelepon;
    }

    /**
     * Mengatur nomor telepon tamu.
     *
     * @param noTelepon Nomor telepon yang akan diatur untuk tamu.
     */
    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

    /**
     * Mengambil alamat email tamu.
     *
     * @return Alamat email yang akan diatur untuk tamu.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Mengatur alamat email tamu.
     *
     * @param email Alamat email dari tamu.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Representasi string dari objek Tamu.
     *
     * @return String yang berisi informasi tentang objek Tamu.
     */
    @Override
    public String toString() {
        return "Tamu{" + "nama=" + nama + ", email=" + email + '}';
    }

}
