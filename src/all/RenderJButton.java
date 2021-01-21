package all;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class RenderJButton implements TableCellRenderer {
    private TableCellRenderer defRenderer;
    public RenderJButton(TableCellRenderer renderer){
        defRenderer = renderer;
    }
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
        if (value instanceof Component)
            return (Component)value;
        return defRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}
