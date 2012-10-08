package peoplerock

class EmployeeHolidays {
    
    Employee employee
    int year
    int allocated
    int remaining
    int inLieu

    static constraints = {
        year(nullable:false,blank:false)
        allocated(nullable:false,blank:false)
        remaining(nullable:false,blank:false)
        inLieu(nullable:false,blank:false)
    }
    
    String toString(){
        return "${employee} ${year}"
    }
}
