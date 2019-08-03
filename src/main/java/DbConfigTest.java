import config.DbConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConfigTest {
    private static Logger logger = LoggerFactory.getLogger(DbConfigTest.class);

    @Test
    public void testOne() throws SQLException {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(DbConfig.class);
        DataSource dataSource = ctx.getBean("dataSource",DataSource.class);
        testDataSource(dataSource);
        ctx.close();
    }

    public void testDataSource(DataSource dataSource) throws SQLException{
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("select 1");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int mockVal = resultSet.getInt("1");
                assertTrue(mockVal==1);
            }
            statement.close();
        }catch (Exception e){
            logger.error("somthing goes wrong", e);
        }finally {
            if(connection != null){
                connection.close();
            }
        }
    }
}
