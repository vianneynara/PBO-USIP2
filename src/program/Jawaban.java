package program;

/**
 * Kelas jawaban ini berisi label dari sebuah jawaban. Bisa digunakan untuk soal pilihan ganda dan isian.
 * */
public class Jawaban {
    
    private String namaFile;
    private String linkFile;
    private String label;

    /** Constructor jawaban soal ganda dan isian. */
    public Jawaban(String label) {
        this.label = label;
    }

    /** Constructor jawaban soal esai. */
    public Jawaban(String namaFile, String linkFile) {
        this.namaFile = namaFile;
        this.linkFile = linkFile;
    }

    /* Getters / Setters */

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getNamaFile() {
        return namaFile;
    }

    public void setNamaFile(String namaFile) {
        this.namaFile = namaFile;
    }

    public String getLinkFile() {
        return linkFile;
    }

    public void setLinkFile(String linkFile) {
        this.linkFile = linkFile;
    }

    @Override
    public String toString() {
        return label;
    }
}
