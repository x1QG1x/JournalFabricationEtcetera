package journalfabricationetcetera.model.tablecell;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Tooltip;
import journalfabricationetcetera.model.ObjectWithRecipe;
import journalfabricationetcetera.model.Recipe;

/**
 * Created by Quentin Gangler on 03/11/2016.
 *
 */
public class RecipeTableCell<M extends ObjectWithRecipe> extends TableCell<M, String>{

    private TableColumn<M, String> param;

    public RecipeTableCell(TableColumn<M, String> param) {
        super();
        this.param = param;
    }

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            setText("");
            setStyle("");
        } else {
            setText(item);
            int currentIndex = indexProperty().getValue() < 0 ? 0 : indexProperty().getValue();
            Recipe recipe = param.getTableView().getItems().get(currentIndex).getRecipe();
            setTooltip(new Tooltip(recipe.getTooltipMessage()));
        }
    }
}
