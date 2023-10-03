    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packageHotel;

import java.time.LocalDate;

/**
 *
 * @author Nitro
 */
public class Pemesanan {
    private Tamu tamu;
    private LocalDate tanggalCheckIn;
    private LocalDate tanggalCheckOut;
    private Room kamar;
    
    
    /**
     * Konstruktor untuk membuat objek Pemesanan.
     *
     * @param tamu          Details tamu yang melakukan pemesanan.
     * @param tanggalCheckIn Tanggal check-in.
     * @param tanggalCheckout Tanggal check-out.
     * @param room           Kamar yang dipesan oleh tamu.
     */
    
    public Pemesanan(Tamu tamu, LocalDate tanggalCheckIn, LocalDate tanggalCheckout, Room room) {
        this.tamu = tamu;
        this.tanggalCheckIn = tanggalCheckIn;
        this.tanggalCheckOut = tanggalCheckout;
        this.kamar = room;
        
    }
     
    
    /**
     * Mendapatkan nama tamu yang melakukan pemesanan.
     *
     * @return Nama tamu.
     */
    public Tamu getTamu() {
        return tamu;
    }

    /**
     * Mengatur nama tamu yang melakukan pemesanan.
     *
     * @param tamu Nama tamu yang akan diatur.
     */
    public void setTamu(Tamu tamu) {
        this.tamu = tamu;
    }

    /**
     * Mendapatkan tanggal check-in.
     *
     * @return Tanggal check-in.
     */
    public LocalDate getTanggalCheckIn() {
        return tanggalCheckIn;
    }

    /**
     * Mengatur tanggal check-in.
     *
     * @param tanggalCheckin Tanggal check-in yang akan diatur.
     */
    public void setTanggalCheckin(LocalDate tanggalCheckin) {
        this.tanggalCheckIn = tanggalCheckin;
    }

    /**
     * Mendapatkan tanggal check-out.
     *
     * @return Tanggal check-out.
     */
    public LocalDate getTanggalCheckOut() {
        return tanggalCheckOut;
    }

    /**
     * Mengatur tanggal check-out.
     *
     * @param tanggalCheckOut Tanggal check-out yang akan diatur.
     */
    public void setTanggalCheckOut(LocalDate tanggalCheckOut) {
        this.tanggalCheckOut = tanggalCheckOut;
    }

    /**
     * Mendapatkan kamar yang dipesan oleh tamu.
     *
     * @return Objek Room yang mewakili kamar yang dipesan.
     */
    public Room getRoom() {
        return kamar;
    }

    /**
     * Mengatur kamar yang dipesan oleh tamu.
     *
     * @param room Objek Room yang mewakili kamar yang dipesan.
     */
    public void setRoom(Room room) {
        this.kamar = room;
    }

    /**
     * Menghitung total harga pemesanan berdasarkan jumlah hari dan harga kamar.
     *
     * @return Total harga pemesanan.
     */
    public double hitungTotalHarga(){
        int jumlahHari = (int) tanggalCheckIn.until(tanggalCheckOut).getDays();
        double hargaTotal = jumlahHari * kamar.getHarga();
        return hargaTotal;
    }
    
}
