package com.examination.project.utils.misc;

public enum QuestionBoolean {

    NO_VALUE, TRUE, FALSE;


    public QuestionBoolean toQuestionBoolean(Boolean bool) {

        if (bool == null) {
            return NO_VALUE;
        } else if (bool) {
            return TRUE;
        } else if (!bool) {
            return FALSE;
        }
        return NO_VALUE;
    }


    public Boolean toBoolean(QuestionBoolean questionBoolean) {

        if (questionBoolean.equals(NO_VALUE)) {
            return null;
        } else if (questionBoolean.equals(TRUE)) {
            return true;
        } else if (questionBoolean.equals(FALSE)) {
            return false;
        }

        return false;
    }


}
