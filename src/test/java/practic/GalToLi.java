package practic;

public class GalToLi {
    public static void main(String args[]) {
    double gallons, liters;    // в этой переменной хранится значение,
    int counter;
    counter = 0;

    for (gallons = 1; gallons <= 100; gallons++){
        liters = gallons * 3.7854;
        System.out.println(gallons + " галлонам соответствует "+ liters + " литров");
        counter++;
        if (counter == 10){
            System.out.println();
            counter = 0;
        }

    }
}
    }