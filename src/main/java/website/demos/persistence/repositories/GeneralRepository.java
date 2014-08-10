package website.demos.persistence.repositories;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class GeneralRepository<TEntity> {

	@Autowired
	@Resource(name = "hibernate-session-factory")
	private SessionFactory sessionFactory;

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	// save
	public void save(final TEntity entity) {
		getCurrentSession().save(entity);
	}

	@SuppressWarnings("unchecked")
	public void save(final TEntity... entities) {
		for (TEntity entity : entities) {
			this.getCurrentSession().save(entity);
		}
	}

	public void save(List<TEntity> entities) {
		int entitiesCount = entities.size();
		for (int i = 0; i < entitiesCount; i++) {
			TEntity entity = entities.get(i);
			this.getCurrentSession().save(entity);
		}
	}

	// update
	public void update(final TEntity entity) {
		getCurrentSession().update(entity);
	}

	@SuppressWarnings("unchecked")
	public void update(final TEntity... entities) {
		for (TEntity entity : entities) {
			this.getCurrentSession().update(entity);
		}
	}

	public void update(List<TEntity> entities) {
		int entitiesCount = entities.size();
		for (int i = 0; i < entitiesCount; i++) {
			TEntity entity = entities.get(i);
			this.getCurrentSession().update(entity);
		}
	}

	// saveOrUpdate
	public void saveOrUpdate(final TEntity entity) {
		getCurrentSession().saveOrUpdate(entity);
	}

	@SuppressWarnings("unchecked")
	public void saveOrUpdate(final TEntity... entities) {
		for (TEntity entity : entities) {
			this.getCurrentSession().saveOrUpdate(entity);
		}
	}

	public void saveOrUpdate(List<TEntity> entities) {
		int entitiesCount = entities.size();
		for (int i = 0; i < entitiesCount; i++) {
			TEntity entity = entities.get(i);
			this.getCurrentSession().saveOrUpdate(entity);
		}
	}

	// delete
	public void delete(final TEntity entity) {
		getCurrentSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	public void delete(final TEntity... entities) {
		for (TEntity entity : entities) {
			this.getCurrentSession().delete(entity);
		}
	}

	public void delete(List<TEntity> entities) {
		int entitiesCount = entities.size();
		for (int i = 0; i < entitiesCount; i++) {
			TEntity entity = entities.get(i);
			this.getCurrentSession().delete(entity);
		}
	}
	
	//get
	@SuppressWarnings("unchecked")
	public TEntity get(Serializable id) {
        return (TEntity) getCurrentSession().get(getEntityType(), id);
    }
	
	//query
	@SuppressWarnings("unchecked")
	public List<TEntity> query(String queryString){
		Query query=getCurrentSession().createQuery(queryString);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<TEntity> query(String queryString, Object[] args) {
        Query query=getCurrentSession().createQuery(queryString);
        if(args!=null){
            for (int i = 0; i < args.length; i++) {
                query.setParameter(i, args[i]);
            }
        }
        return query.list();
    }
	
	protected abstract Class<TEntity> getEntityType();
}
