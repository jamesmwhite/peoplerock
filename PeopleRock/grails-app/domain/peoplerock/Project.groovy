package peoplerock

class Project {

    String name
    Date startDate
    Date finishDate
    
    Employee pm
    
    static constraints = {
        name(blank:false,nullable:false)
        pm()
        startDate()
        finishDate()
    }
}
