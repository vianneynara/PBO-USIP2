package program;

import java.util.Scanner;

public abstract class SoalUjian {
    
    protected String soal;
    protected Jawaban kunciJawaban;

    public SoalUjian(String soal, Jawaban kunciJawaban) {
        this.soal = soal;
        this.kunciJawaban = kunciJawaban;
    }

    public String getPertanyaan() {
        return soal;
    }

    public Jawaban getKunciJawaban() {
        return kunciJawaban;
    }

    public abstract void tampilan();
}

class SoalPilihanGanda extends SoalUjian {
    
    private String[] pilihanJawaban;

    public SoalPilihanGanda(String soal, String[] pilihanJawaban, Jawaban kunciJawaban) {
        super(soal, kunciJawaban);
        this.pilihanJawaban = pilihanJawaban;
    }

    public void tampilkanSoal() {
        System.out.println(super.getPertanyaan());
    }

    public void tampilkanJawaban() {
        for (int i = 0; i < pilihanJawaban.length; i++) {
            System.out.println("\t" + (char) ('A' + i) + ". " + pilihanJawaban[i]);
        }
    }

    @Override
    public void tampilan() {
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            System.out.print("Masukkan jawaban Anda: ");
            input = scanner.nextLine();

            if (input.isEmpty())
                System.out.println("Anda belum memasukkan jawaban.");
        } while (input.isEmpty());

        char inputJawaban = Character.toUpperCase(input.charAt(0));

        if (getKunciJawaban().getLabel().equalsIgnoreCase(pilihanJawaban[inputJawaban - 'A']))
            System.out.println("Jawaban Anda benar!");
        else
            System.out.println("Jawaban Anda salah!");
    }
}

class SoalIsian extends SoalUjian {
    
    public SoalIsian(String soal, Jawaban kunciJawaban) {
        super(soal, kunciJawaban);
    }

    @Override
    public void tampilan() {
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            System.out.print("Jawaban: ");
            input = scanner.nextLine();
            if (input.length() > 20)
                System.out.println("Maksimal 20 karakter.");
        } while (input.length() > 20);

        Jawaban inputJawaban = new Jawaban(input);

        if (inputJawaban.getLabel().equalsIgnoreCase(getKunciJawaban().getLabel()))
            System.out.println("Jawaban Anda benar!");
        else
            System.out.println("Jawaban Anda salah!");
    }
}

class SoalEsai extends SoalUjian {
    
    private String namaFile;
    private String linkFile;

    public SoalEsai(String soal, String namaFile, String linkFile) {
        super(soal, null);
        this.namaFile = namaFile;
        this.linkFile = linkFile;
    }

    public String getnamaFile() {
        return namaFile;
    }

    public String getlinkFile() {
        return linkFile;
    }

    @Override
    public void tampilan() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(super.getPertanyaan());
        System.out.print("Nama File     : ");
        String namaFile = scanner.nextLine();
        System.out.print("Link gambar   :  ");
        String linkFile = scanner.nextLine();
    }
}
