/*
* Modified by enmargaret, JezaMarts, && noahdominic;
*/

public abstract class Hero extends RPGCharacter {
    private int level;
	protected int mp;
	protected int armor;

    public Hero(String name, int hp, int mp, int armor) {
        super(name, hp);
        this.mp = mp;
		this.armor = armor;
    }

    public int getLevel() {
        return level;
    }

    public void levelUp() {
        this.level += 1;
    }

	public void decreaseMp(int mpMin){
		mp-=mpMin;
	}
	
	public void dodge(int damage){
		int chance = randInt(1,5);
		if(chance==1){
			hp = takeDamage(damage/2);
			System.out.printf("\n<< Only half of the damage was inflicted to %s! -%d HP! >>\n",name,damage/2);
		}
		else if (chance == 2){
			System.out.printf("\n<< %s has managed to fully evade the monster's attack! No damage taken! >>\n",name);
			hp = takeDamage(0);
		}
		else{
			System.out.printf("\n<< %s has been hit by the monster's attack! -%d HP! >>\n",name,damage);
			hp = takeDamage(damage);
		}
	}
	public abstract boolean usePotion();
	public abstract int callAttack(int type, Monster mon);
	public abstract boolean getPotion();	
	public abstract void skillList();
	public abstract void regenMp();
}