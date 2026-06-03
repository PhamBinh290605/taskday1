import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService implements Manageable{
    Scanner scanner = new Scanner(System.in);
    private static List<Student> students = new ArrayList<>();
    private static List<Subject> subjects = new ArrayList<>();
    private static List<Enrollment> enrollments = new ArrayList<>();

    @Override
    public void xemDanhSachSinhVien() {
        System.out.println("===== DANH SACH SINH VIEN =====");

        for (Student student : students) {
            System.out.println("--------------------------------");
            student.hienThiThongTin();
        }
    }

    @Override
    public void xemChiTietSinhVien() {
        System.out.print("Nhap ma sinh vien: ");
        int maSv = scanner.nextInt();
        scanner.nextLine();

        Student student = findById(maSv);

        if (student == null) {
            System.out.println("Khong tim thay sinh vien.");
            return;
        }

        System.out.println("===== CHI TIET SINH VIEN =====");
        student.hienThiThongTin();
    }

    @Override
    public void xemSoMonHocSvDangKi() {
        System.out.print("Nhap ma sinh vien: ");
        int maSv = scanner.nextInt();
        scanner.nextLine();

        Student student = findById(maSv);

        if (student == null) {
            System.out.println("Khong tim thay sinh vien.");
            return;
        }

        int count = 0;

        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudent().getMaSv() == student.getMaSv()) {
                count++;
            }
        }

        System.out.println("\n===== SO MON HOC DA DANG KY =====");
        System.out.println("Ma sinh vien : " + student.getMaSv());
        System.out.println("Ten sinh vien: " + student.getTenSv());
        System.out.println("So mon hoc   : " + count);
    }

    @Override
    public void xemDiemMonHocSv() {
        System.out.print("Nhap ma sinh vien: ");
        int maSv = scanner.nextInt();
        scanner.nextLine();

        Student student = findById(maSv);

        if (student == null) {
            System.out.println("Khong tim thay sinh vien.");
            return;
        }

        System.out.println("\n===== DIEM MON HOC CUA SINH VIEN =====");

        boolean isFind = false;

        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudent().getMaSv() == maSv) {
                isFind = true;
                System.out.println("--------------------------------");
                enrollment.hienThiDiem();
            }
        }

        if (!isFind) {
            System.out.println("Sinh vien chua dang ky mon hoc nao.");
        }
    }

    @Override
    public void nhapDiem() {
        System.out.print("Nhap ma sinh vien: ");
        int maSv = scanner.nextInt();
        scanner.nextLine();

        Student student = findById(maSv);

        if (student == null) {
            System.out.println("Khong tim thay sinh vien.");
            return;
        }

        System.out.println("\n===== DANH SACH MON HOC DA DANG KY =====");

        boolean isFind = false;

        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudent().getMaSv() == maSv) {
                isFind = true;
                System.out.println(
                        enrollment.getSubject().getMaMonHoc()
                                + " - "
                                + enrollment.getSubject().getTenMonHoc()
                );
            }
        }

        if (!isFind) {
            System.out.println("Sinh vien chua dang ky mon hoc nao.");
            return;
        }

        System.out.print("Nhap ma mon hoc: ");
        int subjectId = scanner.nextInt();
        scanner.nextLine();

        Enrollment enrollment = findEnrollment(maSv, subjectId);

        if (enrollment == null) {
            System.out.println("Sinh vien chua dang ky mon hoc nay.");
            return;
        }

        System.out.print("Nhap diem qua trinh: ");
        double diemQt = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Nhap diem thanh phan: ");
        double diemTp = scanner.nextDouble();
        scanner.nextLine();

        if (!checkScore(diemQt) || !checkScore(diemTp)) {
            System.out.println("Diem phai nam trong khoang 0 den 10.");
            return;
        }

        enrollment.nhapDiem(diemQt, diemTp);

        System.out.println("Nhap diem thanh cong.");
    }

    @Override
    public void xemKetQua() {
        System.out.print("Nhap ma sinh vien: ");
        int studentCode = scanner.nextInt();
        scanner.nextLine();

        Student student = findById(studentCode);

        if (student == null) {
            System.out.println("Khong tim thay sinh vien.");
            return;
        }

        System.out.println("===== KET QUA TRUOT / DO =====");

        boolean isFind = false;

        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudent().getMaSv() == studentCode) {
                isFind = true;
                System.out.println("--------------------------------");
                System.out.println("Mon hoc       : " + enrollment.getSubject().getTenMonHoc());

                if (!enrollment.hasScore()) {
                    System.out.println("Ket qua       : Chua co diem");
                } else {
                    System.out.println("Diem tong ket : " + enrollment.diemCuoiKi());
                    System.out.println("Ket qua       : " + enrollment.getKetQua());
                }
            }
        }

        if (!isFind) {
            System.out.println("Sinh vien chua dang ky mon hoc nao.");
        }
    }

    private static Student findById(int studentCode) {
        for (Student student : students) {
            if (student.getMaSv() == studentCode) {
                return student;
            }
        }

        return null;
    }

    private static Enrollment findEnrollment(int studentCode, int subjectCode) {
        for (Enrollment enrollment : enrollments) {
            boolean hasStudent = enrollment.getStudent()
                    .getMaSv() == studentCode;

            boolean hasSubject = enrollment.getSubject()
                    .getMaMonHoc() == subjectCode;

            if (hasStudent && hasSubject) {
                return enrollment;
            }
        }

        return null;
    }

    private static boolean checkScore(double score) {
        return score >= 0 && score <= 10;
    }

    public void initData() {
        Student s1 = new Student(1, "Phạm Xuân Bình", "Nam",
                LocalDate.of(2005, 6, 29), "CNTT4", "K64");

        Student s2 = new Student(2, "Võ Hữu Thái", "Nam",
                LocalDate.of(2005, 7, 15), "CNTT1", "K64");

        Student s3 = new Student(3, "Nguyễn Tiến Mạnh", "Nam",
                LocalDate.of(2004, 9, 15), "CNTT3", "K61");

        students.add(s1);
        students.add(s2);
        students.add(s3);

        Subject sub1 = new Subject(1, "Cơ sở dữ liệu", 3, 0.4, 0.6);
        Subject sub2 = new Subject(2, "Lập trình Java", 3, 0.3, 0.7);
        Subject sub3 = new Subject(3, "Mạng máy tính", 2, 0.5, 0.5);

        subjects.add(sub1);
        subjects.add(sub2);
        subjects.add(sub3);

        enrollments.add(new Enrollment(s1, sub1));
        enrollments.add(new Enrollment(s1, sub2));
        enrollments.add(new Enrollment(s2, sub1));
        enrollments.add(new Enrollment(s2, sub3));
        enrollments.add(new Enrollment(s3, sub1));
    }
}
