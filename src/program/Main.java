package program;

import java.util.Scanner;

public class Main {

    public static void ujian() {
        Scanner scanner = new Scanner(System.in);
        MataKuliah matkul = new MataKuliah("Fakultas Sains dan Teknologi", "PBO", "Ibu Tatik", "2", "Senin, 27 Mei 2023");

        System.out.println("\t\t\t\t\tLEMBAR JAWAB MAHASISWA");
        System.out.println("--------------------------------------------------");
        System.out.println(matkul.getFakultas());
        System.out.println("Matakuliah      : " + matkul.getNama());
        System.out.println("Nama dosen      : " + matkul.getDosen());
        System.out.println("Semester        : " + matkul.getSemester());
        System.out.println("Hari / Tanggal  : " + matkul.getTanggal());
        System.out.println();
        System.out.println("===================================================");
        System.out.println("\t\t\t\t\tPilihan Ganda");
        System.out.println("===================================================");

        Jawaban jawabanGanda1 = new Jawaban("Jakarta");
        Jawaban jawabanGanda2 = new Jawaban("Kaya");
        SoalPilihanGanda[] soalPilgan = new SoalPilihanGanda[2];
        soalPilgan[0] = new SoalPilihanGanda("Apa ibu kota Indonesia?", new String[]{"Jakarta", "Bandung", "Surabaya", "Medan"}, jawabanGanda1);
        soalPilgan[1] = new SoalPilihanGanda("Hemat Pangkal?", new String[]{"Miskin", "Kaya", "Sederhana", "Susah"}, jawabanGanda2);

        // Tampilkan soal-soal pilihan ganda
        for (int i = 0; i < soalPilgan.length; i++) {
            System.out.println("Nomor " + (i + 1));
            soalPilgan[i].tampilkanSoal();
            soalPilgan[i].tampilkanJawaban();
            soalPilgan[i].tampilan();
            System.out.println();
        }
        System.out.println("===================================================");
        System.out.println("\t\t\t\t\t\tIsian");
        System.out.println("===================================================");

        Jawaban jawabanIsian1 = new Jawaban("Jakarta");
        SoalIsian[] soalIsian = new SoalIsian[10];
        System.out.println("Nomor 1.");
        soalIsian[0] = new SoalIsian("Apa ibu kota Indonesia?", jawabanIsian1);
        System.out.println(soalIsian[0].getPertanyaan());
        soalIsian[0].tampilan();
        System.out.println();

        System.out.println("===================================================");
        System.out.println("\t\t\t\t\tEsai");
        System.out.println("===================================================");
        SoalEsai[] SoalEsai = new SoalEsai[5];
        System.out.println("Nomor 1.");
        SoalEsai[0] = new SoalEsai("Jelaskan Sejarah Kemerdekaan Indonesia", "sejarah.pdf", "https://www.example.com/sejarah.pdf");
        SoalEsai[0].tampilan();}

    public static void main(String[] args) {
        ujian();
    }
}
