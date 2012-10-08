package peoplerock

class Training {
    
    String courseName
    Date startDate
    Date finishDate    
    

    static constraints = {
        courseName(nullable:false,blank:false)
        startDate()
        finishDate()
        
    }
    
    String toString(){
        return "${courseName} - ${startDate}"
    }
}
