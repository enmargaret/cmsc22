/*
* Modified by enmargaret, JezaMarts, && noahdominic;
*/

import java.util.Random;

public abstract class RPGCharacter {

    protected String name;
    protected int hp;
	private Random rand = new Random();

    public RPGCharacter(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public abstract int attack();

    public boolean isAlive() {
        return hp > 0 ? true : false;
    }

	public int takeDamage(int damage) {
        hp -= damage;
        return hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
	
	public int randInt(int min, int max) {
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    @Override
    public String toString() {
        return "RPGCharacter{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                '}';
    }
}