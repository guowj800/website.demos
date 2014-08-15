package website.demos.persistence.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-08-13T15:59:33.758+0800")
@StaticMetamodel(Navigation.class)
public class Navigation_ {
	public static volatile SingularAttribute<Navigation, Long> id;
	public static volatile SingularAttribute<Navigation, String> title;
	public static volatile SingularAttribute<Navigation, String> url;
	public static volatile SingularAttribute<Navigation, Boolean> visiable;
	public static volatile SingularAttribute<Navigation, Date> createdDate;
}
