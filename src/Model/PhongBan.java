package Model;

import java.sql.Date;

public class PhongBan {
	private int MaPB;
	private String TenPB;
	private int MaTP;
	private Date NgayNhanChuc;
	public int getMaPB() {
		return MaPB;
	}
	public void setMaPB(int maPB) {
		MaPB = maPB;
	}
	public String getTenPB() {
		return TenPB;
	}
	public void setTenPB(String tenPB) {
		TenPB = tenPB;
	}
	public int getMaTP() {
		return MaTP;
	}
	public void setMaTP(int maTP) {
		MaTP = maTP;
	}
	public Date getNgayNhanChuc() {
		return NgayNhanChuc;
	}
	public void setNgayNhanChuc(Date ngayNhanChuc) {
		NgayNhanChuc = ngayNhanChuc;
	}
}
