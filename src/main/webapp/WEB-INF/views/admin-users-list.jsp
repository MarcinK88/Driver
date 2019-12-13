<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>



    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Dashboard</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->

    <!-- /.row -->
    <div class="row">
            <a class="btn btn-primary" href="/admin/users/add">add new user</a>

        <div class="panel panel-default">
            <div class="panel-heading">
                Users list
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <div class="table-responsive">
                    <table class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>id</th>
                            <th>username</th>
                            <th>enabled</th>
                            <th>action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${users}" var="user">
                            <tr>
                                <td>${user.id}</td>
                                <td>${user.username}</td>
                                <td>${user.enabled}</td>
                                <td><a class="confirm btn btn-danger" href="/admin/users/remove/${user.id}">delete</a>
                                    <a class="btn btn-success" href="/admin/users/edit/${user.id}">edit</a>
                                    <a class="btn btn-warning" href="/admin/users/password/${user.id}">change password</a>
                                    </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <!-- /.table-responsive -->
            </div>
            <!-- /.panel-body -->
        </div>

    </div>
    <!-- /.row -->

<!-- /#page-wrapper -->

<jsp:include page="footer.jsp"/>
