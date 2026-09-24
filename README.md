# MINPRO 2 Sistem Manajemen Peternakan Ayam

```text
「---------------------------------------------\
 | Nama : Dhiyya Rizky Akhmad Wijaya           |
 | NIM  : 2509116048                           |
 \---------------------------------------------」
```

---

## Deskripsi Singkat Program

Sistem Manajemen Peternakan Ayam merupakan program berbasis Java yang digunakan untuk mengelola data sederhana pada peternakan ayam. Program dijalankan melalui Command Line Interface (CLI).

Program memiliki beberapa data, yaitu data kandang, jenis ayam, pakan, dan pemberian pakan. Data kandang dan jenis ayam merupakan data awal yang dapat ditampilkan, sedangkan data pakan dan pemberian pakan dapat dikelola menggunakan fitur tambah, tampil, ubah, dan hapus.

Program juga memiliki menu perhitungan untuk menghitung total ayam, total kapasitas kandang, total stok pakan, dan total pemberian pakan.

## Alur Program

Saat program dijalankan, sistem akan menampilkan menu utama:

    1. Data Kandang
    2. Data Jenis Ayam
    3. Data Pakan
    4. Data Pemberian Pakan
    5. Perhitungan
    0. Keluar

Alur program:

1. Program menjalankan class Main.
2. Program membuat data awal jenis ayam, kandang, pakan, dan pemberian pakan.
3. Program menampilkan menu utama.
4. Pengguna memilih menu yang tersedia.
5. Jika memilih Data Kandang, program menampilkan data kandang.
6. Jika memilih Data Jenis Ayam, program menampilkan data jenis ayam.
7. Jika memilih Data Pakan, pengguna dapat menambah, melihat, mengubah, dan menghapus data pakan.
8. Jika memilih Data Pemberian Pakan, pengguna dapat menambah, melihat, mengubah, dan menghapus data pemberian pakan.
9. Jika memilih Perhitungan, program menghitung total ayam, total kapasitas, total stok pakan, dan total pemberian pakan.
10. Program kembali ke menu utama setelah proses selesai.
11. Program berhenti ketika pengguna memilih menu 0.

## Penerapan Encapsulation

Encapsulation diterapkan dengan membuat atribut pada setiap class menggunakan access modifier private.

Contohnya pada class Pakan:
```java
    private int idPakan;
    private String namaPakan;
    private int stok;
```
Atribut tersebut tidak dapat diakses secara langsung dari luar class. Untuk mengambil data digunakan method getter.

Contoh:
```java
    public int getStok() {
        return stok;
    }
```
Untuk mengubah data digunakan method setter.

Contoh:
```java
    public void setStok(int stok) {
        this.stok = stok;
    }
```
Penerapan encapsulation juga terdapat pada class JenisAyam, Kandang, dan PemberianPakan. Dengan cara ini, data di dalam object dapat diakses dan diubah melalui method yang sudah disediakan.

## Penerapan Inheritance

Inheritance diterapkan dengan menggunakan class JenisAyam sebagai class induk.

Class Kandang menggunakan inheritance dengan:
```java
    public class Kandang extends JenisAyam
```
Class Pakan juga menggunakan inheritance dengan:
```java
    public class Pakan extends JenisAyam
```
Kedua class tersebut menggunakan constructor dari class induk melalui keyword super.

Pada class Kandang:
```java
    super(idKandang, jenisAyam, 1);
```
Pada class Pakan:
```java
    super(idPakan, namaPakan, 1);
```
Dengan penerapan tersebut, class Kandang dan Pakan menjadi turunan dari class JenisAyam.

## Penerapan Nilai Tambah

Nilai tambah pada program diterapkan dalam bentuk fitur CRUD dan perhitungan data.

### 1. CRUD Data Pakan

Pada menu Data Pakan terdapat fitur:

- Tambah data
- Tampilkan data
- Ubah data
- Hapus data

Fitur ini terdapat pada method:
```java
- tambahPakan()
- tampilPakan()
- ubahPakan()
- hapusPakan()
```
Data pakan disimpan menggunakan ArrayList.

```java
    static ArrayList<Pakan> pakan = new ArrayList<>();
```

### 2. CRUD Data Pemberian Pakan

Pada menu Data Pemberian Pakan juga terdapat fitur:

- Tambah data
- Tampilkan data
- Ubah data
- Hapus data

Fitur ini terdapat pada method:

```java
- tambahPemberian()
- tampilPemberian()
- ubahPemberian()
- hapusPemberian()
```

Data pemberian pakan disimpan menggunakan ArrayList.

```java
    static ArrayList<PemberianPakan> pemberian = new ArrayList<>();
```

### 3. Perhitungan Data

Program memiliki menu Perhitungan yang digunakan untuk menghitung:

- Total Ayam
- Total Kapasitas Kandang
- Total Stok Pakan
- Total Pemberian Pakan

Perhitungan dilakukan pada method:

```java
    perhitungan()
```

Perhitungan menggunakan perulangan untuk mengambil data dari ArrayList dan menjumlahkan nilai yang tersedia.

## Struktur Class

    Main
    │
    ├── JenisAyam
    │
    ├── Kandang extends JenisAyam
    │
    ├── Pakan extends JenisAyam
    │
    └── PemberianPakan

## Teknologi yang Digunakan

- Java
- Apache NetBeans
- Maven
- ArrayList
- Scanner
- Command Line Interface (CLI)

## File Program
```java
    JenisAyam.java
    Kandang.java
    Pakan.java
    PemberianPakan.java
    Main.java
```

## Screenshot menu

### Menu Utama

<img width="198" height="92" alt="image" src="https://github.com/user-attachments/assets/e18959cd-b780-4dd4-9d3b-970c722348e2" />

Saat melakukan run pada program akan muncul menu utama berisi semua fitur yang bisa digunakan peternak

### Data Kandang

<img width="323" height="67" alt="image" src="https://github.com/user-attachments/assets/ae93d8a9-6ee0-48a4-bc91-a2ab52abc8cd" />

Di menu 1 peternak bisa melihat data kandang yang ada di peternakan. Data berisi id kandang, nama kandang, kapasitas, jumlah ayam, jenis ayam di dalam kandang, dan berapa KG pakan yang dibutuhkan oleh kandang tersebut

### Data Jenis Ayam
<img width="178" height="63" alt="image" src="https://github.com/user-attachments/assets/34c2dde7-afc8-4549-add8-4527a6427b20" />

Di menu 2 peternak bisa melihat jenis ayam yang bisa digunakan di peternakan

### Data Pakan

<img width="117" height="66" alt="image" src="https://github.com/user-attachments/assets/a3f0cef1-11be-4e7d-9ad6-2c6ae3a3189c" />

Di menu 3 peternak bisa melihat, menambahkan, menghapus, dan mengedit data pakan

<img width="134" height="80" alt="image" src="https://github.com/user-attachments/assets/0ff10191-6a3a-4e79-b0ee-97bcabef2eca" />

Jika memilih menu 1 maka peternak bisa menambahkan id, nama, dan stok dari pakan baru

<img width="149" height="80" alt="image" src="https://github.com/user-attachments/assets/6397eb86-73c5-446e-9524-3b5888abb448" />

Jika memilih menu 2 maka peternak bisa melihat pakan apa saja yang dimiliki dan stoknya

<img width="130" height="74" alt="image" src="https://github.com/user-attachments/assets/5040f6b7-f266-47bd-a36e-1fc0e056797d" />

Jika terjadi kesalahan menginput saat menambahkan pakan peternak bisa memilih menu 3 untuk mengubah data pakan yang sudah ada

<img width="110" height="56" alt="image" src="https://github.com/user-attachments/assets/5c36a379-dab7-4d6c-98df-e81d6746ba43" />
Jika peternak merasa sudah tidak ingin menggunakan suatu pakan maka bisa memilih menu 4 untuk menghapus pakan yang tidak diinginkan

### Data Pemberian Pakan

<img width="129" height="83" alt="image" src="https://github.com/user-attachments/assets/db3fec62-446a-43b7-86f9-0e6af1da1887" />

Di menu 4 peternak bisa melihat, menambahkan, menghapus, dan mengedit data pemberian pakan ayam

<img width="143" height="83" alt="image" src="https://github.com/user-attachments/assets/4b0f8ea9-4758-4258-b459-66a58278b4ea" />

Jika memilih menu 1, peternak bisa menambahkan data pemberian pakan yang sudah dilakukan

<img width="209" height="77" alt="image" src="https://github.com/user-attachments/assets/420ebc89-f58b-4a30-bafb-336645394beb" />

Jika memilih menu 2, peternak bisa melihat data pemberian pakan yang sudah dilakukan

<img width="146" height="86" alt="image" src="https://github.com/user-attachments/assets/b29cad4c-75ab-42a4-aac9-50d8c2152443" />

Jika terjadi kesalahan menginput, peternak bisa memilih menu 3 untuk mengupdate data yang salah

<img width="137" height="56" alt="image" src="https://github.com/user-attachments/assets/25c3ba96-b35f-4e41-8946-24a9630fa5fe" />

(Berbahaya) Jika terjadi input data fiktif, peternak bisa memilih 4 untuk menghapus data yang palsu

### Perhitungan

<img width="121" height="77" alt="image" src="https://github.com/user-attachments/assets/57ee2a0f-9885-4b2a-995a-88055022ecf9" />

Terakhir di menu 5 peternak bisa melihat total dari seluruh ayam, kapasitas kandang, stok pakan, dan total pemberian pakan yang sudah diberikan
