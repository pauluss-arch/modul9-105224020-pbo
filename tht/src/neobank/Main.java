package neobank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Nasabah profilNasabah = null;
        CustomerService csNeo = new CustomerService("Siska");
        
        System.out.println("=== SELAMAT DATANG DI BACKEND PROTOTYPE NEOBANK ===");
        int pilihan;

        do {
            System.out.println("\n--- MENU UTAMA SYSTEM ---");
            System.out.println("1. Registrasi Profil Nasabah");
            System.out.println("2. Buka Rekening Baru (Maks 3)");
            System.out.println("3. Simulasi Transaksi (Setor/Tarik)");
            System.out.println("4. Hubungi Customer Service (Asosiasi)");
            System.out.println("5. Keluar & Simulasi Hancurkan Akun Paksa");
            System.out.print("Pilih opsi menu: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Nama Nasabah: ");
                    String nama = input.nextLine();
                    System.out.print("Masukkan NIK: ");
                    String nik = input.nextLine();
                    profilNasabah = new Nasabah(nama, nik);
                    System.out.println("[+] Profil Nasabah berhasil didaftarkan ke sistem pusat.");
                    break;

                case 2:
                    if (profilNasabah == null) {
                        System.out.println("[-] Silakan registrasi profil nasabah terlebih dahulu di Menu 1!");
                        break;
                    }
                    System.out.print("Masukkan Nomor Rekening Baru: ");
                    String noRek = input.nextLine();
                    System.out.print("Setoran Awal: ");
                    double setoranAwal = input.nextDouble();
                    System.out.print("Set PIN Keamanan (Angka/Teks): ");
                    input.nextLine();
                    String pin = input.nextLine();
                    
                    System.out.println("Pilih Jenis Rekening:");
                    System.out.println("a. Rekening Reguler (Biaya Admin 5.000 tiap tarik)");
                    System.out.println("b. Rekening Prioritas (Bebas Admin, Min Tarik 500.000)");
                    System.out.print("Pilihan (a/b): ");
                    String jenis = input.nextLine();

                    Rekening rekBaru = null;
                    if (jenis.equalsIgnoreCase("a")) {
                        rekBaru = new RekeningReguler(noRek, profilNasabah.ambilNama(), setoranAwal, pin);
                    } else if (jenis.equalsIgnoreCase("b")) {
                        rekBaru = new RekeningPrioritas(noRek, profilNasabah.ambilNama(), setoranAwal, pin);
                    } else {
                        System.out.println("[-] Pilihan tidak valid, pembatalan sistem.");
                        break;
                    }

                    if (profilNasabah.bukaRekening(rekBaru)) {
                        System.out.println("[+] Rekening berhasil ditautkan ke profil Anda.");
                    } else {
                        System.out.println("[-] Gagal! Anda telah mencapai batas maksimal kepemilikan 3 rekening.");
                    }
                    break;

                case 3:
                    if (profilNasabah == null) {
                        System.out.println("[-] Silakan masuk/registrasi terlebih dahulu!");
                        break;
                    }
                    System.out.print("Masukkan Nomor Rekening Tujuan Transaksi: ");
                    String targetRek = input.nextLine();
                    Rekening akunAktif = profilNasabah.aksesRekening(targetRek);

                    if (akunAktif == null) {
                        System.out.println("[-] Nomor rekening tidak ditemukan pada profil ini!");
                        break;
                    }

                    System.out.print("Masukkan PIN Verifikasi Akun: ");
                    String inputPin = input.nextLine();
                    if (!akunAktif.verifikasiPIN(inputPin)) {
                        System.out.println("[-] PIN SALAH! Akses Transaksi Ditolak Sistem.");
                        break;
                    }

                    System.out.println("\n--- AKSES DIIZINKAN ---");
                    System.out.println("1. Setor Tunai");
                    System.out.println("2. Tarik Tunai (Polimorfisme)");
                    System.out.print("Pilih opsi transaksi: ");
                    int tkn = input.nextInt();
                    
                    if (tkn == 1) {
                        System.out.print("Jumlah Setor: ");
                        double jmlSetor = input.nextDouble();
                        akunAktif.setor(jmlSetor);
                    } else if (tkn == 2) {
                        System.out.print("Jumlah Tarik: ");
                        double jmlTarik = input.nextDouble();
                        akunAktif.tarik(jmlTarik);
                    } else {
                        System.out.println("[-] Opsi transaksi tidak dikenali.");
                    }
                    break;

                case 4:
                    if (profilNasabah == null) {
                        System.out.println("[-] Buat profil terlebih dahulu.");
                        break;
                    }
                    System.out.print("Tuliskan Keluhan Anda untuk CS Siska: ");
                    String keluhan = input.nextLine();
                    profilNasabah.laporkanMasalah(csNeo, keluhan);
                    break;

                case 5:
                    System.out.println("[!] Menutup aplikasi dan mengeksekusi simulasi penutupan akun...");
                    break;
                default:
                    System.out.println("[-] Menu tidak tersedia.");
            }
        } while (pilihan != 5);

        System.out.println("\n=======================================================");
        System.out.println("MENGHANCURKAN REFERENSI PROFIL NASABAH (PROFIL = NULL)");
        System.out.println("=======================================================");
        
        Rekening dataRekeningTerpisah = null;
        if (profilNasabah != null && profilNasabah.ambilArrayRekening()[0] != null) {
            dataRekeningTerpisah = profilNasabah.ambilArrayRekening()[0];
        }

        profilNasabah = null; 
        System.out.println("[+] Objek 'profilNasabah' resmi diputus hubungannya (Set to null).");

        if (dataRekeningTerpisah != null) {
            System.out.println("\n>>> HASIL ANALISIS SIKLUS HIDUP OBJEK <<<");
            System.out.println("1. AGREGASI: Objek Rekening tetap hidup di memori bank pusat.");
            System.out.println("   Nomor Rekening yang terselamatkan: " + dataRekeningTerpisah.ambilNomor());
            System.out.println("2. KOMPOSISI: Objek 'BukuMutasi' terisolasi penuh di dalam Rekening.");
            System.out.println("   Jika objek Rekening ini ikut dihancurkan, log mutasi otomatis musnah total.");
        } else {
            System.out.println("\n[!] Simulasi analisis selesai: Tidak ada rekening yang sempat dibuka sebelumnya.");
        }
        System.out.println("=======================================================");
        input.close();
    }
}