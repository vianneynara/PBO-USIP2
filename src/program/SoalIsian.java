package program;

public class SoalIsian extends SoalUjian {

    private JawabanTunggal kunciJawaban;
    private JawabanTunggal inputJawaban;

    public SoalIsian(String soal, JawabanTunggal kunciJawaban) {
        super(soal);
        this.kunciJawaban = kunciJawaban;
    }

    /* Getters */

    public JawabanTunggal getKunciJawaban() {
        return kunciJawaban;
    }

    public JawabanTunggal getInputJawaban() {
        return inputJawaban;
    }

    /* Setters */

    public void setKunciJawaban(JawabanTunggal kunciJawaban) {
        this.kunciJawaban = kunciJawaban;
    }

    public void setInputJawaban(JawabanTunggal inputJawaban) {
        this.inputJawaban = inputJawaban;
    }

    /**
     * Menyimpan masukan jawaban ke kelas.
     * @param jawaban jawaban yang berisi label dari kelas {@link JawabanTunggal}.
     * */
    public void simpanJawaban(JawabanTunggal jawaban) {
        inputJawaban = jawaban;
    }

    @Override
    public String getSoal() {
        return getPertanyaan();
    }
}