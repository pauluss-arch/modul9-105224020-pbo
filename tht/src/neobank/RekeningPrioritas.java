package neobank;

class RekeningPrioritas extends Rekening {
    private final double MINIMAL_TARIK = 500000;

    public RekeningPrioritas(String nomorRekening, String namaPemilik, double saldoAwal, String pin) {
        super(nomorRekening, namaPemilik, saldoAwal, pin);
    }

    @Override
    public void tarik(double jumlah) {
        if (jumlah < MINIMAL_TARIK) {
            System.out.println("[-] Transaksi Gagal! Akun Prioritas mensyaratkan minimal penarikan " + MINIMAL_TARIK);
            return;
        }
        if (ambilSaldo() >= jumlah) {
            ubahSaldo(ambilSaldo() - jumlah);
            ambilMutasi().catat("Penarikan Prioritas: -" + jumlah + " (Bebas Biaya Admin) | Saldo: " + ambilSaldo());
            System.out.println("[+] Penarikan khusus prioritas sukses.");
        } else {
            System.out.println("[-] Transaksi Gagal! Saldo akun prioritas tidak mencukupi.");
        }
    }
}