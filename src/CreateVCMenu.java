import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CreateVCMenu extends JPanel {

    public CreateVCMenu()
    {
        JLabel createVCMenuLbl = new JLabel("Create Vending Machine");
        setLayout(new BorderLayout());
        add(createVCMenuLbl, BorderLayout.NORTH);
        createVCMenuLbl.setPreferredSize(new Dimension(500, 100));
        createVCMenuLbl.setHorizontalAlignment(SwingConstants.CENTER);
        createVCMenuBtns = new ArrayList<>();
        createVCMenuBtns.add(new JButton("Create Regular Vending Machine"));
        createVCMenuBtns.get(0).setPreferredSize(new Dimension(500, 50));
        createVCMenuBtns.add(new JButton("Create Special Vending Machine"));
        createVCMenuBtns.get(1).setPreferredSize(new Dimension(500, 50));
        JPanel createVCMenuPnlBtns = new JPanel(new FlowLayout());
        createVCMenuPnlBtns.add(createVCMenuBtns.get(0));
        createVCMenuPnlBtns.add(createVCMenuBtns.get(1));
        add(createVCMenuPnlBtns);
    }

    public JButton getCreateRegVC()
    {
        return createVCMenuBtns.get(0);
    }

    public JButton getCreateSpecVC()
    {
        return createVCMenuBtns.get(1);
    }

   private ArrayList<JButton> createVCMenuBtns;
   private JPanel createVCMenuPnl;

}
