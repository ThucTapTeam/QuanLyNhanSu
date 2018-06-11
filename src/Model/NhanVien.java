package Model;

import java.sql.Date;

public class NhanVien {
	private int MaNV;
	private String TenNV;
	private String HoNV;
	private Date NgaySinh;
	private String DiaChi;
	private boolean GioiTinh;
	private int luong;
	private int MaPB;
	private String ID;
	private String Password;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public int getMaNV() {
		return MaNV;
	}
	public void setMaNV(int maNV) {
		MaNV = maNV;
	}
	public String getTenNV() {
		return TenNV;
	}
	public void setTenNV(String tenNV) {
		TenNV = tenNV;
	}
	public String getHoNV() {
		return HoNV;
	}
	public void setHoNV(String hoNV) {
		HoNV = hoNV;
	}
	public Date getNgaySinh() {
		return NgaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		NgaySinh = ngaySinh;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public String getGioiTinh() {
		if(GioiTinh == true)
			return "nam";
		else
			return "nu";
	}
	public void setGioiTinh(boolean gioiTinh) {
		GioiTinh = gioiTinh;
	}
	public int getLuong() {
		return luong;
	}
	public void setLuong(int luong) {
		this.luong = luong;
	}
	public int getMaPB() {
		return MaPB;
	}
	public void setMaPB(int maPB) {
		MaPB = maPB;
	}
}
