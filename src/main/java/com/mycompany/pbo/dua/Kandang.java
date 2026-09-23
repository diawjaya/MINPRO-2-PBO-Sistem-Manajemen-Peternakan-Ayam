package com.mycompany.pbo.dua;

public class Kandang extends JenisAyam {

    private int idKandang;
    private String namaKandang;
    private int kapasitas;
    private int jumlahAyam;
    private String jenisAyam;
    private int pakanDibutuhkan;

    public Kandang(int idKandang, String namaKandang, int kapasitas,
            int jumlahAyam, String jenisAyam, int pakanDibutuhkan) {

        super(idKandang, jenisAyam, 1);

        this.idKandang = idKandang;
        this.namaKandang = namaKandang;
        this.kapasitas = kapasitas;
        this.jumlahAyam = jumlahAyam;
        this.jenisAyam = jenisAyam;
        this.pakanDibutuhkan = pakanDibutuhkan;
    }

    public int getIdKandang() {
        return idKandang;
    }

    public String getNamaKandang() {
        return namaKandang;
    }

    public void setNamaKandang(String namaKandang) {
        if (!namaKandang.isEmpty()) {
            this.namaKandang = namaKandang;
        }
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(int kapasitas) {
        if (kapasitas > 0) {
            this.kapasitas = kapasitas;
        }
    }

    public int getJumlahAyam() {
        return jumlahAyam;
    }

    public void setJumlahAyam(int jumlahAyam) {
        if (jumlahAyam >= 0 && jumlahAyam <= kapasitas) {
            this.jumlahAyam = jumlahAyam;
        }
    }

    public String getJenisAyam() {
        return jenisAyam;
    }

    public void setJenisAyam(String jenisAyam) {
        if (!jenisAyam.isEmpty()) {
            this.jenisAyam = jenisAyam;
        }
    }

    public int getPakanDibutuhkan() {
        return pakanDibutuhkan;
    }

    public void setPakanDibutuhkan(int pakanDibutuhkan) {
        if (pakanDibutuhkan >= 0) {
            this.pakanDibutuhkan = pakanDibutuhkan;
        }
    }
}