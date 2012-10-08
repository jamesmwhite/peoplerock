package peoplerock

class EmployeeAbsences {
    
    Employee employee
    AbsenceType absence
    Date fromDate
    Date toDate

    static constraints = {
        employee(nullable:false,blank:false)
        absence(nullable:false,blank:false)
        fromDate(nullable:false,blank:false)
        toDate(nullable:false,blank:false)
    }
}
