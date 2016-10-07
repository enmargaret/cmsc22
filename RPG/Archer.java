/*
* Created by enmargaret, JezaMarts, && noahdominic;
*/

public class Archer extends Hero{
	
	private static final int hpMax = 80;
	private static final int mpMax = 100;
	private static final int BASE_ATTACK = 16;
	private boolean potion = true;
	private int arrow = 100;

    public Archer(String name) {
        super(name, hpMax, mpMax, 5);
    }

    public int takeDamage(int damage) {
		if(damage<armor){
			return super.takeDamage(0);
		}
        damage -= armor;
        return super.takeDamage(damage);
    }
	
	public void regenMp(){
        mp += 5;
        if(mp > mpMax)
            mp = mpMax;
    }
	
	public boolean usePotion(){
		if(potion && hp <= 20){
			setHp(hpMax);
			potion = false;
			return true;
		}
		return false;
	}
	
	public boolean getPotion(){
		return potion;
	}
	
	public int attack(){
		//default damage for archer ranges from 16 - 20;
		arrow-=2;
		return BASE_ATTACK + randInt(0,4);
	}
	
	public int rapidFire(){
		arrow-=5;
		int arrowAmt = randInt(4,5);
		int dmg = 0;
		for(;arrowAmt>0;arrowAmt--){
			dmg += randInt(8,10);
		}
		return dmg;
	}
	
	public int radiantArrow(Monster mon){
		if(mp<10){
			return -1;
		}
		
		arrow-=2;
		decreaseMp(10);
		int dmg = 0, arrowAmt = 0, chance = randInt(1,2);
		if(chance == 1){
			for(;arrowAmt<2;arrowAmt++){
				dmg += randInt(13,15);
			}
		}
		return dmg;
	}
	
	public int cripplingShot(Monster mon){
		if(mp<50){
			return -1;
		}
		
		decreaseMp(50);
		arrow-=2;
		mon.setCondition(3);
		int dmg = 0, arrowAmt = 0;
		for(;arrowAmt<2;arrowAmt++){
			dmg += randInt(13,15);
		}
		return dmg;
	}
	
	public int callAttack(int type, Monster mon){
		int damage = 0;
		if(type == 1){
			damage = attack();
		}
		else if(type == 2){
			damage = rapidFire();
		}
		else if(type == 3){
			damage = radiantArrow(mon);
		}
		else if(type == 4){
			damage = cripplingShot(mon);
		}
		return damage;
	}	
	
	public void skillList(){
		System.out.printf("\n1. Strike - 2 consecutive arrows are fired and <16 to 20 HP> is taken from the opponent.\n");
		System.out.printf("\n2. Rapid Fire - 5 consecutive arrows are fired. Each arrow can take <8 to 10 HP>.\n");
		System.out.printf("\n3. Radiant Arrow - 2 consecutive arrows are fired. Each arrow can take <13 to 15 HP>. This has a 50 percent chance of\nsuccess and costs <10 MP> when used.\n");
		System.out.printf("\n4. Crippling Shot - 2 arrows are shot to the opponent, paralyzing it. This takes <13 to 15 HP> each arrow, and will need <50 MP> to perform.\n");
	}
	
	public String toString() {
		return String.format("Archer %s:\tHealth Points: %d\tMana Points: %d\tArmor: 5\tArrows left: %d\n",name,hp,mp,arrow);
	}
}