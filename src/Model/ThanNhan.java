package Model;

import java.util.Date;

public class ThanNhan {
	private int MaNV;
	private String TenTN;
	private boolean GioiTinh;
	private Date NgaySinh;
	private String QuanHe;
	public int getMaNV() {
		return MaNV;
	}
	public void setMaNV(int maNV) {
		MaNV = maNV;
	}
	public String getTenTN() {
		return TenTN;
	}
	public void setTenTN(String tenTN) {
		TenTN = tenTN;
	}
	public String getGioiTinh() {
		if(GioiTinh == true)
			return "Nam";
		else
			return "Nu";
	}
	public void setGioiTinh(boolean gioiTinh) {
		GioiTinh = gioiTinh;
	}
	public Date getNgaySinh() {
		return NgaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		NgaySinh = ngaySinh;
	}
	public String getQuanHe() {
		return QuanHe;
	}
	public void setQuanHe(String quanHe) {
		QuanHe = quanHe;
	}
	
	
}
