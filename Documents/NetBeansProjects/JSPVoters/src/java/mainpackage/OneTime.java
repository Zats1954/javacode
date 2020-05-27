package mainpackage;
import java.util.TreeMap;

public class OneTime {
  /* TreeMap< День, Часы работы > */ 
    TreeMap<String, String> marks;

    public OneTime() {
        marks = new TreeMap<>();
    }

    public void addTime(String oneDay, String oneHour) {
        marks.put(oneDay, oneHour);
    }

    public TreeMap<String, String> getMarks(){
        return marks;
    }
}
