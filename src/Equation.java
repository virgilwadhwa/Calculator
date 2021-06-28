import java.lang.Math;
import java.util.Stack;
import java.util.ArrayList;

public class Equation extends EquationStack<String> {
    private String equation="";
    private String prefix="";
    private String postfix="";
    private double answer;
    private String binary="";
    private String hex="";
    private boolean balanced;
    private String precedence1 = "+-";
    private String precedence2 = "*/";
    private String precedence3 = "^";
    private String precedence4 = "({[";
    private ArrayList<String> postList = new ArrayList<String>();



    public Equation() {

    }

    public void setEquation(String equation) {
        this.equation = equation;
    }

    public ArrayList<String> getPostList(){
        return this.postList;
    }


    public void setPrefix(String prefix) {
        this.prefix = prefix;

    }


    public void setAnswer(double answer) {
        this.answer = answer;

    }

    public void setBinary(String binary) {
        this.binary = binary;

    }

    public void setHex(String hexadecimal) {
        this.hex = hexadecimal;

    }

    public void setBool(boolean a) {
        this.balanced = a;
    }

    public String getEquation() {
        return this.equation;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public double getAnswer() {
        return this.answer;
    }

    public String getBinary() {
        return this.binary;
    }

    public String getHex() {
        return this.hex;
    }

    public boolean getBalanced() {
        return this.balanced;
    }

    public boolean inString(String s, String e) {
        return s.contains(e);
    }

    public boolean isBalanced() {
        char[] charArr = equation.toCharArray();
        EquationStack<String> obj1 = new EquationStack<String>();
        //Stack<Character> operatorStack = new Stack<Character>();
        ArrayList<Character> operatorAray = new ArrayList<Character>();
        int i=0;
        for (char c : charArr) {
            operatorAray.add(c);
            if(c== '+' || c=='-' || c=='/' || c=='*' || c=='^' ){
                if(i>0){
                    if(operatorAray.get(i-1)=='+' || operatorAray.get(i-1)=='-' || operatorAray.get(i-1)=='/' || operatorAray.get(i-1)=='*' || operatorAray.get(i-1)=='^'){
                        return false;
                    }
                }

            }
            if (c == '(' || c == '{' || c == '[') {
                //System.out.println("Object pushed");
                obj1.push(Character.toString(c));
            } else if (c == ')' || c == '}' || c == ']') {
                //System.out.println(obj1.peek());
                //System.out.println(obj1.peek().equals(Character.toString('(')));

                if (obj1.isEmpty() == true) {
                    //System.out.println("the first case ran");
                    return false;
                } else if (obj1.peek().equals(Character.toString('(')) && c != ')') {
                    //System.out.println("the 2nd case ran");
                    return false;
                } else if (obj1.peek().equals(Character.toString('{')) && c != '}') {
                    return false;
                } else if (obj1.peek().equals(Character.toString('[')) && c != ']') {
                    return false;
                } else {
                    //System.out.println("Object poped"+ obj1.peek());
                    obj1.pop();
                }

            }
            i++;
        }
        i=i-1;
        if(operatorAray.get(i)=='+' || operatorAray.get(i)=='-' || operatorAray.get(i)=='/' || operatorAray.get(i)=='*' || operatorAray.get(i)=='^'){
            return false;
        }
        if (obj1.isEmpty() == false) {
            //System.out.println("Last case ran");
            return false;
        }
        return true;
    }

    /*public double calcAns(EquationStack a){
        EquationStack obj1=a;
        //obj1=a;
        char[] charArr =equation.toCharArray();
        for(char c:charArr){
            if(c=='+' || c=='-' || c=='/' || c=='*' || c=='^' || c=='(' || c==')' ){


            }

        }
    return 0;
    }*/

    public void check(){
        EquationStack<String> obj1 = new EquationStack<String>();
        char[] charArr = equation.toCharArray();
        for(char c : charArr){
            obj1.push(Character.toString(c));
        }
    }
/*
    public int getPriority(String a, String b){ // checks if a>b

        if(precedence1.contains(a) && (precedence2.contains(b) || precedence3.contains(b))){
            return -1; // 1 means that priority of b is higher than a , 0 means that priority is equal, -1 means that priority is low
        }

        else if(precedence2.contains(a) && (precedence3.contains(b))){
            return -1;
        }


        else if(precedence1.contains(a) && precedence1.contains(b)){
            return 0;
        }

        else if(precedence2.contains(a) && precedence2.contains(b)){
            return 0;
        }

        else if(precedence3.contains(a) && precedence3.contains(b)){
            return 0;
        }

        else {
            return 1;
        }
    }

 */

    public int getPriority(String a, String b){ // checks if a>b

        if(getPrecedence(a) < getPrecedence(b)){
            return -1; // 1 means that priority of b is higher than a , 0 means that priority is equal, -1 means that priority is low
        }

        else {
            return 1;
        }
    }


    public int getPrecedence(String a){ // checks if a>b

        if(precedence1.contains(a)){
            return 1; // 1 means that priority of b is higher than a , 0 means that priority is equal, -1 means that priority is low
        }

        else if(precedence2.contains(a)){
            return 2;
        }


        else if(precedence3.contains(a)){
            return 3;
        }
/*
        else if(precedence4.contains(a)){
            return 4;
        }*/

        else {
            return 0;
        }
    }

    public boolean assositivityLR(String a){
        if(a.equals("^")){
            return false;
        }
        else{
            return true;
        }
    }

    public String inToPost(){


        postfix="";
        postList.clear();
        String mother=precedence1+precedence2+precedence3;
        //String s = "";
        EquationStack<String> postStack = new EquationStack<String>();
//      char[] charArr = equation.toCharArray();
        String q=null;
        ArrayList<String> thisList = scanOperand();

        for(String a: thisList){
            //System.out.println("loop running");
            //String q = Character.toString(c);
            //q= Character.toString(c);
            if(a.equals("+")==false && a.equals("-") == false && a.equals("*") == false && a.equals("/") ==false && a.equals("^") == false && a.equals("(") == false && a.equals(")") == false ){
                postfix = postfix + a;
                postList.add(a);
            }
            else if (precedence4.contains(a)){
                postStack.push(a);
            }

            else if (a.equals(")") || a.equals("]") || a.equals("}") ){
                while(precedence4.contains(postStack.peek())==false){
                    postfix=postfix+postStack.peek();
                    postList.add(postStack.peek());
                    postStack.pop();
                    //postStack.pop();
                }
                postStack.pop();
            }
            else if(mother.contains(a)){
                if(postStack.isEmpty()==true){
                    postStack.push(a);
                }

                else if(precedence4.contains(postStack.peek())){
                    postStack.push(a);
                }

                else if(getPrecedence(a)>getPrecedence(postStack.peek())){
                    postStack.push(a);
                }

                else if(precedence4.contains(postStack.peek())){
                    postStack.push(a);
                }

                else{
                    //if()

                while(postStack.isEmpty()!= true && getPrecedence(a)<=getPrecedence(postStack.peek())){
                    if(a.equals("^")==false){ postfix=postfix+postStack.peek();
                        postList.add(postStack.peek());
                    postStack.pop();
                    //postStack.pop();
                        }
                    else if(a.equals("^")){
                        postStack.push(a);
                        break;
                    }
                }                postStack.push(a);
                     }

            }

        }

        while(postStack.isEmpty() == false)
        {
            postfix = postfix+postStack.peek();
            postList.add(postStack.peek());
            postStack.pop();
        }

        return postfix;
    }



    /*public String inToPost() {
        postfix="";
        String mother=precedence1+precedence2+precedence3;
        String s = "";
        EquationStack<String> postStack = new EquationStack<String>();
        char[] charArr = equation.toCharArray();
        String q=null;

        for(char c:charArr){
            //System.out.println("loop running");
            //String q= Character.toString(c);
            q= Character.toString(c);
            if(c != '+' && c != '-' && c != '*' && c != '/' && c!= '^' && c != '(' && c != ')'){
                postfix = postfix + q;
            }
            else if (precedence4.contains(q)){
                postStack.push(q);
            }

            else if (c==')' || c==']' || c== '}' ){
                while(precedence4.contains(postStack.peek())==false){
                    postfix=postfix+postStack.peek();
                    postStack.pop();
                    //postStack.pop();
                }
                postStack.pop();
            }
            else if(mother.contains(q)){
                if(postStack.isEmpty()==true){
                    postStack.push(q);
                }

                else if(precedence4.contains(postStack.peek())){
                    postStack.push(q);
                }

                else if(getPrecedence(q)>getPrecedence(postStack.peek())){
                    postStack.push(q);
                }

                else if(precedence4.contains(postStack.peek())){
                    postStack.push(q);
                }

                else{
                    //if()

                while(postStack.isEmpty()!= true && getPrecedence(q)<=getPrecedence(postStack.peek())){
                    if(c!='^'){ postfix=postfix+postStack.peek();
                    postStack.pop();
                    //postStack.pop();
                        }
                    else if(c=='^'){
                        postStack.push(q);
                        break;
                    }
                }                postStack.push(q);
                     }

            }

        }

        while(postStack.isEmpty() == false)
        {
            postfix = postfix+postStack.peek();
            postStack.pop();
        }
        return postfix;
    } */

    public ArrayList<String> scanOperand(){
        ArrayList<String> operandBank  = new ArrayList<String>();
        String equationCopy = equation;
        String s ="";
        int i=0;

        char[] a = equation.toCharArray();
        for(char c :a){
            if(c != '+' && c != '-' && c != '*' && c != '/' && c!= '^' && c != '(' && c!= ')'){
                s= s + Character.toString(c);
            }

            else if(c == '+' || c == '-' || c == '*' || c == '/' || c== '^' || c == '(' || c== ')'){
                //s="";
                //s=s+Character.toString(c);
                if(s!=""){
                    operandBank.add(s);
                }
                s="";
                operandBank.add(Character.toString(c));
            }
/*
            else{
                if(s!=""){
                operandBank.add(s);
                }
                s="";
            }*/
        }
        operandBank.add(s);
        //System.out.println(operandBank);
        return operandBank;
    }


    public double decimalAnswer(){
        String temp1= inToPost();
        //String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        //char[] decArr = temp1.toCharArray();
        //EquationStack<String> postStack = new EquationStack<String>();
        EquationStack<String> dec = new EquationStack<String>();
        //String decimal="1";
        //String q=null;
        double sum=0;
        double temp=0;

        for( String a : postList){
            //q = Character.toString(c);
            //a.equals("+")==false && a.equals("-") == false && a.equals("*") == false && a.equals("/") ==false && a.equals("^") == false && a.equals("(") == false && a.equals(")") == false
            //System.out.println("I am in 2");
            if(a.equals("+")==false && a.equals("-") == false && a.equals("*") == false && a.equals("/") ==false && a.equals("^") == false){
                //System.out.println("I am in 2");
                dec.push(a);

            }


            else if(a.equals("+")==true || a.equals("-") == true || a.equals("*") == true || a.equals("/") == true || a.equals("^")==true){
                //System.out.println("I am in");
                temp = Double.parseDouble(dec.peek());
                dec.pop();
                if(a.equals("+")){
                    sum=Double.parseDouble(dec.peek()) +  temp;
                    dec.pop();
                }

               else if(a.equals("-") == true) {
                    sum=Double.parseDouble(dec.pop()) - temp;
                }

                else if(a.equals("*") == true ) {
                    sum=Double.parseDouble(dec.peek())*temp;
                    dec.pop();
                }

                else if(a.equals("/") == true) {
                    sum=Double.parseDouble(dec.pop())/temp;
                }

                else if(a.equals("^") == true) {
                    sum= Math.pow(Double.parseDouble(dec.pop()), temp);
                }
                dec.push(Double.toString(sum));
            }

        }
        return sum;
    }



    public String hexaDecimal(){
        decimalAnswer();
        hex="";
        double decimalvalue =  decimalAnswer();
        int temp3=0;
        int intPart=0;
        int rem=0;
        double decimalPart=0;
        intPart = (int)decimalvalue;
        decimalPart = decimalvalue-intPart;


        char hexchars[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G'};
        while(intPart>0)
        {
            rem=intPart%16;
            hex=hexchars[rem]+hex;
            intPart=intPart/16;
        }



        int intTemp=0;
        int swi=0;
        double newDecVal=0;

if(decimalPart !=0 ){
    hex = hex + ".";
    intTemp = (int)(decimalPart*16);
    newDecVal = decimalPart*16-(int)(decimalPart*16);

    int i=0;
    int multiple;
    double decimalmul=0;

    while(decimalPart!=0 && i<3)
    {
        decimalmul = decimalPart*16;
        multiple = (int)decimalmul;
        System.out.println(multiple);
        hex=hex + hexchars[multiple];
        decimalPart = decimalmul - multiple;
        i++;
    }

}
        //System.out.println("hex= :" + hex);
        return hex;
    }
}
