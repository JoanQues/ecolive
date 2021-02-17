package com.ecolive.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecolive.dao.ProductDao;
import com.ecolive.dto.Product;

@WebServlet("/product")
public class ProductController extends HttpServlet {
	
	private static final long serialVersionUID = -7948693285569109704L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recuperam l'acció a realitzar i es crida a la funció corresponent
		String action = request.getParameter("action");
		if (action != null) {
			switch (action) {
			case "edit":
				this.editProduct(request, response);
				break;
			default:
				this.showListProduct(request, response);
			}
		} else {
			this.showListProduct(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Recuperam l'acció a realitzar i es crida a la funció corresponent
		String action = request.getParameter("action");
		if (action != null) {
			switch (action) {
			case "delete":
				this.deleteProduct(request, response);
				break;
			case "insert":
				this.insertProduct(request, response);
				break;
			case "update":
				this.updateProduct(request, response);
				break;
			default:
				this.showListProduct(request, response);
			}
		} else {
			this.showListProduct(request, response);
		}
	}

	private void showListProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> products = new ProductDao().listar();

		System.out.println("products = " + products);
		
		// Dades a desar a la sessió de la classe
		HttpSession session = request.getSession();
		session.setAttribute("products", products);
		response.sendRedirect("frmProducts.jsp");
	}

	private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");
		
		// recuperamos los valores del formulario agregarCliente
		String name = request.getParameter("name");
		String desc = request.getParameter("description");
		Double price = Double.parseDouble(request.getParameter("price"));
		Double weigth = Double.parseDouble(request.getParameter("weigth"));

		// Creamos el objeto de cliente (modelo)
		Product product = new Product(name, desc, price, weigth);

		// Insertamos el nuevo objeto en la base de datos
		int registrosModificados = new ProductDao().create(product);
		System.out.println("Registres modificats:" + registrosModificados);

		// Redirigimos hacia accion por default
		this.showListProduct(request, response);
	}
	
	private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");
		System.out.println("Modificar producte");
		
		// Recuperam els valors del formulari editProduct
		int idProduct = Integer.parseInt(request.getParameter("idProduct"));
		String name = request.getParameter("name");
		String desc = request.getParameter("desc");
		Double price = Double.parseDouble(request.getParameter("price"));
		Double weigth = Double.parseDouble(request.getParameter("weigth"));
		
		Product product = new Product(idProduct,name, desc,price,weigth);

		int registrosModificados = new ProductDao().update(product);
		System.out.println("Registres modificats:" + registrosModificados);

		this.showListProduct(request, response);
	}

	private void editProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");
		System.out.println("Modificar producte");
		
		// Recuperam els valors del formulari editClient
		int idProduct = Integer.parseInt(request.getParameter("idProduct"));
		Product product = new ProductDao().findById(new Product(idProduct));
		request.setAttribute("product", product);
		String jspEditar = "/editProduct.jsp";
		request.getRequestDispatcher(jspEditar).forward(request, response);

	}

	private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recuperamos los valores del formulario editarCliente
		int idProduct = Integer.parseInt(request.getParameter("idProduct"));

		// Creamos el objeto de cliente (modelo)
		Product product = new Product(idProduct);

		// Eliminamos el objeto en la base de datos
		int registrosModificados = new ProductDao().delete(product);
		System.out.println("Registres modificats:" + registrosModificados);

		// Redirigimos hacia accion por default
		this.showListProduct(request, response);
	}
}
