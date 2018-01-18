package testApp;

import javax.faces.convert.Converter;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;

import testApp.LokalizacjaEntity;

public class LokalizacjaEntityConverter implements Converter {

	public LokalizacjaEntityConverter() {
	}

	public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
		if (string == null || string.trim().length() == 0) {
			return null;
		}

		LokalizacjaEntityManagedBean managedBean = (LokalizacjaEntityManagedBean) facesContext.getApplication().getVariableResolver().resolveVariable(
				facesContext, "lokalizacjaEntity");

		final int id = Integer.parseInt(string);

		return managedBean.findEntity(id);
	}

	public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
		if (object == null) return null;

		if (object instanceof LokalizacjaEntity) {
			LokalizacjaEntity entity = (LokalizacjaEntity) object;

			final String pk = String.valueOf(entity.getIdLokalizacja());

			return pk;
		} else {
			throw new IllegalArgumentException("Incorrect object type: " + object.getClass().getName() + "; must be: LokalizacjaEntity");
		}
	}
}
