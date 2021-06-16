package Application.FormValues;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormValues {
    private Map<String, String> sexes;

    public FormValues() {
        sexes = new HashMap<>();
        sexes.put("M", "Male");
        sexes.put("F", "Female");
    }

    public Map<String, String> getSexes() {
        System.out.println(sexes);
        return sexes;
    }

    public void setSexes(Map<String, String> sexes) {
        this.sexes = sexes;
    }
}
