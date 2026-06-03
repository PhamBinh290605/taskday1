import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        StudentService studentService = new StudentService();

        studentService.initData();
        int choice;

        do {
            System.out.println("\n========== QUAN LY DIEM SINH VIEN ==========");
            System.out.println("1. Xem danh sach sinh vien");
            System.out.println("2. Xem chi tiet sinh vien");
            System.out.println("3. Xem so mon hoc sinh vien dang ky");
            System.out.println("4. Xem diem mon hoc cua sinh vien");
            System.out.println("5. Nhap diem cua sinh vien");
            System.out.println("6. Xem ket qua truot / do cua sinh vien");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    studentService.xemDanhSachSinhVien();
                    break;
                case 2:
                    studentService.xemChiTietSinhVien();
                    break;
                case 3:
                    studentService.xemSoMonHocSvDangKi();
                    break;
                case 4:
                    studentService.xemDiemMonHocSv();
                    break;
                case 5:
                    studentService.nhapDiem();
                    break;
                case 6:
                    studentService.xemKetQua();
                    break;
                case 0:
                    System.out.println("Da thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le.");
            }

        } while (choice != 0);
    }
}