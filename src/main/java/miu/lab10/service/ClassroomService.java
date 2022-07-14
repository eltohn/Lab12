package miu.lab10.service;

import miu.lab10.model.Classroom;

public interface ClassroomService {
    Classroom save(Classroom cr);
    Classroom getClassroomById(int id);
}
