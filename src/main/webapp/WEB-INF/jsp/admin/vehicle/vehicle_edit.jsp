<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/navbar.jsp" %>
<%@include file="../../includes/subnav_admin.jsp" %>

<%--<script>--%>

    <%--$(document).ready(function() {--%>
        <%--//attach an onclick function to the remove buttons--%>
        <%--$('.remove_button').click(function() {--%>
            <%--//log name of button, and contents of associated text box--%>
            <%--console.log(this.name);--%>
            <%--console.log($('#'+ this.name).val());--%>
            <%--//clear the value / contents of the textbox--%>
            <%--$('#'+ this.name).val('');--%>
            <%--//submit the form--%>
            <%--$('#vehicleVO').submit();--%>

        <%--});--%>
    <%--});--%>
<%--</script>--%>

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
            <form:form  modelAttribute="vehicleVO" action="/admin/vehicle/update/${vehicle.id}" method="post">

            <div class="row">
                <label for="vehicleMakeName" class="col-2 offset-1 control-label" >Vehicle Make</label>
                    <div class="input-group col-7">
                        <form:select path="newVehicleMake" type="text" id="vehicleMakeName" cssClass="form-control">
                            <c:forEach var="vehicleMake" items="${makeList}">
                                <c:choose>
                                    <c:when test="${vehicleMake.id == vehicle.vehicleModel.vehicleMake.id}">
                                         <form:option selected="true" value="${vehicleMake.id}" >${vehicleMake.vehicleMakeName}</form:option>
                                    </c:when>
                                    <c:otherwise>
                                        <form:option value="${vehicleMake.id}" >${vehicleMake.vehicleMakeName}</form:option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </form:select>
                    </div>
            </div>
            <br>
            <div class="row">
                <label for="vehicleModelName" class="col-2 offset-1 control-label" >Vehicle Model</label>
                    <div class="input-group col-7">
                        <form:select path="newVehicleModel" type="text" id="vehicleModelName" cssClass="form-control">
                            <c:forEach var="vehicleModel" items="${modelList}" >
                                <c:choose>
                                    <c:when test="${vehicleModel.id == vehicle.vehicleModel.id}">
                            <form:option selected="true" value="${vehicleModel.id}" >${vehicleModel.vehicleModelName}</form:option>
                                    </c:when>
                                    <c:otherwise>
                                        <form:option value="${vehicleModel.id}" >${vehicleModel.vehicleModelName}</form:option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </form:select>
                    </div>
            </div>
            <br>
            <div class="row">
                <label for="year" class="col-2 offset-1 control-label" >Year</label>
                    <div class="input-group col-7">
                        <form:input path="newVehicleYear" value="${vehicle.year}" type="text" id="year" cssClass="form-control"></form:input>
                        <%--<span class="input-group-btn col-1">--%>
                        <%--<button name="year" class="btn btn-secondary remove_button" type="button">Remove</button>--%>
                        <%--</span>--%>
                    </div>
            </div>
                   <br>

            <div class="row">
                <label for="licensePlate" class="col-2 offset-1 control-label" >License Plate</label>
                    <div class="input-group col-7">
                        <form:input path="newVehicleLicensePlate" value="${vehicle.licensePlate}" type="text" id="licensePlate" cssClass="form-control"></form:input>
                        <%--<span class=" col-1">--%>
                        <%--<button name="licensePlate" class="btn btn-secondary remove_button" type="button">Remove</button>--%>
                        <%--</span>--%>
                    </div>
            </div>
               <br>
            <div class="row">
                <label for="VIN" class="col-2 offset-1 control-label" >VIN</label>
                    <div class="input-group col-7">
                        <form:input path="newVehicleVIN" type="text" value="${vehicle.VIN}" id="VIN" cssClass="form-control"></form:input>
                        <%--<span class="input-group-btn col-1">--%>
                        <%--<button name="VIN" class="btn btn-secondary remove_button" type="button">Remove</button>--%>
                        <%--</span>--%>
                    </div>
            </div>
              <br>
            <div class="row">
                <label for="color" class="col-2 offset-1 control-label" >Color</label>
                    <div class="input-group col-7">
                        <form:input path="newVehicleColor" type="text" value="${vehicle.color}" id="color" cssClass="form-control"></form:input>
                        <%--<span class="input-group-btn col-1">--%>
                        <%--<button name="color" class="btn btn-secondary remove_button" type="button">Remove</button>--%>
                        <%--</span>--%>
                    </div>
            </div>
                <br>
            <div class="row">
                    <button class="col-2 offset-5 btn btn-primary" value="save" type="submit">Update</button>
            </div>
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