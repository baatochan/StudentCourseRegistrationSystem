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

import testApp.OsobyEntity;

public class OsobyEntityManagedBean {
	final public static String SELECT_ALL_ENTITIES_SQL = "SELECT o FROM OsobyEntity AS o";

	private OsobyEntity myEntity;

	private EntityManagerFactory myEntityManagerFactory;

	private ListDataModel myList;
	private ListDataModel myReferencesEntities; // M-N and M-1 references

	public OsobyEntityManagedBean() {
		myEntityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
	}

	private EntityManagerFactory getEntityManagerFactory() {
		return myEntityManagerFactory;
	}

	public OsobyEntity getEntity() {
		return myEntity;
	}

	public void setEntity(OsobyEntity entity) {
		myEntity = entity;
	}

	// add new OsobyEntity
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

		return "osobyEntityList";
	}

	// save edited OsobyEntity
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
		return "osobyEntityList";
	}

	// delete OsobyEntity
	public String delete() {
		EntityManager entityManager = getEntityManagerFactory().createEntityManager();
		try {
			entityManager.getTransaction().begin();
			OsobyEntity entity = getCurrentEntity();
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

		return "osobyEntityList";
	}

	public DataModel getReferencedEntities() {
		return myReferencesEntities;
	}

	public void setReferencedEntities(Collection<OsobyEntity> entities) {
		myReferencesEntities = new ListDataModel(new ArrayList<OsobyEntity>(entities));
	}

	public String startCreate() {
		myEntity = new OsobyEntity();
		return "createOsobyEntity";
	}

	public String startView() {
		setEntityFromRequestParam();
		return "viewOsobyEntity";
	}

	public String startEdit() {
		setEntityFromRequestParam();
		return "editOsobyEntity";
	}

	public OsobyEntity getCurrentEntity() {
		OsobyEntity entity = getEntityFromRequestParam();

		return entity == null ? myEntity : entity;
	}

	public OsobyEntity getEntityFromRequestParam() {
		if (myList == null) return null;

		EntityManager entityManager = getEntityManagerFactory().createEntityManager();
		OsobyEntity entity = (OsobyEntity) myList.getRowData();
		entity = entityManager.merge(entity);
		entityManager.close();

		return entity;
	}

	public void setEntityFromRequestParam() {
		myEntity = getCurrentEntity();
	}

	public OsobyEntity findEntity(int id) {
		EntityManager entityManager = getEntityManagerFactory().createEntityManager();

		OsobyEntity entity = entityManager.find(OsobyEntity.class, id);

		entityManager.close();

		return entity;
	}

	public DataModel getAllEntities() {
		myList = new ListDataModel(getEntities());

		return myList;
	}

	public SelectItem[] getAllEntitiesAsSelectedItems() {
		List<OsobyEntity> entities = getEntities();
		SelectItem selectItems[] = new SelectItem[entities.size()];
		int i = 0;
		for (OsobyEntity entity : entities) {
			selectItems[i++] = new SelectItem(entity);
		}
		return selectItems;
	}

	public List<OsobyEntity> getEntities() {
		EntityManager entityManager = getEntityManagerFactory().createEntityManager();

		List<OsobyEntity> entities = (List<OsobyEntity>) entityManager.createQuery(SELECT_ALL_ENTITIES_SQL).getResultList();

		entityManager.close();

		return entities;
	}
}
