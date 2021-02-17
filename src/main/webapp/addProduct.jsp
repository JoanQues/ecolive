<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="modal fade" id="addProductModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Add Product</h5> 
                <button class="close" data-dismiss="modal"> <span>&times;</span> </button>
            </div>
            
            <form action="${pageContext.request.contextPath}/product?action=insert" method="POST" class="was-validated">
                
                <div class="modal-body">
                    <div class="form-group">
                        <label for="name">Name</label>
                        <input type="text" class="form-control" name="name" required />
                    </div>
                    <div class="form-group">
                        <label for="description">Description</label>
                        <input type="text" class="form-control" name="description" required />
                    </div>
                    <div class="form-group">
                        <label for="price">Price</label>
                        <input type="number" step="0.01" class="form-control" name="price" required>
                    </div>
                    <div class="form-group">
                        <label for="weigth">Weigth</label>
                        <input type="number" step="0.01" class="form-control" name="weigth" required />
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Save</button>
                </div>    
            </form>
        </div>
    </div>
</div>
    