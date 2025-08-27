export interface Attendance {
  classroomId: number;
  studentId: number;
  present: boolean;
  joinTime: string;   // ISO datetime string
}