import peoplerock.Employee
import peoplerock.Competency
import peoplerock.CompetencyRate
import peoplerock.EmployeeCompetencyProfile
import peoplerock.Competency
import peoplerock.CompetencyRate
import peoplerock.EmployeeCompetencyProfile
import peoplerock.Role
import grails.util.GrailsUtil
import peoplerock.EmployeeProfile
import peoplerock.JobFamily
import peoplerock.JobPosition

class BootStrap {

    def init = { servletContext ->
        switch(GrailsUtil.environment){
        case "development":
            
            // COMPETENCY
            def comp = new Competency(
                shortDescription:"Communications",
                description:"Communicating with colleagues both remote and local"                
            )
            comp.save()
            if(comp.hasErrors()){
                println comp.errors
            }
                        
            comp = new Competency(
                shortDescription:"Leadership",
                description:"Leading by example"                
            )
            comp.save()
            if(comp.hasErrors()){
                println comp.errors
            }
            ///////////////////////////////////////////
            
            // COMPETENCY RATE
            def comprate = new CompetencyRate(
                shortDescription:"SME",
                description:"Subject Matter Expert"                
            )
            comprate.save()
            if(comprate.hasErrors()){
                println comprate.errors
            }
                        
            comprate = new CompetencyRate(
                shortDescription:"Novice",
                description:"Novice level"                
            )
            comprate.save()
            if(comprate.hasErrors()){
                println comprate.errors
            }
            //////////////////////////////////////////
                        
            // EMPLOYEE PROFILE
            def employeecompprofile = new EmployeeCompetencyProfile(
                competency:comp,
                competencyRate:comprate                
            )
            employeecompprofile.save()
            if(employeecompprofile.hasErrors()){
                println employeecompprofile.errors
            }
            //////////////////////////////////////////////////
            
            // ROLES
            def roles = new Role(
                name:"Tech Lead",
                description:"Technical Lead"
            )
            roles.save()
            if(roles.hasErrors()){
                println roles.errors
            }
            
            roles = new Role(
                name:"Project Manager",
                description:"Manages Projects"
            )
            roles.save()
            if(roles.hasErrors()){
                println roles.errors
            }
            
            roles = new Role(
                name:"Developer",
                description:"Software Developer"
            )
            roles.save()
            if(roles.hasErrors()){
                println roles.errors
            }
            //////////////////////////////////////////////
            
            // JOB FAMILY
            def jobfam = new JobFamily(
                jobFamilyName:"Business Analysis",
                description:"All business analysis roles"
            )
            jobfam.save()
            if(jobfam.hasErrors()){
                println jobfam.errors
            }
            
            jobfam = new JobFamily(
                jobFamilyName:"Development",
                description:"All development roles"
            )
            jobfam.save()
            if(jobfam.hasErrors()){
                println jobfam.errors
            }
            
            //////////////////////////////////////////////
            
            
            // JOB POSITION
            def jobpos = new JobPosition(
                jobFamily:jobFam,
                role:roles
            )
            jobpos.save()
            if(jobpos.hasErrors()){
                println jobpos.errors
            }
            //////////////////////////////////////////////
            
            
            // EMPLOYEE
            def emp = new Employee(
                firstName:"Tom",
                lastName:"Jones",
                costCentre:"23423423",
                hireDate:new Date(),
                employmentStatus:"Full"
            )
            emp.save()
            if(emp.hasErrors()){
                println emp.errors
            }
            //////////////////////////////////////////////
            
            
            // EMPLOYEE PROFILE
            def emprof = new EmployeeProfile(
                employee:emp,
                jobPosition:jobpos,
                startDate:new Date(),
                endDate:(new Date() + 90),
                competencyProfile:employeecompprofile,
                careerTrack:"Management",
                ladderRung:5
            )
            emprof.save()
            if(emprof.hasErrors()){
                println emprof.errors
            }
            //////////////////////////////////
            
            
            
            
            break
            
            
        
        }
        def destroy = {
        }
    }
}