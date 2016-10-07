/*
* Modified by enmargaret, JezaMarts, && noahdominic;
*/

public class Monster extends RPGCharacter{
    private int attackDamage;
	private int isCondition = 0;
	private int count = 0;
	
	/* isCondition: 0 = normal
	* 1 = Burn
	* 2 = Poison
	* 3 = Stun
	* 4 = Freeze
	*/
	
    public Monster(String name, int hp, int attackDamage) {
        super(name, hp);
        this.attackDamage = attackDamage;
    }

	public void setCondition(int status){ //this is called in the hero subclass when using burn etc.;
		isCondition = status;
		if(status==4){
			count = 1;
		}
		else if(status == 0){
			count = 0;
		}
		else{
			count = 2;
		}
	}
	
	public int getCondition(){
		return isCondition;
	}
	
	public int getCount(){
		return count;
	}
	
	public void condDamage(){ //this is called in monsterTurn to check the condition of the monster;
		if(isCondition == 1){
			hp-=10;
		}
		else if(isCondition == 2){
			hp-=randInt(5,8);
		}
		else if(isCondition == 3){
		}
		else if(isCondition == 4){
		}
		count--;
		if(count == 0){
			setCondition(0);
		}
	}
	
    public int attack() {
        return attackDamage;
    }

	public String toString() {
		return String.format("%s:\tHealth Points: %d\tDamage: %d\n",name,hp,attackDamage);
	}
}