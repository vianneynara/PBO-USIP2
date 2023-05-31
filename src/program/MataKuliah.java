package program;

/**
 * Kelas ini mengandung nama, fakultas, dan dosen dari sebuah mata kuliah.
 * */
public class MataKuliah {
    private String nama;
    private String fakultas;
    private Dosen dosen;

    /** Constructor utama. */
    public MataKuliah(String nama, String fakultas, Dosen dosen) {
        this.nama = nama;
        this.fakultas = fakultas;
        this.dosen = dosen;
    }

    /* Getters */

    public String getNama() {
        return nama;
    }

    public String getFakultas() {
        return fakultas;
    }

    public Dosen getDosen() {
        return dosen;
    }

    /* Setters */

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }

    public void setDosen(Dosen dosen) {
        this.dosen = dosen;
    }
}

/**
 * Kelas ini menyimpan data dari sebuah dosen yaitu nama dan NIP.
 * */
class Dosen {
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
