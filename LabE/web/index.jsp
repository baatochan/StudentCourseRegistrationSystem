<!--
  Created by IntelliJ IDEA.
  User: barto
  Date: 18.01.18
  Time: 01:04
-->
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
<head><title>Generated Entities</title></head>
<body>

<h1>Generated Entities</h1>
<br/>
<f:view>
    <h:form>
                <h:commandLink action="lokalizacjaEntityList" value="LokalizacjaEntity"/>
        <br/>
                <h:commandLink action="osobyEntityList" value="OsobyEntity"/>
        <br/>
                <h:commandLink action="sprzetEntityList" value="SprzetEntity"/>
        <br/>
            </h:form>
</f:view>

</body>
</html>
