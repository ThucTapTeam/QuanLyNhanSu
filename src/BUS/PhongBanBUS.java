package BUS;

import java.util.List;

import DAO.PhongBanDAO;
import Model.PhongBan;

public class PhongBanBUS implements BaseInterfaceBUS<PhongBan>{

	@Override
	public boolean insert(PhongBan obj) {
		// TODO Auto-generated method stub
		return new PhongBanDAO().insert(obj);
	}

	@Override
	public List<PhongBan> getList(String sql) {
		// TODO Auto-generated method stub
		return new PhongBanDAO().getList(sql);
	}

	@Override
	public boolean delete(PhongBan obj) {
		// TODO Auto-generated method stub
		return new PhongBanDAO().delete(obj);
	}

	@Override
	public boolean update(PhongBan obj) {
		// TODO Auto-generated method stub
		return new PhongBanDAO().update(obj);
	}

}
