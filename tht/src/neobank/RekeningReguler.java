package neobank;

class RekeningReguler extends Rekening {
    private final double BIAYA_ADMIN = 5000;

    public RekeningReguler(String nomorRekening, String namaPemilik, double saldoAwal, String pin) {
        super(nomorRekening, namaPemilik, saldoAwal, pin);
    }

    @Override
    public void tarik(double jumlah) {
        double totalTagihan = jumlah + BIAYA_ADMIN;
        if (jumlah <= 0) {
            System.out.println("[-] Jumlah penarikan tidak valid!");
            return;
        }
        if (ambilSaldo() >= totalTagihan) {
            ubahSaldo(ambilSaldo() - totalTagihan);
            ambilMutasi().catat("Penarikan Reguler: -" + jumlah + " (Biaya Admin: -" + BIAYA_ADMIN + ") | Saldo: " + ambilSaldo());
            System.out.println("[+] Penarikan berhasil dilakukan.");
        } else {
            System.out.println("[-] Transaksi Gagal! Saldo tidak mencukupi untuk penarikan + biaya admin.");
        }
    }
}