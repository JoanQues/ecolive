package com.ecolive.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecolive.dto.Category;
import com.ecolive.dto.Product;

public class ProductDao {

	/*
	 * Llista tots els clients de la base de dades
	 * 
	 */
	//INTENTO DE JOIN//  + "INNER JOIN categories" + "ON pro_cat_id = cat_id"
	public List<Product> listar() {
		String SQL_SELECT = "SELECT pro_id, pro_name, pro_desc, pro_price, pro_weigth" + " FROM products";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Product product = null;
		List<Product> products = new ArrayList<>();
		
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("pro_id");
				String name = rs.getString("pro_name");
				String desc = rs.getString("pro_desc");
				double price = rs.getDouble("pro_price");
				double weigth = rs.getDouble("pro_weigth");

				product = new Product (id, name, desc, price, weigth);
				products.add(product);
			}
		} catch (SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			DBConnection.close(rs);
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		return products;
	}

	/*
	 * Recupera un client a la base de dades segons el seu ID
	 * 
	 */
		
	public Product findById(Product product) {
		String SQL_SELECT_BY_ID = "SELECT pro_id, pro_name, pro_desc, pro_price, pro_weigth"
				+ " FROM products WHERE pro_id = ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
			stmt.setInt(1, product.getId());
			rs = stmt.executeQuery();
			rs.absolute(1);// nos posicionamos en el primer registro devuelto

			String name = rs.getString("pro_name");
			String description = rs.getString("pro_desc");
			Double price = rs.getDouble("pro_price");
			Double weigth = rs.getDouble("pro_weigth");

			product.setName(name);
			product.setDescription(description);
			product.setPrice(price);
			product.setWeigth(weigth);

		} catch (SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			DBConnection.close(rs);
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		return product;
	}

/*
	 * Crea un client a la base de dades
	 * 
*/
	
	public int create(Product product) {
		String SQL_INSERT = "INSERT INTO products(pro_name, pro_desc, pro_price, pro_weigth)"
				+ " VALUES(?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, product.getName());
			stmt.setString(2, product.getDescription());
			stmt.setDouble(3, product.getPrice());
			stmt.setDouble(4, product.getWeigth());
			
			rows = stmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		return rows;
	}

	/*
	 * Modifica un client de la base de dades
	 * 
	*/ 
	public int update(Product product) {
		String SQL_UPDATE = "UPDATE products "
				+ " SET pro_name=?, pro_desc=?, pro_price=?, pro_weigth=? WHERE pro_id=?";
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE);
			int i = 1;
			stmt.setString(i++, product.getName());
			stmt.setString(i++, product.getDescription());
			stmt.setDouble(i++, product.getPrice());
			stmt.setDouble(i++, product.getWeigth());
			stmt.setInt(i++, product.getId());

			rows = stmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		return rows;
	}

	 /* Esborra un client de la base de dades*/
	 
	public int delete(Product product) {
		String SQL_DELETE = "DELETE FROM products WHERE pro_id = ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, product.getId());
			rows = stmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		return rows;
	}
	
}