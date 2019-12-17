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
                Add new advice
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <form:form modelAttribute="advice" >
                    <div class="form-group">
                        <label>Title:</label>
                        <form:input path="title" cssClass="form-control"/>
                        <form:errors path="title" cssClass="error"/>
                    </div>
                    <div class="form-group">
                        <label>Leader:</label>
                        <form:input path="leader" cssClass="form-control"/>
                        <form:errors path="leader" cssClass="error"/>
                    </div>
                    <div class="form-group">
                        <label>Path to Image:</label>
                        <form:input path="pathToImage" cssClass="form-control"/>
                        <form:errors path="pathToImage" cssClass="error"/>
                    </div>
                    <div class="form-group">
                        <label>Description:</label>
                        <form:input path="description" cssClass="form-control"/>
                        <form:errors path="description" cssClass="error"/>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-default">Add advice</button>
                    </div>
                </form:form>

            </div>
            <!-- /.panel-body -->
        </div>

    </div>
    <!-- /.row -->

<!-- /#page-wrapper -->

<jsp:include page="footer.jsp"/>
