package BUS;

import java.util.List;

import DAO.DuanDAO;
import Model.DuAn;

public class DuAnBUS implements BaseInterfaceBUS<DuAn>{

	@Override
	public boolean insert(DuAn obj) {
		// TODO Auto-generated method stub
		return new DuanDAO().insert(obj);
	}

	@Override
	public List<DuAn> getList(String sql) {
		// TODO Auto-generated method stub
		return new DuanDAO().getList(sql);
	}

	@Override
	public boolean delete(DuAn obj) {
		// TODO Auto-generated method stub
		return new DuanDAO().delete(obj);
	}

	@Override
	public boolean update(DuAn obj) {
		// TODO Auto-generated method stub
		return new DuanDAO().update(obj);
	}

}
