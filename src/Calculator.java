public class Calculator {

    public static void main(String[] args){
        Equation obj1 = new Equation();
        obj1.setEquation("[{()}]");
        System.out.println(obj1.isBalanced());


    }
}
