package com.htec.microservicecourses.controllers;

import com.htec.commonsmicroservices.commons.controllers.CommonController;
import com.htec.commonsstudents.models.entity.Student;
import com.htec.microservicecourses.models.entity.Course;
import com.htec.microservicecourses.services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController extends CommonController<Course, CourseService> {


//    @Value("${config.balanceador.test}")
//    private String balanceadorTest;
//
//    @DeleteMapping("/eliminar-alumno/{id}")
//    public ResponseEntity<?> eliminarCursoAlumnoPorId(@PathVariable Long id) {
//        service.eliminarCursoAlumnoPorId(id);
//        return ResponseEntity.noContent().build();
//    }
//
//
//    @GetMapping
//    @Override
//    public ResponseEntity<?> listar(){
//        List<Curso> cursos = ((List<Curso>) service.findAll()).stream().map(c -> {
//            c.getCursoAlumnos().forEach(ca -> {
//                Alumno alumno = new Alumno();
//                alumno.setId(ca.getAlumnoId());
//                c.addAlumno(alumno);
//            });
//            return c;
//        }).collect(Collectors.toList());
//        return ResponseEntity.ok().body(cursos);
//    }
//
//    @GetMapping("/pagina")
//    @Override
//    public ResponseEntity<?> listar(Pageable pageable){
//        Page<Curso> cursos = service.findAll(pageable).map(curso -> {
//            curso.getCursoAlumnos().forEach(ca -> {
//                Alumno alumno = new Alumno();
//                alumno.setId(ca.getAlumnoId());
//                curso.addAlumno(alumno);
//            });
//            return curso;
//        });
//        return ResponseEntity.ok().body(cursos);
//    }
//
//    @GetMapping("/{id}")
//    @Override
//    public ResponseEntity<?> ver(@PathVariable Long id){
//        Optional<Curso> o = service.findById(id);
//        if(o.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }
//        Curso curso = o.get();
//        if( curso.getCursoAlumnos().isEmpty() == false) {
//            List<Long> ids = curso.getCursoAlumnos().stream().map(ca -> ca.getAlumnoId()).collect(Collectors.toList());
//            List<Alumno> alumnos = (List<Alumno>) service.obtenerAlumnosPorCurso(ids);
//            curso.setAlumnos(alumnos);
//        }
//        return ResponseEntity.ok().body(curso);
//    }
//
//    @GetMapping("/balanceador-test")
//    public ResponseEntity<?> balanceadorTest() {
//        Map<String, Object> response = new HashMap<String, Object>();
//        response.put("balanceador", balanceadorTest);
//        response.put("cursos", service.findAll());
//        return ResponseEntity.ok(response);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editCourse(@RequestBody Course course, @PathVariable Long id) {
        Optional<Course > o = this.service.findById(id);
        if (o.isEmpty()){
            ResponseEntity.notFound().build();
        }

        Course courseDb = o.get();
        courseDb.setName(course.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.saveCourse(courseDb));
    }

    @PutMapping("/{id}/asignar-alumnos")
    public ResponseEntity<?> assignStudents(@RequestBody List<Student> students, @PathVariable Long id){
        Optional<Course> o = this.service.findById(id);
        if (!o.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Course dbCourse = o.get();
        students.forEach(a -> {
            dbCourse.addStudent(a);
//            CourseStudent courseStudent = new CourseStudent();
//            courseStudent.setStudentId(a.getId());
//            courseStudent.setCourse(dbCourse);
//            dbCourse.addCourseStudent(courseStudent);
        });
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCourse));
    }

    @PutMapping("/{id}/eliminar-alumno")
    public ResponseEntity<?> eliminarAlumno(@RequestBody Student student , @PathVariable Long id){
        Optional<Course> o = this.service.findById(id);
        if (!o.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Course dbCourse = o.get();
        dbCourse.removeStudent(student);
//        CourseStudent cursoStudent = new CourseStudent();
//        cursoStudent.setStudentId(alumno.getId());
//        dbCourse.removeCourseStudent(cursoStudent);

        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCourse));
    }
//
//    @GetMapping("/alumno/{id}")
//    public ResponseEntity<?> buscarPorAlumnoId(@PathVariable Long id){
//        Curso curso = service.findCursoByAlumnoId(id);
//
//        if ( curso != null) {
//            List<Long> examenesIds = (List<Long>) service.obtenerExamenesIdsConrespuestasAlumno(id);
//            if (examenesIds != null && examenesIds.size() > 0) {
//                List<Examen> examenes = curso.getExamenes().stream().map(examen -> {
//                    if (examenesIds.contains(examen.getId())) {
//                        examen.setRespondido(true);
//                    }
//                    return examen;
//                }).collect(Collectors.toList());
//                curso.setExamenes(examenes);
//            }
//        }
//        return ResponseEntity.ok(curso);
//    }
//
//    @PutMapping("/{id}/asignar-examenes")
//    public ResponseEntity<?> asignarExamenes(@RequestBody List<Examen> examenes, @PathVariable Long id){
//        Optional<Curso> o = this.service.findById(id);
//        if (!o.isPresent()) {
//            return ResponseEntity.notFound().build();
//        }
//        Curso dbCurso = o.get();
//        examenes.forEach(e -> {
//            dbCurso.addExamen(e);
//        });
//        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCurso));
//    }
//
//    @PutMapping("/{id}/eliminar-examen")
//    public ResponseEntity<?> eliminarExamen(@RequestBody Examen examen, @PathVariable Long id){
//        Optional<Curso> o = this.service.findById(id);
//        if (!o.isPresent()) {
//            return ResponseEntity.notFound().build();
//        }
//        Curso dbCurso = o.get();
//        dbCurso.removeExamen(examen);
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCurso));
//    }
}
