package com.mycompany.pbo.dua;

public class Pakan extends JenisAyam {

    private int idPakan;
    private String namaPakan;
    private int stok;

    public Pakan(int idPakan, String namaPakan, int stok) {

        super(idPakan, namaPakan, 1);

        this.idPakan = idPakan;
        this.namaPakan = namaPakan;
        this.stok = stok;
    }

    public int getIdPakan() {
        return idPakan;
    }

    public String getNamaPakan() {
        return namaPakan;
    }

    public void setNamaPakan(String namaPakan) {
        if (!namaPakan.isEmpty()) {
            this.namaPakan = namaPakan;
        }
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        if (stok >= 0) {
            this.stok = stok;
        }
    }
}