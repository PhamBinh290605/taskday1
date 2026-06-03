public class Subject {
    private int maMonHoc;
    private String tenMonHoc;
    private int soTietHoc;
    private double tiLeQt;
    private double tileTp;

    public Subject(int maMonHoc, String tenMonHoc, int soTietHoc, double tiLeQt, double tileTp) {
        this.maMonHoc = maMonHoc;
        this.tenMonHoc = tenMonHoc;
        this.soTietHoc = soTietHoc;
        this.tiLeQt = tiLeQt;
        this.tileTp = tileTp;
    }

    public Subject() {}

    public int getMaMonHoc() {
        return maMonHoc;
    }

    public void setMaMonHoc(int maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public int getSoTietHoc() {
        return soTietHoc;
    }

    public void setSoTietHoc(int soTietHoc) {
        this.soTietHoc = soTietHoc;
    }

    public double getTiLeQt() {
        return tiLeQt;
    }

    public void setTiLeQt(double tiLeQt) {
        this.tiLeQt = tiLeQt;
    }

    public double getTileTp() {
        return tileTp;
    }

    public void setTileTp(double tileTp) {
        this.tileTp = tileTp;
    }

    public void hienThiThongTin() {
        System.out.println("Ma mon hoc : " + maMonHoc);
        System.out.println("Ten mon hoc: " + tenMonHoc);
        System.out.println("So tiet hoc : " + soTietHoc);
        System.out.println("Ti le QT   : " + tiLeQt);
        System.out.println("Ti le TP   : " + tileTp);
    }
}
