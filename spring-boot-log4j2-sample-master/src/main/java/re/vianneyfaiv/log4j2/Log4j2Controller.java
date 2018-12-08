package re.vianneyfaiv.log4j2;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableScheduling
public class Log4j2Controller {

	private final static Logger LOGGER = LoggerFactory.getLogger(Log4j2Controller.class);

    @RequestMapping("/test")
    public void test() {
    	ClassLoader classLoader = ClassLoader.getSystemClassLoader();
    	File file1 = new File(classLoader.getResource("CustomReportConfigurationTest.java").getFile());
    	File file2 = new File("./abc.json");
    	
    	System.out.println("file2:::"+file2.exists());
    	System.out.println(file1.exists());
    	LOGGER.error("This is a test");
    }
}
