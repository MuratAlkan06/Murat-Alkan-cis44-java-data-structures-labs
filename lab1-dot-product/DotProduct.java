public class DotProduct{
    public static void main(String[] args){
        int n = 5;
        int[] firstArray = new int[n];
        int[] secondArray = new int[n];
        int[] resultArray = new int[n];
        
        for (int i =0; i<n; i++){
            firstArray[i] = (int)(Math.random()*10) + 1;
            secondArray[i] = (int)(Math.random()*10) + 1;  
            resultArray[i] = firstArray[i] * secondArray[i];
        } 
        System.out.print("First Array: ");
        for (int i =0; i<n; i++){
            System.out.print(firstArray[i] + " ");
        }
        
        System.out.print("\nSecond Array: ");
        for (int i =0; i<n; i++){
            System.out.print(secondArray[i] + " ");
        }

        System.out.print("\nResult Array: ");
        for (int i =0; i<n; i++){
            System.out.print(resultArray[i] + " ");
        }
    }
}