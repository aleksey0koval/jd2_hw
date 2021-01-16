<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${expense}" var="ex">
    <c:out value="${ex}"/><br>
</c:forEach>

