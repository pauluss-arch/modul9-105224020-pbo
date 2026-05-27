package neobank;

abstract class Rekening implements Otorisasi {
    private String nomorRekening;
    private String namaPemilik;
    private double saldo;
    private String pin;
    private final BukuMutasi mutasi;

    public Rekening(String nomorRekening, String namaPemilik, double saldoAwal, String pin) {
        this.nomorRekening = nomorRekening;
        this.namaPemilik = namaPemilik;
        this.saldo = saldoAwal;
        this.pin = pin;
        this.mutasi = new BukuMutasi();
        this.mutasi.catat("Rekening berhasil dibuka dengan saldo awal: " + saldoAwal);
    }

    @Override
    public boolean verifikasiPIN(String pinInput) {
        return this.pin.equals(pinInput);
    }

    public void setor(double jumlah) {
        if (jumlah > 0) {
            this.saldo += jumlah;
            this.mutasi.catat("Setoran berhasil: +" + jumlah + " | Saldo saat ini: " + this.saldo);
        } else {
            System.out.println("[-] Jumlah setoran harus valid!");
        }
    }

    public abstract void tarik(double jumlah);

    public double ambilSaldo() { 
        return this.saldo; 
    }
    
    public void ubahSaldo(double saldoBaru) { 
        this.saldo = saldoBaru; 
    }
    
    public BukuMutasi ambilMutasi() { 
        return this.mutasi; 
    }
    
    public String ambilNomor() { 
        return this.nomorRekening; 
    }
}