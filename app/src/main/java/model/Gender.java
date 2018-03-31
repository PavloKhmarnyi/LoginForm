package model;

/**
 * Created by Illya Havrulyk on 2/22/2018.
 */

public enum Gender {
    MALE(0),
    FEMALE(1);

    private int code;

    Gender(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
