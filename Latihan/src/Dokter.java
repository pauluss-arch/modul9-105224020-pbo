public class Dokter {
    private String nama;
    private String Spesialis;

    public Dokter (String nama , String Spesialis){
        this.nama = nama;
        this.Spesialis = Spesialis;
    }
    public void periksaPasien(Pasien pasien){
        System.out.print("Dokter " + this.nama + "(" + this.Spesialis + ") sedang memeriksa" );
        pasien.cetakIdentitas();
    }
    public void cetakInfoDokter(){
        System.out.println("-Dr. " + this.nama + "[" + this.Spesialis + "]");
    }
}
