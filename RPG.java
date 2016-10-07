import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.*;

/*
* Modified by enmargaret, JezaMarts, && noahdominic;
*/

public class RPG{
    private Random rand;
    public RPG() {
        this.rand = new Random();
    }

    public String getRandomMonsterName() {
        String[] monsters = {"the Nightmare from the Legendary Abyss","the Creature from the Mysterious Grotto","the Juggernaut Consumed by Rage","the Monster from the Legendary Abbey","the Menace from the Enchanted Pit","the Livestock-Torturing Creature","the Abomination from the Enchanted Labyrinth"};
        String[] adjectives = {"Nigell", "Loewe", "Chaelle", "Mike", "Lily","Jace","Alexis"};
        List<String> adjs = Arrays.asList(adjectives);
        List<String> mons = Arrays.asList(monsters);
        return adjs.get(randInt(0, adjs.size() - 1)) + " " + mons.get(randInt(0, mons.size() - 1));
    }

    public int randInt(int min, int max) {
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
	
	public boolean heroIsDead(Hero he){
		if(he.getHp()<=0){
			System.out.println(he.getName() + " is DEAD.");
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean monsterIsDead(Monster mon){
		if(mon.getHp()<=0){
			System.out.println("\n==> "+ mon.getName() + " is DEAD. <==\n");
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean heroTurn(Hero he, Monster mon){
		Scanner in = new Scanner(System.in);
		int damage = -1;
		int flag = 1;
		
		while(flag == 1){
			System.out.println(he);
			System.out.println("VS\n");
			System.out.println(mon);
			System.out.printf("\n1. Attack\n\n2. Use Potion - Can only be used once and only when HP is less than 25 percent.\n\nWhat will %s do? ",he.getName());
			int action = in.nextInt();
			if(action == 1){
				while(damage<0){
					int type = 0;
					while(type < 1 || type > 4){
						he.skillList();
						System.out.printf("\nChoose an attack. <Make sure you have enough Mana>: ");
						type = in.nextInt();
					}
					damage = he.callAttack(type,mon);
				}
				mon.setHp(mon.takeDamage(damage));
				if(damage==0){
					System.out.printf("\n<< %s didn't inflict damage! >>\n",he.getName());
				}
				else{
					System.out.printf("\n<< %s has been hit! -%d HP! >>\n",mon.getName(),damage);
				}
				flag = 0;
			}
			else if(action == 2){
				if(he.usePotion() == false){
					action = 1;
					flag = 1;
				}
				else{
					he.usePotion();
				}
			}
			else{
				flag = 1;
			}
			he.regenMp();
		}
		return monsterIsDead(mon);
	}
	
	public void monsterStatus(Monster mon){
		if(mon.getCondition() == 1){
			System.out.printf("\n<< %s is burning! -10 HP! >>\n",mon.getName());
		}
		else if(mon.getCondition() == 2){
			System.out.printf("\n<< %s is poisoned! Damage has been inflicted! >>\n",mon.getName());
		}
		else if(mon.getCondition() == 3){
			System.out.printf("\n<< %s is stunned! >>\n",mon.getName());
		}
		else if(mon.getCondition() == 4){
			System.out.printf("\n<< %s is frozen! >>\n",mon.getName());
		}
	}
	
	public boolean monsterTurn(Monster mon, Hero he){
		int damage = 0;
		System.out.println(he);
		System.out.println("VS\n");
		System.out.println(mon);
		if(mon.getCondition()>0){
			monsterStatus(mon);
			mon.condDamage();
			if(mon.getCondition() > 2){
				return false;
			}
		}
		he.dodge(mon.attack());
		return heroIsDead(he);
	}
	
	public void classDisplay(){
		clearScreen();
		System.out.printf("Hero classes:\n1. Swordsman\n\t- Armed with a sword forged from the same steel as King Alexander's, Swordsmen have their strength as their\n\tgreatest advantage. Their weapons allow them to be as agressive as they want as long as it is for the defeat\n\tof the enemy.\n\n");
		System.out.printf("2. Shaman\n\t- Shamans have the power to call upon the spirits of Ancient Mexica and America for mystic guidance. While\n\tShamans prefer to heal the wounded, the Opening of the Gates of Hell forced them to use their magic only for\n\thealing themselves and fighting the primordial monsters.\n\n");
		System.out.printf("3. Archer\n\t- Archers are trained by the army of the Early Frankish Empire. They are excellent melee fighters, but they are\n\tlethal when they hide among the fortress with their bow and arrows. Although they have a limited number of\n\tarrows, all of them are not wasted as they always hit the target.\n\n");
		System.out.printf("4. Thief\n\t- After years of training, stealing from the upper classes roaming the Victorian streets, Thieves have\n\tdeveloped a set of skills that are meant to deceive its enemy.\n\n");
		System.out.printf("\n\nChoose a class: ");
	}
	
	public static void clearScreen(){
         try {
              if (System.getProperty("os.name").contains("Windows"))
                  new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
              else
                  Runtime.getRuntime().exec("clear");
         } catch (IOException | InterruptedException ex) {}
    }

	
    public static void main(String[] args) {
		RPG rpg = new RPG();
		rpg.clearScreen();
		System.out.print("Welcome brave Adventurer. What awaits you is a dangerous quest.\nIf you wish to proceed, then please enter your name: ");
		Scanner in = new Scanner(System.in);
		String name = in.next();
		Hero hero = new Swordsman(name);
        Monster monster = new Monster(rpg.getRandomMonsterName(), rpg.randInt(1, 100), rpg.randInt(1, 100));
		int choice = 0;
		do{
			rpg.classDisplay();
			choice = in.nextInt();
			if(choice==1){
				hero = new Swordsman(name);
			}
			else if(choice == 2){
				hero = new Shaman(name);
			}
			else if(choice == 3){
				hero = new Archer(name);
			}
			else if(choice == 4){
				hero = new Thief(name);
			}
		}while(choice>4 || choice<1);
		rpg.sleep(1000);
		rpg.clearScreen();
        System.out.printf("\n====== GAME START! =====\n");

        int turn = 0, round = 1, hpmin = 40, hpmax = 60, atkmin = 5, atkmax = 7;
        while (round<4) {
			turn = 0;
			System.out.printf("\n====== ROUND %d! =====\n",round);
			monster = new Monster(rpg.getRandomMonsterName(), rpg.randInt(hpmin, hpmax), rpg.randInt(atkmin, atkmax)); 
			System.out.printf("\n===> %s vs LEVEL %d %s! <===\n", hero.getName(), round, monster.getName());
			rpg.sleep(1500);
			while(true){
				System.out.printf("\n== Turn %d ==\n",++turn);
				System.out.println("\n==> " + hero.getName() + "'s turn! <==\n");
				boolean monIsDead = rpg.heroTurn(hero,monster);
				if (monIsDead) break;
				rpg.sleep(2000);
				rpg.clearScreen();
				System.out.println("\n==> " + monster.getName() + "'s turn! <==\n");
				boolean heIsDead = rpg.monsterTurn(monster,hero);
				rpg.sleep(3000);
				if (heIsDead){ 
					round = 4;
					break;
				}
				rpg.clearScreen();
			}
			hpmin+=20; hpmax+=20; atkmin+=15; atkmax+=15;
			round++;
			rpg.sleep(1000);
			rpg.clearScreen();
        }
		if(monster.isAlive()){
			System.out.printf("\nGAME OVER.\n");
		}
		else{
			System.out.printf("\nCongratulations! %s has successfully defeated all monsters!\n",hero.getName());
		}
    }
}
