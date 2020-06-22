package academicplan.ui.main;

import academicplan.models.Discipline;

import java.util.ArrayList;

public class MainModel {

    private ArrayList<Discipline> disciplineList = new ArrayList<>();

    public ArrayList<Discipline> getDisciplineList() {
        return disciplineList;
    }

    public void setDisciplineList(ArrayList<Discipline> disciplineList) {
        this.disciplineList = disciplineList;
    }
}
