package program;

import java.util.Scanner;

public class Main {
    
    private static final Scanner sc = new Scanner(System.in);    
    
    /**
     * Metode untuk menampilkan pemasukkan soal pilihan ganda.
     * @return {@link SoalPilihanGanda}
     * */
    @Deprecated // Tidak digunakan.
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
    @Deprecated // Tidak digunakan.
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
    @Deprecated // Tidak digunakan.
    public static SoalEsai inputSoalEsai() {
        System.out.print("Pertanyaan    : ");
        var pertanyaan = sc.nextLine();

        return new SoalEsai(
                pertanyaan
        );
    }

    /**
     * Metode untuk mengetes tanpa input (Soal sudah diberikan).
     * */
    public static Ujian testTanpaInput() {
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
                        "Ibu kota Indonesia?",
                        pilihanSoal1,
                        pilihanSoal1[0]),
                new SoalPilihanGanda(
                        "Kapan Indonesia merdeka?",
                        pilihanSoal2,
                        pilihanSoal2[2]),
                new SoalPilihanGanda(
                        "Daratan yang menjorok ke laut disebut?",
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
        return UjianUtility.mulaiUjian(ujian);
    }

    public static void main(String[] args) {
        Ujian hasilUjian = testTanpaInput();

        System.out.println();
        System.out.println(UjianUtility.analisaJawaban(hasilUjian));
    }
}