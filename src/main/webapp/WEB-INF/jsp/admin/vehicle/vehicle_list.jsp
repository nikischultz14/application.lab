<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/navbar.jsp" %>
<%@include file="../../includes/subnav_admin.jsp" %>



<br>
<div class="container-fluid">
    <div class="row">
        <%--SIDEBAR HERE--%>

        <%@include file="vehicle_sidebar.jsp" %>

        <div id="main" class="col-10">
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Vehicle Make</th>
                    <th>Vehicle Model</th>
                    <th>Year</th>
                    <th>License Plate</th>
                    <th>VIN</th>
                    <th>Color</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>


                <tr>
                <c:forEach var="vehicle" items="${vehicleList}">
                    <td>${vehicle.id}</td>
                    <td>${vehicle.vehicleModel.vehicleMake.vehicleMakeName}</td>
                    <td>${vehicle.vehicleModel.vehicleModelName}</td>
                    <td>${vehicle.year}</td>
                    <td>${vehicle.licensePlate}</td>
                    <td>${vehicle.VIN}</td>
                    <td>${vehicle.color}</td>
                    <td><a href="/admin/vehicle/edit/${vehicle.id}">Edit</a></td>
                    <td><a href="/admin/vehicle/delete/${vehicle.id}">Delete</a></td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

    </div>
</div>


<%@include file="../../includes/footer.jsp" %>