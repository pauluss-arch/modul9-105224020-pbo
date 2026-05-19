class Mobil {
    private String merkMobil;
    private String warna;
    private Mesin mesin;
    private Ban[] daftarBan;

    public Mobil(String merkMobil, String warna, String noSeriMesin, int ccMesin) {
        this.merkMobil = merkMobil;
        this.warna = warna;
        this.mesin = new Mesin(noSeriMesin, ccMesin);
        this.daftarBan = new Ban[4];
    }
    public void pasangSetBan(Ban[] setBan) {
        for (int i = 0; i < this.daftarBan.length; i++) {
            if (i < setBan.length) {
                this.daftarBan[i] = setBan[i];
            }
        }
    }
    public void tampilkanSpesifikasi() {
        System.out.println("Spesifikasi Mobil " + this.merkMobil + " (" + this.warna + "):");
        if (this.mesin != null) {
            this.mesin.cetakInfoMesin();
        }
        System.out.println("-Detail Ban terpasang:");
        for (int i = 0; i < this.daftarBan.length; i++) {
            if (this.daftarBan[i] != null) {
                this.daftarBan[i].cetakInfoBan(i + 1);
            }
        }
    }
}