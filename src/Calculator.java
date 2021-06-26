public class Calculator {

    public static void main(String[] args){
        Equation obj1 = new Equation();

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
        System.out.println("infix: "+ " to postfix: " +  " expected output : abcd^e-fgh*+^*+i-" + "Decimal Answer is: " + obj1.decimalAnswer() + " hexadecimal value : "  +" Array List Value" +  obj1.getPostList()  );
        System.out.println("Hexadecimal = " + obj1.hexaDecimal());


        //+obj1.hexaDecimal()
    }
}
