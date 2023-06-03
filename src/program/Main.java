package program;

import org.w3c.dom.ls.LSOutput;

public class Main {
    public static void main(String[] args) {
        Jawaban[] pilgan = {
                new Jawaban("Jakarta"),
                new Jawaban("Bandung"),
                new Jawaban("Malang"),
                new Jawaban("Kalimantan")
        };
        SoalPilihanGanda soalPilihanGanda = new SoalPilihanGanda("Ibu kota negara Indonesia adalah ? ", pilgan, pilgan[0]);
        System.out.println("Soal Pilihan Ganda :");
        System.out.println(soalPilihanGanda.getSoal());
        soalPilihanGanda.tampilkanJawaban();
        soalPilihanGanda.jawab();
        System.out.println("----------------------------------------");

        SoalIsian soalIsian = new SoalIsian("Hewan pemakan daging disebut ? ", new Jawaban("Karnivora"));
        System.out.println("Soal Isian : ");
        System.out.println(soalIsian.getSoal());
        soalIsian.jawab();
        System.out.println("----------------------------------------");

        SoalEsai soalEsai = new SoalEsai("Jelaskan sejarah tentang Indonesia ?","gambar1.jpg","http:sdjksdskdksdkssk.com");
        System.out.println("Soal Esai : ");
        soalEsai.jawab();
    }
}