package website.demos.persistence.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import website.demos.persistence.entities.enums.EAccountType;

@Generated(value="Dali", date="2014-08-13T15:59:33.628+0800")
@StaticMetamodel(Account.class)
public class Account_ {
	public static volatile SingularAttribute<Account, Long> id;
	public static volatile SingularAttribute<Account, String> accountId;
	public static volatile SingularAttribute<Account, String> password;
	public static volatile SingularAttribute<Account, String> name;
	public static volatile SingularAttribute<Account, Date> creadtedDate;
	public static volatile SingularAttribute<Account, EAccountType> type;
}
