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
        <title>OsobyEntity View</title>
    </head>
    <body>
        <f:view>
            <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            <h1>OsobyEntity View</h1>
            <h:form>
                <h:panelGrid columns="2">
                                                           <h:outputText value="idOsoby:"/>
                                                   <h:outputText value="#{osobyEntity.entity.idOsoby}" title="idOsoby" />
                                                                                                       <h:outputText value="imie:"/>
                                                   <h:outputText value="#{osobyEntity.entity.imie}" title="imie" />
                                                                                                       <h:outputText value="nazwisko:"/>
                                                   <h:outputText value="#{osobyEntity.entity.nazwisko}" title="nazwisko" />
                                                                                                       <h:outputText value="nrTel:"/>
                                                   <h:outputText value="#{osobyEntity.entity.nrTel}" title="nrTel" />
                                                                                                       <h:outputText value="adres:"/>
                                                   <h:outputText value="#{osobyEntity.entity.adres}" title="adres" />
                                                                                                       <h:outputText value="mail:"/>
                                                   <h:outputText value="#{osobyEntity.entity.mail}" title="mail" />
                                                                                                       <h:outputText value="login:"/>
                                                   <h:outputText value="#{osobyEntity.entity.login}" title="login" />
                                                                                                       <h:outputText value="hasło:"/>
                                                   <h:outputText value="#{osobyEntity.entity.hasło}" title="hasło" />
                                                                            </h:panelGrid>

                <h:commandButton action="editOsobyEntity" value="Edit" />
                <br>
                <h:commandButton action="osobyEntityList" value="Show All"/>
                <br>
            </h:form>
        </f:view>
    </body>
</html>
