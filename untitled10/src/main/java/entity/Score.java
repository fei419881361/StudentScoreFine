package entity;

public class Score {
    private int id;
    private int s_id;
    private int type;
    private int score;
    private String score_name;

    public Score(){}

    public Score(int id, int s_id, int type, int score, String score_name) {
        this.id = id;
        this.s_id = s_id;
        this.type = type;
        this.score = score;
        this.score_name = score_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getScore_name() {
        return score_name;
    }

    public void setScore_name(String score_name) {
        this.score_name = score_name;
    }
}
