package program;

import java.util.*;
import java.util.stream.Stream;

/**
 * Menyimpan data mengenai sebuah ujian.
 * */
public class Ujian {

    private SoalUjian[] listSoal;
    private MataKuliah mataKuliah;
    private Dosen dosen;
    private String namaUjian;
    private String semester;
    private String tanggal;

    /** Constructor utama. */
    public Ujian(SoalUjian[] listSoal, MataKuliah mataKuliah, Dosen dosen, String namaUjian, String semester, String tanggal) {
        this.listSoal = Stream.of(
             UjianUtility.getSoalPilihanGanda(listSoal),
             UjianUtility.getSoalIsian(listSoal),
             UjianUtility.getSoalEsai(listSoal)
        )
        /* Mengkonversi Stream menjadi Array bertipe SoalUjian. */
        .flatMap(Arrays::stream)
        .toArray(SoalUjian[]::new);

        this.mataKuliah = mataKuliah;
        this.dosen = dosen;
        this.namaUjian = namaUjian;
        this.semester = semester;
        this.tanggal = tanggal;
    }

    /** Getters */

    public SoalUjian[] getListSoal() {
        return listSoal;
    }

    public MataKuliah getMataKuliah() {
        return mataKuliah;
    }

    public Dosen getDosen() {
        return dosen;
    }

    public String getNamaUjian() {
        return namaUjian;
    }

    public String getSemester() {
        return semester;
    }

    public String getTanggal() {
        return tanggal;
    }

    /** Setters */

    public void setListSoal(SoalUjian[] listSoal) {
        this.listSoal = listSoal;
    }

    public void setMataKuliah(MataKuliah mataKuliah) {
        this.mataKuliah = mataKuliah;
    }

    public void setDosen(Dosen dosen) {
        this.dosen = dosen;
    }

    public void setNamaUjian(String namaUjian) {
        this.namaUjian = namaUjian;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}
