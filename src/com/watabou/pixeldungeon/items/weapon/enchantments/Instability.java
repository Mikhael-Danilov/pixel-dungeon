/*
 * Pixel Dungeon
 * Copyright (C) 2012-2014  Oleg Dolya
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
package com.watabou.pixeldungeon.items.weapon.enchantments;

import com.watabou.noosa.Game;
import com.nyrds.pixeldungeon.ml.R;
import com.watabou.pixeldungeon.actors.Char;
import com.watabou.pixeldungeon.items.weapon.Weapon;
import com.watabou.pixeldungeon.items.weapon.Weapon.Enchantment;
import com.watabou.pixeldungeon.items.weapon.missiles.Boomerang;

public class Instability extends Weapon.Enchantment {

	private static final String TXT_NAME = Game.getVar(R.string.Instability_Name);
	
	@Override
	public boolean proc( Weapon weapon, Char attacker, Char defender, int damage ) {
		Enchantment ench = random();
		if (weapon instanceof Boomerang) {
			while (ench instanceof Piercing || ench instanceof Swing) {
				ench = Enchantment.random();
			}
		}
		return ench.proc( weapon, attacker, defender, damage );
	}
	
	@Override
	public String name( String weaponName) {
		return String.format( TXT_NAME, weaponName );
	}

}
