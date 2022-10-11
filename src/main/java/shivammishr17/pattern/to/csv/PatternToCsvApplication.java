package shivammishr17.pattern.to.csv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.File;
import java.util.Scanner;

@SpringBootApplication
public class PatternToCsvApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(PatternToCsvApplication.class, args);
		FileService fileService = run.getBean(FileService.class);
		PatternService patternService = run.getBean(PatternService.class);
		Scanner in = new Scanner(System.in).useDelimiter("\n");
		System.out.print("Enter file name: ");
		String fileName = in.nextLine();
		System.out.print("Enter start number: ");
		int start = Integer.parseInt(in.nextLine());
		System.out.print("Enter end number: ");
		int end = Integer.parseInt(in.nextLine());
		System.out.print("Enter number of items per line: ");
		int itemsPerLine = Integer.parseInt(in.nextLine());
		System.out.print("Enter pattern prefix: ");
		String item = in.nextLine();
		File file = fileService.openFile(fileName);
		fileService.writeToFile(file, patternService.createPattern(item, start, end, itemsPerLine));
		run.close();
	}

}
