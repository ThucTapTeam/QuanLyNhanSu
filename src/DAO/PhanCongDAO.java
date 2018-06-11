package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Connect.connectSQL;
import Model.PhanCongDA;
import Model.PhongBan;

public class PhanCongDAO implements BaseInterfaceDAO<PhanCongDA> {

	@Override
	public boolean insert(PhanCongDA obj) {
		Connection connect = null;
		String sql = "Insert INTO dbo.PhanCongDA (MaNV,MaDA,SoGio)VALUES (?,?,?)";
		PreparedStatement prepare = null;

		try {
			connect = connectSQL.connect();
			prepare = connect.prepareStatement(sql);
			connect.setAutoCommit(false);
			prepare.setInt(1, obj.getMaNV());
			prepare.setInt(2,obj.getMaDA());
			prepare.setInt(3,obj.getSoGio());
			connect.setAutoCommit(true);
			prepare.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (prepare != null) {
				try {
					prepare.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connect != null) {
				try {
					connect.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return true;
	}

	@Override
	public List<PhanCongDA> getList(String sql) {
		Connection connect = null;
		Statement statement = null;
		ResultSet rs = null;
		List<PhanCongDA> list = null;
		try {
			connect = connectSQL.connect();
			list = new ArrayList<>();
			// Statement creation
			statement = connect.createStatement();
			// for retrieve data
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				PhanCongDA phancong = new PhanCongDA();
				phancong.setMaNV(rs.getInt("MaNV"));
				phancong.setMaDA(rs.getInt("MaDA"));
				phancong.setSoGio(rs.getInt("SoGio"));
				list.add(phancong);
			}
			rs.close();
			statement.close();
			connect.close();
			return list;

		} catch (ClassNotFoundException e) {
			return list;
		} catch (SQLException e) {
			return list;
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connect != null) {
				try {
					connect.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public boolean delete(PhanCongDA obj) {
		Connection connect;
		int check = 0;
		try {
			connect = connectSQL.connect();
			Statement statement = connect.createStatement();
			check = statement.executeUpdate("delete from PhanCongDA where MaNV = " + obj.getMaNV() + "and MaDA =" + obj.getMaDA());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();

		}
		if (check >= 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(PhanCongDA obj) {
		Connection connect;
		Statement statement;
		int check = 0;
		try {
			connect = connectSQL.connect();
			statement = connect.createStatement();
			String sql = "update PhanCongDA set SoGio = ? where MaNV = ? and MaDA= ?";
			PreparedStatement prepare = connect.prepareStatement(sql);
			prepare = connect.prepareStatement(sql);
			connect.setAutoCommit(false);	
			prepare.setInt(1, obj.getSoGio());
			prepare.setInt(2, obj.getMaNV());
			prepare.setInt(3, obj.getMaDA());
			check = prepare.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (check > 0) {
			return true;
		}
		return false;
	}


}
