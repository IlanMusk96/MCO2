//import javax.swing.*;
//import java.awt.*;
//import java.util.ArrayList;
//
//public class VendingMachineView {
//    public VendingMachineView()
//    {
//        frame = new JFrame("Vending Machine");
//        frame.setSize(900, 750);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        contPnl = new JPanel(new CardLayout());
//
//        mainMenuPnl = new JPanel(new BorderLayout());
//        mainMenuLbl = new JLabel("Main Menu");
//        mainMenuPnl.add(mainMenuLbl, BorderLayout.NORTH);
//        mainMenuLbl.setPreferredSize(new Dimension(500, 100));
//        mainMenuLbl.setHorizontalAlignment(SwingConstants.CENTER);
//        JPanel mainMenuBtnPnl = new JPanel(new FlowLayout());
//        mainMenuBtns.add(new JButton("Create Vending Machine"));
//        mainMenuBtns.get(0).setPreferredSize(new Dimension(500, 50));
//        mainMenuBtns.add(new JButton("Test and Maintain Vending Machine"));
//        mainMenuBtns.get(1).setPreferredSize(new Dimension(500, 50));
//        mainMenuBtns.add(new JButton("Exit"));
//        mainMenuBtns.get(2).setPreferredSize(new Dimension(500, 50));
//        mainMenuBtnPnl.add(mainMenuBtns.get(0));
//        mainMenuBtnPnl.add(mainMenuBtns.get(1));
//        mainMenuBtnPnl.add(mainMenuBtns.get(2));
//        mainMenuPnl.add(mainMenuBtnPnl, BorderLayout.CENTER);
//
//        JLabel createVCMenuLbl = new JLabel("Create Vending Machine");
//        createVCMenuPnl = new JPanel(new BorderLayout());
//        createVCMenuPnl.add(createVCMenuLbl, BorderLayout.NORTH);
//        createVCMenuLbl.setPreferredSize(new Dimension(500, 100));
//        createVCMenuLbl.setHorizontalAlignment(SwingConstants.CENTER);
//        createVCMenuBtns = new ArrayList<>();
//        createVCMenuBtns.add(new JButton("Create Regular Vending Machine"));
//        createVCMenuBtns.get(0).setPreferredSize(new Dimension(500, 50));
//        createVCMenuBtns.add(new JButton("Create Special Vending Machine"));
//        createVCMenuBtns.get(1).setPreferredSize(new Dimension(500, 50));
//        JPanel createVCMenuPnlBtns = new JPanel(new FlowLayout());
//        createVCMenuPnlBtns.add(createVCMenuBtns.get(0));
//        createVCMenuPnlBtns.add(createVCMenuBtns.get(1));
//        createVCMenuPnl.add(createVCMenuPnlBtns);
//
//        tMMenuPnl = new JPanel(new BorderLayout());
//        JLabel tMMenuLbl = new JLabel("Test and Maintain Vending Machine");
//        JPanel tMMenuBtnPnl = new JPanel(new FlowLayout());
//        tMMenuBtns = new ArrayList<>();
//        tMMenuBtns.add(new JButton("Test Vending Machine"));
//        tMMenuBtns.get(0).setPreferredSize(new Dimension(500, 50));
//        tMMenuBtns.add(new JButton("Maintain Vending Machine"));
//        tMMenuBtns.get(1).setPreferredSize(new Dimension(500, 50));
//        tMMenuBtns.add(new JButton("Exit"));
//        tMMenuBtns.get(2).setPreferredSize(new Dimension(500, 50));
//        tMMenuBtnPnl.add(tMMenuBtns.get(0));
//        tMMenuBtnPnl.add(tMMenuBtns.get(1));
//        tMMenuBtnPnl.add(tMMenuBtns.get(2));
//        tMMenuPnl.add(tMMenuLbl, BorderLayout.NORTH);
//        tMMenuLbl.setHorizontalAlignment(SwingConstants.CENTER);
//        tMMenuLbl.setPreferredSize(new Dimension(500, 100));
//        tMMenuPnl.add(tMMenuBtnPnl, BorderLayout.CENTER);
//
        vmTestingMenu = new JPanel(new BorderLayout());
        JLabel vmTestingMenuLbl = new JLabel("Vending Machine");
        vmTestingMenuLbl.setPreferredSize(new Dimension(0, 100));
        vmTestingMenuLbl.setHorizontalAlignment(SwingConstants.CENTER);
        vmTestingMenu.add(vmTestingMenuLbl, BorderLayout.NORTH);
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
        vmTestingMenu.add(vmTestingMenuItemBtnsPnl, BorderLayout.WEST);
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
        vmTestingMenu.add(vmTestingDenomBtnPnl, BorderLayout.SOUTH);
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

        vmTestingMenu.add(vmTestingCheckoutPnl, BorderLayout.EAST);
//
//
//
//
//
//
//
//        frame.add(vmTestingMenu);
//
//
//
//        frame.setVisible(true);
//    }
//
//    private JFrame frame;
//    private JPanel contPnl, mainMenuPnl, createVCMenuPnl, tMMenuPnl, vmTestingMenu;
//    private JLabel mainMenuLbl;
//    private ArrayList<JButton> mainMenuBtns = new ArrayList<>();
//    private ArrayList<JButton> createVCMenuBtns;
//    private ArrayList<JButton> tMMenuBtns;
//    private ArrayList<JButton> vmTestingMenuItemBtns;
//    private ArrayList<JButton> vmTestingMenuDenomBtns;
//    private JTextArea checkoutArea;
//    private ArrayList<JButton> vmTestingCheckoutBtns;

//}
