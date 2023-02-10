import chars.Base;
import chars.HeroTeam;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        HeroTeam.Init();

        Scanner scanner = new Scanner(System.in);

        while (true){
            ConsoleView.view();
            System.out.println("Press ENTER");
            scanner.nextLine();
            gameStep();
            if(HeroTeam.deadTeam(HeroTeam.monkTeam) || HeroTeam.deadTeam(HeroTeam.wizardTeam))
            {
                ConsoleView.view();
                System.out.println("End");
                break;
            }
        }

    }

    public static void gameStep()
    {
        for (int i = 0; i < HeroTeam.GANG_SIZE; i++) {
            if(HeroTeam.monkTeam.get(i).getName().equals("Xbowman") ||
                    HeroTeam.monkTeam.get(i).getName().equals("Spearman"))
                HeroTeam.monkTeam.get(i).Step(HeroTeam.wizardTeam);
            if(HeroTeam.wizardTeam.get(i).getName().equals("Sniper") ||
                    HeroTeam.wizardTeam.get(i).getName().equals("Robber"))
                HeroTeam.wizardTeam.get(i).Step(HeroTeam.monkTeam);
        }

        for (int i = 0; i < HeroTeam.GANG_SIZE; i++) {
            if(HeroTeam.monkTeam.get(i).getName().equals("Monk"))
                HeroTeam.monkTeam.get(i).Step(HeroTeam.wizardTeam);
            if(HeroTeam.wizardTeam.get(i).getName().equals("Wizard"))
                HeroTeam.wizardTeam.get(i).Step(HeroTeam.monkTeam);
        }

        for (int i = 0; i < HeroTeam.GANG_SIZE; i++) {
            if(HeroTeam.monkTeam.get(i).getName().equals("Peasant"))
                HeroTeam.monkTeam.get(i).Step(HeroTeam.wizardTeam);
            if(HeroTeam.wizardTeam.get(i).getName().equals("Peasant"))
                HeroTeam.wizardTeam.get(i).Step(HeroTeam.monkTeam);
        }
    }
}
