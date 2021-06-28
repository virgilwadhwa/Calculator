import java.util.Scanner;

public class Calculator {

    public static void main(String[] args){
        Equation obj1 = new Equation();
        boolean breaking_var = true;

        while(breaking_var==true){
            System.out.println("Press A for adding an equation, B for calculating postfix, C to see the Decimal, D to Hexadecimal");
            Scanner sc = new Scanner(System.in);
            String choice = sc.nextLine();

            switch(choice){
                case "A":
                    System.out.println("Enter the Equationof your choice");
                    String eq = sc.nextLine();
                    obj1.setEquation(eq);
                    if (obj1.isBalanced() == false){
                        while(obj1.isBalanced()==false){
                            System.out.println("Please enter a Balanced equation");
                            eq = sc.nextLine();
                            obj1.setEquation(eq);
                        }
                    }


                    //if (obj1.isBalanced() == false) {throw new ArithmeticException("equation is not balanced enter a proper equation");}
                    break;

                case "B":
                    System.out.println("Calculating Posfix: " + obj1.inToPost()+obj1.getPostList() + "   ");
                    break;

                case "C":
                    System.out.println("Calculating DecimalAnswer: " + obj1.decimalAnswer()+ "   ");
                     break;

                case "D":
                    System.out.println("Calculating Hexadecimal Answer: " + obj1.hexaDecimal()+ "   ");
                    break;
                case "E":
                    //System.out.println("Calculating Hexadecimal Answer: " + obj1.hexaDecimal()+ "   ");
                    breaking_var=false;
                    System.out.println("breaking the loop ok Goodbye ");
                    break;
            } }






/*
            else{
                //obj1.setEquation("A*(B+C)/D");
                //obj1.setEquation("16*(17+34)/10");
                //obj1.setEquation("17");
                //obj1.setEquation("a+b*(c^d-e)^(f+g*h)-i");
                obj1.setEquation("1+24*(3^2-5)^(1+2*1)-9");
            //obj1.setEquation("a^b^c^d-e^f+g*h-i");
            //obj1.setEquation("A*(B+C)/D");
            //System.out.println(obj1.isBalanced());
            //System.out.println(obj1.solveAnswer());
            //obj1.solveAnswer();
            //obj1.check();
            //System.out.println(obj1.getPriority("*","("));
            //obj1.scanOperand();
            //obj1.decimalAnswer();
            //System.out.println("infix: "+ obj1.getEquation()+ " to postfix: " + obj1.inToPost() + " expected output : abcd^e-fgh*+^*+i-" + "Decimal Answer is: " + obj1.decimalAnswer() + " hexadecimal value : " + obj1.hexaDecimal()  +" Array List Value" +  obj1.getPostList()  );
            System.out.println("infix: " + " to postfix: " + " expected output : abcd^e-fgh*+^*+i-" + "Decimal Answer is: " + obj1.decimalAnswer() + " hexadecimal value : " + " Array List Value" + obj1.getPostList());
            System.out.println("Hexadecimal = " + obj1.hexaDecimal());
        } */



        //+obj1.hexaDecimal()
    }
}
