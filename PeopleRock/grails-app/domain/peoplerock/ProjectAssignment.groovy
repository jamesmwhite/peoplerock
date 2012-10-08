package peoplerock

class ProjectAssignment {
    
    Project project
    Employee employee
    Date startDate
    Date endDate
    Date endByDate
    int allocated
    int demand
    boolean coreTeamMember

    static constraints = {
        project(nullable:false,blank:false)
        employee(nullable:false,blank:false)
        startDate(nullable:false,blank:false)
        endDate(nullable:false,blank:false)
        endByDate(nullable:false,blank:false)
        allocated(nullable:false,blank:false)
        demand(nullable:false,blank:false)
        coreTeamMember(nullable:false,blank:false)
    }
    
    String toString(){
        return "${project} - ${employee}"
    }
}
