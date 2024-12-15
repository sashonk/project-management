package ru.asocial.pm.service;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openapitools.client.ApiClient;
import org.openapitools.client.api.DefaultApi;
import org.openapitools.client.model.Department;
import org.openapitools.client.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ru.asocial.pm.model.entity.ProjectMemberEntity;
import ru.asocial.pm.repo.ProjectMemberRepository;

@Service
public class ProjectMembersScheduledService {
    
    private static final Logger log = LoggerFactory.getLogger(ProjectMembersScheduledService.class);
    
    @Autowired
    private ProjectMemberRepository projectMemberRepository;
    
    private DefaultApi defaultApi;
    
    private Integer pageSize = 1000;
            
    public ProjectMembersScheduledService(@Value("${pm.employee.rest.url}") String employeeRestUrl) {
        ApiClient apiClient = new ApiClient(new RestTemplate());
        apiClient.setBasePath(employeeRestUrl);
        defaultApi = new DefaultApi(apiClient);        
    }

   // @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
    public void findMembers() {
        int newEmployees = 0;
        do {
            long totalEmployees = projectMemberRepository.count();
            /*
             * if (totalEmployees >= limit) { log.info("Number of project members is " +
             * totalEmployees + ". Skip request"); return; }
             */
            int pageNumber = (int) (totalEmployees / pageSize);

            List<Department> departments = defaultApi.getDepartments();
            List<String> deptCodes = departments.stream().map(Department::getId).collect(Collectors.toList());
            log.debug("Departments: " + deptCodes);
            List<Employee> employees = defaultApi.searchInDepartments(deptCodes, pageNumber, pageSize, 
                    null, null, null, null, null, null, null, null);
            newEmployees = employees.size();
            log.debug("Employees: " + employees.size());
            for (Employee employee : employees) {                
                 ProjectMemberEntity pm = new ProjectMemberEntity();
                 pm.setDepartmentName("Unknown");
                 pm.setExternalId(employee.getId());
                 pm.setFirstName(employee.getFirstName());
                 pm.setLastName(employee.getLastName());
                 projectMemberRepository.save(pm);
             }
        } while (newEmployees > 0);            
    }
    

}
