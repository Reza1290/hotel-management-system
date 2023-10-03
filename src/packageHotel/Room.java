/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packageHotel;

/**
 *
 * @author Nitro
 */
public class Room {
    private int nomorKamar;
    private String tipeKamar;
    private double harga;
    private boolean status;
    
   
    
   /**
     * Konstruktor untuk membuat objek Room.
     *
     * @param nomorKamar Nomor kamar.
     * @param tipeKamar  Tipe kamar.
     * @param harga      Harga kamar.
     */
    public Room(int nomorKamar, String tipeKamar, double harga) {
        this.nomorKamar = nomorKamar;
        this.tipeKamar = tipeKamar;
        this.harga = harga;
        this.status = false; // Awalnya, kamar dianggap tidak tersedia.
    }

    /**
     * Mendapatkan status kamar (tersedia atau tidak).
     *
     * @return Status kamar.
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Mengatur status kamar (tersedia atau tidak).
     *
     * @param status Status kamar yang akan diatur.
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * Mendapatkan nomor kamar.
     *
     * @return Nomor kamar.
     */
    public int getNomorKamar() {
        return nomorKamar;
    }

    /**
     * Mengatur nomor kamar.
     *
     * @param nomorKamar Nomor kamar yang akan diatur.
     */
    public void setNomorKamar(int nomorKamar) {
        this.nomorKamar = nomorKamar;
    }

    /**
     * Mendapatkan tipe kamar.
     *
     * @return Tipe kamar.
     */
    public String getTipeKamar() {
        return tipeKamar;
    }

    /**
     * Mengatur tipe kamar.
     *
     * @param tipeKamar Tipe kamar yang akan diatur.
     */
    public void setTipeKamar(String tipeKamar) {
        this.tipeKamar = tipeKamar;
    }

    /**
     * Mendapatkan harga kamar.
     *
     * @return Harga kamar.
     */
    public double getHarga() {
        return harga;
    }

    /**
     * Mengatur harga kamar.
     *
     * @param harga Harga kamar yang akan diatur.
     */
    public void setHarga(double harga) {
        this.harga = harga;
    }

    /**
     * Representasi string dari objek Room.
     *
     * @return String yang berisi informasi tentang objek Room.
     */
    @Override
    public String toString() {
        return "Room{" + "nomorKamar=" + nomorKamar + ", tipeKamar=" + tipeKamar + ", harga=" + harga + ", status=" + status + '}';
    }
    
    
    
    
    
    
    
}
