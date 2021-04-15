package game;

/*
 * 英雄类
 * 	属性包括：英雄名字、生命值、攻击力、防御力、掌握的技能
 *  方法包括：学习新技能的方法、攻击的方法，防御的方法
 *  	1、设置属性的私有访问权限，通过公有的 get，set 方法实现对属性的访问
 */
public class Hero {
	private String heroName; // 英雄名字
	private int vitality; // 生命力
	private int heroAggressivity; // 英雄攻击力
	private int heroDefensePower; // 英雄防御力
	private Skill masteredSkill; // 掌握的技能
	
	

	public Hero() {
		super();
	}

	public Hero(String heroName, int vitality, int heroAggressivity, int heroDefensePower, Skill masteredSkill) {
		super();
		this.heroName = heroName;
		this.vitality = vitality;
		this.heroAggressivity = heroAggressivity;
		this.heroDefensePower = heroDefensePower;
		this.masteredSkill = masteredSkill;
	}
	/**
	 * 学习新技能的方法，需要判断新技能等级是否大于已经掌握技能等级，如果不满足条件则放弃学习
	 * @param newSkill Skill 新技能的信息
	 */
	public void learnNewSkills(Skill newSkill) {
		if (newSkill.getSkillLevel() > masteredSkill.getSkillLevel()) {
			masteredSkill = newSkill;
			System.out.println(masteredSkill.getSkillName() + "技能已经掌握!");
		} else {
			System.out.println(newSkill.getSkillName() + "等级过低,不需要学习");
		}
		System.out.println("==================================================");
	}
	/**
	 * 攻击方法描述攻击状态。内容包括英雄名字，生命值、攻击力。其中攻击力=个人攻击力+技能攻击力
	 */
	public void attack() {
		System.out.println("英雄" + heroName + "展开攻击");
		System.out.println("当前生命值:" + vitality);
		System.out.println("攻击力为:" +( masteredSkill.getSkillAggressivity() + heroAggressivity));
		System.out.println("==================================================");
	}
	/**
	 * 防御方法通过输入参数接收攻击力。需要判断，如果攻击力小于防御力，伤害值=0；反之，伤害值=攻击力-防御力。
	 * 根据伤害值情况显示不同的防御信息，内容包括英雄名字，防御力，防御后的生命值。其中防御力=个人防御力+技能防御力
	 * @param aggressivity int 攻击力
	 */
	public void defense(int aggressivity) {
		//防御力
		int defensePower = heroDefensePower + masteredSkill.getSkillDefensePower();
		//伤害值
		int damageValue = 0;
		if (aggressivity >= defensePower) {
			damageValue = aggressivity - defensePower;
			vitality -= damageValue;
			if (vitality > 0) {
				System.out.println("防御失败!");
				System.out.println("英雄" + heroName + "以" + defensePower + "的防御力未能防御进攻!");
				System.out.println("当前生命值为:" + vitality);
			} else {
				System.out.println("防御失败!");
				System.out.println("英雄" + heroName + "以" + defensePower + "的防御力未能防御进攻!");
				System.out.println("英雄已死亡!!");
			}
		} else {
			System.out.println("防御成功!");
			System.out.println("英雄" + heroName + "以" + defensePower + "的防御力成功防御进攻!");
		}
		System.out.println("==================================================");
	}
}
