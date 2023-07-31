import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TMMenu extends JPanel {
    public TMMenu()
    {

        setLayout(new BorderLayout());
        tmMenuLbl = new JLabel("Test and Maintain Vending Machine");
        tmMenuBtnPnl = new JPanel(new FlowLayout());
        tmMenuBtns = new ArrayList<>();
        tmMenuBtns.add(new JButton("Test Vending Machine"));
        tmMenuBtns.get(0).setPreferredSize(new Dimension(500, 50));
        tmMenuBtns.add(new JButton("Maintain Vending Machine"));
        tmMenuBtns.get(1).setPreferredSize(new Dimension(500, 50));
        tmMenuBtns.add(new JButton("Exit"));
        tmMenuBtns.get(2).setPreferredSize(new Dimension(500, 50));
        tmMenuBtnPnl.add(tmMenuBtns.get(0));
        tmMenuBtnPnl.add(tmMenuBtns.get(1));
        tmMenuBtnPnl.add(tmMenuBtns.get(2));
        add(tmMenuLbl, BorderLayout.NORTH);
        tmMenuLbl.setHorizontalAlignment(SwingConstants.CENTER);
        tmMenuLbl.setPreferredSize(new Dimension(500, 100));
        add(tmMenuBtnPnl, BorderLayout.CENTER);
    }

    private JPanel tmMenuBtnPnl;
    private ArrayList<JButton> tmMenuBtns = new ArrayList<>();
    JLabel tmMenuLbl;

}
