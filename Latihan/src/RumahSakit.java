class RumahSakit {
    private String namaRS;
    private Ruangan[] daftarRuangan;
    private Dokter[] daftarDokter;

    public RumahSakit(String namaRS, String noReg1, int kap1, String noReg2, int kap2, Dokter[] dokterDariPusat){
        this.namaRS = namaRS;

        this.daftarRuangan = new Ruangan[2];
        this.daftarRuangan[0] = new Ruangan (noReg1,kap1);
        this.daftarRuangan[1] = new Ruangan (noReg2,kap2);

        this.daftarDokter = dokterDariPusat;
    }
    public void cetakDaftarRuangan(){
        System.out.println("Daftar Ruangan di " + this.namaRS + ":");
        for( int i=0; i < daftarRuangan.length; i++){
            if( daftarRuangan[i] != null){
                daftarRuangan[i].cetakRuangan();
            }
        }
    }
    public void cetakDaftarDokter(){
        System.out.println("Daftar Dokter yang bertugas di " + this.namaRS + ":");
        for( int i=0; i < daftarDokter.length; i++){
            if( daftarDokter[i] != null){
                daftarDokter[i].cetakInfoDokter();
            }
        }
    }

}