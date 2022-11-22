public class Department {
    public Department() {
    }

    public Department(int maBoPhan, String tenBoPhan, int soLuongNhanVienHienTai) {
        this.maBoPhan = maBoPhan;
        this.tenBoPhan = tenBoPhan;
        this.soLuongNhanVienHienTai = soLuongNhanVienHienTai;
    }

    private int maBoPhan;
    private String tenBoPhan;
    private int soLuongNhanVienHienTai;

    public int getMaBoPhan() {
        return maBoPhan;
    }

    public void setMaBoPhan(int maBoPhan) {
        this.maBoPhan = maBoPhan;
    }

    public String getTenBoPhan() {
        return tenBoPhan;
    }

    public void setTenBoPhan(String tenBoPhan) {
        this.tenBoPhan = tenBoPhan;
    }

    public int getSoLuongNhanVienHienTai() {
        return soLuongNhanVienHienTai;
    }

    public void setSoLuongNhanVienHienTai(int soLuongNhanVienHienTai) {
        this.soLuongNhanVienHienTai = soLuongNhanVienHienTai;
    }

    @Override
    public String toString() {
        return String.format("%-15d|%-30s|%-7d", maBoPhan, tenBoPhan, soLuongNhanVienHienTai);
    }
}
