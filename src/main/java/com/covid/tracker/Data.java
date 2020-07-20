package com.covid.tracker;

public class Data {
	
	private String id;
    private String country;
    private String totalCases;
    private String newCases;
    private String totalDeaths;
    private String newDeaths;
    private String totalRecovered;
    private String activeCases;
    private String seriousCases;
    private String totalCasesPerMillionPop;
    private String totalDeathsPerMillionPop;
	private String totalTests;
    private String testsPerMillion;
    private String pop;
    
    public String getTotalTests() {
		return totalTests;
	}
    
    

	public void setTotalTests(String totalTests) {
		this.totalTests = totalTests;
	}
	
    public String getTestsPerMillion() {
		return testsPerMillion;
	}

	public void setTestsPerMillion(String testsPerMillion) {
		this.testsPerMillion = testsPerMillion;
	}

	public String getPop() {
		return pop;
	}

	public void setPop(String pop) {
		this.pop = pop;
	}

    
    public String getId() {
        return id;
    }

    public void setId(String string) {
        this.id = string;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(String totalCases) {
        this.totalCases = totalCases;
    }

    public String getNewCases() {
        return newCases;
    }

    public void setNewCases(String newCases) {
        this.newCases = newCases;
    }

    public String getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(String totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public String getNewDeaths() {
        return newDeaths;
    }

    public void setNewDeaths(String newDeaths) {
        this.newDeaths = newDeaths;
    }

    public String getTotalRecovered() {
        return totalRecovered;
    }

    public void setTotalRecovered(String totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

    public String getActiveCases() {
        return activeCases;
    }

    public void setActiveCases(String activeCases) {
        this.activeCases = activeCases;
    }

    public String getSeriousCases() {
        return seriousCases;
    }

    public void setSeriousCases(String seriousCases) {
        this.seriousCases = seriousCases;
    }

    public String getTotalCasesPerMillionPop() {
        return totalCasesPerMillionPop;
    }

    public void setTotalCasesPerMillionPop(String totalCasesPerMillionPop) {
        this.totalCasesPerMillionPop = totalCasesPerMillionPop;
    }

    public String getTotalDeathsPerMillionPop() {
        return totalDeathsPerMillionPop;
    }

    public void setTotalDeathsPerMillionPop(String totalDeathsPerMillionPop) {
        this.totalDeathsPerMillionPop = totalDeathsPerMillionPop;
    }


    @Override
    public String toString() {
        return 	"Id= " + id +
                "\nCountry= " + country  +
                "\nTotal Cases= " + totalCases  +
                "\nNew Cases= " + newCases  +
                "\nTotal deaths= " + totalDeaths +
                "\nNew deaths= " + newDeaths  +
                "\nTotal recovered= " + totalRecovered + 
                "\nActive cases= " + activeCases + 
                "\nSerious cases= " + seriousCases +
                "\nTotal cases per million population= " + totalCasesPerMillionPop +
                "\nTotal deaths per million population= " + totalDeathsPerMillionPop + 
                "\nTotal tests= " + totalTests  +
                "\nTests per million= " + testsPerMillion  +
                "\nPopulation= " + pop ;
    }
}