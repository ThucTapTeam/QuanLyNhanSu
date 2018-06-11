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
import Model.DuAn;
import Model.DuAn;

public class DuanDAO implements BaseInterfaceDAO<DuAn> {

	@Override
	public boolean insert(DuAn obj) {
		Connection connect = null;
		String sql = "Insert INTO dbo.DuAn (TenDA,MaDA,DDiem,MaPB)VALUES (?,?,?,?)";
		PreparedStatement prepare = null;

		try {
			connect = connectSQL.connect();
			prepare = connect.prepareStatement(sql);
			connect.setAutoCommit(false);
			prepare.setString(1, obj.getTenDA());
			prepare.setInt(2,obj.getMaDA());
			prepare.setString(3, obj.getDiaDiem());
			prepare.setInt(4, obj.getMaPB());
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
	public List<DuAn> getList(String sql) {
		Connection connect = null;
		Statement statement = null;
		ResultSet rs = null;
		List<DuAn> list = null;
		try {
			connect = connectSQL.connect();
			list = new ArrayList<>();
			// Statement creation
			statement = connect.createStatement();
			// for retrieve data
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				DuAn duan = new DuAn();
				duan.setTenDA(rs.getString("TenDA"));

				duan.setMaDA(rs.getInt("MaDA"));
				
				duan.setDiaDiem(rs.getString("DDiem"));

				duan.setMaPB(rs.getInt("MaPB"));
				list.add(duan);

				
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
	public boolean delete(DuAn obj) {
		Connection connect;
		int check = 0;
		try {
			connect = connectSQL.connect();
			Statement statement = connect.createStatement();
			check = statement.executeUpdate("delete from DuAn where MaDA = " + obj.getMaDA());
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
	public boolean update(DuAn obj) {
		Connection connect;
		Statement statement;
		int check = 0;
		try {
			connect = connectSQL.connect();
			statement = connect.createStatement();
			String sql = "update DuAn set TenDA = ?,DDiem=?,MaPB = ? where MaDA = ? ";
			PreparedStatement prepare = connect.prepareStatement(sql);
			prepare = connect.prepareStatement(sql);
			connect.setAutoCommit(false);
			prepare.setString(1,obj.getTenDA());
			prepare.setString(2, obj.getDiaDiem());
			prepare.setInt(3, obj.getMaPB());
			prepare.setInt(4, obj.getMaDA());
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
