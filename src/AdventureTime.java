import java.io.*;
import java.util.Scanner;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        int answer = challengeOne("inputOneTwo.txt");
        System.out.println(answer);
        int answer1 = challengeTwo("inputOneTwo.txt");
        System.out.println(answer1);
        int answer3 = challengeThree("inputThreeFour.txt");
        System.out.println(answer3);
        int answer4 = challengeFour("inputThreeFour.txt");
        System.out.println(answer4);
    }

    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {
        int[] a = readFile(fileName);
        int z = 0;
        for(int i = 0; i < a.length-1; i++){
            if(a[i] < a[i+1]){
                z++;
            }
        }
        return z;
    }

    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        int[] a = readFile(fileName);
        int z = 0;
        for(int i = 0; i < a.length-3; i++){
            if(a[i] < a[i+3]){
                z++;
            }
        }
        return z;
    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {
        String[] a = readString(fileName);
        int x = 0;
        int y = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i].charAt(0) == 'u'){
                int z = Integer.parseInt(a[i].split(" ") [1]);
                y -= z;
            }
            if(a[i].charAt(0) == 'd'){
                int z = Integer.parseInt(a[i].split(" ") [1]);
                y += z;
            }
            if(a[i].charAt(0) == 'f'){
                int z = Integer.parseInt(a[i].split(" ") [1]);
                x += z;
            }

        }
        return x*y;
    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param filename
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String fileName) throws FileNotFoundException {
        String[] a = readString(fileName);
        int x = 0;
        int y = 0;
        int xy = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i].charAt(0) == 'u'){
                int z = Integer.parseInt(a[i].split(" ") [1]);
                xy -= z;
            }
            if(a[i].charAt(0) == 'd'){
                int z = Integer.parseInt(a[i].split(" ") [1]);
                xy += z;
            }
            if(a[i].charAt(0) == 'f'){
                int z = Integer.parseInt(a[i].split(" ") [1]);
                x += z;
                y += z*xy;
            }

        }
        return x*y;
    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    private static String[] readString(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        String[] data = new String[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {

            data[index++] = scanner.nextLine();
        }
        scanner.close();
        return data;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

}