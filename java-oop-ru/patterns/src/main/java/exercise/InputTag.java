package exercise;

// BEGIN
public class InputTag implements TagInterface{
    private String type;
    private String value;

    public InputTag(String type,String value){
        this.type = type;
        this.value = value;
    }
    public String getType(){
        return type;
    }
    public String getValue(){
        return value;
    }

    @Override
    public String render(){
        var result = "<input type=" +"\"" + getType() +"\""+ " value=" +"\""+ getValue() +"\""+ ">";
        return result;
    }
}
// END
