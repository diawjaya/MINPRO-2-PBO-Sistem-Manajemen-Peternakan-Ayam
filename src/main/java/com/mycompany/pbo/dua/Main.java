package com.mycompany.pbo.dua;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    static ArrayList<JenisAyam> jenisAyam = new ArrayList<>();
    static ArrayList<Kandang> kandang = new ArrayList<>();
    static ArrayList<Pakan> pakan = new ArrayList<>();
    static ArrayList<PemberianPakan> pemberian = new ArrayList<>();

    public static void main(String[] args) {

        jenisAyam.add(new JenisAyam(1, "Broiler", 35));
        jenisAyam.add(new JenisAyam(2, "Layer", 70));
        jenisAyam.add(new JenisAyam(3, "Kampung", 60));

        kandang.add(new Kandang(
                1, "Kandang A", 100, 80, "Broiler", 20));

        kandang.add(new Kandang(
                2, "Kandang B", 150, 120, "Layer", 30));

        kandang.add(new Kandang(
                3, "Kandang C", 80, 60, "Kampung", 15));

        pakan.add(new Pakan(1, "Jagung", 500));
        pakan.add(new Pakan(2, "Dedak", 300));

        pemberian.add(new PemberianPakan(
                1, 20, "08-09-2026", "08:00"));

        pemberian.add(new PemberianPakan(
                2, 25, "08-09-2026", "16:00"));

        int pilihan;

        do {
            System.out.println();
            System.out.println("=== SISTEM MANAJEMEN PETERNAKAN AYAM ===");
            System.out.println("1. Data Kandang");
            System.out.println("2. Data Jenis Ayam");
            System.out.println("3. Data Pakan");
            System.out.println("4. Data Pemberian Pakan");
            System.out.println("5. Perhitungan");
            System.out.println("0. Keluar");

            pilihan = inputAngka("Pilih menu: ");

            if (pilihan == 1) {
                tampilKandang();

            } else if (pilihan == 2) {
                tampilJenisAyam();

            } else if (pilihan == 3) {
                menuPakan();

            } else if (pilihan == 4) {
                menuPemberian();

            } else if (pilihan == 5) {
                perhitungan();

            } else if (pilihan == 0) {
                System.out.println("Program selesai.");

            } else {
                System.out.println("Menu tidak tersedia.");
            }

        } while (pilihan != 0);
    }

    static void tampilKandang() {

        System.out.println();
        System.out.println("=== DATA KANDANG ===");

        System.out.printf(
                "%-5s %-15s %-10s %-12s %-15s %-10s%n",
                "ID", "Nama", "Kapasitas", "Jumlah Ayam",
                "Jenis Ayam", "Pakan");

        for (Kandang k : kandang) {

            System.out.printf(
                    "%-5d %-15s %-10d %-12d %-15s %-10d%n",
                    k.getIdKandang(),
                    k.getNamaKandang(),
                    k.getKapasitas(),
                    k.getJumlahAyam(),
                    k.getJenisAyam(),
                    k.getPakanDibutuhkan());
        }
    }

    static void tampilJenisAyam() {

        System.out.println();
        System.out.println("=== DATA JENIS AYAM ===");

        System.out.printf(
                "%-5s %-20s %-15s%n",
                "ID", "Jenis Ayam", "Umur Panen");

        for (JenisAyam j : jenisAyam) {

            System.out.printf(
                    "%-5d %-20s %-15d%n",
                    j.getIdJenisAyam(),
                    j.getNamaJenis(),
                    j.getUmurPanen());
        }
    }

    static void menuPakan() {

        int pilihan;

        do {

            System.out.println();
            System.out.println("=== MENU PAKAN ===");
            System.out.println("1. Tambah");
            System.out.println("2. Tampilkan");
            System.out.println("3. Ubah");
            System.out.println("4. Hapus");
            System.out.println("0. Kembali");

            pilihan = inputAngka("Pilih menu: ");

            if (pilihan == 1) {
                tambahPakan();

            } else if (pilihan == 2) {
                tampilPakan();

            } else if (pilihan == 3) {
                ubahPakan();

            } else if (pilihan == 4) {
                hapusPakan();

            } else if (pilihan == 0) {
                System.out.println("Kembali.");

            } else {
                System.out.println("Menu tidak tersedia.");
            }

        } while (pilihan != 0);
    }

    static void tambahPakan() {

        System.out.println();
        System.out.println("=== TAMBAH PAKAN ===");

        int id = inputAngka("ID Pakan: ");

        System.out.print("Nama Pakan: ");
        String nama = input.nextLine();

        int stok = inputAngka("Stok: ");

        pakan.add(new Pakan(id, nama, stok));

        System.out.println("Pakan berhasil ditambahkan.");
    }

    static void tampilPakan() {

        System.out.println();
        System.out.println("=== DATA PAKAN ===");

        System.out.printf(
                "%-5s %-20s %-10s%n",
                "ID", "Nama Pakan", "Stok");

        for (Pakan p : pakan) {

            System.out.printf(
                    "%-5d %-20s %-10d%n",
                    p.getIdPakan(),
                    p.getNamaPakan(),
                    p.getStok());
        }
    }

    static void ubahPakan() {

        System.out.println();
        System.out.println("=== UBAH PAKAN ===");

        int id = inputAngka("ID Pakan: ");

        for (Pakan p : pakan) {

            if (p.getIdPakan() == id) {

                System.out.print("Nama Baru: ");
                String nama = input.nextLine();

                int stok = inputAngka("Stok Baru: ");

                p.setNamaPakan(nama);
                p.setStok(stok);

                System.out.println("Pakan berhasil diubah.");
                return;
            }
        }

        System.out.println("Pakan tidak ditemukan.");
    }

    static void hapusPakan() {

        System.out.println();
        System.out.println("=== HAPUS PAKAN ===");

        int id = inputAngka("ID Pakan: ");

        for (int i = 0; i < pakan.size(); i++) {

            if (pakan.get(i).getIdPakan() == id) {

                pakan.remove(i);

                System.out.println("Pakan berhasil dihapus.");
                return;
            }
        }

        System.out.println("Pakan tidak ditemukan.");
    }

    static void menuPemberian() {

        int pilihan;

        do {

            System.out.println();
            System.out.println("=== MENU PEMBERIAN PAKAN ===");
            System.out.println("1. Tambah");
            System.out.println("2. Tampilkan");
            System.out.println("3. Ubah");
            System.out.println("4. Hapus");
            System.out.println("0. Kembali");

            pilihan = inputAngka("Pilih menu: ");

            if (pilihan == 1) {
                tambahPemberian();

            } else if (pilihan == 2) {
                tampilPemberian();

            } else if (pilihan == 3) {
                ubahPemberian();

            } else if (pilihan == 4) {
                hapusPemberian();

            } else if (pilihan == 0) {
                System.out.println("Kembali.");

            } else {
                System.out.println("Menu tidak tersedia.");
            }

        } while (pilihan != 0);
    }

    static void tambahPemberian() {

        System.out.println();
        System.out.println("=== TAMBAH PEMBERIAN PAKAN ===");

        int id = inputAngka("ID Pemberian: ");
        int jumlah = inputAngka("Jumlah Pakan: ");

        System.out.print("Tanggal: ");
        String tanggal = input.nextLine();

        System.out.print("Waktu: ");
        String waktu = input.nextLine();

        pemberian.add(new PemberianPakan(
                id, jumlah, tanggal, waktu));

        System.out.println("Data berhasil ditambahkan.");
    }

    static void tampilPemberian() {

        System.out.println();
        System.out.println("=== DATA PEMBERIAN PAKAN ===");

        System.out.printf(
                "%-5s %-15s %-15s %-10s%n",
                "ID", "Jumlah", "Tanggal", "Waktu");

        for (PemberianPakan p : pemberian) {

            System.out.printf(
                    "%-5d %-15d %-15s %-10s%n",
                    p.getIdPemberian(),
                    p.getJumlahPakan(),
                    p.getTanggalPemberian(),
                    p.getWaktuPemberian());
        }
    }

    static void ubahPemberian() {

        System.out.println();
        System.out.println("=== UBAH PEMBERIAN PAKAN ===");

        int id = inputAngka("ID Pemberian: ");

        for (PemberianPakan p : pemberian) {

            if (p.getIdPemberian() == id) {

                int jumlah = inputAngka("Jumlah Baru: ");

                System.out.print("Tanggal Baru: ");
                String tanggal = input.nextLine();

                System.out.print("Waktu Baru: ");
                String waktu = input.nextLine();

                p.setJumlahPakan(jumlah);
                p.setTanggalPemberian(tanggal);
                p.setWaktuPemberian(waktu);

                System.out.println("Data berhasil diubah.");
                return;
            }
        }

        System.out.println("Data tidak ditemukan.");
    }

    static void hapusPemberian() {

        System.out.println();
        System.out.println("=== HAPUS PEMBERIAN PAKAN ===");

        int id = inputAngka("ID Pemberian: ");

        for (int i = 0; i < pemberian.size(); i++) {

            if (pemberian.get(i).getIdPemberian() == id) {

                pemberian.remove(i);

                System.out.println("Data berhasil dihapus.");
                return;
            }
        }

        System.out.println("Data tidak ditemukan.");
    }

    static void perhitungan() {

        int totalAyam = 0;
        int totalKapasitas = 0;
        int totalStok = 0;
        int totalPemberian = 0;

        for (Kandang k : kandang) {
            totalAyam += k.getJumlahAyam();
            totalKapasitas += k.getKapasitas();
        }

        for (Pakan p : pakan) {
            totalStok += p.getStok();
        }

        for (PemberianPakan p : pemberian) {
            totalPemberian += p.getJumlahPakan();
        }

        System.out.println();
        System.out.println("=== HASIL PERHITUNGAN ===");
        System.out.println("Total Ayam       : " + totalAyam);
        System.out.println("Total Kapasitas  : " + totalKapasitas);
        System.out.println("Total Stok Pakan : " + totalStok);
        System.out.println("Total Pemberian  : " + totalPemberian);
    }

    static int inputAngka(String pesan) {

        while (true) {

            try {

                System.out.print(pesan);

                int angka = input.nextInt();
                input.nextLine();

                return angka;

            } catch (Exception e) {

                System.out.println("Masukkan angka.");
                input.nextLine();
            }
        }
    }
}