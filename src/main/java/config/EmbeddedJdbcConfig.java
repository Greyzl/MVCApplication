package config;

import dao.JdbcSingerDao;
import dao.SingerDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class EmbeddedJdbcConfig {
    private Logger logger = LoggerFactory.getLogger(EmbeddedJdbcConfig.class);

    @Bean
    public DataSource dataSource(){
        try{
            EmbeddedDatabaseBuilder databaseBuilder = new EmbeddedDatabaseBuilder();
            return databaseBuilder.setType(EmbeddedDatabaseType.H2).addScripts(
                    "classpath:dЬ/h2/schema.sql",
                    "classpath:db/h2/test-data.sql").build();
        }catch (Exception e){
            logger.error("EmЬedded DataSource bean cannot be created", e);
            return null;
        }
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }
    @Bean
    public SingerDao singerDao(){
        JdbcSingerDao dao = new JdbcSingerDao();
        dao.setDataSource(dataSource());
        return dao;
    }
}
