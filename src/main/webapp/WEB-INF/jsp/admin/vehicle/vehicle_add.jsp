<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/navbar.jsp" %>
<%@include file="../../includes/subnav_admin.jsp" %>

<script>
    $(document).ready(function() {

        $("#successAlert").delay(8000).fadeOut(2000); //milliseconds
        $("#warningAlert").delay(10000).fadeOut(2000);
    });
</script>

<br>
<div class="container-fluid">
<div class="row">
    <%--SIDEBAR HERE--%>

    <%@include file="vehicle_sidebar.jsp" %>

    <div id="main" class="col-7">
        <c:set var="vehicle" value="${vehicle}" />
            <form:form class="form-horizontal" modelAttribute="vehicleVO" action="/admin/vehicle/add" method="post">
                <fieldset>
                <legend>Vehicle Management</legend>

                <div class="form-group">
                    <label for="inputNewVehicleMake" class="col-3 control-label">Vehicle Make:</label>
                      <div class="col-9">
                         <form:select path="newVehicleMake" type="text" class="form-control"
                            id="inputNewVehicleMake" placeholder="Vehicle Make">
                            <c:forEach var="vehicleMake" items="${makeList}"  >
                             <form:option value="${vehicleMake.id}">${vehicleMake.vehicleMakeName}</form:option>
                            </c:forEach >
                         </form:select>
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputNewVehicleModel" class="col-3 control-label">Vehicle Model:</label>
                    <div class="col-9">
                        <form:select path="newVehicleModel" type="text" class="form-control"
                                    id="inputNewVehicleModel" placeholder="Vehicle Model">
                            <c:forEach var="vehicleModel" items="${modelList}" >
                                <form:option value="${vehicleModel.id}">${vehicleModel.vehicleModelName}</form:option>
                            </c:forEach>

                        </form:select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputNewVehicle" class="col-3 control-label">Vehicle Year:</label>
                    <div class="col-9">
                        <form:input path="newVehicleYear" type="text" class="form-control"
                                    id="inputNewVehicle" placeholder="Vehicle Year"></form:input>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputNewVehicle" class="col-3 control-label">Vehicle License Plate:</label>
                    <div class="col-9">
                        <form:input path="newVehicleLicensePlate" type="text" class="form-control"
                                    id="inputNewVehicle" placeholder="Vehicle License Plate"></form:input>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputNewVehicle" class="col-3 control-label">Vehicle VIN:</label>
                    <div class="col-9">
                        <form:input path="newVehicleVIN" type="text" class="form-control"
                                    id="inputNewVehicle" placeholder="Vehicle VIN"></form:input>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputNewVehicle" class="col-3 control-label">Vehicle Color:</label>
                    <div class="col-9">
                        <form:input path="newVehicleColor" type="text" class="form-control"
                                    id="inputNewVehicle" placeholder="Vehicle Color"></form:input>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-10 col-offset-2">
                        <form:button type="reset" value="cancel" class="btn btn-secondary">Cancel</form:button>
                        <form:button type="submit" value="save" class="btn btn-primary">Save</form:button>
                    </div>
                </div>

            </fieldset>
            </form:form>
        </div>



        <div class="col-3" id="alerts">
            <%--Alerts--%>
            <div class="${successAlert == null ? 'hidden' : successAlert}" id="successAlert">
                <div class="alert alert-dismissible alert-success">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>Vehicle Added!!</strong> You successfully added a new Vehicle to the Database</a>.
                </div>
            </div>

            <div class="${warningAlert == null ? 'hidden' : warningAlert}" id="warningAlert">
                <div class="alert alert-dismissible alert-warning">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <h4 class="alert-heading">Warning!</h4>
                    <p class="mb-0">Best check yo self, you're not looking too good. Try again!</p>
                </div>
            </div>

            <div class="${errorAlert == null ? 'hidden' : errorAlert}" id="errorAlert">
                <div class="alert alert-dismissible alert-danger">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong>Oh snap!</strong> There was an error submitting, please correct and try submitting again.
                </div>
            </div>
        </div>

</div>
</div>


<%@include file="../../includes/footer.jsp" %>