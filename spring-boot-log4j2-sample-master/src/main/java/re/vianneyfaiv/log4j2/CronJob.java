package re.vianneyfaiv.log4j2;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;



@Component
public class CronJob {

	
	
	
	@Scheduled(cron = "${app.time}")
    public void reportCurrentTime() {
       System.out.println("test");
       
       try {
		FileRead();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
	
	@Value("${app.title}")
	 private String appTitle;

	public void FileRead() throws IOException {
		//Writer output = null;
//		File file = new File(".//HEADER.txt");
//		System.out.println(file.getAbsolutePath());
//		System.out.println(file.getPath());
//		System.out.println("fileExist"+file.exists());
//		output = new BufferedWriter(new FileWriter(file, true));
//		output.write("testings");
//		output.close();
		System.out.println("appTitle"+appTitle);
		try {
			// append = false
			FileWriter fw =new FileWriter(".//HEADER.txt", false);
			fw.write("bla bla bla...");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		try (Stream<String> stream = Files.lines(Paths.get(".//HEADER.txt"))) {

			stream.forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
