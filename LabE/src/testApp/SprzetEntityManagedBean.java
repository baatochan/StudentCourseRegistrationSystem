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

import testApp.SprzetEntity;

public class SprzetEntityManagedBean {
	final public static String SELECT_ALL_ENTITIES_SQL = "SELECT o FROM SprzetEntity AS o";

	private SprzetEntity myEntity;

	private EntityManagerFactory myEntityManagerFactory;

	private ListDataModel myList;
	private ListDataModel myReferencesEntities; // M-N and M-1 references

	public SprzetEntityManagedBean() {
		myEntityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
	}

	private EntityManagerFactory getEntityManagerFactory() {
		return myEntityManagerFactory;
	}

	public SprzetEntity getEntity() {
		return myEntity;
	}

	public void setEntity(SprzetEntity entity) {
		myEntity = entity;
	}

	// add new SprzetEntity
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

		return "sprzetEntityList";
	}

	// save edited SprzetEntity
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
		return "sprzetEntityList";
	}

	// delete SprzetEntity
	public String delete() {
		EntityManager entityManager = getEntityManagerFactory().createEntityManager();
		try {
			entityManager.getTransaction().begin();
			SprzetEntity entity = getCurrentEntity();
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

		return "sprzetEntityList";
	}

	public DataModel getReferencedEntities() {
		return myReferencesEntities;
	}

	public void setReferencedEntities(Collection<SprzetEntity> entities) {
		myReferencesEntities = new ListDataModel(new ArrayList<SprzetEntity>(entities));
	}

	public String startCreate() {
		myEntity = new SprzetEntity();
		return "createSprzetEntity";
	}

	public String startView() {
		setEntityFromRequestParam();
		return "viewSprzetEntity";
	}

	public String startEdit() {
		setEntityFromRequestParam();
		return "editSprzetEntity";
	}

	public SprzetEntity getCurrentEntity() {
		SprzetEntity entity = getEntityFromRequestParam();

		return entity == null ? myEntity : entity;
	}

	public SprzetEntity getEntityFromRequestParam() {
		if (myList == null) return null;

		EntityManager entityManager = getEntityManagerFactory().createEntityManager();
		SprzetEntity entity = (SprzetEntity) myList.getRowData();
		entity = entityManager.merge(entity);
		entityManager.close();

		return entity;
	}

	public void setEntityFromRequestParam() {
		myEntity = getCurrentEntity();
	}

	public SprzetEntity findEntity(int id) {
		EntityManager entityManager = getEntityManagerFactory().createEntityManager();

		SprzetEntity entity = entityManager.find(SprzetEntity.class, id);

		entityManager.close();

		return entity;
	}

	public DataModel getAllEntities() {
		myList = new ListDataModel(getEntities());

		return myList;
	}

	public SelectItem[] getAllEntitiesAsSelectedItems() {
		List<SprzetEntity> entities = getEntities();
		SelectItem selectItems[] = new SelectItem[entities.size()];
		int i = 0;
		for (SprzetEntity entity : entities) {
			selectItems[i++] = new SelectItem(entity);
		}
		return selectItems;
	}

	public List<SprzetEntity> getEntities() {
		EntityManager entityManager = getEntityManagerFactory().createEntityManager();

		List<SprzetEntity> entities = (List<SprzetEntity>) entityManager.createQuery(SELECT_ALL_ENTITIES_SQL).getResultList();

		entityManager.close();

		return entities;
	}
}
