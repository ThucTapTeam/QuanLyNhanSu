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
import Model.PhongBan;
import Model.ThanNhan;

public class ThanNhanDAO implements BaseInterfaceDAO<ThanNhan> {

	@Override
	public boolean insert(ThanNhan obj) {
		Connection connect = null;
		String sql = "Insert INTO dbo.SanPham (MaNV,TenTN,GT,NgaySinh,QuanHe)VALUES (?,?,?,?,?)";
		PreparedStatement prepare = null;
		boolean GT;
		if(obj.getGioiTinh().toLowerCase()=="nam")
			GT = true;
		else
			GT= false;

		try {
			connect = connectSQL.connect();
			prepare = connect.prepareStatement(sql);
			connect.setAutoCommit(false);
			prepare.setInt(1, obj.getMaNV());
			prepare.setString(2,obj.getTenTN());
			prepare.setBoolean(3, GT);
			prepare.setDate(4, (Date) obj.getNgaySinh());
			prepare.setString(5,obj.getQuanHe());
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
	public List<ThanNhan> getList(String sql) {
		Connection connect = null;
		Statement statement = null;
		ResultSet rs = null;
		List<ThanNhan> list = null;
		try {
			connect = connectSQL.connect();
			list = new ArrayList<>();
			// Statement creation
			statement = connect.createStatement();
			// for retrieve data
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				ThanNhan thannhan = new ThanNhan();
				thannhan.setMaNV(rs.getInt("MaNV"));
				thannhan.setTenTN(rs.getString("TenTN"));
				thannhan.setGioiTinh(rs.getBoolean("GT"));
				thannhan.setNgaySinh(rs.getDate("NgaySinh"));
				thannhan.setQuanHe(rs.getString("QuanHe"));
				list.add(thannhan);
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
	public boolean delete(ThanNhan obj) {
		Connection connect;
		int check = 0;
		try {
			connect = connectSQL.connect();
			Statement statement = connect.createStatement();
			check = statement.executeUpdate("delete from ThanNhan where MaTN = " + obj.getMaNV() + "and TenTN =" + obj.getTenTN());
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
	public boolean update(ThanNhan obj) {
		Connection connect;
		Statement statement;
		int check = 0;
		boolean GT;
		if(obj.getGioiTinh().toLowerCase()=="nam")
			GT = true;
		else
			GT= false;
		try {
			connect = connectSQL.connect();
			statement = connect.createStatement();
			String sql = "update SanPham set GT = ? ,NgaySinh = ?, QuanHe = ? where MaNV = ? and TenTN = ? ";
			PreparedStatement prepare = connect.prepareStatement(sql);
			prepare = connect.prepareStatement(sql);
			connect.setAutoCommit(false);		
			prepare.setBoolean(1, GT);
			prepare.setDate(2,(Date) obj.getNgaySinh());
			prepare.setString(3,obj.getQuanHe());
			prepare.setInt(4, obj.getMaNV());
			prepare.setString(5,obj.getTenTN());
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
