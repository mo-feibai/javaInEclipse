package game;

/*
 * 技能类
 * 	属性包括：技能名称、攻击力、防御力、技能等级
 */
public class Skill {
	private String skillName; // 技能名称
	private int skillAggressivity; // 技能攻击力
	private int skillDefensePower; // 技能防御力
	private int skillLevel; // 技能等级

	public Skill() {
		super();
	}

	public Skill(String skillName, int skillAggressivity, int skillDefensePower, int skillLevel) {
		super();
		this.skillName = skillName;
		this.skillAggressivity = skillAggressivity;
		this.skillDefensePower = skillDefensePower;
		this.skillLevel = skillLevel;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public int getSkillAggressivity() {
		return skillAggressivity;
	}

	public void setSkillAggressivity(int skillAggressivity) {
		this.skillAggressivity = skillAggressivity;
	}

	public int getSkillDefensePower() {
		return skillDefensePower;
	}

	public void setSkillDefensePower(int skillDefensePower) {
		this.skillDefensePower = skillDefensePower;
	}

	public int getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(int skillLevel) {
		this.skillLevel = skillLevel;
	}

}