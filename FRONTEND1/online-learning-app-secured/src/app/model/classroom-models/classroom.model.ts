export interface Classroom {
  id?: number;                // optional for new classroom
  courseId: number;
  sessionDateTime: string;    // ISO datetime string
  sessionLink: string;
}
