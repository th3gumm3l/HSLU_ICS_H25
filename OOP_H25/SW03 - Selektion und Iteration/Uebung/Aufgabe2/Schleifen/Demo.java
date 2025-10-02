public class Demo
{
    public void IterationOfNumForLoop(){
        for (int i = 0; i < 11; i++){
            System.out.println(i);
        }
    }
    
    public void IterationOfNumWhileLoop(){
        int i = 0;
        
        while (i < 11){
            System.out.println(i);
            i++;
        }
    }
    
    public void IterationOfNumDoWhileLoop(){
        int i = 0;
        
        do {
            System.out.println(i);
            i++;
        } while (i < 11);
    }
    
    public void IterationOfNumWhileLoopFloat(){
        float i = 0.9f;
        int counter = 0;
        
        while (i <= 1.0f){
            System.out.println(i);
            i += 0.000025f;
            counter++;
        }
        
        System.out.println(counter);
    }
    
    public void IterationOfNumForLoopFloat(){
        float i = 0.9f;
        int ausgabe = 0;
        
        for (int counter = 0; counter <= 4000; counter++){
            System.out.println(i);
            i += 0.000025f;
            ausgabe = counter;
        }
        
        System.out.println(ausgabe);
    }
    
    public void printBox(final int width, final int height){
        
        for (int row = 0; row < height; row++) {
            if (row == 0 || row == height - 1) {
                // Erste und letzte Zeile komplett #
                for (int col = 0; col < width; col++) {
                    System.out.print("#");
                }
            } else {
                // Mittlere Zeilen: # + Leerzeichen + #
                System.out.print("#");
                for (int col = 0; col < width - 2; col++) {
                    System.out.print(" ");
                }
                System.out.print("#");
            }
            System.out.println(); // Zeilenumbruch
        }
    }
    
}