public class first {
    public static void main(String[] args) {
        int sum = 1000;
        int a;
        for (a = 1; a <= sum/3; a++)
        {
            int b;
            for (b = a + 1; b <= sum/2; b++)
            {
                int c = sum - a - b;
                if ( a*a + b*b == c*c ) {
                    System.out.println("A : " + a + " B : " + b + " C : " + c);
                    System.out.println("Sum is " + (a + b + c));
                    System.out.println("Result is " + a * b * c);
                }
            }
        }

    }
}
