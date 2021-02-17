<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/f90d3bf50d.js" crossorigin="anonymous"></script>

        <title>Edit Product</title>
    </head>
    <body class="container">
        <!--Cabecero-->
        <%@ include file="/common/header.jsp" %> 

        <form name="frm-product" action="${pageContext.request.contextPath}/product" method="POST" class="was-validated">
           <input id="input-action" type="hidden" name="action" value="update" />
           <input type="hidden" name="idProduct" value="${product.id}" />
           
            <!--Botones de Navegacion -->
        	<section id="actions" class="py-4 mb-4 bg-light">
			    <div class="container">
			        <div class="row">
			            <div class="col-md-3">
			                <a href="frmProducts.jsp" class="btn btn-ligth btn-block">
			                    <i class="fas fa-arrow-left"></i> Back to main page
			                </a>
			            </div>
			            <div class="col-md-3">
			                <button type="submit" class="btn btn-success btn-block">
			                    <i class="fas fa-check"></i> Save Product
			                </button>
			            </div>
			            <div class="col-md-3">
			                <button id="btn-delete" type="button" class="btn btn-danger btn-block">
			                    <i class="fas fa-trash"></i> Delete Product
			                </button>
			            </div>
			        </div>
			    </div>
			</section>
        	
            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Edit Product</h4>
                                </div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="name">Name</label>
                                        <input type="text" class="form-control" name="name" required value="${product.name}">
                                    </div>
                                    <div class="form-group">
                                        <label for="description">Description</label>
                                        <input type="text" class="form-control" name="desc" required value="${product.description}">
                                    </div>
                                    <div class="form-group">
                                        <label for="price">Price</label>
                                        <input type="number" step="0.01" class="form-control" name="price" required value="${product.price}">
                                    </div>
                                    <div class="form-group">
                                        <label for="weigth">Weigth</label>
                                        <input type="number" step="0.01" class="form-control" name="weigth" required value="${product.weigth}">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
                       
        </form>

        <!--Pie de Pagina-->
        <%@ include file="/common/footer.jsp" %> 

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script type="text/javascript">
        	let btnDelete = document.getElementById("btn-delete");
        	btnDelete.onclick = function(){
        		document.getElementById("input-action").value ="delete";
        		document.forms["frm-product"].submit();
        	}
        
        </script>

    </body>
</html>
