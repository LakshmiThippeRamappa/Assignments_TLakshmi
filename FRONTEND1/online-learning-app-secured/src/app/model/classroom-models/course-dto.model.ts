import { UserDTO } from "../user-dto.model";

export interface CourseDTO {
  id: number;
  title: string;
  description: string;
  teacher: UserDTO;
  enrolledStudents: UserDTO[];
}