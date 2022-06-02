package global.dao;

public class Lecture {
    private String lectureId;
    private String lectureName;
    private String lecturePdfName;
    private String lecturerId;

    public Lecture() {
    }

    public Lecture(String lectureId, String lectureName, String lecturePdfName, String lecturerId) {
        this.lectureId = lectureId;
        this.lectureName = lectureName;
        this.lecturePdfName = lecturePdfName;
        this.lecturerId = lecturerId;
    }

    public void setLectureId(String lectureId) {
        this.lectureId = lectureId;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public void setLecturePdfName(String lecturePdfName) {
        this.lecturePdfName = lecturePdfName;
    }



    public String getLectureId() {
        return lectureId;
    }

    public String getLectureName() {
        return lectureName;
    }

    public String getLecturePdfName() {
        return lecturePdfName;
    }

    public String getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(String lecturerId) {
        this.lecturerId = lecturerId;
    }

    @Override
    public String toString() {
        return "강의 ID:" + lectureId + "/ 강의 이름:" + lectureName +"/ 강의 자료 PDF:" + lecturePdfName +"/ 강의 직원 ID:"+lecturerId;
    }
}
