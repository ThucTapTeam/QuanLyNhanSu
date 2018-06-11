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
import Model.NhanVien;

public class NhanVienDAO implements BaseInterfaceDAO<NhanVien> {

	@Override
	public boolean insert(NhanVien obj) {
		Connection connect = null;
		String sql = "Insert INTO dbo.NhanVien (MaNV,TenNV,HoNV,NgaySinh,DiaChi,GT,Luong,MaPB)VALUES (?,?,?,?,?,?,?,?)";
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
			prepare.setString(2,obj.getTenNV());
			prepare.setString(3, obj.getHoNV());
			prepare.setDate(4, obj.getNgaySinh());
			prepare.setString(5, obj.getDiaChi());
			prepare.setBoolean(6, GT);
			prepare.setInt(7, obj.getLuong());
			prepare.setInt(8, obj.getMaPB());
			//prepare.setString(9,obj.getID());
			//prepare.setString(10, obj.getPassword());
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
	public List<NhanVien> getList(String sql) {
		Connection connect = null;
		Statement statement = null;
		ResultSet rs = null;
		List<NhanVien> list = null;
		try {
			connect = connectSQL.connect();
			list = new ArrayList<>();
			// Statement creation
			statement = connect.createStatement();
			// for retrieve data
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				NhanVien nhanvien = new NhanVien();
				nhanvien.setMaNV(rs.getInt("MaNV"));
				nhanvien.setTenNV(rs.getString("TenNV"));
				nhanvien.setHoNV(rs.getString("HoNV"));
				nhanvien.setNgaySinh(rs.getDate("NgaySinh"));
				nhanvien.setDiaChi(rs.getString("DiaChi"));
				nhanvien.setGioiTinh(rs.getBoolean("GT"));
				nhanvien.setLuong(rs.getInt("Luong"));
				nhanvien.setMaPB(rs.getInt("MaPB"));
				nhanvien.setID(rs.getString("ID"));
				nhanvien.setPassword(rs.getString("Password"));
				list.add(nhanvien);
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
	public boolean delete(NhanVien obj) {
		Connection connect;
		int check = 0;
		try {
			connect = connectSQL.connect();
			Statement statement = connect.createStatement();
			check = statement.executeUpdate("delete from NhanVien where MaNV = " + obj.getMaNV());
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
	public boolean update(NhanVien obj) {
		Connection connect;
		Statement statement;
		int check = 0;
		int GT;
		if(obj.getGioiTinh().toLowerCase()=="nam")
			GT = 1;
		else
			GT= 0;
		try {
			connect = connectSQL.connect();
			statement = connect.createStatement();
			String sql = "update NhanVien set  TenNV = ?,HoNV=?,NgaySinh=?,DiaChi=?,Luong=?,MaPB=? where MaNV = ?";
			PreparedStatement prepare = connect.prepareStatement(sql);
			prepare = connect.prepareStatement(sql);
			connect.setAutoCommit(false);
			prepare.setString(1,obj.getTenNV());
			prepare.setString(2, obj.getHoNV());
			prepare.setDate(3, (Date) obj.getNgaySinh());
			prepare.setString(4, obj.getDiaChi());
			//prepare.setInt(5, GT);
			prepare.setInt(5, obj.getLuong());
			prepare.setInt(6, obj.getMaPB());
			prepare.setInt(7, obj.getMaNV());
			connect.setAutoCommit(true);
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
