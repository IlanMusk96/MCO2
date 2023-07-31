import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VMTestMenu extends JPanel {

    public VMTestMenu()
    {
        setLayout(new BorderLayout());
        JLabel vmTestingMenuLbl = new JLabel("Vending Machine");
        vmTestingMenuLbl.setPreferredSize(new Dimension(0, 100));
        vmTestingMenuLbl.setHorizontalAlignment(SwingConstants.CENTER);
        add(vmTestingMenuLbl, BorderLayout.NORTH);
        JPanel vmTestingMenuItemBtnsPnl = new JPanel();
        vmTestingMenuItemBtnsPnl.setLayout(new BoxLayout(vmTestingMenuItemBtnsPnl, BoxLayout.LINE_AXIS));
        vmTestingMenuItemBtns = new ArrayList<>();
        vmTestingMenuItemBtns.add(new JButton("Rice"));
        vmTestingMenuItemBtns.add(new JButton("Egg"));
        vmTestingMenuItemBtns.add(new JButton("Tocino"));
        vmTestingMenuItemBtns.add(new JButton("Tapa"));
        vmTestingMenuItemBtns.add(new JButton("Longanissa"));
        vmTestingMenuItemBtns.add(new JButton("Bacon"));
        vmTestingMenuItemBtns.add(new JButton("Tomato Slice"));
        vmTestingMenuItemBtns.add(new JButton("Cucumber Slice"));
        vmTestingMenuItemBtnsPnl.add(vmTestingMenuItemBtns.get(0));
        vmTestingMenuItemBtnsPnl.add(vmTestingMenuItemBtns.get(1));
        vmTestingMenuItemBtnsPnl.add(vmTestingMenuItemBtns.get(2));
        vmTestingMenuItemBtnsPnl.add(vmTestingMenuItemBtns.get(3));
        vmTestingMenuItemBtnsPnl.add(vmTestingMenuItemBtns.get(4));
        vmTestingMenuItemBtnsPnl.add(vmTestingMenuItemBtns.get(5));
        vmTestingMenuItemBtnsPnl.add(vmTestingMenuItemBtns.get(6));
        vmTestingMenuItemBtnsPnl.add(vmTestingMenuItemBtns.get(7));
        add(vmTestingMenuItemBtnsPnl, BorderLayout.WEST);
        vmTestingMenuItemBtnsPnl.setPreferredSize(new Dimension(500, 200));
        JPanel vmTestingDenomBtnPnl = new JPanel(new GridLayout(1, 8));
        vmTestingMenuDenomBtns = new ArrayList<>();
        vmTestingMenuDenomBtns.add(new JButton("PHP 1"));
        vmTestingMenuDenomBtns.add(new JButton("PHP 5"));
        vmTestingMenuDenomBtns.add(new JButton("PHP 10"));
        vmTestingMenuDenomBtns.add(new JButton("PHP 20"));
        vmTestingMenuDenomBtns.add(new JButton("PHP 50"));
        vmTestingMenuDenomBtns.add(new JButton("PHP 100"));
        vmTestingMenuDenomBtns.add(new JButton("PHP 500"));
        vmTestingMenuDenomBtns.add(new JButton("PHP 10000"));
        vmTestingDenomBtnPnl.add(vmTestingMenuDenomBtns.get(0));
        vmTestingDenomBtnPnl.add(vmTestingMenuDenomBtns.get(1));
        vmTestingDenomBtnPnl.add(vmTestingMenuDenomBtns.get(2));
        vmTestingDenomBtnPnl.add(vmTestingMenuDenomBtns.get(3));
        vmTestingDenomBtnPnl.add(vmTestingMenuDenomBtns.get(4));
        vmTestingDenomBtnPnl.add(vmTestingMenuDenomBtns.get(5));
        vmTestingDenomBtnPnl.add(vmTestingMenuDenomBtns.get(6));
        vmTestingDenomBtnPnl.add(vmTestingMenuDenomBtns.get(7));
        add(vmTestingDenomBtnPnl, BorderLayout.SOUTH);
        JPanel vmTestingCheckoutPnl = new JPanel(new FlowLayout());
        checkoutArea = new JTextArea("Checkout: ");
        checkoutArea.setPreferredSize(new Dimension(200, 300));
        vmTestingCheckoutPnl.add(checkoutArea);
        vmTestingCheckoutBtns = new ArrayList<>();
        vmTestingCheckoutBtns.add(new JButton("Buy"));
        vmTestingCheckoutBtns.get(0).setPreferredSize(new Dimension(100, 50));
        vmTestingCheckoutBtns.add(new JButton("Exit"));
        vmTestingCheckoutBtns.get(1).setPreferredSize(new Dimension(100, 50));
        vmTestingCheckoutPnl.setPreferredSize(new Dimension(300, 500));
        vmTestingCheckoutPnl.add(vmTestingCheckoutBtns.get(0));
        vmTestingCheckoutPnl.add(vmTestingCheckoutBtns.get(1));

        add(vmTestingCheckoutPnl, BorderLayout.EAST);
    }

    private ArrayList<JButton> vmTestingMenuItemBtns;
    private ArrayList<JButton> vmTestingMenuDenomBtns;
    private ArrayList<JButton> vmTestingCheckoutBtns;
    private JTextArea checkoutArea;
}
