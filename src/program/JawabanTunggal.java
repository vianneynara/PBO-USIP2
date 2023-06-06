package program;

/**
 * Kelas jawaban ini berisi label dari sebuah jawaban. Bisa digunakan untuk soal pilihan ganda dan isian.
 * */
public class JawabanTunggal {

    private String label;

    /** Constructor jawaban soal ganda dan isian. */
    public JawabanTunggal(String label) {
        this.label = label;
    }

    /* Getter */
    public String getLabel() {
        return label;
    }

    /* Setter */
    public void setLabel(String label) {
        this.label = label;
    }
}
