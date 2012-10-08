package peoplerock

class EmployeeCompetencyProfile {
        
    Competency competency
    CompetencyRate competencyRate
    
    static constraints = {
        competency(nullable:false,blank:false)
        competencyRate(nullable:false,blank:false)
    }
    
    String toString(){
        return "${competency.description} ${competencyRate.shortDescription}"
    }
}
