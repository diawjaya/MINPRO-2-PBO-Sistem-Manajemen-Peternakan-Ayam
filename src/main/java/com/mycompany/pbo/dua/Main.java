package com.mycompany.pbo.dua;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner input = new Scanner(System.in);

    private static ArrayList<Kandang> daftarKandang = new ArrayList<>();
    private static ArrayList<JenisAyam> daftarJenisAyam = new ArrayList<>();
    private static ArrayList<Pakan> daftarPakan = new ArrayList<>();
    private static ArrayList<PemberianPakan> daftarPemberian = new ArrayList<>();

    public static void main(String[] args) {

        // Data awal jenis ayam
        daftarJenisAyam.add(new JenisAyam(1, "Broiler", 35));
        daftarJenisAyam.add(new JenisAyam(2, "Layer", 70));
        daftarJenisAyam.add(new JenisAyam(3, "Kampung", 60));

        // Data awal kandang
        daftarKandang.add(
                new Kandang(1, "Kandang A", 100, 80, "Broiler", 20)
        );

        daftarKandang.add(
                new Kandang(2, "Kandang B", 150, 120, "Layer", 30)
        );

        daftarKandang.add(
                new Kandang(3, "Kandang C", 80, 60, "Kampung", 15)
        );

        // Data awal pakan
        daftarPakan.add(
                new Pakan(1, "Jagung", 500)
        );

        daftarPakan.add(
                new Pakan(2, "Dedak", 300)
        );

        // Data awal pemberian pakan
        daftarPemberian.add(
                new PemberianPakan(1, 20, "08-09-2026", "08:00")
        );

        daftarPemberian.add(
                new PemberianPakan(2, 25, "08-09-2026", "16:00")
        );

        int pilihan;

        do {

            System.out.println("\n=== SISTEM MANAJEMEN PETERNAKAN AYAM ===");
            System.out.println("1. Data Kandang");
            System.out.println("2. Data Jenis Ayam");
            System.out.println("3. Data Pakan");
            System.out.println("4. Data Pemberian Pakan");
            System.out.println("5. Perhitungan");
            System.out.println("0. Keluar");

            pilihan = inputAngka("Pilih menu: ");

            switch (pilihan) {

                case 1:
                    tampilKandang();
                    break;

                case 2:
                    tampilJenisAyam();
                    break;

                case 3:
                    menuPakan();
                    break;

                case 4:
                    menuPemberian();
                    break;

                case 5:
                    hitung();
                    break;

                case 0:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Menu tidak tersedia.");
            }

        } while (pilihan != 0);
    }

    private static void tampilKandang() {
        System.out.println("\n=== DATA KANDANG ===");

        System.out.printf(
                "%-5s %-15s %-10s %-12s %-15s %-15s%n",
                "ID", "Nama Kandang", "Kapasitas", "Jumlah Ayam",
                "Jenis Ayam", "Pakan"
        );

        for (Kandang k : daftarKandang) {
            System.out.printf(
                    "%-5d %-15s %-10d %-12d %-15s %-15d%n",
                    k.getIdKandang(),
                    k.getNamaKandang(),
                    k.getKapasitas(),
                    k.getJumlahAyam(),
                    k.getJenisAyam(),
                    k.getPakanDibutuhkan()
            );
        }
    }

    private static void tampilJenisAyam() {
        System.out.println("\n=== DATA JENIS AYAM ===");

        System.out.printf(
                "%-5s %-20s %-15s%n",
                "ID", "Nama Jenis", "Umur Panen"
        );

        for (JenisAyam j : daftarJenisAyam) {
            System.out.printf(
                    "%-5d %-20s %-15d%n",
                    j.getIdJenisAyam(),
                    j.getNamaJenis(),
                    j.getUmurPanen()
            );
        }
    }

    private static void menuPakan() {
        int pilihan;

        do {
            System.out.println("\n=== MENU PAKAN ===");
            System.out.println("1. Tambah Pakan");
            System.out.println("2. Tampilkan Pakan");
            System.out.println("3. Ubah Pakan");
            System.out.println("4. Hapus Pakan");
            System.out.println("0. Kembali");

            pilihan = inputAngka("Pilih menu: ");

            switch (pilihan) {

                case 1:
                    tambahPakan();
                    break;

                case 2:
                    tampilPakan();
                    break;

                case 3:
                    ubahPakan();
                    break;

                case 4:
                    hapusPakan();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Menu tidak tersedia.");
            }

        } while (pilihan != 0);
    }

    private static void tambahPakan() {
        System.out.println("\n=== TAMBAH PAKAN ===");

        int id = inputAngka("ID Pakan: ");

        if (id <= 0) {
            System.out.println("ID harus lebih dari 0.");
            return;
        }

        System.out.print("Nama Pakan: ");
        String nama = input.nextLine();

        if (nama.isEmpty()) {
            System.out.println("Nama pakan tidak boleh kosong.");
            return;
        }

        int stok = inputAngka("Stok: ");

        if (stok < 0) {
            System.out.println("Stok tidak boleh negatif.");
            return;
        }

        daftarPakan.add(new Pakan(id, nama, stok));

        System.out.println("Pakan berhasil ditambahkan.");
    }

    private static void tampilPakan() {
        System.out.println("\n=== DATA PAKAN ===");

        System.out.printf(
                "%-5s %-20s %-10s%n",
                "ID", "Nama Pakan", "Stok"
        );

        for (Pakan p : daftarPakan) {
            System.out.printf(
                    "%-5d %-20s %-10d%n",
                    p.getIdPakan(),
                    p.getNamaPakan(),
                    p.getStok()
            );
        }
    }

    private static void ubahPakan() {
        System.out.println("\n=== UBAH PAKAN ===");

        int id = inputAngka("ID Pakan: ");

        for (Pakan p : daftarPakan) {

            if (p.getIdPakan() == id) {

                System.out.print("Nama Pakan Baru: ");
                String nama = input.nextLine();

                System.out.print("Stok Baru: ");
                int stok = inputAngka("");

                if (stok < 0) {
                    System.out.println("Stok tidak boleh negatif.");
                    return;
                }

                p.setNamaPakan(nama);
                p.setStok(stok);

                System.out.println("Pakan berhasil diubah.");
                return;
            }
        }

        System.out.println("Pakan tidak ditemukan.");
    }

    private static void hapusPakan() {
        System.out.println("\n=== HAPUS PAKAN ===");

        int id = inputAngka("ID Pakan: ");

        for (int i = 0; i < daftarPakan.size(); i++) {

            if (daftarPakan.get(i).getIdPakan() == id) {

                daftarPakan.remove(i);

                System.out.println("Pakan berhasil dihapus.");
                return;
            }
        }

        System.out.println("Pakan tidak ditemukan.");
    }

    private static void menuPemberian() {
        int pilihan;

        do {
            System.out.println("\n=== MENU PEMBERIAN PAKAN ===");
            System.out.println("1. Tambah");
            System.out.println("2. Tampilkan");
            System.out.println("3. Ubah");
            System.out.println("4. Hapus");
            System.out.println("0. Kembali");

            pilihan = inputAngka("Pilih menu: ");

            switch (pilihan) {

                case 1:
                    tambahPemberian();
                    break;

                case 2:
                    tampilPemberian();
                    break;

                case 3:
                    ubahPemberian();
                    break;

                case 4:
                    hapusPemberian();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Menu tidak tersedia.");
            }

        } while (pilihan != 0);
    }

    private static void tambahPemberian() {
        System.out.println("\n=== TAMBAH PEMBERIAN PAKAN ===");

        int id = inputAngka("ID Pemberian: ");

        if (id <= 0) {
            System.out.println("ID harus lebih dari 0.");
            return;
        }

        int jumlah = inputAngka("Jumlah Pakan: ");

        if (jumlah <= 0) {
            System.out.println("Jumlah harus lebih dari 0.");
            return;
        }

        System.out.print("Tanggal: ");
        String tanggal = input.nextLine();

        System.out.print("Waktu: ");
        String waktu = input.nextLine();

        daftarPemberian.add(
                new PemberianPakan(
                        id,
                        jumlah,
                        tanggal,
                        waktu
                )
        );

        System.out.println("Pemberian pakan berhasil ditambahkan.");
    }

    private static void tampilPemberian() {
        System.out.println("\n=== DATA PEMBERIAN PAKAN ===");

        System.out.printf(
                "%-5s %-15s %-15s %-10s%n",
                "ID", "Jumlah Pakan", "Tanggal", "Waktu"
        );

        for (PemberianPakan p : daftarPemberian) {
            System.out.printf(
                    "%-5d %-15d %-15s %-10s%n",
                    p.getIdPemberian(),
                    p.getJumlahPakan(),
                    p.getTanggalPemberian(),
                    p.getWaktuPemberian()
            );
        }
    }

    private static void ubahPemberian() {
        System.out.println("\n=== UBAH PEMBERIAN PAKAN ===");

        int id = inputAngka("ID Pemberian: ");

        for (PemberianPakan p : daftarPemberian) {

            if (p.getIdPemberian() == id) {

                int jumlah = inputAngka("Jumlah Pakan Baru: ");

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

    private static void hapusPemberian() {
        System.out.println("\n=== HAPUS PEMBERIAN PAKAN ===");

        int id = inputAngka("ID Pemberian: ");

        for (int i = 0; i < daftarPemberian.size(); i++) {

            if (daftarPemberian.get(i).getIdPemberian() == id) {

                daftarPemberian.remove(i);

                System.out.println("Data berhasil dihapus.");
                return;
            }
        }

        System.out.println("Data tidak ditemukan.");
    }

    private static void hitung() {

        int totalAyam = 0;
        int totalKapasitas = 0;
        int totalStok = 0;
        int totalPakan = 0;

        for (Kandang k : daftarKandang) {
            totalAyam += k.getJumlahAyam();
            totalKapasitas += k.getKapasitas();
        }

        for (Pakan p : daftarPakan) {
            totalStok += p.getStok();
        }

        for (PemberianPakan p : daftarPemberian) {
            totalPakan += p.getJumlahPakan();
        }

        System.out.println("\n=== PERHITUNGAN ===");
        System.out.println("Total Ayam       : " + totalAyam);
        System.out.println("Total Kapasitas  : " + totalKapasitas);
        System.out.println("Total Stok Pakan : " + totalStok);
        System.out.println("Total Pemberian  : " + totalPakan);
    }

    private static int inputAngka(String pesan) {

        while (true) {

            try {

                System.out.print(pesan);

                int angka = input.nextInt();
                input.nextLine();

                return angka;

            } catch (Exception e) {

                System.out.println("Input harus berupa angka.");
                input.nextLine();
            }
        }
    }
}