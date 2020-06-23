package academicplan.ui.semester;

import academicplan.database.DatabaseHandler;
import academicplan.models.Discipline;
import academicplan.ui.discipline.DisciplineController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class SemesterController {

    @FXML
    private Label summaryLabel;

    @FXML
    private Label disciplinesLabel;

    @FXML
    private ListView<String> disciplinesListView;

    @FXML
    private Button openDisciplineButton;

    private int disciplinesCounter = 0;
    private int zachetCounter = 0;
    private int examCounter = 0;
    private int courseWorkCounter = 0;

    private final DatabaseHandler dbHandler = new DatabaseHandler();

    private final SemesterModel model = new SemesterModel();

    @FXML
    void initialize() {
        openDisciplineButton.setOnAction(actionEvent -> openDiscipline(disciplinesListView.getSelectionModel().getSelectedItem()));
    }

    public void setData(ArrayList<Discipline> disciplines, Integer semester){
        model.setDisciplines(disciplines);
        model.setSemester(semester);
        ObservableList<String> disciplinesList = FXCollections.observableArrayList();
        for (Discipline d: disciplines) {
            if(d.getSemester()==semester){
                disciplinesCounter++;
                disciplinesList.add(d.toStringWithControl());
                if(d.getControl().toLowerCase().equals("зачёт")){
                    zachetCounter++;
                } else {
                    examCounter++;
                }
                if(d.isCoursework()){
                    courseWorkCounter++;
                }
            }
        }
        disciplinesLabel.setText(disciplinesCounter+" дисциплин:");
        summaryLabel.setText("Зачётов: "+zachetCounter+", экзаменов: "+examCounter+", курсовых: "+courseWorkCounter);
        disciplinesListView.setItems(disciplinesList);
    }

    private void openDiscipline(String disciplineString){
        Discipline discipline = null;
        for (Discipline d: model.getDisciplines()) {
            if(disciplineString.contains(d.getName()) && d.getSemester()==model.getSemester()){
                discipline = d;
            }
        }
        if (discipline==null) return;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../resources/discipline_view.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle(discipline.getName()+" ("+discipline.getSemester()+" семестр)");
            stage.setScene(new Scene(root,280,280));
            stage.setResizable(false);
            DisciplineController controller = loader.getController();
            controller.setData(discipline);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
