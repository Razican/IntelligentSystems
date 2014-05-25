package es.deusto.ingenieria.is.kbs.insurance;

public class Policy {

	public static enum Name {
		THIRD_PARTY_DAMAGE, 
		HOME_ESSENTIALS, 
		MULTIRISK, 
		SILVER, 
		GOLD, 
		PLATINUM
	}

	private Name name;
	private int contentCoverage;
	private int buildingCoverage;
	private int thirdPartyCoverage;
	private boolean homeAssistance;
	private boolean legalAssistance;

	public Policy() {		
	}
	
	public Policy(Name name) {
		this.name = name;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public int getContentCoverage() {
		return contentCoverage;
	}

	public void setContentCoverage(int contentCoverage) {
		this.contentCoverage = contentCoverage;
	}

	public int getBuildingCoverage() {
		return buildingCoverage;
	}

	public void setBuildingCoverage(int buildingCoverage) {
		this.buildingCoverage = buildingCoverage;
	}

	public int getThirdPartyCoverage() {
		return thirdPartyCoverage;
	}

	public void setThirdPartyCoverage(int thirdPartyCoverage) {
		this.thirdPartyCoverage = thirdPartyCoverage;
	}

	public boolean isHomeAssistance() {
		return homeAssistance;
	}

	public void setHomeAssistance(boolean homeAssistance) {
		this.homeAssistance = homeAssistance;
	}

	public boolean isLegalAssistance() {
		return legalAssistance;
	}

	public void setLegalAssistance(boolean legalAssistance) {
		this.legalAssistance = legalAssistance;
	}
	
	public String toString() {
		return name.toString();
	}
}