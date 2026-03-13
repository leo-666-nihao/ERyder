package ERyder;

public class Feedback {
    private String firstName;
    private String lastName;
    private String email;
    private String completeFeedback;
    private String reviewID;
    private boolean longFeedback;

    public Feedback(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public void analyseFeedback(boolean isContenation, String sent1, String sent2, String sent3, String sent4, String sent5) {
        if (isContenation) {
            completeFeedback = feedbackUsingConcatenation(sent1, sent2, sent3, sent4, sent5);
        } else {
            completeFeedback = feedbackUsingConcatenation(sent1, sent2, sent3, sent4, sent5);
        }
        checkFeedbackLength(this.completeFeedback);
        createReviewID(this.firstName, this.lastName, this.completeFeedback);
    }

    private String feedbackUsingConcatenation(String s1, String s2, String s3, String s4, String s5) {
        return s1 + s2 + s3 + s4 + s5;
    }

    private boolean checkFeedbackLength(String feedback) {
        this.longFeedback = feedback != null && feedback.length() > 500;
        return this.longFeedback;
    }

    private void createReviewID(String firstName, String lastName, String completeFeedback) {
        if (firstName == null || lastName == null || completeFeedback == null) {
            this.reviewID = "INVALID_ID";
        } else {
            this.reviewID = firstName.charAt(0) + lastName + System.currentTimeMillis();
        }
    }

    public String toString() {
        return "Feedback{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", completeFeedback='" + completeFeedback + '\'' +
                ", longFeedback=" + longFeedback +
                ", reviewID='" + reviewID + '\'' +
                '}';
    }

    public static void main(String[] args) {
        String s1 = "I was very satisfied with the service.";
        String s2 = "The e-Bike is quite comfortable to ride.";
        String s3 = "The battery life of the e-Bike is impressive.";
        String s4 = "The customer support was helpful and responsive.";
        String s5 = "I would recommend this e-Bike to my friends and family.";
        Feedback userFeedback = new Feedback("John", "Doe", "john.doe@example.com");
        userFeedback.analyseFeedback(true, s1, s2, s3, s4, s5);
        System.out.println(userFeedback.toString());
    }
}