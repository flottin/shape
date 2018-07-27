package in.karatube;


import javax.swing.JFrame;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.TableModel;
import javax.swing.table.AbstractTableModel;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.UIManager;
import javax.swing.table.TableColumn;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

//Classe écoutant notre premier bouton
class BtnListener implements ActionListener{
private JLabel label;
private String txt;

public BtnListener(JLabel label, JButton btn){
    this.label = label;
    this.txt = btn.getLabel();
}
public BtnListener(JLabel label, String txt){
    this.label = label;
    this.txt = txt;
}


  //Redéfinition de la méthode actionPerformed()
  public void actionPerformed(ActionEvent arg0) {
    this.label.setText("You clicked button : " + txt);
  }
}


public  class Fenetre extends JFrame{


  public Fenetre(){
try{

          UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");

}catch(Exception e){}
    this.setTitle("Box Layout");
    this.setSize(1140, 410);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
//this.setBackground(Color.DARK_GRAY);
    JPanel b1 = new JPanel();
    b1.setBackground(Color.DARK_GRAY);
    //On définit le layout en lui indiquant qu'il travaillera en ligne
    b1.setLayout(new BoxLayout(b1, BoxLayout.LINE_AXIS));
    JLabel label = new JLabel("click buttons:", SwingConstants.LEFT);

    JButton btn1 = new JButton("Button 1");
    JButton btn2 = new JButton("Button 2");
    JButton btn3 = new JButton("Button 3");
    JButton btn4 = new JButton("Button 4");
    btn1.addActionListener(new BtnListener(label, btn1));
    btn2.addActionListener(new BtnListener(label, btn2));
    btn3.addActionListener(new BtnListener(label, btn3));
    btn4.addActionListener(new BtnListener(label, btn4));


    btn4.setBackground(Color.BLACK);
    b1.add(btn1);
    b1.add(btn2);
    b1.add(btn3);
    b1.add(btn4);

    JPanel b2 = new JPanel();

    b2.setLayout(new BoxLayout(b2, BoxLayout.LINE_AXIS));
b2.setBackground(Color.DARK_GRAY);
    TableModel dataModel = new AbstractTableModel() {
        public int getColumnCount() { return 15; }
        public int getRowCount() { return 40;}
        public Object getValueAt(int row, int col) { return new Integer(row*col); }
    };
    JTable table = new JTable(dataModel);

    Color ivory = new Color(255, 255, 222);
table.setOpaque(true);
table.setFillsViewportHeight(true);
table.setBackground(Color.DARK_GRAY);
table.setGridColor(Color.BLACK);
table.setBorder(BorderFactory.createEmptyBorder());



TableColumn column = null;
for (int i = 0; i < 15; i++) {
    column = table.getColumnModel().getColumn(i);

    if (i == 2) {
        column.setMinWidth(75); //third column is bigger
    } else {
        column.setMinWidth(75);
    }
    column.setMaxWidth(75);
}

DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
centerRenderer.setHorizontalAlignment( DefaultTableCellRenderer.CENTER );

table.setDefaultRenderer(Object.class, centerRenderer);
TableCellRenderer rendererFromHeader = table.getTableHeader().getDefaultRenderer();
JLabel headerLabel = (JLabel) rendererFromHeader;
headerLabel.setHorizontalAlignment(JLabel.CENTER);
//table.getTableHeader().getColumnModel().getColumns().setDefaultRenderer(Object.class, centerRenderer);
table.getTableHeader().setBackground(Color.BLACK);
table.getTableHeader().setForeground(Color.WHITE);
table.setSelectionBackground(Color.GRAY);

    JScrollPane  scrollpane = new JScrollPane(table);
    scrollpane.setVerticalScrollBarPolicy(
   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    scrollpane.setBorder(BorderFactory.createEmptyBorder());
    scrollpane.setBackground(Color.DARK_GRAY);
b2.add(scrollpane);

    JPanel b3 = new JPanel();
    //Idem pour cette ligne
    b3.setLayout(new BoxLayout(b3, BoxLayout.LINE_AXIS));
    b3.setBackground(Color.DARK_GRAY);
    b3.add(label);

    JPanel b4 = new JPanel();
    //On positionne maintenant ces trois lignes en colonne
    b4.setLayout(new BoxLayout(b4, BoxLayout.PAGE_AXIS));
    b4.setBackground(Color.DARK_GRAY);

    b4.add(b3);
    b4.add(b2);
    b4.add(b1);


    this.getContentPane().add(b4);
    this.getContentPane().setBackground(Color.DARK_GRAY);
    this.setVisible(true);
  }
}
