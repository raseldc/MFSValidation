/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anunad.WalletVerification.config;

/**
 *
 * @author rasel
 */
//@Configuration
public class SessionFactoryConfig {
/*
    @Autowired
    DataSource dataSource;

    @Bean
    
    public SessionFactory sessionFactory() {

        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
        builder
                .scanPackages("com.anunad.WalletVerification")
                .addProperties(hibernateProperties());
        return builder.buildSessionFactory();
//                
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//        sessionFactory.setPackagesToScan("com.icvgd");
//        sessionFactory.setDataSource(dataSource);
//        sessionFactory.setHibernateProperties(hibernateProperties());
//        return sessionFactory;
    }

    private Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.ddl.auto", "none");
//        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        hibernateProperties.setProperty("hibernate.current_session_context_class", "org.springframework.orm.hibernate5.SpringSessionContext");
        return hibernateProperties;
    }
*/
}
