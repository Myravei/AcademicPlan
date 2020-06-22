package academicplan.main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button disciplinesButton;

    @FXML
    private Button practicesButton;

    @FXML
    private Button semestersButton;

    @FXML
    private Button searchButton;

    @FXML
    private HBox disciplinesPanel;

    @FXML
    private ListView<?> disciplinesListView;

    @FXML
    private Button openDisciplineButton;

    @FXML
    private HBox practiciesPanel;

    @FXML
    private ListView<?> practiciesListView;

    @FXML
    private HBox semestersPanel;

    @FXML
    private ListView<?> semestersListView;

    private MainModel model = new MainModel();

    @FXML
    void initialize() {

    }
}
