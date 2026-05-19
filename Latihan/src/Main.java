public class Main {
    public static void main(String[] args) {
        
        Dokter dok1 = new Dokter("Nopal", "Spesialis Anak");
        Dokter dok2 = new Dokter("Ruswan", "Spesialis Jantung");
        Dokter[] listDokterPusat = {dok1,dok2};

        Pasien pasien1 = new Pasien("Aldo",19);
        Pasien pasien2 = new Pasien("Paulus", 19);

        System.out.println("=== DEMONSTRASI INTERAKSI (BAGIAN 1) ===");
        dok1.periksaPasien(pasien1);
        dok2.periksaPasien(pasien2);
        System.out.println();

        System.out.println("=== PENDIRIAN RUMAH SAKIT (BAGIAN 2 & 3) ===");
        RumahSakit rsSehatSelalu = new RumahSakit("RS Sehat Selalu", "R-01", 15, "R-02", 20, listDokterPusat);
        rsSehatSelalu.cetakDaftarRuangan();
        rsSehatSelalu.cetakDaftarDokter();
        System.out.println();

        System.out.println("=== PENGUJIAN TERAKHIR: RUMAH SAKIT DIHANCURKAN ===");
        rsSehatSelalu = null;
        System.out.println("Objek rsSehatSelalu telah di-set menjadi null.");

        System.out.println("\nMembuktikan objek Dokter dari sistem pusat masih eksis:");
        dok1.cetakInfoDokter();
        dok2.cetakInfoDokter();
    }
    
}
