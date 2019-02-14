package practic;

public class LogicalOpTable {

    public static void main(String args[]) {
        int p;
        int q;

        System.out.println("P\tQ\tAND\tOR\tXOR\tNOT");
        p = 1;
        q = 0;
        System.out.print(p + "\t" + q + "\t");
        System.out.print((p & q) + "\t" + (p|q) + "\t");
        System.out.println((p^q) + "\t" + (p));
        p = 1;
        q = 0;
        System.out.print(p + "\t" + q + "\t");
        System.out.print((p & q) + "\t" + (p|q) + "\t");
        System.out.println((p^q) + "\t" + (p));
        p = 1;
        q = 0;
        System.out.print(p + "\t" + q + "\t");
        System.out.print((p & q) + "\t" + (p|q) + "\t");
        System.out.println((p^q) + "\t" + (p));
        p = 1;
        q = 0;
        System.out.print(p + "\t" + q + "\t");
        System.out.print((p & q) + "\t" + (p|q) + "\t");
        System.out.println((p^q) + "\t" + (p));

    }
}