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
                Edit tag
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <form:form modelAttribute="tag" >
                    <div class="form-group">
                        <form:hidden path="id"/>
                        <label>Name:</label>
                        <form:input path="name" cssClass="form-control"/>
                        <form:errors path="name" cssClass="error"/>
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
