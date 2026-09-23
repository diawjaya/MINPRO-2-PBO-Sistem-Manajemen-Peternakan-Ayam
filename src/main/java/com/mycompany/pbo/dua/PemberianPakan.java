package com.mycompany.pbo.dua;

public class PemberianPakan {

    private int idPemberian;
    private int jumlahPakan;
    private String tanggalPemberian;
    private String waktuPemberian;

    public PemberianPakan(int idPemberian, int jumlahPakan,
            String tanggalPemberian, String waktuPemberian) {

        this.idPemberian = idPemberian;
        this.jumlahPakan = jumlahPakan;
        this.tanggalPemberian = tanggalPemberian;
        this.waktuPemberian = waktuPemberian;
    }

    public int getIdPemberian() {
        return idPemberian;
    }

    public int getJumlahPakan() {
        return jumlahPakan;
    }

    public void setJumlahPakan(int jumlahPakan) {
        if (jumlahPakan > 0) {
            this.jumlahPakan = jumlahPakan;
        }
    }

    public String getTanggalPemberian() {
        return tanggalPemberian;
    }

    public void setTanggalPemberian(String tanggalPemberian) {
        if (!tanggalPemberian.isEmpty()) {
            this.tanggalPemberian = tanggalPemberian;
        }
    }

    public String getWaktuPemberian() {
        return waktuPemberian;
    }

    public void setWaktuPemberian(String waktuPemberian) {
        if (!waktuPemberian.isEmpty()) {
            this.waktuPemberian = waktuPemberian;
        }
    }
}