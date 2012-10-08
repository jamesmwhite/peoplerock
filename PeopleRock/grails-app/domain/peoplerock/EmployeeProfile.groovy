package peoplerock

class EmployeeProfile {

    Employee employee
    JobPosition jobPosition
    Date startDate
    Date endDate
    EmployeeCompetencyProfile competencyProfile
    String careerTrack
    int ladderRung           
    
    static constraints = {
        employee(nullable:false,blank:false)
        jobPosition(nullable:false,blank:false)
        startDate(nullable:false,blank:false)
        endDate(nullable:false,blank:true)
        competencyProfile(nullable:false,blank:false)
        careerTrack(nullable:false,blank:true)
        ladderRung(nullable:false,blank:true)
    }
    
    String toString(){
        return "${employee.firstName} ${employee.lastName} - ${jobPosition}"
    }
}
