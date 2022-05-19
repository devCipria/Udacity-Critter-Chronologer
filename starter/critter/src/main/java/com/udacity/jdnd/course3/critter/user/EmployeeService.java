package com.udacity.jdnd.course3.critter.user;

import com.udacity.jdnd.course3.critter.schedule.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee findEmployee(Long employeeId) {
        return employeeRepository.findById(employeeId).get();
    }

    public List<Schedule> findScheduleListByEmployeeId(long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();
        return employee.getScheduleList();
    }

    public List<Employee> findAvailableEmployees(Set<EmployeeSkill> skills, DayOfWeek dayOfWeek) {
        List<Employee> employeeList = employeeRepository.findAll();
        List<Employee> dayAvailableEmployeeList = new ArrayList<>();
        List<Employee> employeeListWithMatchingSkills = new ArrayList<>();

        // Get a list of employees who are available on the requested day
        for (Employee employee : employeeList) {
            if (employee.getDaysAvailable().contains(dayOfWeek)) {
                dayAvailableEmployeeList.add(employee);
            }
        }

        // From the list of employees who are available on the requested day, get the ones with matching skills
        for (Employee employee : dayAvailableEmployeeList) {
            if (employee.getSkills().containsAll(skills)) {
                employeeListWithMatchingSkills.add(employee);
            }
        }

        return employeeListWithMatchingSkills;
    }

}
