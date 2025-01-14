package exercise;

// BEGIN
public class LabelTag implements TagInterface {
private String tag;
private final TagInterface inputTag;

public LabelTag(String tag, TagInterface inputTag ){
    this.tag = tag;
    this.inputTag = inputTag;
}

    @Override
    public String render() {
        var result = "<label>" + tag + inputTag.render() +"</label>";
        return result;
    }

}
// END
