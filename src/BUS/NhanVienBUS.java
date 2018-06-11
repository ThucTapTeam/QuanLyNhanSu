package BUS;

import java.util.List;

import DAO.NhanVienDAO;
import Model.NhanVien;

public class NhanVienBUS implements BaseInterfaceBUS<NhanVien> {

	@Override
	public boolean insert(NhanVien obj) {
		return new NhanVienDAO().insert(obj);
	}

	@Override
	public List<NhanVien> getList(String sql) {
		// TODO Auto-generated method stub
		return new NhanVienDAO().getList(sql);
	}

	@Override
	public boolean delete(NhanVien obj) {
		// TODO Auto-generated method stub
		return new NhanVienDAO().delete(obj);
	}

	@Override
	public boolean update(NhanVien obj) {
		// TODO Auto-generated method stub
		return new NhanVienDAO().update(obj);
	}

}
