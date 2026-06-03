import java.time.LocalDate;

public class Student {
    private int maSv;
    private String tenSv;
    private String gioiTinh;
    private LocalDate ngaySinh;
    private String lop;
    private String khoa;

    public Student(int maSv, String tenSv, String gioiTinh, LocalDate ngaySinh, String lop, String khoa) {
        this.maSv = maSv;
        this.tenSv = tenSv;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.lop = lop;
        this.khoa = khoa;
    }

    public Student() {}

    public int getMaSv() {
        return maSv;
    }

    public void setMaSv(int maSv) {
        this.maSv = maSv;
    }

    public String getTenSv() {
        return tenSv;
    }

    public void setTenSv(String tenSv) {
        this.tenSv = tenSv;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public void hienThiThongTin() {
        System.out.println("Ma sinh vien : " + maSv);
        System.out.println("Ten sinh vien: " + tenSv);
        System.out.println("Gioi tinh    : " + gioiTinh);
        System.out.println("Ngay sinh    : " + ngaySinh);
        System.out.println("Lop          : " + lop);
        System.out.println("Khoa         : " + khoa);
    }
}
