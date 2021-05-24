public class Equation extends EquationStack{
    private String equation;
    private String prefix;
    private double answer;
    private String binary;
    private String hex;
    private boolean balanced;

    public Equation(){

    }

    public void setEquation(String equation){
        this.equation=equation;

    }


    public void setPrefix(String prefix){
        this.prefix=prefix;

    }


    public void setAnswer(double answer){
        this.answer=answer;

    }

    public void setBinary(String binary){
        this.binary=binary;

    }

    public void setHex(String hexadecimal){
        this.hex=hexadecimal;

    }

    public void setBool( boolean a){
        this.balanced=a;
    }

    public String getEquation(){
        return this.equation;
    }

    public String getPrefix(){
        return this.prefix;
    }

    public double getAnswer(){
        return this.answer;
    }

    public String getBinary(){
        return this.binary;
    }

    public String getHex(){
        return this.hex;
    }

    public boolean getBalanced(){
        return this.balanced;
    }

    public boolean isBalanced(){
       /* int countleft_parenthesis=0;
        int right_parenthesis=0;
        char[] a = equation.toCharArray();
        for(char c : a){
            if(c=='('){
                countleft_parenthesis = countleft_parenthesis+1;
            }

            if(c==')'){
                right_parenthesis=right_parenthesis+1;
            }
        }

        if(countleft_parenthesis==right_parenthesis){
            return true;
        }
        else{
        return false;} */
        char[] charArr =equation.toCharArray();
        EquationStack<String> obj1 = new EquationStack<String>();
        for(char c:charArr){
            if(c=='(' || c=='{' || c=='['){
                System.out.println("Object pushed");
                obj1.push(Character.toString(c));
            }
            else if(c==')' || c=='}' || c==']'){
                //System.out.println(obj1.peek());
                //System.out.println(obj1.peek().equals(Character.toString('(')));

                if(obj1.isEmpty()==true){
                    System.out.println("the first case ran");
                    return false;
                }

                else if(obj1.peek().equals(Character.toString('(')) && c!=')'){
                    //System.out.println("the 2nd case ran");
                    return false;
                }

                else if(obj1.peek().equals(Character.toString('{')) && c!='}'){
                    return false;
                }

                else if(obj1.peek().equals(Character.toString('[')) && c!=']'){
                    return false;
                }

                else{
                    //System.out.println("Object poped"+ obj1.peek());
                    obj1.pop();
                }

            }

        }
       if(obj1.isEmpty()==false){
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

    public double solveAnswer(String equation){
        char[] charArr = equation.toCharArray();
        for(char c: charArr){
            EquationStack<String> obj1 = new EquationStack<String>();
        if(c=='+' || c=='-'|| c=='*' || c=='/' || c=='^'){
            if(obj1.isEmpty()==true){
                obj1.push(Character.toString(c));


            }
        }
        }

        return 0;
    }
}
