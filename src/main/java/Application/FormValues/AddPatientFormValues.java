package Application.FormValues;

import java.util.List;

public class AddPatientFormValues {
    private List<Character> sexes = List.of('F', 'M');

    public List<Character> getSexes() {
        return sexes;
    }

    public void setSexes(List<Character> sexes) {
        this.sexes = sexes;
    }
}
