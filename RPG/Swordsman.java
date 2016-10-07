public class Swordsman extends Hero{

    //base attack
    private static final int BASE_ATTACK = 20;
    // full hp
    private static final int FULL_HP = 100;
    // full mana
    private static final int FULL_MP = 40;
    // if berserk skill is used,swordsman cannot move for one trurn
    private boolean isTired;
    private boolean canUsePotion;


    public Swordsman(String name) {
        super(name, FULL_HP, FULL_MP, 10);
        isTired = false;
        canUsePotion = true;
    }

    public int attack(){
        // base attack damage ranges from 20 to 25 because why not
        if(isTired == true){
            System.out.println("\n>> Swordsman " + name + " is tired. He didn't move. <<");
            isTired = false;
            return 0;
        } else {
            return BASE_ATTACK + randInt(0,5);
        }
    }

    public int berserk(){
        if(mp<20){
			return -1;
		}
		
		if(isTired == true) {
            System.out.println("Swordsman " + name + " is tired. He didn't move.");
            isTired = false;
            return 0;
        } else { 
            decreaseMp(20);
            isTired = true;
            return (BASE_ATTACK + randInt(0,5))*3;
        }
    }

    public int stun(Monster a){
        if(mp<25){
			return -1;
		}
		
		if(isTired == true) {
            System.out.println("Swordsman " + name + " is tired. He didn't move.");
            isTired = false;
            return 0;
        } else {
            decreaseMp(25);
                a.setCondition(3);
            return BASE_ATTACK + randInt(0,5);
        }
    }

    public int luckyBlow(Monster a){
		if(mp<40){
			return -1;
		}
        if(isTired == true) {
            System.out.println("Swordsman " + name + " is tired. He didn't move.");
            isTired = false;
            return 0;
        } else {
			if(randInt(1,5) == 5) {
				decreaseMp(40);
				return a.getHp();
			}
			else {
				System.out.println("The Lucky Blow missed!");
				return 0;
			}
            
        }
    }

    public int takeDamage(int damage) {
		if(damage<armor){
			return super.takeDamage(0);
		}
        damage -= armor;
        return super.takeDamage(damage);
    }

    public int callAttack(int type, Monster mon){
        if(type == 1){
            return attack();
        } else if (type == 2) {
            return berserk();
        } else if (type == 3) {
            return stun(mon);
        } else if (type == 4) {
            return luckyBlow(mon);
        }
		return 0;
    }

    public void regenMp(){
        mp += 5;
        if(mp > FULL_MP)
            mp = FULL_MP;
    }

    public boolean usePotion(){
        if (canUsePotion == true && hp<=25){
            hp = FULL_HP;        
            canUsePotion = false;
            return true;
        } else {
            return false;
        }
    }
	
	public boolean getPotion(){
		return canUsePotion;
	}
	
	public void skillList(){
		System.out.printf("\n1. Slash - The Swordsman lashes out on the opponent with a sword. This takes <20 to 25 HP> from the foe.\n");
		System.out.printf("\n2. Berserk - Filled with rage, the Swordsman strikes it opponent with everything it has. This takes <60 to 75 HP> from\nthe opponent. <20 MP> is needed to perform this and the Swordsman will not be able to move the next turn.\n");
		System.out.printf("\n3. Shockwave - The Swordsman slashes its sword faster than sound and takes <20 to 25 HP> from the opponent, paralyzing\nit. <25 MP> is needed to perform this.\n");
		System.out.printf("\n4. Lucky Blow - The foe is struck directly at its critical points, causing it to die immediately. There is a 20 percent chance for success. <40 MP> is needed to perform this.\n");
	}
	
	public String toString() {
		return String.format("Swordsman %s:\tHealth Points: %d\tMana Points: %d\t\tArmor: 10\n",name,hp,mp);
	}
}