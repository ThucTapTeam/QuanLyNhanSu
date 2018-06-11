package BUS;

import java.util.List;

import DAO.ThanNhanDAO;
import Model.ThanNhan;

public class ThanNhanBUS implements BaseInterfaceBUS<ThanNhan>{

	@Override
	public boolean insert(ThanNhan obj) {
		// TODO Auto-generated method stub
		return new ThanNhanDAO().insert(obj);
	}

	@Override
	public List<ThanNhan> getList(String sql) {
		// TODO Auto-generated method stub
		return new ThanNhanDAO().getList(sql);
	}

	@Override
	public boolean delete(ThanNhan obj) {
		// TODO Auto-generated method stub
		return new ThanNhanDAO().delete(obj);
	}

	@Override
	public boolean update(ThanNhan obj) {
		// TODO Auto-generated method stub
		return new ThanNhanDAO().update(obj);
	}

}
