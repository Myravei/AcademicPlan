package academicplan.ui.search;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import academicplan.models.Discipline;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

public class SearchController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button semesterButton;

    @FXML
    private Button disciplinesButton;

    @FXML
    private Button trudoemkostButton;

    @FXML
    private AnchorPane semesterPanel;

    @FXML
    private ComboBox<Integer> semesterComboBox;

    @FXML
    private Label listLabel;

    @FXML
    private AnchorPane disciplinesPanel;

    @FXML
    private ComboBox<Integer> disciplineSemesterComboBox;

    @FXML
    private CheckBox disciplinesLabCB;

    @FXML
    private CheckBox disciplinesPrCB;

    @FXML
    private CheckBox disciplinesLecCB;

    @FXML
    private CheckBox disciplinesCourseWorksCB;

    @FXML
    private CheckBox disciplinesZachetCB;

    @FXML
    private CheckBox disciplinesExamsCB;

    @FXML
    private ListView<?> disciplinesListView;

    @FXML
    private AnchorPane trudoemkostPanel;

    @FXML
    private ComboBox<Integer> trudSemesterCB;

    @FXML
    private ListView<?> trudoemkostListView;

    private final SearchModel model = new SearchModel();

    @FXML
    void initialize() {
        semesterComboBox.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8));
        disciplineSemesterComboBox.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8));
        trudSemesterCB.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8));
        semesterButton.setOnAction(actionEvent -> showPanel(semesterPanel));
        disciplinesButton.setOnAction(actionEvent -> showPanel(disciplinesPanel));
        trudoemkostButton.setOnAction(actionEvent -> showPanel(trudoemkostPanel));

        semesterComboBox.setOnAction(actionEvent -> updateListLabel());
    }

    public void setData(ArrayList<Discipline> disciplines) {
        model.setDisciplineList(disciplines);
    }

    void showPanel(AnchorPane panel) {
        semesterPanel.setVisible(panel.getId().equals(semesterPanel.getId()));
        disciplinesPanel.setVisible(panel.getId().equals(disciplinesPanel.getId()));
        trudoemkostPanel.setVisible(panel.getId().equals(trudoemkostPanel.getId()));
    }

    void updateListLabel() {
        int exams = 0, zachets = 0, works = 0;
        for (Discipline d : model.getDisciplineList()) {
            if(d.getSemester()==semesterComboBox.getSelectionModel().getSelectedItem()){
                if (d.getControl().toLowerCase().equals("зачёт")) {
                    zachets++;
                }
                if (d.getControl().toLowerCase().equals("экзамен")) {
                    exams++;
                }
                if(d.isCoursework()) {
                    works++;
                }
            }
        }
        listLabel.setText(zachets+" зачётов, "+exams+" экзаменов, "+works+" курсовых");
    }
}