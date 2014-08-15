package website.demos.persistence.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-08-13T15:59:33.761+0800")
@StaticMetamodel(NavigationFirst.class)
public class NavigationFirst_ extends Navigation_ {
	public static volatile SingularAttribute<NavigationFirst, String> type;
	public static volatile ListAttribute<NavigationFirst, NavigationSecond> navigationSecond;
}
