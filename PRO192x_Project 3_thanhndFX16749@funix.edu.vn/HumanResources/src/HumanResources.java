import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class HumanResources {
    private static ArrayList<Staff> danhSachNhanVien = new ArrayList<>();
    private static ArrayList<Department> danhSachBoPhan = new ArrayList<>();
    static {
        danhSachBoPhan.add(new Department( 1, "Hanh chinh nhan su", 1));
        danhSachBoPhan.add(new Department( 2, "Cong nghe thong tin", 1));
        danhSachBoPhan.add(new Department( 3, "Marketing", 3));

        danhSachNhanVien.add(new Employee( "1", "Thanh", 20, 0.7f, "20/02/2002", "Cong nghe thong tin", 5, 100));
        danhSachNhanVien.add(new Employee( "2", "Dung", 20, 0.6f, "20/02/2002", "Hanh chinh nhan su", 5, 90));
        danhSachNhanVien.add(new Employee( "3", "Dat", 20, 0.65f, "20/02/2002", "Marketing", 5, 95));
        danhSachNhanVien.add(new Employee( "4", "Truong", 20, 0.65f, "20/02/2002", "Marketing", 5, 95));
        danhSachNhanVien.add(new Manager( "5", "Tung", 20, 0.65f, "20/02/2002", "Marketing", 5,"Business Leader"));
    }
    public static void menu(){
        System.out.println("1. Hien thi danh sach nhan vien hien co trong cong ty.");
        System.out.println("2. Hien thi cac bo phan trong cong ty.");
        System.out.println("3. Hien thi cac nhan vien theo tung bo phan.");
        System.out.println("4. Them nhan vien moi vao cong ty.");
        System.out.println("5. Tim kiem thong tin nhan vien theo ten hoac ma nhan vien.");
        System.out.println("6. Hien thi bang luong cua nhan vien toan cong ty.");
        System.out.println("7. Hien thi bang luong cua nhan vien theo thu tu tang dan.");
        System.out.println("0. Thoat chuong trinh.");
        System.out.print("Lua chon cua ban:");
    }
    public static void main(String[] args) {
        int options;
        Scanner input = new Scanner(System.in);
        do{
            menu();
            options = input.nextInt();
            switch ( options ) {
                case  1:
                    hienThiNhanVien();
                    break;
                case  2:
                    hienThiPhongBan();
                    break;
                case  3:
                    hienThiNhanVienTheoBoPhan();
                    break;
                case  4:
                    themNhanVien();
                    break;
                case  5:
                    timNhanVien();
                    break;
                case  6:
                    hienThiBangLuongNhanVienToanCongTyGiamDan();
                    break;
                case  7:
                    hienThiBangLuongNhanVienToanCongTy();
                    break;
                case  0:
                    break;
                default:
            }
        }while (options != 0);
    }
    static void hienThiNhanVien(){
        System.out.printf("%-15s| %-20s| %-7s| %-15s| %-15s| %-15s| %-20s| %-25s| %-20s\n", "Ma nhan vien", "Ten nhan vien", "Tuoi", "He so luong", "Ngay vao lam", "Ngay nghi phep", "Bo phan", "So gio lam them/Chuc vu", "Luong");
        for (int i = 0; i < danhSachNhanVien.size(); i++) {
            danhSachNhanVien.get(i).displayInformation();
        }
    }
    static void hienThiPhongBan(){

        System.out.printf("%-15s|%-30s|%-7s\n", "Ma bo phan", "Ten bo phan", "So luong nhan vien hien tai");
        for (int i = 0; i < danhSachBoPhan.size(); i++) {
            System.out.println(danhSachBoPhan.get(i).toString());
        }
    }
    static void hienThiNhanVienTheoBoPhan(){
        for (int i = 0; i < danhSachBoPhan.size(); i++) {
            System.out.println(danhSachBoPhan.get(i).getTenBoPhan());
            System.out.println("-----------------------------------------------");
            System.out.printf("%-15s| %-20s| %-7s| %-15s| %-15s| %-15s| %-20s| %-25s| %-20s\n", "Ma nhan vien", "Ten nhan vien", "Tuoi", "He so luong", "Ngay vao lam", "Ngay nghi phep", "Bo phan", "So gio lam them", "Luong");
            for (int j = 0; j < danhSachNhanVien.size(); j++) {
                if ( danhSachNhanVien.get(j).getBoPhanLamViec().equals(danhSachBoPhan.get(i).getTenBoPhan())){
                    danhSachNhanVien.get(j).displayInformation();
                }
            }
        }
    }
    static void themNhanVien(){
        Scanner input = new Scanner(System.in);
        System.out.println("1. Them nhan vien thong thuong");
        System.out.println("2. Them nhan vien la cap quan ly (co them chuc vu)");
        System.out.println("Ban chon: ");
        int optionCase4;
        optionCase4 = input.nextInt();
        while ( optionCase4 != 1 && optionCase4 != 2){
            System.out.println("Vui long chon tu 1 den 2");
            System.out.println("Ban chon: ");
            optionCase4 = input.nextInt();
        }
        String maNhanVien;
        String tenNhanVien;
        int tuoiNhanVien;
        float heSoLuong;
        String ngayVaoLam;
        int soNgayNghiPhep;
        String boPhanLamViec;
        System.out.println("Nhap ma nhan vien: ");
        maNhanVien = input.next();
        for (int i = 0; i < danhSachNhanVien.size(); i++) {
            if (danhSachNhanVien.get(i).getMaNhanVien().equals(maNhanVien)){
                System.out.println("Ma nhan vien bi trung!!!\nNhap lai ma nhan vien");
                maNhanVien = input.next();
                i = -1;
            }
        }
        String c = input.nextLine();// xử lý lỗi bắt ký tự enter vào dòng nhập tên nhân viên
        System.out.println("Nhap ten nhan vien: ");
        tenNhanVien = input.nextLine();
        System.out.println("Nhap tuoi nhan vien: ");
        tuoiNhanVien = input.nextInt();
        System.out.println("Nhap he so luong: ");
        heSoLuong = input.nextFloat();
        System.out.println("Nhap ngay vao lam viec: ");
        ngayVaoLam = input.next();
        System.out.println("Nhap bo phan lam viec: ");
        System.out.println("1 : Hanh chinh nhan su");
        System.out.println("2 : Cong nghe thong tin");
        System.out.println("3 : Marketing");
        int option = input.nextInt();
        while ( option != 1 && option != 2 && option != 3){
            System.out.println("Vui long chon tu 1 den 3");
            System.out.println("1 : Hanh chinh nhan su");
            System.out.println("2 : Cong nghe thong tin");
            System.out.println("3 : Marketing");
            System.out.println("Ban chon: ");
            option = input.nextInt();
        }
        if ( option == 1){
            boPhanLamViec = "Hanh chinh nhan su";
        } else if (option == 2) {
            boPhanLamViec = "Cong nghe thong tin";
        } else {
            boPhanLamViec = "Marketing";
        }
        for (int i = 0; i < danhSachBoPhan.size(); i++) {
            if( danhSachBoPhan.get(i).getTenBoPhan().contains(boPhanLamViec) ){
                danhSachBoPhan.get(i).setSoLuongNhanVienHienTai(danhSachBoPhan.get(i).getSoLuongNhanVienHienTai()+1);
                break;
            }
        }
        System.out.println("Nhap so ngay nghi phep: ");
        soNgayNghiPhep = input.nextInt();
        if (optionCase4 == 1){
            int soGioLamThem;
            System.out.println("Nhap so gio lam them: ");
            soGioLamThem = input.nextInt();
            danhSachNhanVien.add(new Employee( maNhanVien, tenNhanVien, tuoiNhanVien, heSoLuong, ngayVaoLam, boPhanLamViec, soNgayNghiPhep, soGioLamThem));
        } else {
            String chucVu;
            System.out.println("Chon chuc vu: ");
            System.out.println("1 : Business Leader");
            System.out.println("2 : Project Leader");
            System.out.println("3 : Technical Leader");
            option = input.nextInt();
            while ( option != 1 && option != 2 && option != 3){
                System.out.println("Vui long chon tu 1 den 3");
                System.out.println("1 : Business Leader");
                System.out.println("2 : Project Leader");
                System.out.println("3 : Technical Leader");
                System.out.println("Ban chon: ");
                option = input.nextInt();
            }
            if ( option == 1){
                chucVu = "Business Leader";
            } else if (option == 2) {
                chucVu = "Project Leader";
            } else {
                chucVu = "Technical Leader";
            }
            danhSachNhanVien.add(new Manager( maNhanVien, tenNhanVien, tuoiNhanVien, heSoLuong, ngayVaoLam, boPhanLamViec, soNgayNghiPhep, chucVu));
        }
    }
    static void timNhanVien(){
        Scanner input = new Scanner(System.in);
        System.out.println("1. Tim nhan vien bang ten");
        System.out.println("2. Tim nhan vien bang ma nhan vien");
        System.out.print("Ban chon: ");
        int option = input.nextInt();
        while ( option != 1 && option != 2){
            System.out.println("Vui long chon tu 1 den 2");
            System.out.println("1. Tim nhan vien bang ten");
            System.out.println("2. Tim nhan vien bang ma nhan vien");
            System.out.println("Ban chon: ");
            option = input.nextInt();
        }
        boolean isFound = false;
        if ( option == 1){
            System.out.println("Nhap ten nhan vien can tim:");
            String tenCanTim = input.next();
            for (int i = 0; i < danhSachNhanVien.size(); i++) {
                if( danhSachNhanVien.get(i).getTenNhanVien().contains(tenCanTim) ){
                    danhSachNhanVien.get(i).displayInformation();
                    isFound = true;
                    break;
                }
            }
            if (!isFound){
                System.out.printf("Khong tim thay nhan vien co ten la : \"%s\"\n", tenCanTim);
            }
        } else {
            System.out.println("Nhap ma nhan vien can tim:");
            String maCanTim = input.next();
            for (int i = 0; i < danhSachNhanVien.size(); i++) {
                if( danhSachNhanVien.get(i).getMaNhanVien().contains(maCanTim) ){
                    danhSachNhanVien.get(i).displayInformation();
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                System.out.printf("Khong tim thay nhan vien co ma la: \"%s\"\n", maCanTim);
            }
        }
    }
    static void hienThiBangLuongNhanVienToanCongTy(){
        int indexOfSmallNumber;
        for (int i = 0; i < danhSachNhanVien.size(); i++) {
            indexOfSmallNumber = i;
            for (int j = i+1; j < danhSachNhanVien.size(); j++) {
                if ( danhSachNhanVien.get(indexOfSmallNumber).calculateSalary() > danhSachNhanVien.get(j).calculateSalary()){
                    indexOfSmallNumber = j;
                }
            }
            Collections.swap(danhSachNhanVien, i,indexOfSmallNumber);
        }
        System.out.printf("%-15s| %-20s| %-7s| %-15s| %-15s| %-15s| %-20s| %-25s| %-20s\n", "Ma nhan vien", "Ten nhan vien", "Tuoi", "He so luong", "Ngay vao lam", "Ngay nghi phep", "Bo phan", "So gio lam them/Chuc vu", "Luong");
        for (int i = 0; i < danhSachNhanVien.size(); i++) {
            danhSachNhanVien.get(i).displayInformation();
        }
    }
    static void hienThiBangLuongNhanVienToanCongTyGiamDan(){
        int indexOfBigerNumber;
        for (int i = 0; i < danhSachNhanVien.size(); i++) {
            indexOfBigerNumber = i;
            for (int j = i+1; j < danhSachNhanVien.size(); j++) {
                if ( danhSachNhanVien.get(indexOfBigerNumber).calculateSalary() < danhSachNhanVien.get(j).calculateSalary()){
                    indexOfBigerNumber = j;
                }
            }
            Collections.swap(danhSachNhanVien, i,indexOfBigerNumber);
        }
        System.out.printf("%-15s| %-20s| %-7s| %-15s| %-15s| %-15s| %-20s| %-25s| %-20s\n", "Ma nhan vien", "Ten nhan vien", "Tuoi", "He so luong", "Ngay vao lam", "Ngay nghi phep", "Bo phan", "So gio lam them/Chuc vu", "Luong");
        for (int i = 0; i < danhSachNhanVien.size(); i++) {
            danhSachNhanVien.get(i).displayInformation();
        }
    }
}
