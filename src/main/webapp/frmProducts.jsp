<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta http-equiv=”Content-Type” content=”text/html; charset=UTF-8″>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Ecolive</title> 
    </head>
    <body class="container">
        <!--Header-->
        <jsp:include page="/common/header.jsp" />  
      

        <!--Botones de navegacion-->
        <div class="row">
            <div style="margin-top: 2%; margin-bottom: 1%;" class="col-md-2">
                <a href="#" class="btn btn-success"
                   data-toggle="modal" data-target="#addProductModal">
                    <i class="fas fa-plus"></i> Add Products
                </a>
            </div>
            <div style="margin-top: 2%; margin-bottom: 1%;">
                <a href="${pageContext.request.contextPath}/product?action=list" class="btn btn-success">
                    <i class="fas fa-plus"></i> List Products
                </a>
            </div>
        </div>

        <!--Listado Clientes --> 
        <jsp:include page="/listProducts.jsp"/>
       
        
        <!-- Agregar cliente MODAL -->
		<jsp:include page="/addProduct.jsp"/>

        <!--Footer-->
        <jsp:include page="/common/footer.jsp" /> 

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    </body>
</html>
