import { UserDTO } from "../user-dto.model";
import { CourseDTO } from "./course-dto.model";

export interface ClassroomResponse {
  id: number;
  course: CourseDTO;
  sessionDateTime: string;
  sessionLink: string;
  presentStudents: UserDTO[];
}