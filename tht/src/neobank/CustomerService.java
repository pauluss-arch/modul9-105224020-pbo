package neobank;

class CustomerService {
    private String namaCS;

    public CustomerService(String namaCS) {
        this.namaCS = namaCS;
    }

    public void terimaKeluhan(String namaNasabah, String isiKeluhan) {
        System.out.println("[CS " + this.namaCS + "] Menerima keluhan dari " + namaNasabah + ": \"" + isiKeluhan + "\"");
        System.out.println("[CS " + this.namaCS + "] Solusi: Laporan telah diteruskan ke tim teknis NeoBank.");
    }
}