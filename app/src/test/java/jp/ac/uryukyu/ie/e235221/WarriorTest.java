package jp.ac.uryukyu.ie.e235221;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WarriorTest {
	@Test
	void testAttackWithWeponSkill() {
		Warrior warrior = new Warrior("勇者", 100, 10);
		Enemy enemy = new Enemy("スライム", 100, 10);

		// 3回攻撃してダメージを確認
		for (int i = 0; i < 3; i++) {
			int enemyHpBeforeAttack = enemy.getHitPoint();
			warrior.attackWithWeponSkill(enemy); // WeaponSkillで攻撃
			int expectedDamage = (int) (warrior.getAttack() * 1.5); // 期待されるダメージ
			assertEquals(enemyHpBeforeAttack - expectedDamage, enemy.getHitPoint(), "ダメージが期待通りでない");
		}
	}
}
