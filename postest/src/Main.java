public class Main {
    public static void main(String[] args) {
        
        System.out.println("---1. Penciptaan 4 Ban Secara Mandiri ---");
        Ban ban1 = new Ban("Aldo", 17);
        Ban ban2 = new Ban("Aldo", 17);
        Ban ban3 = new Ban("Aldo", 17);
        Ban ban4 = new Ban("Aldo", 17);
        Ban[] setBanMobil = {ban1, ban2, ban3, ban4};
        System.out.println("4 Ban berhasil diproduksi terpisah di pabrik komponen.\n");

        System.out.println("---2. Pembentukan 1 Unit Mobil & Pemasangan Ban ---");
        Mobil mobilGagal = new Mobil("GTR R35", "Hitam", "AXYZ123", 5000);
        mobilGagal.pasangSetBan(setBanMobil);
        System.out.println("Mobil selesai dirakit dan ban telah dipasang.\n");

        System.out.println("---3. Proses Inspeksi oleh Montir ---");
        Montir montirEko = new Montir("MTR-007", "Opal");
        montirEko.lakukanQualityControl(mobilGagal);
        System.out.println();

        System.out.println("---4. Skenario Selesai: Mobil Gagal Uji & Dihancurkan ---");
        mobilGagal = null;
        System.out.println("Objek mobilGagal telah di-set menjadi null.");

        System.out.println("\n---5. Bukti Fisik di Memori ---");
        System.out.println("Memanggil salah satu objek ban setelah mobil lebur:");
        ban1.cetakInfoBan(1); 
        // Objek ban1 tetap bisa diakses karena referensinya masih dipegang oleh scope main method
    
    }
}