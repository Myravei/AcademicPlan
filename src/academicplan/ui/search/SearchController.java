package academicplan.ui.search;

import java.net.URL;
import java.util.ResourceBundle;
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
    private ComboBox<?> semesterComboBox;

    @FXML
    private CheckBox zachetCheckBox;

    @FXML
    private CheckBox examCheckBox;

    @FXML
    private CheckBox courseWorkCheckBox;

    @FXML
    private Label listLabel;

    @FXML
    private AnchorPane disciplinesPanel;

    @FXML
    private ComboBox<?> disciplineSemesterComboBox;

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
    private ComboBox<?> trudSemesterCB;

    @FXML
    private ListView<?> trudoemkostListView;

    @FXML
    void initialize() {

    }
}