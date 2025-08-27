import { UserDTO } from "../user-dto.model";

export interface AttendanceResponse {
  classroomId: number;
  student: UserDTO;
  present: boolean;
  joinTime: string;
}