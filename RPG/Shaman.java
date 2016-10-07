/*
* Created by enmargaret, JezaMarts, && noahdominic;
*/

public class Shaman extends Hero{
	public static final int hpMax = 80;
	public static final int mpMax = 150;
	public static final int BASE_ATTACK = 8;
	private boolean potion = true;

	public Shaman(String name){
		super(name, hpMax, mpMax,0);
	}

	public int takeDamage(int damage){
		damage-=armor;
		return super.takeDamage(damage);
	}
	
	public void regenMp(){
        mp += 5;
        if(mp > mpMax)
            mp = mpMax;
    }

	public boolean usePotion(){
		if(potion && hp<=20){
			setHp(80);
			potion = false;
			return true;
		}
		else
			return false;
	}
	
	public boolean getPotion(){
		return potion;
	}

	public int attack(){
		return BASE_ATTACK + randInt(1,3);
	}

	public int heal(){
		if(mp<20){
			return -1;
		}
		
		decreaseMp(20);
		int hpSet=randInt(20,30);
		if(hp+hpSet>80)
			setHp(80);
		else
			setHp(hp+hpSet);
		
		return 0;
	}

	public int burn(Monster a){
		if(mp<40){
			return -1;
		}
		
		a.setCondition(1);
		decreaseMp(40);
		return  10;
	}

	public int freeze(Monster a){
		if(mp<20){
			return -1;
		}
		
		a.setCondition(4);
		decreaseMp(20);	
		return 0;
	}

	public int callAttack(int type, Monster a){
		if(type == 1){
			return attack();
		}
		else if(type == 2){
			return heal();
		}
		else if(type == 3){
			return burn(a);
		}
		else{
			return freeze(a);
		}
	}
	
	public void skillList(){
		System.out.printf("\n1. Thwack - Preserving their magic, Shamans will strike their enemy with their staff. This takes <8 to 12 HP> from the\nfoe.\n");
		System.out.printf("\n2. Heal - The Shaman is graced by a blissful wind from the spirits and recovers <20 to 30 HP>. <20 MP> is needed to\nperform this.\n");
		System.out.printf("\n3. Combustion - A burning spell is cast upon the opponent, taking <10 HP> and leaving it burned. If the opponent is\nfrozen, the ice thaws.\n");
		System.out.printf("\n4. Frostbite - A freezing spell is cast upon the opponent, leaving it unable to move for 2 turns. <20 MP> is needed to\nperform this.\n");
	}
	
	public String toString() {
		return String.format("Shaman %s:\tHealth Points: %d\tMana Points: %d\tArmor: 0\n",name,hp,mp);
	}
}