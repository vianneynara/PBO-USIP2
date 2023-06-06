package program;

/**
 * Kelas abstrak soal ujian yang membagikan kesamaan atribut tipe-tipe soal dalam ujian.
 * */
public abstract class SoalUjian {
    
    protected String soal;

    /**
     *  Constructor utama.
     *  */
    public SoalUjian(String soal) {
        this.soal = soal;
    }

    /**
     * Mengembalikan hanya pertanyaan soal.
     * @return {@link String}
     * */
    public String getPertanyaan() {
        return soal;
    }

    /**
     * Metode untuk mendapatkan format soal yang menyesuaikan tipe soal sub-kelas {@link SoalUjian}:
     * <li>{@link SoalPilihanGanda}</li>
     * <li>{@link SoalIsian}</li>
     * <li>{@link SoalEsai}</li>
     * */
    public abstract String getSoal();
}


