public class Main {
    public static void main (String[] args) {
        Matrix randomA = new Matrix (2,2);
        randomA.populateRandom();

        Matrix randomB = new Matrix (2,2);
        randomB.populateRandom();

        System.out.println("Matrix A:\n" + randomA);
        System.out.println("Matrix B:\n" + randomB);

        Matrix sumAB = randomA.add(randomB);
        System.out.println("A + B = \n" + sumAB);
        
        //ASKED FOR HELP HERE!!!!!! 
        int[][] leftValues  = { {1, 2, 3}, {4, 5, 6} };          
        int[][] rightValues = { {7, 8}, {9, 10}, {11, 12} };      

        Matrix left2x3  = new Matrix(leftValues);
        Matrix right3x2 = new Matrix(rightValues);

        System.out.println("Left (2x3):\n" + left2x3);
        System.out.println("Right (3x2):\n" + right3x2);

        Matrix product = left2x3.multiply(right3x2);
        System.out.println("Product Left * Right:\n" + product);

        // --- Exception handling demos ---
        try {
            // invalid: dimensions differ for addition
            left2x3.add(right3x2);
            System.out.println("Unexpected: addition succeeded on mismatched sizes.");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected IllegalArgumentException (add): " + e.getMessage());
        }

        try {
            Matrix invalidLeft = new Matrix(2, 3);
            Matrix invalidRight = new Matrix(2, 2);
            invalidLeft.multiply(invalidRight);
            System.out.println("Unexpected: multiplication succeeded on mismatched sizes.");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected IllegalArgumentException (multiply): " + e.getMessage());
        }
        // STOPPED HERE, DID NOT COPY CODE BUT JUST ASKED HELP WITH IMPLEMENTATION
        // I USED IT AS A MENTOR TO THE BEST OF MY ABILITY WITHOUT JUST GENERATING CODE
    }
}

