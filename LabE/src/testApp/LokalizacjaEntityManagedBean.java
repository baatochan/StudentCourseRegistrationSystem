package testApp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import testApp.LokalizacjaEntity;

public class LokalizacjaEntityManagedBean {
	final public static String SELECT_ALL_ENTITIES_SQL = "SELECT o FROM LokalizacjaEntity AS o";

	private LokalizacjaEntity myEntity;

	private EntityManagerFactory myEntityManagerFactory;

	private ListDataModel myList;
	private ListDataModel myReferencesEntities; // M-N and M-1 references

	public LokalizacjaEntityManagedBean() {
		myEntityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
	}

	private EntityManagerFactory getEntityManagerFactory() {
		return myEntityManagerFactory;
	}

	public LokalizacjaEntity getEntity() {
		return myEntity;
	}

	public void setEntity(LokalizacjaEntity entity) {
		myEntity = entity;
	}

	// add new LokalizacjaEntity
	public String create() {
		EntityManager entityManager = getEntityManagerFactory().createEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(getEntity());
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			try {
				entityManager.getTransaction().rollback();
			} catch (Exception e) {
			}
		}
		entityManager.close();

		return "lokalizacjaEntityList";
	}

	// save edited LokalizacjaEntity
	public String save() {
		EntityManager entityManager = getEntityManagerFactory().createEntityManager();
		try {
			entityManager.getTransaction().begin();
			myEntity = entityManager.merge(getEntity());
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			try {
				entityManager.getTransaction().rollback();
			} catch (Exception e) {
			}
		}
		entityManager.close();
		return "lokalizacjaEntityList";
	}

	// delete LokalizacjaEntity
	public String delete() {
		EntityManager entityManager = getEntityManagerFactory().createEntityManager();
		try {
			entityManager.getTransaction().begin();
			LokalizacjaEntity entity = getCurrentEntity();
			entity = entityManager.merge(entity);
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			try {
				entityManager.getTransaction().rollback();
			} catch (Exception e) {
			}
		}
		entityManager.close();

		return "lokalizacjaEntityList";
	}

	public DataModel getReferencedEntities() {
		return myReferencesEntities;
	}

	public void setReferencedEntities(Collection<LokalizacjaEntity> entities) {
		myReferencesEntities = new ListDataModel(new ArrayList<LokalizacjaEntity>(entities));
	}

	public String startCreate() {
		myEntity = new LokalizacjaEntity();
		return "createLokalizacjaEntity";
	}

	public String startView() {
		setEntityFromRequestParam();
		return "viewLokalizacjaEntity";
	}

	public String startEdit() {
		setEntityFromRequestParam();
		return "editLokalizacjaEntity";
	}

	public LokalizacjaEntity getCurrentEntity() {
		LokalizacjaEntity entity = getEntityFromRequestParam();

		return entity == null ? myEntity : entity;
	}

	public LokalizacjaEntity getEntityFromRequestParam() {
		if (myList == null) return null;

		EntityManager entityManager = getEntityManagerFactory().createEntityManager();
		LokalizacjaEntity entity = (LokalizacjaEntity) myList.getRowData();
		entity = entityManager.merge(entity);
		entityManager.close();

		return entity;
	}

	public void setEntityFromRequestParam() {
		myEntity = getCurrentEntity();
	}

	public LokalizacjaEntity findEntity(int id) {
		EntityManager entityManager = getEntityManagerFactory().createEntityManager();

		LokalizacjaEntity entity = entityManager.find(LokalizacjaEntity.class, id);

		entityManager.close();

		return entity;
	}

	public DataModel getAllEntities() {
		myList = new ListDataModel(getEntities());

		return myList;
	}

	public SelectItem[] getAllEntitiesAsSelectedItems() {
		List<LokalizacjaEntity> entities = getEntities();
		SelectItem selectItems[] = new SelectItem[entities.size()];
		int i = 0;
		for (LokalizacjaEntity entity : entities) {
			selectItems[i++] = new SelectItem(entity);
		}
		return selectItems;
	}

	public List<LokalizacjaEntity> getEntities() {
		EntityManager entityManager = getEntityManagerFactory().createEntityManager();

		List<LokalizacjaEntity> entities = (List<LokalizacjaEntity>) entityManager.createQuery(SELECT_ALL_ENTITIES_SQL).getResultList();

		entityManager.close();

		return entities;
	}
}
