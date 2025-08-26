
import { UserDTO } from "./user-dto.model";

export interface CourseResponse {
  id?: number;
  title: string;
  description?: string;
  teacher: UserDTO;
  enrolledStudents: UserDTO[];
}
