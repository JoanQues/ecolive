<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="modal fade" id="addClientModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Add Client</h5> 
                <button class="close" data-dismiss="modal"> <span>&times;</span> </button>
            </div>
            
            <form action="${pageContext.request.contextPath}/client?action=insert" method="POST" class="was-validated">
                
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nombre">Dni</label>
                        <input type="text" class="form-control" name="dni" required />
                    </div>
                    <div class="form-group">
                        <label for="nombre">Name</label>
                        <input type="text" class="form-control" name="name" required />
                    </div>
                    <div class="form-group">
                        <label for="surname">Surname</label>
                        <input type="text" class="form-control" name="surname" required />
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" name="email" required> 
                    </div>
                    <div class="form-group">
                        <label for="phone">Phone</label>
                        <input type="tel" class="form-control" name="phone" required />
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Save</button>
                </div>    
            </form>
        </div>
    </div>
</div>
    