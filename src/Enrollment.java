public class Enrollment {
    private Student student;
    private Subject subject;
    private Double diemQt;
    private Double diemTp;

    public Enrollment(Student student, Subject subject) {
        this.student = student;
        this.subject = subject;
    }

    public Student getStudent() {
        return student;
    }

    public Subject getSubject() {
        return subject;
    }

    public double getDiemQt() {
        return diemQt;
    }

    public double getDiemTp() {
        return diemTp;
    }

    public void nhapDiem(double diemQt, double diemTp) {
        this.diemQt = diemQt;
        this.diemTp = diemTp;
    }

    public boolean hasScore() {
        return diemQt != null && diemTp != null;
    }

    public double diemCuoiKi() {
        if (!hasScore()) {
            return 0;
        }

        return diemQt * subject.getTiLeQt()
                + diemTp * subject.getTileTp();
    }

    public String getKetQua() {
        if (!hasScore()) {
            return "Chua co diem";
        }

        if (diemCuoiKi() >= 4) {
            return "DO";
        }

        return "TRUOT";
    }

    public void hienThiDiem() {
        System.out.println("Ma SV          : " + student.getMaSv());
        System.out.println("Ten SV         : " + student.getTenSv());
        System.out.println("Mon hoc        : " + subject.getTenMonHoc());
        System.out.println("So tiet hoc     : " + subject.getSoTietHoc());

        if (!hasScore()) {
            System.out.println("Diem           : Chua nhap diem");
        } else {
            System.out.println("Diem qua trinh : " + diemQt);
            System.out.println("Diem thanh phan: " + diemTp);
            System.out.println("Diem tong ket  : " + diemCuoiKi());
            System.out.println("Ket qua        : " + getKetQua());
        }
    }
}
