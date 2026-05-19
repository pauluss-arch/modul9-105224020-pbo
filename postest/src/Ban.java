class Ban {
    private String merk;
    private int ukuranRing;

    public Ban(String merk, int ukuranRing) {
        this.merk = merk;
        this.ukuranRing = ukuranRing;
    }
    public void cetakInfoBan(int indeks) {
        System.out.println("-Ban ke-" + indeks + ": " + this.merk + " (Ring " + this.ukuranRing + ")");
    }
}