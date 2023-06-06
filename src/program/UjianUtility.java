package program;

import java.util.ArrayList;
import java.util.Scanner;

public class UjianUtility {

    private static final Scanner sc = new Scanner(System.in);

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
     * Metode ini menyimpan pertanyaan secara langsung dengan masukan A hingga E menyesuaikan banyaknya
     * pilihan yang diberikan.
     * <br><br><center><code>
     *     (input < 65) || (input >= 65 + soal.getPilihanJawaban().length)
     * </code></center><br>
     * Merupakan kondisi untuk mengecek apakah character yang dimasukkan memiliki bobot yang sesuai dengan tabel
     * ASCII yaitu A = 65 hingga E = 69
     * @param soal soal bertipe {@link SoalPilihanGanda}
     * */
    public static void jawab(SoalPilihanGanda soal) {
        Scanner scanner = new Scanner(System.in);
        char input;
        do {
            System.out.print("Masukkan jawaban Anda: ");
            input = scanner.nextLine().toUpperCase().charAt(0);

            if ((input < 65) || (input >= 65 + soal.getPilihanJawaban().length))
                System.out.println("Masukkan jawaban yang sesuai!");

        } while ((input < 65) || (input >= 65 + soal.getPilihanJawaban().length));

        /* Mengkonversi char ASCII menjadi index dari 0 hingga 4. */
        int inputIndex = switch (input) {
            case 'A' -> 0;
            case 'B' -> 1;
            case 'C' -> 2;
            case 'D' -> 3;
            default -> 4;
        };

        soal.simpanJawaban(soal.getPilihanJawaban()[inputIndex]);

        /* Komparasi jawaban. */
        if (soal.getKunciJawaban().getLabel().equalsIgnoreCase(soal.getPilihanJawaban()[inputIndex].getLabel())) {
            System.out.println("Jawaban Anda benar!");
        }
        else
            System.out.println("Jawaban Anda salah!");
    }
    
    

    /**
     * Metode ini menyimpan dan memberikan keputusan benar salah sebuah jawaban secara langsung.
     * @param soal saol bertipe {@link SoalIsian}
     * */
    public static void jawab(SoalIsian soal) {
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            System.out.print("Jawab: ");
            input = scanner.nextLine();
            if (input.length() > 20)
                System.out.println("Maksimal 20 karakter.");
        } while (input.length() > 20);

        soal.simpanJawaban(new JawabanTunggal(input));

        /* Komparasi jawaban. */
        if (soal.getInputJawaban().getLabel().equalsIgnoreCase(soal.getKunciJawaban().getLabel()))
            System.out.println("Jawaban Anda benar!");
        else
            System.out.println("Jawaban Anda salah!");
    }

    /**
     * Metode ini menyimpan JawabanTunggal dan memberikan keputusan benar salah sebuah jawaban secara langsung.
     * @param soal saol bertipe {@link SoalEsai}
     * */
    public static void jawab(SoalEsai soal) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nama File     : ");
        var namaFile = scanner.nextLine();
        System.out.print("Link gambar   : ");
        var linkFile = scanner.nextLine();

        /* Menyimpan jawaban. */
        soal.simpanJawaban(new JawabanEsai(namaFile, linkFile));
        System.out.println("JawabanTunggal Anda sudah tersimpan!");
    }

}
