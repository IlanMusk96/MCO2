import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VendingMachineController extends JFrame{

    MainMenuView mainMenu = new MainMenuView();
    CreateVCMenu createVCMenu = new CreateVCMenu();
    TMMenu tmMenu = new TMMenu();
    CardLayout cl = new CardLayout();
    JPanel contPnl = new JPanel(cl);
    public VendingMachineController()
    {


        setTitle("Vending Machine");
        setSize(900, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        contPnl.setLayout(cl);
        contPnl.setPreferredSize(new Dimension(900, 750));
        add(contPnl);
        contPnl.add("mainMenu", mainMenu);
        contPnl.add("createVCMenu", createVCMenu);
        contPnl.add("tmMenu", tmMenu);


        cl.show(contPnl, "mainMenu");
        contPnl.setVisible(true);


        mainMenu.getCreateBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(contPnl, "createVCMenu");
            }
        });

        mainMenu.getTMBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(contPnl, "tmMenu");
            }
        });

        mainMenu.getExitBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                System.exit(0);
            }
        });


    }
    private VendingMachine vc;
}
