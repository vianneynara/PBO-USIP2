package program;

import java.util.ArrayList;
import java.util.Scanner;

public class UjianUtility {
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

        /* Menyimpan jawaban. */
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

        /* Menyimpan jawaban. */
        soal.simpanJawaban(new JawabanTunggal(input));

        /* Komparasi jawaban. */
        if (soal.getInputJawaban().getLabel().equalsIgnoreCase(soal.getKunciJawaban().getLabel()))
            System.out.println("Jawaban Anda benar!");
        else
            System.out.println("Jawaban Anda salah!");
    }

    /**
     * Metode ini menyimpan JawabanTunggal dan memberikan keputusan benar salah sebuah jawaban secara langsung.
     * @param soal soal bertipe {@link SoalEsai}
     * */
    public static void jawab(SoalEsai soal) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nama File     : ");
        var namaFile = scanner.nextLine();
        System.out.print("Link gambar   : ");
        var linkFile = scanner.nextLine();

        /* Menyimpan jawaban. */
        soal.simpanJawaban(new JawabanEsai(namaFile, linkFile));

        System.out.println("Jawaban Anda sudah tersimpan!");
    }

    /**
     * Mencocokan jawaban dengan kunci jawaban di {@link SoalPilihanGanda}.
     * @return true or false
     * */
    public static boolean cek(JawabanTunggal j, SoalPilihanGanda soal) {
        if (j.getLabel().equalsIgnoreCase(soal.getKunciJawaban().getLabel()))
            return true;
        else
            return false;
    }

    /**
     * Mencocokan jawaban dengan kunci jawaban di {@link SoalIsian}.
     * @return true or false
     * */
    public static boolean cek(JawabanTunggal j, SoalIsian soal) {
        if (j.getLabel().equalsIgnoreCase(soal.getKunciJawaban().getLabel()))
            return true;
        else
            return false;
    }

    /**
     * Metode utama untuk menjalankan ujian.
     * @param ujian {@link Ujian}
     * @return filled {@link Ujian}
     * */
    public static Ujian mulaiUjian(Ujian ujian) {
        System.out.println("\t\t\t  LEMBAR JAWAB MAHASISWA");
        System.out.println("--------------------------------------------------");
        System.out.println("Fakultas        : " + ujian.getMataKuliah().getFakultas());
        System.out.println("Matakuliah      : " + ujian.getMataKuliah().getNama());
        System.out.println("Nama dosen      : " + ujian.getDosen().getNama());
        System.out.println("Semester        : " + ujian.getSemester());
        System.out.println("Hari / Tanggal  : " + ujian.getTanggal());
        System.out.println("Nama ujian      : " + ujian.getNamaUjian());

        int jumlahSoal = 0;

        /* Array indikator soal pertama*/
        boolean[] isFirst = new boolean[]{true, true, true};
        /* List soal sudah dianggap terurut: Pilihan ganda - Isian - Esai. */
        for (SoalUjian soal : ujian.getListSoal()) {
            /* Ujian Pilihan ganda. */
            if (soal instanceof SoalPilihanGanda pilgan) {
                if (isFirst[0]) {
                    System.out.println();
                    System.out.println("\n===================================================");
                    System.out.println("\t\t\t\t Soal Pilihan Ganda");
                    System.out.println("===================================================");
                    isFirst[0] = false;
                }
                System.out.printf("%02d. %s%n", ++jumlahSoal, pilgan.getSoal());
                UjianUtility.jawab(pilgan);
                System.out.println();
            }

            /* Ujian Isian. */
            else if (soal instanceof SoalIsian isian) {
                if (isFirst[1]) {
                    System.out.println();
                    System.out.println("\n===================================================");
                    System.out.println("\t\t\t\t Soal Isian");
                    System.out.println("===================================================");
                    isFirst[1] = false;
                }
                System.out.printf("%02d. %s%n", ++jumlahSoal, isian.getPertanyaan());
                UjianUtility.jawab(isian);
                System.out.println();
            }

            /* Ujian Esai. */
            else if (soal instanceof SoalEsai esai) {
                if (isFirst[2]) {
                    System.out.println();
                    System.out.println("\n===================================================");
                    System.out.println("\t\t\t\t Soal Esai");
                    System.out.println("===================================================");
                    isFirst[2] = false;
                }
                System.out.printf("%02d. %s%n", ++jumlahSoal, esai.getPertanyaan());
                UjianUtility.jawab(esai);
                System.out.println();
            }
        }

        return ujian;
    }

    /**
     * Metode untuk menganalisa performa serta jawaban yang benar atau salah dari sebuah ujian.
     * @param ujian {@link Ujian} yang sudah terisi input jawabannya.
     * @return formatted {@link String}
     * */
    public static String analisaJawaban(Ujian ujian) {
        StringBuilder kesimpulan = new StringBuilder();

        /* List soal sudah dianggap terurut: Pilihan ganda - Isian - Esai. */
        SoalUjian[] listSoal = ujian.getListSoal();

        boolean hasilCek;
        int nomor = 0;
        int jumlahPilgan = UjianUtility.getSoalPilihanGanda(listSoal).length;
        int jumlahIsian = UjianUtility.getSoalIsian(listSoal).length;
        int benarPilgan = 0;
        int benarIsian = 0;
        int jumlahSoalNonEsai = 0;

        kesimpulan.append("[ Performa / hasil analisa ujian ]\n");
        kesimpulan.append("Jumlah keseluruhan soal: " + ujian.getListSoal().length);
        kesimpulan.append("\n");

        /* Array indikator soal pertama*/
        boolean[] isFirst = new boolean[]{true, true, true};
        for (SoalUjian soal : listSoal) {
            /* Ujian Pilihan ganda. */
            if (soal instanceof SoalPilihanGanda pilgan) {
                jumlahSoalNonEsai++;
                if (isFirst[0]) {
                    kesimpulan.append("\n = Soal Pilihan Ganda = (%02d)\n".formatted(
                            jumlahPilgan));
                    isFirst[0] = false;
                }

                /* true jika benar, false jika salah. */
                hasilCek = (UjianUtility.cek(pilgan.getInputJawaban(), pilgan));
                benarPilgan += (hasilCek) ? 1 : 0;

                kesimpulan.append("%02d. %s (%s) \n".formatted(
                        ++nomor,
                        pilgan.getInputJawaban().getLabel(),
                        (hasilCek) ?
                                "benar" :
                                "salah"
                        )
                );
            }

            /* Ujian Isian. */
            else if (soal instanceof SoalIsian isian) {
                jumlahSoalNonEsai++;
                if (isFirst[1]) {
                    kesimpulan.append("\n = Soal Isian = (%02d)\n".formatted(
                            jumlahIsian));
                    isFirst[1] = false;
                }

                /* true jika benar, false jika salah. */
                hasilCek = (UjianUtility.cek(isian.getInputJawaban(), isian));
                benarIsian += (hasilCek) ? 1 : 0;

                kesimpulan.append("%02d. %s (%s) \n".formatted(
                        ++nomor,
                        isian.getInputJawaban().getLabel(),
                        (hasilCek) ?
                                "benar" :
                                "salah"
                        )
                );
            }

            /* Ujian Esai. */
            else if (soal instanceof SoalEsai esai) {
                if (isFirst[2]) {
                    kesimpulan.append("\n = Soal Esai = (%02d)\n".formatted(
                            UjianUtility.getSoalEsai(listSoal).length));
                    isFirst[2] = false;
                }

                kesimpulan.append("%02d. [%s](%s) \n".formatted(
                        ++nomor,
                        esai.getInputJawaban().getNamaFile(),
                        esai.getInputJawaban().getLinkFile()
                        )
                );
            }
        }

        kesimpulan.append("\nPilihan ganda benar  : " + benarPilgan + " / " + jumlahPilgan);
        kesimpulan.append("\nIsian benar          : " + benarIsian + " / " + jumlahIsian);
        kesimpulan.append("\nTotal jawaban benar  : " + (benarPilgan + benarIsian) + " / " + jumlahSoalNonEsai);
        kesimpulan.append("\nHarap koreksi jawaban esai untuk menentukan skor akhir.");

        return kesimpulan.toString();
    }
}
