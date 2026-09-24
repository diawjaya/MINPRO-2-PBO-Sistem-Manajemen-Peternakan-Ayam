package com.mycompany.pbo.dua;

public class JenisAyam {

    private int idJenisAyam;
    private String namaJenis;
    private int umurPanen;

    public JenisAyam(int idJenisAyam, String namaJenis, int umurPanen) {
        this.idJenisAyam = idJenisAyam;
        this.namaJenis = namaJenis;
        this.umurPanen = umurPanen;
    }

    public int getIdJenisAyam() {
        return idJenisAyam;
    }

    public String getNamaJenis() {
        return namaJenis;
    }

    public int getUmurPanen() {
        return umurPanen;
    }

    public void setNamaJenis(String namaJenis) {
        this.namaJenis = namaJenis;
    }

    public void setUmurPanen(int umurPanen) {
        this.umurPanen = umurPanen;
    }
}