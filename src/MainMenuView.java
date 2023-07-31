import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainMenuView extends JPanel{

    public MainMenuView()
    {
        setLayout(new BorderLayout());
        mainMenuLbl = new JLabel("Main Menu");
        add(mainMenuLbl, BorderLayout.NORTH);
        mainMenuLbl.setPreferredSize(new Dimension(500, 100));
        mainMenuLbl.setHorizontalAlignment(SwingConstants.CENTER);
        JPanel mainMenuBtnPnl = new JPanel(new FlowLayout());
        mainMenuBtns.add(new JButton("Create Vending Machine"));
        mainMenuBtns.get(0).setPreferredSize(new Dimension(500, 50));
        mainMenuBtns.add(new JButton("Test and Maintain Vending Machine"));
        mainMenuBtns.get(1).setPreferredSize(new Dimension(500, 50));
        mainMenuBtns.add(new JButton("Exit"));
        mainMenuBtns.get(2).setPreferredSize(new Dimension(500, 50));
        mainMenuBtnPnl.add(mainMenuBtns.get(0));
        mainMenuBtnPnl.add(mainMenuBtns.get(1));
        mainMenuBtnPnl.add(mainMenuBtns.get(2));
        add(mainMenuBtnPnl, BorderLayout.CENTER);

    }

    public JButton getCreateBtn()
    {
        return mainMenuBtns.get(0);
    }

    public JButton getTMBtn()
    {
        return mainMenuBtns.get(1);
    }

    public JButton getExitBtn()
    {
        return mainMenuBtns.get(2);
    }

    private JPanel mainMenuPnl;
    private JLabel mainMenuLbl;
    private ArrayList<JButton> mainMenuBtns = new ArrayList<>();
}
