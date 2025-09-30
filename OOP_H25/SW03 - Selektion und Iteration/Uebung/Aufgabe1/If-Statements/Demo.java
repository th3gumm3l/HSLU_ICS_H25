public class Demo
{
    public Demo (){
        
    }
    
    private int Max(int a, int b){
        if (a < b){
            return b;
        }
        else {
            return a;
        }
    }
    
    private int Max(int a, int b, int c) {
        int result = a;
        if (result < b){
            result = b; 
        }
        if (result < c){
            result = c;
        }
        return result;
    }
}