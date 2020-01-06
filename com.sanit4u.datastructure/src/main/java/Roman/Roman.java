package Roman;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Roman {

	public static void main(String[] args) {

		final String filePath = "C:\\Users\\rsa\\Downloads\\A-small-practice.in";
		final String writeFilePath = "C:\\Users\\rsa\\Desktop\\Roman2.txt";

		try {
			String lines[] = readFile(filePath).split("\\r?\\n");
			int numberOfLines = Integer.parseInt(lines[0]);
			StringBuilder sb = new StringBuilder();
			for (int i = 1; numberOfLines <= lines.length && i <= numberOfLines; i++) {
				System.out.println("Case #" + i + ":");
				sb.append("Case #" + i + ":").append("\n");
				printBox(lines[i], sb);
			}

			writeFile(writeFilePath, sb.toString());

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void writeFile(String filePath, String data) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(filePath));
			writer.write(data);

		} catch (IOException e) {
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
			}
		}
	}

	private static void printBox(String line, StringBuilder stringBuilder) {
		StringBuilder sb1 = new StringBuilder();
		sb1.append("+");

		for (int j = 0; j <= line.length() + 1; j++) {
			sb1.append("-");
		}
		sb1.append("+");
		System.out.println(sb1);
		stringBuilder.append(sb1).append("\n");

		System.out.println("| " + line + " |");
		stringBuilder.append("| " + line + " |").append("\n");
		;
		StringBuilder sb2 = new StringBuilder();
		sb2.append("+");

		for (int i = 0; i <= line.length() + 1; i++) {
			sb2.append("-");
		}

		sb2.append("+");
		System.out.println(sb2);
		stringBuilder.append(sb2).append("\n");
	}

	// public static void main(String[] args) {
	// final String filePath = "C:\\Users\\rsa\\Desktop\\Roman.txt";
	// try {
	// String readFile = readFile(filePath);
	//
	// String lines[] = readFile.split("\\r?\\n");
	//
	// int numberOfLines = Integer.parseInt(lines[0]);
	// for (int i = 1; i <= numberOfLines; i++) {
	// System.out.println("Case #" + i + ":");
	//
	// int lineLength = lines[i].length();
	// StringBuilder sb = new StringBuilder();
	// sb.append("+");
	// for (int j = 0; j < lineLength + 2; j++) {
	// sb.append("-");
	// }
	// sb.append("+");
	// System.out.println(sb.toString());
	//
	// StringBuilder sb1 = new StringBuilder();
	// sb1.append("|").append(" ");
	// sb1.append(lines[i]);
	// sb1.append(" ").append("|");
	// System.out.println(sb1.toString());
	//
	// StringBuilder sb2 = new StringBuilder();
	// sb2.append("+");
	// for (int j = 0; j < lineLength + 2; j++) {
	// sb2.append("-");
	// }
	// sb2.append("+");
	// System.out.println(sb2.toString());
	// }
	//
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }

	private static String readFile(String filePath) throws IOException {

		InputStream is = new FileInputStream(filePath);
		@SuppressWarnings("resource")
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(is, "UTF8"));

		String line = bufferedReader.readLine();

		StringBuilder builder = new StringBuilder();

		while (line != null) {
			builder.append(line).append("\n");
			line = bufferedReader.readLine();
		}

		return builder.toString();
	}
}
