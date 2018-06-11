package BUS;

import java.util.List;

import DAO.PhanCongDAO;
import Model.PhanCongDA;

public class PhanCongBUS implements BaseInterfaceBUS<PhanCongDA> {

	@Override
	public boolean insert(PhanCongDA obj) {
		// TODO Auto-generated method stub
		return new PhanCongDAO().insert(obj);
	}

	@Override
	public List<PhanCongDA> getList(String sql) {
		// TODO Auto-generated method stub
		return new PhanCongDAO().getList(sql);
	}

	@Override
	public boolean delete(PhanCongDA obj) {
		// TODO Auto-generated method stub
		return new PhanCongDAO().delete(obj);
	}

	@Override
	public boolean update(PhanCongDA obj) {
		// TODO Auto-generated method stub
		return new PhanCongDAO().update(obj);
	}

}
