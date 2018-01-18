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
        <title>Edit SprzetEntity</title>
    </head>
    <body>
        <f:view>
            <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            <h1>Edit SprzetEntity</h1>
            <h:form>
                <h:panelGrid columns="2">
                                    <h:outputText value="idSprzet:"/>
                                                                        <h:inputText value="#{sprzetEntity.entity.idSprzet}" title="idSprzet" />
                                                                                <h:outputText value="typ:"/>
                                                                        <h:inputText value="#{sprzetEntity.entity.typ}" title="typ" />
                                                                                <h:outputText value="marka:"/>
                                                                        <h:inputText value="#{sprzetEntity.entity.marka}" title="marka" />
                                                                                <h:outputText value="parametry:"/>
                                                                        <h:inputText value="#{sprzetEntity.entity.parametry}" title="parametry" />
                                                                                <h:outputText value="stanSprzetu:"/>
                                                                        <h:inputText value="#{sprzetEntity.entity.stanSprzetu}" title="stanSprzetu" />
                                                                                <h:outputText value="model:"/>
                                                                        <h:inputText value="#{sprzetEntity.entity.model}" title="model" />
                                                                            </h:panelGrid>

                <h:commandButton action="#{sprzetEntity.save}" value="Save"/>
                <h:commandButton action="sprzetEntityList" value="Cancel"/>
                <br>
            </h:form>
        </f:view>
    </body>
</html>
