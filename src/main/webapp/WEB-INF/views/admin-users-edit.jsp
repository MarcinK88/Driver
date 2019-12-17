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
                Edit user
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <form:form modelAttribute="user" >
                    <div class="form-group">
                        <form:hidden path="id"/>
                        <form:hidden path="password"/>
                        <label>Username:</label>
                        <form:input path="username" cssClass="form-control"/>
                        <form:errors path="username" cssClass="error"/>
                    </div>
                    <div class="form-group">
                        <label>Enabled:</label>
                            <form:select path="enabled" id="enabled" cssClass="form-control">
                                <form:option value="true" />
                                <form:option value="false"/>
                            </form:select>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-default">Save</button>
                    </div>
                </form:form>

            </div>
            <!-- /.panel-body -->
        </div>

    </div>
    <!-- /.row -->

<!-- /#page-wrapper -->

<jsp:include page="footer.jsp"/>
