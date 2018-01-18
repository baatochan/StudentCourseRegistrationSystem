<!--
  Created by IntelliJ IDEA.
  User: barto
  Date: 18.01.18
  Time: 01:24
  To change this template use File | Settings | File Templates.
-->
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>LokalizacjaEntity View</title>
    </head>
    <body>
        <f:view>
            <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            <h1>LokalizacjaEntity View</h1>
            <h:form>
                <h:panelGrid columns="2">
                                                           <h:outputText value="idLokalizacja:"/>
                                                   <h:outputText value="#{lokalizacjaEntity.entity.idLokalizacja}" title="idLokalizacja" />
                                                                                                       <h:outputText value="miasto:"/>
                                                   <h:outputText value="#{lokalizacjaEntity.entity.miasto}" title="miasto" />
                                                                                                       <h:outputText value="kodPocztowy:"/>
                                                   <h:outputText value="#{lokalizacjaEntity.entity.kodPocztowy}" title="kodPocztowy" />
                                                                            </h:panelGrid>

                <h:commandButton action="editLokalizacjaEntity" value="Edit" />
                <br>
                <h:commandButton action="lokalizacjaEntityList" value="Show All"/>
                <br>
            </h:form>
        </f:view>
    </body>
</html>
