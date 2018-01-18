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
        <title>LokalizacjaEntity List</title>
    </head>
    <body>
        <f:view>
            <h1>LokalizacjaEntity List</h1>
            <h:form>
              <h:commandButton action="#{lokalizacjaEntity.startCreate}" value="Create"/>

              <h:dataTable value='#{lokalizacjaEntity.allEntities}' var='item' border="1" cellpadding="2" cellspacing="0">
                                                       <h:column>
                      <f:facet name="header">
                      <h:outputText value="idLokalizacja"/>
                      </f:facet>
                      <h:outputText value="#{item.idLokalizacja}"/>
                  </h:column>
                                                                        <h:column>
                      <f:facet name="header">
                      <h:outputText value="miasto"/>
                      </f:facet>
                      <h:outputText value="#{item.miasto}"/>
                  </h:column>
                                                                        <h:column>
                      <f:facet name="header">
                      <h:outputText value="kodPocztowy"/>
                      </f:facet>
                      <h:outputText value="#{item.kodPocztowy}"/>
                  </h:column>
                                                   <h:column>
                      <h:commandButton value="View" action="#{lokalizacjaEntity.startView}">
                          <f:param name="id" value="#{item.idLokalizacja}"/>
                      </h:commandButton>&nbsp;
                      <h:commandButton value="Edit" action="#{lokalizacjaEntity.startEdit}">
                          <f:param name="id" value="#{item.idLokalizacja}"/>
                      </h:commandButton>&nbsp;
                      <h:commandButton value="Delete" action="#{lokalizacjaEntity.delete}">
                          <f:param name="id" value="#{item.idLokalizacja}"/>
                      </h:commandButton>
                  </h:column>
              </h:dataTable>
            </h:form>
        </f:view>
    </body>
</html>
