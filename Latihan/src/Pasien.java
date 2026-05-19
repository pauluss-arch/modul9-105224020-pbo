public class Pasien {
    private String nama;
    private int umur;

    public Pasien(String nama, int umur){
        this.nama = nama;
        this.umur = umur;
    }
    public void cetakIdentitas(){
        System.out.println("pasien bernama " + this.nama + " berumur " + this.umur + " tahun");
    }
}
