<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es-ES" variant="euro"/>

 <div class="col-md 3">
   <h3>Productes</h3>
</div>
 <div class="col-md-12">
  <form action="">
  	<label for="filtro">Categorias</label>
    <select id="filtro" name="categories">
    	<option>1</option>
        <option>2</option>
        <option>3</option>
  	</select>
	<label for="nom">Nom producte</label>
 	<input id="nom" type="text">
	<label for="preu">Preu</label>
	<input id="preu" type="range" min="5" max="200">
	<input type="submit" value="Filtra">
  </form>
  <div class="row">
  <c:forEach var="product" items="${products}" varStatus="status" >
  	<div class="card mb-4 shadow-sm" style="width: 14rem; margin: 10px;">
		<div class="card-body">
			<h5 class="card-title">${product.name}</h5>
			<p class="card-text">Description: ${product.description}</p>
			<p class="card-text">Price: ${product.price}€</p>
			<p class="card-text">Weigth: ${product.weigth}g</p>
		</div>
		<input style="margin-bottom:5px" type="button" class="btn btn-outline-primary" name="cart" value="Add to cart">
		<a href="${pageContext.request.contextPath}/product?action=edit&idProduct=${product.id}"
                                           class="btn btn-outline-secondary">
                                            <i class="fas fa-angle-double-right"></i> Edit Product
                                        </a>
	</div>
  </c:forEach>
  </div>
</div>

                        