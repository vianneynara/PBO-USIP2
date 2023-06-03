package program;

import java.util.*;
import java.util.stream.Stream;

public class Ujian {
    private SoalUjian[] listSoal;
    private MataKuliah mataKuliah;
    private Dosen dosen;
    private String namaUjian;
    private String semester;
    private Date tanggal;

    /* Constructor utama. */
    public Ujian(SoalUjian[] listSoal, MataKuliah mataKuliah, Dosen dosen, String namaUjian, String semester, Date tanggal) {
        this.listSoal = Stream.of(
             getSoalPilihanGanda(listSoal),
             getSoalIsian(listSoal),
             getSoalEsai(listSoal)
        )
        /* Mengkonversi Stream menjadi Array. */
        .flatMap(Arrays::stream)
        .toArray(SoalUjian[]::new);

        this.mataKuliah = mataKuliah;
        this.dosen = dosen;
        this.namaUjian = namaUjian;
        this.semester = semester;
        this.tanggal = tanggal;
    }

    /**
     * Mengembalikan soal bertipe {@link SoalPilihanGanda} dalam bentuk array dari list soal bertipe {@link SoalUjian}.
     * Proses dilakukan dengan mengiterasi setiap soal pada list soal dan dimasukkan ke dalam sebuah array.
     * @param listSoal list soal bertipe {@link SoalUjian}
     * @return Array of {@link SoalPilihanGanda}
     * */
    public static SoalPilihanGanda[] getSoalPilihanGanda(SoalUjian[] listSoal) {
        ArrayList<SoalPilihanGanda> soalPilihanGanda = new ArrayList<>();
        for (SoalUjian soal : listSoal)
            if (soal instanceof SoalPilihanGanda) soalPilihanGanda.add((SoalPilihanGanda) soal);
        return soalPilihanGanda.toArray(new SoalPilihanGanda[0]);
    }

    /**
     * Mengembalikan soal bertipe {@link SoalIsian} dalam bentuk array dari list soal bertipe {@link SoalUjian}.
     * Proses dilakukan dengan mengiterasi setiap soal pada list soal dan dimasukkan ke dalam sebuah array.
     * @param listSoal list soal bertipe {@link SoalUjian}
     * @return Array of {@link SoalIsian}
     * */
    public static SoalIsian[] getSoalIsian(SoalUjian[] listSoal) {
        ArrayList<SoalIsian> soalIsian = new ArrayList<>();
        for (SoalUjian soal : listSoal)
            if (soal instanceof SoalIsian) soalIsian.add((SoalIsian) soal);
        return soalIsian.toArray(new SoalIsian[0]);
    }

    /**
     * Mengembalikan soal bertipe {@link SoalEsai} dalam bentuk array dari list soal bertipe {@link SoalUjian}.
     * Proses dilakukan dengan mengiterasi setiap soal pada list soal dan dimasukkan ke dalam sebuah array.
     * @param listSoal list soal bertipe {@link SoalUjian}
     * @return Array of {@link SoalEsai}
     * */
    public static SoalEsai[] getSoalEsai(SoalUjian[] listSoal) {
        ArrayList<SoalEsai> soalEsai = new ArrayList<>();
        for (SoalUjian soal : listSoal)
            if (soal instanceof SoalEsai) soalEsai.add((SoalEsai) soal);
        return soalEsai.toArray(new SoalEsai[0]);
    }

    /**
     * Metode utama untuk menjalankan ujian.
     * */
    public void startUjian() {
        System.out.println("\t\t\t\t\tLEMBAR JAWAB MAHASISWA");
        System.out.println("--------------------------------------------------");
        System.out.println("Fakultas        : " + mataKuliah.getFakultas());
        System.out.println("Matakuliah      : " + mataKuliah.getNama());
        System.out.println("Nama dosen      : " + dosen.getNama());
        System.out.println("Semester        : " + semester);
        System.out.println("Hari / Tanggal  : " + tanggal);
        System.out.println("Nama ujian      : " + namaUjian);

        int amount = 0;    // menghitung jumlah soal

        /* Array indikator soal pertama*/
        boolean[] isFirst = new boolean[] {true, true, true};
        /* List soal sudah dianggap terurut: Pilihan ganda - Isian - Esai. */
        for (SoalUjian soal : listSoal) {
            /* Ujian Pilihan ganda. */
            if (soal instanceof SoalPilihanGanda pilgan) {
                if (isFirst[0]) {
                    System.out.println();
                    System.out.println("===================================================");
                    System.out.println("\t\t\t\t\tSoal Pilihan Ganda");
                    System.out.println("===================================================");
                    isFirst[0] = false;
                }
                System.out.printf("%02d. %s", ++amount, pilgan.getSoal());
                pilgan.jawab();
            }

            /* Ujian Isian. */
            if (soal instanceof SoalIsian isian) {
                if (isFirst[1]) {
                    System.out.println();
                    System.out.println("===================================================");
                    System.out.println("\t\t\t\t\tSoal Isian");
                    System.out.println("===================================================");
                    isFirst[1] = false;
                }
                System.out.printf("%02d. %s", ++amount, isian.getPertanyaan());
                isian.jawab();
            }

            /* Ujian Esai. */
            if (soal instanceof SoalEsai esai) {
                if (isFirst[2]) {
                    System.out.println();
                    System.out.println("===================================================");
                    System.out.println("\t\t\t\t\tSoal Esai");
                    System.out.println("===================================================");
                    isFirst[2] = false;
                }
                System.out.printf("%02d. %s", ++amount, esai.getPertanyaan());
                esai.jawab();
            }
        }
    }
}
