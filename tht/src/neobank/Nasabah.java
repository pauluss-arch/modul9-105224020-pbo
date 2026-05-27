package neobank;

class Nasabah {
    private String namaNasabah;
    private String nik;
    private Rekening[] daftarRekening;
    private int jumlahRekening;

    public Nasabah(String namaNasabah, String nik) {
        this.namaNasabah = namaNasabah;
        this.nik = nik;
        this.daftarRekening = new Rekening[3];
        this.jumlahRekening = 0;
    }

    public boolean bukaRekening(Rekening rek) {
        if (this.jumlahRekening < 3) {
            this.daftarRekening[this.jumlahRekening] = rek;
            this.jumlahRekening++;
            return true;
        }
        return false;
    }

    public void laporkanMasalah(CustomerService cs, String keluhan) {
        cs.terimaKeluhan(this.namaNasabah, keluhan);
    }

    public Rekening aksesRekening(String noRek) {
        for (int i = 0; i < this.jumlahRekening; i++) {
            if (this.daftarRekening[i].ambilNomor().equals(noRek)) {
                return this.daftarRekening[i];
            }
        }
        return null;
    }

    public String ambilNama() { 
        return this.namaNasabah; 
    }
    
    public Rekening[] ambilArrayRekening() { 
        return this.daftarRekening; 
    }
}