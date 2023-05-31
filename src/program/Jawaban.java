package program;

/**
 * Kelas jawaban ini berisi label dari sebuah jawaban. Bisa digunakan untuk soal pilihan ganda dan isian.
 * */
public class Jawaban {
    private String label;

    /** Constructor utama. */
    public Jawaban(String label) {
        this.label = label;
    }

    /* Getters / Setters */

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
