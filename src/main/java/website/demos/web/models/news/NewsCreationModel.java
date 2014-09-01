package website.demos.web.models.news;

import website.demos.common.exceptions.CommonSystemException;
import website.demos.common.global.InstanceConverter;
import website.demos.persistence.entities.News;

public class NewsCreationModel extends News {
	private static final long serialVersionUID = 1L;

	public NewsCreationModel() {

	}

	public NewsCreationModel(News news) throws CommonSystemException {
		InstanceConverter.assignProperties(news, this);
	}

	public News getEntity() throws CommonSystemException {
		News entity = new News();
		return InstanceConverter.assignProperties(this, entity);
	}

}
