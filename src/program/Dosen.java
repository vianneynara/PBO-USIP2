package program;

/**
 * Kelas ini menyimpan data dari sebuah dosen yaitu nama dan NIP.
 * */
public class Dosen {
    private String nama;
    private String NIP;

    /** Constructor utama. */
    public Dosen(String nama, String NIP) {
        this.nama = nama;
        this.NIP = NIP;
    }

    /* Getters / Setters */

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNIP() {
        return NIP;
    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
    }
}