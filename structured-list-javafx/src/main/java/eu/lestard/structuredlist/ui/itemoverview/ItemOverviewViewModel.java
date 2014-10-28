package eu.lestard.structuredlist.ui.itemoverview;

import de.saxsys.mvvmfx.ViewModel;
import eu.lestard.structuredlist.model.Item;
import eu.lestard.structuredlist.model.ItemsModel;
import eu.lestard.structuredlist.util.RecursiveTreeItem;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.TreeItem;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Optional;

@Singleton
public class ItemOverviewViewModel implements ViewModel {

    private TreeItem<Item> rootNode;

    private ObjectProperty<TreeItem<Item>> selectedItem = new SimpleObjectProperty<>();

    @Inject
    ItemsModel itemsModel;

    public ItemOverviewViewModel(){
        rootNode = new RecursiveTreeItem<>(Item::getSubItems);
    }

    @PostConstruct
    void init(){
        rootNode.setValue(itemsModel.getRoot());
    }


    public TreeItem<Item> getRootNode(){
        return rootNode;
    }

    public ObjectProperty<TreeItem<Item>> selectedItemProperty(){
        return selectedItem;
    }

    public Optional<Item> getSelectedItem(){
        final TreeItem<Item> selectedTreeItem = selectedItem.get();
        if(selectedTreeItem != null){
            return Optional.of(selectedTreeItem.getValue());
        }
        return Optional.empty();
    }
}
