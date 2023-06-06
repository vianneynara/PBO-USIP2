package program;

public class Main {
    public static void main(String[] args) {
        MataKuliah mataKuliah = new MataKuliah("Informatika", "Sains dan Teknologi");
        Dosen dosen = new Dosen("Tatik", "33453535");
        Jawaban[] pilihanSoal1 = {
                new Jawaban("Jakarta"),
                new Jawaban("Bandung"),
                new Jawaban("Malang"),
                new Jawaban("Kalimantan")
        };
        Jawaban[] pilihanSoal2 = {
                new Jawaban("19 Agustus 1945"),
                new Jawaban("18 Agustus 1945"),
                new Jawaban("17 Agustus 1945"),
                new Jawaban("16 Agustus 1945")
        };
        Jawaban[] pilihanSoal3 = {
                new Jawaban("Teluk"),
                new Jawaban("Sungai"),
                new Jawaban("Pantai"),
                new Jawaban("Tanjung")
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
                        new Jawaban("Karnivora")),
                new SoalIsian(
                        "Hewan pemakan segala disebut?",
                        new Jawaban("Omnivora")),
                new SoalIsian(
                        "Tahun berapa kapal Titanic tenggelam?",
                        new Jawaban("1912")),
                new SoalEsai(
                        "Jelaskan latar belakang terjadinya perang antara Palestina dengan Israel?"),
                new SoalEsai(
                        "Jelaskan sejarah kemerdekaan Indonesia!"),
                new SoalEsai(
                        "Berikan tanggapan Anda mengenai ekonomi indonesia yang menurun!")
        };
        Ujian ujian = new Ujian(listSoal, mataKuliah, dosen, "Test I", "2", "12 Juni 2023");
        ujian.startUjian();
    }
}