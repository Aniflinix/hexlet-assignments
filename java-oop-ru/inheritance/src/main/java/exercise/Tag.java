package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public abstract class Tag{
    protected String name;
    protected  Map<String,String> tagAttributes;

    public Tag(String name, Map<String,String> tagAttributes){
        this.name = name;
        this.tagAttributes = tagAttributes;
    }

    public String getName(){
        return name;
    }

    public Map<String,String> getTagAttributes(){
        return tagAttributes;
    }
    public abstract String toString();
}
// END
