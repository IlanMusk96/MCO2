import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {
    static Scanner sc = new Scanner(System.in);

    public static void displayDenominations(ArrayList<VendingMachine> vcs, int amt)
    {
        int i = 1;
        for (Money m : vcs.get(amt).getMoney())
        {
            System.out.println(i + ". ₱" + m.getValue());
            i++;
        }
    }
    public static void testingMenu(ArrayList<VendingMachine> vcs, int amt)
    {
        int choice, choice2, slotNum, i, x, payment;

        do {
            choice = 0;
            choice2 = 0;
            slotNum = 0;
            i = 0 ;
            x = 0;
            payment = 0;
            System.out.println("Testing Menu\n");
            System.out.println("1. Buy item");
            System.out.println("2. Produce change");
            System.out.println("3. Exit");

            do {
                try {
                    System.out.print("\nEnter Choice: ");
                    choice = sc.nextInt();
                    x = 1;
                }

                catch (Exception e)
                {
                    sc.nextLine();
                    System.out.println("Please enter an integer between 1 and 3");
                }
            }while (x==0);

            x = 0;
            switch (choice)
            {
                case 1:
                    System.out.println(vcs.get(amt).getVcType() + " slots: \n");
                    vcs.get(amt).displaySlots();

                    do {
                        try {
                            System.out.print("\nChoose which slot to buy from: ");
                            slotNum = sc.nextInt();
                            x = 1;
                        }

                        catch (Exception e)
                        {
                            sc.nextLine();
                            System.out.println("Please enter an integer between 1 and " + vcs.get(amt).getCurrentItemAmt());
                        }
                    }while (x == 0);
                    x=0;
                    displayDenominations(vcs, amt);

                    do {
                        try {
                            System.out.print("Choose which denomination to pay with: ");
                            payment = sc.nextInt();
                            x = 1;
                        }

                        catch (Exception e)
                        {
                            sc.nextLine();
                            System.out.println("Please choose an integer between 1 and " + vcs.get(amt).getMoney().size());
                        }
                    }while (x==0);

                    vcs.get(amt).dispenseItem(slotNum, vcs.get(amt).getMoney().get(payment - 1).getValue());

                    break;

                case 2:
                    displayDenominations(vcs, amt);
                    try {
                        System.out.print("Choose which denomination to get change from: ");
                        choice2 = sc.nextInt();
                    }

                    catch (Exception e)
                    {
                        sc.nextLine();
                        System.out.println("Please input an integer between 1 and " + vcs.get(amt).getMoney().size());
                    }

                    vcs.get(amt).receiveMoney(vcs.get(amt).getMoney().get(choice2 - 1).getValue());
                    vcs.get(amt).giveChange(vcs.get(amt).getMoney().get(choice2 - 1).getValue());
                    break;


            }
        }while (choice != 3);
    }

    public static void maintenanceMenu(ArrayList<VendingMachine> vcs, int amt)
    {
        int choice, moneyAmt;
        do {
            choice = -1;
            int slotNum = 0, price = 0, x = 0;
            double calories = 0;
            String name;
            System.out.println("\nMoney in Machine: ");
            vcs.get(amt).displayMoney();
            System.out.println("\nMaintenance Menu\n");

            System.out.println("1. Add item");
            System.out.println("2. Restock items");
            System.out.println("3. Restock one item");
            System.out.println("4. Change stock");
            System.out.println("5. Take money");
            System.out.println("6. Add money");
            System.out.println("7. Check starting inventory");
            System.out.println("8. Check current inventory");
            System.out.println("9. Check Transaction History");
            System.out.println("0. Exit\n");

            try {
                System.out.print("Enter choice: ");
                choice = sc.nextInt();
                x = 1;
            }

            catch (Exception e)
            {
                sc.nextLine();
                System.out.println("Please input an integer between 1 and 9 or 0");
            }

            switch (choice)
            {
                case 2:
                    vcs.get(amt).restockAll();
                    System.out.println("Items restocked successfully");
                    break;

                case 3:
                    vcs.get(amt).displayCurrentInventory();
                    System.out.print("Please choose which slot to restock: ");
                    vcs.get(amt).restockItem(sc.nextInt());
                    System.out.println("Slot restocked successfully");
                    break;

                case 5:
                    vcs.get(amt).takeVCMoney();
                    System.out.println("Money has been taken successfully");
                    break;

                case 6:
                    int choice3 = 0;
                    moneyAmt = 0;
                    vcs.get(amt).displayMoney();

                    do {
                        try {
                            System.out.println("Choose which denomination to add to: ");
                            choice3 = sc.nextInt();
                            x = 1;
                        }

                        catch (Exception e)
                        {
                            sc.nextLine();
                            System.out.println("Please choose an integer between 1 and " + vcs.get(amt).getMoney().size());
                        }
                    }while (x==0);

                    x = 0;
                    do {
                        try {
                            System.out.println("Choose how much to add: ");
                            moneyAmt = sc.nextInt();
                            x = 1;
                        }

                        catch (Exception e)
                        {
                            sc.nextLine();
                            System.out.println("Please choose an integer");
                        }
                    }while (x == 0);

                    vcs.get(amt).addVCMoney(moneyAmt, choice3);
                    System.out.println("Money added successfully");
                    break;

                case 7:
                    vcs.get(amt).displayStartingInventory();
                    break;

                case 8:
                    vcs.get(amt).displayCurrentInventory();
                    break;

                case 9:
                    vcs.get(amt).displayTransactionHistory();
                    break;

                case 0:
                    break;
            }
        }while (choice != 0);



    }

    public static void main(String[] args) {
        int choice;
        int vcAmt = 0;
        int x = 0;
        ArrayList<VendingMachine> vcs = new ArrayList<>();


        do {
            choice = 0;
            System.out.println("Vending Machine Simulation");
            System.out.println("\n1. Create Vending Machine");
            System.out.println("2. Test and Maintain Vending Machine");
            System.out.println("3. Exit");
            do {
                try {
                    System.out.print("\nEnter Choice: ");
                    choice = sc.nextInt();
                }

                catch (Exception e)
                {
                    sc.nextLine();
                    System.out.println("Please enter an integer between 1 and 3");
                }
            }while (choice < 1 || choice > 3);

            switch (choice) {
                case 1:
                    vcs.add(new VendingMachine());
                    vcAmt++;

                    System.out.println("Vending Machine created successfully.");
                    break;

                case 2:
                    if(vcAmt > 0) {
                        int choice2 = 0;
                        do {
                            System.out.println("Testing and Maintenance of " + vcs.get(vcAmt - 1).getVcType());

                            System.out.println("\n1. Test Vending Machine");
                            System.out.println("2. Maintain Vending Machine");
                            System.out.println("3. Exit");


                            do {
                                try {
                                    System.out.print("\nEnter Choice: ");
                                    choice2 = sc.nextInt();
                                }

                                catch (Exception e)
                                {
                                    sc.nextLine();
                                    System.out.println("Please enter an integer between 1 and 2");
                                }
                            }while (choice2 < 1||choice2 > 3);

                            switch (choice2) {
                                case 1:
                                    if (vcs.get(vcAmt-1).getCurrentItemAmt() > 0)
                                        testingMenu(vcs, vcAmt - 1);
                                    else
                                        System.out.println("Vending machine has no items");
                                    break;

                                case 2:
                                    maintenanceMenu(vcs, vcAmt - 1);
                                    break;

                                case 3:
                                    break;
                            }
                        } while (choice2 != 3);
                    }

                    else
                        System.out.println("Please create a vending machine first");
                    break;

                case 3:
                    break;
            }
        }while(choice != 3);

        sc.close();
        System.exit(0);
    }
}
