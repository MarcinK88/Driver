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
            <a class="btn btn-primary" href="/admin/advices/add">add new advice</a>

        <div class="panel panel-default">
            <div class="panel-heading">
                Advices list
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <div class="table-responsive">
                    <table class="table table-striped table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>id</th>
                            <th>Path to image</th>
                            <th>Title</th>
                            <th>Leader</th>
                            <th>Date</th>
                            <th>Recommends</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${advices}" var="advice">
                            <tr>
                                <td>${advice.id}</td>
                                <td>${advice.pathToImage}</td>
                                <td>${advice.title}</td>
                                <td>${advice.leader}</td>
                                <td>${advice.date}</td>
                                <td>${advice.recommends}</td>
                                <td><a class="confirm btn btn-danger" href="/admin/advices/delete/${advice.id}">delete</a>
                                    <a class="btn btn-success" href="/admin/advices/edit/${advice.id}">edit</a>
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
