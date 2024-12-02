package jp.ac.uryukyu.ie.e235221;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnemyTest {
	@Test
	void attackTest() {
		int defaultHeroHp = 100;
		Hero demoHero = new Hero("デモ勇者", defaultHeroHp, 100);
		Enemy slime = new Enemy("スライムもどき", 10, 100);

		// 10回攻撃し、スライムを倒す
		for (int count = 0; count < 10; count++) {
			demoHero.attack(slime); // Heroの攻撃
		}

		// スライムは死んでいるはず
		assertTrue(slime.isDead(), "スライムは死んでいるはず");

		// スライムが死んだ後、攻撃してもHPが変わらないことを確認
		slime.attack(demoHero);
		assertEquals(defaultHeroHp, demoHero.getHitPoint(), "死んだスライムは攻撃できないはず");
	}

	@Test
	public void testAttackAfterDeath() {
		Hero hero = new Hero("勇者", 10, 5);
		Enemy enemy = new Enemy("スライム", 6, 3);

		// スライムが攻撃
		enemy.attack(hero);
		assertEquals(2, hero.getHitPoint(), "最初の攻撃後、HPは減少するはず");

		// さらに攻撃
		enemy.attack(hero);
		assertEquals(0, hero.getHitPoint(), "2回目の攻撃後、HPはさらに減少するはず");

		// ここでスライムは倒れているはず
		enemy.attack(hero);
		assertTrue(enemy.isDead(), "スライムは死んでいるはず");

		// 死んだ後に攻撃してもHeroのHPが変わらないことを確認
		enemy.attack(hero);
		assertEquals(0, hero.getHitPoint(), "死んだスライムは攻撃できないはず");
	}
}
