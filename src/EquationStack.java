import java.util.Stack;
public class EquationStack<String> extends Stack<String>{
    private int top=0;

    @Override
    public String push(String item) {
        return super.push(item);
    }


    @Override
    public synchronized String pop() {
        return super.pop();
    }

    @Override
    public synchronized int size() {
        return super.size();
    }

    @Override
    public synchronized boolean isEmpty() {
        return super.isEmpty();
    }

    public int getTop() {
        return top;
    }

    @Override
    public synchronized String peek() {
        return super.peek();
    }
}
