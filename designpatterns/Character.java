/*
*Created by enmargaret on 11/25/2016;
*/

import java.util.*;

public class Character{
	private WeaponBehavior weapon;
	
	public void setWeapon(WeaponBehavior w){
		this.weapon = w;
	}
	
	public Character(WeaponBehavior w){
		setWeapon(w);
	}
	
	public void fight(){
		weapon.useWeapon();
	}
}