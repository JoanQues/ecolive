package com.ecolive.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecolive.dto.Client;

public class ClientDao {

	/*
	 * Llista tots els clients de la base de dades
	 * 
	 */
	public List<Client> listar() {
		String SQL_SELECT = "SELECT cli_id, cli_dni, cli_name, cli_surname, cli_phone, cli_email" + " FROM clients";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Client client = null;
		List<Client> clients = new ArrayList<>();
		
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("cli_id");
				String dni = rs.getString("cli_dni");
				String name = rs.getString("cli_name");
				String surname = rs.getString("cli_surname");
				String email = rs.getString("cli_email");
				int phone = rs.getInt("cli_phone");

				client = new Client(id, dni, name, surname, phone, email);
				clients.add(client);
			}
		} catch (SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			DBConnection.close(rs);
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		return clients;
	}

	/*
	 * Recupera un client a la base de dades segons el seu ID
	 * 
	 */
	public Client findById(Client client) {
		String SQL_SELECT_BY_ID = "SELECT cli_id, cli_dni, cli_name, cli_surname, cli_phone, cli_email"
				+ " FROM clients WHERE cli_id = ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
			stmt.setInt(1, client.getId());
			rs = stmt.executeQuery();
			rs.absolute(1);// nos posicionamos en el primer registro devuelto
			String dni = rs.getString("cli_dni");
			String name = rs.getString("cli_name");
			String surname = rs.getString("cli_surname");
			String email = rs.getString("cli_email");
			int phone = rs.getInt("cli_phone");
			
			client.setDni(dni);
			client.setName(name);
			client.setSurname(surname);
			client.setEmail(email);
			client.setPhone(phone);


		} catch (SQLException ex) {
			ex.printStackTrace(System.out);
		} finally {
			DBConnection.close(rs);
			DBConnection.close(stmt);
			DBConnection.close(conn);
		}
		return client;
	}

	/*
	 * Crea un client a la base de dades
	 * 
	 */
	public int create(Client client) {
		String SQL_INSERT = "INSERT INTO clients(cli_dni, cli_name, cli_surname, cli_email, cli_phone) "
				+ " VALUES(?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, client.getDni());
			stmt.setString(2, client.getName());
			stmt.setString(3, client.getSurname());
			stmt.setString(4, client.getEmail());
			stmt.setInt(5, client.getPhone());
			

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
	public int update(Client client) {
		String SQL_UPDATE = "UPDATE clients "
				+ " SET cli_dni=?, cli_name=?, cli_surname=?, cli_email=?, cli_phone=? WHERE cli_id=?";
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE);
			int i = 1;
			stmt.setString(i++, client.getDni());
			stmt.setString(i++, client.getName());
			stmt.setString(i++, client.getSurname());
			stmt.setString(i++, client.getEmail());
			stmt.setInt(i++, client.getPhone());
			stmt.setInt(i++, client.getId());

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
	 * Esborra un client de la base de dades
	 * 
	 */
	public int delete(Client client) {
		String SQL_DELETE = "DELETE FROM clients WHERE cli_id = ?";
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows = 0;
		try {
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, client.getId());
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