package program;

/**
 * Kelas ini mengandung nama, fakultas, dan dosen dari sebuah mata kuliah.
 */
public class MataKuliah {
    private String nama;
    private String fakultas;

    /**
     * Constructor utama.
     * */
    public MataKuliah(String nama, String fakultas) {
        this.nama = nama;
        this.fakultas = fakultas;
    }

    /* Getters */

    public String getNama() {
        return nama;
    }

    public String getFakultas() {
        return fakultas;
    }
}
