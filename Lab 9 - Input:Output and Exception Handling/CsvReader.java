import java.nio.file.Files;
import java.nio.file.Path;
import java.io.*;

public class CsvReader {

    public static double[] readCSV() throws FileNotFoundException{
        String categoryName;
        double price, highestPrice = 0.0, school = 0.0, beauty = 0.0, office = 0.0, clothes = 0.0;
        double schoolTotal = 0.0, beautyTotal = 0.0, officeTotal = 0.0, clothesTotal = 0.0;

        try(BufferedReader reader = Files.newBufferedReader(Path.of("Resources/products.csv"))){
            String line = reader.readLine();
            line = reader.readLine();
            while(line != null){
                String[] elements = line.split(",");
                categoryName = elements[1];
                price = Double.parseDouble(elements[2]);

                if(price > highestPrice){
                  highestPrice = price;
                }

                switch (categoryName) {
                    case "school_supplies" -> {
                        schoolTotal = schoolTotal + price;
                        school++;
                    }
                    case "hair_health_beauty" -> {
                        beautyTotal = beautyTotal + price;
                        beauty++;
                    }
                    case "office_supplies" -> {
                        officeTotal = officeTotal + price;
                        office++;
                    }
                    case "clothing" -> {
                        clothesTotal = clothesTotal + price;
                        clothes++;
                    }
                    default -> {
                    }
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        double[] doubleArray = new double[9];
        doubleArray[0] = schoolTotal / school;
        doubleArray[1] = beautyTotal / school;
        doubleArray[2] = officeTotal / school;
        doubleArray[3] = clothesTotal / school;
        doubleArray[4] = highestPrice;
        doubleArray[5] = school;
        doubleArray[6] = beauty;
        doubleArray[7] = office;
        doubleArray[8] = clothes;
        return(doubleArray);
    }

    public static void main(String[] args) throws FileNotFoundException {
        double [] fromFile = readCSV();
        double schoolAvg = fromFile[0];
        double beautyAvg = fromFile[1];
        double officeAvg = fromFile[2];
        double clothesAvg = fromFile[3];
        double highestPrice = fromFile[4];
        double school = fromFile[5];
        double beauty = fromFile[6];
        double office = fromFile[7];
        double clothes = fromFile[8];

        System.out.println("Average price for each category");
        System.out.println("School supplies: " + schoolAvg + "\nHair and beauty: " + beautyAvg);
        System.out.println("Office supplies: " + officeAvg + "\nClothing: " + clothesAvg + "\n");

        System.out.println("Highest priced item: " + highestPrice + "\n");

        System.out.println("Amount of items per category");
        System.out.println("School supplies: " + school + "\nHair and beauty: " + beauty);
        System.out.println("Office supplies: " + office + "\nClothing: " + clothes);
        System.out.println("Average price for each category:");

    }
}
