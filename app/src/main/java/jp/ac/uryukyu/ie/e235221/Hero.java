public class Hero {
	private String name;
	private int hitPoint;
	private int attack;

	public Hero(String name, int hitPoint, int attack) {
		this.name = name;
		this.hitPoint = hitPoint;
		this.attack = attack;
	}

	public int getHitPoint() {
		return hitPoint;
	}

	public void attack(Enemy enemy) {
		if (!enemy.isDead()) { // 敵が死んでいない場合のみ攻撃
			enemy.takeDamage(this.attack);
		}
	}

	public void takeDamage(int damage) {
		this.hitPoint -= damage;
	}
}
