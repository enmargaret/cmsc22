public class Thief extends Hero{
	public static final int hpMax = 100;
	public static final int mpMax = 70;
	public static final int BASE_ATTACK = 8;
	private boolean potion = true;
	private int shadowWalk = 0;
	private int passDamage = 0;

	public Thief(String name){
		super(name, hpMax, mpMax,0);
	}

	public int takeDamage(int damage){//evasive bec of shadowwalk
		if(shadowWalk>0){
			shadowWalk--;
			passDamage=(damage/5)*2;
			System.out.println("Evasiveness has increased!");
			return super.takeDamage(passDamage);
		}
		else{
			return super.takeDamage(damage);
		}
	}

	public void regenMp(){
        mp += 5;
        if(mp > mpMax)
            mp = mpMax;
    }

	public boolean usePotion(){
		if(potion && hp<=25){
			setHp(100);
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
		return BASE_ATTACK + randInt(1,2);
	}

	public int venoshock(Monster a){
		if(mp<20){
			return -1;
		}
		
		a.setCondition(2);
		decreaseMp(20);
		return 5+randInt(1,3);
	}

	public int backstab(Monster a){//check sa main if first turn sa player
		if(mp<30){
			return -1;
		}
		
		decreaseMp(30);
		if(randInt(1,15) ==1){
			a.setHp(0);
			return 0;
		}		
		else{
			int attMinus = attack();
			return attMinus+(attMinus/2);
		}
	}

	public int ShadowWalk(){
		if(mp<20){
			return -1;
		}
		
		decreaseMp(20);
		shadowWalk=3;
		return 0;
	}

	public int callAttack(int type, Monster a){
		if(type == 1){
			if(randInt(1,5) == 2){
				return attack() + attack();
			}
			else {
				return attack() + attack() + attack();
			}
		}
		else if(type == 2){
			return venoshock(a);
		}
		else if(type == 3){
			return backstab(a);			
		}
		else if(type == 4){
			return ShadowWalk();
		}
		return 0;
	}

	public void skillList(){
		System.out.printf("\n1. Jab - The foe is punched abruptly, leaving it unable to react. This takes <8 to 10 HP> from the foe.\n");
		System.out.printf("\n2. Venoshock - The foe is struck with a blade seeped with venom. This will take <5 to 8 HP> from the foe and leave it\npoisoned for 3 turns. <20 MP> will be needed to perform this.\n");
		System.out.printf("\n3. Backstab - The target is diverted and stabbed in the back. If the move hits a weak spot, this instantly kills the\ntarget. If not, this will take <12 to 15 HP>. <30 MP> is needed to perform this.\n");
		System.out.printf("\n4. Shadow Walk - For 3 turns, the Thief will increase its evasiveness and will only receive 2/5 of damage from all\nattacks.\n");
	}
	
	public String toString() {
		return String.format("Thief %s:\tHealth Points: %d\tMana Points: %d\t\tArmor: 0\n",name,hp,mp);
	}
}