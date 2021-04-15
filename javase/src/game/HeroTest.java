package game;
/*
 * 某公司要开发新游戏，请用面向对象的思想设计英雄类和技能类。
 */
public class HeroTest {
	public static void main(String[] args) {
		Skill masteredSkill = new Skill("乾坤大挪移", 150, 20, 2);
		Skill newSkill = new Skill("降龙十八掌", 300, 150, 4);
		Hero hero = new Hero("郭靖", 500, 100, 50, masteredSkill);
		hero.learnNewSkills(newSkill);
		hero.attack();
		hero.defense(220);
	}
}
