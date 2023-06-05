//package repo.BD;
//
//import model.AuthUserDTO;
//import model.User;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.boot.MetadataSources;
//import org.hibernate.boot.registry.StandardServiceRegistry;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import repo.interfaces.UserRepo;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.Optional;
//
//public class UserRepoBDHBM implements UserRepo {
//
//
//    private static SessionFactory sessionFactory;
//
//    private static HibernateUtils hibernateUtils;
//
//
//
//    public static void initialize() {
//        // A SessionFactory is set up once for an application!
//        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
//                .configure() // configures settings from hibernate.cfg.xml
//                .build();
//        try {
//            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
//        } catch (Exception e) {
//            System.err.println("Exception " + e);
//            StandardServiceRegistryBuilder.destroy(registry);
//        }
//    }
//
//    public static void close() {
//        if (sessionFactory != null) {
//            sessionFactory.close();
//        }
//    }
//
//    @Override
//    public List<User> getAll() {
//        SessionFactory ses = HibernateUtils.getSession();
//        try (Session session = ses.openSession()) {
//            Transaction transact = null;
//            try {
//                transact = session.beginTransaction();
//                List<User> users = session.createQuery("FROM User ", Users.class).list();
//                System.out.println(users.size() + " users");
//                transact.commit();
//                return users;
//            } catch (Exception e) {
//                System.err.println("Error when getting all the users " + e);
//                if (transact != null) {
//                    transact.rollback();
//                }
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public boolean delete(User storableEntity) throws IOException {
//        return false;
//    }
//
//    @Override
//    public User update(User storableEntity) throws IOException {
//        return null;
//    }
//
//    @Override
//    public User save(User storableEntity) throws IOException {
//        return null;
//    }
//
//    @Override
//    public int size() {
//        return 0;
//    }
//
//    @Override
//    public Optional<AuthUserDTO> authenticate(String username, String password) {
////        return Optional.of(new AuthUserDTO(0L,"Heh", UserType.Angajat));
////        return Optional.of(new AuthUserDTO(0L,"Yep", UserType.Sef));
//        return Optional.empty();
//    }
//}
