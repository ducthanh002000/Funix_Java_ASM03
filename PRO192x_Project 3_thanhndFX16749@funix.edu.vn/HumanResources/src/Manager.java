public class Manager extends Staff implements ICalculator{
    public Manager() {
    }

    public Manager(String maNhanVien, String tenNhanVien, int tuoiNhanVien, float heSoLuong, String ngayVaoLam, String boPhanLamViec, int soNgayNghiPhep, String chucVu) {
        super(maNhanVien, tenNhanVien, tuoiNhanVien, heSoLuong, ngayVaoLam, boPhanLamViec, soNgayNghiPhep);
        this.chucVu = chucVu;
    }

    private String chucVu;

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    @Override
    public float calculateSalary() {
        if ( chucVu.equalsIgnoreCase("Business Leader")){
            return getHeSoLuong()*5000000+8000000;
        } else if (chucVu.equalsIgnoreCase("Project Leader")) {
            return getHeSoLuong()*5000000+5000000;
        } else {
            return getHeSoLuong()*5000000+6000000;
        }
    }
    @Override
    public void displayInformation(){
        System.out.printf("%-15s| %-20s| %-7d| %-15f| %-15s| %-15d| %-20s| %-25s| %-20.2f\n", getMaNhanVien(), getTenNhanVien(), getTuoiNhanVien(), getHeSoLuong(), getNgayVaoLam(), getSoNgayNghiPhep(), getBoPhanLamViec(), chucVu, calculateSalary());
    }
}
