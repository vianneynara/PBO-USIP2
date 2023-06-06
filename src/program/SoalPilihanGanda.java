package program;

public class SoalPilihanGanda extends SoalUjian {

    private JawabanTunggal[] pilihanJawaban;
    private JawabanTunggal kunciJawaban;
    private JawabanTunggal inputJawaban;

    public SoalPilihanGanda(String soal, JawabanTunggal[] pilihanJawaban, JawabanTunggal kunciJawaban) {
        super(soal);
        this.pilihanJawaban = pilihanJawaban;
        this.kunciJawaban = kunciJawaban;
    }

    /* Getters */

    public JawabanTunggal[] getPilihanJawaban() {
        return pilihanJawaban;
    }

    public JawabanTunggal getKunciJawaban() {
        return kunciJawaban;
    }

    public JawabanTunggal getInputJawaban() {
        return inputJawaban;
    }

    /* Setters */

    public void setPilihanJawaban(JawabanTunggal[] pilihanJawaban) {
        this.pilihanJawaban = pilihanJawaban;
    }

    public void setKunciJawaban(JawabanTunggal kunciJawaban) {
        this.kunciJawaban = kunciJawaban;
    }

    public void setInputJawaban(JawabanTunggal inputJawaban) {
        this.inputJawaban = inputJawaban;
    }

    /**
     * Mengembalikan string pilihan jawaban yang terdapat pada soal.
     * @return {@link String}
     * */
    public String getPilihan() {
        var sb = new StringBuilder();
        for (int i = 0; i < pilihanJawaban.length; i++) {
            sb.append("\t")
                    .append((char) ('A' + i))
                    .append(". ")
                    .append(pilihanJawaban[i]);
        }
        return sb.toString();
    }

    /**
     * Menyimpan masukan jawaban ke kelas.
     * @param jawaban jawaban yang berisi label dari kelas {@link JawabanTunggal}.
     * */
    public void simpanJawaban(JawabanTunggal jawaban) {
        inputJawaban = jawaban;
    }

    public String getSoal() {
        var sb = new StringBuilder();
        sb.append(soal).append("\n");
        char option = 65; // 65 adalah A.
        for (JawabanTunggal jawaban : pilihanJawaban)
            sb.append("\t")
                    .append(option++).append(". ")
                    .append(jawaban.getLabel()).append("\n");
        return sb.toString();
    }
}