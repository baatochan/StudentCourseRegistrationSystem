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
        <title>SprzetEntity List</title>
    </head>
    <body>
        <f:view>
            <h1>SprzetEntity List</h1>
            <h:form>
              <h:commandButton action="#{sprzetEntity.startCreate}" value="Create"/>

              <h:dataTable value='#{sprzetEntity.allEntities}' var='item' border="1" cellpadding="2" cellspacing="0">
                                                       <h:column>
                      <f:facet name="header">
                      <h:outputText value="idSprzet"/>
                      </f:facet>
                      <h:outputText value="#{item.idSprzet}"/>
                  </h:column>
                                                                        <h:column>
                      <f:facet name="header">
                      <h:outputText value="typ"/>
                      </f:facet>
                      <h:outputText value="#{item.typ}"/>
                  </h:column>
                                                                        <h:column>
                      <f:facet name="header">
                      <h:outputText value="marka"/>
                      </f:facet>
                      <h:outputText value="#{item.marka}"/>
                  </h:column>
                                                                        <h:column>
                      <f:facet name="header">
                      <h:outputText value="parametry"/>
                      </f:facet>
                      <h:outputText value="#{item.parametry}"/>
                  </h:column>
                                                                        <h:column>
                      <f:facet name="header">
                      <h:outputText value="stanSprzetu"/>
                      </f:facet>
                      <h:outputText value="#{item.stanSprzetu}"/>
                  </h:column>
                                                                        <h:column>
                      <f:facet name="header">
                      <h:outputText value="model"/>
                      </f:facet>
                      <h:outputText value="#{item.model}"/>
                  </h:column>
                                                   <h:column>
                      <h:commandButton value="View" action="#{sprzetEntity.startView}">
                          <f:param name="id" value="#{item.idSprzet}"/>
                      </h:commandButton>&nbsp;
                      <h:commandButton value="Edit" action="#{sprzetEntity.startEdit}">
                          <f:param name="id" value="#{item.idSprzet}"/>
                      </h:commandButton>&nbsp;
                      <h:commandButton value="Delete" action="#{sprzetEntity.delete}">
                          <f:param name="id" value="#{item.idSprzet}"/>
                      </h:commandButton>
                  </h:column>
              </h:dataTable>
            </h:form>
        </f:view>
    </body>
</html>
