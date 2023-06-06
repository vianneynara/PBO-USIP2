package program;

import java.util.Scanner;

public class Main {
    
    private static final Scanner sc = new Scanner(System.in);    
    
    /**
     * Metode untuk menampilkan pemasukkan soal pilihan ganda.
     * @return {@link SoalPilihanGanda}
     * */
    public static SoalPilihanGanda inputSoalPilihanGanda() {
        System.out.print("Pertanyaan    : ");
        var pertanyaan = sc.nextLine();
        int jmlPilihan;
        do {
            System.out.print("Jumlah pilihan: ");
            jmlPilihan = sc.nextInt();
        } while (jmlPilihan < 1 || jmlPilihan > 5);
        sc.nextLine();  // Makan sisa input.

        JawabanTunggal[] listPilihan = new JawabanTunggal[jmlPilihan];
        for (int i = 0; i < jmlPilihan; i++) {
            System.out.printf("\nPilihan %d: ", i + 1);
            listPilihan[i] = new JawabanTunggal(sc.nextLine());
        }

        int nomorKunci;
        do {
            System.out.print("Kunci jawaban (masukkan nomor pilihan): ");
            nomorKunci = sc.nextInt() - 1;
        } while (nomorKunci < 0 || nomorKunci >= jmlPilihan);
        sc.nextLine();  // Makan sisa input.

        return new SoalPilihanGanda(
                pertanyaan,
                listPilihan,
                listPilihan[nomorKunci]
        );
    }

    /**
     * Metode untuk menampilkan pemasukkan soal isian.
     * @return {@link SoalIsian}
     * */
    public static SoalIsian inputSoalIsian() {
        System.out.print("Pertanyaan    : ");
        var pertanyaan = sc.nextLine();

        System.out.print("Kunci jawaban: ");
        var kunciJawaban = sc.nextLine();

        return new SoalIsian(
                pertanyaan,
                new JawabanTunggal(kunciJawaban)
        );
    }

    /**
     * Metode untuk menampilkan pemasukkan soal esai.
     * @return {@link SoalEsai}
     * */
    public static SoalEsai inputSoalEsai() {
        System.out.print("Pertanyaan    : ");
        var pertanyaan = sc.nextLine();

        return new SoalEsai(
                pertanyaan
        );
    }


    /**
     * Metode utama untuk menjalankan ujian.
     * */
    public static void mulaiUjian(Ujian ujian) {
        System.out.println("\t\t\t  LEMBAR JAWAB MAHASISWA");
        System.out.println("--------------------------------------------------");
        System.out.println("Fakultas        : " + ujian.getMataKuliah().getFakultas());
        System.out.println("Matakuliah      : " + ujian.getMataKuliah().getNama());
        System.out.println("Nama dosen      : " + ujian.getDosen().getNama());
        System.out.println("Semester        : " + ujian.getSemester());
        System.out.println("Hari / Tanggal  : " + ujian.getTanggal());
        System.out.println("Nama ujian      : " + ujian.getNamaUjian());

        int amount = 0;    // menghitung jumlah soal

        /* Array indikator soal pertama*/
        boolean[] isFirst = new boolean[]{true, true, true};
        /* List soal sudah dianggap terurut: Pilihan ganda - Isian - Esai. */
        for (SoalUjian soal : ujian.getListSoal()) {
            /* Ujian Pilihan ganda. */
            if (soal instanceof SoalPilihanGanda pilgan) {
                if (isFirst[0]) {
                    System.out.println();
                    System.out.println("===================================================");
                    System.out.println("\t\t\t\t Soal Pilihan Ganda");
                    System.out.println("===================================================");
                    isFirst[0] = false;
                }
                System.out.printf("%02d. %s", ++amount, pilgan.getSoal());
                UjianUtility.jawab(pilgan);
                System.out.println();
            }

            /* Ujian Isian. */
            if (soal instanceof SoalIsian isian) {
                if (isFirst[1]) {
                    System.out.println();
                    System.out.println("===================================================");
                    System.out.println("\t\t\t\t Soal Isian");
                    System.out.println("===================================================");
                    isFirst[1] = false;
                }
                System.out.printf("%02d. %s", ++amount, isian.getPertanyaan());
                System.out.println();
                UjianUtility.jawab(isian);
                System.out.println();
            }

            /* Ujian Esai. */
            if (soal instanceof SoalEsai esai) {
                if (isFirst[2]) {
                    System.out.println();
                    System.out.println("===================================================");
                    System.out.println("\t\t\t\t Soal Esai");
                    System.out.println("===================================================");
                    isFirst[2] = false;
                }
                System.out.printf("%02d. %s", ++amount, esai.getPertanyaan());
                UjianUtility.jawab(esai);
                System.out.println();
            }
        }
    }

    /**
     * Metode untuk mengetes tanpa input (Soal sudah diberikan).
     * */
    public static void testTanpaInput() {
        MataKuliah mataKuliah = new MataKuliah("Pengetahuan Umum", "Pendidikan Guru Sekolah Dasar");
        Dosen dosen = new Dosen("Sri Hartati", "33453535");
        JawabanTunggal[] pilihanSoal1 = {
                new JawabanTunggal("Jakarta"),
                new JawabanTunggal("Bandung"),
                new JawabanTunggal("Malang"),
                new JawabanTunggal("Kalimantan")
        };
        JawabanTunggal[] pilihanSoal2 = {
                new JawabanTunggal("19 Agustus 1945"),
                new JawabanTunggal("18 Agustus 1945"),
                new JawabanTunggal("17 Agustus 1945"),
                new JawabanTunggal("16 Agustus 1945")
        };
        JawabanTunggal[] pilihanSoal3 = {
                new JawabanTunggal("Teluk"),
                new JawabanTunggal("Sungai"),
                new JawabanTunggal("Pantai"),
                new JawabanTunggal("Tanjung")
        };
        SoalUjian[] listSoal = {
                new SoalPilihanGanda(
                        "Ibu kota Indonesia? ",
                        pilihanSoal1,
                        pilihanSoal1[0]),
                new SoalPilihanGanda(
                        "Kapan Indonesia merdeka? ",
                        pilihanSoal2,
                        pilihanSoal2[2]),
                new SoalPilihanGanda(
                        "Daratan yang menjorok ke laut disebut? ",
                        pilihanSoal3,
                        pilihanSoal3[3]),
                new SoalIsian(
                        "Hewan pemakan daging disebut?",
                        new JawabanTunggal("Karnivora")),
                new SoalIsian(
                        "Hewan pemakan segala disebut?",
                        new JawabanTunggal("Omnivora")),
                new SoalIsian(
                        "Tahun berapa kapal Titanic tenggelam?",
                        new JawabanTunggal("1912")),
                new SoalEsai(
                        "Jelaskan latar belakang terjadinya perang antara Palestina dengan Israel?"),
                new SoalEsai(
                        "Jelaskan sejarah kemerdekaan Indonesia!"),
                new SoalEsai(
                        "Berikan tanggapan Anda mengenai ekonomi indonesia yang menurun!")
        };
        Ujian ujian = new Ujian(listSoal, mataKuliah, dosen, "Test I", "2", "12 Juni 2023");
        mulaiUjian(ujian);
    }

    public static void main(String[] args) {
        testTanpaInput();
    }
}