package exercise;

// BEGIN
public class ReversedSequence implements CharSequence{
    private String text;
    private String reversed;

    public ReversedSequence(String input){
        this.text = input;
        this.reversed = new StringBuilder(input).reverse().toString();
    }

    @Override
    public int length(){
        return reversed.length();
    }
    @Override
    public char charAt(int index){
        return reversed.charAt(index);
    }
    @Override
    public CharSequence subSequence(int begin,int end) {
        return reversed.substring(begin, end);
    }
    @Override
    public String toString(){
        var reversed1 = reversed;
        return reversed1;
    }

}
// END
