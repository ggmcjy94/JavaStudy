package you.exam;

import java.io.*;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;


class Result {
    public static String cutThemAll(List<Long> lengths, long minLength) {
        int sum = 0;
        int result;
        for (Long length : lengths) {
            sum += length;
        }
        result = (int) (sum - minLength);
        if (result >= lengths.size()-1 ) {
            return "Possible";
        } else {
            return "Impossible";
        }
    }

}



public class test {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int lengthsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Long> lengths = IntStream.range(0, lengthsCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Long::parseLong)
                .collect(toList());

        long minLength = Long.parseLong(bufferedReader.readLine().trim());

        String result = Result.cutThemAll(lengths, minLength);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
