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

    public void setIdJenisAyam(int idJenisAyam) {
        if (idJenisAyam > 0) {
            this.idJenisAyam = idJenisAyam;
        }
    }

    public String getNamaJenis() {
        return namaJenis;
    }

    public void setNamaJenis(String namaJenis) {
        if (!namaJenis.isEmpty()) {
            this.namaJenis = namaJenis;
        }
    }

    public int getUmurPanen() {
        return umurPanen;
    }

    public void setUmurPanen(int umurPanen) {
        if (umurPanen > 0) {
            this.umurPanen = umurPanen;
        }
    }
}