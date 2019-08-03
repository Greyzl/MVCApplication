import dao.PlainSingerDao;
import dao.SingerDao;
import entity.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class PlainJdbcDemo {
    private static SingerDao singerDao = new PlainSingerDao();
    private static Logger logger = LoggerFactory.getLogger(PlainJdbcDemo.class);

    public static void main(String[] args) {
        logger.info("Listing initial singer data:");
        listAllSingers();
        logger.info("----------");
        logger.info("Insert new singer");

        Singer singer = new Singer();
        singer.setFirstName("Ed");
        singer.setLastName("Sheeran");
        singer.setBirthDate(new Date((new GregorianCalendar(1991,2,1991)).getTime().getTime()));
        //singerDao.insert(singer);
        logger.info("Listing singer data " +
                "after new singer created:");
        listAllSingers();
        singerDao.delete(singer.getId());
    }

    private static void listAllSingers(){
        List<Singer> list = singerDao.findAll();
        for (Singer singer : list){
            logger.info(singer.toString());
        }
    }
}
