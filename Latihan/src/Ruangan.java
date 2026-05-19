public class Ruangan {
    private String nomorRegistrasi;
    private int kapasitasMaksimal;

    public Ruangan(String nomorRegistrasi, int kapasitasMaksimal){
        this.nomorRegistrasi = nomorRegistrasi;
        this.kapasitasMaksimal = kapasitasMaksimal;
    }

    public void cetakRuangan(){
        System.out.println("- ruangan " + this.nomorRegistrasi + "(kapasitas maksimal " + this.kapasitasMaksimal + ")" );
    }
}
