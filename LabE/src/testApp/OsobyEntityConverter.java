package testApp;

import javax.faces.convert.Converter;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;

import testApp.OsobyEntity;

public class OsobyEntityConverter implements Converter {

	public OsobyEntityConverter() {
	}

	public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
		if (string == null || string.trim().length() == 0) {
			return null;
		}

		OsobyEntityManagedBean managedBean = (OsobyEntityManagedBean) facesContext.getApplication().getVariableResolver().resolveVariable(
				facesContext, "osobyEntity");

		final int id = Integer.parseInt(string);

		return managedBean.findEntity(id);
	}

	public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
		if (object == null) return null;

		if (object instanceof OsobyEntity) {
			OsobyEntity entity = (OsobyEntity) object;

			final String pk = String.valueOf(entity.getIdOsoby());

			return pk;
		} else {
			throw new IllegalArgumentException("Incorrect object type: " + object.getClass().getName() + "; must be: OsobyEntity");
		}
	}
}
