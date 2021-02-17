package com.ecolive.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecolive.dao.ClientDao;
import com.ecolive.dto.Client;

@WebServlet("/client")
public class ClientController extends HttpServlet {
	
private static final long serialVersionUID = -7558166539389234332L;
	   
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recuperam l'acció a realitzar i es crida a la funció corresponent
		String action = request.getParameter("action");
		if (action != null) {
			switch (action) {
			case "edit":
				this.editClient(request, response);
				break;
			case "login":
				//this.loginClient(request, response);
				break;
			default:
				this.showListClient(request, response);
			}
		} else {
			this.showListClient(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Recuperam l'acció a realitzar i es crida a la funció corresponent
		String action = request.getParameter("action");
		if (action != null) {
			switch (action) {
			case "delete":
				this.deleteClient(request, response);
				break;
			case "insert":
				this.insertClient(request, response);
				break;
			case "update":
				this.updateClient(request, response);
				break;
			default:
				this.showListClient(request, response);
			}
		} else {
			this.showListClient(request, response);
		}
	}

	private void showListClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Client> clientes = new ClientDao().listar();

		System.out.println("clientes = " + clientes);
		
		// Dades a desar a la sessió de la classe
		HttpSession session = request.getSession();
		session.setAttribute("clientes", clientes);
		session.setAttribute("totalClientes", clientes.size());

		// request.getRequestDispatcher("frmClient.jsp").forward(request, response);
		response.sendRedirect("frmProducts.jsp");
	}

	private void editClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recuperamos el idCliente
		int idCliente = Integer.parseInt(request.getParameter("idClient"));
		Client cliente = new ClientDao().findById(new Client(idCliente));
		request.setAttribute("cliente", cliente);
		String jspEditar = "/editClient.jsp";
		request.getRequestDispatcher(jspEditar).forward(request, response);

	}

	private void insertClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");
		
		// recuperamos los valores del formulario agregarCliente
		String dni = request.getParameter("dni");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String email = request.getParameter("email");
		int phone = Integer.parseInt(request.getParameter("phone"));

		// Creamos el objeto de cliente (modelo)
		Client cliente = new Client(dni, name, surname, phone, email);

		// Insertamos el nuevo objeto en la base de datos
		int registrosModificados = new ClientDao().create(cliente);
		System.out.println("Registres modificats:" + registrosModificados);

		// Redirigimos hacia accion por default
		this.showListClient(request, response);
	}

	private void updateClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");
		System.out.println("Modificar client");
		
		// Recuperam els valors del formulari editClient
		int idCliente = Integer.parseInt(request.getParameter("idClient"));
		String dni = request.getParameter("nif");
		String name = request.getParameter("name");
		System.out.println("Nombre:" + name);
		String surname = request.getParameter("surmane");
		String email = request.getParameter("email");
		int phone = Integer.parseInt(request.getParameter("phone"));

		// Creamos el objeto de cliente (modelo)
		Client cliente = new Client(idCliente,dni, name, surname, phone, email);

		// Modificar el objeto en la base de datos
		int registrosModificados = new ClientDao().update(cliente);
		System.out.println("Registres modificats:" + registrosModificados);

		// Redirigimos hacia accion por default
		this.showListClient(request, response);
	}

	private void deleteClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recuperamos los valores del formulario editarCliente
		int idCliente = Integer.parseInt(request.getParameter("idClient"));

		// Creamos el objeto de cliente (modelo)
		Client cliente = new Client(idCliente);

		// Eliminamos el objeto en la base de datos
		int registrosModificados = new ClientDao().delete(cliente);
		System.out.println("Registres modificats:" + registrosModificados);

		// Redirigimos hacia accion por default
		this.showListClient(request, response);
	}

}
