package program;

public class SoalEsai extends SoalUjian {

    JawabanEsai inputJawaban;

    public SoalEsai(String soal) {
        super(soal);
    }

    /* Getter */

    public JawabanEsai getInputJawaban() {
        return inputJawaban;
    }

    /* Setter */

    public void setInputJawaban(JawabanEsai inputJawaban) {
        this.inputJawaban = inputJawaban;
    }

    /**
     * Menyimpan masukan jawaban ke kelas.
     * @param inputJawaban input jawaban bertipe {@link JawabanEsai}.
     * */
    public void simpanJawaban(JawabanEsai inputJawaban) {
        this.inputJawaban = inputJawaban;
    }

    @Override
    public String getSoal() {
        return getPertanyaan();
    }
}