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
            <a class="btn btn-primary" href="/admin/tags/add">add new tag</a>

        <div class="panel panel-default">
            <div class="panel-heading">
                Tags list
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <div class="table-responsive">
                    <table class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>id</th>
                            <th>name</th>
                            <th>action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${tags}" var="tag">
                            <tr>
                                <td>${tag.id}</td>
                                <td>${tag.name}</td>
                                <td><a class="confirm btn btn-danger" href="/admin/tags/delete/${tag.id}">delete</a>
                                    <a class="btn btn-success" href="/admin/tags/edit/${tag.id}">edit</a>
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
