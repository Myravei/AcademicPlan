package academicplan.ui.main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
    private Button openDisciplineButton;

    @FXML
    private HBox disciplinesPanel;

    @FXML
    private HBox practiciesPanel;

    @FXML
    private HBox semestersPanel;

    @FXML
    private ListView<Discipline> disciplinesListView;

    @FXML
    private ListView<?> practiciesListView;

    @FXML
    private ListView<?> semestersListView;

    private final MainModel model = new MainModel();

    private final DatabaseHandler dbHandler = new DatabaseHandler();

    @FXML
    void initialize() {
        model.setDisciplineList(dbHandler.getDisciplines());
        disciplinesButton.setOnAction(actionEvent -> {
            showPanel(disciplinesPanel);
            ObservableList<Discipline> disciplineList = FXCollections.observableList(model.getDisciplineList());
            disciplinesListView.setItems(disciplineList);
        });
        openDisciplineButton.setOnAction(actionEvent -> openDiscipline(disciplinesListView.getSelectionModel().getSelectedItem()));
        practicesButton.setOnAction(actionEvent -> showPanel(practiciesPanel));
        semestersButton.setOnAction(actionEvent -> showPanel(semestersPanel));
        searchButton.setOnAction(actionEvent -> {});
    }

    void showPanel(HBox panel){
        disciplinesPanel.setVisible(panel.getId().equals(disciplinesPanel.getId()));
        practiciesPanel.setVisible(panel.getId().equals(practiciesPanel.getId()));
        semestersPanel.setVisible(panel.getId().equals(semestersPanel.getId()));
    }

    void openDiscipline(Discipline discipline){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../../resources/discipline_view.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setOpacity(1);
            stage.setTitle(discipline.getName());
            stage.setScene(new Scene(root,280,280));
            DisciplineController controller = loader.getController();
            controller.setData(discipline);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}