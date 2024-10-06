package hibernate;
import com.neoteric.fullstackdemo_20248._1.model.AccountAddressEntity;
import com.neoteric.fullstackdemo_20248._1.model.AccountEntity;
import com.neoteric.fullstackdemo_20248._1.model.AddressEntity;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;


import java.rmi.AccessException;
import java.util.Properties;


public class HibernateUtils {
    public static SessionFactory seesionFactory;

    public static SessionFactory getSeesionFactory() {
        if (seesionFactory == null) {
            Configuration configuration = new Configuration();
            Properties properties = new Properties();
            properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
            properties.put(Environment.URL, "jdbc:myssql://localhost:3306/bank");
            properties.put(Environment.USER,"root");
            properties.put(Environment.PASS,"root");
            properties.put(Environment.DIALECT,"org.hibernate.dialect.MysqlDialect");
            properties.put(Environment.SHOW_SQL,true);
            configuration.addAnnotatedClass(AccountEntity.class).
                    addAnnotatedClass(AccountAddressEntity.class)
                    .addAnnotatedClass(AddressEntity.class);
            ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().
                    applySettings(configuration.getProperties()).build();
            seesionFactory= configuration.buildSessionFactory(serviceRegistry);

        }
        return seesionFactory;
    }
}
