package MainApp;

import java.util.ArrayList;

public class Group {
    private String name;
    private String groupID;
    private int slots;

    private ArrayList<Student> students;

    public Group (String name, String groupID, int slots) {
        this.name = name;
        this.groupID = groupID;
        this.slots = slots;
        this.students = new ArrayList<>();
    }
}
