package ru.asocial.pm.api.v1;

import org.openapitools.api.ProjectApi;
import org.openapitools.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import ru.asocial.pm.repo.ProjectMemberProjectRepository;
import ru.asocial.pm.repo.ProjectMemberRepository;
import ru.asocial.pm.repo.ProjectRepository;

@RestController
@RequestMapping(value = "/api/v1/project")
public class ProjectController implements ProjectApi {
    
    @Autowired
    private ProjectRepository projectRepository;
    
    @Autowired
    private ProjectMemberProjectRepository projectMemberProjectRepository;
    
    @Autowired
    private ProjectMemberRepository projectMemberRepository;

    /**
     * POST /project
     *
     * @param project  (optional)
     * @return Project Created (status code 201)
     *         or Bad request (status code 400)
     *         or Can&#39;t process request (status code 422)
     */
    @Operation(
        operationId = "createProject",
        responses = {
            @ApiResponse(responseCode = "201", description = "Project Created"),
            @ApiResponse(responseCode = "400", description = "Bad request", content = {
                @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))
            }),
            @ApiResponse(responseCode = "422", description = "Can't process request", content = {
                @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/project",
        produces = { "text/plain" },
        consumes = { "application/json" }
    )
    @Transactional
    public ResponseEntity<String> createProject(
        @Parameter(name = "Project", description = "") @Valid @RequestBody(required = false) Project project) {       
        if (project.getDueDate() == null) {
            return ResponseEntity.unprocessableEntity().body("dueDate is null");
        }
        if (project.getTitle() == null) {
            return ResponseEntity.unprocessableEntity().body("title is null");
        }        
        if ( project.getGoals() == null || project.getGoals().isEmpty() ) {
            return ResponseEntity.unprocessableEntity().body("goals is empty or null");
        }
        
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
