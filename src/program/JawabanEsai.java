package program;

public class JawabanEsai {
    
    private String namaFile;
    private String linkFile;
    
    /** 
     * Constructor jawaban soal esai. 
     * */
    public JawabanEsai(String namaFile, String linkFile) {
        this.namaFile = namaFile;
        this.linkFile = linkFile;
    }

    /* Getters */

    public String getNamaFile() {
        return namaFile;
    }

    public String getLinkFile() {
        return linkFile;
    }

    /* Setters */

    public void setNamaFile(String namaFile) {
        this.namaFile = namaFile;
    }

    public void setLinkFile(String linkFile) {
        this.linkFile = linkFile;
    }
}