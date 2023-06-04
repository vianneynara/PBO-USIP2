package program;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        MataKuliah mataKuliah = new MataKuliah("Informatika", "Sains Dan Teknologi");
        Dosen dosen = new Dosen("Tatik","33453535");
        Jawaban[] jawabans = {
                new Jawaban("Jakarta"),
                new Jawaban("Bandung"),
                new Jawaban("Malang"),
                new Jawaban("Kalimantan")
        };
        Jawaban [] jawabans1 = {
                new Jawaban("20 Agustus 1956"),
                new Jawaban("18 September 1893"),
                new Jawaban("17 Agustus 1945"),
                new Jawaban("17 Agustus 1959")

        };
        Jawaban [] jawabans2 = {
                new Jawaban("Teluk"),
                new Jawaban("Sungai"),
                new Jawaban("pantai"),
                new Jawaban("Tanjung")
        };
        SoalUjian[] listSoal = {
                new SoalPilihanGanda("Ibu kota Indonesia ? ",jawabans,jawabans[0]),
                new SoalPilihanGanda("Kapan Indonesia Merdeka ? ",jawabans1, jawabans1[2]),
                new SoalPilihanGanda("Daratan yang menjorok kelaut disebut ? ",jawabans2, jawabans2[3]),
                new SoalIsian("Heman pemakan daging disebut ?",new Jawaban("Karnivora")),
                new SoalIsian("Heman pemakan Segala disebut ?",new Jawaban("Omnivora")),
                new SoalIsian(" Tahun berapa kapal titanic tenggelam?",new Jawaban("1912")),
                new SoalEsai("Jelaskan kenapa terjadinya perang antara pelestina dengan israel ?","gambar.jpg","hhtps:jshisisds.com")
        };
        Ujian ujian = new Ujian(listSoal,mataKuliah,dosen,"sdsds","2",new Date());
        ujian.startUjian();
    }
}