package program;

public class MataKuliah {
    private String fakultas;
    private String nama;
    private String dosen;
    private String semester;
    private String tanggal;

    public MataKuliah(String fakultas, String nama, String dosen, String semester, String tanggal) {
        this.fakultas = fakultas;
        this.nama = nama;
        this.dosen = dosen;
        this.semester = semester;
        this.tanggal = tanggal;
    }

    public String getNama() {
        return nama;
    }

    public String getFakultas() {
        return fakultas;
    }

    public String getDosen() {
        return dosen;
    }

    public String getSemester() {
        return semester;
    }

    public String getTanggal() {
        return tanggal;
    }
}
