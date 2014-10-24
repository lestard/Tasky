package eu.lestard.tasky.ui.taskoverview;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import eu.lestard.tasky.model.Task;
import javafx.fxml.FXML;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;

public class TaskOverviewView implements FxmlView<TaskOverviewViewModel> {


    @FXML
    private TreeTableView<Task> taskTreeView;

    @FXML
    private TreeTableColumn<Task, String> titleColumn;

    @InjectViewModel
    private TaskOverviewViewModel viewModel;


    public void initialize(){

        taskTreeView.setRoot(viewModel.getRootNode());
        taskTreeView.setShowRoot(false);

        titleColumn.setCellValueFactory(param -> param.getValue().getValue().titleProperty());
    }

}
