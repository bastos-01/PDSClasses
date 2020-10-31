package ex5;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicLong;

public class SizeCalc {

	public AtomicLong getSize(String path, boolean recursive) {

		Path diretorio;

		try {
			diretorio = Paths.get(path);
			AtomicLong size = new AtomicLong(0);

			Files.walkFileTree(diretorio, new SimpleFileVisitor<Path>() {
				public FileVisitResult visitFile(Path f, BasicFileAttributes attributes) throws IOException {

					String[] path = ((String) (f + "")).split("/");
					String[] dir = ((String) (diretorio + "")).split("/");

					String dirName = path[path.length - 2];

					String file = path[path.length - 1];

					if (!dirName.equals(dir[dir.length - 1]))
						if (recursive)
							file = dirName + "->" + file;
						else
							return FileVisitResult.CONTINUE;

					System.out.println("\t" + file + ": " + attributes.size() / 1024 + " Kb");
					size.addAndGet(attributes.size() / 1024);
					return FileVisitResult.CONTINUE;
				}
			});

			return size;

		} catch (Exception e) {
			System.out.println(e);
			System.exit(1);
		}
		return null;
	}

}
