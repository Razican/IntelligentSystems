package es.deusto.ingenieria.is.kbs.insurance;

import java.util.ArrayList;
import java.util.List;

public class Home {

	public static enum Type {
		APARTMENT, 
		HOUSE
	}

	public static enum ConstructionQuality {
		AVERAGE, 
		EXCELLENT
	}

	public static enum AgeRange {
		OLD, 
		SEMI_NEW, 
		NEW
	}

	public static enum BudgetRange {
		LOW, 
		MEDIUM, 
		HIGH
	}

	//The use of this enumeration is optional
	public static enum Check {

	}

	private String owner;
	private String address;
	private Policy policy;
	private Type type;
	private ConstructionQuality quality;
	private int age;
	private AgeRange ageRange;
	private double budget;
	private BudgetRange budgetRange;
	private boolean improvements;
	private boolean expensiveBelongins;

	private Check check;
	private List<String> milestones;
	
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public ConstructionQuality getQuality() {
		return quality;
	}

	public void setQuality(ConstructionQuality quality) {
		this.quality = quality;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public AgeRange getAgeRange() {
		return ageRange;
	}

	public void setAgeRange(AgeRange ageRange) {
		this.ageRange = ageRange;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public BudgetRange getBudgetRange() {
		return budgetRange;
	}

	public void setBudgetRange(BudgetRange budgetRange) {
		this.budgetRange = budgetRange;
	}

	public boolean isImprovements() {
		return improvements;
	}

	public void setImprovements(boolean improvements) {
		this.improvements = improvements;
	}

	public boolean isExpensiveBelongins() {
		return expensiveBelongins;
	}

	public void setExpensiveBelongins(boolean expensiveBelongins) {
		this.expensiveBelongins = expensiveBelongins;
	}

	public Check getCheck() {
		return check;
	}

	public void setCheck(Check check) {
		this.check = check;
	}

	public void addMilestone(String milestone) {
		if (milestones == null) {
			milestones = new ArrayList<String>();
		}
		
		if (!milestones.contains(milestone)) {
			milestones.add(milestone);
		}
	}
	
	public List<String> getMilestones() {
		return milestones;
	}

	public String toString() {
		String result = "- Home Information:";
		result += "\n   * Address: " + address;
		result += "\n   * Owner: " + owner;
		
		if (type != null) {
			result += "\n   * Type: " + type.toString();
		}
		
		if (quality != null) {
			result += "\n   * Construction quality: " + quality.toString();
		}
		
		if (ageRange == null) { 
			result += "\n   * Age: " + age;
		} else {
			result += "\n   * Age range: " + ageRange;
		}
			
		if (improvements) {
			result += "\n   * Improvements made";	
		}
			
		if (expensiveBelongins) {				
			result += "\n   * Has expensive belongins";
		}
			
		if (budgetRange == null) {
			result += "\n   * Budget: " + budget;
		} else {
			result += "\n   * Budget Range: " + budgetRange.toString();
		}
		
		if (policy != null) {
			result += "\n   * POLICY: " + policy.getName();
		}
		
		if (milestones != null && !milestones.isEmpty()) {
			result += "\n   * SECURITY NET (milestones): ";
			
			for (String milestone : milestones) {
				result += "\n      - " + milestone;
			}			
		}
		
		return result;		
	}
}