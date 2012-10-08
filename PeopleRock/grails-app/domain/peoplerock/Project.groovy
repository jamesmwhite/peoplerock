package peoplerock

class Project {

    String projectName
    Date startDate
    Date finishDate
    Date endByDate
    Employee owner
    Platform platform
   
    
    static constraints = {
        projectName(blank:false,nullable:false)
        platform(blank:false,nullable:false)
        owner(blank:false,nullable:false)
        startDate(blank:false,nullable:false)
        endByDate(blank:false,nullable:false)
        finishDate(blank:true,nullable:false)
        
    }
    
    String toString(){
        return "${projectName} - ${platform}"
    }
}
