package Frame;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.GridLayout;

public class MainPanel extends JPanel {
    private GridLayout layout;
    private int rows,cols;
    private JPanel [][]Map;
    public MainPanel (){
        rows = 25;cols = 25;
        this.setBackground(Color.DARK_GRAY);
        this.setBorder(new TitledBorder(new LineBorder(Color.white)));
        layout = new GridLayout(rows,cols);
        this.setLayout(layout);
        addGridPanel(rows,cols);
    }
    private void addGridPanel(int rows, int cols){
        Map = new JPanel[rows][cols];
        for(int i = 0 ; i<rows;i++){
            for(int j = 0; j<cols;j++){
                Map[i][j] = new JPanel();
                Map[i][j].setBorder(new TitledBorder(new LineBorder(Color.white)));
                Map[i][j].setBackground(Color.gray);
                this.add(Map[i][j]);
            }
        }

    }

}
