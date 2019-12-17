<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

        <div class="panel panel-default">
            <div class="panel-heading">
                Change password
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <form:form modelAttribute="user" >
                        <form:hidden path="username"/>
                        <form:hidden path="id"/>
                        <form:hidden path="enabled"/>

                    <div class="form-group">
                        <label>New password:</label>
                        <form:input path="password" type="password" cssClass="form-control"/>
                        <form:errors path="password" cssClass="error"/>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-default">Add user</button>
                    </div>
                </form:form>

            </div>
            <!-- /.panel-body -->
        </div>

    </div>
    <!-- /.row -->

<!-- /#page-wrapper -->

<jsp:include page="footer.jsp"/>
