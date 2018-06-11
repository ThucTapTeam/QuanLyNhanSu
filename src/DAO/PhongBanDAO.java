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
import Model.PhongBan;

public class PhongBanDAO implements BaseInterfaceDAO<PhongBan> {

	@Override
	public boolean insert(PhongBan obj) {
		Connection connect = null;
		String sql = "Insert INTO dbo.PhongBan (MaPB,TenPB,MaTP,NgayNhanChuc)VALUES (?,?,?,?,)";
		PreparedStatement prepare = null;

		try {
			connect = connectSQL.connect();
			prepare = connect.prepareStatement(sql);
			connect.setAutoCommit(false);
			prepare.setInt(1, obj.getMaPB());
			prepare.setString(2,obj.getTenPB());
			prepare.setInt(3, obj.getMaTP());
			prepare.setDate(4,(Date) obj.getNgayNhanChuc());
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
	public List<PhongBan> getList(String sql) {
		Connection connect = null;
		Statement statement = null;
		ResultSet rs = null;
		List<PhongBan> list = null;
		try {
			connect = connectSQL.connect();
			list = new ArrayList<>();
			// Statement creation
			statement = connect.createStatement();
			// for retrieve data
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				PhongBan phongban = new PhongBan();
				phongban.setMaPB(rs.getInt("MaPB"));
				phongban.setTenPB(rs.getString("TenPB"));
				phongban.setMaTP(rs.getInt("MaTP"));
				phongban.setNgayNhanChuc(rs.getDate("NgayNhanChuc"));
				list.add(phongban);
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
	public boolean delete(PhongBan obj) {
		Connection connect;
		int check = 0;
		try {
			connect = connectSQL.connect();
			Statement statement = connect.createStatement();
			check = statement.executeUpdate("delete from PhongBan where MaPB = " + obj.getMaPB());
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
	public boolean update(PhongBan obj) {
		Connection connect;
		Statement statement;
		int check = 0;
		try {
			connect = connectSQL.connect();
			statement = connect.createStatement();
			String sql = "update PhongBan set TenPB = ? ,MaTP = ? ,NgayNhanChuc = ? where MaPB = ? ";
			PreparedStatement prepare = connect.prepareStatement(sql);
			prepare = connect.prepareStatement(sql);
			connect.setAutoCommit(false);	
			prepare.setString(1,obj.getTenPB());
			prepare.setInt(2, obj.getMaTP());
			prepare.setDate(3,(Date) obj.getNgayNhanChuc());
			prepare.setInt(4, obj.getMaPB());
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
