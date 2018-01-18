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
        <title>OsobyEntity List</title>
    </head>
    <body>
        <f:view>
            <h1>OsobyEntity List</h1>
            <h:form>
              <h:commandButton action="#{osobyEntity.startCreate}" value="Create"/>

              <h:dataTable value='#{osobyEntity.allEntities}' var='item' border="1" cellpadding="2" cellspacing="0">
                                                       <h:column>
                      <f:facet name="header">
                      <h:outputText value="idOsoby"/>
                      </f:facet>
                      <h:outputText value="#{item.idOsoby}"/>
                  </h:column>
                                                                        <h:column>
                      <f:facet name="header">
                      <h:outputText value="imie"/>
                      </f:facet>
                      <h:outputText value="#{item.imie}"/>
                  </h:column>
                                                                        <h:column>
                      <f:facet name="header">
                      <h:outputText value="nazwisko"/>
                      </f:facet>
                      <h:outputText value="#{item.nazwisko}"/>
                  </h:column>
                                                                        <h:column>
                      <f:facet name="header">
                      <h:outputText value="nrTel"/>
                      </f:facet>
                      <h:outputText value="#{item.nrTel}"/>
                  </h:column>
                                                                        <h:column>
                      <f:facet name="header">
                      <h:outputText value="adres"/>
                      </f:facet>
                      <h:outputText value="#{item.adres}"/>
                  </h:column>
                                                                        <h:column>
                      <f:facet name="header">
                      <h:outputText value="mail"/>
                      </f:facet>
                      <h:outputText value="#{item.mail}"/>
                  </h:column>
                                                                        <h:column>
                      <f:facet name="header">
                      <h:outputText value="login"/>
                      </f:facet>
                      <h:outputText value="#{item.login}"/>
                  </h:column>
                                                                        <h:column>
                      <f:facet name="header">
                      <h:outputText value="hasło"/>
                      </f:facet>
                      <h:outputText value="#{item.hasło}"/>
                  </h:column>
                                                   <h:column>
                      <h:commandButton value="View" action="#{osobyEntity.startView}">
                          <f:param name="id" value="#{item.idOsoby}"/>
                      </h:commandButton>&nbsp;
                      <h:commandButton value="Edit" action="#{osobyEntity.startEdit}">
                          <f:param name="id" value="#{item.idOsoby}"/>
                      </h:commandButton>&nbsp;
                      <h:commandButton value="Delete" action="#{osobyEntity.delete}">
                          <f:param name="id" value="#{item.idOsoby}"/>
                      </h:commandButton>
                  </h:column>
              </h:dataTable>
            </h:form>
        </f:view>
    </body>
</html>
