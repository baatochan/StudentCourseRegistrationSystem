package testApp;

import javax.faces.convert.Converter;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;

import testApp.SprzetEntity;

public class SprzetEntityConverter implements Converter {

	public SprzetEntityConverter() {
	}

	public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
		if (string == null || string.trim().length() == 0) {
			return null;
		}

		SprzetEntityManagedBean managedBean = (SprzetEntityManagedBean) facesContext.getApplication().getVariableResolver().resolveVariable(
				facesContext, "sprzetEntity");

		final int id = Integer.parseInt(string);

		return managedBean.findEntity(id);
	}

	public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
		if (object == null) return null;

		if (object instanceof SprzetEntity) {
			SprzetEntity entity = (SprzetEntity) object;

			final String pk = String.valueOf(entity.getIdSprzet());

			return pk;
		} else {
			throw new IllegalArgumentException("Incorrect object type: " + object.getClass().getName() + "; must be: SprzetEntity");
		}
	}
}
