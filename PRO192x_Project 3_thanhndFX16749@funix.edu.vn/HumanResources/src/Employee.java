public class Employee extends Staff implements ICalculator {
    public Employee() {
    }

    public Employee(String maNhanVien, String tenNhanVien, int tuoiNhanVien, float heSoLuong, String ngayVaoLam, String boPhanLamViec, int soNgayNghiPhep, int soGioLamThem) {
        super(maNhanVien, tenNhanVien, tuoiNhanVien, heSoLuong, ngayVaoLam, boPhanLamViec, soNgayNghiPhep);
        this.soGioLamThem = soGioLamThem;
    }

    private int soGioLamThem;

    public int getSoGioLamThem() {
        return soGioLamThem;
    }

    public void setSoGioLamThem(int soGioLamThem) {
        this.soGioLamThem = soGioLamThem;
    }

    @Override
    public float calculateSalary() {
        return getHeSoLuong()*3000000+soGioLamThem*200000;
    }

    @Override
    public void displayInformation(){
        System.out.printf("%-15s| %-20s| %-7d| %-15.3f| %-15s| %-15d| %-20s| %-25d| %-20.2f\n", getMaNhanVien(), getTenNhanVien(), getTuoiNhanVien(), getHeSoLuong(), getNgayVaoLam(), getSoNgayNghiPhep(), getBoPhanLamViec(), soGioLamThem, calculateSalary());
    }
}
