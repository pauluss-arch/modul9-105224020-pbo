class Mesin {
    private String nomorSeri;
    private int kapasitasCC;

    public Mesin(String nomorSeri, int kapasitasCC) {
        this.nomorSeri = nomorSeri;
        this.kapasitasCC = kapasitasCC;
    }

    public void cetakInfoMesin() {
        System.out.println("-Mesin: No Seri " + this.nomorSeri + " (" + this.kapasitasCC + " CC)");
    }
}