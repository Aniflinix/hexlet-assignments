package exercise;

import java.util.Map;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag{
    protected String tagbody;
    protected List<Tag> children;

    public PairedTag(String name, Map<String, String> tagAttributes, String tagbody,List<Tag> children) {
        super(name, tagAttributes);
        this.tagbody = tagbody;
        this.children = children;
    }

    @Override
    public String toString() {
        // Строка для открывающего тега с аттрибутами
        StringBuilder builder = new StringBuilder("<" + name);

        // Если у тега есть атрибуты, добавляем их
        if (tagAttributes != null && !tagAttributes.isEmpty()) {
            for (Map.Entry<String, String> entry : tagAttributes.entrySet()) {
                builder.append(" ")
                        .append(entry.getKey())
                        .append("=\"")
                        .append(entry.getValue())
                        .append("\"");
            }
        }

        // Закрываем открывающий тег
        builder.append(">");

        // Добавляем тело тега (если оно есть)
        if (tagbody != null && !tagbody.isEmpty()) {
            builder.append(tagbody);
        }

        // Добавляем дочерние теги (если они есть)
        if (children != null && !children.isEmpty()) {
            for (Tag child : children) {
                builder.append(child.toString());
            }
        }

        // Добавляем закрывающий тег
        builder.append("</" + name + ">");

        // Возвращаем полное строковое представление тега
        return builder.toString();
    }

}
// END
